/*******************************************************************************
 * Copyright (c) 2013 Jens Reimann and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Jens Reimann - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.sec.ui.providers;

import java.util.Date;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.eclipse.core.runtime.SafeRunner;
import org.eclipse.jface.util.SafeRunnable;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KeyInstanceManager
{

    private final static Logger logger = LoggerFactory.getLogger ( KeyInstanceManager.StatusListener.class );

    public interface StatusListener
    {
        public void defaultKeyChanged ( KeyInformation key, Date validUntil );
    }

    private static Map<Display, KeyInstanceManager> instanceMap = new ConcurrentHashMap<Display, KeyInstanceManager> ();

    private final Display display;

    private final Set<StatusListener> statusListeners = new HashSet<KeyInstanceManager.StatusListener> ();

    private KeyInformation defaultKey;

    private Date validUntil;

    private boolean disposed;

    private KeyInstanceManager ( final Display display )
    {
        this.display = display;
    }

    public void setDefaultKey ( final KeyInformation key, final Integer keyTimeout )
    {
        checkDisplay ();

        this.defaultKey = key;
        if ( keyTimeout != null && keyTimeout > 0 )
        {
            this.validUntil = new Date ( System.currentTimeMillis () + keyTimeout );
            this.display.timerExec ( keyTimeout, new Runnable () {

                @Override
                public void run ()
                {
                    checkClearKey ();
                }
            } );
        }
        else
        {
            this.validUntil = null;
        }

        fireUpdate ( key, this.validUntil );
    }

    protected void checkClearKey ()
    {
        if ( this.validUntil == null || this.disposed )
        {
            return;
        }

        if ( new Date ().after ( this.validUntil ) )
        {
            logger.debug ( "Clearing default key after period" );
            clearDefaultKey ();
        }
    }

    private void checkDisplay ()
    {
        if ( Display.getCurrent () != this.display )
        {
            SWT.error ( SWT.ERROR_THREAD_INVALID_ACCESS );
        }
    }

    private void fireUpdate ( final KeyInformation key, final Date validUntil )
    {
        for ( final StatusListener listener : this.statusListeners )
        {
            SafeRunner.run ( new SafeRunnable () {

                @Override
                public void run () throws Exception
                {
                    listener.defaultKeyChanged ( key, validUntil );
                }
            } );
        }
    }

    public void clearDefaultKey ()
    {
        setDefaultKey ( null, null );
    }

    public KeyInformation getDefaultKey ()
    {
        checkDisplay ();

        return this.defaultKey;
    }

    private void dispose ()
    {
        this.disposed = true;
        this.statusListeners.clear ();
    }

    public void addStatusListener ( final StatusListener statusListener )
    {
        this.statusListeners.add ( statusListener );
    }

    public void removeStatusListener ( final StatusListener statusListener )
    {
        this.statusListeners.remove ( statusListener );
    }

    public static KeyInstanceManager getInstance ( final Display display )
    {
        if ( display == null )
        {
            SWT.error ( SWT.ERROR_NULL_ARGUMENT );
        }

        if ( Display.getCurrent () != display )
        {
            SWT.error ( SWT.ERROR_THREAD_INVALID_ACCESS );
        }

        if ( display.isDisposed () )
        {
            SWT.error ( SWT.ERROR_DEVICE_DISPOSED );
        }

        KeyInstanceManager mgr = instanceMap.get ( display );
        if ( mgr != null )
        {
            return mgr;
        }

        mgr = new KeyInstanceManager ( display );
        instanceMap.put ( display, mgr );

        display.disposeExec ( new Runnable () {

            @Override
            public void run ()
            {
                disposeDisplay ( display );
            }
        } );

        return mgr;
    }

    protected static void disposeDisplay ( final Display display )
    {
        final KeyInstanceManager mgr = instanceMap.remove ( display );
        if ( mgr != null )
        {
            mgr.dispose ();
        }
    }

}
