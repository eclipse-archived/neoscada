/*******************************************************************************
 * Copyright (c) 2006, 2011 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.utils.str;

import java.util.Properties;

import org.eclipse.scada.utils.str.StringReplacer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ReplacerTest
{

    private Properties props;

    @Before
    public void setup ()
    {
        this.props = new Properties ();
        this.props.put ( "foo", "bar" );
        this.props.put ( "one", 1 );
        this.props.put ( "test", "blubb" );
    }

    @Test
    public void replace1 ()
    {
        Assert.assertEquals ( "", StringReplacer.replace ( "", this.props ) );
        Assert.assertEquals ( "foo", StringReplacer.replace ( "foo", this.props ) );
        Assert.assertEquals ( "bar", StringReplacer.replace ( "${foo}", this.props ) );
        Assert.assertEquals ( "barbar", StringReplacer.replace ( "${foo}${foo}", this.props ) );
        Assert.assertEquals ( "1", StringReplacer.replace ( "${one}", this.props ) );
        Assert.assertEquals ( "${two}", StringReplacer.replace ( "${two}", this.props ) );
        Assert.assertEquals ( "This is foo bar!", StringReplacer.replace ( "This is foo ${foo}!", this.props ) );
    }
}
