/*******************************************************************************
 * Copyright (c) 2006, 2014 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - further development
 *     IBH SYSTEMS GmbH - cleanups for bug 433409, limit interface for Java 8
 *******************************************************************************/
package org.eclipse.scada.utils.script;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

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
 */
public class ScriptExecutor
{
    private static final String PROP_NAME_DISABLE_COMPILE = "org.eclipse.scada.utils.script.ScriptExecutor.disableCompile";

    private final ScriptEngine engine;

    private final String command;

    private CompiledScript compiledScript;

    private final ClassLoader classLoader;

    private final URL commandUrl;

    private final String sourceName;

    public ScriptExecutor ( final String engineName, final String command, final ClassLoader classLoader ) throws Exception
    {
        this ( engineName, command, classLoader, null );
    }

    public ScriptExecutor ( final String engineName, final String command, final ClassLoader classLoader, final String sourceName ) throws Exception
    {
        this ( Scripts.createManager ( classLoader ), engineName, command, classLoader, sourceName );
    }

    public ScriptExecutor ( final String engineName, final URL commandUrl, final ClassLoader classLoader ) throws Exception
    {
        this ( Scripts.createManager ( classLoader ), engineName, commandUrl, classLoader );
    }

    /**
     * Create a new script executor
     *
     * @param engineManager
     *            the engine manager to use
     * @param engineName
     *            the name of the script engine
     * @param command
     *            the script
     * @param classLoader
     *            the class loader the script should use
     * @throws Exception
     *             if anything goes wrong
     */
    public ScriptExecutor ( final ScriptEngineManager engineManager, final String engineName, final String command, final ClassLoader classLoader ) throws Exception
    {
        this ( Scripts.createEngine ( engineManager, engineName, classLoader ), engineName == null ? null : command, classLoader );
    }

    /**
     * Create a new script executor
     *
     * @param engineManager
     *            the engine manager to use
     * @param engineName
     *            the name of the script engine
     * @param command
     *            the script
     * @param classLoader
     *            the class loader the script should use
     * @param sourceName
     *            the name of the source
     * @throws Exception
     *             if anything goes wrong
     */
    public ScriptExecutor ( final ScriptEngineManager engineManager, final String engineName, final String command, final ClassLoader classLoader, final String sourceName ) throws Exception
    {
        this ( Scripts.createEngine ( engineManager, engineName, classLoader ), engineName == null ? null : command, classLoader, sourceName );
    }

    /**
     * Create a new script executor
     *
     * @param engineManager
     *            the engine manager to use
     * @param engineName
     *            the name of the script engine
     * @param commandUrl
     *            the URL to the script
     * @param classLoader
     *            the class loader the script should use
     * @throws Exception
     *             if anything goes wrong
     */
    public ScriptExecutor ( final ScriptEngineManager engineManager, final String engineName, final URL commandUrl, final ClassLoader classLoader ) throws Exception
    {
        this ( Scripts.createEngine ( engineManager, engineName, classLoader ), engineName == null ? null : commandUrl, classLoader );
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
    public ScriptExecutor ( final ScriptEngine engine, final String command, final ClassLoader classLoader, final String sourceName ) throws Exception
    {
        this.engine = engine;
        this.command = command;
        this.commandUrl = null;
        this.classLoader = classLoader;
        this.sourceName = sourceName;

        if ( command != null && engine instanceof Compilable && !Boolean.getBoolean ( PROP_NAME_DISABLE_COMPILE ) )
        {
            if ( sourceName != null )
            {
                engine.put ( ScriptEngine.FILENAME, sourceName );
            }

            Scripts.executeWithClassLoader ( classLoader, new Callable<Void> () {
                @Override
                public Void call () throws Exception
                {
                    ScriptExecutor.this.compiledScript = ( (Compilable)engine ).compile ( command );
                    return null;
                }
            } );
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
    public ScriptExecutor ( final ScriptEngine engine, final String command, final ClassLoader classLoader ) throws Exception
    {
        this ( engine, command, classLoader, null );
    }

    public ScriptExecutor ( final ScriptEngine engine, final URL commandUrl, final ClassLoader classLoader ) throws Exception
    {
        this.engine = engine;
        this.command = null;
        this.commandUrl = commandUrl;
        this.classLoader = classLoader;
        this.sourceName = commandUrl.toString ();

        if ( commandUrl != null && engine instanceof Compilable && !Boolean.getBoolean ( PROP_NAME_DISABLE_COMPILE ) )
        {
            Scripts.executeWithClassLoader ( classLoader, new Callable<Void> () {

                @Override
                public Void call () throws Exception
                {
                    ScriptExecutor.this.compiledScript = ( (Compilable)engine ).compile ( new InputStreamReader ( commandUrl.openStream () ) );
                    return null;
                }
            } );
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
        if ( this.command == null && this.commandUrl == null && this.compiledScript == null )
        {
            // catch first, since the following reference to "engine" might already be null
            return null;
        }

        Map<String, Object> vars = null;
        try
        {
            if ( this.sourceName != null )
            {
                this.engine.put ( ScriptEngine.FILENAME, this.sourceName );
            }

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

    public Object execute ( final ScriptContext scriptContext ) throws Exception
    {
        return execute ( scriptContext, null );
    }

    public Object execute ( final ScriptContext scriptContext, final Map<String, Object> scriptObjects ) throws Exception
    {
        return Scripts.executeWithClassLoader ( this.classLoader, new Callable<Object> () {

            @Override
            public Object call () throws Exception
            {
                return executeScript ( scriptContext, scriptObjects );
            }
        } );
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
