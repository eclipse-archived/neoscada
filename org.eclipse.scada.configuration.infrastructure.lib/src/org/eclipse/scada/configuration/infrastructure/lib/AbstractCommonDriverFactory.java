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

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.scada.configuration.infrastructure.AbstractFactoryDriver;
import org.eclipse.scada.configuration.infrastructure.InfrastructurePackage;
import org.eclipse.scada.configuration.infrastructure.Node;
import org.eclipse.scada.configuration.infrastructure.World;
import org.eclipse.scada.configuration.lib.Endpoints;
import org.eclipse.scada.configuration.world.CommonDriver;
import org.eclipse.scada.configuration.world.Driver;
import org.eclipse.scada.configuration.world.Endpoint;
import org.eclipse.scada.ide.validation.Severity;
import org.eclipse.scada.ide.validation.ValidationContext;

public abstract class AbstractCommonDriverFactory<T extends CommonDriver> implements DriverFactory
{

    protected abstract void configureDriver ( final World world, final AbstractFactoryDriver infraDriver, final T driver );

    protected abstract T createDriver ();

    private final List<DriverValidator<org.eclipse.scada.configuration.infrastructure.CommonDriver>> validators = new LinkedList<> ();

    public AbstractCommonDriverFactory ()
    {
        this.validators.add ( new DriverValidator<org.eclipse.scada.configuration.infrastructure.CommonDriver> () {

            @Override
            public void validate ( final ValidationContext ctx, final org.eclipse.scada.configuration.infrastructure.CommonDriver driver )
            {
                if ( Worlds.findCommonDriverPassword ( driver ) == null )
                {
                    ctx.add ( Severity.WARNING, new Object[] { driver }, "Access to the driver is not secured by a password." );
                }

                if ( driver.getPortNumber () <= 0 )
                {
                    ctx.add ( InfrastructurePackage.Literals.COMMON_DRIVER__PORT_NUMBER, "The port number ({0}) is invalid. It must be greater then zero.", driver.getPortNumber () );
                }
            }
        } );
    }

    protected void addValidator ( final DriverValidator<org.eclipse.scada.configuration.infrastructure.CommonDriver> validator )
    {
        this.validators.add ( validator );
    }

    @Override
    public Driver createDriver ( final World world, final AbstractFactoryDriver infraDriver, final Map<Node, org.eclipse.scada.configuration.world.Node> nodes )
    {
        final T driver = createDriver ();

        driver.setPassword ( EcoreUtil.copy ( Worlds.findCommonDriverPassword ( (org.eclipse.scada.configuration.infrastructure.CommonDriver)infraDriver ) ) );

        final Endpoint ep = Endpoints.registerEndpoint ( nodes.get ( infraDriver.getNode () ), ( (org.eclipse.scada.configuration.infrastructure.CommonDriver)infraDriver ).getPortNumber (), Endpoints.reference ( driver ), "CommonDriver Endpoint: " + driver.getName () );
        driver.getEndpoints ().add ( ep );

        configureDriver ( world, infraDriver, driver );

        return driver;
    }

    @Override
    public void validate ( final ValidationContext ctx, final AbstractFactoryDriver driver )
    {
        if ( ! ( driver instanceof org.eclipse.scada.configuration.infrastructure.CommonDriver ) )
        {
            ctx.add ( "Driver factory of type {0} can only process driver of type {1}", this.getClass ().getSimpleName (), org.eclipse.scada.configuration.infrastructure.CommonDriver.class.getSimpleName () );
            return;
        }

        validateDriver ( ctx, (org.eclipse.scada.configuration.infrastructure.CommonDriver)driver );
    }

    protected void validateDriver ( final ValidationContext ctx, final org.eclipse.scada.configuration.infrastructure.CommonDriver driver )
    {
        for ( final DriverValidator<org.eclipse.scada.configuration.infrastructure.CommonDriver> validator : this.validators )
        {
            validator.validate ( ctx, driver );
        }
    }

}