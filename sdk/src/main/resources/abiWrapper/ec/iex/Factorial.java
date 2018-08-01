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
public class Factorial extends Contract {
    private static final String BINARY = "0x6060604052341561000f57600080fd5b60405160208061076c833981016040528080519060200190919050508060016040805190810160405280600981526020017f666163746f7269616c00000000000000000000000000000000000000000000008152506000836000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055506000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1690508073ffffffffffffffffffffffffffffffffffffffff16635993ef5384846000604051602001526040518363ffffffff167c01000000000000000000000000000000000000000000000000000000000281526004018083815260200180602001828103825283818151815260200191508051906020019080838360005b83811015610162578082015181840152602081019050610147565b50505050905090810190601f16801561018f5780820380516001836020036101000a031916815260200191505b509350505050602060405180830381600087803b15156101ae57600080fd5b6102c65a03f115156101bf57600080fd5b5050506040518051905015156101d457600080fd5b5050505050610584806101e86000396000f300606060405260043610610062576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff16806310a9f201146100675780633c0aef301461014b5780638cd213b914610174578063c878f958146101c6575b600080fd5b341561007257600080fd5b61013160048080356000191690602001909190803573ffffffffffffffffffffffffffffffffffffffff1690602001909190803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509190803590602001908201803590602001908080601f01602080910402602001604051908101604052809392919081815260200183838082843782019150505050505091905050610254565b604051808215151515815260200191505060405180910390f35b341561015657600080fd5b61015e6103ed565b6040518082815260200191505060405180910390f35b6101c4600480803590602001908201803590602001908080601f016020809104026020016040519081016040528093929190818152602001838380828437820191505050505050919050506103f2565b005b34156101d157600080fd5b6101d961051f565b6040518080602001828103825283818151815260200191508051906020019080838360005b838110156102195780820151818401526020810190506101fe565b50505050905090810190601f1680156102465780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b60008060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff161415156102b157600080fd5b8373ffffffffffffffffffffffffffffffffffffffff167f68d2eaa37ea3e53bbe55f11eb038084f280086b8f4c4552dbca1b5692efeb9138685856040518084600019166000191681526020018060200180602001838103835285818151815260200191508051906020019080838360005b8381101561033e578082015181840152602081019050610323565b50505050905090810190601f16801561036b5780820380516001836020036101000a031916815260200191505b50838103825284818151815260200191508051906020019080838360005b838110156103a4578082015181840152602081019050610389565b50505050905090810190601f1680156103d15780820380516001836020036101000a031916815260200191505b509550505050505060405180910390a260019050949350505050565b600181565b60008060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1690508073ffffffffffffffffffffffffffffffffffffffff1663d99a8dc334846000604051602001526040518363ffffffff167c01000000000000000000000000000000000000000000000000000000000281526004018080602001828103825283818151815260200191508051906020019080838360005b838110156104aa57808201518184015260208101905061048f565b50505050905090810190601f1680156104d75780820380516001836020036101000a031916815260200191505b50925050506020604051808303818588803b15156104f457600080fd5b6125ee5a03f1151561050557600080fd5b5050505060405180519050151561051b57600080fd5b5050565b6040805190810160405280600981526020017f666163746f7269616c0000000000000000000000000000000000000000000000815250815600a165627a7a723058202131638594f5c88bb4ad16e27ece2dfbe4b6f54b681f854133973c7b9420c2760029";

    public static final String FUNC_IEXECSUBMITCALLBACK = "iexecSubmitCallback";

    public static final String FUNC_DAPP_PRICE = "DAPP_PRICE";

    public static final String FUNC_IEXECSUBMIT = "iexecSubmit";

    public static final String FUNC_DAPP_NAME = "DAPP_NAME";

    public static final Event IEXECSUBMITCALLBACK_EVENT = new Event("IexecSubmitCallback", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}),
            Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}));
    ;

    protected static final HashMap<String, String> _addresses;

    static {
        _addresses = new HashMap<String, String>();
        _addresses.put("3", "0xd2b9d3ecc76b6d43277fd986afdb8b79685d4d1a");
        _addresses.put("4", "0x392ea5ebbe94ce8fac71720bf8b7a37301341fe2");
        _addresses.put("42", "0x0F0921a1101475DF0A4E322aa7886a32B1e15a5C");
    }

    protected Factorial(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Factorial(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public RemoteCall<TransactionReceipt> iexecSubmitCallback(byte[] submitTxHash, String user, String stdout, String uri) {
        final Function function = new Function(
                FUNC_IEXECSUBMITCALLBACK, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(submitTxHash), 
                new org.web3j.abi.datatypes.Address(user), 
                new org.web3j.abi.datatypes.Utf8String(stdout), 
                new org.web3j.abi.datatypes.Utf8String(uri)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<BigInteger> DAPP_PRICE() {
        final Function function = new Function(FUNC_DAPP_PRICE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> iexecSubmit(String param, BigInteger weiValue) {
        final Function function = new Function(
                FUNC_IEXECSUBMIT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(param)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    public RemoteCall<String> DAPP_NAME() {
        final Function function = new Function(FUNC_DAPP_NAME, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public static RemoteCall<Factorial> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String _iexecOracleAddress) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_iexecOracleAddress)));
        return deployRemoteCall(Factorial.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static RemoteCall<Factorial> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String _iexecOracleAddress) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_iexecOracleAddress)));
        return deployRemoteCall(Factorial.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public List<IexecSubmitCallbackEventResponse> getIexecSubmitCallbackEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(IEXECSUBMITCALLBACK_EVENT, transactionReceipt);
        ArrayList<IexecSubmitCallbackEventResponse> responses = new ArrayList<IexecSubmitCallbackEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            IexecSubmitCallbackEventResponse typedResponse = new IexecSubmitCallbackEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.user = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.submitTxHash = (byte[]) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.stdout = (String) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.uri = (String) eventValues.getNonIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<IexecSubmitCallbackEventResponse> iexecSubmitCallbackEventObservable(EthFilter filter) {
        return web3j.ethLogObservable(filter).map(new Func1<Log, IexecSubmitCallbackEventResponse>() {
            @Override
            public IexecSubmitCallbackEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(IEXECSUBMITCALLBACK_EVENT, log);
                IexecSubmitCallbackEventResponse typedResponse = new IexecSubmitCallbackEventResponse();
                typedResponse.log = log;
                typedResponse.user = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.submitTxHash = (byte[]) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.stdout = (String) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse.uri = (String) eventValues.getNonIndexedValues().get(2).getValue();
                return typedResponse;
            }
        });
    }

    public Observable<IexecSubmitCallbackEventResponse> iexecSubmitCallbackEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(IEXECSUBMITCALLBACK_EVENT));
        return iexecSubmitCallbackEventObservable(filter);
    }

    public static Factorial load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Factorial(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static Factorial load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Factorial(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected String getStaticDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static String getPreviouslyDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static class IexecSubmitCallbackEventResponse {
        public Log log;

        public String user;

        public byte[] submitTxHash;

        public String stdout;

        public String uri;
    }
}
