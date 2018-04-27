/*******************************************************************************
 * Copyright (c) 2014, 2016 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.neoscada.configuration.iec60870.lib.hive;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.neoscada.configuration.iec60870.ClientDevice;
import org.eclipse.neoscada.configuration.iec60870.DriverApplication;
import org.eclipse.neoscada.configuration.iec60870.ItemType;
import org.eclipse.neoscada.configuration.iec60870.lib.Configurations;
import org.eclipse.scada.configuration.world.lib.oscar.EquinoxApplicationProcessor;
import org.eclipse.scada.configuration.world.lib.oscar.OscarContext;

public class DriverProcessor extends EquinoxApplicationProcessor
{
    private final DriverApplication driver;

    public DriverProcessor ( final DriverApplication driver )
    {
        super ( driver );
        this.driver = driver;
    }

    @Override
    protected void processForContext ( final OscarContext ctx, final IFolder output, final IProgressMonitor monitor ) throws Exception
    {
        for ( final ClientDevice device : this.driver.getDevices () )
        {
            addClientDevice ( ctx, device );
        }
    }

    private void addClientDevice ( final OscarContext ctx, final ClientDevice device )
    {
        final String id = device.getId ();

        final Map<String, String> data = new HashMap<> ();

        data.put ( "host", device.getEndpoint ().getNode ().getHostName () ); //$NON-NLS-1$
        data.put ( "port", "" + device.getEndpoint ().getPortNumber () ); //$NON-NLS-1$ //$NON-NLS-2$

        Configurations.encode ( data, "protocol", device.getProtocolOptions () ); //$NON-NLS-1$
        Configurations.encode ( data, "dataModule", device.getDataModuleOptions () ); //$NON-NLS-1$

        for ( ItemType itemType : device.getItemTypes () )
        {
            data.put ( "itemType." + itemType.getItem (), itemType.getType ().getName () );
        }

        ctx.addData ( "org.eclipse.neoscada.da.server.iec60870.connection", id, data ); //$NON-NLS-1$
    }
}
