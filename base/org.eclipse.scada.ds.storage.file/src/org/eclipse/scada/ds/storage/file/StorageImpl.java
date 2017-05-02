/*******************************************************************************
 * Copyright (c) 2011, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.ds.storage.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

import org.eclipse.scada.ds.DataNode;
import org.eclipse.scada.ds.storage.AbstractStorage;
import org.eclipse.scada.utils.concurrent.ExportedExecutorService;
import org.eclipse.scada.utils.concurrent.InstantErrorFuture;
import org.eclipse.scada.utils.concurrent.InstantFuture;
import org.eclipse.scada.utils.concurrent.NotifyFuture;
import org.eclipse.scada.utils.str.StringReplacer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StorageImpl extends AbstractStorage
{

    private static final int SPLIT_PATH_DEPTH = 2;

    private final static Logger logger = LoggerFactory.getLogger ( StorageImpl.class );

    private final File rootFolder;

    private final ExecutorService executorService;

    public StorageImpl () throws IOException
    {
        this.executorService = new ExportedExecutorService ( StorageImpl.class.getName (), 1, 1, 0L, TimeUnit.MILLISECONDS );

        this.rootFolder = new File ( getRootFolder () );

        if ( !this.rootFolder.exists () )
        {
            this.rootFolder.mkdirs ();
        }

        if ( !this.rootFolder.exists () || !this.rootFolder.isDirectory () )
        {
            throw new IOException ( String.format ( "Unable to use directory: %s", this.rootFolder ) );
        }
    }

    private static String getRootFolder ()
    {
        final String str = System.getProperty ( "org.eclipse.scada.ds.storage.file.root", "${user.home}" + File.separator + "scadaDS" );
        return StringReplacer.replace ( str, System.getProperties () );
    }

    @Override
    protected Executor getExecutor ()
    {
        return this.executorService;
    }

    @Override
    public synchronized void dispose ()
    {
        super.dispose ();
        this.executorService.shutdown ();
    }

    @Override
    public synchronized NotifyFuture<DataNode> readNode ( final String nodeId )
    {
        try
        {
            return new InstantFuture<DataNode> ( loadFile ( nodeId ) );
        }
        catch ( final Exception e )
        {
            logger.warn ( "Failed to load data node", e );
            return new InstantErrorFuture<DataNode> ( e );
        }
    }

    private DataNode loadFile ( final String nodeId ) throws IOException
    {
        final File file = makeFile ( nodeId );

        // quick check for existence
        if ( !file.exists () || !file.canRead () )
        {
            return null;
        }

        FileInputStream stream = null;
        try
        {
            stream = new FileInputStream ( file );

            return new DataNode ( nodeId, stream );
        }
        catch ( final FileNotFoundException e )
        {
            return null;
        }
        finally
        {
            if ( stream != null )
            {
                stream.close ();
            }
        }
    }

    private File makeFile ( final String nodeId )
    {
        final String hash = String.format ( "%08X", nodeId.hashCode () );
        File root = this.rootFolder;
        for ( int i = 1; i <= SPLIT_PATH_DEPTH; i++ )
        {
            root = new File ( root, hash.substring ( 0, i ) );
        }

        try
        {
            return new File ( root, URLEncoder.encode ( nodeId, "UTF-8" ) );
        }
        catch ( final UnsupportedEncodingException e )
        {
            return new File ( root, nodeId.replaceAll ( "[^a-zA-Z0-9]", "_" ) );
        }
    }

    @Override
    public synchronized NotifyFuture<Void> writeNode ( final DataNode node )
    {
        final File file = makeFile ( node.getId () );
        try
        {
            saveTo ( node, file );
            fireUpdate ( node );
            return new InstantFuture<Void> ( null );
        }
        catch ( final IOException e )
        {
            logger.warn ( "Failed to store data node", e );
            return new InstantErrorFuture<Void> ( e );
        }
    }

    private void saveTo ( final DataNode node, final File file ) throws IOException
    {
        file.delete ();

        final byte[] data = node.getData ();
        if ( data == null )
        {
            return;
        }

        file.getParentFile ().mkdirs ();

        final FileOutputStream stream = new FileOutputStream ( file );
        try
        {
            stream.write ( node.getData () );
        }
        finally
        {
            stream.close ();
        }
    }

    @Override
    public synchronized NotifyFuture<Void> deleteNode ( final String nodeId )
    {
        final File file = makeFile ( nodeId );
        file.delete ();
        return new InstantFuture<Void> ( null );
    }
}
