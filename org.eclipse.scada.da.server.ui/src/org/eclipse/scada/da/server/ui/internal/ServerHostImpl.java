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
package org.eclipse.scada.da.server.ui.internal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.FeatureMap.Entry;
import org.eclipse.scada.core.ConnectionInformation;
import org.eclipse.scada.da.server.exporter.DocumentRoot;
import org.eclipse.scada.da.server.exporter.Export;
import org.eclipse.scada.da.server.exporter.ExportType;
import org.eclipse.scada.da.server.exporter.ExporterPackage;
import org.eclipse.scada.da.server.exporter.HiveType;
import org.eclipse.scada.da.server.exporter.NetExport;
import org.eclipse.scada.da.server.exporter.NgpExport;
import org.eclipse.scada.da.server.exporter.util.ExporterResourceFactoryImpl;
import org.eclipse.scada.da.server.ui.HivesPlugin;
import org.eclipse.scada.da.server.ui.HostedServer;
import org.eclipse.scada.da.server.ui.ServerDescriptor;
import org.eclipse.scada.da.server.ui.ServerHost;
import org.eclipse.scada.da.server.ui.util.ServerDescriptorImpl;
import org.eclipse.scada.da.core.server.Hive;
import org.eclipse.scada.ui.utils.status.StatusHelper;

public class ServerHostImpl implements ServerHost
{

    private final class HostedServerDescriptor extends ServerDescriptorImpl implements HostedServer
    {
        private HostedServerDescriptor ( final Realm realm, final Hive hive, final Set<Export> exporters, final String labelAddition )
        {
            super ( realm, hive, exporters, labelAddition );
        }

        @Override
        public void dispose ()
        {
            removeServer ( HostedServerDescriptor.this );
            super.dispose ();
        }
    }

    private final Realm realm;

    private final Set<ServerDescriptorImpl> servers = new HashSet<> ();

    public ServerHostImpl ( final Realm realm )
    {
        this.realm = realm;
    }

    public void removeServer ( final HostedServerDescriptor server )
    {
        final boolean doUnregister;
        synchronized ( this.servers )
        {
            doUnregister = this.servers.remove ( server );
        }
        if ( doUnregister )
        {
            HivesPlugin.unregisterServer ( server );
        }
    }

    public void dispose ()
    {
        final ArrayList<ServerDescriptorImpl> toDispose;

        synchronized ( this )
        {
            toDispose = new ArrayList<> ( this.servers );
            this.servers.clear ();
        }

        this.realm.asyncExec ( new Runnable () {

            @Override
            public void run ()
            {
                for ( final ServerDescriptorImpl server : toDispose )
                {
                    // the removeServer method not be called since cleared the servers list
                    // before in order to prevent CME 
                    HivesPlugin.unregisterServer ( server );
                    server.dispose ();
                }
            }
        } );
    }

    @Override
    public Collection<? extends ServerDescriptor> startServer ( final IFile exporterFile ) throws CoreException
    {
        final String label = exporterFile.getFullPath ().toString ();
        return startServer ( URI.createURI ( exporterFile.getLocationURI ().toString () ), label );
    }

    @Override
    public Collection<? extends ServerDescriptor> startServer ( final String exporterFileUri ) throws CoreException
    {
        return startServer ( URI.createURI ( exporterFileUri ) );
    }

    @Override
    public Collection<? extends ServerDescriptor> startServer ( final URI exporterFileUri ) throws CoreException
    {
        return startServer ( exporterFileUri, exporterFileUri.toString () );
    }

    public Collection<? extends ServerDescriptor> startServer ( final URI exporterFileUri, final String locationLabel ) throws CoreException
    {
        final ResourceSetImpl resourceSet = new ResourceSetImpl ();

        resourceSet.getResourceFactoryRegistry ().getExtensionToFactoryMap ().put ( "*", new ExporterResourceFactoryImpl () );

        final Resource resource = resourceSet.createResource ( exporterFileUri );
        try
        {
            resource.load ( null );
        }
        catch ( final IOException e )
        {
            throw new CoreException ( StatusHelper.convertStatus ( HivesPlugin.PLUGIN_ID, "Failed to load configuration", e ) );
        }

        final DocumentRoot root = (DocumentRoot)EcoreUtil.getObjectByType ( resource.getContents (), ExporterPackage.Literals.DOCUMENT_ROOT );
        if ( root == null )
        {
            throw new CoreException ( new Status ( IStatus.ERROR, HivesPlugin.PLUGIN_ID, "Failed to locate exporter configuration in: " + exporterFileUri ) );
        }
        return startServer ( root, locationLabel );
    }

    @Override
    public Collection<? extends ServerDescriptor> startServer ( final DocumentRoot root, final String locationLabel ) throws CoreException
    {
        try
        {
            final java.util.List<ServerDescriptorImpl> descriptors = new LinkedList<> ();
            for ( final HiveType hive : root.getConfiguration ().getHive () )
            {

                final Hive hiveImpl = createHive ( hive.getRef (), hive.getConfiguration ().getAny () );

                final Set<Export> exporters = new HashSet<> ();
                for ( final ExportType export : hive.getExport () )
                {
                    final Export exporter = createExporter ( hiveImpl, export.getUri () );
                    if ( exporter != null )
                    {
                        exporters.add ( exporter );
                    }
                }
                final ServerDescriptorImpl desc = new HostedServerDescriptor ( this.realm, hiveImpl, exporters, locationLabel );
                HivesPlugin.registerServer ( desc );
                this.servers.add ( desc ); // for internal use
                descriptors.add ( desc ); // for the result
            }
            return descriptors;
        }
        catch ( final Exception e )
        {
            throw new CoreException ( StatusHelper.convertStatus ( HivesPlugin.PLUGIN_ID, "Failed to start", e ) );
        }
    }

    private Export createExporter ( final Hive hive, final String uri ) throws Exception
    {
        final ConnectionInformation ci = ConnectionInformation.fromURI ( uri );
        if ( !ci.getInterface ().equals ( "da" ) ) //$NON-NLS-1$
        {
            throw new IllegalArgumentException ( String.format ( "Only the interface 'da' may be used (%s)", ci.getInterface () ) );
        }

        final String driver = ci.getDriver ();
        if ( "ngp".equals ( driver ) ) //$NON-NLS-1$
        {
            return new NgpExport ( hive, ci );
        }
        if ( "net".equals ( driver ) ) //$NON-NLS-1$
        {
            return new NetExport ( hive, ci );
        }

        throw new IllegalArgumentException ( String.format ( "Illegal protocol used '%s' (only 'net' and 'ngp' are allowed)", driver ) );
    }

    private Hive createHive ( final String ref, final FeatureMap featureMap ) throws Exception
    {
        final Entry first = featureMap.get ( 0 );
        final BundleContextHiveFactory factory = new BundleContextHiveFactory ( HivesPlugin.getDefault ().getBundle ().getBundleContext () );
        return factory.createHive ( ref, (EObject)first.getValue () );
    }
}
