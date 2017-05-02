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

/**
 * Provide an implementation that has a static visible state
 * 
 * @author Jens Reimann
 */
public class StaticVisibileProvider implements VisibilityProvider
{
    /**
     * Provide an instance that is always visible
     */
    public static StaticVisibileProvider VISIBLE_INSTANCE = new StaticVisibileProvider ( true );

    /**
     * Provide an instance that is never visible
     */
    public static StaticVisibileProvider INVISIBLE_INSTANCE = new StaticVisibileProvider ( false );

    private final boolean state;

    private StaticVisibileProvider ( final boolean state )
    {
        this.state = state;
    }

    @Override
    public void addListener ( final Listener listener )
    {
        listener.visibilityChanged ( this.state );
    }

    @Override
    public void removeListener ( final Listener listener )
    {
    }

    @Override
    public void dispose ()
    {
    }

}
