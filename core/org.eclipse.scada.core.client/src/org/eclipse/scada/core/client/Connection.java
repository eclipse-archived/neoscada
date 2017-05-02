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
package org.eclipse.scada.core.client;

import java.util.Map;
import java.util.Set;

import org.eclipse.scada.core.ConnectionInformation;
import org.eclipse.scada.sec.callback.CallbackFactory;
import org.eclipse.scada.sec.callback.CallbackHandler;

public interface Connection
{
    /**
     * @since 1.1
     */
    public void setCallbackFactory ( CallbackFactory callbackFactory );

    /**
     * Start the connection
     */
    public void connect ();

    /**
     * Start the connection with a callback handler
     * 
     * @since 1.1
     */
    public void connect ( CallbackHandler callbackHandler );

    /**
     * Stop the connection
     */
    public void disconnect ();

    public void addConnectionStateListener ( ConnectionStateListener connectionStateListener );

    public void removeConnectionStateListener ( ConnectionStateListener connectionStateListener );

    /**
     * Get the current connection state
     * 
     * @return The current connection state
     */
    public ConnectionState getState ();

    public ConnectionInformation getConnectionInformation ();

    /**
     * Return the session properties as provided by the server. The session
     * properties are only
     * valid if the connection is in the state {@link ConnectionState#BOUND}
     * 
     * @return the connection properties
     */
    public Map<String, String> getSessionProperties ();

    /**
     * Add a listener to the privileges of the session
     * <p>
     * When adding a new listener it will receive an initial call with the
     * current privileges.
     * </p>
     * 
     * @param listener
     */
    public void addPrivilegeListener ( PrivilegeListener listener );

    public void removePrivilegeListener ( PrivilegeListener listener );

    /**
     * Return the list of currently granted privileges.
     * 
     * @since 1.0
     * @return the list of current privileges. Must never return
     *         <code>null</code>.
     */
    public Set<String> getPrivileges ();

    /**
     * Dispose the connection
     * <p>
     * A dispose will also act as a disconnect.
     * </p>
     * <p>
     * Connections must be disposed in order to clean up all resources. In the
     * past the {@link #disconnect()} call was enough and, if possible, most
     * resources (sockets) should be closed when disconnecting. Still some
     * resources can be re-used and these need to be cleaned up in the
     * {@link #dispose()} call.
     * </p>
     * 
     * @since 1.0
     */
    public void dispose ();
}
