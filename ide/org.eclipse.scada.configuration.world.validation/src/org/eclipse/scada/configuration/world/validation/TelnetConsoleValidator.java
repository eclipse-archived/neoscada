/*******************************************************************************
 * Copyright (c) 2015 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.configuration.world.validation;

import org.eclipse.scada.configuration.world.osgi.OsgiPackage;
import org.eclipse.scada.configuration.world.osgi.TelnetConsole;
import org.eclipse.scada.utils.ecore.validation.Severity;
import org.eclipse.scada.utils.ecore.validation.TypedValidator;
import org.eclipse.scada.utils.ecore.validation.ValidationContext;

public class TelnetConsoleValidator extends TypedValidator<TelnetConsole>
{
    private static final int MAX_PORT = 64 * 1024;

    public TelnetConsoleValidator ()
    {
        super ( TelnetConsole.class );
    }

    @Override
    protected void validate ( final TelnetConsole target, final ValidationContext context )
    {
        int port = target.getPort ();

        if ( port < 0 )
        {
            context.add ( OsgiPackage.Literals.TELNET_CONSOLE__PORT, "Port must be a positive integer" );
        }
        else if ( port == 0 )
        {
            context.add ( OsgiPackage.Literals.TELNET_CONSOLE__PORT, Severity.WARNING, "Wildcard ports are not recommended" );
        }
        else if ( port < 1024 )
        {
            context.add ( OsgiPackage.Literals.TELNET_CONSOLE__PORT, Severity.WARNING, "Ports below 1024 are considered privileged for some operating systems and are not recommended" );
        }
        else if ( port < MAX_PORT )
        {
            // ok
        }
        else
        {
            context.add ( OsgiPackage.Literals.TELNET_CONSOLE__PORT, "Port must be lower than {0}", MAX_PORT );
        }

        if ( target.getHost () != null && target.getHost ().isEmpty () )
        {
            context.add ( OsgiPackage.Literals.TELNET_CONSOLE__HOST, Severity.WARNING, "Binding to all interfaces might pose a security risk. Consider binding to 'localhost' instead.", MAX_PORT );
        }
    }
}
