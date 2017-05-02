/*******************************************************************************
 * Copyright (c) 2010, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.core.ui.connection.login;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import org.eclipse.scada.utils.lang.Immutable;

@Immutable
public class LoginContext
{
    private final String id;

    private final String name;

    private final Collection<LoginFactory> factories;

    private final Map<String, String> properties;

    public LoginContext ( final String id, final String name, final Collection<LoginFactory> connections, final Map<String, String> properties )
    {
        this.id = id;
        this.name = name;
        this.factories = new LinkedList<LoginFactory> ( connections );
        this.properties = new HashMap<String, String> ( properties );
    }

    public Map<String, String> getProperties ()
    {
        return Collections.unmodifiableMap ( this.properties );
    }

    public String getName ()
    {
        return this.name;
    }

    public Collection<LoginFactory> getFactories ()
    {
        return Collections.unmodifiableCollection ( this.factories );
    }

    public String getId ()
    {
        return this.id;
    }

}
