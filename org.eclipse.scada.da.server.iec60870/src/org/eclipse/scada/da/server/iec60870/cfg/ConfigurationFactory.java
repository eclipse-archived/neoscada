/*******************************************************************************
 * Copyright (c) 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.server.iec60870.cfg;

import org.eclipse.scada.da.server.iec60870.ConnectionConfiguration;

import com.google.common.util.concurrent.ListenableFuture;

public interface ConfigurationFactory
{
    public interface Receiver
    {
        public ListenableFuture<Void> addConnection ( String id, ConnectionConfiguration configuration );

        public void removeConnection ( String id );
    }

    public void setReceiver ( Receiver receiver );
}
