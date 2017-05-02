/*******************************************************************************
 * Copyright (c) 2011, 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.hd.server.importer.hsdb;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ScheduledExecutorService;

import org.osgi.framework.BundleContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HSDBStorageManager
{
    private final static Logger logger = LoggerFactory.getLogger ( HSDBStorageManager.class );

    private final File root;

    private final BundleContext context;

    private final Set<HSDBItemController> sources = new CopyOnWriteArraySet<HSDBItemController> ();

    private final String prefix;

    private final ScheduledExecutorService executor;

    public HSDBStorageManager ( final ScheduledExecutorService executor, final String prefix, final BundleContext bundleContext, final File root )
    {
        this.executor = executor;
        this.prefix = prefix;
        this.root = root;
        this.context = bundleContext;

        scan ();
    }

    private void scan ()
    {
        if ( !this.root.isDirectory () )
        {
            logger.warn ( "{} is not a directory. Skipping scan!", this.root );
            return;
        }

        logger.info ( "Scanning {} for sources...", this.root );

        for ( final File file : this.root.listFiles () )
        {
            try
            {
                logger.debug ( "Entry: {}", file );

                if ( !file.isDirectory () )
                {
                    continue;
                }

                final String baseName = file.getName ();
                if ( !new File ( file, baseName + ".va_ctrl" ).canRead () )
                {
                    continue;
                }

                createSource ( file );
            }
            catch ( final Exception e )
            {
                logger.warn ( "Failed scanning source: " + file, e );
            }
        }
    }

    private void createSource ( final File file ) throws FileNotFoundException, IOException
    {
        logger.info ( "Importing {} ...", file );

        final Properties p = new Properties ();
        p.load ( new FileInputStream ( new File ( file, file.getName () + ".va_ctrl" ) ) );
        final String id = p.getProperty ( "hsdb.manager.configurationId" );
        final String dataType = p.getProperty ( "hsdb.dataType" );

        if ( id == null )
        {
            return;
        }

        if ( !dataType.equals ( "DOUBLE" ) )
        {
            logger.warn ( "Data type {} is not supported", dataType );
            return;
        }

        logger.info ( "Importing as {} -> {}", id, this.prefix + id );

        final HSDBValueSource source = new HSDBValueSource ( this.context, file, file.getName () );
        final HSDBItemController item = new HSDBItemController ( id, this.executor, this.context, source );

        this.sources.add ( item );
    }

    public void dispose ()
    {
        for ( final HSDBItemController source : this.sources )
        {
            source.dispose ();
        }
        this.sources.clear ();
    }
}
