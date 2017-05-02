/*******************************************************************************
 * Copyright (c) 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.vi.ui.user.navigation;

import org.eclipse.scada.vi.data.SummaryInformation;
import org.eclipse.scada.vi.data.SummaryListener;

public class DelegatingSummaryProvider implements StateProvider
{
    private final org.eclipse.scada.vi.data.SummaryProvider summaryProvider;

    private final StateListener listener;

    private final SummaryListener summaryListener = new SummaryListener () {

        @Override
        public void summaryChanged ( final SummaryInformation summaryInformation )
        {
            handleSummaryChanged ( summaryInformation );
        }
    };

    public DelegatingSummaryProvider ( final org.eclipse.scada.vi.data.SummaryProvider summaryProvider, final StateListener listener )
    {
        this.summaryProvider = summaryProvider;
        this.listener = listener;

        this.summaryProvider.addSummaryListener ( this.summaryListener );
        final SummaryInformation currentSummary = summaryProvider.getSummary ();
        if ( currentSummary != null && listener != null )
        {
            listener.stateChange ( currentSummary.getStateInformation () );
        }
    }

    protected void handleSummaryChanged ( final SummaryInformation summaryInformation )
    {
        if ( this.listener != null && summaryInformation != null )
        {
            this.listener.stateChange ( summaryInformation.getStateInformation () );
        }
    }

    @Override
    public void dispose ()
    {
        this.summaryProvider.removeSummaryListener ( this.summaryListener );
    }

}
