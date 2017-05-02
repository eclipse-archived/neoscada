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
import java.util.Map;
import java.util.TreeMap;

/**
 * A generic control file <br/>
 * This type can be used to implement other control files are directly.
 */
public class GenericControlFile
{
    private final Map<ControlFieldDefinition, ControlField> fields = new TreeMap<ControlFieldDefinition, ControlField> ();

    public GenericControlFile ()
    {
    }

    public void set ( final ControlField field )
    {
        this.fields.put ( field.getDefinition (), field );
    }

    public void set ( final ControlFieldDefinition definition, final String value )
    {
        this.fields.put ( definition, definition.createField ( value ) );
    }

    public ControlField get ( final ControlFieldDefinition definition )
    {
        return this.fields.get ( definition );
    }

    public String getValue ( final ControlFieldDefinition definition )
    {
        final ControlField field = this.fields.get ( definition );
        if ( field == null )
        {
            return null;
        }
        return field.getValue ();
    }

    public void write ( final ControlFileWriter writer ) throws IOException
    {
        for ( final Map.Entry<ControlFieldDefinition, ControlField> entry : this.fields.entrySet () )
        {
            writer.writeField ( entry.getValue () );
        }
    }

}
