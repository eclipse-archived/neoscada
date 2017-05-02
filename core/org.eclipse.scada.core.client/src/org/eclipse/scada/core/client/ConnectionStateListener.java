/*******************************************************************************
 * Copyright (c) 2010 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.core.client;

public interface ConnectionStateListener
{
    /**
     * Notify a state change
     * @param connection the connection that changed
     * @param state the new state of the connection
     * @param error some error information that lead to the new state (can be <code>null</code> if it was not an error)
     */
    public void stateChange ( Connection connection, ConnectionState state, Throwable error );
}
