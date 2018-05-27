pragma solidity ^0.4.18;
//v1.1.1
import './IexecOracleAPI.sol';
import './IexecOracleEscrow.sol';
import './IexecLib.sol';
import "rlc-token/contracts/Ownable.sol";
import "rlc-token/contracts/RLC.sol";


contract IexecOracle is Ownable {


    bool public stopped = false;
    /*
     * EVENTS AND MODIFIERS
     */
    event Submit(address indexed user, address indexed dapp, address indexed provider, string args); // special log to launch process
    event SubmitCallback(bytes32 submitTxHash, address indexed user, string stdout, string uri);
    event Register(address indexed dapp, address indexed provider,uint256 dappPrice, string dappName);
    event Error(uint code,string message);

    IexecOracleEscrow public iexecOracleEscrow;

    uint256 public callbackPrice;

    struct Work {
      uint256 timestamp;
      IexecLib.StatusEnum status;
      string stdout;
      string stderr;
      string uri;
    }
    //mapping (submitTxHash => Work) workRegistry;
    mapping (bytes32 => Work) workRegistry;

    struct Dapp {
      string dappName;
      uint256 dappPrice;
      address provider;
    }

    //mapping (dapp address => Dapp Struct)
    mapping (address => Dapp ) dappRegistry ;

    modifier stopInEmergency {
      require(!stopped);
      _;
    }

    modifier onlyRegistered(){
        assert(dappRegistry[msg.sender].provider != 0x0);
        _;
    }

    modifier checkCallbackPrice(){
        if(msg.value < callbackPrice){
          Error(1,"msg.value needed for submit callback gas is too low. Check the current callbackPrice");
          revert();
        }
        if(msg.value >= 1 ether){
          Error(2,"msg.value needed for submit callback gas is too high. Must be lower than 1 ether");
          revert();
        }
        _;
    }

    //constructor
    function IexecOracle(address _iexecOracleEscrow,uint256 _callbackPrice) public {
        iexecOracleEscrow=IexecOracleEscrow(_iexecOracleEscrow);
        callbackPrice=_callbackPrice;
    }

    // Circuit Breakers
    function toggleContractActive() onlyOwner public
    {
        stopped = !stopped;
    }

    function registerDappAndProvider(uint256 dappPrice,string dappName) stopInEmergency public  returns (bool) {
        assert(dappRegistry[msg.sender].provider == 0x0);
        assert(msg.sender != tx.origin);
        dappRegistry[msg.sender].provider=tx.origin;
        dappRegistry[msg.sender].dappPrice=dappPrice;
        dappRegistry[msg.sender].dappName=dappName;
        Register(msg.sender,tx.origin,dappPrice,dappName);
        return true;
    }

    function getDapp(address dapp) constant public returns (string dappName, uint256 dappPrice, address provider) {
        return (
        dappRegistry[dapp].dappName,
        dappRegistry[dapp].dappPrice,
        dappRegistry[dapp].provider
        );
    }

    function getProvider(address dapp) constant public returns (address provider) {
        return dappRegistry[dapp].provider;
    }

    function getDappPrice(address dapp) constant public returns (uint256 dappPrice) {
        return dappRegistry[dapp].dappPrice;
    }

    function getDappName(address dapp) constant public returns (string dappName) {
        return dappRegistry[dapp].dappName;
    }

    function getWork(bytes32 submitTxHash) constant public returns (uint256 timestamp, IexecLib.StatusEnum status, string stdout, string stderr, string uri) {
        return (
        workRegistry[submitTxHash].timestamp,
        workRegistry[submitTxHash].status,
        workRegistry[submitTxHash].stdout,
        workRegistry[submitTxHash].stderr,
        workRegistry[submitTxHash].uri
        );
    }

    function getWorkTimestamp(bytes32 submitTxHash) constant public returns (uint256 timestamp) {
        return workRegistry[submitTxHash].timestamp;
    }

    function getWorkStatus(bytes32 submitTxHash) constant public returns (IexecLib.StatusEnum status) {
        return workRegistry[submitTxHash].status;
    }

    function getWorkStdout(bytes32 submitTxHash) constant public returns (string stdout) {
        return workRegistry[submitTxHash].stdout;
    }

    function getWorkStderr(bytes32 submitTxHash) constant public returns (string stderr) {
        return workRegistry[submitTxHash].stderr;
    }

    function getWorkUri(bytes32 submitTxHash) constant public returns (string uri) {
        return workRegistry[submitTxHash].uri;
    }

    function submit(string param) onlyRegistered  checkCallbackPrice stopInEmergency public payable returns (bool){
        uint256 dappPrice=dappRegistry[msg.sender].dappPrice;
        if(dappPrice > 0 ){
            //transfert user RLC deplosit to iexecOracleEscrow
            require(iexecOracleEscrow.rlcDeposit(dappPrice));
        }
        owner.transfer(msg.value);
        Submit(tx.origin, msg.sender,dappRegistry[msg.sender].provider, param);
        return true;
    }

    function submitCallback(bytes32 submitTxHash, address user, address dapp, IexecLib.StatusEnum status, string stdout, string stderr, string uri) stopInEmergency public {
        assert(msg.sender == owner);
        //set StatusEnum.UNSET forbidden
        require(status != IexecLib.StatusEnum.UNSET);
        //only one call is consider if 2 bridges are up thanks to the following check
        require(workRegistry[submitTxHash].status == IexecLib.StatusEnum.UNSET);
        workRegistry[submitTxHash].timestamp=now;
        workRegistry[submitTxHash].status = status;
        workRegistry[submitTxHash].stdout = stdout;
        workRegistry[submitTxHash].stderr = stderr;
        workRegistry[submitTxHash].uri = uri;
        SubmitCallback(submitTxHash,user,stdout,uri);
        iexecSubmitCallback(submitTxHash,dapp,user,stdout,uri);
        uint256 dappPrice=dappRegistry[dapp].dappPrice;
        if(dappPrice > 0 ){
            if(status == IexecLib.StatusEnum.COMPLETED){
                require(iexecOracleEscrow.rlcPayment(dappRegistry[dapp].provider,dappPrice));
            }
            if(status == IexecLib.StatusEnum.ERROR){
                require(iexecOracleEscrow.rlcPayment(user,dappPrice));
            }
        }
    }

    function changeCallbackPrice(uint256 _callbackPrice) public {
        assert(msg.sender == owner);
        callbackPrice=_callbackPrice;
    }

    function iexecSubmitCallback(bytes32 submitTxHash, address dapp, address user, string stdout, string uri) internal {
        IexecOracleAPI iexecOracleAPI = IexecOracleAPI(dapp);
        require(iexecOracleAPI.iexecSubmitCallback(submitTxHash,user,stdout,uri));
    }

    /**
    * transfer to owner any tokens send by mistake on this contracts
    */
    function emergencyERC20Drain(address rlcTokenAddress, uint amount) public onlyOwner {
        RLC rlcToken = RLC(rlcTokenAddress);
        rlcToken.transfer(owner, amount);
    }

}
