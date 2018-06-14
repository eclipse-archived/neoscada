#!/bin/bash

USER=neoscada

. /etc/default/$USER

cd ~$USER/"@@appName@@"
exec screen -D -m -S "@@appName@@" ./launcher
