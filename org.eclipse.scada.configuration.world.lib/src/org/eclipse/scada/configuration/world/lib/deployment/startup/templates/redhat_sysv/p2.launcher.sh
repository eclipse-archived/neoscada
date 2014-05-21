#!/bin/bash

. /etc/default/eclipsescada

cd ~eclipsescada/@@appName@@
exec screen -d -m -S "@@appName@@" /bin/bash -c 'echo $$ > /var/run/eclipsescada/scada.app.@@appName@@.pid; exec ./launcher'
