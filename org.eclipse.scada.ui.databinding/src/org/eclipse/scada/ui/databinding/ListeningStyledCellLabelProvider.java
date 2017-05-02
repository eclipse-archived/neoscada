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
package org.eclipse.scada.ui.databinding;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.core.databinding.observable.set.IObservableSet;
import org.eclipse.core.databinding.observable.set.ISetChangeListener;
import org.eclipse.core.databinding.observable.set.SetChangeEvent;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.IValueChangeListener;
import org.eclipse.core.databinding.observable.value.ValueChangeEvent;
import org.eclipse.core.databinding.property.value.IValueProperty;
import org.eclipse.jface.viewers.LabelProviderChangedEvent;
import org.eclipse.jface.viewers.StyledCellLabelProvider;

public abstract class ListeningStyledCellLabelProvider extends StyledCellLabelProvider
{

    private final ISetChangeListener listener = new ISetChangeListener () {
        @Override
        public void handleSetChange ( final SetChangeEvent event )
        {
            for ( final Iterator<?> it = event.diff.getAdditions ().iterator (); it.hasNext (); )
            {
                addListenerTo ( it.next () );
            }
            for ( final Iterator<?> it = event.diff.getRemovals ().iterator (); it.hasNext (); )
            {
                processRemove ( it.next () );
            }
        }
    };

    private final IObservableSet items;

    public ListeningStyledCellLabelProvider ( final IObservableSet itemsThatNeedLabels )
    {
        this.items = itemsThatNeedLabels;
        this.items.addSetChangeListener ( this.listener );
        for ( final Iterator<?> it = this.items.iterator (); it.hasNext (); )
        {
            addListenerTo ( it.next () );
        }
    }

    private final Map<Object, IObservable> observables = new HashMap<Object, IObservable> ();

    /**
     * Listen to changed of the value property of an element
     * <p>
     * This will start listening to value change events and trigger a refresh of
     * the label provider. It will not actually take the value for displaying.
     * </p>
     * <p>
     * Elements that are listened to will automatically removed
     * </p>
     * 
     * @since 1.2
     * @param element
     *            the element to listen to
     * @param property
     *            the property to listen to
     */
    protected void listenTo ( final Object element, final IValueProperty property )
    {
        final IObservableValue obs = property.observe ( element );
        this.observables.put ( element, obs );
        obs.addValueChangeListener ( new IValueChangeListener () {

            @Override
            public void handleValueChange ( final ValueChangeEvent event )
            {
                fireLabelProviderChanged ( new LabelProviderChangedEvent ( ListeningStyledCellLabelProvider.this, element ) );
            }
        } );
    }

    /**
	 * @since 1.2
	 */
    protected void processRemove ( final Object element )
    {
        final IObservable obs = this.observables.remove ( element );
        if ( obs != null )
        {
            obs.dispose ();
        }
        else
        {
            removeListenerFrom ( element );
        }
    }

    @Override
    public void dispose ()
    {
        for ( final IObservable obs : this.observables.values () )
        {
            obs.dispose ();
        }
        this.observables.clear ();
        super.dispose ();
    }

    /**
     * @param element
     */
    protected abstract void removeListenerFrom ( Object element );

    /**
     * @param element
     */
    protected abstract void addListenerTo ( Object element );

}
