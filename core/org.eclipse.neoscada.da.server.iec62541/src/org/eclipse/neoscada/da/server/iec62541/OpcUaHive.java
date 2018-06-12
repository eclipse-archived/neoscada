package org.eclipse.neoscada.da.server.iec62541;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

import org.eclipse.scada.da.server.browser.common.FolderCommon;
import org.eclipse.scada.da.server.common.DataItem;
import org.eclipse.scada.da.server.common.ValidationStrategy;
import org.eclipse.scada.da.server.common.impl.HiveCommon;
import org.eclipse.scada.utils.concurrent.NamedThreadFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OpcUaHive extends HiveCommon
{
    private final static Logger logger = LoggerFactory.getLogger ( OpcUaHive.class );

    private final static String DATA_DELIM_PATTERN = Pattern.quote ( ".data" + OpcUaConnection.DATA_DELIM );

    private FolderCommon rootFolder;

    private final Path configDir;

    private ScheduledExecutorService executor;

    private WatchService watchService;

    private final ConcurrentMap<String, OpcUaConnection> configuredConnections = new ConcurrentSkipListMap<> ();

    public OpcUaHive ( final String configDir )
    {
        super ();

        setValidatonStrategy ( ValidationStrategy.GRANT_ALL );

        this.configDir = Paths.get ( configDir );
        setRootFolder ( this.rootFolder = new FolderCommon () );
    }

    @Override
    public String getHiveId ()
    {
        return getClass ().getPackage ().getName ();
    }

    @Override
    public void performStart () throws Exception
    {
        super.performStart ();
        this.executor = Executors.newSingleThreadScheduledExecutor ( new NamedThreadFactory ( OpcUaHive.class.getName () ) );
        this.watchService = FileSystems.getDefault ().newWatchService ();
        this.configDir.register ( this.watchService, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_DELETE, StandardWatchEventKinds.ENTRY_MODIFY );
        this.executor.submit ( new Runnable () {
            @Override
            public void run ()
            {
                reConfigureHive ();
            }
        } );
        // every ten seconds check if config file has changed in the meantime
        this.executor.scheduleAtFixedRate ( new Runnable () {
            @Override
            public void run ()
            {
                checkForConfigChange ();
            }
        }, 0, 10, TimeUnit.SECONDS );
    }

    protected void checkForConfigChange ()
    {
        boolean trigger = false;
        if ( this.watchService != null )
        {
            final WatchKey wk = this.watchService.poll ();
            if ( wk == null )
            {
                return;
            }
            // we only care if file has been touched at all
            trigger = !wk.pollEvents ().isEmpty ();
            wk.reset ();
        }
        if ( trigger )
        {
            this.executor.submit ( new Runnable () {
                @Override
                public void run ()
                {
                    reConfigureHive ();
                }
            } );
        }
    }

    protected void reConfigureHive ()
    {
        logger.info ( "reconfigure hive" );
        final SortedSet<ConnectionConfig> currentPlantConfigs = ConnectionConfig.readConnectionConfigs ( this.configDir.toFile () );
        final SortedSet<ConnectionConfig> toDelete = new TreeSet<> ();
        final SortedSet<ConnectionConfig> toCreate = new TreeSet<> ();
        for ( final ConnectionConfig connectionConfig : currentPlantConfigs )
        {
            if ( !this.configuredConnections.containsValue ( connectionConfig ) )
            {
                toCreate.add ( connectionConfig );
            }
        }
        for ( final OpcUaConnection connection : this.configuredConnections.values () )
        {
            if ( !currentPlantConfigs.contains ( connection.getConfiguration () ) )
            {
                toDelete.add ( connection.getConfiguration () );
            }
        }
        for ( final ConnectionConfig connectionConfig : toDelete )
        {
            removeServer ( connectionConfig );
        }
        for ( final ConnectionConfig connectionConfig : toCreate )
        {
            addServer ( connectionConfig );
        }
    }

    private OpcUaConnection addServer ( final ConnectionConfig connectionConfig )
    {
        final OpcUaConnection service = new OpcUaConnection ( connectionConfig, this, this.rootFolder );

        synchronized ( this )
        {
            // perform add
            final OpcUaConnection oldService = this.configuredConnections.put ( connectionConfig.getName (), service );
            if ( oldService != null )
            {
                oldService.dispose ();
            }
        }

        service.start ();

        return service;
    }

    private void removeServer ( final ConnectionConfig connectionConfig )
    {
        final OpcUaConnection server;

        synchronized ( this )
        {
            server = this.configuredConnections.remove ( connectionConfig.getName () );
        }
        if ( server != null )
        {
            server.dispose ();
        }
    }

    @Override
    public void performStop () throws Exception
    {
        if ( this.watchService != null )
        {
            this.watchService.close ();
        }
        this.watchService = null;
        if ( this.executor != null )
        {
            this.executor.shutdown ();
        }
        this.executor = null;

        super.performStop ();
    }

    @Override
    public DataItem lookupItem ( final String id )
    {
        final String[] toks = parseDataItem ( id );
        if ( toks == null )
        {
            return super.lookupItem ( id );
        }

        return getDataItem ( toks[0], toks[1] );
    }

    /**
     * Parse a data item for connection and item id
     *
     * @param the
     *            Eclipse SCADA item id
     * @return an array of two elements, "connection id" and "opc item id" or
     *         {@code null} if the item could not be parsed
     */
    public static String[] parseDataItem ( final String id )
    {
        final String[] toks = id.split ( DATA_DELIM_PATTERN, 2 );
        if ( toks.length == 2 )
        {
            return toks;
        }
        return null;
    }

    protected DataItem getDataItem ( final String connectionId, final String remoteId )
    {
        OpcUaConnection server = null;

        server = this.configuredConnections.get ( connectionId );

        if ( server == null )
        {
            return null;
        }

        return server.getRemoteDataItem ( remoteId );
    }

}
