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
package org.eclipse.scada.base.extractor.mqtt.test;

import java.nio.charset.Charset;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.eclipse.scada.base.extractor.input.Data;
import org.eclipse.scada.base.extractor.input.Input.Listener;
import org.eclipse.scada.base.extractor.mqtt.input.MqttInput;
import org.eclipse.scada.base.extractor.transform.StringTransformer;
import org.junit.Test;

public class InputTest
{
    @Test
    public void test1 () throws Exception
    {
        final ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor ();
        final MqttInput input = new MqttInput ( executor, "tcp://iot.eclipse.org:1883", null, "javaonedemo/eclipse-greenhouse-ben/sensors/temperature", 2 );
        input.addInputListener ( new Listener () {

            @Override
            public void processInput ( final Data data )
            {
                System.out.println ( "Data: " + data );
            }
        } );
        input.addTransformer ( new StringTransformer ( Charset.forName ( "UTF-8" ) ) );

        System.out.println ( "Starting..." );
        input.start ();

        System.out.println ( "Sleeping..." );
        Thread.sleep ( 600_000 );

        System.out.println ( "Stopping..." );
        input.stop ();

        System.out.println ( "Shutdown..." );
        executor.shutdown ();
        executor.awaitTermination ( Long.MAX_VALUE, TimeUnit.MILLISECONDS );
        System.out.println ( "Shutdown...done!" );
    }
}
