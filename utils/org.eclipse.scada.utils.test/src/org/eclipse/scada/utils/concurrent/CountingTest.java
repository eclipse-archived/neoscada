/*******************************************************************************
 * Copyright (c) 2006, 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.utils.concurrent;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

import org.eclipse.scada.utils.concurrent.CountingThreadPoolExecutor.Listener;

public class CountingTest
{
    public static void main ( final String[] args )
    {
        final CountingThreadPoolExecutor exec = new CountingThreadPoolExecutor ( 1, 1, 1, TimeUnit.MINUTES, new LinkedBlockingDeque<Runnable> (), new NamedThreadFactory ( "Testing" ) );

        exec.addListener ( new Listener () {

            @Override
            public void countChanged ( final int count )
            {
                System.out.println ( "Count: " + count );
            }
        } );

        for ( int i = 0; i < 100; i++ )
        {
            exec.execute ( new Runnable () {

                @Override
                public void run ()
                {
                    System.out.println ( "Test" );
                }
            } );
        }

        System.out.println ( "Before now" );
        exec.shutdownNow ();
        System.out.println ( "After now" );
    }
}
