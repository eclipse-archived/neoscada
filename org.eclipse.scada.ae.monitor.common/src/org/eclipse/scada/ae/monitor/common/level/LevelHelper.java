/*******************************************************************************
 * Copyright (c) 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.ae.monitor.common.level;

public class LevelHelper
{
    public static boolean isFailure ( final double value, final double limit, final boolean lowerOk, final boolean includedOk )
    {
        final boolean f = value > limit && lowerOk || value < limit && !lowerOk;
        if ( f )
        {
            return true;
        }

        return ! ( value != limit || includedOk );
    }
}
