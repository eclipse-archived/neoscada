/*******************************************************************************
 * Copyright (c) 2013 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.server.exporter.rest.internal;

import java.util.Map;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.Variant;

import org.eclipse.scada.da.client.DataItemValue;
import org.eclipse.scada.da.server.exporter.rest.ItemResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ItemResourceImpl implements ItemResource
{
    private final static Logger logger = LoggerFactory.getLogger ( ItemResourceImpl.class );

    private DataContextProvider provider;

    public void setProvider ( final DataContextProvider provider )
    {
        this.provider = provider;
    }

    @Override
    public DataItemValue read ( final String contextId, final String itemId )
    {
        logger.trace ( "Reading - contextId: {}, itemId: {}", contextId, itemId );

        final DataContext context = this.provider.getContext ( contextId );

        if ( context == null )
        {
            logger.trace ( "Context not found" );
            throw new WebApplicationException ( Status.NOT_FOUND );
        }

        final DataItemValue value = context.getValue ( itemId );
        if ( value == null )
        {
            logger.trace ( "Item not found" );
            throw new WebApplicationException ( Status.NOT_FOUND );
        }

        return value;
    }

    @Override
    public void write ( final String contextId, final String itemId, final Variant value )
    {
        // TODO Auto-generated method stub
    }

    @Override
    public void writeAttribute ( final String contextId, final String itemId, final Map<String, Variant> attributes )
    {
        // TODO Auto-generated method stub
    }
}
