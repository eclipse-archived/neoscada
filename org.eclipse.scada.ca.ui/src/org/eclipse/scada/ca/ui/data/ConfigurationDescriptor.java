/*******************************************************************************
 * Copyright (c) 2012, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
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

    @SuppressWarnings ( "rawtypes" )
    @Override
    public Object getAdapter ( final Class adapter )
    {
        if ( adapter == ConfigurationEditorSourceInformation.class )
        {
            return new ConfigurationEditorSourceInformation ( this.connectionUri, this.configurationInformation.getFactoryId (), this.configurationInformation.getId () );
        }
        return null;
    }
}
