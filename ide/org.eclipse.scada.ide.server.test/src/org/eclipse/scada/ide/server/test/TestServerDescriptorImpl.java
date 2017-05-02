/*******************************************************************************
 * Copyright (c) 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.ide.server.test;

import java.util.Set;

import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.scada.da.core.server.Hive;
import org.eclipse.scada.da.server.exporter.Export;
import org.eclipse.scada.da.server.ui.HivesPlugin;
import org.eclipse.scada.da.server.ui.HostedServer;
import org.eclipse.scada.da.server.ui.util.ServerDescriptorImpl;

public class TestServerDescriptorImpl extends ServerDescriptorImpl implements HostedServer
{
    public TestServerDescriptorImpl ( final Realm realm, final Hive hive, final Set<Export> exporters, final String labelAddition )
    {
        super ( realm, hive, exporters, labelAddition );
    }

    @Override
    public void dispose ()
    {
        HivesPlugin.unregisterServer ( this );
        super.dispose ();
    }
}