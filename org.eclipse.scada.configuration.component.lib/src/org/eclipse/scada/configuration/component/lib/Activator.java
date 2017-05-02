/*******************************************************************************
 * Copyright (c) 2013 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.configuration.component.lib;

import org.eclipse.core.runtime.Plugin;
import org.osgi.framework.BundleContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Activator extends Plugin
{

    private final static Logger logger = LoggerFactory.getLogger ( Activator.class );

    public static final String PLUGIN_ID = "org.eclipse.scada.configuration.component.lib";

    private static Activator instance;

    public static Activator getDefault ()
    {
        return instance;
    }

    private ForwardingDanglingReferenceResolver resolver;

    @Override
    public void start ( final BundleContext context ) throws Exception
    {
        instance = this;
    }

    @Override
    public void stop ( final BundleContext context ) throws Exception
    {
        instance = null;
        synchronized ( this )
        {
            if ( this.resolver != null )
            {
                this.resolver.dispose ();
                this.resolver = null;
            }
        }
    }

    public synchronized DanglingReferenceResolver getResolver ()
    {
        if ( this.resolver == null )
        {
            logger.debug ( "Creating new resolver" );
            this.resolver = new ForwardingDanglingReferenceResolver ();
        }
        return this.resolver;
    }

}
