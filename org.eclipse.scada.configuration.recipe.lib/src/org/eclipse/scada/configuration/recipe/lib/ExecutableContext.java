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

import java.util.Map;

public interface ExecutableContext
{
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
