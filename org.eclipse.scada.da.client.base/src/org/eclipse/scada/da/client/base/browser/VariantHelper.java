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

import org.eclipse.scada.core.Variant;

public class VariantHelper
{
    protected static String toString ( final Variant variant )
    {
        final ValueType vt = toValueType ( variant );
        try
        {
            if ( vt == null )
            {
                return "VT_UNKNOWN"; //$NON-NLS-1$
            }

            final StringBuffer str = new StringBuffer ();
            str.append ( vt.toString () );
            str.append ( "[" ); //$NON-NLS-1$
            switch ( vt )
            {
                case NULL:
                    str.append ( "<null>" ); //$NON-NLS-1$
                    break;
                case BOOLEAN:
                    str.append ( variant.asBoolean () ? "true" : "false" ); //$NON-NLS-1$ //$NON-NLS-2$
                    break;
                case DOUBLE:
                    str.append ( variant.asDouble () );
                    break;
                case LONG:
                    str.append ( variant.asLong () );
                    break;
                case INT:
                    str.append ( variant.asInteger () );
                    break;
                case STRING:
                    str.append ( variant.asString () );
                    break;
                case STRING_CRLF:
                    str.append ( variant.asString () );
                    break;
            }
            str.append ( "]" ); //$NON-NLS-1$
            return str.toString ();
        }
        catch ( final Exception e )
        {
            return "VT_ERROR[" + e.getMessage () + "]"; //$NON-NLS-1$ //$NON-NLS-2$
        }
    }

    public static ValueType toValueType ( final Variant variant )
    {
        if ( variant.isNull () )
        {
            return ValueType.NULL;
        }
        else if ( variant.isBoolean () )
        {
            return ValueType.BOOLEAN;
        }
        else if ( variant.isDouble () )
        {
            return ValueType.DOUBLE;
        }
        else if ( variant.isLong () )
        {
            return ValueType.LONG;
        }
        else if ( variant.isInteger () )
        {
            return ValueType.INT;
        }
        else if ( variant.isString () )
        {
            return ValueType.STRING;
        }
        else
        {
            return null;
        }
    }

}
