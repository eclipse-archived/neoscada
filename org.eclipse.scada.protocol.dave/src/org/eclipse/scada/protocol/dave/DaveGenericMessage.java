/*******************************************************************************
 * Copyright (c) 2010, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - refactoring for a generic memory driver system
 *******************************************************************************/

package org.eclipse.scada.protocol.dave;

import org.apache.mina.core.buffer.IoBuffer;

public class DaveGenericMessage extends DaveMessage
{
    private final IoBuffer parameters;

    private final IoBuffer data;

    public DaveGenericMessage ( final IoBuffer parameters, final IoBuffer data )
    {
        this.parameters = parameters;
        this.data = data;
    }

    public IoBuffer getData ()
    {
        return this.data;
    }

    public IoBuffer getParameters ()
    {
        return this.parameters;
    }

    @Override
    public String toString ()
    {
        return String.format ( "Generic Message : Parameters: %s, Data: %s", this.parameters, this.data );
    }

}
