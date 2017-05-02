/*******************************************************************************
 * Copyright (c) 2009, 2010 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.server.exec.command;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ProcessConfiguration
{
    private String exec = "";

    private String[] arguments = new String[] {};

    private Map<String, String> environment;

    public ProcessConfiguration ( final String exec, final String[] arguments, final Map<String, String> environment )
    {
        this.exec = exec;
        this.arguments = arguments;
        this.environment = environment;
    }

    public Map<String, String> getEnvironment ()
    {
        return this.environment;
    }

    public void setEnvironment ( final Map<String, String> environment )
    {
        this.environment = environment;
    }

    public String getExec ()
    {
        return this.exec;
    }

    public void setExec ( final String exec )
    {
        this.exec = exec;
    }

    public String[] getArguments ()
    {
        return this.arguments;
    }

    public void setArguments ( final String[] arguments )
    {
        this.arguments = arguments;
    }

    public ProcessBuilder asProcessBuilder ()
    {
        final List<String> args = new ArrayList<String> ();
        args.add ( this.exec );
        args.addAll ( Arrays.asList ( this.arguments ) );

        final ProcessBuilder builder = new ProcessBuilder ( args );

        if ( this.environment != null )
        {
            // setting enviroment
            final Map<String, String> env = builder.environment ();
            for ( final Map.Entry<String, String> entry : this.environment.entrySet () )
            {
                if ( entry.getValue () == null )
                {
                    env.remove ( entry.getKey () );
                }
                else
                {
                    env.put ( entry.getKey (), entry.getValue () );
                }
            }
        }

        return builder;
    }
}
