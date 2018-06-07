package ec.iex;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
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
public class IexecOracleEscrow extends Contract {
    private static final String BINARY = "0x6060604052341561000f57600080fd5b604051602080610aad83398101604052808051906020019091905050336000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555080600160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550506109f1806100bc6000396000f300606060405260043610610099576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff168063097c0b0a1461009e57806382ca37f1146101035780638da5cb5b14610158578063b78f1b4d146101ad578063b8ad26da146101fe578063b95803e814610242578063bbc88c5d14610293578063bfd24f40146102ce578063f2fde38b14610328575b600080fd5b34156100a957600080fd5b6101016004808035906020019082018035906020019080806020026020016040519081016040528093929190818152602001838360200280828437820191505050505050919080351515906020019091905050610361565b005b341561010e57600080fd5b6101166103fa565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b341561016357600080fd5b61016b610420565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b34156101b857600080fd5b6101e4600480803573ffffffffffffffffffffffffffffffffffffffff16906020019091905050610445565b604051808215151515815260200191505060405180910390f35b341561020957600080fd5b610240600480803573ffffffffffffffffffffffffffffffffffffffff169060200190919080351515906020019091905050610465565b005b341561024d57600080fd5b610279600480803573ffffffffffffffffffffffffffffffffffffffff16906020019091905050610516565b604051808215151515815260200191505060405180910390f35b341561029e57600080fd5b6102b4600480803590602001909190505061056c565b604051808215151515815260200191505060405180910390f35b34156102d957600080fd5b61030e600480803573ffffffffffffffffffffffffffffffffffffffff1690602001909190803590602001909190505061074a565b604051808215151515815260200191505060405180910390f35b341561033357600080fd5b61035f600480803573ffffffffffffffffffffffffffffffffffffffff169060200190919050506108f5565b005b60008060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff1614156103f557600090505b82518110156103f4576103e783828151811015156103d757fe5b9060200190602002015183610465565b80806001019150506103bd565b5b505050565b600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b60026020528060005260406000206000915054906101000a900460ff1681565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff1614156105125780600260008473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060006101000a81548160ff0219169083151502179055505b5050565b6000600260008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060009054906101000a900460ff169050919050565b6000600260003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060009054906101000a900460ff168061061257506000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16145b151561061a57fe5b600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166323b872dd3230856000604051602001526040518463ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018281526020019350505050602060405180830381600087803b151561071b57600080fd5b6102c65a03f1151561072c57600080fd5b50505060405180519050151561074157600080fd5b60019050919050565b6000600260003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060009054906101000a900460ff16806107f057506000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16145b15156107f857fe5b600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663a9059cbb84846000604051602001526040518363ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200182815260200192505050602060405180830381600087803b15156108c557600080fd5b6102c65a03f115156108d657600080fd5b5050506040518051905015156108eb57600080fd5b6001905092915050565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff1614156109c257600073ffffffffffffffffffffffffffffffffffffffff168173ffffffffffffffffffffffffffffffffffffffff161415156109c157806000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055505b5b505600a165627a7a72305820e5061ac2ada696b6788133763ad96a7d41466daf98d819fc37c996f2e687c5b70029";

    public static final String FUNC_CHANGEIEXECORACLEREGISTRATIONSTATUSES = "changeIexecOracleRegistrationStatuses";

    public static final String FUNC_RLCTOKEN = "rlcToken";

    public static final String FUNC_OWNER = "owner";

    public static final String FUNC_IEXECORACLEREGISTERED = "iexecOracleRegistered";

    public static final String FUNC_CHANGEIEXECORACLEREGISTRATIONSTATUS = "changeIexecOracleRegistrationStatus";

    public static final String FUNC_ISIEXECORACLEREGISTERED = "isIexecOracleRegistered";

    public static final String FUNC_RLCDEPOSIT = "rlcDeposit";

    public static final String FUNC_RLCPAYMENT = "rlcPayment";

    public static final String FUNC_TRANSFEROWNERSHIP = "transferOwnership";

    protected static final HashMap<String, String> _addresses;

    static {
        _addresses = new HashMap<String, String>();
        _addresses.put("1", "0xf2137a5591b3b9b6fd75240c5fce8d8a6702375b");
        _addresses.put("3", "0xf81b04beed2002ec2f98210cfed2f051b3df7528");
        _addresses.put("4", "0xa29cbd14e12e24658f1ef09090e8487f1d728645");
        _addresses.put("42", "0xb34406538112bd2b3036b2c417c7cff827777a11");
        _addresses.put("31", "0xab87bd92acfff1c698ec4bb26fd381d041bc4539");
    }

    protected IexecOracleEscrow(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected IexecOracleEscrow(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public RemoteCall<TransactionReceipt> changeIexecOracleRegistrationStatuses(List<String> targets, Boolean isRegistered) {
        final Function function = new Function(
                FUNC_CHANGEIEXECORACLEREGISTRATIONSTATUSES, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.Address>(
                        org.web3j.abi.Utils.typeMap(targets, org.web3j.abi.datatypes.Address.class)), 
                new org.web3j.abi.datatypes.Bool(isRegistered)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<String> rlcToken() {
        final Function function = new Function(FUNC_RLCTOKEN, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<String> owner() {
        final Function function = new Function(FUNC_OWNER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<Boolean> iexecOracleRegistered(String param0) {
        final Function function = new Function(FUNC_IEXECORACLEREGISTERED, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteCall<TransactionReceipt> changeIexecOracleRegistrationStatus(String target, Boolean isRegistered) {
        final Function function = new Function(
                FUNC_CHANGEIEXECORACLEREGISTRATIONSTATUS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(target), 
                new org.web3j.abi.datatypes.Bool(isRegistered)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<Boolean> isIexecOracleRegistered(String target) {
        final Function function = new Function(FUNC_ISIEXECORACLEREGISTERED, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(target)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteCall<TransactionReceipt> rlcDeposit(BigInteger dappPrice) {
        final Function function = new Function(
                FUNC_RLCDEPOSIT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(dappPrice)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> rlcPayment(String beneficiary, BigInteger dappPrice) {
        final Function function = new Function(
                FUNC_RLCPAYMENT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(beneficiary), 
                new org.web3j.abi.datatypes.generated.Uint256(dappPrice)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> transferOwnership(String newOwner) {
        final Function function = new Function(
                FUNC_TRANSFEROWNERSHIP, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(newOwner)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public static RemoteCall<IexecOracleEscrow> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String _tokenAddress) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_tokenAddress)));
        return deployRemoteCall(IexecOracleEscrow.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static RemoteCall<IexecOracleEscrow> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String _tokenAddress) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_tokenAddress)));
        return deployRemoteCall(IexecOracleEscrow.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static IexecOracleEscrow load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new IexecOracleEscrow(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static IexecOracleEscrow load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new IexecOracleEscrow(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected String getStaticDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static String getPreviouslyDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }
}
