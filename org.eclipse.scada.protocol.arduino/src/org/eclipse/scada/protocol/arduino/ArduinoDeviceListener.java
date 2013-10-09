/*******************************************************************************
 * Copyright (c) 2010, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.protocol.arduino;

import java.util.Map;

public interface ArduinoDeviceListener
{
    public void stateChange ( DeviceState deviceState );

    public void deviceConnected ( Map<Integer, Object>[] parameters );

    public void deviceDisconnected ();

    public void dataChange ( Object[] data );
}
