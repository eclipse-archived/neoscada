/*******************************************************************************
 * Copyright (c) 2006, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - further development
 *******************************************************************************/
package org.eclipse.scada.utils.script;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.script.Compilable;
import javax.script.CompiledScript;
import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * A wrapper to execute scripts
 * 
 * @author Jens Reimann
 * @since 0.17.0
 */
public class ScriptExecutor
{
    private final ScriptEngine engine;

    private final String command;

    private CompiledScript compiledScript;

    private final ClassLoader classLoader;

    private final URL commandUrl;

    private final String sourceName;

    public ScriptExecutor ( final ScriptEngineManager engineManager, final String engineName, final String command, final ClassLoader classLoader ) throws ScriptException
    {
        this ( engineName == null ? null : engineManager.getEngineByName ( engineName ), engineName == null ? null : command, classLoader );
    }

    public ScriptExecutor ( final ScriptEngineManager engineManager, final String engineName, final URL commandUrl, final ClassLoader classLoader ) throws ScriptException, IOException
    {
        this ( engineName == null ? null : engineManager.getEngineByName ( engineName ), engineName == null ? null : commandUrl, classLoader );
    }

    /**
     * Construct a new script executors
     * 
     * @param engine
     *            the script engine to use, must not be <code>null</code>
     * @param command
     *            the command to execute, may be <code>null</code>
     * @param classLoader
     *            the class loader to use when executing, may be
     *            <code>null</code>
     * @throws ScriptException
     */
    public ScriptExecutor ( final ScriptEngine engine, final String command, final ClassLoader classLoader, final String sourceName ) throws ScriptException
    {
        this.engine = engine;
        this.command = command;
        this.commandUrl = null;
        this.classLoader = classLoader;
        this.sourceName = sourceName;

        if ( command != null && engine instanceof Compilable && !Boolean.getBoolean ( "org.eclipse.scada.ScriptExecutor.disableCompile" ) )
        {
            engine.put ( ScriptEngine.FILENAME, sourceName );
            final ClassLoader currentClassLoader = Thread.currentThread ().getContextClassLoader ();
            try
            {
                if ( classLoader != null )
                {
                    Thread.currentThread ().setContextClassLoader ( classLoader );
                }
                this.compiledScript = ( (Compilable)engine ).compile ( command );
            }
            finally
            {
                Thread.currentThread ().setContextClassLoader ( currentClassLoader );
            }
        }
    }

    /**
     * Construct a new script executors
     * 
     * @param engine
     *            the script engine to use, must not be <code>null</code>
     * @param command
     *            the command to execute, may be <code>null</code>
     * @param classLoader
     *            the class loader to use when executing, may be
     *            <code>null</code>
     * @throws ScriptException
     */
    public ScriptExecutor ( final ScriptEngine engine, final String command, final ClassLoader classLoader ) throws ScriptException
    {
        this ( engine, command, classLoader, null );
    }

    public ScriptExecutor ( final ScriptEngine engine, final URL commandUrl, final ClassLoader classLoader ) throws ScriptException, IOException
    {
        this.engine = engine;
        this.command = null;
        this.commandUrl = commandUrl;
        this.classLoader = classLoader;
        this.sourceName = commandUrl.toString ();

        if ( commandUrl != null && engine instanceof Compilable && !Boolean.getBoolean ( "org.eclipse.scada.ScriptExecutor.disableCompile" ) )
        {
            final ClassLoader currentClassLoader = Thread.currentThread ().getContextClassLoader ();
            try
            {
                if ( classLoader != null )
                {
                    Thread.currentThread ().setContextClassLoader ( classLoader );
                }
                this.compiledScript = ( (Compilable)engine ).compile ( new InputStreamReader ( commandUrl.openStream () ) );
            }
            finally
            {
                Thread.currentThread ().setContextClassLoader ( currentClassLoader );
            }
        }
    }

    protected Map<String, Object> applyVars ( final ScriptContext context, final Map<String, Object> scriptObjects )
    {
        if ( scriptObjects == null || scriptObjects.isEmpty () )
        {
            return null;
        }

        final Map<String, Object> replaced = new HashMap<String, Object> ();
        for ( final Map.Entry<String, Object> entry : scriptObjects.entrySet () )
        {
            final Object original = context.getAttribute ( entry.getKey (), ScriptContext.ENGINE_SCOPE );
            replaced.put ( entry.getKey (), original );
            context.setAttribute ( entry.getKey (), entry.getValue (), ScriptContext.ENGINE_SCOPE );
        }
        return replaced;
    }

    protected void restoreVars ( final ScriptContext context, final Map<String, Object> vars )
    {
        if ( vars == null )
        {
            return;
        }

        for ( final Map.Entry<String, Object> entry : vars.entrySet () )
        {
            if ( entry.getValue () == null )
            {
                context.removeAttribute ( entry.getKey (), ScriptContext.ENGINE_SCOPE );
            }
            else
            {
                context.setAttribute ( entry.getKey (), entry.getValue (), ScriptContext.ENGINE_SCOPE );
            }
        }
    }

    private Object executeScript ( final ScriptContext scriptContext, final Map<String, Object> scriptObjects ) throws ScriptException, IOException
    {
        Map<String, Object> vars = null;
        try
        {
            this.engine.put ( ScriptEngine.FILENAME, this.sourceName );

            vars = applyVars ( scriptContext, scriptObjects );

            if ( this.compiledScript != null )
            {
                return this.compiledScript.eval ( scriptContext );
            }
            else if ( this.command != null )
            {
                return this.engine.eval ( this.command, scriptContext );
            }
            else if ( this.commandUrl != null )
            {
                return this.engine.eval ( new InputStreamReader ( this.commandUrl.openStream () ) );
            }
            else
            {
                return null;
            }
        }
        finally
        {
            restoreVars ( scriptContext, vars );
        }
    }

    public Object execute ( final ScriptContext scriptContext ) throws ScriptException, IOException
    {
        return execute ( scriptContext, null );
    }

    public Object execute ( final ScriptContext scriptContext, final Map<String, Object> scriptObjects ) throws ScriptException, IOException
    {
        final ClassLoader currentClassLoader = Thread.currentThread ().getContextClassLoader ();
        try
        {
            if ( this.classLoader != null )
            {
                Thread.currentThread ().setContextClassLoader ( this.classLoader );
            }
            return executeScript ( scriptContext, scriptObjects );
        }
        finally
        {
            Thread.currentThread ().setContextClassLoader ( currentClassLoader );
        }
    }

    @Override
    public String toString ()
    {
        if ( this.compiledScript != null )
        {
            return this.compiledScript.toString ();
        }
        else
        {
            return this.command;
        }
    }
}
