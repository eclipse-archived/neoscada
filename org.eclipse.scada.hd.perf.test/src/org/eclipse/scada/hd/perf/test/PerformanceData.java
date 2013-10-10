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

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class PerformanceData
{
    static class Path
    {
        public Object from;

        public Object to;

        @Override
        public int hashCode ()
        {
            final int prime = 31;
            int result = 1;
            result = prime * result + ( this.from == null ? 0 : this.from.hashCode () );
            result = prime * result + ( this.to == null ? 0 : this.to.hashCode () );
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
            final Path other = (Path)obj;
            if ( this.from == null )
            {
                if ( other.from != null )
                {
                    return false;
                }
            }
            else if ( !this.from.equals ( other.from ) )
            {
                return false;
            }
            if ( this.to == null )
            {
                if ( other.to != null )
                {
                    return false;
                }
            }
            else if ( !this.to.equals ( other.to ) )
            {
                return false;
            }
            return true;
        }

    }

    static class Entry
    {
        public List<Long> times = new LinkedList<Long> ();
    }

    private final Map<Path, Entry> entries = new HashMap<Path, Entry> ();

    private Object lastNode;

    private Long lastTimestamp;

    public void marker ( final Object node )
    {
        final Path path = new Path ();

        path.from = this.lastNode;
        path.to = node;

        Entry entry = this.entries.get ( path );
        if ( entry == null )
        {
            entry = new Entry ();
            this.entries.put ( path, entry );
        }

        final long now = System.currentTimeMillis ();
        if ( this.lastTimestamp != null )
        {
            entry.times.add ( now - this.lastTimestamp );
        }
        else
        {
            entry.times.add ( 0L );
        }

        this.lastTimestamp = now;
        this.lastNode = node;
    }

    public Map<Path, Entry> getEntries ()
    {
        return this.entries;
    }

}
