/*******************************************************************************
 * Copyright (c) 2011, 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.chart.swt.render;

import org.eclipse.scada.chart.swt.ChartRenderer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;

public abstract class AbstractRenderer implements Renderer
{
    private final Display display;

    private boolean disposed = false;

    private final ChartRenderer chart;

    public AbstractRenderer ( final ChartRenderer chart )
    {
        this.chart = chart;
        this.display = chart.getDisplay ();
    }

    public void dispose ()
    {
        if ( !this.disposed )
        {
            this.disposed = true;
            this.chart.removeRenderer ( this );
        }
    }

    protected void redraw ()
    {
        checkWidget ();
        this.chart.redraw ();
    }

    protected void checkWidget ()
    {
        final Display display = this.display;
        if ( display == null )
        {
            error ( SWT.ERROR_WIDGET_DISPOSED );
        }
        if ( display.getThread () != Thread.currentThread () )
        {
            error ( SWT.ERROR_THREAD_INVALID_ACCESS );
        }
        if ( this.disposed )
        {
            error ( SWT.ERROR_WIDGET_DISPOSED );
        }
    }

    private void error ( final int code )
    {
        SWT.error ( code );
    }

}
