/*******************************************************************************
 * Copyright (c) 2010, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - implement security callback system
 *******************************************************************************/
package org.eclipse.scada.ca.data;

public class FactoryInformation implements java.io.Serializable
{
    private static final long serialVersionUID = 1L;

    public FactoryInformation ( final String id, final String description, final org.eclipse.scada.ca.data.FactoryState state, final java.util.List<org.eclipse.scada.ca.data.ConfigurationInformation> configurations )
    {
        this.id = id;
        this.description = description;
        this.state = state;
        this.configurations = configurations;
    }

    private final String id;

    public String getId ()
    {
        return this.id;
    }

    private final String description;

    public String getDescription ()
    {
        return this.description;
    }

    private final org.eclipse.scada.ca.data.FactoryState state;

    public org.eclipse.scada.ca.data.FactoryState getState ()
    {
        return this.state;
    }

    private final java.util.List<org.eclipse.scada.ca.data.ConfigurationInformation> configurations;

    public java.util.List<org.eclipse.scada.ca.data.ConfigurationInformation> getConfigurations ()
    {
        return this.configurations;
    }

    @Override
    public boolean equals ( final Object obj )
    {
        if ( this == obj )
        {
            return true;
        }
        if ( obj == null )
        {
            return false;
        }

        if ( ! ( obj instanceof FactoryInformation ) )
        {
            return false;
        }
        final FactoryInformation other = (FactoryInformation)obj;

        if ( this.id == null )
        {
            if ( other.id != null )
            {
                return false;
            }
        }
        else if ( !this.id.equals ( other.id ) )
        {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode ()
    {
        final int prime = 31;
        int result = 1;

        result = prime * result + ( this.id == null ? 0 : this.id.hashCode () );

        return result;
    }

    @Override
    public String toString ()
    {
        return "[FactoryInformation - " + "id: " + this.id + ", " + "description: " + this.description + ", " + "state: " + this.state + ", " + "configurations: " + this.configurations + "]";
    }
}
