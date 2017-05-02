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
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.ProcessingInstruction;
import org.xml.sax.InputSource;

public class MetaDataMerger extends AbstractP2Builder
{
    private final Document doc;

    private final Element r;

    private final Element p;

    private final Element u;

    private final XPathExpression isCategoryPathExpression;

    private final Map<String, Element> categoryStore = new HashMap<> ();

    public MetaDataMerger ( final String label, final boolean compressed ) throws Exception
    {
        this.doc = createDocument ();

        final XPathFactory xpf = XPathFactory.newInstance ();
        final XPath xp = xpf.newXPath ();
        this.isCategoryPathExpression = xp.compile ( "properties/property[@name='org.eclipse.equinox.p2.type.category']/@value" );

        final ProcessingInstruction pi = this.doc.createProcessingInstruction ( "metadataRepository", "" );
        pi.setData ( "version=\"1.1.0\"" );
        this.doc.appendChild ( pi );

        this.r = this.doc.createElement ( "repository" );
        this.doc.appendChild ( this.r );
        this.r.setAttribute ( "name", label );
        this.r.setAttribute ( "type", "org.eclipse.equinox.internal.p2.metadata.repository.LocalMetadataRepository" );
        this.r.setAttribute ( "version", "1" );

        this.p = this.doc.createElement ( "properties" );
        this.r.appendChild ( this.p );

        addProperty ( this.p, "p2.compressed", "" + compressed );
        addProperty ( this.p, "p2.timestamp", "" + System.currentTimeMillis () );

        this.u = this.doc.createElement ( "units" );
        this.r.appendChild ( this.u );
    }

    public void build ( final File targetDir ) throws Exception
    {
        // append categories of latest repository
        for ( final Map.Entry<String, Element> entry : this.categoryStore.entrySet () )
        {
            this.u.appendChild ( entry.getValue () );
        }

        // update unit counter
        this.u.setAttribute ( "size", "" + this.u.getChildNodes ().getLength () );

        try ( ZipOutputStream os = new ZipOutputStream ( new FileOutputStream ( new File ( targetDir, "content.jar" ) ) ) )
        {
            final ZipEntry ze = new ZipEntry ( "content.xml" );
            os.putNextEntry ( ze );
            write ( this.doc, os );
            os.closeEntry ();
        }
    }

    public void setProperty ( final String key, final String value )
    {
        addProperty ( this.p, key, value );
    }

    public void addRepository ( final File dir ) throws Exception
    {
        // we only want to the have the categories of the latest repository
        this.categoryStore.clear ();

        final Document md = loadMetaData ( dir );

        final NodeList nl = md.getElementsByTagName ( "units" );
        for ( int i = 0; i < nl.getLength (); i++ )
        {
            final Node node = nl.item ( i );
            for ( final Node child : new NodeIterable ( node ) )
            {
                if ( child instanceof Element && child.getNodeName ().equals ( "unit" ) )
                {
                    addUnit ( (Element)child );
                }
            }
        }
    }

    private void addUnit ( final Element node ) throws Exception
    {
        if ( isCategoryUnit ( node ) )
        {
            final String categoryId = node.getAttribute ( "id" );
            System.out.println ( "          Skipping category: " + categoryId );
            this.categoryStore.put ( categoryId, (Element)this.doc.adoptNode ( node ) );
            return;
        }

        this.u.appendChild ( this.doc.adoptNode ( node ) );
    }

    private boolean isCategoryUnit ( final Element unit ) throws Exception
    {
        final Object value = this.isCategoryPathExpression.evaluate ( unit, XPathConstants.STRING );
        if ( value == null )
        {
            return false;
        }
        return Boolean.parseBoolean ( (String)value );
    }

    protected Document loadMetaData ( final File dir ) throws Exception
    {
        {
            final File file = new File ( dir, "content.xml" );
            if ( file.canRead () && file.isFile () )
            {
                System.out.println ( "     Loading: " + file );
                return load ( new InputSource ( new FileInputStream ( file ) ) );
            }
        }
        {
            final File file = new File ( dir, "content.jar" );
            if ( file.canRead () && file.isFile () )
            {
                final URL url = new URL ( "jar:" + file.toURI ().toString () + "!/content.xml" );
                System.out.println ( "     Loading: " + url );
                return load ( new InputSource ( url.openStream () ) );
            }
        }
        throw new IllegalArgumentException ( String.format ( "Failed to load repository from: " + dir ) );
    }
}
