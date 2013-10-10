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
package org.eclipse.scada.ae.server.storage.jdbc;

import java.sql.SQLException;
import java.util.Properties;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.eclipse.scada.ae.Event;
import org.eclipse.scada.utils.concurrent.NamedThreadFactory;
import org.eclipse.scada.utils.osgi.jdbc.task.ConnectionContext;
import org.osgi.service.jdbc.DataSourceFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Interner;

public class JdbcStorageDao extends AbstractJdbcStorageDao
{

    private final static Logger logger = LoggerFactory.getLogger ( JdbcStorageDao.class );

    private final ScheduledExecutorService executor;

    public JdbcStorageDao ( final DataSourceFactory dataSourceFactory, final Properties properties, final boolean usePool, final Interner<String> stringInterner ) throws SQLException
    {
        super ( dataSourceFactory, properties, usePool, stringInterner );

        this.executor = Executors.newSingleThreadScheduledExecutor ( new NamedThreadFactory ( "org.eclipse.scada.ae.server.storage.jdbc/CleanupThread" ) );
        this.executor.scheduleWithFixedDelay ( new Runnable () {

            @Override
            public void run ()
            {
                cleanupArchive ();
            }
        }, getCleanupPeriod (), getCleanupPeriod (), TimeUnit.SECONDS );
    }

    @Override
    public void dispose ()
    {
        logger.info ( "Shutting down" );
        this.executor.shutdown ();

        super.dispose ();
        logger.info ( "Shutdown complete" );
    }

    protected boolean isReplication ()
    {
        return Boolean.getBoolean ( "org.eclipse.scada.ae.server.storage.jdbc.enableReplication" );
    }

    public static long getCleanupPeriod ()
    {
        return Long.getLong ( "org.eclipse.scada.ae.server.storage.jdbc.cleanupPeriodSeconds", 60 * 60 /* default to one hour */);
    }

    @Override
    protected void performStoreEvent ( final Event event, final ConnectionContext connectionContext ) throws SQLException, Exception
    {
        super.performStoreEvent ( event, connectionContext );
        if ( isReplication () )
        {
            storeReplicationEvent ( event, connectionContext.getConnection () );
        }
    }
}
