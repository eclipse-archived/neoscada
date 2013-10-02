/*******************************************************************************
 * Copyright (c) 2009, 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.ui.databinding;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.core.databinding.observable.set.IObservableSet;
import org.eclipse.core.databinding.observable.set.ISetChangeListener;
import org.eclipse.core.databinding.observable.set.SetChangeEvent;

/**
 * @since 1.1
 */
public class ListeningLabelProvider extends ViewerLabelProvider
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
                removeListenerFrom ( it.next () );
            }
        }
    };

    private final Set<IObservableSet> sources = new HashSet<IObservableSet> ();

    private boolean disposed;

    /**
     * @param itemsThatNeedLabels
     */
    public ListeningLabelProvider ( final IObservableSet itemsThatNeedLabels )
    {
        addSource ( itemsThatNeedLabels );
    }

    public ListeningLabelProvider ()
    {
    }

    protected void addSource ( final IObservableSet observableSet )
    {
        if ( observableSet == null )
        {
            return;
        }

        this.sources.add ( observableSet );
        observableSet.addSetChangeListener ( this.listener );
        for ( final Iterator<?> it = observableSet.iterator (); it.hasNext (); )
        {
            addListenerTo ( it.next () );
        }
    }

    protected void removeSource ( final IObservableSet observableSet )
    {
        if ( observableSet == null )
        {
            return;
        }

        for ( final Iterator<?> it = observableSet.iterator (); it.hasNext (); )
        {
            removeListenerFrom ( it.next () );
        }
        observableSet.removeSetChangeListener ( this.listener );

        if ( !this.disposed )
        {
            this.sources.remove ( observableSet );
        }
    }

    protected void addListenerTo ( final Object next )
    {
    }

    protected void removeListenerFrom ( final Object next )
    {
    }

    @Override
    public void dispose ()
    {
        if ( this.disposed )
        {
            return;
        }

        this.disposed = true;

        for ( final IObservableSet set : this.sources )
        {
            if ( !set.isDisposed () )
            {
                for ( final Iterator<?> iter = set.iterator (); iter.hasNext (); )
                {
                    removeListenerFrom ( iter.next () );
                }
            }
            set.removeSetChangeListener ( this.listener );
        }
        super.dispose ();
    }

}
