/*******************************************************************************
 * Copyright (c) 2013 Jens Reimann and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Jens Reimann - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.protocol.sfp.messages;

import org.eclipse.scada.core.Variant;

public class WriteCommand
{
    private final int registerNumber;

    private final Variant value;

    private final int operationId;

    public WriteCommand ( final int registerNumber, final Variant value, final int operationId )
    {
        this.registerNumber = registerNumber;
        this.value = value;
        this.operationId = operationId;
    }

    public int getRegisterNumber ()
    {
        return this.registerNumber;
    }

    public Variant getValue ()
    {
        return this.value;
    }

    public int getOperationId ()
    {
        return this.operationId;
    }
}
