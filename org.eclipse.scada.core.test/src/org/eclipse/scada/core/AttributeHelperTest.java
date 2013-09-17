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

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.scada.core.AttributesHelper;
import org.eclipse.scada.core.Variant;
import org.junit.Assert;
import org.junit.Test;

public class AttributeHelperTest
{
    @Test
    public void testDiff1 ()
    {
        final Map<String, Variant> map1 = new HashMap<String, Variant> ();
        map1.put ( "A", Variant.valueOf ( 1 ) );
        map1.put ( "B", Variant.valueOf ( 1 ) );
        map1.put ( "C", Variant.valueOf ( 1 ) );

        final Map<String, Variant> map2 = new HashMap<String, Variant> ();
        map2.put ( "B", Variant.valueOf ( 1 ) );
        map2.put ( "C", Variant.valueOf ( 2 ) );
        map2.put ( "D", Variant.valueOf ( 2 ) );

        final Map<String, Variant> diff = AttributesHelper.diff ( map1, map2 );

        final Map<String, Variant> expected = new HashMap<String, Variant> ();
        expected.put ( "A", null );
        expected.put ( "C", Variant.valueOf ( 2 ) );
        expected.put ( "D", Variant.valueOf ( 2 ) );

        Assert.assertEquals ( expected, diff );
    }

    @Test
    public void testDiff2 ()
    {
        final Map<String, Variant> diff = AttributesHelper.diff ( null, null );

        Assert.assertEquals ( Collections.emptyMap (), diff );
    }
}
