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
package org.eclipse.scada.configuration.generator.world.validator.handler;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.scada.ca.ConfigurationDataHelper;
import org.eclipse.scada.configuration.generator.world.validator.DataSourceDescriptor;

public class ProxyQueryHandler extends NoOpHandler
{
    private final String ourType;

    public ProxyQueryHandler ( final String ourType )
    {
        this.ourType = ourType;
    }

    @Override
    public Set<DataSourceDescriptor> getNode ( final String configurationId, final Map<String, String> parameters )
    {
        final Set<DataSourceDescriptor> result = new HashSet<DataSourceDescriptor> ();

        final DataSourceDescriptor desc = new DataSourceDescriptor ( this.ourType, configurationId );

        final ConfigurationDataHelper cfg = new ConfigurationDataHelper ( parameters );

        for ( final String query : cfg.getPrefixed ( "local.queries." ).values () )
        {
            desc.addReference ( this.ourType, query );
        }

        for ( final String query : cfg.getPrefixed ( "remove.queries." ).values () )
        {
            final String tok[] = query.split ( "#" );
            desc.addReference ( "ae.connection", tok[0] );
        }

        result.add ( desc );

        return result;
    }

    @Override
    public boolean providesDescriptors ()
    {
        return true;
    }
}
