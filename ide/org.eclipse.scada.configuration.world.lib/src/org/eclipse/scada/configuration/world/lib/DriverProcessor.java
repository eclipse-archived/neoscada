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
package org.eclipse.scada.configuration.world.lib;

import java.io.FileOutputStream;
import java.util.Map;
import java.util.Properties;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.scada.configuration.utils.ModelWriter;
import org.eclipse.scada.configuration.world.Driver;
import org.eclipse.scada.configuration.world.Endpoint;
import org.eclipse.scada.da.server.exporter.ConfigurationType;
import org.eclipse.scada.da.server.exporter.DocumentRoot;
import org.eclipse.scada.da.server.exporter.ExportType;
import org.eclipse.scada.da.server.exporter.ExporterFactory;
import org.eclipse.scada.da.server.exporter.HiveConfigurationType;
import org.eclipse.scada.da.server.exporter.HiveType;

public abstract class DriverProcessor implements NodeElementProcessor
{
    private final Driver driver;

    public DriverProcessor ( final Driver driver )
    {
        this.driver = driver;
    }

    @Override
    public void process ( final String phase, final IFolder baseDir, final IProgressMonitor monitor, final Map<String, String> properties ) throws Exception
    {
        if ( phase != null && !"process".equals ( phase ) )
        {
            return;
        }

        final String name = makeName ();

        final IFolder output = baseDir.getFolder ( new Path ( name ) );
        output.create ( true, true, null );

        final IFile exporterFile = output.getFile ( "exporter.xml" ); //$NON-NLS-1$
        final IFile propFile = output.getFile ( "application.properties" ); //$NON-NLS-1$

        final DocumentRoot root = ExporterFactory.eINSTANCE.createDocumentRoot ();

        final ConfigurationType cfg = ExporterFactory.eINSTANCE.createConfigurationType ();
        root.setConfiguration ( cfg );

        final HiveType hive = ExporterFactory.eINSTANCE.createHiveType ();
        cfg.getHive ().add ( hive );
        hive.setRef ( getHiveId () );

        final HiveConfigurationType hiveCfg = ExporterFactory.eINSTANCE.createHiveConfigurationType ();
        hive.setConfiguration ( hiveCfg );

        addConfiguration ( hiveCfg );

        for ( final Endpoint ep : this.driver.getEndpoints () )
        {
            addEndpoint ( hive, ep );
        }

        // write exporter file
        new ModelWriter ( root ).store ( URI.createPlatformResourceURI ( exporterFile.getFullPath ().toString (), true ) );
        exporterFile.refreshLocal ( 1, monitor );

        // write application properties
        if ( propFile.exists () )
        {
            propFile.delete ( true, monitor );
        }
        final Properties p = new Properties ();
        fillProperties ( p );
        if ( !p.isEmpty () )
        {
            try (FileOutputStream fos = new FileOutputStream ( propFile.getRawLocation ().toOSString () ))
            {
                p.store ( fos, "Created by the Eclipse SCADA world generator" );
            }
            propFile.refreshLocal ( 1, monitor );
        }
    }

    protected void fillProperties ( final Properties p )
    {
    }

    private void addEndpoint ( final HiveType hive, final Endpoint ep )
    {
        final ExportType exporter = ExporterFactory.eINSTANCE.createExportType ();
        hive.getExport ().add ( exporter );

        exporter.setUri ( String.format ( "da:ngp://0.0.0.0:%s", ep.getPortNumber () ) ); //$NON-NLS-1$
    }

    protected abstract void addConfiguration ( HiveConfigurationType hiveCfg );

    protected abstract String getHiveId ();

    private String makeName ()
    {
        return this.driver.getName ();
    }
}
