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

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class PlainValidator implements PasswordValidator
{

    private static final List<PasswordEncoding> ENCODINGS = Arrays.asList ( PasswordEncoding.SHA1, PasswordEncoding.MD5, PasswordEncoding.PLAIN );

    private final boolean ignoreCase;

    public PlainValidator ( final boolean ignoreCase )
    {
        this.ignoreCase = ignoreCase;
    }

    @Override
    public List<PasswordEncoding> getSupportedInputEncodings ()
    {
        return ENCODINGS;
    }

    @Override
    public boolean validatePassword ( final Map<PasswordEncoding, String> passwords, final String storedPassword ) throws Exception
    {
        for ( final PasswordEncoding encoding : ENCODINGS )
        {
            final String providedPassword = passwords.get ( encoding );
            if ( providedPassword == null )
            {
                continue;
            }

            final String storedEncoded = encoding.encodeToHexString ( storedPassword );

            return comparePassword ( providedPassword, storedEncoded );
        }

        return false;
    }

    private boolean comparePassword ( final String providedPassword, final String storedPassword )
    {
        if ( this.ignoreCase )
        {
            return providedPassword.equalsIgnoreCase ( storedPassword );
        }
        else
        {
            return providedPassword.equals ( storedPassword );
        }
    }

}
