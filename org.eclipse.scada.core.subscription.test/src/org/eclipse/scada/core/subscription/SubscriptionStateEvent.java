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
package org.eclipse.scada.core.subscription;

import org.eclipse.scada.core.data.SubscriptionState;

public class SubscriptionStateEvent
{
    private SubscriptionState state = null;

    public SubscriptionStateEvent ( final SubscriptionState subscriptionState )
    {
        this.state = subscriptionState;
    }

    public SubscriptionState getState ()
    {
        return this.state;
    }

    public void setState ( final SubscriptionState status )
    {
        this.state = status;
    }

    @Override
    public int hashCode ()
    {
        final int PRIME = 31;
        int result = 1;
        result = PRIME * result + ( this.state == null ? 0 : this.state.hashCode () );
        return result;
    }

    @Override
    public boolean equals ( final Object obj )
    {
        if ( this == obj )
        {
            return true;
        }
        if ( obj == null )
        {
            return false;
        }
        if ( getClass () != obj.getClass () )
        {
            return false;
        }
        final SubscriptionStateEvent other = (SubscriptionStateEvent)obj;
        if ( this.state == null )
        {
            if ( other.state != null )
            {
                return false;
            }
        }
        else if ( !this.state.equals ( other.state ) )
        {
            return false;
        }
        return true;
    }
}
