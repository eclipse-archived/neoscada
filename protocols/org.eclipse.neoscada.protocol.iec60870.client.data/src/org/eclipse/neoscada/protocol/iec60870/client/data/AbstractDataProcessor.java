/*******************************************************************************
 * Copyright (c) 2014, 2016 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *     Red Hat Inc - enhancements
 *******************************************************************************/
package org.eclipse.neoscada.protocol.iec60870.client.data;

import org.eclipse.neoscada.protocol.iec60870.asdu.message.AbstractMessage;
import org.eclipse.neoscada.protocol.iec60870.asdu.message.DoublePointInformationSequence;
import org.eclipse.neoscada.protocol.iec60870.asdu.message.DoublePointInformationSingle;
import org.eclipse.neoscada.protocol.iec60870.asdu.message.DoublePointInformationTimeSingle;
import org.eclipse.neoscada.protocol.iec60870.asdu.message.MeasuredValueNormalizedSequence;
import org.eclipse.neoscada.protocol.iec60870.asdu.message.MeasuredValueNormalizedSingle;
import org.eclipse.neoscada.protocol.iec60870.asdu.message.MeasuredValueNormalizedTimeSingle;
import org.eclipse.neoscada.protocol.iec60870.asdu.message.MeasuredValueScaledSequence;
import org.eclipse.neoscada.protocol.iec60870.asdu.message.MeasuredValueScaledSingle;
import org.eclipse.neoscada.protocol.iec60870.asdu.message.MeasuredValueScaledTimeSingle;
import org.eclipse.neoscada.protocol.iec60870.asdu.message.MeasuredValueShortFloatingPointSequence;
import org.eclipse.neoscada.protocol.iec60870.asdu.message.MeasuredValueShortFloatingPointSingle;
import org.eclipse.neoscada.protocol.iec60870.asdu.message.MeasuredValueShortFloatingPointTimeSingle;
import org.eclipse.neoscada.protocol.iec60870.asdu.message.SinglePointInformationSequence;
import org.eclipse.neoscada.protocol.iec60870.asdu.message.SinglePointInformationSingle;
import org.eclipse.neoscada.protocol.iec60870.asdu.message.SinglePointInformationTimeSingle;
import org.eclipse.neoscada.protocol.iec60870.asdu.types.ASDUAddress;
import org.eclipse.neoscada.protocol.iec60870.asdu.types.DoublePoint;
import org.eclipse.neoscada.protocol.iec60870.asdu.types.InformationEntry;
import org.eclipse.neoscada.protocol.iec60870.asdu.types.InformationObjectAddress;
import org.eclipse.neoscada.protocol.iec60870.asdu.types.Value;

public abstract class AbstractDataProcessor implements DataHandler
{
    protected abstract void fireEntry ( final ASDUAddress asduAddress, final InformationObjectAddress address, final Value<?> value );

    /**
     * Test if this message should be ignored
     *
     * @param msg
     *            the message to check
     * @return {@code true} if the message should be ignore, {@code false}
     *         otherwise
     */
    protected boolean checkIgnore ( final AbstractMessage msg )
    {
        return false;
    }

    @Override
    public void process ( final SinglePointInformationTimeSingle msg )
    {
        if ( checkIgnore ( msg ) )
        {
            return;
        }

        for ( final InformationEntry<Boolean> entry : msg.getEntries () )
        {
            fireEntry ( msg.getHeader ().getAsduAddress (), entry.getAddress (), entry.getValue () );
        }
    }

    @Override
    public void process ( final SinglePointInformationSingle msg )
    {
        if ( checkIgnore ( msg ) )
        {
            return;
        }

        for ( final InformationEntry<Boolean> entry : msg.getEntries () )
        {
            fireEntry ( msg.getHeader ().getAsduAddress (), entry.getAddress (), entry.getValue () );
        }
    }

    @Override
    public void process ( final SinglePointInformationSequence msg )
    {
        if ( checkIgnore ( msg ) )
        {
            return;
        }

        int i = msg.getStartAddress ().getAddress ();

        for ( final Value<Boolean> value : msg.getValues () )
        {
            fireEntry ( msg.getHeader ().getAsduAddress (), InformationObjectAddress.valueOf ( i ), value );
            i++;
        }
    }

    @Override
    public void process ( final DoublePointInformationTimeSingle msg )
    {
        if ( checkIgnore ( msg ) )
        {
            return;
        }

        for ( final InformationEntry<DoublePoint> entry : msg.getEntries () )
        {
            fireEntry ( msg.getHeader ().getAsduAddress (), entry.getAddress (), entry.getValue () );
        }
    }

    @Override
    public void process ( final DoublePointInformationSingle msg )
    {
        if ( checkIgnore ( msg ) )
        {
            return;
        }

        for ( final InformationEntry<DoublePoint> entry : msg.getEntries () )
        {
            fireEntry ( msg.getHeader ().getAsduAddress (), entry.getAddress (), entry.getValue () );
        }
    }

    @Override
    public void process ( final DoublePointInformationSequence msg )
    {
        if ( checkIgnore ( msg ) )
        {
            return;
        }

        int i = msg.getStartAddress ().getAddress ();

        for ( final Value<DoublePoint> value : msg.getValues () )
        {
            fireEntry ( msg.getHeader ().getAsduAddress (), InformationObjectAddress.valueOf ( i ), value );
            i++;
        }
    }

    @Override
    public void process ( final MeasuredValueShortFloatingPointTimeSingle msg )
    {
        if ( checkIgnore ( msg ) )
        {
            return;
        }

        for ( final InformationEntry<Float> entry : msg.getEntries () )
        {
            fireEntry ( msg.getHeader ().getAsduAddress (), entry.getAddress (), entry.getValue () );
        }
    }

    @Override
    public void process ( final MeasuredValueShortFloatingPointSingle msg )
    {
        if ( checkIgnore ( msg ) )
        {
            return;
        }

        for ( final InformationEntry<Float> entry : msg.getEntries () )
        {
            fireEntry ( msg.getHeader ().getAsduAddress (), entry.getAddress (), entry.getValue () );
        }
    }

    @Override
    public void process ( final MeasuredValueShortFloatingPointSequence msg )
    {
        if ( checkIgnore ( msg ) )
        {
            return;
        }

        int i = msg.getStartAddress ().getAddress ();

        for ( final Value<Float> value : msg.getValues () )
        {
            fireEntry ( msg.getHeader ().getAsduAddress (), InformationObjectAddress.valueOf ( i ), value );
            i++;
        }
    }

    @Override
    public void process ( final MeasuredValueScaledTimeSingle msg )
    {
        if ( checkIgnore ( msg ) )
        {
            return;
        }

        for ( final InformationEntry<Short> entry : msg.getEntries () )
        {
            fireEntry ( msg.getHeader ().getAsduAddress (), entry.getAddress (), entry.getValue () );
        }
    }

    @Override
    public void process ( final MeasuredValueScaledSingle msg )
    {
        if ( checkIgnore ( msg ) )
        {
            return;
        }

        for ( final InformationEntry<Short> entry : msg.getEntries () )
        {
            fireEntry ( msg.getHeader ().getAsduAddress (), entry.getAddress (), entry.getValue () );
        }
    }

    @Override
    public void process ( final MeasuredValueScaledSequence msg )
    {
        if ( checkIgnore ( msg ) )
        {
            return;
        }

        int i = msg.getStartAddress ().getAddress ();

        for ( final Value<Short> value : msg.getValues () )
        {
            fireEntry ( msg.getHeader ().getAsduAddress (), InformationObjectAddress.valueOf ( i ), value );
            i++;
        }
    }

    @Override
    public void process( MeasuredValueNormalizedTimeSingle msg )
    {
        if ( checkIgnore ( msg ) )
        {
            return;
        }

        for ( final InformationEntry<Double> entry : msg.getEntries () )
        {
            fireEntry ( msg.getHeader ().getAsduAddress (), entry.getAddress (), entry.getValue () );
        }
    }

    @Override
    public void process( MeasuredValueNormalizedSingle msg ) {
        if ( checkIgnore ( msg ) )
        {
            return;
        }

        for ( final InformationEntry<Double> entry : msg.getEntries () )
        {
            fireEntry ( msg.getHeader ().getAsduAddress (), entry.getAddress (), entry.getValue () );
        }
    }

    @Override
    public void process( MeasuredValueNormalizedSequence msg )
    {
        if ( checkIgnore ( msg ) )
        {
            return;
        }

        int i = msg.getStartAddress ().getAddress ();

        for ( final Value<Double> value : msg.getValues () )
        {
            fireEntry ( msg.getHeader ().getAsduAddress (), InformationObjectAddress.valueOf ( i ), value );
            i++;
        }
    }
}
