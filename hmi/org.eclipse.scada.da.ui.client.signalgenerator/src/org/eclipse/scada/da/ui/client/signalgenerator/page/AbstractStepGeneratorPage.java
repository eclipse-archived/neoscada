/*******************************************************************************
 * Copyright (c) 2009, 2014 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     IBH SYSTEMS GmbH - cleanup and add real period
 *******************************************************************************/
package org.eclipse.scada.da.ui.client.signalgenerator.page;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.scada.da.ui.client.signalgenerator.Activator;
import org.eclipse.scada.da.ui.client.signalgenerator.SimulationTarget;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;

public abstract class AbstractStepGeneratorPage implements GeneratorPage
{
    private long lastTimestamp;

    protected Display display;

    private volatile boolean running;

    private long period = 250;

    private final int tickDelay = 100;

    protected SimulationTarget target;

    protected abstract void step ();

    @Override
    public void dispose ()
    {
        stop ();
    }

    protected void setPeriod ( final long period )
    {
        this.period = period;
    }

    @Override
    public void createPage ( final Composite parent )
    {
        this.display = parent.getDisplay ();
    }

    @Override
    public void start ()
    {
        this.lastTimestamp = 0;
        this.running = true;
        setTimer ();
    }

    private void setTimer ()
    {
        this.display.timerExec ( this.tickDelay, new Runnable () {
            @Override
            public void run ()
            {
                AbstractStepGeneratorPage.this.tick ();
            }
        } );
    }

    @Override
    public void stop ()
    {
        this.running = false;
    }

    private void tick ()
    {
        if ( !this.running )
        {
            return;
        }

        final long now = System.currentTimeMillis ();
        try
        {
            if ( now - this.lastTimestamp > this.period )
            {
                this.lastTimestamp = now;
                step ();
            }
        }
        catch ( final Throwable e )
        {
            Activator.getDefault ().getLog ().log ( new Status ( IStatus.ERROR, Activator.PLUGIN_ID, "Failed to step", e ) ); //$NON-NLS-1$
        }
        finally
        {
            setTimer ();
        }

    }

    @Override
    public void setTarget ( final SimulationTarget target )
    {
        this.target = target;
    }

}