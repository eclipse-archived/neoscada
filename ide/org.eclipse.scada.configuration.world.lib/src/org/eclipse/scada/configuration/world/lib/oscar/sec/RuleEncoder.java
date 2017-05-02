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
package org.eclipse.scada.configuration.world.lib.oscar.sec;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.scada.configuration.security.Rule;
import org.eclipse.scada.configuration.security.Script;
import org.eclipse.scada.configuration.security.ScriptRule;
import org.eclipse.scada.configuration.security.SignatureRule;
import org.eclipse.scada.configuration.world.lib.oscar.OscarContext;

public class RuleEncoder
{
    public static final String ID = "org.eclipse.scada.sec.osgi.manager";

    public static RuleEncoder findEncoder ( final Rule rule )
    {
        if ( rule instanceof ScriptRule )
        {
            return new ScriptRuleEncoder ( (ScriptRule)rule );
        }
        else if ( rule instanceof SignatureRule )
        {
            return new SigatureRuleEncoder ( (SignatureRule)rule );
        }
        return new RuleEncoder ( rule );
    }

    private final Rule rule;

    public RuleEncoder ( final Rule rule )
    {
        this.rule = rule;
    }

    public void encodeRule ( final OscarContext target, final int priority )
    {
        final Map<String, String> data = new HashMap<String, String> ();

        data.put ( "serviceType", this.rule.getRuleType () );
        data.put ( "priority", "" + priority );

        if ( this.rule.getIdFilter () != null )
        {
            data.put ( "for.id", "" + this.rule.getIdFilter () );
        }
        if ( this.rule.getTypeFilter () != null )
        {
            data.put ( "for.type", "" + this.rule.getTypeFilter () );
        }
        if ( this.rule.getActionFilter () != null )
        {
            data.put ( "for.action", "" + this.rule.getActionFilter () );
        }
        putScript ( data, "filter.script", this.rule.getFilterScript () );

        putData ( data );

        target.addData ( ID, this.rule.getId (), data );
    }

    protected void putData ( final Map<String, String> data )
    {
    }

    public static void putScript ( final Map<String, String> data, final String prefix, final Script script )
    {
        if ( script == null )
        {
            return;
        }

        if ( script.getSource () == null )
        {
            throw new NullPointerException ( "'script' must not be null" ); //$NON-NLS-1$
        }

        data.put ( prefix, script.getSource () );
        if ( script.getType () != null )
        {
            data.put ( prefix + ".engine", script.getType () );
        }
    }
}
