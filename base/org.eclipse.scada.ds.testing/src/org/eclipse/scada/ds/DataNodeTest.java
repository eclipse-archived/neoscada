/*******************************************************************************
 * Copyright (c) 2011, 2010 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.ds;

import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;

import org.eclipse.scada.ds.DataNode;
import org.junit.Assert;
import org.junit.Test;

public class DataNodeTest
{

    protected void testSerialize ( final Serializable data ) throws IOException, ClassNotFoundException
    {
        final DataNode node = new DataNode ( "id", data );

        final Object result = node.getDataAsObject ();

        Assert.assertEquals ( data, result );
        Assert.assertNotSame ( data, result );
    }

    @Test
    public void test1 () throws IOException, ClassNotFoundException
    {
        testSerialize ( "Hello World" );
    }

    @Test
    public void test2 () throws IOException, ClassNotFoundException
    {
        final HashMap<String, String> data = new HashMap<String, String> ();

        data.put ( "foo", "bar" );
        data.put ( "question", "42" );

        testSerialize ( data );
    }
}
