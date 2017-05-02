/*******************************************************************************
 * Copyright (c) 2011, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - further development
 *******************************************************************************/
package org.eclipse.scada.sec.utils.password;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class DigestValidator implements PasswordValidator
{

    private final PasswordDigestCodec passwordDigestCodec;

    private final PasswordEncoding storedEncoding;

    private final List<PasswordEncoding> supportedInputEncodings;

    private final Charset passwordCharset;

    public DigestValidator ( final PasswordEncoding storedEncoding, final String passwordCharsetEncoder, final PasswordDigestCodec passwordDigestCodec )
    {
        this.storedEncoding = storedEncoding;
        this.passwordDigestCodec = passwordDigestCodec;
        this.supportedInputEncodings = Collections.unmodifiableList ( Arrays.asList ( storedEncoding, PasswordEncoding.PLAIN ) );
        this.passwordCharset = Charset.forName ( passwordCharsetEncoder );
    }

    @Override
    public List<PasswordEncoding> getSupportedInputEncodings ()
    {
        return this.supportedInputEncodings;
    }

    @Override
    public boolean validatePassword ( final Map<PasswordEncoding, String> passwords, final String storedPassword ) throws Exception
    {
        final byte[] storedDigest = this.passwordDigestCodec.decode ( storedPassword );

        final String encodedPassword = passwords.get ( this.storedEncoding );
        if ( encodedPassword != null )
        {
            final byte[] providedDigest = new HexCodec ().decode ( encodedPassword );
            return MessageDigest.isEqual ( providedDigest, storedDigest );
        }

        final String plainPassword = passwords.get ( PasswordEncoding.PLAIN );
        if ( plainPassword != null )
        {
            final byte[] providedDigest = makeDigest ( plainPassword );
            return MessageDigest.isEqual ( providedDigest, storedDigest );
        }

        return false;
    }

    private byte[] makeDigest ( final String plainPassword ) throws NoSuchAlgorithmException
    {
        final MessageDigest digest = this.storedEncoding.getDigest ();

        final ByteBuffer data = this.passwordCharset.encode ( plainPassword );
        digest.update ( data.array (), 0, data.remaining () );
        return digest.digest ();
    }
}
