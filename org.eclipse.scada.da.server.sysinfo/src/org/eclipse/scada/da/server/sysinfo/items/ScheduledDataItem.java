/*******************************************************************************
 * Copyright (c) 2010 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.server.sysinfo.items;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import org.eclipse.scada.da.server.common.DataItemInputCommon;
import org.eclipse.scada.da.server.common.SuspendableDataItem;

public abstract class ScheduledDataItem extends DataItemInputCommon implements Runnable, SuspendableDataItem
{

    private final ScheduledExecutorService scheduler;

    private final int period;

    private ScheduledFuture<?> future;

    public ScheduledDataItem ( final String name, final ScheduledExecutorService scheduler, final int period )
    {
        super ( name );
        this.period = period;
        this.scheduler = scheduler;
    }

    public void suspend ()
    {
        this.future.cancel ( false );
    }

    public void wakeup ()
    {
        this.future = this.scheduler.scheduleAtFixedRate ( this, 0, this.period, TimeUnit.MILLISECONDS );
    }

}
