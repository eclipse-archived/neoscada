/*******************************************************************************
 * Copyright (c) 2013 Jens Reimann and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Jens Reimann - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.core.server.common;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.SocketAddress;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;

import org.apache.mina.core.service.IoAcceptor;
import org.eclipse.scada.core.ConnectionInformation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NetworkHelper
{

    private final static Logger logger = LoggerFactory.getLogger ( NetworkHelper.class );

    public static Set<ConnectionInformation> getLocalInterfaces ( final IoAcceptor acceptor, final ConnectionInformation connectionInformation ) throws SocketException
    {
        final Set<ConnectionInformation> result = new HashSet<ConnectionInformation> ();

        for ( final InetSocketAddress address : getLocalAddresses ( acceptor ) )
        {
            result.add ( cloneFill ( address.getAddress (), connectionInformation ) );
        }

        return result;
    }

    public static Set<InetSocketAddress> getLocalAddresses ( final IoAcceptor acceptor ) throws SocketException
    {
        final Set<InetSocketAddress> result = new HashSet<InetSocketAddress> ();

        for ( final SocketAddress address : acceptor.getLocalAddresses () )
        {
            logger.info ( "Bound to: {}", address );
            if ( ! ( address instanceof InetSocketAddress ) )
            {
                continue;
            }

            final InetSocketAddress socketAddress = (InetSocketAddress)address;
            if ( socketAddress.getAddress ().isAnyLocalAddress () )
            {
                final int port = socketAddress.getPort ();

                final Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces ();
                while ( interfaces.hasMoreElements () )
                {
                    final NetworkInterface networkInterface = interfaces.nextElement ();

                    for ( final InterfaceAddress interfaceAddress : networkInterface.getInterfaceAddresses () )
                    {
                        result.add ( new InetSocketAddress ( interfaceAddress.getAddress (), port ) );
                    }
                }
            }
            else
            {
                result.add ( socketAddress );
            }

        }

        return result;
    }

    private static ConnectionInformation cloneFill ( final InetAddress inetAddress, final ConnectionInformation connectionInformation )
    {
        final ConnectionInformation info = connectionInformation.clone ();
        info.setTarget ( inetAddress.getHostAddress () );
        return info;
    }

}
