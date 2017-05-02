/*******************************************************************************
 * Copyright (c) 2010, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.protocol.iso8073;

import org.apache.mina.core.buffer.IoBuffer;

public class DataTPDU
{
    private final IoBuffer data;

    public DataTPDU ( final IoBuffer data )
    {
        this.data = data;
    }

    public IoBuffer getData ()
    {
        return this.data;
    }

    @Override
    public String toString ()
    {
        return this.data.toString ();
    }
}
