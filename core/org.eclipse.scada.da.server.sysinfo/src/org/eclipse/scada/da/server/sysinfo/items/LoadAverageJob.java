/*******************************************************************************
 * Copyright (c) 2010, 2011 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.server.sysinfo.items;

import java.io.File;
import java.io.IOException;
import java.util.StringTokenizer;

import org.eclipse.scada.core.Variant;
import org.eclipse.scada.da.server.browser.common.FolderCommon;
import org.eclipse.scada.da.server.common.DataItemInputCommon;
import org.eclipse.scada.da.server.sysinfo.Hive;
import org.eclipse.scada.da.server.sysinfo.utils.FileUtils;
import org.eclipse.scada.utils.collection.MapBuilder;

public class LoadAverageJob implements Runnable
{

    private final File file = new File ( "/proc/loadavg" );

    private final DataItemInputCommon avg1 = new DataItemInputCommon ( "loadavg1" );

    private final DataItemInputCommon avg5 = new DataItemInputCommon ( "loadavg5" );

    private final DataItemInputCommon avg15 = new DataItemInputCommon ( "loadavg15" );

    private Hive hive = null;

    private FolderCommon folder = null;

    public LoadAverageJob ( final Hive hive, final FolderCommon folder )
    {
        this.hive = hive;
        this.folder = folder;

        this.hive.registerItem ( this.avg1 );
        this.folder.add ( "1", this.avg1, new MapBuilder<String, Variant> ().put ( "description", Variant.valueOf ( "The 1 minute load avarage" ) ).getMap () );

        this.hive.registerItem ( this.avg5 );
        this.folder.add ( "5", this.avg5, new MapBuilder<String, Variant> ().put ( "description", Variant.valueOf ( "The 5 minute load avarage" ) ).getMap () );

        this.hive.registerItem ( this.avg15 );
        this.folder.add ( "15", this.avg15, new MapBuilder<String, Variant> ().put ( "description", Variant.valueOf ( "The 15 minute load avarage" ) ).getMap () );
    }

    @Override
    public void run ()
    {
        try
        {
            read ();
        }
        catch ( final Exception e )
        {
            // handle error
        }
    }

    private void read () throws IOException
    {
        final String[] data = FileUtils.readFile ( this.file );

        final StringTokenizer tok = new StringTokenizer ( data[0] );

        this.avg1.updateData ( Variant.valueOf ( Double.parseDouble ( tok.nextToken () ) ), null, null );
        this.avg5.updateData ( Variant.valueOf ( Double.parseDouble ( tok.nextToken () ) ), null, null );
        this.avg15.updateData ( Variant.valueOf ( Double.parseDouble ( tok.nextToken () ) ), null, null );
    }
}
