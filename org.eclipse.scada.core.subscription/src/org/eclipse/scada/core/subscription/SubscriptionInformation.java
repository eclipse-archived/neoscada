/*******************************************************************************
 * Copyright (c) 2012, 2014 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     IBH SYSTEMS GmbH - generic subscription manager
 *******************************************************************************/
package org.eclipse.scada.core.subscription;

/**
 * A subscription information object which holds the information that where used
 * when the listener binds to the subscription.
 * Two subscription information objects are equal if their listeners are equal.
 * 
 * @author Jens Reimann
 */
public class SubscriptionInformation<T>
{
    private SubscriptionListener<T> listener;

    private Object hint;

    public SubscriptionInformation ()
    {
        super ();
    }

    public SubscriptionInformation ( final SubscriptionListener<T> listener, final Object hint )
    {
        this.listener = listener;
        this.hint = hint;
    }

    public Object getHint ()
    {
        return this.hint;
    }

    public void setHint ( final Object hint )
    {
        this.hint = hint;
    }

    public SubscriptionListener<T> getListener ()
    {
        return this.listener;
    }

    public void setListener ( final SubscriptionListener<T> listener )
    {
        this.listener = listener;
    }

    @Override
    public int hashCode ()
    {
        final int PRIME = 31;
        int result = 1;
        result = PRIME * result + ( this.listener == null ? 0 : this.listener.hashCode () );
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
        final SubscriptionInformation<?> other = (SubscriptionInformation<?>)obj;
        if ( this.listener == null )
        {
            if ( other.listener != null )
            {
                return false;
            }
        }
        else if ( !this.listener.equals ( other.listener ) )
        {
            return false;
        }
        return true;
    }
}
