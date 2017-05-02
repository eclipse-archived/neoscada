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
package org.eclipse.scada.vi.ui.user.navigation.breadcrumb;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

import org.eclipse.core.runtime.SafeRunner;
import org.eclipse.jface.util.SafeRunnable;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

public class BreadcrumbBar
{
    private final Composite composite;

    private final boolean horizontal;

    private final ArrayList<BreadcrumbItem> items = new ArrayList<BreadcrumbItem> ();

    public interface BreadcrumbSelectionListener
    {
        public void selectionChanged ( BreadcrumbItem item );
    }

    private final Set<BreadcrumbSelectionListener> selectionListeners = new LinkedHashSet<BreadcrumbSelectionListener> ();

    public BreadcrumbBar ( final Composite parent, final int style )
    {
        this.composite = new Composite ( parent, SWT.NONE );
        this.composite.addDisposeListener ( new DisposeListener () {

            @Override
            public void widgetDisposed ( final DisposeEvent e )
            {
                handleDispose ();
            }
        } );
        this.horizontal = ( style & SWT.HORIZONTAL ) != 0;

        final GridLayout layout = new GridLayout ( 1, false );
        layout.marginHeight = layout.marginWidth = 0;
        layout.horizontalSpacing = layout.verticalSpacing = 0;

        if ( this.horizontal )
        {
            layout.marginWidth = 5;
            layout.horizontalSpacing = 5;
        }
        else
        {
            layout.marginHeight = 5;
            layout.verticalSpacing = 5;
        }

        this.composite.setLayout ( layout );
    }

    public void addSelectionListener ( final BreadcrumbSelectionListener listener )
    {
        this.selectionListeners.add ( listener );
    }

    public void removeSelectionListener ( final BreadcrumbSelectionListener listener )
    {
        this.selectionListeners.remove ( listener );
    }

    protected void fireSelectionEvent ( final BreadcrumbItem item )
    {
        for ( final BreadcrumbSelectionListener listener : this.selectionListeners )
        {
            SafeRunner.run ( new SafeRunnable () {
                @Override
                public void run () throws Exception
                {
                    listener.selectionChanged ( item );
                }
            } );
        }
    }

    protected void handleDispose ()
    {
        // free all resources
        this.selectionListeners.clear ();
    }

    public BreadcrumbItem[] getItems ()
    {
        return this.items.toArray ( new BreadcrumbItem[this.items.size ()] );
    }

    public void setSelectionIndex ( final int selectionIndex )
    {
        selectItem ( this.items.get ( selectionIndex ), true );
    }

    public void dispose ()
    {
        this.composite.dispose ();
    }

    Composite getComposite ()
    {
        return this.composite;
    }

    public Control getControl ()
    {
        return this.composite;
    }

    void addChild ( final BreadcrumbItem item )
    {
        this.items.add ( item );

        if ( this.horizontal )
        {
            ( (GridLayout)this.composite.getLayout () ).numColumns = this.items.size ();
        }
        this.composite.layout ();
    }

    void removeChild ( final BreadcrumbItem item )
    {
        this.items.remove ( item );

        if ( this.horizontal )
        {
            ( (GridLayout)this.composite.getLayout () ).numColumns = this.items.size ();
        }
        this.composite.layout ();
    }

    boolean isHorizontal ()
    {
        return this.horizontal;
    }

    public void layout ()
    {
        this.composite.layout ();
    }

    public void selectItem ( final BreadcrumbItem item, final boolean selected )
    {
        if ( !this.items.contains ( item ) )
        {
            return;
        }

        for ( final BreadcrumbItem otherItem : this.items )
        {
            if ( otherItem != item )
            {
                otherItem.handleSetSelection ( false );
            }
        }

        item.handleSetSelection ( selected );

        if ( selected )
        {
            fireSelectionEvent ( item );
        }
    }

}
