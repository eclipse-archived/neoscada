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
package org.eclipse.scada.da.server.ngp;

import java.net.InetSocketAddress;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

import org.eclipse.scada.core.ConnectionInformation;
import org.eclipse.scada.core.server.exporter.ExporterInformation;
import org.eclipse.scada.da.common.ngp.ProtocolConfigurationFactoryImpl;
import org.eclipse.scada.da.core.server.Hive;
import org.eclipse.scada.protocol.ngp.common.ProtocolConfigurationFactory;
import org.eclipse.scada.utils.lifecycle.LifecycleAware;

public class Exporter implements LifecycleAware
{
    private Server server;

    private final ProtocolConfigurationFactory protocolConfigurationFactory;

    private Collection<InetSocketAddress> addresses = new LinkedList<InetSocketAddress> ();

    private final Hive service;

    private Set<InetSocketAddress> startedAddresses;

    public Exporter ( final Hive service, final ProtocolConfigurationFactory protocolConfigurationFactory, final Collection<InetSocketAddress> addresses )
    {
        this.service = service;
        this.protocolConfigurationFactory = protocolConfigurationFactory;
        this.addresses = addresses;
    }

    public Exporter ( final Hive service, final ConnectionInformation connectionInformation ) throws Exception
    {
        this ( service, new ProtocolConfigurationFactoryImpl ( connectionInformation ), Collections.singletonList ( new InetSocketAddress ( connectionInformation.getTarget (), connectionInformation.getSecondaryTarget () ) ) );
    }

    public Class<? extends Hive> getServiceClass ()
    {
        return this.service.getClass ();
    }

    private Set<InetSocketAddress> createServer () throws Exception
    {
        this.server = new Server ( this.addresses, this.protocolConfigurationFactory, this.service );
        return this.server.start ();
    }

    @Override
    public void start () throws Exception
    {
        if ( this.startedAddresses == null )
        {
            this.startedAddresses = createServer ();
        }
    }

    public Set<InetSocketAddress> getStartedAddresses ()
    {
        return this.startedAddresses;
    }

    /**
     * @since 1.1
     */
    public Set<ConnectionInformation> getStartedConnectionInformations ()
    {
        return convert ( "da", getStartedAddresses () );
    }

    public Set<ExporterInformation> getExporterInformation ()
    {
        final Set<ExporterInformation> result = new HashSet<ExporterInformation> ();

        for ( final ConnectionInformation ci : getStartedConnectionInformations () )
        {
            result.add ( new ExporterInformation ( ci, null ) );
        }

        return result;
    }

    Set<ConnectionInformation> convert ( final String interfaceName, final Set<InetSocketAddress> startedAddresses )
    {
        final HashSet<ConnectionInformation> result = new HashSet<ConnectionInformation> ();

        for ( final InetSocketAddress address : startedAddresses )
        {
            final String target = address.getAddress ().getHostAddress ().replace ( "%", "%25" ); // for IPv6

            final ConnectionInformation ci;
            if ( target.indexOf ( ':' ) >= 0 )
            {
                ci = ConnectionInformation.fromURI ( String.format ( "%s:ngp://[%s]:%s", interfaceName, target, address.getPort () ) );
            }
            else
            {
                ci = ConnectionInformation.fromURI ( String.format ( "%s:ngp://%s:%s", interfaceName, target, address.getPort () ) );
            }
            if ( ci != null )
            {
                result.add ( ci );
            }
        }

        return result;
    }

    @Override
    public void stop () throws Exception
    {
        destroyServer ();
    }

    private void destroyServer ()
    {
        if ( this.server != null )
        {
            this.server.dispose ();
            this.server = null;
            this.startedAddresses = null;
        }
    }
}
