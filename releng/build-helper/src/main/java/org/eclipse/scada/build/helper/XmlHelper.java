/*******************************************************************************
 * Copyright (c) 2013, 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *     IBH SYSTEMS GmbH - add getText method
 *******************************************************************************/
package org.eclipse.scada.build.helper;

import java.io.File;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.apache.maven.plugin.MojoExecutionException;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public final class XmlHelper
{
    private XmlHelper ()
    {
    }

    private static XPathFactory xpf = XPathFactory.newInstance ();

    private static DocumentBuilderFactory dbf;

    static
    {
        dbf = DocumentBuilderFactory.newInstance ();
    }

    public static void write ( final Document doc, final File file ) throws Exception
    {
        final TransformerFactory transformerFactory = TransformerFactory.newInstance ();
        final Transformer transformer = transformerFactory.newTransformer ();
        final DOMSource source = new DOMSource ( doc );
        final StreamResult result = new StreamResult ( file );
        transformer.transform ( source, result );
    }

    public static void clearChildren ( final Element ele )
    {
        Node child;
        while ( ( child = ele.getFirstChild () ) != null )
        {
            ele.removeChild ( child );
        }
    }

    public static void replaceContent ( final Element ele, final String newContent )
    {
        XmlHelper.clearChildren ( ele );
        ele.appendChild ( ele.getOwnerDocument ().createTextNode ( newContent ) );
    }

    public static String getText ( final Node startNode, final String expression ) throws XPathExpressionException
    {
        StringBuilder sb = null;

        for ( final Node node : XmlHelper.findNodes ( startNode, expression ) )
        {
            if ( sb == null )
            {
                sb = new StringBuilder ();
            }

            sb.append ( node.getTextContent () );
        }

        if ( sb != null )
        {
            return sb.toString ();
        }
        else
        {
            return null;
        }
    }

    public static void updateValue ( final Document doc, final String expression, final String content ) throws XPathExpressionException
    {
        for ( final Node node : XmlHelper.findNodes ( doc, expression ) )
        {
            if ( node instanceof Element )
            {
                XmlHelper.updateContent ( node.getTextContent (), content, node );
            }
            else if ( node instanceof Attr )
            {
                XmlHelper.updateContent ( ( (Attr)node ).getValue (), content, node );
            }
        }
    }

    public static void updateContent ( final String actualContent, final String newContent, final Node node )
    {
        if ( isEqual ( actualContent, Collections.singleton ( newContent ) ) )
        {
            return;
        }

        if ( node instanceof Element )
        {
            final Element ele = (Element)node;
            XmlHelper.replaceContent ( ele, newContent );
            return;
        }
        else if ( node instanceof Attr )
        {
            final Attr attr = (Attr)node;
            attr.setValue ( newContent );
            return;
        }
        throw new IllegalStateException ( String.format ( "%s refers to an XML node type which is not supported", node ) );
    }

    public static boolean isEqual ( final String actualContent, final Set<String> expectedContent )
    {
        return expectedContent.contains ( actualContent );
    }

    public static List<Node> findNodes ( final Node node, final String expression ) throws XPathExpressionException
    {
        final XPath path = xpf.newXPath ();
        final XPathExpression expr = path.compile ( expression );
        final NodeList nodeList = (NodeList)expr.evaluate ( node, XPathConstants.NODESET );

        if ( nodeList == null )
        {
            return Collections.emptyList ();
        }

        final List<Node> result = new LinkedList<Node> ();
        for ( int i = 0; i < nodeList.getLength (); i++ )
        {
            result.add ( nodeList.item ( i ) );
        }

        return result;
    }

    public static Document parse ( final File file ) throws Exception
    {
        final DocumentBuilder db = dbf.newDocumentBuilder ();
        try
        {
            return db.parse ( file );
        }
        catch ( final Exception e )
        {
            throw new MojoExecutionException ( String.format ( "Failed to parse: %s", file ), e );
        }
    }

}
