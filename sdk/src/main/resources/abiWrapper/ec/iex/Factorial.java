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
 * <p>Generated with web3j version 3.3.1.
 */
public class Factorial extends Contract {
    private static final String BINARY = "0x608060405234801561001057600080fd5b506040516020806107c3833981018060405281019080805190602001909291905050508060016040805190810160405280600981526020017f666163746f7269616c00000000000000000000000000000000000000000000008152506000836000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055506000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1690508073ffffffffffffffffffffffffffffffffffffffff16635993ef5384846040518363ffffffff167c01000000000000000000000000000000000000000000000000000000000281526004018083815260200180602001828103825283818151815260200191508051906020019080838360005b83811015610161578082015181840152602081019050610146565b50505050905090810190601f16801561018e5780820380516001836020036101000a031916815260200191505b509350505050602060405180830381600087803b1580156101ae57600080fd5b505af11580156101c2573d6000803e3d6000fd5b505050506040513d60208110156101d857600080fd5b810190808051906020019092919050505015156101f457600080fd5b50505050506105bb806102086000396000f300608060405260043610610062576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff16806310a9f201146100675780633c0aef301461015c5780638cd213b914610187578063c878f958146101e3575b600080fd5b34801561007357600080fd5b506101426004803603810190808035600019169060200190929190803573ffffffffffffffffffffffffffffffffffffffff169060200190929190803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509192919290803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509192919290505050610273565b604051808215151515815260200191505060405180910390f35b34801561016857600080fd5b5061017161040c565b6040518082815260200191505060405180910390f35b6101e1600480360381019080803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509192919290505050610411565b005b3480156101ef57600080fd5b506101f8610556565b6040518080602001828103825283818151815260200191508051906020019080838360005b8381101561023857808201518184015260208101905061021d565b50505050905090810190601f1680156102655780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b60008060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff161415156102d057600080fd5b8373ffffffffffffffffffffffffffffffffffffffff167f68d2eaa37ea3e53bbe55f11eb038084f280086b8f4c4552dbca1b5692efeb9138685856040518084600019166000191681526020018060200180602001838103835285818151815260200191508051906020019080838360005b8381101561035d578082015181840152602081019050610342565b50505050905090810190601f16801561038a5780820380516001836020036101000a031916815260200191505b50838103825284818151815260200191508051906020019080838360005b838110156103c35780820151818401526020810190506103a8565b50505050905090810190601f1680156103f05780820380516001836020036101000a031916815260200191505b509550505050505060405180910390a260019050949350505050565b600181565b60008060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1690508073ffffffffffffffffffffffffffffffffffffffff1663d99a8dc334846040518363ffffffff167c01000000000000000000000000000000000000000000000000000000000281526004018080602001828103825283818151815260200191508051906020019080838360005b838110156104c05780820151818401526020810190506104a5565b50505050905090810190601f1680156104ed5780820380516001836020036101000a031916815260200191505b50925050506020604051808303818588803b15801561050b57600080fd5b505af115801561051f573d6000803e3d6000fd5b50505050506040513d602081101561053657600080fd5b8101908080519060200190929190505050151561055257600080fd5b5050565b6040805190810160405280600981526020017f666163746f7269616c0000000000000000000000000000000000000000000000815250815600a165627a7a72305820a1c3848fda3888f98681d1fd11f224bdb07750e51e1c0949ab0ff728be8ea36f0029";

    protected static final HashMap<String, String> _addresses;

    static {
        _addresses = new HashMap<>();
        _addresses.put("3", "0xd2b9d3ecc76b6d43277fd986afdb8b79685d4d1a");
        _addresses.put("4", "0x392ea5ebbe94ce8fac71720bf8b7a37301341fe2");
        _addresses.put("42", "0x0cca8579d3527a16e5abfc633c60b02ebc62a28c");
    }

    protected Factorial(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Factorial(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public List<IexecSubmitCallbackEventResponse> getIexecSubmitCallbackEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("IexecSubmitCallback", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}));
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(event, transactionReceipt);
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

    public Observable<IexecSubmitCallbackEventResponse> iexecSubmitCallbackEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("IexecSubmitCallback", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, IexecSubmitCallbackEventResponse>() {
            @Override
            public IexecSubmitCallbackEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(event, log);
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

    public RemoteCall<TransactionReceipt> iexecSubmitCallback(byte[] submitTxHash, String user, String stdout, String uri) {
        final Function function = new Function(
                "iexecSubmitCallback", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(submitTxHash), 
                new org.web3j.abi.datatypes.Address(user), 
                new org.web3j.abi.datatypes.Utf8String(stdout), 
                new org.web3j.abi.datatypes.Utf8String(uri)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<BigInteger> DAPP_PRICE() {
        final Function function = new Function("DAPP_PRICE", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> iexecSubmit(String param, BigInteger weiValue) {
        final Function function = new Function(
                "iexecSubmit", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(param)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    public RemoteCall<String> DAPP_NAME() {
        final Function function = new Function("DAPP_NAME", 
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
