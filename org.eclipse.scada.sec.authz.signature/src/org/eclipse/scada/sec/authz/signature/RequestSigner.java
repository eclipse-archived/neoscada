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

import java.security.Key;
import java.security.KeyPair;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import javax.xml.crypto.dsig.CanonicalizationMethod;
import javax.xml.crypto.dsig.DigestMethod;
import javax.xml.crypto.dsig.Reference;
import javax.xml.crypto.dsig.SignatureMethod;
import javax.xml.crypto.dsig.SignedInfo;
import javax.xml.crypto.dsig.Transform;
import javax.xml.crypto.dsig.XMLSignature;
import javax.xml.crypto.dsig.XMLSignatureFactory;
import javax.xml.crypto.dsig.dom.DOMSignContext;
import javax.xml.crypto.dsig.keyinfo.KeyInfo;
import javax.xml.crypto.dsig.keyinfo.KeyInfoFactory;
import javax.xml.crypto.dsig.spec.C14NMethodParameterSpec;
import javax.xml.crypto.dsig.spec.TransformParameterSpec;

import org.w3c.dom.Document;

/**
 * @since 1.1
 */
public class RequestSigner
{

    private final XMLSignatureFactory fac;

    private final DigestMethod md;

    private final KeyInfoFactory kif;

    private final Transform t;

    private final Reference ref;

    private final CanonicalizationMethod cm;

    private String fromAlg ( final String alg )
    {
        if ( "DSA".equals ( alg ) )
        {
            return SignatureMethod.DSA_SHA1;
        }
        else if ( "RSA".equals ( alg ) )
        {
            return SignatureMethod.RSA_SHA1;
        }
        else if ( "HMAC".equals ( alg ) )
        {
            return SignatureMethod.HMAC_SHA1;
        }
        else
        {
            throw new IllegalArgumentException ( String.format ( "Key algorithm '%s' is not supported", alg ) );
        }
    }

    public static class Configuration
    {
        private String digestMethod = DigestMethod.SHA1;

        public void setDigestMethod ( final String digestMethod )
        {
            this.digestMethod = digestMethod;
        }

        public String getDigestMethod ()
        {
            return this.digestMethod;
        }
    }

    public RequestSigner ( final Configuration configuration ) throws Exception
    {
        this.fac = XMLSignatureFactory.getInstance ( "DOM" );
        this.md = this.fac.newDigestMethod ( configuration.getDigestMethod (), null );
        this.kif = this.fac.getKeyInfoFactory ();

        this.t = this.fac.newTransform ( Transform.ENVELOPED, (TransformParameterSpec)null );
        this.ref = this.fac.newReference ( "", this.md, Collections.singletonList ( this.t ), null, null );
        this.cm = this.fac.newCanonicalizationMethod ( CanonicalizationMethod.INCLUSIVE, (C14NMethodParameterSpec)null );
    }

    public void sign ( final Key privateKey, final Certificate cert, final Document doc ) throws Exception
    {
        sign ( privateKey, null, cert, doc );
    }

    public synchronized void sign ( final KeyPair kp, final Document doc ) throws Exception
    {
        sign ( kp.getPrivate (), kp.getPublic (), null, doc );
    }

    synchronized void sign ( final Key privateKey, final PublicKey publicKey, final Certificate cert, final Document doc ) throws Exception
    {
        final DOMSignContext dsc = new DOMSignContext ( privateKey, doc.getDocumentElement () );

        final SignatureMethod sm = this.fac.newSignatureMethod ( fromAlg ( privateKey.getAlgorithm () ), null );

        final SignedInfo si = this.fac.newSignedInfo ( this.cm, sm, Collections.singletonList ( this.ref ) );

        final List<Object> data = new LinkedList<Object> ();

        if ( cert != null )
        {
            data.add ( this.kif.newKeyValue ( cert.getPublicKey () ) );
            data.add ( this.kif.newX509Data ( Collections.singletonList ( cert ) ) );
        }
        else
        {
            data.add ( this.kif.newKeyValue ( publicKey ) );
        }

        final KeyInfo ki = this.kif.newKeyInfo ( data );

        final XMLSignature signature = this.fac.newXMLSignature ( si, ki );

        // finally sign
        signature.sign ( dsc );
    }

}
