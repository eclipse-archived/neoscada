/*******************************************************************************
 * Copyright (c) 2009, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *******************************************************************************/
package org.eclipse.scada.ae.server.common.akn;

import java.util.Date;

import org.eclipse.scada.core.server.OperationParameters;

public interface AknHandler
{
    /**
     * Perform acknowledge of monitor
     * 
     * @param monitorId
     *            the monitor to acknowledge
     * @param operationParameters
     *            the effective operation parameters
     * @param aknTimestamp
     *            the timestamp until which the state is acknowledged
     * @return <code>true</code> if the monitor was found and processed,
     *         <code>false</code> otherwise
     */
    public boolean acknowledge ( String monitorId, OperationParameters operationParameters, Date aknTimestamp );
}
