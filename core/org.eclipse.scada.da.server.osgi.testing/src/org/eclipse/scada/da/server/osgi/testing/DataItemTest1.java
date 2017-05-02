/*******************************************************************************
 * Copyright (c) 2009, 2011 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.server.osgi.testing;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import org.eclipse.scada.core.Variant;
import org.eclipse.scada.da.server.common.chain.DataItemInputChained;

public class DataItemTest1 extends DataItemInputChained implements Runnable
{
    private final ScheduledExecutorService scheduledExecutor;

    private final ScheduledFuture<?> job;

    public DataItemTest1 ( final String id, final ScheduledExecutorService executor )
    {
        super ( id, executor );
        this.scheduledExecutor = executor;

        this.job = this.scheduledExecutor.scheduleAtFixedRate ( this, 1000, 1000, TimeUnit.MILLISECONDS );
    }

    public void dispose ()
    {
        this.job.cancel ( false );
    }

    @Override
    public void run ()
    {
        updateData ( Variant.valueOf ( System.currentTimeMillis () ), null, null );
    }

}
