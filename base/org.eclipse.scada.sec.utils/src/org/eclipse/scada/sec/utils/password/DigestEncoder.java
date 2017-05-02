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

import java.security.NoSuchAlgorithmException;

public class DigestEncoder extends DigestBase implements PasswordEncoder
{

    private final PasswordDigestCodec passwordDigestCodec;

    public DigestEncoder ( final String algorithm, final String passwordCharsetEncoder, final PasswordDigestCodec passwordDigestCodec )
    {
        super ( algorithm, passwordCharsetEncoder );
        this.passwordDigestCodec = passwordDigestCodec;
    }

    @Override
    public String encodePassword ( final String password ) throws NoSuchAlgorithmException
    {
        return this.passwordDigestCodec.encode ( makeDigest ( password ) );
    }
}
