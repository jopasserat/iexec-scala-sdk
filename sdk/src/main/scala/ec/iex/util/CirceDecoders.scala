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

package ec.iex.util

object CirceDecoders {

  import io.circe.Decoder
  import io.circe.generic.extras.Configuration

  import com.micronautics.web3j.Address

  import ec.iex.core.Market.BlockTimestamp

  implicit val customConfig: Configuration =
    Configuration.default.withDefaults.withDiscriminator("type")

  import java.time.LocalDateTime
  import java.time.format.DateTimeFormatter

  val blockDateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")

  implicit val decodeDate: Decoder[BlockTimestamp] = Decoder.decodeString.emap { str ⇒
    try Right(LocalDateTime.parse(str, blockDateFormatter))
    catch {
      case e: Exception ⇒ Left("Date")
    }
  }

  implicit val decodeAddress: Decoder[Address] = Decoder.decodeString.emap { str ⇒
    try Right(Address(str))
    catch {
      case e: Exception ⇒ Left(s"wrong Address: $str")
    }
  }

  implicit val decodeBigInt: Decoder[BigInt] = Decoder.decodeString.emap { str ⇒
    try Right(BigInt(str))
    catch {
      case e: Exception ⇒ Left(s"error parsing BigInt: $str")
    }
  }
}
