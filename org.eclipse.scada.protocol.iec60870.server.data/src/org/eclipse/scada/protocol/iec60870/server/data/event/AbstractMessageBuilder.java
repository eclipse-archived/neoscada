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

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.scada.protocol.iec60870.asdu.types.ASDUAddress;
import org.eclipse.scada.protocol.iec60870.asdu.types.Cause;
import org.eclipse.scada.protocol.iec60870.asdu.types.CauseOfTransmission;
import org.eclipse.scada.protocol.iec60870.asdu.types.InformationEntry;
import org.eclipse.scada.protocol.iec60870.asdu.types.InformationObjectAddress;
import org.eclipse.scada.protocol.iec60870.asdu.types.StandardCause;
import org.eclipse.scada.protocol.iec60870.asdu.types.Value;

public abstract class AbstractMessageBuilder<T, M> implements MessageBuilder<T, M>
{
    protected ASDUAddress asduAddress;

    protected CauseOfTransmission causeOfTransmission;

    protected final List<InformationEntry<T>> entries = new LinkedList<> ();

    private final int maxContinuousSize;

    private final int maxNotContinuousSize;

    /**
     * Flag if the addresses are continuous
     */
    private boolean continuous;

    private InformationObjectAddress lastAddress;

    private final Class<T> clazz;

    private final int maxTimestampSize;

    /**
     * @param maxContinuousSize
     *            the number of possible entries when the data set is continuous
     * @param maxNotContinuousSize
     *            the number of possible entries when the data set is not
     *            continuous. If is required that this value is not greater than
     *            "maxContinuousSize".
     * @param maxTimestampSize
     *            the number of possible entries when the cause permits
     *            timestamp transmissions. Timestamp messages will only be used
     *            when the value is greater than zero
     */
    public AbstractMessageBuilder ( final Class<T> clazz, final int maxContinuousSize, final int maxNotContinuousSize, final int maxTimestampSize )
    {
        this.clazz = clazz;
        this.maxContinuousSize = maxContinuousSize;
        this.maxNotContinuousSize = maxNotContinuousSize;
        this.maxTimestampSize = maxTimestampSize;
    }

    @Override
    public boolean accepts ( final Value<?> value )
    {
        if ( value == null || value.getValue () == null )
        {
            return false;
        }

        return this.clazz.isAssignableFrom ( value.getValue ().getClass () );
    }

    public boolean isContinuous ()
    {
        return this.continuous;
    }

    public boolean isWithTimestamps ()
    {
        if ( this.maxTimestampSize <= 0 || this.causeOfTransmission == null )
        {
            return false;
        }

        final Cause cause = this.causeOfTransmission.getCause ();
        if ( cause.getValue () == StandardCause.REQUEST.getValue () )
        {
            return true;
        }
        if ( cause.getValue () == StandardCause.SPONTANEOUS.getValue () )
        {
            return true;
        }
        return false;
    }

    @Override
    public void start ( final CauseOfTransmission causeOfTransmission, final ASDUAddress asduAddress )
    {
        this.continuous = true;
        this.asduAddress = asduAddress;
        this.causeOfTransmission = causeOfTransmission;
    }

    @Override
    public boolean addEntry ( final InformationObjectAddress address, final Value<T> value )
    {
        validateStart ();

        if ( this.lastAddress != null && this.lastAddress.getAddress () + 1 != address.getAddress () )
        {
            this.continuous = false;
        }

        this.entries.add ( new InformationEntry<> ( address, value ) );

        this.lastAddress = address;

        if ( isWithTimestamps () )
        {
            return this.entries.size () < this.maxTimestampSize;
        }
        else if ( this.continuous )
        {
            return this.entries.size () < this.maxContinuousSize;
        }
        else
        {
            return this.entries.size () < this.maxNotContinuousSize;
        }
    }

    protected void validateStart ()
    {
        if ( this.asduAddress == null || this.causeOfTransmission == null )
        {
            throw new IllegalStateException ( "start method was never called" );
        }
    }

    protected InformationObjectAddress getStartAddress ()
    {
        if ( this.entries.isEmpty () || !isContinuous () )
        {
            return null;
        }

        int address = Integer.MAX_VALUE;
        for ( final InformationEntry<?> entry : this.entries )
        {
            address = Math.min ( address, entry.getAddress ().getAddress () );
        }
        return InformationObjectAddress.valueOf ( address );
    }

    protected List<Value<T>> getValues ()
    {
        final List<Value<T>> result = new ArrayList<> ( this.entries.size () );
        for ( final InformationEntry<T> entry : this.entries )
        {
            result.add ( entry.getValue () );
        }
        return result;
    }
}