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
package org.eclipse.scada.sec.equinox;

import java.util.Map;

import javax.security.auth.Subject;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.login.LoginException;

import org.eclipse.scada.sec.AuthenticationImplementation;
import org.eclipse.scada.sec.UserInformation;
import org.eclipse.scada.sec.UserInformationPrincipal;

public class LoginModule implements javax.security.auth.spi.LoginModule
{
    private CallbackHandler callbackHandler;

    private boolean loggedIn;

    private Subject subject;

    private UserInformation userInformation;

    public LoginModule ()
    {
    }

    @SuppressWarnings ( "rawtypes" )
    @Override
    public void initialize ( final Subject subject, final CallbackHandler callbackHandler, final Map sharedState, final Map options )
    {
        this.subject = subject;
        this.callbackHandler = callbackHandler;
    }

    @Override
    public boolean login () throws LoginException
    {
        this.userInformation = null;

        final AuthenticationImplementation auth = Activator.getInstance ().getAuthentication ();

        try
        {
            this.userInformation = auth.authenticate ( new JavaCallbackHandler ( this.callbackHandler ) ).get ();
        }
        catch ( final Exception e )
        {
            final LoginException loginException = new LoginException ();
            loginException.initCause ( e );
            throw loginException;
        }

        this.loggedIn = this.userInformation != null;

        return this.loggedIn;
    }

    @Override
    public boolean commit () throws LoginException
    {
        this.subject.getPrincipals ().add ( new UserInformationPrincipal ( this.userInformation ) );
        this.subject.getPublicCredentials ().add ( this.userInformation );
        return this.loggedIn;
    }

    @Override
    public boolean abort () throws LoginException
    {
        this.loggedIn = false;
        return true;
    }

    @Override
    public boolean logout () throws LoginException
    {
        this.loggedIn = false;
        return true;
    }

}
