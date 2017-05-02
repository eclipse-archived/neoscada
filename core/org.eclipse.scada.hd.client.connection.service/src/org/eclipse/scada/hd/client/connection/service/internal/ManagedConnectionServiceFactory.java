/*******************************************************************************
 * Copyright (c) 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.hd.client.connection.service.internal;

import org.eclipse.scada.core.ConnectionInformation;
import org.eclipse.scada.core.client.connection.service.AbstractConnectionManager;
import org.eclipse.scada.core.client.connection.service.AbstractManagedConnectionServiceFactory;
import org.eclipse.scada.hd.connection.provider.ConnectionService;
import org.osgi.framework.BundleContext;

public class ManagedConnectionServiceFactory extends AbstractManagedConnectionServiceFactory<ConnectionService>
{
    private final BundleContext context;

    public ManagedConnectionServiceFactory ( final BundleContext context )
    {
        this.context = context;
    }

    @Override
    protected AbstractConnectionManager<ConnectionService> createConnectionManager ( final String pid, final String uri )
    {
        return new ConnectionManager ( this.context, pid, ConnectionInformation.fromURI ( uri ) );
    }

}
