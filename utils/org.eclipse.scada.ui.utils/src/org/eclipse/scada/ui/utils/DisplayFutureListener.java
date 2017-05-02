/*******************************************************************************
 * Copyright (c) 2010, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.ui.utils;

import java.util.concurrent.Future;

import org.eclipse.scada.utils.concurrent.FutureListener;
import org.eclipse.swt.widgets.Display;

public class DisplayFutureListener<T> implements FutureListener<T>
{

    private final Display display;

    private final FutureListener<T> listener;

    public DisplayFutureListener ( final Display display, final FutureListener<T> listener )
    {
        this.display = display;
        this.listener = listener;
    }

    public void complete ( final Future<T> future )
    {
        if ( !this.display.isDisposed () )
        {
            this.display.asyncExec ( new Runnable () {

                public void run ()
                {
                    DisplayFutureListener.this.listener.complete ( future );
                }
            } );
        }
    }

}
