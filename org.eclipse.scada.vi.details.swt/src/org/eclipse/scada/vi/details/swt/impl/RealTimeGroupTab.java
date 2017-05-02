/*******************************************************************************
 * Copyright (c) 2012, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *******************************************************************************/
package org.eclipse.scada.vi.details.swt.impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.databinding.observable.Observables;
import org.eclipse.core.databinding.observable.set.IObservableSet;
import org.eclipse.core.databinding.observable.set.ISetChangeListener;
import org.eclipse.core.databinding.observable.set.SetChangeEvent;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.scada.da.ui.connection.data.Item;
import org.eclipse.scada.da.ui.connection.data.Item.Type;
import org.eclipse.scada.da.ui.widgets.realtime.ListEntry;
import org.eclipse.scada.da.ui.widgets.realtime.RealTimeListViewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.scada.da.client.dataitem.details.dialog.DataItemDetailsDialog;
import org.eclipse.scada.vi.data.DataValue;
import org.eclipse.scada.vi.data.SummaryInformation;
import org.eclipse.scada.vi.data.SummaryListener;
import org.eclipse.scada.vi.data.SummaryProvider;
import org.eclipse.scada.vi.details.model.Visibility;
import org.eclipse.scada.vi.details.swt.data.DataItemDescriptor;
import org.eclipse.scada.vi.details.swt.impl.visibility.VisibilityProviderFactory;

class RealTimeGroupTab implements GroupTab
{
    private RealTimeListViewer viewer;

    private Shell shell;

    private IObservableSet input;

    private final Map<Item, ListEntry> entryMap = new HashMap<Item, ListEntry> ();

    private final ISetChangeListener setListener;

    public RealTimeGroupTab ()
    {
        this.setListener = new ISetChangeListener () {

            @Override
            public void handleSetChange ( final SetChangeEvent event )
            {
                for ( final Object object : event.diff.getAdditions () )
                {
                    final DataItemDescriptor item = (DataItemDescriptor)object;
                    addItem ( item );
                }

                for ( final Object object : event.diff.getRemovals () )
                {
                    final DataItemDescriptor item = (DataItemDescriptor)object;
                    removeItem ( item );
                }
            }
        };
    }

    @Override
    public void dispose ()
    {
        if ( this.viewer != null )
        {
            this.viewer.dispose ();
        }
        if ( this.input != null )
        {
            this.input.dispose ();
            this.input = null;
        }
    }

    @Override
    public String getLabel ()
    {
        return Messages.RealTimeGroupTab_TabLabel;
    }

    @Override
    public void init ( final VisibilityProviderFactory factory, final Composite parent, final Map<String, String> properties )
    {
        this.shell = parent.getShell ();

        this.viewer = new RealTimeListViewer ();
        this.viewer.createControl ( parent );
        this.viewer.addDoubleClickListener ( new IDoubleClickListener () {

            @Override
            public void doubleClick ( final DoubleClickEvent event )
            {
                RealTimeGroupTab.this.handleDoubleClick ( event );
            }
        } );

        if ( this.input != null )
        {
            attachInput ();
        }
    }

    private void attachInput ()
    {
        this.input.addSetChangeListener ( this.setListener );

        // load initial items
        for ( final Object object : this.input )
        {
            final DataItemDescriptor item = (DataItemDescriptor)object;
            addItem ( item );
        }
    }

    protected void addItem ( final DataItemDescriptor descriptor )
    {
        if ( this.viewer == null )
        {
            return;
        }

        final Item item = convertItem ( descriptor );

        if ( this.entryMap.containsKey ( item ) )
        {
            return;
        }

        final ListEntry entry = new ListEntry ();
        entry.setDataItem ( item );
        this.viewer.add ( entry );
        this.entryMap.put ( item, entry );
    }

    protected void removeItem ( final DataItemDescriptor descriptor )
    {
        if ( this.viewer == null )
        {
            return;
        }

        final Item item = convertItem ( descriptor );

        final ListEntry entry = this.entryMap.remove ( item );
        if ( entry == null )
        {
            return;
        }

        this.viewer.remove ( entry );
    }

    private void detachInput ()
    {
        if ( this.input != null )
        {
            this.input.removeSetChangeListener ( this.setListener );
        }
        this.viewer.clear ();
    }

    protected void handleDoubleClick ( final DoubleClickEvent event )
    {
        if ( event.getSelection () instanceof IStructuredSelection )
        {
            final Object o = ( (IStructuredSelection)event.getSelection () ).getFirstElement ();
            if ( o instanceof ListEntry )
            {
                final DataItemDetailsDialog dlg = new DataItemDetailsDialog ( this.shell, ( (ListEntry)o ).getItem () );
                dlg.open ();
            }
        }
    }

    /**
     * Set the new input set
     * <p>
     * The old input set will be returned but not disposed
     * </p>
     * 
     * @param input
     *            the new input set or <code>null</code> to set none
     * @return the old input set or <code>null</code> if none was present
     */
    public IObservableSet setInput ( final IObservableSet input )
    {
        final IObservableSet oldInput = this.input;

        if ( this.input != null )
        {
            detachInput ();
        }

        if ( this.viewer != null && input != null )
        {
            this.input = input;
            attachInput ();
        }

        return oldInput;
    }

    private static Item convertItem ( final DataItemDescriptor item )
    {
        return new Item ( item.getConnectionInformation ().toString (), item.getItemId (), Type.ID );
    }

    @Override
    public IObservableSet getDescriptors ()
    {
        // we only consume the other items, not provide them again
        return Observables.emptyObservableSet ();
    }

    @Override
    public Visibility getVisibility ()
    {
        return null;
    }

    @Override
    public void start ()
    {
        // no-op
    }

    @Override
    public void stop ()
    {
        // no-op
    }

    @Override
    public SummaryProvider getSummaryProvider ()
    {
        // we don't provide summary informations
        return new SummaryProvider () {

            @Override
            public SummaryInformation getSummary ()
            {
                return new SummaryInformation ( Collections.<String, DataValue> emptyMap () );
            }

            @Override
            public void addSummaryListener ( final SummaryListener summaryListener )
            {
            }

            @Override
            public void removeSummaryListener ( final SummaryListener summaryListener )
            {
            }
        };
    }
}