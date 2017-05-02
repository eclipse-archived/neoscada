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

import java.util.Collections;
import java.util.Map;
import java.util.Set;

import org.eclipse.scada.configuration.world.lib.validator.DataSourceDescriptor;

public class NoOpHandler implements LoopHandler
{

    @Override
    public Set<DataSourceDescriptor> getNode ( final String configurationId, final Map<String, String> parameters )
    {
        return Collections.emptySet ();
    }

    @Override
    public boolean providesDescriptors ()
    {
        return false;
    }

    @Override
    public boolean providesPostProcessing ()
    {
        return false;
    }

    @Override
    public void postProcess ( final Set<DataSourceDescriptor> descriptors )
    {
    }

}
