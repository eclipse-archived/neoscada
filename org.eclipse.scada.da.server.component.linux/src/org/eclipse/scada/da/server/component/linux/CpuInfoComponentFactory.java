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
package org.eclipse.scada.da.server.component.linux;

import java.util.concurrent.ScheduledExecutorService;

import org.eclipse.scada.da.server.browser.common.FolderCommon;
import org.eclipse.scada.da.server.component.Component;
import org.eclipse.scada.da.server.component.ComponentFactory;
import org.eclipse.scada.da.server.component.Hive;

public class CpuInfoComponentFactory implements ComponentFactory
{

    private final ScheduledExecutorService executor;

    public CpuInfoComponentFactory ( final ScheduledExecutorService executor )
    {
        this.executor = executor;
    }

    @Override
    public String[] getPrefix ()
    {
        return new String[] { "linux", "cpuinfo" }; //$NON-NLS-1$ //$NON-NLS-2$
    }

    @Override
    public Component createComponent ( final Hive hive, final FolderCommon folder )
    {
        return new CpuInfoComponent ( this.executor, hive, folder, "linux.cpuinfo" ); //$NON-NLS-1$
    }
}
