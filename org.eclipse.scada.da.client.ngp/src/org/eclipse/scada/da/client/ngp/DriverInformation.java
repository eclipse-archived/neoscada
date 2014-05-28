/*******************************************************************************
 * Copyright (c) 2012, 2014 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     IBH SYSTEMS GmbH - allow shared socket connectors
 *******************************************************************************/
package org.eclipse.scada.da.client.ngp;

import org.apache.mina.core.service.IoProcessor;
import org.apache.mina.transport.socket.nio.NioSession;
import org.eclipse.scada.core.ConnectionInformation;
import org.eclipse.scada.core.client.Connection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DriverInformation implements org.eclipse.scada.core.client.DriverInformation
{

    private final static Logger logger = LoggerFactory.getLogger ( DriverInformation.class );

    private final IoProcessor<NioSession> processor;

    public DriverInformation ()
    {
        this ( null );
    }

    public DriverInformation ( final IoProcessor<NioSession> processor )
    {
        this.processor = processor;
    }

    @Override
    public Connection create ( final ConnectionInformation connectionInformation )
    {
        if ( connectionInformation.getSecondaryTarget () == null )
        {
            return null;
        }

        try
        {
            return new org.eclipse.scada.da.client.ngp.ConnectionImpl ( connectionInformation, this.processor );
        }
        catch ( final Exception e )
        {
            logger.warn ( "Failed to create connection", e );
            return null;
        }
    }

    @Override
    public Class<?> getConnectionClass ()
    {
        return org.eclipse.scada.da.client.ngp.ConnectionImpl.class;
    }

    @Override
    public void validate ( final ConnectionInformation connectionInformation ) throws Throwable
    {
    }

}
