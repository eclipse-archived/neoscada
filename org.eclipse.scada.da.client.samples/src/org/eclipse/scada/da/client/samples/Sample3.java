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

import org.eclipse.scada.core.OperationException;
import org.eclipse.scada.da.client.BrowseOperationCallback;
import org.eclipse.scada.da.core.Location;
import org.eclipse.scada.da.core.browser.DataItemEntry;
import org.eclipse.scada.da.core.browser.Entry;
import org.eclipse.scada.da.core.browser.FolderEntry;

/**
 * Sample showing how to browse once <br>
 * 
 * @author Jens Reimann <jens.reimann@th4-systems.com>
 */
public class Sample3 extends SampleBase
{
    public Sample3 ( final String uri, final String className ) throws Exception
    {
        super ( uri, className );
    }

    /**
     * Show one folder entry.
     * 
     * @param entry
     *            A folder entry which can be an item or a sub-folder
     */
    protected void showEntry ( final Entry entry )
    {
        System.out.print ( "'" + entry.getName () + "' " );
        if ( entry instanceof FolderEntry )
        {
            System.out.print ( "[Folder] " );
        }
        else if ( entry instanceof DataItemEntry )
        {
            System.out.print ( "[Item]: " + ( (DataItemEntry)entry ).getId () );
        }

        System.out.println ();
    }

    protected void dumpEntries ( final Entry[] entries )
    {
        for ( final Entry entry : entries )
        {
            showEntry ( entry );
        }
    }

    /**
     * browse once through a predefined folder named "test"
     * 
     * @throws InterruptedException
     * @throws OperationException
     */
    public void run () throws InterruptedException, OperationException
    {
        try
        {
            this.connection.browse ( new Location ( "test" ), new BrowseOperationCallback () {

                @Override
                public void failed ( final String error )
                {
                    System.err.println ( "Error: " + error );
                }

                @Override
                public void error ( final Throwable e )
                {
                    e.printStackTrace ();
                }

                @Override
                public void complete ( final Entry[] entries )
                {
                    dumpEntries ( entries );
                }
            } );
        }
        catch ( final Exception e )
        {
            e.printStackTrace ();
        }
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

        Sample3 s = null;
        try
        {
            s = new Sample3 ( uri, className );
            s.connect ();
            s.run ();
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
