/*******************************************************************************
 * Copyright (c) 2013 Jürgen Rose and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Jürgen Rose - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.ae.server.storage.postgres.internal;

import org.eclipse.scada.ae.Event;
import org.eclipse.scada.ae.server.storage.StoreListener;

public class StoreTask
{

    private final StoreListener listener;

    private final Event eventToStore;

    private final boolean storeInErrorQueue;

    public StoreTask ( final StoreListener listener, final Event eventToStore, final boolean storeInErrorQueue )
    {
        this.listener = listener;
        this.eventToStore = eventToStore;
        this.storeInErrorQueue = storeInErrorQueue;
    }

    public StoreListener getListener ()
    {
        return listener;
    }

    public Event getEventToStore ()
    {
        return eventToStore;
    }

    public boolean isStoreInErrorQueue ()
    {
        return storeInErrorQueue;
    }
}
