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
package org.eclipse.scada.ca.testing;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.scada.ca.ConfigurationFactory;
import org.eclipse.scada.sec.UserInformation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConfigurationFactoryImpl implements ConfigurationFactory
{
    private final static Logger logger = LoggerFactory.getLogger ( ConfigurationFactoryImpl.class );

    private final Map<String, Map<String, String>> configurations = new HashMap<String, Map<String, String>> ();

    @Override
    public void update ( final UserInformation userInformation, final String configurationId, final Map<String, String> properties ) throws NumberFormatException, InterruptedException
    {
        logger.info ( String.format ( "Updating configuration: %s (%s)", configurationId, properties ) );

        if ( properties.containsKey ( "error" ) )
        {
            throw new RuntimeException ( "Error flag set" );
        }
        if ( properties.containsKey ( "sleep" ) )
        {
            Thread.sleep ( Integer.parseInt ( properties.get ( "sleep" ) ) );
        }
        this.configurations.put ( configurationId, properties );
    }

    @Override
    public void delete ( final UserInformation userInformation, final String configurationId ) throws NumberFormatException, InterruptedException
    {
        logger.info ( "Deleting: " + configurationId );

        final Map<String, String> properties = this.configurations.remove ( configurationId );
        if ( properties != null )
        {
            final String sleepStr = properties.get ( "sleep" );
            if ( sleepStr != null )
            {
                Thread.sleep ( Integer.parseInt ( sleepStr ) );
            }
        }
    }

}
