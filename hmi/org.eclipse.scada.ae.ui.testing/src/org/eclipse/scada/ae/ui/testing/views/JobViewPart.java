/*******************************************************************************
 * Copyright (c) 2010, 2011 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.ae.ui.testing.views;

import java.util.Collection;
import java.util.LinkedList;

import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.ui.part.ViewPart;

public abstract class JobViewPart extends ViewPart
{

    private Collection<Runnable> taskList = null;

    protected abstract Realm getRealm ();

    protected void scheduleJob ( final Runnable runnable )
    {
        synchronized ( this )
        {
            boolean created = false;
            if ( this.taskList == null )
            {
                created = true;
                this.taskList = new LinkedList<Runnable> ();
            }
            this.taskList.add ( runnable );
            if ( created )
            {
                getRealm ().asyncExec ( new Runnable () {

                    public void run ()
                    {
                        JobViewPart.this.getRealm ().timerExec ( 1000, new Runnable () {

                            public void run ()
                            {
                                processQueue ();
                            }
                        } );
                    }
                } );

            }
        }
    }

    private void processQueue ()
    {
        Collection<Runnable> list = null;
        synchronized ( this )
        {
            list = this.taskList;
            this.taskList = null;
        }

        if ( list != null )
        {
            for ( final Runnable r : list )
            {
                r.run ();
            }
        }
    }

}
