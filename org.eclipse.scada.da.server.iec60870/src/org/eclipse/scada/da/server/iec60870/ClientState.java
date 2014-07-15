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
package org.eclipse.scada.da.server.iec60870;

import org.eclipse.scada.da.server.common.exporter.ItemOptions;
import org.eclipse.scada.utils.beans.AbstractPropertyChange;

public class ClientState extends AbstractPropertyChange
{
    public static final String PROP_CONNECTION_STATE = "connectionState";

    @ItemOptions ( readonly = true )
    private String connectionState;

    public void setConnectionState ( final String connectionState )
    {
        firePropertyChange ( PROP_CONNECTION_STATE, this.connectionState, this.connectionState = connectionState );
    }

    public String getConnectionState ()
    {
        return this.connectionState;
    }
}
