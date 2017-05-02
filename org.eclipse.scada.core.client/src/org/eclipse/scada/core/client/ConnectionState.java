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

public enum ConnectionState
{
    /**
     * The connection is closed.
     */
    CLOSED,
    /**
     * The connection is in progress of looking up the target endpoint (e.g. hostname)
     */
    LOOKUP,
    /**
     * An attempt was made to contact the remote endpoint. The attempt is still in progress.
     */
    CONNECTING,
    /**
     * The connection is established but not set up for data transmission.
     */
    CONNECTED,
    /**
     * The connection is established and set up for transmitting data. 
     */
    BOUND,
    /**
     * The connection is being closed and will not allow further data transmission. 
     */
    CLOSING,
}