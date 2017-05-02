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
public enum Assertion
{

    EQUALITY ( 0 ),
    PRESENCE ( 1 ),
    SUBSTRING ( 2 ),
    GREATEREQ ( 3 ),
    LESSEQ ( 4 ),
    APPROXIMATE ( 6 ),

    LESSTHAN ( 7 ),
    GREATERTHAN ( 8 );

    private final int op;

    Assertion ( final int operator )
    {
        this.op = operator;
    }

    public static Assertion fromValue ( final int op )
    {
        switch ( op )
        {
            case 0:
                return Assertion.EQUALITY;
            case 1:
                return Assertion.PRESENCE;
            case 2:
                return Assertion.SUBSTRING;
            case 3:
                return Assertion.GREATEREQ;
            case 4:
                return Assertion.LESSEQ;
            case 6:
                return Assertion.APPROXIMATE;
            case 7:
                return Assertion.LESSTHAN;
            case 8:
                return Assertion.GREATERTHAN;
        }
        return null;
    }

    public static Assertion fromString ( final String op )
    {
        if ( "=".equals ( op ) ) //$NON-NLS-1$
        {
            return EQUALITY;
        }
        else if ( "=*".equals ( op ) ) //$NON-NLS-1$
        {
            return PRESENCE;
        }
        else if ( ">=".equals ( op ) ) //$NON-NLS-1$
        {
            return GREATEREQ;
        }
        else if ( ">".equals ( op ) ) //$NON-NLS-1$
        {
            return GREATERTHAN;
        }
        else if ( "<=".equals ( op ) ) //$NON-NLS-1$
        {
            return LESSEQ;
        }
        else if ( "<".equals ( op ) ) //$NON-NLS-1$
        {
            return LESSTHAN;
        }
        else if ( "~=".equals ( op ) ) //$NON-NLS-1$
        {
            return APPROXIMATE;
        }
        return null;
    }

    @Override
    public String toString ()
    {
        switch ( this.op )
        {
            case 0:
                return "="; //$NON-NLS-1$
            case 1:
                return "=*"; //$NON-NLS-1$
            case 2:
                return "="; //$NON-NLS-1$
            case 3:
                return ">="; //$NON-NLS-1$
            case 4:
                return "<="; //$NON-NLS-1$
            case 6:
                return "~="; //$NON-NLS-1$
            case 7:
                return "<"; //$NON-NLS-1$
            case 8:
                return ">"; //$NON-NLS-1$
        }
        return null;
    }

    public int toValue ()
    {
        return this.op;
    }
}