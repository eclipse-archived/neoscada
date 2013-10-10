/*******************************************************************************
 * Copyright (c) 2010, 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.client.common;

import org.eclipse.scada.core.Variant;
import org.eclipse.scada.core.data.SubscriptionState;
import org.eclipse.scada.da.client.DataItemValue;
import org.eclipse.scada.da.client.DataItemValue.Builder;
import org.junit.Assert;
import org.junit.Test;

public class DataItemValueTest
{
    @Test
    public void test1 ()
    {
        final DataItemValue div1 = DataItemValue.DISCONNECTED;
        final DataItemValue div2 = DataItemValue.DISCONNECTED;

        Assert.assertEquals ( div1, div2 );
        Assert.assertEquals ( div2, div1 );
    }

    @Test
    public void test2 ()
    {
        final Builder div1 = new Builder ();
        final Builder div2 = new Builder ();

        Assert.assertEquals ( div1.build (), div2.build () );
        Assert.assertEquals ( div2.build (), div1.build () );
    }

    @Test
    public void test3 ()
    {
        final Builder div1 = new Builder ();
        div1.setValue ( Variant.valueOf ( 1 ) );

        final Builder div2 = new Builder ();
        div2.setValue ( Variant.valueOf ( 1 ) );

        Assert.assertEquals ( div1.build (), div2.build () );
        Assert.assertEquals ( div2.build (), div1.build () );
    }

    @Test
    public void test4 ()
    {
        final Builder div1 = new Builder ();
        div1.setValue ( Variant.valueOf ( 1 ) );
        div1.setSubscriptionState ( SubscriptionState.CONNECTED );

        final Builder div2 = new Builder ();
        div2.setValue ( Variant.valueOf ( 1 ) );
        div2.setSubscriptionState ( SubscriptionState.CONNECTED );

        Assert.assertEquals ( div1.build (), div2.build () );
        Assert.assertEquals ( div2.build (), div1.build () );
    }

    @Test
    public void test5 ()
    {
        final Builder div1 = new Builder ();
        div1.setValue ( Variant.valueOf ( 1 ) );
        div1.setSubscriptionState ( SubscriptionState.CONNECTED );
        div1.setAttribute ( "foo", Variant.valueOf ( "bar" ) );

        final Builder div2 = new Builder ();
        div2.setValue ( Variant.valueOf ( 1 ) );
        div2.setSubscriptionState ( SubscriptionState.CONNECTED );
        div2.setAttribute ( "foo", Variant.valueOf ( "bar" ) );

        Assert.assertEquals ( div1.build (), div2.build () );
        Assert.assertEquals ( div2.build (), div1.build () );
    }

    @Test
    public void testFalse1 ()
    {
        final Builder div1 = new Builder ();
        div1.setValue ( Variant.valueOf ( 1 ) );
        div1.setSubscriptionState ( SubscriptionState.CONNECTED );
        div1.setAttribute ( "foo", Variant.valueOf ( "bar" ) );

        final Builder div2 = new Builder ();
        div2.setValue ( Variant.valueOf ( 1 ) );
        div2.setSubscriptionState ( SubscriptionState.CONNECTED );
        div2.setAttribute ( "bar", Variant.valueOf ( "foo" ) );

        Assert.assertFalse ( div1.equals ( div2 ) );
        Assert.assertFalse ( div2.equals ( div1 ) );
    }

    @Test
    public void testFalse2 ()
    {
        final Builder div1 = new Builder ();
        div1.setValue ( Variant.valueOf ( 1 ) );
        div1.setSubscriptionState ( SubscriptionState.CONNECTED );
        div1.setAttribute ( "foo", Variant.valueOf ( "bar" ) );

        final Builder div2 = new Builder ();
        div2.setValue ( Variant.valueOf ( 1 ) );
        div2.setSubscriptionState ( SubscriptionState.DISCONNECTED );
        div2.setAttribute ( "foo", Variant.valueOf ( "bar" ) );

        Assert.assertFalse ( div1.equals ( div2 ) );
        Assert.assertFalse ( div2.equals ( div1 ) );
    }

    @Test
    public void testFalse3 ()
    {
        final Builder div1 = new Builder ();
        div1.setValue ( Variant.valueOf ( 1 ) );
        div1.setSubscriptionState ( SubscriptionState.CONNECTED );
        div1.setAttribute ( "foo", Variant.valueOf ( "bar" ) );

        final Builder div2 = new Builder ();
        div2.setSubscriptionState ( SubscriptionState.CONNECTED );
        div2.setAttribute ( "foo", Variant.valueOf ( "bar" ) );

        Assert.assertFalse ( div1.equals ( div2 ) );
        Assert.assertFalse ( div2.equals ( div1 ) );
    }

    @Test
    public void testFalse4 ()
    {
        final Builder div1 = new Builder ();
        div1.setValue ( Variant.valueOf ( 1 ) );
        div1.setSubscriptionState ( SubscriptionState.CONNECTED );
        div1.setAttribute ( "foo", Variant.valueOf ( "bar" ) );

        final Builder div2 = new Builder ();
        div2.setValue ( Variant.valueOf ( 1 ) );
        div2.setSubscriptionState ( SubscriptionState.CONNECTED );
        div2.setAttribute ( "foo", Variant.valueOf ( "bar" ) );

        Assert.assertFalse ( div1.equals ( div2 ) );
        Assert.assertFalse ( div2.equals ( div1 ) );
    }
}
