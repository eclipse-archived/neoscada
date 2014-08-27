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

import org.eclipse.scada.ae.event.EventProcessor;
import org.eclipse.scada.ae.server.injector.EventInjector;
import org.eclipse.scada.ae.server.injector.filter.EventFilter;
import org.eclipse.scada.ae.server.injector.monitor.EventMonitorEvaluator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.framework.FrameworkUtil;

public class EventInjectorManager
{
    private EventInjectorImpl impl;

    private EventProcessor processor;

    private final EventFilter eventFilter;

    private final EventMonitorEvaluator evaluator;

    public EventInjectorManager ( final EventFilter eventFilter, final EventMonitorEvaluator evaluator )
    {
        this.eventFilter = eventFilter;
        this.evaluator = evaluator;
    }

    public synchronized void start () throws Exception
    {
        final BundleContext context = FrameworkUtil.getBundle ( EventInjectorManager.class ).getBundleContext ();

        this.processor = new EventProcessor ( context );
        this.processor.open ();

        this.impl = new EventInjectorImpl ( this.processor, this.eventFilter, this.evaluator );

        final Dictionary<String, Object> properties = new Hashtable<> ();
        properties.put ( Constants.SERVICE_DESCRIPTION, "Event injector service" );
        properties.put ( Constants.SERVICE_VENDOR, "Eclipse SCADA Project" );
        context.registerService ( EventInjector.class, this.impl, properties );
    }

    public synchronized void stop () throws Exception
    {
        if ( this.processor != null )
        {
            this.processor.close ();
        }
        if ( this.impl != null )
        {
            this.impl.dispose ();
        }
    }
}
