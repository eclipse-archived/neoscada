/*******************************************************************************
 * Copyright (c) 2015 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.configuration.infrastructure.lib.internal;

import java.util.Collection;

import org.eclipse.scada.configuration.generator.Profiles;
import org.eclipse.scada.configuration.infrastructure.EquinoxBase;
import org.eclipse.scada.configuration.infrastructure.JMXSettings;
import org.eclipse.scada.configuration.infrastructure.Module;
import org.eclipse.scada.configuration.infrastructure.lib.ModuleHandler;
import org.eclipse.scada.configuration.lib.Nodes;
import org.eclipse.scada.configuration.world.Node;
import org.eclipse.scada.configuration.world.osgi.ApplicationModule;
import org.eclipse.scada.configuration.world.osgi.profile.Profile;

public class JMXSettingsModuleHandler implements ModuleHandler
{

    @Override
    public void process ( final Module module, final Collection<ApplicationModule> modules, final EquinoxBase app, final org.eclipse.scada.configuration.world.osgi.EquinoxApplication implApp )
    {
        final JMXSettings s = (JMXSettings)module;

        final Profile p = Profiles.createOrGetCustomizationProfile ( implApp );

        // the next line will enable JMX remote
        Profiles.addSystemProperty ( p, "com.sun.management.jmxremote", "" );

        final Integer port = makePort ( s, app );
        Profiles.addSystemProperty ( p, "com.sun.management.jmxremote.port", port );
        Profiles.addSystemProperty ( p, "com.sun.management.jmxremote.local.only", s.getLocalOnly () );
        Profiles.addSystemProperty ( p, "com.sun.management.jmxremote.authenticate", s.getAuthenticated () );
        Profiles.addSystemProperty ( p, "com.sun.management.jmxremote.ssl", s.getSsl () );

        final Node node = Nodes.fromApp ( implApp );

        if ( s.isAssignNodeHostname () && node != null && node.getHostName () != null && !node.getHostName ().isEmpty () )
        {
            Profiles.addSystemProperty ( p, "java.rmi.server.hostname", node.getHostName () );
        }
    }

    private Integer makePort ( final JMXSettings s, final EquinoxBase app )
    {
        if ( s.getPort () != null )
        {
            return s.getPort ();
        }

        if ( s.getInstancePortOffset () != null )
        {
            return s.getInstancePortOffset () + app.getInstanceNumber ();
        }

        return null;
    }

}
