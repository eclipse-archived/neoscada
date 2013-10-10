/*******************************************************************************
 * Copyright (c) 2013 Jens Reimann and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Jens Reimann - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.core.client.net;

import org.eclipse.scada.net.base.MessageStateListener;
import org.eclipse.scada.net.base.data.Message;
import org.eclipse.scada.utils.concurrent.AbstractFuture;

public abstract class MessageFuture<T> extends AbstractFuture<T> implements MessageStateListener
{
    @Override
    public void messageTimedOut ()
    {
        setError ( new InterruptedException ( "Message timed out" ) );
    }

    @Override
    public void messageReply ( final Message message )
    {
        try
        {
            setResult ( process ( message ) );
        }
        catch ( final Exception e )
        {
            setError ( e );
        }
    }

    protected abstract T process ( Message message ) throws Exception;
}