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

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.scada.configuration.generator.world.oscar.BasicOscarProcessor;
import org.eclipse.scada.configuration.generator.world.oscar.OscarContext;
import org.eclipse.scada.configuration.security.Rule;
import org.eclipse.scada.configuration.security.Rules;
import org.eclipse.scada.configuration.world.osgi.EquinoxApplication;

import com.google.common.collect.Lists;

public class SecurityProcessor extends BasicOscarProcessor
{
    private final EquinoxApplication app;

    public SecurityProcessor ( final EquinoxApplication app, final OscarContext oscarContext )
    {
        super ( app, oscarContext );
        this.app = app;
    }

    public void process ( final IProgressMonitor monitor )
    {
        addSecurityRules ( this.app.getSecurityConfiguration (), monitor );
    }

    public void addSecurityRules ( final Rules rules, final IProgressMonitor monitor )
    {
        if ( rules == null )
        {
            return;
        }

        int priority = 1000;

        monitor.beginTask ( "Encoding security rules", rules.getRules ().size () );

        for ( final Rule rule : Lists.reverse ( rules.getRules () ) )
        {
            final RuleEncoder encoder = RuleEncoder.findEncoder ( rule );
            if ( encoder != null )
            {
                encoder.encodeRule ( this.ctx, priority += 100 );
            }
            monitor.worked ( 1 );
        }

        monitor.done ();
    }
}
