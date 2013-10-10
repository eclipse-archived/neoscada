/*******************************************************************************
 * Copyright (c) 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.ae.server.http.filter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.eclipse.scada.ae.Event;
import org.eclipse.scada.ae.filter.EventMatcher;
import org.eclipse.scada.ae.filter.internal.EventMatcherImpl;
import org.eclipse.scada.ca.ConfigurationAdministrator;
import org.eclipse.scada.ca.ConfigurationDataHelper;
import org.eclipse.scada.ca.ConfigurationFactory;
import org.eclipse.scada.sec.UserInformation;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.framework.ServiceRegistration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EventFilterImpl implements EventFilter, ConfigurationFactory
{

    private final static Logger logger = LoggerFactory.getLogger ( EventFilterImpl.class );

    private final ServiceRegistration<ConfigurationFactory> handle;

    private final List<FilterEntry> filters = new ArrayList<FilterEntry> ();

    private final PriorityComparator priorityComparator = new PriorityComparator ();

    private final Lock readLock;

    private final Lock writeLock;

    public EventFilterImpl ( final BundleContext context, final String factoryId )
    {
        final Dictionary<String, Object> properties = new Hashtable<String, Object> ();

        properties.put ( Constants.SERVICE_VENDOR, "Eclipse SCADA Project" );
        properties.put ( Constants.SERVICE_DESCRIPTION, "A configurable event filter" );
        properties.put ( ConfigurationAdministrator.FACTORY_ID, factoryId );

        this.handle = context.registerService ( ConfigurationFactory.class, this, properties );

        final ReadWriteLock lock = new ReentrantReadWriteLock ( false );
        this.readLock = lock.readLock ();
        this.writeLock = lock.writeLock ();
    }

    @Override
    public void dispose ()
    {
        this.handle.unregister ();
    }

    @Override
    public boolean matches ( final Event event )
    {
        try
        {
            this.readLock.lock ();

            final Iterator<FilterEntry> i = this.filters.iterator ();
            while ( i.hasNext () )
            {
                if ( i.next ().matches ( event ) )
                {
                    return true;
                }
            }

            return false;
        }
        finally
        {
            this.readLock.unlock ();
        }
    }

    @Override
    public void update ( final UserInformation userInformation, final String configurationId, final Map<String, String> properties ) throws Exception
    {
        try
        {
            this.writeLock.lock ();

            // delete first
            internalDelete ( configurationId );

            // now add
            final FilterEntry entry = createFilter ( configurationId, properties );
            if ( entry != null )
            {
                this.filters.add ( entry );
            }

            // finally re-sort
            resort ();
        }
        finally
        {
            this.writeLock.unlock ();
        }

    }

    private FilterEntry createFilter ( final String configurationId, final Map<String, String> properties )
    {
        final ConfigurationDataHelper cfg = new ConfigurationDataHelper ( properties );

        final String id = configurationId;
        final long priority = cfg.getLongChecked ( "priority", "'priority' must be set" );
        final String type = cfg.getStringChecked ( "type", "'type' must be set" );

        if ( type.equalsIgnoreCase ( "static" ) )
        {
            final boolean value = cfg.getBoolean ( "value", false );
            return new StaticFilter ( id, priority, value );
        }
        else if ( type.equalsIgnoreCase ( "filter" ) )
        {
            final String filterString = cfg.getStringChecked ( "filter", "'filter' must be set when type is 'filter'" );
            final EventMatcher matcher = new EventMatcherImpl ( filterString );
            return new MatcherFilter ( id, priority, matcher );
        }

        logger.warn ( "Unable to create filter for type: '{}'", type );

        throw new RuntimeException ( String.format ( "Filter type '%s' is unknown", type ) );
    }

    @Override
    public void delete ( final UserInformation userInformation, final String configurationId ) throws Exception
    {
        try
        {
            this.writeLock.lock ();
            internalDelete ( configurationId );

            // no need to resort
        }
        finally
        {
            this.writeLock.unlock ();
        }
    }

    private void internalDelete ( final String configurationId )
    {
        final Iterator<FilterEntry> i = this.filters.iterator ();
        while ( i.hasNext () )
        {
            if ( i.next ().getId ().equals ( configurationId ) )
            {
                i.remove ();
            }
        }
    }

    private void resort ()
    {
        Collections.sort ( this.filters, this.priorityComparator );
    }

}
