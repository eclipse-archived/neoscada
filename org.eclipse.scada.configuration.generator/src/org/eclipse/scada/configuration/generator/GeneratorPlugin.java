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
package org.eclipse.scada.configuration.generator;

import java.util.Set;

import org.eclipse.core.runtime.Plugin;
import org.osgi.framework.BundleContext;

public class GeneratorPlugin extends Plugin
{

    private static GeneratorPlugin INSTANCE;

    public static GeneratorPlugin getDefault ()
    {
        return INSTANCE;
    }

    private GeneratorLocator locator;

    /*
     * (non-Javadoc)
     * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
     */
    @Override
    public void start ( final BundleContext bundleContext ) throws Exception
    {
        super.start ( bundleContext );
        GeneratorPlugin.INSTANCE = this;
        this.locator = new GeneratorLocator ( bundleContext, getLog () );
        this.locator.start ();

    }

    /*
     * (non-Javadoc)
     * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
     */
    @Override
    public void stop ( final BundleContext bundleContext ) throws Exception
    {
        this.locator.stop ();
        GeneratorPlugin.INSTANCE = null;
        super.stop ( bundleContext );
    }

    public static Set<Generator> createGeneratorsFor ( final Object source )
    {
        return INSTANCE.locator.createGeneratorsFor ( source );
    }
}
