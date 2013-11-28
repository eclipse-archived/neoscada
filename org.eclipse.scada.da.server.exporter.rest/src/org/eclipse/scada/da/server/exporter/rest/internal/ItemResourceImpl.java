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

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.eclipse.scada.core.InvalidOperationException;
import org.eclipse.scada.core.Variant;
import org.eclipse.scada.da.client.DataItemValue;
import org.eclipse.scada.da.core.WriteAttributeResult;
import org.eclipse.scada.da.core.WriteAttributeResults;
import org.eclipse.scada.da.server.exporter.rest.ItemResource;
import org.eclipse.scada.da.server.exporter.rest.WriteResult;
import org.eclipse.scada.utils.ExceptionHelper;
import org.eclipse.scada.utils.concurrent.NotifyFuture;
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

        logger.trace ( "Result: {}", value );

        return value;
    }

    @Override
    public WriteResult write ( final String contextId, final String itemId, final Variant value )
    {
        logger.trace ( "Writing value - contextId: {}, itemId: {}, value: {}", contextId, itemId, value );

        final DataContext context = this.provider.getContext ( contextId );

        if ( context == null )
        {
            logger.trace ( "Context not found" );
            throw new WebApplicationException ( Status.NOT_FOUND );
        }

        final NotifyFuture<org.eclipse.scada.da.core.WriteResult> future = context.writeValue ( itemId, value );

        try
        {
            final org.eclipse.scada.da.core.WriteResult result = future.get ();
            return new WriteResult ( result.getError () );
        }
        catch ( final ExecutionException e )
        {
            final Throwable cause = ExceptionHelper.getRootCause ( e );
            if ( cause instanceof InvalidOperationException )
            {
                // this operation is now allowed for this item
                throw new WebApplicationException ( Response.status ( Status.FORBIDDEN ).build () );
            }
            throw new WebApplicationException ( e.getCause () );
        }
        catch ( final Exception e )
        {
            throw new WebApplicationException ( e );
        }
    }

    @Override
    public Map<String, WriteResult> writeAttribute ( final String contextId, final String itemId, final Map<String, Variant> attributes )
    {
        logger.trace ( "Writing attributes - contextId: {}, itemId: {}, attributes: {}", contextId, itemId, attributes );

        final DataContext context = this.provider.getContext ( contextId );

        if ( context == null )
        {
            logger.trace ( "Context not found" );
            throw new WebApplicationException ( Status.NOT_FOUND );
        }

        final NotifyFuture<WriteAttributeResults> future = context.writeAttributes ( itemId, attributes );

        try
        {
            final WriteAttributeResults result = future.get ();
            final Map<String, WriteResult> r = new HashMap<String, WriteResult> ();
            for ( final Map.Entry<String, WriteAttributeResult> entry : result.entrySet () )
            {
                r.put ( entry.getKey (), new WriteResult ( entry.getValue ().getError () ) );
            }
            return r;
        }
        catch ( final ExecutionException e )
        {
            throw new WebApplicationException ( e.getCause () );
        }
        catch ( final Exception e )
        {
            throw new WebApplicationException ( e );
        }
    }
}
