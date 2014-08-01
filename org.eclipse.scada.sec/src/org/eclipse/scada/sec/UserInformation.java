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

import java.io.Serializable;
import java.security.Principal;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.scada.utils.lang.Immutable;
import org.eclipse.scada.utils.str.StringHelper;

/**
 * A user information object
 *
 * @author Jens Reimann
 */
@Immutable
public class UserInformation implements Serializable
{
    private static final long serialVersionUID = 1L;

    public final static UserInformation ANONYMOUS = new UserInformation ( null, Collections.<String> emptySet () );

    /**
     * The name of the user or <code>null</code> if it is an anonymous user
     * information.
     */
    private final String name;

    private final Set<String> roles;

    public UserInformation ( final String name )
    {
        this.name = name;
        this.roles = Collections.emptySet ();
    }

    public UserInformation ( final String name, final Collection<String> roles )
    {
        this.name = name;
        if ( roles != null )
        {
            this.roles = Collections.unmodifiableSet ( new HashSet<String> ( roles ) );
        }
        else
        {
            this.roles = Collections.emptySet ();
        }
    }

    public UserInformation ( final String name, final String[] roles )
    {
        this ( name, Arrays.asList ( roles ) );
    }

    /**
     * Create a user information object
     *
     * @param principal
     * @return Returns the converted user information object or
     *         {@link #ANONYMOUS} if principal was <code>null</code>. Never
     *         returns <code>null</code>.
     */
    public static UserInformation fromPrincipal ( final Principal principal )
    {
        if ( principal == null )
        {
            return ANONYMOUS;
        }
        return new UserInformation ( principal.getName () );
    }

    public boolean isAnonymous ()
    {
        return this.name == null;
    }

    /**
     * Get the name of the user
     *
     * @return the name of the user or <code>null</code> if it an anonymous user
     *         information
     */
    public String getName ()
    {
        return this.name;
    }

    public Set<String> getRoles ()
    {
        // is unmodifiable
        return this.roles;
    }

    public boolean hasRole ( final String role )
    {
        return this.roles.contains ( role );
    }

    public boolean hasAllRoles ( final String[] roles )
    {
        return this.roles.containsAll ( Arrays.asList ( roles ) );
    }

    public boolean hasAllRoles ( final Collection<String> roles )
    {
        return this.roles.containsAll ( roles );
    }

    public boolean hasAnyRole ( final String[] roles )
    {
        for ( final String role : roles )
        {
            if ( this.roles.contains ( role ) )
            {
                return true;
            }
        }
        return false;
    }

    public boolean hasAnyRole ( final Collection<String> roles )
    {
        for ( final String role : roles )
        {
            if ( this.roles.contains ( role ) )
            {
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode ()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ( this.name == null ? 0 : this.name.hashCode () );
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
        final UserInformation other = (UserInformation)obj;
        if ( this.name == null )
        {
            if ( other.name != null )
            {
                return false;
            }
        }
        else if ( !this.name.equals ( other.name ) )
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
        sb.append ( "[UserInformation - name=" );
        if ( this.name != null )
        {
            sb.append ( this.name );
        }
        else
        {
            sb.append ( "<anonymous>" );
        }
        sb.append ( ", roles=[" );
        sb.append ( StringHelper.join ( this.roles, ", " ) );
        sb.append ( "]]" );
        return sb.toString ();
    }
}
