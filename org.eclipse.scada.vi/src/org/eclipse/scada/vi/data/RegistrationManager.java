/*******************************************************************************
 * Copyright (c) 2012, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *******************************************************************************/
package org.eclipse.scada.vi.data;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

import org.eclipse.scada.core.Variant;
import org.eclipse.scada.core.connection.provider.ConnectionIdTracker;
import org.eclipse.scada.da.client.DataItemValue;
import org.eclipse.scada.da.connection.provider.ConnectionService;
import org.eclipse.scada.da.ui.connection.data.Item;
import org.eclipse.scada.da.ui.connection.data.Item.Type;
import org.eclipse.scada.sec.callback.CallbackHandler;
import org.osgi.framework.BundleContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RegistrationManager
{
    private static final long SERVICE_TIMEOUT = Long.getLong ( "org.eclipse.scada.vi.data.serviceTimeout", 1000 );

    private final static Logger logger = LoggerFactory.getLogger ( RegistrationManager.class );

    public interface Listener
    {
        public void triggerDataUpdate ();
    }

    private final Set<Listener> listeners = new LinkedHashSet<RegistrationManager.Listener> ();

    private final Map<String, DataItemRegistration> registrations = new LinkedHashMap<String, DataItemRegistration> ();

    private final AtomicReference<Map<String, DataValue>> currentValues = new AtomicReference<Map<String, DataValue>> ( Collections.<String, DataValue> emptyMap () );

    private final BundleContext context;

    private boolean open;

    private final String name;

    public RegistrationManager ( final BundleContext context )
    {
        this ( context, null );
    }

    public RegistrationManager ( final BundleContext context, final String name )
    {
        this.context = context;
        this.name = name;
    }

    public void addListener ( final Listener listener )
    {
        this.listeners.add ( listener );
    }

    public void removeListener ( final Listener listener )
    {
        this.listeners.remove ( listener );
    }

    public void dispose ()
    {
        close ();
        this.registrations.clear ();
    }

    public void unregisterItem ( final String name )
    {
        final DataItemRegistration registration = this.registrations.remove ( name );
        if ( registration != null )
        {
            if ( this.open )
            {
                registration.close ();
                notifyRemove ( name );
            }
        }
    }

    public void open ()
    {
        if ( this.open )
        {
            return;
        }

        this.open = true;

        for ( final DataItemRegistration registration : this.registrations.values () )
        {
            registration.open ();
        }
    }

    public void close ()
    {
        if ( !this.open )
        {
            return;
        }

        this.open = false;

        for ( final DataItemRegistration registration : this.registrations.values () )
        {
            registration.close ();
        }
    }

    public void registerItem ( final String name, final String itemId, final String connectionId, final boolean ignoreSummary, final boolean nullInvalid )
    {
        if ( itemId == null )
        {
            throw new IllegalArgumentException ( String.format ( "'itemId' must not be null" ) );
        }

        if ( this.open )
        {
            notifyChange ( name, new Item ( connectionId, itemId, Type.ID ), DataItemValue.DISCONNECTED, ignoreSummary, nullInvalid );
        }

        final DataItemRegistration newRegistration = new DataItemRegistration ( this, this.context, name, itemId, connectionId, ignoreSummary, nullInvalid );
        final DataItemRegistration oldRegistration = this.registrations.put ( name, newRegistration );
        if ( this.open )
        {
            if ( oldRegistration != null )
            {
                oldRegistration.close ();
            }

            newRegistration.open ();
        }
    }

    protected void notifyRemove ( final String name )
    {
        notifyValue ( name, null );
    }

    public void notifyChange ( final String name, final Item item, final DataItemValue value, final boolean ignoreSummary, final boolean nullInvalid )
    {
        notifyValue ( name, new DataValue ( value, item, ignoreSummary, nullInvalid ) );
    }

    protected void notifyValue ( final String name, final DataValue dataValue )
    {
        Map<String, DataValue> currentMap;
        Map<String, DataValue> newMap;
        int t = 0;
        do
        {
            t++;
            currentMap = this.currentValues.get ();
            newMap = new LinkedHashMap<String, DataValue> ( currentMap );

            if ( dataValue == null )
            {
                // item got removed
                newMap.remove ( name );
            }
            else
            {
                // item changed
                newMap.put ( name, dataValue );
            }
        } while ( !this.currentValues.compareAndSet ( currentMap, newMap ) );

        if ( t > 1 )
        {
            logger.debug ( "Took {} updates", t );
        }

        for ( final Listener listener : this.listeners )
        {
            try
            {
                listener.triggerDataUpdate ();
            }
            catch ( final Exception e )
            {
                logger.warn ( "Failed to notify", e );
            }
        }
    }

    public Map<String, DataValue> getData ()
    {
        logger.debug ( "{} - getData: {}", this.name, this.currentValues.get () );
        return Collections.unmodifiableMap ( this.currentValues.get () );
    }

    public void startWrite ( final String connectionId, final String itemId, final Variant value, final CallbackHandler callbackHandler ) throws InterruptedException
    {
        final ConnectionIdTracker connectionTracker = new ConnectionIdTracker ( this.context, connectionId, null, ConnectionService.class );
        connectionTracker.open ();
        try
        {
            final ConnectionService service = (ConnectionService)connectionTracker.waitForService ( SERVICE_TIMEOUT );
            service.getConnection ().startWrite ( itemId, value, null, callbackHandler );
        }
        finally
        {
            connectionTracker.close ();
        }
    }

    public void startWriteAttributes ( final String connectionId, final String itemId, final Map<String, Variant> attributes, final CallbackHandler callbackHandler ) throws InterruptedException
    {
        final ConnectionIdTracker connectionTracker = new ConnectionIdTracker ( this.context, connectionId, null, ConnectionService.class );
        connectionTracker.open ();
        try
        {
            final ConnectionService service = (ConnectionService)connectionTracker.waitForService ( SERVICE_TIMEOUT );
            service.getConnection ().startWriteAttributes ( itemId, attributes, null, callbackHandler );
        }
        finally
        {
            connectionTracker.close ();
        }
    }

    public Collection<Item> getItems ()
    {
        final Set<Item> result = new LinkedHashSet<Item> ( this.registrations.size () );

        for ( final DataItemRegistration reg : this.registrations.values () )
        {
            result.add ( reg.getItem () );
        }

        return result;
    }
}
