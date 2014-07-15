/*******************************************************************************
 * Copyright (c) 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.protocol.iec60870.asdu.types;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.eclipse.scada.protocol.iec60870.ProtocolOptions;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TimestampTest
{
    private ProtocolOptions options;

    @Before
    public void setup ()
    {
        this.options = new ProtocolOptions.Builder ().build ();
    }

    public static long makeTimestamp ( final int year, final int month, final int day, final int hour, final int minute, final int second, final int millisecond )
    {
        final Calendar c = new GregorianCalendar ( year, month - 1, day, hour, minute, second );
        c.set ( Calendar.MILLISECOND, millisecond );
        return c.getTimeInMillis ();
    }

    @Test
    public void test1 ()
    {
        testTimestamp ( makeTimestamp ( 2014, 1, 2, 3, 4, 5, 6 ) );
        testTimestamp ( makeTimestamp ( 2014, 1, 2, 3, 4, 5, 999 ) );
        testTimestamp ( makeTimestamp ( 2014, 1, 2, 3, 4, 59, 999 ) );
        testTimestamp ( makeTimestamp ( 2014, 1, 31, 23, 59, 59, 999 ) );
    }

    private void testTimestamp ( final long ts1 )
    {
        final ByteBuf buf = Unpooled.buffer ();
        TypeHelper.encodeTimestamp ( this.options, buf, ts1 );
        final long rts1 = TypeHelper.parseTimestamp ( this.options, buf );

        dump ( ts1, rts1 );
        Assert.assertEquals ( ts1, rts1 );
    }

    private void dump ( final long ts1, final long rts1 )
    {
        System.out.format ( "In:  %15s - %tc %2$tL%n", ts1, new Date ( ts1 ) );
        System.out.format ( "Out: %15s - %tc %2$tL%n", rts1, new Date ( rts1 ) );
    }
}
