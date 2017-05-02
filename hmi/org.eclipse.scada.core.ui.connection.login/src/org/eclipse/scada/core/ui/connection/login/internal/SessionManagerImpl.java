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
package org.eclipse.scada.core.ui.connection.login.internal;

import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.services.ISourceProviderService;
import org.eclipse.scada.core.ui.connection.login.LoginSession;
import org.eclipse.scada.core.ui.connection.login.LoginSessionProvider;
import org.eclipse.scada.core.ui.connection.login.SessionManager;

public class SessionManagerImpl extends SessionManager
{
    public SessionManagerImpl ( final Realm realm )
    {
        super ( realm );
    }

    @Override
    public void setSession ( final LoginSession session )
    {
        checkRealm ();

        if ( this.session != null )
        {
            this.session.dispose ();
        }

        this.session = session;

        if ( this.session != null )
        {
            this.session.register ();
        }

        for ( final IWorkbenchWindow window : PlatformUI.getWorkbench ().getWorkbenchWindows () )
        {
            final ISourceProviderService service = (ISourceProviderService)window.getService ( ISourceProviderService.class );
            final LoginSessionProvider sessionSourceProvider = (LoginSessionProvider)service.getSourceProvider ( LoginSessionProvider.SESSION_STATE );
            sessionSourceProvider.setLoginSession ( session );
        }

        super.setSession ( session );
    }

    @Override
    public void dispose ()
    {
        super.dispose ();
    }
}
