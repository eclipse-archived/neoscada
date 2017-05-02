#!/bin/bash

. /etc/default/eclipsescada

cd ~eclipsescada/"@@appName@@"
exec screen -D -m -S "@@appName@@" ./launcher
