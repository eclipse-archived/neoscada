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

import java.security.KeyException;
import java.security.PublicKey;
import java.util.List;

import javax.xml.crypto.AlgorithmMethod;
import javax.xml.crypto.KeySelector;
import javax.xml.crypto.KeySelectorException;
import javax.xml.crypto.KeySelectorResult;
import javax.xml.crypto.XMLCryptoContext;
import javax.xml.crypto.XMLStructure;
import javax.xml.crypto.dsig.SignatureMethod;
import javax.xml.crypto.dsig.keyinfo.KeyInfo;
import javax.xml.crypto.dsig.keyinfo.KeyValue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @since 1.1
 */
public class KeyValueKeySelector extends KeySelector
{

    private final static Logger logger = LoggerFactory.getLogger ( KeyValueKeySelector.class );

    @Override
    public KeySelectorResult select ( final KeyInfo keyInfo, final KeySelector.Purpose purpose, final AlgorithmMethod method, final XMLCryptoContext context ) throws KeySelectorException
    {
        if ( keyInfo == null )
        {
            throw new KeySelectorException ( "Null KeyInfo object!" );
        }

        final SignatureMethod sm = (SignatureMethod)method;
        final List<?> list = keyInfo.getContent ();

        for ( int i = 0; i < list.size (); i++ )
        {
            final XMLStructure xmlStructure = (XMLStructure)list.get ( i );
            if ( xmlStructure instanceof KeyValue )
            {
                try
                {
                    final PublicKey pk = ( (KeyValue)xmlStructure ).getPublicKey ();
                    // make sure algorithm is compatible with method
                    if ( algEquals ( sm.getAlgorithm (), pk.getAlgorithm () ) )
                    {
                        return new SimpleKeySelectorResult ( pk );
                    }
                }
                catch ( final KeyException ke )
                {
                    throw new KeySelectorException ( ke );
                }

            }
        }
        throw new KeySelectorException ( "No KeyValue element found!" );
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
            logger.warn ( "Failed to check key - algUri: {}, algName: {}", algURI, algName );
            return false;
        }
    }
}