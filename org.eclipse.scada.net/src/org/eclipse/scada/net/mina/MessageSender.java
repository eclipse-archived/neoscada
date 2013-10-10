/*******************************************************************************
 * Copyright (c) 2010, 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.net.mina;

import org.apache.mina.core.future.WriteFuture;
import org.eclipse.scada.net.base.data.Message;

public interface MessageSender
{

    /**
     * Send a message out to somewhere
     * 
     * @param message
     *            the message to send
     * @param prepareSendHandler
     *            the prepare handler to call after the message is prepared
     * @return <code>true</code> if the message was send out (does not guarantee a successful delivery!)
     */
    public WriteFuture sendMessage ( Message message, PrepareSendHandler prepareSendHandler );

    /**
     * Close the session of the sender
     */
    public void close ();
}
