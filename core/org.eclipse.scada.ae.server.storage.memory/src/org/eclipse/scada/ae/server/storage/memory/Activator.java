/*******************************************************************************
 * Copyright (c) 2009, 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.ae.server.storage.memory;

import java.util.Dictionary;
import java.util.Hashtable;

import org.eclipse.scada.ae.server.storage.Storage;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator
{

    private MemoryStorage memoryStorage;

    private ServiceRegistration<?> handle;

    @Override
    public void start ( final BundleContext context ) throws Exception
    {
        this.memoryStorage = new MemoryStorage ();

        final Dictionary<String, Object> props = new Hashtable<String, Object> ();
        this.handle = context.registerService ( new String[] { MemoryStorage.class.getName (), Storage.class.getName () }, this.memoryStorage, props );
    }

    @Override
    public void stop ( final BundleContext context ) throws Exception
    {
        this.handle.unregister ();
        this.memoryStorage = null;
        return;
    }
}
