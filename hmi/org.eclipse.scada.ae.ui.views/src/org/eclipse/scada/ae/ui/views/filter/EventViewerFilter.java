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
package org.eclipse.scada.ae.ui.views.filter;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.scada.ae.filter.EventMatcher;
import org.eclipse.scada.ae.filter.internal.EventMatcherImpl;
import org.eclipse.scada.ae.ui.views.model.DecoratedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EventViewerFilter extends ViewerFilter
{

    private static final Logger logger = LoggerFactory.getLogger ( EventViewerFilter.class );

    private final EventMatcher eventMatcher;

    private final String filter;

    public EventViewerFilter ( final String filter )
    {
        this.filter = filter;
        this.eventMatcher = new EventMatcherImpl ( filter );
    }

    @Override
    public boolean select ( final Viewer viewer, final Object parentElement, final Object element )
    {
        if ( this.eventMatcher == null )
        {
            return true;
        }
        if ( ! ( element instanceof DecoratedEvent ) )
        {
            return false;
        }
        try
        {
            return this.eventMatcher.matches ( ( (DecoratedEvent)element ).getEvent () );
        }
        catch ( final Exception e )
        {
            logger.warn ( "Failed to filter", e );
        }
        return false;
    }

    @Override
    public int hashCode ()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ( this.filter == null ? 0 : this.filter.hashCode () );
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
        final EventViewerFilter other = (EventViewerFilter)obj;
        if ( this.filter == null )
        {
            if ( other.filter != null )
            {
                return false;
            }
        }
        else if ( !this.filter.equals ( other.filter ) )
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString ()
    {
        return "EventViewerFilter [filter=" + this.filter + "]"; //$NON-NLS-1$ //$NON-NLS-2$
    }
}
