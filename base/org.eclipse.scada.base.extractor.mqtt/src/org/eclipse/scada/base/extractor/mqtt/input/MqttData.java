package org.eclipse.scada.base.extractor.mqtt.input;

import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.scada.base.extractor.input.Data;

public class MqttData extends Data
{
    private final MqttMessage message;

    public MqttData ( final MqttMessage msg )
    {
        super ( msg.getPayload (), null );
        this.message = msg;
    }

    public MqttMessage getMessage ()
    {
        return this.message;
    }
}
