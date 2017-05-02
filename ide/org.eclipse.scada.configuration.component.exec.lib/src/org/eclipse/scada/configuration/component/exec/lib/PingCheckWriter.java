/*******************************************************************************
 * Copyright (c) 2013, 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.configuration.component.exec.lib;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.scada.configuration.component.exec.PingCheckConfiguration;
import org.eclipse.scada.configuration.generator.GeneratorContext;
import org.eclipse.scada.da.exec.configuration.ConfigurationFactory;
import org.eclipse.scada.da.exec.configuration.EnvEntryType;
import org.eclipse.scada.da.exec.configuration.HiveProcessCommandType;
import org.eclipse.scada.da.exec.configuration.ProcessType;
import org.eclipse.scada.da.exec.configuration.RootType;

class PingCheckWriter
{
    private static final String ATTR_PING_CHECK_WRITER = "pingCheckWriter";

    private final Map<String, String> hostnameMap = new HashMap<String, String> ();

    private final RootType root;

    private final PingCheckConfiguration cfg;

    public PingCheckWriter ( final PingCheckConfiguration cfg, final RootType root )
    {
        this.cfg = cfg;
        this.root = root;
    }

    public void addEntry ( final String hostname, final String alias )
    {
        this.hostnameMap.put ( alias, hostname );
    }

    public void finish ()
    {
        final HiveProcessCommandType cmd = ConfigurationFactory.eINSTANCE.createHiveProcessCommandType ();
        cmd.setId ( "PING" );
        cmd.setRestartDelay ( 10000 );
        cmd.setMaxInputBuffer ( 10000 );

        final ProcessType process = ConfigurationFactory.eINSTANCE.createProcessType ();
        cmd.setProcess ( process );

        if ( this.cfg.getPingDelay () != null )
        {
            final EnvEntryType env1 = ConfigurationFactory.eINSTANCE.createEnvEntryType ();
            env1.setName ( "PING_PERIOD" );
            env1.setValue ( String.format ( "%s", this.cfg.getPingDelay () ) );
            process.getEnv ().add ( env1 );
        }

        process.setExec ( "eclipse_scada_ping" );

        for ( final Map.Entry<String, String> entry : this.hostnameMap.entrySet () )
        {
            process.getArgument ().add ( String.format ( "%s=%s", entry.getValue (), entry.getKey () ) );
        }

        this.root.getHiveProcess ().add ( cmd );
    }

    public static PingCheckWriter find ( final PingCheckConfiguration cfg, final RootType root, final GeneratorContext context )
    {
        PingCheckWriter writer = (PingCheckWriter)context.getAttribute ( root, ATTR_PING_CHECK_WRITER );
        if ( writer == null )
        {
            final PingCheckWriter _writer = new PingCheckWriter ( cfg, root );
            writer = _writer;
            context.setAttribute ( root, ATTR_PING_CHECK_WRITER, writer );
            context.addPostTrigger ( new Runnable () {
                @Override
                public void run ()
                {
                    _writer.finish ();
                }
            } );
        }
        return writer;
    }
}