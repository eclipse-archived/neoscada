/*******************************************************************************
 * Copyright (c) 2012, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jürgen Rose - additional work
 *******************************************************************************/
package org.eclipse.scada.vi.details.swt.impl.visibility;

import java.util.Arrays;
import java.util.List;

import org.eclipse.scada.core.ui.connection.login.LoginSession;
import org.eclipse.scada.core.ui.connection.login.SessionListener;
import org.eclipse.scada.core.ui.connection.login.SessionManager;

public class PermissionVisibilityProviderImpl extends AbstractVisibilityProvider implements SessionListener
{

    private final List<String> permissions;

    public PermissionVisibilityProviderImpl ( final String permissions )
    {
        this.permissions = Arrays.asList ( permissions.split ( "[,|]" ) );
        SessionManager.getDefault ().addListener ( this );
    }

    protected boolean evalPermission ()
    {
        boolean result = false;
        for ( String permission : this.permissions )
        {
            if ( permission.startsWith ( "!" ) )
            {
                result |= !SessionManager.getDefault ().hasRole ( permission.substring ( 1 ) );
            }
            else
            {
                result |= SessionManager.getDefault ().hasRole ( permission );
            }
        }
        return result;
    }

    @Override
    public void dispose ()
    {
        SessionManager.getDefault ().removeListener ( this );
    }

    @Override
    public void sessionChanged ( final LoginSession session )
    {
        fireChange ( evalPermission () );
    }

}
