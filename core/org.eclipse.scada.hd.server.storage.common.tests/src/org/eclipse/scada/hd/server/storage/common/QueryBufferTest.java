/*******************************************************************************
 * Copyright (c) 2013 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.hd.server.storage.common;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.scada.hd.data.ValueInformation;
import org.eclipse.scada.utils.str.Tables;
import org.junit.Assert;
import org.junit.Test;

public class QueryBufferTest
{
    @Test ( expected = IllegalStateException.class )
    public void testNoParameterUpdate ()
    {
        // timespan of one hour
        final Calendar c1 = Calendar.getInstance ();
        c1.set ( 2010, 1, 1, 0, 0 );
        final Calendar c2 = Calendar.getInstance ();
        c2.set ( 2010, 1, 1, 1, 0 );

        final TestQueryBuffer b1 = new TestQueryBuffer ( c1.getTime (), c2.getTime (), -1 );
        b1.insertData ( 1.0, timestamp ( c1, -10 ), false, false );
        b1.complete ();
    }

    @Test
    public void test1 ()
    {
        // timespan of one hour
        final Calendar c1 = Calendar.getInstance ();
        c1.set ( 2010, 1, 1, 0, 0 );
        final Calendar c2 = Calendar.getInstance ();
        c2.set ( 2010, 1, 1, 1, 0 );

        final TestQueryBuffer b1 = new TestQueryBuffer ( c1.getTime (), c2.getTime (), 100 );
        b1.insertData ( -1.0, timestamp ( c1, -20 ), false, false );
        b1.insertData ( 1.0, timestamp ( c1, -10 ), false, false );
        b1.insertData ( 2.0, timestamp ( c1, 0 ), false, false );
        b1.insertData ( 3.0, timestamp ( c1, 1 ), false, false );
        b1.insertData ( 4.0, timestamp ( c1, 2 ), false, false );

        b1.insertData ( 5.0, timestamp ( c1, 200 ), false, false );
        b1.insertData ( 6.0, timestamp ( c1, 201 ), false, false );
        b1.insertData ( 7.0, timestamp ( c1, 202 ), false, false );

        b1.complete ();

        assertBuffer ( b1, 100 );
    }

    @Test
    public void test2 ()
    {
        // timespan of one hour
        final Calendar c1 = Calendar.getInstance ();
        c1.set ( 2010, 1, 1, 0, 0 );
        final Calendar c2 = Calendar.getInstance ();
        c2.set ( 2010, 1, 1, 1, 0 );

        final TestQueryBuffer b1 = new TestQueryBuffer ( c1.getTime (), c2.getTime (), 100 );
        b1.insertData ( -1.0, timestamp ( c1, -20 ), false, false );
        b1.insertData ( 1.0, timestamp ( c1, -10 ), false, false );
        b1.insertData ( 2.0, timestamp ( c1, 0 ), false, false );
        b1.insertData ( 3.0, timestamp ( c1, 1 ), false, false );
        b1.insertData ( 4.0, timestamp ( c1, 2 ), false, false );

        for ( int i = 0; i < 10_000; i++ )
        {
            b1.insertData ( i, timestampMs ( c1, 200 * 1000 + i ), false, false );
        }

        b1.complete ();

        assertBuffer ( b1, 100 );
    }

    private void assertBuffer ( final TestQueryBuffer buffer, final int count )
    {
        Assert.assertEquals ( count, buffer.getInformation ().length );
        dumpBuffer ( buffer, "AVG" );
    }

    private void dumpBuffer ( final TestQueryBuffer buffer, final String string )
    {
        final ValueInformation[] inf = buffer.getInformation ();
        final Double[] data = buffer.getData ().get ( string );

        final List<List<String>> rows = new LinkedList<> ();
        for ( int i = 0; i < data.length; i++ )
        {
            final List<String> row = new LinkedList<> ();
            rows.add ( row );

            row.add ( String.format ( "%04d", i ) );
            row.add ( String.format ( "%s", data[i] ) );
            row.add ( String.format ( "%s", inf[i].getSourceValues () ) );
            row.add ( String.format ( "%.1f", inf[i].getQuality () ) );
        }
        Tables.showTable ( System.out, Arrays.asList ( "Idx", "Value", "#", "Q" ), rows, 2 );
    }

    private Date timestamp ( final Calendar base, final int addSeconds )
    {
        final Calendar c = (Calendar)base.clone ();
        c.add ( Calendar.SECOND, addSeconds );
        return c.getTime ();
    }

    private Date timestampMs ( final Calendar base, final int ms )
    {
        final Calendar c = (Calendar)base.clone ();
        c.add ( Calendar.MILLISECOND, ms );
        return c.getTime ();
    }
}
