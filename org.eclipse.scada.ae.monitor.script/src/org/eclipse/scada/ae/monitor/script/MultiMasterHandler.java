/*******************************************************************************
 * Copyright (c) 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.ae.monitor.script;

import org.eclipse.scada.ca.ConfigurationAdministrator;
import org.eclipse.scada.da.master.AbstractConfigurableMasterHandlerImpl;
import org.eclipse.scada.da.master.MasterItem;
import org.eclipse.scada.utils.osgi.pool.ObjectPoolTracker;
import org.osgi.util.tracker.ServiceTracker;

public abstract class MultiMasterHandler extends AbstractConfigurableMasterHandlerImpl
{

    public MultiMasterHandler ( final String configurationId, final ObjectPoolTracker<MasterItem> poolTracker, final int priority, final ServiceTracker<ConfigurationAdministrator, ConfigurationAdministrator> caTracker, final String prefix, final String factoryId )
    {
        super ( configurationId, poolTracker, priority, caTracker, prefix, factoryId );
    }

}
