/*******************************************************************************
 * Copyright (c) 2010, 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.master.common.manual;

import java.util.Map;

import org.eclipse.scada.ae.event.EventProcessor;
import org.eclipse.scada.ca.ConfigurationAdministrator;
import org.eclipse.scada.ca.common.factory.AbstractServiceConfigurationFactory;
import org.eclipse.scada.da.master.AbstractMasterHandlerImpl;
import org.eclipse.scada.da.master.MasterItem;
import org.eclipse.scada.sec.UserInformation;
import org.eclipse.scada.utils.osgi.pool.ObjectPoolTracker;
import org.osgi.framework.BundleContext;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.util.tracker.ServiceTracker;

public class ManualHandlerFactoryImpl extends AbstractServiceConfigurationFactory<AbstractMasterHandlerImpl>
{
    public static final String FACTORY_ID = "org.openscada.da.manual"; //$NON-NLS-1$

    private final int priority;

    private final ObjectPoolTracker<MasterItem> poolTracker;

    private final ServiceTracker<ConfigurationAdministrator, ConfigurationAdministrator> caTracker;

    private final EventProcessor eventProcessor;

    public ManualHandlerFactoryImpl ( final BundleContext context, final EventProcessor eventProcessor, final ObjectPoolTracker<MasterItem> poolTracker, final ServiceTracker<ConfigurationAdministrator, ConfigurationAdministrator> caTracker, final int priority ) throws InvalidSyntaxException
    {
        super ( context );
        this.eventProcessor = eventProcessor;
        this.priority = priority;
        this.poolTracker = poolTracker;
        this.caTracker = caTracker;
    }

    @Override
    public synchronized void dispose ()
    {
        this.poolTracker.close ();
        super.dispose ();
    }

    @Override
    protected Entry<AbstractMasterHandlerImpl> createService ( final UserInformation userInformation, final String configurationId, final BundleContext context, final Map<String, String> parameters ) throws Exception
    {
        final AbstractMasterHandlerImpl handler = new ManualHandlerImpl ( configurationId, this.eventProcessor, this.poolTracker, this.priority, this.caTracker );
        handler.update ( userInformation, parameters );
        return new Entry<AbstractMasterHandlerImpl> ( configurationId, handler );
    }

    @Override
    protected Entry<AbstractMasterHandlerImpl> updateService ( final UserInformation userInformation, final String configurationId, final Entry<AbstractMasterHandlerImpl> entry, final Map<String, String> parameters ) throws Exception
    {
        entry.getService ().update ( userInformation, parameters );
        return null;
    }

    @Override
    protected void disposeService ( final UserInformation userInformation, final String id, final AbstractMasterHandlerImpl service )
    {
        service.dispose ();
    }

}
