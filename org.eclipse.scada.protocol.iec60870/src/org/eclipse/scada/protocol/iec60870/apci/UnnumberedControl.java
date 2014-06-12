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
package org.eclipse.scada.protocol.iec60870.apci;

public class UnnumberedControl extends APCIBase
{
    public static enum Function
    {
        STARTDT_ACT ( (byte)4 ),
        STARTDT_CONFIRM ( (byte)8 ),
        STOPDT_ACT ( (byte)16 ),
        STOPDT_CONFIRM ( (byte)32 ),
        TESTFR_ACT ( (byte)64 ),
        TESTFR_CONFIRM ( (byte)128 );

        private byte numericValue;

        Function ( final byte numericValue )
        {
            this.numericValue = numericValue;
        }

        public byte getNumericValue ()
        {
            return this.numericValue;
        }
    }

    private final Function function;

    public UnnumberedControl ( final Function function )
    {
        super ( APCIType.U );
        this.function = function;
    }

    public Function getFunction ()
    {
        return this.function;
    }

    @Override
    public String toString ()
    {
        return String.format ( "[APCI:U:%s]", this.function );
    }

}
