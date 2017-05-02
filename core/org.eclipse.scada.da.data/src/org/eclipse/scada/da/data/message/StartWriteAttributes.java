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
package org.eclipse.scada.da.data.message;

public class StartWriteAttributes implements java.io.Serializable, org.eclipse.scada.core.data.RequestMessage
{
    private static final long serialVersionUID = 1L;

    public StartWriteAttributes ( final org.eclipse.scada.core.data.Request request, final String itemId, final java.util.Map<String, org.eclipse.scada.core.Variant> attributes, final org.eclipse.scada.core.data.OperationParameters operationParameters, final Long callbackHandlerId )
    {
        this.request = request;
        this.itemId = itemId;
        this.attributes = attributes;
        this.operationParameters = operationParameters;
        this.callbackHandlerId = callbackHandlerId;
    }

    private final org.eclipse.scada.core.data.Request request;

    @Override
    public org.eclipse.scada.core.data.Request getRequest ()
    {
        return this.request;
    }

    private final String itemId;

    public String getItemId ()
    {
        return this.itemId;
    }

    private final java.util.Map<String, org.eclipse.scada.core.Variant> attributes;

    public java.util.Map<String, org.eclipse.scada.core.Variant> getAttributes ()
    {
        return this.attributes;
    }

    private final org.eclipse.scada.core.data.OperationParameters operationParameters;

    public org.eclipse.scada.core.data.OperationParameters getOperationParameters ()
    {
        return this.operationParameters;
    }

    private final Long callbackHandlerId;

    public Long getCallbackHandlerId ()
    {
        return this.callbackHandlerId;
    }

    @Override
    public String toString ()
    {
        return "[StartWriteAttributes - " + "request: " + this.request + ", " + "itemId: " + this.itemId + ", " + "attributes: " + this.attributes + ", " + "operationParameters: " + this.operationParameters + ", " + "callbackHandlerId: " + this.callbackHandlerId + "]";
    }
}
