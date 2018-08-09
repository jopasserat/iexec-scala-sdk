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

import com.micronautics.web3j.{ Address, EthereumSynchronous }
import org.web3j.crypto.{ Credentials, WalletUtils }
import ec.iex.util._
import ec.iex._
import java.math.BigInteger

case class UserWallet(
  privateKey: BigInteger,
  publicKey: BigInteger,
  address: Address)

case class Balance(staked: BigInteger, locked: BigInteger)

object Account {

  /**
   * No need to get contract's method data to later build and send an asynchronous raw transaction since asynchronicity is handled by Web3J.
   *
   * @param web3
   * @param userWallet
   * @param credentials
   * @param rlcContract
   * @param escrowAddress
   * @param amount
   * @return
   */
  def allow(web3: EthereumSynchronous, userWallet: UserWallet, credentials: Credentials, rlcContract: RLC, escrowAddress: Address)(amount: Int = 1) = {
    // try to allow 1 nRLC
    val unsignedTx = rlcContract.approve(escrowAddress.value, amount).send()

    //    val txHash = signAndSendTx(web3, userWallet, credentials)(Address(rlcContract.getContractAddress), unsignedTx)
    unsignedTx
  }

  def rlcBalance(rlcContract: RLC, wallet: UserWallet) =
    rlcContract.balanceOf(wallet.address.value).send()

  def rlcAllowance(rlcContract: RLC, iexecHubContract: IexecHub, wallet: UserWallet) =
    rlcContract.allowance(wallet.address.value, iexecHubContract.getContractAddress).send()

  def hubBalances(iexecHubContract: IexecHub, wallet: UserWallet) = {
    val balances = iexecHubContract.checkBalance(wallet.address.value).send()
    Balance(balances.getValue1, balances.getValue2)
  }

  def withdrawFromHub(iexecHubContract: IexecHub, amount: BigInteger) = {
    // withdraw amount from iexec hub
    iexecHubContract.withdraw(amount).send()
  }

  def depositToHub(iexecHubContract: IexecHub, amount: BigInteger) = {
    // deposit amount to iexec hub
    iexecHubContract.deposit(amount).send()
  }

  def loadWallet(walletFilepath: String, password: String) = {

    val credentials: Credentials = WalletUtils.loadCredentials(password, walletFilepath)

    val (pubKey, privKey) = (credentials.getEcKeyPair.getPrivateKey, credentials.getEcKeyPair.getPublicKey)
    val userWallet = UserWallet(privKey, pubKey, Address(credentials.getAddress))

    (credentials, userWallet)
  }

  lazy val KOVAN_ID = "42"

  def loadContracts(web3: EthereumSynchronous, credentials: Credentials)(gasPrice: BigInteger, gasLimit: BigInteger) = {

    val web3j = web3.web3j

    val appHubAddress = AppHub.getPreviouslyDeployedAddress(KOVAN_ID)
    val rlcAddress = RLC.getPreviouslyDeployedAddress(KOVAN_ID)
    val iexecHubAddress = IexecHub.getPreviouslyDeployedAddress(KOVAN_ID)
    val marketplaceAddress = Marketplace.getPreviouslyDeployedAddress(KOVAN_ID)

    val appHub = AppHub.load(appHubAddress, web3j, credentials, gasPrice, gasLimit)
    val rlc = RLC.load(rlcAddress, web3j, credentials, gasPrice, gasLimit)
    val iexecHub = IexecHub.load(iexecHubAddress, web3j, credentials, gasPrice, gasLimit)
    val marketplace = Marketplace.load(marketplaceAddress, web3j, credentials, gasPrice, gasLimit)

    (appHub, rlc, iexecHub, marketplace)
  }

}