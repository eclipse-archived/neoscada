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
package org.eclipse.scada.core.subscription;

import java.util.Set;
import java.util.concurrent.Executor;

import org.junit.Assert;
import org.junit.Test;

public class Test2
{
    @Test
    public void test1 () throws ValidationException
    {
        final Executor executor = new Executor () {

            @Override
            public void execute ( final Runnable command )
            {
                command.run ();
            }
        };

        final ListenableSubscriptionManager<String> manager = new ListenableSubscriptionManager<String> ( executor );

        final SubscriptionRecorder<String> recorder = new SubscriptionRecorder<String> ();

        Set<String> topics;
        manager.subscribe ( "", recorder );

        topics = manager.getAllSubscribedTopics ();
        Assert.assertArrayEquals ( new String[] { "" }, topics.toArray ( new String[0] ) );

        manager.unsubscribe ( "", recorder );

        topics = manager.getAllSubscribedTopics ();
        Assert.assertArrayEquals ( new String[] {}, topics.toArray ( new String[0] ) );
    }
}
