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
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.ProcessingInstruction;

public class CompositeBuilder
{
    private final Set<File> dirs = new HashSet<> ();

    private final String repositoryName;

    private final Map<String, String> properties = new HashMap<> ();

    public CompositeBuilder ( final String repositoryName )
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

        final Document docA = createContent ( targetDir, "compositeArtifactRepository" );
        final Document docM = createContent ( targetDir, "compositeMetadataRepository" );

        write ( docA, new File ( targetDir, "compositeContent.xml" ) );
        write ( docM, new File ( targetDir, "compositeArtifacts.xml" ) );

        writeIndex ( new File ( targetDir, "p2.index" ) );
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
            final Element p = doc.createElement ( "property" );
            props.appendChild ( p );
            p.setAttribute ( "name", entry.getKey () );
            p.setAttribute ( "value", entry.getValue () );
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

    private void writeIndex ( final File file ) throws IOException
    {
        try ( PrintWriter pw = new PrintWriter ( file ) )
        {
            pw.println ( "version=1" );
            pw.println ( "metadata.repository.factory.order=compositeContent.xml,\\!" );
            pw.println ( "artifact.repository.factory.order=compositeArtifacts.xml,\\!" );
        }
    }

    private Document createDocument () throws Exception
    {
        final DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance ();
        final DocumentBuilder db = dbf.newDocumentBuilder ();
        return db.newDocument ();
    }

    private void write ( final Document doc, final File file ) throws Exception
    {
        final TransformerFactory transformerFactory = TransformerFactory.newInstance ();
        final Transformer transformer = transformerFactory.newTransformer ();
        final DOMSource source = new DOMSource ( doc );
        final StreamResult result = new StreamResult ( file );

        transformer.setOutputProperty ( OutputKeys.INDENT, "yes" );
        transformer.setOutputProperty ( "{http://xml.apache.org/xslt}indent-amount", "2" );

        transformer.transform ( source, result );
    }
}
