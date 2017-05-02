/*******************************************************************************
 * Copyright (c) 2010, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     IBH SYSTEMS GmbH - refactor for generic memory devices
 *******************************************************************************/
package org.eclipse.scada.da.server.common.memory;

import org.apache.mina.core.buffer.IoBuffer;
import org.eclipse.scada.core.Variant;
import org.osgi.framework.BundleContext;

public class UdtVariable implements Variable
{
    private final String name;

    private final Variable[] variables;

    private final int index;

    public UdtVariable ( final String name, final int index, final Variable... variables )
    {
        this.name = name;
        this.index = index;
        this.variables = variables;
        if ( variables == null )
        {
            throw new NullPointerException ( "'variables' must not be null" );
        }
    }

    @Override
    public void handleData ( final IoBuffer data, final Variant timestamp )
    {
        for ( final Variable var : this.variables )
        {
            var.handleData ( data, timestamp );
        }
    }

    @Override
    public void handleError ( final int errorCode )
    {
        for ( final Variable var : this.variables )
        {
            var.handleError ( errorCode );
        }
    }

    @Override
    public void handleDisconnect ()
    {
        for ( final Variable var : this.variables )
        {
            var.handleDisconnect ();
        }
    }

    @Override
    public void handleFailure ( final Throwable e )
    {
        for ( final Variable var : this.variables )
        {
            var.handleFailure ( e );
        }
    }

    @Override
    public void start ( final String parentName, final BundleContext context, final MemoryRequestBlock block, final int offset )
    {
        String itemId;
        if ( parentName != null )
        {
            itemId = parentName + "." + this.name;
        }
        else
        {
            itemId = this.name;
        }

        for ( final Variable var : this.variables )
        {
            var.start ( itemId, context, block, offset + this.index );
        }
    }

    @Override
    public void stop ( final BundleContext context )
    {
        for ( final Variable var : this.variables )
        {
            var.stop ( context );
        }
    }

}
