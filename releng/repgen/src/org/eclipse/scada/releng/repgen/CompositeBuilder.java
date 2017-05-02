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
package org.eclipse.scada.releng.repgen;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.ProcessingInstruction;

public class CompositeBuilder extends AbstractP2Builder
{
    private final Set<File> dirs = new HashSet<> ();

    private final String repositoryName;

    private final Map<String, String> properties = new HashMap<> ();

    public CompositeBuilder ( final String repositoryName ) throws Exception
    {
        this.repositoryName = repositoryName;
    }

    public void setProperty ( final String key, final String value )
    {
        this.properties.put ( key, value );
    }

    public void addRepository ( final File file ) throws IOException
    {
        this.dirs.add ( file.getCanonicalFile () );
    }

    public void build ( File targetDir ) throws Exception
    {
        targetDir = targetDir.getCanonicalFile ();
        targetDir.mkdir ();

        setProperty ( "p2.timestamp", "" + System.currentTimeMillis () );
        setProperty ( "p2.compressed", "false" );

        // final Document docA = createContent ( targetDir, "compositeArtifactRepository" );
        final Document docM = createContent ( targetDir, "compositeMetadataRepository" );

        // write ( docA, new File ( targetDir, "compositeContent.xml" ) );
        write ( docM, new File ( targetDir, "compositeArtifacts.xml" ) );
    }

    private Document createContent ( final File targetDir, final String type ) throws Exception
    {
        final Document doc = createDocument ();

        final ProcessingInstruction pi = doc.createProcessingInstruction ( type, "" );
        pi.setData ( "version=\"1.0.0\"" );
        doc.appendChild ( pi );

        final Element rep = doc.createElement ( "repository" );
        doc.appendChild ( rep );

        final String typeUpper = Character.toUpperCase ( type.charAt ( 0 ) ) + type.substring ( 1 );

        rep.setAttribute ( "name", this.repositoryName );
        rep.setAttribute ( "type", "org.eclipse.equinox.internal.p2.metadata.repository." + typeUpper );
        rep.setAttribute ( "version", "1.0.0" );

        final Element props = doc.createElement ( "properties" );
        rep.appendChild ( props );
        props.setAttribute ( "size", "" + this.properties.size () );

        for ( final Map.Entry<String, String> entry : this.properties.entrySet () )
        {
            addProperty ( props, entry.getKey (), entry.getValue () );
        }

        final Element children = doc.createElement ( "children" );
        rep.appendChild ( children );
        children.setAttribute ( "size", "" + this.dirs.size () );

        for ( final File file : this.dirs )
        {
            final String ref = targetDir.toPath ().relativize ( file.toPath () ).toString ();
            final Element c = doc.createElement ( "child" );
            children.appendChild ( c );
            c.setAttribute ( "location", ref );
        }

        return doc;
    }

}
