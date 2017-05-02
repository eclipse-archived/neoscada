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
import org.eclipse.scada.configuration.world.lib.oscar.Helper;
import org.eclipse.scada.configuration.world.lib.oscar.MasterHandlerPriorities;
import org.eclipse.scada.configuration.world.lib.oscar.OscarContext;
import org.eclipse.scada.configuration.world.lib.oscar.item.Items;
import org.eclipse.scada.configuration.world.osgi.BooleanMonitor;
import org.eclipse.scada.configuration.world.osgi.ItemFeatureEntry;

public class BooleanMonitorProcessor implements ItemFeatureProcessor
{

    @Override
    public void process ( final MasterHandlerPriorities priorities, final ItemFeatureEntry rawFeature, final OscarContext context )
    {
        final BooleanMonitor feature = (BooleanMonitor)rawFeature;

        final String configurationId = Features.configurationItem ( feature );

        final Map<String, String> data = new HashMap<String, String> ();

        data.put ( "active", "" + feature.isActive () ); //$NON-NLS-1$ //$NON-NLS-2$
        data.put ( "reference", "" + feature.isReferenceValue () ); //$NON-NLS-1$ //$NON-NLS-2$
        data.put ( "requireAck", "" + feature.isRequireAck () ); //$NON-NLS-1$ //$NON-NLS-2$
        data.put ( "suppressEvents", "" + feature.isSuppressEvents () ); //$NON-NLS-1$ //$NON-NLS-2$
        Helper.addOptional ( data, "message", feature.getMessage () ); //$NON-NLS-1$ 
        data.put ( "severity", feature.getSeverity ().name () ); //$NON-NLS-1$ 
        Helper.addOptional ( data, "demote.prefix", feature.getDemotePrefix () ); //$NON-NLS-1$ 

        final int priority = priorities.findPriority ( Factories.FACTORY_AE_MONITOR_BIT, configurationId );
        Items.fillForMasterHandler ( data, feature.getItem (), priority );

        context.addData ( Factories.FACTORY_AE_MONITOR_BIT, configurationId, data );
    }
}
