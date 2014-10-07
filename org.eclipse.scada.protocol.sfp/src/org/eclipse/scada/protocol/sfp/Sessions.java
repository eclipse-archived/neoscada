/*******************************************************************************
 * Copyright (c) 2013, 2014 Jens Reimann and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Jens Reimann - initial API and implementation
 *     IBH SYSTEMS GmbH - add logging
 *******************************************************************************/
package org.eclipse.scada.protocol.sfp;

import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

import org.apache.mina.core.session.IoSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Sessions
{

    private final static Logger logger = LoggerFactory.getLogger ( Sessions.class );

    public static final String DEFAULT_CHARSET_NAME = "UTF-8";

    public static final String ATTR_CHARSET = "charset";

    public static final String ATTR_LITTLE_ENDIAN = "littleEndian";

    public static CharsetEncoder getCharsetEncoder ( final IoSession session )
    {
        final Object charset = session.getAttribute ( ATTR_CHARSET, Charset.forName ( DEFAULT_CHARSET_NAME ) );
        if ( charset instanceof Charset )
        {
            return ( (Charset)charset ).newEncoder ();
        }
        else
        {
            return Charset.forName ( DEFAULT_CHARSET_NAME ).newEncoder ();
        }
    }

    public static CharsetDecoder getCharsetDecoder ( final IoSession session )
    {
        final Object charset = session.getAttribute ( ATTR_CHARSET, Charset.forName ( DEFAULT_CHARSET_NAME ) );
        if ( charset instanceof Charset )
        {
            return ( (Charset)charset ).newDecoder ();
        }
        else
        {
            return Charset.forName ( DEFAULT_CHARSET_NAME ).newDecoder ();
        }
    }

    public static void setCharset ( final IoSession session, final Charset charset )
    {
        logger.info ( "Setting character encoding to {} - session: {}", charset != null ? charset.name () : null, session );
        session.setAttribute ( ATTR_CHARSET, charset );
    }

    public static void setLittleEndian ( final IoSession session )
    {
        logger.info ( "Setting byte order to little endian - session: {}", session );
        session.setAttribute ( ATTR_LITTLE_ENDIAN );
    }

    public static boolean isLittleEndian ( final IoSession session )
    {
        return session.containsAttribute ( ATTR_LITTLE_ENDIAN );
    }

}
