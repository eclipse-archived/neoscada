/*******************************************************************************
 * Copyright (c) 2006, 2010 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.utils.concurrent;

import java.util.Collection;
import java.util.LinkedList;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ListeningFutureTest
{

    private FutureTestImpl<Object> future;

    @Before
    public void setUp () throws Exception
    {
        this.future = new FutureTestImpl<Object> ();
    }

    @Test ( expected = CancellationException.class )
    public void test1 () throws InterruptedException, ExecutionException
    {
        final boolean rc = this.future.cancel ( true );
        Assert.assertEquals ( "Cancel must return true", true, rc );
        this.future.get ();
    }

    @Test ( expected = ExecutionException.class )
    public void test2 () throws InterruptedException, ExecutionException
    {
        this.future.setError ( new RuntimeException ( "test" ).fillInStackTrace () );
        this.future.get ();
    }

    @Test
    public void test3 () throws InterruptedException, ExecutionException
    {
        final Object result = new Object ();
        this.future.setResult ( result );
        Assert.assertEquals ( "Result does not match", result, this.future.get () );
    }

    @Test
    public void test4 () throws InterruptedException, ExecutionException
    {
        final Object result = new Object ();
        this.future.setResult ( result );
        this.future.setResult ( new Object () );
        Assert.assertEquals ( "Result does not match", result, this.future.get () );
    }

    @Test
    public void test5 () throws InterruptedException, ExecutionException
    {
        final Object result = new Object ();
        this.future.setResult ( result );
        final boolean rc = this.future.cancel ( true );
        Assert.assertEquals ( "Cancel must return false", false, rc );
        Assert.assertEquals ( "Result does not match", result, this.future.get () );
    }

    @Test
    public void test6 () throws InterruptedException, ExecutionException
    {
        final int count = 10;
        final ExecutorService service = Executors.newFixedThreadPool ( count );

        final Collection<Future<Object>> futures = new LinkedList<Future<Object>> ();
        for ( int i = 0; i < count; i++ )
        {
            futures.add ( service.submit ( new Callable<Object> () {

                @Override
                public Object call () throws Exception
                {
                    System.out.println ( "Waiting" );
                    final Object result = ListeningFutureTest.this.future.get ();
                    System.out.println ( "Completed" );
                    return result;
                }
            } ) );
        }

        // set result
        final Object result = new Object ();
        this.future.setResult ( result );

        // shutdown
        service.shutdown ();

        // validate
        for ( final Future<Object> f : futures )
        {
            Assert.assertEquals ( "Result not ok", result, f.get () );
        }
    }
}
