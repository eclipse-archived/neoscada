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
package org.eclipse.scada.da.mapper.osgi.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.locks.ReentrantLock;

import org.eclipse.scada.ca.ConfigurationDataHelper;
import org.eclipse.scada.core.Variant;
import org.eclipse.scada.core.VariantEditor;
import org.eclipse.scada.da.mapper.AbstractValueMapper;
import org.eclipse.scada.da.mapper.ValueMapper;
import org.eclipse.scada.da.server.common.osgi.factory.ObjectPoolDataItemFactory;
import org.eclipse.scada.utils.concurrent.NamedThreadFactory;
import org.eclipse.scada.utils.osgi.jdbc.DataSourceConnectionAccessor;
import org.eclipse.scada.utils.osgi.jdbc.DataSourceFactoryTracker;
import org.eclipse.scada.utils.osgi.jdbc.task.CommonConnectionTask;
import org.eclipse.scada.utils.osgi.jdbc.task.ConnectionContext;
import org.eclipse.scada.utils.osgi.jdbc.task.RowCallback;
import org.eclipse.scada.utils.osgi.pool.ManageableObjectPool;
import org.eclipse.scada.da.server.common.DataItem;
import org.eclipse.scada.da.server.common.DataItemCommand;
import org.eclipse.scada.da.server.common.DataItemCommand.Listener;
import org.eclipse.scada.da.server.common.exporter.ObjectExporter;
import org.osgi.framework.BundleContext;
import org.osgi.service.jdbc.DataSourceFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JdbcValueMapper extends AbstractValueMapper implements ValueMapper
{
    private final static Logger logger = LoggerFactory.getLogger ( JdbcValueMapper.class );

    private final ScheduledExecutorService executor;

    private static class Configuration
    {
        Variant defaultValue;

        String jdbcDriver;

        String sql;

        Properties jdbcProperties;

        public int loginTimeout;

        public int serviceTimeout;

        public String statePrefix;
    }

    private volatile Configuration configuration;

    private final BundleContext context;

    private final JdbcValueMapperState state;

    private final String id;

    private final ManageableObjectPool<DataItem> objectPool;

    private ObjectExporter exporter;

    private ObjectPoolDataItemFactory itemFactory;

    private final ReentrantLock updateLock;

    public JdbcValueMapper ( final BundleContext context, final String id, final ManageableObjectPool<DataItem> objectPool )
    {
        this.id = id;
        this.objectPool = objectPool;
        this.context = context;
        this.executor = Executors.newSingleThreadScheduledExecutor ( new NamedThreadFactory ( "org.eclipse.scada.da.mapper.osgi.jdbc" ) );

        this.state = new JdbcValueMapperState ();

        this.updateLock = new ReentrantLock ();
    }

    @Override
    public void dispose ()
    {
        disposeStateExporter ();

        this.executor.shutdown ();
        super.dispose ();
    }

    public void update ( final Map<String, String> parameters )
    {
        try
        {
            this.updateLock.lock ();

            disposeStateExporter ();

            final ConfigurationDataHelper cfg = new ConfigurationDataHelper ( parameters );

            final Configuration configuration = new Configuration ();
            configuration.defaultValue = makeDefaultValue ( cfg );
            configuration.jdbcDriver = cfg.getStringChecked ( "jdbcDriver", "'jdbcDriver' must be set" );
            configuration.jdbcProperties = new Properties ();
            configuration.jdbcProperties.putAll ( cfg.getPrefixed ( "properties." ) );
            configuration.loginTimeout = cfg.getInteger ( "loginTimeout", 5 );
            configuration.serviceTimeout = cfg.getInteger ( "serviceTimeout", 1000 );
            configuration.statePrefix = cfg.getString ( "statePrefix", String.format ( "datamapper.%s.", this.id ) );
            configuration.sql = cfg.getStringChecked ( "sql", "'sql' is required" );

            this.configuration = configuration;

            createStateExporter ();

            startUpdate ();
        }
        finally
        {
            this.updateLock.unlock ();
        }
    }

    private void createStateExporter ()
    {
        this.itemFactory = new ObjectPoolDataItemFactory ( this.executor, this.objectPool, this.configuration.statePrefix );
        this.exporter = new ObjectExporter ( this.itemFactory, false, false );
        this.exporter.attachTarget ( this.state );

        final DataItemCommand reloadCommand = this.itemFactory.createCommand ( "reload", null );
        reloadCommand.addListener ( new Listener () {

            @Override
            public void command ( final Variant value ) throws Exception
            {
                startUpdate ();
            }
        } );
    }

    private void disposeStateExporter ()
    {
        if ( this.exporter != null )
        {
            this.exporter.dispose ();
            this.exporter = null;
        }
        if ( this.itemFactory != null )
        {
            this.itemFactory.dispose ();
            this.itemFactory = null;
        }
    }

    private void startUpdate ()
    {
        this.executor.execute ( new Runnable () {

            @Override
            public void run ()
            {
                try
                {
                    JdbcValueMapper.this.state.setLoading ( true );
                    performReload ();
                }
                catch ( final Exception e )
                {
                    handleError ( e );
                }
                finally
                {
                    JdbcValueMapper.this.state.setLoading ( false );
                }
            }
        } );
    }

    protected void handleError ( final Exception e )
    {
        logger.warn ( "Failed to load data", e );
        super.configure ( Collections.<String, String> emptyMap (), this.configuration.defaultValue );
        this.state.setError ( true );
        this.state.setEntries ( 0 );
    }

    protected void performReload () throws Exception
    {
        final Configuration configuration = this.configuration;

        final Map<String, String> newData;

        final DataSourceFactoryTracker tracker = new DataSourceFactoryTracker ( this.context, configuration.jdbcDriver, null );

        try
        {
            tracker.open ();
            final DataSourceFactory factory = tracker.waitForService ( configuration.serviceTimeout );

            final DataSourceConnectionAccessor accessor = new DataSourceConnectionAccessor ( factory, configuration.jdbcProperties );
            accessor.getDataSource ().setLoginTimeout ( configuration.loginTimeout );
            newData = accessor.doWithConnection ( new CommonConnectionTask<Map<String, String>> () {

                @Override
                protected Map<String, String> performTask ( final ConnectionContext connectionContext ) throws Exception
                {
                    return doReload ( configuration, connectionContext );
                }
            } );
        }
        finally
        {
            tracker.close ();
        }

        configure ( newData, configuration.defaultValue );
    }

    @Override
    protected void configure ( final Map<String, String> data, final Variant defaultValue )
    {
        super.configure ( data, defaultValue );
        this.state.setError ( false );
        this.state.setEntries ( data.size () );
    }

    protected Map<String, String> doReload ( final Configuration configuration, final ConnectionContext connectionContext ) throws SQLException
    {
        final Map<String, String> result = new HashMap<String, String> ();

        connectionContext.query ( new RowCallback () {

            @Override
            public void processRow ( final ResultSet resultSet ) throws SQLException
            {
                final String key = resultSet.getString ( 1 );
                final String value = resultSet.getString ( 2 );
                result.put ( key, value );
            }
        }, configuration.sql );

        return result;
    }

    private Variant makeDefaultValue ( final ConfigurationDataHelper cfg )
    {
        final String stringValue = cfg.getString ( "defaultValue", null );
        if ( stringValue == null )
        {
            return null;
        }
        return VariantEditor.toVariant ( stringValue );
    }
}
