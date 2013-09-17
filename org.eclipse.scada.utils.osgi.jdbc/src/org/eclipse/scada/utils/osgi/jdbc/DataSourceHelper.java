/*******************************************************************************
 * Copyright (c) 2006, 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.utils.osgi.jdbc;

import java.util.Map;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class DataSourceHelper
{

    public static final String DEFAULT_PREFIX = "org.eclipse.scada.jdbc";

    private final static Logger logger = LoggerFactory.getLogger ( DataSourceHelper.class );

    private DataSourceHelper ()
    {
    }

    public static boolean isConnectionPool ( final String specificPrefix, final String defaultPrefix, final boolean defaultValue )
    {
        final String value = System.getProperty ( specificPrefix + ".usePool", System.getProperty ( defaultPrefix + ".usePool", "" + defaultValue ) );
        return Boolean.parseBoolean ( value );
    }

    public static String getDriver ( final String specificPrefix, final String defaultPrefix )
    {
        return getDriver ( System.getProperties (), specificPrefix, defaultPrefix );
    }

    public static String getDriver ( final Properties properties, final String specificPrefix, final String defaultPrefix )
    {
        return properties.getProperty ( specificPrefix + ".driver", properties.getProperty ( defaultPrefix + ".driver", null ) );
    }

    public static Properties getDataSourceProperties ( final String specificPrefix, final String defaultPrefix )
    {
        return getDataSourceProperties ( System.getProperties (), specificPrefix, defaultPrefix );
    }

    public static Properties getDataSourceProperties ( final Properties properties, final String specificPrefix, final String defaultPrefix )
    {
        logger.debug ( "Getting datasource properties - specific: {} / default: {}", specificPrefix, defaultPrefix );

        final Properties p = new Properties ();

        String prefix;
        if ( properties.containsKey ( specificPrefix + ".driver" ) )
        {
            prefix = specificPrefix + ".properties.";
        }
        else
        {
            prefix = defaultPrefix + ".properties.";
        }

        logger.debug ( "Prefix is: {}", prefix );

        for ( final Map.Entry<Object, Object> entry : properties.entrySet () )
        {
            logger.trace ( "Checking entry - key: {}, value: {}", entry.getKey (), entry.getValue () );

            if ( entry.getKey () == null )
            {
                continue;
            }
            final String key = entry.getKey ().toString ();
            if ( key.startsWith ( prefix ) )
            {
                // remove prefix and add as property
                if ( logger.isDebugEnabled () )
                {
                    logger.debug ( "Adding entry - key: {}, value: {}", key.substring ( prefix.length () ), entry.getValue () );
                }
                p.put ( key.substring ( prefix.length () ), entry.getValue () );
            }
        }

        return p;
    }

}
