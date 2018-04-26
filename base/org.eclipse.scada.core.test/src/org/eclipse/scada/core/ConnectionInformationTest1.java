/*******************************************************************************
 * Copyright (c) 2006, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.core;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.eclipse.scada.core.ConnectionInformation;
import org.junit.Assert;
import org.junit.Test;

public class ConnectionInformationTest1
{

    protected void testParserEqual ( final String uri, final ConnectionInformation expected )
    {
        final ConnectionInformation actual = ConnectionInformation.fromURI ( uri );
        assertNotNull ( "Object is null", actual );
        assertEquals ( expected, actual );
    }

    @Test
    public void test1 () throws Throwable
    {
        final ConnectionInformation.Builder expected = new ConnectionInformation.Builder ();
        expected.setInterface ( "da" );
        expected.setDriver ( "net" );
        expected.setTarget ( "localhost" );
        expected.setSecondaryTarget ( 1202 );

        testParserEqual ( "da:net://localhost:1202", expected.build () );
    }

    @Test
    public void test2 () throws Throwable
    {
        final ConnectionInformation.Builder expected = new ConnectionInformation.Builder ();
        expected.setInterface ( "da" );
        expected.setProperty ( "user", "user" );
        expected.setProperty ( "password", "password" );
        expected.setDriver ( "net" );
        expected.setTarget ( "localhost" );
        expected.setSecondaryTarget ( 1202 );

        testParserEqual ( "da:net://user:password@localhost:1202", expected.build () );
    }

    @Test
    public void test3 () throws Throwable
    {
        final ConnectionInformation.Builder expected = new ConnectionInformation.Builder ();
        expected.setInterface ( "da" );
        expected.setDriver ( "net" );
        expected.setTarget ( "localhost" );
        expected.setSecondaryTarget ( 1202 );
        expected.addSubTarget ( "sub1" );
        expected.addSubTarget ( "sub2" );

        testParserEqual ( "da:net://localhost:1202/sub1/sub2", expected.build () );
    }

    @Test
    public void test4 () throws Throwable
    {
        final ConnectionInformation.Builder expected = new ConnectionInformation.Builder ();
        expected.setInterface ( "da" );
        expected.setDriver ( "net" );
        expected.setTarget ( "localhost" );
        expected.setSecondaryTarget ( 1202 );

        testParserEqual ( "da:net://localhost:1202/", expected.build () );
    }

    @Test
    public void test5 () throws Throwable
    {
        final ConnectionInformation.Builder expected = new ConnectionInformation.Builder ();
        expected.setInterface ( "da" );
        expected.setDriver ( "net" );
        expected.setTarget ( "localhost" );
        expected.setSecondaryTarget ( 1202 );
        expected.setProperty ( "key", "value" );

        testParserEqual ( "da:net://localhost:1202?key=value", expected.build () );
    }

    @Test
    public void test6 () throws Throwable
    {
        final ConnectionInformation.Builder expected = new ConnectionInformation.Builder ();
        expected.setInterface ( "da" );
        expected.setDriver ( "net" );
        expected.setTarget ( "localhost" );
        expected.setSecondaryTarget ( 1202 );
        expected.setProperty ( "key1", "value1" );
        expected.setProperty ( "key2", "value2" );

        testParserEqual ( "da:net://localhost:1202?key1=value1&key2=value2", expected.build () );
    }

    @Test
    public void test6a () throws Throwable
    {
        final ConnectionInformation.Builder expected = new ConnectionInformation.Builder ();
        expected.setInterface ( "da" );
        expected.setDriver ( "net" );
        expected.setTarget ( "localhost" );
        expected.setSecondaryTarget ( 1202 );
        expected.setProperty ( "key1", "value1" );
        expected.setProperty ( "key2", "value2" );

        testParserEqual ( "da:net://localhost:1202?key2=value2&key1=value1", expected.build () );
    }

    @Test
    public void test6b () throws Throwable
    {
        final ConnectionInformation.Builder expected = new ConnectionInformation.Builder ();
        expected.setInterface ( "da" );
        expected.setDriver ( "net" );
        expected.setTarget ( "localhost" );
        expected.setSecondaryTarget ( 1202 );
        expected.setProperty ( "key1", "value1" );
        expected.setProperty ( "key2", "value2" );

        testParserEqual ( "da:net://localhost:1202?key2=value3&key1=value1&key2=value2", expected.build () );
    }

    @Test
    public void test7 () throws Throwable
    {
        final ConnectionInformation.Builder expected = new ConnectionInformation.Builder ();
        expected.setInterface ( "da" );
        expected.setDriver ( "net" );
        expected.setProperty ( "user", "user" );
        expected.setProperty ( "password", "password" );
        expected.setTarget ( "localhost" );
        expected.addSubTarget ( "sub1" );
        expected.addSubTarget ( "sub2" );
        expected.setSecondaryTarget ( 1202 );
        expected.setProperty ( "key1", "value1" );
        expected.setProperty ( "key2", "value2" );

        testParserEqual ( "da:net://user:password@localhost:1202/sub1/sub2?key1=value1&key2=value2", expected.build () );
    }

    @Test
    public void test8 () throws Throwable
    {
        final ConnectionInformation.Builder expected = new ConnectionInformation.Builder ();
        expected.setInterface ( "da" );
        expected.setDriver ( "net" );
        expected.setProperty ( "user", ":" );
        expected.setProperty ( "password", ":" );
        expected.setTarget ( "localhost" );
        expected.addSubTarget ( ":" );
        expected.addSubTarget ( ":" );
        expected.setSecondaryTarget ( 1202 );
        expected.setProperty ( ":", ":" );

        testParserEqual ( "da:net://%3A:%3A@localhost:1202/%3A/%3A?%3A=%3A", expected.build () );
    }

    @Test
    public void test9 () throws Throwable
    {
        final ConnectionInformation.Builder expected = new ConnectionInformation.Builder ();
        expected.setInterface ( "da" );
        expected.setDriver ( "net" );
        expected.setProperty ( "user", "&" );
        expected.setProperty ( "password", "&" );
        expected.setTarget ( "localhost" );
        expected.addSubTarget ( "&" );
        expected.addSubTarget ( "&" );
        expected.setSecondaryTarget ( 1202 );
        expected.setProperty ( "&", "&" );

        testParserEqual ( "da:net://%26:%26@localhost:1202/%26/%26?%26=%26", expected.build () );
    }

    @Test
    public void test10 () throws Throwable
    {
        final ConnectionInformation.Builder expected = new ConnectionInformation.Builder ();
        expected.setInterface ( "da" );
        expected.setDriver ( "net" );
        expected.setProperty ( "user", "%" );
        expected.setProperty ( "password", "%" );
        expected.setTarget ( "localhost" );
        expected.addSubTarget ( "%" );
        expected.addSubTarget ( "%" );
        expected.setSecondaryTarget ( 1202 );
        expected.setProperty ( "%", "%" );

        testParserEqual ( "da:net://%25:%25@localhost:1202/%25/%25?%25=%25", expected.build () );
    }

    @Test
    public void test11 () throws Throwable
    {
        final ConnectionInformation.Builder expected = new ConnectionInformation.Builder ();
        expected.setInterface ( "da" );
        expected.setDriver ( "net" );
        expected.setProperty ( "user", "%" );
        expected.setProperty ( "password", "%" );
        expected.setTarget ( "localhost" );
        expected.addSubTarget ( "%" );
        expected.addSubTarget ( "%" );
        expected.setSecondaryTarget ( 1202 );
        expected.setProperty ( "%", "%" );

        testParserEqual ( "da:net://%25:%25@localhost:1202/%25/%25?%25=%25", expected.build () );
    }

    @Test
    public void test12 () throws Throwable
    {
        final ConnectionInformation.Builder expected = new ConnectionInformation.Builder ();
        expected.setInterface ( "da" );
        expected.setDriver ( "net" );
        expected.setProperty ( "user", "user" );
        expected.setProperty ( "password", "password" );
        expected.setTarget ( "localhost" );
        expected.setSecondaryTarget ( 1202 );
        expected.addSubTarget ( "sub1" );
        expected.addSubTarget ( "sub2" );
        expected.setProperty ( "key", "value" );
        Assert.assertEquals ( "da:net://user:password@localhost:1202/sub1/sub2?key=value", expected.build ().toString () );
    }

    @Test
    public void test13a () throws Throwable
    {
        final ConnectionInformation o = ConnectionInformation.fromURI ( "da:ngp://localhost" );
        assertNull ( o );
    }

    @Test
    public void test13b () throws Throwable
    {
        final ConnectionInformation.Builder expected = new ConnectionInformation.Builder ();
        expected.setInterface ( "da" );
        expected.setDriver ( "net" );
        expected.setTarget ( "localhost" );

        assertNull ( expected.build () );
    }

    @Test
    public void testEquals1 () throws Throwable
    {
        Assert.assertEquals ( ConnectionInformation.fromURI ( "da:net://localhost:1202" ), ConnectionInformation.fromURI ( "da:net://localhost:1202" ) );
    }

    @Test
    public void testEquals2 () throws Throwable
    {
        Assert.assertNotSame ( ConnectionInformation.fromURI ( "da:net://localhost:1202" ), ConnectionInformation.fromURI ( "da:net://localhost:1203" ) );
    }
}
