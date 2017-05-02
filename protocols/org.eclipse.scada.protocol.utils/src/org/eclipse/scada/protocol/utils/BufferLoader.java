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
package org.eclipse.scada.protocol.utils;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.LinkedList;
import java.util.List;

import org.apache.mina.core.buffer.IoBuffer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.io.LineProcessor;
import com.google.common.io.Resources;

public class BufferLoader
{

    private final static Logger logger = LoggerFactory.getLogger ( BufferLoader.class );

    public static List<IoBuffer> loadBuffersFromResource ( final Class<?> clazz, final String resourceName ) throws IOException
    {
        logger.debug ( "Loading buffer - {}", resourceName );

        final URL url = Resources.getResource ( clazz, resourceName );

        return Resources.readLines ( url, Charset.forName ( "UTF-8" ), new LineProcessor<List<IoBuffer>> () {

            private final List<IoBuffer> result = new LinkedList<> ();

            private IoBuffer buffer = null;

            protected void pushBuffer ()
            {
                if ( this.buffer == null )
                {
                    return;
                }

                this.buffer.flip ();
                this.result.add ( this.buffer );

                this.buffer = null;
            }

            @Override
            public boolean processLine ( String line ) throws IOException
            {
                line = line.replaceAll ( "#.*", "" ); // clear comments

                if ( line.isEmpty () )
                {
                    pushBuffer ();
                    return true;
                }

                final String[] toks = line.split ( "\\s+" );

                if ( toks.length <= 0 )
                {
                    pushBuffer ();
                    return true;
                }

                if ( this.buffer == null )
                {
                    // start a new buffer
                    this.buffer = IoBuffer.allocate ( 0 );
                    this.buffer.setAutoExpand ( true );
                }

                for ( final String tok : toks )
                {
                    this.buffer.put ( Byte.parseByte ( tok, 16 ) );
                }
                return true;
            }

            @Override
            public List<IoBuffer> getResult ()
            {
                pushBuffer (); // last chance to add something
                return this.result;
            }
        } );
    }
}
