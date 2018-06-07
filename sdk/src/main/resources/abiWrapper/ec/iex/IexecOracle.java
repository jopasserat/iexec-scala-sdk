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
import org.web3j.abi.datatypes.generated.Bytes32;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.abi.datatypes.generated.Uint8;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple3;
import org.web3j.tuples.generated.Tuple5;
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
public class IexecOracle extends Contract {
    private static final String BINARY = "0x606060405260008060146101000a81548160ff021916908315150217905550341561002957600080fd5b6040516040806128a983398101604052808051906020019091908051906020019091905050336000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555081600160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055508060028190555050506127c2806100e76000396000f30060606040526004361061011d576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff1680631385d24c146101225780631692c89b146101375780631b0935661461018457806330266537146102be57806333d4da2a14610452578063496bd3df1461047b5780634bbed29c1461056757806352dd94cc1461060757806355f21eb7146106b95780635993ef531461073257806375f12b21146107b05780638da5cb5b146107dd57806392556147146108325780639e1c466f14610887578063af5a02a414610927578063cddc3b0a1461094a578063d543c28d14610993578063d99a8dc314610a33578063db0e16f114610a9d578063f2fde38b14610adf578063f5923e7e14610b18575b600080fd5b341561012d57600080fd5b610135610b53565b005b341561014257600080fd5b61016e600480803573ffffffffffffffffffffffffffffffffffffffff16906020019091905050610bd5565b6040518082815260200191505060405180910390f35b341561018f57600080fd5b6102bc60048080356000191690602001909190803573ffffffffffffffffffffffffffffffffffffffff1690602001909190803573ffffffffffffffffffffffffffffffffffffffff1690602001909190803560ff1690602001909190803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509190803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509190803590602001908201803590602001908080601f01602080910402602001604051908101604052809392919081815260200183838082843782019150505050505091905050610c21565b005b34156102c957600080fd5b6102e3600480803560001916906020019091905050611224565b604051808681526020018560058111156102f957fe5b60ff168152602001806020018060200180602001848103845287818151815260200191508051906020019080838360005b8381101561034557808201518184015260208101905061032a565b50505050905090810190601f1680156103725780820380516001836020036101000a031916815260200191505b50848103835286818151815260200191508051906020019080838360005b838110156103ab578082015181840152602081019050610390565b50505050905090810190601f1680156103d85780820380516001836020036101000a031916815260200191505b50848103825285818151815260200191508051906020019080838360005b838110156104115780820151818401526020810190506103f6565b50505050905090810190601f16801561043e5780820380516001836020036101000a031916815260200191505b509850505050505050505060405180910390f35b341561045d57600080fd5b6104656114cb565b6040518082815260200191505060405180910390f35b341561048657600080fd5b6104b2600480803573ffffffffffffffffffffffffffffffffffffffff169060200190919050506114d1565b60405180806020018481526020018373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001828103825285818151815260200191508051906020019080838360005b8381101561052a57808201518184015260208101905061050f565b50505050905090810190601f1680156105575780820380516001836020036101000a031916815260200191505b5094505050505060405180910390f35b341561057257600080fd5b61058c60048080356000191690602001909190505061166d565b6040518080602001828103825283818151815260200191508051906020019080838360005b838110156105cc5780820151818401526020810190506105b1565b50505050905090810190601f1680156105f95780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b341561061257600080fd5b61063e600480803573ffffffffffffffffffffffffffffffffffffffff16906020019091905050611733565b6040518080602001828103825283818151815260200191508051906020019080838360005b8381101561067e578082015181840152602081019050610663565b50505050905090810190601f1680156106ab5780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b34156106c457600080fd5b6106f0600480803573ffffffffffffffffffffffffffffffffffffffff1690602001909190505061181d565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b341561073d57600080fd5b610796600480803590602001909190803590602001908201803590602001908080601f01602080910402602001604051908101604052809392919081815260200183838082843782019150505050505091905050611889565b604051808215151515815260200191505060405180910390f35b34156107bb57600080fd5b6107c3611b5d565b604051808215151515815260200191505060405180910390f35b34156107e857600080fd5b6107f0611b70565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b341561083d57600080fd5b610845611b95565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b341561089257600080fd5b6108ac600480803560001916906020019091905050611bbb565b6040518080602001828103825283818151815260200191508051906020019080838360005b838110156108ec5780820151818401526020810190506108d1565b50505050905090810190601f1680156109195780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b341561093257600080fd5b6109486004808035906020019091905050611c81565b005b341561095557600080fd5b61096f600480803560001916906020019091905050611ce3565b6040518082600581111561097f57fe5b60ff16815260200191505060405180910390f35b341561099e57600080fd5b6109b8600480803560001916906020019091905050611d18565b6040518080602001828103825283818151815260200191508051906020019080838360005b838110156109f85780820151818401526020810190506109dd565b50505050905090810190601f168015610a255780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b610a83600480803590602001908201803590602001908080601f01602080910402602001604051908101604052809392919081815260200183838082843782019150505050505091905050611dde565b604051808215151515815260200191505060405180910390f35b3415610aa857600080fd5b610add600480803573ffffffffffffffffffffffffffffffffffffffff169060200190919080359060200190919050506122dd565b005b3415610aea57600080fd5b610b16600480803573ffffffffffffffffffffffffffffffffffffffff16906020019091905050612425565b005b3415610b2357600080fd5b610b3d6004808035600019169060200190919050506124f5565b6040518082815260200191505060405180910390f35b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff161415610bd357600060149054906101000a900460ff1615600060146101000a81548160ff0219169083151502179055505b565b6000600460008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020600101549050919050565b60008060149054906101000a900460ff16151515610c3e57600080fd5b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16141515610c9657fe5b60006005811115610ca357fe5b856005811115610caf57fe5b14151515610cbc57600080fd5b60006005811115610cc957fe5b600360008a6000191660001916815260200190815260200160002060010160009054906101000a900460ff166005811115610d0057fe5b141515610d0c57600080fd5b42600360008a600019166000191681526020019081526020016000206000018190555084600360008a6000191660001916815260200190815260200160002060010160006101000a81548160ff02191690836005811115610d6957fe5b021790555083600360008a600019166000191681526020019081526020016000206002019080519060200190610da09291906126dd565b5082600360008a600019166000191681526020019081526020016000206003019080519060200190610dd39291906126dd565b5081600360008a600019166000191681526020019081526020016000206004019080519060200190610e069291906126dd565b508673ffffffffffffffffffffffffffffffffffffffff167f06239fa7a3489329ee223aa89190ea8412cf24599da9c43000047862209fbe3b8986856040518084600019166000191681526020018060200180602001838103835285818151815260200191508051906020019080838360005b83811015610e94578082015181840152602081019050610e79565b50505050905090810190601f168015610ec15780820380516001836020036101000a031916815260200191505b50838103825284818151815260200191508051906020019080838360005b83811015610efa578082015181840152602081019050610edf565b50505050905090810190601f168015610f275780820380516001836020036101000a031916815260200191505b509550505050505060405180910390a2610f44888789878661251d565b600460008773ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020600101549050600081111561121a5760046005811115610f9f57fe5b856005811115610fab57fe5b141561110757600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663bfd24f40600460008973ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060020160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff16836000604051602001526040518363ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200182815260200192505050602060405180830381600087803b15156110e057600080fd5b6102c65a03f115156110f157600080fd5b50505060405180519050151561110657600080fd5b5b60058081111561111357fe5b85600581111561111f57fe5b141561121957600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663bfd24f4088836000604051602001526040518363ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200182815260200192505050602060405180830381600087803b15156111f257600080fd5b6102c65a03f1151561120357600080fd5b50505060405180519050151561121857600080fd5b5b5b5050505050505050565b60008061122f61275d565b61123761275d565b61123f61275d565b6003600087600019166000191681526020019081526020016000206000015460036000886000191660001916815260200190815260200160002060010160009054906101000a900460ff16600360008960001916600019168152602001908152602001600020600201600360008a60001916600019168152602001908152602001600020600301600360008b60001916600019168152602001908152602001600020600401828054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156113795780601f1061134e57610100808354040283529160200191611379565b820191906000526020600020905b81548152906001019060200180831161135c57829003601f168201915b50505050509250818054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156114155780601f106113ea57610100808354040283529160200191611415565b820191906000526020600020905b8154815290600101906020018083116113f857829003601f168201915b50505050509150808054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156114b15780601f10611486576101008083540402835291602001916114b1565b820191906000526020600020905b81548152906001019060200180831161149457829003601f168201915b505050505090509450945094509450945091939590929450565b60025481565b6114d961275d565b600080600460008573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020600001600460008673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060010154600460008773ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060020160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff16828054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156116595780601f1061162e57610100808354040283529160200191611659565b820191906000526020600020905b81548152906001019060200180831161163c57829003601f168201915b505050505092509250925092509193909250565b61167561275d565b6003600083600019166000191681526020019081526020016000206004018054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156117275780601f106116fc57610100808354040283529160200191611727565b820191906000526020600020905b81548152906001019060200180831161170a57829003601f168201915b50505050509050919050565b61173b61275d565b600460008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000206000018054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156118115780601f106117e657610100808354040283529160200191611811565b820191906000526020600020905b8154815290600101906020018083116117f457829003601f168201915b50505050509050919050565b6000600460008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060020160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff169050919050565b60008060149054906101000a900460ff161515156118a657600080fd5b6000600460003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060020160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1614151561192a57fe5b3273ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff161415151561196257fe5b32600460003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060020160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555082600460003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000206001018190555081600460003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000206000019080519060200190611a809291906126dd565b503273ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff167faf5012f155004010b6b3ae7a6355778f4d22bb65d1ca74541e78696e41a448c085856040518083815260200180602001828103825283818151815260200191508051906020019080838360005b83811015611b18578082015181840152602081019050611afd565b50505050905090810190601f168015611b455780820380516001836020036101000a031916815260200191505b50935050505060405180910390a36001905092915050565b600060149054906101000a900460ff1681565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b611bc361275d565b6003600083600019166000191681526020019081526020016000206003018054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015611c755780601f10611c4a57610100808354040283529160200191611c75565b820191906000526020600020905b815481529060010190602001808311611c5857829003601f168201915b50505050509050919050565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16141515611cd957fe5b8060028190555050565b600060036000836000191660001916815260200190815260200160002060010160009054906101000a900460ff169050919050565b611d2061275d565b6003600083600019166000191681526020019081526020016000206002018054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015611dd25780601f10611da757610100808354040283529160200191611dd2565b820191906000526020600020905b815481529060010190602001808311611db557829003601f168201915b50505050509050919050565b6000806000600460003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060020160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1614151515611e6657fe5b600254341015611f32577fc548eaddad03c946ad5228a88cfbd752439e312a7b29b7e8791a0b5fe143584c60016040518082815260200180602001828103825260548152602001807f6d73672e76616c7565206e656564656420666f72207375626d69742063616c6c81526020017f6261636b2067617320697320746f6f206c6f772e20436865636b20746865206381526020017f757272656e742063616c6c6261636b50726963650000000000000000000000008152506060019250505060405180910390a1600080fd5b670de0b6b3a764000034101515612005577fc548eaddad03c946ad5228a88cfbd752439e312a7b29b7e8791a0b5fe143584c60026040518082815260200180602001828103825260508152602001807f6d73672e76616c7565206e656564656420666f72207375626d69742063616c6c81526020017f6261636b2067617320697320746f6f20686967682e204d757374206265206c6f81526020017f776572207468616e2031206574686572000000000000000000000000000000008152506060019250505060405180910390a1600080fd5b600060149054906101000a900460ff1615151561202157600080fd5b600460003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020600101549050600081111561212f57600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663bbc88c5d826000604051602001526040518263ffffffff167c010000000000000000000000000000000000000000000000000000000002815260040180828152602001915050602060405180830381600087803b151561210857600080fd5b6102c65a03f1151561211957600080fd5b50505060405180519050151561212e57600080fd5b5b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166108fc349081150290604051600060405180830381858888f19350505050151561219057600080fd5b600460003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060020160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff163273ffffffffffffffffffffffffffffffffffffffff167f743a962df271a2e268a671fb94be36697104681af61a64ccdf1dcf924035fdcd866040518080602001828103825283818151815260200191508051906020019080838360005b8381101561229957808201518184015260208101905061227e565b50505050905090810190601f1680156122c65780820380516001836020036101000a031916815260200191505b509250505060405180910390a46001915050919050565b60008060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff161415612420578290508073ffffffffffffffffffffffffffffffffffffffff1663a9059cbb6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff16846000604051602001526040518363ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200182815260200192505050602060405180830381600087803b151561240357600080fd5b6102c65a03f1151561241457600080fd5b50505060405180519050505b505050565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff1614156124f257600073ffffffffffffffffffffffffffffffffffffffff168173ffffffffffffffffffffffffffffffffffffffff161415156124f157806000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055505b5b50565b6000600360008360001916600019168152602001908152602001600020600001549050919050565b60008490508073ffffffffffffffffffffffffffffffffffffffff166310a9f201878686866000604051602001526040518563ffffffff167c01000000000000000000000000000000000000000000000000000000000281526004018085600019166000191681526020018473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018060200180602001838103835285818151815260200191508051906020019080838360005b838110156125fa5780820151818401526020810190506125df565b50505050905090810190601f1680156126275780820380516001836020036101000a031916815260200191505b50838103825284818151815260200191508051906020019080838360005b83811015612660578082015181840152602081019050612645565b50505050905090810190601f16801561268d5780820380516001836020036101000a031916815260200191505b509650505050505050602060405180830381600087803b15156126af57600080fd5b6102c65a03f115156126c057600080fd5b5050506040518051905015156126d557600080fd5b505050505050565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f1061271e57805160ff191683800117855561274c565b8280016001018555821561274c579182015b8281111561274b578251825591602001919060010190612730565b5b5090506127599190612771565b5090565b602060405190810160405280600081525090565b61279391905b8082111561278f576000816000905550600101612777565b5090565b905600a165627a7a7230582021f90e1bd3a0171ed2a77382449792421f1cbf0c3ac5a428be0bd73ffa9979a90029";

    public static final String FUNC_TOGGLECONTRACTACTIVE = "toggleContractActive";

    public static final String FUNC_GETDAPPPRICE = "getDappPrice";

    public static final String FUNC_SUBMITCALLBACK = "submitCallback";

    public static final String FUNC_GETWORK = "getWork";

    public static final String FUNC_CALLBACKPRICE = "callbackPrice";

    public static final String FUNC_GETDAPP = "getDapp";

    public static final String FUNC_GETWORKURI = "getWorkUri";

    public static final String FUNC_GETDAPPNAME = "getDappName";

    public static final String FUNC_GETPROVIDER = "getProvider";

    public static final String FUNC_REGISTERDAPPANDPROVIDER = "registerDappAndProvider";

    public static final String FUNC_STOPPED = "stopped";

    public static final String FUNC_OWNER = "owner";

    public static final String FUNC_IEXECORACLEESCROW = "iexecOracleEscrow";

    public static final String FUNC_GETWORKSTDERR = "getWorkStderr";

    public static final String FUNC_CHANGECALLBACKPRICE = "changeCallbackPrice";

    public static final String FUNC_GETWORKSTATUS = "getWorkStatus";

    public static final String FUNC_GETWORKSTDOUT = "getWorkStdout";

    public static final String FUNC_SUBMIT = "submit";

    public static final String FUNC_EMERGENCYERC20DRAIN = "emergencyERC20Drain";

    public static final String FUNC_TRANSFEROWNERSHIP = "transferOwnership";

    public static final String FUNC_GETWORKTIMESTAMP = "getWorkTimestamp";

    public static final Event SUBMIT_EVENT = new Event("Submit", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}, new TypeReference<Address>() {}),
            Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
    ;

    public static final Event SUBMITCALLBACK_EVENT = new Event("SubmitCallback", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}),
            Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}));
    ;

    public static final Event REGISTER_EVENT = new Event("Register", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}),
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Utf8String>() {}));
    ;

    public static final Event ERROR_EVENT = new Event("Error", 
            Arrays.<TypeReference<?>>asList(),
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Utf8String>() {}));
    ;

    protected static final HashMap<String, String> _addresses;

    static {
        _addresses = new HashMap<String, String>();
        _addresses.put("1", "0xe81294735294e1498af81de1c3b102b97c1dbbce");
        _addresses.put("3", "0x361a12b8caa96add52abcae37cdc28dfaba24f04");
        _addresses.put("4", "0xcaa446f33b685622420a7ebedf91de9640709b8f");
        _addresses.put("42", "0x6949a20492a874e7b5f186a30a292e33a14ca77b");
        _addresses.put("31", "0x8d986c0dee6f2a20c483949485efbe8e0b008b93");
    }

    protected IexecOracle(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected IexecOracle(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public RemoteCall<TransactionReceipt> toggleContractActive() {
        final Function function = new Function(
                FUNC_TOGGLECONTRACTACTIVE, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<BigInteger> getDappPrice(String dapp) {
        final Function function = new Function(FUNC_GETDAPPPRICE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(dapp)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> submitCallback(byte[] submitTxHash, String user, String dapp, BigInteger status, String stdout, String stderr, String uri) {
        final Function function = new Function(
                FUNC_SUBMITCALLBACK, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(submitTxHash), 
                new org.web3j.abi.datatypes.Address(user), 
                new org.web3j.abi.datatypes.Address(dapp), 
                new org.web3j.abi.datatypes.generated.Uint8(status), 
                new org.web3j.abi.datatypes.Utf8String(stdout), 
                new org.web3j.abi.datatypes.Utf8String(stderr), 
                new org.web3j.abi.datatypes.Utf8String(uri)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<Tuple5<BigInteger, BigInteger, String, String, String>> getWork(byte[] submitTxHash) {
        final Function function = new Function(FUNC_GETWORK, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(submitTxHash)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Uint8>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}));
        return new RemoteCall<Tuple5<BigInteger, BigInteger, String, String, String>>(
                new Callable<Tuple5<BigInteger, BigInteger, String, String, String>>() {
                    @Override
                    public Tuple5<BigInteger, BigInteger, String, String, String> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple5<BigInteger, BigInteger, String, String, String>(
                                (BigInteger) results.get(0).getValue(), 
                                (BigInteger) results.get(1).getValue(), 
                                (String) results.get(2).getValue(), 
                                (String) results.get(3).getValue(), 
                                (String) results.get(4).getValue());
                    }
                });
    }

    public RemoteCall<BigInteger> callbackPrice() {
        final Function function = new Function(FUNC_CALLBACKPRICE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<Tuple3<String, BigInteger, String>> getDapp(String dapp) {
        final Function function = new Function(FUNC_GETDAPP, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(dapp)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Uint256>() {}, new TypeReference<Address>() {}));
        return new RemoteCall<Tuple3<String, BigInteger, String>>(
                new Callable<Tuple3<String, BigInteger, String>>() {
                    @Override
                    public Tuple3<String, BigInteger, String> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple3<String, BigInteger, String>(
                                (String) results.get(0).getValue(), 
                                (BigInteger) results.get(1).getValue(), 
                                (String) results.get(2).getValue());
                    }
                });
    }

    public RemoteCall<String> getWorkUri(byte[] submitTxHash) {
        final Function function = new Function(FUNC_GETWORKURI, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(submitTxHash)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<String> getDappName(String dapp) {
        final Function function = new Function(FUNC_GETDAPPNAME, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(dapp)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<String> getProvider(String dapp) {
        final Function function = new Function(FUNC_GETPROVIDER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(dapp)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> registerDappAndProvider(BigInteger dappPrice, String dappName) {
        final Function function = new Function(
                FUNC_REGISTERDAPPANDPROVIDER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(dappPrice), 
                new org.web3j.abi.datatypes.Utf8String(dappName)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<Boolean> stopped() {
        final Function function = new Function(FUNC_STOPPED, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteCall<String> owner() {
        final Function function = new Function(FUNC_OWNER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<String> iexecOracleEscrow() {
        final Function function = new Function(FUNC_IEXECORACLEESCROW, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<String> getWorkStderr(byte[] submitTxHash) {
        final Function function = new Function(FUNC_GETWORKSTDERR, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(submitTxHash)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> changeCallbackPrice(BigInteger _callbackPrice) {
        final Function function = new Function(
                FUNC_CHANGECALLBACKPRICE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_callbackPrice)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<BigInteger> getWorkStatus(byte[] submitTxHash) {
        final Function function = new Function(FUNC_GETWORKSTATUS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(submitTxHash)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint8>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<String> getWorkStdout(byte[] submitTxHash) {
        final Function function = new Function(FUNC_GETWORKSTDOUT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(submitTxHash)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> submit(String param, BigInteger weiValue) {
        final Function function = new Function(
                FUNC_SUBMIT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(param)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    public RemoteCall<TransactionReceipt> emergencyERC20Drain(String rlcTokenAddress, BigInteger amount) {
        final Function function = new Function(
                FUNC_EMERGENCYERC20DRAIN, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(rlcTokenAddress), 
                new org.web3j.abi.datatypes.generated.Uint256(amount)), 
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

    public RemoteCall<BigInteger> getWorkTimestamp(byte[] submitTxHash) {
        final Function function = new Function(FUNC_GETWORKTIMESTAMP, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(submitTxHash)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public static RemoteCall<IexecOracle> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String _iexecOracleEscrow, BigInteger _callbackPrice) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_iexecOracleEscrow), 
                new org.web3j.abi.datatypes.generated.Uint256(_callbackPrice)));
        return deployRemoteCall(IexecOracle.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static RemoteCall<IexecOracle> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String _iexecOracleEscrow, BigInteger _callbackPrice) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_iexecOracleEscrow), 
                new org.web3j.abi.datatypes.generated.Uint256(_callbackPrice)));
        return deployRemoteCall(IexecOracle.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public List<SubmitEventResponse> getSubmitEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(SUBMIT_EVENT, transactionReceipt);
        ArrayList<SubmitEventResponse> responses = new ArrayList<SubmitEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            SubmitEventResponse typedResponse = new SubmitEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.user = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.dapp = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.provider = (String) eventValues.getIndexedValues().get(2).getValue();
            typedResponse.args = (String) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<SubmitEventResponse> submitEventObservable(EthFilter filter) {
        return web3j.ethLogObservable(filter).map(new Func1<Log, SubmitEventResponse>() {
            @Override
            public SubmitEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(SUBMIT_EVENT, log);
                SubmitEventResponse typedResponse = new SubmitEventResponse();
                typedResponse.log = log;
                typedResponse.user = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.dapp = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.provider = (String) eventValues.getIndexedValues().get(2).getValue();
                typedResponse.args = (String) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Observable<SubmitEventResponse> submitEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(SUBMIT_EVENT));
        return submitEventObservable(filter);
    }

    public List<SubmitCallbackEventResponse> getSubmitCallbackEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(SUBMITCALLBACK_EVENT, transactionReceipt);
        ArrayList<SubmitCallbackEventResponse> responses = new ArrayList<SubmitCallbackEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            SubmitCallbackEventResponse typedResponse = new SubmitCallbackEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.user = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.submitTxHash = (byte[]) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.stdout = (String) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.uri = (String) eventValues.getNonIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<SubmitCallbackEventResponse> submitCallbackEventObservable(EthFilter filter) {
        return web3j.ethLogObservable(filter).map(new Func1<Log, SubmitCallbackEventResponse>() {
            @Override
            public SubmitCallbackEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(SUBMITCALLBACK_EVENT, log);
                SubmitCallbackEventResponse typedResponse = new SubmitCallbackEventResponse();
                typedResponse.log = log;
                typedResponse.user = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.submitTxHash = (byte[]) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.stdout = (String) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse.uri = (String) eventValues.getNonIndexedValues().get(2).getValue();
                return typedResponse;
            }
        });
    }

    public Observable<SubmitCallbackEventResponse> submitCallbackEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(SUBMITCALLBACK_EVENT));
        return submitCallbackEventObservable(filter);
    }

    public List<RegisterEventResponse> getRegisterEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(REGISTER_EVENT, transactionReceipt);
        ArrayList<RegisterEventResponse> responses = new ArrayList<RegisterEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            RegisterEventResponse typedResponse = new RegisterEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.dapp = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.provider = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.dappPrice = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.dappName = (String) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<RegisterEventResponse> registerEventObservable(EthFilter filter) {
        return web3j.ethLogObservable(filter).map(new Func1<Log, RegisterEventResponse>() {
            @Override
            public RegisterEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(REGISTER_EVENT, log);
                RegisterEventResponse typedResponse = new RegisterEventResponse();
                typedResponse.log = log;
                typedResponse.dapp = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.provider = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.dappPrice = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.dappName = (String) eventValues.getNonIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Observable<RegisterEventResponse> registerEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(REGISTER_EVENT));
        return registerEventObservable(filter);
    }

    public List<ErrorEventResponse> getErrorEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(ERROR_EVENT, transactionReceipt);
        ArrayList<ErrorEventResponse> responses = new ArrayList<ErrorEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            ErrorEventResponse typedResponse = new ErrorEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.code = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.message = (String) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<ErrorEventResponse> errorEventObservable(EthFilter filter) {
        return web3j.ethLogObservable(filter).map(new Func1<Log, ErrorEventResponse>() {
            @Override
            public ErrorEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(ERROR_EVENT, log);
                ErrorEventResponse typedResponse = new ErrorEventResponse();
                typedResponse.log = log;
                typedResponse.code = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.message = (String) eventValues.getNonIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Observable<ErrorEventResponse> errorEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(ERROR_EVENT));
        return errorEventObservable(filter);
    }

    public static IexecOracle load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new IexecOracle(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static IexecOracle load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new IexecOracle(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected String getStaticDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static String getPreviouslyDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static class SubmitEventResponse {
        public Log log;

        public String user;

        public String dapp;

        public String provider;

        public String args;
    }

    public static class SubmitCallbackEventResponse {
        public Log log;

        public String user;

        public byte[] submitTxHash;

        public String stdout;

        public String uri;
    }

    public static class RegisterEventResponse {
        public Log log;

        public String dapp;

        public String provider;

        public BigInteger dappPrice;

        public String dappName;
    }

    public static class ErrorEventResponse {
        public Log log;

        public BigInteger code;

        public String message;
    }
}
