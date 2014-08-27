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
package org.eclipse.scada.ae.server.syslog;

import java.util.Map;

import org.eclipse.scada.ae.event.EventProcessor;
import org.eclipse.scada.ca.common.factory.AbstractServiceConfigurationFactory;
import org.eclipse.scada.sec.UserInformation;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.InvalidSyntaxException;

public class ReceiverServiceFactory extends AbstractServiceConfigurationFactory<ReceiverServiceEntry>
{
    private final EventProcessor processor;

    public ReceiverServiceFactory () throws InvalidSyntaxException
    {
        super ( FrameworkUtil.getBundle ( ReceiverServiceFactory.class ).getBundleContext () );

        this.processor = new EventProcessor ( FrameworkUtil.getBundle ( ReceiverServiceFactory.class ).getBundleContext () );
        this.processor.open ();
    }

    @Override
    public synchronized void dispose ()
    {
        super.dispose ();
        this.processor.close ();
    }

    @Override
    protected Entry<ReceiverServiceEntry> createService ( final UserInformation userInformation, final String configurationId, final BundleContext context, final Map<String, String> parameters ) throws Exception
    {
        final ReceiverConfiguration cfg = ReceiverConfiguration.parse ( configurationId, parameters );
        return new Entry<> ( configurationId, new ReceiverServiceEntry ( this.processor, cfg ), null );
    }

    @Override
    protected void disposeService ( final UserInformation userInformation, final String configurationId, final ReceiverServiceEntry service )
    {
        service.dispose ();
    }

    @Override
    protected Entry<ReceiverServiceEntry> updateService ( final UserInformation userInformation, final String configurationId, final Entry<ReceiverServiceEntry> entry, final Map<String, String> parameters ) throws Exception
    {
        final ReceiverConfiguration cfg = ReceiverConfiguration.parse ( configurationId, parameters );
        entry.getService ().update ( cfg );
        return entry;
    }
}
