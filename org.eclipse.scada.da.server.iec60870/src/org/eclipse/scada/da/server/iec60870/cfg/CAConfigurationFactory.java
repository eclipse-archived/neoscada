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
package org.eclipse.scada.da.server.iec60870.cfg;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import org.eclipse.scada.ca.ConfigurationAdministrator;
import org.eclipse.scada.ca.ConfigurationDataHelper;
import org.eclipse.scada.core.common.iec60870.Configurations;
import org.eclipse.scada.da.server.iec60870.ConnectionConfiguration;
import org.eclipse.scada.protocol.iec60870.ProtocolOptions.Builder;
import org.eclipse.scada.sec.UserInformation;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.framework.ServiceRegistration;

public class CAConfigurationFactory implements ConfigurationFactory, org.eclipse.scada.ca.ConfigurationFactory
{

    private Receiver receiver;

    private final ServiceRegistration<org.eclipse.scada.ca.ConfigurationFactory> handle;

    private final Map<String, ConnectionConfiguration> configurations = new HashMap<> ();

    public CAConfigurationFactory ( final BundleContext context )
    {
        final Dictionary<String, Object> properties = new Hashtable<> ( 3 );
        properties.put ( ConfigurationAdministrator.FACTORY_ID, "org.eclipse.scada.da.server.iec60870.connection" );
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
    public void setReceiver ( final Receiver receiver )
    {
        this.receiver = receiver;
    }

    private ConnectionConfiguration parse ( final Map<String, String> properties )
    {
        final ConfigurationDataHelper cfg = new ConfigurationDataHelper ( properties );

        final String host = cfg.getStringNonEmpty ( "hostname" );
        final int port = cfg.getInteger ( "port", 2404 );

        final Builder builder = Configurations.parseProtocolOptions ( cfg.getPrefixedHelper ( "protocol" ) );

        return new ConnectionConfiguration ( host, port, builder.build () );
    }

    @Override
    public synchronized void update ( final UserInformation userInformation, final String configurationId, final Map<String, String> properties ) throws Exception
    {
        this.receiver.removeConnection ( configurationId );

        final ConnectionConfiguration cfg = parse ( properties );

        this.receiver.addConnection ( configurationId, cfg ).get ();
    }

    @Override
    public synchronized void delete ( final UserInformation userInformation, final String configurationId ) throws Exception
    {
        this.receiver.removeConnection ( configurationId );
        this.configurations.remove ( configurationId );
    }

}
