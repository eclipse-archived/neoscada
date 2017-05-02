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

import java.util.HashMap;
import java.util.Map;

import org.eclipse.scada.ca.Configuration;
import org.eclipse.scada.ca.data.ConfigurationState;

public class ConfigurationImpl implements Configuration
{
    private final String id;

    private Map<String, String> data;

    private final String factoryId;

    private ConfigurationState state;

    private Throwable error;

    public ConfigurationImpl ( final String id, final String factoryId, final Map<String, String> data )
    {
        this.id = id;
        this.factoryId = factoryId;
        this.data = new HashMap<String, String> ( data );
    }

    @Override
    public String getFactoryId ()
    {
        return this.factoryId;
    }

    @Override
    public Map<String, String> getData ()
    {
        return this.data;
    }

    @Override
    public Throwable getErrorInformation ()
    {
        return this.error;
    }

    @Override
    public String getId ()
    {
        return this.id;
    }

    @Override
    public ConfigurationState getState ()
    {
        return this.state;
    }

    public void setData ( final Map<String, String> data )
    {
        this.data = data;
    }

    public void setState ( final ConfigurationState state, final Throwable e )
    {
        this.state = state;
        this.error = e;
    }

    @Override
    public String toString ()
    {
        final StringBuilder sb = new StringBuilder ();

        sb.append ( "[" ).append ( this.factoryId ).append ( "/" ).append ( this.id ).append ( "]=" );
        sb.append ( this.data );

        return sb.toString ();
    }
}
