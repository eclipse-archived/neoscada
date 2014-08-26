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
package org.eclipse.scada.configuration.setup.common;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.scada.utils.str.ExtendedPropertiesReplacer;
import org.eclipse.scada.utils.str.StringReplacer;

public class Postgres
{
    public static final String POSTGRES_VERSION_KEY = "postgresql.version"; //$NON-NLS-1$

    public static final String POSTGRES_USER_KEY = "postgresql.user"; //$NON-NLS-1$

    public static final String POSTGRES_GROUP_KEY = "postgresql.group"; //$NON-NLS-1$

    public static final String POSTGRES_VERSION_VALUE = "9.3"; //$NON-NLS-1$

    public static final String PLUGIN_ID = "org.eclipse.scada.configuration.setup.common"; //$NON-NLS-1$

    protected final PostgresSetupModule postgres;

    public Postgres ( final PostgresSetupModule postgres )
    {
        this.postgres = postgres;
    }

    public InputStream openResource ( final String uriString ) throws MalformedURLException, IOException
    {
        return makeURL ( uriString ).openStream ();
    }

    public URL makeURL ( final String uriString ) throws MalformedURLException
    {
        URI uri = URI.createURI ( uriString );
        uri = uri.resolve ( this.postgres.eResource ().getURI () );
        return new URL ( uri.toString () );
    }

    protected String getHostBasedAccessFile ( final Map<String, String> properties )
    {
        return expand ( "${postgresql.hostBasedAccessFile:${postgresql.configurationDirectory}/pg_hba.conf}", properties );
    }

    protected String getConfigurationFile ( final Map<String, String> properties )
    {
        return expand ( "${postgresql.configurationFile:${postgresql.configurationDirectory}/postgresql.conf}", properties );
    }

    protected String expand ( final String string, final Map<String, String> properties )
    {
        return StringReplacer.replace ( string, new ExtendedPropertiesReplacer ( properties, true ), StringReplacer.DEFAULT_PATTERN );
    }

}
