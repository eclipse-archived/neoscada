/*******************************************************************************
 * Copyright (c) 2011, 2016 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     IBH SYSTEMS GmbH - add "requireSsl"
 *******************************************************************************/
package org.eclipse.scada.protocol.ngp.common;

import java.io.File;
import java.security.KeyStore;
import java.util.Map;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.TrustManagerFactory;

import org.apache.mina.filter.ssl.KeyStoreFactory;
import org.apache.mina.filter.ssl.SslContextFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class SslHelper
{

    private final static Logger logger = LoggerFactory.getLogger ( SslHelper.class );

    private SslHelper ()
    {
    }

    protected static String get ( final Map<String, String> properties, final String key, final String defaultValue )
    {
        final String value = properties.get ( key );
        if ( value != null )
        {
            return value;
        }
        return defaultValue;
    }

    public static boolean isSslRequired ( final Map<String, String> properties )
    {
        return properties.containsKey ( "requireSsl" ) && properties.get ( "requireSsl" ) != null && Boolean.parseBoolean ( properties.get ( "requireSsl" ) );
    }

    // FIXME: this should be able to reload at some point, maybe mina does it. need to check.
    public static SslContextFactory createDefaultSslFactory ( final Map<String, String> properties, final boolean clientMode ) throws Exception
    {
        final boolean requireSsl = isSslRequired ( properties );

        final File defaultKeyStoreFile = findDefaultKeyStore ();

        final String keyStoreFileName = get ( properties, "sslKeyStoreFile", null );
        File keyStoreFile = keyStoreFileName != null ? new File ( keyStoreFileName ) : null;

        if ( keyStoreFile == null && defaultKeyStoreFile == null && !requireSsl )
        {
            // no STATS_KEY store provided and no default key store found
            // no ssl
            return null;
        }
        if ( keyStoreFile == null && defaultKeyStoreFile != null )
        {
            // no specific key store file and default key store file exists and is readable
            logger.debug ( "Using default key store file: {}", defaultKeyStoreFile );
            keyStoreFile = defaultKeyStoreFile;
        }

        if ( keyStoreFile == null )
        {
            // no key store to use
            return null;
        }

        final String trustStoreFile = get ( properties, "sslTrustStoreFile", keyStoreFile.getAbsolutePath () );

        final String password = get ( properties, "sslPassword", null );

        final String keyStorePassword = get ( properties, "sslKeyStorePassword", password );
        final String trustStorePassword = get ( properties, "sslTrustStorePassword", keyStorePassword );
        final String keyPassword = get ( properties, "sslKeyPassword", keyStorePassword );

        if ( ( keyStorePassword == null || trustStorePassword == null || keyPassword == null ) && !requireSsl )
        {
            // no ssl
            return null;
        }

        final SslContextFactory factory = new SslContextFactory ();

        logger.debug ( "Default KeyStore: {}", KeyStore.getDefaultType () );
        logger.debug ( "Default KeyManagerFactory: {}", KeyManagerFactory.getDefaultAlgorithm () );
        logger.debug ( "Default TrustManagerFactory: {}", TrustManagerFactory.getDefaultAlgorithm () );

        final KeyStoreFactory keyStoreFactory = new KeyStoreFactory ();
        keyStoreFactory.setDataFile ( keyStoreFile );
        keyStoreFactory.setPassword ( keyStorePassword );

        final KeyStoreFactory trustStoreFactory = new KeyStoreFactory ();
        trustStoreFactory.setDataFile ( new File ( trustStoreFile ) );
        trustStoreFactory.setPassword ( trustStorePassword );

        factory.setKeyManagerFactoryKeyStore ( keyStoreFactory.newInstance () );
        factory.setTrustManagerFactoryKeyStore ( trustStoreFactory.newInstance () );

        factory.setKeyManagerFactoryKeyStorePassword ( keyPassword );

        return factory;
    }

    private static File findDefaultKeyStore ()
    {
        File file;

        file = testKeyStore ( System.getProperty ( "user.home" ) + "/.eclipseScada/keystore" );
        if ( file != null )
        {
            return file;
        }

        file = testKeyStore ( System.getProperty ( "user.home" ) + "/.eclipse.scada/keystore" );
        if ( file != null )
        {
            return file;
        }

        file = testKeyStore ( System.getProperty ( "java.home" ) + "/lib/security/cacerts" );
        if ( file != null )
        {
            return file;
        }

        return null;
    }

    private static File testKeyStore ( final String name )
    {
        logger.debug ( "Testing: {}", name );

        if ( name == null )
        {
            return null;
        }

        final File file = new File ( name );
        if ( !file.canRead () )
        {
            return null;
        }

        logger.info ( "Considering: {}", name );

        return file;
    }
}
