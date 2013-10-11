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
package org.eclipse.scada.ae.ui.views.tester;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.scada.ae.data.MonitorStatus;
import org.eclipse.scada.ae.ui.views.handler.AckInformation;
import org.eclipse.scada.ui.databinding.AdapterHelper;

public class AckInformationTester extends PropertyTester
{

    @Override
    public boolean test ( final Object receiver, final String property, final Object[] args, final Object expectedValue )
    {
        final AckInformation ackInformation = AdapterHelper.adapt ( receiver, AckInformation.class );
        if ( ackInformation == null )
        {
            return false;
        }
        if ( "status".equals ( property ) )
        {
            return testStatus ( ackInformation, expectedValue );
        }

        return false;
    }

    private boolean testStatus ( final AckInformation monitor, final Object expectedValue )
    {
        if ( expectedValue == null )
        {
            return false;
        }

        final String expectedState = expectedValue.toString ();

        final MonitorStatus status = monitor.getMonitorStatus ();

        return status.toString ().equals ( expectedState );
    }
}
