/*******************************************************************************
 * Copyright (c) 2013, 2016 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.configuration.world.lib.oscar;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class OscarContext
{

    private static boolean useTreeMaps ()
    {
        return !Boolean.getBoolean ( "org.eclipse.scada.configuration.world.lib.oscar.useHashMaps" );
    }

    private static <T> Map<String, T> createMap ()
    {
        return createMap ( -1 );
    }

    private static <T> Map<String, T> createMap ( final int initialHashSize )
    {
        if ( useTreeMaps () )
        {
            return new TreeMap<> ();
        }
        else if ( initialHashSize > 0 )
        {
            return new HashMap<> ( initialHashSize );
        }
        else
        {
            return new HashMap<> ();
        }
    }

    private static Set<String> createSet ()
    {
        if ( useTreeMaps () )
        {
            return new TreeSet<> ();
        }
        else
        {
            return new HashSet<> ();
        }
    }

    private final Map<String, Map<String, Map<String, String>>> data = createMap ();

    private final Map<String, Set<String>> ignoreFields = createMap ();

    public void addIgnoreField ( final String factoryId, final String fieldName )
    {
        Set<String> fields = this.ignoreFields.get ( factoryId );
        if ( fields == null )
        {
            fields = createSet ();
            this.ignoreFields.put ( factoryId, fields );
        }
        fields.add ( fieldName );
    }

    public void addIgnoreFields ( final String factoryId, final String... fieldNames )
    {
        Set<String> fields = this.ignoreFields.get ( factoryId );
        if ( fields == null )
        {
            fields = createSet ();
            this.ignoreFields.put ( factoryId, fields );
        }
        fields.addAll ( Arrays.asList ( fieldNames ) );
    }

    public void addData ( final String factoryId, final String configurationId, final Map<String, String> data )
    {
        Map<String, Map<String, String>> factoryData = this.data.get ( factoryId );
        if ( factoryData == null )
        {
            factoryData = createMap ( 5_000 );
            this.data.put ( factoryId, factoryData );
        }

        if ( useTreeMaps () && ! ( data instanceof TreeMap ) )
        {
            factoryData.put ( configurationId, new TreeMap<> ( data ) );
        }
        else
        {
            factoryData.put ( configurationId, data );
        }
    }

    public Map<String, Map<String, Map<String, String>>> getData ()
    {
        return this.data;
    }

    public Map<String, Set<String>> getIgnoreFields ()
    {
        return this.ignoreFields;
    }
}
