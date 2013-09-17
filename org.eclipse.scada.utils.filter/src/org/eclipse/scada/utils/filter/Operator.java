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

/**
 * @author jrose
 */
public enum Operator
{
    OR ( 9 ),
    AND ( 10 ),
    NOT ( 11 );

    private final int op;

    Operator ( final int operator )
    {
        this.op = operator;
    }

    public static Operator fromValue ( final int op )
    {
        switch ( op )
        {
            case 9:
                return Operator.OR;
            case 10:
                return Operator.AND;
            case 11:
                return Operator.NOT;
        }
        return null;
    }

    @Override
    public String toString ()
    {
        switch ( this.op )
        {
            case 9:
                return "|"; //$NON-NLS-1$
            case 10:
                return "&"; //$NON-NLS-1$
            case 11:
                return "!"; //$NON-NLS-1$
        }
        return null;
    }

    public int toValue ()
    {
        return this.op;
    }
}
