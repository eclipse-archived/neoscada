/*******************************************************************************
 * Copyright (c) 2013 Jens Reimann and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Jens Reimann - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.server.exporter.osgi;

import java.net.MalformedURLException;
import java.net.URL;

import org.eclipse.scada.da.server.exporter.ConfigurationException;
import org.eclipse.scada.da.server.exporter.Controller;
import org.eclipse.scada.da.server.exporter.HiveFactory;
import org.eclipse.scada.da.server.exporter.osgi.internal.Activator;
import org.osgi.framework.BundleContext;

public class Exporter
{
    private final Controller controller;

    public Exporter ( final String configurationFileUrl ) throws MalformedURLException, ConfigurationException
    {
        this.controller = new Controller ( createHiveFactory ( Activator.getContext () ), new URL ( configurationFileUrl ) );
    }

    private HiveFactory createHiveFactory ( final BundleContext context )
    {
        return new BundleContextHiveFactory ( context );
    }

    public void start () throws Exception
    {
        this.controller.start ();
    }

    public void stop () throws Exception
    {
        this.controller.stop ();
    }
}
