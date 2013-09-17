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

public class DigestBase
{
    private final MessageDigest digest;

    private final Charset passwordCharset;

    public DigestBase ( final String algorithm, final String passwordCharsetEncoder )
    {
        this.passwordCharset = Charset.forName ( passwordCharsetEncoder );

        MessageDigest digest = null;
        try
        {
            digest = MessageDigest.getInstance ( algorithm );
        }
        catch ( final NoSuchAlgorithmException e )
        {
        }
        this.digest = digest;
    }

    protected byte[] makeDigest ( final String providedPassword ) throws NoSuchAlgorithmException
    {
        if ( this.digest == null )
        {
            throw new NoSuchAlgorithmException ();
        }

        final ByteBuffer data = this.passwordCharset.encode ( providedPassword );
        this.digest.update ( data.array (), 0, data.remaining () );
        return this.digest.digest ();
    }
}
