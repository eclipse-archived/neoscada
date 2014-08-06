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

import java.util.Map;

import org.eclipse.scada.configuration.lib.Properties;
import org.eclipse.scada.configuration.world.lib.deployment.DeploymentContext;
import org.eclipse.scada.configuration.world.lib.setup.SetupModuleHandler;
import org.eclipse.scada.configuration.world.setup.OperatingSystemDescriptor;

public class PostgresHandler extends Postgres implements SetupModuleHandler
{
    public PostgresHandler ( final PostgresSetupModule postgres )
    {
        super ( postgres );
    }

    @Override
    public void perform ( final DeploymentContext context, final OperatingSystemDescriptor operatingSystem ) throws Exception
    {
        final String dbName = this.postgres.getDatabase ().getDatabaseName ();
        final String username = this.postgres.getDatabase ().getUsername ();
        final String password = this.postgres.getDatabase ().getPassword ();

        final Map<String, String> properties = Properties.makeAttributes ( operatingSystem.getProperties () );

        final String confFile = getConfigurationFile ( properties );
        final String hbaFile = getHostBasedAccessFile ( properties );

        context.addInstallDependency ( "postgresql" ); //$NON-NLS-1$
        context.addInstallDependency ( "postgresql-contrib" ); //$NON-NLS-1$

        if ( this.postgres.getConfigurationFile () != null && !this.postgres.getConfigurationFile ().isEmpty () )
        {
            context.addFile ( openResource ( this.postgres.getConfigurationFile () ), confFile );
        }
        if ( this.postgres.getHostBasedAccessFile () != null && !this.postgres.getHostBasedAccessFile ().isEmpty () )
        {
            context.addFile ( openResource ( this.postgres.getHostBasedAccessFile () ), hbaFile );
        }

        final String command = String.format ( "esSetupPostgresDatabase -q %s %s %s", shellEscape ( dbName ), shellEscape ( username ), shellEscape ( password ) );

        String postgresUser = this.postgres.getPostgresUser ();
        if ( postgresUser == null || postgresUser.isEmpty () )
        {
            postgresUser = Properties.get ( operatingSystem.getProperties (), POSTGRES_USER_KEY, null );
        }

        if ( postgresUser != null && !postgresUser.isEmpty () )
        {
            context.runAfterInstallation ( String.format ( "   su - %s -c %s", shellEscape ( postgresUser ), shellEscape ( command ) ) ); //$NON-NLS-1$
        }
        else
        {
            context.runAfterInstallation ( "   " + command );
        }
    }

    protected static String shellEscape ( String string )
    {
        if ( string == null )
        {
            return null;
        }

        string = string.replaceAll ( "[^a-zA-Z0-9]", "\\\\$0" );
        return string;
    }

}
