/*******************************************************************************
 * Copyright (c) 2009, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.client.base.browser;

import org.eclipse.scada.core.NotConvertableException;
import org.eclipse.scada.core.NullValueException;
import org.eclipse.scada.core.Variant;
import org.eclipse.scada.core.VariantType;
import org.eclipse.scada.da.client.connector.Activator;

/**
 * value types used for visual input purposes
 * @author Jens Reimann
 *
 */
public enum ValueType
{
    NULL ( 10, Messages.getString ( "ValueType.NULL.label" ) ) //$NON-NLS-1$
    {
        @Override
        public Variant convertTo ( final String value )
        {
            return Variant.NULL;
        }
    },
    STRING ( 20, Messages.getString ( "ValueType.STRING.label" ) ) //$NON-NLS-1$
    {
        @Override
        public Variant convertTo ( String value )
        {
            value = value.replace ( Activator.NATIVE_LS, "\n" ); //$NON-NLS-1$
            return Variant.valueOf ( value );
        }
    },
    STRING_CRLF ( 21, Messages.getString ( "ValueType.STRING_CRLF.label" ) ) //$NON-NLS-1$
    {
        @Override
        public Variant convertTo ( String value )
        {
            value = value.replace ( Activator.NATIVE_LS, "\r\n" ); //$NON-NLS-1$
            return Variant.valueOf ( value );
        }
    },
    INT ( 30, Messages.getString ( "ValueType.INT.label" ) ) //$NON-NLS-1$
    {
        @Override
        public Variant convertTo ( final String value ) throws NotConvertableException
        {
            final Variant stringValue = Variant.valueOf ( value );
            try
            {
                return Variant.valueOf ( stringValue.asInteger () );
            }
            catch ( final NullValueException e )
            {
                return Variant.NULL;
            }
        }
    },
    LONG ( 40, Messages.getString ( "ValueType.LONG.label" ) ) //$NON-NLS-1$
    {
        @Override
        public Variant convertTo ( final String value ) throws NotConvertableException
        {
            final Variant stringValue = Variant.valueOf ( value );
            try
            {
                return Variant.valueOf ( stringValue.asLong () );
            }
            catch ( final NullValueException e )
            {
                return Variant.NULL;
            }
        }
    },
    DOUBLE ( 50, Messages.getString ( "ValueType.DOUBLE.label" ) ) //$NON-NLS-1$
    {
        @Override
        public Variant convertTo ( final String value ) throws NotConvertableException
        {
            final Variant stringValue = Variant.valueOf ( value );
            try
            {
                return Variant.valueOf ( stringValue.asDouble () );
            }
            catch ( final NullValueException e )
            {
                return Variant.NULL;
            }
        }
    },
    BOOLEAN ( 60, Messages.getString ( "ValueType.BOOLEAN.label" ) ) //$NON-NLS-1$
    {
        @Override
        public Variant convertTo ( final String value ) throws NotConvertableException
        {
            final Variant stringValue = Variant.valueOf ( value );
            return Variant.valueOf ( stringValue.asBoolean () );
        }
    },
    ;

    private int index;

    private String label;

    ValueType ( final int index, final String label )
    {
        this.index = index;
        this.label = label;
    }

    public String label ()
    {
        return this.label;
    }

    public int index ()
    {
        return this.index;
    }

    public abstract Variant convertTo ( String value ) throws NotConvertableException;

    public static ValueType fromVariantType ( final VariantType type )
    {
        switch ( type )
        {
        case BOOLEAN:
            return ValueType.BOOLEAN;
        case DOUBLE:
            return ValueType.DOUBLE;
        case INT32:
            return ValueType.INT;
        case INT64:
            return ValueType.LONG;
        case NULL:
            return ValueType.NULL;
        case STRING:
            return ValueType.STRING;
        default:
            return ValueType.STRING;
        }
    }
}