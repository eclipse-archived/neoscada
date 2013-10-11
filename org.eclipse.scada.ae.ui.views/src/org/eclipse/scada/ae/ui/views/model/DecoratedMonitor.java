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

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.scada.ae.data.MonitorStatusInformation;
import org.eclipse.scada.ae.ui.views.handler.AckInformation;
import org.eclipse.scada.utils.beans.AbstractPropertyChange;

public class DecoratedMonitor extends AbstractPropertyChange implements Serializable, IAdaptable
{
    private static final long serialVersionUID = -5247078232293575375L;

    private final String id;

    private MonitorData monitor;

    public DecoratedMonitor ( final String id )
    {
        this.id = id;
    }

    public DecoratedMonitor ( final String id, final MonitorStatusInformation monitor )
    {
        this.id = id;
        this.monitor = new MonitorData ( monitor );
    }

    public DecoratedMonitor ( final MonitorStatusInformation monitor )
    {
        this.id = monitor.getId ();
        this.monitor = new MonitorData ( monitor );
    }

    public String getId ()
    {
        return this.id;
    }

    public MonitorData getMonitor ()
    {
        return this.monitor;
    }

    public void setMonitor ( final MonitorStatusInformation monitor )
    {
        firePropertyChange ( "monitor", this.monitor, this.monitor = new MonitorData ( monitor ) ); //$NON-NLS-1$
    }

    public void setMonitor ( final MonitorData monitor )
    {
        firePropertyChange ( "monitor", this.monitor, this.monitor = monitor ); //$NON-NLS-1$
    }

    @Override
    public String toString ()
    {
        return "DecoratedMonitor [id=" + this.id + ", monitor=" + this.monitor + "]"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
    }

    @SuppressWarnings ( "rawtypes" )
    @Override
    public Object getAdapter ( final Class adapter )
    {
        if ( adapter == AckInformation.class )
        {
            return new AckInformation ( this.monitor.getId (), this.monitor.getLastFailTimestamp (), this.monitor.getStatus () );
        }
        return null;
    }
}
