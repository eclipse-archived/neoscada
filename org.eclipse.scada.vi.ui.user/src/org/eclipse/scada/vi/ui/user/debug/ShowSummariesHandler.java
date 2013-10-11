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
package org.eclipse.scada.vi.ui.user.debug;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.scada.ui.databinding.AbstractSelectionHandler;
import org.eclipse.scada.ui.databinding.AdapterHelper;
import org.eclipse.scada.vi.data.SummaryInformation;
import org.eclipse.scada.vi.data.SummaryProvider;

public class ShowSummariesHandler extends AbstractSelectionHandler
{

    @Override
    public Object execute ( final ExecutionEvent event ) throws ExecutionException
    {
        final SummaryProvider viewInstance = AdapterHelper.adapt ( getSelection ().getFirstElement (), SummaryProvider.class );
        if ( viewInstance == null )
        {
            return null;
        }
        showSummaries ( viewInstance.getSummary () );
        return null;
    }

    private void showSummaries ( final SummaryInformation summary )
    {
        summary.dump ( System.out );
    }

    @Override
    public boolean isEnabled ()
    {
        if ( AdapterHelper.adapt ( getSelection ().getFirstElement (), SummaryProvider.class ) == null )
        {
            return false;
        }
        return super.isEnabled ();
    }

}
