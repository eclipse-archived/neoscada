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
package org.eclipse.neoscada.configuration.iec62541.lib;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.neoscada.configuration.iec62541.DriverApplication;
import org.eclipse.neoscada.configuration.iec62541.HiveDevice;
import org.eclipse.scada.configuration.lib.Nodes;
import org.eclipse.scada.configuration.world.Node;
import org.eclipse.scada.configuration.world.lib.oscar.EquinoxApplicationProcessor;
import org.eclipse.scada.configuration.world.lib.oscar.OscarContext;

public class DriverProcessor extends EquinoxApplicationProcessor
{
    private final DriverApplication driver;

    private IFolder nodeDir;

    private String nodeName;

    public DriverProcessor ( final DriverApplication driver )
    {
        super ( driver );
        this.driver = driver;
    }

    protected static IFolder mkdirs ( final IFolder base, final IProgressMonitor monitor, final String... path ) throws CoreException
    {
        IFolder folder = base;
        for ( final String tok : path )
        {
            folder = folder.getFolder ( tok );
            if ( !folder.isAccessible () )
            {
                folder.create ( true, true, monitor );
            }
        }

        return folder;
    }

//    protected void addFile ( final String name, final InputStream stream, final IProgressMonitor monitor, final String... path ) throws CoreException
//    {
//        final IFolder folder = mkdirs ( mkdirs ( this.nodeDir, monitor, "debian-packages", this.nodeName + "-configuration", "src" ), monitor, path ); //$NON-NLS-1$  //$NON-NLS-2$ //$NON-NLS-3$
//
//        folder.getFile ( name ).create ( stream, IResource.FORCE, monitor );
//    }

    @Override
    public void process ( final String phase, final IFolder nodeDir, final IProgressMonitor monitor, final Map<String, String> properties ) throws Exception
    {
        final Node node = Nodes.fromApp ( this.driver );

        this.nodeName = Nodes.makeName ( node );
        this.nodeDir = nodeDir;

        super.process ( phase, nodeDir, monitor, properties );
    }

    @Override
    protected void processForContext ( final OscarContext ctx, final IFolder output, final IProgressMonitor monitor ) throws Exception
    {
        for ( final HiveDevice device : this.driver.getDevices () )
        {
            addHiveDevice ( ctx, device, monitor );
        }
    }

    private void addHiveDevice ( final OscarContext ctx, final HiveDevice device, final IProgressMonitor monitor ) throws Exception
    {
        final String id = device.getId ();

        final Map<String, String> data = new HashMap<> ();

        data.put ( "url", device.getServerUrl () ); //$NON-NLS-1$

        // connection settings

        ctx.addData ( "org.eclipse.neoscada.da.server.iec62541.server", id, data ); //$NON-NLS-1$
    }

    private String makeId ( final HiveDevice device ) throws UnsupportedEncodingException
    {
        final String id = device.getId ();
        return URLEncoder.encode ( id, "UTF-8" ); //$NON-NLS-1$
    }
}
