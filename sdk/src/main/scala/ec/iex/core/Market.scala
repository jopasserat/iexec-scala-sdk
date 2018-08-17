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

object Market {

  import java.time.LocalDateTime

  import com.micronautics.web3j.Address

  import scala.concurrent.Future

  type BlockTimestamp = LocalDateTime

  /**
   *
   * @param _id
   * @param transactionHash
   * @param direction
   * @param category runtime selection
   * @param trust for PoCo
   * @param value value/cost/price
   * @param volume quantity of instances (total)
   * @param remaining remaining instances
   * @param workerpool BID can use null for any
   * @param workerpoolOwner fix ownership if workerpool ownership change during the workorder steps
   * @param marketorderIdx
   * @param status
   * @param chainID
   * @param blockNumber
   * @param blockTimestamp
   */
  case class MarketOrder(
    _id: String,
    transactionHash: String,
    direction: BigInt,
    category: BigInt,
    trust: BigInt,
    value: BigInt,
    volume: Int,
    remaining: Int,
    workerpool: Address,
    workerpoolOwner: Address,
    marketorderIdx: BigInt,
    status: String,
    chainID: Int,
    blockNumber: Int,
    blockTimestamp: BlockTimestamp)

  def getMarketOrders(category: Int = 5) = {

    import ec.iex.util.CirceDecoders._
    import com.softwaremill.sttp._
    import com.softwaremill.sttp.akkahttp._
    import com.softwaremill.sttp.circe._
    import io.circe.generic.auto._

    import scala.concurrent.ExecutionContext.Implicits.global

    case class OrderbookResponse(ok: Boolean, orders: List[MarketOrder])

    val request = sttp
      .get(uri"https://gateway.iex.ec/orderbook?category=$category")

    implicit val backend = HttpURLConnectionBackend()
    val response = request.response(asJson[OrderbookResponse]).send()

    val res = for {
      // TODO add an extra flatMap when switching form Id to another container
      eitherR ← response.body
      orderBookResponse ← eitherR
    } yield orderBookResponse.orders

    // TODO handle connection lifetime properly https://sttp.readthedocs.io/en/latest/backends/start_stop.html
    backend.close()

    res
  }

  type SttpError = java.io.Serializable
  type OrderBook[S[_] <: Seq[_]] = Either[SttpError, S[MarketOrder]]
  type OrderBookList = OrderBook[List]

  def mergeOrderBooks(orderBooks: List[OrderBookList]): Either[SttpError, List[MarketOrder]] = {

    import cats.implicits._ // sequence

    val orders = orderBooks.sequence
    orders.map(_.flatten)
  }

  def sortMarketOrders(orderBook: List[MarketOrder]) = orderBook.sortBy(order ⇒ (order.category, order.value))

}
