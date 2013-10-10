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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AbstractAttribute
{
    private final static Logger logger = LoggerFactory.getLogger ( AbstractAttribute.class );

    protected final String name;

    protected int offset;

    protected MemoryRequestBlock block;

    private boolean stopped;

    public AbstractAttribute ( final String name )
    {
        super ();
        this.name = name;
        this.stopped = true;
    }

    public String getName ()
    {
        return this.name;
    }

    public void start ( final MemoryRequestBlock block, final int offset )
    {
        logger.debug ( "Starting attribute: {}", this.name );
        this.stopped = false;

        assert block != null;

        this.block = block;
        this.offset = offset;
    }

    public void stop ()
    {
        logger.debug ( "Stopping attribute: {}", this.name );

        this.stopped = true;
        this.block = null;
    }

    protected int toAddress ( final int localAddress )
    {
        if ( this.stopped || this.block == null )
        {
            logger.error ( "isStopped" );
        }

        return localAddress + this.offset - this.block.getStartAddress ();
    }

}