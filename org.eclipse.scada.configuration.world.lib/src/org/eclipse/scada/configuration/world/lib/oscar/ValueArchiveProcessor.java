/*******************************************************************************
 * Copyright (c) 2013, 2016 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.configuration.world.lib.oscar;

import java.io.ByteArrayInputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.scada.configuration.lib.Locator;
import org.eclipse.scada.configuration.lib.Names;
import org.eclipse.scada.configuration.world.osgi.ArchiveConfiguration;
import org.eclipse.scada.configuration.world.osgi.DataAccessConnection;
import org.eclipse.scada.configuration.world.osgi.EquinoxApplication;
import org.eclipse.scada.configuration.world.osgi.Item;
import org.eclipse.scada.configuration.world.osgi.OsgiFactory;
import org.eclipse.scada.configuration.world.osgi.ValueArchive;
import org.eclipse.scada.configuration.world.osgi.ValueArchiveServer;
import org.eclipse.scada.utils.str.StringHelper;

public class ValueArchiveProcessor extends BasicOscarProcessor
{

    private final ValueArchiveServer app;

    private final IFile commandFile;

    private final StringBuilder commandBuilder = new StringBuilder ();

    private static final String NL = System.lineSeparator ();

    private static final ArchiveConfiguration DEFAULT_CONFIGURATION;

    static
    {
        DEFAULT_CONFIGURATION = OsgiFactory.eINSTANCE.createArchiveConfiguration ();
    }

    public ValueArchiveProcessor ( final ValueArchiveServer app, final OscarContext ctx, final IFile commandFile )
    {
        super ( app, ctx );
        this.app = app;
        this.commandFile = commandFile;
    }

    public void process ( final IProgressMonitor monitor ) throws Exception
    {
        for ( final ValueArchive archive : this.app.getArchives () )
        {
            createValueArchive ( archive );
        }
        writeCommandFile ( monitor );
    }

    private void writeCommandFile ( final IProgressMonitor monitor ) throws Exception
    {
        final String data = "# These commands must be executed on the target instance" + NL + this.commandBuilder;
        try ( final ByteArrayInputStream input = new ByteArrayInputStream ( data.getBytes () ) )
        {
            this.commandFile.create ( input, IResource.KEEP_HISTORY, monitor );
        }
    }

    private void createValueArchive ( final ValueArchive archive )
    {
        final EList<Item> items = archive.getItems ();
        if ( items.isEmpty () )
        {
            return;
        }

        if ( items.size () == 1 )
        {
            // without proxy
            createArchive ( archive, createSource ( archive, items.get ( 0 ), 0 ) );
        }
        else
        {
            // with proxy
            int i = 1; // start with 1 instead of 0, to make a difference when no proxy is used
            final List<String> sources = new LinkedList<> ();
            for ( final Item item : items )
            {
                sources.add ( createSource ( archive, item, i ) );
                i++;
            }
            createArchive ( archive, createProxy ( archive, sources ) );
        }
    }

    private String createProxy ( final ValueArchive archive, final List<String> sources )
    {
        final Map<String, String> data = new HashMap<String, String> ();

        final String id = Names.makeName ( archive ) + ".proxy";

        for ( final String source : sources )
        {
            if ( source.contains ( "," ) )
            {
                throw new IllegalArgumentException ( String.format ( "Item name '%s' is invalid. Proxy sources must not contain comma (,) in their name.", source ) );
            }
        }

        Collections.sort ( sources ); // make output reproducible

        data.put ( "sources", StringHelper.join ( sources, ", " ) );

        addData ( Factories.FACTORY_DA_PROXY_SOURCE, id, data );

        return id;
    }

    private void createArchive ( final ValueArchive archive, final String sourceId )
    {
        final ArchiveConfiguration cfg = findConfiguration ( archive );

        final Map<String, String> data = new TreeMap<String, String> ();

        final String id = Names.makeName ( archive );
        data.put ( "datasource.id", sourceId );
        addData ( Factories.FACTORY_HD_ITEM, id, data );

        // FIXME: this should be configurable
        // FIXME: this should not be executed manually
        // this.commandBuilder.append ( String.format ( "hds:create %s 3600000 2160", id ) );
        this.commandBuilder.append ( String.format ( "hds:create %s %s %s", id, cfg.getFileSizeInMilliseconds (), cfg.getNumberOfFiles () ) );
        this.commandBuilder.append ( NL );
    }

    private ArchiveConfiguration findConfiguration ( final ValueArchive archive )
    {
        if ( archive.getArchiveconfiguration () != null )
        {
            return archive.getArchiveconfiguration ();
        }
        if ( this.app.getDefaultArchiveConfiguration () != null )
        {
            return this.app.getDefaultArchiveConfiguration ();
        }
        return DEFAULT_CONFIGURATION;
    }

    private String createSource ( final ValueArchive archive, final Item item, final int number )
    {
        final Map<String, String> data = new HashMap<String, String> ();

        final DataAccessConnection connection = findConnection ( item );

        data.put ( "item.id", item.getName () ); //$NON-NLS-1$
        data.put ( "connection.id", Names.makeName ( connection ) ); //$NON-NLS-1$

        final String id = makeId ( archive, number, "source" );
        addData ( Factories.FACTORY_DA_SOURCE, id, data );
        return id;
    }

    private DataAccessConnection findConnection ( final Item item )
    {
        return Locator.findPossibleConnection ( this.app, (EquinoxApplication)item.eContainer (), DataAccessConnection.class );
    }

    public String makeId ( final ValueArchive archive, final int number, final String suffix )
    {
        return String.format ( "%s/%s.%s", Names.makeName ( archive ), number, suffix );
    }
}
