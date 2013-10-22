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
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.scada.configuration.generator.world.validator.DataSourceDescriptor;

public class SimpleAttributeHandler extends NoOpHandler implements LoopHandler
{
    private final String attributeName;

    private final String type;

    private final String referenceType;

    private final String splitPattern;

    public SimpleAttributeHandler ( final String type, final String referenceType, final String attributeName, final String splitPattern )
    {
        this.type = type;
        this.referenceType = referenceType;
        this.attributeName = attributeName;
        this.splitPattern = splitPattern;
    }

    public SimpleAttributeHandler ( final String type, final String referenceType, final String attributeName )
    {
        this ( type, referenceType, attributeName, null );
    }

    @Override
    public Set<DataSourceDescriptor> getNode ( final String configurationId, final Map<String, String> parameters )
    {
        final DataSourceDescriptor desc = new DataSourceDescriptor ( this.type, configurationId );
        final String reference = parameters.get ( this.attributeName );

        if ( reference == null || reference.isEmpty () )
        {
            return Collections.emptySet ();
        }

        if ( this.splitPattern != null )
        {
            for ( final String ref : reference.split ( this.splitPattern ) )
            {
                desc.addReference ( this.referenceType, ref );
            }
        }
        else
        {
            desc.addReference ( this.referenceType, reference );
        }

        return new HashSet<DataSourceDescriptor> ( Arrays.asList ( desc ) );
    }

    @Override
    public boolean providesDescriptors ()
    {
        return true;
    }

}
