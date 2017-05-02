/*******************************************************************************
 * Copyright (c) 2013 Jens Reimann and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Jens Reimann - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.vi.details.swt.impl.tab;

import org.eclipse.jface.action.MenuManager;
import org.eclipse.scada.vi.data.SummaryListener;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;

public class EclipseTabProvider implements TabProvider
{
    private final static class FolderImplementation extends BaseFolderImplementation implements Folder, SummaryListener
    {
        private final Composite container;

        private CTabItem item;

        private final CTabFolder folder;

        private FolderImplementation ( final CTabFolder folder, final Composite container, final int index, final String label, final MenuManager mgr )
        {
            super ( index, label, mgr );
            this.folder = folder;
            this.container = container;
        }

        @Override
        public Composite getContainer ()
        {
            return this.container;
        }

        @Override
        protected void show ()
        {
            super.show ();

            final int tabIndex = findIndex ( this.index );

            if ( tabIndex < 0 )
            {
                this.item = new CTabItem ( this.folder, SWT.NONE );
                this.item.setData ( "order", this.index );
            }
            else
            {
                this.item = new CTabItem ( this.folder, SWT.NONE, tabIndex );
                this.item.setData ( "order", this.index );
            }

            this.item.setControl ( this.container );
            useItem ( this.item );
        }

        @Override
        protected void hide ()
        {
            super.hide ();

            this.item.dispose ();
        }

        @Override
        public void dispose ()
        {
            hide ();
            super.dispose ();
        }

        private int findIndex ( final int index )
        {
            final CTabItem[] items = this.folder.getItems ();
            for ( int i = 0; i < items.length; i++ )
            {
                final CTabItem item = items[i];
                final int order = (Integer)item.getData ( "order" );
                if ( order > index )
                {
                    return i;
                }
            }
            return -1;
        }

    }

    private final CTabFolder folder;

    private final MenuManager mgr;

    public EclipseTabProvider ( final Composite parent )
    {
        this.folder = new CTabFolder ( parent, SWT.TOP | SWT.FLAT | SWT.BORDER );
        this.folder.setTabHeight ( 24 );
        this.folder.setLayoutData ( new GridData ( SWT.FILL, SWT.FILL, true, true ) );

        this.mgr = new MenuManager ();
        final Menu menu = this.mgr.createContextMenu ( this.folder );
        this.folder.setMenu ( menu );
    }

    @Override
    public Folder createFolder ( final int index, final String label )
    {
        final Composite wrapper = new Composite ( this.folder, SWT.NONE );
        wrapper.setLayout ( new FillLayout () );
        return new FolderImplementation ( this.folder, wrapper, index, label, this.mgr );
    }

    @Override
    public void dispose ()
    {
        this.folder.dispose ();
    }
}
