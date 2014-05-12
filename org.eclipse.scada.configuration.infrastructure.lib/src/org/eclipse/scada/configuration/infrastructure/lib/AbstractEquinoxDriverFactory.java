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

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.validation.IValidationContext;
import org.eclipse.emf.validation.model.ConstraintStatus;
import org.eclipse.scada.configuration.infrastructure.AbstractFactoryDriver;
import org.eclipse.scada.configuration.infrastructure.EquinoxDriver;
import org.eclipse.scada.configuration.infrastructure.Node;
import org.eclipse.scada.configuration.infrastructure.Options;
import org.eclipse.scada.configuration.infrastructure.World;
import org.eclipse.scada.configuration.lib.Endpoints;
import org.eclipse.scada.configuration.security.Configuration;
import org.eclipse.scada.configuration.utils.Containers;
import org.eclipse.scada.configuration.world.Driver;
import org.eclipse.scada.configuration.world.osgi.ConfigurationAdministratorExporter;
import org.eclipse.scada.configuration.world.osgi.DataAccessExporter;
import org.eclipse.scada.configuration.world.osgi.OsgiFactory;

public abstract class AbstractEquinoxDriverFactory<T extends Driver & org.eclipse.scada.configuration.world.osgi.EquinoxApplication> implements DriverFactory
{

    protected abstract void configureDriver ( final AbstractFactoryDriver driver, final T result, final Map<Node, org.eclipse.scada.configuration.world.Node> nodes );

    protected abstract T createDriver ();

    private final List<DriverValidator<EquinoxDriver>> validators = new LinkedList<> ();

    public AbstractEquinoxDriverFactory ()
    {
        this.validators.add ( new DriverValidator<EquinoxDriver> () {

            @Override
            public void validate ( final IValidationContext ctx, final EquinoxDriver driver, final Collection<IStatus> result )
            {
                final World world = Containers.findContainer ( driver, World.class );
                final Options options = world.getOptions ();

                if ( driver.getUserService () == null && options == null || options.getDefaultUserService () == null )
                {
                    result.add ( ConstraintStatus.createStatus ( ctx, Arrays.asList ( driver ), IStatus.WARNING, 0, "Neither the driver has set a user service nor is there a default in the global options" ) );
                }
                if ( findConfiguration ( driver, world ) == null )
                {
                    result.add ( ConstraintStatus.createStatus ( ctx, Arrays.asList ( driver ), IStatus.WARNING, 1, "Neither the driver has set a security policy nor is there a default in the root" ) );
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
        exporter.getEndpoints ().add ( Worlds.createDaEndpoint ( world.getOptions (), driver ) );

        final ConfigurationAdministratorExporter caExporter = OsgiFactory.eINSTANCE.createConfigurationAdministratorExporter ();
        caExporter.setName ( "caExporter" ); //$NON-NLS-1$
        caExporter.getEndpoints ().add ( Endpoints.createEndpoint ( world.getOptions ().getBaseCaNgpPort () + eDriver.getInstanceNumber (), "CA Exporter" ) );
        result.getExporter ().add ( caExporter );

        Worlds.addUserService ( result, eDriver.getUserService (), world.getOptions () );

        result.setSecurityConfiguration ( findConfiguration ( eDriver, world ) );

        configureDriver ( driver, result, nodes );

        return result;
    }

    private Configuration findConfiguration ( final EquinoxDriver eDriver, final World world )
    {
        if ( eDriver.getSecurityConfiguration () != null )
        {
            return eDriver.getSecurityConfiguration ();
        }
        else if ( world != null )
        {
            return world.getDefaultSecurityConfiguration ();
        }
        return null;
    }

    @Override
    public IStatus validate ( final IValidationContext ctx, final AbstractFactoryDriver driver )
    {
        if ( ! ( driver instanceof EquinoxDriver ) )
        {
            return ConstraintStatus.createStatus ( ctx, driver, null, "Driver factory of type {0} can only process driver of type {1}", this.getClass ().getSimpleName (), EquinoxDriver.class.getSimpleName () );
        }

        final Collection<IStatus> problems = validateDriver ( ctx, (EquinoxDriver)driver );
        if ( problems.isEmpty () )
        {
            return ctx.createSuccessStatus ();
        }
        else
        {
            return ConstraintStatus.createMultiStatus ( ctx, problems );
        }
    }

    protected Collection<IStatus> validateDriver ( final IValidationContext ctx, final EquinoxDriver driver )
    {
        final Collection<IStatus> result = new LinkedList<> ();
        performValidation ( ctx, driver, result );
        return result;
    }

    protected void performValidation ( final IValidationContext ctx, final EquinoxDriver driver, final Collection<IStatus> result )
    {
        for ( final DriverValidator<EquinoxDriver> validator : this.validators )
        {
            validator.validate ( ctx, driver, result );
        }
    }

}