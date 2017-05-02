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
package org.eclipse.scada.vi.details.swt.widgets;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import org.eclipse.scada.vi.data.DataValue;
import org.eclipse.scada.vi.data.RegistrationManager;
import org.eclipse.scada.vi.data.SummaryInformation;
import org.eclipse.scada.vi.data.SummaryListener;
import org.eclipse.scada.vi.data.SummaryProvider;
import org.eclipse.scada.vi.data.RegistrationManager.Listener;

public class RegistrationManagerSummaryProvider implements SummaryProvider, Listener
{

    private final RegistrationManager registrationManager;

    private SummaryInformation summaryInformation;

    private final Set<SummaryListener> listeners = new CopyOnWriteArraySet<SummaryListener> ();

    private boolean closed;

    public RegistrationManagerSummaryProvider ( final RegistrationManager registrationManager )
    {
        this.registrationManager = registrationManager;
        registrationManager.addListener ( this );
        triggerDataUpdate ();
    }

    public void dispose ()
    {
        this.registrationManager.removeListener ( this );
    }

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

    @Override
    public void triggerDataUpdate ()
    {
        this.summaryInformation = new SummaryInformation ( this.registrationManager.getData () );

        final SummaryInformation si = this.closed ? new SummaryInformation ( Collections.<String, DataValue> emptyMap () ) : this.summaryInformation;

        for ( final SummaryListener listener : this.listeners )
        {
            listener.summaryChanged ( si );
        }
    }

    public void open ()
    {
        this.closed = false;
        triggerDataUpdate ();
    }

    public void close ()
    {
        this.closed = true;
        triggerDataUpdate ();
    }
}
