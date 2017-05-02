/*******************************************************************************
 * Copyright (c) 2012, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.ui.databinding.observable;

import org.eclipse.core.databinding.observable.map.IMapChangeListener;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.observable.map.MapChangeEvent;
import org.eclipse.core.databinding.observable.map.MapDiff;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.viewers.Viewer;

public class ObservableMapContentProvider implements IStructuredContentProvider
{

    private IObservableMap input;

    private IMapChangeListener mapListener;

    private StructuredViewer viewer;

    @Override
    public void dispose ()
    {
        detach ();
    }

    @Override
    public void inputChanged ( final Viewer viewer, final Object oldInput, final Object newInput )
    {
        detach ();

        this.viewer = (StructuredViewer)viewer;

        if ( newInput instanceof IObservableMap )
        {
            setInput ( (IObservableMap)newInput );
        }
    }

    private void detach ()
    {
        if ( this.mapListener != null && this.input != null )
        {
            this.input.removeMapChangeListener ( this.mapListener );
            this.mapListener = null;
            this.input = null;
        }
    }

    private void setInput ( final IObservableMap input )
    {
        this.input = input;
        input.addMapChangeListener ( this.mapListener = new IMapChangeListener () {

            @Override
            public void handleMapChange ( final MapChangeEvent event )
            {
                mapChange ( event.diff );
            }
        } );

    }

    protected void mapChange ( final MapDiff diff )
    {
        this.viewer.refresh ();
    }

    @Override
    public Object[] getElements ( final Object inputElement )
    {
        if ( inputElement != this.input )
        {
            return null;
        }

        return this.input.entrySet ().toArray ();
    }

}
