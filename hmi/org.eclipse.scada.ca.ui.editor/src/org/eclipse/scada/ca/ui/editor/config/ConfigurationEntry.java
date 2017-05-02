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
package org.eclipse.scada.ca.ui.editor.config;

import org.eclipse.scada.utils.beans.AbstractPropertyChange;

public class ConfigurationEntry extends AbstractPropertyChange
{
    public static final String PROP_KEY = "key";

    public static final String PROP_VALUE = "value";

    private String key;

    private String value;

    public String getKey ()
    {
        return this.key;
    }

    public void setKey ( final String key )
    {
        final String oldKey = this.key;
        this.key = key;

        firePropertyChange ( PROP_KEY, oldKey, key );
    }

    public String getValue ()
    {
        return this.value;
    }

    public void setValue ( final String value )
    {
        final String oldValue = this.value;
        this.value = value;

        firePropertyChange ( PROP_VALUE, oldValue, value );
    }

    @Override
    public int hashCode ()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ( this.key == null ? 0 : this.key.hashCode () );
        result = prime * result + ( this.value == null ? 0 : this.value.hashCode () );
        return result;
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
        if ( ! ( obj instanceof ConfigurationEntry ) )
        {
            return false;
        }
        final ConfigurationEntry other = (ConfigurationEntry)obj;
        if ( this.key == null )
        {
            if ( other.key != null )
            {
                return false;
            }
        }
        else if ( !this.key.equals ( other.key ) )
        {
            return false;
        }
        if ( this.value == null )
        {
            if ( other.value != null )
            {
                return false;
            }
        }
        else if ( !this.value.equals ( other.value ) )
        {
            return false;
        }
        return true;
    }
}
