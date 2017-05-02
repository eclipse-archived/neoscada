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
package org.eclipse.scada.configuration.world.lib.deployment;

import org.eclipse.scada.configuration.world.lib.deployment.startup.StartupHandler;

public class ScriptMaker
{
    private final StartupHandler handler;

    public ScriptMaker ( final StartupHandler handler )
    {
        this.handler = handler;
    }

    public String makePreInst ()
    {
        if ( this.handler == null )
        {
            return "";
        }

        return make ( this.handler.preinstCommands () );
    }

    public String makePostInst ()
    {
        if ( this.handler == null )
        {
            return "";
        }

        return make ( this.handler.postinstCommands () );
    }

    public String makePreRem ()
    {
        if ( this.handler == null )
        {
            return "";
        }

        return make ( this.handler.preremCommands () );
    }

    public String makePostRem ()
    {
        if ( this.handler == null )
        {
            return "";
        }

        return make ( this.handler.postremCommands () );
    }

    private String make ( final String[] commands )
    {
        final StringBuilder sb = new StringBuilder ( "\n" );

        append ( sb, commands );

        sb.append ( "\n" );

        return sb.toString ();
    }

    public void appendStopDriver ( final StringBuilder sb, final String driver )
    {
        if ( this.handler == null )
        {
            return;
        }

        append ( sb, this.handler.stopDriverCommand ( driver ) );
    }

    public void appendStartDriver ( final StringBuilder sb, final String driver )
    {
        if ( this.handler == null )
        {
            return;
        }

        append ( sb, this.handler.startDriverCommand ( driver ) );
    }

    public void appendStopApp ( final StringBuilder sb, final String driver )
    {
        if ( this.handler == null )
        {
            return;
        }

        append ( sb, this.handler.stopEquinoxCommand ( driver ) );
    }

    public void appendStartApp ( final StringBuilder sb, final String driver )
    {
        if ( this.handler == null )
        {
            return;
        }

        append ( sb, this.handler.startEquinoxCommand ( driver ) );
    }

    private void append ( final StringBuilder sb, final String[] commands )
    {
        if ( commands == null )
        {
            return;
        }

        for ( String command : commands )
        {
            if ( command == null )
            {
                continue;
            }

            command = command.trim ();

            if ( command.isEmpty () )
            {
                continue;
            }

            sb.append ( command ).append ( " || true\n" );
        }
    }
}
