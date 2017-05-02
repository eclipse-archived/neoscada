/*******************************************************************************
 * Copyright (c) 2016 Red Hat Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Red Hat Inc - initial API and implementation
 *******************************************************************************/
package org.eclipse.neoscada.protocol.iec60870;

import static org.eclipse.neoscada.protocol.iec60870.asdu.types.ASDUAddress.fromArray;
import static org.eclipse.neoscada.protocol.iec60870.asdu.types.ASDUAddress.fromString;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AsduAddressTest
{
    @Test
    public void test1 ()
    {
        assertEquals ( fromString ( "0-1" ), fromString ( "0-1" ) );
    }

    @Test
    public void test2 ()
    {
        assertEquals ( fromArray ( new int[] { 0, 1 } ), fromString ( "0-1" ) );
    }

    @Test
    public void test3 ()
    {
        assertEquals ( 1, fromString ( "0-1" ).getAddress () );
        assertEquals ( 2, fromString ( "0-2" ).getAddress () );
        assertEquals ( 256, fromString ( "1-0" ).getAddress () );
    }
}
