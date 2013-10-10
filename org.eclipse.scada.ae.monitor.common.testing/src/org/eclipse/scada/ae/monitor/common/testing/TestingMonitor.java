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
package org.eclipse.scada.ae.monitor.common.testing;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.eclipse.scada.ae.data.Severity;
import org.eclipse.scada.ae.event.EventProcessor;
import org.eclipse.scada.ae.monitor.common.AbstractStateMonitor;
import org.eclipse.scada.ae.monitor.common.PersistentInformation;
import org.eclipse.scada.ae.server.common.akn.AknHandler;
import org.eclipse.scada.core.Variant;
import org.eclipse.scada.core.server.OperationParameters;
import org.osgi.framework.BundleContext;

public class TestingMonitor extends AbstractStateMonitor implements AknHandler
{

    private final ScheduledExecutorService scheduler = new ScheduledThreadPoolExecutor ( 1 );

    private final Random r = new Random ();

    public TestingMonitor ( final BundleContext context, final Executor executor, final EventProcessor eventProcessor, final String sourceName )
    {
        super ( sourceName, executor, null, eventProcessor );
        this.scheduler.scheduleAtFixedRate ( new Runnable () {

            @Override
            public void run ()
            {
                TestingMonitor.this.tick ();
            }
        }, 1000, 1000, TimeUnit.MILLISECONDS );
    }

    protected void tick ()
    {
        if ( this.r.nextBoolean () )
        {
            setOk ( Variant.TRUE, System.currentTimeMillis () );
        }
        else
        {
            setFailure ( Variant.FALSE, System.currentTimeMillis (), Severity.ALARM, false );
        }
    }

    public void stop ()
    {
        this.scheduler.shutdown ();
    }

    @Override
    public boolean acknowledge ( final String conditionId, final OperationParameters operationParameters, final Date aknTimestamp )
    {
        if ( getId ().equals ( conditionId ) )
        {
            akn ( operationParameters == null ? null : operationParameters.getUserInformation (), aknTimestamp );
            return true;
        }
        return false;
    }

    @Override
    protected void storePersistentInformation ( final PersistentInformation persistentInformation )
    {
        // no-op
    }

}
