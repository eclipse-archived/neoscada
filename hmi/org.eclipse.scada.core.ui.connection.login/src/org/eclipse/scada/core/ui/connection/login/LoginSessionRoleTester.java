/*******************************************************************************
 * Copyright (c) 2011 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.core.ui.connection.login;

import org.eclipse.core.expressions.PropertyTester;

public class LoginSessionRoleTester extends PropertyTester
{

    @Override
    public boolean test ( final Object receiver, final String property, final Object[] args, final Object expectedValue )
    {
        if ( ! ( receiver instanceof LoginSession ) )
        {
            return false;
        }
        if ( "roles".equals ( property ) )
        {
            return checkRoles ( (LoginSession)receiver, args, expectedValue );
        }
        return false;
    }

    private boolean checkRoles ( final LoginSession receiver, final Object[] args, final Object expectedValue )
    {
        final boolean expected = expectedValue == null ? true : expectedValue instanceof Boolean ? (Boolean)expectedValue : Boolean.parseBoolean ( expectedValue.toString () );

        for ( final Object arg : args )
        {
            if ( arg == null )
            {
                continue;
            }

            if ( hasRole ( receiver, arg.toString () ) )
            {
                if ( expected )
                {
                    // we expected the role .. so the test is positive
                    return true;
                }
                else
                {
                    // we expected no role .. so the test is negative
                    return false;
                }
            }
        }

        // no match
        if ( expected )
        {
            // we expected the role .. so the test is negative
            return false;
        }
        else
        {
            // we expected no role .. so the test is positive
            return true;
        }
    }

    private boolean hasRole ( final LoginSession receiver, final String role )
    {
        return receiver.hasRole ( role );
    }

}
