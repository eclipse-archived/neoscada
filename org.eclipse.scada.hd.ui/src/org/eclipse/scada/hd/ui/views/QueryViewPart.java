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
package org.eclipse.scada.hd.ui.views;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.scada.hd.QueryListener;
import org.eclipse.scada.hd.ui.data.AbstractQueryBuffer;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.part.ViewPart;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class QueryViewPart extends ViewPart implements QueryListener
{

    private final static Logger logger = LoggerFactory.getLogger ( QueryViewPart.class );

    protected volatile AbstractQueryBuffer query;

    private ISelectionListener selectionListener;

    @Override
    public void dispose ()
    {
        removeListener ();
        clear ();
        super.dispose ();
    }

    /**
     * Add a listener to the global selection service and set the currently selected query
     */
    protected void addListener ()
    {
        if ( this.selectionListener == null )
        {
            getViewSite ().getWorkbenchWindow ().getSelectionService ().addSelectionListener ( this.selectionListener = new ISelectionListener () {

                @Override
                public void selectionChanged ( final IWorkbenchPart part, final ISelection selection )
                {
                    QueryViewPart.this.setSelection ( selection );
                }
            } );
        }
    }

    protected void removeListener ()
    {
        if ( this.selectionListener != null )
        {
            getViewSite ().getWorkbenchWindow ().getSelectionService ().removeSelectionListener ( this.selectionListener );
            this.selectionListener = null;
        }
    }

    protected AbstractQueryBuffer getQueryFromSelection ( final ISelection selection )
    {
        if ( selection.isEmpty () )
        {
            return null;
        }
        if ( ! ( selection instanceof IStructuredSelection ) )
        {
            return null;
        }
        final Object o = ( (IStructuredSelection)selection ).getFirstElement ();
        if ( o instanceof AbstractQueryBuffer )
        {
            return (AbstractQueryBuffer)o;
        }
        return null;
    }

    protected void setSelection ( final ISelection selection )
    {
        final AbstractQueryBuffer query = getQueryFromSelection ( selection );
        if ( query != this.query )
        {
            clear ();
            if ( query != null )
            {
                setQuery ( query );
            }
        }
    }

    protected void setQuery ( final AbstractQueryBuffer query )
    {
        logger.info ( "Setting query: {}", query ); //$NON-NLS-1$

        this.query = query;
        this.query.addQueryListener ( this );
    }

    protected void clear ()
    {
        logger.info ( "Clearing query" );
        if ( this.query != null )
        {
            this.query.removeQueryListener ( this );
            this.query = null;
        }
    }

}
