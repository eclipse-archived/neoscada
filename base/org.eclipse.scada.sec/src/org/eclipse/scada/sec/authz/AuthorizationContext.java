/*******************************************************************************
 * Copyright (c) 2013 Jens Reimann and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Jens Reimann - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.sec.authz;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.scada.sec.AuthorizationRequest;
import org.eclipse.scada.sec.UserInformation;
import org.eclipse.scada.sec.callback.CallbackHandler;

/**
 * @since 1.1
 */
public class AuthorizationContext
{
    private AuthorizationRequest request;

    private final Map<String, Object> context = new HashMap<String, Object> ();

    private CallbackHandler callbackHandler;

    public void setCallbackHandler ( final CallbackHandler callbackHandler )
    {
        this.callbackHandler = callbackHandler;
    }

    public CallbackHandler getCallbackHandler ()
    {
        return this.callbackHandler;
    }

    public Map<String, Object> getContext ()
    {
        return this.context;
    }

    public void setRequest ( final AuthorizationRequest request )
    {
        this.request = request;
    }

    public AuthorizationRequest getRequest ()
    {
        return this.request;
    }

    /**
     * Change the user information to the provided user information
     * 
     * @param userInformation
     *            the new user information
     */
    public void changeUserInformation ( final UserInformation userInformation )
    {
        this.request = AuthorizationRequest.changeUser ( this.request, userInformation );
    }

    @Override
    public String toString ()
    {
        return String.format ( "[AuthorizationContext - request: %s, context: %s, callbackHandler: %s]", this.request, this.context, this.callbackHandler );
    }
}
