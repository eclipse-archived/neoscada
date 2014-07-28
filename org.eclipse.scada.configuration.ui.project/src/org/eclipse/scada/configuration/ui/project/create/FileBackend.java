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
package org.eclipse.scada.configuration.ui.project.create;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.scada.configuration.generator.Profiles;
import org.eclipse.scada.configuration.world.osgi.profile.Profile;

public class FileBackend implements PersistentBackend
{
    private String location;

    private final String bundle;

    private final String key;

    public FileBackend ( final String bundle, final String key, final String defaultLocation )
    {
        this.bundle = bundle;
        this.key = key;
        this.location = defaultLocation;
    }

    public void setLocation ( final String location )
    {
        this.location = location;
    }

    @Override
    public void configure ( final ResourceSet rs, final Profile profile, final String appName )
    {
        Profiles.addStartBundle ( profile, this.bundle );
        Profiles.addSystemProperty ( profile, this.key, String.format ( this.location, appName ) );
    }

}
