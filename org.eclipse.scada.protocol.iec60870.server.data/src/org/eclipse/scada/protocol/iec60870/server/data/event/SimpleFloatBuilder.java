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

import org.eclipse.scada.protocol.iec60870.asdu.ASDUHeader;
import org.eclipse.scada.protocol.iec60870.asdu.message.MeasuredValueShortFloatingPointSequence;
import org.eclipse.scada.protocol.iec60870.asdu.message.MeasuredValueShortFloatingPointSingle;
import org.eclipse.scada.protocol.iec60870.asdu.message.MeasuredValueShortFloatingPointTimeSingle;

public class SimpleFloatBuilder implements MessageBuilderFactory<Float>
{
    private final boolean withTimestamps;

    public SimpleFloatBuilder ( final boolean withTimestamps )
    {
        this.withTimestamps = withTimestamps;
    }

    @Override
    public MessageBuilder<Float, ?> create ()
    {
        return new AbstractMessageBuilder<Float, Object> ( Float.class, 20, 20, this.withTimestamps ? 10 : -1 ) {
            @Override
            public Object build ()
            {
                validateStart ();

                final ASDUHeader header = new ASDUHeader ( this.causeOfTransmission, this.asduAddress );

                if ( isWithTimestamps () )
                {
                    return MeasuredValueShortFloatingPointTimeSingle.create ( header, this.entries );
                }
                else if ( isContinuous () )
                {
                    return MeasuredValueShortFloatingPointSequence.create ( getStartAddress (), header, getValues () );
                }
                else
                {
                    return MeasuredValueShortFloatingPointSingle.create ( header, this.entries );
                }
            }
        };
    }

}
