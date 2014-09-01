/*******************************************************************************
 * Copyright (c) 2010, 2011 TH4 SYSTEMS GmbH and others.
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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginSessionPropertyTester extends PropertyTester
{
    private final static Logger logger = LoggerFactory.getLogger ( LoginSessionPropertyTester.class );

    @Override
    public boolean test ( final Object receiver, final String property, final Object[] args, final Object expectedValue )
    {
        logger.debug ( "Testing - receiver: {}, property: {}, args: {}, expectedValue: {}", receiver, property, args, expectedValue );

        if ( ! ( receiver instanceof LoginSession ) )
        {
            logger.debug ( "Receiver is not of type {}", LoginSession.class );
            return false;
        }

        boolean result = false;
        if ( "properties".equals ( property ) )
        {
            result = checkProperties ( (LoginSession)receiver, args, expectedValue );
        }

        logger.debug ( "result = {}", result );
        return result;
    }

    private boolean checkProperties ( final LoginSession receiver, final Object[] args, final Object expectedValue )
    {
        if ( args.length != 1 )
        {
            return false;
        }
        if ( args[0] == null )
        {
            return false;
        }

        final String propertyName = args[0].toString ();

        final String value = receiver.getLoginContext ().getProperties ().get ( propertyName );
        if ( value == null && expectedValue == null )
        {
            return true;
        }
        if ( value == null )
        {
            return false;
        }

        return value.equals ( expectedValue.toString () );
    }

}
