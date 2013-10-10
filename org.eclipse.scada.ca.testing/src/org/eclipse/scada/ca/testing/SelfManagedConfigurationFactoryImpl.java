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
package org.eclipse.scada.ca.testing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.eclipse.scada.ca.Configuration;
import org.eclipse.scada.ca.ConfigurationListener;
import org.eclipse.scada.ca.SelfManagedConfigurationFactory;
import org.eclipse.scada.utils.concurrent.InstantFuture;
import org.eclipse.scada.utils.concurrent.NotifyFuture;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SelfManagedConfigurationFactoryImpl implements SelfManagedConfigurationFactory
{

    private final static Logger logger = LoggerFactory.getLogger ( SelfManagedConfigurationFactoryImpl.class );

    private ExecutorService executor;

    private final Map<String, ConfigurationImpl> configurations = new HashMap<String, ConfigurationImpl> ();

    private final String factoryId;

    private final Set<ConfigurationListener> listeners = new HashSet<ConfigurationListener> ();

    public SelfManagedConfigurationFactoryImpl ( final String factoryId )
    {
        this.factoryId = factoryId;

        for ( int i = 0; i < 5; i++ )
        {
            // sample init
            final Map<String, String> data = new HashMap<String, String> ();
            data.put ( "foo", "bar" );
            data.put ( "a", "" + i );
            this.configurations.put ( "test" + i, new ConfigurationImpl ( "test" + i, factoryId, data ) );
        }
    }

    public synchronized void start ()
    {
        this.executor = Executors.newSingleThreadExecutor ();
    }

    public synchronized void stop ()
    {
        this.executor.shutdown ();
        this.executor = null;
    }

    public synchronized void addConfigurationListener ( final ConfigurationListener listener )
    {
        if ( !this.listeners.add ( listener ) )
        {
            return;
        }

        // notify the initial in the same thread
        listener.configurationUpdate ( this.configurations.values ().toArray ( new Configuration[0] ), null );
    }

    public synchronized NotifyFuture<Void> purge ()
    {
        notifyListeners ( null, this.configurations.keySet ().toArray ( new String[0] ) );
        this.configurations.clear ();

        return new InstantFuture<Void> ( null );
    }

    public synchronized NotifyFuture<Configuration> delete ( final String configurationId )
    {
        logger.info ( "Deleting: {}", configurationId );

        if ( this.configurations.remove ( configurationId ) != null )
        {
            notifyListeners ( null, new String[] { configurationId } );
        }

        return new InstantFuture<Configuration> ( new ConfigurationImpl ( configurationId, this.factoryId, null ) );
    }

    /**
     * Notify all listeners in a seperate thread
     * @param addedOrChanged the added or changed configs
     * @param deleted the deleted configs
     */
    private void notifyListeners ( final Configuration[] addedOrChanged, final String[] deleted )
    {
        final Set<ConfigurationListener> listeners = new HashSet<ConfigurationListener> ( this.listeners );

        this.executor.execute ( new Runnable () {

            public void run ()
            {
                for ( final ConfigurationListener listener : listeners )
                {
                    listener.configurationUpdate ( addedOrChanged, deleted );
                }
            }
        } );
    }

    public synchronized void removeConfigurationListener ( final ConfigurationListener listener )
    {
        this.listeners.remove ( listener );
    }

    public synchronized NotifyFuture<Configuration> update ( final String configurationId, final Map<String, String> properties, final boolean fullSet )
    {
        logger.info ( "Updating: {} -> {}", new Object[] { configurationId, properties } );
        ConfigurationImpl cfg = this.configurations.get ( configurationId );
        if ( cfg != null )
        {
            cfg.setData ( properties );
        }
        else
        {
            cfg = new ConfigurationImpl ( configurationId, this.factoryId, properties );
        }

        notifyListeners ( new Configuration[] { cfg }, null );

        return new InstantFuture<Configuration> ( new ConfigurationImpl ( configurationId, this.factoryId, null ) );
    }
}
