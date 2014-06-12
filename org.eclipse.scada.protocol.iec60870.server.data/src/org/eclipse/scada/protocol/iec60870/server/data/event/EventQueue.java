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
package org.eclipse.scada.protocol.iec60870.server.data.event;

import org.eclipse.scada.protocol.iec60870.asdu.types.ASDUAddress;
import org.eclipse.scada.protocol.iec60870.asdu.types.CauseOfTransmission;
import org.eclipse.scada.protocol.iec60870.asdu.types.InformationObjectAddress;
import org.eclipse.scada.protocol.iec60870.asdu.types.Value;

public class EventQueue<T>
{
    private final EventBuffer<T> buffer;

    private final MessageBuilderFactory<T> factory;

    public EventQueue ( final int numberOfDuplicates, final MessageBuilderFactory<T> factory )
    {
        this.buffer = new EventBuffer<T> ( numberOfDuplicates );
        this.factory = factory;
    }

    public void append ( final CauseOfTransmission causeOfTransmission, final ASDUAddress asduAddress, final InformationObjectAddress address, final Value<T> value )
    {
        this.buffer.append ( causeOfTransmission, asduAddress, address, value );
    }

    public int getCauseCounter ( final CauseOfTransmission causeOfTransmission, final ASDUAddress asduAddress )
    {
        return this.buffer.getCauseCounter ( causeOfTransmission, asduAddress );
    }

    public Object poll ()
    {
        return this.buffer.poll ( this.factory.create () );
    }

}
