/*******************************************************************************
 * Copyright (c) 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.vi.details.swt.impl.visibility;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.runtime.SafeRunner;
import org.eclipse.jface.util.SafeRunnable;

public abstract class AbstractVisibilityProvider implements VisibilityProvider
{
    private final Set<Listener> listeners = new HashSet<Listener> ();

    private boolean state;

    /**
     * Fire visibility change
     * <p>
     * The change will only be fired if the state really changed.
     * </p>
     * 
     * @param state
     *            the new state
     */
    protected void fireChange ( final boolean state )
    {
        if ( this.state == state )
        {
            return;
        }

        this.state = state;
        for ( final Listener listener : this.listeners )
        {
            SafeRunner.run ( new SafeRunnable () {

                @Override
                public void run () throws Exception
                {
                    listener.visibilityChanged ( state );
                }
            } );
        }
    }

    @Override
    public void addListener ( final Listener listener )
    {
        if ( this.listeners.add ( listener ) )
        {
            listener.visibilityChanged ( this.state );
        }
    }

    @Override
    public void removeListener ( final Listener listener )
    {
        this.listeners.remove ( listener );
    }

}