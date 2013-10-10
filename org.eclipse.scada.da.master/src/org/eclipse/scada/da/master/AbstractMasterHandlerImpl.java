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
package org.eclipse.scada.da.master;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import org.eclipse.scada.ca.ConfigurationDataHelper;
import org.eclipse.scada.core.Variant;
import org.eclipse.scada.da.client.DataItemValue;
import org.eclipse.scada.sec.UserInformation;
import org.eclipse.scada.utils.osgi.pool.ObjectPoolListener;
import org.eclipse.scada.utils.osgi.pool.ObjectPoolServiceTracker;
import org.eclipse.scada.utils.osgi.pool.ObjectPoolTracker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractMasterHandlerImpl implements MasterItemHandler
{

    private final static Logger logger = LoggerFactory.getLogger ( AbstractMasterHandlerImpl.class );

    private final Set<MasterItem> items = new CopyOnWriteArraySet<MasterItem> ();

    private final int defaultPriority;

    private final ObjectPoolTracker<MasterItem> poolTracker;

    private volatile int priority;

    private final Map<String, ObjectPoolServiceTracker<MasterItem>> trackers = new HashMap<String, ObjectPoolServiceTracker<MasterItem>> ();

    protected Map<String, Variant> eventAttributes;

    public AbstractMasterHandlerImpl ( final ObjectPoolTracker<MasterItem> poolTracker )
    {
        this ( poolTracker, Integer.MAX_VALUE );
    }

    public AbstractMasterHandlerImpl ( final ObjectPoolTracker<MasterItem> poolTracker, final int defaultPriority )
    {
        this.poolTracker = poolTracker;
        this.defaultPriority = defaultPriority;
        this.priority = defaultPriority;

        this.eventAttributes = Collections.emptyMap ();
    }

    public synchronized void dispose ()
    {
        closeTrackers ();
    }

    private void closeTrackers ()
    {
        for ( final ObjectPoolServiceTracker<MasterItem> tracker : this.trackers.values () )
        {
            tracker.close ();
        }
        this.trackers.clear ();
    }

    public synchronized void update ( final UserInformation userInformation, final Map<String, String> parameters ) throws Exception
    {
        final ConfigurationDataHelper cfg = new ConfigurationDataHelper ( parameters );

        final String masterId = cfg.getStringChecked ( MasterItem.MASTER_ID, String.format ( "'%s' must be set", MasterItem.MASTER_ID ) );
        final String splitPattern = cfg.getString ( "splitPattern", ", ?" );
        final String[] newIds = masterId.split ( splitPattern );
        final boolean trackerUpdate = !this.trackers.keySet ().equals ( new HashSet<String> ( Arrays.asList ( newIds ) ) );

        logger.debug ( "Need tracker update: {}", trackerUpdate );

        if ( trackerUpdate )
        {
            closeTrackers ();
        }

        this.priority = cfg.getInteger ( "handlerPriority", this.defaultPriority );
        this.eventAttributes = convert ( cfg.getPrefixed ( "info." ) );

        if ( trackerUpdate )
        {
            createTrackers ( newIds );
            for ( final ObjectPoolServiceTracker<MasterItem> tracker : this.trackers.values () )
            {
                tracker.open ();
            }
        }
    }

    private Map<String, Variant> convert ( final Map<String, String> attributes )
    {
        final Map<String, Variant> result = new HashMap<String, Variant> ( attributes.size () );

        for ( final Map.Entry<String, String> entry : attributes.entrySet () )
        {
            result.put ( entry.getKey (), Variant.valueOf ( entry.getValue () ) );
        }

        return result;
    }

    protected void createTrackers ( final String[] masterIds )
    {
        for ( final String masterId : masterIds )
        {
            this.trackers.put ( masterId, new ObjectPoolServiceTracker<MasterItem> ( this.poolTracker, masterId, new ObjectPoolListener<MasterItem> () {

                @Override
                public void serviceAdded ( final MasterItem service, final Dictionary<?, ?> properties )
                {
                    addItem ( service );
                }

                @Override
                public void serviceModified ( final MasterItem service, final Dictionary<?, ?> properties )
                {
                }

                @Override
                public void serviceRemoved ( final MasterItem service, final Dictionary<?, ?> properties )
                {
                    removeItem ( service );
                }
            } ) );
        }
    }

    protected boolean removeItem ( final MasterItem item )
    {
        logger.debug ( "Removing master: {}", item );
        if ( this.items.remove ( item ) )
        {
            logger.debug ( "Removed master: {}", item );
            item.removeHandler ( this );
            return true;
        }
        else
        {
            return false;
        }
    }

    protected void addItem ( final MasterItem item )
    {
        logger.debug ( "Adding master: {}", item );
        if ( this.items.add ( item ) )
        {
            logger.debug ( "Added master: {} / {}", new Object[] { item, this.priority } );
            item.addHandler ( this, this.priority );
        }
    }

    /**
     * Get an unmodifiable list of master items
     * 
     * @return unmodifiable list of master items
     */
    protected Collection<MasterItem> getMasterItems ()
    {
        return Collections.unmodifiableCollection ( this.items );
    }

    protected void reprocess ()
    {
        for ( final MasterItem item : this.items )
        {
            item.reprocess ();
        }
    }

    @Override
    public abstract void dataUpdate ( Map<String, Object> context, final DataItemValue.Builder value );

    /**
     * Process the write request
     * <p>
     * This implementation does <em>nothing</em> and can be overridden by derived implementations.
     * </p>
     */
    @Override
    public WriteRequestResult processWrite ( final WriteRequest request )
    {
        return null;
    }
}
