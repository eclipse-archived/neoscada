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
package org.eclipse.scada.sec.provider.plain.property;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import org.eclipse.scada.sec.authn.AbstractPlainAuthenticationService;

/**
 * A plain authentication provider
 * <p>
 * Authentication data is stored in the following from in the system property
 * <code>org.eclipse.scada.sec.provider.plain.property.data</code>:
 * <code>username:password:ROLE1,ROLE2|username2:password2:ROLE1,ROLE2</code>
 * </p>
 * 
 * @author Jens Reimann
 * @since 0.1.0
 */
public class PropertyAuthenticationService extends AbstractPlainAuthenticationService
{
    public static final String PROP = "org.eclipse.scada.sec.provider.plain.property.data";

    protected Map<String, UserEntry> userInformation = new HashMap<String, UserEntry> ();

    public PropertyAuthenticationService ()
    {
        this.userInformation.putAll ( split ( System.getProperty ( PROP, "" ) ) );
    }

    public static Map<String, UserEntry> split ( final String data )
    {
        final StringTokenizer tok = new StringTokenizer ( data, "|" );

        final Map<String, UserEntry> result = new HashMap<String, UserEntry> ();

        while ( tok.hasMoreElements () )
        {
            final String[] toks = tok.nextToken ().split ( ":" );
            if ( toks.length == 3 )
            {
                final String name = toks[0];
                final String password = toks[1];
                final String[] roles = toks[2].split ( "," );
                final UserEntry entry = new UserEntry ( password, Arrays.asList ( roles ) );
                result.put ( name, entry );
            }
            else if ( toks.length == 2 )
            {
                final String name = toks[0];
                final String password = toks[1];
                final UserEntry entry = new UserEntry ( password, Collections.<String> emptyList () );
                result.put ( name, entry );
            }
        }

        return result;
    }

    @Override
    protected UserEntry getUserEntry ( final String name )
    {
        return this.userInformation.get ( name );
    }

}
