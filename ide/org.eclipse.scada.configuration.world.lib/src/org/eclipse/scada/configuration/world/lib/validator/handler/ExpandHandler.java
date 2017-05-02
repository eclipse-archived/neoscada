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
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.scada.configuration.world.lib.validator.DataSourceDescriptor;

public class ExpandHandler extends NoOpHandler
{
    private final Set<String> suffixes;

    private final String type;

    public ExpandHandler ( final String type, final List<String> suffixes )
    {
        this.type = type;
        this.suffixes = new LinkedHashSet<String> ( suffixes );
    }

    @Override
    public Set<DataSourceDescriptor> getNode ( final String configurationId, final Map<String, String> parameters )
    {
        final Set<DataSourceDescriptor> result = new HashSet<DataSourceDescriptor> ();

        for ( final String suffix : this.suffixes )
        {
            result.add ( new DataSourceDescriptor ( this.type, configurationId + "." + suffix ) );
        }

        return result;
    }

    @Override
    public boolean providesDescriptors ()
    {
        return true;
    }
}