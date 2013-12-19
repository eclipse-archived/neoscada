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
package org.eclipse.scada.configuration.recipe.lib;

import java.util.Collections;
import java.util.Map;

public interface ExecutableContext
{
    /**
     * An empty context that can be used when components need a context but
     * don't get one provided.
     */
    public static ExecutableContext EMPTY = new ExecutableContext () {

        @Override
        public Object getValue ( final String name )
        {
            return null;
        }

        @Override
        public Map<String, String> getProperties ()
        {
            return Collections.emptyMap ();
        }
    };

    /**
     * Get an object from the current context
     * 
     * @param name
     *            the name of the object
     * @return the object, or <code>null</code> if the object could not be found
     */
    public Object getValue ( String name );

    /**
     * Get the static properties
     * 
     * @return An unmodifiable map of the definition properties
     */
    public Map<String, String> getProperties ();
}
