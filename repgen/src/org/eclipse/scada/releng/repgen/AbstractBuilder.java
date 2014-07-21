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
import java.io.OutputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;

public abstract class AbstractBuilder
{

    private final TransformerFactory transformerFactory;

    private final DocumentBuilderFactory dbf;

    private final DocumentBuilder db;

    public AbstractBuilder () throws ParserConfigurationException
    {
        this.transformerFactory = TransformerFactory.newInstance ();

        this.dbf = DocumentBuilderFactory.newInstance ();
        this.db = this.dbf.newDocumentBuilder ();
    }

    protected Document createDocument () throws Exception
    {
        return this.db.newDocument ();
    }

    protected Document load ( final InputSource input ) throws Exception
    {
        return this.db.parse ( input );
    }

    protected void write ( final Document doc, final File file ) throws Exception
    {
        write ( doc, new StreamResult ( file ) );
    }

    protected void write ( final Document doc, final StreamResult result ) throws Exception
    {
        final Transformer transformer = this.transformerFactory.newTransformer ();
        final DOMSource source = new DOMSource ( doc );

        transformer.setOutputProperty ( OutputKeys.INDENT, "yes" );
        transformer.setOutputProperty ( "{http://xml.apache.org/xslt}indent-amount", "2" );

        transformer.transform ( source, result );
    }

    protected void write ( final Document doc, final OutputStream output ) throws Exception
    {
        write ( doc, new StreamResult ( output ) );
    }

}
