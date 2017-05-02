/*******************************************************************************
 * Copyright (c) 2010, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - further development
 *******************************************************************************/
package org.eclipse.scada.sec;

import org.eclipse.scada.sec.authn.CredentialsRequest;

/**
 * An interface for a service that authenticates a user.
 * <p>
 * The service needs to ensure that the information provided identifies a valid
 * user.
 * </p>
 * 
 * @author Jens Reimann
 * @since 0.15.0
 */
public interface AuthenticationService
{
    /**
     * Authenticate a user based on credentials
     * 
     * @return a valid user information instance if the user is a known user and
     *         is allowed to log on using the provided credentials. Or
     *         <code>null</code> if it is a valid anonymous login.
     * @throws AuthenticationException
     *             in the case the login is invalid (e.g. username and
     *             password don't match)
     */
    public UserInformation authenticate ( CredentialsRequest request ) throws AuthenticationException;

    /**
     * @since 1.1
     */
    public void joinRequest ( CredentialsRequest request );

    /**
     * The the user information of the named user
     * 
     * @since 1.1
     * @param user
     *            the user to get the information for
     * @return the user information or <code>null</code> if the user is unknown
     */
    public UserInformation getUser ( String user );
}
