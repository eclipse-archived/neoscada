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
package org.eclipse.scada.da.client.dataitem.details.part.attrs;

import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.databinding.beans.PojoProperties;
import org.eclipse.core.databinding.observable.Diffs;
import org.eclipse.core.databinding.observable.set.SetDiff;
import org.eclipse.core.databinding.observable.set.WritableSet;
import org.eclipse.core.databinding.property.value.IValueProperty;
import org.eclipse.jface.databinding.viewers.ViewerSupport;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.TableLayout;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.scada.core.Variant;
import org.eclipse.scada.da.client.DataItemValue;
import org.eclipse.scada.da.client.dataitem.details.part.AbstractBaseDetailsPart;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

public class AttributesPart extends AbstractBaseDetailsPart
{

    public static class Entry
    {
        private final String name;

        private final String type;

        private final String value;

        public Entry ( final String name, final String type, final String value )
        {
            this.name = name;
            this.type = type;
            this.value = value;
        }

        public String getName ()
        {
            return this.name;
        }

        public String getValue ()
        {
            return this.value;
        }

        public String getType ()
        {
            return this.type;
        }

        @Override
        public int hashCode ()
        {
            final int prime = 31;
            int result = 1;
            result = prime * result + ( this.name == null ? 0 : this.name.hashCode () );
            result = prime * result + ( this.type == null ? 0 : this.type.hashCode () );
            result = prime * result + ( this.value == null ? 0 : this.value.hashCode () );
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
            if ( getClass () != obj.getClass () )
            {
                return false;
            }
            final Entry other = (Entry)obj;
            if ( this.name == null )
            {
                if ( other.name != null )
                {
                    return false;
                }
            }
            else if ( !this.name.equals ( other.name ) )
            {
                return false;
            }
            if ( this.type == null )
            {
                if ( other.type != null )
                {
                    return false;
                }
            }
            else if ( !this.type.equals ( other.type ) )
            {
                return false;
            }
            if ( this.value == null )
            {
                if ( other.value != null )
                {
                    return false;
                }
            }
            else if ( !this.value.equals ( other.value ) )
            {
                return false;
            }
            return true;
        }

    }

    private final WritableSet entries = new WritableSet ();

    private TableViewer viewer;

    @Override
    public void createPart ( final Composite parent )
    {
        super.createPart ( parent );

        this.viewer = new TableViewer ( parent, SWT.FULL_SELECTION );

        final TableLayout tableLayout = new TableLayout ();

        final TableViewerColumn col1 = new TableViewerColumn ( this.viewer, SWT.NONE );
        col1.getColumn ().setText ( Messages.AttributesPart_NameLabel );
        tableLayout.addColumnData ( new ColumnWeightData ( 50 ) );

        final TableViewerColumn col2 = new TableViewerColumn ( this.viewer, SWT.NONE );
        col2.getColumn ().setText ( Messages.AttributesPart_TypeLabel );
        tableLayout.addColumnData ( new ColumnWeightData ( 20 ) );

        final TableViewerColumn col3 = new TableViewerColumn ( this.viewer, SWT.NONE );
        col3.getColumn ().setText ( Messages.AttributesPart_ValueLabel );
        tableLayout.addColumnData ( new ColumnWeightData ( 50 ) );

        this.viewer.getTable ().setHeaderVisible ( true );
        this.viewer.getTable ().setLayout ( tableLayout );

        ViewerSupport.bind ( this.viewer, this.entries, new IValueProperty[] { PojoProperties.value ( "name" ), PojoProperties.value ( "type" ), PojoProperties.value ( "value" ) } ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$

        this.viewer.setComparator ( new ViewerComparator () );
    }

    @Override
    public void dispose ()
    {
        this.entries.dispose ();
        super.dispose ();
    }

    @Override
    protected void update ()
    {
        final Set<Entry> newAttributes = convert ( getValue () );
        final SetDiff diff = Diffs.computeSetDiff ( this.entries, newAttributes );
        diff.applyTo ( this.entries );
    }

    private Set<Entry> convert ( final DataItemValue value )
    {
        if ( value == null || value.getAttributes () == null )
        {
            return Collections.emptySet ();
        }

        final Set<Entry> entries = new HashSet<AttributesPart.Entry> ( value.getAttributes ().size () );

        for ( final Map.Entry<String, Variant> entry : value.getAttributes ().entrySet () )
        {
            final Variant entryValue = entry.getValue ();
            if ( entryValue != null )
            {
                entries.add ( new Entry ( entry.getKey (), entryValue.getType ().toString (), entryValue.toLabel () ) );
            }
            else
            {
                entries.add ( new Entry ( entry.getKey (), null, null ) );
            }
        }

        return entries;
    }

}
