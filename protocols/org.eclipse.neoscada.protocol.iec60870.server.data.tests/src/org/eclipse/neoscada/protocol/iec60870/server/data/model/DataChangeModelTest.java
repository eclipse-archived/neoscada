/*******************************************************************************
 * Copyright (c) 2016, 2017 Red Hat Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Red Hat Inc - initial API and implementation
 *******************************************************************************/
package org.eclipse.neoscada.protocol.iec60870.server.data.model;

import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import org.eclipse.neoscada.protocol.iec60870.asdu.ASDUHeader;
import org.eclipse.neoscada.protocol.iec60870.asdu.message.AbstractMessage;
import org.eclipse.neoscada.protocol.iec60870.asdu.message.MeasuredValueShortFloatingPointSequence;
import org.eclipse.neoscada.protocol.iec60870.asdu.message.SinglePointInformationSequence;
import org.eclipse.neoscada.protocol.iec60870.asdu.types.ASDUAddress;
import org.eclipse.neoscada.protocol.iec60870.asdu.types.CauseOfTransmission;
import org.eclipse.neoscada.protocol.iec60870.asdu.types.CommandValue;
import org.eclipse.neoscada.protocol.iec60870.asdu.types.InformationObjectAddress;
import org.eclipse.neoscada.protocol.iec60870.asdu.types.StandardCause;
import org.eclipse.neoscada.protocol.iec60870.asdu.types.Value;
import org.eclipse.neoscada.protocol.iec60870.server.data.BackgroundIterator;
import org.eclipse.neoscada.protocol.iec60870.server.data.model.MockDataListener.Event;
import org.hamcrest.Matcher;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DataChangeModelTest
{
    private static final int WAIT = 250;

    private MockChangeDataModel model;

    private Thread[] threads;

    @Before
    public void before ()
    {
        this.model = new MockChangeDataModel ( null );
        this.threads = Thread.getAllStackTraces ().keySet ().toArray ( new Thread[0] );
    }

    @After
    public void after () throws Exception
    {
        this.model.stop ().await ();
        this.model = null;

        Thread.sleep ( 50 ); // thread count grace period

        final Thread[] threads = Thread.getAllStackTraces ().keySet ().toArray ( new Thread[0] );
        if ( threads.length != this.threads.length )
        {
            dumpThreads ( "Before", this.threads );
            dumpThreads ( "After", threads );
            fail ( "Illegal thread count" );
        }
    }

    @Test
    public void test1 ()
    {
        this.model.start ();
        this.model.stop ();
    }

    @Test
    public void test1a ()
    {
        this.model.start ();
        this.model.stop ();

        // double stop should not fail
        this.model.stop ();
    }

    @Test
    public void test1b ()
    {
        // no start, stop should not fail as well
        this.model.stop ();
    }

    @Test
    public void testWriteCommandOk () throws Exception
    {
        this.model.start ();

        final MockMirrorCommand mirrorCommand = new MockMirrorCommand ();
        this.model.writeValue ( new ASDUHeader ( CauseOfTransmission.REQUEST, ASDUAddress.valueOf ( 1 ) ), InformationObjectAddress.valueOf ( 1 ), CommandValue.TRUE (), (byte)0, mirrorCommand, true );

        this.model.stop ().await ();

        // assert command

        Assert.assertEquals ( 1, mirrorCommand.getPositive () );
        Assert.assertEquals ( 0, mirrorCommand.getNegative () );
        Assert.assertEquals ( 1, mirrorCommand.getTermination () );
    }

    // FIXME: clarify what exactly this test is testing (fails)
    @Test
    public void testWriteCommandNotOk () throws Exception
    {
        this.model.start ();

        final MockMirrorCommand mirrorCommand = new MockMirrorCommand ();
        this.model.writeValue ( new ASDUHeader ( CauseOfTransmission.REQUEST, ASDUAddress.valueOf ( 1 ) ), InformationObjectAddress.valueOf ( 1 ), new CommandValue<Float> ( 1.2f, System.currentTimeMillis () ), (byte)0, mirrorCommand, true );

        this.model.stop ().await ();

        // assert command

        Assert.assertEquals ( 0, mirrorCommand.getPositive () );
        Assert.assertEquals ( 1, mirrorCommand.getNegative () );
        Assert.assertEquals ( 0, mirrorCommand.getTermination () );
    }

    @Test
    public void testNotify1 () throws Exception
    {
        this.model.start ();

        final MockDataListener dataListener = new MockDataListener ();
        this.model.subscribe ( dataListener );

        this.model.notifyDataChange ( CauseOfTransmission.SPONTANEOUS, ASDUAddress.fromString ( "0-1" ), InformationObjectAddress.fromString ( "2-3-4" ), MockDataListener.TRUE, true );

        this.model.stop ().await ();

        // assert notifies

        dataListener.assertEvents ( //
                new Event ( CauseOfTransmission.SPONTANEOUS, ASDUAddress.fromArray ( new int[] { 0, 1 } ), InformationObjectAddress.fromArray ( new int[] { 2, 3, 4 } ), MockDataListener.TRUE ) //
        );
    }

    @Test
    public void testNotify2 () throws Exception
    {
        this.model.start ();

        final MockDataListener dataListener = new MockDataListener ();
        this.model.subscribe ( dataListener );

        this.model.notifyDataChange ( CauseOfTransmission.SPONTANEOUS, ASDUAddress.fromString ( "0-1" ), InformationObjectAddress.fromString ( "2-3-4" ), MockDataListener.TRUE, true );
        this.model.notifyDataChange ( CauseOfTransmission.SPONTANEOUS, ASDUAddress.fromString ( "0-1" ), InformationObjectAddress.fromString ( "2-3-5" ), MockDataListener.FALSE, true );

        Thread.sleep ( 2 * WAIT );

        this.model.stop ().await ();

        // assert notifies

        dataListener.assertEvents ( //
                new Event ( CauseOfTransmission.SPONTANEOUS, ASDUAddress.fromArray ( new int[] { 0, 1 } ), InformationObjectAddress.fromArray ( new int[] { 2, 3, 4 } ), MockDataListener.TRUE ), //
                new Event ( CauseOfTransmission.SPONTANEOUS, ASDUAddress.fromArray ( new int[] { 0, 1 } ), InformationObjectAddress.fromArray ( new int[] { 2, 3, 5 } ), MockDataListener.FALSE ) //
        );
    }

    private void dumpThreads ( final String string, final Thread[] threads )
    {
        System.out.println ( "==== " + string + " ====" );
        for ( final Thread t : threads )
        {
            System.out.println ( t );
        }
    }

    @Test
    public void testBackground1 () throws Exception
    {
        this.model.start ();

        final MockDataListener dataListener = new MockDataListener ();
        this.model.subscribe ( dataListener );

        this.model.notifyDataChange ( CauseOfTransmission.SPONTANEOUS, ASDUAddress.fromString ( "0-1" ), InformationObjectAddress.fromString ( "2-3-4" ), MockDataListener.TRUE, true );
        this.model.notifyDataChange ( CauseOfTransmission.SPONTANEOUS, ASDUAddress.fromString ( "0-2" ), InformationObjectAddress.fromString ( "2-3-4" ), Value.ok ( 1.0f ), true );

        final BackgroundIterator iter = this.model.createBackgroundIterator ();

        assertNextBackgroundMessage ( iter, 1, instanceOf ( SinglePointInformationSequence.class ) );
        assertNextBackgroundMessage ( iter, 1, instanceOf ( MeasuredValueShortFloatingPointSequence.class ) );

        // next must be null .. scan ended

        assertLastBackgroundMessage ( iter );

        // end

        this.model.stop ().await ();
    }

    @Test
    public void testBackground2 () throws Exception
    {
        this.model.start ();

        final MockDataListener dataListener = new MockDataListener ();
        this.model.subscribe ( dataListener );

        this.model.notifyDataChange ( CauseOfTransmission.SPONTANEOUS, ASDUAddress.fromString ( "0-1" ), InformationObjectAddress.fromString ( "2-3-4" ), MockDataListener.TRUE, true );
        this.model.notifyDataChange ( CauseOfTransmission.SPONTANEOUS, ASDUAddress.fromString ( "0-1" ), InformationObjectAddress.fromString ( "2-3-5" ), MockDataListener.FALSE, true );
        this.model.notifyDataChange ( CauseOfTransmission.SPONTANEOUS, ASDUAddress.fromString ( "0-2" ), InformationObjectAddress.fromString ( "2-3-4" ), Value.ok ( 1.0f ), true );

        final BackgroundIterator iter = this.model.createBackgroundIterator ();

        assertNextBackgroundMessage ( iter, 2 );

        // background iterator should reset now

        this.model.notifyDataChange ( CauseOfTransmission.SPONTANEOUS, ASDUAddress.fromString ( "0-3" ), InformationObjectAddress.fromString ( "2-3-6" ), MockDataListener.TRUE, true );

        assertNextBackgroundMessage ( iter, 2 );

        // end

        this.model.stop ().await ();
    }

    private void assertLastBackgroundMessage ( final BackgroundIterator iter )
    {
        assertNull ( iter.nextMessage () );
    }

    private void assertNextBackgroundMessage ( final BackgroundIterator iter, final int size )
    {
        assertNextBackgroundMessage ( iter, size, null );
    }

    private void assertNextBackgroundMessage ( final BackgroundIterator iter, final int size, final Matcher<Object> matcher )
    {
        final Object o = iter.nextMessage ();
        assertNotNull ( o );

        assertThat ( o, instanceOf ( AbstractMessage.class ) );

        final AbstractMessage amsg = (AbstractMessage)o;
        assertEquals ( StandardCause.BACKGROUND, amsg.getHeader ().getCauseOfTransmission ().getCause () );

        if ( matcher != null )
        {
            assertThat ( o, matcher );
        }

        if ( amsg instanceof SinglePointInformationSequence )
        {
            final SinglePointInformationSequence msg = (SinglePointInformationSequence)amsg;
            assertEquals ( size, msg.getValues ().size () );
        }
        else if ( amsg instanceof MeasuredValueShortFloatingPointSequence )
        {
            final MeasuredValueShortFloatingPointSequence msg = (MeasuredValueShortFloatingPointSequence)amsg;
            assertEquals ( size, msg.getValues ().size () );
        }
        else
        {
            fail ( "Wrong messgae type: " + amsg.getClass ().getName () );
        }
    }
}
