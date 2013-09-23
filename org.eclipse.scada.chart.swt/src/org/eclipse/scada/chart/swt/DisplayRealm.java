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
package org.eclipse.scada.chart.swt;

import org.eclipse.scada.chart.Realm;
import org.eclipse.swt.widgets.Display;

public class DisplayRealm implements Realm
{

    private final Display display;

    public DisplayRealm ( final Display display )
    {
        this.display = display;
    }

    @Override
    public void asyncExec ( final Runnable runnable )
    {
        this.display.asyncExec ( runnable );
    }

    @Override
    public boolean isDisposed ()
    {
        return this.display.isDisposed ();
    }

    @Override
    public void checkRealm () throws IllegalAccessException
    {
        if ( Display.getCurrent () == this.display )
        {
            return;
        }
        throw new IllegalAccessException ( "Access outside of realm" );
    }

}
