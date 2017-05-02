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
package org.eclipse.scada.sec.utils.password;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @since 1.1
 */
public enum PasswordEncoding
{
    PLAIN
    {
        private final PasswordEncoder encoder = new PasswordEncoder () {

            @Override
            public String encodePassword ( final String password )
            {
                return password;
            }
        };

        @Override
        public PasswordEncoder getEncoder ( final String characterEncoding, final PasswordDigestCodec codec ) throws Exception
        {
            return this.encoder;
        }

        @Override
        public MessageDigest getDigest () throws NoSuchAlgorithmException
        {
            return null;
        }
    },
    MD5
    {
        @Override
        public MessageDigest getDigest () throws NoSuchAlgorithmException
        {
            return MessageDigest.getInstance ( "MD5" );
        }

        @Override
        public PasswordEncoder getEncoder ( final String characterEncoding, final PasswordDigestCodec codec ) throws Exception
        {
            return new DigestEncoder ( "MD5", characterEncoding, codec );
        }
    },
    SHA1
    {
        @Override
        public PasswordEncoder getEncoder ( final String characterEncoding, final PasswordDigestCodec codec ) throws Exception
        {
            return new DigestEncoder ( "SHA1", characterEncoding, codec );
        }

        @Override
        public MessageDigest getDigest () throws NoSuchAlgorithmException
        {
            return MessageDigest.getInstance ( "SHA1" );
        }
    };

    public abstract PasswordEncoder getEncoder ( String characterEncoding, PasswordDigestCodec codec ) throws Exception;

    public String encodeToString ( final String password, final String characterEncoding, final PasswordDigestCodec codec ) throws Exception
    {
        return getEncoder ( characterEncoding, codec ).encodePassword ( password );
    }

    public String encodeToHexString ( final String password ) throws Exception
    {
        return encodeToString ( password, "UTF-8", new HexCodec () );
    }

    /**
     * @return the message digest or <code>null</code> if none is used
     * @throws NoSuchAlgorithmException
     */
    public abstract MessageDigest getDigest () throws NoSuchAlgorithmException;

}
