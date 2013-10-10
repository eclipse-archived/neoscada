/*******************************************************************************
 * Copyright (c) 2010, 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *******************************************************************************/
package org.eclipse.scada.da.server.sysinfo;

import java.io.File;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.eclipse.scada.core.Variant;
import org.eclipse.scada.da.server.browser.common.FolderCommon;
import org.eclipse.scada.da.server.common.DataItem;
import org.eclipse.scada.da.server.common.impl.HiveCommon;
import org.eclipse.scada.da.server.sysinfo.items.LoadAverageJob;
import org.eclipse.scada.da.server.sysinfo.items.PlainFileDataItem;
import org.eclipse.scada.da.server.sysinfo.items.TimeDataItem;
import org.eclipse.scada.utils.collection.MapBuilder;

public class Hive extends HiveCommon
{
    private ScheduledExecutorService scheduler;

    private FolderCommon loadFolder;

    private final FolderCommon rootFolder;

    public Hive ()
    {
        super ();

        this.rootFolder = new FolderCommon ();
        setRootFolder ( this.rootFolder );

    }

    @Override
    public String getHiveId ()
    {
        return "org.eclipse.scada.da.server.sysinfo";
    }

    private void createModel ()
    {
        DataItem item;
        registerItem ( item = new TimeDataItem ( "time", this.scheduler ) );
        this.rootFolder.add ( "time", item, new MapBuilder<String, Variant> ().put ( "description", Variant.valueOf ( "Time since the epoc in milliseconds!" ) ).getMap () );

        registerItem ( item = new PlainFileDataItem ( "hostname", new File ( "/proc/sys/kernel/hostname" ), this.scheduler, 1000 * 10 ) );
        this.rootFolder.add ( "hostname", item, new MapBuilder<String, Variant> ().put ( "description", Variant.valueOf ( "Hostname of the computer the server is running on." ) ).getMap () );

        this.loadFolder = new FolderCommon ();
        this.rootFolder.add ( "loadavg", this.loadFolder, new MapBuilder<String, Variant> ().put ( "description", Variant.valueOf ( "Load avarage information" ) ).getMap () );
    }

    @Override
    protected void performStart () throws Exception
    {
        super.performStart ();
        this.scheduler = new ScheduledThreadPoolExecutor ( 1 );

        createModel ();

        this.scheduler.scheduleAtFixedRate ( new LoadAverageJob ( this, this.loadFolder ), 1000, 1000, TimeUnit.MILLISECONDS );
    }

    @Override
    protected void performStop () throws Exception
    {
        this.scheduler.shutdown ();
        super.performStop ();
    }
}
