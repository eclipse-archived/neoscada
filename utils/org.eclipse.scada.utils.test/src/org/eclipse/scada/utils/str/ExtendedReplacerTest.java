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
package org.eclipse.scada.utils.str;

import java.util.Properties;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ExtendedReplacerTest
{

    private Properties props;

    private ExtendedPropertiesReplacer source;

    @Before
    public void setup ()
    {
        this.props = new Properties ();
        this.props.put ( "foo", "bar" );
        this.props.put ( "foo2", "foo" );
        this.props.put ( "one", 1 );
        this.props.put ( "test", "blubb" );

        this.source = new ExtendedPropertiesReplacer ( this.props );
    }

    @Test
    public void testNormal ()
    {
        test ( "${foo}", "bar" );
        test ( "${foo}${foo}", "barbar" );
    }

    @Test
    public void testDefault ()
    {
        test ( "${foo:bar2}", "bar" );
        test ( "${foo3:bar3}", "bar3" );
    }

    @Test
    public void testDefault2 ()
    {
        test ( "${:bar2}", "bar2" );
        test ( "${foo3:}", "" );
        test ( "${:}", "" );
    }

    @Test
    public void testDefaultNested ()
    {
        test ( "${foo:${test}}", "bar" );
        test ( "${foo3:${test}}", "blubb" );
    }

    @Test
    public void testDefaultNested2 ()
    {
        test ( "${foo:${test}} ${foo:${test}}", "bar bar" );
        test ( "${foo3:${test}} ${foo3:${test}}", "blubb blubb" );
    }

    @Test
    public void testNested ()
    {
        test ( "${${foo2}}", "bar" );
    }

    @Test
    public void testNested2 ()
    {
        test ( "${${foo2}} ${${foo2}}", "bar bar" );
    }

    private void test ( final String string, final String expected )
    {
        final String result = StringReplacer.replace ( string, this.source, StringReplacer.DEFAULT_PATTERN );
        Assert.assertEquals ( expected, result );
    }
}
