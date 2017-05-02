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
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import org.eclipse.scada.configuration.generator.Profiles;
import org.eclipse.scada.configuration.infrastructure.DSFileBackend;
import org.eclipse.scada.configuration.infrastructure.EquinoxBase;
import org.eclipse.scada.configuration.infrastructure.Module;
import org.eclipse.scada.configuration.infrastructure.lib.ModuleHandler;
import org.eclipse.scada.configuration.world.osgi.ApplicationModule;
import org.eclipse.scada.configuration.world.osgi.profile.Profile;
import org.eclipse.scada.utils.str.StringReplacer;

public class DSFileModuleHandler implements ModuleHandler
{
    private static final Pattern VAR_PATTERN = Pattern.compile ( "\\#\\{([^{}]*?)\\}" );

    @Override
    public void process ( final Module module, final Collection<ApplicationModule> modules, final EquinoxBase app, final org.eclipse.scada.configuration.world.osgi.EquinoxApplication implApp )
    {
        final DSFileBackend s = (DSFileBackend)module;

        final Profile p = Profiles.createOrGetCustomizationProfile ( implApp );

        final Map<String, String> vars = new HashMap<> ();
        vars.put ( "name", app.getName () );

        Profiles.addSystemProperty ( p, "org.eclipse.scada.ds.storage.file.root", makePath ( vars, s ) );

        // mark for installation
        p.getInstallationUnits ().add ( "org.eclipse.scada.ds.storage.file" );

        // mark for startup
        Profiles.addStartBundle ( p, "org.eclipse.scada.ds.storage.file" );
    }

    private String makePath ( final Map<String, String> vars, final DSFileBackend s )
    {
        return StringReplacer.replace ( s.getPath (), StringReplacer.newExtendedSource ( vars ), VAR_PATTERN, true );
    }

}
