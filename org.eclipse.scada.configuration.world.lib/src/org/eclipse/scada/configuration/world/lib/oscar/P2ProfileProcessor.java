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
package org.eclipse.scada.configuration.world.lib.oscar;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.scada.configuration.world.lib.Nodes;
import org.eclipse.scada.configuration.world.osgi.EquinoxApplication;
import org.eclipse.scada.configuration.world.osgi.profile.Profile;
import org.eclipse.scada.configuration.world.osgi.profile.ProfileFactory;
import org.eclipse.scada.configuration.world.osgi.profile.SubProfile;
import org.eclipse.scada.configuration.world.osgi.profile.SystemProperty;

public class P2ProfileProcessor
{
    private final EquinoxApplication app;

    public P2ProfileProcessor ( final EquinoxApplication app )
    {
        this.app = app;
    }

    public void process ( final File output, final IProgressMonitor monitor ) throws Exception
    {
        processProfile ( output );
    }

    private void processProfile ( final File output ) throws IOException
    {
        final Profile profile = makeProfile ( this.app );

        final File profileFile = new File ( output, this.app.getName () + ".profile.xml" ); //$NON-NLS-1$

        final ResourceSet rs = new ResourceSetImpl ();
        final Resource r = rs.createResource ( URI.createFileURI ( profileFile.toString () ) );
        r.getContents ().add ( EcoreUtil.copy ( profile ) );

        final Map<Object, Object> options = new HashMap<> ();
        options.put ( XMLResource.OPTION_ENCODING, "UTF-8" ); //$NON-NLS-1$

        r.save ( options );
    }

    public static Profile makeProfile ( final EquinoxApplication app )
    {
        final Profile profile = flatten ( EcoreUtil.copy ( app.getProfile () ) );

        if ( profile == null )
        {
            throw new IllegalStateException ( "Application implemenation did not return a profile" );
        }

        if ( app.getCustomizationProfile () != null )
        {
            mergeIntoProfile ( flatten ( EcoreUtil.copy ( app.getCustomizationProfile () ) ), profile );
        }

        profile.setName ( String.format ( "Custom profile for %s on node %s", app.getName (), Nodes.fromApp ( app ).getHostName () ) );
        profile.setDescription ( null );

        // finally clear null system properties
        clearNulls ( profile );

        return profile;
    }

    protected static void clearNulls ( final Profile profile )
    {
        for ( final Iterator<SystemProperty> i = profile.getProperty ().iterator (); i.hasNext (); )
        {
            final SystemProperty prop = i.next ();
            if ( prop.getValue () == null )
            {
                i.remove ();
            }
        }
    }

    public static Profile flatten ( final Profile profile )
    {
        flatten ( profile, profile.getIncludes () );
        profile.getIncludes ().clear ();
        return profile;
    }

    static void flatten ( final Profile profile, final EList<Profile> includes )
    {
        for ( final Profile include : includes )
        {
            mergeIntoProfile ( include, profile );
            flatten ( profile, include.getIncludes () );
        }
    }

    static void mergeIntoProfile ( final Profile source, final Profile target )
    {
        target.getInstallationUnits ().addAll ( source.getInstallationUnits () );
        target.getJvmArguments ().addAll ( source.getJvmArguments () );
        target.getArguments ().addAll ( source.getArguments () );
        target.getNotes ().addAll ( source.getNotes () );
        target.getSetbsl ().addAll ( EcoreUtil.copyAll ( source.getSetbsl () ) );
        target.getStart ().addAll ( EcoreUtil.copyAll ( source.getStart () ) );
        target.getProperty ().addAll ( EcoreUtil.copyAll ( source.getProperty () ) );

        // merge sub profiles
        for ( final SubProfile subProfile : source.getProfile () )
        {
            mergeSubProfile ( subProfile, findTargetSubProfile ( subProfile.getName (), target ) );
        }
    }

    static void mergeSubProfile ( final SubProfile source, final SubProfile target )
    {
        target.getProperty ().addAll ( target.getProperty () );
    }

    static SubProfile findTargetSubProfile ( final String name, final Profile target )
    {
        for ( final SubProfile sub : target.getProfile () )
        {
            if ( sub.getName ().equals ( name ) )
            {
                return sub;
            }
        }

        // did not find, create a new one

        final SubProfile sub = ProfileFactory.eINSTANCE.createSubProfile ();
        sub.setName ( name );
        target.getProfile ().add ( sub );
        return sub;
    }
}
