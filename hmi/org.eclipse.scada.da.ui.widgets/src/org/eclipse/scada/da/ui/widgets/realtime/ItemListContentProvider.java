/*******************************************************************************
 * Copyright (c) 2010, 2011 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.ui.widgets.realtime;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.widgets.Display;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ItemListContentProvider implements ITreeContentProvider, Listener
{

    private final static Logger logger = LoggerFactory.getLogger ( ItemListContentProvider.class );

    private Viewer viewer = null;

    private ListData data = null;

    private Display display;

    public Object[] getChildren ( final Object parentElement )
    {
        if ( this.data == null )
        {
            return null;
        }

        if ( parentElement instanceof ListData )
        {
            final ListData listData = (ListData)parentElement;
            return listData.getItems ().toArray ( new ListEntry[0] );
        }
        else if ( parentElement instanceof ListEntry )
        {
            return ( (ListEntry)parentElement ).getAttributes ().toArray ( new AttributePair[0] );
        }

        return new Object[0];
    }

    public Object getParent ( final Object element )
    {
        if ( this.data == null )
        {
            return null;
        }

        if ( element instanceof ListEntry )
        {
            return this.data;
        }

        return null;
    }

    public boolean hasChildren ( final Object element )
    {
        if ( this.data == null )
        {
            return false;
        }

        if ( element instanceof ListEntry )
        {
            return ( (ListEntry)element ).hasAttributes ();
        }

        return false;
    }

    public Object[] getElements ( final Object inputElement )
    {
        return getChildren ( inputElement );
    }

    public void dispose ()
    {
        unsubscribe ();
    }

    public void inputChanged ( final Viewer viewer, final Object oldInput, final Object newInput )
    {
        unsubscribe ();

        this.viewer = viewer;
        if ( viewer != null )
        {
            this.display = viewer.getControl ().getDisplay ();
        }

        if ( newInput != null )
        {
            subcribe ( newInput );
        }
    }

    private void subcribe ( final Object newInput )
    {
        if ( ! ( newInput instanceof ListData ) )
        {
            return;
        }

        this.data = (ListData)newInput;
        this.data.addListener ( this );
    }

    private void unsubscribe ()
    {
        if ( this.data != null )
        {
            this.data.removeListener ( this );
            this.data = null;
        }
    }

    public void added ( final ListEntry[] entries )
    {
        try
        {
            if ( this.viewer != null )
            {
                this.display.asyncExec ( new Runnable () {
                    public void run ()
                    {
                        performAdded ( entries );
                    }
                } );
            }
        }
        catch ( final Exception e )
        {
            logger.warn ( "Failed to notify viewer", e ); //$NON-NLS-1$
        }
    }

    protected void performAdded ( final ListEntry[] entries )
    {
        if ( this.viewer.getControl ().isDisposed () )
        {
            return;
        }

        if ( this.viewer instanceof TreeViewer )
        {
            ( (TreeViewer)this.viewer ).add ( this.data, entries );
        }
        else if ( this.viewer != null )
        {
            this.viewer.refresh ();
        }
    }

    public void removed ( final ListEntry[] entries )
    {
        try
        {
            if ( this.viewer != null )
            {
                this.display.asyncExec ( new Runnable () {
                    public void run ()
                    {
                        performRemoved ( entries );
                    }
                } );
            }
        }
        catch ( final Exception e )
        {
            logger.warn ( "Failed to notify viewer", e ); //$NON-NLS-1$
        }
    }

    public void performRemoved ( final ListEntry[] entries )
    {
        if ( this.viewer.getControl ().isDisposed () )
        {
            return;
        }

        if ( this.viewer instanceof TreeViewer )
        {
            ( (TreeViewer)this.viewer ).remove ( entries );
        }
        else if ( this.viewer != null )
        {
            this.viewer.refresh ();
        }
    }

    public void updated ( final ListEntry[] entries )
    {
        try
        {
            if ( this.viewer != null )
            {
                this.display.asyncExec ( new Runnable () {
                    public void run ()
                    {
                        performUpdated ( entries );
                    }
                } );
            }
        }
        catch ( final Exception e )
        {
            logger.warn ( "Failed to notify viewer", e ); //$NON-NLS-1$
        }
    }

    public void performUpdated ( final ListEntry[] entries )
    {
        if ( this.viewer.getControl ().isDisposed () )
        {
            return;
        }

        if ( this.viewer instanceof TreeViewer )
        {
            for ( final ListEntry entry : entries )
            {
                ( (TreeViewer)this.viewer ).refresh ( entry );
            }
            ( (TreeViewer)this.viewer ).update ( entries, null );
        }
        else if ( this.viewer != null )
        {
            this.viewer.refresh ();
        }
    }

}
