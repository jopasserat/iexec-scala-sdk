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

package ec.iex.core

import java.io.File

import com.micronautics.web3j.{ Address, Signature }
import com.softwaremill.sttp.HttpURLConnectionBackend
import ec.iex.io.Network
import io.circe.Json
import net.consensys.tools.ethereum.eip712.{ TypedData, TypedDataSignature }
import org.web3j.crypto.Credentials

object Authentication {
  lazy val AUTH_URL = "https://auth.iex.ec"

  // FIXME should we have a single unified connection backend for all HTTP connections?
  implicit val backend = HttpURLConnectionBackend()

  case class STypedData(name: String, `type`: String, value: String)
  case class AuthenticationResponse(ok: Boolean, message: List[STypedData])
  case class JWTResponse(ok: Boolean, jwtoken: String)

  def sTypedData2TypedData(t: STypedData): TypedData = new TypedData(t.name, t.`type`, t.value)
  // FIXME might not be the most generic way to decode the Object, but Any doesn't help serialize to JSON...
  def typedData2STypedData(t: TypedData): STypedData = STypedData(t.getName(), t.getType(), t.getValue().toString)

  def getTypedMessage() = {

    import com.softwaremill.sttp._
    import com.softwaremill.sttp.circe._
    import io.circe.generic.auto._

    val request = sttp.get(uri"$AUTH_URL/typedmessage")

    Network.withHTTPSession(request) { response: AuthenticationResponse ⇒
      val sTypedData = response.message
      sTypedData.map(sTypedData2TypedData)
    }
  }

  def getJWTBySignature(messageJSON: Json, address: Address, signature: Signature) = {
    import com.softwaremill.sttp._
    import io.circe.generic.auto._

    val request = sttp.get(uri"$AUTH_URL/typedauth?message=${messageJSON.noSpaces}&address=${address.value}&signature=${signature.value}")

    Network.withHTTPSession(request) { response: JWTResponse ⇒
      response.jwtoken
    }
  }
}
