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

import org.eclipse.scada.configuration.world.lib.deployment.OperatingSystemDescriptors;
import org.eclipse.scada.configuration.world.setup.OperatingSystemDescriptor;

public final class SerialToNetwork
{
    public static final String DPKG_DIVERT = "dpkg.divert";

    public static void validate ( final SerialToNetworkSetupModule setupModule, final OperatingSystemDescriptor descriptor ) throws Exception
    {
        if ( !OperatingSystemDescriptors.isProperty ( descriptor, DPKG_DIVERT, false ) )
        {
            throw new IllegalStateException ( String.format ( "Operating system %s does not support '%s'. Or it is not set to 'true'.", descriptor.getId (), DPKG_DIVERT ) );
        }
    }
}
