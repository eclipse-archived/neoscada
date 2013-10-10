/*******************************************************************************
 * Copyright (c) 2013 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.mqtt;

import java.util.regex.Pattern;

public class TopicToItemConverter implements NameConverter
{
    private final Character delimiter;

    private final String prefix;

    private final String writeValueSuffix;

    public TopicToItemConverter ( final Character delimiter, final String prefix, final String writeValueSuffix )
    {
        this.delimiter = delimiter;
        this.prefix = prefix;
        this.writeValueSuffix = writeValueSuffix;

    }

    @Override
    public String convert ( String name, final boolean writable )
    {
        if ( name == null )
        {
            return null;
        }
        if ( this.prefix != null )
        {
            name = name.replaceFirst ( Pattern.quote ( this.prefix ), "" );
        }
        name = name.replace ( '/', this.delimiter );
        if ( writable && ( this.writeValueSuffix != null ) )
        {
            name = name.replace ( Pattern.quote ( this.writeValueSuffix ), "" );
        }
        return name;
    }
}
