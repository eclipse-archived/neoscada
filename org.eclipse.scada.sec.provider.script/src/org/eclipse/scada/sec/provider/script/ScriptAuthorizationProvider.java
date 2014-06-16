/*******************************************************************************
 * Copyright (c) 2012, 2014 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *     IBH SYSTEMS GmbH - fix bug 433409, fix bug 437536
 *******************************************************************************/
package org.eclipse.scada.sec.provider.script;

import java.util.Map;

import org.eclipse.scada.ca.ConfigurationDataHelper;
import org.eclipse.scada.sec.AuthenticationImplementation;
import org.eclipse.scada.sec.AuthorizationService;
import org.eclipse.scada.sec.authz.AuthorizationRule;
import org.eclipse.scada.utils.script.ScriptExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ScriptAuthorizationProvider implements AuthorizationService
{

    private final static Logger logger = LoggerFactory.getLogger ( ScriptAuthorizationProvider.class );

    private final ClassLoader classLoader;

    private AuthenticationImplementation authenticationImplementation;

    public ScriptAuthorizationProvider ()
    {
        this.classLoader = getClass ().getClassLoader ();
    }

    public void setAuthenticationImplementation ( final AuthenticationImplementation authenticationImplementation )
    {
        this.authenticationImplementation = authenticationImplementation;
    }

    @Override
    public AuthorizationRule createRule ( final Map<String, String> properties ) throws Exception
    {
        logger.debug ( "Creating rule - {}", properties );

        return createEntry ( new ConfigurationDataHelper ( properties ) );
    }

    private ScriptExecutor makeScript ( final String engine, final String script ) throws Exception
    {
        if ( script == null || script.isEmpty () )
        {
            return null;
        }
        return new ScriptExecutor ( engine, script, this.classLoader );
    }

    private AuthorizationEntry createEntry ( final ConfigurationDataHelper cfg ) throws Exception
    {
        final ScriptExecutor script = makeScript ( cfg.getString ( "script.engine", "JavaScript" ), cfg.getString ( "script" ) );
        final ScriptExecutor callbackScript = makeScript ( cfg.getString ( "callbackScript.engine", "JavaScript" ), cfg.getString ( "callbackScript" ) );

        return new AuthorizationEntry ( script, callbackScript, this.authenticationImplementation );
    }
}
