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
package org.eclipse.scada.core.connection.provider;

import org.eclipse.scada.core.client.AutoReconnectController;
import org.eclipse.scada.core.client.Connection;
import org.eclipse.scada.sec.callback.CallbackHandler;

public interface ConnectionService
{
    public Connection getConnection ();

    public AutoReconnectController getAutoReconnectController ();

    public void connect ();

    /**
     * @since 1.1
     */
    public void setConnectCallbackHandler ( CallbackHandler callbackHandler );

    public void disconnect ();

    public static final String CONNECTION_URI = "connection.uri";

    public Class<?>[] getSupportedInterfaces ();

    public void dispose ();
}
