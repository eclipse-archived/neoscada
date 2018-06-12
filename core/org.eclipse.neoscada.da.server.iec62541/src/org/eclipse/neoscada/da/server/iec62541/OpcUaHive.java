package org.eclipse.neoscada.da.server.iec62541;

import java.net.URL;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.ScheduledExecutorService;
import java.util.regex.Pattern;

import org.eclipse.scada.ca.ConfigurationAdministrator;
import org.eclipse.scada.ca.ConfigurationDataHelper;
import org.eclipse.scada.da.server.browser.common.FolderCommon;
import org.eclipse.scada.da.server.common.DataItem;
import org.eclipse.scada.da.server.common.ValidationStrategy;
import org.eclipse.scada.da.server.common.osgi.AbstractOsgiHiveCommon;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.ServiceRegistration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OpcUaHive extends AbstractOsgiHiveCommon
{
    private final static Logger logger = LoggerFactory.getLogger ( OpcUaHive.class );

    private final static String DATA_DELIM_PATTERN = Pattern.quote ( ".data" + OpcUaConnection.DATA_DELIM );

    private FolderCommon rootFolder;

    private ServiceRegistration<org.eclipse.scada.ca.ConfigurationFactory> handle;

    private final ConcurrentMap<String, OpcUaConnection> servers = new ConcurrentSkipListMap<> ();

    private final BundleContext context;

    private final ConfigurationFactory configurator;

    public OpcUaHive ()
    {
        this ( FrameworkUtil.getBundle ( OpcUaHive.class ).getBundleContext () );
    }

    public OpcUaHive ( final BundleContext context )
    {
        super ( context );

        this.context = context;

        setValidationStrategy ( ValidationStrategy.GRANT_ALL );

        this.rootFolder = new FolderCommon ();
        setRootFolder ( this.rootFolder );

        this.configurator = new ConfigurationFactory ( this );
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

        final Dictionary<String, Object> properties = new Hashtable<> ( 2 );
        properties.put ( ConfigurationAdministrator.FACTORY_ID, "org.eclipse.neoscada.da.server.iec62541.server" );
        properties.put ( Constants.SERVICE_DESCRIPTION, "An IEC 62541 (OPC UA) DA server connection" );
        this.handle = this.context.registerService ( org.eclipse.scada.ca.ConfigurationFactory.class, this.configurator, properties );
    }

    @Override
    protected void performStop () throws Exception
    {
        this.handle.unregister ();
        super.performStop ();
    }

    OpcUaConnection addServer ( final String configurationId, final Map<String, String> parameters ) throws Exception
    {
        final ConfigurationDataHelper cfg = new ConfigurationDataHelper ( parameters );

        final URL url = new URL ( cfg.getStringNonEmptyChecked ( "url", "'url' must be set to a valid server URL" ) );

        final ServerConfiguration config = new ServerConfiguration ( url );

        final OpcUaConnection service = new OpcUaConnection ( configurationId, config, this, this.rootFolder );

        synchronized ( this )
        {
            // perform add
            final OpcUaConnection oldService = this.servers.put ( configurationId, service );
            if ( oldService != null )
            {
                oldService.dispose ();
            }
        }

        service.start ();

        return service;
    }

    void removeServer ( final String configurationId )
    {
        final OpcUaConnection server;

        synchronized ( this )
        {
            server = this.servers.remove ( configurationId );
        }
        if ( server != null )
        {
            server.dispose ();
        }
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

        server = this.servers.get ( connectionId );

        if ( server == null )
        {
            return null;
        }

        return server.getRemoteDataItem ( remoteId );
    }

}
