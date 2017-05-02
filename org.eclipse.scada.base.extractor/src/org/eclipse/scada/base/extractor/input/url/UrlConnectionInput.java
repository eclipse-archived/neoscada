/*******************************************************************************
 * Copyright (c) 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.base.extractor.input.url;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.concurrent.ScheduledExecutorService;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.scada.base.extractor.input.AbstractScheduledInput;
import org.eclipse.scada.base.extractor.input.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UrlConnectionInput extends AbstractScheduledInput
{

    private final static Logger logger = LoggerFactory.getLogger ( UrlConnectionInput.class );

    private final URL url;

    private final boolean probeCharset;

    private final Charset charset;

    public UrlConnectionInput ( final ScheduledExecutorService executor, final URL url, final boolean probeCharset, final long period )
    {
        super ( executor, period );
        this.url = url;
        this.probeCharset = probeCharset;
        this.charset = null;
    }

    public UrlConnectionInput ( final ScheduledExecutorService executor, final URL url, final Charset charset, final long period )
    {
        super ( executor, period );
        this.url = url;
        this.probeCharset = false;
        this.charset = charset;
    }

    @Override
    protected Data makeData () throws Exception
    {
        final URLConnection connection = this.url.openConnection ();
        connection.connect ();

        final int len = connection.getContentLength ();

        final ByteArrayOutputStream bos = new ByteArrayOutputStream ( len > 0 ? len : 0 );

        final byte[] buffer = new byte[4096];
        try ( InputStream stream = connection.getInputStream () )
        {
            int rc;
            while ( ( rc = stream.read ( buffer ) ) > 0 )
            {
                bos.write ( buffer, 0, rc );
            }
            bos.close ();
        }

        final String encoding = connection.getContentEncoding ();
        final String type = connection.getContentType ();

        logger.debug ( "Content-Encoding: {}", encoding );
        logger.debug ( "Content-Type: {}", type );

        Charset charset = null;

        if ( this.charset != null )
        {
            charset = this.charset;
        }
        else if ( this.probeCharset )
        {
            charset = makeCharsetFromType ( type );
        }

        return new UrlConnectionData ( convert ( buffer, charset ), null );
    }

    private static Pattern typePattern = Pattern.compile ( ".*charset=([a-zA-Z-0-9]+?)" );

    private Charset makeCharsetFromType ( final String type )
    {
        final Matcher m = typePattern.matcher ( type );
        if ( !m.matches () )
        {
            return null;
        }

        final String charset = m.group ( 1 );
        try
        {
            return Charset.forName ( charset );
        }
        catch ( final Exception e )
        {
            logger.warn ( "Failed to find charset", e );
            return null;
        }
    }
}
