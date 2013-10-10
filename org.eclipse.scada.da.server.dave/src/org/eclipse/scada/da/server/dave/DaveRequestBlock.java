/*******************************************************************************
 * Copyright (c) 2009, 2011 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     IBH SYSTEMS GmbH - additional work
 *******************************************************************************/
package org.eclipse.scada.da.server.dave;

import org.eclipse.scada.da.server.common.memory.AbstractRequestBlock;
import org.eclipse.scada.protocol.dave.DaveReadRequest;
import org.eclipse.scada.protocol.dave.DaveReadResult;
import org.eclipse.scada.protocol.dave.DaveReadRequest.Request;
import org.eclipse.scada.protocol.dave.DaveReadResult.Result;
import org.osgi.framework.BundleContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DaveRequestBlock extends AbstractRequestBlock
{
    private final static Logger logger = LoggerFactory.getLogger ( DaveRequestBlock.class );

    private final Request request;

    private final DaveDevice device;

    public DaveRequestBlock ( final String id, final String name, final String mainTypeName, final DaveDevice device, final BundleContext context, final Request request, final boolean enableStatistics, final long period )
    {
        super ( context, device.getExecutor (), mainTypeName, device.getVarItemId ( name ), device.getItemId ( id ), enableStatistics, period, request.getCount (), 0L, true );

        this.device = device;
        this.request = request;
    }

    @Override
    public long getPollRequestTimeout ()
    {
        return 0;
    }

    /**
     * The the configured request
     * 
     * @return the request
     */
    public Request getRequest ()
    {
        return this.request;
    }

    /**
     * Handle a response from the device
     * 
     * @param response
     *            the response to handle
     */
    public synchronized void handleResponse ( final Result response )
    {
        if ( response.isError () )
        {
            handleError ( response.getError () );
        }
        else
        {
            handleData ( response.getData () );
        }
    }

    @Override
    public void handleTimeout ()
    {
        // this is a no-op since we don't have poll timeouts
    }

    @Override
    public String toString ()
    {
        return String.format ( "[Request - %s]", this.request );
    }

    @Override
    public boolean handleMessage ( final Object message )
    {
        if ( message instanceof DaveReadResult )
        {
            // we should have exactly one reply
            for ( final Result result : ( (DaveReadResult)message ).getResult () )
            {
                handleResponse ( result );
                return true;
            }
        }
        else
        {
            logger.warn ( "Got wrong message as reply: {}", message );
        }
        return false;
    }

    @Override
    public Object createPollRequest ()
    {
        final DaveReadRequest request = new DaveReadRequest ();
        request.addRequest ( this.request );
        return request;
    }

    @Override
    public int getStartAddress ()
    {
        return this.request.getStart ();
    }

    private int toGlobalAddress ( final int address )
    {
        return address + this.request.getStart ();
    }

    @Override
    public void writeBit ( final int address, final int subIndex, final boolean value )
    {
        this.device.writeBit ( this, toGlobalAddress ( address ), subIndex, value );
    }

    @Override
    public void writeData ( final int blockAddress, final byte[] data )
    {
        this.device.writeData ( this, toGlobalAddress ( blockAddress ), data );
    }
}
