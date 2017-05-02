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
package org.eclipse.scada.configuration.world.lib.oscar;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.scada.configuration.world.Endpoint;
import org.eclipse.scada.configuration.world.osgi.EquinoxApplication;
import org.eclipse.scada.configuration.world.osgi.Exporter;
import org.eclipse.scada.configuration.world.osgi.profile.Profile;
import org.eclipse.scada.configuration.world.osgi.profile.ProfileFactory;
import org.eclipse.scada.configuration.world.osgi.profile.SystemProperty;

public class ExporterProcessor extends BasicOscarProcessor
{

    private final EquinoxApplication app;

    public ExporterProcessor ( final EquinoxApplication app, final OscarContext ctx )
    {
        super ( app, ctx );
        this.app = app;
    }

    public void process ()
    {
        if ( this.app.getCustomizationProfile () == null )
        {
            this.app.setCustomizationProfile ( ProfileFactory.eINSTANCE.createProfile () );
        }

        final Profile prof = this.app.getCustomizationProfile ();

        final Map<Class<?>, Exporter> countMap = new HashMap<> ();

        for ( final Exporter exporter : this.app.getExporter () )
        {
            if ( exporter.getEndpoints ().size () != 1 )
            {
                throw new IllegalStateException ( "At the moment each exporter must not have exactly than one endpoint" );
            }

            if ( countMap.containsKey ( exporter.getClass () ) )
            {
                throw new IllegalStateException ( String.format ( "At the moment there must not me more than one exporter at a time for the type: %s", exporter.getClass () ) );
            }
            countMap.put ( exporter.getClass (), exporter );

            final String tag = exporter.getTypeTag ();
            put ( prof, String.format ( "org.eclipse.scada.%s.server.exporter.ngp.exportUri", tag ), makeUri ( tag, exporter.getEndpoints ().get ( 0 ) ) );
        }
    }

    private String makeUri ( final String tag, final Endpoint endpoint )
    {
        return String.format ( "%s:ngp://0.0.0.0:%s", tag, endpoint.getPortNumber () );
    }

    private void put ( final Profile prof, final String key, final String value )
    {
        final SystemProperty prop = ProfileFactory.eINSTANCE.createSystemProperty ();
        prof.getProperty ().add ( prop );

        prop.setEval ( false );
        prop.setKey ( key );
        prop.setValue ( value );
    }

}
