/*******************************************************************************
 * Copyright (c) 2016 Red Hat Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Red Hat Inc - initial API and implementation
 *******************************************************************************/
package org.eclipse.neoscada.protocol.iec60870.server.data.event;

import org.eclipse.neoscada.protocol.iec60870.asdu.ASDUHeader;
import org.eclipse.neoscada.protocol.iec60870.asdu.message.MeasuredValueScaledSequence;
import org.eclipse.neoscada.protocol.iec60870.asdu.message.MeasuredValueScaledSingle;
import org.eclipse.neoscada.protocol.iec60870.asdu.message.MeasuredValueScaledTimeSingle;

public class SimpleScaledBuilder implements MessageBuilderFactory<Short>
{
    private final boolean withTimestamps;

    public SimpleScaledBuilder ( final boolean withTimestamps )
    {
        this.withTimestamps = withTimestamps;
    }

    @Override
    public MessageBuilder<Short, ?> create ()
    {
        return new AbstractMessageBuilder<Short, Object> ( Short.class, 20, 20, this.withTimestamps ? 10 : -1 ) {
            @Override
            public Object build ()
            {
                validateStart ();

                final ASDUHeader header = new ASDUHeader ( this.causeOfTransmission, this.asduAddress );

                if ( isWithTimestamps () )
                {
                    return MeasuredValueScaledTimeSingle.create ( header, this.entries );
                }
                else if ( isContinuous () )
                {
                    return MeasuredValueScaledSequence.create ( getStartAddress (), header, getValues () );
                }
                else
                {
                    return MeasuredValueScaledSingle.create ( header, this.entries );
                }
            }
        };
    }

}
