/*******************************************************************************
 * Copyright (c) 2016 Red Hat Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Red Hat Inc - initial API and implementation
 *******************************************************************************/
package org.eclipse.neoscada.protocol.iec60870.server.data.model;

import static java.time.Instant.now;
import static org.junit.Assert.fail;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.CompletableFuture;

import org.eclipse.neoscada.protocol.iec60870.server.data.Stopping;
import org.junit.Test;

public class StoppingTest
{

    private static final int WAIT = 100;

    private Stopping timed ( final long milliseconds )
    {
        return new Stopping () {

            @Override
            public void await () throws Exception
            {
                Thread.sleep ( milliseconds );
            }
        };
    }

    @Test
    public void test1 () throws Exception
    {
        final Instant start = now ();
        timed ( WAIT ).await ();

        assertMin ( start, WAIT );
    }

    @Test
    public void test2 () throws Exception
    {
        final Instant start = now ();

        timed ( WAIT ).awaitAsync ();
        assertMin ( start, WAIT );
    }

    @Test
    public void test3 () throws Exception
    {
        final Instant start = now ();

        timed ( WAIT ).awaitSeperately ();
        assertMin ( start, WAIT );
    }

    @Test
    public void test4 () throws Exception
    {
        final Instant start = now ();

        final CompletableFuture<?> future = timed ( WAIT ).completion ();
        assertMax ( start, 10 );
        future.join ();
        assertMin ( start, WAIT );
    }

    @Test
    public void test5 () throws Exception
    {
        final Instant start = now ();

        final CompletableFuture<?> future = timed ( WAIT ).andThen ( timed ( WAIT ) ).completion ();
        assertMax ( start, 10 );
        future.join ();
        assertMin ( start, 2 * WAIT );
    }

    private void assertMax ( final Instant start, final int wait )
    {
        final Duration duration = Duration.between ( start, now () );
        if ( duration.toMillis () > wait )
        {
            fail ( String.format ( "Should take less than %s ms, took %s ms", wait, duration.toMillis () ) );
        }
    }

    private void assertMin ( final Instant start, final int wait )
    {
        final Duration duration = Duration.between ( start, now () );
        if ( duration.toMillis () < wait )
        {
            fail ( String.format ( "Should take as least %s ms, took %s ms", wait, duration.toMillis () ) );
        }
    }
}
