/*******************************************************************************
 * Copyright (c) 2012, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *******************************************************************************/
package org.eclipse.scada.ae.monitor.datasource.common.list;

import java.util.Map;

import org.eclipse.scada.ae.monitor.common.AbstractConfiguration;
import org.eclipse.scada.ae.monitor.datasource.AbstractMasterItemMonitor;
import org.eclipse.scada.ae.monitor.datasource.common.ListSeverity;
import org.eclipse.scada.core.Variant;

class Configuration extends AbstractConfiguration
{
    ListSeverity defaultSeverity;

    boolean defaultAck;

    Map<Variant, ListSeverity> severityMap;

    Map<Variant, Boolean> ackMap;

    String messageAttribute;

    public Configuration ( final Configuration currentConfiguration, final AbstractMasterItemMonitor monitor )
    {
        super ( currentConfiguration, monitor );
        if ( currentConfiguration != null )
        {
            this.defaultSeverity = currentConfiguration.defaultSeverity;
            this.defaultAck = currentConfiguration.defaultAck;
            this.severityMap = currentConfiguration.severityMap;
            this.ackMap = currentConfiguration.ackMap;
            this.messageAttribute = currentConfiguration.messageAttribute;
        }
    }

    public void setMessageAttribute ( final String messageAttribute )
    {
        this.messageAttribute = messageAttribute;
    }

    public void setDefaultAck ( final boolean defaultAck )
    {
        this.defaultAck = defaultAck;
    }

    public void setDefaultSeverity ( final ListSeverity defaultSeverity )
    {
        this.defaultSeverity = defaultSeverity;
    }

    public void setAckMap ( final Map<Variant, Boolean> ackMap )
    {
        this.ackMap = ackMap;
    }

    public void setSeverityMap ( final Map<Variant, ListSeverity> severityMap )
    {
        this.severityMap = severityMap;
    }
}