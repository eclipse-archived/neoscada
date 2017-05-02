/*******************************************************************************
 * Copyright (c) 2012, 2015 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     IBH SYSTEMS GmbH - new adapter signature
 *******************************************************************************/
package org.eclipse.scada.ca.ui.data;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.scada.ca.data.ConfigurationInformation;

public class ConfigurationDescriptor implements IAdaptable
{
    private String connectionUri;

    private ConfigurationInformation configurationInformation;

    public void setConfigurationInformation ( final ConfigurationInformation configurationInformation )
    {
        this.configurationInformation = configurationInformation;
    }

    public void setConnectionUri ( final String connectionUri )
    {
        this.connectionUri = connectionUri;
    }

    public ConfigurationInformation getConfigurationInformation ()
    {
        return this.configurationInformation;
    }

    public String getConnectionUri ()
    {
        return this.connectionUri;
    }

    @Override
    public <T> T getAdapter ( final Class<T> adapter )
    {
        if ( adapter == ConfigurationEditorSourceInformation.class )
        {
            return adapter.cast ( new ConfigurationEditorSourceInformation ( this.connectionUri, this.configurationInformation.getFactoryId (), this.configurationInformation.getId () ) );
        }
        return null;
    }
}
