/*******************************************************************************
 * Copyright (c) 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.component.script;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.script.SimpleScriptContext;

import org.eclipse.scada.ca.ConfigurationDataHelper;
import org.eclipse.scada.utils.osgi.pool.ObjectPoolImpl;
import org.eclipse.scada.utils.script.ScriptExecutor;
import org.eclipse.scada.da.server.common.DataItem;
import org.osgi.framework.BundleContext;

public class ScriptComponent
{
    private final String id;

    private final ScriptContextImpl scriptContext;

    public ScriptComponent ( final Executor executor, final ObjectPoolImpl<DataItem> objectPool, final String configurationId, final BundleContext context, final Map<String, String> parameters ) throws ScriptException, IOException
    {
        this.id = configurationId;

        final ConfigurationDataHelper cfg = new ConfigurationDataHelper ( parameters );

        final String scriptLanguage = cfg.getString ( "scriptLanguage", "JavaScript" );
        final String script = cfg.getStringChecked ( "script", "'script' must be set to an executable script fragment" );

        final ScriptEngineManager scriptEngineManager = new ScriptEngineManager ( Activator.class.getClassLoader () );
        final ScriptEngine scriptEngine = scriptEngineManager.getEngineByName ( scriptLanguage );

        final ScriptExecutor scriptExecutor = new ScriptExecutor ( scriptEngine, script, Activator.class.getClassLoader () );

        this.scriptContext = new ScriptContextImpl ( executor, objectPool, this.id, context, cfg.getPrefixed ( "property." ) );

        final Map<String, Object> objects = new HashMap<String, Object> ( 1 );
        objects.put ( "context", this.scriptContext );

        final ScriptContext scriptContext = new SimpleScriptContext ();

        scriptExecutor.execute ( scriptContext, objects );
    }

    public void dispose ()
    {
        this.scriptContext.dispose ();
    }

}
