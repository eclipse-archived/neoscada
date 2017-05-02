/*******************************************************************************
 * Copyright (c) 2010, 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.ui.utils.datetime;

import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.window.IShellProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class DateTimeDialog extends Dialog
{

    private Label resultControl;

    private Text input;

    private Calendar time;

    public DateTimeDialog ( final Shell shell )
    {
        super ( shell );
    }

    public DateTimeDialog ( final IShellProvider shellProvider )
    {
        super ( shellProvider );
    }

    public void setTime ( final Calendar time )
    {
        this.time = time;
    }

    public void setTime ( final Date date )
    {
        final Calendar c = Calendar.getInstance ();
        c.setTime ( date );
        this.time = c;
    }

    public void setTime ( final long millis )
    {
        final Calendar c = Calendar.getInstance ();
        c.setTimeInMillis ( millis );
        this.time = c;
    }

    @Override
    protected Control createDialogArea ( final Composite parent )
    {
        getShell ().setText ( "Time and date" );

        final Composite base = (Composite)super.createDialogArea ( parent );

        final Composite wrapper = new Composite ( base, SWT.NONE );
        wrapper.setLayout ( new GridLayout ( 2, false ) );
        wrapper.setLayoutData ( new GridData ( GridData.FILL_BOTH ) );

        final Label label = new Label ( wrapper, SWT.NONE );
        label.setText ( "Input:" );

        this.input = new Text ( wrapper, SWT.BORDER );

        this.input.addModifyListener ( new ModifyListener () {

            @Override
            public void modifyText ( final ModifyEvent e )
            {
                update ();
            }
        } );
        this.input.setLayoutData ( new GridData ( SWT.FILL, SWT.CENTER, true, false ) );

        this.resultControl = new Label ( wrapper, SWT.NONE );
        this.resultControl.setLayoutData ( new GridData ( SWT.FILL, SWT.CENTER, true, false, 2, 1 ) );

        if ( this.time != null )
        {
            this.input.setText ( String.format ( "%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS.%1$tL", this.time ) );
        }

        return base;
    }

    protected void update ()
    {
        final String str = this.input.getText ();

        final Calendar c = parse ( str );
        setCalendar ( c );
    }

    protected Calendar parse ( final String str )
    {
        try
        {
            Calendar c;

            c = tryParse ( str, "(\\d{1,2}):(\\d{1,2})", new int[] { Calendar.HOUR_OF_DAY, Calendar.MINUTE }, new int[] { 1, 2 } );
            if ( c != null )
            {
                return c;
            }

            c = tryParse ( str, "(\\d{1,2}):(\\d{1,2}):(\\d{1,2})", new int[] { Calendar.HOUR_OF_DAY, Calendar.MINUTE, Calendar.SECOND }, new int[] { 1, 2, 3 } );
            if ( c != null )
            {
                return c;
            }

            c = tryParse ( str, "(\\d{1,2}):(\\d{1,2}):(\\d{1,2})\\.(\\d{1,3})", new int[] { Calendar.HOUR_OF_DAY, Calendar.MINUTE, Calendar.SECOND, Calendar.MILLISECOND }, new int[] { 1, 2, 3, 4 } );
            if ( c != null )
            {
                return c;
            }

            c = tryParse ( str, "(\\d{4})", new int[] { Calendar.YEAR }, new int[] { 1 } );
            if ( c != null )
            {
                return c;
            }

            c = tryParse ( str, "(\\d{4})-(\\d{2})", new int[] { Calendar.YEAR, Calendar.MONTH }, new int[] { 1, 2 } );
            if ( c != null )
            {
                return c;
            }

            c = tryParse ( str, "(\\d{4})-(\\d{2})-(\\d{2})", new int[] { Calendar.YEAR, Calendar.MONTH, Calendar.DAY_OF_MONTH }, new int[] { 1, 2, 3 } );
            if ( c != null )
            {
                return c;
            }

            c = tryParse ( str, "(\\d{4})-(\\d{2})-(\\d{2}) +(\\d{1,2})", new int[] { Calendar.YEAR, Calendar.MONTH, Calendar.DAY_OF_MONTH, Calendar.HOUR_OF_DAY }, new int[] { 1, 2, 3, 4 } );
            if ( c != null )
            {
                return c;
            }

            c = tryParse ( str, "(\\d{4})-(\\d{2})-(\\d{2}) +(\\d{1,2}):(\\d{1,2})", new int[] { Calendar.YEAR, Calendar.MONTH, Calendar.DAY_OF_MONTH, Calendar.HOUR_OF_DAY, Calendar.MINUTE }, new int[] { 1, 2, 3, 4, 5 } );
            if ( c != null )
            {
                return c;
            }

            c = tryParse ( str, "(\\d{4})-(\\d{2})-(\\d{2}) +(\\d{1,2}):(\\d{1,2}):(\\d{1,2})", new int[] { Calendar.YEAR, Calendar.MONTH, Calendar.DAY_OF_MONTH, Calendar.HOUR_OF_DAY, Calendar.MINUTE, Calendar.SECOND }, new int[] { 1, 2, 3, 4, 5, 6 } );
            if ( c != null )
            {
                return c;
            }

            c = tryParse ( str, "(\\d{4})-(\\d{2})-(\\d{2}) +(\\d{1,2}):(\\d{1,2}):(\\d{1,2})\\.(\\d{1,3})", new int[] { Calendar.YEAR, Calendar.MONTH, Calendar.DAY_OF_MONTH, Calendar.HOUR_OF_DAY, Calendar.MINUTE, Calendar.SECOND, Calendar.MILLISECOND }, new int[] { 1, 2, 3, 4, 5, 6, 7 } );
            if ( c != null )
            {
                return c;
            }

            return null;
        }
        catch ( final Exception e )
        {
            return null;
        }
    }

    private Calendar tryParse ( final String str, final String exp, final int[] is, final int[] is2 )
    {
        final Matcher m = Pattern.compile ( exp ).matcher ( str );
        if ( m.matches () )
        {
            final String[] data = new String[is2.length];
            for ( int i = 0; i < is2.length; i++ )
            {
                data[i] = m.group ( is2[i] );
            }
            return makeCalendar ( is, data );
        }
        return null;
    }

    private Calendar makeCalendar ( final int[] is, final String[] strings )
    {
        final Calendar c = Calendar.getInstance ();

        if ( is.length != strings.length )
        {
            throw new IllegalArgumentException ( "Array length is not equal. Internal error." );
        }

        for ( int i = 0; i < is.length; i++ )
        {
            if ( is[i] == Calendar.MONTH )
            {
                c.set ( is[i], Integer.parseInt ( strings[i] ) - 1 );
            }
            else
            {
                c.set ( is[i], Integer.parseInt ( strings[i] ) );
            }
        }
        return c;
    }

    private void setCalendar ( final Calendar c )
    {
        this.time = c;
        if ( c != null )
        {
            this.resultControl.setText ( String.format ( "%tc", c ) );
            // getButton ( OK ).setEnabled ( true );
        }
        else
        {
            this.resultControl.setText ( "<none>" );
            // getButton ( OK ).setEnabled ( false );
        }
    }

    public Calendar getCalendar ()
    {
        return this.time;
    }

    public Date getDate ()
    {
        final Calendar c = getCalendar ();
        if ( c == null )
        {
            return null;
        }
        return c.getTime ();
    }

}
