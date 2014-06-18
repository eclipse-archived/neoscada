/*******************************************************************************
 * Copyright (c) 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.configuration.iec60870.edit;

import java.util.TimeZone;

import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

public class TimeZoneCellEditor extends TextComboBoxCellEditor
{
    public TimeZoneCellEditor ( final Composite composite )
    {
        super ( composite, TimeZoneWrapper.getAvailable (), new LabelProvider () {
            @Override
            public String getText ( final Object element )
            {
                final TimeZoneWrapper tzw = (TimeZoneWrapper)element;
                final TimeZone tz = tzw.getTimeZone ();
                return String.format ( "%s (%s)", tz.getID (), tz.getDisplayName () );
            }
        }, true, SWT.SINGLE );
    }

    @Override
    protected Object fromString ( final String value )
    {
        return new TimeZoneWrapper ( TimeZone.getTimeZone ( value ) );
    }

    @Override
    protected String toString ( final Object object )
    {
        if ( object instanceof TimeZoneWrapper )
        {
            return ( (TimeZoneWrapper)object ).getTimeZone ().getID ();
        }
        else if ( object != null )
        {
            return object.toString ();
        }
        else
        {
            return null;
        }
    }
}