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

import java.util.ArrayList;
import java.util.List;

public class FilterExpression implements Filter
{

    private Operator operator;

    private final List<Filter> filterSet = new ArrayList<Filter> ();

    @Override
    public String toString ()
    {
        final StringBuilder result = new StringBuilder ();
        if ( this.operator == null )
        {
            for ( final Filter filter : this.filterSet )
            {
                result.append ( filter.toString () );
            }
        }
        else
        {
            result.append ( "(" ); //$NON-NLS-1$
            result.append ( this.operator.toString () );
            for ( final Filter filter : this.filterSet )
            {
                result.append ( filter.toString () );
            }
            result.append ( ")" ); //$NON-NLS-1$
        }
        return result.toString ();
    }

    public List<Filter> getFilterSet ()
    {
        return this.filterSet;
    }

    public Operator getOperator ()
    {
        return this.operator;
    }

    public void setOperator ( final Operator operator )
    {
        this.operator = operator;
    }

    @Override
    public boolean isAssertion ()
    {
        return false;
    }

    @Override
    public boolean isExpression ()
    {
        return true;
    }

    @Override
    public boolean isEmpty ()
    {
        return this.operator == null;
    }

    public static FilterExpression negate ( final Filter expression )
    {
        final FilterExpression negation = new FilterExpression ();
        negation.setOperator ( Operator.NOT );
        negation.getFilterSet ().add ( expression );
        return negation;
    }
}
