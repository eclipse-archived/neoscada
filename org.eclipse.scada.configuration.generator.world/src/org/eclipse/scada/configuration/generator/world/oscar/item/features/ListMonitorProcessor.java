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
import org.eclipse.scada.configuration.generator.world.oscar.Helper;
import org.eclipse.scada.configuration.generator.world.oscar.MasterHandlerPriorities;
import org.eclipse.scada.configuration.generator.world.oscar.OscarContext;
import org.eclipse.scada.configuration.generator.world.oscar.item.Items;
import org.eclipse.scada.configuration.world.osgi.ItemFeatureEntry;
import org.eclipse.scada.configuration.world.osgi.ListMonitor;
import org.eclipse.scada.configuration.world.osgi.ListMonitorEntry;

public class ListMonitorProcessor implements ItemFeatureProcessor
{

    @Override
    public void process ( final MasterHandlerPriorities priorities, final ItemFeatureEntry rawFeature, final OscarContext context )
    {
        final ListMonitor feature = (ListMonitor)rawFeature;

        final String configurationId = Features.configurationItem ( feature );

        final Map<String, String> data = new HashMap<String, String> ();

        data.put ( "defaultSeverity", feature.getDefaultSeverity ().name () );
        data.put ( "defaultAck", "" + feature.isDefaultAck () );
        data.put ( "monitorType", feature.getMonitorType () );
        Helper.addOptional ( data, "demote.prefix", feature.getDemotePrefix () );
        Helper.addOptional ( data, "messageAttribute", feature.getMessageAttribute () );
        Helper.addOptional ( data, "message", feature.getMessage () );

        int i = 0;
        for ( final ListMonitorEntry entry : feature.getEntries () )
        {
            final String value = entry.getValue ().toString ();

            if ( entry.getRequireAck () != null )
            {
                final String prefix = entry.getRequireAck () ? "ack" : "nak";
                data.put ( String.format ( "values.%s.%s", prefix, i ), value );

            }
            if ( entry.getSeverity () != null )
            {
                data.put ( String.format ( "values.%s.%s", entry.getSeverity ().name (), i ), value );
            }
            i++;
        }

        final int priority = priorities.findPriority ( Factories.FACTORY_AE_MONITOR_LIST, configurationId );
        Items.fillForMasterHandler ( data, feature.getItem (), priority );

        context.addData ( Factories.FACTORY_AE_MONITOR_LIST, configurationId, data );
    }
}
