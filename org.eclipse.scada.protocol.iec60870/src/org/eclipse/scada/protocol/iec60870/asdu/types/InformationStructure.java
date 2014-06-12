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

public enum InformationStructure
{
    SINGLE /*0*/
    {
        @Override
        public byte encode ( final int size )
        {
            return (byte) ( 0b01111111 & size );
        }
    },
    SEQUENCE /*1*/
    {
        @Override
        public byte encode ( final int size )
        {
            return (byte) ( 0b10000000 | size );
        }
    };

    public abstract byte encode ( final int size );
}
