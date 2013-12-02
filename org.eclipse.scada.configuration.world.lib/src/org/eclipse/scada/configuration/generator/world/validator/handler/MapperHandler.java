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

import org.eclipse.scada.configuration.generator.world.validator.DataSourceDescriptor;

public class MapperHandler extends NoOpHandler
{

    @Override
    public Set<DataSourceDescriptor> getNode ( final String configurationId, final Map<String, String> parameters )
    {
        final Set<DataSourceDescriptor> result = new HashSet<DataSourceDescriptor> ();

        final DataSourceDescriptor desc = new DataSourceDescriptor ( "masterHandler", configurationId );

        desc.addReference ( "master", parameters.get ( "master.id" ) );
        desc.addReference ( "mapper", parameters.get ( "mapper.id" ) );
        result.add ( desc );

        return result;
    }

    @Override
    public boolean providesDescriptors ()
    {
        return true;
    }

}
