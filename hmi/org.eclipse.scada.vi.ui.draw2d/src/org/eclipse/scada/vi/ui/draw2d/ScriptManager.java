/*******************************************************************************
 * Copyright (c) 2016 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.vi.ui.draw2d;

import javax.script.ScriptEngine;

import org.eclipse.scada.utils.script.ScriptExecutor;
import org.eclipse.scada.utils.script.Scripts;

public class ScriptManager
{
    private final ClassLoader classLoader;

    private final ScriptEngine scriptEngine;

    public ScriptManager () throws Exception
    {
        this.classLoader = Activator.class.getClassLoader ();
        this.scriptEngine = Scripts.createEngine ( "JavaScript", this.classLoader );
    }

    public ScriptExecutor parse ( final String script, final String scriptName ) throws Exception
    {
        if ( script == null || script.isEmpty () )
        {
            return null;
        }

        return new ScriptExecutor ( this.scriptEngine, script, this.classLoader, scriptName );
    }
}
