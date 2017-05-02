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
package org.eclipse.scada.utils.lang;

import org.eclipse.scada.utils.lang.BitArray;
import org.junit.Test;

public class BitArrayTest
{
    @Test
    public void test1 ()
    {
        final BitArray ba = new BitArray ();

        ba.set ( 0, true );
        ba.set ( 1, true );
        ba.set ( 8, true );
        System.out.println ( ba );
        ba.set ( 1, false );
        ba.set ( 8, false );
        System.out.println ( ba );
    }
}
