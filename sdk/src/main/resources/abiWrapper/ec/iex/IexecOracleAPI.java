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
public class IexecOracleAPI extends Contract {
    private static final String BINARY = "0x608060405234801561001057600080fd5b5060405161068e38038061068e8339810180604052810190808051906020019092919080519060200190929190805182019291905050506000836000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055506000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1690508073ffffffffffffffffffffffffffffffffffffffff16635993ef5384846040518363ffffffff167c01000000000000000000000000000000000000000000000000000000000281526004018083815260200180602001828103825283818151815260200191508051906020019080838360005b8381101561013c578082015181840152602081019050610121565b50505050905090810190601f1680156101695780820380516001836020036101000a031916815260200191505b509350505050602060405180830381600087803b15801561018957600080fd5b505af115801561019d573d6000803e3d6000fd5b505050506040513d60208110156101b357600080fd5b810190808051906020019092919050505015156101cf57600080fd5b505050506104ac806101e26000396000f30060806040526004361061004c576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff16806310a9f201146100515780638cd213b914610146575b600080fd5b34801561005d57600080fd5b5061012c6004803603810190808035600019169060200190929190803573ffffffffffffffffffffffffffffffffffffffff169060200190929190803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509192919290803590602001908201803590602001908080601f01602080910402602001604051908101604052809392919081815260200183838082843782019150505050505091929192905050506101a2565b604051808215151515815260200191505060405180910390f35b6101a0600480360381019080803590602001908201803590602001908080601f016020809104026020016040519081016040528093929190818152602001838380828437820191505050505050919291929050505061033b565b005b60008060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff161415156101ff57600080fd5b8373ffffffffffffffffffffffffffffffffffffffff167f68d2eaa37ea3e53bbe55f11eb038084f280086b8f4c4552dbca1b5692efeb9138685856040518084600019166000191681526020018060200180602001838103835285818151815260200191508051906020019080838360005b8381101561028c578082015181840152602081019050610271565b50505050905090810190601f1680156102b95780820380516001836020036101000a031916815260200191505b50838103825284818151815260200191508051906020019080838360005b838110156102f25780820151818401526020810190506102d7565b50505050905090810190601f16801561031f5780820380516001836020036101000a031916815260200191505b509550505050505060405180910390a260019050949350505050565b60008060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1690508073ffffffffffffffffffffffffffffffffffffffff1663d99a8dc334846040518363ffffffff167c01000000000000000000000000000000000000000000000000000000000281526004018080602001828103825283818151815260200191508051906020019080838360005b838110156103ea5780820151818401526020810190506103cf565b50505050905090810190601f1680156104175780820380516001836020036101000a031916815260200191505b50925050506020604051808303818588803b15801561043557600080fd5b505af1158015610449573d6000803e3d6000fd5b50505050506040513d602081101561046057600080fd5b8101908080519060200190929190505050151561047c57600080fd5b50505600a165627a7a72305820cdb79ee514c59027928a4d2e242bf44984c2d8ece25b7f576de65c26ccb08f150029";

    protected static final HashMap<String, String> _addresses;

    static {
        _addresses = new HashMap<>();
    }

    protected IexecOracleAPI(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected IexecOracleAPI(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
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

    public static RemoteCall<IexecOracleAPI> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String _iexecOracleAddress, BigInteger dappPrice, String dappName) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_iexecOracleAddress), 
                new org.web3j.abi.datatypes.generated.Uint256(dappPrice), 
                new org.web3j.abi.datatypes.Utf8String(dappName)));
        return deployRemoteCall(IexecOracleAPI.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static RemoteCall<IexecOracleAPI> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String _iexecOracleAddress, BigInteger dappPrice, String dappName) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_iexecOracleAddress), 
                new org.web3j.abi.datatypes.generated.Uint256(dappPrice), 
                new org.web3j.abi.datatypes.Utf8String(dappName)));
        return deployRemoteCall(IexecOracleAPI.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public RemoteCall<TransactionReceipt> iexecSubmit(String param, BigInteger weiValue) {
        final Function function = new Function(
                "iexecSubmit", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(param)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
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

    public static IexecOracleAPI load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new IexecOracleAPI(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static IexecOracleAPI load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new IexecOracleAPI(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
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
