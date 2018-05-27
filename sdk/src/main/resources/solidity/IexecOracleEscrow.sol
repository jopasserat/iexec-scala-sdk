pragma solidity ^0.4.18;
//v1.1.1
import "rlc-token/contracts/RLC.sol";
import "rlc-token/contracts/Ownable.sol";


contract IexecOracleEscrow is Ownable {

    RLC public rlcToken;

    mapping(address=>bool) public iexecOracleRegistered;

    modifier onlyOwnerOrOracleRegistered(){
        assert( iexecOracleRegistered[msg.sender] ||  msg.sender == owner );
        _;
    }

    //constructor
    function IexecOracleEscrow(address _tokenAddress) public {
        rlcToken = RLC(_tokenAddress);
    }

    function changeIexecOracleRegistrationStatus(address target, bool isRegistered) public onlyOwner {
        iexecOracleRegistered[target] = isRegistered;
    }

    function changeIexecOracleRegistrationStatuses(address[] targets, bool isRegistered) public onlyOwner {
        for (uint i = 0; i < targets.length; i++) {
            changeIexecOracleRegistrationStatus(targets[i], isRegistered);
        }
    }

    function rlcDeposit(uint256 dappPrice) public onlyOwnerOrOracleRegistered returns (bool){
        require(rlcToken.transferFrom(tx.origin,this,dappPrice));
        return true;
    }

    function rlcPayment(address beneficiary ,uint256 dappPrice) public onlyOwnerOrOracleRegistered returns (bool){
        require(rlcToken.transfer(beneficiary,dappPrice));
        return true;
    }

    function isIexecOracleRegistered(address target) constant public returns (bool){
      return iexecOracleRegistered[target];
    }

}
