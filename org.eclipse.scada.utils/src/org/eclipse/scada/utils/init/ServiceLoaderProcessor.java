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
package org.eclipse.scada.utils.init;

import java.util.Iterator;
import java.util.ServiceLoader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Process all initialization found using the {@link ServiceLoader} mechanism
 * 
 * @author Jens Reimann
 */
public final class ServiceLoaderProcessor
{

    private final static Logger logger = LoggerFactory.getLogger ( ServiceLoaderProcessor.class );

    private ServiceLoaderProcessor ()
    {
    }

    /**
     * Initialize a specific type
     * 
     * @param type
     *            the initializer specific type, see
     *            {@link Initializer#initialize(Object)}
     */
    public static void initialize ( final Object type )
    {
        initialize ( type, null );
    }

    /**
     * Initialize a specific type
     * 
     * @param type
     *            the initializer specific type, see
     *            {@link Initializer#initialize(Object)}
     * @param classloader
     *            a specific class loader to use
     */
    public static void initialize ( final Object type, final ClassLoader classloader )
    {
        logger.debug ( "Initializing: {}", type );

        final ServiceLoader<Initializer> loader = ServiceLoader.load ( Initializer.class, classloader );
        final Iterator<Initializer> i = loader.iterator ();
        while ( i.hasNext () )
        {
            final Initializer initializer = i.next ();
            logger.debug ( "Processing: {}", initializer );

            try
            {
                initializer.initialize ( type );
            }
            catch ( final Exception e )
            {
                logger.info ( "Failed to initialize", e );
            }
        }
    }
}
