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

import java.util.HashMap;
import java.util.Map;

import org.eclipse.scada.sec.utils.password.PasswordEncoding;
import org.eclipse.scada.sec.utils.password.PasswordType;
import org.eclipse.scada.sec.utils.password.PasswordValidator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ValidationTest
{
    private PasswordValidator plainValidator;

    @Before
    public void setup ()
    {
        this.plainValidator = PasswordType.PLAIN.createValdiator ();
    }

    @Test
    public void testPlain1 () throws Exception
    {
        final HashMap<PasswordEncoding, String> passwords = new HashMap<PasswordEncoding, String> ();
        Assert.assertFalse ( "Empty result map", this.plainValidator.validatePassword ( passwords, "test12" ) );
    }

    @Test
    public void testPlain2 () throws Exception
    {
        final String password = "test12";
        Assert.assertTrue ( "Provided PLAIN", this.plainValidator.validatePassword ( makeMap ( password, PasswordEncoding.PLAIN ), password ) );
        Assert.assertTrue ( "Provided MD5", this.plainValidator.validatePassword ( makeMap ( password, PasswordEncoding.MD5 ), password ) );
        Assert.assertTrue ( "Provided SHA1", this.plainValidator.validatePassword ( makeMap ( password, PasswordEncoding.SHA1 ), password ) );
    }

    @Test
    public void testPlain3 () throws Exception
    {
        final String password = "test12";
        Assert.assertTrue ( "Provided PLAIN, MD5 and SHA1", this.plainValidator.validatePassword ( makeMap ( password, PasswordEncoding.PLAIN, PasswordEncoding.MD5, PasswordEncoding.SHA1 ), password ) );
    }

    private Map<PasswordEncoding, String> makeMap ( final String password, final PasswordEncoding... encodings ) throws Exception
    {
        final Map<PasswordEncoding, String> result = new HashMap<PasswordEncoding, String> ( 1 );

        for ( final PasswordEncoding encoding : encodings )
        {
            result.put ( encoding, encoding.encodeToHexString ( password ) );
        }

        return result;
    }

}
