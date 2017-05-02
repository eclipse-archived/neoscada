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
 *     IBH SYSTEMS GmbH - Added dummy authenticator
 *******************************************************************************/
package org.eclipse.scada.sec.provider.dummy;

import java.util.Dictionary;
import java.util.Hashtable;

import org.eclipse.scada.sec.AuthenticationService;
import org.eclipse.scada.sec.osgi.AuthorizationManager;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.framework.ServiceRegistration;

public class Console
{

    private final DummyAuthenticationProviderImpl authenticationService;

    private final int priority = Integer.getInteger ( "org.eclipse.scada.sec.provider.dummy.priority", Integer.MIN_VALUE );

    private final int authenticationPriority = Integer.getInteger ( "org.eclipse.scada.sec.provider.dummy.authentication.priority", this.priority );

    private final int authorizationPriority = Integer.getInteger ( "org.eclipse.scada.sec.provider.dummy.authorization.priority", this.priority );

    private BundleContext context;

    private ServiceRegistration<?> authnHandle;

    private ServiceRegistration<?> authzHandle;

    private final DummyAuthorizationProviderImpl authorizationService;

    public Console ()
    {
        this.authenticationService = new DummyAuthenticationProviderImpl ();
        this.authorizationService = new DummyAuthorizationProviderImpl ();
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
        this.authnHandle = this.context.registerService ( AuthenticationService.class, this.authenticationService, properties );
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

    public synchronized void enableDummyAuthorization ()
    {
        if ( this.authzHandle != null )
        {
            return;
        }

        final Dictionary<String, Object> properties = new Hashtable<String, Object> ();
        properties.put ( Constants.SERVICE_DESCRIPTION, "A dummy authorization service" );
        properties.put ( Constants.SERVICE_VENDOR, "Eclipse SCADA Project" );
        properties.put ( Constants.SERVICE_RANKING, this.authorizationPriority );

        System.out.println ( String.format ( "Injecting dummy authorization service with priority: %s", this.authorizationPriority ) );
        this.authzHandle = this.context.registerService ( AuthorizationManager.class, this.authorizationService, properties );
    }

    public synchronized void disableDummyAuthorization ()
    {
        if ( this.authzHandle != null )
        {
            System.out.println ( "Removing dummy authorization service" );
            this.authzHandle.unregister ();
            this.authzHandle = null;
        }
    }

    public void dispose ()
    {
        disableDummyAuthentication ();
    }

}
