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
package org.eclipse.scada.ae.server.injector.internal;

import java.util.Dictionary;
import java.util.Hashtable;

import org.eclipse.scada.ae.server.injector.monitor.EventMonitorEvaluator;
import org.eclipse.scada.ca.ConfigurationAdministrator;
import org.eclipse.scada.ca.ConfigurationFactory;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.framework.FrameworkUtil;

public class EventInjectorManager
{
    private EventInjectorImpl impl;

    private final EventMonitorEvaluator evaluator;

    public EventInjectorManager ( final EventMonitorEvaluator evaluator )
    {
        this.evaluator = evaluator;
    }

    public synchronized void start () throws Exception
    {
        final BundleContext context = FrameworkUtil.getBundle ( EventInjectorManager.class ).getBundleContext ();

        this.impl = new EventInjectorImpl ( context, this.evaluator );

        final Dictionary<String, Object> properties = new Hashtable<> ();
        properties.put ( Constants.SERVICE_DESCRIPTION, "Event injector manager" );
        properties.put ( Constants.SERVICE_VENDOR, "Eclipse SCADA Project" );
        properties.put ( "osgi.command.scope", "ein" );
        properties.put ( "osgi.command.function", new String[] { "rules", "state" } );
        properties.put ( ConfigurationAdministrator.FACTORY_ID, "org.eclipse.scada.ae.server.injector" );
        context.registerService ( ConfigurationFactory.class, this.impl, properties );
    }

    public synchronized void stop () throws Exception
    {
        if ( this.impl != null )
        {
            this.impl.dispose ();
        }
    }
}
