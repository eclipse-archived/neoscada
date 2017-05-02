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
package org.eclipse.scada.da.client.dataitem.details;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

public abstract class CTabVisibilityController implements VisibilityController
{
    private final CTabFolder tabFolder;

    private CTabItem item;

    private Control control;

    private final String label;

    public CTabVisibilityController ( final CTabFolder tabFolder, final String label )
    {
        this.tabFolder = tabFolder;
        this.label = label;
    }

    @Override
    public void dispose ()
    {
        hide ();

        if ( this.control != null )
        {
            this.control.dispose ();
            this.control = null;
        }
    }

    @Override
    public void create ()
    {
        if ( this.control == null )
        {
            this.control = createPart ( this.tabFolder );
        }
        show ();
    }

    protected abstract Control createPart ( Composite parent );

    @Override
    public void show ()
    {
        if ( this.item == null && !this.tabFolder.isDisposed () )
        {
            this.item = new CTabItem ( this.tabFolder, SWT.NONE );
            this.item.setText ( this.label );
            this.item.setControl ( this.control );
        }
    }

    @Override
    public void hide ()
    {
        if ( this.item != null )
        {
            this.item.dispose ();
            this.item = null;
        }
    }
}