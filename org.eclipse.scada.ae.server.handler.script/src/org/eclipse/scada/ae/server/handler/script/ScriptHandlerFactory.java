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
package org.eclipse.scada.ae.server.handler.script;

import java.util.Map;

import javax.script.ScriptEngine;

import org.eclipse.scada.ae.server.handler.EventHandler;
import org.eclipse.scada.ae.server.handler.EventHandlerFactory;
import org.eclipse.scada.ca.ConfigurationDataHelper;
import org.eclipse.scada.utils.script.ScriptExecutor;
import org.eclipse.scada.utils.script.Scripts;

public class ScriptHandlerFactory implements EventHandlerFactory
{
    private final ClassLoader classLoader;

    private final ScriptEngine engine;

    public ScriptHandlerFactory () throws Exception
    {
        this.classLoader = ScriptHandlerFactory.class.getClassLoader ();
        this.engine = Scripts.createEngine ( "JavaScript", this.classLoader ); //$NON-NLS-1$
    }

    @Override
    public EventHandler createHandler ( final Map<String, String> properties ) throws Exception
    {
        final ConfigurationDataHelper cfg = new ConfigurationDataHelper ( properties );

        final String command = cfg.getStringNonEmptyChecked ( "script", null ); //$NON-NLS-1$
        final ScriptExecutor script = new ScriptExecutor ( this.engine, command, this.classLoader );

        return new ScriptEventHandler ( script );
    }

}
