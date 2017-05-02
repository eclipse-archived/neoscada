/*******************************************************************************
 * Copyright (c) 2006, 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.core;

import org.eclipse.scada.core.Variant;
import org.junit.Assert;
import org.junit.Test;

public class VariantCompareTest
{
    @Test
    public void testEqual ()
    {
        checkCompare ( 0, 0, 0 );
        checkCompare ( "0", 0, 0 );
        checkCompare ( 0, "0", 0 );
        checkCompare ( "0", "0", 0 );

        checkCompare ( 0L, 0L, 0 );
        checkCompare ( "0", 0L, 0 );
        checkCompare ( 0L, "0", 0 );

        checkCompare ( true, true, 0 );
        checkCompare ( "true", true, 0 );
        checkCompare ( true, "true", 0 );
        checkCompare ( "true", "true", 0 );

        checkCompare ( "true", "true", 0 );
    }

    private void checkCompare ( final Object o1, final Object o2, final int expected )
    {
        Assert.assertEquals ( expected, Variant.valueOf ( o1 ).compareTo ( Variant.valueOf ( o2 ) ) );
    }
}
