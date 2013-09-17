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
package org.eclipse.scada.sec.equinox;

import org.eclipse.scada.sec.AuthenticationImplementation;
import org.eclipse.scada.sec.osgi.TrackingAuthenticationImplementation;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator
{

    private static Activator instance;

    private TrackingAuthenticationImplementation authentication;

    @Override
    public void start ( final BundleContext context ) throws Exception
    {
        this.authentication = new TrackingAuthenticationImplementation ( context );
        this.authentication.open ();

        instance = this;
    }

    @Override
    public void stop ( final BundleContext context ) throws Exception
    {
        instance = null;

        this.authentication.close ();
        this.authentication = null;
    }

    public static Activator getInstance ()
    {
        return instance;
    }

    public AuthenticationImplementation getAuthentication ()
    {
        return this.authentication;
    }
}
