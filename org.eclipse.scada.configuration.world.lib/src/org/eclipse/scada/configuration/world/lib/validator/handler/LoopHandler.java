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

import java.util.Map;
import java.util.Set;

import org.eclipse.scada.configuration.world.lib.validator.DataSourceDescriptor;

public interface LoopHandler
{
    public Set<DataSourceDescriptor> getNode ( String configurationId, Map<String, String> parameters );

    public boolean providesDescriptors ();

    public boolean providesPostProcessing ();

    public void postProcess ( Set<DataSourceDescriptor> descriptors );
}
