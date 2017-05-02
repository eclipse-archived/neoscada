/*******************************************************************************
 * Copyright (c) 2006, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - further development
 *******************************************************************************/
package org.eclipse.scada.sec.provider.dummy;

import org.eclipse.scada.sec.AuthenticationService;
import org.eclipse.scada.sec.UserInformation;
import org.eclipse.scada.sec.authn.CredentialsRequest;

/**
 * A dummy provider which returns an anonymous
 * user information (<code>null</code>) if the username
 * is not set and an authenticated user with no roles
 * if the username is set
 * 
 * @author Jens Reimann
 */
public class DummyAuthenticationProviderImpl implements AuthenticationService
{

    @Override
    public UserInformation authenticate ( final CredentialsRequest request )
    {
        return new UserInformation ( request.getUserName () );
    }

    @Override
    public void joinRequest ( final CredentialsRequest request )
    {
        request.askUsername ();
    }

    @Override
    public UserInformation getUser ( final String user )
    {
        return new UserInformation ( user );
    }

}
