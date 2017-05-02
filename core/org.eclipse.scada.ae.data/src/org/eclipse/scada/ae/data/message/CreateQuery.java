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
package org.eclipse.scada.ae.data.message;

public class CreateQuery implements java.io.Serializable
{
    private static final long serialVersionUID = 1L;

    public CreateQuery ( final long queryId, final String queryType, final String queryData )
    {
        this.queryId = queryId;
        this.queryType = queryType;
        this.queryData = queryData;
    }

    private final long queryId;

    public long getQueryId ()
    {
        return this.queryId;
    }

    private final String queryType;

    public String getQueryType ()
    {
        return this.queryType;
    }

    private final String queryData;

    public String getQueryData ()
    {
        return this.queryData;
    }

    @Override
    public String toString ()
    {
        return "[CreateQuery - " + "queryId: " + this.queryId + ", " + "queryType: " + this.queryType + ", " + "queryData: " + this.queryData + "]";
    }
}
