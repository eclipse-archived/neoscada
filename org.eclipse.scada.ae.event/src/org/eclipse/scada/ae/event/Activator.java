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
package org.eclipse.scada.ae.event;

import org.eclipse.scada.ae.event.internal.EventServiceImpl;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator
{

    private EventServiceImpl service;

    public void start ( final BundleContext context ) throws Exception
    {
        this.service = new EventServiceImpl ( context );
        context.registerService ( new String[] { EventManager.class.getName (), EventService.class.getName () }, this.service, null );
    }

    public void stop ( final BundleContext context ) throws Exception
    {
        this.service.dispose ();
    }

}
