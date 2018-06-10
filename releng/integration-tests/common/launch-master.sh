#!/bin/bash

echo "starting ..."
pushd /var/lib/eclipsescada/master
pwd
sudo -g eclipsescada -u eclipsescada /var/lib/eclipsescada/master/launcher
