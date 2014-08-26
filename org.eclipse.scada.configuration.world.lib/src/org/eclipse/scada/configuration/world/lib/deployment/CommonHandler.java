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
package org.eclipse.scada.configuration.world.lib.deployment;

import java.io.File;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.scada.configuration.lib.Nodes;
import org.eclipse.scada.configuration.world.Application;
import org.eclipse.scada.configuration.world.ApplicationNode;
import org.eclipse.scada.configuration.world.CommonDriver;
import org.eclipse.scada.configuration.world.lib.NodeElementProcessor;
import org.eclipse.scada.configuration.world.osgi.EquinoxApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class CommonHandler implements NodeElementProcessor
{
    private final static Logger logger = LoggerFactory.getLogger ( CommonHandler.class );

    protected final ApplicationNode applicationNode;

    protected abstract void handleProcess ( IFolder nodeDir, IProgressMonitor monitor, Map<String, String> properties ) throws Exception;

    public CommonHandler ( final ApplicationNode applicationNode )
    {
        this.applicationNode = applicationNode;
    }

    @Override
    public void process ( final String phase, final IFolder nodeDir, final IProgressMonitor monitor, final Map<String, String> properties ) throws Exception
    {
        if ( phase != null && !"package".equals ( phase ) )
        {
            return;
        }

        if ( Boolean.parseBoolean ( properties.get ( "skipDeployment" ) ) )
        {
            return;
        }

        handleProcess ( nodeDir, monitor, properties );
        monitor.done ();
    }

    protected abstract String getBaseFolderName ();

    public String getPackageName ()
    {
        return Nodes.makeName ( this.applicationNode ) + "-configuration";
    }

    protected File getPackageFolder ( final IFolder nodeDir )
    {
        final File folder = nodeDir.getFolder ( getBaseFolderName () ).getLocation ().toFile ();
        logger.debug ( "Output folder: {}", folder );

        return new File ( folder, getPackageName () );
    }

    protected boolean needP2 ()
    {
        for ( final Application app : this.applicationNode.getApplications () )
        {
            if ( app instanceof EquinoxApplication )
            {
                return true;
            }
        }
        return false;
    }

    protected Set<String> makeDriverList ()
    {
        final Set<String> result = new HashSet<> ();
        for ( final Application app : this.applicationNode.getApplications () )
        {
            if ( app instanceof CommonDriver )
            {
                result.add ( app.getName () );
            }
        }
        return result;
    }

    protected Set<String> makeEquinoxList ()
    {
        final Set<String> result = new HashSet<> ();
        for ( final Application app : this.applicationNode.getApplications () )
        {
            if ( app instanceof EquinoxApplication )
            {
                result.add ( app.getName () );
            }
        }
        return result;
    }

}