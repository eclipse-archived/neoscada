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
package org.eclipse.scada.utils.ui.server.internal;

import java.util.Dictionary;
import java.util.Hashtable;

import org.eclipse.scada.utils.ui.server.PageProvider;
import org.eclipse.scada.utils.ui.server.internal.page.main.MainPageProvider;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator
{

    private ServiceRegistration<PageProvider> mainPageHandle;

    @Override
    public void start ( final BundleContext context ) throws Exception
    {
        if ( !Boolean.getBoolean ( "org.eclipse.scada.utils.ui.server.disableMainPage" ) )
        {
            final MainPageProvider mainPageProvider = new MainPageProvider ();
            final Dictionary<String, Object> properties = new Hashtable<> ( 2 );
            properties.put ( Constants.SERVICE_VENDOR, "Eclipse SCADA Project" );
            this.mainPageHandle = context.registerService ( PageProvider.class, mainPageProvider, properties );
        }
    }

    @Override
    public void stop ( final BundleContext context ) throws Exception
    {
        if ( this.mainPageHandle != null )
        {
            this.mainPageHandle.unregister ();
            this.mainPageHandle = null;
        }
    }

}
