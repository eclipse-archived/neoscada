/*******************************************************************************
 * Copyright (c) 2012, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *******************************************************************************/
package org.eclipse.scada.sec.provider.script;

import java.util.Map;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

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

    private final ScriptEngineManager manager;

    private final ClassLoader classLoader;

    private AuthenticationImplementation authenticationImplementation;

    public ScriptAuthorizationProvider ()
    {
        this.classLoader = getClass ().getClassLoader ();

        final ClassLoader currentClassLoader = Thread.currentThread ().getContextClassLoader ();
        try
        {
            Thread.currentThread ().setContextClassLoader ( this.classLoader );
            this.manager = new ScriptEngineManager ( this.classLoader );
        }
        finally
        {
            Thread.currentThread ().setContextClassLoader ( currentClassLoader );
        }
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

    private ScriptExecutor makeScript ( final ScriptEngine engine, final String script ) throws ScriptException
    {
        if ( script == null || script.isEmpty () )
        {
            return null;
        }
        return new ScriptExecutor ( engine, script, this.classLoader );
    }

    private AuthorizationEntry createEntry ( final ConfigurationDataHelper cfg ) throws Exception
    {
        final ScriptEngine scriptEngine = this.manager.getEngineByName ( cfg.getString ( "script.engine", "JavaScript" ) );
        final ScriptEngine callbackScriptEngine = this.manager.getEngineByName ( cfg.getString ( "callbackScript.engine", "JavaScript" ) );

        final ScriptExecutor script = makeScript ( scriptEngine, cfg.getString ( "script" ) );
        final ScriptExecutor callbackScript = makeScript ( callbackScriptEngine, cfg.getString ( "callbackScript" ) );

        return new AuthorizationEntry ( script, callbackScript, this.authenticationImplementation );
    }
}
