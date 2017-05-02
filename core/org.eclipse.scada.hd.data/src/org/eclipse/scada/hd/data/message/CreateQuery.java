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

public class CreateQuery implements java.io.Serializable
{
    private static final long serialVersionUID = 1L;

    public CreateQuery ( final org.eclipse.scada.core.data.Request request, final long queryId, final String itemId, final boolean updateData, final org.eclipse.scada.hd.data.QueryParameters queryParameters )
    {
        this.request = request;
        this.queryId = queryId;
        this.itemId = itemId;
        this.updateData = updateData;
        this.queryParameters = queryParameters;
    }

    private final org.eclipse.scada.core.data.Request request;

    public org.eclipse.scada.core.data.Request getRequest ()
    {
        return this.request;
    }

    private final long queryId;

    public long getQueryId ()
    {
        return this.queryId;
    }

    private final String itemId;

    public String getItemId ()
    {
        return this.itemId;
    }

    private final boolean updateData;

    public boolean isUpdateData ()
    {
        return this.updateData;
    }

    private final org.eclipse.scada.hd.data.QueryParameters queryParameters;

    public org.eclipse.scada.hd.data.QueryParameters getQueryParameters ()
    {
        return this.queryParameters;
    }

    @Override
    public String toString ()
    {
        return "[CreateQuery - " + "request: " + this.request + ", " + "queryId: " + this.queryId + ", " + "itemId: " + this.itemId + ", " + "updateData: " + this.updateData + ", " + "queryParameters: " + this.queryParameters + "]";
    }
}
