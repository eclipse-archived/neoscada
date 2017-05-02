/*******************************************************************************
 * Copyright (c) 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.utils.script;

import java.util.concurrent.Callable;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * Helper functions for JSR 223 scripts
 * <p>
 * This is mostly about class loaders. Scripts have at least three class loaders
 * to worry about. The first is the thread context class loader. The second is
 * the class loader used by {@link ScriptEngineManager} to find the
 * implementations of script languages. The third is the class loaders used by
 * the script engine to find additional classes.
 * </p>
 * <p>
 * For Rhino this is all pretty straight forward. The class loaders used by the
 * script is the current thread context class loader. However this was changed
 * with Nashorn. Here the script has a special class loader, used inside the
 * script. This can be set using a non-standard API, however the default value
 * for this class loader is the current thread context class loader during
 * creation of the {@link ScriptEngine} instance.
 * </p>
 */
public final class Scripts
{
    private Scripts ()
    {
    }

    /**
     * Create a new script engine manager
     * <p>
     * <em>Note:</em> The context class loader will be set during the creation
     * of the script engine. However the constructor
     * {@link ScriptEngineManager#ScriptEngineManager(ClassLoader)} with the
     * parameter <code>null</code> will still be used in order to look up the
     * default script languages of the JRE.
     * </p>
     *
     * @param contextClassLoader
     *            the context class loader to use
     * @return a new instanceof a {@link ScriptEngineManager}
     */
    public static ScriptEngineManager createManager ( final ClassLoader contextClassLoader )
    {
        try
        {
            return executeWithClassLoader ( contextClassLoader, new Callable<ScriptEngineManager> () {

                @Override
                public ScriptEngineManager call ()
                {
                    return new ScriptEngineManager ( null );
                }
            } );
        }
        catch ( final Exception e )
        {
            // should never happen
            throw new RuntimeException ( e );
        }
    }

    public static ScriptEngine createEngine ( final String engineName, final ClassLoader scriptClassLoader ) throws Exception
    {
        return createEngine ( createManager ( scriptClassLoader ), engineName, scriptClassLoader );
    }

    public static ScriptEngine createEngine ( final ScriptEngineManager engineManager, final String engineName, final ClassLoader scriptClassLoader ) throws Exception
    {
        if ( engineManager == null )
        {
            throw new IllegalArgumentException ( "Script engine manager must not be null" );
        }

        if ( engineName == null )
        {
            return null;
        }

        final ScriptEngine engine = executeWithClassLoader ( scriptClassLoader, new Callable<ScriptEngine> () {

            @Override
            public ScriptEngine call () throws Exception
            {
                // nashorn will use this current thread context class loader for the script
                return engineManager.getEngineByName ( engineName );
            }
        } );

        if ( engine == null )
        {
            throw new ScriptException ( String.format ( "Script engine '%s' could not be found", engineName ) );
        }

        return engine;
    }

    public static <V> V executeWithClassLoader ( final ClassLoader classLoader, final Callable<V> callable ) throws Exception
    {
        if ( classLoader == null )
        {
            return callable.call ();
        }

        final ClassLoader tcl = Thread.currentThread ().getContextClassLoader ();
        try
        {
            Thread.currentThread ().setContextClassLoader ( classLoader );
            return callable.call ();
        }
        finally
        {
            Thread.currentThread ().setContextClassLoader ( tcl );
        }
    }

}
