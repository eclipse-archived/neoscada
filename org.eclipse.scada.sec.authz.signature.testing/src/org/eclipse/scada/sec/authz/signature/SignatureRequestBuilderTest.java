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

import java.net.URL;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.security.auth.x500.X500Principal;
import javax.xml.crypto.KeySelector;

import org.eclipse.scada.sec.AuthorizationRequest;
import org.eclipse.scada.sec.UserInformation;
import org.eclipse.scada.sec.authz.signature.RequestSigner;
import org.eclipse.scada.sec.authz.signature.RequestValidator;
import org.eclipse.scada.sec.authz.signature.SignatureRequestBuilder;
import org.eclipse.scada.sec.authz.signature.X509CA;
import org.eclipse.scada.sec.authz.signature.X509KeySelector;
import org.eclipse.scada.sec.authz.signature.X509KeySelectorResult;
import org.eclipse.scada.sec.authz.signature.RequestValidator.Result;
import org.eclipse.scada.utils.collection.MapBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Document;

/**
 * @since 1.1
 * @author Jens Reimann
 */
public class SignatureRequestBuilderTest
{
    private SignatureRequestBuilder builder;

    private KeyPairGenerator kpg;

    private KeyPair kp;

    private RequestSigner signer;

    private SignatureRequestBuilder builderNoId;

    private CertificateFactory cf;

    private RequestValidator validator1;

    private RequestValidator validator2;

    private static final String CERT_FILE_1 = "platform:/plugin/org.eclipse.scada.sec.authz.signature/resources/Test1.p12";

    private static final String CA_FILE_1 = "platform:/plugin/org.eclipse.scada.sec.authz.signature/resources/SignTest1.crt";

    private static final String CERT_REV_FILE_1 = "platform:/plugin/org.eclipse.scada.sec.authz.signature/resources/TestRevoke1.p12";

    private static final String CRL_FILE_1 = "platform:/plugin/org.eclipse.scada.sec.authz.signature/resources/SignTest1.CRL.pem";

    @SuppressWarnings ( "unused" )
    private static final String CERT_FILE_2 = "platform:/plugin/org.eclipse.scada.sec.authz.signature/resources/Test2.p12";

    private static final String CA_FILE_2 = "platform:/plugin/org.eclipse.scada.sec.authz.signature/resources/SignTest2.crt";

    @Before
    public void setup () throws Exception
    {
        this.builder = new SignatureRequestBuilder ();
        this.builderNoId = new SignatureRequestBuilder ( false );

        this.kpg = KeyPairGenerator.getInstance ( "DSA" );
        this.kpg.initialize ( 512 );
        this.kp = this.kpg.generateKeyPair ();

        this.signer = new RequestSigner ( new RequestSigner.Configuration () );

        this.cf = CertificateFactory.getInstance ( "X.509" );

        final X509CA ca1 = new X509CA ( this.cf, CA_FILE_1, Collections.singleton ( CRL_FILE_1 ) );
        final X509CA ca2 = new X509CA ( this.cf, CA_FILE_2, null );

        ca1.load ();
        ca2.load ();

        this.validator1 = new RequestValidator ( new X509KeySelector ( ca1 ) );
        this.validator2 = new RequestValidator ( new X509KeySelector ( ca2 ) );
    }

    protected AuthorizationRequest makeRequest ()
    {
        final Map<String, Object> context = new HashMap<String, Object> ();

        final Map<String, Object> context2 = new HashMap<String, Object> ();
        context2.put ( "key1", "value1" );
        context2.put ( "key2", new Date () );
        context2.put ( "key3", "This is some <xml>inside</xml>" );
        context2.put ( "key4", "maybe some öü\nmore stuff" );

        context.put ( "number", 1 );
        context.put ( "sub", context2 );

        return new AuthorizationRequest ( "ITEM", "item1", "WRITE", new UserInformation ( "username" ), context );
    }

    @Test
    public void testBuild () throws Exception
    {
        final AuthorizationRequest request = makeRequest ();

        final Document doc = this.builder.buildFromRequest ( request );
        System.out.println ( this.builder.toString ( doc, true ) );
    }

    @Test
    public void testSignPrivateKey () throws Exception
    {
        final AuthorizationRequest request = makeRequest ();

        final Document doc = this.builder.buildFromRequest ( request );

        this.signer.sign ( this.kp, doc );

        System.out.println ( this.builder.toString ( doc, true ) );
    }

    @Test
    public void testValidatePublicKey () throws Exception
    {
        final AuthorizationRequest request = makeRequest ();

        final Document doc = this.builder.buildFromRequest ( request );
        this.signer.sign ( this.kp, doc );

        System.out.println ( "Key: " + this.kp.getPrivate () );

        final RequestValidator validator1 = new RequestValidator ( KeySelector.singletonKeySelector ( this.kp.getPublic () ) );
        final RequestValidator validator2 = new RequestValidator ( new KeyValueKeySelector () );

        Assert.assertTrue ( "XML Core Validation (Public Key)", validator1.validate ( doc ).isValid () );
        Assert.assertTrue ( "XML Core Validation (KeyValueKeySelector)", validator2.validate ( doc ).isValid () );
    }

    @Test
    public void testX509 () throws Exception
    {
        final AuthorizationRequest request = makeRequest ();

        final Document doc = this.builder.buildFromRequest ( request );

        final KeyStore ks = KeyStore.getInstance ( "PKCS12" );
        ks.load ( new URL ( CERT_FILE_1 ).openStream (), "test12".toCharArray () );

        // use first key
        final String useAlias = ks.aliases ().nextElement ();

        final Certificate cert = ks.getCertificate ( useAlias );
        final Key key = ks.getKey ( useAlias, "test12".toCharArray () );

        this.signer.sign ( key, null, cert, doc );

        System.out.println ( this.builder.toString ( doc, true ) );

        final Result result = this.validator1.validate ( doc );
        Assert.assertTrue ( "XML Core Validation (X509KeySelector)", result.isValid () );

        Assert.assertTrue ( "Key Result is X509", result.getKeySelectorResult () instanceof X509KeySelectorResult );
        final X509Certificate signCert = ( (X509KeySelectorResult)result.getKeySelectorResult () ).getCertificate ();
        Assert.assertNotNull ( "Certificate found", signCert );

        final String subjectName = signCert.getSubjectX500Principal ().toString ();
        Assert.assertEquals ( "Subject name", "EMAILADDRESS=test1@test.org, CN=Test1, O=openSCADA.org, L=Munich, ST=BY, C=DE", subjectName );

        System.out.println ( "1: " + signCert.getSubjectX500Principal ().getName () );
        System.out.println ( "2a: " + signCert.getSubjectX500Principal ().getName ( X500Principal.CANONICAL ) );
        System.out.println ( "2b: " + signCert.getSubjectX500Principal ().getName ( X500Principal.RFC1779 ) );
        System.out.println ( "2c: " + signCert.getSubjectX500Principal ().getName ( X500Principal.RFC2253 ) );

        final HashMap<String, String> oidMap = new HashMap<String, String> ();
        oidMap.put ( "1.2.840.113549.1.9.1", "EMAILADDRESS" );
        System.out.println ( "3b: " + signCert.getSubjectX500Principal ().getName ( X500Principal.RFC1779, oidMap ) );
        System.out.println ( "3c: " + signCert.getSubjectX500Principal ().getName ( X500Principal.RFC2253, oidMap ) );

        Assert.assertFalse ( "XML Core Validation (X509KeySelector with wrong CA)", this.validator2.validate ( doc ).isValid () );
    }

    @Test
    public void testX509Crl () throws Exception
    {
        final AuthorizationRequest request = makeRequest ();

        final Document doc = this.builder.buildFromRequest ( request );

        final KeyStore ks = KeyStore.getInstance ( "PKCS12" );
        ks.load ( new URL ( CERT_REV_FILE_1 ).openStream (), "test12".toCharArray () );

        // use first key
        final String useAlias = ks.aliases ().nextElement ();

        final Certificate cert = ks.getCertificate ( useAlias );
        final Key key = ks.getKey ( useAlias, "test12".toCharArray () );

        this.signer.sign ( key, null, cert, doc );

        System.out.println ( this.builder.toString ( doc, true ) );

        final Result result = this.validator1.validate ( doc );
        Assert.assertFalse ( "XML Core Validation fails", result.isValid () );
    }

    @Test
    public void testTransport () throws Exception
    {
        final AuthorizationRequest request = makeRequest ();

        final Document doc = this.builder.buildFromRequest ( request );

        final Document signedDoc = this.builder.fromString ( this.builder.toString ( doc, false ) );

        final KeyStore ks = KeyStore.getInstance ( "PKCS12" );
        ks.load ( new URL ( CERT_FILE_1 ).openStream (), "test12".toCharArray () );

        // use first key
        final String useAlias = ks.aliases ().nextElement ();

        final Certificate cert = ks.getCertificate ( useAlias );
        final Key key = ks.getKey ( useAlias, "test12".toCharArray () );

        this.signer.sign ( key, null, cert, signedDoc );

        final Document doc2 = this.builder.fromString ( this.builder.toString ( signedDoc, false ) );

        Assert.assertTrue ( "XML Core Validation (X509KeySelector)", this.validator1.validate ( doc2 ).isValid () );
        Assert.assertTrue ( "Check validity", this.builder.isEqual ( doc, doc2 ) );
    }

    @Test
    public void testCompare () throws Exception
    {
        testCompare1 ( makeRequest () );

        final AuthorizationRequest r1 = new AuthorizationRequest ( "ITEM", "item1", "WRITE", null, null );
        final AuthorizationRequest r2 = new AuthorizationRequest ( "ITEM", "item2", "WRITE", null, null );

        final AuthorizationRequest r3 = new AuthorizationRequest ( "ITEM", "item1", "WRITE", null, new MapBuilder<String, Object> ().put ( "value", "INT32#1" ).build () );
        final AuthorizationRequest r4 = new AuthorizationRequest ( "ITEM", "item1", "WRITE", null, new MapBuilder<String, Object> ().put ( "value", "INT32#2" ).build () );

        testCompare1 ( r1 );
        testCompare1 ( r2 );
        testCompare1 ( r3 );
        testCompare1 ( r4 );

        Assert.assertFalse ( "Should not be equal", testCompare2 ( r1, r2 ) );
        Assert.assertFalse ( "Should not be equal", testCompare2 ( r3, r4 ) );
    }

    protected void testCompare1 ( final AuthorizationRequest request ) throws Exception
    {
        final Document doc = this.builder.buildFromRequest ( request );
        final Document signed = this.builder.cloneDoc ( doc );

        this.signer.sign ( this.kp, signed );

        this.builder.compare ( doc, signed );
    }

    protected boolean testCompare2 ( final AuthorizationRequest request1, final AuthorizationRequest request2 ) throws Exception
    {
        final Document doc1 = this.builderNoId.buildFromRequest ( request1 );
        final Document doc2 = this.builderNoId.buildFromRequest ( request2 );

        try
        {
            this.builder.compare ( doc1, doc2 );
            return true;
        }
        catch ( final IllegalStateException e )
        {
            return false;
        }
    }
}
