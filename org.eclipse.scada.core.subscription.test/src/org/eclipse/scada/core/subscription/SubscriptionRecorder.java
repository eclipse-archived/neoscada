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

import java.util.LinkedList;
import java.util.List;

import org.eclipse.scada.core.data.SubscriptionState;
import org.eclipse.scada.core.subscription.SubscriptionListener;
import org.eclipse.scada.core.subscription.SubscriptionSource;

public class SubscriptionRecorder implements SubscriptionListener
{
    private List<Object> _list = new LinkedList<Object> ();

    @Override
    public void updateStatus ( final Object topic, final SubscriptionState subscriptionState )
    {
        this._list.add ( new SubscriptionStateEvent ( subscriptionState ) );
    }

    public void added ( final SubscriptionSource source )
    {
        this._list.add ( new SubscriptionSourceEvent ( true, source ) );
    }

    public void removed ( final SubscriptionSource source )
    {
        this._list.add ( new SubscriptionSourceEvent ( false, source ) );
    }

    public List<Object> getList ()
    {
        return this._list;
    }

    public void setList ( final List<Object> list )
    {
        this._list = list;
    }
}
