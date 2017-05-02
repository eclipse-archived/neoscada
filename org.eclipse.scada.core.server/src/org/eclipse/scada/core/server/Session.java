/*******************************************************************************
 * Copyright (c) 2010, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *******************************************************************************/
package org.eclipse.scada.core.server;

import java.util.Map;
import java.util.Set;

public interface Session
{
    /**
     * Get the session properties
     * <p>
     * This method must actually return a copy of the session properties or an
     * unmodifiable instance.
     * </p>
     * 
     * @return the session properties
     */
    public Map<String, String> getProperties ();

    public Set<String> getPrivileges ();

    public interface SessionListener
    {
        public void privilegeChange ();
    }

    public void addSessionListener ( SessionListener listener );

    public void removeSessionListener ( SessionListener listener );
}
