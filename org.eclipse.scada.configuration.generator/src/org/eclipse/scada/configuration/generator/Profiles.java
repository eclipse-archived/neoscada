/*******************************************************************************
 * Copyright (c) 2013, 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.configuration.generator;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.scada.configuration.world.PropertyEntry;
import org.eclipse.scada.configuration.world.osgi.EquinoxApplication;
import org.eclipse.scada.configuration.world.osgi.profile.BundleStartLevel;
import org.eclipse.scada.configuration.world.osgi.profile.Profile;
import org.eclipse.scada.configuration.world.osgi.profile.ProfileFactory;
import org.eclipse.scada.configuration.world.osgi.profile.StartBundle;
import org.eclipse.scada.configuration.world.osgi.profile.SystemProperty;

public final class Profiles
{
    private Profiles ()
    {
    }

    public static Map<String, Integer> makeStartLevelMap ( final Profile profile )
    {
        final Map<String, Integer> result = new HashMap<> ();

        for ( final StartBundle start : profile.getStart () )
        {
            result.put ( start.getName (), -1 );
        }
        for ( final BundleStartLevel bsl : profile.getSetbsl () )
        {
            result.put ( bsl.getName (), bsl.getLevel () );
        }

        return result;
    }

    public static Profile createOrGetCustomizationProfile ( final EquinoxApplication app )
    {
        Profile profile = app.getCustomizationProfile ();
        if ( profile == null )
        {
            profile = ProfileFactory.eINSTANCE.createProfile ();
            app.setCustomizationProfile ( profile );
        }
        return profile;
    }

    public static void addStartBundle ( final Profile profile, final String name )
    {
        if ( name == null )
        {
            // no name
            return;
        }

        for ( final StartBundle bundle : profile.getStart () )
        {
            if ( name.equals ( bundle.getName () ) )
            {
                // already added
                return;
            }
        }

        final StartBundle sb = ProfileFactory.eINSTANCE.createStartBundle ();
        sb.setName ( name );
        profile.getStart ().add ( sb );
    }

    public static void addSystemProperty ( final Profile profile, final String key, final Object value, final boolean eval )
    {
        for ( final Iterator<SystemProperty> i = profile.getProperty ().iterator (); i.hasNext (); )
        {
            final SystemProperty p = i.next ();
            if ( p.getKey ().equals ( key ) )
            {
                i.remove ();
            }
        }

        // now add

        final SystemProperty prop = ProfileFactory.eINSTANCE.createSystemProperty ();
        prop.setEval ( eval );
        prop.setKey ( key );
        if ( value != null )
        {
            prop.setValue ( "" + value );
        }
        else
        {
            // we do set null here since we want to cancel out higher level values
            prop.setValue ( null );
        }
        profile.getProperty ().add ( prop );
    }

    public static void addProgramArugment ( final Profile profile, final String argument )
    {
        profile.getArguments ().add ( argument );
    }

    public static void addInclude ( final Profile profile, final ResourceSet resourceSet, final URI uri )
    {
        final EObject content = resourceSet.getEObject ( uri, true );
        if ( content instanceof Profile )
        {
            profile.getIncludes ().add ( (Profile)content );
        }
        else
        {
            throw new IllegalStateException ( String.format ( "URI '%s' must point to an object of type '%s'.", uri, Profile.class.getName () ) );
        }
    }

    public static void addJdbcSystemProperties ( final Profile profile, final String prefix, final String jdbcDriverName, final List<PropertyEntry> jdbcProperties )
    {
        addSystemProperty ( profile, prefix + ".driver", jdbcDriverName, false );
        for ( final PropertyEntry entry : jdbcProperties )
        {
            addSystemProperty ( profile, prefix + ".properties." + entry.getKey (), entry.getValue (), false );
        }
    }

    public static boolean hasStartBundle ( final Profile profile, final String name )
    {
        for ( final StartBundle sb : profile.getStart () )
        {
            if ( sb.getName ().equals ( name ) )
            {
                return true;
            }
        }
        return false;
    }
}
