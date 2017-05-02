/*******************************************************************************
 * Copyright (c) 2011, 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.ae.ui.views.views.table;

import org.eclipse.jface.viewers.StyledCellLabelProvider;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.scada.ae.ui.views.model.DecoratedEvent;
import org.eclipse.scada.ae.ui.views.views.LabelProviderSupport;

public class EntryTimestampLabelProvider extends StyledCellLabelProvider
{

    private final LabelProviderSupport labelProviderSupport;

    public EntryTimestampLabelProvider ( final LabelProviderSupport labelProviderSupport )
    {
        this.labelProviderSupport = labelProviderSupport;
    }

    @Override
    public void update ( final ViewerCell cell )
    {
        final DecoratedEvent event = (DecoratedEvent)cell.getElement ();

        final String value = this.labelProviderSupport.getDf ().format ( event.getEvent ().getEntryTimestamp () );
        cell.setText ( value );
    }

}
