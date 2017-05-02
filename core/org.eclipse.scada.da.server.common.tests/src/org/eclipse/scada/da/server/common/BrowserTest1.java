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
import org.junit.Test;
import org.eclipse.scada.da.server.common.DataItemInputCommon;

public class BrowserTest1
{

    @Test
    public void test1 ()
    {
        final SplitGroupProvider sgp = new SplitGroupProvider ( new IDNameProvider (), "\\.", 0, 2 );

        final ItemDescriptor desc = new ItemDescriptor ( new DataItemInputCommon ( "this.is.the.id" ), new HashMap<String, Variant> () );
        for ( int i = 0; i < 1000 * 1000; i++ )
        {
            sgp.getGrouping ( desc );
        }
    }
}
