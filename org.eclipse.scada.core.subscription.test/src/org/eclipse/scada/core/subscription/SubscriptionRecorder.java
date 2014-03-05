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

import java.util.LinkedList;
import java.util.List;

import org.eclipse.scada.core.data.SubscriptionState;

public class SubscriptionRecorder<T> implements SubscriptionListener<T>
{
    private List<Object> list = new LinkedList<Object> ();

    @Override
    public void updateStatus ( final T topic, final SubscriptionState subscriptionState )
    {
        this.list.add ( new SubscriptionStateEvent ( subscriptionState ) );
    }

    public void added ( final SubscriptionSource<T> source )
    {
        this.list.add ( new SubscriptionSourceEvent<T> ( true, source ) );
    }

    public void removed ( final SubscriptionSource<T> source )
    {
        this.list.add ( new SubscriptionSourceEvent<T> ( false, source ) );
    }

    public List<Object> getList ()
    {
        return this.list;
    }

    public void setList ( final List<Object> list )
    {
        this.list = list;
    }
}
