/*******************************************************************************
 * Copyright (c) 2013 Jürgen Rose and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Jürgen Rose - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.server.mqtt;

import org.eclipse.scada.mqtt.MqttBroker;

public class MqttBrokerChangedListener
{
    private final MqttDataitem item;

    public MqttBrokerChangedListener ( final MqttDataitem mqttDataitem )
    {
        this.item = mqttDataitem;
    }

    public void unsetBroker ( final String id, final MqttBroker broker )
    {
        if ( ( id != null ) && id.equals ( this.item.getBrokerId () ) )
        {
            this.item.unsetBroker ();
        }
    }

    public void setBroker ( final String id, final MqttBroker broker )
    {
        if ( ( id != null ) && id.equals ( this.item.getBrokerId () ) )
        {
            this.item.unsetBroker ();
            this.item.setBroker ( broker );
        }
    }
}
