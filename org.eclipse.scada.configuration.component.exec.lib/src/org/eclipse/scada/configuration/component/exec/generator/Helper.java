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
package org.eclipse.scada.configuration.component.exec.generator;

import org.eclipse.scada.configuration.world.osgi.DataType;
import org.eclipse.scada.da.exec.configuration.VariantTypeType;

public final class Helper
{
    private Helper ()
    {
    }

    public static VariantTypeType convert ( final DataType dataType )
    {
        switch ( dataType )
        {
            case BOOLEAN:
                return VariantTypeType.BOOLEAN;
            case FLOAT:
                return VariantTypeType.DOUBLE;
            case INT32:
                return VariantTypeType.INTEGER;
            case INT64:
                return VariantTypeType.STRING;
            case NULL:
                return VariantTypeType.STRING;
            case STRING:
                return VariantTypeType.STRING;
            case VARIANT:
                return VariantTypeType.STRING;
        }
        throw new IllegalArgumentException ( String.format ( "Data type %s is unknown", dataType ) );
    }
}
