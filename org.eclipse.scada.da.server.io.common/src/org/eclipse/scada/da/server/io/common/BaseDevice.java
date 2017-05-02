/*******************************************************************************
 * Copyright (c) 2010, 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.server.io.common;

public interface BaseDevice
{
    public abstract void addConnectionListener ( ConnectionListener listener );

    public abstract void removeConnectionListener ( ConnectionListener listener );

    public abstract boolean isConnected ();

    public abstract void connect ();

    public abstract void dispose ();
}