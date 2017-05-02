/*******************************************************************************
 * Copyright (c) 2012, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *******************************************************************************/
package org.eclipse.scada.vi.details.swt.impl.visibility;

import org.eclipse.core.databinding.observable.set.IObservableSet;
import org.eclipse.core.databinding.observable.set.ISetChangeListener;
import org.eclipse.core.databinding.observable.set.SetChangeEvent;
import org.eclipse.core.databinding.observable.set.SetDiff;
import org.eclipse.core.databinding.observable.set.WritableSet;
import org.eclipse.scada.vi.data.SummaryProvider;
import org.eclipse.scada.vi.details.swt.impl.visibility.VisibilityProvider.Listener;

public class ComponentVisibility
{
    private final VisibilityProvider provider;

    private final Listener listener;

    private boolean state = true;

    private final VisibleComponent component;

    private final WritableSet descriptors = new WritableSet ();

    private final IObservableSet componentDescriptors;

    private final ISetChangeListener setListener = new ISetChangeListener () {

        @Override
        public void handleSetChange ( final SetChangeEvent event )
        {
            ComponentVisibility.this.handleSetChange ( event.diff );
        }
    };

    public ComponentVisibility ( final VisibilityProvider provider, final VisibleComponent component )
    {
        this.provider = provider;
        this.component = component;
        this.componentDescriptors = component.getDescriptors ();

        component.create ();
        attachDescriptors ();

        this.listener = new Listener () {

            @Override
            public void visibilityChanged ( final boolean state )
            {
                handleVisibilityChanged ( state );
            }
        };

        this.provider.addListener ( this.listener );
    }

    public SummaryProvider getSummaryProvider ()
    {
        return this.component.getSummaryProvider ();
    }

    protected void handleSetChange ( final SetDiff diff )
    {
        diff.applyTo ( this.descriptors );
    }

    protected void handleVisibilityChanged ( final boolean state )
    {
        if ( this.state == state )
        {
            return;
        }

        this.state = state;

        if ( state )
        {
            show ();
        }
        else
        {
            hide ();
        }
    }

    protected void hide ()
    {
        this.component.hide ();
        this.component.stop ();
        detachDescriptors ();
    }

    protected void show ()
    {
        this.component.start ();
        this.component.show ();
        attachDescriptors ();
    }

    private void attachDescriptors ()
    {
        this.componentDescriptors.addSetChangeListener ( this.setListener );
        this.descriptors.addAll ( this.componentDescriptors );
    }

    private void detachDescriptors ()
    {
        this.componentDescriptors.removeSetChangeListener ( this.setListener );
        this.descriptors.clear ();
    }

    public void dispose ()
    {
        this.provider.dispose ();
        this.component.dispose ();
    }

    public IObservableSet getDescriptors ()
    {
        return this.descriptors;
    }

    public void start ()
    {
        if ( this.state )
        {
            this.component.start ();
        }
    }

    public void stop ()
    {
        this.component.stop ();
    }
}
