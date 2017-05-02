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
package org.eclipse.scada.ae.server.common.event.pool.internal;

import java.util.Map;

import org.eclipse.scada.ca.ConfigurationDataHelper;
import org.eclipse.scada.ca.common.factory.AbstractServiceConfigurationFactory;
import org.eclipse.scada.sec.UserInformation;
import org.osgi.framework.BundleContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EventPoolConfigurationFactory extends AbstractServiceConfigurationFactory<EventPoolManager>
{

    private final static Logger logger = LoggerFactory.getLogger ( EventPoolConfigurationFactory.class );

    public EventPoolConfigurationFactory ( final BundleContext context )
    {
        super ( context );
    }

    @Override
    protected Entry<EventPoolManager> createService ( final UserInformation userInformation, final String configurationId, final BundleContext context, final Map<String, String> parameters ) throws Exception
    {
        logger.info ( "Creating event pool '{}'", configurationId );

        final ConfigurationDataHelper cfg = new ConfigurationDataHelper ( parameters );

        final String filter = parameters.get ( "filter" );
        final Integer size = cfg.getIntegerChecked ( "size", "Need 'size' parameter" );

        final EventPoolManager manager = new EventPoolManager ( context, configurationId, filter, size );
        return new Entry<EventPoolManager> ( configurationId, manager );
    }

    @Override
    protected void disposeService ( final UserInformation userInformation, final String id, final EventPoolManager service )
    {
        logger.info ( "Disposing event pool '{}'", id );

        service.dispose ();
    }

    @Override
    protected Entry<EventPoolManager> updateService ( final UserInformation userInformation, final String configurationId, final Entry<EventPoolManager> entry, final Map<String, String> parameters ) throws Exception
    {
        logger.info ( "Updating event pool '{}'", configurationId );

        final ConfigurationDataHelper cfg = new ConfigurationDataHelper ( parameters );

        final String filter = parameters.get ( "filter" );
        final Integer size = cfg.getIntegerChecked ( "size", "Need 'size' parameter" );

        entry.getService ().update ( filter, size );
        return entry;
    }

}
