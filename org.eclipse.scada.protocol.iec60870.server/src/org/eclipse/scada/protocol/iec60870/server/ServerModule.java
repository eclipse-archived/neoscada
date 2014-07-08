/*******************************************************************************
 * Copyright (c) 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.protocol.iec60870.server;

import org.eclipse.scada.protocol.iec60870.asdu.MessageManager;
import org.eclipse.scada.protocol.iec60870.io.Module;

public interface ServerModule extends Module
{
    public void initializeServer ( Server server, MessageManager manager );
}
