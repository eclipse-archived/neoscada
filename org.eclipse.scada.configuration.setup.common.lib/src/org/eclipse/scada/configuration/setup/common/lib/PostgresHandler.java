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
package org.eclipse.scada.configuration.setup.common.lib;

import java.util.Map;

import org.eclipse.scada.configuration.lib.Properties;
import org.eclipse.scada.configuration.setup.common.Postgres;
import org.eclipse.scada.configuration.setup.common.PostgresSetupModule;
import org.eclipse.scada.configuration.world.lib.deployment.DeploymentContext;
import org.eclipse.scada.configuration.world.lib.deployment.FileInformation;
import org.eclipse.scada.configuration.world.lib.deployment.FileOptions;
import org.eclipse.scada.configuration.world.lib.deployment.OperatingSystemDescriptors;
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

        String postgresUser = this.postgres.getPostgresUser ();
        if ( postgresUser == null || postgresUser.isEmpty () )
        {
            postgresUser = OperatingSystemDescriptors.getProperty ( operatingSystem, POSTGRES_USER_KEY, "root" );
        }
        final String postgresGroup = OperatingSystemDescriptors.getProperty ( operatingSystem, POSTGRES_GROUP_KEY, "root" );

        final Map<String, String> properties = Properties.makeAttributes ( operatingSystem.getProperties () );

        final String confFile = getConfigurationFile ( properties );
        final String hbaFile = getHostBasedAccessFile ( properties );

        context.addInstallDependency ( "postgresql" ); //$NON-NLS-1$
        context.addInstallDependency ( "postgresql-contrib" ); //$NON-NLS-1$

        if ( this.postgres.getConfigurationFile () != null && !this.postgres.getConfigurationFile ().isEmpty () )
        {
            context.addFile ( new InputStreamContentProvider ( openResource ( this.postgres.getConfigurationFile () ) ), confFile, new FileInformation ( 0640, postgresUser, postgresGroup, FileOptions.CONFIGURATION ) );
        }
        if ( this.postgres.getHostBasedAccessFile () != null && !this.postgres.getHostBasedAccessFile ().isEmpty () )
        {
            context.addFile ( new InputStreamContentProvider ( openResource ( this.postgres.getHostBasedAccessFile () ) ), hbaFile, new FileInformation ( 0644, postgresUser, postgresGroup, FileOptions.CONFIGURATION ) );
        }

        final String command = String.format ( "esSetupPostgresDatabase -q %s %s %s", shellEscape ( dbName ), shellEscape ( username ), shellEscape ( password ) );

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
