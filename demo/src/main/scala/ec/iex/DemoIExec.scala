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

import java.math.BigInteger

import org.web3j.protocol.Web3j
import com.micronautics.web3j.Cmd.{isMac, isWindows}

object DemoIExec {

  import scala.concurrent.ExecutionContext.Implicits.global

  import com.micronautics.web3j._
  //  import ec.iex._ // would need to include all the contracts wrapper if not in same package

  import ec.iex.core.Account._

  def main(args: Array[String]): Unit = {

    try {
      // TODO how to get that from web3.accounts?
      val walletDir: String = Cmd.home(
        if (isWindows) s"${sys.props("user.home")}\\AppData\\Roaming\\Ethereum\\"
        else if (isMac) "/Users/Karow/Library/Application Support/io.parity.ethereum/keys/kovan/"
        else "/home/foo/.ethereum/ropsten/keystore/wallet")

    val (credentials, userWallet) = loadWallet(walletDir, "XXX")

      val web3j: Web3j = Web3JScala.fromHttp() // defaults to http://localhost:8545/
      val web3JScala = new Web3JScala(web3j)
      val web3 = web3JScala.sync // CAREFUL!! impactful choice with all subsequent calls going through this proxy being synchronous!

      val gasPrice = web3.gasPrice.asWei
      val gasLimit = Ether.fromWei(452250)


      val (appHub, rlc, iexecHub) = loadContracts(web3, credentials)(gasPrice.bigInteger, gasLimit.bigInteger)

      val factorialAddress = appHub.getApp(userWallet.address.value, BigInteger.valueOf(3)).send()

      showRlcBalance(rlc, userWallet.address)
      showHubBalances(iexecHub, userWallet.address)

    } catch {
      case e: Throwable ⇒
        System.err.println(e.getMessage)
    }
  }

}
