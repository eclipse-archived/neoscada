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
package org.eclipse.scada.configuration.generator.world.oscar;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.scada.configuration.generator.Profiles;
import org.eclipse.scada.configuration.lib.Names;
import org.eclipse.scada.configuration.world.osgi.EquinoxApplication;
import org.eclipse.scada.configuration.world.osgi.JdbcUserService;
import org.eclipse.scada.configuration.world.osgi.JdbcUserServiceModule;
import org.eclipse.scada.configuration.world.osgi.profile.Profile;

public class JdbcUserServiceModuleProcessor extends BasicTypedOscarProcessor<JdbcUserServiceModule>
{
    private final EquinoxApplication app;

    public JdbcUserServiceModuleProcessor ( final EquinoxApplication app, final OscarContext ctx )
    {
        super ( app, ctx, JdbcUserServiceModule.class );
        this.app = app;
    }

    @Override
    protected void process ( final JdbcUserServiceModule module )
    {
        final Profile profile = Profiles.createOfGetCustomizationProfile ( this.app );
        Profiles.addStartBundle ( profile, "org.eclipse.scada.sec.provider.jdbc" ); //$NON-NLS-1$

        for ( final JdbcUserService service : module.getUserServices () )
        {
            createService ( service );
        }
    }

    private void createService ( final JdbcUserService service )
    {
        final Map<String, String> data = new HashMap<> ();

        data.put ( "driverName", service.getJdbcDriver () );
        data.put ( "passwordType", service.getPasswordType ().toString () );

        data.put ( "findUserSql", service.getFindUserSql () );
        Helper.addOptional ( data, "findRolesForUserSql", service.getFindRolesForUserSql () );

        Helper.addOptional ( data, "userIdColumnName", service.getUserIdColumnName () );
        Helper.addOptional ( data, "passwordColumnName", service.getPasswordColumnName () );

        Helper.addOptional ( data, "updatePasswordSql", service.getUpdatePasswordSql () );

        data.put ( "authoritative", service.isAuthorative () ? "true" : "false " );

        Helper.makeAttributes ( "jdbc.properties.", service.getJdbcPropeties () );

        addData ( Factories.FACTORY_SEC_JDBC, Names.makeName ( service ), data );
    }
}
