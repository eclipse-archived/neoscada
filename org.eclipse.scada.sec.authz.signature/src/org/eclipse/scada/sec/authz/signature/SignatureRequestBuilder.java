/*******************************************************************************
 * Copyright (c) 2013 Jens Reimann and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Jens Reimann - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.sec.authz.signature;

import java.io.StringReader;
import java.io.StringWriter;
import java.security.SecureRandom;
import java.util.Map;

import javax.xml.crypto.dsig.XMLSignature;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.eclipse.scada.sec.AuthorizationRequest;
import org.eclipse.scada.sec.UserInformation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

/**
 * @since 1.1
 */
public class SignatureRequestBuilder
{
    public static final String NAMESPACE = System.getProperty("org.eclipse.scada.sec.authz.signature.xmlNamespace", "urn:eclipse:scada:sec:request");

    private final DocumentBuilderFactory dbf;

    private final DocumentBuilder db;

    private TransformerFactory tf;

    private final boolean injectRandomId;

    private final SecureRandom random = new SecureRandom ();

    public SignatureRequestBuilder () throws Exception
    {
        this ( true );
    }

    public SignatureRequestBuilder ( final boolean injectRandomId ) throws Exception
    {
        this.injectRandomId = injectRandomId;

        synchronized ( this )
        {
            this.dbf = DocumentBuilderFactory.newInstance ();
            this.dbf.setNamespaceAware ( true );
            this.dbf.setCoalescing ( true );
            this.dbf.setIgnoringComments ( true );
            this.db = this.dbf.newDocumentBuilder ();

            this.tf = TransformerFactory.newInstance ();
        }
    }

    public Document fromString ( final String str ) throws Exception
    {
        synchronized ( this )
        {
            return this.db.parse ( new InputSource ( new StringReader ( str ) ) );
        }
    }

    public Document buildFromRequest ( final AuthorizationRequest request )
    {
        Document doc;
        synchronized ( this )
        {
            doc = this.db.newDocument ();
        }

        fillDocument ( doc, request );

        return doc;
    }

    public String toString ( final Document doc, final boolean indent ) throws Exception
    {
        Transformer t;
        synchronized ( this )
        {
            t = this.tf.newTransformer ();
        }

        if ( indent )
        {
            t.setOutputProperty ( "{http://xml.apache.org/xslt}indent-amount", "2" );
            t.setOutputProperty ( OutputKeys.INDENT, "yes" );
        }

        final StringWriter sw = new StringWriter ();
        t.transform ( new DOMSource ( doc ), new StreamResult ( sw ) );
        return sw.toString ();
    }

    private void fillDocument ( final Document doc, final AuthorizationRequest request )
    {
        final Element root = doc.createElementNS ( NAMESPACE, "request:request" );
        doc.appendChild ( root );

        root.setAttribute ( "xmlns:request", NAMESPACE );

        if ( this.injectRandomId )
        {
            root.setAttributeNS ( NAMESPACE, "request:id", String.format ( "%016x", this.random.nextLong () ) );
        }

        if ( request.getObjectType () != null )
        {
            root.setAttributeNS ( NAMESPACE, "request:objectType", request.getObjectType () );
        }
        if ( request.getObjectId () != null )
        {
            root.setAttributeNS ( NAMESPACE, "request:objectId", request.getObjectId () );
        }
        if ( request.getAction () != null )
        {
            root.setAttributeNS ( NAMESPACE, "request:action", request.getAction () );
        }

        if ( request.getUserInformation () != null && !request.getUserInformation ().isAnonymous () )
        {
            root.appendChild ( makeUserElement ( doc, request.getUserInformation () ) );
        }

        if ( request.getContext () != null && !request.getContext ().isEmpty () )
        {
            root.appendChild ( makeContextElement ( doc, request.getContext () ) );
        }
    }

    private Node makeContextElement ( final Document doc, final Map<String, Object> context )
    {
        return makeMapElement ( doc, context, NAMESPACE, "request:context" );
    }

    private Element makeMapElement ( final Document doc, final Map<?, ?> map, final String namespace, final String elementName )
    {
        final Element ele = doc.createElementNS ( namespace, elementName );

        for ( final Map.Entry<?, ?> entry : map.entrySet () )
        {
            final Element ee = doc.createElementNS ( NAMESPACE, "request:entry" );
            ee.setAttributeNS ( NAMESPACE, "request:key", "" + entry.getKey () );
            ele.appendChild ( ee );

            final Object value = entry.getValue ();
            if ( value instanceof Map<?, ?> )
            {
                ee.appendChild ( makeMapElement ( doc, (Map<?, ?>)value, namespace, "request:map" ) );
            }
            else if ( value != null )
            {
                ee.appendChild ( doc.createTextNode ( "" + value ) );
            }
        }

        return ele;
    }

    private Node makeUserElement ( final Document doc, final UserInformation userInformation )
    {
        final Element user = doc.createElementNS ( NAMESPACE, "request:user" );
        user.setAttributeNS ( NAMESPACE, "request:name", userInformation.getName () );
        return user;
    }

    public boolean isEqual ( final Document sourceDoc, final Document signedDoc )
    {
        try
        {
            compare ( sourceDoc, signedDoc );
            return true;
        }
        catch ( final Exception e )
        {
            return false;
        }
    }

    public void compare ( final Document sourceDoc, final Document signedDoc ) throws Exception
    {
        final Document d1 = cloneDoc ( sourceDoc );
        final Document d2 = cloneDoc ( signedDoc );

        final NodeList nl = d2.getElementsByTagNameNS ( XMLSignature.XMLNS, "Signature" );

        while ( nl.getLength () > 0 )
        {
            final Node item = nl.item ( 0 );
            item.getParentNode ().removeChild ( item );
        }

        d1.normalizeDocument ();
        d2.normalizeDocument ();

        final Element root1 = d1.getDocumentElement ();
        final Element root2 = d2.getDocumentElement ();

        compareNode ( root1, root2 );
    }

    public Document cloneDoc ( final Document doc ) throws TransformerException
    {
        final Transformer tx = this.tf.newTransformer ();
        final DOMSource source = new DOMSource ( doc );
        final DOMResult result = new DOMResult ();
        tx.transform ( source, result );
        return (Document)result.getNode ();
    }

    private void compareNode ( final Node n1, final Node n2 )
    {
        if ( !compareString ( n1.getNamespaceURI (), n2.getNamespaceURI () ) )
        {
            throw new IllegalStateException ( String.format ( "Nodes differ by namespace - %s <-> %s", n1.getNamespaceURI (), n2.getNamespaceURI () ) );
        }

        if ( !compareString ( n1.getLocalName (), n2.getLocalName () ) )
        {
            throw new IllegalStateException ( "Nodes differ by local name" );
        }

        if ( !compareString ( n1.getTextContent (), n2.getTextContent () ) )
        {
            throw new IllegalStateException ( "Nodes differ by text content" );
        }

        compareLists ( n1.getAttributes (), n2.getAttributes () );
        compareLists ( n1.getChildNodes (), n2.getChildNodes () );
    }

    private void compareLists ( final NamedNodeMap nl1, final NamedNodeMap nl2 )
    {
        if ( nl1 == nl2 )
        {
            return;
        }

        if ( nl1.getLength () != nl2.getLength () )
        {
            throw new IllegalStateException ( "Different number of child nodes" );
        }

        for ( int i = 0; i < nl1.getLength (); i++ )
        {
            compareNode ( nl1.item ( i ), nl2.item ( i ) );
        }
    }

    private void compareLists ( final NodeList nl1, final NodeList nl2 )
    {
        if ( nl1.getLength () != nl2.getLength () )
        {
            throw new IllegalStateException ( "Different number of child nodes" );
        }

        for ( int i = 0; i < nl1.getLength (); i++ )
        {
            compareNode ( nl1.item ( i ), nl2.item ( i ) );
        }
    }

    private boolean compareString ( final String s1, final String s2 )
    {
        if ( s1 == s2 )
        {
            return true;
        }
        if ( s1 == null )
        {
            return false;
        }
        return s1.equals ( s2 );
    }

}
