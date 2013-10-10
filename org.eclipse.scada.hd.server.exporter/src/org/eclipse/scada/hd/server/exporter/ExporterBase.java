/*******************************************************************************
 * Copyright (c) 2009, 2010 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.hd.server.exporter;

import org.eclipse.scada.core.ConnectionInformation;
import org.eclipse.scada.hd.server.Service;
import org.eclipse.scada.utils.lifecycle.LifecycleAware;

public abstract class ExporterBase implements LifecycleAware
{
    protected Service service = null;

    protected ConnectionInformation connectionInformation;

    public ExporterBase ( final Service service, final ConnectionInformation connectionInformation ) throws Exception
    {
        this.service = service;
        this.connectionInformation = connectionInformation;
    }

    public Class<?> getServiceClass ()
    {
        return this.service.getClass ();
    }

    public ConnectionInformation getConnectionInformation ()
    {
        return this.connectionInformation;
    }
}
