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

import org.eclipse.scada.configuration.infrastructure.AbstractFactoryDriver;
import org.eclipse.scada.configuration.infrastructure.Device;
import org.eclipse.scada.ide.validation.ValidationContext;

/**
 * A validator for a specific device type
 * <p>
 * If you want to validate that a driver has only a specific device type
 * assigned use {@link DeviceTypeValidator}.
 * </p>
 *
 * @author Jens Reimann
 * @param <T>
 *            the driver type
 * @param <D>
 *            the device type
 */
public abstract class DeviceValidator<T extends AbstractFactoryDriver, D extends Device> implements DriverValidator<T>
{
    private final Class<D> deviceClass;

    public DeviceValidator ( final Class<D> deviceClass )
    {
        this.deviceClass = deviceClass;
    }

    @Override
    public void validate ( final ValidationContext ctx, final T driver )
    {
        for ( final Device device : driver.getDevices () )
        {
            if ( !this.deviceClass.isAssignableFrom ( device.getClass () ) )
            {
                continue;
            }
            validateDevice ( this.deviceClass.cast ( device ), ctx );
        }
    }

    protected abstract void validateDevice ( final D device, ValidationContext ctx );
}
