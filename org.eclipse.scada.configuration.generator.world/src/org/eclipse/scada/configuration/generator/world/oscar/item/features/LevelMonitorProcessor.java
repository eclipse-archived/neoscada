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

import org.eclipse.scada.ae.data.Severity;
import org.eclipse.scada.configuration.generator.world.oscar.Factories;
import org.eclipse.scada.configuration.generator.world.oscar.MasterHandlerPriorities;
import org.eclipse.scada.configuration.generator.world.oscar.OscarContext;
import org.eclipse.scada.configuration.generator.world.oscar.item.Items;
import org.eclipse.scada.configuration.world.osgi.ItemFeatureEntry;
import org.eclipse.scada.configuration.world.osgi.LevelMonitor;

public class LevelMonitorProcessor implements ItemFeatureProcessor
{

    @Override
    public void process ( final MasterHandlerPriorities priorities, final ItemFeatureEntry rawFeature, final OscarContext context )
    {
        final LevelMonitor feature = (LevelMonitor)rawFeature;

        // final String configurationId = Items.makeId ( feature.getItem (), "local.level." + feature.getPrefix () );
        final String configurationId = Features.configurationItem ( feature );

        final Double preset = feature.getPreset ();
        final boolean cap = feature.isCap ();
        final boolean requireAck = feature.isRequireAck ();
        final boolean suppressEvents = feature.isSuppressEvents ();
        final Severity severity = feature.getSeverity ();
        final String demotePrefix = feature.getDemotePrefix ();
        final boolean lowerOk = feature.isLowerOk ();
        final boolean includedOk = feature.isIncludedOk ();
        final String monitorType = feature.getMonitorType ();
        final String type = feature.getPrefix ();

        final Map<String, String> data = new HashMap<String, String> ();

        data.put ( "active", "false" ); //$NON-NLS-1$ //$NON-NLS-2$
        if ( preset != null )
        {
            data.put ( "preset", "" + preset ); //$NON-NLS-1$ //$NON-NLS-2$
            data.put ( "active", "true" ); //$NON-NLS-1$ //$NON-NLS-2$
        }

        data.put ( "cap", "" + cap ); //$NON-NLS-1$ //$NON-NLS-2$
        data.put ( "requireAck", "" + requireAck ); //$NON-NLS-1$ //$NON-NLS-2$
        if ( suppressEvents )
        {
            data.put ( "suppressEvents", "" + suppressEvents ); //$NON-NLS-1$ //$NON-NLS-2$
        }
        data.put ( "severity", "" + severity ); //$NON-NLS-1$ //$NON-NLS-2$
        data.put ( "prefix", type ); //$NON-NLS-1$
        data.put ( "monitorType", monitorType ); //$NON-NLS-1$

        data.put ( "lowerOk", "" + lowerOk ); //$NON-NLS-1$ //$NON-NLS-2$
        data.put ( "includedOk", "" + includedOk ); //$NON-NLS-1$ //$NON-NLS-2$

        if ( demotePrefix != null )
        {
            data.put ( "demote.prefix", demotePrefix ); //$NON-NLS-1$
        }

        final int priority = priorities.findPriority ( Factories.FACTORY_AE_MONITOR_LEVEL, configurationId );
        Items.fillForMasterHandler ( data, feature.getItem (), priority );

        context.addData ( Factories.FACTORY_AE_MONITOR_LEVEL, configurationId, data );
    }
}
