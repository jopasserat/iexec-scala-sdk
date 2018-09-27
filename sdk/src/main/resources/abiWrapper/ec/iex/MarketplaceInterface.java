package ec.iex;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.abi.datatypes.generated.Uint8;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple7;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 3.5.0.
 */
public class MarketplaceInterface extends Contract {
    private static final String BINARY = "0x";

    public static final String FUNC_CREATEMARKETORDER = "createMarketOrder";

    public static final String FUNC_CLOSEMARKETORDER = "closeMarketOrder";

    public static final String FUNC_GETMARKETORDERVALUE = "getMarketOrderValue";

    public static final String FUNC_GETMARKETORDERWORKERPOOLOWNER = "getMarketOrderWorkerpoolOwner";

    public static final String FUNC_GETMARKETORDERCATEGORY = "getMarketOrderCategory";

    public static final String FUNC_GETMARKETORDERTRUST = "getMarketOrderTrust";

    public static final String FUNC_GETMARKETORDER = "getMarketOrder";

    protected static final HashMap<String, String> _addresses;

    static {
        _addresses = new HashMap<String, String>();
    }

    protected MarketplaceInterface(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected MarketplaceInterface(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
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

    public RemoteCall<Tuple7<BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, String>> getMarketOrder(BigInteger _marketorderIdx) {
        final Function function = new Function(FUNC_GETMARKETORDER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_marketorderIdx)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint8>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Address>() {}));
        return new RemoteCall<Tuple7<BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, String>>(
                new Callable<Tuple7<BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, String>>() {
                    @Override
                    public Tuple7<BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, String> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple7<BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, String>(
                                (BigInteger) results.get(0).getValue(), 
                                (BigInteger) results.get(1).getValue(), 
                                (BigInteger) results.get(2).getValue(), 
                                (BigInteger) results.get(3).getValue(), 
                                (BigInteger) results.get(4).getValue(), 
                                (BigInteger) results.get(5).getValue(), 
                                (String) results.get(6).getValue());
                    }
                });
    }

    public static RemoteCall<MarketplaceInterface> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(MarketplaceInterface.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<MarketplaceInterface> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(MarketplaceInterface.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static MarketplaceInterface load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new MarketplaceInterface(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static MarketplaceInterface load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new MarketplaceInterface(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected String getStaticDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static String getPreviouslyDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }
}
