/*******************************************************************************
 * Copyright (c) 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.vi.details.swt.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import org.eclipse.scada.vi.data.DataValue;
import org.eclipse.scada.vi.data.SummaryInformation;
import org.eclipse.scada.vi.data.SummaryListener;
import org.eclipse.scada.vi.data.SummaryProvider;

public class CompositeSummaryProvider implements SummaryProvider, SummaryListener
{

    private final Set<SummaryListener> listeners = new CopyOnWriteArraySet<SummaryListener> ();

    private SummaryInformation summaryInformation = new SummaryInformation ( Collections.<String, DataValue> emptyMap () );

    private final Set<SummaryProvider> providers = new CopyOnWriteArraySet<SummaryProvider> ();

    @Override
    public SummaryInformation getSummary ()
    {
        return this.summaryInformation;
    }

    @Override
    public void addSummaryListener ( final SummaryListener summaryListener )
    {
        if ( this.listeners.add ( summaryListener ) )
        {
            summaryListener.summaryChanged ( this.summaryInformation );
        }
    }

    @Override
    public void removeSummaryListener ( final SummaryListener summaryListener )
    {
        this.listeners.remove ( summaryListener );
    }

    public void dispose ()
    {
        for ( final SummaryProvider provider : this.providers )
        {
            provider.removeSummaryListener ( this );
        }
        this.providers.clear ();
    }

    public void addSummaryProvider ( final SummaryProvider summaryProvider )
    {
        if ( summaryProvider == null )
        {
            return;
        }

        if ( this.providers.add ( summaryProvider ) )
        {
            summaryProvider.addSummaryListener ( this );
        }
    }

    public void removeSummaryProvider ( final SummaryProvider summaryProvider )
    {
        if ( this.providers.remove ( summaryProvider ) )
        {
            // recreate state
            summaryChanged ( null );
        }
    }

    @Override
    public void summaryChanged ( final SummaryInformation summaryInformation )
    {
        fireChange ( new SummaryInformation ( Collections.<String> emptyList (), Collections.<String, DataValue> emptyMap (), collect () ) );
    }

    private void fireChange ( final SummaryInformation summaryInformation )
    {
        this.summaryInformation = summaryInformation;

        for ( final SummaryListener listener : this.listeners )
        {
            listener.summaryChanged ( summaryInformation );
        }
    }

    private Collection<SummaryInformation> collect ()
    {
        final Collection<SummaryInformation> result = new LinkedList<SummaryInformation> ();

        for ( final SummaryProvider provider : this.providers )
        {
            result.add ( provider.getSummary () );
        }

        return result;
    }

}
