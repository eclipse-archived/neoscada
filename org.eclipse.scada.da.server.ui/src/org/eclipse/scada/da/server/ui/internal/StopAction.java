/*******************************************************************************
 * Copyright (c) 2013 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.server.ui.internal;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.scada.da.server.ui.ServerLifecycle;

public class StopAction extends AbstractServerHandler
{

    @Override
    protected void process ( final ServerLifecycle server ) throws CoreException
    {
        server.stop ();
    }

    @Override
    protected String getLabel ()
    {
        return "Stopping";
    }

}
