/*******************************************************************************
 * Copyright (c) 2009, 2011 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.client.dataitem.details;

import org.eclipse.scada.da.client.base.action.AbstractItemAction;
import org.eclipse.scada.da.ui.connection.data.Item;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;

public class ShowDetailsAction extends AbstractItemAction
{
    public ShowDetailsAction ()
    {
        super ( Messages.ShowDetailsAction_Label );
    }

    @Override
    protected void processItem ( final Item item ) throws PartInitException
    {
        final DetailsViewPart view = (DetailsViewPart)this.page.showView ( DetailsViewPart.VIEW_ID, asSecondardId ( item ), IWorkbenchPage.VIEW_ACTIVATE );
        view.setDataItem ( item );
    }

}
