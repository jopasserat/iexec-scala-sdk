package ec.iex;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import rx.Observable;
import rx.functions.Func1;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 3.5.0.
 */
public class IexecCallbackInterface extends Contract {
    private static final String BINARY = "0x";

    public static final String FUNC_WORKORDERCALLBACK = "workOrderCallback";

    public static final Event WORKORDERCALLBACK_EVENT = new Event("WorkOrderCallback", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}));
    ;

    protected static final HashMap<String, String> _addresses;

    static {
        _addresses = new HashMap<String, String>();
    }

    protected IexecCallbackInterface(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected IexecCallbackInterface(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public List<WorkOrderCallbackEventResponse> getWorkOrderCallbackEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(WORKORDERCALLBACK_EVENT, transactionReceipt);
        ArrayList<WorkOrderCallbackEventResponse> responses = new ArrayList<WorkOrderCallbackEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            WorkOrderCallbackEventResponse typedResponse = new WorkOrderCallbackEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.woid = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.stdout = (String) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.stderr = (String) eventValues.getNonIndexedValues().get(2).getValue();
            typedResponse.uri = (String) eventValues.getNonIndexedValues().get(3).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<WorkOrderCallbackEventResponse> workOrderCallbackEventObservable(EthFilter filter) {
        return web3j.ethLogObservable(filter).map(new Func1<Log, WorkOrderCallbackEventResponse>() {
            @Override
            public WorkOrderCallbackEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(WORKORDERCALLBACK_EVENT, log);
                WorkOrderCallbackEventResponse typedResponse = new WorkOrderCallbackEventResponse();
                typedResponse.log = log;
                typedResponse.woid = (String) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.stdout = (String) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse.stderr = (String) eventValues.getNonIndexedValues().get(2).getValue();
                typedResponse.uri = (String) eventValues.getNonIndexedValues().get(3).getValue();
                return typedResponse;
            }
        });
    }

    public Observable<WorkOrderCallbackEventResponse> workOrderCallbackEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(WORKORDERCALLBACK_EVENT));
        return workOrderCallbackEventObservable(filter);
    }

    public RemoteCall<TransactionReceipt> workOrderCallback(String _woid, String _stdout, String _stderr, String _uri) {
        final Function function = new Function(
                FUNC_WORKORDERCALLBACK, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_woid), 
                new org.web3j.abi.datatypes.Utf8String(_stdout), 
                new org.web3j.abi.datatypes.Utf8String(_stderr), 
                new org.web3j.abi.datatypes.Utf8String(_uri)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public static RemoteCall<IexecCallbackInterface> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(IexecCallbackInterface.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<IexecCallbackInterface> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(IexecCallbackInterface.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static IexecCallbackInterface load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new IexecCallbackInterface(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static IexecCallbackInterface load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new IexecCallbackInterface(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected String getStaticDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static String getPreviouslyDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static class WorkOrderCallbackEventResponse {
        public Log log;

        public String woid;

        public String stdout;

        public String stderr;

        public String uri;
    }
}
