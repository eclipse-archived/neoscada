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

import org.eclipse.scada.sec.utils.password.DigestValidator;
import org.eclipse.scada.sec.utils.password.HexCodec;
import org.eclipse.scada.sec.utils.password.PasswordEncoding;
import org.junit.Assert;
import org.junit.Test;

public class Md5Test
{
    private Map<PasswordEncoding, String> makeResult ( final String string )
    {
        final Map<PasswordEncoding, String> result = new HashMap<PasswordEncoding, String> ( 1 );
        result.put ( PasswordEncoding.PLAIN, string );
        return result;
    }

    @Test
    public void test1 () throws Exception
    {
        final DigestValidator digest = new DigestValidator ( PasswordEncoding.MD5, "UTF-8", new HexCodec () );
        Assert.assertEquals ( "Passwords do not match", true, digest.validatePassword ( makeResult ( "test12" ), "60474c9c10d7142b7508ce7a50acf414" ) );
    }

    @Test
    public void test2 () throws Exception
    {
        final DigestValidator digest = new DigestValidator ( PasswordEncoding.MD5, "UTF-8", new HexCodec () );
        Assert.assertEquals ( "Passwords do match", false, digest.validatePassword ( makeResult ( "test123" ), "60474c9c10d7142b7508ce7a50acf414" ) );
    }

    @Test
    public void test3 () throws Exception
    {
        final DigestValidator digest = new DigestValidator ( PasswordEncoding.MD5, "UTF-8", new HexCodec () );
        Assert.assertEquals ( "Passwords do not match", true, digest.validatePassword ( makeResult ( "öäü" ), "7448211b4951bf618d8b7688144295ba" ) );
    }
}
