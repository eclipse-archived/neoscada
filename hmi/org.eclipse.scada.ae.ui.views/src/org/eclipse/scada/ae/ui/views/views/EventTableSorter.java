/*******************************************************************************
 * Copyright (c) 2011, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.ae.ui.views.views;

import java.util.Comparator;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.scada.ae.Event;
import org.eclipse.scada.ae.ui.views.model.DecoratedEvent;
import org.eclipse.scada.core.VariantComparator;
import org.eclipse.swt.SWT;

class EventTableSorter extends ViewerSorter
{
    private static final VariantComparator variantComparator = new VariantComparator ();

    private final EventTableColumn column;

    private final int dir;

    private static final Comparator<Event> idComparator = new Comparator<Event> () {
        @Override
        public int compare ( final Event e1, final Event e2 )
        {
            return e1.getId ().compareTo ( e2.getId () );
        }
    };

    private static final Comparator<Event> sourceTimestampComparator = new Comparator<Event> () {
        @Override
        public int compare ( final Event e1, final Event e2 )
        {
            return e1.getSourceTimestamp ().compareTo ( e2.getSourceTimestamp () );
        }
    };

    private static final Comparator<Event> entryTimestampComparator = new Comparator<Event> () {
        @Override
        public int compare ( final Event e1, final Event e2 )
        {
            return e1.getEntryTimestamp ().compareTo ( e2.getEntryTimestamp () );
        }
    };

    private static final Comparator<Event> sequenceComparator = new Comparator<Event> () {
        @Override
        public int compare ( final Event e1, final Event e2 )
        {
            return EventTableSorter.variantComparator.compare ( e1.getAttributes ().get ( "sequence" ), e2.getAttributes ().get ( "sequence" ) );//$NON-NLS-1$ //$NON-NLS-2$
        }
    };

    public EventTableSorter ( final EventTableColumn column, final int dir )
    {
        this.column = column;
        this.dir = dir;
    }

    @Override
    public int compare ( final Viewer viewer, final Object o1, final Object o2 )
    {
        final Event e1 = ( (DecoratedEvent)o1 ).getEvent ();
        final Event e2 = ( (DecoratedEvent)o2 ).getEvent ();

        if ( this.column == EventTableColumn.reservedColumnId )
        {
            return chainCompare ( e1, e2, EventTableSorter.idComparator, EventTableSorter.sourceTimestampComparator, EventTableSorter.sequenceComparator, EventTableSorter.entryTimestampComparator );
        }
        else if ( this.column == EventTableColumn.reservedColumnSourceTimestamp )
        {
            return chainCompare ( e1, e2, EventTableSorter.sourceTimestampComparator, EventTableSorter.sequenceComparator, EventTableSorter.entryTimestampComparator, EventTableSorter.idComparator );
        }
        else if ( this.column == EventTableColumn.reservedColumnEntryTimestamp )
        {
            return chainCompare ( e1, e2, EventTableSorter.entryTimestampComparator, EventTableSorter.sourceTimestampComparator, EventTableSorter.sequenceComparator, EventTableSorter.idComparator );
        }
        return 0;
    }

    private int invert ( final int result )
    {
        return ( this.dir == SWT.DOWN ? -1 : 1 ) * result;
    }

    /**
     * Compare the events
     * <p>
     * This might look strange .. but actually is faster
     * </p<
     * @param e1
     * @param e2
     * @param cmp1
     * @param cmp2
     * @param cmp3
     * @param cmp4
     * @return
     */
    private int chainCompare ( final Event e1, final Event e2, final Comparator<Event> cmp1, final Comparator<Event> cmp2, final Comparator<Event> cmp3, final Comparator<Event> cmp4 )
    {
        int result;

        result = cmp1.compare ( e1, e2 );
        if ( result != 0 )
        {
            return invert ( result );
        }
        result = cmp2.compare ( e1, e2 );
        if ( result != 0 )
        {
            return invert ( result );
        }
        result = cmp3.compare ( e1, e2 );
        if ( result != 0 )
        {
            return invert ( result );
        }
        result = cmp4.compare ( e1, e2 );
        if ( result != 0 )
        {
            return invert ( result );
        }

        return 0;
    }
}