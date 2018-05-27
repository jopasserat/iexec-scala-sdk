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
 * <p>Generated with web3j version 3.3.1.
 */
public class IexecOracle extends Contract {
    private static final String BINARY = "0x608060405260008060146101000a81548160ff02191690831515021790555034801561002a57600080fd5b506040516040806129a68339810180604052810190808051906020019092919080519060200190929190505050336000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555081600160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055508060028190555050506128b6806100f06000396000f30060806040526004361061011d576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff1680631385d24c146101225780631692c89b146101395780631b0935661461019057806330266537146102e057806333d4da2a1461047e578063496bd3df146104a95780634bbed29c1461059f57806352dd94cc1461064957806355f21eb7146107055780635993ef531461078857806375f12b21146108135780638da5cb5b1461084257806392556147146108995780639e1c466f146108f0578063af5a02a41461099a578063cddc3b0a146109c7578063d543c28d14610a1a578063d99a8dc314610ac4578063db0e16f114610b38578063f2fde38b14610b85578063f5923e7e14610bc8575b600080fd5b34801561012e57600080fd5b50610137610c0d565b005b34801561014557600080fd5b5061017a600480360381019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050610c8f565b6040518082815260200191505060405180910390f35b34801561019c57600080fd5b506102de6004803603810190808035600019169060200190929190803573ffffffffffffffffffffffffffffffffffffffff169060200190929190803573ffffffffffffffffffffffffffffffffffffffff169060200190929190803560ff169060200190929190803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509192919290803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509192919290803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509192919290505050610cdb565b005b3480156102ec57600080fd5b5061030f600480360381019080803560001916906020019092919050505061130e565b6040518086815260200185600581111561032557fe5b60ff168152602001806020018060200180602001848103845287818151815260200191508051906020019080838360005b83811015610371578082015181840152602081019050610356565b50505050905090810190601f16801561039e5780820380516001836020036101000a031916815260200191505b50848103835286818151815260200191508051906020019080838360005b838110156103d75780820151818401526020810190506103bc565b50505050905090810190601f1680156104045780820380516001836020036101000a031916815260200191505b50848103825285818151815260200191508051906020019080838360005b8381101561043d578082015181840152602081019050610422565b50505050905090810190601f16801561046a5780820380516001836020036101000a031916815260200191505b509850505050505050505060405180910390f35b34801561048a57600080fd5b506104936115a2565b6040518082815260200191505060405180910390f35b3480156104b557600080fd5b506104ea600480360381019080803573ffffffffffffffffffffffffffffffffffffffff1690602001909291905050506115a8565b60405180806020018481526020018373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001828103825285818151815260200191508051906020019080838360005b83811015610562578082015181840152602081019050610547565b50505050905090810190601f16801561058f5780820380516001836020036101000a031916815260200191505b5094505050505060405180910390f35b3480156105ab57600080fd5b506105ce600480360381019080803560001916906020019092919050505061173e565b6040518080602001828103825283818151815260200191508051906020019080838360005b8381101561060e5780820151818401526020810190506105f3565b50505050905090810190601f16801561063b5780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b34801561065557600080fd5b5061068a600480360381019080803573ffffffffffffffffffffffffffffffffffffffff1690602001909291905050506117fe565b6040518080602001828103825283818151815260200191508051906020019080838360005b838110156106ca5780820151818401526020810190506106af565b50505050905090810190601f1680156106f75780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b34801561071157600080fd5b50610746600480360381019080803573ffffffffffffffffffffffffffffffffffffffff1690602001909291905050506118e2565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b34801561079457600080fd5b506107f960048036038101908080359060200190929190803590602001908201803590602001908080601f016020809104026020016040519081016040528093929190818152602001838380828437820191505050505050919291929050505061194e565b604051808215151515815260200191505060405180910390f35b34801561081f57600080fd5b50610828611c22565b604051808215151515815260200191505060405180910390f35b34801561084e57600080fd5b50610857611c35565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b3480156108a557600080fd5b506108ae611c5a565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b3480156108fc57600080fd5b5061091f6004803603810190808035600019169060200190929190505050611c80565b6040518080602001828103825283818151815260200191508051906020019080838360005b8381101561095f578082015181840152602081019050610944565b50505050905090810190601f16801561098c5780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b3480156109a657600080fd5b506109c560048036038101908080359060200190929190505050611d40565b005b3480156109d357600080fd5b506109f66004803603810190808035600019169060200190929190505050611da2565b60405180826005811115610a0657fe5b60ff16815260200191505060405180910390f35b348015610a2657600080fd5b50610a496004803603810190808035600019169060200190929190505050611dd7565b6040518080602001828103825283818151815260200191508051906020019080838360005b83811015610a89578082015181840152602081019050610a6e565b50505050905090810190601f168015610ab65780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b610b1e600480360381019080803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509192919290505050611e97565b604051808215151515815260200191505060405180910390f35b348015610b4457600080fd5b50610b83600480360381019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190803590602001909291905050506123b5565b005b348015610b9157600080fd5b50610bc6600480360381019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050612515565b005b348015610bd457600080fd5b50610bf760048036038101908080356000191690602001909291905050506125e5565b6040518082815260200191505060405180910390f35b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff161415610c8d57600060149054906101000a900460ff1615600060146101000a81548160ff0219169083151502179055505b565b6000600460008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020600101549050919050565b60008060149054906101000a900460ff16151515610cf857600080fd5b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16141515610d5057fe5b60006005811115610d5d57fe5b856005811115610d6957fe5b14151515610d7657600080fd5b60006005811115610d8357fe5b600360008a6000191660001916815260200190815260200160002060010160009054906101000a900460ff166005811115610dba57fe5b141515610dc657600080fd5b42600360008a600019166000191681526020019081526020016000206000018190555084600360008a6000191660001916815260200190815260200160002060010160006101000a81548160ff02191690836005811115610e2357fe5b021790555083600360008a600019166000191681526020019081526020016000206002019080519060200190610e5a9291906127e5565b5082600360008a600019166000191681526020019081526020016000206003019080519060200190610e8d9291906127e5565b5081600360008a600019166000191681526020019081526020016000206004019080519060200190610ec09291906127e5565b508673ffffffffffffffffffffffffffffffffffffffff167f06239fa7a3489329ee223aa89190ea8412cf24599da9c43000047862209fbe3b8986856040518084600019166000191681526020018060200180602001838103835285818151815260200191508051906020019080838360005b83811015610f4e578082015181840152602081019050610f33565b50505050905090810190601f168015610f7b5780820380516001836020036101000a031916815260200191505b50838103825284818151815260200191508051906020019080838360005b83811015610fb4578082015181840152602081019050610f99565b50505050905090810190601f168015610fe15780820380516001836020036101000a031916815260200191505b509550505050505060405180910390a2610ffe888789878661260d565b600460008773ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000206001015490506000811115611304576004600581111561105957fe5b85600581111561106557fe5b14156111d957600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663bfd24f40600460008973ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060020160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff16836040518363ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200182815260200192505050602060405180830381600087803b15801561119257600080fd5b505af11580156111a6573d6000803e3d6000fd5b505050506040513d60208110156111bc57600080fd5b810190808051906020019092919050505015156111d857600080fd5b5b6005808111156111e557fe5b8560058111156111f157fe5b141561130357600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663bfd24f4088836040518363ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200182815260200192505050602060405180830381600087803b1580156112bc57600080fd5b505af11580156112d0573d6000803e3d6000fd5b505050506040513d60208110156112e657600080fd5b8101908080519060200190929190505050151561130257600080fd5b5b5b5050505050505050565b60008060608060606003600087600019166000191681526020019081526020016000206000015460036000886000191660001916815260200190815260200160002060010160009054906101000a900460ff16600360008960001916600019168152602001908152602001600020600201600360008a60001916600019168152602001908152602001600020600301600360008b60001916600019168152602001908152602001600020600401828054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156114505780601f1061142557610100808354040283529160200191611450565b820191906000526020600020905b81548152906001019060200180831161143357829003601f168201915b50505050509250818054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156114ec5780601f106114c1576101008083540402835291602001916114ec565b820191906000526020600020905b8154815290600101906020018083116114cf57829003601f168201915b50505050509150808054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156115885780601f1061155d57610100808354040283529160200191611588565b820191906000526020600020905b81548152906001019060200180831161156b57829003601f168201915b505050505090509450945094509450945091939590929450565b60025481565b6060600080600460008573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020600001600460008673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060010154600460008773ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060020160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff16828054600181600116156101000203166002900480601f01602080910402602001604051908101604052809291908181526020018280546001816001161561010002031660029004801561172a5780601f106116ff5761010080835404028352916020019161172a565b820191906000526020600020905b81548152906001019060200180831161170d57829003601f168201915b505050505092509250925092509193909250565b60606003600083600019166000191681526020019081526020016000206004018054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156117f25780601f106117c7576101008083540402835291602001916117f2565b820191906000526020600020905b8154815290600101906020018083116117d557829003601f168201915b50505050509050919050565b6060600460008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000206000018054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156118d65780601f106118ab576101008083540402835291602001916118d6565b820191906000526020600020905b8154815290600101906020018083116118b957829003601f168201915b50505050509050919050565b6000600460008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060020160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff169050919050565b60008060149054906101000a900460ff1615151561196b57600080fd5b6000600460003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060020160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff161415156119ef57fe5b3273ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff1614151515611a2757fe5b32600460003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060020160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555082600460003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000206001018190555081600460003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000206000019080519060200190611b459291906127e5565b503273ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff167faf5012f155004010b6b3ae7a6355778f4d22bb65d1ca74541e78696e41a448c085856040518083815260200180602001828103825283818151815260200191508051906020019080838360005b83811015611bdd578082015181840152602081019050611bc2565b50505050905090810190601f168015611c0a5780820380516001836020036101000a031916815260200191505b50935050505060405180910390a36001905092915050565b600060149054906101000a900460ff1681565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b60606003600083600019166000191681526020019081526020016000206003018054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015611d345780601f10611d0957610100808354040283529160200191611d34565b820191906000526020600020905b815481529060010190602001808311611d1757829003601f168201915b50505050509050919050565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16141515611d9857fe5b8060028190555050565b600060036000836000191660001916815260200190815260200160002060010160009054906101000a900460ff169050919050565b60606003600083600019166000191681526020019081526020016000206002018054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015611e8b5780601f10611e6057610100808354040283529160200191611e8b565b820191906000526020600020905b815481529060010190602001808311611e6e57829003601f168201915b50505050509050919050565b6000806000600460003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060020160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1614151515611f1f57fe5b600254341015611feb577fc548eaddad03c946ad5228a88cfbd752439e312a7b29b7e8791a0b5fe143584c60016040518082815260200180602001828103825260548152602001807f6d73672e76616c7565206e656564656420666f72207375626d69742063616c6c81526020017f6261636b2067617320697320746f6f206c6f772e20436865636b20746865206381526020017f757272656e742063616c6c6261636b50726963650000000000000000000000008152506060019250505060405180910390a1600080fd5b670de0b6b3a7640000341015156120be577fc548eaddad03c946ad5228a88cfbd752439e312a7b29b7e8791a0b5fe143584c60026040518082815260200180602001828103825260508152602001807f6d73672e76616c7565206e656564656420666f72207375626d69742063616c6c81526020017f6261636b2067617320697320746f6f20686967682e204d757374206265206c6f81526020017f776572207468616e2031206574686572000000000000000000000000000000008152506060019250505060405180910390a1600080fd5b600060149054906101000a900460ff161515156120da57600080fd5b600460003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020600101549050600081111561220057600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663bbc88c5d826040518263ffffffff167c010000000000000000000000000000000000000000000000000000000002815260040180828152602001915050602060405180830381600087803b1580156121b957600080fd5b505af11580156121cd573d6000803e3d6000fd5b505050506040513d60208110156121e357600080fd5b810190808051906020019092919050505015156121ff57600080fd5b5b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166108fc349081150290604051600060405180830381858888f19350505050158015612267573d6000803e3d6000fd5b50600460003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060020160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff163273ffffffffffffffffffffffffffffffffffffffff167f743a962df271a2e268a671fb94be36697104681af61a64ccdf1dcf924035fdcd866040518080602001828103825283818151815260200191508051906020019080838360005b83811015612371578082015181840152602081019050612356565b50505050905090810190601f16801561239e5780820380516001836020036101000a031916815260200191505b509250505060405180910390a46001915050919050565b60008060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff161415612510578290508073ffffffffffffffffffffffffffffffffffffffff1663a9059cbb6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff16846040518363ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200182815260200192505050602060405180830381600087803b1580156124d357600080fd5b505af11580156124e7573d6000803e3d6000fd5b505050506040513d60208110156124fd57600080fd5b8101908080519060200190929190505050505b505050565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff1614156125e257600073ffffffffffffffffffffffffffffffffffffffff168173ffffffffffffffffffffffffffffffffffffffff161415156125e157806000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055505b5b50565b6000600360008360001916600019168152602001908152602001600020600001549050919050565b60008490508073ffffffffffffffffffffffffffffffffffffffff166310a9f201878686866040518563ffffffff167c01000000000000000000000000000000000000000000000000000000000281526004018085600019166000191681526020018473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018060200180602001838103835285818151815260200191508051906020019080838360005b838110156126e15780820151818401526020810190506126c6565b50505050905090810190601f16801561270e5780820380516001836020036101000a031916815260200191505b50838103825284818151815260200191508051906020019080838360005b8381101561274757808201518184015260208101905061272c565b50505050905090810190601f1680156127745780820380516001836020036101000a031916815260200191505b509650505050505050602060405180830381600087803b15801561279757600080fd5b505af11580156127ab573d6000803e3d6000fd5b505050506040513d60208110156127c157600080fd5b810190808051906020019092919050505015156127dd57600080fd5b505050505050565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f1061282657805160ff1916838001178555612854565b82800160010185558215612854579182015b82811115612853578251825591602001919060010190612838565b5b5090506128619190612865565b5090565b61288791905b8082111561288357600081600090555060010161286b565b5090565b905600a165627a7a72305820c6902eda97dfe3ac79631fd8c0dcd6deaadde4ccd3b63c5f61686b96ce3f0d260029";

    protected static final HashMap<String, String> _addresses;

    static {
        _addresses = new HashMap<>();
    }

    protected IexecOracle(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected IexecOracle(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public List<SubmitEventResponse> getSubmitEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("Submit", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}, new TypeReference<Address>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(event, transactionReceipt);
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

    public Observable<SubmitEventResponse> submitEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("Submit", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}, new TypeReference<Address>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, SubmitEventResponse>() {
            @Override
            public SubmitEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(event, log);
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

    public List<SubmitCallbackEventResponse> getSubmitCallbackEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("SubmitCallback", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}));
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(event, transactionReceipt);
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

    public Observable<SubmitCallbackEventResponse> submitCallbackEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("SubmitCallback", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, SubmitCallbackEventResponse>() {
            @Override
            public SubmitCallbackEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(event, log);
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

    public List<RegisterEventResponse> getRegisterEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("Register", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Utf8String>() {}));
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(event, transactionReceipt);
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

    public Observable<RegisterEventResponse> registerEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("Register", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Utf8String>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, RegisterEventResponse>() {
            @Override
            public RegisterEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(event, log);
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

    public List<ErrorEventResponse> getErrorEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("Error", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Utf8String>() {}));
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(event, transactionReceipt);
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

    public Observable<ErrorEventResponse> errorEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("Error", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Utf8String>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, ErrorEventResponse>() {
            @Override
            public ErrorEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(event, log);
                ErrorEventResponse typedResponse = new ErrorEventResponse();
                typedResponse.log = log;
                typedResponse.code = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.message = (String) eventValues.getNonIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public RemoteCall<BigInteger> callbackPrice() {
        final Function function = new Function("callbackPrice", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<Boolean> stopped() {
        final Function function = new Function("stopped", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteCall<String> owner() {
        final Function function = new Function("owner", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<String> iexecOracleEscrow() {
        final Function function = new Function("iexecOracleEscrow", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> transferOwnership(String newOwner) {
        final Function function = new Function(
                "transferOwnership", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(newOwner)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
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

    public RemoteCall<TransactionReceipt> toggleContractActive() {
        final Function function = new Function(
                "toggleContractActive", 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> registerDappAndProvider(BigInteger dappPrice, String dappName) {
        final Function function = new Function(
                "registerDappAndProvider", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(dappPrice), 
                new org.web3j.abi.datatypes.Utf8String(dappName)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<Tuple3<String, BigInteger, String>> getDapp(String dapp) {
        final Function function = new Function("getDapp", 
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

    public RemoteCall<String> getProvider(String dapp) {
        final Function function = new Function("getProvider", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(dapp)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<BigInteger> getDappPrice(String dapp) {
        final Function function = new Function("getDappPrice", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(dapp)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<String> getDappName(String dapp) {
        final Function function = new Function("getDappName", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(dapp)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<Tuple5<BigInteger, BigInteger, String, String, String>> getWork(byte[] submitTxHash) {
        final Function function = new Function("getWork", 
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

    public RemoteCall<BigInteger> getWorkTimestamp(byte[] submitTxHash) {
        final Function function = new Function("getWorkTimestamp", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(submitTxHash)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> getWorkStatus(byte[] submitTxHash) {
        final Function function = new Function("getWorkStatus", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(submitTxHash)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint8>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<String> getWorkStdout(byte[] submitTxHash) {
        final Function function = new Function("getWorkStdout", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(submitTxHash)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<String> getWorkStderr(byte[] submitTxHash) {
        final Function function = new Function("getWorkStderr", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(submitTxHash)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<String> getWorkUri(byte[] submitTxHash) {
        final Function function = new Function("getWorkUri", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(submitTxHash)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> submit(String param, BigInteger weiValue) {
        final Function function = new Function(
                "submit", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(param)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    public RemoteCall<TransactionReceipt> submitCallback(byte[] submitTxHash, String user, String dapp, BigInteger status, String stdout, String stderr, String uri) {
        final Function function = new Function(
                "submitCallback", 
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

    public RemoteCall<TransactionReceipt> changeCallbackPrice(BigInteger _callbackPrice) {
        final Function function = new Function(
                "changeCallbackPrice", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_callbackPrice)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> emergencyERC20Drain(String rlcTokenAddress, BigInteger amount) {
        final Function function = new Function(
                "emergencyERC20Drain", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(rlcTokenAddress), 
                new org.web3j.abi.datatypes.generated.Uint256(amount)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
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
