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

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.core.databinding.observable.Observables;
import org.eclipse.core.databinding.observable.set.IObservableSet;
import org.eclipse.core.databinding.observable.set.ISetChangeListener;
import org.eclipse.core.databinding.observable.set.SetChangeEvent;
import org.eclipse.core.databinding.observable.set.UnionSet;
import org.eclipse.core.databinding.observable.set.WritableSet;
import org.eclipse.scada.vi.data.SummaryProvider;
import org.eclipse.scada.vi.details.swt.DetailComponent;
import org.eclipse.scada.vi.details.swt.impl.CompositeSummaryProvider;

public abstract class SubTrackingVisibleComponent extends TrackingVisibleComponent
{
    private final Set<DetailComponent> subs = new HashSet<DetailComponent> ();

    private final WritableSet descriptors = new WritableSet ();

    private IObservableSet unionSet = Observables.emptyObservableSet ();

    private final ISetChangeListener setListener = new ISetChangeListener () {

        @Override
        public void handleSetChange ( final SetChangeEvent event )
        {
            event.diff.applyTo ( SubTrackingVisibleComponent.this.descriptors );
        }
    };

    private final CompositeSummaryProvider compositeSummaryProvider;

    public SubTrackingVisibleComponent ()
    {
        this.compositeSummaryProvider = new CompositeSummaryProvider ();
    }

    @Override
    public SummaryProvider getSummaryProvider ()
    {
        return this.compositeSummaryProvider;
    }

    @Override
    public void start ()
    {
        super.start ();
        for ( final DetailComponent component : this.subs )
        {
            component.start ();
        }
    };

    @Override
    public void stop ()
    {
        for ( final DetailComponent component : this.subs )
        {
            component.stop ();
        }
        super.stop ();
    };

    /**
     * Start tracking the sub component
     * <p>
     * Note that the sub component must be created and initialized. This method
     * will call {@link DetailComponent#getDescriptors()} only once and needs
     * the fill list then.
     * </p>
     * 
     * @param subComponent
     *            the sub component to add
     */
    protected void trackSub ( final DetailComponent subComponent )
    {
        this.subs.add ( subComponent );
        this.compositeSummaryProvider.addSummaryProvider ( subComponent.getSummaryProvider () );
        update ();
    }

    protected void untrackSub ( final DetailComponent subComponent )
    {
        this.compositeSummaryProvider.removeSummaryProvider ( subComponent.getSummaryProvider () );
        this.subs.remove ( subComponent );
        update ();
    }

    private void update ()
    {
        this.unionSet.removeSetChangeListener ( this.setListener );
        this.unionSet.dispose ();
        this.descriptors.clear ();

        final List<IObservableSet> childSets = new LinkedList<IObservableSet> ();

        for ( final DetailComponent component : this.subs )
        {
            childSets.add ( component.getDescriptors () );
        }

        if ( childSets.isEmpty () )
        {
            this.unionSet = Observables.emptyObservableSet ();
        }
        else
        {
            this.unionSet = new UnionSet ( childSets.toArray ( new IObservableSet[childSets.size ()] ) );
        }

        this.unionSet.addSetChangeListener ( this.setListener );
        this.descriptors.addAll ( this.unionSet );
    }

    @Override
    public void dispose ()
    {
        for ( final DetailComponent sub : this.subs )
        {
            sub.dispose ();
        }
        this.compositeSummaryProvider.dispose ();
        super.dispose ();
    }

    @Override
    public IObservableSet getDescriptors ()
    {
        return new UnionSet ( new IObservableSet[] { super.getDescriptors (), this.descriptors } );
    }
}
