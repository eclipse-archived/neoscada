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

/**
 * A subscription information object which holds the information that where used
 * when the listener binds to the subscription.
 * 
 * Two subcsription information objects are equal if their listeners are equal.
 * @author Jens Reimann
 *
 */
public class SubscriptionInformation
{
    private SubscriptionListener _listener = null;

    private Object _hint = null;

    public SubscriptionInformation ()
    {
        super ();
    }

    public SubscriptionInformation ( final SubscriptionListener listener, final Object hint )
    {
        this._listener = listener;
        this._hint = hint;
    }

    public Object getHint ()
    {
        return this._hint;
    }

    public void setHint ( final Object hint )
    {
        this._hint = hint;
    }

    public SubscriptionListener getListener ()
    {
        return this._listener;
    }

    public void setListener ( final SubscriptionListener listener )
    {
        this._listener = listener;
    }

    @Override
    public int hashCode ()
    {
        final int PRIME = 31;
        int result = 1;
        result = PRIME * result + ( this._listener == null ? 0 : this._listener.hashCode () );
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
        final SubscriptionInformation other = (SubscriptionInformation)obj;
        if ( this._listener == null )
        {
            if ( other._listener != null )
            {
                return false;
            }
        }
        else if ( !this._listener.equals ( other._listener ) )
        {
            return false;
        }
        return true;
    }
}
