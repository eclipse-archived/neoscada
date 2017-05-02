/*******************************************************************************
 * Copyright (c) 2013 Jens Reimann and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Jens Reimann - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.sec.auth.logon;

import java.util.Map;

import org.eclipse.scada.sec.AuthenticationImplementation;
import org.eclipse.scada.sec.AuthorizationService;
import org.eclipse.scada.sec.authz.AuthorizationRule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @since 1.1
 */
public class LogonAuthorizationService implements AuthorizationService
{
    private final static Logger logger = LoggerFactory.getLogger ( LogonAuthorizationService.class );

    private AuthenticationImplementation authenticator;

    public void setAuthenticator ( final AuthenticationImplementation authenticator )
    {
        logger.info ( "Setting authenticator: {}", authenticator );
        this.authenticator = authenticator;
    }

    @Override
    public AuthorizationRule createRule ( final Map<String, String> properties )
    {
        return new AuthorizationRuleImpl ( this.authenticator );
    }

}
