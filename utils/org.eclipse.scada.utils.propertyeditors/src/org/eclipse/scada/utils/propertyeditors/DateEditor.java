/*******************************************************************************
 * Copyright (c) 2006, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.utils.propertyeditors;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateEditor extends PropertyEditorSupport
{
    private final SimpleDateFormat dfDateTimeS = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss.S" ); // 23 

    private final SimpleDateFormat dfDateTime = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss" ); // 19

    private final SimpleDateFormat dfDate = new SimpleDateFormat ( "yyyy-MM-dd" ); // 10 

    private final SimpleDateFormat dfTimeS = new SimpleDateFormat ( "HH:mm:ss.S" ); // 12

    private final SimpleDateFormat dfTime = new SimpleDateFormat ( "HH:mm:ss" ); // 8

    @Override
    public void setAsText ( final String text ) throws IllegalArgumentException
    {
        Date d = null;
        if ( text == null )
        {
            setValue ( null );
            return;
        }
        try
        {
            if ( text.length () == 23 )
            {
                d = this.dfDateTimeS.parse ( text );
            }
            else if ( text.length () == 19 )
            {
                d = this.dfDateTime.parse ( text );
            }
            else if ( text.length () == 10 )
            {
                d = this.dfDate.parse ( text );
            }
            else if ( text.length () == 12 )
            {
                d = this.dfTimeS.parse ( text );
            }
            else if ( text.length () == 8 )
            {
                d = this.dfTime.parse ( text );
            }
        }
        catch ( final ParseException e )
        {
            d = null;
        }
        setValue ( d );
    }

    @Override
    public void setValue ( final Object value )
    {
        Date v = null;
        if ( value instanceof Date )
        {
            v = new Date ( ( (Date)value ).getTime () );
        }
        if ( value instanceof Calendar )
        {
            v = ( (Calendar)value ).getTime ();
        }
        if ( value instanceof Integer || value instanceof Long )
        {
            v = new Date ( (Long)value );
        }
        super.setValue ( v );
    }
}
