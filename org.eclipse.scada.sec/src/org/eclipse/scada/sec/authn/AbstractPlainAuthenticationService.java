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
package org.eclipse.scada.sec.authn;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.scada.sec.AuthenticationException;
import org.eclipse.scada.sec.AuthenticationService;
import org.eclipse.scada.sec.StatusCodes;
import org.eclipse.scada.sec.UserInformation;
import org.eclipse.scada.sec.utils.password.PasswordType;
import org.eclipse.scada.utils.lang.Immutable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractPlainAuthenticationService implements AuthenticationService
{

    private final static Logger logger = LoggerFactory.getLogger ( AbstractPlainAuthenticationService.class );

    @Immutable
    public static class UserEntry implements Serializable
    {
        private static final long serialVersionUID = -6899786759766310861L;

        private final String password;

        private final Set<String> roles;

        public UserEntry ( final String password, final Collection<String> roles )
        {
            this.password = password;
            this.roles = new HashSet<String> ( roles );
        }

        public String getPassword ()
        {
            return this.password;
        }

        public Set<String> getRoles ()
        {
            return Collections.unmodifiableSet ( this.roles );
        }

        @Override
        public int hashCode ()
        {
            final int prime = 31;
            int result = 1;
            result = prime * result + ( this.password == null ? 0 : this.password.hashCode () );
            result = prime * result + ( this.roles == null ? 0 : this.roles.hashCode () );
            return result;
        }

        @Override
        public boolean equals ( final Object obj )
        {
            if ( this == obj )
            {
                return true;
            }
            if ( obj == null )
            {
                return false;
            }
            if ( getClass () != obj.getClass () )
            {
                return false;
            }
            final UserEntry other = (UserEntry)obj;
            if ( this.password == null )
            {
                if ( other.password != null )
                {
                    return false;
                }
            }
            else if ( !this.password.equals ( other.password ) )
            {
                return false;
            }
            if ( this.roles == null )
            {
                if ( other.roles != null )
                {
                    return false;
                }
            }
            else if ( !this.roles.equals ( other.roles ) )
            {
                return false;
            }
            return true;
        }

        @Override
        public String toString ()
        {
            final StringBuilder sb = new StringBuilder ();
            sb.append ( "UserEntry [password=" );
            sb.append ( this.password == null ? "null" : "***" );
            sb.append ( ", roles=" );
            for ( final String role : this.roles )
            {
                sb.append ( "," );
                sb.append ( role );
            }
            sb.append ( "]" );
            return sb.toString ();
        }
    }

    protected abstract UserEntry getUserEntry ( final String name ) throws Exception;

    @Override
    public UserInformation getUser ( final String user )
    {
        try
        {
            final UserEntry entry = getUserEntry ( user );
            if ( entry == null )
            {
                return null;
            }
            return makeInfo ( user, entry );
        }
        catch ( final Exception e )
        {
            logger.debug ( "Failed to look up user - " + user, e );
            return null;
        }
    }

    @Override
    public UserInformation authenticate ( final CredentialsRequest credentialsRequest ) throws AuthenticationException
    {
        final String username = credentialsRequest.getUserName ();

        logger.debug ( "Authenticating user: '{}'", username );

        final UserEntry user;
        try
        {
            user = getUserEntry ( username );
        }
        catch ( final Exception e )
        {
            throw new AuthenticationException ( StatusCodes.UNKNOWN_STATUS_CODE, "Failed to retrieve user data for user " + username, e );
        }

        if ( user == null )
        {
            // user is unknown
            return null;
        }

        if ( user.getPassword () == null )
        {
            // user has no password assigned
            return null;
        }

        try
        {
            if ( PasswordType.PLAIN.createValdiator ().validatePassword ( credentialsRequest.getPasswords (), user.getPassword () ) )
            {
                // user was found and passwords did match
                return makeInfo ( username, user );
            }
        }
        catch ( final Exception e )
        {
            logger.warn ( "Failed to authenticate", e );
            throw new AuthenticationException ( StatusCodes.AUTHENTICATION_FAILED, e );
        }
        // passwords don't match
        return null;
    }

    @Override
    public void joinRequest ( final CredentialsRequest request )
    {
        request.askUsername ();
        request.askPassword ( PasswordType.PLAIN.getSupportedInputEncodings () );
    }

    protected UserInformation makeInfo ( final String name, final UserEntry user )
    {
        return new UserInformation ( name, user.getRoles () );
    }

}