/*******************************************************************************
 * Copyright (c) 2016 Red Hat Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Red Hat Inc - initial API and implementation
 *******************************************************************************/
package org.eclipse.neoscada.releng.p2.to.maven;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.eclipse.equinox.p2.metadata.IInstallableUnit;

public class LicenseProvider
{
    private final Properties properties;

    private final Map<String, License> licenses = new HashMap<> ();

    public LicenseProvider ( final Properties properties )
    {
        this.properties = properties;

        this.licenses.put ( "epl", License.EPL );
    }

    public List<License> getLicenses ( final IInstallableUnit iu )
    {
        final String id = this.properties.getProperty ( "license.for." + iu.getId () );

        if ( id == null || id.isEmpty () )
        {
            return null;
        }

        final String[] ids = id.split ( "," );
        if ( ids.length == 0 )
        {
            return null;
        }

        final List<License> result = new ArrayList<> ( ids.length );

        for ( final String lid : ids )
        {
            final License lic = this.licenses.get ( lid );
            if ( lic != null )
            {
                result.add ( lic );
            }
            else
            {
                result.add ( parseLicense ( lid ) );
            }
        }

        return result;
    }

    private License parseLicense ( final String id )
    {
        final String name = this.properties.getProperty ( "license.info." + id + ".name" );
        final String url = this.properties.getProperty ( "license.info." + id + ".url" );

        if ( name == null || url == null )
        {
            throw new IllegalStateException ( "Missing or invalid license information for: " + id );
        }

        if ( name.isEmpty () || url.isEmpty () )
        {
            throw new IllegalStateException ( "Missing or invalid license information for: " + id );
        }

        return new License ( name, url );
    }
}
