package ec.iex;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Bytes32;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.abi.datatypes.generated.Uint8;
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
public class WorkOrder extends Contract {
    private static final String BINARY = "0x6060604052341561000f57600080fd5b604051610c5a380380610c5a8339810160405280805191906020018051919060200180519190602001805191906020018051919060200180519190602001805182019190602001805191906020018051600e8054600160a060020a03191633600160a060020a039081169190911790915590925089161515905061009257600080fd5b6000805460ff1916600190811790915589905560028054600160a060020a0319908116600160a060020a038a81169190911790925560038054821689841617905560048054821688841617905560058054909116918a1691909117905560068490556007838051610107929160200190610141565b5060088054600160a060020a03938416600160a060020a03199182161790915560098054929093169116179055506101dc95505050505050565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f1061018257805160ff19168380011785556101af565b828001600101855582156101af579182015b828111156101af578251825591602001919060010190610194565b506101bb9291506101bf565b5090565b6101d991905b808211156101bb57600081556001016101c5565b90565b610a6f806101eb6000396000f3006060604052600436106101065763ffffffff7c01000000000000000000000000000000000000000000000000000000006000350416630690e5b8811461010b57806315298c771461013a5780631a514d97146101c45780632d4d671f146101eb5780634e71d92d146101fe5780635f44910c146102135780636946f6921461022657806371a599ca146102395780638628aaff1461024c5780639c4a856114610271578063cc3a2dfa14610284578063d3281fd614610297578063d3a69e01146102aa578063d5fdfdbc146102bd578063da1fea2814610392578063e329c478146103a5578063ecc40f64146103dc578063f3859f57146103ef578063f6a5b13e14610402575b600080fd5b341561011657600080fd5b61011e610415565b604051600160a060020a03909116815260200160405180910390f35b341561014557600080fd5b61014d610424565b60405160208082528190810183818151815260200191508051906020019080838360005b83811015610189578082015183820152602001610171565b50505050905090810190601f1680156101b65780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b34156101cf57600080fd5b6101d76104c2565b604051901515815260200160405180910390f35b34156101f657600080fd5b6101d761053d565b341561020957600080fd5b6102116105b7565b005b341561021e57600080fd5b61011e610647565b341561023157600080fd5b61011e610656565b341561024457600080fd5b61011e610665565b341561025757600080fd5b61025f610674565b60405190815260200160405180910390f35b341561027c57600080fd5b61014d61067a565b341561028f57600080fd5b61014d6106e5565b34156102a257600080fd5b61025f610750565b34156102b557600080fd5b61011e610756565b34156102c857600080fd5b61021160046024813581810190830135806020601f8201819004810201604051908101604052818152929190602084018383808284378201915050505050509190803590602001908201803590602001908080601f01602080910402602001604051908101604052818152929190602084018383808284378201915050505050509190803590602001908201803590602001908080601f01602080910402602001604051908101604052818152929190602084018383808284375094965061076595505050505050565b341561039d57600080fd5b61011e610913565b34156103b057600080fd5b6103b8610922565b604051808260048111156103c857fe5b60ff16815260200191505060405180910390f35b34156103e757600080fd5b61025f61092b565b34156103fa57600080fd5b61014d610931565b341561040d57600080fd5b61011e61099c565b600454600160a060020a031681565b60078054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156104ba5780601f1061048f576101008083540402835291602001916104ba565b820191906000526020600020905b81548152906001019060200180831161049d57829003601f168201915b505050505081565b60045460009033600160a060020a039081169116146104e057600080fd5b600260005460ff1660048111156104f357fe5b146104fd57600080fd5b6000805460ff191660011790557f06c42818c4ab74dff6aec55942f601c2e9b7f2aa4321ee71690b125eacfe465460405160405180910390a15060015b90565b60045460009033600160a060020a0390811691161461055b57600080fd5b600160005460ff16600481111561056e57fe5b1461057857600080fd5b6000805460ff191660021790557f2b0cab0be6d82b2661b3b789c540ec9c7223aac635ac8e59a1e71e1137f2dd7760405160405180910390a150600190565b600e5433600160a060020a039081169116146105d257600080fd5b600160005460ff1660048111156105e557fe5b14806106015750600260005460ff1660048111156105ff57fe5b145b151561060c57600080fd5b6000805460ff191660031790557f1938697ee29e363ecda49e464c6d2aae25f0974bd1f2c81a91c21e13ad8dbf7760405160405180910390a1565b600554600160a060020a031681565b600254600160a060020a031681565b600354600160a060020a031681565b60065481565b600d8054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156104ba5780601f1061048f576101008083540402835291602001916104ba565b600b8054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156104ba5780601f1061048f576101008083540402835291602001916104ba565b600a5481565b600e54600160a060020a031681565b600e5433600160a060020a0390811691161461078057600080fd5b600260005460ff16600481111561079357fe5b1461079d57600080fd5b6000805460ff19166004179055600b8380516107bd9291602001906109ab565b50600c8280516107d19291602001906109ab565b50600d8180516107e59291602001906109ab565b508282826040518084805190602001908083835b602083106108185780518252601f1990920191602091820191016107f9565b6001836020036101000a038019825116818451161790925250505091909101905083805190602001908083835b602083106108645780518252601f199092019160209182019101610845565b6001836020036101000a038019825116818451161790925250505091909101905082805190602001908083835b602083106108b05780518252601f199092019160209182019101610891565b6001836020036101000a03801982511681845116179092525050509190910194506040935050505051908190039020600a557f777f59509d985349c80271b657d2649b218bc6f075a4625821b64448cc235b8660405160405180910390a1505050565b600854600160a060020a031681565b60005460ff1681565b60015481565b600c8054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156104ba5780601f1061048f576101008083540402835291602001916104ba565b600954600160a060020a031681565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f106109ec57805160ff1916838001178555610a19565b82800160010185558215610a19579182015b82811115610a195782518255916020019190600101906109fe565b50610a25929150610a29565b5090565b61053a91905b80821115610a255760008155600101610a2f5600a165627a7a72305820aab9d309bae837f3417f3dc81c0f650543365c210e440786b5dfc09f1981eba70029";

    public static final String FUNC_M_WORKERPOOL = "m_workerpool";

    public static final String FUNC_M_PARAMS = "m_params";

    public static final String FUNC_M_REQUESTER = "m_requester";

    public static final String FUNC_M_APP = "m_app";

    public static final String FUNC_M_DATASET = "m_dataset";

    public static final String FUNC_M_EMITCOST = "m_emitcost";

    public static final String FUNC_M_URI = "m_uri";

    public static final String FUNC_M_STDOUT = "m_stdout";

    public static final String FUNC_M_RESULTCALLBACKPROOF = "m_resultCallbackProof";

    public static final String FUNC_M_IEXECHUBADDRESS = "m_iexecHubAddress";

    public static final String FUNC_M_CALLBACK = "m_callback";

    public static final String FUNC_M_STATUS = "m_status";

    public static final String FUNC_M_MARKETORDERIDX = "m_marketorderIdx";

    public static final String FUNC_M_STDERR = "m_stderr";

    public static final String FUNC_M_BENEFICIARY = "m_beneficiary";

    public static final String FUNC_STARTREVEALINGPHASE = "startRevealingPhase";

    public static final String FUNC_REACTIVATE = "reActivate";

    public static final String FUNC_CLAIM = "claim";

    public static final String FUNC_SETRESULT = "setResult";

    public static final Event WORKORDERACTIVATED_EVENT = new Event("WorkOrderActivated", 
            Arrays.<TypeReference<?>>asList());
    ;

    public static final Event WORKORDERREACTIVATED_EVENT = new Event("WorkOrderReActivated", 
            Arrays.<TypeReference<?>>asList());
    ;

    public static final Event WORKORDERREVEALING_EVENT = new Event("WorkOrderRevealing", 
            Arrays.<TypeReference<?>>asList());
    ;

    public static final Event WORKORDERCLAIMED_EVENT = new Event("WorkOrderClaimed", 
            Arrays.<TypeReference<?>>asList());
    ;

    public static final Event WORKORDERCOMPLETED_EVENT = new Event("WorkOrderCompleted", 
            Arrays.<TypeReference<?>>asList());
    ;

    protected static final HashMap<String, String> _addresses;

    static {
        _addresses = new HashMap<String, String>();
    }

    protected WorkOrder(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected WorkOrder(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public RemoteCall<String> m_workerpool() {
        final Function function = new Function(FUNC_M_WORKERPOOL, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<String> m_params() {
        final Function function = new Function(FUNC_M_PARAMS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<String> m_requester() {
        final Function function = new Function(FUNC_M_REQUESTER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<String> m_app() {
        final Function function = new Function(FUNC_M_APP, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<String> m_dataset() {
        final Function function = new Function(FUNC_M_DATASET, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<BigInteger> m_emitcost() {
        final Function function = new Function(FUNC_M_EMITCOST, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<String> m_uri() {
        final Function function = new Function(FUNC_M_URI, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<String> m_stdout() {
        final Function function = new Function(FUNC_M_STDOUT, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<byte[]> m_resultCallbackProof() {
        final Function function = new Function(FUNC_M_RESULTCALLBACKPROOF, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteCall<String> m_iexecHubAddress() {
        final Function function = new Function(FUNC_M_IEXECHUBADDRESS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<String> m_callback() {
        final Function function = new Function(FUNC_M_CALLBACK, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<BigInteger> m_status() {
        final Function function = new Function(FUNC_M_STATUS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint8>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> m_marketorderIdx() {
        final Function function = new Function(FUNC_M_MARKETORDERIDX, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<String> m_stderr() {
        final Function function = new Function(FUNC_M_STDERR, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<String> m_beneficiary() {
        final Function function = new Function(FUNC_M_BENEFICIARY, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public static RemoteCall<WorkOrder> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, BigInteger _marketorderIdx, String _requester, String _app, String _dataset, String _workerpool, BigInteger _emitcost, String _params, String _callback, String _beneficiary) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_marketorderIdx), 
                new org.web3j.abi.datatypes.Address(_requester), 
                new org.web3j.abi.datatypes.Address(_app), 
                new org.web3j.abi.datatypes.Address(_dataset), 
                new org.web3j.abi.datatypes.Address(_workerpool), 
                new org.web3j.abi.datatypes.generated.Uint256(_emitcost), 
                new org.web3j.abi.datatypes.Utf8String(_params), 
                new org.web3j.abi.datatypes.Address(_callback), 
                new org.web3j.abi.datatypes.Address(_beneficiary)));
        return deployRemoteCall(WorkOrder.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static RemoteCall<WorkOrder> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, BigInteger _marketorderIdx, String _requester, String _app, String _dataset, String _workerpool, BigInteger _emitcost, String _params, String _callback, String _beneficiary) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_marketorderIdx), 
                new org.web3j.abi.datatypes.Address(_requester), 
                new org.web3j.abi.datatypes.Address(_app), 
                new org.web3j.abi.datatypes.Address(_dataset), 
                new org.web3j.abi.datatypes.Address(_workerpool), 
                new org.web3j.abi.datatypes.generated.Uint256(_emitcost), 
                new org.web3j.abi.datatypes.Utf8String(_params), 
                new org.web3j.abi.datatypes.Address(_callback), 
                new org.web3j.abi.datatypes.Address(_beneficiary)));
        return deployRemoteCall(WorkOrder.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public List<WorkOrderActivatedEventResponse> getWorkOrderActivatedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(WORKORDERACTIVATED_EVENT, transactionReceipt);
        ArrayList<WorkOrderActivatedEventResponse> responses = new ArrayList<WorkOrderActivatedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            WorkOrderActivatedEventResponse typedResponse = new WorkOrderActivatedEventResponse();
            typedResponse.log = eventValues.getLog();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<WorkOrderActivatedEventResponse> workOrderActivatedEventObservable(EthFilter filter) {
        return web3j.ethLogObservable(filter).map(new Func1<Log, WorkOrderActivatedEventResponse>() {
            @Override
            public WorkOrderActivatedEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(WORKORDERACTIVATED_EVENT, log);
                WorkOrderActivatedEventResponse typedResponse = new WorkOrderActivatedEventResponse();
                typedResponse.log = log;
                return typedResponse;
            }
        });
    }

    public Observable<WorkOrderActivatedEventResponse> workOrderActivatedEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(WORKORDERACTIVATED_EVENT));
        return workOrderActivatedEventObservable(filter);
    }

    public List<WorkOrderReActivatedEventResponse> getWorkOrderReActivatedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(WORKORDERREACTIVATED_EVENT, transactionReceipt);
        ArrayList<WorkOrderReActivatedEventResponse> responses = new ArrayList<WorkOrderReActivatedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            WorkOrderReActivatedEventResponse typedResponse = new WorkOrderReActivatedEventResponse();
            typedResponse.log = eventValues.getLog();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<WorkOrderReActivatedEventResponse> workOrderReActivatedEventObservable(EthFilter filter) {
        return web3j.ethLogObservable(filter).map(new Func1<Log, WorkOrderReActivatedEventResponse>() {
            @Override
            public WorkOrderReActivatedEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(WORKORDERREACTIVATED_EVENT, log);
                WorkOrderReActivatedEventResponse typedResponse = new WorkOrderReActivatedEventResponse();
                typedResponse.log = log;
                return typedResponse;
            }
        });
    }

    public Observable<WorkOrderReActivatedEventResponse> workOrderReActivatedEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(WORKORDERREACTIVATED_EVENT));
        return workOrderReActivatedEventObservable(filter);
    }

    public List<WorkOrderRevealingEventResponse> getWorkOrderRevealingEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(WORKORDERREVEALING_EVENT, transactionReceipt);
        ArrayList<WorkOrderRevealingEventResponse> responses = new ArrayList<WorkOrderRevealingEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            WorkOrderRevealingEventResponse typedResponse = new WorkOrderRevealingEventResponse();
            typedResponse.log = eventValues.getLog();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<WorkOrderRevealingEventResponse> workOrderRevealingEventObservable(EthFilter filter) {
        return web3j.ethLogObservable(filter).map(new Func1<Log, WorkOrderRevealingEventResponse>() {
            @Override
            public WorkOrderRevealingEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(WORKORDERREVEALING_EVENT, log);
                WorkOrderRevealingEventResponse typedResponse = new WorkOrderRevealingEventResponse();
                typedResponse.log = log;
                return typedResponse;
            }
        });
    }

    public Observable<WorkOrderRevealingEventResponse> workOrderRevealingEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(WORKORDERREVEALING_EVENT));
        return workOrderRevealingEventObservable(filter);
    }

    public List<WorkOrderClaimedEventResponse> getWorkOrderClaimedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(WORKORDERCLAIMED_EVENT, transactionReceipt);
        ArrayList<WorkOrderClaimedEventResponse> responses = new ArrayList<WorkOrderClaimedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            WorkOrderClaimedEventResponse typedResponse = new WorkOrderClaimedEventResponse();
            typedResponse.log = eventValues.getLog();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<WorkOrderClaimedEventResponse> workOrderClaimedEventObservable(EthFilter filter) {
        return web3j.ethLogObservable(filter).map(new Func1<Log, WorkOrderClaimedEventResponse>() {
            @Override
            public WorkOrderClaimedEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(WORKORDERCLAIMED_EVENT, log);
                WorkOrderClaimedEventResponse typedResponse = new WorkOrderClaimedEventResponse();
                typedResponse.log = log;
                return typedResponse;
            }
        });
    }

    public Observable<WorkOrderClaimedEventResponse> workOrderClaimedEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(WORKORDERCLAIMED_EVENT));
        return workOrderClaimedEventObservable(filter);
    }

    public List<WorkOrderCompletedEventResponse> getWorkOrderCompletedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(WORKORDERCOMPLETED_EVENT, transactionReceipt);
        ArrayList<WorkOrderCompletedEventResponse> responses = new ArrayList<WorkOrderCompletedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            WorkOrderCompletedEventResponse typedResponse = new WorkOrderCompletedEventResponse();
            typedResponse.log = eventValues.getLog();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<WorkOrderCompletedEventResponse> workOrderCompletedEventObservable(EthFilter filter) {
        return web3j.ethLogObservable(filter).map(new Func1<Log, WorkOrderCompletedEventResponse>() {
            @Override
            public WorkOrderCompletedEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(WORKORDERCOMPLETED_EVENT, log);
                WorkOrderCompletedEventResponse typedResponse = new WorkOrderCompletedEventResponse();
                typedResponse.log = log;
                return typedResponse;
            }
        });
    }

    public Observable<WorkOrderCompletedEventResponse> workOrderCompletedEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(WORKORDERCOMPLETED_EVENT));
        return workOrderCompletedEventObservable(filter);
    }

    public RemoteCall<TransactionReceipt> startRevealingPhase() {
        final Function function = new Function(
                FUNC_STARTREVEALINGPHASE, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> reActivate() {
        final Function function = new Function(
                FUNC_REACTIVATE, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> claim() {
        final Function function = new Function(
                FUNC_CLAIM, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> setResult(String _stdout, String _stderr, String _uri) {
        final Function function = new Function(
                FUNC_SETRESULT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_stdout), 
                new org.web3j.abi.datatypes.Utf8String(_stderr), 
                new org.web3j.abi.datatypes.Utf8String(_uri)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public static WorkOrder load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new WorkOrder(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static WorkOrder load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new WorkOrder(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected String getStaticDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static String getPreviouslyDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static class WorkOrderActivatedEventResponse {
        public Log log;
    }

    public static class WorkOrderReActivatedEventResponse {
        public Log log;
    }

    public static class WorkOrderRevealingEventResponse {
        public Log log;
    }

    public static class WorkOrderClaimedEventResponse {
        public Log log;
    }

    public static class WorkOrderCompletedEventResponse {
        public Log log;
    }
}
