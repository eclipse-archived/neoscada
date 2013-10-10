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
package org.eclipse.scada.ca.jdbc.internal;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.scada.ca.common.AbstractConfigurationAdministrator;
import org.eclipse.scada.ca.common.ConfigurationImpl;
import org.eclipse.scada.sec.UserInformation;
import org.osgi.framework.BundleContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConfigurationAdministratorImpl extends AbstractConfigurationAdministrator
{
    private final static Logger logger = LoggerFactory.getLogger ( ConfigurationAdministratorImpl.class );

    private static final int INITIAL_CFG_SIZE = Integer.getInteger ( "org.eclipse.scada.ca.jdbc.initialConfigurationHashSize", 4 );

    private final boolean disableIntern = Boolean.getBoolean ( "org.eclipse.scada.ca.jdbc.disableIntern" );

    private final JdbcStorageDAO jdbcStorageDAO;

    public ConfigurationAdministratorImpl ( final BundleContext context, final JdbcStorageDAO jdbcStorageDAO )
    {
        super ( context );
        this.jdbcStorageDAO = jdbcStorageDAO;
    }

    @Override
    public synchronized void start () throws Exception
    {
        super.start ();
        initialLoad ();
    }

    protected synchronized void initialLoad () throws SQLException
    {
        logger.debug ( "Starting initial load" );

        final List<String> factoryIds = this.jdbcStorageDAO.listFactories ();
        // map
        final Map<String, Map<String, Map<String, String>>> factories = new HashMap<String, Map<String, Map<String, String>>> ( factoryIds.size () );

        for ( final String factoryId : factoryIds )
        {
            // load
            final List<Entry> result = this.jdbcStorageDAO.loadFactory ( factoryId );

            logger.debug ( "Loaded {} initial entries for factory {}", result.size (), factoryId );

            for ( final Entry entry : result )
            {
                if ( ( entry.getFactoryId () == null ) || ( entry.getConfigurationId () == null ) || ( entry.getKey () == null ) )
                {
                    continue;
                }

                Map<String, Map<String, String>> factory = factories.get ( entry.getFactoryId () );
                if ( factory == null )
                {
                    factory = new HashMap<String, Map<String, String>> ();
                    factories.put ( intern ( entry.getFactoryId () ), factory );
                }
                Map<String, String> cfg = factory.get ( entry.getConfigurationId () );
                if ( cfg == null )
                {
                    // no need to intern configuration ids as they are unique
                    cfg = new HashMap<String, String> ( INITIAL_CFG_SIZE );
                    factory.put ( entry.getConfigurationId (), cfg );
                }

                final String value = intern ( entry.getValue () );
                final String key = intern ( entry.getKey () );

                cfg.put ( key, value );
            }
        }

        // announce
        for ( final Map.Entry<String, Map<String, Map<String, String>>> factory : factories.entrySet () )
        {
            final Collection<ConfigurationImpl> configurations = new ArrayList<ConfigurationImpl> ( factory.getValue ().size () );

            for ( final Map.Entry<String, Map<String, String>> configurationEntry : factory.getValue ().entrySet () )
            {
                final ConfigurationImpl cfg = new ConfigurationImpl ( configurationEntry.getKey (), factory.getKey (), configurationEntry.getValue () );
                configurations.add ( cfg );
            }

            addStoredFactory ( factory.getKey (), configurations.toArray ( new ConfigurationImpl[configurations.size ()] ) );
        }
    }

    private String intern ( final String string )
    {
        if ( this.disableIntern )
        {
            return string;
        }
        if ( string == null )
        {
            return null;
        }
        return string.intern ();
    }

    @Override
    protected synchronized void performDeleteConfiguration ( final UserInformation userInformation, final String factoryId, final String configurationId, final ConfigurationFuture future ) throws Exception
    {
        this.jdbcStorageDAO.deleteConfiguration ( factoryId, configurationId );

        changeConfiguration ( userInformation, factoryId, configurationId, null, future );
    }

    @Override
    protected synchronized void performPurge ( final UserInformation userInformation, final String factoryId, final PurgeFuture future )
    {
        logger.info ( "Purging: {}", factoryId );

        final Set<String> done = new HashSet<String> ();
        for ( final Entry entry : this.jdbcStorageDAO.purgeFactory ( factoryId ) )
        {
            if ( done.add ( entry.getConfigurationId () ) )
            {
                final ConfigurationFuture subFuture = new ConfigurationFuture ();
                changeConfiguration ( userInformation, factoryId, entry.getConfigurationId (), null, subFuture );

                future.addChild ( subFuture );
            }
        }
        logger.info ( "Purging: {} complete", factoryId );
        future.setComplete ();
    }

    @Override
    protected synchronized void performStoreConfiguration ( final UserInformation userInformation, final String factoryId, final String configurationId, final Map<String, String> properties, final boolean fullSet, final ConfigurationFuture future ) throws Exception
    {
        final Map<String, String> resultProperties = this.jdbcStorageDAO.storeConfiguration ( factoryId, configurationId, properties, fullSet );

        changeConfiguration ( userInformation, factoryId, configurationId, resultProperties, future );
    }

}
