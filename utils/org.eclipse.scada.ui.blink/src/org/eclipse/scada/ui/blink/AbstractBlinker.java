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
package org.eclipse.scada.ui.blink;

public abstract class AbstractBlinker implements BlinkCallback
{

    private boolean state;

    @Override
    public abstract void toggle ( int globalCounter );

    /**
     * Dispose the blinker
     * <p>
     * Calling dispose multiple times is a no-op
     * </p>
     */
    public void dispose ()
    {
        Activator.removeDefaultToggle ( this );
    }

    protected void enableBlinking ( final boolean state )
    {
        if ( this.state == state )
        {
            return;
        }

        if ( state )
        {
            Activator.addDefaultToggle ( this );
        }
        else
        {
            Activator.removeDefaultToggle ( this );
        }
    }

}