/*******************************************************************************
 * Copyright (c) 2013 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.build.helper;

import org.junit.Assert;
import org.junit.Test;

public class VersionTest
{
    @Test
    public void test1 ()
    {
        Assert.assertEquals ( "1.0.0", VersionPropertyMojo.makeVersion ( "1.0.0" ) );
        Assert.assertEquals ( "1.0.0", VersionPropertyMojo.makeVersion ( "1.0.0-SNAPSHOT" ) );
        Assert.assertEquals ( "1.0.0", VersionPropertyMojo.makeVersion ( "1" ) );
        Assert.assertEquals ( "1.0.0-M1", VersionPropertyMojo.makeVersion ( "1.0.0-M1" ) );
        Assert.assertEquals ( "1.0.0", VersionPropertyMojo.makeVersion ( "1.0.0.v123" ) );
    }
}
