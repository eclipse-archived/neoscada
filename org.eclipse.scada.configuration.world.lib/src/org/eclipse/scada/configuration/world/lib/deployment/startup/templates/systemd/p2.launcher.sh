#!/bin/bash

. /etc/default/eclipsescada

cd ~eclipsescada/"@@appName@@"
exec screen -d -m -S "@@appName@@" ./launcher
