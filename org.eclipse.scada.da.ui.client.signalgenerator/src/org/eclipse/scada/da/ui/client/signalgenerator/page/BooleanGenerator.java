/*******************************************************************************
 * Copyright (c) 2009, 2014 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     IBH SYSTEMS GmbH - remove iterations
 *******************************************************************************/
package org.eclipse.scada.da.ui.client.signalgenerator.page;

import org.eclipse.scada.core.Variant;
import org.eclipse.scada.da.ui.client.signalgenerator.SimulationTarget;
import org.eclipse.swt.widgets.Display;

public class BooleanGenerator
{
    public enum State
    {
        START_DELAY,
        END_DELAY,
    }

    private Display display;

    private int startDelay = 1000;

    private int endDelay = 1000;

    private boolean running = false;

    private long lastTick = 0;

    private State currentState;

    private final SimulationTarget target;

    public BooleanGenerator ( final Display display, final SimulationTarget target )
    {
        this.display = display;
        this.target = target;
    }

    public void start ()
    {
        if ( this.running )
        {
            return;
        }
        this.lastTick = System.currentTimeMillis ();
        this.currentState = State.START_DELAY;
        this.running = true;
        triggerRun ();
    }

    private void triggerRun ()
    {
        this.display.timerExec ( 100, new Runnable () {

            @Override
            public void run ()
            {
                if ( BooleanGenerator.this.running )
                {
                    BooleanGenerator.this.tick ();
                    BooleanGenerator.this.triggerRun ();
                }
            }
        } );
    }

    public void stop ()
    {
        if ( !this.running )
        {
            this.running = false;
            return;
        }
    }

    public void dispose ()
    {
        stop ();
        this.display = null;
    }

    protected void tick ()
    {
        final long now = System.currentTimeMillis ();
        switch ( this.currentState )
        {
            case START_DELAY:
                if ( now - this.lastTick > this.startDelay )
                {
                    this.currentState = State.END_DELAY;
                    this.lastTick = now;
                    this.target.writeValue ( Variant.TRUE );
                }
                break;
            case END_DELAY:
                if ( now - this.lastTick > this.endDelay )
                {
                    this.currentState = State.START_DELAY;
                    this.lastTick = now;
                    this.target.writeValue ( Variant.FALSE );
                }
                break;
        }
    }

    public int getStartDelay ()
    {
        return this.startDelay;
    }

    public void setStartDelay ( final int startDelay )
    {
        this.startDelay = startDelay;
    }

    public int getEndDelay ()
    {
        return this.endDelay;
    }

    public void setEndDelay ( final int endDelay )
    {
        this.endDelay = endDelay;
    }
}
