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
package org.eclipse.scada.ae.ui.views.views;

import java.util.TimeZone;

import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.jface.databinding.viewers.ObservableMapLabelProvider;
import org.eclipse.scada.ae.data.MonitorStatusInformation;
import org.eclipse.scada.ae.data.Severity;
import org.eclipse.scada.ae.ui.views.model.DecoratedMonitor;
import org.eclipse.swt.graphics.Image;

public class MonitorTableLabelProvider extends ObservableMapLabelProvider
{
    final private LabelProviderSupport labelProviderSupport;

    public MonitorTableLabelProvider ( final IObservableMap attributeMap, final TimeZone timeZone )
    {
        super ( attributeMap );
        this.labelProviderSupport = new LabelProviderSupport ( timeZone );
    }

    public MonitorTableLabelProvider ( final IObservableMap[] attributeMaps, final TimeZone timeZone )
    {
        super ( attributeMaps );
        this.labelProviderSupport = new LabelProviderSupport ( timeZone );
    }

    @Override
    public void dispose ()
    {
        super.dispose ();
        this.labelProviderSupport.dispose ();
    }

    @Override
    public Image getColumnImage ( final Object element, final int columnIndex )
    {
        if ( ! ( element instanceof DecoratedMonitor ) )
        {
            return null;
        }
        final MonitorStatusInformation monitor = ( (DecoratedMonitor)element ).getMonitor ();
        if ( columnIndex == 1 )
        {
            switch ( monitor.getStatus () )
            {
                case INACTIVE:
                    break;
                case UNSAFE:
                    return this.labelProviderSupport.getDisconnectedImage ();
                case OK:
                    return this.labelProviderSupport.getOkImage ();
                case NOT_OK:
                    //$FALL-THROUGH$
                case NOT_OK_AKN:
                    if ( monitor.getSeverity () == Severity.WARNING )
                    {
                        return this.labelProviderSupport.getWarningImage ();
                    }
                    else
                    {
                        return this.labelProviderSupport.getAlarmImage ();
                    }
                case NOT_AKN:
                    return this.labelProviderSupport.getAckImage ();
                case NOT_OK_NOT_AKN:
                    return this.labelProviderSupport.getAckImage ();
                case INIT:
                    break;
            }
            return this.labelProviderSupport.getEmptyImage ();
        }
        return null;
    }

    @Override
    public String getColumnText ( final Object element, final int columnIndex )
    {
        if ( ! ( element instanceof DecoratedMonitor ) )
        {
            return Messages.MonitorTableLabelProvider_EmptyString;
        }
        final MonitorStatusInformation monitor = ( (DecoratedMonitor)element ).getMonitor ();
        switch ( columnIndex )
        {
            case 0:
                return monitor.getId ().toString ();
            case 1:
                return monitor.getStatus ().toString ();
            case 2:
                return this.labelProviderSupport.formatDate ( monitor.getLastFailTimestamp () );
            case 3:
                return this.labelProviderSupport.toLabel ( monitor.getLastFailValue () );
            case 4:
                return this.labelProviderSupport.toLabel ( monitor.getValue () );
            case 5:
                return monitor.getLastAknUser ();
            case 6:
                return this.labelProviderSupport.formatDate ( monitor.getLastAknTimestamp () );
            case 7:
                return this.labelProviderSupport.toLabel ( monitor.getAttributes ().get ( "item" ) ); //$NON-NLS-1$
            case 8:
                return this.labelProviderSupport.toLabel ( monitor.getAttributes ().get ( "itemDescription" ) ); //$NON-NLS-1$
            case 9:
                return this.labelProviderSupport.toLabel ( monitor.getAttributes ().get ( "message" ) ); //$NON-NLS-1$
            case 10:
                return this.labelProviderSupport.formatDate ( monitor.getStatusTimestamp () );
            case 11:
                return monitor.getSeverity () == null ? "" : monitor.getSeverity ().name ();
        }
        return Messages.MonitorTableLabelProvider_EmptyString;
    }
}
