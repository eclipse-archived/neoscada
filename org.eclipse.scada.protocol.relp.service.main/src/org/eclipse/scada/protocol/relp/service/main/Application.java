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
package org.eclipse.scada.protocol.relp.service.main;

import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.eclipse.scada.protocol.relp.service.Receiver;
import org.eclipse.scada.protocol.relp.service.StreamHandlerFactory;

public class Application implements IApplication
{
    @Override
    public Object start ( final IApplicationContext context ) throws Exception
    {
        try ( Receiver receiver = new Receiver ( new StreamHandlerFactory ( System.out ), 1204 ) )
        {
            Thread.sleep ( 1_000_000 );
        }
        return null;
    }

    @Override
    public void stop ()
    {
    }
}
