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
package org.eclipse.scada.core.ui.connection.login.dialog;

import java.net.ConnectException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.databinding.observable.set.WritableSet;
import org.eclipse.jface.databinding.viewers.ObservableSetContentProvider;
import org.eclipse.jface.viewers.CellLabelProvider;
import org.eclipse.jface.viewers.ColumnPixelData;
import org.eclipse.jface.viewers.TableLayout;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;

public class ConnectionAnalyzer extends Composite implements ContextCreatorListener
{

    private static class Entry
    {
        private final String handlerName;

        private final String state;

        private final Throwable error;

        public Entry ( final String handlerName, final String state, final Throwable error )
        {
            this.handlerName = handlerName;
            this.state = state;
            this.error = error;
        }

        public String getHandlerName ()
        {
            return this.handlerName;
        }

        public Throwable getError ()
        {
            return this.error;
        }

        public String getState ()
        {
            return this.state;
        }

        @Override
        public int hashCode ()
        {
            final int prime = 31;
            int result = 1;
            result = prime * result + ( this.handlerName == null ? 0 : this.handlerName.hashCode () );
            return result;
        }

        @Override
        public boolean equals ( final Object obj )
        {
            if ( this == obj )
            {
                return true;
            }
            if ( obj == null )
            {
                return false;
            }
            if ( ! ( obj instanceof Entry ) )
            {
                return false;
            }
            final Entry other = (Entry)obj;
            if ( this.handlerName == null )
            {
                if ( other.handlerName != null )
                {
                    return false;
                }
            }
            else if ( !this.handlerName.equals ( other.handlerName ) )
            {
                return false;
            }
            return true;
        }

    }

    private static class LabelProvider extends CellLabelProvider
    {

        @Override
        public void update ( final ViewerCell cell )
        {
            final Entry entry = (Entry)cell.getElement ();
            switch ( cell.getColumnIndex () )
            {
            case 0:
                cell.setText ( entry.getHandlerName () );
                break;
            case 1:
                cell.setText ( entry.getState ().toString () );
                break;
            case 2:
                final String errorText = makeError ( entry.getError () );
                // only update when we have an error to prevent
                // the error from disapearing
                if ( errorText != null )
                {
                    cell.setText ( errorText );
                }
                break;
            }
        }
    }

    private final TableViewer tableViewer;

    private final WritableSet dataSet;

    public ConnectionAnalyzer ( final Composite parent, final int style )
    {
        super ( parent, style );
        setLayout ( new FillLayout () );

        this.tableViewer = new TableViewer ( this, style | SWT.FULL_SELECTION );

        TableViewerColumn col;

        col = new TableViewerColumn ( this.tableViewer, SWT.NONE );
        col.getColumn ().setText ( Messages.ConnectionAnalyzer_Column_Text_Uri );
        col.setLabelProvider ( new LabelProvider () );

        col = new TableViewerColumn ( this.tableViewer, SWT.NONE );
        col.getColumn ().setText ( Messages.ConnectionAnalyzer_Column_Text_State );
        col.setLabelProvider ( new LabelProvider () );

        col = new TableViewerColumn ( this.tableViewer, SWT.NONE );
        col.getColumn ().setText ( Messages.ConnectionAnalyzer_Column_Text_Error );
        col.setLabelProvider ( new LabelProvider () );

        final TableLayout tableLayout = new TableLayout ();
        tableLayout.addColumnData ( new ColumnPixelData ( 200 ) );
        tableLayout.addColumnData ( new ColumnPixelData ( 100 ) );
        tableLayout.addColumnData ( new ColumnPixelData ( 400 ) );

        this.tableViewer.getTable ().setLayout ( tableLayout );

        this.tableViewer.getTable ().setHeaderVisible ( true );

        this.dataSet = new WritableSet ();
        this.tableViewer.setContentProvider ( new ObservableSetContentProvider () );
        this.tableViewer.setInput ( this.dataSet );

        this.tableViewer.setItemCount ( 5 );
    }

    public static String makeError ( Throwable error )
    {
        if ( error == null )
        {
            return null;
        }

        final Set<Throwable> causes = new HashSet<Throwable> ( 1 );

        while ( error.getCause () != null && !causes.contains ( error ) )
        {
            causes.add ( error );
            error = error.getCause ();
        }

        if ( error instanceof ConnectException || error instanceof java.rmi.ConnectException )
        {
            return String.format ( Messages.ConnectionAnalyzer_Error_ConnectException, error.getLocalizedMessage () );
        }

        final String msg = error.getLocalizedMessage ();
        if ( msg == null )
        {
            return error.getClass ().getName ();
        }

        if ( "Bad credentials".equals ( msg ) ) //$NON-NLS-1$
        {
            return Messages.ConnectionAnalyzer_Error_BadCredentials;
        }
        return msg;

    }

    public void clear ()
    {
        this.tableViewer.setItemCount ( 0 );
        this.dataSet.clear ();
    }

    @SuppressWarnings ( "unchecked" )
    @Override
    public void stateChanged ( final String handlerName, final String state, final Throwable error )
    {
        if ( isDisposed () )
        {
            return;
        }

        Entry entry = new Entry ( handlerName, state, error );

        try
        {
            this.dataSet.setStale ( true );
            // use error information from previous entry of we don't have a new error, so the user
            // gets at least the last error
            for ( final Entry currentEntry : (Collection<Entry>)this.dataSet )
            {
                if ( currentEntry.equals ( entry ) && currentEntry.getError () != null && entry.getError () == null )
                {
                    entry = new Entry ( handlerName, state, currentEntry.getError () );
                }
            }

            this.dataSet.remove ( entry );
            this.dataSet.add ( entry );
        }
        finally
        {
            this.dataSet.setStale ( false );
        }
    }
}
