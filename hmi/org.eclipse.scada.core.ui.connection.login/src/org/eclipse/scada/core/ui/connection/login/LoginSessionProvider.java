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

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.expressions.IEvaluationContext;
import org.eclipse.ui.AbstractSourceProvider;
import org.eclipse.ui.ISources;

public class LoginSessionProvider extends AbstractSourceProvider
{

    public static final String SESSION_STATE = "org.eclipse.scada.core.ui.connection.login.sessionState"; //$NON-NLS-1$

    public static final String SESSION = "org.eclipse.scada.core.ui.connection.login.session"; //$NON-NLS-1$

    private LoginSession session;

    public LoginSessionProvider ()
    {
    }

    @Override
    public void dispose ()
    {
    }

    @Override
    @SuppressWarnings ( { "rawtypes" } )
    public Map getCurrentState ()
    {
        final Map<String, Object> result = new HashMap<String, Object> ( 2 );
        result.put ( SESSION_STATE, getSessionState () );
        result.put ( SESSION, this.session != null ? this.session : IEvaluationContext.UNDEFINED_VARIABLE );
        return result;
    }

    private String getSessionState ()
    {
        return this.session != null ? "loggedIn" : "loggedOut"; //$NON-NLS-1$ //$NON-NLS-2$
    }

    public void setLoginSession ( final LoginSession session )
    {
        this.session = session;
        fireSourceChanged ( ISources.WORKBENCH, getCurrentState () );
    }

    @Override
    public String[] getProvidedSourceNames ()
    {
        return new String[] { SESSION_STATE, SESSION };
    }

}
