/*******************************************************************************
 * Copyright (c) 2013 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.configuration.generator.world.oscar.sec;

import java.util.Map;

import org.eclipse.scada.configuration.security.ScriptRule;

public class ScriptRuleEncoder extends RuleEncoder
{

    private final ScriptRule rule;

    public ScriptRuleEncoder ( final ScriptRule rule )
    {
        super ( rule );
        this.rule = rule;
    }

    @Override
    protected void putData ( final Map<String, String> data )
    {
        putScript ( data, "properties.script", this.rule.getScript () );
        putScript ( data, "properties.callbackScript", this.rule.getCallbackScript () );
    }
}
