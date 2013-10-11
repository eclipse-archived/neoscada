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
package org.eclipse.scada.core.ui.connection.login.factory;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.scada.core.ui.connection.login.LoginHandler;
import org.eclipse.scada.core.ui.connection.login.StateListener;
import org.osgi.framework.BundleContext;

public class MultiLoginHandler implements LoginHandler
{
    private final ArrayList<LoginHandler> handler;

    private StateListener stateListener;

    public MultiLoginHandler ( final Collection<LoginHandler> handler )
    {
        this.handler = new ArrayList<LoginHandler> ( handler );
    }

    @Override
    public void setStateListener ( final StateListener stateListener )
    {
        this.stateListener = stateListener;
        for ( final LoginHandler handler : this.handler )
        {
            handler.setStateListener ( stateListener );
        }
    }

    @Override
    public void startLogin ()
    {
        if ( this.handler.isEmpty () )
        {
            // signal that we are complete at once
            final StateListener listener = this.stateListener;
            if ( listener != null )
            {
                listener.stateChanged ( null, null, null );
            }
        }
        else
        {
            for ( final LoginHandler handler : this.handler )
            {
                handler.startLogin ();
            }
        }
    }

    @Override
    public void register ( final BundleContext context )
    {
        for ( final LoginHandler handler : this.handler )
        {
            handler.register ( context );
        }
    }

    @Override
    public void dispose ()
    {
        for ( final LoginHandler handler : this.handler )
        {
            handler.dispose ();
        }
    }

    @Override
    public boolean isOk ()
    {
        for ( final LoginHandler handler : this.handler )
        {
            if ( !handler.isOk () )
            {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean isComplete ()
    {
        for ( final LoginHandler handler : this.handler )
        {
            if ( !handler.isComplete () )
            {
                return false;
            }
        }
        return true;
    }

    @Override
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
