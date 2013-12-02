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

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.scada.configuration.generator.world.validator.DataSourceDescriptor;

public class MultiSourceAttributeHandler extends NoOpHandler implements LoopHandler
{
    private final String[] attributePrefix;

    public MultiSourceAttributeHandler ( final String... attributePrefix )
    {
        this.attributePrefix = attributePrefix;
    }

    @Override
    public Set<DataSourceDescriptor> getNode ( final String configurationId, final Map<String, String> parameters )
    {
        final DataSourceDescriptor desc = createNode ( configurationId, parameters );

        return new HashSet<DataSourceDescriptor> ( Arrays.asList ( desc ) );
    }

    protected DataSourceDescriptor createNode ( final String configurationId, final Map<String, String> parameters )
    {
        final DataSourceDescriptor desc = new DataSourceDescriptor ( "datasource", configurationId );

        for ( final String prefix : this.attributePrefix )
        {
            for ( final Map.Entry<String, String> entry : parameters.entrySet () )
            {
                if ( !entry.getKey ().startsWith ( prefix ) )
                {
                    continue;
                }

                if ( ! ( entry.getValue () instanceof String ) )
                {
                    continue;
                }

                if ( entry.getValue ().isEmpty () )
                {
                    continue;
                }

                desc.addReference ( "datasource", entry.getValue () );
            }
        }
        return desc;
    }

    @Override
    public boolean providesDescriptors ()
    {
        return true;
    }

}
