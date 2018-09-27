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

### Clone

- Fetch codebase and its submodules

`git clone --recursive https://github.com/jopasserat/iexec-scala-sdk`

### (Re-)Generate solidity contract wrappers

- This should only be needed when updating the [PoCo](sdk/src/main/resources/PoCo) submodule
- From the top level directory of this repository, run:

```bash
for c in sdk/src/main/resources/PoCo/deployed/contracts/*.json; do
  web3j truffle generate $(pwd)/$c -o $(pwd)/abiWrapper/ -p ec.iex
done
```

### Run demo

`sbt "project demo" run`

### Separate project for SDK

`sbt "project sdk" compile`

