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
package org.eclipse.scada.configuration.infrastructure.lib.internal;

import java.util.List;

import org.eclipse.scada.configuration.generator.Profiles;
import org.eclipse.scada.configuration.infrastructure.SystemPropertyUserService;
import org.eclipse.scada.configuration.infrastructure.UserEntry;
import org.eclipse.scada.configuration.world.osgi.EquinoxApplication;
import org.eclipse.scada.configuration.world.osgi.profile.Profile;
import org.eclipse.scada.configuration.world.osgi.profile.ProfileFactory;
import org.eclipse.scada.configuration.world.osgi.profile.SystemProperty;
import org.eclipse.scada.sec.provider.plain.property.PropertyAuthenticationService;
import org.eclipse.scada.utils.str.StringHelper;

public class SystemPropertiesUserServiceProcessor
{

    private final SystemPropertyUserService userService;

    public SystemPropertiesUserServiceProcessor ( final SystemPropertyUserService userService )
    {
        this.userService = userService;
    }

    public void process ( final EquinoxApplication app )
    {
        // get profile

        final Profile profile = Profiles.createOfGetCustomizationProfile ( app );

        // add system property

        final SystemProperty prop = ProfileFactory.eINSTANCE.createSystemProperty ();
        prop.setKey ( PropertyAuthenticationService.PROP );
        prop.setValue ( makeValue ( this.userService.getUsers () ) );
        profile.getProperty ().add ( prop );

        // add service

        Profiles.addStartBundle ( profile, "org.eclipse.scada.sec.provider.plain.property" );
    }

    private static String makeValue ( final List<UserEntry> users )
    {
        final StringBuilder sb = new StringBuilder ();

        for ( final UserEntry user : users )
        {
            if ( sb.length () > 0 )
            {
                sb.append ( '|' );
            }

            if ( user.getName ().contains ( ":" ) )
            {
                throw new IllegalArgumentException ( "User name must not contain ':'" );
            }

            if ( user.getPassword ().contains ( ":" ) )
            {
                throw new IllegalArgumentException ( "Password must not contain ':'" );
            }

            sb.append ( user.getName () );
            sb.append ( ':' );
            sb.append ( user.getPassword () );
            sb.append ( ':' );
            sb.append ( StringHelper.join ( user.getRoles (), "," ) );
        }

        return sb.toString ();
    }
}
