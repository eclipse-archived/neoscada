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
import javax.script.ScriptException;
import javax.script.SimpleScriptContext;

import org.junit.Assert;
import org.junit.Test;

public class ScriptExecutorTest
{

    @Test
    public void testSimpleJS () throws Exception
    {
        final ScriptEngineManager manager = new ScriptEngineManager ();
        final ScriptExecutor script = new ScriptExecutor ( manager, "JavaScript", "true;", ScriptExecutorTest.class.getClassLoader () );
        final SimpleScriptContext ctx = new SimpleScriptContext ();
        final Object result = script.execute ( ctx );

        Assert.assertEquals ( true, result );
    }

    @Test ( expected = ScriptException.class )
    public void testNonExLanguage () throws Exception
    {
        final ScriptEngineManager manager = new ScriptEngineManager ();
        final ScriptExecutor script = new ScriptExecutor ( manager, "WTF-123", "true;", ScriptExecutorTest.class.getClassLoader () );
        final SimpleScriptContext ctx = new SimpleScriptContext ();
        final Object result = script.execute ( ctx );

        Assert.assertEquals ( true, result );
    }
}
