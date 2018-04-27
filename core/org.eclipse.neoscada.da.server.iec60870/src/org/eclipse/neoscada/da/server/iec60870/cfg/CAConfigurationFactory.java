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
package org.eclipse.neoscada.da.server.iec60870.cfg;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.neoscada.core.common.iec60870.Configurations;
import org.eclipse.neoscada.da.server.iec60870.CommandMessage;
import org.eclipse.neoscada.da.server.iec60870.ConnectionConfiguration;
import org.eclipse.neoscada.da.server.iec60870.QualifiedCommandMessage;
import org.eclipse.neoscada.protocol.iec60870.ProtocolOptions.Builder;
import org.eclipse.neoscada.protocol.iec60870.client.data.DataModuleOptions;
import org.eclipse.scada.ca.ConfigurationAdministrator;
import org.eclipse.scada.ca.ConfigurationDataHelper;
import org.eclipse.scada.sec.UserInformation;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.framework.ServiceRegistration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CAConfigurationFactory implements ConfigurationFactory, org.eclipse.scada.ca.ConfigurationFactory
{
    private final static Logger logger = LoggerFactory.getLogger ( CAConfigurationFactory.class );

    private Receiver receiver;

    private final ServiceRegistration<org.eclipse.scada.ca.ConfigurationFactory> handle;

    private final Map<String, ConnectionConfiguration> configurations = new HashMap<> ();

    public CAConfigurationFactory ( final BundleContext context )
    {
        final Dictionary<String, Object> properties = new Hashtable<> ( 3 );
        properties.put ( ConfigurationAdministrator.FACTORY_ID, "org.eclipse.neoscada.da.server.iec60870.connection" );
        properties.put ( Constants.SERVICE_DESCRIPTION, "IEC60870-5-104 connection" );
        properties.put ( Constants.SERVICE_VENDOR, "Eclipse SCADA Project" );

        this.handle = context.registerService ( org.eclipse.scada.ca.ConfigurationFactory.class, this, properties );
    }

    public synchronized void dispose ()
    {
        this.handle.unregister ();
        this.configurations.clear ();
    }

    @Override
    public synchronized void setReceiver ( final Receiver receiver )
    {
        logger.debug ( "Setting receiver: {}", receiver );

        this.receiver = receiver;

        if ( receiver != null )
        {
            logger.debug ( "Pushing stored configuration" );
            for ( final Map.Entry<String, ConnectionConfiguration> entry : this.configurations.entrySet () )
            {
                logger.debug ( "\t{}", entry.getKey () );
                // we don't wait here for the result
                receiver.addConnection ( entry.getKey (), entry.getValue () );
            }
        }
    }

    private ConnectionConfiguration parse ( final Map<String, String> properties )
    {
        final ConfigurationDataHelper cfg = new ConfigurationDataHelper ( properties );

        final String host = cfg.getStringNonEmptyChecked ( "host", "'host' must be set" );
        final int port = cfg.getInteger ( "port", 2404 );

        final Builder builder = Configurations.parseProtocolOptions ( cfg.getPrefixedHelper ( "protocol." ) );
        final DataModuleOptions dataModuleOptions = parseDataModuleOptions ( cfg.getPrefixedHelper ( "dataModule." ) );

        final Map<String, QualifiedCommandMessage> itemTypes = new HashMap<> ();
        for ( final Entry<String, String> entry : cfg.getPrefixed ( "itemType." ).entrySet () )
        {
            try
            {
                final QualifiedCommandMessage qcm;
                if ( entry.getValue ().contains ( "#" ) )
                {
                    String[] parts = entry.getValue ().split ( "#" );
                    final CommandMessage cm = CommandMessage.valueOf ( parts[0] );
                    qcm = new QualifiedCommandMessage ( cm, Byte.parseByte ( parts[1] ) );
                }
                else
                {
                    final CommandMessage cm = CommandMessage.valueOf ( entry.getValue () );
                    qcm = new QualifiedCommandMessage ( cm );
                }
                itemTypes.put ( entry.getKey (), qcm );
            }
            catch ( Exception e )
            {
                logger.warn ( "type {} (of key '{}') is not a valid IEC type; will be ignored", entry.getValue (), entry.getKey () );
            }
        }

        return new ConnectionConfiguration ( host, port, builder.build (), dataModuleOptions, itemTypes );
    }

    private DataModuleOptions parseDataModuleOptions ( final ConfigurationDataHelper cfg )
    {
        final DataModuleOptions.Builder builder = new DataModuleOptions.Builder ();

        builder.setIgnoreBackgroundScan ( cfg.getBoolean ( "ignoreBackgroundScan", true ) );

        return builder.build ();
    }

    @Override
    public synchronized void update ( final UserInformation userInformation, final String configurationId, final Map<String, String> properties ) throws Exception
    {
        logger.debug ( "Request to update configuration: {}", configurationId );

        delete ( userInformation, configurationId );

        final ConnectionConfiguration cfg = parse ( properties );
        this.configurations.put ( configurationId, cfg );
        logger.debug ( "Configuration cached internally: {}", cfg );

        if ( this.receiver != null )
        {
            logger.debug ( "Forwarding update to receiver" );
            this.receiver.addConnection ( configurationId, cfg ).get ();
        }
    }

    @Override
    public synchronized void delete ( final UserInformation userInformation, final String configurationId ) throws Exception
    {
        logger.debug ( "Request to delete configuration: {}", configurationId );

        if ( this.receiver != null )
        {
            logger.debug ( "Forwarding deletion to receiver" );
            this.receiver.removeConnection ( configurationId );
        }
        this.configurations.remove ( configurationId );
    }

}
