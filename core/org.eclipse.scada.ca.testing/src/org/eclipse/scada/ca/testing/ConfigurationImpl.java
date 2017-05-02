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
package org.eclipse.scada.ca.testing;

import java.util.Map;

import org.eclipse.scada.ca.Configuration;
import org.eclipse.scada.ca.data.ConfigurationState;

public class ConfigurationImpl implements Configuration
{
    private final String id;

    private final String factoryId;

    private Map<String, String> data;

    public ConfigurationImpl ( final String id, final String factoryId, final Map<String, String> data )
    {
        this.id = id;
        this.factoryId = factoryId;
        this.data = data;
    }

    @Override
    public Map<String, String> getData ()
    {
        return this.data;
    }

    @Override
    public Throwable getErrorInformation ()
    {
        return null;
    }

    @Override
    public String getFactoryId ()
    {
        return this.factoryId;
    }

    @Override
    public String getId ()
    {
        return this.id;
    }

    @Override
    public ConfigurationState getState ()
    {
        return ConfigurationState.APPLIED;
    }

    public void setData ( final Map<String, String> properties )
    {
        this.data = properties;
    }
}
