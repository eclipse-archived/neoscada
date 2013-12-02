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
package org.eclipse.scada.configuration.generator.ui;

import java.io.File;
import java.io.FileInputStream;
import java.io.PrintStream;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.MessageConsole;
import org.eclipse.scada.ca.oscar.OscarLoader;
import org.eclipse.scada.configuration.world.lib.validator.LoopValidator;

/**
 * Run a component model
 * 
 * @author IBH SYSTEMS GmbH
 */
public class OscarValidatorHandler extends AbstractFileRunner
{

    @Override
    protected void runFile ( final IFile file, final IProgressMonitor monitor ) throws Exception
    {

        final MessageConsole mc = new MessageConsole ( String.format ( "OSCAR Validation: %s", file ), "org.eclipse.scada.configuration.oscar.validation", null, true );

        ConsolePlugin.getDefault ().getConsoleManager ().addConsoles ( new IConsole[] { mc } );
        mc.activate ();

        final File dataFile = file.getLocation ().toFile ();

        Map<String, Map<String, Map<String, String>>> data;

        if ( OscarLoader.isOscar ( dataFile ) )
        {
            data = new OscarLoader ( dataFile ).getData ();
        }
        else
        {
            try (FileInputStream stream = new FileInputStream ( dataFile ))
            {
                data = OscarLoader.loadJsonData ( stream );
            }
        }

        final PrintStream consoleStream = new PrintStream ( mc.newOutputStream () );
        try
        {
            new LoopValidator ( data, consoleStream ).validate ();
        }
        finally
        {
            consoleStream.close ();
        }
    }
}
