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

public class ConfigurationInformation implements java.io.Serializable
{
    private static final long serialVersionUID = 1L;

    public ConfigurationInformation ( final String factoryId, final String id, final org.eclipse.scada.ca.data.ConfigurationState state, final java.util.Map<String, String> data, final String errorInformation )
    {
        this.factoryId = factoryId;
        this.id = id;
        this.state = state;
        this.data = data;
        this.errorInformation = errorInformation;
    }

    private final String factoryId;

    public String getFactoryId ()
    {
        return this.factoryId;
    }

    private final String id;

    public String getId ()
    {
        return this.id;
    }

    private final org.eclipse.scada.ca.data.ConfigurationState state;

    public org.eclipse.scada.ca.data.ConfigurationState getState ()
    {
        return this.state;
    }

    private final java.util.Map<String, String> data;

    public java.util.Map<String, String> getData ()
    {
        return this.data;
    }

    private final String errorInformation;

    public String getErrorInformation ()
    {
        return this.errorInformation;
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

        if ( ! ( obj instanceof ConfigurationInformation ) )
        {
            return false;
        }
        final ConfigurationInformation other = (ConfigurationInformation)obj;

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
        return "[ConfigurationInformation - " + "factoryId: " + this.factoryId + ", " + "id: " + this.id + ", " + "state: " + this.state + ", " + "data: " + this.data + ", " + "errorInformation: " + this.errorInformation + "]";
    }
}
