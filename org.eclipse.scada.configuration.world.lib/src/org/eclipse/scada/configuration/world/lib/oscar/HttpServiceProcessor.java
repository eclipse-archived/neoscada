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

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.scada.configuration.generator.Profiles;
import org.eclipse.scada.configuration.world.osgi.EquinoxApplication;
import org.eclipse.scada.configuration.world.osgi.HttpService;
import org.eclipse.scada.configuration.world.osgi.profile.Profile;

public class HttpServiceProcessor extends TypedOscarProcessor<HttpService>
{

    public HttpServiceProcessor ()
    {
        super ( HttpService.class );
    }

    @Override
    protected void process ( final HttpService item, final EquinoxApplication app, final OscarContext ctx, final IProgressMonitor monitor )
    {
        final Profile profile = Profiles.createOfGetCustomizationProfile ( app );
        Profiles.addStartBundle ( profile, "org.eclipse.jetty.http" );

        Profiles.addSystemProperty ( profile, "org.osgi.service.http.port", "" + item.getEndpoint ().getPortNumber (), false );
    }

}
