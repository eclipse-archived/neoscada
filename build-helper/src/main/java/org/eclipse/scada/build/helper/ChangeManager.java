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
package org.eclipse.scada.build.helper;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.maven.model.Model;
import org.apache.maven.model.io.DefaultModelReader;
import org.apache.maven.model.io.DefaultModelWriter;
import org.apache.maven.plugin.logging.Log;

public class ChangeManager
{
    private final Map<File, Set<ModelModifier>> changes = new HashMap<File, Set<ModelModifier>> ();

    private final List<Runnable> otherChanges = new LinkedList<Runnable> ();

    private final Map<File, Model> modelCache = new HashMap<File, Model> ();

    private final DefaultModelWriter writer;

    private final DefaultModelReader reader;

    private final Log log;

    public ChangeManager ( final Log log )
    {
        this.log = log;
        this.writer = new DefaultModelWriter ();
        this.reader = new DefaultModelReader ();
    }

    public synchronized void addChange ( final Runnable run )
    {
        this.otherChanges.add ( run );
    }

    public synchronized void addChange ( File file, final ModelModifier modifier )
    {
        try
        {
            file = file.getCanonicalFile ();
        }
        catch ( final IOException e )
        {
            throw new RuntimeException ( e );
        }

        // find set
        Set<ModelModifier> set = this.changes.get ( file );
        if ( set == null )
        {
            // add set for file
            set = new HashSet<ModelModifier> ();
            this.changes.put ( file, set );
        }

        // add change
        set.add ( modifier );
    }

    public synchronized void applyAll () throws IOException
    {
        for ( final Runnable run : this.otherChanges )
        {
            run.run ();
        }
        this.otherChanges.clear ();

        for ( final Map.Entry<File, Set<ModelModifier>> entry : this.changes.entrySet () )
        {
            final Model model = this.reader.read ( entry.getKey (), null );

            for ( final ModelModifier modifier : entry.getValue () )
            {
                this.log.debug ( "Running: " + modifier );

                if ( modifier.apply ( model ) )
                {
                    this.log.debug ( String.format ( "%s modified by %s", entry.getKey (), modifier ) );
                    this.modelCache.put ( entry.getKey (), model );
                }
            }
        }
        this.changes.clear ();

        // everything went through, so now we write
        writeModelCache ();
    }

    private void writeModelCache () throws IOException
    {
        for ( final Map.Entry<File, Model> entry : this.modelCache.entrySet () )
        {
            writeModel ( entry.getKey (), entry.getValue () );
        }
        this.modelCache.clear ();
    }

    protected void writeModel ( final File file, final Model model ) throws IOException
    {
        this.log.info ( String.format ( "Writing model: %s", file ) );
        this.writer.write ( file, null, model );
    }
}
