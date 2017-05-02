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
package org.eclipse.scada.da.connection.provider.internal;

import org.eclipse.scada.da.client.ItemUpdateListener;

final class SubscriptionItemEntry
{
    private final String itemId;

    private final ItemUpdateListener listener;

    public SubscriptionItemEntry ( final String itemId, final ItemUpdateListener listener )
    {
        this.itemId = itemId;
        this.listener = listener;
    }

    @Override
    public int hashCode ()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ( this.itemId == null ? 0 : this.itemId.hashCode () );
        result = prime * result + ( this.listener == null ? 0 : this.listener.hashCode () );
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
        final SubscriptionItemEntry other = (SubscriptionItemEntry)obj;
        if ( this.itemId == null )
        {
            if ( other.itemId != null )
            {
                return false;
            }
        }
        else if ( !this.itemId.equals ( other.itemId ) )
        {
            return false;
        }
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