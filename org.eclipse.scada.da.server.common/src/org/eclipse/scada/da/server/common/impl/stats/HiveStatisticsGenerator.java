/*******************************************************************************
 * Copyright (c) 2010, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.server.common.impl.stats;

import org.eclipse.scada.core.Variant;
import org.eclipse.scada.core.server.common.session.AbstractSessionImpl;
import org.eclipse.scada.da.core.server.Session;
import org.eclipse.scada.da.server.common.DataItem;

public class HiveStatisticsGenerator implements HiveEventListener, Tickable
{
    protected CounterValue itemsValue = new CounterValue ();

    protected CounterValue sessionsValue = new CounterValue ();

    protected CounterValue valueWritesCounter = new CounterValue ();

    protected CounterValue attributeWritesCounter = new CounterValue ();

    protected CounterValue valueEventsCounter = new CounterValue ();

    protected CounterValue attributeEventsCounter = new CounterValue ();

    @Override
    public void itemRegistered ( final DataItem item )
    {
        this.itemsValue.add ( 1 );
    }

    @Override
    public void sessionCreated ( final AbstractSessionImpl session )
    {
        this.sessionsValue.add ( 1 );
    }

    @Override
    public void sessionDestroyed ( final AbstractSessionImpl session )
    {
        this.sessionsValue.add ( -1 );
    }

    @Override
    public void startWrite ( final Session session, final String itemName, final Variant value )
    {
        this.valueWritesCounter.add ( 1 );
    }

    @Override
    public void startWriteAttributes ( final Session session, final String itemId, final int size )
    {
        this.attributeWritesCounter.add ( size );
    }

    @Override
    public void attributesChanged ( final DataItem item, final int size )
    {
        this.attributeEventsCounter.add ( size );
    }

    @Override
    public void valueChanged ( final DataItem item, final Variant variant, final boolean cache )
    {
        this.valueEventsCounter.add ( 1 );
    }

    @Override
    public void tick ()
    {
        this.attributeWritesCounter.tick ();
        this.itemsValue.tick ();
        this.sessionsValue.tick ();
        this.valueWritesCounter.tick ();
        this.valueEventsCounter.tick ();
        this.attributeEventsCounter.tick ();
    }

    @Override
    public void itemUnregistered ( final DataItem item )
    {
        this.itemsValue.add ( -1 );
    }
}
