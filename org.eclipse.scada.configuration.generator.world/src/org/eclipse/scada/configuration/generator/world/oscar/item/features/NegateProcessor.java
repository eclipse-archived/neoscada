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
package org.eclipse.scada.configuration.generator.world.oscar.item.features;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.scada.configuration.generator.world.oscar.Factories;
import org.eclipse.scada.configuration.generator.world.oscar.MasterHandlerPriorities;
import org.eclipse.scada.configuration.generator.world.oscar.OscarContext;
import org.eclipse.scada.configuration.generator.world.oscar.item.Items;
import org.eclipse.scada.configuration.world.osgi.ItemFeatureEntry;
import org.eclipse.scada.configuration.world.osgi.Negate;

public class NegateProcessor implements ItemFeatureProcessor
{

    @Override
    public void process ( final MasterHandlerPriorities priorities, final ItemFeatureEntry rawFeature, final OscarContext context )
    {
        final Negate feature = (Negate)rawFeature;

        final String configurationId = Features.configurationItem ( feature );

        final Map<String, String> data = new HashMap<String, String> ();

        data.put ( "active", "" + feature.isActive () ); //$NON-NLS-1$ //$NON-NLS-2$

        final int priority = priorities.findPriority ( Factories.FACTORY_MASTER_HANDLER_NEGATE, configurationId );
        Items.fillForMasterHandler ( data, feature.getItem (), priority );

        context.addData ( Factories.FACTORY_MASTER_HANDLER_NEGATE, configurationId, data );
    }
}
