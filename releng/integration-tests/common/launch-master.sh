#!/bin/bash

echo "starting ..."
pushd /var/lib/neoscada/master
pwd
sudo -g neoscada -u neoscada /var/lib/neoscada/master/launcher
