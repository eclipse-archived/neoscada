/*******************************************************************************
 * Copyright (c) 2010 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.core;

import org.eclipse.scada.utils.lang.Immutable;

@Immutable
public class WriteResult
{
    private Throwable error = null;

    /**
     * A pre-existing OK result
     */
    public static final WriteResult OK = new WriteResult ();

    /**
     * Create an "OK" result
     */
    public WriteResult ()
    {
    }

    /**
     * Create a result with error information
     * @param error the error or <code>null</code> if the result is "ok"
     */
    public WriteResult ( final Throwable error )
    {
        this.error = error;
    }

    public Throwable getError ()
    {
        return this.error;
    }

    public boolean isError ()
    {
        return this.error != null;
    }

    public boolean isSuccess ()
    {
        return this.error == null;
    }
}