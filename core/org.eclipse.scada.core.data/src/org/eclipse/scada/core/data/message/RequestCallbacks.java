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
package org.eclipse.scada.core.data.message;

public class RequestCallbacks implements java.io.Serializable, org.eclipse.scada.core.data.RequestMessage
{
    private static final long serialVersionUID = 1L;

    public RequestCallbacks ( final org.eclipse.scada.core.data.Request request, final long callbackHandlerId, final java.util.List<org.eclipse.scada.core.data.CallbackRequest> callbacks, final Long timeoutMillis )
    {
        this.request = request;
        this.callbackHandlerId = callbackHandlerId;
        this.callbacks = callbacks;
        this.timeoutMillis = timeoutMillis;
    }

    private final org.eclipse.scada.core.data.Request request;

    @Override
    public org.eclipse.scada.core.data.Request getRequest ()
    {
        return this.request;
    }

    private final long callbackHandlerId;

    public long getCallbackHandlerId ()
    {
        return this.callbackHandlerId;
    }

    private final java.util.List<org.eclipse.scada.core.data.CallbackRequest> callbacks;

    public java.util.List<org.eclipse.scada.core.data.CallbackRequest> getCallbacks ()
    {
        return this.callbacks;
    }

    private final Long timeoutMillis;

    public Long getTimeoutMillis ()
    {
        return this.timeoutMillis;
    }

    @Override
    public String toString ()
    {
        return "[RequestCallbacks - " + "request: " + this.request + ", " + "callbackHandlerId: " + this.callbackHandlerId + ", " + "callbacks: " + this.callbacks + ", " + "timeoutMillis: " + this.timeoutMillis + "]";
    }
}
