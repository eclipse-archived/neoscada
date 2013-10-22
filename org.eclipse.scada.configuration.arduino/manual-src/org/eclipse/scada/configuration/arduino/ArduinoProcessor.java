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
package org.eclipse.scada.configuration.arduino;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.scada.configuration.arduino.ArduinoConnection;
import org.eclipse.scada.configuration.arduino.ArduinoDriver;
import org.eclipse.scada.configuration.generator.world.oscar.EquinoxApplicationProcessor;
import org.eclipse.scada.configuration.generator.world.oscar.OscarContext;
import org.eclipse.scada.configuration.lib.Names;

public class ArduinoProcessor extends EquinoxApplicationProcessor
{

    private final ArduinoDriver driver;

    public ArduinoProcessor ( final ArduinoDriver driver )
    {
        super ( driver );
        this.driver = driver;
    }

    @Override
    protected void processForContext ( final OscarContext ctx, final IFolder output, final IProgressMonitor monitor ) throws Exception
    {
        for ( final ArduinoConnection device : this.driver.getArduinoConnections () )
        {
            createDevice ( ctx, device );
        }
    }

    private void createDevice ( final OscarContext ctx, final ArduinoConnection device )
    {
        final Map<String, String> data = new HashMap<> ();

        final String id = Names.makeName ( device );

        data.put ( "host", device.getEndpoint ().getNode ().getHostName () );
        data.put ( "port", "" + device.getEndpoint ().getPortNumber () );

        ctx.addData ( "org.eclipse.scada.da.server.arduino.device", id, data );
    }

}
