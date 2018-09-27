package ec.iex;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Callable;
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
import org.web3j.abi.datatypes.generated.Uint8;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple8;
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
public class Marketplace extends Contract {
    private static final String BINARY = "0x6060604052341561000f57600080fd5b6040516020806112a6833981016040528080519150819050600160a060020a038116151561003c57600080fd5b60008054600160a060020a03909216600160a060020a0319909216919091179055506112398061006d6000396000f3006060604052600436106100b65763ffffffff60e060020a60003504166302a63c2881146100bb57806324026bfb146100f7578063270a8ef71461011f57806338c4090b146101355780633ab679561461014b5780634cfddcfb146101c2578063514d7067146101d857806355d66c3e146102bd57806360f75f3b146102ef57806369c7c180146103055780636b14ea361461031857806397e645f31461032b578063ea0b25901461034a578063eb3721be1461037b575b600080fd5b34156100c657600080fd5b6100e3600435600160a060020a0360243581169060443516610391565b604051901515815260200160405180910390f35b341561010257600080fd5b61010d600435610508565b60405190815260200160405180910390f35b341561012a57600080fd5b6100e3600435610535565b341561014057600080fd5b61010d60043561054b565b341561015657600080fd5b610161600435610577565b6040518089600381111561017157fe5b60ff1681526020810198909852506040808801969096526060870194909452608086019290925260a0850152600160a060020a0390811660c08501521660e083015261010090910191505180910390f35b34156101cd57600080fd5b61010d6004356105cc565b34156101e357600080fd5b6102bb60048035600160a060020a03169060446024803590810190830135806020601f8201819004810201604051908101604052818152929190602084018383808284378201915050505050509190803590602001908201803590602001908080601f01602080910402602001604051908101604052818152929190602084018383808284378201915050505050509190803590602001908201803590602001908080601f0160208091040260200160405190810160405281815292919060208401838380828437509496506105f895505050505050565b005b34156102c857600080fd5b6102d3600435610cde565b604051600160a060020a03909116815260200160405180910390f35b34156102fa57600080fd5b6100e3600435610d13565b341561031057600080fd5b61010d610e4a565b341561032357600080fd5b61010d610e50565b341561033657600080fd5b6100e3600160a060020a0360043516610e55565b341561035557600080fd5b61010d60ff60043516602435604435606435600160a060020a036084351660a435610e73565b341561038657600080fd5b6101616004356110ee565b60008054819033600160a060020a039081169116146103af57600080fd5b50600084815260026020819052604090912090815460ff1660038111156103d257fe5b146103dc57600080fd5b6005810154600090116103ee57600080fd5b6006810154600160a060020a0384811691161461040a57600080fd5b600581015461042090600163ffffffff61116d16565b60058201819055151561043957805460ff191660031781555b6000546003820154600160a060020a039091169063ac26109e90869060405160e060020a63ffffffff8516028152600160a060020a0390921660048301526024820152604401602060405180830381600087803b151561049857600080fd5b5af115156104a557600080fd5b5050506040518051905015156104ba57600080fd5b7fe15b7f1dd90867f2f9084033184322ae15a1572828d3d2a5a2dca5f6038332ba8585604051918252600160a060020a031660208201526040908101905180910390a1506001949350505050565b600061051382610535565b151561051e57600080fd5b506000908152600260208190526040909120015490565b6000908152600260205260408120600101541190565b600061055682610535565b151561056157600080fd5b5060009081526002602052604090206003015490565b60026020819052600091825260409091208054600182015492820154600383015460048401546005850154600686015460079096015460ff90951696959394929391929091600160a060020a03908116911688565b60006105d782610535565b15156105e257600080fd5b5060009081526002602052604090206001015490565b60008054600160a060020a03166332ca55878660405160e060020a63ffffffff8416028152600160a060020a039091166004820152602401602060405180830381600087803b151561064957600080fd5b5af1151561065657600080fd5b50505060405180519050151561066b57600080fd5b61067485610e55565b1561067e57600080fd5b600160a060020a0385166000908152600360205260409020805460ff19166001179055600485600160a060020a031663e329c4786040518163ffffffff1660e060020a028152600401602060405180830381600087803b15156106e057600080fd5b5af115156106ed57600080fd5b50505060405180519050600481111561070257fe5b1461070c57600080fd5b8383836040518084805190602001908083835b6020831061073e5780518252601f19909201916020918201910161071f565b6001836020036101000a038019825116818451161790925250505091909101905083805190602001908083835b6020831061078a5780518252601f19909201916020918201910161076b565b6001836020036101000a038019825116818451161790925250505091909101905082805190602001908083835b602083106107d65780518252601f1990920191602091820191016107b7565b6001836020036101000a03801982511681845116179092525050509190910194506040935050505051908190039020600160a060020a03861663d3281fd66040518163ffffffff1660e060020a028152600401602060405180830381600087803b151561084257600080fd5b5af1151561084f57600080fd5b505050604051805191909114905061086657600080fd5b84600160a060020a031663da1fea286040518163ffffffff1660e060020a028152600401602060405180830381600087803b15156108a357600080fd5b5af115156108b057600080fd5b5050506040518051915050600160a060020a03811615156108d057600080fd5b80600160a060020a031663514d7067868686866040518563ffffffff1660e060020a0281526004018085600160a060020a0316600160a060020a03168152602001806020018060200180602001848103845287818151815260200191508051906020019080838360005b8381101561095257808201518382015260200161093a565b50505050905090810190601f16801561097f5780820380516001836020036101000a031916815260200191505b50848103835286818151815260200191508051906020019080838360005b838110156109b557808201518382015260200161099d565b50505050905090810190601f1680156109e25780820380516001836020036101000a031916815260200191505b50848103825285818151815260200191508051906020019080838360005b83811015610a18578082015183820152602001610a00565b50505050905090810190601f168015610a455780820380516001836020036101000a031916815260200191505b50975050505050505050602060405180830381600087803b1515610a6857600080fd5b5af11515610a7557600080fd5b505050604051805190501515610a8a57600080fd5b32600160a060020a031681600160a060020a031686600160a060020a03167ffaa5bd626c00cd99117399c04259a0d49a005fdde47f67ed013a1f473a49587088600160a060020a0316635f44910c6040518163ffffffff1660e060020a028152600401602060405180830381600087803b1515610b0657600080fd5b5af11515610b1357600080fd5b5050506040518051905089600160a060020a031663f6a5b13e6040518163ffffffff1660e060020a028152600401602060405180830381600087803b1515610b5a57600080fd5b5af11515610b6757600080fd5b50505060405180519050898989604051600160a060020a0380871682528516602082015260a0604082018181529060608301906080840190840187818151815260200191508051906020019080838360005b83811015610bd1578082015183820152602001610bb9565b50505050905090810190601f168015610bfe5780820380516001836020036101000a031916815260200191505b50848103835286818151815260200191508051906020019080838360005b83811015610c34578082015183820152602001610c1c565b50505050905090810190601f168015610c615780820380516001836020036101000a031916815260200191505b50848103825285818151815260200191508051906020019080838360005b83811015610c97578082015183820152602001610c7f565b50505050905090810190601f168015610cc45780820380516001836020036101000a031916815260200191505b509850505050505050505060405180910390a45050505050565b6000610ce982610535565b1515610cf457600080fd5b50600090815260026020526040902060070154600160a060020a031690565b6000818152600260208190526040822090815460ff166003811115610d3457fe5b14156100b657600781015433600160a060020a03908116911614610d5757600080fd5b600054600782015460058301546003840154600160a060020a039384169363b7b6e978931691610d9e91610d9290601e63ffffffff61117f16565b9063ffffffff61119416565b60405160e060020a63ffffffff8516028152600160a060020a0390921660048301526024820152604401602060405180830381600087803b1515610de157600080fd5b5af11515610dee57600080fd5b505050604051805190501515610e0357600080fd5b805460ff191660031781557f9a05087bc2e92d4e31e031af3ffb9da7e4dffd4be5573811330541cc559315fe8360405190815260200160405180910390a150600192915050565b60015481565b601e81565b600160a060020a031660009081526003602052604090205460ff1690565b600080548190600160a060020a03166332baa8d98860405160e060020a63ffffffff84160281526004810191909152602401602060405180830381600087803b1515610ebe57600080fd5b5af11515610ecb57600080fd5b505050604051805190501515610ee057600080fd5b60008311610eed57600080fd5b60018054610f009163ffffffff6111ca16565b600181815560009182526002602052604090912080549092508991839160ff191690836003811115610f2e57fe5b0217905550600181018790556002808201879055600382018690556004820184905560058201849055886003811115610f6357fe5b14156100b65733600160a060020a031684600160a060020a031663deff41c16040518163ffffffff1660e060020a028152600401602060405180830381600087803b1515610fb057600080fd5b5af11515610fbd57600080fd5b50505060405180519050600160a060020a0316141515610fdc57600080fd5b600054600160a060020a031663ac26109e3361100386610d928a601e63ffffffff61117f16565b60405160e060020a63ffffffff8516028152600160a060020a0390921660048301526024820152604401602060405180830381600087803b151561104657600080fd5b5af1151561105357600080fd5b50505060405180519050151561106857600080fd5b600681018054600160a060020a0380871673ffffffffffffffffffffffffffffffffffffffff199283161790925560078301805433909316929091169190911790557fb0be9c5566c7b426b2e5378a75c24af27818f33e0b6aa5ea6208562c144c98f160015460405190815260200160405180910390a150506001549695505050505050565b60008060008060008060008060006111058a610535565b151561111057600080fd5b505050600096875250506002602081905260409095208054600182015496820154600383015460048401546005850154600686015460079096015460ff9095169b93995091975095509350600160a060020a039283169290911690565b60008282111561117957fe5b50900390565b600061118d838360646111d9565b9392505050565b6000808315156111a757600091506111c3565b508282028284828115156111b757fe5b04146111bf57fe5b8091505b5092915050565b6000828201838110156111bf57fe5b60006111ee6111e88585611194565b836111f6565b949350505050565b600080828481151561120457fe5b049493505050505600a165627a7a72305820b668c5108a5814f2559e74c0479fac009c4511209da1afccf95c8e16c36ab40e0029";

    public static final String FUNC_M_ORDERBOOK = "m_orderBook";

    public static final String FUNC_M_ORDERCOUNT = "m_orderCount";

    public static final String FUNC_ASK_STAKE_RATIO = "ASK_STAKE_RATIO";

    public static final String FUNC_CREATEMARKETORDER = "createMarketOrder";

    public static final String FUNC_CLOSEMARKETORDER = "closeMarketOrder";

    public static final String FUNC_CONSUMEMARKETORDERASK = "consumeMarketOrderAsk";

    public static final String FUNC_EXISTINGMARKETORDER = "existingMarketOrder";

    public static final String FUNC_GETMARKETORDERVALUE = "getMarketOrderValue";

    public static final String FUNC_GETMARKETORDERWORKERPOOLOWNER = "getMarketOrderWorkerpoolOwner";

    public static final String FUNC_GETMARKETORDERCATEGORY = "getMarketOrderCategory";

    public static final String FUNC_GETMARKETORDERTRUST = "getMarketOrderTrust";

    public static final String FUNC_GETMARKETORDER = "getMarketOrder";

    public static final String FUNC_ISCALLBACKDONE = "isCallbackDone";

    public static final String FUNC_WORKORDERCALLBACK = "workOrderCallback";

    public static final Event MARKETORDERCREATED_EVENT = new Event("MarketOrderCreated", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
    ;

    public static final Event MARKETORDERCLOSED_EVENT = new Event("MarketOrderClosed", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
    ;

    public static final Event MARKETORDERASKCONSUME_EVENT = new Event("MarketOrderAskConsume", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Address>() {}));
    ;

    public static final Event WORKORDERCALLBACKPROOF_EVENT = new Event("WorkOrderCallbackProof", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>() {}, new TypeReference<Address>() {}, new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}));
    ;

    protected static final HashMap<String, String> _addresses;

    static {
        _addresses = new HashMap<String, String>();
        _addresses.put("1", "0xfb7703c74f14930f8871c34056d5db6693e5a00b");
        _addresses.put("3", "0xc65b1643b8a6a2ba8fe70310be82689f8563917e");
        _addresses.put("4", "0x2a6a5a0516add25dda891e4afdfc15cbcdf21643");
        _addresses.put("42", "0x9315a6ae9a9842bcb5ad8f5d43a4271d297088e2");
    }

    protected Marketplace(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Marketplace(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public RemoteCall<Tuple8<BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, String, String>> m_orderBook(BigInteger param0) {
        final Function function = new Function(FUNC_M_ORDERBOOK, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint8>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Address>() {}, new TypeReference<Address>() {}));
        return new RemoteCall<Tuple8<BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, String, String>>(
                new Callable<Tuple8<BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, String, String>>() {
                    @Override
                    public Tuple8<BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, String, String> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple8<BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, String, String>(
                                (BigInteger) results.get(0).getValue(), 
                                (BigInteger) results.get(1).getValue(), 
                                (BigInteger) results.get(2).getValue(), 
                                (BigInteger) results.get(3).getValue(), 
                                (BigInteger) results.get(4).getValue(), 
                                (BigInteger) results.get(5).getValue(), 
                                (String) results.get(6).getValue(), 
                                (String) results.get(7).getValue());
                    }
                });
    }

    public RemoteCall<BigInteger> m_orderCount() {
        final Function function = new Function(FUNC_M_ORDERCOUNT, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> ASK_STAKE_RATIO() {
        final Function function = new Function(FUNC_ASK_STAKE_RATIO, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public static RemoteCall<Marketplace> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String _iexecHubAddress) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_iexecHubAddress)));
        return deployRemoteCall(Marketplace.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static RemoteCall<Marketplace> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String _iexecHubAddress) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_iexecHubAddress)));
        return deployRemoteCall(Marketplace.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public List<MarketOrderCreatedEventResponse> getMarketOrderCreatedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(MARKETORDERCREATED_EVENT, transactionReceipt);
        ArrayList<MarketOrderCreatedEventResponse> responses = new ArrayList<MarketOrderCreatedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            MarketOrderCreatedEventResponse typedResponse = new MarketOrderCreatedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.marketorderIdx = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<MarketOrderCreatedEventResponse> marketOrderCreatedEventObservable(EthFilter filter) {
        return web3j.ethLogObservable(filter).map(new Func1<Log, MarketOrderCreatedEventResponse>() {
            @Override
            public MarketOrderCreatedEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(MARKETORDERCREATED_EVENT, log);
                MarketOrderCreatedEventResponse typedResponse = new MarketOrderCreatedEventResponse();
                typedResponse.log = log;
                typedResponse.marketorderIdx = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Observable<MarketOrderCreatedEventResponse> marketOrderCreatedEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(MARKETORDERCREATED_EVENT));
        return marketOrderCreatedEventObservable(filter);
    }

    public List<MarketOrderClosedEventResponse> getMarketOrderClosedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(MARKETORDERCLOSED_EVENT, transactionReceipt);
        ArrayList<MarketOrderClosedEventResponse> responses = new ArrayList<MarketOrderClosedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            MarketOrderClosedEventResponse typedResponse = new MarketOrderClosedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.marketorderIdx = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<MarketOrderClosedEventResponse> marketOrderClosedEventObservable(EthFilter filter) {
        return web3j.ethLogObservable(filter).map(new Func1<Log, MarketOrderClosedEventResponse>() {
            @Override
            public MarketOrderClosedEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(MARKETORDERCLOSED_EVENT, log);
                MarketOrderClosedEventResponse typedResponse = new MarketOrderClosedEventResponse();
                typedResponse.log = log;
                typedResponse.marketorderIdx = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Observable<MarketOrderClosedEventResponse> marketOrderClosedEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(MARKETORDERCLOSED_EVENT));
        return marketOrderClosedEventObservable(filter);
    }

    public List<MarketOrderAskConsumeEventResponse> getMarketOrderAskConsumeEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(MARKETORDERASKCONSUME_EVENT, transactionReceipt);
        ArrayList<MarketOrderAskConsumeEventResponse> responses = new ArrayList<MarketOrderAskConsumeEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            MarketOrderAskConsumeEventResponse typedResponse = new MarketOrderAskConsumeEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.marketorderIdx = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.requester = (String) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<MarketOrderAskConsumeEventResponse> marketOrderAskConsumeEventObservable(EthFilter filter) {
        return web3j.ethLogObservable(filter).map(new Func1<Log, MarketOrderAskConsumeEventResponse>() {
            @Override
            public MarketOrderAskConsumeEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(MARKETORDERASKCONSUME_EVENT, log);
                MarketOrderAskConsumeEventResponse typedResponse = new MarketOrderAskConsumeEventResponse();
                typedResponse.log = log;
                typedResponse.marketorderIdx = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.requester = (String) eventValues.getNonIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Observable<MarketOrderAskConsumeEventResponse> marketOrderAskConsumeEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(MARKETORDERASKCONSUME_EVENT));
        return marketOrderAskConsumeEventObservable(filter);
    }

    public List<WorkOrderCallbackProofEventResponse> getWorkOrderCallbackProofEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(WORKORDERCALLBACKPROOF_EVENT, transactionReceipt);
        ArrayList<WorkOrderCallbackProofEventResponse> responses = new ArrayList<WorkOrderCallbackProofEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            WorkOrderCallbackProofEventResponse typedResponse = new WorkOrderCallbackProofEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.woid = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.callbackTo = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.gasCallbackProvider = (String) eventValues.getIndexedValues().get(2).getValue();
            typedResponse.requester = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.beneficiary = (String) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.stdout = (String) eventValues.getNonIndexedValues().get(2).getValue();
            typedResponse.stderr = (String) eventValues.getNonIndexedValues().get(3).getValue();
            typedResponse.uri = (String) eventValues.getNonIndexedValues().get(4).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<WorkOrderCallbackProofEventResponse> workOrderCallbackProofEventObservable(EthFilter filter) {
        return web3j.ethLogObservable(filter).map(new Func1<Log, WorkOrderCallbackProofEventResponse>() {
            @Override
            public WorkOrderCallbackProofEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(WORKORDERCALLBACKPROOF_EVENT, log);
                WorkOrderCallbackProofEventResponse typedResponse = new WorkOrderCallbackProofEventResponse();
                typedResponse.log = log;
                typedResponse.woid = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.callbackTo = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.gasCallbackProvider = (String) eventValues.getIndexedValues().get(2).getValue();
                typedResponse.requester = (String) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.beneficiary = (String) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse.stdout = (String) eventValues.getNonIndexedValues().get(2).getValue();
                typedResponse.stderr = (String) eventValues.getNonIndexedValues().get(3).getValue();
                typedResponse.uri = (String) eventValues.getNonIndexedValues().get(4).getValue();
                return typedResponse;
            }
        });
    }

    public Observable<WorkOrderCallbackProofEventResponse> workOrderCallbackProofEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(WORKORDERCALLBACKPROOF_EVENT));
        return workOrderCallbackProofEventObservable(filter);
    }

    public RemoteCall<TransactionReceipt> createMarketOrder(BigInteger _direction, BigInteger _category, BigInteger _trust, BigInteger _value, String _workerpool, BigInteger _volume) {
        final Function function = new Function(
                FUNC_CREATEMARKETORDER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint8(_direction), 
                new org.web3j.abi.datatypes.generated.Uint256(_category), 
                new org.web3j.abi.datatypes.generated.Uint256(_trust), 
                new org.web3j.abi.datatypes.generated.Uint256(_value), 
                new org.web3j.abi.datatypes.Address(_workerpool), 
                new org.web3j.abi.datatypes.generated.Uint256(_volume)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> closeMarketOrder(BigInteger _marketorderIdx) {
        final Function function = new Function(
                FUNC_CLOSEMARKETORDER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_marketorderIdx)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> consumeMarketOrderAsk(BigInteger _marketorderIdx, String _requester, String _workerpool) {
        final Function function = new Function(
                FUNC_CONSUMEMARKETORDERASK, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_marketorderIdx), 
                new org.web3j.abi.datatypes.Address(_requester), 
                new org.web3j.abi.datatypes.Address(_workerpool)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<Boolean> existingMarketOrder(BigInteger _marketorderIdx) {
        final Function function = new Function(FUNC_EXISTINGMARKETORDER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_marketorderIdx)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteCall<BigInteger> getMarketOrderValue(BigInteger _marketorderIdx) {
        final Function function = new Function(FUNC_GETMARKETORDERVALUE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_marketorderIdx)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<String> getMarketOrderWorkerpoolOwner(BigInteger _marketorderIdx) {
        final Function function = new Function(FUNC_GETMARKETORDERWORKERPOOLOWNER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_marketorderIdx)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<BigInteger> getMarketOrderCategory(BigInteger _marketorderIdx) {
        final Function function = new Function(FUNC_GETMARKETORDERCATEGORY, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_marketorderIdx)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> getMarketOrderTrust(BigInteger _marketorderIdx) {
        final Function function = new Function(FUNC_GETMARKETORDERTRUST, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_marketorderIdx)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<Tuple8<BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, String, String>> getMarketOrder(BigInteger _marketorderIdx) {
        final Function function = new Function(FUNC_GETMARKETORDER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_marketorderIdx)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint8>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Address>() {}, new TypeReference<Address>() {}));
        return new RemoteCall<Tuple8<BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, String, String>>(
                new Callable<Tuple8<BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, String, String>>() {
                    @Override
                    public Tuple8<BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, String, String> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple8<BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, String, String>(
                                (BigInteger) results.get(0).getValue(), 
                                (BigInteger) results.get(1).getValue(), 
                                (BigInteger) results.get(2).getValue(), 
                                (BigInteger) results.get(3).getValue(), 
                                (BigInteger) results.get(4).getValue(), 
                                (BigInteger) results.get(5).getValue(), 
                                (String) results.get(6).getValue(), 
                                (String) results.get(7).getValue());
                    }
                });
    }

    public RemoteCall<Boolean> isCallbackDone(String _woid) {
        final Function function = new Function(FUNC_ISCALLBACKDONE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_woid)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
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

    public static Marketplace load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Marketplace(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static Marketplace load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Marketplace(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected String getStaticDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static String getPreviouslyDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static class MarketOrderCreatedEventResponse {
        public Log log;

        public BigInteger marketorderIdx;
    }

    public static class MarketOrderClosedEventResponse {
        public Log log;

        public BigInteger marketorderIdx;
    }

    public static class MarketOrderAskConsumeEventResponse {
        public Log log;

        public BigInteger marketorderIdx;

        public String requester;
    }

    public static class WorkOrderCallbackProofEventResponse {
        public Log log;

        public String woid;

        public String callbackTo;

        public String gasCallbackProvider;

        public String requester;

        public String beneficiary;

        public String stdout;

        public String stderr;

        public String uri;
    }
}
