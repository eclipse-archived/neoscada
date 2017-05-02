/*******************************************************************************
 * Copyright (c) 2010, 2016 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - implement security callback system
 *     IBH SYSTEMS GmbH - cleanups and fixes
 *******************************************************************************/
package org.eclipse.scada.core.ngp.common;

import static org.eclipse.scada.protocol.ngp.common.SslHelper.createDefaultSslFactory;
import static org.eclipse.scada.protocol.ngp.common.SslHelper.isSslRequired;

import java.util.Map;

import org.apache.mina.filter.compression.CompressionFilter;
import org.eclipse.scada.core.ConnectionInformation;
import org.eclipse.scada.protocol.ngp.common.ProtocolConfiguration;
import org.eclipse.scada.protocol.ngp.common.ProtocolConfigurationFactory;
import org.eclipse.scada.protocol.ngp.common.mc.protocol.ProtocolDescriptor;
import org.eclipse.scada.protocol.ngp.common.mc.protocol.serialize.ObjectSerializationProtocolDescriptor;

public class DefaultProtocolConfigurationFactory implements ProtocolConfigurationFactory
{
    protected final ConnectionInformation connectionInformation;

    public DefaultProtocolConfigurationFactory ( final ConnectionInformation connectionInformation )
    {
        this.connectionInformation = connectionInformation;
    }

    @Override
    public ProtocolConfiguration createConfiguration ( final boolean clientMode ) throws Exception
    {
        final ProtocolConfiguration configuration = new ProtocolConfiguration ();

        final Map<String, String> properties = this.connectionInformation.getProperties ();

        configuration.setStreamCompressionLevel ( getInteger ( properties, "streamCompressionLevel", CompressionFilter.COMPRESSION_MAX ) ); //$NON-NLS-1$

        configuration.setSslRequired ( isSslRequired ( properties ) );
        configuration.setSslContextFactory ( createDefaultSslFactory ( properties, clientMode ) );

        configuration.setTimeout ( getInteger ( properties, "timeout", configuration.getTimeout () ) ); //$NON-NLS-1$
        configuration.setPingFrequency ( getInteger ( properties, "pingFrequency", configuration.getPingFrequency () ) ); //$NON-NLS-1$

        customizeConfiguration ( configuration, clientMode );

        return configuration;
    }

    private static Integer getInteger ( final Map<String, String> properties, final String key, final Integer defaultValue )
    {
        final String value = properties.get ( key );
        if ( value == null )
        {
            return defaultValue;
        }

        try
        {
            return Integer.parseInt ( value );
        }
        catch ( final Exception e )
        {
            return defaultValue;
        }
    }

    protected void addJavaProtocol ( final String protocolVersion, final ProtocolConfiguration configuration, final ClassLoader classLoader )
    {
        addProtocol ( configuration, new ObjectSerializationProtocolDescriptor ( "java/" + protocolVersion, classLoader ) ); //$NON-NLS-1$
    }

    protected void addProtocol ( final ProtocolConfiguration configuration, final ProtocolDescriptor protocol )
    {
        configuration.getProtocols ().add ( protocol );
    }

    /**
     * Can be overridden in order to customize the configuration
     *
     * @param configuration
     *            the configuration to customize
     */
    protected void customizeConfiguration ( final ProtocolConfiguration configuration, final boolean clientMode )
    {
    }
}
