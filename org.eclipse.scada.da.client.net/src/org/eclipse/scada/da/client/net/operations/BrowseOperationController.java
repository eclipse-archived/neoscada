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
package org.eclipse.scada.da.client.net.operations;

import org.eclipse.scada.da.net.handler.ListBrowser;
import org.eclipse.scada.da.net.handler.Messages;
import org.eclipse.scada.net.base.LongRunningController;
import org.eclipse.scada.net.base.data.Message;
import org.eclipse.scada.net.mina.Messenger;
import org.eclipse.scada.utils.exec.LongRunningListener;
import org.eclipse.scada.utils.exec.LongRunningOperation;

public class BrowseOperationController
{
    private LongRunningController controller = null;

    public BrowseOperationController ( final Messenger connection )
    {
        this.controller = new LongRunningController ( connection, Messages.CC_BROWSER_LIST_RES );
    }

    public void register ()
    {
        this.controller.register ();
    }

    public void unregister ()
    {
        this.controller.unregister ();
    }

    public LongRunningOperation start ( final String[] location, final LongRunningListener listener )
    {
        final Message message = ListBrowser.createRequest ( location );

        return this.controller.start ( message, listener );
    }

}
