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

import javax.script.ScriptEngineManager;

/**
 * Helper functions for JSR 223 scripts
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
     * {@link ScriptEngineManager#ScriptEngineManager()} will still be used in
     * order to look up the default script languages of the JRE.
     * </p>
     * 
     * @param contextClassLoader
     *            the context class loader to use
     * @return a new instanceof a {@link ScriptEngineManager}
     */
    public static ScriptEngineManager createManager ( final ClassLoader contextClassLoader )
    {
        final ClassLoader ctx = Thread.currentThread ().getContextClassLoader ();
        try
        {
            Thread.currentThread ().setContextClassLoader ( contextClassLoader );
            return new ScriptEngineManager ();
        }
        finally
        {
            Thread.currentThread ().setContextClassLoader ( ctx );
        }
    }
}
