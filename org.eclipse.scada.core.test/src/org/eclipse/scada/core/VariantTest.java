/*******************************************************************************
 * Copyright (c) 2006, 2014 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     IBH SYSTEMS GmbH - rewritten most of the test in order to test more variants
 *******************************************************************************/
package org.eclipse.scada.core;

import org.junit.Assert;
import org.junit.Test;

public class VariantTest
{

    /**
     * Assert two variants in both directions
     * 
     * @param v1
     *            value one
     * @param v2
     *            value two
     * @param equal
     *            expected to be equal
     */
    private void compareVariant ( final Variant v1, final Variant v2, final boolean equal )
    {
        if ( equal )
        {
            Assert.assertTrue ( v1.equals ( v2 ) );
            Assert.assertTrue ( v2.equals ( v1 ) );
        }
        else
        {
            Assert.assertFalse ( v1.equals ( v2 ) );
            Assert.assertFalse ( v2.equals ( v1 ) );
        }
    }

    private void testCompare ( final Object v1, final Object v2, final boolean expectEqual )
    {
        compareVariant ( Variant.valueOf ( v1 ), Variant.valueOf ( v2 ), expectEqual );
        compareVariant ( new Variant ( v1 ), new Variant ( v2 ), expectEqual );
    }

    @Test
    public void testVariantCompareEqualSameType () throws Exception
    {
        testCompare ( null, null, true );

        testCompare ( 0, 0, true );
        testCompare ( 1, 1, true );
        testCompare ( -1, -01, true );

        testCompare ( 0L, 0L, true );
        testCompare ( 1L, 1L, true );
        testCompare ( -1L, -1L, true );

        testCompare ( 0.0, 0.0, true );
        testCompare ( 1.0, 1.0, true );
        testCompare ( -1.0, -1.0, true );
        testCompare ( 1.5, 1.5, true );
        testCompare ( -1.5, -1.5, true );

        testCompare ( "", "", true );
        testCompare ( "foo", "foo", true );
        testCompare ( "bar", "bar", true );

        testCompare ( false, false, true );
        testCompare ( true, true, true );
    }

    @Test
    public void testVariantCompareNullNotEqual () throws Exception
    {
        testCompare ( null, 0, false );
        testCompare ( null, 0L, false );
        testCompare ( null, 0.0, false );
        testCompare ( null, false, false );
        testCompare ( null, true, false );
        testCompare ( null, "", false );
    }

    @Test
    public void testVariantCompareBooleanNotEqual () throws Exception
    {
        testCompare ( false, 1, false );
        testCompare ( false, 1L, false );
        testCompare ( false, 1.0, false );
        testCompare ( false, "1", false );
        testCompare ( false, true, false );

        testCompare ( true, 0, false );
        testCompare ( true, 0L, false );
        testCompare ( true, 0.0, false );
        testCompare ( true, "0", false );
        testCompare ( true, false, false );
    }

    @Test
    public void testVariantCompareIntNotEqual () throws Exception
    {
        testCompare ( 0, 1, false );
        testCompare ( 0, 1L, false );
        testCompare ( 0, 1.0, false );
        testCompare ( 0, "1", false );
        testCompare ( 0, true, false );
    }

    @Test
    public void testVariantCompareLongNotEqual () throws Exception
    {
        testCompare ( 0L, 1, false );
        testCompare ( 0L, 1L, false );
        testCompare ( 0L, 1.0, false );
        testCompare ( 0L, "1", false );
        testCompare ( 0L, true, false );
    }

    @Test
    public void testVariantCompareDoubleNotEqual () throws Exception
    {
        testCompare ( 0.0, 1, false );
        testCompare ( 0.0, 1L, false );
        testCompare ( 0.0, "1", false );
        testCompare ( 0.0, true, false );

        testCompare ( 0.0, -1.5, false );
        testCompare ( 0.0, 1.5, false );
    }

    @Test
    public void testVariantCompareStringNotEqual () throws Exception
    {
        testCompare ( "0", 1, false );
        testCompare ( "0", 1L, false );
        testCompare ( "0", "1", false );
        testCompare ( "0", true, false );
    }

    @Test
    public void testVariantCompareIntDifferentType () throws Exception
    {
        testCompare ( 0, 0L, true );
        testCompare ( 1, 1L, true );

        testCompare ( 0, 0.0, true );
        testCompare ( 1, 1.0, true );

        testCompare ( 0, false, true );
        testCompare ( 1, true, true );

        testCompare ( 0, "0", true );
        testCompare ( 1, "1", true );
    }

    @Test
    public void testVariantCompareLongDifferentType () throws Exception
    {
        testCompare ( 0L, 0, true );
        testCompare ( 1L, 1, true );

        testCompare ( 0L, 0.0, true );
        testCompare ( 1L, 1.0, true );

        testCompare ( 0L, false, true );
        testCompare ( 1L, true, true );

        testCompare ( 0L, "0", true );
        testCompare ( 1L, "1", true );
    }

    @Test
    public void testVariantCompareBooleanDifferentType () throws Exception
    {
        testCompare ( false, 0, true );
        testCompare ( false, 0.0, true );
        testCompare ( false, 0L, true );

        testCompare ( true, 1, true );
        testCompare ( true, 1L, true );
        testCompare ( true, 1.0, true );

        testCompare ( true, -1.5, true );
        testCompare ( true, 1.5, true );

        testCompare ( true, -1, true );
        testCompare ( true, -1L, true );
        testCompare ( true, -1.0, true );

        testCompare ( false, "", true );
        testCompare ( false, "foobar", true );
        testCompare ( false, "false", true );
        testCompare ( false, "0", true );

        testCompare ( true, "true", true );
        testCompare ( true, "1", true );

        testCompare ( true, "0", false );
    }

    @Test
    public void testVariantCompareDoubleDifferentType () throws Exception
    {
        testCompare ( 0.0, 0, true );
        testCompare ( 1.0, 1, true );

        testCompare ( 0.0, 0L, true );
        testCompare ( 1.0, 1L, true );

        testCompare ( 0.0, false, true );
        testCompare ( 1.0, true, true );

        testCompare ( 0.0, "0", true );
        testCompare ( 1.0, "1", true );

        testCompare ( 0.0, "0.0", true );
        testCompare ( 1.0, "1.0", true );

        testCompare ( 0.0, "", false );
        testCompare ( 1.0, "", false );

        testCompare ( 0.0, "1.0", false );
        testCompare ( 1.5, "1.0", false );
        testCompare ( -1.0, "1.0", false );
    }

    @Test
    public void testVariantCompareStringDifferntType () throws Exception
    {
        testCompare ( "0", 0, true );
        testCompare ( "0.0", 0, false );
        testCompare ( "0.0", 0.0, true );
        testCompare ( "0", 0.0, true );

        testCompare ( "1", 1, true );
        testCompare ( "1.0", 1, false );
        testCompare ( "1.0", 1.0, true );

        testCompare ( "1.5", 1.5, true );
        testCompare ( "1", 1.5, false );

        testCompare ( "foo", 1.5, false );
        testCompare ( "foo", 1, false );
        testCompare ( "foo", 1L, false );
        testCompare ( "foo", 0, false );

        testCompare ( "false", false, true );
        testCompare ( "true", true, true );
    }

    @Test
    public void testNumberIssue ()
    {
        final Variant v1 = new Variant ( 1.1 );
        final Variant v2 = new Variant ( new Double ( 1.1 ) );

        compareVariant ( v1, v2, true );
    }
}
