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

import java.text.DecimalFormat;
import java.util.Date;
import java.util.Map;

import org.eclipse.scada.core.NotConvertableException;
import org.eclipse.scada.core.NullValueException;
import org.eclipse.scada.core.Variant;
import org.eclipse.scada.da.client.DataItemValue;
import org.eclipse.scada.vi.data.DataValue;
import org.eclipse.swt.widgets.Composite;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class ReadableComposite extends GenericComposite
{
    private static final Logger logger = LoggerFactory.getLogger ( ReadableComposite.class );

    protected final DecimalFormat decimalFormat;

    protected final boolean isText;

    private final String attribute;

    private String nullReplacementValue = null;

    public ReadableComposite ( final Composite parent, final int style, final String format, final String decimal, final boolean isText, final String attribute )
    {
        super ( parent, style, null, null );

        this.attribute = attribute;
        this.isText = isText;
        if ( ( decimal == null ) && !isText )
        {
            this.decimalFormat = new DecimalFormat ( "0.0" ); //$NON-NLS-1$
        }
        else if ( ( decimal != null ) && !isText )
        {
            this.decimalFormat = new DecimalFormat ( decimal );
        }
        else
        {
            this.decimalFormat = null;
        }
    }

    protected String getText ( final Map<String, DataValue> values, final String attribute )
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
                logger.info ( "could not get attribute", e ); //$NON-NLS-1$
                value = Variant.NULL;
            }
        }

        String ret;
        try
        {
            ret = value.asString ();
        }
        catch ( final NullValueException e )
        {
            ret = nullReplacementValue == null ? "null" : nullReplacementValue; //$NON-NLS-1$
        }
        catch ( final NullPointerException e )
        {
            ret = nullReplacementValue == null ? "null" : nullReplacementValue; //$NON-NLS-1$
        }
        return ret;
    }

    protected String getDateAsString ( final Map<String, DataValue> values, final String attribute )
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
                ;
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
                logger.info ( "could not get attribute", e ); //$NON-NLS-1$
                value = Variant.NULL;
                ;
            }
        }

        Date date;
        try
        {
            date = new Date ( value.asLong () );
        }
        catch ( final NullValueException e )
        {
            date = new Date ( 0 );
            logger.error ( "value is null. can't convert to date: ", e ); //$NON-NLS-1$
        }
        catch ( final NotConvertableException e )
        {
            date = new Date ( 0 );
            logger.error ( "could not convert value to date: ", e ); //$NON-NLS-1$
        }
        return date.toString ();
    }

    protected String getTextDecimal ( final Map<String, DataValue> values, final String attribute )
    {
        return getTextDecimal ( values.get ( "value" ).getValue (), attribute );
    }

    protected String getTextDecimal ( final DataItemValue value, final String attribute )
    {
        return getTextDecimal ( value, attribute, 1.0 );
    }

    protected String getTextDecimal ( final DataItemValue value, final String attribute, final double factor )
    {
        Variant var;

        if ( attribute == null )
        {
            try
            {
                var = value.getValue ();
            }
            catch ( final NullPointerException e )
            {
                logger.info ( "could not get value", e ); //$NON-NLS-1$
                var = Variant.NULL;
            }
        }
        else
        {
            try
            {
                var = value.getAttributes ().get ( attribute );
                if ( var == null )
                {
                    //var may be null, if no manual value has been set
                    logger.info ( "no attribute" ); //$NON-NLS-1$
                    var = Variant.NULL;
                }
            }
            catch ( final NullPointerException e )
            {
                logger.info ( "could not get attribute", e ); //$NON-NLS-1$
                var = Variant.NULL;
            }
        }

        if ( value == null )
        {
            return nullReplacementValue == null ? "null" : nullReplacementValue; //$NON-NLS-1$
        }

        String ret;
        try
        {
            if ( this.decimalFormat == null )
            {
                ret = var.asString ();
            }
            else
            {
                try
                {
                    ret = this.decimalFormat.format ( var.asDouble () * factor );
                }
                catch ( final NotConvertableException e )
                {
                    ret = "?"; //$NON-NLS-1$
                    logger.error ( "Could not convert and show double value: {}", e ); //$NON-NLS-1$
                }
            }
        }
        catch ( final NullValueException e )
        {
            ret = nullReplacementValue == null ? "null" : nullReplacementValue; //$NON-NLS-1$
            logger.info ( "No valid data to show value" ); //$NON-NLS-1$
        }

        return ret;
    }

    protected String getAttribute ()
    {
        return this.attribute;
    }

    public void setNullReplacementValue ( String nullReplacementValue )
    {
        this.nullReplacementValue = nullReplacementValue;
    }

    public String getNullReplacementValue ()
    {
        return nullReplacementValue;
    }
}
