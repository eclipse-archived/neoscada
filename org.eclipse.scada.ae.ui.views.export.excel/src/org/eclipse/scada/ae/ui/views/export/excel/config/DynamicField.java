/*******************************************************************************
 * Copyright (c) 2010, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.ae.ui.views.export.excel.config;

import java.util.Date;

import org.eclipse.scada.ae.Event;
import org.eclipse.scada.ae.ui.views.export.excel.Cell;
import org.eclipse.scada.core.Variant;

public class DynamicField implements Field
{
    final String attributeName;

    public DynamicField ( final String attributeName )
    {
        this.attributeName = attributeName;
    }

    @Override
    public int hashCode ()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ( this.attributeName == null ? 0 : this.attributeName.hashCode () );
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
        final DynamicField other = (DynamicField)obj;
        if ( this.attributeName == null )
        {
            if ( other.attributeName != null )
            {
                return false;
            }
        }
        else if ( !this.attributeName.equals ( other.attributeName ) )
        {
            return false;
        }
        return true;
    }

    public String getHeader ()
    {
        return this.attributeName;
    }

    public void render ( final Event event, final Cell cell )
    {
        final Variant data = event.getAttributes ().get ( this.attributeName );
        if ( data != null )
        {
            if ( this.attributeName.contains ( "timestamp" ) && data.isNumber () ) //$NON-NLS-1$
            {
                cell.setDataAsDate ( new Date ( data.asLong ( 0L ) ) );
            }
            else
            {
                cell.setDataAsVariant ( data );
            }
        }
    }
}