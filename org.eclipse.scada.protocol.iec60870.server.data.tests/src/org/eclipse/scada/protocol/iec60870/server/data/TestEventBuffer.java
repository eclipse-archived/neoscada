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

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.scada.protocol.iec60870.asdu.types.ASDUAddress;
import org.eclipse.scada.protocol.iec60870.asdu.types.CauseOfTransmission;
import org.eclipse.scada.protocol.iec60870.asdu.types.InformationEntry;
import org.eclipse.scada.protocol.iec60870.asdu.types.InformationObjectAddress;
import org.eclipse.scada.protocol.iec60870.asdu.types.QualityInformation;
import org.eclipse.scada.protocol.iec60870.asdu.types.StandardCause;
import org.eclipse.scada.protocol.iec60870.asdu.types.Value;
import org.eclipse.scada.protocol.iec60870.server.data.event.EventBuffer;
import org.eclipse.scada.protocol.iec60870.server.data.event.MessageBuilder;
import org.junit.Assert;
import org.junit.Test;

public class TestEventBuffer
{

    private final static class Pair<T>
    {
        private final int address;

        private final T value;

        public Pair ( final int address, final T value )
        {
            this.address = address;
            this.value = value;
        }

        public InformationEntry<T> toInformationEntry ()
        {
            return new InformationEntry<> ( new InformationObjectAddress ( this.address ), new Value<T> ( this.value, 0, QualityInformation.OK ) );
        }
    }

    private static class PollResult<T>
    {

        private final CauseOfTransmission causeOfTransmission;

        private final ASDUAddress asduAddress;

        private final List<InformationEntry<T>> entries;

        public PollResult ( final CauseOfTransmission causeOfTransmission, final ASDUAddress asduAddress, final List<InformationEntry<T>> entries )
        {
            this.causeOfTransmission = causeOfTransmission;
            this.asduAddress = asduAddress;
            this.entries = entries;
        }

        public CauseOfTransmission getCauseOfTransmission ()
        {
            return this.causeOfTransmission;
        }

        public ASDUAddress getAsduAddress ()
        {
            return this.asduAddress;
        }

        public List<InformationEntry<T>> getEntries ()
        {
            return this.entries;
        }
    }

    private static class TestResultBuilder<T> implements MessageBuilder<T, PollResult<T>>
    {
        private final int maxEntries;

        private CauseOfTransmission causeOfTransmission;

        private final List<InformationEntry<T>> entries = new LinkedList<> ();

        private ASDUAddress asduAddress;

        private final Class<T> clazz;

        public TestResultBuilder ( final Class<T> clazz, final int maxEntries )
        {
            this.clazz = clazz;
            this.maxEntries = maxEntries;
        }

        @Override
        public void start ( final CauseOfTransmission causeOfTransmission, final ASDUAddress asduAddress )
        {
            this.causeOfTransmission = causeOfTransmission;
            this.asduAddress = asduAddress;
        }

        @Override
        public boolean addEntry ( final InformationObjectAddress address, final Value<T> value )
        {
            this.entries.add ( new InformationEntry<T> ( address, value ) );
            return this.entries.size () < this.maxEntries;
        }

        @Override
        public boolean accepts ( final Value<?> value )
        {
            return this.clazz.isAssignableFrom ( value.getValue ().getClass () );
        }

        @Override
        public PollResult<T> build ()
        {
            return new PollResult<T> ( this.causeOfTransmission, this.asduAddress, this.entries );
        }

    }

    protected void addBuffer ( final EventBuffer<Float> buffer, final int address, final float value, final CauseOfTransmission causeOfTransmission, final ASDUAddress asduAddress )
    {
        buffer.append ( causeOfTransmission, asduAddress, new InformationObjectAddress ( address ), new Value<> ( value, 0, QualityInformation.OK ) );
    }

    @Test
    public void testEmpty ()
    {
        final EventBuffer<Float> buffer = new EventBuffer<> ( 10 );

        final PollResult<Float> result = buffer.poll ( new TestResultBuilder<Float> ( Float.class, 10 ) );

        Assert.assertNull ( result );
    }

    @Test
    public void testPlain ()
    {
        final int limit = 10;

        final ASDUAddress asduAddress = ASDUAddress.valueOf ( 1 );
        final CauseOfTransmission cot1 = new CauseOfTransmission ( StandardCause.SPONTANEOUS );
        final EventBuffer<Float> buffer = new EventBuffer<> ( limit );

        doubleFill ( limit, cot1, asduAddress, buffer, 1 );

        final PollResult<Float> result = buffer.poll ( new TestResultBuilder<Float> ( Float.class, 20 ) );

        Assert.assertEquals ( cot1, result.getCauseOfTransmission () );
        assertEntries ( new Pair<?>[] {
                new Pair<> ( 1, 0.0f ),
                new Pair<> ( 1, 1.0f ),
                new Pair<> ( 1, 2.0f ),
                new Pair<> ( 1, 3.0f ),
                new Pair<> ( 1, 4.0f ),
                new Pair<> ( 1, 5.0f ),
                new Pair<> ( 1, 6.0f ),
                new Pair<> ( 1, 7.0f ),
                new Pair<> ( 1, 8.0f ),
                new Pair<> ( 1, 900.0f ),
        }, result.getEntries () );

        Assert.assertEquals ( 0, buffer.getCauseCounter ( cot1, asduAddress ) );
    }

    @Test
    public void testPlainSplit ()
    {
        final int limit = 10;

        final ASDUAddress asduAddress = ASDUAddress.valueOf ( 1 );
        final CauseOfTransmission cot1 = new CauseOfTransmission ( StandardCause.SPONTANEOUS );
        final EventBuffer<Float> buffer = new EventBuffer<> ( limit );

        doubleFill ( limit, cot1, asduAddress, buffer, 1 );

        final PollResult<Float> result1 = buffer.poll ( new TestResultBuilder<Float> ( Float.class, 5 ) );
        Assert.assertEquals ( cot1, result1.getCauseOfTransmission () );
        assertEntries ( new Pair<?>[] {
                new Pair<> ( 1, 0.0f ),
                new Pair<> ( 1, 1.0f ),
                new Pair<> ( 1, 2.0f ),
                new Pair<> ( 1, 3.0f ),
                new Pair<> ( 1, 4.0f ),
        }, result1.getEntries () );

        Assert.assertEquals ( 5, buffer.getCauseCounter ( cot1, asduAddress ) );

        final PollResult<Float> result2 = buffer.poll ( new TestResultBuilder<Float> ( Float.class, 5 ) );
        Assert.assertEquals ( cot1, result2.getCauseOfTransmission () );
        assertEntries ( new Pair<?>[] {
                new Pair<> ( 1, 5.0f ),
                new Pair<> ( 1, 6.0f ),
                new Pair<> ( 1, 7.0f ),
                new Pair<> ( 1, 8.0f ),
                new Pair<> ( 1, 900.0f ),
        }, result2.getEntries () );

        Assert.assertEquals ( 0, buffer.getCauseCounter ( cot1, asduAddress ) );
    }

    // test A1, B1, C1, A2x, E1x
    @Test
    public void testDifferentCause ()
    {
        final ASDUAddress asduAddress = ASDUAddress.valueOf ( 1 );
        final CauseOfTransmission cot1 = new CauseOfTransmission ( StandardCause.SPONTANEOUS );
        final CauseOfTransmission cot2 = new CauseOfTransmission ( StandardCause.REQUEST );

        final EventBuffer<Float> buffer = new EventBuffer<> ( 10 );
        addBuffer ( buffer, 1, 100.0f, cot1, asduAddress );
        addBuffer ( buffer, 2, 200.0f, cot1, asduAddress );
        addBuffer ( buffer, 3, 300.0f, cot1, asduAddress );
        addBuffer ( buffer, 1, 1000.0f, cot2, asduAddress );
        addBuffer ( buffer, 4, 400.0f, cot1, asduAddress );

        PollResult<Float> result;

        result = buffer.poll ( new TestResultBuilder<Float> ( Float.class, 10 ) );
        Assert.assertEquals ( cot1, result.getCauseOfTransmission () );
        assertEntries ( new Pair<?>[] {
                new Pair<> ( 1, 100.0f ),
                new Pair<> ( 2, 200.0f ),
                new Pair<> ( 3, 300.0f ),
        }, result.getEntries () );
        Assert.assertEquals ( 1, buffer.getCauseCounter ( cot1, asduAddress ) );
        Assert.assertEquals ( 1, buffer.getCauseCounter ( cot2, asduAddress ) );

        result = buffer.poll ( new TestResultBuilder<Float> ( Float.class, 10 ) );
        Assert.assertEquals ( cot2, result.getCauseOfTransmission () );
        assertEntries ( new Pair<?>[] {
                new Pair<> ( 1, 1000.0f ),
        }, result.getEntries () );
        Assert.assertEquals ( 1, buffer.getCauseCounter ( cot1, asduAddress ) );
        Assert.assertEquals ( 0, buffer.getCauseCounter ( cot2, asduAddress ) );

        result = buffer.poll ( new TestResultBuilder<Float> ( Float.class, 10 ) );
        Assert.assertEquals ( cot1, result.getCauseOfTransmission () );
        assertEntries ( new Pair<?>[] {
                new Pair<> ( 4, 400.0f ),
        }, result.getEntries () );
        Assert.assertEquals ( 0, buffer.getCauseCounter ( cot1, asduAddress ) );
        Assert.assertEquals ( 0, buffer.getCauseCounter ( cot2, asduAddress ) );
    }

    // test A1, B1, C1, D2x, D1x, D3x, E1
    @Test
    public void testLateEvent ()
    {
        final ASDUAddress asduAddress = ASDUAddress.valueOf ( 1 );

        final CauseOfTransmission cot1 = new CauseOfTransmission ( StandardCause.SPONTANEOUS );
        final CauseOfTransmission cot2 = new CauseOfTransmission ( StandardCause.REQUEST );
        final CauseOfTransmission cot3 = new CauseOfTransmission ( StandardCause.STATION_REQUEST );

        final EventBuffer<Float> buffer = new EventBuffer<> ( 10 );

        addBuffer ( buffer, 1, 100.0f, cot1, asduAddress );
        addBuffer ( buffer, 2, 200.0f, cot1, asduAddress );
        addBuffer ( buffer, 3, 300.0f, cot1, asduAddress );
        addBuffer ( buffer, 4, 4000.0f, cot2, asduAddress );
        addBuffer ( buffer, 4, 400.0f, cot1, asduAddress );
        addBuffer ( buffer, 4, 40000.0f, cot3, asduAddress );
        addBuffer ( buffer, 5, 500.0f, cot1, asduAddress );

        PollResult<Float> result;

        result = buffer.poll ( new TestResultBuilder<Float> ( Float.class, 10 ) );
        Assert.assertEquals ( cot1, result.getCauseOfTransmission () );
        assertEntries ( new Pair<?>[] {
                new Pair<> ( 1, 100.0f ),
                new Pair<> ( 2, 200.0f ),
                new Pair<> ( 3, 300.0f ),
                new Pair<> ( 5, 500.0f ),
        }, result.getEntries () );
        Assert.assertEquals ( 1, buffer.getCauseCounter ( cot1, asduAddress ) );
        Assert.assertEquals ( 1, buffer.getCauseCounter ( cot2, asduAddress ) );
        Assert.assertEquals ( 1, buffer.getCauseCounter ( cot3, asduAddress ) );

        result = buffer.poll ( new TestResultBuilder<Float> ( Float.class, 10 ) );
        Assert.assertEquals ( cot2, result.getCauseOfTransmission () );
        assertEntries ( new Pair<?>[] {
                new Pair<> ( 4, 4000.0f ),
        }, result.getEntries () );
        Assert.assertEquals ( 1, buffer.getCauseCounter ( cot1, asduAddress ) );
        Assert.assertEquals ( 0, buffer.getCauseCounter ( cot2, asduAddress ) );
        Assert.assertEquals ( 1, buffer.getCauseCounter ( cot3, asduAddress ) );

        result = buffer.poll ( new TestResultBuilder<Float> ( Float.class, 10 ) );
        Assert.assertEquals ( cot1, result.getCauseOfTransmission () );
        assertEntries ( new Pair<?>[] {
                new Pair<> ( 4, 400.0f ),
        }, result.getEntries () );
        Assert.assertEquals ( 0, buffer.getCauseCounter ( cot1, asduAddress ) );
        Assert.assertEquals ( 0, buffer.getCauseCounter ( cot2, asduAddress ) );
        Assert.assertEquals ( 1, buffer.getCauseCounter ( cot3, asduAddress ) );

        result = buffer.poll ( new TestResultBuilder<Float> ( Float.class, 10 ) );
        Assert.assertEquals ( cot3, result.getCauseOfTransmission () );
        assertEntries ( new Pair<?>[] {
                new Pair<> ( 4, 40000.0f ),
        }, result.getEntries () );
        Assert.assertEquals ( 0, buffer.getCauseCounter ( cot1, asduAddress ) );
        Assert.assertEquals ( 0, buffer.getCauseCounter ( cot2, asduAddress ) );
        Assert.assertEquals ( 0, buffer.getCauseCounter ( cot3, asduAddress ) );
    }

    /*
     * Test with different common addresses
     */
    @Test
    public void testDifferentBaseAddress ()
    {
        final ASDUAddress asduAddress1 = ASDUAddress.valueOf ( 1 );
        final ASDUAddress asduAddress2 = ASDUAddress.valueOf ( 2 );

        final CauseOfTransmission cot1 = new CauseOfTransmission ( StandardCause.SPONTANEOUS );
        final CauseOfTransmission cot2 = new CauseOfTransmission ( StandardCause.REQUEST );

        final EventBuffer<Float> buffer = new EventBuffer<> ( 10 );

        addBuffer ( buffer, 1, 100.0f, cot1, asduAddress1 );
        addBuffer ( buffer, 1, 200.0f, cot1, asduAddress2 );
        addBuffer ( buffer, 1, 1000.0f, cot2, asduAddress1 );
        addBuffer ( buffer, 1, 2000.0f, cot2, asduAddress2 );

        PollResult<Float> result;

        result = buffer.poll ( new TestResultBuilder<Float> ( Float.class, 10 ) );
        Assert.assertEquals ( cot1, result.getCauseOfTransmission () );
        Assert.assertEquals ( asduAddress1, result.getAsduAddress () );
        assertEntries ( new Pair<?>[] {
                new Pair<> ( 1, 100.0f ),
        }, result.getEntries () );
        Assert.assertEquals ( 0, buffer.getCauseCounter ( cot1, asduAddress1 ) );
        Assert.assertEquals ( 1, buffer.getCauseCounter ( cot1, asduAddress2 ) );
        Assert.assertEquals ( 1, buffer.getCauseCounter ( cot2, asduAddress1 ) );
        Assert.assertEquals ( 1, buffer.getCauseCounter ( cot2, asduAddress2 ) );

        result = buffer.poll ( new TestResultBuilder<Float> ( Float.class, 10 ) );
        Assert.assertEquals ( cot1, result.getCauseOfTransmission () );
        Assert.assertEquals ( asduAddress2, result.getAsduAddress () );
        assertEntries ( new Pair<?>[] {
                new Pair<> ( 1, 200.0f ),
        }, result.getEntries () );
        Assert.assertEquals ( 0, buffer.getCauseCounter ( cot1, asduAddress1 ) );
        Assert.assertEquals ( 0, buffer.getCauseCounter ( cot1, asduAddress2 ) );
        Assert.assertEquals ( 1, buffer.getCauseCounter ( cot2, asduAddress1 ) );
        Assert.assertEquals ( 1, buffer.getCauseCounter ( cot2, asduAddress2 ) );

        result = buffer.poll ( new TestResultBuilder<Float> ( Float.class, 10 ) );
        Assert.assertEquals ( cot2, result.getCauseOfTransmission () );
        Assert.assertEquals ( asduAddress1, result.getAsduAddress () );
        assertEntries ( new Pair<?>[] {
                new Pair<> ( 1, 1000.0f ),
        }, result.getEntries () );
        Assert.assertEquals ( 0, buffer.getCauseCounter ( cot1, asduAddress1 ) );
        Assert.assertEquals ( 0, buffer.getCauseCounter ( cot1, asduAddress2 ) );
        Assert.assertEquals ( 0, buffer.getCauseCounter ( cot2, asduAddress1 ) );
        Assert.assertEquals ( 1, buffer.getCauseCounter ( cot2, asduAddress2 ) );

        result = buffer.poll ( new TestResultBuilder<Float> ( Float.class, 10 ) );
        Assert.assertEquals ( cot2, result.getCauseOfTransmission () );
        Assert.assertEquals ( asduAddress2, result.getAsduAddress () );
        assertEntries ( new Pair<?>[] {
                new Pair<> ( 1, 2000.0f ),
        }, result.getEntries () );
        Assert.assertEquals ( 0, buffer.getCauseCounter ( cot1, asduAddress1 ) );
        Assert.assertEquals ( 0, buffer.getCauseCounter ( cot1, asduAddress2 ) );
        Assert.assertEquals ( 0, buffer.getCauseCounter ( cot2, asduAddress1 ) );
        Assert.assertEquals ( 0, buffer.getCauseCounter ( cot2, asduAddress2 ) );
    }

    private void doubleFill ( final int limit, final CauseOfTransmission cot, final ASDUAddress asduAddress, final EventBuffer<Float> buffer, final int addressValue )
    {
        Assert.assertEquals ( 0, buffer.getCauseCounter ( cot, asduAddress ) );

        final InformationObjectAddress address = new InformationObjectAddress ( addressValue );

        for ( int i = 0; i < limit; i++ )
        {
            buffer.append ( cot, asduAddress, address, new Value<Float> ( (float)i, 0, QualityInformation.OK ) );
            Assert.assertEquals ( 1 + i, buffer.getCauseCounter ( cot, asduAddress ) ); // works only when we have one cause for testing
        }

        // reached limit

        for ( int i = 0; i < limit; i++ )
        {
            buffer.append ( cot, asduAddress, address, new Value<Float> ( 100.0f * i, 0, QualityInformation.OK ) );
            Assert.assertEquals ( limit, buffer.getCauseCounter ( cot, asduAddress ) ); // works only when we have one cause for testing
        }
    }

    private void assertEntries ( final Pair<?>[] expecteds, final List<InformationEntry<Float>> actuals )
    {
        final List<InformationEntry<?>> entries = new ArrayList<> ( expecteds.length );

        for ( final Pair<?> p : expecteds )
        {
            entries.add ( p.toInformationEntry () );
        }

        assertEntries ( entries, actuals );
    }

    private void assertEntries ( final List<InformationEntry<?>> expecteds, final List<InformationEntry<Float>> actuals )
    {
        Assert.assertArrayEquals ( expecteds.toArray (), actuals.toArray () );
    }
}
