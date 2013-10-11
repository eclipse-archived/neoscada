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
package org.eclipse.scada.core.ui.connection;

import org.eclipse.ui.services.IDisposable;

public interface ConnectionDiscoverer extends IDisposable
{
    /**
     * Add a new listener to receive events.
     * <p>
     * If the connection discoverer already has discovered connections before
     * the listener is added the already known connections are already sent to
     * the listener.
     * </p>
     * 
     * @param listener
     *            the listener to add
     */
    public void addConnectionListener ( ConnectionDiscoveryListener listener );

    public void removeConnectionListener ( ConnectionDiscoveryListener listener );
}
