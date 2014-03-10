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
package org.eclipse.scada.base.extractor.input;

public class Data
{
    private final Object data;

    private final Throwable error;

    public Data ( final Object data, final Throwable error )
    {
        this.data = data;
        this.error = error;
    }

    public Object getData ()
    {
        return this.data;
    }

    public Throwable getError ()
    {
        return this.error;
    }

    @Override
    public String toString ()
    {
        return String.format ( "[%s - data: '%s', error: '%s']", getClass (), this.data, this.error );
    }

}
