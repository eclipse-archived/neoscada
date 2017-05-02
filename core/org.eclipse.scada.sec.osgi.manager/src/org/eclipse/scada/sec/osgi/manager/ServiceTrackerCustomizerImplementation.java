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
package org.eclipse.scada.sec.osgi.manager;

import org.eclipse.scada.sec.AuthorizationService;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

final class ServiceTrackerCustomizerImplementation implements ServiceTrackerCustomizer<AuthorizationService, AuthorizationService>
{

    private final static Logger logger = LoggerFactory.getLogger ( ServiceTrackerCustomizerImplementation.class );

    private final AuthorizationManagerImpl authorizationManagerImpl;

    private final BundleContext context;

    public ServiceTrackerCustomizerImplementation ( final AuthorizationManagerImpl authorizationManagerImpl, final BundleContext context )
    {
        this.authorizationManagerImpl = authorizationManagerImpl;
        this.context = context;
    }

    private String[] getServiceTypes ( final ServiceReference<AuthorizationService> reference )
    {
        final Object t = reference.getProperty ( AuthorizationService.RULE_TYPES );
        if ( t instanceof String[] )
        {
            return (String[])t;
        }
        else if ( t instanceof String )
        {
            return new String[] { (String)t };
        }
        else
        {
            return null;
        }
    }

    @Override
    public AuthorizationService addingService ( final ServiceReference<AuthorizationService> reference )
    {
        final String[] serviceTypes = getServiceTypes ( reference );

        final AuthorizationService service = this.context.getService ( reference );

        this.authorizationManagerImpl.addService ( service, serviceTypes );

        return service;
    }

    @Override
    public void modifiedService ( final ServiceReference<AuthorizationService> reference, final AuthorizationService service )
    {
        this.authorizationManagerImpl.removeService ( service );

        final String[] serviceTypes = getServiceTypes ( reference );
        this.authorizationManagerImpl.addService ( service, serviceTypes );
    }

    @Override
    public void removedService ( final ServiceReference<AuthorizationService> reference, final AuthorizationService service )
    {
        try
        {
            this.authorizationManagerImpl.removeService ( service );
        }
        catch ( final Exception e )
        {
            logger.warn ( "Failed to remove service", e );
        }
        this.context.ungetService ( reference );
    }
}