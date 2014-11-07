/*******************************************************************************
 * Copyright (c) 2013, 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.configuration.infrastructure.lib;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.scada.configuration.infrastructure.AbstractFactoryDriver;
import org.eclipse.scada.configuration.infrastructure.EquinoxDriver;
import org.eclipse.scada.configuration.infrastructure.Node;
import org.eclipse.scada.configuration.infrastructure.World;
import org.eclipse.scada.configuration.lib.Endpoints;
import org.eclipse.scada.configuration.world.Driver;
import org.eclipse.scada.configuration.world.osgi.ConfigurationAdministratorExporter;
import org.eclipse.scada.configuration.world.osgi.DataAccessExporter;
import org.eclipse.scada.configuration.world.osgi.OsgiFactory;
import org.eclipse.scada.utils.ecore.validation.Severity;
import org.eclipse.scada.utils.ecore.validation.ValidationContext;

public abstract class AbstractEquinoxDriverFactory<T extends Driver & org.eclipse.scada.configuration.world.osgi.EquinoxApplication> implements DriverFactory
{

    protected abstract void configureDriver ( final AbstractFactoryDriver driver, final T result, final Map<Node, org.eclipse.scada.configuration.world.Node> nodes );

    protected abstract T createDriver ();

    private final List<DriverValidator<EquinoxDriver>> validators = new LinkedList<> ();

    public AbstractEquinoxDriverFactory ()
    {
        this.validators.add ( new DriverValidator<EquinoxDriver> () {

            @Override
            public void validate ( final ValidationContext ctx, final EquinoxDriver driver )
            {
                if ( Worlds.findUserService ( driver ) == null )
                {
                    ctx.add ( Severity.WARNING, new Object[] { driver }, "Neither the driver has set a user service nor is there a default in the global options" );
                }
                if ( Worlds.findSecurityConfiguration ( driver ) == null )
                {
                    ctx.add ( Severity.WARNING, new Object[] { driver }, "Neither the driver has set a security policy nor is there a default in the root" );
                }
            }
        } );
    }

    protected void addValidator ( final DriverValidator<EquinoxDriver> validator )
    {
        this.validators.add ( validator );
    }

    @Override
    public Driver createDriver ( final World world, final AbstractFactoryDriver driver, final Map<Node, org.eclipse.scada.configuration.world.Node> nodes )
    {
        final T result = createDriver ();

        final EquinoxDriver eDriver = (EquinoxDriver)driver;

        final DataAccessExporter exporter = OsgiFactory.eINSTANCE.createDataAccessExporter ();
        exporter.setName ( "exporter" ); //$NON-NLS-1$
        result.getExporter ().add ( exporter );
        exporter.getEndpoints ().add ( Endpoints.registerEndpoint ( nodes.get ( driver.getNode () ), world.getOptions ().getBaseDaNgpPort () + eDriver.getInstanceNumber (), Endpoints.reference ( exporter ), "EquinoxDriver Endpoint: " + driver.getName () ) );

        final ConfigurationAdministratorExporter caExporter = OsgiFactory.eINSTANCE.createConfigurationAdministratorExporter ();
        caExporter.setName ( "caExporter" ); //$NON-NLS-1$
        result.getExporter ().add ( caExporter );
        caExporter.getEndpoints ().add ( Endpoints.registerEndpoint ( nodes.get ( driver.getNode () ), world.getOptions ().getBaseCaNgpPort () + eDriver.getInstanceNumber (), Endpoints.reference ( caExporter ), "CA Exporter: " + driver.getName () ) );

        Worlds.addUserService ( result, eDriver );

        result.setSecurityConfiguration ( Worlds.findSecurityConfiguration ( eDriver ) );

        configureDriver ( driver, result, nodes );

        return result;
    }

    @Override
    public void validate ( final ValidationContext ctx, final AbstractFactoryDriver driver )
    {
        if ( ! ( driver instanceof EquinoxDriver ) )
        {
            ctx.add ( "Driver factory of type {0} can only process driver of type {1}", this.getClass ().getSimpleName (), EquinoxDriver.class.getSimpleName () );
            return;
        }

        performValidation ( ctx, (EquinoxDriver)driver );
    }

    protected void performValidation ( final ValidationContext ctx, final EquinoxDriver driver )
    {
        for ( final DriverValidator<EquinoxDriver> validator : this.validators )
        {
            validator.validate ( ctx, driver );
        }
    }

}