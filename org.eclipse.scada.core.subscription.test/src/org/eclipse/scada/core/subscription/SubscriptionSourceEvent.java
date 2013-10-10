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

import org.eclipse.scada.core.subscription.SubscriptionSource;

public class SubscriptionSourceEvent
{
    private Boolean _added = null;

    private SubscriptionSource _source = null;

    public SubscriptionSourceEvent ( final boolean added, final SubscriptionSource source )
    {
        super ();
        this._added = added;
        this._source = source;
    }

    public Boolean getAdded ()
    {
        return this._added;
    }

    public void setAdded ( final Boolean added )
    {
        this._added = added;
    }

    public SubscriptionSource getSource ()
    {
        return this._source;
    }

    public void setSource ( final SubscriptionSource source )
    {
        this._source = source;
    }

    @Override
    public int hashCode ()
    {
        final int PRIME = 31;
        int result = 1;
        result = PRIME * result + ( this._added == null ? 0 : this._added.hashCode () );
        result = PRIME * result + ( this._source == null ? 0 : this._source.hashCode () );
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
        final SubscriptionSourceEvent other = (SubscriptionSourceEvent)obj;
        if ( this._added == null )
        {
            if ( other._added != null )
            {
                return false;
            }
        }
        else if ( !this._added.equals ( other._added ) )
        {
            return false;
        }
        if ( this._source == null )
        {
            if ( other._source != null )
            {
                return false;
            }
        }
        else if ( !this._source.equals ( other._source ) )
        {
            return false;
        }
        return true;
    }
}
