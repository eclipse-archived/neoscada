/*******************************************************************************
 * Copyright (c) 2009, 2014 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     IBH SYSTEMS GmbH - honor the lifecycle
 *******************************************************************************/
package org.eclipse.scada.da.server.simulation.component;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import org.eclipse.scada.core.Variant;
import org.eclipse.scada.da.server.browser.common.FolderCommon;
import org.eclipse.scada.da.server.browser.common.query.AttributeNameProvider;
import org.eclipse.scada.da.server.browser.common.query.GroupFolder;
import org.eclipse.scada.da.server.browser.common.query.IDNameProvider;
import org.eclipse.scada.da.server.browser.common.query.InvisibleStorage;
import org.eclipse.scada.da.server.browser.common.query.ItemDescriptor;
import org.eclipse.scada.da.server.browser.common.query.ItemStorage;
import org.eclipse.scada.da.server.browser.common.query.Matcher;
import org.eclipse.scada.da.server.browser.common.query.QueryFolder;
import org.eclipse.scada.da.server.browser.common.query.SplitGroupProvider;
import org.eclipse.scada.da.server.common.impl.HiveCommon;
import org.eclipse.scada.da.server.simulation.component.modules.BaseModule;
import org.eclipse.scada.da.server.simulation.component.modules.SimpleMOV;
import org.eclipse.scada.da.server.simulation.component.modules.SimpleScale;
import org.eclipse.scada.utils.concurrent.NamedThreadFactory;

public class Hive extends HiveCommon
{
    private final ScheduledExecutorService executor;

    private final List<BaseModule> modules = new LinkedList<BaseModule> ();

    private final InvisibleStorage storage = new InvisibleStorage ();

    public Hive ()
    {
        this.executor = Executors.newSingleThreadScheduledExecutor ( new NamedThreadFactory ( "org.eclipse.scada.da.server.simulation.component" ) );

        // create root folder
        final FolderCommon rootFolder = new FolderCommon ();
        setRootFolder ( rootFolder );

        final QueryFolder queryFolder = new QueryFolder ( new Matcher () {

            @Override
            public boolean matches ( final ItemDescriptor desc )
            {
                return true;
            }
        }, new IDNameProvider () );
        rootFolder.add ( "all", queryFolder, new HashMap<String, Variant> () );
        this.storage.addChild ( queryFolder );

        final GroupFolder groupFolder = new GroupFolder ( new SplitGroupProvider ( new AttributeNameProvider ( "tag" ), "\\." ), new IDNameProvider () );
        rootFolder.add ( "components", groupFolder, new HashMap<String, Variant> () );
        this.storage.addChild ( groupFolder );
    }

    @Override
    public String getHiveId ()
    {
        return "org.eclipse.scada.da.server.simulation.component";
    }

    public ScheduledExecutorService getExecutor ()
    {
        return this.executor;
    }

    @Override
    protected void performStart () throws Exception
    {
        super.performStart ();

        addModule ( new SimpleMOV ( this, "1000" ) );
        addModule ( new SimpleScale ( this, "1001" ) );
    }

    @Override
    protected void performStop () throws Exception
    {
        for ( final BaseModule module : this.modules )
        {
            module.dispose ();
        }
        this.modules.clear ();
        this.executor.shutdown ();
        super.performStop ();
    }

    public ItemStorage getStorage ()
    {
        return this.storage;
    }

    public void addModule ( final BaseModule module )
    {
        this.modules.add ( module );
    }
}
