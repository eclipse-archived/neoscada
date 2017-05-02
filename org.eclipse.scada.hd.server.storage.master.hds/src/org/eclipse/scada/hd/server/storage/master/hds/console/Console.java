/*******************************************************************************
 * Copyright (c) 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *******************************************************************************/
package org.eclipse.scada.hd.server.storage.master.hds.console;

import java.io.File;

import org.apache.felix.service.command.Descriptor;
import org.eclipse.scada.hd.server.storage.hds.StorageConfiguration;
import org.eclipse.scada.hd.server.storage.hds.StorageInformation;
import org.eclipse.scada.hd.server.storage.master.hds.StorageManager;

public class Console
{
    private final StorageManager manager;

    public Console ( final StorageManager manager )
    {
        this.manager = manager;
    }

    @Descriptor ( "Delete all data outside of the valid time spec" )
    public void purgeAll ()
    {
        System.out.print ( "Purging..." );
        System.out.flush ();

        this.manager.purgeAll ();
        System.out.println ( "done!" );
    }

    @Descriptor ( "List all HDS storages" )
    public void list ()
    {
        System.out.println ( "ID\t\tLocation" );
        System.out.println ( "============================================" );
        for ( final StorageInformation info : this.manager.list () )
        {
            printStorage ( info );
        }
        System.out.println ( "============================================" );
    }

    private void printStorage ( final StorageInformation info )
    {
        System.out.println ( String.format ( "%s\t\t%s", info.getId (), info.getFile () ) );
        final StorageConfiguration cfg = info.getConfiguration ();
        System.out.println ( String.format ( "\t\tnative: %s ms, %s", cfg.getTimeSlice (), cfg.getCount () ) );
    }

    @Descriptor ( "Create a new HDS storage" )
    public void create ( @Descriptor ( "the new id" ) final String id, @Descriptor ( "number of milliseconds each file is valid for" ) final long time, @Descriptor ( "the number of files to keep" ) final int count ) throws Exception
    {
        this.manager.addStorage ( id, time, count );
    }

    @Descriptor ( "Remove storage by id" )
    public void remove ( final String[] args )
    {
        final String usage = "Usage: remove [--force] id1 [id2 [id3]]";
        if ( args.length <= 0 )
        {
            System.out.println ( usage );
            return;
        }

        boolean force = false;
        for ( final String id : args )
        {
            if ( "--force".equals ( id ) )
            {
                force = true;
            }
            else
            {
                System.out.println ( String.format ( "Removing storage '%s' ...", id ) );
                System.out.flush ();
                removeById ( id, force );
                System.out.println ( String.format ( "Removing storage '%s' ... done!", id ) );
            }
        }
    }

    private void removeById ( final String id, final boolean force )
    {
        for ( final StorageInformation info : this.manager.list () )
        {
            if ( id.equals ( info.getId () ) )
            {
                System.out.println ( String.format ( "Removing file - id: %s, file: %s, force: %s", id, info.getFile (), force ) );
                removeByFile ( info.getFile (), force );
            }
        }
    }

    private void removeByFile ( final File file, final boolean force )
    {
        try
        {
            this.manager.removeStorage ( file, force );
        }
        catch ( final Exception e )
        {
            e.printStackTrace ();
        }
    }

}
