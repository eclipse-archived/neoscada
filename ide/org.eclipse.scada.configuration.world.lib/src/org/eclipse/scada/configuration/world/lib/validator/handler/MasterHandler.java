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

package org.eclipse.scada.configuration.world.lib.validator.handler;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.scada.configuration.world.lib.validator.DataSourceDescriptor;

public class MasterHandler extends NoOpHandler implements LoopHandler
{
    @Override
    public Set<DataSourceDescriptor> getNode ( final String configurationId, final Map<String, String> parameters )
    {
        final Set<DataSourceDescriptor> result = new HashSet<DataSourceDescriptor> ();

        final DataSourceDescriptor master = new DataSourceDescriptor ( "master", configurationId );
        master.addReference ( "datasource", parameters.get ( "datasource.id" ) );

        final DataSourceDescriptor datasource = new DataSourceDescriptor ( "datasource", configurationId );

        result.add ( master );
        result.add ( datasource );

        return result;
    }

    @Override
    public boolean providesDescriptors ()
    {
        return true;
    }
}
