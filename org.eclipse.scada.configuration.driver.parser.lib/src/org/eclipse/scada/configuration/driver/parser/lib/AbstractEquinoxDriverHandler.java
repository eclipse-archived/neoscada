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
package org.eclipse.scada.configuration.driver.parser.lib;

import org.eclipse.scada.configuration.infrastructure.EquinoxBase;
import org.eclipse.scada.configuration.infrastructure.World;
import org.eclipse.scada.configuration.infrastructure.lib.DriverHandler;
import org.eclipse.scada.configuration.infrastructure.lib.Worlds;
import org.eclipse.scada.configuration.lib.Endpoints;
import org.eclipse.scada.configuration.utils.Containers;
import org.eclipse.scada.configuration.world.Driver;
import org.eclipse.scada.configuration.world.osgi.ConfigurationAdministratorExporter;
import org.eclipse.scada.configuration.world.osgi.DataAccessExporter;
import org.eclipse.scada.configuration.world.osgi.EquinoxApplication;
import org.eclipse.scada.configuration.world.osgi.OsgiFactory;

public abstract class AbstractEquinoxDriverHandler<T extends org.eclipse.scada.configuration.infrastructure.Driver & EquinoxBase, S extends Driver & EquinoxApplication> implements DriverHandler
{
    protected abstract S createDriver ( T driver );

    @SuppressWarnings ( "unchecked" )
    @Override
    public Driver process ( final org.eclipse.scada.configuration.infrastructure.Driver infraDriver )
    {
        final T driver = (T)infraDriver;

        final S result = createDriver ( driver );

        result.setName ( driver.getName () );

        result.setSecurityConfiguration ( Worlds.findSecurityConfiguration ( driver ) );
        Worlds.addUserService ( result, driver );

        final World world = Containers.findContainer ( infraDriver, World.class );

        final DataAccessExporter exporter = OsgiFactory.eINSTANCE.createDataAccessExporter ();
        exporter.setName ( "exporter" ); //$NON-NLS-1$
        result.getExporter ().add ( exporter );
        exporter.getEndpoints ().add ( Worlds.createDaEndpoint ( world.getOptions (), driver ) );

        final ConfigurationAdministratorExporter caExporter = OsgiFactory.eINSTANCE.createConfigurationAdministratorExporter ();
        caExporter.setName ( "caExporter" ); //$NON-NLS-1$
        caExporter.getEndpoints ().add ( Endpoints.createEndpoint ( world.getOptions ().getBaseCaNgpPort () + driver.getInstanceNumber (), "CA Exporter" ) );
        result.getExporter ().add ( caExporter );

        return result;
    }

}