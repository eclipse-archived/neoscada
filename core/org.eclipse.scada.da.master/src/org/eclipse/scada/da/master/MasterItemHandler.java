/*******************************************************************************
 * Copyright (c) 2009, 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.master;

import java.util.Map;

import org.eclipse.scada.da.client.DataItemValue;

public interface MasterItemHandler
{
    /**
     * Called when data changed or the handler chain changed.
     * <p>
     * The call gets a context object provided which each handler can use to store context information of one calculation run. Each calculation run gets a fresh new context. The context is intended to
     * pass data from one handler to the next.
     * </p>
     * <p>
     * Although the value parameter is a mutable type, the handler may only make changes inside the dataUpdate method.
     * </p>
     * 
     * @param context
     *            the context object
     * @param value
     *            the changed value
     */
    public abstract void dataUpdate ( Map<String, Object> context, DataItemValue.Builder value );

    /**
     * Handle a write request
     * <p>
     * This method is called when a master item received a write request. It will then pass on the request to all MasterItemHandler in order to process or alter the write request. Each handler returns
     * a result and then the next handler will received that altered write request.
     * </p>
     * <p>
     * If null is returned instead of a new write result, original write request is used and it is considered that the handler has done nothing.
     * </p>
     * 
     * @param request
     *            the write request to handle
     * @return the resulting write request
     */
    public abstract WriteRequestResult processWrite ( WriteRequest request );
}