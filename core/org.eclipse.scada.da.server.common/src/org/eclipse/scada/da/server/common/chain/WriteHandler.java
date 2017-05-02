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
package org.eclipse.scada.da.server.common.chain;

import org.eclipse.scada.core.Variant;
import org.eclipse.scada.core.server.OperationParameters;

public interface WriteHandler
{
    /**
     * Handle the write call
     * <p>
     * e.g. performs a write call to a subsystem
     * 
     * @param value
     *            the value to write
     * @param operationParameters
     *            optional operation parameters, may be <code>null</code>
     * @throws Exception
     *             if anything goes wrong
     */
    public abstract void handleWrite ( Variant value, OperationParameters operationParameters ) throws Exception;
}
