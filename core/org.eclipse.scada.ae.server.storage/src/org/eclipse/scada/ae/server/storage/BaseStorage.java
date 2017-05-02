/*******************************************************************************
 * Copyright (c) 2009, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *******************************************************************************/
package org.eclipse.scada.ae.server.storage;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.UUID;

import org.eclipse.scada.ae.Event;
import org.eclipse.scada.ae.Event.EventBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class BaseStorage implements Storage
{

    private final static Logger logger = LoggerFactory.getLogger ( BaseStorage.class );

    private static final boolean allowEntryTimestamp = Boolean.getBoolean ( "org.eclipse.scada.ae.server.storage.allowExternalEntryTimestamp" ); //$NON-NLS-1$

    private static final String providedNodeId = System.getProperty ( "org.eclipse.scada.ae.server.storage.nodeId" ); //$NON-NLS-1$

    private final String nodeId;

    public BaseStorage ()
    {
        if ( providedNodeId != null )
        {
            this.nodeId = providedNodeId;
        }
        else
        {
            this.nodeId = getHostname ();
        }
    }

    private static String getHostname ()
    {
        try
        {
            return InetAddress.getLocalHost ().getCanonicalHostName ();
        }
        catch ( final UnknownHostException e )
        {
            logger.warn ( "Failed to obtain hostname", e );
            return "<unknown>";
        }
    }

    protected String getNodeId ()
    {
        return this.nodeId;
    }

    @Override
    public Event store ( final Event event )
    {
        return store ( event, null );
    }

    protected Event createEvent ( final Event event )
    {
        final EventBuilder builder = Event.create ().event ( event ).id ( UUID.randomUUID () );

        final Date now = new GregorianCalendar ().getTime ();

        if ( !allowEntryTimestamp || ( event.getEntryTimestamp () == null ) )
        {
            // if we are not allowed to have prefilled entryTimestamps
            // or a missing the timestamp anyway
            builder.entryTimestamp ( now );
        }
        if ( event.getSourceTimestamp () == null )
        {
            builder.sourceTimestamp ( now );
        }

        builder.attribute ( "nodeId", this.nodeId );

        return builder.build ();
    }

    @Override
    public Event update ( final UUID id, final String comment ) throws Exception
    {
        return update ( id, comment, null );
    }
}
