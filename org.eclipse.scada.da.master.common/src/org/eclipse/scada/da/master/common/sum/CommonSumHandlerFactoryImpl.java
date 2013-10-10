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
package org.eclipse.scada.da.master.common.sum;

import java.util.Map;

import org.eclipse.scada.ca.common.factory.AbstractServiceConfigurationFactory;
import org.eclipse.scada.da.master.AbstractMasterHandlerImpl;
import org.eclipse.scada.da.master.MasterItem;
import org.eclipse.scada.sec.UserInformation;
import org.eclipse.scada.utils.osgi.pool.ObjectPoolTracker;
import org.osgi.framework.BundleContext;
import org.osgi.framework.InvalidSyntaxException;

public class CommonSumHandlerFactoryImpl extends AbstractServiceConfigurationFactory<AbstractMasterHandlerImpl>
{
    private final ObjectPoolTracker<MasterItem> poolTracker;

    public CommonSumHandlerFactoryImpl ( final BundleContext context, final ObjectPoolTracker<MasterItem> poolTracker ) throws InvalidSyntaxException
    {
        super ( context );
        this.poolTracker = poolTracker;
        this.poolTracker.open ();
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
        final AbstractMasterHandlerImpl handler = new CommonSumHandler ( this.poolTracker );
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
