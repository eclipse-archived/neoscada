/*******************************************************************************
 * Copyright (c) 2011, 2014 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     IBH SYSTEMS GmbH - cleanup property handling
 *******************************************************************************/
package org.eclipse.scada.chart.swt.render;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import org.eclipse.scada.chart.Realm;
import org.eclipse.scada.chart.swt.ChartRenderer;
import org.eclipse.swt.SWT;

public abstract class AbstractRenderer implements Renderer
{
    private boolean disposed = false;

    private final ChartRenderer chart;

    protected PropertyChangeListener propertyChangeListener;

    private final Realm realm;

    public AbstractRenderer ( final ChartRenderer chart )
    {
        this.chart = chart;
        this.realm = chart.getRealm ();

        this.propertyChangeListener = new PropertyChangeListener () {

            @Override
            public void propertyChange ( final PropertyChangeEvent evt )
            {
                handlePropertyChange ( evt );
            }
        };
    }

    protected void handlePropertyChange ( final PropertyChangeEvent evt )
    {
        // if something changes, relayout
        relayoutParent ();
    }

    /**
     * Relayout the whole chart area
     */
    protected void relayoutParent ()
    {
        if ( this.chart.isDisposed () )
        {
            return;
        }

        checkWidget ();
        this.chart.relayout ();
        this.chart.redraw ();
    }

    /**
     * Dispose the renderer <br/>
     * If the renderer is already disposed the method does nothing
     */
    public void dispose ()
    {
        if ( !this.disposed )
        {
            this.chart.removeRenderer ( this );
            relayoutParent ();
            this.disposed = true;
        }
    }

    protected void redraw ()
    {
        checkWidget ();
        this.chart.redraw ();
    }

    protected void checkWidget ()
    {
        try
        {
            this.realm.checkRealm ();
        }
        catch ( final IllegalAccessException e )
        {
            SWT.error ( SWT.ERROR_THREAD_INVALID_ACCESS, e );
        }
    }

}
