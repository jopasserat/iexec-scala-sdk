/**
 * Copyright (C) 2018 Jonathan Passerat-Palmbach
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package ec.iex.io

object Network {

  import cats.Monad
  import com.softwaremill.sttp.{ Request, SttpBackend }
  import com.softwaremill.sttp.circe.asJson
  import io.circe.Decoder

  /**
   * Apply given function on the results of an HTTP query.
   * Various sttp backends can be picked.
   * @param q HTTP query to submit to backend
   * @param f Function processing body of the message's response
   * @param backend Takes care of managing connections, sending requests and receiving responses
   * @tparam R Response wrapper
   * @tparam T Request body type
   * @tparam S Stream type
   * @return An R[_] Monad instance containing an Either with B as a result
   */
  def withHTTPSession[R[_]: Monad, T, S, A, B](q: Request[T, S])(f: A ⇒ B)(implicit backend: SttpBackend[R, S], decoder: Decoder[A]) = {
    import cats.implicits._

    val responseM = q.response(asJson[A]).send()

    val res = for {
      response ← responseM
    } yield for {
      eitherR ← response.body
      authenticationResponse ← eitherR
    } yield f(authenticationResponse)

    // TODO handle connection lifetime properly https://sttp.readthedocs.io/en/latest/backends/start_stop.html
    backend.close()
    res
  }

}
