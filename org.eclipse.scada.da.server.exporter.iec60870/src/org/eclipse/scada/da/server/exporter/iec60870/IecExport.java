/*******************************************************************************
 * Copyright (c) 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.server.exporter.iec60870;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;

import org.eclipse.scada.da.server.common.DataItem;
import org.eclipse.scada.da.server.common.exporter.ObjectExporter;
import org.eclipse.scada.da.server.common.osgi.factory.ObjectPoolDataItemFactory;
import org.eclipse.scada.da.server.exporter.common.HiveSource;
import org.eclipse.scada.protocol.iec60870.server.Server;
import org.eclipse.scada.protocol.iec60870.server.ServerModule;
import org.eclipse.scada.protocol.iec60870.server.data.DataModule;
import org.eclipse.scada.utils.osgi.pool.ManageableObjectPool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IecExport
{

    private final static Logger logger = LoggerFactory.getLogger ( IecExport.class );

    private ExportConfiguration configuration;

    private Server server;

    private DataModule dataModule;

    private final InformationBean info;

    private final ObjectExporter exporter;

    private final HiveSource hiveSource;

    public IecExport ( final String id, final Map<String, String> parameters, final ScheduledExecutorService executor, final ManageableObjectPool<DataItem> itemObjectPool, final HiveSource hiveSource )
    {
        this.info = new InformationBean ();
        this.hiveSource = hiveSource;

        final ObjectPoolDataItemFactory itemFactory = new ObjectPoolDataItemFactory ( executor, itemObjectPool, String.format ( "org.eclipse.scada.da.server.exporter.iec60870.export.%s.information.", id ) ); //$NON-NLS-1$
        this.exporter = new ObjectExporter ( itemFactory, true, true );
        this.exporter.attachTarget ( this.info );

        synchronized ( this )
        {
            update ( parameters );
        }
    }

    public void dispose ()
    {
        synchronized ( this )
        {
            disposeServer ();
            disposeDataModel ();
        }
        if ( this.exporter != null )
        {
            this.exporter.dispose ();
        }
    }

    public synchronized void update ( final Map<String, String> parameters )
    {
        final ExportConfiguration cfg = ExportConfiguration.parse ( parameters );
        if ( this.configuration == null || !this.configuration.equals ( cfg ) )
        {
            applyConfiguration ( cfg );
        }
    }

    private synchronized void applyConfiguration ( final ExportConfiguration cfg )
    {
        this.configuration = cfg;

        this.info.setConfigured ( this.configuration != null );

        checkAndCreate ();
    }

    private void checkAndCreate ()
    {
        disposeServer ();
        disposeDataModel ();

        if ( this.configuration != null )
        {
            this.dataModule = new DataModule ( this.configuration.getDataModuleOptions (), new DataModelImpl ( this.hiveSource, this.configuration.getEntries (), this.configuration.getHiveProperties (), this.info ) );
            this.info.setItems ( this.configuration.getEntries ().size () );

            final List<ServerModule> modules = new LinkedList<ServerModule> ();
            modules.add ( this.dataModule );

            this.server = new Server ( this.configuration.getPort (), this.configuration.getProtocolOptions (), modules );
        }

        this.info.setHasDataModule ( this.dataModule != null );
        this.info.setHasServer ( this.server != null );
    }

    private void disposeDataModel ()
    {
        if ( this.dataModule != null )
        {
            this.dataModule.dispose ();
            this.dataModule = null;
        }

        this.info.setItems ( 0 );
        this.info.setHasDataModule ( this.dataModule != null );
    }

    private void disposeServer ()
    {
        if ( this.server != null )
        {
            try
            {
                this.server.close ();
            }
            catch ( final Exception e )
            {
                logger.warn ( "Failed to close server", e );
            }
            this.server = null;
        }

        this.info.setHasServer ( this.server != null );
    }
}
