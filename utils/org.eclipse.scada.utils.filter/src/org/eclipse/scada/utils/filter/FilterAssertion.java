/*******************************************************************************
 * Copyright (c) 2006, 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.utils.filter;

import java.util.Collection;

import org.eclipse.scada.utils.filter.internal.Encoder;

public class FilterAssertion implements Filter
{
    private String attribute;

    private Assertion assertion;

    private Object value;

    public FilterAssertion ( final String attribute, final Assertion assertion, final Object value )
    {
        this.attribute = attribute;
        this.assertion = assertion;
        this.value = value;
    }

    public String getAttribute ()
    {
        return this.attribute;
    }

    public void setAttribute ( final String attribute )
    {
        this.attribute = attribute;
    }

    public Assertion getAssertion ()
    {
        return this.assertion;
    }

    public void setAssertion ( final Assertion assertion )
    {
        this.assertion = assertion;
    }

    public Object getValue ()
    {
        return this.value;
    }

    public void setValue ( final Object value )
    {
        this.value = value;
    }

    @Override
    public String toString ()
    {
        return "(" + this.attribute + this.assertion.toString () + nullSafeToString ( this.value ) + ")"; //$NON-NLS-1$ //$NON-NLS-2$
    }

    @Override
    public boolean isAssertion ()
    {
        return true;
    }

    @Override
    public boolean isExpression ()
    {
        return false;
    }

    @Override
    public boolean isEmpty ()
    {
        return this.assertion == null;
    }

    private String nullSafeToString ( final Object value )
    {
        if ( value == null )
        {
            return ""; //$NON-NLS-1$
        }
        else if ( value instanceof Collection<?> )
        {
            final Object[] valueList = ( (Collection<?>)value ).toArray ();
            return stringFromArray ( valueList );
        }
        else if ( value instanceof String[] )
        {
            // I am not sure if we really need that, multi values should
            // be provided in collections
            final Object[] valueList = (String[])value;
            return stringFromArray ( valueList );
        }
        else
        {
            return Encoder.encode ( value.toString () );
        }
    }

    private String stringFromArray ( final Object[] valueList )
    {
        final StringBuilder sb = new StringBuilder ();
        int i = 0;
        for ( final Object part : valueList )
        {
            if ( i > 0 && i < valueList.length )
            {
                sb.append ( "*" ); //$NON-NLS-1$
            }
            sb.append ( part == null ? "" : Encoder.encode ( part.toString () ) ); //$NON-NLS-1$
            i += 1;
        }
        return sb.toString ();
    }
}
