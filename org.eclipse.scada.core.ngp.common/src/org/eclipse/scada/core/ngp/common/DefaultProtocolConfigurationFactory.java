/*******************************************************************************
 * Copyright (c) 2010, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - implement security callback system
 *******************************************************************************/


package org.eclipse.scada.core.ngp.common;

import java.util.Map;

import org.apache.mina.filter.compression.CompressionFilter;
import org.apache.mina.filter.ssl.SslContextFactory;
import org.eclipse.scada.core.ConnectionInformation;
import org.eclipse.scada.protocol.ngp.common.ProtocolConfiguration;
import org.eclipse.scada.protocol.ngp.common.ProtocolConfigurationFactory;
import org.eclipse.scada.protocol.ngp.common.SslHelper;
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

        configuration.setStreamCompressionLevel ( getInteger ( "streamCompressionLevel", this.connectionInformation.getProperties (), CompressionFilter.COMPRESSION_MAX ) );
        configuration.setSslContextFactory ( makeSslContextFactory ( clientMode ) );

        configuration.setTimeout ( getInteger ( "timeout", this.connectionInformation.getProperties (), configuration.getTimeout () ) ); //$NON-NLS-1$
        configuration.setPingFrequency ( getInteger ( "pingFrequency", this.connectionInformation.getProperties (), configuration.getPingFrequency () ) ); //$NON-NLS-1$

        customizeConfiguration ( configuration, clientMode );

        return configuration;
    }

    private Integer getInteger ( final String key, final Map<String, String> properties, final Integer defaultValue )
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

    protected SslContextFactory makeSslContextFactory ( final boolean clientMode ) throws Exception
    {
        return SslHelper.createDefaultSslFactory ( this.connectionInformation.getProperties (), clientMode );
    }
}
