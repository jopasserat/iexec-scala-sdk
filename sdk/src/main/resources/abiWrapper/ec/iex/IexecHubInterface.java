package ec.iex;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple2;
import org.web3j.tuples.generated.Tuple4;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 3.4.0.
 */
public class IexecHubInterface extends Contract {
    private static final String BINARY = "0x";

    public static final String FUNC_RLC = "rlc";

    public static final String FUNC_ATTACHCONTRACTS = "attachContracts";

    public static final String FUNC_SETCATEGORIESCREATOR = "setCategoriesCreator";

    public static final String FUNC_CREATECATEGORY = "createCategory";

    public static final String FUNC_CREATEWORKERPOOL = "createWorkerPool";

    public static final String FUNC_CREATEAPP = "createApp";

    public static final String FUNC_CREATEDATASET = "createDataset";

    public static final String FUNC_BUYFORWORKORDER = "buyForWorkOrder";

    public static final String FUNC_ISWOIDREGISTRED = "isWoidRegistred";

    public static final String FUNC_CLAIMFAILEDCONSENSUS = "claimFailedConsensus";

    public static final String FUNC_FINALIZEWORKORDER = "finalizeWorkOrder";

    public static final String FUNC_GETCATEGORYWORKCLOCKTIMEREF = "getCategoryWorkClockTimeRef";

    public static final String FUNC_EXISTINGCATEGORY = "existingCategory";

    public static final String FUNC_GETCATEGORY = "getCategory";

    public static final String FUNC_GETWORKERSTATUS = "getWorkerStatus";

    public static final String FUNC_GETWORKERSCORE = "getWorkerScore";

    public static final String FUNC_REGISTERTOPOOL = "registerToPool";

    public static final String FUNC_UNREGISTERFROMPOOL = "unregisterFromPool";

    public static final String FUNC_EVICTWORKER = "evictWorker";

    public static final String FUNC_LOCKFORORDER = "lockForOrder";

    public static final String FUNC_UNLOCKFORORDER = "unlockForOrder";

    public static final String FUNC_LOCKFORWORK = "lockForWork";

    public static final String FUNC_UNLOCKFORWORK = "unlockForWork";

    public static final String FUNC_REWARDFORWORK = "rewardForWork";

    public static final String FUNC_SEIZEFORWORK = "seizeForWork";

    public static final String FUNC_DEPOSIT = "deposit";

    public static final String FUNC_WITHDRAW = "withdraw";

    public static final String FUNC_CHECKBALANCE = "checkBalance";

    protected static final HashMap<String, String> _addresses;

    static {
        _addresses = new HashMap<String, String>();
    }

    protected IexecHubInterface(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected IexecHubInterface(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public RemoteCall<String> rlc() {
        final Function function = new Function(FUNC_RLC, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> attachContracts(String _tokenAddress, String _marketplaceAddress, String _workerPoolHubAddress, String _appHubAddress, String _datasetHubAddress) {
        final Function function = new Function(
                FUNC_ATTACHCONTRACTS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_tokenAddress), 
                new org.web3j.abi.datatypes.Address(_marketplaceAddress), 
                new org.web3j.abi.datatypes.Address(_workerPoolHubAddress), 
                new org.web3j.abi.datatypes.Address(_appHubAddress), 
                new org.web3j.abi.datatypes.Address(_datasetHubAddress)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> setCategoriesCreator(String _categoriesCreator) {
        final Function function = new Function(
                FUNC_SETCATEGORIESCREATOR, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_categoriesCreator)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> createCategory(String _name, String _description, BigInteger _workClockTimeRef) {
        final Function function = new Function(
                FUNC_CREATECATEGORY, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_name), 
                new org.web3j.abi.datatypes.Utf8String(_description), 
                new org.web3j.abi.datatypes.generated.Uint256(_workClockTimeRef)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> createWorkerPool(String _description, BigInteger _subscriptionLockStakePolicy, BigInteger _subscriptionMinimumStakePolicy, BigInteger _subscriptionMinimumScorePolicy) {
        final Function function = new Function(
                FUNC_CREATEWORKERPOOL, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_description), 
                new org.web3j.abi.datatypes.generated.Uint256(_subscriptionLockStakePolicy), 
                new org.web3j.abi.datatypes.generated.Uint256(_subscriptionMinimumStakePolicy), 
                new org.web3j.abi.datatypes.generated.Uint256(_subscriptionMinimumScorePolicy)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> createApp(String _appName, BigInteger _appPrice, String _appParams) {
        final Function function = new Function(
                FUNC_CREATEAPP, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_appName), 
                new org.web3j.abi.datatypes.generated.Uint256(_appPrice), 
                new org.web3j.abi.datatypes.Utf8String(_appParams)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
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

    public RemoteCall<Boolean> isWoidRegistred(String _woid) {
        final Function function = new Function(FUNC_ISWOIDREGISTRED, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_woid)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteCall<TransactionReceipt> claimFailedConsensus(String _woid) {
        final Function function = new Function(
                FUNC_CLAIMFAILEDCONSENSUS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_woid)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> finalizeWorkOrder(String _woid, String _stdout, String _stderr, String _uri) {
        final Function function = new Function(
                FUNC_FINALIZEWORKORDER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_woid), 
                new org.web3j.abi.datatypes.Utf8String(_stdout), 
                new org.web3j.abi.datatypes.Utf8String(_stderr), 
                new org.web3j.abi.datatypes.Utf8String(_uri)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<BigInteger> getCategoryWorkClockTimeRef(BigInteger _catId) {
        final Function function = new Function(FUNC_GETCATEGORYWORKCLOCKTIMEREF, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_catId)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<Boolean> existingCategory(BigInteger _catId) {
        final Function function = new Function(FUNC_EXISTINGCATEGORY, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_catId)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteCall<Tuple4<BigInteger, String, String, BigInteger>> getCategory(BigInteger _catId) {
        final Function function = new Function(FUNC_GETCATEGORY, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_catId)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Uint256>() {}));
        return new RemoteCall<Tuple4<BigInteger, String, String, BigInteger>>(
                new Callable<Tuple4<BigInteger, String, String, BigInteger>>() {
                    @Override
                    public Tuple4<BigInteger, String, String, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple4<BigInteger, String, String, BigInteger>(
                                (BigInteger) results.get(0).getValue(), 
                                (String) results.get(1).getValue(), 
                                (String) results.get(2).getValue(), 
                                (BigInteger) results.get(3).getValue());
                    }
                });
    }

    public RemoteCall<Tuple2<String, BigInteger>> getWorkerStatus(String _worker) {
        final Function function = new Function(FUNC_GETWORKERSTATUS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_worker)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Uint256>() {}));
        return new RemoteCall<Tuple2<String, BigInteger>>(
                new Callable<Tuple2<String, BigInteger>>() {
                    @Override
                    public Tuple2<String, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple2<String, BigInteger>(
                                (String) results.get(0).getValue(), 
                                (BigInteger) results.get(1).getValue());
                    }
                });
    }

    public RemoteCall<BigInteger> getWorkerScore(String _worker) {
        final Function function = new Function(FUNC_GETWORKERSCORE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_worker)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> registerToPool(String _worker) {
        final Function function = new Function(
                FUNC_REGISTERTOPOOL, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_worker)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> unregisterFromPool(String _worker) {
        final Function function = new Function(
                FUNC_UNREGISTERFROMPOOL, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_worker)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> evictWorker(String _worker) {
        final Function function = new Function(
                FUNC_EVICTWORKER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_worker)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> lockForOrder(String _user, BigInteger _amount) {
        final Function function = new Function(
                FUNC_LOCKFORORDER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_user), 
                new org.web3j.abi.datatypes.generated.Uint256(_amount)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> unlockForOrder(String _user, BigInteger _amount) {
        final Function function = new Function(
                FUNC_UNLOCKFORORDER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_user), 
                new org.web3j.abi.datatypes.generated.Uint256(_amount)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> lockForWork(String _woid, String _user, BigInteger _amount) {
        final Function function = new Function(
                FUNC_LOCKFORWORK, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_woid), 
                new org.web3j.abi.datatypes.Address(_user), 
                new org.web3j.abi.datatypes.generated.Uint256(_amount)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> unlockForWork(String _woid, String _user, BigInteger _amount) {
        final Function function = new Function(
                FUNC_UNLOCKFORWORK, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_woid), 
                new org.web3j.abi.datatypes.Address(_user), 
                new org.web3j.abi.datatypes.generated.Uint256(_amount)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> rewardForWork(String _woid, String _worker, BigInteger _amount, Boolean _reputation) {
        final Function function = new Function(
                FUNC_REWARDFORWORK, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_woid), 
                new org.web3j.abi.datatypes.Address(_worker), 
                new org.web3j.abi.datatypes.generated.Uint256(_amount), 
                new org.web3j.abi.datatypes.Bool(_reputation)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> seizeForWork(String _woid, String _worker, BigInteger _amount, Boolean _reputation) {
        final Function function = new Function(
                FUNC_SEIZEFORWORK, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_woid), 
                new org.web3j.abi.datatypes.Address(_worker), 
                new org.web3j.abi.datatypes.generated.Uint256(_amount), 
                new org.web3j.abi.datatypes.Bool(_reputation)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> deposit(BigInteger _amount) {
        final Function function = new Function(
                FUNC_DEPOSIT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_amount)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> withdraw(BigInteger _amount) {
        final Function function = new Function(
                FUNC_WITHDRAW, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_amount)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<Tuple2<BigInteger, BigInteger>> checkBalance(String _owner) {
        final Function function = new Function(FUNC_CHECKBALANCE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_owner)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
        return new RemoteCall<Tuple2<BigInteger, BigInteger>>(
                new Callable<Tuple2<BigInteger, BigInteger>>() {
                    @Override
                    public Tuple2<BigInteger, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple2<BigInteger, BigInteger>(
                                (BigInteger) results.get(0).getValue(), 
                                (BigInteger) results.get(1).getValue());
                    }
                });
    }

    public static RemoteCall<IexecHubInterface> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(IexecHubInterface.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<IexecHubInterface> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(IexecHubInterface.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static IexecHubInterface load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new IexecHubInterface(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static IexecHubInterface load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new IexecHubInterface(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected String getStaticDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static String getPreviouslyDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }
}
