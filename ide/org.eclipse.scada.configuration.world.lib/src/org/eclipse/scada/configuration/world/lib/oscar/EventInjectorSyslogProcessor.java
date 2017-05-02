/*******************************************************************************
 * Copyright (c) 2014 IBH SYSTEMS GmbH and others.
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

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.scada.configuration.generator.Profiles;
import org.eclipse.scada.configuration.world.osgi.EquinoxApplication;
import org.eclipse.scada.configuration.world.osgi.EventInjectorSyslog;
import org.eclipse.scada.configuration.world.osgi.profile.Profile;

public class EventInjectorSyslogProcessor extends TypedOscarProcessor<EventInjectorSyslog>
{
    private static final String BUNDLE = "org.eclipse.scada.ae.server.syslog"; //$NON-NLS-1$

    private static final String FACTORY_ID = "org.eclipse.scada.ae.server.syslog.receiver"; //$NON-NLS-1$

    public EventInjectorSyslogProcessor ()
    {
        super ( EventInjectorSyslog.class );
    }

    @Override
    protected void process ( final EventInjectorSyslog item, final EquinoxApplication app, final OscarContext ctx, final IProgressMonitor monitor )
    {
        final Profile profile = Profiles.createOrGetCustomizationProfile ( app );

        Profiles.addStartBundle ( profile, BUNDLE );
        profile.getInstallationUnits ().add ( BUNDLE );

        final String id = String.format ( "%s_%s", item.getBindAddress (), item.getEndpoint ().getPortNumber () ); //$NON-NLS-1$

        final Map<String, String> data = new HashMap<> ();
        data.put ( "port", "" + item.getEndpoint ().getPortNumber () );
        if ( item.getBindAddress () != null )
        {
            data.put ( "host", item.getBindAddress () );
        }

        ctx.addData ( FACTORY_ID, id, data );
    }

}
