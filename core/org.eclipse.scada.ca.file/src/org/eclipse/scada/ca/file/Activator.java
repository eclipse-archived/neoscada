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
package org.eclipse.scada.ca.file;

import java.util.Dictionary;
import java.util.Hashtable;

import org.eclipse.scada.ca.ConfigurationAdministrator;
import org.eclipse.scada.ca.FreezableConfigurationAdministrator;
import org.eclipse.scada.ca.common.AbstractConfigurationAdministrator;
import org.eclipse.scada.ca.file.internal.ConfigurationAdminImpl;
import org.eclipse.scada.utils.interner.InternerHelper;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.framework.ServiceRegistration;

import com.google.common.collect.Interner;

public class Activator implements BundleActivator
{
    private AbstractConfigurationAdministrator service;

    private ServiceRegistration<?> handle;

    private Interner<String> stringInterner;

    @Override
    public void start ( final BundleContext context ) throws Exception
    {
        this.stringInterner = InternerHelper.makeInterner ( "org.eclipse.scada.ca.file.stringInternerType", "weak" );

        this.service = new ConfigurationAdminImpl ( context, this.stringInterner );

        this.service.start ();

        final Dictionary<String, Object> properties = new Hashtable<String, Object> ();
        properties.put ( Constants.SERVICE_VENDOR, "Eclipse SCADA Project" );
        properties.put ( Constants.SERVICE_DESCRIPTION, "An Eclipse SCADA CA File Implementation" );

        this.handle = context.registerService ( new String[] { ConfigurationAdministrator.class.getName (), FreezableConfigurationAdministrator.class.getName () }, this.service, properties );
    }

    @Override
    public void stop ( final BundleContext context ) throws Exception
    {
        this.handle.unregister ();
        this.handle = null;

        this.service.dispose ();
        this.service = null;
    }

}
