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
package org.eclipse.scada.ae.monitor.datasource.common.bit;

import org.eclipse.scada.ae.data.Severity;
import org.eclipse.scada.ae.monitor.common.AbstractConfiguration;
import org.eclipse.scada.ae.monitor.datasource.AbstractMasterItemMonitor;
import org.eclipse.scada.sec.UserInformation;

class Configuration extends AbstractConfiguration
{
    Boolean reference;

    Severity severity = Severity.ALARM;

    boolean requireAck;

    public Configuration ( final Configuration currentConfiguration, final AbstractMasterItemMonitor monitor )
    {
        super ( currentConfiguration, monitor );
        if ( currentConfiguration != null )
        {
            this.reference = currentConfiguration.reference;
            this.severity = currentConfiguration.severity;
            this.requireAck = currentConfiguration.requireAck;
        }
    }

    public void setRequireAck ( final UserInformation userInformation, final boolean requireAck )
    {
        this.requireAck = update ( userInformation, this.requireAck, requireAck );
    }

    public void setReference ( final UserInformation userInformation, final Boolean reference )
    {
        this.reference = update ( userInformation, this.reference, reference );
    }

    public void setSeverity ( final UserInformation userInformation, final Severity severity )
    {
        this.severity = update ( userInformation, this.severity, severity );
    }
}