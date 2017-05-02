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
package org.eclipse.scada.utils.pkg.deb.control;

import java.io.IOException;
import java.io.Writer;

/**
 * A control field instance <br/>
 * Can be created using {@link ControlFieldDefinition#createField(String)} or
 * {@link ControlFieldDefinition#createField(String, String)}
 */
public class ControlField
{
    private final String value;

    private final String firstLine;

    private final ControlFieldDefinition definition;

    ControlField ( final ControlFieldDefinition definition, final String value, final String firstLine )
    {
        this.definition = definition;
        this.value = value;
        this.firstLine = firstLine;
    }

    public ControlFieldDefinition getDefinition ()
    {
        return this.definition;
    }

    public String getFirstLine ()
    {
        return this.firstLine;
    }

    public String getValue ()
    {
        return this.value;
    }

    public void write ( final Writer writer ) throws IOException
    {
        final String name = this.definition.getName ();
        final FieldType type = this.definition.getType ();

        writer.write ( name );
        writer.write ( ": " );
        switch ( type )
        {
            case SIMPLE:
                writeSimpleValue ( writer );
                break;
            case FOLDED:
                writeFoldedValue ( writer );
                break;
            case MULTILINE:
                writeMultiLineValue ( writer );
                break;
        }
    }

    private void writeSimpleValue ( final Writer writer ) throws IOException
    {
        writer.write ( this.value );
        writer.write ( '\n' );
    }

    private void writeFoldedValue ( final Writer writer ) throws IOException
    {
        writeLines ( writer, true, 78 );
    }

    private void writeMultiLineValue ( final Writer writer ) throws IOException
    {
        writeLines ( writer, false, Integer.MAX_VALUE );
    }

    private void writeLines ( final Writer writer, final boolean ignoreFirstLine, final int maxLineLength ) throws IOException
    {
        boolean lineBreak = false;

        if ( !ignoreFirstLine )
        {
            if ( this.firstLine != null )
            {
                writer.write ( this.firstLine );
            }
            writer.write ( '\n' );
            lineBreak = true;
        }

        int lineLength = 0;
        final int len = this.value.length ();
        for ( int i = 0; i < len; i++ )
        {
            final char c = this.value.charAt ( i );
            switch ( c )
            {
                case '\n':
                    if ( lineBreak )
                    {
                        writer.write ( " ." );
                    }
                    writer.write ( '\n' );
                    lineBreak = true;
                    lineLength = 0;
                    break;
                default:
                    if ( lineLength > maxLineLength )
                    {
                        // we break the line before we start to write anything
                        // in order to not write empty lines
                        lineLength = 0;
                        lineBreak = true;
                        writer.write ( '\n' );
                    }
                    if ( lineBreak )
                    {
                        // handle the line break
                        // no matter if it came from wrapping or a source line break
                        lineBreak = false;
                        writer.write ( ' ' );
                    }

                    // now write the character
                    writer.write ( c );
                    lineLength++;
                    break;
            }
        }
        writer.write ( '\n' );
    }
}
