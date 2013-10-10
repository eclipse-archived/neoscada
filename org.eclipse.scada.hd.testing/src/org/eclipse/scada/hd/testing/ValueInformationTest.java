/*******************************************************************************
 * Copyright (c) 2009, 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.hd.testing;

import java.util.Calendar;

import org.eclipse.scada.hd.data.ValueInformation;
import org.junit.Assert;
import org.junit.Test;

public class ValueInformationTest
{
    @Test
    public void equals1 ()
    {
        final Calendar start = Calendar.getInstance ();
        start.set ( 2000, 1, 1 );
        final Calendar end = (Calendar)start.clone ();
        end.add ( Calendar.MINUTE, 1 );

        final ValueInformation vi1 = new ValueInformation ( 1.0, 0.0, start.getTimeInMillis (), end.getTimeInMillis (), 1 );
        final ValueInformation vi2 = new ValueInformation ( 1.0, 0.0, start.getTimeInMillis (), end.getTimeInMillis (), 1 );

        Assert.assertEquals ( "Basic equality", vi1, vi2 );
    }

    /**
     * Test if the calendar can be changed without changing the VI instance
     */
    @Test
    public void equals2 ()
    {
        final Calendar start = Calendar.getInstance ();
        start.set ( 2000, 1, 1 );
        final Calendar end = (Calendar)start.clone ();
        end.add ( Calendar.MINUTE, 1 );

        final ValueInformation vi1 = new ValueInformation ( 1.0, 0.0, start.getTimeInMillis (), end.getTimeInMillis (), 1 );

        start.set ( 2001, 1, 1 );

        final ValueInformation vi2 = new ValueInformation ( 1.0, 0.0, start.getTimeInMillis (), end.getTimeInMillis (), 1 );

        Assert.assertFalse ( "Should not be equal", vi1.equals ( vi2 ) );
    }
}
