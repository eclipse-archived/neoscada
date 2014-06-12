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
import org.eclipse.scada.protocol.iec60870.asdu.message.SinglePointInformationSequence;
import org.eclipse.scada.protocol.iec60870.asdu.message.SinglePointInformationSingle;
import org.eclipse.scada.protocol.iec60870.asdu.message.SinglePointInformationTimeSingle;

public class SimpleBooleanBuilder implements MessageBuilderFactory<Boolean>
{
    private final boolean withTimestamps;

    public SimpleBooleanBuilder ( final boolean withTimestamps )
    {
        this.withTimestamps = withTimestamps;
    }

    @Override
    public MessageBuilder<Boolean, ?> create ()
    {
        return new AbstractMessageBuilder<Boolean, Object> ( Boolean.class, 20, 20, this.withTimestamps ? 10 : -1 ) {
            @Override
            public Object build ()
            {
                validateStart ();

                final ASDUHeader header = new ASDUHeader ( this.causeOfTransmission, this.asduAddress );

                if ( isWithTimestamps () )
                {
                    return SinglePointInformationTimeSingle.create ( header, this.entries );
                }
                else if ( isContinuous () )
                {
                    return SinglePointInformationSequence.create ( getStartAddress (), header, getValues () );
                }
                else
                {
                    return SinglePointInformationSingle.create ( header, this.entries );
                }
            }
        };
    }
}
