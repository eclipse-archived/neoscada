/*******************************************************************************
 * Copyright (c) 2013 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.mqtt;

import org.eclipse.paho.client.mqttv3.MqttClient;

public interface MqttBroker
{
    public MqttClient getClient ();

    public NameConverter getTopicToItemConverter ();

    public NameConverter getItemToTopicConverter ();

    public void addListener ( String topic, TopicListener listener );

    public void removeListener ( String topic, TopicListener listener );
}
