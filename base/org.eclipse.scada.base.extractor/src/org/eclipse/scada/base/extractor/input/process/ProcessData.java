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
package org.eclipse.scada.base.extractor.input.process;

import org.eclipse.scada.base.extractor.input.Data;

public class ProcessData extends Data
{
    private final Object errorData;

    private final int returnCode;

    public ProcessData ( final Object data, final Object errorData, final int returnCode, final Throwable error )
    {
        super ( data, error );
        this.errorData = errorData;
        this.returnCode = returnCode;
    }

    public Object getErrorData ()
    {
        return this.errorData;
    }

    public int getReturnCode ()
    {
        return this.returnCode;
    }

    @Override
    public String toString ()
    {
        return String.format ( "[%s - data: '%s', errorData: '%s', returnCode: %s, error: '%s']", getClass (), getData (), this.errorData, this.returnCode, getError () );
    }
}
