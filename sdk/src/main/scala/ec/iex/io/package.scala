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

package object io {

  import org.web3j.crypto.RawTransaction
  import org.web3j.protocol.core.methods.response.TransactionReceipt
  import ec.iex.core._
  import ec.iex.core.Work.translateStatus
  import util.int2BigInt

  def format(tx: RawTransaction): String =
    s"""Raw transaction:
       |  Data         = ${tx.getData}
       |  Gas limit    = ${tx.getGasLimit}
       |  Gas price    = ${tx.getGasPrice}
       |  Gas limit    = ${tx.getGasLimit}
       |  Nonce        = ${tx.getNonce}
       |  To           = ${tx.getTo}
       |  Value        = ${tx.getValue}
       |""".stripMargin

  def format(tx: TransactionReceipt): String =
    s"""Transaction receipt:
       |  Block hash              = ${tx.getBlockHash}
       |  Block number            = ${tx.getBlockNumber}
       |  Raw block number        = ${tx.getBlockNumberRaw}
       |  Contract address        = ${tx.getContractAddress}
       |  Cumulative gas used     = ${tx.getCumulativeGasUsed}
       |  Raw cumulative gas used = ${tx.getCumulativeGasUsedRaw}
       |  From                    = ${tx.getFrom}
       |  Gas used                = ${tx.getGasUsed}
       |  Raw gas used            = ${tx.getGasUsedRaw}
       |  Logs                    = ${tx.getLogs}
       |  Log bloom               = ${tx.getLogsBloom}
       |  Root                    = ${tx.getRoot}
       |  To                      = ${tx.getTo}
       |  Transaction hash        = ${tx.getTransactionHash}
       |  Transaction index       = ${tx.getTransactionIndex}
       |  Raw transaction index   = ${tx.getTransactionIndexRaw}
       |""".stripMargin

  def format(work: WorkInfo): String =
    s"""Work info:
       |  Market Order ID = ${work.marketOrderId}
       |  Requester       = ${work.requester}
       |  App             = ${work.app}
       |  Status          = ${translateStatus(work.status.intValue())}
       |  Dataset         = ${work.dataset}
       |  Worker pool     = ${work.workerpool}
       |  Emit cost       = ${work.emitCost}
       |  Parameters      = ${work.params}
       |  Callback        = ${work.callback}
       |  Beneficiary     = ${work.beneficiary}
       |  StdOut          = ${work.stdOut}
       |  StdErr          = ${work.stdErr}
       |  Uri             = ${work.uri}
       |""".stripMargin

}
