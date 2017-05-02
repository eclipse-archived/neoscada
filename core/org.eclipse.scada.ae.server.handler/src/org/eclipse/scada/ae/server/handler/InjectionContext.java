/*******************************************************************************
 * Copyright (c) 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.ae.server.handler;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class InjectionContext
{
    private final Map<String, String> properties;

    private InjectionContext ( final Map<String, String> properties, final boolean copy )
    {
        if ( copy )
        {
            this.properties = Collections.unmodifiableMap ( new HashMap<> ( properties ) );
        }
        else
        {
            this.properties = Collections.unmodifiableMap ( properties );
        }
    }

    public InjectionContext ( final Map<String, String> properties )
    {
        this ( properties, true );
    }

    public Map<String, String> getProperties ()
    {
        return this.properties;
    }

    public static class Builder
    {
        private Map<String, String> properties = new HashMap<> ();

        public Builder put ( final String key, final String value )
        {
            this.properties.put ( key, value );
            return this;
        }

        public Builder sourceModule ( final String value )
        {
            return put ( "sourceModule", value );
        }

        public InjectionContext build ()
        {
            final InjectionContext ctx = new InjectionContext ( this.properties, false );
            this.properties = new HashMap<> ();
            return ctx;
        }
    }
}
