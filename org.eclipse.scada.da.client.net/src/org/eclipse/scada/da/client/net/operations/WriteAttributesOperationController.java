/*******************************************************************************
 * Copyright (c) 2010, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *******************************************************************************/
package org.eclipse.scada.da.client.net.operations;

import java.util.Map;

import org.eclipse.scada.core.Variant;
import org.eclipse.scada.core.data.OperationParameters;
import org.eclipse.scada.da.net.handler.Messages;
import org.eclipse.scada.da.net.handler.WriteAttributesOperation;
import org.eclipse.scada.net.base.LongRunningController;
import org.eclipse.scada.net.base.data.Message;
import org.eclipse.scada.net.mina.Messenger;
import org.eclipse.scada.utils.exec.LongRunningListener;
import org.eclipse.scada.utils.exec.LongRunningOperation;

public class WriteAttributesOperationController
{
    private LongRunningController controller = null;

    public WriteAttributesOperationController ( final Messenger connection )
    {
        this.controller = new LongRunningController ( connection, Messages.CC_WRITE_ATTRIBUTES_OPERATION_RESULT );
    }

    public void register ()
    {
        this.controller.register ();
    }

    public void unregister ()
    {
        this.controller.unregister ();
    }

    public LongRunningOperation start ( final String itemName, final Map<String, Variant> attributes, final OperationParameters operationParameters, final LongRunningListener listener )
    {
        final Message message = WriteAttributesOperation.createRequest ( itemName, attributes, operationParameters );

        return this.controller.start ( message, listener );
    }

}
