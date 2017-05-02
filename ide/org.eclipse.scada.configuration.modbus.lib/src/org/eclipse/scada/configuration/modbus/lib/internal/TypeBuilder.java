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
package org.eclipse.scada.configuration.modbus.lib.internal;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.scada.configuration.modbus.ModbusDataType;

public class TypeBuilder
{
    private final ModbusDataType dataType;

    private Double factor;

    public TypeBuilder ( final ModbusDataType dataType )
    {
        this.dataType = dataType;
    }

    public TypeBuilder ( final TypeBuilder builder )
    {
        this.dataType = builder.dataType;
    }

    public TypeBuilder scaled ( final double factor )
    {
        final TypeBuilder copy = new TypeBuilder ( this );
        copy.factor = factor;
        return copy;
    }

    public ModbusDataType build ()
    {
        final ModbusDataType copy = EcoreUtil.copy ( this.dataType );
        if ( this.factor != null )
        {
            copy.setScale ( this.factor );
        }
        return copy;
    }
}