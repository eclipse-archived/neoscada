/*******************************************************************************
 * Copyright (c) 2012, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.ui.styles;

import java.util.EnumSet;
import java.util.Set;

import org.eclipse.scada.da.client.DataItemValue;
import org.eclipse.scada.core.ui.styles.AbstractStateInformation;

public class DataItemValueStateExtractor extends AbstractStateInformation
{

    public DataItemValueStateExtractor ( final DataItemValue itemValue )
    {
        super ( extractStates ( itemValue ) );
    }

    private static Set<State> extractStates ( final DataItemValue value )
    {
        if ( value == null )
        {
            return EnumSet.noneOf ( State.class );
        }

        final EnumSet<State> result = EnumSet.noneOf ( State.class );

        if ( value.isError () )
        {
            result.add ( State.ERROR );
        }
        if ( value.isAlarm () )
        {
            result.add ( State.ALARM );
        }
        if ( value.isWarning () )
        {
            result.add ( State.WARNING );
        }
        if ( value.isBlocked () )
        {
            result.add ( State.BLOCK );
        }
        if ( value.isManual () )
        {
            result.add ( State.MANUAL );
        }
        if ( !value.isConnected () )
        {
            result.add ( State.DISCONNECTED );
        }
        if ( value.isAttribute ( "warning.ackRequired", false ) )
        {
            result.add ( State.WARNING_ACK );
        }
        if ( value.isAttribute ( "alarm.ackRequired", false ) )
        {
            result.add ( State.ALARM_ACK );
        }
        if ( value.isAttribute ( "error.ackRequired", false ) )
        {
            result.add ( State.ERROR_ACK );
        }

        return result;
    }

}
