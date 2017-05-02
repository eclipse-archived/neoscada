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
package org.eclipse.scada.da.server.common;

import java.util.Map;

import org.eclipse.scada.core.InvalidOperationException;
import org.eclipse.scada.core.NotConvertableException;
import org.eclipse.scada.core.NullValueException;
import org.eclipse.scada.core.OperationException;
import org.eclipse.scada.core.Variant;
import org.eclipse.scada.core.server.OperationParameters;
import org.eclipse.scada.da.core.DataItemInformation;
import org.eclipse.scada.da.core.WriteAttributeResults;
import org.eclipse.scada.da.core.WriteResult;
import org.eclipse.scada.utils.concurrent.NotifyFuture;

public interface DataItem
{
    public DataItemInformation getInformation ();

    /**
     * The read operation of a data item.
     * 
     * @return The value read from the subsystem.
     * @throws InvalidOperationException
     *             Raised if "read" is not a valid operation for this item
     */
    public NotifyFuture<Variant> readValue () throws InvalidOperationException;

    public Map<String, Variant> getAttributes ();

    /**
     * Sets the listener for this item.
     * Set by the controller to which this item is registered. The item has to
     * use the listener
     * provided.
     * 
     * @param listener
     *            The listener to use or null to disable notification
     */
    public void setListener ( ItemListener listener );

    /**
     * The write operation of a data item.
     * 
     * @param session
     *            The user session
     * @param value
     *            The value to write to the subsystem
     * @param operationParameters
     * @return the future to the operation
     * @throws InvalidOperationException
     *             Raised if "write" is not a valid operation for this item
     * @throws NullValueException
     *             Raised if a null value was passed but the subsystem does not
     *             allow null values to be written
     * @throws NotConvertableException
     *             Raised if a value was passed that cannot be converted in a
     *             variant type suitable for the subsystem
     * @throws OperationException
     *             Raised if the value could not be written due to some
     *             subsystem error
     */
    public NotifyFuture<WriteResult> startWriteValue ( Variant value, OperationParameters operationParameters );

    /**
     * Start the write attributes operation
     * 
     * @param attributes
     *            attributes to set
     * @param session
     *            The user session
     * @param operationParameters
     * @return the future to the operation
     */
    public NotifyFuture<WriteAttributeResults> startSetAttributes ( Map<String, Variant> attributes, OperationParameters operationParameters );
}
