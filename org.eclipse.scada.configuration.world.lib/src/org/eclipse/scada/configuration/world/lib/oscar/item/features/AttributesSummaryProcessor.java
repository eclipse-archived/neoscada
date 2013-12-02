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

import org.eclipse.emf.common.util.EList;
import org.eclipse.scada.configuration.world.lib.oscar.Factories;
import org.eclipse.scada.configuration.world.lib.oscar.MasterHandlerPriorities;
import org.eclipse.scada.configuration.world.lib.oscar.OscarContext;
import org.eclipse.scada.configuration.world.lib.oscar.item.Items;
import org.eclipse.scada.configuration.world.osgi.AttributesSummary;
import org.eclipse.scada.configuration.world.osgi.ItemFeatureEntry;
import org.eclipse.scada.utils.str.StringHelper;

public class AttributesSummaryProcessor implements ItemFeatureProcessor
{

    @Override
    public void process ( final MasterHandlerPriorities priorities, final ItemFeatureEntry rawFeature, final OscarContext context )
    {
        final AttributesSummary feature = (AttributesSummary)rawFeature;

        final String configurationId = Features.configurationItem ( feature );

        final EList<String> tags = feature.getAttributes ();
        final String prefix = feature.getOutputPrefix ();

        final Map<String, String> data = new HashMap<String, String> ();

        data.put ( "tag", StringHelper.join ( tags, ", " ) ); //$NON-NLS-1$

        for ( final String tag : tags )
        {
            if ( prefix != null )
            {
                data.put ( "tag." + tag + ".prefix", prefix ); //$NON-NLS-1$ //$NON-NLS-2$
            }
        }

        final int priority = priorities.findPriority ( Factories.FACTORY_DA_MASTER_HANDLER_SUM, configurationId );
        Items.fillForMasterHandler ( data, feature.getItem (), priority );

        context.addData ( Factories.FACTORY_DA_MASTER_HANDLER_SUM, configurationId, data );
    }
}
