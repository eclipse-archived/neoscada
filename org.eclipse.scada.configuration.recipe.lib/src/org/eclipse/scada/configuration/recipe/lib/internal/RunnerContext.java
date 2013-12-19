/*******************************************************************************
 * Copyright (c) 2013 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.configuration.recipe.lib.internal;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.scada.configuration.recipe.lib.ExecutableContext;

public class RunnerContext implements ExecutableContext
{
    private final Map<String, Object> map;

    private final Map<Class<?>, Object> singletons;

    private final Map<String, String> properties;

    public RunnerContext ( final Map<String, String> properties )
    {
        this.map = new HashMap<> ();
        this.singletons = new HashMap<> ();
        this.properties = Collections.unmodifiableMap ( properties );
    }

    public Map<String, String> getProperties ()
    {
        return this.properties;
    }

    public Map<String, Object> getMap ()
    {
        return this.map;
    }

    @Override
    public Object getValue ( final String name )
    {
        return this.map.get ( name );
    }

    public Map<Class<?>, Object> getSingletons ()
    {
        return this.singletons;
    }
}
