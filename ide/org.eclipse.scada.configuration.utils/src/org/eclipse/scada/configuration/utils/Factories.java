/*******************************************************************************
 * Copyright (c) 2013 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.configuration.utils;

import org.eclipse.core.runtime.IConfigurationElement;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class Factories
{

    private final static Logger logger = LoggerFactory.getLogger ( Factories.class );

    private Factories ()
    {
    }

    public static Class<?> loadClass ( final BundleContext ctx, final IConfigurationElement ele, final String attribute )
    {
        final String clazzName = ele.getAttribute ( attribute );
        if ( clazzName == null || clazzName.isEmpty () )
        {
            return null;
        }

        final String bundleName = ele.getContributor ().getName ();

        logger.debug ( "Locating classs {} from {}", clazzName, bundleName );

        for ( final Bundle bundle : ctx.getBundles () )
        {
            if ( bundle.getSymbolicName ().equals ( bundleName ) )
            {
                try
                {
                    return bundle.loadClass ( clazzName );
                }
                catch ( final ClassNotFoundException e )
                {
                    // we give other bundles a chance
                }
            }
        }

        return null;
    }

}
