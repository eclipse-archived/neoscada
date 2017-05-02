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
package org.eclipse.scada.configuration.world.lib.oscar.item.features;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.scada.configuration.world.lib.oscar.MasterHandlerPriorities;
import org.eclipse.scada.configuration.world.lib.oscar.OscarContext;
import org.eclipse.scada.configuration.world.lib.oscar.item.Items;
import org.eclipse.scada.configuration.world.osgi.ItemFeatureEntry;

public class EmptyItemFeatureProcessor implements ItemFeatureProcessor
{

    private final String factoryId;

    public EmptyItemFeatureProcessor ( final String factoryId )
    {
        this.factoryId = factoryId;
    }

    @Override
    public void process ( final MasterHandlerPriorities priorities, final ItemFeatureEntry rawFeature, final OscarContext context )
    {
        final String configurationId = Features.configurationItem ( rawFeature );

        final Map<String, String> data = new HashMap<String, String> ();

        final int priority = priorities.findPriority ( this.factoryId, configurationId );
        Items.fillForMasterHandler ( data, rawFeature.getItem (), priority );

        context.addData ( this.factoryId, configurationId, data );
    }

}
