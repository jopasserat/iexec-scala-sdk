/**
 * Copyright (C) 2018 Jonathan Passerat-Palmbach
 * <p>
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * <p>
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * <p>
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package ec.iex

import org.web3j.protocol.Web3j
import com.micronautics.web3j.Cmd.{ isMac, isWindows }

object DemoIExec extends App {

  import scala.concurrent.ExecutionContext.Implicits.global

  import com.micronautics.web3j._
  //  import ec.iex._ // would need to include all the contracts wrapper if not in same package

  import ec.iex.core.Account._

  try {
    // TODO how to get that from web3.accounts?
    val walletDir: String = Cmd.home(
      if (isWindows) s"${sys.props("user.home")}\\AppData\\Roaming\\Ethereum\\"
      else if (isMac) "~/Library/Ethereum/"
      //    else "~/.ethereum/ropsten/keystore/UTC--2018-05-07T22-33-01.660000000Z--6434239175774f2cd7851e9e3038aa814756bfa9.json")
      else "/home/foo/.ethereum/ropsten/keystore/wallet")

    val (credentials, userWallet) = loadWallet(walletDir, "XXX")

    val web3j: Web3j = Web3JScala.fromHttp() // defaults to http://localhost:8545/
    val web3JScala = new Web3JScala(web3j)
    val web3 = web3JScala.sync // CAREFUL!! impactful choice with all subsequent calls going through this proxy being synchronous!

    val gasPrice = web3.gasPrice.asWei
    val gasLimit = Ether.fromWei(452250)

    // TODO get that from contract?
    val escrowAddress = Address("0xf81b04beed2002ec2f98210cfed2f051b3df7528")

    val (oracle, rlcContract, factorial) = loadContracts(web3, credentials)(gasPrice.bigInteger, gasLimit.bigInteger)

    // FIXME all these call are synchronous at the moment
    val callbackPrice = oracle.callbackPrice().send()
    val dappPrice = oracle.getDappPrice(factorial.getContractAddress).send()

    showRlcBalance(rlcContract, userWallet.address)
    showAllowance(rlcContract, userWallet.address, escrowAddress)

    val txReceipt = allow(web3, userWallet, credentials, rlcContract, escrowAddress)(3)
    //    for (txReceipt ← futureTxReceipt) {
    println(io.format(txReceipt))
    println(s"View on etherscan: https://ropsten.etherscan.io/tx/${txReceipt.getTransactionHash}")
    //    }

  } catch {
    case e: Throwable ⇒
      System.err.println(e.getMessage)
  }
}
