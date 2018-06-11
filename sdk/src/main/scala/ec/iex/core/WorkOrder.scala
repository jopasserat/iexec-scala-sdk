package ec.iex.core

import java.math.BigInteger

import ec.iex._

object WorkOrder {

  def buyWorkOrder(iexecHubContract: IexecHub, workerPoolId: Int, workerPoolAddress: String, appAddress: String, datasetAddress: String, parameters: String, callbackAddress: String, beneficiaryAddress: String) = {

    val txReceipt = iexecHubContract.buyForWorkOrder(BigInteger.valueOf(workerPoolId), workerPoolAddress, appAddress, datasetAddress, parameters, callbackAddress, beneficiaryAddress).send()

    val workId = "0x" + txReceipt.getLogs().get(1).getTopics().get(1).replace("0x", "").replaceFirst("^0+(?!$)", "")

    workId
  }

}
