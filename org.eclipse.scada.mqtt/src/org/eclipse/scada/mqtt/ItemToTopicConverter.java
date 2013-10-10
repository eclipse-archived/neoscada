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

public class ItemToTopicConverter implements NameConverter
{
    private final Character delimiter;

    private final String prefix;

    private final String writeValueSuffix;

    public ItemToTopicConverter ( final Character delimiter, final String prefix, final String writeValueSuffix )
    {
        this.delimiter = delimiter;
        this.prefix = prefix;
        this.writeValueSuffix = writeValueSuffix;
    }

    @Override
    public String convert ( final String name, final boolean writable )
    {
        if ( name == null )
        {
            return null;
        }
        return ( this.prefix == null ? "" : this.prefix ) + name.replace ( this.delimiter, '/' ) + ( writable && ( this.writeValueSuffix != null ) ? this.writeValueSuffix : "" );
    }

}
