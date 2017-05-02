/*******************************************************************************
 * Copyright (c) 2010, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *******************************************************************************/
package org.eclipse.scada.ae.ui.views.model;

import java.util.Map;

import org.eclipse.scada.ae.data.MonitorStatus;
import org.eclipse.scada.ae.data.MonitorStatusInformation;
import org.eclipse.scada.ae.data.Severity;
import org.eclipse.scada.core.Variant;
import org.eclipse.scada.utils.lang.Immutable;

/**
 * @author jrose
 */
@Immutable
public class MonitorData extends MonitorStatusInformation
{
    private static final long serialVersionUID = 6727349873713785401L;

    public MonitorData ( final String id, final MonitorStatus status, final long statusTimestamp, final Severity severity, final Variant value, final Long lastAknTimestamp, final String lastAknUser, final Long lastFailTimestamp, final Variant lastFailValue, final Map<String, Variant> attributes )
    {
        super ( id, status, statusTimestamp, severity, value, lastAknTimestamp, lastAknUser, lastFailTimestamp, lastFailValue, attributes );
    }

    public MonitorData ( final MonitorStatusInformation monitor )
    {
        super ( monitor.getId (), monitor.getStatus (), monitor.getStatusTimestamp (), monitor.getSeverity (), monitor.getValue (), monitor.getLastAknTimestamp (), monitor.getLastAknUser (), monitor.getLastFailTimestamp (), monitor.getLastFailValue (), monitor.getAttributes () );
    }

    @Override
    public int hashCode ()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ( getId () == null ? 0 : getId ().hashCode () );
        result = prime * result + ( getLastAknTimestamp () == null ? 0 : getLastAknTimestamp ().hashCode () );
        result = prime * result + ( getLastAknUser () == null ? 0 : getLastAknUser ().hashCode () );
        result = prime * result + ( getStatus () == null ? 0 : getStatus ().hashCode () );
        result = prime * result + (int) ( getStatusTimestamp () ^ getStatusTimestamp () >>> 32 );
        result = prime * result + ( getSeverity () == null ? 0 : getSeverity ().hashCode () );
        result = prime * result + ( getValue () == null ? 0 : getValue ().hashCode () );
        result = prime * result + ( getLastFailValue () == null ? 0 : getLastFailValue ().hashCode () );
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
        final MonitorStatusInformation other = (MonitorStatusInformation)obj;
        if ( getId () == null )
        {
            if ( other.getId () != null )
            {
                return false;
            }
        }
        else if ( !getId ().equals ( other.getId () ) )
        {
            return false;
        }
        if ( getLastAknTimestamp () == null )
        {
            if ( other.getLastAknTimestamp () != null )
            {
                return false;
            }
        }
        else if ( !getLastAknTimestamp ().equals ( other.getLastAknTimestamp () ) )
        {
            return false;
        }
        if ( getLastAknUser () == null )
        {
            if ( other.getLastAknUser () != null )
            {
                return false;
            }
        }
        else if ( !getLastAknUser ().equals ( other.getLastAknUser () ) )
        {
            return false;
        }
        if ( getStatus () == null )
        {
            if ( other.getStatus () != null )
            {
                return false;
            }
        }
        else if ( !getStatus ().equals ( other.getStatus () ) )
        {
            return false;
        }
        if ( getStatusTimestamp () != other.getStatusTimestamp () )
        {
            return false;
        }
        if ( getSeverity () == null )
        {
            if ( other.getSeverity () != null )
            {
                return false;
            }
        }
        else if ( !getSeverity ().equals ( other.getSeverity () ) )
        {
            return false;
        }
        if ( getValue () == null )
        {
            if ( other.getValue () != null )
            {
                return false;
            }
        }
        else if ( !getValue ().equals ( other.getValue () ) )
        {
            return false;
        }
        if ( getLastFailValue () == null )
        {
            if ( other.getLastFailValue () != null )
            {
                return false;
            }
        }
        else if ( !getLastFailValue ().equals ( other.getLastFailValue () ) )
        {
            return false;
        }
        return true;
    }
}
