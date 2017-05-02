/*******************************************************************************
 * Copyright (c) 2009, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.ae.ui.testing.views;

import java.text.DateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.databinding.observable.map.IMapChangeListener;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.observable.map.MapChangeEvent;
import org.eclipse.jface.viewers.CellLabelProvider;
import org.eclipse.jface.viewers.LabelProviderChangedEvent;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.scada.ae.ui.connection.data.MonitorStatusBean;
import org.eclipse.scada.core.Variant;

public class MonitorsLabelProvider extends CellLabelProvider
{

    private final IMapChangeListener mapChangeListener = new IMapChangeListener () {
        @Override
        public void handleMapChange ( final MapChangeEvent event )
        {
            final Set<?> affectedElements = event.diff.getChangedKeys ();
            if ( !affectedElements.isEmpty () )
            {
                final LabelProviderChangedEvent newEvent = new LabelProviderChangedEvent ( MonitorsLabelProvider.this, affectedElements.toArray () );
                fireLabelProviderChanged ( newEvent );
            }
        }
    };

    private final IObservableMap[] attributeMaps;

    private final DateFormat dateFormat;

    public MonitorsLabelProvider ( final IObservableMap... attributeMaps )
    {
        super ();

        for ( int i = 0; i < attributeMaps.length; i++ )
        {
            attributeMaps[i].addMapChangeListener ( this.mapChangeListener );
        }
        this.attributeMaps = attributeMaps;

        this.dateFormat = DateFormat.getDateTimeInstance ( DateFormat.LONG, DateFormat.LONG );
    }

    @Override
    public void dispose ()
    {
        for ( int i = 0; i < this.attributeMaps.length; i++ )
        {
            this.attributeMaps[i].removeMapChangeListener ( this.mapChangeListener );
        }
        super.dispose ();
    }

    @Override
    public void update ( final ViewerCell cell )
    {
        final Object o = cell.getElement ();
        if ( o instanceof MonitorStatusBean )
        {
            final MonitorStatusBean info = (MonitorStatusBean)o;
            switch ( cell.getColumnIndex () )
            {
                case 0: // id
                    cell.setText ( info.getId () );
                    break;
                case 1: // state
                    cell.setText ( info.getStatus ().toString () );
                    break;
                case 2: // timestamp
                    cell.setText ( getTimestamp ( info.getStatusTimestamp () ) );
                    break;
                case 3: // priority
                    cell.setText ( getAttribute ( info.getAttributes (), "priority", "<none>" ) );
                    break;
                case 4: // value
                    cell.setText ( getValue ( info.getValue (), "<none>" ) );
                    break;
                case 5: // ack user
                    cell.setText ( info.getLastAknUser () != null ? info.getLastAknUser () : "<unknown>" );
                    break;
                case 6: // ack timestamp
                    cell.setText ( getTimestamp ( info.getLastAknTimestamp () ) );
                    break;
                case 7: // fail timestamp
                    cell.setText ( getTimestamp ( info.getLastFailTimestamp () ) );
                    break;
            }
        }
    }

    private String getTimestamp ( final Date timestamp )
    {
        if ( timestamp != null )
        {
            return this.dateFormat.format ( timestamp );
        }
        else
        {
            return "<none>";
        }

    }

    private String getAttribute ( final Map<String, Variant> attributes, final String key, final String defaultString )
    {
        if ( attributes == null )
        {
            return null;
        }

        return getValue ( attributes.get ( key ), defaultString );
    }

    private String getValue ( final Variant value, final String defaultString )
    {
        if ( value == null )
        {
            return defaultString;
        }

        return value.asString ( defaultString );

    }
}