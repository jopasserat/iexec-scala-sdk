# iExec Scala SDK (Small Development Toolkit...)

## Pre-requisites

### Import iExec wallet into geth

`geth account import ./iexec_wallet_priv.key`

### Generate contracts wrappers with web3j

- Install web3j command line utilities: https://docs.web3j.io/command_line.html
- From an iExec DApp folder
```
npm install
truffle compile --all --network ropsten
for c in $(pwd)/build/contracts/*.json; do web3j truffle generate $c -o /tmp/Factorial -p ec.iex; done
```


## Build and run


### Run demo

`sbt "project demo" run`

### Separate project for SDK

`sbt "project sdk" compile`

