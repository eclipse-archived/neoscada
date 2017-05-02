/*******************************************************************************
 * Copyright (c) 2010, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *******************************************************************************/
package org.eclipse.scada.da.server.proxy.item;

import java.util.Map;

import org.eclipse.scada.core.OperationException;
import org.eclipse.scada.core.Variant;
import org.eclipse.scada.core.client.NoConnectionException;
import org.eclipse.scada.core.server.OperationParameters;
import org.eclipse.scada.da.core.WriteAttributeResults;

public interface ProxyWriteHandler
{

    /**
     * Write a value to the currently active connection
     * 
     * @param itemId
     *            the item id of the local proxy item to write to
     * @param value
     *            the value to write to
     * @param operationParameters
     * @throws NoConnectionException
     * @throws OperationException
     */
    public abstract void write ( final String itemId, final Variant value, final OperationParameters operationParameters ) throws NoConnectionException, OperationException;

    /**
     * Write attributes to the currently active connection
     * 
     * @param itemId
     *            the item id of the local proxy item to write to
     * @param attributes
     *            the attributes to write
     * @param writeAttributeResults
     *            the result set that must be filled by the implementor
     */
    public abstract void writeAttributes ( final String itemId, final Map<String, Variant> attributes, final WriteAttributeResults writeAttributeResults, final OperationParameters operationParameters );

}