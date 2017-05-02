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

public class SubscriptionSourceEvent<T>
{
    private boolean added;

    private SubscriptionSource<T> source;

    public SubscriptionSourceEvent ( final boolean added, final SubscriptionSource<T> source )
    {
        this.added = added;
        this.source = source;
    }

    public boolean getAdded ()
    {
        return this.added;
    }

    public void setAdded ( final boolean added )
    {
        this.added = added;
    }

    public SubscriptionSource<T> getSource ()
    {
        return this.source;
    }

    public void setSource ( final SubscriptionSource<T> source )
    {
        this.source = source;
    }

    @Override
    public int hashCode ()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ( this.added ? 1231 : 1237 );
        result = prime * result + ( this.source == null ? 0 : this.source.hashCode () );
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
        if ( ! ( obj instanceof SubscriptionSourceEvent ) )
        {
            return false;
        }
        final SubscriptionSourceEvent<?> other = (SubscriptionSourceEvent<?>)obj;
        if ( this.added != other.added )
        {
            return false;
        }
        if ( this.source == null )
        {
            if ( other.source != null )
            {
                return false;
            }
        }
        else if ( !this.source.equals ( other.source ) )
        {
            return false;
        }
        return true;
    }

}
