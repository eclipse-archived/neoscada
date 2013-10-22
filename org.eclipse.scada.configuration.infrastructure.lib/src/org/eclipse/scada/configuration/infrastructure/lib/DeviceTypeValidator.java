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
package org.eclipse.scada.configuration.infrastructure.lib;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.IValidationContext;
import org.eclipse.emf.validation.model.ConstraintStatus;
import org.eclipse.scada.configuration.infrastructure.AbstractFactoryDriver;
import org.eclipse.scada.configuration.infrastructure.Device;

public class DeviceTypeValidator<T extends AbstractFactoryDriver> implements DriverValidator<T>
{

    private final Class<?> deviceClass;

    public DeviceTypeValidator ( final Class<?> deviceClass )
    {
        this.deviceClass = deviceClass;
    }

    @Override
    public void validate ( final IValidationContext ctx, final T driver, final Collection<IStatus> result )
    {

        final Set<EObject> locations = new HashSet<> ();
        final Set<String> illegalDevices = new HashSet<> ();
        for ( final Device device : driver.getDevices () )
        {
            if ( !this.deviceClass.isAssignableFrom ( device.getClass () ) )
            {
                illegalDevices.add ( device.getClass ().getName () );
                locations.add ( device );
            }
        }

        if ( !illegalDevices.isEmpty () )
        {
            result.add ( ConstraintStatus.createStatus ( ctx, locations, IStatus.ERROR, 3, "The driver may only contain device of type {0}. The following device types are invalid: {1}", this.deviceClass.getName (), illegalDevices ) );
        }
    }
}
