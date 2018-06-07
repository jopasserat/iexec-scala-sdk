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
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
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
public class DatasetHub extends Contract {
    private static final String BINARY = "0x6060604052341561000f57600080fd5b6000805474010000000000000000000000000000000000000000600160a060020a031990911633600160a060020a03161760a060020a60ff021916178155610ca490819061005d90396000f3006060604052600436106100985763ffffffff7c010000000000000000000000000000000000000000000000000000000060003504166316265b4e811461009d5780632b58072f146100d057806331638ced14610101578063346461631461013357806339b7312214610155578063bbac78a9146101f1578063deff41c114610212578063e21b9d0814610225578063fbc09b2614610238575b600080fd5b34156100a857600080fd5b6100bc600160a060020a036004351661024b565b604051901515815260200160405180910390f35b34156100db57600080fd5b6100ef600160a060020a0360043516610269565b60405190815260200160405180910390f35b341561010c57600080fd5b610117600435610284565b604051600160a060020a03909116815260200160405180910390f35b341561013e57600080fd5b610117600160a060020a036004351660243561029f565b341561016057600080fd5b61011760046024813581810190830135806020601f8201819004810201604051908101604052818152929190602084018383808284378201915050505050509190803590602001909190803590602001908201803590602001908080601f0160208091040260200160405190810160405281815292919060208401838380828437509496506102c795505050505050565b34156101fc57600080fd5b610210600160a060020a0360043516610408565b005b341561021d57600080fd5b6101176104e4565b341561023057600080fd5b6100bc6104f3565b341561024357600080fd5b6100ef610514565b600160a060020a031660009081526003602052604090205460ff1690565b600160a060020a031660009081526001602052604090205490565b600090815260046020526040902054600160a060020a031690565b600160a060020a03918216600090815260026020908152604080832093835292905220541690565b60008054819033600160a060020a039081169116146102e557600080fd5b338585856102f16105f5565b600160a060020a038516815260408101839052608060208201818152906060830190830186818151815260200191508051906020019080838360005b8381101561034557808201518382015260200161032d565b50505050905090810190601f1680156103725780820380516001836020036101000a031916815260200191505b50838103825284818151815260200191508051906020019080838360005b838110156103a8578082015183820152602001610390565b50505050905090810190601f1680156103d55780820380516001836020036101000a031916815260200191505b509650505050505050604051809103906000f08015156103f457600080fd5b9050610400328261051a565b949350505050565b60005433600160a060020a0390811691161461042357600080fd5b60005474010000000000000000000000000000000000000000900460ff16151561044c57600080fd5b600160a060020a038116151561046157600080fd5b600054600160a060020a0380831691167f8be0079c531659141344cd1fd0a4f28419497f9722a3daafe3b4186f6b6457e060405160405180910390a36000805473ffffffffffffffffffffffffffffffffffffffff1916600160a060020a03929092169190911774ff000000000000000000000000000000000000000019169055565b600054600160a060020a031681565b60005474010000000000000000000000000000000000000000900460ff1681565b60055481565b600160a060020a03821660009081526001602081905260408220546105449163ffffffff6105df16565b60055490915061055b90600163ffffffff6105df16565b600581905560009081526004602090815260408083208054600160a060020a0396871673ffffffffffffffffffffffffffffffffffffffff199182168117909255969095168352600180835281842085905560028352818420948452938252808320805490961685179095559281526003909252919020805460ff19169091179055565b6000828201838110156105ee57fe5b9392505050565b604051610673806106068339019056006060604052341561000f57600080fd5b6040516106733803806106738339810160405280805191906020018051820191906020018051919060200180516000805460a060020a60ff0219600160a060020a03338116600160a060020a0319909316929092171674010000000000000000000000000000000000000000179091559201918591508116151561009257600080fd5b60018054600160a060020a031916600160a060020a039283161790553381163290911614156100c057600080fd5b6100d63264010000000061025961010c82021704565b60028380516100e99291602001906101cd565b50600382905560048180516101029291602001906101cd565b5050505050610268565b60005433600160a060020a0390811691161461012757600080fd5b60005474010000000000000000000000000000000000000000900460ff16151561015057600080fd5b600160a060020a038116151561016557600080fd5b600054600160a060020a0380831691167f8be0079c531659141344cd1fd0a4f28419497f9722a3daafe3b4186f6b6457e060405160405180910390a360008054600160a060020a031916600160a060020a03929092169190911760a060020a60ff0219169055565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f1061020e57805160ff191683800117855561023b565b8280016001018555821561023b579182015b8281111561023b578251825591602001919060010190610220565b5061024792915061024b565b5090565b61026591905b808211156102475760008155600101610251565b90565b6103fc806102776000396000f3006060604052600436106100775763ffffffff7c01000000000000000000000000000000000000000000000000000000006000350416630847c431811461007c57806362d598eb14610106578063bbac78a91461012b578063c2880e171461014c578063deff41c11461015f578063e21b9d081461018e575b600080fd5b341561008757600080fd5b61008f6101b5565b60405160208082528190810183818151815260200191508051906020019080838360005b838110156100cb5780820151838201526020016100b3565b50505050905090810190601f1680156100f85780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b341561011157600080fd5b610119610253565b60405190815260200160405180910390f35b341561013657600080fd5b61014a600160a060020a0360043516610259565b005b341561015757600080fd5b61008f610335565b341561016a57600080fd5b6101726103a0565b604051600160a060020a03909116815260200160405180910390f35b341561019957600080fd5b6101a16103af565b604051901515815260200160405180910390f35b60028054600181600116156101000203166002900480601f01602080910402602001604051908101604052809291908181526020018280546001816001161561010002031660029004801561024b5780601f106102205761010080835404028352916020019161024b565b820191906000526020600020905b81548152906001019060200180831161022e57829003601f168201915b505050505081565b60035481565b60005433600160a060020a0390811691161461027457600080fd5b60005474010000000000000000000000000000000000000000900460ff16151561029d57600080fd5b600160a060020a03811615156102b257600080fd5b600054600160a060020a0380831691167f8be0079c531659141344cd1fd0a4f28419497f9722a3daafe3b4186f6b6457e060405160405180910390a36000805473ffffffffffffffffffffffffffffffffffffffff1916600160a060020a03929092169190911774ff000000000000000000000000000000000000000019169055565b60048054600181600116156101000203166002900480601f01602080910402602001604051908101604052809291908181526020018280546001816001161561010002031660029004801561024b5780601f106102205761010080835404028352916020019161024b565b600054600160a060020a031681565b60005474010000000000000000000000000000000000000000900460ff16815600a165627a7a723058205ffc863a097aa3a9df8dcd15972d278d368758dd3e2a6e19a607a6f484d5c0b20029a165627a7a72305820c6b63c7fbf6b53812b0fa390d88c1f1cad0ed3058cd9658ae4a3300af6c840350029";

    public static final String FUNC_SETIMMUTABLEOWNERSHIP = "setImmutableOwnership";

    public static final String FUNC_M_OWNER = "m_owner";

    public static final String FUNC_M_CHANGEABLE = "m_changeable";

    public static final String FUNC_M_TOTALDATASETCOUNT = "m_totalDatasetCount";

    public static final String FUNC_ISDATASETREGISTRED = "isDatasetRegistred";

    public static final String FUNC_GETDATASETSCOUNT = "getDatasetsCount";

    public static final String FUNC_GETDATASET = "getDataset";

    public static final String FUNC_GETDATASETBYINDEX = "getDatasetByIndex";

    public static final String FUNC_CREATEDATASET = "createDataset";

    public static final Event OWNERSHIPTRANSFERRED_EVENT = new Event("OwnershipTransferred", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}),
            Arrays.<TypeReference<?>>asList());
    ;

    protected static final HashMap<String, String> _addresses;

    static {
        _addresses = new HashMap<String, String>();
        _addresses.put("3", "0xfe6a941ddfbfc6924ea64dc2e576de3b5be3e3a5");
        _addresses.put("4", "0x82f858f32c8ee88772e296650667a838e5d1b961");
        _addresses.put("42", "0xdee768d9a781658503445cbe79e463bcf90538d5");
    }

    protected DatasetHub(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected DatasetHub(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
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

    public RemoteCall<BigInteger> m_totalDatasetCount() {
        final Function function = new Function(FUNC_M_TOTALDATASETCOUNT, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public static RemoteCall<DatasetHub> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(DatasetHub.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<DatasetHub> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(DatasetHub.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
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

    public RemoteCall<Boolean> isDatasetRegistred(String _dataset) {
        final Function function = new Function(FUNC_ISDATASETREGISTRED, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_dataset)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteCall<BigInteger> getDatasetsCount(String _owner) {
        final Function function = new Function(FUNC_GETDATASETSCOUNT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_owner)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<String> getDataset(String _owner, BigInteger _index) {
        final Function function = new Function(FUNC_GETDATASET, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_owner), 
                new org.web3j.abi.datatypes.generated.Uint256(_index)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<String> getDatasetByIndex(BigInteger _index) {
        final Function function = new Function(FUNC_GETDATASETBYINDEX, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_index)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> createDataset(String _datasetName, BigInteger _datasetPrice, String _datasetParams) {
        final Function function = new Function(
                FUNC_CREATEDATASET, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_datasetName), 
                new org.web3j.abi.datatypes.generated.Uint256(_datasetPrice), 
                new org.web3j.abi.datatypes.Utf8String(_datasetParams)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public static DatasetHub load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new DatasetHub(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static DatasetHub load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new DatasetHub(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
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
