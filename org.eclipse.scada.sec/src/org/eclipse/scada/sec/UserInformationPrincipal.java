/*******************************************************************************
 * Copyright (c) 2010, 2011 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.sec;

import java.security.Principal;

import org.eclipse.scada.utils.lang.Immutable;

@Immutable
public class UserInformationPrincipal implements Principal
{
    private final UserInformation userInformation;

    /**
     * Create an new principal object from a user information
     * 
     * @param userInformation
     *            the user information or <code>null</code> if none is available
     * @return a new {@link UserInformationPrincipal} instance of
     *         <code>null</code> if the
     *         parameter userInformation was null
     */
    public static UserInformationPrincipal create ( final UserInformation userInformation )
    {
        if ( userInformation == null )
        {
            return null;
        }
        else
        {
            return new UserInformationPrincipal ( userInformation );
        }
    }

    /**
     * Create a new principal object
     * <p>
     * For creating a new object with easier <code>null</code> handling see
     * {@link #create(UserInformation)}
     * </p>
     * 
     * @param userInformation
     *            the user information that is the source of the information.
     *            This parameter must not be <code>null</code>
     * @throws NullPointerException
     *             in the case the userInformation parameter is
     *             <code>null</code>
     * @see #create(UserInformation)
     */
    public UserInformationPrincipal ( final UserInformation userInformation )
    {
        if ( userInformation == null )
        {
            throw new NullPointerException ();
        }
        this.userInformation = userInformation;
    }

    @Override
    public String getName ()
    {
        return this.userInformation.getName ();
    }

    @Override
    public String toString ()
    {
        return this.userInformation.getName ();
    }

    @Override
    public int hashCode ()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ( this.userInformation == null ? 0 : this.userInformation.hashCode () );
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
        final UserInformationPrincipal other = (UserInformationPrincipal)obj;
        if ( this.userInformation == null )
        {
            if ( other.userInformation != null )
            {
                return false;
            }
        }
        else if ( !this.userInformation.equals ( other.userInformation ) )
        {
            return false;
        }
        return true;
    }

}
