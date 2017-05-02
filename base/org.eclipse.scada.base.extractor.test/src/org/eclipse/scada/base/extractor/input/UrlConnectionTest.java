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

import java.net.URL;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.eclipse.scada.base.extractor.input.url.UrlConnectionInput;
import org.eclipse.scada.base.extractor.input.utils.TestListener;
import org.junit.Test;

public class UrlConnectionTest
{
    @Test
    public void test1 () throws Exception
    {
        final ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor ();

        final Input input = new UrlConnectionInput ( executor, new URL ( "http://google.com" ), true, 100 );

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
