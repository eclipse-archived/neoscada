/*******************************************************************************
 * Copyright (c) 2010, 2015 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     IBH SYSTEMS GmbH - new adapter signature
 *******************************************************************************/
package org.eclipse.scada.ca.ui.connection.data;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.scada.ca.connection.provider.ConnectionService;
import org.eclipse.scada.ca.data.ConfigurationInformation;
import org.eclipse.scada.ca.ui.data.ConfigurationEditorSourceInformation;

public class ConfigurationInformationBean implements IAdaptable
{

    private final ConfigurationInformation configurationInformation;

    private final ConnectionService service;

    public ConfigurationInformationBean ( final ConnectionService service, final ConfigurationInformation configurationInformation )
    {
        this.service = service;
        this.configurationInformation = configurationInformation;
    }

    public ConnectionService getService ()
    {
        return this.service;
    }

    public ConfigurationInformation getConfigurationInformation ()
    {
        return this.configurationInformation;
    }

    @Override
    public <T> T getAdapter ( final Class<T> adapter )
    {
        if ( adapter == ConfigurationEditorSourceInformation.class )
        {
            return adapter.cast ( new ConfigurationEditorSourceInformation ( this.service.getConnection ().getConnectionInformation ().toString (), this.configurationInformation.getFactoryId (), this.configurationInformation.getId () ) );
        }
        return null;
    }

}
