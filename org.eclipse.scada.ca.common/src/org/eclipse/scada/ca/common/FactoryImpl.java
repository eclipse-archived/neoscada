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
package org.eclipse.scada.ca.common;

import java.util.Map;
import java.util.TreeMap;

import org.eclipse.scada.ca.ConfigurationFactory;
import org.eclipse.scada.ca.ConfigurationListener;
import org.eclipse.scada.ca.Factory;
import org.eclipse.scada.ca.SelfManagedConfigurationFactory;
import org.eclipse.scada.ca.data.FactoryState;

public class FactoryImpl implements Factory
{

    private final String id;

    private String description;

    private FactoryState state;

    private final Map<String, ConfigurationImpl> configurations = new TreeMap<String, ConfigurationImpl> ();

    private Object service;

    private ConfigurationListener listener;

    public FactoryImpl ( final String id )
    {
        this.id = id;
    }

    public void setDescription ( final String description )
    {
        this.description = description;
    }

    @Override
    public String getDescription ()
    {
        return this.description;
    }

    @Override
    public String getId ()
    {
        return this.id;
    }

    public void setState ( final FactoryState state )
    {
        this.state = state;
    }

    @Override
    public FactoryState getState ()
    {
        return this.state;
    }

    public ConfigurationImpl getConfiguration ( final String configurationId )
    {
        return this.configurations.get ( configurationId );
    }

    public ConfigurationImpl[] getConfigurations ()
    {
        return this.configurations.values ().toArray ( new ConfigurationImpl[0] );
    }

    public void setConfigurations ( final ConfigurationImpl[] configurations )
    {
        this.configurations.clear ();
        for ( final ConfigurationImpl configuration : configurations )
        {
            this.configurations.put ( configuration.getId (), configuration );
        }
    }

    public void setService ( final Object service )
    {
        this.service = service;
    }

    public Object getService ()
    {
        return this.service;
    }

    public ConfigurationFactory getConfigurationFactoryService ()
    {
        final Object service = this.service;
        if ( service instanceof ConfigurationFactory )
        {
            return (ConfigurationFactory)service;
        }
        else
        {
            return null;
        }
    }

    public void addConfiguration ( final ConfigurationImpl configuration )
    {
        this.configurations.put ( configuration.getId (), configuration );
    }

    public void removeConfigration ( final String configurationId )
    {
        this.configurations.remove ( configurationId );
    }

    public void setListener ( final ConfigurationListener listener )
    {
        this.listener = listener;
    }

    public ConfigurationListener getListener ()
    {
        return this.listener;
    }

    public SelfManagedConfigurationFactory getSelfService ()
    {
        final Object service = this.service;
        if ( service instanceof SelfManagedConfigurationFactory )
        {
            return (SelfManagedConfigurationFactory)service;
        }
        else
        {
            return null;
        }
    }

    public boolean isSelfManaged ()
    {
        return this.service instanceof SelfManagedConfigurationFactory;
    }
}
