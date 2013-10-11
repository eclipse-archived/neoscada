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
package org.eclipse.scada.ae.ui.views;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.actions.ActionFactory.IWorkbenchAction;

public class CustomizableAction extends Action implements IWorkbenchAction
{
    private Runnable runnable;

    public Runnable getRunnable ()
    {
        return this.runnable;
    }

    public void setRunnable ( final Runnable runnable )
    {
        this.runnable = runnable;
    }

    @Override
    public void dispose ()
    {
    }

    @Override
    public void run ()
    {
        if ( this.runnable != null )
        {
            this.runnable.run ();
        }
    }

    public CustomizableAction ()
    {
        super ();
    }

    public CustomizableAction ( final String text, final ImageDescriptor image )
    {
        super ( text, image );
    }

    public CustomizableAction ( final String text, final int style )
    {
        super ( text, style );
    }

    public CustomizableAction ( final String text )
    {
        super ( text );
    }
}
