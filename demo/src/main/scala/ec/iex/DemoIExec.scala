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
import com.micronautics.web3j.Cmd.{ isMac, isWindows }
import ec.iex.core.Balance
import ec.iex.util._

object DemoIExec {

  import scala.concurrent.ExecutionContext.Implicits.global

  import com.micronautics.web3j._
  //  import ec.iex._ // would need to include all the contracts wrapper if not in same package

  import ec.iex.core.Account._
  import ec.iex.core.Work._

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
      val gasLimit = Ether.fromWei(1000000)

      val (appHub, rlc, iexecHub, marketPlace) = loadContracts(web3, credentials)(gasPrice.bigInteger, gasLimit.bigInteger)

      println(s"RLC balance: ${rlcBalance(rlc, userWallet)}")
      println(s"RLC allowance: ${rlcAllowance(rlc, iexecHub, userWallet)}")
      val Balance(stakedBalance, lockedBalance) = hubBalances(iexecHub, userWallet)
      println(s"Balance staked: $stakedBalance\nBalance locked: $lockedBalance")

      //      val factorialAddress = "0x0F0921a1101475DF0A4E322aa7886a32B1e15a5C" // can get from getApp() if user's own dapp
      //      val factorialAddress = Factorial.getPreviouslyDeployedAddress("42")
      val vanitiyGenAddress = "0x2bcc53b7d48718d70cfc8b08ea986ce761ab5e0c" // FIXME this is actually vanity Gen's address
      val factorialApp = App.load(vanitiyGenAddress, web3.web3j, credentials, gasPrice.bigInteger, gasLimit.bigInteger)
      val appPrice = factorialApp.m_appPrice().send()

      // the two lines below approve the iexec hub contract and deposit to it respectively
      //allow(web3, userWallet, credentials, rlc, Address(iexecHub.getContractAddress))(appPrice.intValue())
      //depositToHub(iexecHub, appPrice.intValue())

      val workerPoolId = 502
      val workPoolAddress = "0x851f65b27030Ac9634BF514FfBC3C1369ED747e9"
      //       val workerPoolId = 312 // pool ID
      //      val workPoolAddress = "0x851f65b27030Ac9634BF514FfBC3C1369ED747e9" // pool address
      val params = "{\"cmdline\":\"12\"}" // dapp params

      val workId = buyWorkOrder(iexecHub, workerPoolId, workPoolAddress, vanitiyGenAddress, "0", params, userWallet.address.value, userWallet.address.value)

      println("workId: " + workId)

      Thread.sleep(20000) // allow time for WorkOrder contract to be created

      val workInfo = waitUntilCompleted(web3, workId, credentials, gasPrice.bigInteger, gasLimit.bigInteger)

      println(io.format(workInfo))

    } catch {
      case e: Throwable ⇒
        System.err.println(e.getMessage)
    }
  }

}
