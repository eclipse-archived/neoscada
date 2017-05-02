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
package org.eclipse.scada.da.server.simulation.component.modules;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.eclipse.scada.core.Variant;
import org.eclipse.scada.da.server.common.DataItemCommand;
import org.eclipse.scada.da.server.common.chain.DataItemInputChained;
import org.eclipse.scada.da.server.simulation.component.Hive;

public class SimpleMOV extends BaseModule implements MOV, Runnable
{
    public enum State
    {
        CLOSED,
        OPENED,
        TRANSIT_OPEN,
        TRANSIT_CLOSE
    }

    protected final static int JOB_PERIOD = 1000;

    protected final static int MOV_RUNTIME = 10 * 1000;

    private final long switchTime = MOV_RUNTIME;

    private long lastTick = 0;

    private long switchRunning = 0;

    private State switchTarget = null;

    private boolean error = false;

    private State state = State.CLOSED;

    private DataItemInputChained openInput = null;

    private DataItemInputChained closeInput = null;

    private DataItemInputChained transitInput = null;

    private DataItemInputChained errorInput = null;

    private DataItemInputChained runtimeInput = null;

    private DataItemInputChained percentInput = null;

    private DataItemCommand openCommand = null;

    private DataItemCommand closeCommand = null;

    private ScheduledExecutorService executor = null;

    public SimpleMOV ( final Hive hive, final String id )
    {
        super ( hive, "mov." + id );

        this.executor = hive.getExecutor ();

        final Map<String, Variant> attributes = new HashMap<String, Variant> ();
        attributes.put ( "tag", Variant.valueOf ( "mov." + id ) );
        this.openInput = getInput ( "open-signal", attributes );
        this.closeInput = getInput ( "close-signal", attributes );
        this.transitInput = getInput ( "transit-signal", attributes );
        this.errorInput = getInput ( "error-signal", attributes );
        this.runtimeInput = getInput ( "runtime-value", attributes );
        this.percentInput = getInput ( "percent-value", attributes );

        this.lastTick = System.currentTimeMillis ();
        this.executor.scheduleAtFixedRate ( this, 0, JOB_PERIOD, TimeUnit.MILLISECONDS );

        this.openCommand = getOutput ( "open-command", attributes );
        this.openCommand.addListener ( new DataItemCommand.Listener () {

            @Override
            public void command ( final Variant value )
            {
                open ();
            }
        } );
        this.closeCommand = getOutput ( "close-command", attributes );
        this.closeCommand.addListener ( new DataItemCommand.Listener () {

            @Override
            public void command ( final Variant value )
            {
                close ();
            }
        } );

        update ();
    }

    @Override
    public synchronized void close ()
    {
        if ( this.state.equals ( State.CLOSED ) )
        {
            return;
        }

        startTransit ( State.CLOSED, State.TRANSIT_CLOSE );
    }

    @Override
    public synchronized void open ()
    {
        if ( this.state.equals ( State.OPENED ) )
        {
            return;
        }

        startTransit ( State.OPENED, State.TRANSIT_OPEN );
    }

    public synchronized void startTransit ( final State target, final State currentState )
    {
        if ( this.switchTarget != null && this.switchTarget.equals ( target ) )
        {
            return;
        }

        if ( this.switchRunning > 0 )
        {
            this.switchRunning = this.switchTime - this.switchRunning;
        }
        else
        {
            this.switchRunning = this.switchTime;
        }

        this.switchTarget = target;
        this.state = currentState;

        update ();
    }

    @Override
    public synchronized void setErrorState ( final boolean state )
    {
        if ( this.error = state )
        {
            return;
        }

        this.error = state;
    }

    protected void setOpenStates ( final boolean open, final boolean close )
    {
        this.openInput.updateData ( Variant.valueOf ( open ), null, null );
        this.closeInput.updateData ( Variant.valueOf ( close ), null, null );
        this.transitInput.updateData ( Variant.valueOf ( isTransit () ), null, null );
    }

    protected synchronized void update ()
    {
        if ( this.error )
        {
            setOpenStates ( true, true );
        }
        else
        {
            switch ( this.state )
            {
            case CLOSED:
                setOpenStates ( false, true );
                this.percentInput.updateData ( Variant.valueOf ( 0.0 ), null, null );
                break;
            case OPENED:
                setOpenStates ( true, false );
                this.percentInput.updateData ( Variant.valueOf ( 1.0 ), null, null );
                break;
            case TRANSIT_CLOSE:
                setOpenStates ( false, false );
                this.percentInput.updateData ( Variant.valueOf ( ( (double)this.switchRunning / (double)this.switchTime ) ), null, null );
                break;
            case TRANSIT_OPEN:
                setOpenStates ( false, false );
                this.percentInput.updateData ( Variant.valueOf ( 1 - (double)this.switchRunning / (double)this.switchTime ), null, null );
                break;
            }
        }
        this.errorInput.updateData ( Variant.valueOf ( this.error ), null, null );
        this.runtimeInput.updateData ( Variant.valueOf ( this.switchRunning ), null, null );

    }

    public boolean isTransit ()
    {
        switch ( this.state )
        {
        case TRANSIT_OPEN:
            return true;
        case TRANSIT_CLOSE:
            return true;
        default:
            return false;
        }
    }

    @Override
    public synchronized void run ()
    {
        final long ts = System.currentTimeMillis ();
        final long diff = ts - this.lastTick;
        this.lastTick = ts;

        this.switchRunning -= diff;

        if ( this.switchRunning < 0 )
        {
            this.switchRunning = 0;
        }

        if ( this.switchTarget == null )
        {
            return;
        }

        if ( this.switchRunning == 0 )
        {
            this.state = this.switchTarget;
            this.switchTarget = null;
        }

        update ();
    }
}
