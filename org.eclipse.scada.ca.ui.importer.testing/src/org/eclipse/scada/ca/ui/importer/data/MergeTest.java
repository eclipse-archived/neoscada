/*******************************************************************************
 * Copyright (c) 2010, 2015 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *     IBH SYSTEMS GmbH - relocate diff helper
 *******************************************************************************/
package org.eclipse.scada.ca.ui.importer.data;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.scada.ca.data.DiffEntry;
import org.eclipse.scada.ca.utils.DiffController;
import org.junit.Before;
import org.junit.Test;

public class MergeTest
{

    private DiffController mergeController;

    @Before
    public void setup ()
    {
        this.mergeController = new DiffController ();
    }

    @Test
    public void test1 ()
    {
        // local data
        final Map<String, Map<String, Map<String, String>>> localData = new HashMap<String, Map<String, Map<String, String>>> ();
        final HashMap<String, Map<String, String>> factoryA = new HashMap<String, Map<String, String>> ();

        final Map<String, String> cfgA1 = new HashMap<String, String> ();
        cfgA1.put ( "foo", "bar" );
        factoryA.put ( "cfg1", cfgA1 );

        localData.put ( "factoryA", factoryA );

        // remote data

        final Map<String, Map<String, Map<String, String>>> remoteData = new HashMap<String, Map<String, Map<String, String>>> ();
        final HashMap<String, Map<String, String>> factoryB = new HashMap<String, Map<String, String>> ();

        final Map<String, String> cfgB1 = new HashMap<String, String> ();
        cfgB1.put ( "foo", "bar" );
        factoryB.put ( "cfg1", cfgB1 );

        remoteData.put ( "factoryB", factoryB );

        this.mergeController.setLocalData ( localData );
        this.mergeController.setRemoteData ( remoteData );

        final Collection<DiffEntry> result = this.mergeController.merge ( null );
        System.out.println ( result );
    }
}
