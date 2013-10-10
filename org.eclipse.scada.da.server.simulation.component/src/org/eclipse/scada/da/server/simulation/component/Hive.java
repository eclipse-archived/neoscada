/*******************************************************************************
 * Copyright (c) 2009, 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
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

public class Hive extends HiveCommon
{
    private final ScheduledExecutorService executor;

    private final List<BaseModule> _modules = new LinkedList<BaseModule> ();

    private final InvisibleStorage _storage = new InvisibleStorage ();

    public Hive ()
    {
        super ();

        this.executor = Executors.newSingleThreadScheduledExecutor ();

        // create root folder
        final FolderCommon rootFolder = new FolderCommon ();
        setRootFolder ( rootFolder );

        addModule ( new SimpleMOV ( this, "1000" ) );
        addModule ( new SimpleScale ( this, "1001" ) );

        final QueryFolder queryFolder = new QueryFolder ( new Matcher () {

            @Override
            public boolean matches ( final ItemDescriptor desc )
            {
                return true;
            }
        }, new IDNameProvider () );
        rootFolder.add ( "all", queryFolder, new HashMap<String, Variant> () );
        this._storage.addChild ( queryFolder );

        final GroupFolder groupFolder = new GroupFolder ( new SplitGroupProvider ( new AttributeNameProvider ( "tag" ), "\\." ), new IDNameProvider () );
        rootFolder.add ( "components", groupFolder, new HashMap<String, Variant> () );
        this._storage.addChild ( groupFolder );
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
    public void stop () throws Exception
    {
        this.executor.shutdown ();
        super.stop ();
    }

    public ItemStorage getStorage ()
    {
        return this._storage;
    }

    public void addModule ( final BaseModule module )
    {
        this._modules.add ( module );
    }
}
