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
package org.eclipse.scada.hd.server.ngp;

import java.net.InetSocketAddress;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

import org.eclipse.scada.core.ConnectionInformation;
import org.eclipse.scada.hd.common.ngp.ProtocolConfigurationFactoryImpl;
import org.eclipse.scada.hd.server.Service;
import org.eclipse.scada.protocol.ngp.common.ProtocolConfigurationFactory;
import org.eclipse.scada.utils.lifecycle.LifecycleAware;

public class Exporter implements LifecycleAware
{
    private Server server;

    private final ProtocolConfigurationFactory protocolConfigurationFactory;

    private Collection<InetSocketAddress> addresses = new LinkedList<InetSocketAddress> ();

    private final Service service;

    public Exporter ( final Service service, final ProtocolConfigurationFactory protocolConfigurationFactory, final Collection<InetSocketAddress> addresses )
    {
        this.service = service;
        this.protocolConfigurationFactory = protocolConfigurationFactory;
        this.addresses = addresses;
    }

    public Exporter ( final Service service, final ConnectionInformation connectionInformation ) throws Exception
    {
        this ( service, new ProtocolConfigurationFactoryImpl ( connectionInformation ), Collections.singletonList ( new InetSocketAddress ( connectionInformation.getTarget (), connectionInformation.getSecondaryTarget () ) ) );
    }

    public Class<? extends Service> getServiceClass ()
    {
        return this.service.getClass ();
    }

    private void createServer () throws Exception
    {
        this.server = new Server ( this.addresses, this.protocolConfigurationFactory, this.service );
        this.server.start ();
    }

    @Override
    public void start () throws Exception
    {
        createServer ();
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
        }
    }
}
