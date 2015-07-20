/*******************************************************************************
 * Copyright (c) 2013, 2015 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.server.exporter.rest.internal;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TimeZone;
import java.util.TreeMap;
import java.util.concurrent.ExecutionException;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.StreamingOutput;

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
    private static final String[] FIELDS = new String[] { "Item", "Subscription State", "Raw Value", "Value", "Type", "Timestamp (UTC)", "Timestamp (Epoch)", "Error", "Alarm", "Warning", "Manual", "Blocked", "Connected" };

    private final static Logger logger = LoggerFactory.getLogger ( ItemResourceImpl.class );

    private DataContextProvider provider;

    public void setProvider ( final DataContextProvider provider )
    {
        this.provider = provider;
    }

    @Override
    public DataItemValue read ( final String contextId, final String itemId )
    {
        logger.trace ( "Reading - contextId: {}, itemId: {}", contextId, itemId ); //$NON-NLS-1$

        final DataContext context = this.provider.getContext ( contextId );

        if ( context == null )
        {
            logger.trace ( "Context '{}' not found", contextId ); //$NON-NLS-1$
            throw new WebApplicationException ( Status.NOT_FOUND );
        }

        final DataItemValue value = context.getValue ( itemId );
        if ( value == null )
        {
            logger.trace ( "Item '{}' not found", itemId ); //$NON-NLS-1$
            throw new WebApplicationException ( Status.NOT_FOUND );
        }

        logger.trace ( "Result: {}", value ); //$NON-NLS-1$

        return value;
    }

    @Override
    public Map<String, DataItemValue> readAll ( final String contextId )
    {
        logger.trace ( "Reading all - contextId: {}", contextId ); //$NON-NLS-1$

        final DataContext context = this.provider.getContext ( contextId );

        if ( context == null )
        {
            logger.trace ( "Context '{}' not found", contextId ); //$NON-NLS-1$
            throw new WebApplicationException ( Status.NOT_FOUND );
        }

        SortedMap<String, DataItemValue> values = context.getAllValues ();
        if ( values == null )
        {
            values = new TreeMap<> ();
        }

        logger.trace ( "Result: {}", values ); //$NON-NLS-1$

        return values;
    }

    @Override
    public Response readAllCsv ( final String contextId )
    {
        final DataContext context = this.provider.getContext ( contextId );

        if ( context == null )
        {
            logger.trace ( "Context '{}' not found", contextId ); //$NON-NLS-1$
            throw new WebApplicationException ( Status.NOT_FOUND );
        }

        final SortedMap<String, DataItemValue> values = context.getAllValues ();

        final StreamingOutput out = new StreamingOutput () {

            @Override
            public void write ( final OutputStream output ) throws IOException, WebApplicationException
            {
                streamAsCSV ( new PrintWriter ( new OutputStreamWriter ( output, StandardCharsets.UTF_8 ) ), values, ",", "\r\n" ); //$NON-NLS-1$  //$NON-NLS-2$
            }
        };
        return Response.ok ( out ).header ( "Content-Disposition", "attachment; filename=\"data.csv\"" ).build (); //$NON-NLS-1$
    }

    protected void streamAsCSV ( final PrintWriter writer, SortedMap<String, DataItemValue> values, final String delim, final String nl )
    {
        if ( values == null )
        {
            values = new TreeMap<> ();
        }

        for ( int i = 0; i < FIELDS.length; i++ )
        {
            if ( i > 0 )
            {
                writer.print ( delim );
            }
            writer.print ( FIELDS[i] );
        }
        writer.print ( nl );

        final DateFormat df = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss.SSS" ); //$NON-NLS-1$
        df.setTimeZone ( TimeZone.getTimeZone ( "UTC" ) ); //$NON-NLS-1$

        for ( final Map.Entry<String, DataItemValue> entry : values.entrySet () )
        {
            final DataItemValue div = entry.getValue ();

            writer.print ( escapedCsv ( entry.getKey () ) );
            writer.print ( delim );

            // Subscription state
            writer.print ( escapedCsv ( "" + div.getSubscriptionState () ) ); //$NON-NLS-1$
            writer.print ( delim );
            // raw value
            writer.print ( escapedCsv ( div.getValue () == null ? "" : div.toString () ) ); //$NON-NLS-1$
            writer.print ( delim );
            // value
            writer.print ( escapedCsv ( div.getValue () == null ? "" : div.getValue ().toLabel ( "" ) ) ); //$NON-NLS-1$  //$NON-NLS-2$
            writer.print ( delim );
            // type
            writer.print ( escapedCsv ( div.getValue () == null ? "" : div.getValue ().getType ().toString () ) ); //$NON-NLS-1$
            writer.print ( delim );
            // Timestamp - UTC
            final Calendar ts = div.getTimestamp ();
            writer.print ( ts == null ? "" : df.format ( ts.getTime () ) ); //$NON-NLS-1$
            writer.print ( delim );
            // timestamp - epoch
            writer.print ( ts == null ? "" : "" + ts.getTimeInMillis () ); //$NON-NLS-1$  //$NON-NLS-2$
            writer.print ( delim );
            // flag - error
            writer.print ( div.isError () ? "true" : "false" ); //$NON-NLS-1$  //$NON-NLS-2$
            writer.print ( delim );
            // flag - alarm
            writer.print ( div.isAlarm () ? "true" : "false" ); //$NON-NLS-1$  //$NON-NLS-2$
            writer.print ( delim );
            // flag - warning
            writer.print ( div.isWarning () ? "true" : "false" ); //$NON-NLS-1$  //$NON-NLS-2$
            writer.print ( delim );
            // flag - manual
            writer.print ( div.isManual () ? "true" : "false" ); //$NON-NLS-1$  //$NON-NLS-2$
            writer.print ( delim );
            // flag - blocked
            writer.print ( div.isBlocked () ? "true" : "false" ); //$NON-NLS-1$  //$NON-NLS-2$
            writer.print ( delim );
            // flag - connected
            writer.print ( div.isConnected () ? "true" : "false" ); //$NON-NLS-1$  //$NON-NLS-2$

            writer.print ( nl );
        }
    }

    private static String escapedCsv ( final String key )
    {
        final StringBuilder sb = new StringBuilder ( key.length () );

        boolean escaped = false;

        for ( int i = 0; i < key.length (); i++ )
        {
            final char c = key.charAt ( i );
            switch ( c )
            {
                case '"':
                    escaped = startEscaped ( sb, escaped );
                    sb.append ( "\"\"" ); // double "
                    break;
                case '\t':
                    //$FALL-THROUGH$
                case '\r':
                    //$FALL-THROUGH$
                case '\n':
                    escaped = startEscaped ( sb, escaped );
                    sb.append ( c );
                    break;
                default:
                    sb.append ( c );
                    break;
            }
        }

        if ( escaped )
        {
            sb.append ( "\"" );
        }

        return sb.toString ();
    }

    private static boolean startEscaped ( final StringBuilder sb, final boolean escaped )
    {
        if ( escaped )
        {
            return true;
        }

        sb.insert ( 0, "\"" );

        return true;
    }

    @Override
    public WriteResult write ( final String contextId, final String itemId, final Variant value )
    {
        logger.trace ( "Writing value - contextId: {}, itemId: {}, value: {}", contextId, itemId, value ); //$NON-NLS-1$

        final DataContext context = this.provider.getContext ( contextId );

        if ( context == null )
        {
            logger.trace ( "Context not found" ); //$NON-NLS-1$
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
        logger.trace ( "Writing attributes - contextId: {}, itemId: {}, attributes: {}", contextId, itemId, attributes ); //$NON-NLS-1$

        final DataContext context = this.provider.getContext ( contextId );

        if ( context == null )
        {
            logger.trace ( "Context not found" ); //$NON-NLS-1$
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
