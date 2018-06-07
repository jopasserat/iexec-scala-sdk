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
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
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
 * <p>Generated with web3j version 3.4.0.
 */
public class IexecAPI extends Contract {
    private static final String BINARY = "0x6060604052341561000f57600080fd5b604051604080610c2883398101604052808051919060200180516000805460a060020a60ff0219600160a060020a03338116600160a060020a0319909316929092171674010000000000000000000000000000000000000000179091559092508391508116151561007f57600080fd5b60018054600160a060020a03928316600160a060020a0319918216179091556002805493909216921691909117905550610b6a806100be6000396000f30060606040526004361061008a5763ffffffff60e060020a6000350416634c0f5342811461008f578063514d7067146100b9578063536e28001461019c57806356af48ca1461022057806379117b2e14610236578063a56620f71461024c578063bbac78a914610262578063c2cc421414610281578063deff41c1146102b0578063e21b9d08146102c3575b600080fd5b341561009a57600080fd5b6100a56004356102d6565b604051901515815260200160405180910390f35b34156100c457600080fd5b6100a560048035600160a060020a03169060446024803590810190830135806020601f8201819004810201604051908101604052818152929190602084018383808284378201915050505050509190803590602001908201803590602001908080601f01602080910402602001604051908101604052818152929190602084018383808284378201915050505050509190803590602001908201803590602001908080601f01602080910402602001604051908101604052818152929190602084018383808284375094965061042195505050505050565b34156101a757600080fd5b61021e6004803590600160a060020a0360248035821692604435831692606435169160a49060843590810190830135806020601f8201819004810201604051908101604052818152929190602084018383808284375094965050600160a060020a038535811695602001351693506105c992505050565b005b341561022b57600080fd5b6100a560043561071b565b341561024157600080fd5b6100a56004356107f9565b341561025757600080fd5b6100a56004356108eb565b341561026d57600080fd5b61021e600160a060020a0360043516610a23565b341561028c57600080fd5b610294610aff565b604051600160a060020a03909116815260200160405180910390f35b34156102bb57600080fd5b610294610b0e565b34156102ce57600080fd5b6100a5610b1d565b60008054819033600160a060020a039081169116146102f457600080fd5b600154600160a060020a031663b017c0366040518163ffffffff1660e060020a028152600401602060405180830381600087803b151561033357600080fd5b5af1151561034057600080fd5b5050506040518051600154909250600160a060020a03808416925063095ea7b391168560405160e060020a63ffffffff8516028152600160a060020a0390921660048301526024820152604401602060405180830381600087803b15156103a657600080fd5b5af115156103b357600080fd5b5050506040518051905015156103c857600080fd5b6001547f5e9a23944fb3d019925ad84f8e1696436c1c7229787674a8ef8e08c776050df590600160a060020a031684604051600160a060020a03909216825260208201526040908101905180910390a150600192915050565b60025460009033600160a060020a0390811691161461043f57600080fd5b7f708463eccdafadafbe7022c0f4909af2e585cd08c63eaefa786159e156227e3785858585604051600160a060020a03851681526080602082018181529060408301906060840190840187818151815260200191508051906020019080838360005b838110156104b95780820151838201526020016104a1565b50505050905090810190601f1680156104e65780820380516001836020036101000a031916815260200191505b50848103835286818151815260200191508051906020019080838360005b8381101561051c578082015183820152602001610504565b50505050905090810190601f1680156105495780820380516001836020036101000a031916815260200191505b50848103825285818151815260200191508051906020019080838360005b8381101561057f578082015183820152602001610567565b50505050905090810190601f1680156105ac5780820380516001836020036101000a031916815260200191505b5097505050505050505060405180910390a1506001949350505050565b600154600090600160a060020a031663536e28008989898989898960405160e060020a63ffffffff8a1602815260048101888152600160a060020a0380891660248401528781166044840152868116606484015284811660a4840152831660c483015260e060848301908152909160e40185818151815260200191508051906020019080838360005b8381101561066a578082015183820152602001610652565b50505050905090810190601f1680156106975780820380516001836020036101000a031916815260200191505b5098505050505050505050602060405180830381600087803b15156106bb57600080fd5b5af115156106c857600080fd5b5050506040518051905090507f97bc1c5737260b338426a9a41398356e2567bfb662ff28845fb5cb3e6cdfee9181604051600160a060020a03909116815260200160405180910390a15050505050505050565b6000805433600160a060020a0390811691161461073757600080fd5b600154600160a060020a031663b6b55f258360405160e060020a63ffffffff84160281526004810191909152602401602060405180830381600087803b151561077f57600080fd5b5af1151561078c57600080fd5b5050506040518051905015156107a157600080fd5b6001547fbaa053b1e17bc83190da4939238743339cd734d83d7413a6d3c117df790dd1a590600160a060020a031683604051600160a060020a03909216825260208201526040908101905180910390a1506001919050565b6000805433600160a060020a0390811691161461081557600080fd5b600154600160a060020a0316632e1a7d4d8360405160e060020a63ffffffff84160281526004810191909152602401602060405180830381600087803b151561085d57600080fd5b5af1151561086a57600080fd5b50505060405180519050151561087f57600080fd5b610888826108eb565b151561089357600080fd5b6001547f2114edfbc766dd13ecebe139c59b657991c87b94518361feb5db86f05b0570f190600160a060020a031683604051600160a060020a03909216825260208201526040908101905180910390a1506001919050565b60008054819033600160a060020a0390811691161461090957600080fd5b600154600160a060020a031663b017c0366040518163ffffffff1660e060020a028152600401602060405180830381600087803b151561094857600080fd5b5af1151561095557600080fd5b5050506040518051915050600160a060020a03811663a9059cbb338560405160e060020a63ffffffff8516028152600160a060020a0390921660048301526024820152604401602060405180830381600087803b15156109b457600080fd5b5af115156109c157600080fd5b5050506040518051905015156109d657600080fd5b7f3cab9babe8fba8f5cfad7cac37057781ced585f6af63c4e64aedbb12a5c96d993384604051600160a060020a03909216825260208201526040908101905180910390a150600192915050565b60005433600160a060020a03908116911614610a3e57600080fd5b60005474010000000000000000000000000000000000000000900460ff161515610a6757600080fd5b600160a060020a0381161515610a7c57600080fd5b600054600160a060020a0380831691167f8be0079c531659141344cd1fd0a4f28419497f9722a3daafe3b4186f6b6457e060405160405180910390a36000805473ffffffffffffffffffffffffffffffffffffffff1916600160a060020a03929092169190911774ff000000000000000000000000000000000000000019169055565b600254600160a060020a031681565b600054600160a060020a031681565b60005474010000000000000000000000000000000000000000900460ff16815600a165627a7a723058203c5f00edf167da00906749313aaa54bb10b6fb41b4d3297b9bb90c7027adf5c70029";

    public static final String FUNC_SETIMMUTABLEOWNERSHIP = "setImmutableOwnership";

    public static final String FUNC_M_CALLBACKPROOFADDRESS = "m_callbackProofAddress";

    public static final String FUNC_M_OWNER = "m_owner";

    public static final String FUNC_M_CHANGEABLE = "m_changeable";

    public static final String FUNC_BUYFORWORKORDER = "buyForWorkOrder";

    public static final String FUNC_WORKORDERCALLBACK = "workOrderCallback";

    public static final String FUNC_APPROVEIEXECHUB = "approveIexecHub";

    public static final String FUNC_WITHDRAWRLCFROMIEXECAPI = "withdrawRLCFromIexecAPI";

    public static final String FUNC_DEPOSITRLCONIEXECHUB = "depositRLCOnIexecHub";

    public static final String FUNC_WITHDRAWRLCFROMIEXECHUB = "withdrawRLCFromIexecHub";

    public static final Event WORKORDERACTIVATED_EVENT = new Event("WorkOrderActivated", 
            Arrays.<TypeReference<?>>asList(),
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
    ;

    public static final Event WITHDRAWRLCFROMIEXECAPI_EVENT = new Event("WithdrawRLCFromIexecAPI", 
            Arrays.<TypeReference<?>>asList(),
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event APPROVEIEXECHUB_EVENT = new Event("ApproveIexecHub", 
            Arrays.<TypeReference<?>>asList(),
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event DEPOSITRLCONIEXECHUB_EVENT = new Event("DepositRLCOnIexecHub", 
            Arrays.<TypeReference<?>>asList(),
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event WITHDRAWRLCFROMIEXECHUB_EVENT = new Event("WithdrawRLCFromIexecHub", 
            Arrays.<TypeReference<?>>asList(),
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event WORKORDERCALLBACK_EVENT = new Event("WorkOrderCallback", 
            Arrays.<TypeReference<?>>asList(),
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}));
    ;

    public static final Event OWNERSHIPTRANSFERRED_EVENT = new Event("OwnershipTransferred", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}),
            Arrays.<TypeReference<?>>asList());
    ;

    protected static final HashMap<String, String> _addresses;

    static {
        _addresses = new HashMap<String, String>();
    }

    protected IexecAPI(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected IexecAPI(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public RemoteCall<TransactionReceipt> setImmutableOwnership(String _newOwner) {
        final Function function = new Function(
                FUNC_SETIMMUTABLEOWNERSHIP, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_newOwner)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<String> m_callbackProofAddress() {
        final Function function = new Function(FUNC_M_CALLBACKPROOFADDRESS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<String> m_owner() {
        final Function function = new Function(FUNC_M_OWNER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<Boolean> m_changeable() {
        final Function function = new Function(FUNC_M_CHANGEABLE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public static RemoteCall<IexecAPI> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String _iexecHubAddress, String _callbackProofAddress) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_iexecHubAddress), 
                new org.web3j.abi.datatypes.Address(_callbackProofAddress)));
        return deployRemoteCall(IexecAPI.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static RemoteCall<IexecAPI> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String _iexecHubAddress, String _callbackProofAddress) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_iexecHubAddress), 
                new org.web3j.abi.datatypes.Address(_callbackProofAddress)));
        return deployRemoteCall(IexecAPI.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public List<WorkOrderActivatedEventResponse> getWorkOrderActivatedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(WORKORDERACTIVATED_EVENT, transactionReceipt);
        ArrayList<WorkOrderActivatedEventResponse> responses = new ArrayList<WorkOrderActivatedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            WorkOrderActivatedEventResponse typedResponse = new WorkOrderActivatedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.woid = (String) eventValues.getNonIndexedValues().get(0).getValue();
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
                typedResponse.woid = (String) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Observable<WorkOrderActivatedEventResponse> workOrderActivatedEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(WORKORDERACTIVATED_EVENT));
        return workOrderActivatedEventObservable(filter);
    }

    public List<WithdrawRLCFromIexecAPIEventResponse> getWithdrawRLCFromIexecAPIEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(WITHDRAWRLCFROMIEXECAPI_EVENT, transactionReceipt);
        ArrayList<WithdrawRLCFromIexecAPIEventResponse> responses = new ArrayList<WithdrawRLCFromIexecAPIEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            WithdrawRLCFromIexecAPIEventResponse typedResponse = new WithdrawRLCFromIexecAPIEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.to = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<WithdrawRLCFromIexecAPIEventResponse> withdrawRLCFromIexecAPIEventObservable(EthFilter filter) {
        return web3j.ethLogObservable(filter).map(new Func1<Log, WithdrawRLCFromIexecAPIEventResponse>() {
            @Override
            public WithdrawRLCFromIexecAPIEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(WITHDRAWRLCFROMIEXECAPI_EVENT, log);
                WithdrawRLCFromIexecAPIEventResponse typedResponse = new WithdrawRLCFromIexecAPIEventResponse();
                typedResponse.log = log;
                typedResponse.to = (String) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Observable<WithdrawRLCFromIexecAPIEventResponse> withdrawRLCFromIexecAPIEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(WITHDRAWRLCFROMIEXECAPI_EVENT));
        return withdrawRLCFromIexecAPIEventObservable(filter);
    }

    public List<ApproveIexecHubEventResponse> getApproveIexecHubEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(APPROVEIEXECHUB_EVENT, transactionReceipt);
        ArrayList<ApproveIexecHubEventResponse> responses = new ArrayList<ApproveIexecHubEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            ApproveIexecHubEventResponse typedResponse = new ApproveIexecHubEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.iexecHub = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<ApproveIexecHubEventResponse> approveIexecHubEventObservable(EthFilter filter) {
        return web3j.ethLogObservable(filter).map(new Func1<Log, ApproveIexecHubEventResponse>() {
            @Override
            public ApproveIexecHubEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(APPROVEIEXECHUB_EVENT, log);
                ApproveIexecHubEventResponse typedResponse = new ApproveIexecHubEventResponse();
                typedResponse.log = log;
                typedResponse.iexecHub = (String) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Observable<ApproveIexecHubEventResponse> approveIexecHubEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(APPROVEIEXECHUB_EVENT));
        return approveIexecHubEventObservable(filter);
    }

    public List<DepositRLCOnIexecHubEventResponse> getDepositRLCOnIexecHubEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(DEPOSITRLCONIEXECHUB_EVENT, transactionReceipt);
        ArrayList<DepositRLCOnIexecHubEventResponse> responses = new ArrayList<DepositRLCOnIexecHubEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            DepositRLCOnIexecHubEventResponse typedResponse = new DepositRLCOnIexecHubEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.iexecHub = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<DepositRLCOnIexecHubEventResponse> depositRLCOnIexecHubEventObservable(EthFilter filter) {
        return web3j.ethLogObservable(filter).map(new Func1<Log, DepositRLCOnIexecHubEventResponse>() {
            @Override
            public DepositRLCOnIexecHubEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(DEPOSITRLCONIEXECHUB_EVENT, log);
                DepositRLCOnIexecHubEventResponse typedResponse = new DepositRLCOnIexecHubEventResponse();
                typedResponse.log = log;
                typedResponse.iexecHub = (String) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Observable<DepositRLCOnIexecHubEventResponse> depositRLCOnIexecHubEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(DEPOSITRLCONIEXECHUB_EVENT));
        return depositRLCOnIexecHubEventObservable(filter);
    }

    public List<WithdrawRLCFromIexecHubEventResponse> getWithdrawRLCFromIexecHubEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(WITHDRAWRLCFROMIEXECHUB_EVENT, transactionReceipt);
        ArrayList<WithdrawRLCFromIexecHubEventResponse> responses = new ArrayList<WithdrawRLCFromIexecHubEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            WithdrawRLCFromIexecHubEventResponse typedResponse = new WithdrawRLCFromIexecHubEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.iexecHub = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<WithdrawRLCFromIexecHubEventResponse> withdrawRLCFromIexecHubEventObservable(EthFilter filter) {
        return web3j.ethLogObservable(filter).map(new Func1<Log, WithdrawRLCFromIexecHubEventResponse>() {
            @Override
            public WithdrawRLCFromIexecHubEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(WITHDRAWRLCFROMIEXECHUB_EVENT, log);
                WithdrawRLCFromIexecHubEventResponse typedResponse = new WithdrawRLCFromIexecHubEventResponse();
                typedResponse.log = log;
                typedResponse.iexecHub = (String) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Observable<WithdrawRLCFromIexecHubEventResponse> withdrawRLCFromIexecHubEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(WITHDRAWRLCFROMIEXECHUB_EVENT));
        return withdrawRLCFromIexecHubEventObservable(filter);
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

    public List<OwnershipTransferredEventResponse> getOwnershipTransferredEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(OWNERSHIPTRANSFERRED_EVENT, transactionReceipt);
        ArrayList<OwnershipTransferredEventResponse> responses = new ArrayList<OwnershipTransferredEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            OwnershipTransferredEventResponse typedResponse = new OwnershipTransferredEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.previousOwner = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.newOwner = (String) eventValues.getIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<OwnershipTransferredEventResponse> ownershipTransferredEventObservable(EthFilter filter) {
        return web3j.ethLogObservable(filter).map(new Func1<Log, OwnershipTransferredEventResponse>() {
            @Override
            public OwnershipTransferredEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(OWNERSHIPTRANSFERRED_EVENT, log);
                OwnershipTransferredEventResponse typedResponse = new OwnershipTransferredEventResponse();
                typedResponse.log = log;
                typedResponse.previousOwner = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.newOwner = (String) eventValues.getIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Observable<OwnershipTransferredEventResponse> ownershipTransferredEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(OWNERSHIPTRANSFERRED_EVENT));
        return ownershipTransferredEventObservable(filter);
    }

    public RemoteCall<TransactionReceipt> buyForWorkOrder(BigInteger _marketorderIdx, String _workerpool, String _app, String _dataset, String _params, String _callback, String _beneficiary) {
        final Function function = new Function(
                FUNC_BUYFORWORKORDER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_marketorderIdx), 
                new org.web3j.abi.datatypes.Address(_workerpool), 
                new org.web3j.abi.datatypes.Address(_app), 
                new org.web3j.abi.datatypes.Address(_dataset), 
                new org.web3j.abi.datatypes.Utf8String(_params), 
                new org.web3j.abi.datatypes.Address(_callback), 
                new org.web3j.abi.datatypes.Address(_beneficiary)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
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

    public RemoteCall<TransactionReceipt> approveIexecHub(BigInteger amount) {
        final Function function = new Function(
                FUNC_APPROVEIEXECHUB, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(amount)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> withdrawRLCFromIexecAPI(BigInteger amount) {
        final Function function = new Function(
                FUNC_WITHDRAWRLCFROMIEXECAPI, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(amount)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> depositRLCOnIexecHub(BigInteger amount) {
        final Function function = new Function(
                FUNC_DEPOSITRLCONIEXECHUB, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(amount)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> withdrawRLCFromIexecHub(BigInteger amount) {
        final Function function = new Function(
                FUNC_WITHDRAWRLCFROMIEXECHUB, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(amount)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public static IexecAPI load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new IexecAPI(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static IexecAPI load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new IexecAPI(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected String getStaticDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static String getPreviouslyDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static class WorkOrderActivatedEventResponse {
        public Log log;

        public String woid;
    }

    public static class WithdrawRLCFromIexecAPIEventResponse {
        public Log log;

        public String to;

        public BigInteger amount;
    }

    public static class ApproveIexecHubEventResponse {
        public Log log;

        public String iexecHub;

        public BigInteger amount;
    }

    public static class DepositRLCOnIexecHubEventResponse {
        public Log log;

        public String iexecHub;

        public BigInteger amount;
    }

    public static class WithdrawRLCFromIexecHubEventResponse {
        public Log log;

        public String iexecHub;

        public BigInteger amount;
    }

    public static class WorkOrderCallbackEventResponse {
        public Log log;

        public String woid;

        public String stdout;

        public String stderr;

        public String uri;
    }

    public static class OwnershipTransferredEventResponse {
        public Log log;

        public String previousOwner;

        public String newOwner;
    }
}
