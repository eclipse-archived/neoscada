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

import org.eclipse.scada.configuration.world.lib.oscar.Factories;
import org.eclipse.scada.configuration.world.lib.oscar.MasterHandlerPriorities;
import org.eclipse.scada.configuration.world.lib.oscar.OscarContext;
import org.eclipse.scada.configuration.world.lib.oscar.item.Items;
import org.eclipse.scada.configuration.world.osgi.ItemFeatureEntry;
import org.eclipse.scada.configuration.world.osgi.ManualOverride;

public class ManualOverrideProcessor implements ItemFeatureProcessor
{

    @Override
    public void process ( final MasterHandlerPriorities priorities, final ItemFeatureEntry rawFeature, final OscarContext context )
    {
        final ManualOverride feature = (ManualOverride)rawFeature;

        final String configurationId = Features.configurationItem ( feature );

        final Map<String, String> data = new HashMap<String, String> ();

        if ( feature.getInitialValue () != null )
        {
            data.put ( "active", "true" ); //$NON-NLS-1$ //$NON-NLS-2$
            data.put ( "value", feature.getInitialValue () ); //$NON-NLS-1$ 
        }

        final int priority = priorities.findPriority ( Factories.FACTORY_MASTER_HANDLER_MANUAL, configurationId );
        Items.fillForMasterHandler ( data, feature.getItem (), priority );

        context.addData ( Factories.FACTORY_MASTER_HANDLER_MANUAL, configurationId, data );
    }
}
