/*******************************************************************************
 * Copyright (c) 2006, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - further development
 *******************************************************************************/
package org.eclipse.scada.sec.provider.dummy;

import java.util.Dictionary;
import java.util.Hashtable;

import org.eclipse.scada.sec.AuthenticationService;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.framework.ServiceRegistration;

public class Console
{

    private final DummyAuthenticationProviderImpl authenticationService;

    private final int priority = Integer.getInteger ( "org.eclipse.scada.sec.provider.dummy.priority", Integer.MIN_VALUE );

    private final int authenticationPriority = Integer.getInteger ( "org.eclipse.scada.sec.provider.dummy.authentication.priority", this.priority );

    private BundleContext context;

    private ServiceRegistration<?> authnHandle;

    public Console ()
    {
        this.authenticationService = new DummyAuthenticationProviderImpl ();
    }

    public void activate ( final BundleContext context )
    {
        this.context = context;
    }

    public synchronized void enableDummyAuthentication ()
    {
        if ( this.authnHandle != null )
        {
            return;
        }

        final Dictionary<String, Object> properties = new Hashtable<String, Object> ();
        properties.put ( Constants.SERVICE_DESCRIPTION, "A dummy authentication service" );
        properties.put ( Constants.SERVICE_VENDOR, "Eclipse SCADA Project" );
        properties.put ( Constants.SERVICE_RANKING, this.authenticationPriority );

        System.out.println ( String.format ( "Injecting dummy authentication service with priority: %s", this.authenticationPriority ) );
        this.authnHandle = this.context.registerService ( AuthenticationService.class.getName (), this.authenticationService, properties );
    }

    public synchronized void disableDummyAuthentication ()
    {
        if ( this.authnHandle != null )
        {
            System.out.println ( "Removing dummy authentication service" );
            this.authnHandle.unregister ();
            this.authnHandle = null;
        }
    }

    public void dispose ()
    {
        disableDummyAuthentication ();
    }

}
