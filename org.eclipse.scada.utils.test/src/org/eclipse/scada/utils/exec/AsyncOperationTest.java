/*******************************************************************************
 * Copyright (c) 2006, 2010 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/package org.eclipse.scada.utils.exec;

import org.eclipse.scada.utils.exec.AsyncBasedOperation;
import org.eclipse.scada.utils.exec.Operation;
import org.eclipse.scada.utils.exec.OperationResult;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AsyncOperationTest
{

    Operation<String, String> opAsyncSuccess = null;

    @Before
    public void setUp () throws Exception
    {
        this.opAsyncSuccess = new AsyncBasedOperation<String, String> () {

            @Override
            protected void startExecute ( final OperationResult<String> or, final String arg0 )
            {
                new Thread ( new Runnable () {

                    @Override
                    public void run ()
                    {
                        try
                        {
                            Thread.sleep ( 1000 );
                            System.out.println ( "Say hello: " + arg0 );
                            Thread.sleep ( 1000 );

                            or.notifySuccess ( "Hello to: " + arg0 );
                        }
                        catch ( final Exception e )
                        {
                            or.notifyFailure ( e );
                        }
                    }
                } ).start ();
            }

        };
    }

    @Test
    public void testSync () throws Exception
    {
        Assert.assertEquals ( this.opAsyncSuccess.execute ( "Alice" ), "Hello to: Alice" );
    }

    @Test
    public void testAsync () throws Exception
    {
        final OperationResult<String> or = this.opAsyncSuccess.startExecute ( "Bob" );
        System.out.println ( "Started execution" );

        or.complete ();

        Assert.assertTrue ( or.isComplete () );
        Assert.assertTrue ( or.isSuccess () );
    }

    @Test
    public void testAsyncHandler () throws Exception
    {
        final OperationHandlerTestImpl<String> handler = new OperationHandlerTestImpl<String> ();

        final OperationResult<String> or = this.opAsyncSuccess.startExecute ( handler, "Bob" );
        System.out.println ( "Started execution" );

        or.complete ();

        Assert.assertTrue ( or.isComplete () );
        Assert.assertTrue ( or.isSuccess () );

        Assert.assertTrue ( handler.isSuccess () );
        Assert.assertFalse ( handler.isFailure () );

        Assert.assertNull ( handler.getException () );
        Assert.assertEquals ( handler.getResult (), "Hello to: Bob" );
    }
}
