/*******************************************************************************
 * Copyright (c) 2011, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.ae.ui.views.views;

import java.io.Serializable;

import org.eclipse.scada.utils.lang.Immutable;

@Immutable
public class EventTableColumn implements Serializable
{
    private static final long serialVersionUID = 1L;

    private final String column;

    private final String label;

    public static EventTableColumn reservedColumnId = new EventTableColumn ( "id" ); //$NON-NLS-1$

    public static EventTableColumn reservedColumnSourceTimestamp = new EventTableColumn ( "sourceTimestamp" ); //$NON-NLS-1$

    public static EventTableColumn reservedColumnEntryTimestamp = new EventTableColumn ( "entryTimestamp" ); //$NON-NLS-1$

    public EventTableColumn ( final String column, final String label )
    {
        this.column = column;
        this.label = label;
    }

    public EventTableColumn ( final String column )
    {
        this ( column, null );
    }

    public String getLabel ()
    {
        return this.label;
    }

    public String getColumn ()
    {
        return this.column;
    }

    @Override
    public int hashCode ()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ( this.column == null ? 0 : this.column.hashCode () );
        result = prime * result + ( this.label == null ? 0 : this.label.hashCode () );
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
        if ( ! ( obj instanceof EventTableColumn ) )
        {
            return false;
        }
        final EventTableColumn other = (EventTableColumn)obj;
        if ( this.column == null )
        {
            if ( other.column != null )
            {
                return false;
            }
        }
        else if ( !this.column.equals ( other.column ) )
        {
            return false;
        }
        if ( this.label == null )
        {
            if ( other.label != null )
            {
                return false;
            }
        }
        else if ( !this.label.equals ( other.label ) )
        {
            return false;
        }
        return true;
    }

}