/*******************************************************************************
 * Copyright (c) 2010, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - implement security callback system
 *******************************************************************************/
package org.eclipse.scada.hd.data.message;

public class CloseQuery implements java.io.Serializable
{
    private static final long serialVersionUID = 1L;

    public CloseQuery ( final long queryId )
    {
        this.queryId = queryId;
    }

    private final long queryId;

    public long getQueryId ()
    {
        return this.queryId;
    }

    @Override
    public String toString ()
    {
        return "[CloseQuery - " + "queryId: " + this.queryId + "]";
    }
}
