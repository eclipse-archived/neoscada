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
package org.eclipse.scada.configuration.world.lib.deployment.wix;

import java.io.File;
import java.io.StringReader;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;

public class XMLBase
{

    private final DocumentBuilderFactory dbf;

    public XMLBase ()
    {
        this.dbf = DocumentBuilderFactory.newInstance ();
    }

    protected Element createElement ( final Element parent, final String name )
    {
        final Element ele = parent.getOwnerDocument ().createElement ( name );
        parent.appendChild ( ele );
        return ele;
    }

    protected Element createElementWithText ( final Element parent, final String name, final String text )
    {
        final Element ele = parent.getOwnerDocument ().createElement ( name );
        parent.appendChild ( ele );
        ele.appendChild ( parent.getOwnerDocument ().createTextNode ( text ) );
        return ele;
    }

    protected Element parseFragment ( final String string ) throws Exception
    {
        final DocumentBuilder db = this.dbf.newDocumentBuilder ();
        final InputSource is = new InputSource ( new StringReader ( string ) );
        final Document doc = db.parse ( is );
        return doc.getDocumentElement ();
    }

    protected void appendFragment ( final Element parent, final String fragment ) throws Exception
    {
        Element ele = parseFragment ( fragment );
        ele = (Element)parent.getOwnerDocument ().adoptNode ( ele );
        parent.appendChild ( ele );
    }

    protected void appendFragment ( final Element parent, final URL url ) throws Exception
    {
        final DocumentBuilder db = this.dbf.newDocumentBuilder ();
        final InputSource is = new InputSource ( url.openStream () );
        final Document doc = db.parse ( is );

        Element ele = doc.getDocumentElement ();

        ele = (Element)parent.getOwnerDocument ().adoptNode ( ele );
        parent.appendChild ( ele );
    }

    protected void storeXmlDocument ( final Document doc, final File file ) throws TransformerFactoryConfigurationError, TransformerConfigurationException, TransformerException
    {
        // create output directory

        file.getParentFile ().mkdirs ();

        // write out xml

        final TransformerFactory transformerFactory = TransformerFactory.newInstance ();

        final Transformer transformer = transformerFactory.newTransformer ();
        transformer.setOutputProperty ( OutputKeys.INDENT, "yes" ); //$NON-NLS-1$

        final DOMSource source = new DOMSource ( doc );
        final StreamResult result = new StreamResult ( file );
        transformer.transform ( source, result );
    }

    protected Document createXmlDocument () throws ParserConfigurationException
    {
        final DocumentBuilder db = this.dbf.newDocumentBuilder ();
        final Document doc = db.newDocument ();
        return doc;
    }

}
