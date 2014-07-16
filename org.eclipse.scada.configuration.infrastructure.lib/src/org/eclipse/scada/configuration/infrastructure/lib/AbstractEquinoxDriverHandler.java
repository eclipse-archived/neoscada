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
package org.eclipse.scada.configuration.infrastructure.lib;

import java.util.Map;

import org.eclipse.scada.configuration.infrastructure.EquinoxBase;
import org.eclipse.scada.configuration.infrastructure.Node;
import org.eclipse.scada.configuration.infrastructure.World;
import org.eclipse.scada.configuration.lib.Endpoints;
import org.eclipse.scada.configuration.utils.Containers;
import org.eclipse.scada.configuration.world.Driver;
import org.eclipse.scada.configuration.world.osgi.ConfigurationAdministratorExporter;
import org.eclipse.scada.configuration.world.osgi.DataAccessExporter;
import org.eclipse.scada.configuration.world.osgi.EquinoxApplication;
import org.eclipse.scada.configuration.world.osgi.OsgiFactory;

public abstract class AbstractEquinoxDriverHandler<T extends org.eclipse.scada.configuration.infrastructure.Driver & EquinoxBase, S extends Driver & EquinoxApplication> implements DriverHandler
{
    protected abstract S createDriver ( T driver, final Map<Node, org.eclipse.scada.configuration.world.Node> nodes );

    @SuppressWarnings ( "unchecked" )
    @Override
    public Driver process ( final org.eclipse.scada.configuration.infrastructure.Driver infraDriver, final Map<Node, org.eclipse.scada.configuration.world.Node> nodes )
    {
        final T driver = (T)infraDriver;

        final S result = createDriver ( driver, nodes );

        result.setName ( driver.getName () );

        result.setSecurityConfiguration ( Worlds.findSecurityConfiguration ( driver ) );
        Worlds.addUserService ( result, driver );

        final World world = Containers.findContainer ( infraDriver, World.class );

        final DataAccessExporter exporter = OsgiFactory.eINSTANCE.createDataAccessExporter ();
        exporter.setName ( "exporter" ); //$NON-NLS-1$
        result.getExporter ().add ( exporter );
        exporter.getEndpoints ().add ( Endpoints.registerEndpoint ( nodes.get ( driver.getNode () ), world.getOptions ().getBaseDaNgpPort () + driver.getInstanceNumber (), Endpoints.reference ( exporter ), "EquinoxDriver Endpoint: " + driver.getName () ) );

        final ConfigurationAdministratorExporter caExporter = OsgiFactory.eINSTANCE.createConfigurationAdministratorExporter ();
        caExporter.setName ( "caExporter" ); //$NON-NLS-1$
        result.getExporter ().add ( caExporter );
        caExporter.getEndpoints ().add ( Endpoints.registerEndpoint ( nodes.get ( driver.getNode () ), world.getOptions ().getBaseCaNgpPort () + driver.getInstanceNumber (), Endpoints.reference ( caExporter ), "CA Exporter: " + driver.getName () ) );

        return result;
    }

}