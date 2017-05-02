/*******************************************************************************
 * Copyright (c) 2006, 2010 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/package org.eclipse.scada.utils.str;

import static org.junit.Assert.assertEquals;

import org.eclipse.scada.utils.str.StringEncoder;
import org.junit.Test;

public class EncoderTest
{

    @Test
    public void testEncode ()
    {
        assertEquals ( "abc", StringEncoder.encode ( "abc" ) );
        assertEquals ( "123", StringEncoder.encode ( "123" ) );
        assertEquals ( "", StringEncoder.encode ( "" ) );
        assertEquals ( "+", StringEncoder.encode ( " " ) );
        assertEquals ( "+++", StringEncoder.encode ( "   " ) );
        assertEquals ( "%2B", StringEncoder.encode ( "+" ) );
    }

    @Test
    public void testDecode ()
    {
        assertEquals ( "abc", StringEncoder.decode ( "abc" ) );
        assertEquals ( "123", StringEncoder.decode ( "123" ) );
        assertEquals ( "", StringEncoder.decode ( "" ) );
        assertEquals ( " ", StringEncoder.decode ( "+" ) );
        assertEquals ( "   ", StringEncoder.decode ( "+++" ) );
        assertEquals ( "+", StringEncoder.decode ( "%2B" ) );
    }

    private void assertStringEquals ( final String string )
    {
        assertEquals ( string, StringEncoder.decode ( StringEncoder.encode ( string ) ) );
    }

    @Test
    public void testBoth ()
    {
        assertStringEquals ( "abc" );
        assertStringEquals ( "123" );
        assertStringEquals ( "" );
        assertStringEquals ( "%" );
        assertStringEquals ( "%20" );
        assertStringEquals ( " " );
        assertStringEquals ( "+" );
    }

}
