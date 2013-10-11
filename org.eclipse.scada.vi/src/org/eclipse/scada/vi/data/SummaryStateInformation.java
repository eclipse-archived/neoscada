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
package org.eclipse.scada.vi.data;

import java.util.EnumSet;
import java.util.Set;

import org.eclipse.scada.core.ui.styles.AbstractStateInformation;

public class SummaryStateInformation extends AbstractStateInformation
{
    public SummaryStateInformation ( final SummaryInformation info )
    {
        super ( extract ( info ) );
    }

    private static Set<State> extract ( final SummaryInformation info )
    {
        final EnumSet<State> result = EnumSet.noneOf ( State.class );

        if ( info.isAckRequired ( "warning" ) )
        {
            result.add ( State.WARNING_ACK );
        }
        if ( info.isAckRequired ( "alarm" ) )
        {
            result.add ( State.ALARM_ACK );
        }
        if ( info.isAckRequired ( "error" ) )
        {
            result.add ( State.ERROR_ACK );
        }
        if ( info.isManual () )
        {
            result.add ( State.MANUAL );
        }
        if ( info.isBlocked () )
        {
            result.add ( State.BLOCK );
        }
        if ( !info.isConnected () )
        {
            result.add ( State.DISCONNECTED );
        }
        if ( info.isWarning () )
        {
            result.add ( State.WARNING );
        }
        if ( info.isAlarm () )
        {
            result.add ( State.ALARM );
        }
        if ( info.isError () )
        {
            result.add ( State.ERROR );
        }

        return result;
    }
}