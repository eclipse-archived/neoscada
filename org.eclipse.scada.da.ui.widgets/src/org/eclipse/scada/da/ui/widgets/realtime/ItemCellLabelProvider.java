/*******************************************************************************
 * Copyright (c) 2010, 2014 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     IBH SYSTEMS GmbH - add timestamp column
 *******************************************************************************/
package org.eclipse.scada.da.ui.widgets.realtime;

import java.util.Calendar;
import java.util.TimeZone;

import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.LocalResourceManager;
import org.eclipse.jface.resource.ResourceManager;
import org.eclipse.jface.viewers.CellLabelProvider;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.scada.ui.localization.Activator;

import com.ibm.icu.text.DateFormat;
import com.ibm.icu.text.SimpleDateFormat;

public class ItemCellLabelProvider extends CellLabelProvider
{
    private static DateFormat TIMESTAMP_DATE_FORMAT = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss.SSS" ); //$NON-NLS-1$

    private final ResourceManager resourceManager = new LocalResourceManager ( JFaceResources.getResources () );

    @Override
    public void update ( final ViewerCell cell )
    {
        final Object o = cell.getElement ();
        if ( o instanceof ListEntry )
        {
            updateListEntry ( (ListEntry)o, cell );
        }
        else if ( o instanceof AttributePair )
        {
            updateAttributePair ( (AttributePair)o, cell );
        }
    }

    private void updateAttributePair ( final AttributePair attributePair, final ViewerCell cell )
    {
        switch ( cell.getColumnIndex () )
        {
            case 0:
                cell.setText ( attributePair.key );
                break;
            case 2:
                if ( attributePair.value != null )
                {
                    cell.setText ( attributePair.value.getType ().name () );
                }
                break;
            case 3:
                if ( attributePair.value != null )
                {
                    cell.setText ( attributePair.value.asString ( "<null>" ) ); //$NON-NLS-1$
                }
                break;
            default:
                break;
        }
    }

    private void updateListEntry ( final ListEntry listEntry, final ViewerCell cell )
    {
        cell.setFont ( listEntry.getFont () );
        cell.setForeground ( listEntry.getForeground () );
        cell.setBackground ( listEntry.getBackground () );

        switch ( cell.getColumnIndex () )
        {
            case 0:
                cell.setImage ( listEntry.getImage () );
                cell.setText ( listEntry.getDataItem ().getItem ().getId () );
                break;
            case 1:
                if ( listEntry.getSubscriptionError () != null )
                {
                    cell.setText ( String.format ( "%s (%s)", listEntry.getSubscriptionState (), listEntry.getSubscriptionError ().getMessage () ) ); //$NON-NLS-1$
                }
                else
                {
                    cell.setText ( listEntry.getSubscriptionState ().name () );
                }
                break;
            case 2:
                if ( listEntry.getValue () != null )
                {
                    cell.setText ( listEntry.getValue ().getType ().name () );
                }
                break;
            case 3:
                if ( listEntry.getValue () != null )
                {
                    cell.setText ( listEntry.getValue ().asString ( "<null>" ) ); //$NON-NLS-1$
                }
                break;
            case 4:
                if ( listEntry.getItemValue () != null )
                {
                    final Calendar timestamp = listEntry.getItemValue ().getTimestamp ();
                    if ( timestamp != null )
                    {
                        cell.setText ( formatTimestamp ( timestamp ) );
                    }
                    else
                    {
                        cell.setText ( null );
                    }
                }
                break;
            default:
                break;
        }
    }

    private String formatTimestamp ( final Calendar timestamp )
    {
        if ( timestamp == null )
        {
            return null;
        }

        final Calendar c = (Calendar)timestamp.clone ();
        final TimeZone tz = Activator.getTimeZone ();
        if ( tz != null )
        {
            c.setTimeZone ( tz );
        }

        return TIMESTAMP_DATE_FORMAT.format ( c.getTime () );
    }

    @Override
    public void dispose ()
    {
        this.resourceManager.dispose ();
        super.dispose ();
    }

}
