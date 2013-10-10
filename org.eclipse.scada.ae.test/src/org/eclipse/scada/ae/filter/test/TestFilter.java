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

import java.text.SimpleDateFormat;
import java.util.UUID;

import org.eclipse.scada.ae.Event;
import org.eclipse.scada.ae.Event.EventBuilder;
import org.eclipse.scada.ae.Event.Fields;
import org.eclipse.scada.ae.filter.internal.EventMatcherImpl;
import org.eclipse.scada.core.Variant;
import org.junit.Assert;
import org.junit.Test;

public class TestFilter
{
    SimpleDateFormat formatter = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss" );

    @Test
    public void testFilter () throws Exception
    {
        final EventBuilder eb = Event.create ();
        eb.id ( new UUID ( 0, 1 ) );
        eb.sourceTimestamp ( this.formatter.parse ( "2010-03-01 09:31:57" ) );
        eb.entryTimestamp ( this.formatter.parse ( "2010-03-01 09:31:58" ) );
        eb.attribute ( Fields.MESSAGE, "Hello World" );
        eb.attribute ( Fields.VALUE, Variant.valueOf ( 1000l ) );
        final Event event = eb.build ();
        System.err.println ( event );

        // filtering over id is
        testTrue ( event, null );
        testTrue ( event, "" );
        testTrue ( event, "(id=00000000-0000-0000-0000-000000000001)" );
        testTrue ( event, "(id=*)" );
        testTrue ( event, "(id>00000000-0000-0000-0000-000000000000)" );
        testTrue ( event, "(id<00000000-0000-0000-0000-000000000002)" );
        testFalse ( event, "(id=00000000-0000-0000-0000-000000000002)" );
        testTrue ( event, "(id=*-0000-*)" );
        testTrue ( event, "(id=00000000-0000-0000-0000-*)" );
        testTrue ( event, "(id=*-0000-0000-0000-000000000001)" );
        testFalse ( event, "(id=*-0001-*)" );

        testTrue ( event, "(sourceTimestamp=2010-03-01 09:31:57)" );
        testFalse ( event, "(sourceTimestamp<2010-03-01 09:30:00)" );
        testTrue ( event, "(sourceTimestamp>2010-03-01 09:30:00)" );
        testTrue ( event, "(sourceTimestamp=2010-03-01 09:31:57)" );
        testTrue ( event, "(sourceTimestamp>=2010-03-01 09:31:57)" );
        testTrue ( event, "(sourceTimestamp<=2010-03-01 09:31:57)" );

        testFalse ( event, "(entryTimestamp=2010-03-01 09:30:00)" );
        testFalse ( event, "(entryTimestamp<2010-03-01 09:30:00)" );
        testTrue ( event, "(entryTimestamp>2010-03-01 09:30:00)" );
        testTrue ( event, "(entryTimestamp=2010-03-01 09:31:58)" );
        testTrue ( event, "(entryTimestamp>=2010-03-01 09:31:58)" );
        testTrue ( event, "(entryTimestamp<=2010-03-01 09:31:58)" );
        testTrue ( event, "(entryTimestamp=2010-03-01*)" );
        testFalse ( event, "(entryTimestamp=2010-03-02*)" );

        testTrue ( event, "(message=Hello World)" );
        testTrue ( event, "(message=STRING#Hello World)" );
        testTrue ( event, "(message=*)" );
        testTrue ( event, "(message=*World)" );
        testTrue ( event, "(message=Hello*)" );
        testTrue ( event, "(message=*ll*rl*)" );

        testTrue ( event, "(value=INT64#1000)" );
        testTrue ( event, "(value=INT32#1000)" );
        testTrue ( event, "(value=DOUBLE#1000)" );
        testFalse ( event, "(value=DOUBLE#1000.1)" );
        testTrue ( event, "(value=1*)" );

        testTrue ( event, "(&(message=Hello World)(value=1*))" );
        testFalse ( event, "(&(message=Hello_World)(value=1*))" );
    }

    private void testFalse ( final Event event, final String filter )
    {
        final boolean result = new EventMatcherImpl ( filter ).matches ( event );
        Assert.assertFalse ( "Filter test failed: " + filter + " " + event, result );
        System.out.print ( "!" );
    }

    private void testTrue ( final Event event, final String filter )
    {
        final boolean result = new EventMatcherImpl ( filter ).matches ( event );
        Assert.assertTrue ( "Filter test failed: " + filter + " " + event, result );
        System.out.print ( "." );
    }
}
