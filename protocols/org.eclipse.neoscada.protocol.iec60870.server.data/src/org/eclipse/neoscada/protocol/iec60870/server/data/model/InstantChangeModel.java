/*******************************************************************************
 * Copyright (c) 2016 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *     Red Hat Inc - enhancements
 *******************************************************************************/
package org.eclipse.neoscada.protocol.iec60870.server.data.model;

import static java.util.Collections.singletonList;

import java.util.List;

import org.eclipse.neoscada.protocol.iec60870.asdu.types.ASDUAddress;
import org.eclipse.neoscada.protocol.iec60870.asdu.types.CauseOfTransmission;
import org.eclipse.neoscada.protocol.iec60870.asdu.types.InformationObjectAddress;
import org.eclipse.neoscada.protocol.iec60870.asdu.types.Value;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InstantChangeModel implements ChangeModel
{
    public interface Context
    {
        public void notifyChangeBoolean ( final CauseOfTransmission cause, ASDUAddress asduAddress, InformationObjectAddress startAddress, List<Value<Boolean>> values );

        public void notifyChangeFloat ( final CauseOfTransmission cause, ASDUAddress asduAddress, InformationObjectAddress startAddress, List<Value<Float>> values );

        public void notifyChangeShort ( final CauseOfTransmission cause, ASDUAddress asduAddress, InformationObjectAddress startAddress, List<Value<Short>> values );
    }

    private final static Logger logger = LoggerFactory.getLogger ( InstantChangeModel.class );

    private final Context context;

    public InstantChangeModel ( final Context context )
    {
        this.context = context;
    }

    @Override
    public Runnable dispose ()
    {
        return () -> {
        };
    }

    @SuppressWarnings ( "unchecked" )
    @Override
    public void notifyChange ( final CauseOfTransmission cause, final ASDUAddress asduAddress, final InformationObjectAddress informationObjectAddress, final Value<?> iecValue )
    {
        final Object rawValue = iecValue.getValue ();

        logger.trace ( "Notify raw value: {} ({})", rawValue, rawValue != null ? rawValue.getClass () : null );

        if ( rawValue instanceof Boolean )
        {
            this.context.notifyChangeBoolean ( cause, asduAddress, informationObjectAddress, singletonList ( (Value<Boolean>)iecValue ) );
        }
        else if ( rawValue instanceof Float )
        {
            this.context.notifyChangeFloat ( cause, asduAddress, informationObjectAddress, singletonList ( (Value<Float>)iecValue ) );
        }
        else if ( rawValue instanceof Short )
        {
            this.context.notifyChangeShort ( cause, asduAddress, informationObjectAddress, singletonList ( (Value<Short>)iecValue ) );
        }
    }

}
