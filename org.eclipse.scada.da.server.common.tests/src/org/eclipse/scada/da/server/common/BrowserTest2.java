/*******************************************************************************
 * Copyright (c) 2010 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.server.common;

import java.util.HashMap;

import org.eclipse.scada.core.Variant;
import org.eclipse.scada.da.server.browser.common.query.IDNameProvider;
import org.eclipse.scada.da.server.browser.common.query.ItemDescriptor;
import org.eclipse.scada.da.server.browser.common.query.SplitGroupProvider;
import org.eclipse.scada.da.server.browser.common.query.SplitNameProvider;
import org.junit.Assert;
import org.junit.Test;
import org.eclipse.scada.da.server.common.DataItemInputCommon;

public class BrowserTest2
{
    @Test
    public void test1 ()
    {
        Assert.assertEquals ( "", testName ( "", 0, 2 ) );
        Assert.assertEquals ( "", testName ( "", 2, 0 ) );
        Assert.assertEquals ( "", testName ( "", 2, 2 ) );
        Assert.assertEquals ( "", testName ( "", 0, 0 ) );

        Assert.assertEquals ( "", testName ( "this.id.the.id", 0, 0 ) );

        Assert.assertEquals ( "the.id", testName ( "this.is.the.id", 0, 2 ) );
        Assert.assertEquals ( "this.is", testName ( "this.is.the.id", 2, 0 ) );

        Assert.assertEquals ( "this.is.the.id", testName ( "this.is.the.id", 10, 0 ) );
        Assert.assertEquals ( "this.is.the.id", testName ( "this.is.the.id", 0, 10 ) );
    }

    private String testName ( final String itemId, final int fromStart, final int fromEnd )
    {
        final SplitNameProvider snp = new SplitNameProvider ( new IDNameProvider (), "\\.", fromStart, fromEnd, "." );
        return snp.getName ( new ItemDescriptor ( new DataItemInputCommon ( itemId ), new HashMap<String, Variant> () ) );
    }

    @Test
    public void test2 ()
    {
        Assert.assertArrayEquals ( new String[] { "this", "is", "the", "id" }, testGroup ( "this.is.the.id", 0, 0 ) );

        Assert.assertArrayEquals ( new String[] { "this", "is", "the" }, testGroup ( "this.is.the.id", 0, 1 ) );
        Assert.assertArrayEquals ( new String[] { "this", "is" }, testGroup ( "this.is.the.id", 0, 2 ) );

        Assert.assertArrayEquals ( new String[] { "is", "the", "id" }, testGroup ( "this.is.the.id", 1, 0 ) );
        Assert.assertArrayEquals ( new String[] { "the", "id" }, testGroup ( "this.is.the.id", 2, 0 ) );

        Assert.assertArrayEquals ( new String[] {}, testGroup ( "the.id", 2, 0 ) );
        Assert.assertArrayEquals ( new String[] {}, testGroup ( "the", 2, 0 ) );
        Assert.assertArrayEquals ( new String[] {}, testGroup ( "", 2, 0 ) );
    }

    private String[] testGroup ( final String itemId, final int skipPrefix, final int skipSuffix )
    {
        final SplitGroupProvider sgp = new SplitGroupProvider ( new IDNameProvider (), "\\.", skipPrefix, skipSuffix );
        return sgp.getGrouping ( new ItemDescriptor ( new DataItemInputCommon ( itemId ), new HashMap<String, Variant> () ) );
    }
}
