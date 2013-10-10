/*******************************************************************************
 * Copyright (c) 2011 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.datasource.formula;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import org.eclipse.scada.ca.ConfigurationAdministrator;
import org.eclipse.scada.ca.ConfigurationFactory;
import org.eclipse.scada.utils.concurrent.NamedThreadFactory;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;

public class Activator implements BundleActivator
{

    private ScheduledExecutorService executor;

    private FormulaSourceFactory factory;

    /*
     * (non-Javadoc)
     * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
     */
    @Override
    public void start ( final BundleContext context ) throws Exception
    {
        this.executor = Executors.newSingleThreadScheduledExecutor ( new NamedThreadFactory ( context.getBundle ().getSymbolicName () ) );

        this.factory = new FormulaSourceFactory ( context, this.executor );

        final Dictionary<String, String> properties = new Hashtable<String, String> ();
        properties.put ( Constants.SERVICE_DESCRIPTION, "A formula data source" );
        properties.put ( Constants.SERVICE_VENDOR, "Eclipse SCADA Project" );
        properties.put ( ConfigurationAdministrator.FACTORY_ID, context.getBundle ().getSymbolicName () );

        context.registerService ( ConfigurationFactory.class.getName (), this.factory, properties );
    }

    /*
     * (non-Javadoc)
     * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
     */
    @Override
    public void stop ( final BundleContext bundleContext ) throws Exception
    {
        this.factory.dispose ();
        this.executor.shutdown ();
        this.factory = null;
        this.executor = null;
    }

}
