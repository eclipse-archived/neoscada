/*******************************************************************************
 * Copyright (c) 2012, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.vi.details.swt.widgets;

import java.text.ParseException;
import java.util.Map;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.scada.core.NotConvertableException;
import org.eclipse.scada.core.NullValueException;
import org.eclipse.scada.core.Variant;
import org.eclipse.scada.da.client.DataItemValue;
import org.eclipse.scada.vi.data.DataValue;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class WriteableComposite extends ReadableComposite
{
    private static final Logger logger = LoggerFactory.getLogger ( WriteableComposite.class );

    private Double ceil;

    private Double floor;

    public WriteableComposite ( final Composite parent, final int style, final String format, final String decimal, final boolean isText, final Double ceil, final Double floor, final String attribute, final String hdConnectionId, final String hdItemId )
    {
        super ( parent, style, format, decimal, isText, attribute );
        this.ceil = ceil;
        this.floor = floor;
    }

    protected void addDefaultKeyListener ( final Text text )
    {
        text.addKeyListener ( new KeyListener () {
            @Override
            public void keyReleased ( final KeyEvent arg0 )
            {
            }

            @Override
            public void keyPressed ( final KeyEvent arg0 )
            {
                if ( ( arg0.keyCode == SWT.KEYPAD_CR ) || ( arg0.keyCode == SWT.CR ) )
                {
                    if ( isValidInput ( text.getText () ) )
                    {
                        triggerCommand ();
                    }
                    else
                    {
                        makeWarnDialog ();
                    }

                }
            }

        } );
    }

    protected abstract void triggerCommand ();

    protected void makeWarnDialog ()
    {
        final Shell shell = PlatformUI.getWorkbench ().getActiveWorkbenchWindow ().getShell ();
        MessageDialog.openInformation ( shell, Messages.WriteableComposite_wrongInput, String.format ( Messages.WriteableComposite_requiredInput, this.ceil, this.floor ) );
    }

    protected boolean isValidInput ( final String text )
    {
        if ( this.isText )
        {
            return true;
        }
        boolean ret = false;

        if ( ( this.ceil == null ) && ( this.floor == null ) )
        {
            return true;
        }
        else if ( ( this.ceil != null ) && ( this.floor == null ) )
        {
            this.floor = Double.MIN_VALUE;
        }
        else if ( ( this.ceil == null ) && ( this.floor != null ) )
        {
            this.ceil = Double.MAX_VALUE;
        }

        try
        {
            final Double d = parseDecimal ( text ); //$NON-NLS-1$ //$NON-NLS-2$
            if ( ( d >= this.floor ) && ( d <= this.ceil ) )
            {
                ret = true;
            }
        }
        catch ( final NumberFormatException e )
        {
            logger.warn ( Messages.WriteableComposite_invalidInput + text );
        }
        catch ( final ParseException e )
        {
            logger.warn ( Messages.WriteableComposite_invalidInput + text );
        }
        return ret;
    }

    protected void setCeil ( final DataItemValue value )
    {
        try
        {
            if ( value.isAttribute ( "remote.level.ceil.preset" ) != null ) //$NON-NLS-1$
            {
                this.ceil = value.getAttributes ().get ( "remote.level.ceil.preset" ).asDouble (); //$NON-NLS-1$
            }
            else
            {
                this.ceil = value.getAttributes ().get ( "org.eclipse.scada.da.level.ceil.preset" ).asDouble (); //$NON-NLS-1$
            }
            logger.info ( "Ceil set successfully: {}", this.ceil ); //$NON-NLS-1$
        }
        catch ( final NullValueException e )
        {
            logger.info ( "Could not set ceil" ); //$NON-NLS-1$
        }
        catch ( final NotConvertableException e )
        {
            logger.info ( "Could not set ceil" ); //$NON-NLS-1$
        }
        catch ( final NullPointerException e )
        {
            logger.info ( "Could not set ceil" ); //$NON-NLS-1$
        }
    }

    protected void setFloor ( final DataItemValue value )
    {
        try
        {
            if ( value.isAttribute ( "remote.level.floor.preset" ) != null ) //$NON-NLS-1$
            {
                this.floor = value.getAttributes ().get ( "remote.level.floor.preset" ).asDouble (); //$NON-NLS-1$
            }
            else
            {
                this.floor = value.getAttributes ().get ( "org.eclipse.scada.da.level.floor.preset" ).asDouble (); //$NON-NLS-1$
            }
            logger.info ( "Floor set successfully: {}", this.floor ); //$NON-NLS-1$
        }
        catch ( final NullValueException e )
        {
            logger.info ( "Could not set floor" ); //$NON-NLS-1$
        }
        catch ( final NotConvertableException e )
        {
            logger.info ( "Could not set floor" ); //$NON-NLS-1$
        }
        catch ( final NullPointerException e )
        {
            logger.info ( "Could not set floor" ); //$NON-NLS-1$
        }
    }

    protected void setText ( final Text text, final Map<String, DataValue> values, final String attribute )
    {
        Variant value;

        if ( attribute == null )
        {
            try
            {
                value = values.get ( "value" ).getValue ().getValue (); //$NON-NLS-1$

            }
            catch ( final NullPointerException e )
            {
                logger.info ( "could not get value", e ); //$NON-NLS-1$
                value = Variant.NULL;
            }
        }
        else
        {
            try
            {
                value = values.get ( "value" ).getValue ().getAttributes ().get ( attribute ); //$NON-NLS-1$
            }
            catch ( final NullPointerException e )
            {
                logger.info ( "could not get value", e ); //$NON-NLS-1$
                value = Variant.NULL;
            }
        }

        text.setText ( value != null ? value.asString ( ( getNullReplacementValue () == null ? "" : getNullReplacementValue () ) ) : ( getNullReplacementValue () == null ? "" : getNullReplacementValue () ) ); //$NON-NLS-1$ //$NON-NLS-2$
    }

    protected void setTextDecimal ( final Text text, final DataItemValue value )
    {
        if ( value == null )
        {
            text.setText ( getNullReplacementValue () == null ? "" : getNullReplacementValue () ); //$NON-NLS-1$
            return;
        }
        if ( value.getValue ().isNull () )
        {
            text.setText ( getNullReplacementValue () == null ? "" : getNullReplacementValue () ); //$NON-NLS-1$
            return;
        }

        try
        {
            if ( this.decimalFormat == null )
            {
                text.setText ( value.getValue ().asString () );
            }
            else
            {
                try
                {
                    text.setText ( this.decimalFormat.format ( value.getValue ().asDouble () ) );
                }
                catch ( final NotConvertableException e )
                {
                    text.setText ( "?" ); //$NON-NLS-1$
                    logger.error ( "Could not convert and show double value: {}", e ); //$NON-NLS-1$
                }
            }
        }
        catch ( final NullValueException e )
        {
            text.setText ( getNullReplacementValue () == null ? "" : getNullReplacementValue () ); //$NON-NLS-1$
            logger.info ( "No valid data to show value" ); //$NON-NLS-1$
        }
    }

    protected String getFormattedText ( final Map<String, DataValue> values, final String attribute )
    {
        if ( this.isText )
        {
            return getText ( values, attribute );
        }
        else
        {
            return getTextDecimal ( values, attribute );
        }
    }

    protected Double parseDecimal ( final String text ) throws ParseException
    {
        return this.decimalFormat.parse ( text ).doubleValue ();
    }
}
