/*******************************************************************************
 * Copyright (c) 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.ui.blink.internal;

import java.util.LinkedHashSet;
import java.util.Set;

import org.eclipse.core.runtime.SafeRunner;
import org.eclipse.jface.util.SafeRunnable;
import org.eclipse.scada.ui.blink.BlinkCallback;
import org.eclipse.scada.ui.blink.BlinkService;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A BlinkService based on an SWT Display
 * <p>
 * All methods must be called from the SWT display thread. Use {@link Display#asyncExec(Runnable)} or {@link Display#syncExec(Runnable)} if necessary.
 * </p>
 * <p>
 * The class is multi-thread safe by single domain access using the SWT Display
 * </p>
 * 
 * @author Jens Reimann
 */
public class DisplayBlinkServiceImpl implements BlinkService
{
    private static final Logger logger = LoggerFactory.getLogger ( DisplayBlinkServiceImpl.class );

    private static final int delay = Integer.getInteger ( "org.eclipse.scada.ui.utils.toggle.delay", 300 );

    private final Set<BlinkCallback> callbacks = new LinkedHashSet<BlinkCallback> ();

    private int globalCounter;

    private final Display display;

    private boolean running;

    private final Runnable runnable = new Runnable () {
        @Override
        public void run ()
        {
            tick ();
        }
    };

    private boolean scheduled;

    public DisplayBlinkServiceImpl ( final Display display )
    {
        this.display = display;
    }

    @Override
    public void addListener ( final BlinkCallback bc )
    {
        checkDisplay ();

        this.callbacks.add ( bc );
    }

    @Override
    public void removeListener ( final BlinkCallback bc )
    {
        checkDisplay ();

        this.callbacks.remove ( bc );
    }

    private void schedule ()
    {
        if ( this.scheduled )
        {
            return;
        }

        this.scheduled = true;
        this.display.timerExec ( delay, this.runnable );
    }

    public void start ()
    {
        checkDisplay ();

        if ( this.running )
        {
            return;
        }

        this.running = true;
        schedule ();
    }

    public void stop ()
    {
        checkDisplay ();

        this.running = false;
    }

    protected void tick ()
    {
        checkDisplay ();

        if ( !this.running )
        {
            return;
        }

        if ( !this.scheduled )
        {
            // this should never happen ;-)
            logger.warn ( "Got called but was not scheduled" );
            return;
        }

        processTick ();
    }

    private void processTick ()
    {
        this.scheduled = false;

        this.globalCounter++;
        for ( final BlinkCallback tc : this.callbacks )
        {
            SafeRunner.run ( new SafeRunnable () {

                @Override
                public void run () throws Exception
                {
                    tc.toggle ( DisplayBlinkServiceImpl.this.globalCounter );
                }
            } );
        }

        schedule ();
    }

    protected void checkDisplay ()
    {
        if ( Display.getCurrent () != this.display )
        {
            SWT.error ( SWT.ERROR_THREAD_INVALID_ACCESS );
        }
    }

}
