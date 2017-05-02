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
package org.eclipse.scada.base.extractor.input;

import java.nio.charset.Charset;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.eclipse.scada.base.extractor.input.process.ProcessInput;
import org.eclipse.scada.base.extractor.input.utils.TestListener;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProcessTest
{

    private final static Logger logger = LoggerFactory.getLogger ( ProcessTest.class );

    @Test
    public void test1 () throws Exception
    {
        final ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor ();

        final ProcessBuilder pb = new ProcessBuilder ( "date" ); // FIXME: works only on unix
        final AbstractScheduledInput input = new ProcessInput ( executor, pb, Charset.forName ( "UTF-8" ), 1000 );

        final TestListener listener = new TestListener ();

        input.addInputListener ( listener );

        input.start ();
        Thread.sleep ( 100 );
        input.stop ();
        input.dispose ();

        executor.shutdown ();
        executor.awaitTermination ( Long.MAX_VALUE, TimeUnit.MINUTES );

        dumpData ( listener );

        // TODO: test
    }

    @Test
    public void test2 () throws Exception
    {
        final ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor ();

        final ProcessBuilder pb = new ProcessBuilder ( "sleep", "3" ); // FIXME: works only on unix
        final AbstractScheduledInput input = new ProcessInput ( executor, pb, Charset.forName ( "UTF-8" ), 1000 );

        final TestListener listener = new TestListener ();

        input.addInputListener ( listener );

        logger.debug ( "test2 - start" );

        input.start ();
        Thread.sleep ( 100 );
        logger.debug ( "test2 - stop" );
        input.stop ();
        logger.debug ( "test2 - dispose" );
        input.dispose ();

        logger.debug ( "test2 - shutdown" );
        executor.shutdown ();
        logger.debug ( "test2 - wait" );
        executor.awaitTermination ( Long.MAX_VALUE, TimeUnit.MINUTES );
        logger.debug ( "test2 - done" );

        dumpData ( listener );

        // TODO: test
    }

    private void dumpData ( final TestListener listener )
    {
        System.out.println ( "Data:" );
        System.out.println ( "==========" );
        int i = 0;
        for ( final Data data : listener.getData () )
        {
            System.out.println ( String.format ( "#%03d: %s", i, data ) );
            i++;
        }
        System.out.println ( "==========" );
    }
}
