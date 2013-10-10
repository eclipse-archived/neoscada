/*******************************************************************************
 * Copyright (c) 2010, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.core.net;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.compression.CompressionFilter;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.filter.ssl.SslFilter;
import org.eclipse.scada.core.ConnectionInformation;
import org.eclipse.scada.net.mina.GMPPProtocolDecoder;
import org.eclipse.scada.net.mina.GMPPProtocolEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConnectionHelper
{

    private final static Logger logger = LoggerFactory.getLogger ( ConnectionHelper.class );

    private static final class X509TrustManagerImplementation implements X509TrustManager
    {
        @Override
        public void checkClientTrusted ( final X509Certificate[] arg0, final String arg1 ) throws CertificateException
        {
            logger.info ( "checkClientTrusted: " + arg0 + "/" + arg1 );
        }

        @Override
        public void checkServerTrusted ( final X509Certificate[] arg0, final String arg1 ) throws CertificateException
        {
            logger.info ( "checkServerTrusted: " + arg0 + "/" + arg1 );
        }

        @Override
        public X509Certificate[] getAcceptedIssuers ()
        {
            logger.info ( "getAcceptedIssuers" );
            return new X509Certificate[0];
        }
    }

    public static void injectCompression ( final IoSession session, final String compressionMode )
    {
        logger.debug ( "Prepare for compression filter injection: {}", compressionMode );

        final CompressionFilter compressionFilter = createCompressionFilter ( compressionMode );
        if ( compressionFilter == null )
        {
            return;
        }

        if ( !session.getFilterChain ().contains ( "compress" ) )
        {
            logger.debug ( "Injecting compression filter: {}", compressionFilter );
            session.getFilterChain ().addFirst ( "compress", compressionFilter );
        }
    }

    private static CompressionFilter createCompressionFilter ( final String compressionMode )
    {
        if ( compressionMode != null )
        {
            logger.debug ( "Compression mode {}", compressionMode );
            int level = CompressionFilter.COMPRESSION_DEFAULT;
            try
            {
                level = Integer.parseInt ( compressionMode );
            }
            catch ( final Exception e )
            {
                logger.warn ( "Failed to parse 'compress' property", e );
            }
            if ( level < CompressionFilter.COMPRESSION_DEFAULT || level > CompressionFilter.COMPRESSION_MAX )
            {
                logger.warn ( "Compression ({}) outside of valid range. Setting to default", level );
                level = CompressionFilter.COMPRESSION_DEFAULT;
            }

            logger.debug ( "Creating filter with compression mode: {}", level );
            return new CompressionFilter ( level );
        }
        else
        {
            return null;
        }
    }

    /**
     * Setup the filter chain of a NET/GMPP connection
     * 
     * @param connectionInformation
     *            the connection information to use
     * @param filterChainBuilder
     *            the chain builder
     */
    public static void setupFilterChain ( final ConnectionInformation connectionInformation, final DefaultIoFilterChainBuilder filterChainBuilder, final boolean isClient )
    {
        // set up compression
        final CompressionFilter compressionFilter = createCompressionFilter ( connectionInformation.getProperties ().get ( "compress" ) );
        if ( compressionFilter != null )
        {
            filterChainBuilder.addLast ( "compress", compressionFilter );
        }

        // set up ssl
        final String ssl = connectionInformation.getProperties ().get ( "ssl" );
        if ( ssl != null )
        {
            initSsl ( connectionInformation, filterChainBuilder, isClient );
        }

        // set up logging
        final String trace = connectionInformation.getProperties ().get ( "trace" );
        if ( trace != null )
        {
            filterChainBuilder.addLast ( "logging", new LoggingFilter () );
        }

        // add the main codec
        filterChainBuilder.addLast ( "codec", new ProtocolCodecFilter ( new GMPPProtocolEncoder (), new GMPPProtocolDecoder () ) );
    }

    /**
     * FIXME: still need to implement correctly
     * 
     * @param connectionInformation
     * @param filterChainBuilder
     * @param isClient
     */
    protected static void initSsl ( final ConnectionInformation connectionInformation, final DefaultIoFilterChainBuilder filterChainBuilder, final boolean isClient )
    {
        SSLContext sslContext = null;
        try
        {
            sslContext = createContext ( connectionInformation );
            sslContext.init ( getKeyManagers ( connectionInformation, isClient ), getTrustManagers ( connectionInformation ), getRandom ( connectionInformation ) );
        }
        catch ( final Throwable e )
        {
            logger.warn ( "Failed to enable SSL", e );
        }

        if ( sslContext != null )
        {
            final SslFilter filter = new SslFilter ( sslContext );
            filter.setUseClientMode ( isClient );
            filterChainBuilder.addFirst ( "sslFilter", filter );
        }
    }

    private static SSLContext createContext ( final ConnectionInformation connectionInformation ) throws NoSuchAlgorithmException
    {
        String sslProtocol = connectionInformation.getProperties ().get ( "sslProtocol" );
        if ( sslProtocol == null || sslProtocol.length () == 0 )
        {
            sslProtocol = "SSLv3";
        }

        return SSLContext.getInstance ( sslProtocol );
    }

    private static SecureRandom getRandom ( final ConnectionInformation connectionInformation ) throws NoSuchAlgorithmException
    {
        final String sslRandom = connectionInformation.getProperties ().get ( "sslRandom" );

        SecureRandom random = null;
        if ( sslRandom != null && sslRandom.length () > 0 )
        {
            random = SecureRandom.getInstance ( sslRandom );
            return random;
        }
        return null;
    }

    private static TrustManager[] getTrustManagers ( final ConnectionInformation connectionInformation )
    {
        return new TrustManager[] { new X509TrustManagerImplementation () };
    }

    private static KeyManager[] getKeyManagers ( final ConnectionInformation connectionInformation, final boolean isClient ) throws KeyStoreException, NoSuchAlgorithmException, UnrecoverableKeyException, CertificateException, IOException
    {
        if ( isClient )
        {
            return null;
        }

        final KeyStore keyStore;

        keyStore = createKeyStore ( connectionInformation );

        final String keyManagerFactory = KeyManagerFactory.getDefaultAlgorithm ();
        final KeyManagerFactory kmf = KeyManagerFactory.getInstance ( keyManagerFactory );

        kmf.init ( keyStore, getPassword ( connectionInformation, "sslCertPassword" ) );

        return kmf.getKeyManagers ();
    }

    private static KeyStore createKeyStore ( final ConnectionInformation connectionInformation ) throws KeyStoreException, NoSuchAlgorithmException, CertificateException, IOException
    {
        final KeyStore keyStore;
        final String keyStoreType = connectionInformation.getProperties ().get ( "sslKeyStoreType" );
        if ( keyStoreType != null )
        {
            keyStore = KeyStore.getInstance ( keyStoreType );
        }
        else
        {
            keyStore = KeyStore.getInstance ( KeyStore.getDefaultType () );
        }

        keyStore.load ( getKeyStoreStream ( connectionInformation ), getPassword ( connectionInformation, "sslKeyStorePassword" ) );

        return keyStore;
    }

    private static InputStream getKeyStoreStream ( final ConnectionInformation connectionInformation ) throws IOException
    {
        final String uri = connectionInformation.getProperties ().get ( "sslKeyStoreUri" );
        final URL url = new URL ( uri );
        return url.openStream ();
    }

    private static char[] getPassword ( final ConnectionInformation connectionInformation, final String propertyName )
    {
        final char[] passwordChars;
        final String password = connectionInformation.getProperties ().get ( propertyName );
        if ( password != null )
        {
            passwordChars = password.toCharArray ();
        }
        else
        {
            passwordChars = null;
        }
        return passwordChars;
    }
}
