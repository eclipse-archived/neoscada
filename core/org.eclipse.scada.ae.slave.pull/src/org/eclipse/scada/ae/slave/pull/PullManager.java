/*******************************************************************************
 * Copyright (c) 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *******************************************************************************/
package org.eclipse.scada.ae.slave.pull;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.eclipse.scada.ca.ConfigurationDataHelper;
import org.eclipse.scada.ca.ConfigurationFactory;
import org.eclipse.scada.sec.UserInformation;
import org.eclipse.scada.utils.osgi.jdbc.DataSourceConnectionAccessor;
import org.eclipse.scada.utils.osgi.jdbc.DataSourceFactoryTracker;
import org.eclipse.scada.utils.osgi.jdbc.DataSourceHelper;
import org.eclipse.scada.utils.osgi.jdbc.data.SingleColumnRowMapper;
import org.eclipse.scada.utils.osgi.jdbc.task.CommonConnectionTask;
import org.eclipse.scada.utils.osgi.jdbc.task.ConnectionContext;
import org.eclipse.scada.utils.osgi.jdbc.task.RowCallback;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.service.jdbc.DataSourceFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PullManager implements ConfigurationFactory
{
    private static final String SPECIFIC_PREFIX = "org.eclipse.scada.ae.slave.pull";

    private final static Logger logger = LoggerFactory.getLogger ( PullManager.class );

    public static final String FACTORY_ID = "org.eclipse.scada.ae.slave.pull";

    private final List<Site> sites = new ArrayList<Site> ();

    private volatile boolean needRefresh;

    private final Thread thread;

    private volatile boolean running = true;

    private final long gracePeriod = 10 * 1000;

    private Map<String, DataSourceFactoryTracker> dataSourceFactoryTrackers = new HashMap<String, DataSourceFactoryTracker> ();

    private final DataSourceFactoryTracker tracker;

    public PullManager () throws InvalidSyntaxException
    {
        final String driver = DataSourceHelper.getDriver ( SPECIFIC_PREFIX, DataSourceHelper.DEFAULT_PREFIX );
        this.tracker = new DataSourceFactoryTracker ( Activator.getContext (), driver, null );

        if ( driver == null )
        {
            logger.error ( "JDBC driver is not set" );
            throw new IllegalStateException ( "JDBC driver name is not set" );
        }

        this.tracker.open ();

        this.thread = new Thread ( "org.eclipse.scada.ae.slave.pull.Worker" ) {
            @Override
            public void run ()
            {
                PullManager.this.run ();
            }
        };
        this.thread.start ();
    }

    public void dispose ()
    {
        synchronized ( this )
        {
            // we are already disposed
            if ( !this.running )
            {
                return;
            }

            // mark as disposed
            this.running = false;

            // notify that we are disposing
            notifyAll ();
        }

        // wait until "endWait"
        final long endWait = System.currentTimeMillis () + this.gracePeriod;
        logger.debug ( "Waiting until {}", endWait );

        try
        {
            // try waiting
            while ( this.thread.isAlive () && endWait > System.currentTimeMillis () )
            {
                final long delay = endWait - System.currentTimeMillis ();
                logger.debug ( "Waiting for {} ms", delay );
                try
                {
                    this.thread.join ( delay );
                    // thread is shut down
                    return;
                }
                catch ( final InterruptedException e )
                {
                    logger.warn ( "Got interrupted while waiting for thread shutdown", e );
                }
            }
        }
        finally
        {
            if ( this.thread.isAlive () )
            {
                logger.warn ( "Failed to stop thread after {} ms - now: {}", this.gracePeriod, System.currentTimeMillis () );
            }

            disposeTrackers ();

            // close the local tracer
            this.tracker.close ();
        }
    }

    private void disposeTrackers ()
    {
        for ( final DataSourceFactoryTracker tracker : this.dataSourceFactoryTrackers.values () )
        {
            tracker.close ();
        }
        this.dataSourceFactoryTrackers.clear ();
    }

    public void run ()
    {
        try
        {
            while ( this.running )
            {
                if ( !this.running )
                {
                    logger.warn ( "Not running anymore. Exiting pull thread..." );
                    return;
                }

                try
                {
                    runOnce ();
                }
                catch ( final Exception e )
                {
                    logger.warn ( "Failed to process", e );
                }

                waitForNext ();
            }
        }
        finally
        {
            disposeTrackers ();
        }
    }

    private synchronized void waitForNext ()
    {
        long start = nextStart ();
        logger.debug ( "Next site due in {} ms", start - System.currentTimeMillis () );

        while ( start > System.currentTimeMillis () )
        {
            try
            {
                if ( !this.running )
                {
                    return;
                }

                wait ( start - System.currentTimeMillis () );
                if ( this.needRefresh )
                {
                    start = nextStart ();
                    logger.debug ( "Update - Next site due in {} ms", start - System.currentTimeMillis () );
                }
            }
            catch ( final InterruptedException e )
            {
                logger.warn ( "Failed to wait for next", e );
            }
        }
    }

    private long nextStart ()
    {
        if ( this.sites.isEmpty () )
        {
            return Long.MAX_VALUE;
        }

        Collections.sort ( this.sites, new Comparator<Site> () {

            @Override
            public int compare ( final Site o1, final Site o2 )
            {
                return Long.valueOf ( o1.nextStart () ).compareTo ( o2.nextStart () );
            }
        } );

        final Site nextSite = this.sites.get ( 0 );
        return nextSite.nextStart ();
    }

    public void runOnce () throws SQLException
    {
        final DataSourceFactory localFactory = this.tracker.getService ();
        if ( localFactory == null )
        {
            throw new IllegalStateException ( String.format ( "Failed to get local data source factory - %s", this.tracker.getDriver () ) );
        }

        final Properties properties = DataSourceHelper.getDataSourceProperties ( SPECIFIC_PREFIX, DataSourceHelper.DEFAULT_PREFIX );

        logger.debug ( "Opening database connection for local: {}", properties );

        final DataSourceConnectionAccessor accessor = new DataSourceConnectionAccessor ( localFactory, properties );
        try
        {
            accessor.doWithConnection ( new CommonConnectionTask<Void> () {
                @Override
                protected Void performTask ( final ConnectionContext connectionContext ) throws Exception
                {
                    processSites ( connectionContext );
                    return null;
                }
            } );

        }
        finally
        {
            accessor.dispose ();
        }
    }

    private void processSites ( final ConnectionContext localContext )
    {
        final Site[] sites;

        boolean updateTrackers = false;

        // make a copy inside the lock
        synchronized ( this )
        {
            if ( this.needRefresh )
            {
                updateTrackers = true;
                this.needRefresh = false;
            }
            sites = this.sites.toArray ( new Site[this.sites.size ()] );
        }

        if ( updateTrackers )
        {
            updateTrackers ( sites );
        }

        // process sites
        for ( final Site site : sites )
        {
            if ( this.needRefresh || !this.running )
            {
                // early abort
                return;
            }
            try
            {
                if ( site.isDue () )
                {
                    /* we mark it as processed first since we also delay
                     * the site if the transfer was not successful. Otherwise
                     * we would only try to re-process the broken site.
                     */
                    site.markProcessed ();
                    processSite ( site, localContext );
                }
            }
            catch ( final Exception e )
            {
                logger.warn ( "Failed to process site: " + site.getId (), e );
            }
        }
    }

    private void updateTrackers ( final Site[] sites )
    {
        logger.info ( "Updating trackers" );

        final Map<String, DataSourceFactoryTracker> newTrackers = new HashMap<String, DataSourceFactoryTracker> ();

        for ( final Site site : sites )
        {
            logger.debug ( "Checking driver - {}", site.getDriverName () );

            if ( newTrackers.containsKey ( site.getDriverName () ) )
            {
                logger.debug ( "New tracker list already contains driver" );
                continue;
            }
            DataSourceFactoryTracker tracker = this.dataSourceFactoryTrackers.remove ( site.getDriverName () );
            if ( tracker != null )
            {
                logger.debug ( "Taking tracker from old list" );
                newTrackers.put ( site.getDriverName (), tracker );
                continue;
            }
            else
            {
                try
                {
                    logger.debug ( "Creating new tracker" );
                    tracker = new DataSourceFactoryTracker ( Activator.getContext (), site.getDriverName (), null );
                    tracker.open ();
                    newTrackers.put ( site.getDriverName (), tracker );
                }
                catch ( final InvalidSyntaxException e )
                {
                    logger.warn ( "Failed to create tracker", e );
                }
            }
        }

        final Collection<DataSourceFactoryTracker> closeTrackers = new ArrayList<DataSourceFactoryTracker> ( this.dataSourceFactoryTrackers.values () );

        this.dataSourceFactoryTrackers = newTrackers;

        for ( final DataSourceFactoryTracker tracker : closeTrackers )
        {
            logger.debug ( "Closing old tracker: {}", tracker.getDriver () );
            tracker.close ();
        }
    }

    @Override
    public synchronized void update ( final UserInformation userInformation, final String configurationId, final Map<String, String> properties ) throws Exception
    {
        this.needRefresh = true;

        final Site oldSite = performDelete ( configurationId );

        final Site site = createSite ( configurationId, properties );

        if ( oldSite != null )
        {
            site.setLastProcess ( oldSite.getLastProcess () );
        }

        if ( site == null )
        {
            return;
        }

        this.sites.add ( site );

        // signal that the configuration was changed
        notifyAll ();
    }

    private Site performDelete ( final String configurationId )
    {
        final Iterator<Site> i = this.sites.iterator ();
        while ( i.hasNext () )
        {
            final Site site = i.next ();
            if ( site.getId ().equals ( configurationId ) )
            {
                i.remove ();
                return site;
            }
        }
        return null;
    }

    private void processSite ( final Site site, final ConnectionContext localContext ) throws Exception
    {
        logger.info ( "Processing site: {}", site.getId () );

        final DataSourceFactoryTracker tracker = this.dataSourceFactoryTrackers.get ( site.getDriverName () );
        if ( tracker == null )
        {
            throw new IllegalStateException ( "Site is configured but has not data source factory tracker" );
        }

        final DataSourceFactory factory = tracker.getService ();
        if ( factory == null )
        {
            throw new IllegalStateException ( String.format ( "Site's driver could not be found - %s", site.getDriverName () ) );
        }

        final DataSourceConnectionAccessor accessor = new DataSourceConnectionAccessor ( factory, site.getProperties () );
        try
        {
            accessor.doWithConnection ( new CommonConnectionTask<Void> () {

                @Override
                protected Void performTask ( final ConnectionContext context ) throws Exception
                {
                    transferSite ( site, localContext, context );
                    return null;
                }
            } );
        }
        finally
        {
            accessor.dispose ();
        }
    }

    protected void transferSite ( final Site site, final ConnectionContext localContext, final ConnectionContext context ) throws SQLException
    {
        localContext.setAutoCommit ( false );
        context.setAutoCommit ( false );

        context.query ( new RowCallback () {

            @Override
            public void processRow ( final ResultSet resultSet ) throws SQLException
            {
                transferEntry ( site, localContext, context, resultSet );
                if ( PullManager.this.needRefresh )
                {
                    throw new RuntimeException ( "Configuration data was refreshed. We abort..." );
                }
            }
        }, makeSelectSql ( site ) );

        logger.info ( "Starting commit ... local ... " );
        localContext.commit ();
        logger.info ( "Starting commit ... global ... " );
        context.commit ();
        logger.info ( "Comitted" );
    }

    protected void transferEntry ( final Site site, final ConnectionContext localContext, final ConnectionContext context, final ResultSet resultSet ) throws SQLException
    {
        final String id = resultSet.getString ( 1 );

        if ( !entryExists ( localContext, id ) )
        {
            logger.debug ( "Inserting event {} into local data store", id );
            localContext.update ( String.format ( "INSERT INTO %sOPENSCADA_AE_REP ( ID, ENTRY_TIMESTAMP, NODE_ID, DATA ) VALUES ( ?, ?, ? , ?)", getSchema () ), resultSet.getObject ( 1 ), resultSet.getObject ( 2 ), resultSet.getObject ( 3 ), resultSet.getObject ( 4 ) );
        }

        logger.debug ( "Deleting entry {} in local site", id );
        context.update ( makeDeleteSql ( site ), resultSet.getObject ( 1 ) );
    }

    private boolean entryExists ( final ConnectionContext localContext, final String id ) throws SQLException
    {
        final List<Number> result = localContext.query ( new SingleColumnRowMapper<Number> ( Number.class ), String.format ( "SELECT COUNT(*) FROM %sOPENSCADA_AE_REP WHERE ID=?", getSchema () ), id );
        if ( result.isEmpty () )
        {
            return false;
        }

        return result.get ( 0 ).intValue () > 0;
    }

    private String getSchema ()
    {
        return System.getProperty ( "org.eclipse.scada.ae.slave.pull.local.schema", "" );
    }

    private String makeDeleteSql ( final Site site )
    {
        if ( site.getCustomDeleteSql () != null )
        {
            return site.getCustomDeleteSql ();
        }
        else
        {
            return String.format ( "DELETE FROM %sOPENSCADA_AE_REP WHERE ID=?", getSiteSchema ( site ) );
        }
    }

    private String makeSelectSql ( final Site site )
    {
        if ( site.getCustomSelectSql () != null )
        {
            return site.getCustomSelectSql ();
        }
        else
        {
            return String.format ( "SELECT ID, ENTRY_TIMESTAMP, NODE_ID, DATA from %sOPENSCADA_AE_REP", getSiteSchema ( site ) );
        }
    }

    private String getSiteSchema ( final Site site )
    {
        if ( site.getSchema () == null )
        {
            return "";
        }
        else
        {
            return site.getSchema ();
        }
    }

    private Site createSite ( final String configurationId, final Map<String, String> properties ) throws Exception
    {
        final ConfigurationDataHelper cfg = new ConfigurationDataHelper ( properties );

        final String driverName = cfg.getStringChecked ( "driverName", "'driverName' must be set" );
        final Properties jdbcProperties = cfg.getPrefixedProperties ( "jdbcProperties." );
        final long delay = cfg.getLong ( "delay", 10 * 1000 );
        final String schema = cfg.getString ( "schema", "" );

        final String customSelectSql = cfg.getString ( "customSelectSql", null );
        final String customDeleteSql = cfg.getString ( "customDeleteSql", null );

        return new Site ( configurationId, driverName, jdbcProperties, schema, delay, customSelectSql, customDeleteSql );
    }

    @Override
    public synchronized void delete ( final UserInformation userInformation, final String configurationId ) throws Exception
    {
        performDelete ( configurationId );

        this.needRefresh = true;

        // signal that the configuration was changed
        notifyAll ();
    }
}
