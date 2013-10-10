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
package org.eclipse.scada.ca;

import org.eclipse.scada.ca.data.ConfigurationState;

public class ConfigurationEvent
{
    public static enum Type
    {
        CREATED,
        MODIFIED,
        REMOVED,
        STATE
    }

    private final Configuration configuration;

    private final Type type;

    private final ConfigurationState state;

    private final Throwable error;

    public ConfigurationEvent ( final Type type, final Configuration configuration, final ConfigurationState state, final Throwable error )
    {
        this.type = type;
        this.configuration = configuration;
        this.state = state;
        this.error = error;
    }

    public ConfigurationState getState ()
    {
        return this.state;
    }

    public Throwable getError ()
    {
        return this.error;
    }

    public Configuration getConfiguration ()
    {
        return this.configuration;
    }

    public Type getType ()
    {
        return this.type;
    }

    @Override
    public String toString ()
    {
        switch ( this.type )
        {
            case STATE:
                return String.format ( "%s -> %s / %s", this.configuration.getId (), this.type, this.state );
            default:
                return String.format ( "%s -> %s / %s", this.configuration.getId (), this.type, this.configuration );
        }

    }
}
