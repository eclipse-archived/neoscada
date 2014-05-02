#!/bin/bash

#*******************************************************************************
# Copyright (c) 2013 IBH SYSTEMS GmbH and others.
# All rights reserved. This program and the accompanying materials
# are made available under the terms of the Eclipse Public License v1.0
# which accompanies this distribution, and is available at
# http://www.eclipse.org/legal/epl-v10.html
#
# Contributors:
#     IBH SYSTEMS GmbH - initial API and implementation
#*******************************************************************************

. /etc/default/eclipsescada

cd ~eclipsescada/@@appName@@
exec screen -d -m -S "@@appName@@" /bin/bash -c 'echo $$ > /var/run/eclipsescada/scada.app.@@appName@@.pid; exec ./launcher'
