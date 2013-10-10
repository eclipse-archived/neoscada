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

import java.security.PublicKey;
import java.security.cert.X509Certificate;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.xml.crypto.AlgorithmMethod;
import javax.xml.crypto.KeySelector;
import javax.xml.crypto.KeySelectorException;
import javax.xml.crypto.KeySelectorResult;
import javax.xml.crypto.XMLCryptoContext;
import javax.xml.crypto.XMLStructure;
import javax.xml.crypto.dsig.SignatureMethod;
import javax.xml.crypto.dsig.keyinfo.KeyInfo;
import javax.xml.crypto.dsig.keyinfo.X509Data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @since 1.1
 */
public class X509KeySelector extends KeySelector
{

    private final static Logger logger = LoggerFactory.getLogger ( X509KeySelector.class );

    private final X509CA[] cas;

    public X509KeySelector ( final X509CA ca )
    {
        this ( Collections.singleton ( ca ) );
    }

    public X509KeySelector ( final Collection<X509CA> cas )
    {
        this.cas = cas.toArray ( new X509CA[cas.size ()] );
    }

    public void reload ()
    {
        logger.debug ( "Reloading" );

        for ( final X509CA ca : this.cas )
        {
            logger.debug ( "Reloading ca: {}", ca );

            try
            {
                ca.load ();
            }
            catch ( final InterruptedException e )
            {
                logger.warn ( "Failed to reload", e );
                return;
            }
            catch ( final Exception e )
            {
                logger.warn ( "Failed to reload", e );
            }
        }
    }

    @Override
    public KeySelectorResult select ( final KeyInfo keyInfo, final KeySelector.Purpose purpose, final AlgorithmMethod method, final XMLCryptoContext context ) throws KeySelectorException
    {
        if ( keyInfo == null )
        {
            throw new KeySelectorException ( "Null KeyInfo object!" );
        }

        final SignatureMethod sm = (SignatureMethod)method;
        final List<?> list = keyInfo.getContent ();

        for ( final Object l : list )
        {
            final XMLStructure xmlStructure = (XMLStructure)l;
            if ( xmlStructure instanceof X509Data )
            {
                for ( final Object o : ( (X509Data)xmlStructure ).getContent () )
                {
                    KeySelectorResult result = null;
                    if ( o instanceof X509Certificate )
                    {
                        result = findPublicKey ( (X509Certificate)o, sm );
                    }

                    if ( result != null )
                    {
                        return result;
                    }
                }
            }
        }
        throw new KeySelectorException ( "No KeyValue element found!" );
    }

    private KeySelectorResult findPublicKey ( final X509Certificate cert, final SignatureMethod sm )
    {
        try
        {
            final PublicKey pk = cert.getPublicKey ();

            if ( pk == null || !algEquals ( sm.getAlgorithm (), pk.getAlgorithm () ) )
            {
                return null;
            }

            logger.trace ( "Checking certificate validity" );
            cert.checkValidity ();

            for ( final X509CA ca : this.cas )
            {
                logger.trace ( "Checking CA: {}", ca );

                if ( ca.isRevoked ( cert ) )
                {
                    logger.trace ( "Cert is revoked by CA" );
                    continue;
                }

                for ( final X509Certificate caCert : ca.getCertificates () )
                {
                    try
                    {
                        logger.debug ( "Checking CA validity" );
                        caCert.checkValidity ();

                        logger.debug ( "Validate certificate" );
                        // FIXME: validate CA chain
                        cert.verify ( caCert.getPublicKey () );

                        return new X509KeySelectorResult ( cert );
                    }
                    catch ( final Exception e )
                    {
                        // try next
                    }
                }

            }

        }
        catch ( final Exception e )
        {
            logger.trace ( "Failed to select key", e );
        }

        return null;
    }

    static boolean algEquals ( final String algURI, final String algName )
    {
        if ( algName.equalsIgnoreCase ( "DSA" ) && algURI.equalsIgnoreCase ( SignatureMethod.DSA_SHA1 ) )
        {
            return true;
        }
        else if ( algName.equalsIgnoreCase ( "RSA" ) && algURI.equalsIgnoreCase ( SignatureMethod.RSA_SHA1 ) )
        {
            return true;
        }
        else
        {
            logger.trace ( "Failed to check key - algUri: {}, algName: {}", algURI, algName );
            return false;
        }
    }
}