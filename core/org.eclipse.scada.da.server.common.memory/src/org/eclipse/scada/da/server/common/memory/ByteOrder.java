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
package org.eclipse.scada.da.server.common.memory;

import org.apache.mina.core.buffer.IoBuffer;
import org.eclipse.scada.da.server.common.memory.accessor.Getter;
import org.eclipse.scada.da.server.common.memory.accessor.Setter;

public enum ByteOrder
{
    LITTLE_ENDIAN
    {
        @Override
        public <T> T get ( final IoBuffer data, final int index, final Getter<T> getter )
        {
            final java.nio.ByteOrder order = data.order ();
            try
            {
                data.order ( java.nio.ByteOrder.LITTLE_ENDIAN );
                return getter.get ( data, index );
            }
            finally
            {
                data.order ( order );
            }
        }

        @Override
        public <T> void put ( final IoBuffer data, final Setter<T> setter, final T value )
        {
            final java.nio.ByteOrder order = data.order ();
            try
            {
                data.order ( java.nio.ByteOrder.LITTLE_ENDIAN );
                setter.put ( data, value );
            }
            finally
            {
                data.order ( order );
            }
        }

    },
    BIG_ENDIAN
    {
        @Override
        public <T> T get ( final IoBuffer data, final int index, final Getter<T> getter )
        {
            final java.nio.ByteOrder order = data.order ();
            try
            {
                data.order ( java.nio.ByteOrder.BIG_ENDIAN );
                return getter.get ( data, index );
            }
            finally
            {
                data.order ( order );
            }
        }

        @Override
        public <T> void put ( final IoBuffer data, final Setter<T> setter, final T value )
        {
            final java.nio.ByteOrder order = data.order ();
            try
            {
                data.order ( java.nio.ByteOrder.BIG_ENDIAN );
                setter.put ( data, value );
            }
            finally
            {
                data.order ( order );
            }
        }

    };

    public static ByteOrder DEFAULT;

    static
    {
        try
        {
            DEFAULT = ByteOrder.valueOf ( System.getProperty ( "org.eclipse.scada.da.server.common.memory.defaultByteOrder", BIG_ENDIAN.toString () ) );
        }
        catch ( final Throwable e )
        {
            DEFAULT = BIG_ENDIAN;
        }
    }

    public abstract <T> T get ( IoBuffer data, int index, Getter<T> getter );

    public abstract <T> void put ( IoBuffer data, Setter<T> setter, T value );
}
