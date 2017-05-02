/*******************************************************************************
 * Copyright (c) 2009, 2010 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.ae.connection.provider;

import org.eclipse.scada.ae.client.Connection;
import org.eclipse.scada.ae.client.EventManager;
import org.eclipse.scada.ae.client.MonitorManager;

public interface ConnectionService extends org.eclipse.scada.core.connection.provider.ConnectionService
{
    public EventManager getEventManager ();

    public MonitorManager getMonitorManager ();

    public Connection getConnection ();
}
