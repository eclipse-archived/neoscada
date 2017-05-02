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

public class ConfigurationEditorSourceInformation
{
    private final String connectionId;

    private final String factoryId;

    private final String configurationId;

    public ConfigurationEditorSourceInformation ( final String connectionId, final String factoryId, final String configurationId )
    {
        super ();
        this.connectionId = connectionId;
        this.factoryId = factoryId;
        this.configurationId = configurationId;
    }

    public String getConnectionId ()
    {
        return this.connectionId;
    }

    public String getFactoryId ()
    {
        return this.factoryId;
    }

    public String getConfigurationId ()
    {
        return this.configurationId;
    }

}
