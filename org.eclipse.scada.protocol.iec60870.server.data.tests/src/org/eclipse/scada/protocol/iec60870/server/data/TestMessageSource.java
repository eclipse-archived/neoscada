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
package org.eclipse.scada.protocol.iec60870.server.data;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.scada.protocol.iec60870.asdu.ASDUHeader;
import org.eclipse.scada.protocol.iec60870.asdu.message.AbstractSingleBooleanBaseSingle;
import org.eclipse.scada.protocol.iec60870.asdu.message.SinglePointInformationSingle;
import org.eclipse.scada.protocol.iec60870.asdu.message.SinglePointInformationTimeSingle;
import org.eclipse.scada.protocol.iec60870.asdu.types.ASDUAddress;
import org.eclipse.scada.protocol.iec60870.asdu.types.CauseOfTransmission;
import org.eclipse.scada.protocol.iec60870.asdu.types.InformationEntry;
import org.eclipse.scada.protocol.iec60870.asdu.types.InformationObjectAddress;
import org.eclipse.scada.protocol.iec60870.asdu.types.Value;
import org.junit.Assert;
import org.junit.Test;

public class TestMessageSource
{
    @Test
    public void test1 () throws Exception
    {
        final DataModuleOptions.Builder builder = new DataModuleOptions.Builder ();
        builder.setBooleansWithTimestamp ( false );
        builder.setFloatsWithTimestamp ( false );

        performTest1 ( builder );
    }

    @Test
    public void test1WithTimestamps () throws Exception
    {
        final DataModuleOptions.Builder builder = new DataModuleOptions.Builder ();
        builder.setBooleansWithTimestamp ( true );
        builder.setFloatsWithTimestamp ( true );

        performTest1 ( builder );
    }

    private void performTest1 ( final DataModuleOptions.Builder builder )
    {
        final DataModuleMessageSource ms = new DataModuleMessageSource ( builder.build (), null, new ChannelWriter () {

            @Override
            public void write ( final Object message )
            {
            }

            @Override
            public void notifyMoreData ()
            {
            }

            @Override
            public void flush ()
            {
            }
        }, null, 60_000 );

        final ASDUAddress asduAddress = ASDUAddress.valueOf ( 1 );
        final InformationObjectAddress address = new InformationObjectAddress ( 1 );

        // we need specific instances since otherwise the timestamp would change
        final Value<Boolean> trueValue = Value.TRUE ();
        final Value<Boolean> falseValue = Value.FALSE ();

        ms.sendBooleanValue ( new ASDUHeader ( CauseOfTransmission.REQUEST, asduAddress ), address, trueValue );
        ms.sendBooleanValue ( new ASDUHeader ( CauseOfTransmission.REQUEST, asduAddress ), address, falseValue );

        final List<InformationEntry<Boolean>> entries = new LinkedList<> ();
        entries.add ( new InformationEntry<> ( address, trueValue ) );
        entries.add ( new InformationEntry<> ( address, falseValue ) );

        if ( builder.isBooleansWithTimestamp () )
        {
            assertEquals ( SinglePointInformationTimeSingle.create ( new ASDUHeader ( CauseOfTransmission.REQUEST, asduAddress ), entries ), ms.poll () );
        }
        else
        {
            assertEquals ( SinglePointInformationSingle.create ( new ASDUHeader ( CauseOfTransmission.REQUEST, asduAddress ), entries ), ms.poll () );
        }
    }

    private void assertEquals ( final AbstractSingleBooleanBaseSingle expected, final Object actualObject )
    {
        Assert.assertEquals ( expected.getClass (), actualObject.getClass () );

        final AbstractSingleBooleanBaseSingle actual = (AbstractSingleBooleanBaseSingle)actualObject;

        Assert.assertEquals ( expected.getHeader (), actual.getHeader () );
        Assert.assertEquals ( expected.getEntries (), actual.getEntries () );
    }
}
