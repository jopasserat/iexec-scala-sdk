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
 * <p>Generated with web3j version 3.5.0.
 */
public class TestSha extends Contract {
    private static final String BINARY = "0x6060604052341561000f57600080fd5b6103e38061001e6000396000f3006060604052600436106100615763ffffffff7c0100000000000000000000000000000000000000000000000000000000600035041663040c9c6581146100665780634c4bc901146100b9578063b4b5cae9146100cf578063d29da48c146100e5575b600080fd5b341561007157600080fd5b6100b760046024813581810190830135806020601f8201819004810201604051908101604052818152929190602084018383808284375094965061011195505050505050565b005b34156100c457600080fd5b6100b760043561020f565b34156100da57600080fd5b6100b760043561025d565b34156100f057600080fd5b6100b773ffffffffffffffffffffffffffffffffffffffff6004351661032c565b7f3f5e68e2b6822310a06a920b9b73daa30286bba2c001fa2133308e55a1d2820c816040518082805190602001908083835b602083106101625780518252601f199092019160209182019101610143565b6001836020036101000a038019825116818451161790925250505091909101925060409150505180910390208260405182815260406020820181815290820183818151815260200191508051906020019080838360005b838110156101d15780820151838201526020016101b9565b50505050905090810190601f1680156101fe5780820380516001836020036101000a031916815260200191505b50935050505060405180910390a150565b7f5f9b0066ef1432686f95afb566285f26646659039499219f4e8db0f462e889738160405190815260200160405180910390208260405191825260208201526040908101905180910390a150565b60008082604051908152602001604051809103902091503360405173ffffffffffffffffffffffffffffffffffffffff919091166c0100000000000000000000000002815260140160405180910390208318604051908152602001604051809103902090507f01477555f917271446523927e2e1e6172851347fc25430923a78abc27ef37e978333848460405193845273ffffffffffffffffffffffffffffffffffffffff909216602084015260408084019190915260608301919091526080909101905180910390a1505050565b7fd44e9c0d833bb9a963228a03302f0599e829fc4c38a919695779a05c2f54fd4d8160405173ffffffffffffffffffffffffffffffffffffffff919091166c0100000000000000000000000002815260140160405180910390208260405191825273ffffffffffffffffffffffffffffffffffffffff1660208201526040908101905180910390a1505600a165627a7a723058200ea47c286a485d4a3d20f10ef3bab17afb01dceb7244b36bcf4748906d18a5470029";

    public static final String FUNC_TESTSOLIDITYKECCAK256FROMBYTES = "testSolidityKeccak256FromBytes";

    public static final String FUNC_TESTSOLIDITYKECCAK256FROMSTRING = "testSolidityKeccak256FromString";

    public static final String FUNC_TESTSOLIDITYKECCAK256FROMADDRESS = "testSolidityKeccak256FromAddress";

    public static final String FUNC_TESTSIGNEDVOTE = "testSignedVote";

    public static final Event SOLIDITYKECCAK256FROMBYTES_EVENT = new Event("SolidityKeccak256FromBytes", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}, new TypeReference<Bytes32>() {}));
    ;

    public static final Event SOLIDITYKECCAK256FROMSTRING_EVENT = new Event("SolidityKeccak256FromString", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}, new TypeReference<Utf8String>() {}));
    ;

    public static final Event SOLIDITYKECCAK256FROMADDRESS_EVENT = new Event("SolidityKeccak256FromAddress", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}, new TypeReference<Address>() {}));
    ;

    public static final Event SIGNEDVOTE_EVENT = new Event("SignedVote", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}, new TypeReference<Address>() {}, new TypeReference<Bytes32>() {}, new TypeReference<Bytes32>() {}));
    ;

    protected static final HashMap<String, String> _addresses;

    static {
        _addresses = new HashMap<String, String>();
    }

    protected TestSha(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected TestSha(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public List<SolidityKeccak256FromBytesEventResponse> getSolidityKeccak256FromBytesEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(SOLIDITYKECCAK256FROMBYTES_EVENT, transactionReceipt);
        ArrayList<SolidityKeccak256FromBytesEventResponse> responses = new ArrayList<SolidityKeccak256FromBytesEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            SolidityKeccak256FromBytesEventResponse typedResponse = new SolidityKeccak256FromBytesEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.result = (byte[]) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.input = (byte[]) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<SolidityKeccak256FromBytesEventResponse> solidityKeccak256FromBytesEventObservable(EthFilter filter) {
        return web3j.ethLogObservable(filter).map(new Func1<Log, SolidityKeccak256FromBytesEventResponse>() {
            @Override
            public SolidityKeccak256FromBytesEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(SOLIDITYKECCAK256FROMBYTES_EVENT, log);
                SolidityKeccak256FromBytesEventResponse typedResponse = new SolidityKeccak256FromBytesEventResponse();
                typedResponse.log = log;
                typedResponse.result = (byte[]) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.input = (byte[]) eventValues.getNonIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Observable<SolidityKeccak256FromBytesEventResponse> solidityKeccak256FromBytesEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(SOLIDITYKECCAK256FROMBYTES_EVENT));
        return solidityKeccak256FromBytesEventObservable(filter);
    }

    public List<SolidityKeccak256FromStringEventResponse> getSolidityKeccak256FromStringEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(SOLIDITYKECCAK256FROMSTRING_EVENT, transactionReceipt);
        ArrayList<SolidityKeccak256FromStringEventResponse> responses = new ArrayList<SolidityKeccak256FromStringEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            SolidityKeccak256FromStringEventResponse typedResponse = new SolidityKeccak256FromStringEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.result = (byte[]) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.input = (String) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<SolidityKeccak256FromStringEventResponse> solidityKeccak256FromStringEventObservable(EthFilter filter) {
        return web3j.ethLogObservable(filter).map(new Func1<Log, SolidityKeccak256FromStringEventResponse>() {
            @Override
            public SolidityKeccak256FromStringEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(SOLIDITYKECCAK256FROMSTRING_EVENT, log);
                SolidityKeccak256FromStringEventResponse typedResponse = new SolidityKeccak256FromStringEventResponse();
                typedResponse.log = log;
                typedResponse.result = (byte[]) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.input = (String) eventValues.getNonIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Observable<SolidityKeccak256FromStringEventResponse> solidityKeccak256FromStringEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(SOLIDITYKECCAK256FROMSTRING_EVENT));
        return solidityKeccak256FromStringEventObservable(filter);
    }

    public List<SolidityKeccak256FromAddressEventResponse> getSolidityKeccak256FromAddressEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(SOLIDITYKECCAK256FROMADDRESS_EVENT, transactionReceipt);
        ArrayList<SolidityKeccak256FromAddressEventResponse> responses = new ArrayList<SolidityKeccak256FromAddressEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            SolidityKeccak256FromAddressEventResponse typedResponse = new SolidityKeccak256FromAddressEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.result = (byte[]) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.input = (String) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<SolidityKeccak256FromAddressEventResponse> solidityKeccak256FromAddressEventObservable(EthFilter filter) {
        return web3j.ethLogObservable(filter).map(new Func1<Log, SolidityKeccak256FromAddressEventResponse>() {
            @Override
            public SolidityKeccak256FromAddressEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(SOLIDITYKECCAK256FROMADDRESS_EVENT, log);
                SolidityKeccak256FromAddressEventResponse typedResponse = new SolidityKeccak256FromAddressEventResponse();
                typedResponse.log = log;
                typedResponse.result = (byte[]) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.input = (String) eventValues.getNonIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Observable<SolidityKeccak256FromAddressEventResponse> solidityKeccak256FromAddressEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(SOLIDITYKECCAK256FROMADDRESS_EVENT));
        return solidityKeccak256FromAddressEventObservable(filter);
    }

    public List<SignedVoteEventResponse> getSignedVoteEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(SIGNEDVOTE_EVENT, transactionReceipt);
        ArrayList<SignedVoteEventResponse> responses = new ArrayList<SignedVoteEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            SignedVoteEventResponse typedResponse = new SignedVoteEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.input = (byte[]) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.voter = (String) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.vote = (byte[]) eventValues.getNonIndexedValues().get(2).getValue();
            typedResponse.sign = (byte[]) eventValues.getNonIndexedValues().get(3).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<SignedVoteEventResponse> signedVoteEventObservable(EthFilter filter) {
        return web3j.ethLogObservable(filter).map(new Func1<Log, SignedVoteEventResponse>() {
            @Override
            public SignedVoteEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(SIGNEDVOTE_EVENT, log);
                SignedVoteEventResponse typedResponse = new SignedVoteEventResponse();
                typedResponse.log = log;
                typedResponse.input = (byte[]) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.voter = (String) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse.vote = (byte[]) eventValues.getNonIndexedValues().get(2).getValue();
                typedResponse.sign = (byte[]) eventValues.getNonIndexedValues().get(3).getValue();
                return typedResponse;
            }
        });
    }

    public Observable<SignedVoteEventResponse> signedVoteEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(SIGNEDVOTE_EVENT));
        return signedVoteEventObservable(filter);
    }

    public RemoteCall<TransactionReceipt> testSolidityKeccak256FromBytes(byte[] _input) {
        final Function function = new Function(
                FUNC_TESTSOLIDITYKECCAK256FROMBYTES, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(_input)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> testSolidityKeccak256FromString(String _input) {
        final Function function = new Function(
                FUNC_TESTSOLIDITYKECCAK256FROMSTRING, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_input)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> testSolidityKeccak256FromAddress(String _input) {
        final Function function = new Function(
                FUNC_TESTSOLIDITYKECCAK256FROMADDRESS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_input)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> testSignedVote(byte[] _result) {
        final Function function = new Function(
                FUNC_TESTSIGNEDVOTE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(_result)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public static RemoteCall<TestSha> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(TestSha.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<TestSha> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(TestSha.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static TestSha load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new TestSha(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static TestSha load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new TestSha(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected String getStaticDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static String getPreviouslyDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static class SolidityKeccak256FromBytesEventResponse {
        public Log log;

        public byte[] result;

        public byte[] input;
    }

    public static class SolidityKeccak256FromStringEventResponse {
        public Log log;

        public byte[] result;

        public String input;
    }

    public static class SolidityKeccak256FromAddressEventResponse {
        public Log log;

        public byte[] result;

        public String input;
    }

    public static class SignedVoteEventResponse {
        public Log log;

        public byte[] input;

        public String voter;

        public byte[] vote;

        public byte[] sign;
    }
}
