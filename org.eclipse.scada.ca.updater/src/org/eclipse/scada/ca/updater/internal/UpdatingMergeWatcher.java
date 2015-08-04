/*******************************************************************************
 * Copyright (c) 2015 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.ca.updater.internal;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.TimeUnit;

import org.eclipse.scada.ca.ConfigurationAdministrator;
import org.eclipse.scada.ca.updater.DirectoryScanner.FailMode;
import org.eclipse.scada.ca.updater.Updater;
import org.eclipse.scada.utils.concurrent.NotifyFuture;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UpdatingMergeWatcher extends AbstractMergeWatcher
{
    private final static Logger logger = LoggerFactory.getLogger ( UpdatingMergeWatcher.class );

    private final ConfigurationAdministrator admin;

    private final Path path;

    public UpdatingMergeWatcher ( final ConfigurationAdministrator admin, final Path path, final long delay, final TimeUnit timeUnit ) throws IOException
    {
        super ( path, delay, timeUnit );
        this.path = path;
        this.admin = admin;

        // initial update
        processFireChange ();
    }

    @Override
    protected void processFireChange ()
    {
        logger.info ( "Process change - merging ..." );

        try
        {
            final Updater updater = new Updater ( this.admin );

            if ( this.watchFile )
            {
                // watching a single file
                try ( Reader reader = Files.newBufferedReader ( this.path, StandardCharsets.UTF_8 ) )
                {
                    updater.loadJson ( reader );
                }
            }
            else
            {
                // watching a full directory
                updater.loadDirectory ( this.path, 1, FailMode.FAIL );
            }

            final int changes = updater.getChanges ().size ();

            if ( changes <= 0 )
            {
                logger.info ( "No changes ... skipping!" );
                return;
            }

            logger.info ( "Starting update ... {} changes", changes );
            final NotifyFuture<Void> future = updater.update ();
            future.addListener ( new Runnable () {
                @Override
                public void run ()
                {
                    logger.info ( "Update complete" );
                }
            } );
        }
        catch ( final Exception e )
        {
            logger.warn ( "Failed to perform merge", e );
        }
    }

}
