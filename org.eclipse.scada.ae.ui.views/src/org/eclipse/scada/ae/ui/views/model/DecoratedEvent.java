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
package org.eclipse.scada.ae.ui.views.model;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Date;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.scada.ae.Event;
import org.eclipse.scada.ae.data.MonitorStatus;
import org.eclipse.scada.ae.data.MonitorStatusInformation;
import org.eclipse.scada.ae.ui.views.handler.AckInformation;
import org.eclipse.scada.utils.beans.AbstractPropertyChange;

public class DecoratedEvent extends AbstractPropertyChange implements Serializable, IAdaptable, Comparable<DecoratedEvent>
{
    private static final long serialVersionUID = -565152685009234585L;

    public static class DecoratedEventComparator implements Comparator<DecoratedEvent>
    {
        @Override
        public int compare ( final DecoratedEvent o1, final DecoratedEvent o2 )
        {
            return o1.getEvent ().compareTo ( o2.getEvent () );
        }
    }

    public static final DecoratedEventComparator comparator = new DecoratedEventComparator ();

    private Event event;

    private MonitorData monitor;

    public MonitorStatusInformation getMonitor ()
    {
        return this.monitor;
    }

    public void setMonitor ( final MonitorData monitor )
    {
        firePropertyChange ( "monitor", this.monitor, this.monitor = monitor ); //$NON-NLS-1$
    }

    public DecoratedEvent ( final Event event )
    {
        this.event = event;
    }

    public DecoratedEvent ( final Event event, final MonitorData monitor )
    {
        this.event = event;
        this.monitor = monitor;
    }

    public Event getEvent ()
    {
        return this.event;
    }

    public void setEvent ( final Event event )
    {
        firePropertyChange ( "event", this.event, this.event = event ); //$NON-NLS-1$
    }

    @Override
    public String toString ()
    {
        return String.valueOf ( this.event );
    }

    @Override
    public int hashCode ()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ( this.event == null ? 0 : this.event.hashCode () );
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
        final DecoratedEvent other = (DecoratedEvent)obj;
        if ( this.event == null )
        {
            if ( other.event != null )
            {
                return false;
            }
        }
        else if ( !this.event.equals ( other.event ) )
        {
            return false;
        }
        return true;
    }

    public boolean isActive ()
    {
        if ( this.event == null )
        {
            return false;
        }
        if ( this.monitor == null )
        {
            return false;
        }
        if ( this.event.getSourceTimestamp ().compareTo ( new Date ( this.monitor.getStatusTimestamp () ) ) >= 0 )
        {
            return true;
        }
        return false;
    }

    public boolean isAlarm ()
    {
        return isActive () && ( this.monitor.getStatus () == MonitorStatus.NOT_OK || this.monitor.getStatus () == MonitorStatus.NOT_OK_AKN || this.monitor.getStatus () == MonitorStatus.NOT_OK_NOT_AKN );
    }

    public boolean isAknRequired ()
    {
        return isActive () && ( this.monitor.getStatus () == MonitorStatus.NOT_AKN || this.monitor.getStatus () == MonitorStatus.NOT_OK_NOT_AKN );
    }

    @Override
    @SuppressWarnings ( "rawtypes" )
    public Object getAdapter ( final Class adapter )
    {
        if ( adapter == Event.class )
        {
            return this.event;
        }
        else if ( adapter == AckInformation.class && this.monitor != null )
        {
            return new AckInformation ( this.monitor.getId (), this.event.getSourceTimestamp (), this.monitor.getStatus () );
        }
        return null;
    }

    @Override
    public int compareTo ( final DecoratedEvent o )
    {
        return comparator.compare ( this, o );
    }

}
