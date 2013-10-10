/*******************************************************************************
 * Copyright (c) 2010, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *******************************************************************************/
package org.eclipse.scada.da.client.samples;

import java.util.Collection;

import org.eclipse.scada.core.OperationException;
import org.eclipse.scada.da.client.FolderListener;
import org.eclipse.scada.da.client.FolderManager;
import org.eclipse.scada.da.core.Location;
import org.eclipse.scada.da.core.browser.DataItemEntry;
import org.eclipse.scada.da.core.browser.Entry;
import org.eclipse.scada.da.core.browser.FolderEntry;

/**
 * Sample showing how to browse using subscriptions <br>
 * 
 * @author Jens Reimann <jens.reimann@th4-systems.com>
 */
public class Sample4 extends SampleBase
{
    private FolderManager folderManager = null;

    public Sample4 ( final String uri, final String className ) throws Exception
    {
        super ( uri, className );
    }

    @Override
    public void connect () throws Exception
    {
        super.connect ();
        this.folderManager = new FolderManager ( this.connection );
    }

    protected void showEntry ( final Entry entry )
    {
        System.out.print ( "'" + entry.getName () + "' " );
        if ( entry instanceof FolderEntry )
        {
            System.out.print ( "[Folder] " );
        }
        else if ( entry instanceof DataItemEntry )
        {
            System.out.print ( "[Item]" );
        }

        System.out.println ();
    }

    public void subscribe () throws InterruptedException, OperationException
    {
        this.folderManager.addFolderListener ( new FolderListener () {

            @Override
            public void folderChanged ( final Collection<Entry> added, final Collection<String> removed, final boolean full )
            {
                System.out.println ( String.format ( "Added: %d Removed: %d, Full: %s", added.size (), removed.size (), full ) );
                for ( final Entry entry : added )
                {
                    showEntry ( entry );
                }
                for ( final String entry : removed )
                {
                    System.out.println ( String.format ( "Remove: '%s'", entry ) );
                }
            }
        }, new Location () );
    }

    public static void main ( final String[] args ) throws Exception
    {
        String uri = null;
        String className = null;

        if ( args.length > 0 )
        {
            uri = args[0];
        }
        if ( args.length > 1 )
        {
            className = args[1];
        }

        Sample4 s = null;
        try
        {
            s = new Sample4 ( uri, className );
            s.connect ();
            s.subscribe ();
            Thread.sleep ( 5 * 1000 );
        }
        catch ( final Throwable e )
        {
            e.printStackTrace ();
        }
        finally
        {
            if ( s != null )
            {
                s.dispose ();
            }
        }
    }
}
