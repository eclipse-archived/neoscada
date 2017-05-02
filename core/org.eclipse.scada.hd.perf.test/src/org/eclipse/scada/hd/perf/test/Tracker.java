/*******************************************************************************
 * Copyright (c) 2009, 2010 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.hd.perf.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.scada.hd.perf.test.PerformanceData.Entry;
import org.eclipse.scada.hd.perf.test.PerformanceData.Path;

public class Tracker
{
    private static final Map<Object, Map<Object, PerformanceData>> storage = new HashMap<Object, Map<Object, PerformanceData>> ();

    public static final Object THREAD = new Object ();

    protected static Map<Object, PerformanceData> getType ( final Object type )
    {
        synchronized ( storage )
        {
            Map<Object, PerformanceData> result = storage.get ( type );
            if ( result == null )
            {
                result = new HashMap<Object, PerformanceData> ();
                storage.put ( type, result );
            }
            return result;
        }
    }

    public static void marker ( final Object type, final Object instance, final Object node )
    {
        PerformanceData data;
        synchronized ( storage )
        {
            data = getType ( type ).get ( instance );
            if ( data == null )
            {
                data = new PerformanceData ();
                getType ( type ).put ( instance, data );
            }
        }
        synchronized ( data )
        {
            data.marker ( node );
        }
    }

    public static void marker ( final Object node )
    {
        marker ( THREAD, Thread.currentThread (), node );
    }

    public static Map<Object, PerformanceData> collect ( final Object type )
    {
        for ( final Map.Entry<Object, PerformanceData> entry : getType ( type ).entrySet () )
        {
            final PerformanceData data = entry.getValue ();
            synchronized ( data )
            {
                data.marker ( null );
            }
        }
        return getType ( type );
    }

    public static Map<Path, Entry> compress ( final Object type )
    {
        final Map<PerformanceData.Path, PerformanceData.Entry> data = new HashMap<PerformanceData.Path, PerformanceData.Entry> ();

        for ( final Map.Entry<Object, PerformanceData> entry : getType ( type ).entrySet () )
        {
            final PerformanceData dentry = entry.getValue ();
            synchronized ( dentry )
            {
                dentry.marker ( null );
            }

            for ( final Map.Entry<PerformanceData.Path, PerformanceData.Entry> dataEntry : entry.getValue ().getEntries ().entrySet () )
            {
                final PerformanceData.Path path = dataEntry.getKey ();
                final PerformanceData.Entry value = dataEntry.getValue ();

                PerformanceData.Entry sentry = data.get ( path );
                if ( sentry == null )
                {
                    sentry = new PerformanceData.Entry ();
                    data.put ( path, sentry );
                }
                sentry.times.addAll ( value.times );
            }
        }
        return data;
    }

    public static void dumpCollect ( final Writer out, final Object type ) throws IOException
    {
        final PrintWriter p = new PrintWriter ( out );

        p.println ( "digraph psdata {" );

        for ( final Map.Entry<PerformanceData.Path, PerformanceData.Entry> dataEntry : compress ( type ).entrySet () )
        {
            final BigDecimal avg;

            final List<Long> times = dataEntry.getValue ().times;

            if ( !times.isEmpty () )
            {
                BigDecimal big = new BigDecimal ( 0.0 );
                for ( final Long time : times )
                {
                    big = big.add ( new BigDecimal ( ( (double)time ) ) );
                }
                avg = big.divide ( new BigDecimal ( ( (double)times.size () ) ), 2, BigDecimal.ROUND_HALF_EVEN );
            }
            else
            {
                avg = new BigDecimal ( -1 );
            }

            final Path path = dataEntry.getKey ();

            final String from = path.from == null ? "null-start" : path.from.toString ();
            final String to = path.to == null ? "null-end" : path.to.toString ();

            p.print ( String.format ( "\"%s\" -> \"%s\"", from, to ) );

            p.print ( " [ " );
            p.print ( String.format ( "label=\"%s - %s\"", times.size (), avg ) );
            if ( dataEntry.getKey ().from == null )
            {
                p.print ( ", root=true" );
            }
            p.print ( ", weight=" + times.size () );
            p.print ( " ] " );
            p.print ( ";" );

            p.println ();

        }

        p.println ( "}" );

    }
}
