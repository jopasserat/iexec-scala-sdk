package ec.iex.core

import java.math.BigInteger

import com.micronautics.web3j.EthereumSynchronous
import ec.iex.IexecHub
import ec.iex.WorkOrder
import org.web3j.crypto.Credentials

case class WorkInfo(
  marketOrderId: BigInteger,
  requester: String,
  app: String,
  status: BigInteger,
  dataset: String,
  workerpool: String,
  emitCost: BigInteger,
  params: String,
  callback: String,
  beneficiary: String,
  stdOut: String,
  stdErr: String,
  uri: String)

object WorkState extends Enumeration {
  val UNSET, ACTIVE, REVEALING, CLAIMED, COMPLETED = Value
}

object Work {

  def buyWorkOrder(iexecHubContract: IexecHub, workerPoolId: Int, workerPoolAddress: String, appAddress: String, datasetAddress: String, parameters: String, callbackAddress: String, beneficiaryAddress: String) = {

    val txReceipt = iexecHubContract.buyForWorkOrder(BigInteger.valueOf(workerPoolId), workerPoolAddress, appAddress, datasetAddress, parameters, callbackAddress, beneficiaryAddress).send()

    val workId = "0x" + txReceipt.getLogs().get(1).getTopics().get(1).replace("0x", "").replaceFirst("^0+(?!$)", "")

    workId
  }

  def getWorkOrder(web3: EthereumSynchronous, workId: String, credentials: Credentials, gasPrice: BigInteger, gasLimit: BigInteger) = {
    val workInfo = WorkOrder.load(workId, web3.web3j, credentials, gasPrice, gasLimit)

    WorkInfo(
      workInfo.m_marketorderIdx().send(),
      workInfo.m_requester().send(),
      workInfo.m_app().send(),
      workInfo.m_status().send(),
      workInfo.m_dataset().send(),
      workInfo.m_workerpool().send(),
      workInfo.m_emitcost().send(),
      workInfo.m_params().send(),
      workInfo.m_callback().send(),
      workInfo.m_beneficiary().send(),
      workInfo.m_stdout().send(),
      workInfo.m_stderr().send(),
      workInfo.m_uri().send())
  }

  def translateStatus(statusID: Int) =
    statusID match {
      case 0 ⇒ WorkState.UNSET
      case 1 ⇒ WorkState.ACTIVE
      case 2 ⇒ WorkState.REVEALING
      case 3 ⇒ WorkState.CLAIMED
      case 4 ⇒ WorkState.COMPLETED
    }

}
