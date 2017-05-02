/*******************************************************************************
 * Copyright (c) 2009, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.client.dataitem.details;

import org.eclipse.scada.da.ui.connection.data.Item;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.IViewSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.ViewPart;

public class DetailsViewPart extends ViewPart
{

    public static final String VIEW_ID = "org.eclipse.scada.da.client.dataitem.details.DetailsViewPart"; //$NON-NLS-1$

    private DetailsViewComposite detailsView;

    private Item initItem;

    @Override
    public void createPartControl ( final Composite parent )
    {
        this.detailsView = new DetailsViewComposite ( parent, SWT.NONE );
        this.detailsView.setDataItem ( this.initItem );
    }

    @Override
    public void saveState ( final IMemento memento )
    {
        if ( this.initItem != null )
        {
            super.saveState ( memento );
            this.initItem.saveTo ( memento );
        }
    }

    @Override
    public void init ( final IViewSite site, final IMemento memento ) throws PartInitException
    {
        super.init ( site, memento );
        this.initItem = Item.loadFrom ( memento );
    }

    @Override
    public void setFocus ()
    {
        this.detailsView.setFocus ();
    }

    public void setDataItem ( final Item item )
    {
        this.initItem = item;
        if ( this.detailsView != null )
        {
            this.detailsView.setDataItem ( item );
        }
    }

}
