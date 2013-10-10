/*******************************************************************************
 * Copyright (c) 2010, 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.core.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The connect wait controller makes the {@link Connection#connect()} call a synchronous operation
 * 
 * @author Jens Reimann
 */
public class ConnectWaitController implements ConnectionStateListener
{
    private final static Logger logger = LoggerFactory.getLogger ( ConnectWaitController.class );

    private final Connection connection;

    private ConnectionState state;

    private Throwable error;

    public ConnectWaitController ( final Connection connection )
    {
        super ();
        this.connection = connection;
    }

    public synchronized void connect () throws Exception
    {
        connect ( 0 );
    }

    public synchronized void connect ( final int timeout ) throws Exception
    {
        try
        {
            this.state = this.connection.getState ();
            this.connection.addConnectionStateListener ( this );
            this.connection.connect ();
            switch ( this.state )
            {
                case BOUND:
                    return;
                case CLOSED:
                    if ( this.error == null )
                    {
                        return;
                    }
                    else
                    {
                        throw new Exception ( this.error );
                    }
                default:
                    break;
            }

            wait ( timeout );
            if ( this.error != null )
            {
                throw new Exception ( this.error );
            }
        }
        finally
        {
            this.connection.removeConnectionStateListener ( this );
        }
    }

    @Override
    public synchronized void stateChange ( final Connection connection, final ConnectionState state, final Throwable error )
    {
        logger.info ( String.format ( "New connection state: %s", state ) );
        this.state = state;
        this.error = error;

        switch ( state )
        {
            case BOUND:
                notifyAll ();
                break;
            case CLOSED:
                notifyAll ();
                break;
            default:
                break;
        }
    }
}
