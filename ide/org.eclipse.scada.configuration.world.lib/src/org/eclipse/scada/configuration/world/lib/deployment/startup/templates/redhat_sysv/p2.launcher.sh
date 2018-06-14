#!/bin/bash

USER=neoscada

. /etc/default/$USER

cd ~$USER/@@appName@@
exec screen -d -m -S "@@appName@@" /bin/bash -c 'echo $$ > /var/run/scada.app.@@appName@@.pid; exec ./launcher'
