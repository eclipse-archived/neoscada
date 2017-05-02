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
package org.eclipse.scada.da.datasource.testing.test1;

import java.util.concurrent.ScheduledExecutorService;

import org.eclipse.scada.da.datasource.testing.AbstractDataSourceFactory;
import org.eclipse.scada.da.datasource.testing.DefaultDataSource;
import org.osgi.framework.BundleContext;

public class ToggleDataSourceFactory extends AbstractDataSourceFactory
{
    public ToggleDataSourceFactory ( final BundleContext context, final ScheduledExecutorService scheduler )
    {
        super ( context, scheduler );
    }

    @Override
    protected DefaultDataSource createDataSource ()
    {
        return new ToggleDataSource ( getScheduler () );
    }

}
