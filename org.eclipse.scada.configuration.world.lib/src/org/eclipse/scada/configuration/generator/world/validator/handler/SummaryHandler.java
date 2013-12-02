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

public class SummaryHandler implements LoopHandler
{

    private final Set<SummaryDataSourceDescriptor> ourSources = new HashSet<SummaryDataSourceDescriptor> ();

    @Override
    public Set<DataSourceDescriptor> getNode ( final String configurationId, final Map<String, String> parameters )
    {
        // we will add references later on
        final SummaryDataSourceDescriptor desc = new SummaryDataSourceDescriptor ( configurationId, makeBlacklist ( parameters ), parameters.containsKey ( "onlyMaster" ) );
        this.ourSources.add ( desc );

        return new HashSet<DataSourceDescriptor> ( Arrays.asList ( desc ) );
    }

    private Set<String> makeBlacklist ( final Map<String, String> parameters )
    {
        final Set<String> result = new HashSet<String> ();

        for ( final Map.Entry<String, String> entry : parameters.entrySet () )
        {
            if ( entry.getKey ().startsWith ( "blacklist." ) )
            {
                result.add ( entry.getValue () );
            }
        }
        return result;
    }

    @Override
    public boolean providesDescriptors ()
    {
        return true;
    }

    @Override
    public boolean providesPostProcessing ()
    {
        return true;
    }

    @Override
    public void postProcess ( final Set<DataSourceDescriptor> descriptors )
    {
        for ( final SummaryDataSourceDescriptor our : this.ourSources )
        {
            for ( final DataSourceDescriptor desc : descriptors )
            {
                if ( our.equals ( desc ) )
                {
                    // skip ourself
                    continue;
                }

                if ( our.getBlacklist ().contains ( desc.getId () ) )
                {
                    // skip blacklist
                    continue;
                }

                if ( our.isMasterOnly () && !desc.getId ().endsWith ( ".master" ) )
                {
                    continue;
                }

                our.addReference ( "datasource", desc.getId () );

            }
        }
    }

}
