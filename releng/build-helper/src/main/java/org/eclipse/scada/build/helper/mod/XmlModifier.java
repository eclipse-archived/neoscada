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
package org.eclipse.scada.build.helper.mod;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.regex.Pattern;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

/**
 * @since 0.0.15
 */
public class XmlModifier
{
    private static class Modification implements Comparable<Modification>
    {
        int start;

        int end;

        String data;

        @Override
        public int compareTo ( final Modification o )
        {
            return Integer.compare ( this.start, o.start );
        }
    }

    private final List<Modification> mods = new LinkedList<> ();

    private final File inputFile;

    public XmlModifier ( final File inputFile )
    {
        this.inputFile = inputFile;
    }

    public void set ( final String expression, final int targetElement, final String value ) throws IOException, XMLStreamException
    {
        int pos = 0;

        final Stack<String> ele = new Stack<> ();

        final Pattern pattern = Pattern.compile ( expression );

        final XMLEventReader reader;

        Modification mod = null;

        final XMLInputFactory xmlinf = XMLInputFactory.newInstance ();
        try (final FileInputStream is = new FileInputStream ( this.inputFile ))
        {
            reader = xmlinf.createXMLEventReader ( is );
            try
            {
                while ( reader.hasNext () )
                {
                    final XMLEvent event = (XMLEvent)reader.next ();
                    if ( event instanceof StartElement )
                    {
                        final StartElement startEvent = event.asStartElement ();
                        ele.push ( startEvent.getName ().getLocalPart () );
                    }
                    else if ( event instanceof EndElement )
                    {
                        final EndElement endEvent = event.asEndElement ();
                        final String en = ele.pop ();
                        if ( !endEvent.getName ().getLocalPart ().equals ( en ) )
                        {
                            throw new IllegalStateException ( "Element error: " + en + " / " + endEvent.getName () );
                        }
                    }

                    boolean inMatch = mod != null;
                    final boolean match = isMatch ( ele, pattern );
                    if ( inMatch && !match )
                    {
                        // end
                        if ( pos == targetElement )
                        {
                            this.mods.add ( mod );
                        }
                        pos++;
                        mod = null;
                    }
                    else if ( !inMatch && match )
                    {
                        // starting
                        mod = new Modification ();
                        mod.start = event.getLocation ().getCharacterOffset ();
                        mod.data = value;
                    }
                    else if ( inMatch && match )
                    {
                        mod.end = event.getLocation ().getCharacterOffset () - 2;
                    }
                    inMatch = match;
                }
            }
            finally
            {
                reader.close ();
            }
        }
    }

    public void set ( final String expression, final String value ) throws Exception
    {
        set ( expression, 0, value );
    }

    private boolean isMatch ( final Stack<String> ele, final Pattern pattern )
    {
        final String path = makePath ( ele );
        return pattern.matcher ( path ).matches ();
    }

    private String makePath ( final Stack<String> ele )
    {
        final StringBuilder sb = new StringBuilder ();
        for ( final String e : ele )
        {
            sb.append ( '/' );
            sb.append ( e );
        }
        return sb.toString ();
    }

    public void write ( final File outputFile ) throws IOException
    {
        if ( this.mods.isEmpty () )
        {
            // no changes
            if ( outputFile.getCanonicalFile ().equals ( this.inputFile.getCanonicalFile () ) )
            {
                // same file, to nothing
                return;
            }

            // different file, plain copy
            Files.copy ( this.inputFile.toPath (), outputFile.toPath (), StandardCopyOption.REPLACE_EXISTING );
            return;
        }

        Collections.sort ( this.mods );

        int pos = 0;

        final Path path = Files.createTempFile ( "set-version", null );
        Files.copy ( this.inputFile.toPath (), path, StandardCopyOption.REPLACE_EXISTING );

        try
        {
            try (
                    FileInputStream fis = new FileInputStream ( path.toFile () );
                    FileOutputStream fos = new FileOutputStream ( outputFile ))
            {
                for ( final Modification mod : this.mods )
                {
                    System.out.println ( String.format ( "Start: %s, End: %s, Data: %s", mod.start, mod.end, mod.data ) );

                    final int start = mod.start;
                    final int end = mod.end;
                    final String replacement = mod.data;

                    // FIXME: advance faster then byte by byte
                    while ( pos < start )
                    {
                        fos.write ( fis.read () );
                        pos++;
                    }

                    final int len = end - start;

                    fis.skip ( len );
                    pos += len;
                    final byte[] r = replacement.getBytes ();
                    fos.write ( r );
                }

                // do the rest
                int len;
                final byte buffer[] = new byte[1024];
                while ( ( len = fis.read ( buffer ) ) > 0 )
                {
                    fos.write ( buffer, 0, len );
                }
            }
        }
        finally
        {
            Files.delete ( path );
        }
    }
}
