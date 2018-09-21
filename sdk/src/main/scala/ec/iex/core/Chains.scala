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

import cats.Monoid

case class ChainConfig(
  host: String,
  id: Int,
  hub: Option[String] = None,
  scheduler: String)

object ChainConfig {

  implicit val chainConfigMonoid: Monoid[ChainConfig] = new Monoid[ChainConfig] {
    override def empty: ChainConfig = ChainConfig("", -1, None, "")

    /** Biased on x cause: why not? */
    override def combine(x: ChainConfig, y: ChainConfig): ChainConfig = x
  }
}

object Chain {

  type ChainMap = Map[String, ChainConfig]
  type Chains = Map[String, ChainMap]

  import java.io.File
  import io.circe.jawn.decodeFile
  import io.circe.generic.auto._
  import cats.implicits._

  import ChainConfig._

  implicit def string2File(s: String): File = new File(s)

  def loadChain(chainsConfigFile: String, chainName: String): Option[ChainConfig] =
    loadChains(chainsConfigFile).get(chainName)

  // FIXME shall I log a potential error somewhere?
  def loadChains(chainsConfigFile: String): ChainMap =
    decodeFile[Chains](chainsConfigFile).map(_.values).map(v ⇒
      Monoid[ChainMap].combineAll(v)).getOrElse(Map.empty[String, ChainConfig])

}
