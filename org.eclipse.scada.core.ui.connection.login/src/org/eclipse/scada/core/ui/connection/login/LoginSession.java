/*******************************************************************************
 * Copyright (c) 2010, 2012 TH4 SYSTEMS GmbH and others.
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

import org.osgi.framework.BundleContext;

public class LoginSession
{
    private final String username;

    private final String password;

    private final BundleContext context;

    private final LoginContext loginContext;

    private final Collection<LoginHandler> handler;

    public LoginSession ( final BundleContext context, final String username, final String password, final LoginContext loginContext, final Collection<LoginHandler> handler )
    {
        this.context = context;
        this.username = username;
        this.password = password;
        this.loginContext = loginContext;
        this.handler = handler;
    }

    public String getPassword ()
    {
        return this.password;
    }

    public String getUsername ()
    {
        return this.username;
    }

    public LoginContext getLoginContext ()
    {
        return this.loginContext;
    }

    public void register ()
    {
        for ( final LoginHandler handler : this.handler )
        {
            handler.register ( this.context );
        }
    }

    public void dispose ()
    {
        for ( final LoginHandler handler : this.handler )
        {
            handler.dispose ();
        }
    }

    /**
     * Checks with all login handler if the session has a role granted
     * <p>
     * If no handler grants the role, the default <code>false</code> is returned.
     * </p>
     * 
     * @param role
     *            the role to check
     * @return <code>true</code> if the role was granted, <code>false</code> otherwise
     */
    public boolean hasRole ( final String role )
    {
        for ( final LoginHandler handler : this.handler )
        {
            if ( handler.hasRole ( role ) )
            {
                return true;
            }
        }
        return false;
    }
}
