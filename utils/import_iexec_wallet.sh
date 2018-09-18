#!/bin/bash

iexec_wallet=$1
tmp_priv_key_file=$(mktemp)
tmp_keystore=$(mktemp -d)

awk 'match($0, /"privateKey": "0x(.*)",/, a) {print a[1]}' "${iexec_wallet}" > "${tmp_priv_key_file}"

geth account import --keystore "${tmp_keystore}" "${tmp_priv_key_file}"
parity account import "${tmp_keystore}" --chain=kovan

#rm "${tmp_priv_key_file}"
rm -rf "${tmp_keystore}"

