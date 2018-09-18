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

package ec.iex

package object util {

  import java.math.BigInteger

  import com.micronautics.web3j.{ Address, EthereumSynchronous, SignedData, Web3JScala }
  import ec.iex.core.UserWallet
  import org.web3j.crypto.{ Credentials, RawTransaction, TransactionEncoder }
  import org.web3j.protocol.core.methods.response.TransactionReceipt

  implicit def int2BigInt(i: Int): BigInteger = BigInt(i).bigInteger
  implicit def bigInt2BigInteger(bi: BigInt): BigInteger = bi.bigInteger

  // ---------------  begin signAndSendTx -------------------
  def signAndSendTx(web3: EthereumSynchronous, userWallet: UserWallet, credentials: Credentials)(to: Address, unsignedTransaction: TransactionReceipt) = {

    import scala.concurrent.ExecutionContext.Implicits.global

    val networkGasPrice = web3.gasPrice
    val nonce = web3.nextNonce(Address(credentials.getAddress))
    val estimatedGas = unsignedTransaction.getGasUsed

    // from https://github.com/iExecBlockchainComputing/iexec-sdk/blob/master/src/utils.js#L20-L22
    val DEFAULT_GAS_PRICE_MULTIPLIER = 1
    val DEFAULT_GAS_LIMIT_MULTIPLIER = 1
    val BLOCK_GAS_LIMIT = 4600000

    // same since we don't handle differences between chains here

    val gasPriceMultiplier = DEFAULT_GAS_PRICE_MULTIPLIER
    val gasPrice = networkGasPrice * gasPriceMultiplier
    val gasLimitMultiplier = DEFAULT_GAS_LIMIT_MULTIPLIER

    val gasLimit = estimatedGas.multiply(gasLimitMultiplier).min(BLOCK_GAS_LIMIT)

    // Create a custom transaction
    val rawTransaction: RawTransaction =
      RawTransaction.createTransaction(nonce.bigInteger, gasPrice.bigInteger, gasLimit, to.value, unsignedTransaction.getTransactionHash)
    println(io.format(rawTransaction))

    // Sign & send the transaction
    val signedMessage: Array[Byte] = TransactionEncoder.signMessage(rawTransaction, credentials)
    val hexValue: String = javax.xml.bind.DatatypeConverter.printHexBinary(signedMessage)

    val web3_async = new Web3JScala(web3.web3j).async
    val transactionHash = web3_async.sendRawTransaction(SignedData(hexValue))

    transactionHash
  }
}
