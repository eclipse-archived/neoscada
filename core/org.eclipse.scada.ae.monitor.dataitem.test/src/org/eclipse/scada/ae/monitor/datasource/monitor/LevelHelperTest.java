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
package org.eclipse.scada.ae.monitor.datasource.monitor;

import org.eclipse.scada.ae.monitor.common.level.LevelHelper;
import org.junit.Assert;
import org.junit.Test;

public class LevelHelperTest
{

    protected void test ( final boolean expected, final double value, final double limit, final boolean lowerOk, final boolean includedOk )
    {
        final boolean f = LevelHelper.isFailure ( value, limit, lowerOk, includedOk );
        Assert.assertEquals ( expected, f );
    }

    @Test
    public void test1 ()
    {
        test ( false, 0, 10, true, true );
        test ( true, 20, 10, true, true );
    }

    @Test
    public void test2 ()
    {
        test ( true, 0, 10, false, true );
        test ( false, 20, 10, false, true );
    }

    @Test
    public void test3 ()
    {
        test ( false, 10, 10, false, true );
        test ( true, 10, 10, false, false );

        test ( false, 10, 10, true, true );
        test ( true, 10, 10, true, false );
    }
}
