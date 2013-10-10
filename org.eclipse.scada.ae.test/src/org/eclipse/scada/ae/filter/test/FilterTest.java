/*******************************************************************************
 * Copyright (c) 2009, 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.ae.filter.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.scada.ae.Event;
import org.eclipse.scada.ae.server.storage.Query;
import org.eclipse.scada.ae.server.storage.memory.MemoryStorage;
import org.eclipse.scada.core.Variant;
import org.junit.Assert;
import org.junit.Test;

public class FilterTest
{

    @Test
    public void testFilter () throws Exception
    {
        final MemoryStorage m = new MemoryStorage ();
        m.store ( Event.create ().build () );
        Assert.assertEquals ( 1, m.getEvents ().size () );
        m.store ( Event.create ().build () );
        Assert.assertEquals ( 2, m.getEvents ().size () );
        final Event event = new ArrayList<Event> ( m.getEvents () ).get ( 0 );
        Assert.assertNotNull ( event.getId () );
        Assert.assertNotNull ( event.getEntryTimestamp () );
        Query q = m.query ( "" );
        Assert.assertTrue ( q.hasMore () );
        Collection<Event> events = q.getNext ( 1 );
        Assert.assertEquals ( 1, events.size () );
        events = q.getNext ( 100 );
        Assert.assertEquals ( 1, events.size () );
        m.store ( Event.create ().attribute ( "hop", Variant.valueOf ( "top" ) ).build () );
        m.store ( Event.create ().attribute ( "foo", Variant.valueOf ( "bar" ) ).build () );
        m.store ( Event.create ().attribute ( "foo", Variant.valueOf ( "zap" ) ).build () );
        q = m.query ( "(|(foo=bar)(foo=zap)(hop=top))" );
        final List<Event> r = new ArrayList<Event> ( q.getNext ( 1000 ) );
        System.out.println ( r.size () );
        Assert.assertEquals ( 3, r.size () );
    }
}
