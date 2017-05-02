/*******************************************************************************
 * Copyright (c) 2006, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.utils.osgi.jdbc;

import org.eclipse.scada.utils.osgi.SingleServiceListener;
import org.eclipse.scada.utils.osgi.SingleServiceTracker;
import org.osgi.framework.BundleContext;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.service.jdbc.DataSourceFactory;

public class DataSourceFactoryTracker extends SingleServiceTracker<DataSourceFactory>
{

    private final String driver;

    public DataSourceFactoryTracker ( final BundleContext context, final String driver, final SingleServiceListener<DataSourceFactory> listener ) throws InvalidSyntaxException
    {
        super ( context, context.createFilter ( "(&(objectClass=" + DataSourceFactory.class.getName () + ")(" + DataSourceFactory.OSGI_JDBC_DRIVER_CLASS + "=" + driver + "))" ), listener );
        this.driver = driver;
    }

    public DataSourceFactoryTracker ( final BundleContext context, final String driver, final SingleServiceListener<DataSourceFactory> listener, final boolean isConnectionPool ) throws InvalidSyntaxException
    {
        super ( context, context.createFilter ( "(&(objectClass=" + DataSourceFactory.class.getName () + ")(" + DataSourceFactory.OSGI_JDBC_DRIVER_CLASS + "=" + driver + ")(isConnectionPool=" + isConnectionPool + "))" ), listener );
        this.driver = driver;
    }

    public String getDriver ()
    {
        return this.driver;
    }

}
