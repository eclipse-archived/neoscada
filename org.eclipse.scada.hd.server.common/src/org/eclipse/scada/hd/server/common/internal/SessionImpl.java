/*******************************************************************************
 * Copyright (c) 2009, 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.hd.server.common.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

import org.eclipse.scada.core.server.common.session.AbstractSessionImpl;
import org.eclipse.scada.hd.ItemListListener;
import org.eclipse.scada.hd.data.HistoricalItemInformation;
import org.eclipse.scada.hd.server.Session;
import org.eclipse.scada.sec.UserInformation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SessionImpl extends AbstractSessionImpl implements Session, ItemListListener
{
    private final static Logger logger = LoggerFactory.getLogger ( SessionImpl.class );

    private final HashMap<String, HistoricalItemInformation> itemCache = new HashMap<String, HistoricalItemInformation> ();

    private final Collection<QueryImpl> queries = new LinkedList<QueryImpl> ();

    private ItemListListener itemListListener;

    public SessionImpl ( final UserInformation user, final Map<String, String> properties )
    {
        super ( user, properties );
        logger.info ( "Created new session" );
    }

    public void dispose ()
    {
        logger.info ( "Disposing session" );
        synchronized ( this )
        {
            // close all queries
            final Collection<QueryImpl> queries = new ArrayList<QueryImpl> ( this.queries );
            for ( final QueryImpl query : queries )
            {
                query.dispose ();
            }
            this.queries.clear ();
        }
    }

    @Override
    public void setItemListListener ( final ItemListListener itemListListener )
    {
        synchronized ( this )
        {
            this.itemListListener = itemListListener;
            if ( itemListListener != null )
            {
                fireListChanged ( new HashSet<HistoricalItemInformation> ( this.itemCache.values () ), null, true );
            }
        }
    }

    @Override
    public void listChanged ( final Set<HistoricalItemInformation> addedOrModified, final Set<String> removed, final boolean full )
    {
        synchronized ( this )
        {
            if ( full )
            {
                this.itemCache.clear ();
            }
            if ( removed != null && !full )
            {
                for ( final String item : removed )
                {
                    this.itemCache.remove ( item );
                }
            }
            if ( addedOrModified != null )
            {
                for ( final HistoricalItemInformation item : addedOrModified )
                {
                    this.itemCache.put ( item.getItemId (), item );
                }
            }
            fireListChanged ( addedOrModified, removed, full );
        }
    }

    protected void fireListChanged ( final Set<HistoricalItemInformation> addedOrModified, final Set<String> removed, final boolean full )
    {
        synchronized ( this )
        {
            if ( this.itemListListener != null )
            {
                this.itemListListener.listChanged ( addedOrModified, removed, full );
            }
        }
    }

    public void addQuery ( final QueryImpl query )
    {
        synchronized ( this )
        {
            this.queries.add ( query );
        }
    }

    public void removeQuery ( final QueryImpl query )
    {
        synchronized ( this )
        {
            this.queries.remove ( query );
        }
    }
}
