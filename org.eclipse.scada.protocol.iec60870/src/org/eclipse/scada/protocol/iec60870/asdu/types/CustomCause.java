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
package org.eclipse.scada.protocol.iec60870.asdu.types;

class CustomCause implements Cause
{
    private final short value;

    private String label;

    CustomCause ( final int value )
    {
        this.value = (short)value;
    }

    CustomCause ( final int value, final String label )
    {
        this.value = (short)value;
        this.label = label;
    }

    @Override
    public short getValue ()
    {
        return this.value;
    }

    @Override
    public String toString ()
    {
        return this.label != null ? String.format ( "[%s:%s]", this.value, this.label ) : String.format ( "[%s]", this.value );
    }
}
