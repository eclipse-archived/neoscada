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
package org.eclipse.scada.configuration.setup.common;

import java.util.Map;

import org.eclipse.scada.configuration.lib.Properties;
import org.eclipse.scada.configuration.world.setup.OperatingSystemDescriptor;
import org.eclipse.scada.utils.ecore.validation.ValidationContext;

public class PostgresValidator extends Postgres
{
    private final OperatingSystemDescriptor os;

    private final ValidationContext ctx;

    public PostgresValidator ( final PostgresSetupModule postgres, final OperatingSystemDescriptor os, final ValidationContext ctx )
    {
        super ( postgres );
        this.os = os;
        this.ctx = ctx;
    }

    public void validate ()
    {
        final String version = Properties.get ( this.os.getProperties (), POSTGRES_VERSION_KEY, null );
        if ( version == null )
        {
            this.ctx.add ( "Operating system does not provide PostgreSQL" );
        }
        else if ( !POSTGRES_VERSION_VALUE.equals ( version ) )
        {
            this.ctx.add ( "Requires '{0}' = {1} but found ({2})", POSTGRES_VERSION_KEY, POSTGRES_VERSION_VALUE, version );
        }

        final Map<String, String> props = Properties.makeAttributes ( this.os.getProperties () );
        getConfigurationFile ( props );
        getHostBasedAccessFile ( props );
    }
}
