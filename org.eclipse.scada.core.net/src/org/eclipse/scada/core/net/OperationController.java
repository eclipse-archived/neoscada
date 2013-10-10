/*******************************************************************************
 * Copyright (c) 2010 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.core.net;

import org.eclipse.scada.net.base.data.LongValue;
import org.eclipse.scada.net.base.data.Message;
import org.eclipse.scada.net.mina.Messenger;
import org.eclipse.scada.net.utils.MessageCreator;

public class OperationController
{
    private Messenger messenger = null;

    public OperationController ( final Messenger messenger )
    {
        super ();
        this.messenger = messenger;
    }

    protected void sendACK ( final Message request, final long id )
    {
        final Message message = MessageCreator.createACK ( request );
        message.getValues ().put ( "id", new LongValue ( id ) );
        this.messenger.sendMessage ( message );
    }

    protected void sendFailure ( final Message request, final Throwable e )
    {
        final Message message = MessageCreator.createFailedMessage ( request, e );
        this.messenger.sendMessage ( message );
    }
}
