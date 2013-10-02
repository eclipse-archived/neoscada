/*******************************************************************************
 * Copyright (c) 2006, 2010 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Brad Reynolds - bugs 164247, 164134
 *     Matthew Hall - bug 302860
 *     Jens Reimann - derived from ObservableMapCellLabelProvider
 *******************************************************************************/

package org.eclipse.scada.ui.databinding;

import java.util.Set;

import org.eclipse.core.databinding.observable.map.IMapChangeListener;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.observable.map.MapChangeEvent;
import org.eclipse.jface.viewers.LabelProviderChangedEvent;
import org.eclipse.jface.viewers.StyledCellLabelProvider;
import org.eclipse.jface.viewers.ViewerCell;

/**
 * A label provider based on one or more observable maps that track attributes
 * that this label provider uses for display. The default behavior is to display
 * the first attribute's value. Clients may customize by subclassing and
 * overriding {@link #update(ViewerCell)}.
 * 
 * @since 1.2
 */
public class ObservableMapStyledCellLabelProvider extends StyledCellLabelProvider
{

    /**
     * Observable maps typically mapping from viewer elements to label values.
     * Subclasses may use these maps to provide custom labels.
     * 
     * @since 1.4
     */
    protected IObservableMap[] attributeMaps;

    private IMapChangeListener mapChangeListener = new IMapChangeListener () {
        @Override
        public void handleMapChange ( final MapChangeEvent event )
        {
            final Set<?> affectedElements = event.diff.getChangedKeys ();
            final LabelProviderChangedEvent newEvent = new LabelProviderChangedEvent ( ObservableMapStyledCellLabelProvider.this, affectedElements.toArray () );
            fireLabelProviderChanged ( newEvent );
        }
    };

    /**
     * Creates a new label provider that tracks changes to one attribute.
     * 
     * @param attributeMap
     */
    public ObservableMapStyledCellLabelProvider ( final IObservableMap attributeMap )
    {
        this ( new IObservableMap[] { attributeMap } );
    }

    /**
     * Creates a new label provider that tracks changes to more than one
     * attribute. This constructor should be used by subclasses that override
     * {@link #update(ViewerCell)} and make use of more than one attribute.
     * 
     * @param attributeMaps
     */
    protected ObservableMapStyledCellLabelProvider ( final IObservableMap[] attributeMaps )
    {
        System.arraycopy ( attributeMaps, 0, this.attributeMaps = new IObservableMap[attributeMaps.length], 0, attributeMaps.length );
        for ( int i = 0; i < attributeMaps.length; i++ )
        {
            attributeMaps[i].addMapChangeListener ( this.mapChangeListener );
        }
    }

    @Override
    public void dispose ()
    {
        if ( this.attributeMaps == null )
        {
            return;
        }

        for ( int i = 0; i < this.attributeMaps.length; i++ )
        {
            this.attributeMaps[i].removeMapChangeListener ( this.mapChangeListener );
        }
        super.dispose ();
        this.attributeMaps = null;
        this.mapChangeListener = null;
    }

    @Override
    public void update ( final ViewerCell cell )
    {
        final Object element = cell.getElement ();
        final Object value = this.attributeMaps[0].get ( element );
        cell.setText ( value == null ? "" : value.toString () ); //$NON-NLS-1$
    }

}
