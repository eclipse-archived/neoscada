/*******************************************************************************
 * Copyright (c) 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.ae.server.injector.internal;

import java.util.Arrays;
import java.util.Collections;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.eclipse.scada.ae.Event;
import org.eclipse.scada.ae.server.handler.EventHandler;
import org.eclipse.scada.ae.server.handler.EventHandlerFactory;
import org.eclipse.scada.ae.server.handler.InjectionContext;
import org.eclipse.scada.ae.server.injector.EventInjector;
import org.eclipse.scada.ae.server.injector.internal.EventHandlerFactoryTracker.Listener;
import org.eclipse.scada.ae.server.injector.monitor.EventMonitorEvaluator;
import org.eclipse.scada.ca.ConfigurationDataHelper;
import org.eclipse.scada.ca.ConfigurationFactory;
import org.eclipse.scada.sec.UserInformation;
import org.eclipse.scada.utils.ExceptionHelper;
import org.eclipse.scada.utils.concurrent.ExportedExecutorService;
import org.eclipse.scada.utils.str.Tables;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.framework.ServiceRegistration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EventInjectorImpl implements EventInjector, ConfigurationFactory
{
    private static final String DEFAULT_HANDLER_FACTORY = System.getProperty ( "org.eclipse.scada.ae.server.injector.defaultHandlerFactory", "defaultStorage" );

    private static final String DEFAULT_ID = "default";

    private final static Logger logger = LoggerFactory.getLogger ( EventInjectorImpl.class );

    private final EventMonitorEvaluator evaluator;

    private final Lock readLock;

    private final Lock writeLock;

    private final SortedSet<Entry> entries = new TreeSet<> ();

    private final Map<String, Entry> entryMap = new HashMap<> ();

    private final Map<String, EventHandlerFactory> factoryMap = new HashMap<> ();

    private static final boolean USE_DEFAULT = !Boolean.getBoolean ( "org.eclipse.scada.ae.server.injector.disableDefault" );

    private final Listener factoryListener = new Listener () {

        @Override
        public void factoryRemoved ( final String factoryId )
        {
            handleFactoryRemoved ( factoryId );
        }

        @Override
        public void factoryAdded ( final String factoryId, final EventHandlerFactory factory )
        {
            handleFactoryAdded ( factoryId, factory );
        }
    };

    private final EventHandlerFactoryTracker factoryTracker;

    private final ExportedExecutorService executor;

    private final BundleContext context;

    private ServiceRegistration<EventInjector> handle;

    private boolean hasDefault;

    private static final class Entry implements Comparable<Entry>
    {
        private final String id;

        private final int priority;

        private final String factoryId;

        private final Map<String, String> properties;

        private EventHandler handler;

        private Exception error;

        public Entry ( final String id, final int priority, final String factoryId, final Map<String, String> properties )
        {
            this.id = id;
            this.factoryId = factoryId;
            this.priority = priority;
            this.properties = properties;
        }

        public void dispose ()
        {
            disposeHandler ();
        }

        public void setFactory ( final EventHandlerFactory factory )
        {
            // unrealize

            disposeHandler ();

            // realize

            if ( factory != null )
            {
                try
                {
                    this.handler = factory.createHandler ( this.properties );
                }
                catch ( final Exception e )
                {
                    this.error = e;
                }
            }
        }

        private void disposeHandler ()
        {
            if ( this.handler != null )
            {
                this.handler.dispose ();
                this.handler = null;
            }
        }

        public boolean isRealized ()
        {
            return this.handler != null;
        }

        public String getFactoryId ()
        {
            return this.factoryId;
        }

        @Override
        public int compareTo ( final Entry o )
        {
            int result;

            result = Integer.compare ( this.priority, o.priority );
            if ( result != 0 )
            {
                return result;
            }

            return this.id.compareTo ( o.id );
        }

        @Override
        public int hashCode ()
        {
            final int prime = 31;
            int result = 1;
            result = prime * result + ( this.id == null ? 0 : this.id.hashCode () );
            result = prime * result + this.priority;
            return result;
        }

        @Override
        public boolean equals ( final Object obj )
        {
            if ( this == obj )
            {
                return true;
            }
            if ( obj == null )
            {
                return false;
            }
            if ( getClass () != obj.getClass () )
            {
                return false;
            }
            final Entry other = (Entry)obj;
            if ( this.id == null )
            {
                if ( other.id != null )
                {
                    return false;
                }
            }
            else if ( !this.id.equals ( other.id ) )
            {
                return false;
            }
            if ( this.priority != other.priority )
            {
                return false;
            }
            return true;
        }
    }

    public EventInjectorImpl ( final BundleContext context, final EventMonitorEvaluator evaluator )
    {
        this.context = context;

        final ReentrantReadWriteLock rw = new ReentrantReadWriteLock ();
        this.readLock = rw.readLock ();
        this.writeLock = rw.writeLock ();

        this.evaluator = evaluator;

        this.executor = new ExportedExecutorService ( "org.eclipse.scada.ae.server.injector", 1, 1, 1, TimeUnit.MINUTES );
        this.factoryTracker = new EventHandlerFactoryTracker ( context, this.factoryListener );

        addDefault ();
    }

    private void addDefault ()
    {
        if ( !USE_DEFAULT )
        {
            return;
        }

        if ( this.entries.isEmpty () && !this.hasDefault )
        {
            logger.info ( "Adding default entry" );

            final Entry defaultEntry = new Entry ( DEFAULT_ID, 0, DEFAULT_HANDLER_FACTORY, Collections.<String, String> emptyMap () );
            internalAddEntry ( defaultEntry );
            this.hasDefault = true;
        }
    }

    private void removeDefault ()
    {
        if ( !USE_DEFAULT )
        {
            return;
        }

        if ( !this.entries.isEmpty () && this.hasDefault )
        {
            logger.debug ( "Removing default entry" );
            internalDelete ( DEFAULT_ID );
            this.hasDefault = false;
        }
    }

    public void dispose ()
    {
        this.writeLock.lock ();

        try
        {
            for ( final Entry entry : this.entries )
            {
                entry.dispose ();
            }
            this.entries.clear ();
            this.entryMap.clear ();

            if ( this.factoryTracker != null )
            {
                this.factoryTracker.dispose ();
            }
            if ( this.executor != null )
            {
                this.executor.shutdown ();
            }
        }
        finally
        {
            this.writeLock.unlock ();
        }
    }

    @Override
    public void injectEvent ( final Event event, final InjectionContext context )
    {
        this.readLock.lock ();
        try
        {
            // publish event
            Event evalEvent = this.evaluator.evaluate ( event );

            for ( final Entry entry : this.entries )
            {
                evalEvent = entry.handler.handleEvent ( evalEvent, context );
            }
        }
        finally
        {
            this.readLock.unlock ();
        }

    }

    protected void handleFactoryAdded ( final String factoryId, final EventHandlerFactory factory )
    {
        this.executor.execute ( new Runnable () {

            @Override
            public void run ()
            {
                processFactoryAdded ( factoryId, factory );
            }
        } );
    }

    protected void handleFactoryRemoved ( final String factoryId )
    {
        this.executor.execute ( new Runnable () {

            @Override
            public void run ()
            {
                processFactoryRemoved ( factoryId );
            }
        } );
    }

    protected void processFactoryAdded ( final String factoryId, final EventHandlerFactory factory )
    {
        this.writeLock.lock ();
        try
        {
            this.factoryMap.put ( factoryId, factory );
            for ( final Entry entry : this.entries )
            {
                if ( entry.getFactoryId ().equals ( factoryId ) )
                {
                    entry.setFactory ( factory );
                }
            }
            checkValid ();
        }
        finally
        {
            this.writeLock.unlock ();
        }
    }

    protected void processFactoryRemoved ( final String factoryId )
    {
        logger.debug ( "Removing factory - factoryId: {}", factoryId );

        this.writeLock.lock ();
        try
        {
            this.factoryMap.remove ( factoryId );
            for ( final Entry entry : this.entries )
            {
                if ( entry.getFactoryId ().equals ( factoryId ) )
                {
                    entry.setFactory ( null );
                }
            }
            checkValid ();
        }
        finally
        {
            this.writeLock.unlock ();
        }
    }

    public void state ()
    {
        this.readLock.lock ();
        try
        {
            int count = 0;
            for ( final Entry entry : this.entries )
            {
                if ( !entry.isRealized () )
                {
                    count++;
                }
            }

            // will be redirected by the gogo shell
            if ( count == 0 )
            {
                System.out.println ( "All entries are realized" );
            }
            else
            {
                System.out.format ( "%s of %s entries are NOT realized%n", count, this.entries.size () );
            }
            if ( this.hasDefault )
            {
                System.out.println ( "Default entry is in place" );
            }
        }
        finally
        {
            this.readLock.unlock ();
        }
    }

    public void rules ()
    {
        this.readLock.lock ();
        try
        {
            final List<String> header = Arrays.asList ( "Prio", "ID", "Realized", "Error" );
            final List<List<String>> data = new LinkedList<> ();

            for ( final Entry entry : this.entries )
            {
                final LinkedList<String> row = new LinkedList<> ();
                row.add ( "" + entry.priority );
                row.add ( entry.id );
                row.add ( entry.isRealized () ? "X" : "" );
                if ( entry.error != null )
                {
                    row.add ( ExceptionHelper.getMessage ( entry.error ) );
                }
                else
                {
                    row.add ( "" );
                }
                data.add ( row );
            }

            // will be redirected by the gogo shell
            Tables.showTable ( System.out, header, data, 1 );
        }
        finally
        {
            this.readLock.unlock ();
        }
    }

    @Override
    public void update ( final UserInformation userInformation, final String configurationId, final Map<String, String> properties ) throws Exception
    {
        this.writeLock.lock ();
        try
        {
            final ConfigurationDataHelper cfg = new ConfigurationDataHelper ( properties );
            final Entry entry = new Entry ( configurationId, cfg.getInteger ( "priority", 0 ), cfg.getStringNonEmptyChecked ( "factory.id", null ), cfg.getPrefixed ( "properties." ) );

            removeDefault ();

            internalAddEntry ( entry );
        }
        finally
        {
            this.writeLock.unlock ();
        }
    }

    private void internalAddEntry ( final Entry entry )
    {
        // put new entry

        final Entry oldEntry = this.entryMap.put ( entry.id, entry );

        // dispose old

        if ( oldEntry != null )
        {
            logger.debug ( "Remove old entry - entry: {}", oldEntry );
            this.entries.remove ( oldEntry );
            oldEntry.dispose ();
        }

        // set factory

        final EventHandlerFactory factory = this.factoryMap.get ( entry.getFactoryId () );
        if ( factory != null )
        {
            logger.debug ( "Setting factory - factory: {}", factory );
            entry.setFactory ( factory );
        }

        // add

        this.entries.add ( entry );
        addDefault ();
        checkValid ();
    }

    @Override
    public void delete ( final UserInformation userInformation, final String configurationId ) throws Exception
    {
        this.writeLock.lock ();
        try
        {
            internalDelete ( configurationId );
        }
        finally
        {
            this.writeLock.unlock ();
        }
    }

    private void internalDelete ( final String id )
    {
        final Entry entry = this.entryMap.remove ( id );
        if ( entry == null )
        {
            return;
        }

        this.entries.remove ( entry );
        entry.dispose ();
        addDefault ();
        checkValid ();
    }

    /**
     * Check if the configuration is valid and all handlers are realized
     */
    private void checkValid ()
    {
        setActive ( isValid () );
    }

    private void setActive ( final boolean valid )
    {
        logger.debug ( "set active - valid: {}, handle: {}", valid, this.handle );

        if ( valid && this.handle == null )
        {
            final Dictionary<String, Object> properties = new Hashtable<> ();
            properties.put ( Constants.SERVICE_DESCRIPTION, "Event injector service" );
            properties.put ( Constants.SERVICE_VENDOR, "Eclipse SCADA Project" );
            this.handle = this.context.registerService ( EventInjector.class, this, properties );
        }
        else if ( !valid && this.handle != null )
        {
            this.handle.unregister ();
            this.handle = null;
        }
        // else -> no change
    }

    private boolean isValid ()
    {
        for ( final Entry entry : this.entries )
        {
            if ( !entry.isRealized () )
            {
                return false;
            }
        }
        return true;
    }

}
