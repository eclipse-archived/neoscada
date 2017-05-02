/*******************************************************************************
 * Copyright (c) 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.utils.filter.tests;

import org.eclipse.scada.utils.filter.Assertion;
import org.eclipse.scada.utils.filter.Filter;
import org.eclipse.scada.utils.filter.FilterAssertion;
import org.eclipse.scada.utils.filter.FilterExpression;
import org.eclipse.scada.utils.filter.FilterParser;
import org.eclipse.scada.utils.filter.Operator;
import org.junit.Assert;
import org.junit.Test;

public class FilterTest
{
    @Test
    public void test1 ()
    {
        final Filter filter = new FilterParser ( "(foo=bar)" ).getFilter ();

        assertAssertion ( filter, "foo", Assertion.EQUALITY, "bar" );
    }

    private void assertAssertion ( final Filter filter, final String key, final Assertion assertion, final String value )
    {
        Assert.assertTrue ( filter.isAssertion () );

        Assert.assertEquals ( key, ( (FilterAssertion)filter ).getAttribute () );
        Assert.assertEquals ( assertion, ( (FilterAssertion)filter ).getAssertion () );
        Assert.assertEquals ( value, ( (FilterAssertion)filter ).getValue () );
    }

    @Test
    public void test2 ()
    {
        final Filter filter = new FilterParser ( "(&(foo=bar)(foo2=bar2))" ).getFilter ();

        Assert.assertTrue ( filter.isExpression () );

        Assert.assertEquals ( Operator.AND, ( (FilterExpression)filter ).getOperator () );
        Assert.assertEquals ( 2, ( (FilterExpression)filter ).getFilterSet ().size () );

        assertAssertion ( ( (FilterExpression)filter ).getFilterSet ().get ( 0 ), "foo", Assertion.EQUALITY, "bar" );
        assertAssertion ( ( (FilterExpression)filter ).getFilterSet ().get ( 1 ), "foo2", Assertion.EQUALITY, "bar2" );
    }

    @Test
    public void test2a ()
    {
        final Filter filter = new FilterParser ( "(&(foo=bar))" ).getFilter ();

        Assert.assertTrue ( filter.isExpression () );

        Assert.assertEquals ( Operator.AND, ( (FilterExpression)filter ).getOperator () );
        Assert.assertEquals ( 1, ( (FilterExpression)filter ).getFilterSet ().size () );

        assertAssertion ( ( (FilterExpression)filter ).getFilterSet ().get ( 0 ), "foo", Assertion.EQUALITY, "bar" );
    }

    @Test
    public void test2b ()
    {
        final Filter filter = new FilterParser ( "(&(foo=bar o meter))" ).getFilter ();

        Assert.assertTrue ( filter.isExpression () );

        Assert.assertEquals ( Operator.AND, ( (FilterExpression)filter ).getOperator () );
        Assert.assertEquals ( 1, ( (FilterExpression)filter ).getFilterSet ().size () );

        assertAssertion ( ( (FilterExpression)filter ).getFilterSet ().get ( 0 ), "foo", Assertion.EQUALITY, "bar o meter" );
    }

    @Test
    public void test2c ()
    {
        final Filter filter = new FilterParser ( "(&(sourceTimestamp>=2014-08-25 17:59:05.042))" ).getFilter ();

        Assert.assertTrue ( filter.isExpression () );

        Assert.assertEquals ( Operator.AND, ( (FilterExpression)filter ).getOperator () );
        Assert.assertEquals ( 1, ( (FilterExpression)filter ).getFilterSet ().size () );

        assertAssertion ( ( (FilterExpression)filter ).getFilterSet ().get ( 0 ), "sourceTimestamp", Assertion.GREATEREQ, "2014-08-25 17:59:05.042" );
    }
}
