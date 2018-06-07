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

  def showRlcBalance(rlcContract: RLC, walletAddress: Address) = {
    // get RLC balance of wallet
    println("RLC balance: " + rlcContract.balanceOf(walletAddress.value).send())
  }

  def showAllowance(rlcContract: RLC, walletAddress: Address, escrowAddress: Address) = {
    // get current allowance from wallet address to escrow address
    println("Account allowance: " + rlcContract.allowance(walletAddress.value, escrowAddress.value).send())
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

    AppHub.load(appHubAddress, web3j, credentials, gasPrice, gasLimit)
  }

}