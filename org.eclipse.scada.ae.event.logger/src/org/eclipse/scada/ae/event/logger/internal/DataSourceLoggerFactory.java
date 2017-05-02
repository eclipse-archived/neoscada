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
package org.eclipse.scada.ae.event.logger.internal;

import java.util.Map;

import org.eclipse.scada.ca.common.factory.AbstractServiceConfigurationFactory;
import org.eclipse.scada.da.master.MasterItem;
import org.eclipse.scada.sec.UserInformation;
import org.eclipse.scada.utils.osgi.pool.ObjectPoolTracker;
import org.osgi.framework.BundleContext;
import org.osgi.framework.InvalidSyntaxException;

public class DataSourceLoggerFactory extends AbstractServiceConfigurationFactory<MasterItemLogger>
{

    private final ObjectPoolTracker<MasterItem> poolTracker;

    public DataSourceLoggerFactory ( final BundleContext context ) throws InvalidSyntaxException
    {
        super ( context );
        this.poolTracker = new ObjectPoolTracker<MasterItem> ( context, MasterItem.class );
        this.poolTracker.open ();
    }

    @Override
    public synchronized void dispose ()
    {
        this.poolTracker.close ();
        super.dispose ();
    }

    @Override
    protected Entry<MasterItemLogger> createService ( final UserInformation userInformation, final String configurationId, final BundleContext context, final Map<String, String> parameters ) throws Exception
    {
        final MasterItemLogger logger = new MasterItemLogger ( context, this.poolTracker, 0 );
        logger.update ( userInformation, parameters );
        return new Entry<MasterItemLogger> ( configurationId, logger );
    }

    @Override
    protected void disposeService ( final UserInformation userInformation, final String id, final MasterItemLogger service )
    {
        service.dispose ();
    }

    @Override
    protected Entry<MasterItemLogger> updateService ( final UserInformation userInformation, final String configurationId, final Entry<MasterItemLogger> entry, final Map<String, String> parameters ) throws Exception
    {
        entry.getService ().update ( userInformation, parameters );
        return null;
    }

}
