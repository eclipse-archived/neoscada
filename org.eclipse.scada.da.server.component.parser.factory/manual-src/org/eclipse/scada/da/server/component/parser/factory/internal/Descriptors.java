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
package org.eclipse.scada.da.server.component.parser.factory.internal;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.scada.base.extractor.convert.ValueConverter;
import org.eclipse.scada.base.extractor.extract.pattern.FieldSpec;
import org.eclipse.scada.base.extractor.extract.pattern.MainFieldSpec;
import org.eclipse.scada.base.extractor.extract.pattern.NumberFieldSpec;
import org.eclipse.scada.base.extractor.extract.pattern.StringFieldSpec;
import org.eclipse.scada.base.extractor.extract.pattern.ValueFieldDescriptor;
import org.eclipse.scada.core.VariantType;
import org.eclipse.scada.da.server.component.parser.factory.configuration.AttributeValue;
import org.eclipse.scada.da.server.component.parser.factory.configuration.Field;
import org.eclipse.scada.da.server.component.parser.factory.configuration.MainGroupField;
import org.eclipse.scada.da.server.component.parser.factory.configuration.NumericGroupField;
import org.eclipse.scada.da.server.component.parser.factory.configuration.StringGroupField;
import org.eclipse.scada.da.server.component.parser.factory.configuration.ValueConverterDefinition;
import org.eclipse.scada.da.server.component.parser.factory.configuration.ValueDescriptor;

public final class Descriptors
{
    private Descriptors ()
    {
    }

    public static ValueConverter createConverter ( final ValueConverterDefinition def )
    {
        if ( def == null )
        {
            return null;
        }
        return def.createConverter ();
    }

    public static ValueFieldDescriptor convert ( final ValueDescriptor descriptor )
    {
        if ( descriptor == null )
        {
            return null;
        }

        final Map<String, FieldSpec> attributes = new HashMap<> ();

        for ( final AttributeValue attr : descriptor.getAttributes () )
        {
            attributes.put ( attr.getName (), convert ( attr.getField () ) );
        }

        return new ValueFieldDescriptor ( convert ( descriptor.getPrimaryValue () ), attributes );
    }

    private static FieldSpec convert ( final Field field )
    {
        if ( field == null )
        {
            return null;
        }

        if ( field instanceof MainGroupField )
        {
            return new MainFieldSpec ( convert ( field.getType () ) );
        }
        else if ( field instanceof NumericGroupField )
        {
            return new NumberFieldSpec ( ( (NumericGroupField)field ).getGroupNumber (), convert ( field.getType () ) );
        }
        else if ( field instanceof StringGroupField )
        {
            return new StringFieldSpec ( ( (StringGroupField)field ).getGroupName (), convert ( field.getType () ) );
        }
        throw new RuntimeException ( String.format ( "Unsupported field type: %s", field.getClass ().getName () ) );
    }

    private static VariantType convert ( final org.eclipse.scada.da.server.component.parser.factory.configuration.VariantType type )
    {
        if ( type == null || type == org.eclipse.scada.da.server.component.parser.factory.configuration.VariantType.DEFAULT )
        {
            return null;
        }
        return VariantType.valueOf ( type.name () );
    }
}
