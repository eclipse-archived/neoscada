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

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;

public abstract class AbstractBuilder
{

    protected Document createDocument () throws Exception
    {
        final DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance ();
        final DocumentBuilder db = dbf.newDocumentBuilder ();
        return db.newDocument ();
    }

    protected void write ( final Document doc, final File file ) throws Exception
    {
        final TransformerFactory transformerFactory = TransformerFactory.newInstance ();
        final Transformer transformer = transformerFactory.newTransformer ();
        final DOMSource source = new DOMSource ( doc );
        final StreamResult result = new StreamResult ( file );

        transformer.setOutputProperty ( OutputKeys.INDENT, "yes" );
        transformer.setOutputProperty ( "{http://xml.apache.org/xslt}indent-amount", "2" );

        transformer.transform ( source, result );
    }

    protected Document load ( final InputSource input ) throws Exception
    {
        final DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance ();
        final DocumentBuilder db = dbf.newDocumentBuilder ();
        return db.parse ( input );
    }
}
