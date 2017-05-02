/*******************************************************************************
 * Copyright (c) 2013 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.sec.provider.provider.ca;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.eclipse.scada.ca.ConfigurationFactory;
import org.eclipse.scada.sec.UserInformation;
import org.eclipse.scada.sec.authn.AbstractPlainAuthenticationService;

public class AuthenticationServiceImpl extends AbstractPlainAuthenticationService implements ConfigurationFactory
{
    private final Map<String, UserEntry> entries = new HashMap<String, UserEntry> ();

    private final Lock readLock;

    private final Lock writeLock;

    public AuthenticationServiceImpl ()
    {
        final ReadWriteLock lock = new ReentrantReadWriteLock ();
        this.readLock = lock.readLock ();
        this.writeLock = lock.writeLock ();
    }

    @Override
    protected UserEntry getUserEntry ( final String name ) throws Exception
    {
        this.readLock.lock ();
        try
        {
            return this.entries.get ( name );
        }
        finally
        {
            this.readLock.unlock ();
        }
    }

    @Override
    public void update ( final UserInformation userInformation, final String configurationId, final Map<String, String> properties ) throws Exception
    {
        final UserEntry entry = new UserEntry ( properties.get ( "password" ), makeRoles ( properties ) );

        this.writeLock.lock ();
        try
        {
            this.entries.put ( configurationId, entry );
        }
        finally
        {
            this.writeLock.unlock ();
        }
    }

    private Collection<String> makeRoles ( final Map<String, String> properties )
    {
        final Collection<String> result = new HashSet<> ();

        final String roles = properties.get ( "roles" );
        if ( roles != null )
        {
            final String[] toks = roles.split ( "[, \\t\\n\\r]+" );
            result.addAll ( Arrays.asList ( toks ) );
        }

        return result;
    }

    @Override
    public void delete ( final UserInformation userInformation, final String configurationId ) throws Exception
    {
        this.writeLock.lock ();
        try
        {
            this.entries.remove ( configurationId );
        }
        finally
        {
            this.writeLock.unlock ();
        }
    }

}
