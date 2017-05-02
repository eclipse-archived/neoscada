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
package org.eclipse.scada.configuration.setup.common.validation;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

import org.eclipse.scada.configuration.setup.common.CommonPackage;
import org.eclipse.scada.configuration.setup.common.SerialToNetworkMapping;
import org.eclipse.scada.utils.ecore.validation.TypedValidator;
import org.eclipse.scada.utils.ecore.validation.ValidationContext;
import org.eclipse.scada.utils.str.StringHelper;

public class SerialMappingValidator extends TypedValidator<SerialToNetworkMapping>
{
    private static final int MIN_PORT = 1;

    private static final int MAX_PORT = 64 * 1024 - 1;

    private static final Set<Integer> validDataBits = new TreeSet<> ( Arrays.asList ( 7, 8 ) );

    private static final Set<Integer> validStopBits = new TreeSet<> ( Arrays.asList ( 1, 2 ) );

    public SerialMappingValidator ()
    {
        super ( SerialToNetworkMapping.class );
    }

    @Override
    protected void validate ( final SerialToNetworkMapping target, final ValidationContext context )
    {
        if ( target.getBaudRate () <= 0 )
        {
            context.add ( CommonPackage.Literals.SERIAL_TO_NETWORK_MAPPING__BAUD_RATE, "Baud rate must be greater than zero" );
        }

        if ( !validDataBits.contains ( (int)target.getDataBits () ) )
        {
            context.add ( CommonPackage.Literals.SERIAL_TO_NETWORK_MAPPING__DATA_BITS, "Data bits must be one of: {0}", StringHelper.join ( validDataBits, ", " ) );
        }

        if ( !validStopBits.contains ( (int)target.getStopBits () ) )
        {
            context.add ( CommonPackage.Literals.SERIAL_TO_NETWORK_MAPPING__STOP_BITS, "Stop bits must be one of: {0}", StringHelper.join ( validStopBits, ", " ) );
        }

        if ( target.getTcpPort () < MIN_PORT || target.getTcpPort () > MAX_PORT )
        {
            context.add ( CommonPackage.Literals.SERIAL_TO_NETWORK_MAPPING__TCP_PORT, "TCP port must be between {0} and {1}", MIN_PORT, MAX_PORT );
        }
    }
}
