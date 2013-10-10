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
package org.eclipse.scada.ae.server.common.monitor.testing;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.eclipse.scada.ae.data.MonitorStatus;
import org.eclipse.scada.ae.data.MonitorStatusInformation;
import org.eclipse.scada.ae.server.common.monitor.MonitorQuery;
import org.eclipse.scada.core.Variant;

public class TestConditionQuery extends MonitorQuery
{
    private final ScheduledThreadPoolExecutor scheduler;

    private static final Random r = new Random ();

    public TestConditionQuery ( final Executor executor )
    {
        super ( executor );
        this.scheduler = new ScheduledThreadPoolExecutor ( 1 );
        this.scheduler.scheduleAtFixedRate ( new Runnable () {

            @Override
            public void run ()
            {
                tick ();
            }
        }, 1000, 1000, TimeUnit.MILLISECONDS );
    }

    protected void tick ()
    {
        updateData ( Arrays.asList ( new MonitorStatusInformation ( "test", r.nextBoolean () ? MonitorStatus.OK : MonitorStatus.NOT_OK, System.currentTimeMillis (), null, Variant.NULL, System.currentTimeMillis (), "system", null, null, null ) ), null, false );
    }

    public void stop ()
    {
        this.scheduler.shutdown ();
    }
}
