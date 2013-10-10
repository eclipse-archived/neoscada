/*******************************************************************************
 * Copyright (c) 2012, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.ca.common.ngp;

import java.util.Arrays;
import java.util.Map;

import org.eclipse.scada.ca.protocol.ngp.codec.ProtocolFactory;
import org.eclipse.scada.core.ConnectionInformation;
import org.eclipse.scada.protocol.ngp.common.DefaultProtocolConfigurationFactory;
import org.eclipse.scada.protocol.ngp.common.ProtocolConfiguration;

public class ProtocolConfigurationFactoryImpl extends DefaultProtocolConfigurationFactory
{
    public ProtocolConfigurationFactoryImpl ( final ConnectionInformation connectionInformation )
    {
        super ( connectionInformation );
    }

    @Override
    protected void customizeConfiguration ( final ProtocolConfiguration configuration, final boolean clientMode )
    {
        // check if we prefer the binary protocol
        if ( preferJava () )
        {
            addJavaProtocol ( ProtocolFactory.VERSION, configuration, ProtocolConfigurationFactoryImpl.class.getClassLoader () );
            addProtocol ( configuration, ProtocolFactory.createProtocolDescriptor () );
        }
        else
        {
            addProtocol ( configuration, ProtocolFactory.createProtocolDescriptor () );
            addJavaProtocol ( ProtocolFactory.VERSION, configuration, ProtocolConfigurationFactoryImpl.class.getClassLoader () );
        }

        if ( preferJava () )
        {
            configuration.setPreferredProtocols ( Arrays.asList ( "java/" + ProtocolFactory.VERSION ) );
        }
    }

    private boolean preferJava ()
    {
        final Map<String, String> props = this.connectionInformation.getProperties ();
        final String useJava = props.get ( "useJava" );
        return Boolean.parseBoolean ( useJava );
    }
}
