/*******************************************************************************
 * Copyright (c) 2012, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *******************************************************************************/
package org.eclipse.scada.core.server.common.session;

import java.util.Set;

import org.eclipse.scada.core.server.common.osgi.SessionPrivilegeTracker.PrivilegeListener;

public class PrivilegeListenerImpl implements PrivilegeListener
{

    private final AbstractSessionImpl session;

    public PrivilegeListenerImpl ( final AbstractSessionImpl session )
    {
        this.session = session;
    }

    @Override
    public void privilegesChanged ( final Set<String> granted )
    {
        this.session.setPrivileges ( granted );
    }

}
