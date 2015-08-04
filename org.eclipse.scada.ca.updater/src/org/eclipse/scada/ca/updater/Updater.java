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
package org.eclipse.scada.ca.updater;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.scada.ca.Configuration;
import org.eclipse.scada.ca.ConfigurationAdministrator;
import org.eclipse.scada.ca.Factory;
import org.eclipse.scada.ca.data.DiffEntry;
import org.eclipse.scada.ca.oscar.OscarLoader;
import org.eclipse.scada.ca.updater.DirectoryScanner.FailMode;
import org.eclipse.scada.ca.utils.DiffController;
import org.eclipse.scada.utils.concurrent.NotifyFuture;

public class Updater
{
    private final ConfigurationAdministrator admin;

    private final DiffController diff;

    private List<DiffEntry> changes;

    public Updater ( final ConfigurationAdministrator admin )
    {
        this.admin = admin;
        this.diff = new DiffController ();
        this.diff.setRemoteData ( buildMap ( admin ) );
    }

    public static Map<String, Map<String, Map<String, String>>> buildMap ( final ConfigurationAdministrator admin )
    {
        final Factory[] factories = admin.getKnownFactories ();

        final Map<String, Map<String, Map<String, String>>> result = new HashMap<> ( factories.length );

        for ( final Factory factory : factories )
        {
            final Configuration[] cfgs = admin.getConfigurations ( factory.getId () );

            final Map<String, Map<String, String>> factoryData = new HashMap<> ( cfgs.length );
            result.put ( factory.getId (), factoryData );

            for ( final Configuration cfg : cfgs )
            {
                factoryData.put ( cfg.getId (), cfg.getData () );
            }
        }

        return result;
    }

    /**
     * Load the new data set from the reader
     *
     * @param reader
     *            The reader to read from. The caller is responsible for closing
     *            the reader.
     * @throws Exception
     *             if anything goes wrong
     */
    public void loadJson ( final Reader reader )
    {
        this.diff.setLocalData ( OscarLoader.loadJsonData ( reader ) );
    }

    public void setLocalData ( final Map<String, Map<String, Map<String, String>>> localData )
    {
        this.diff.setLocalData ( localData );
    }

    /**
     * Load all files from a local directory as
     *
     * @param dir
     *            the directory to start
     * @param depth
     *            the depth of sub directories to descend into
     * @param failMode
     *            The mode how parsing failures are handled
     */
    public void loadDirectory ( final Path dir, final int depth, final FailMode failMode )
    {
        try
        {
            this.diff.setLocalData ( new DirectoryScanner ( dir, depth, failMode ).scan () );
        }
        catch ( final IOException e )
        {
            throw new RuntimeException ( e );
        }
    }

    protected void makeDiff ()
    {
        if ( this.changes != null )
        {
            return;
        }

        this.changes = this.diff.merge ( null );
    }

    public List<DiffEntry> getChanges ()
    {
        makeDiff ();
        return this.changes;
    }

    public NotifyFuture<Void> update ()
    {
        makeDiff ();

        if ( this.changes == null )
        {
            throw new IllegalStateException ( "No changes recorded" );
        }
        return this.admin.applyDiff ( null, this.changes );
    }
}
