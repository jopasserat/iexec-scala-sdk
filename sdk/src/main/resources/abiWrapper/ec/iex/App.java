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
 * <p>Generated with web3j version 3.5.0.
 */
public class App extends Contract {
    private static final String BINARY = "0x6060604052341561000f57600080fd5b6040516106733803806106738339810160405280805191906020018051820191906020018051919060200180516000805460a060020a60ff0219600160a060020a03338116600160a060020a0319909316929092171674010000000000000000000000000000000000000000179091559201918591508116151561009257600080fd5b60018054600160a060020a031916600160a060020a039283161790553381163290911614156100c057600080fd5b6100d6326401000000006102c461010c82021704565b60028380516100e99291602001906101cd565b50600382905560048180516101029291602001906101cd565b5050505050610268565b60005433600160a060020a0390811691161461012757600080fd5b60005474010000000000000000000000000000000000000000900460ff16151561015057600080fd5b600160a060020a038116151561016557600080fd5b600054600160a060020a0380831691167f8be0079c531659141344cd1fd0a4f28419497f9722a3daafe3b4186f6b6457e060405160405180910390a360008054600160a060020a031916600160a060020a03929092169190911760a060020a60ff0219169055565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f1061020e57805160ff191683800117855561023b565b8280016001018555821561023b579182015b8281111561023b578251825591602001919060010190610220565b5061024792915061024b565b5090565b61026591905b808211156102475760008155600101610251565b90565b6103fc806102776000396000f3006060604052600436106100775763ffffffff7c010000000000000000000000000000000000000000000000000000000060003504166326137e6b811461007c578063358982a3146100a157806388fc56c01461012b578063bbac78a91461013e578063deff41c11461015f578063e21b9d081461018e575b600080fd5b341561008757600080fd5b61008f6101b5565b60405190815260200160405180910390f35b34156100ac57600080fd5b6100b46101bb565b60405160208082528190810183818151815260200191508051906020019080838360005b838110156100f05780820151838201526020016100d8565b50505050905090810190601f16801561011d5780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b341561013657600080fd5b6100b4610259565b341561014957600080fd5b61015d600160a060020a03600435166102c4565b005b341561016a57600080fd5b6101726103a0565b604051600160a060020a03909116815260200160405180910390f35b341561019957600080fd5b6101a16103af565b604051901515815260200160405180910390f35b60035481565b60028054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156102515780601f1061022657610100808354040283529160200191610251565b820191906000526020600020905b81548152906001019060200180831161023457829003601f168201915b505050505081565b60048054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156102515780601f1061022657610100808354040283529160200191610251565b60005433600160a060020a039081169116146102df57600080fd5b60005474010000000000000000000000000000000000000000900460ff16151561030857600080fd5b600160a060020a038116151561031d57600080fd5b600054600160a060020a0380831691167f8be0079c531659141344cd1fd0a4f28419497f9722a3daafe3b4186f6b6457e060405160405180910390a36000805473ffffffffffffffffffffffffffffffffffffffff1916600160a060020a03929092169190911774ff000000000000000000000000000000000000000019169055565b600054600160a060020a031681565b60005474010000000000000000000000000000000000000000900460ff16815600a165627a7a723058206d99b62a46fd6c98aa2d6fdc4f0dc4efd9a258d38aa451bf0086c59b301c301c0029";

    public static final String FUNC_M_APPPRICE = "m_appPrice";

    public static final String FUNC_M_APPNAME = "m_appName";

    public static final String FUNC_M_APPPARAMS = "m_appParams";

    public static final String FUNC_SETIMMUTABLEOWNERSHIP = "setImmutableOwnership";

    public static final String FUNC_M_OWNER = "m_owner";

    public static final String FUNC_M_CHANGEABLE = "m_changeable";

    public static final Event OWNERSHIPTRANSFERRED_EVENT = new Event("OwnershipTransferred", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}));
    ;

    protected static final HashMap<String, String> _addresses;

    static {
        _addresses = new HashMap<String, String>();
    }

    protected App(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected App(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public RemoteCall<BigInteger> m_appPrice() {
        final Function function = new Function(FUNC_M_APPPRICE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<String> m_appName() {
        final Function function = new Function(FUNC_M_APPNAME, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<String> m_appParams() {
        final Function function = new Function(FUNC_M_APPPARAMS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> setImmutableOwnership(String _newOwner) {
        final Function function = new Function(
                FUNC_SETIMMUTABLEOWNERSHIP, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_newOwner)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
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

    public static RemoteCall<App> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String _iexecHubAddress, String _appName, BigInteger _appPrice, String _appParams) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_iexecHubAddress), 
                new org.web3j.abi.datatypes.Utf8String(_appName), 
                new org.web3j.abi.datatypes.generated.Uint256(_appPrice), 
                new org.web3j.abi.datatypes.Utf8String(_appParams)));
        return deployRemoteCall(App.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static RemoteCall<App> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String _iexecHubAddress, String _appName, BigInteger _appPrice, String _appParams) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_iexecHubAddress), 
                new org.web3j.abi.datatypes.Utf8String(_appName), 
                new org.web3j.abi.datatypes.generated.Uint256(_appPrice), 
                new org.web3j.abi.datatypes.Utf8String(_appParams)));
        return deployRemoteCall(App.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
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

    public static App load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new App(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static App load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new App(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected String getStaticDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static String getPreviouslyDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static class OwnershipTransferredEventResponse {
        public Log log;

        public String previousOwner;

        public String newOwner;
    }
}
