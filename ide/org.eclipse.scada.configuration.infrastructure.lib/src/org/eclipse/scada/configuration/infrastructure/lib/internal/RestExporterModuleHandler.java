/*******************************************************************************
 * Copyright (c) 2014, 2015 IBH SYSTEMS GmbH and others.
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

import org.eclipse.scada.configuration.infrastructure.EquinoxApplication;
import org.eclipse.scada.configuration.infrastructure.EquinoxBase;
import org.eclipse.scada.configuration.infrastructure.Module;
import org.eclipse.scada.configuration.infrastructure.RestExporterModule;
import org.eclipse.scada.configuration.infrastructure.lib.ModuleHandler;
import org.eclipse.scada.configuration.infrastructure.lib.Worlds;
import org.eclipse.scada.configuration.world.osgi.ApplicationModule;
import org.eclipse.scada.configuration.world.osgi.OsgiFactory;
import org.eclipse.scada.configuration.world.osgi.RestExporter;

public class RestExporterModuleHandler implements ModuleHandler
{

    @Override
    public void process ( final Module module, final Collection<ApplicationModule> modules, final EquinoxBase app, final org.eclipse.scada.configuration.world.osgi.EquinoxApplication implApp )
    {
        final EquinoxApplication eqApp = (EquinoxApplication)app;
        if ( app instanceof EquinoxApplication )
        {
            final RestExporter s = OsgiFactory.eINSTANCE.createRestExporter ();
            s.setContextId ( ( (RestExporterModule)module ).getContextId () );
            s.getHiveProperties ().addAll ( Worlds.convertToProperties ( Worlds.findInterconnectCredentials ( eqApp ) ) );
            modules.add ( s );
        }
    }

}
