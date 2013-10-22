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
package org.eclipse.scada.configuration.generator.world.oscar;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class OscarContext
{

    private final Map<String, Map<String, Map<String, String>>> data = new HashMap<> ();

    private final Map<String, Set<String>> ignoreFields = new HashMap<> ();

    public void addIgnoreField ( final String factoryId, final String fieldName )
    {
        Set<String> fields = this.ignoreFields.get ( factoryId );
        if ( fields == null )
        {
            fields = new HashSet<> ();
            this.ignoreFields.put ( factoryId, fields );
        }
        fields.add ( fieldName );
    }

    public void addIgnoreFields ( final String factoryId, final String... fieldNames )
    {
        Set<String> fields = this.ignoreFields.get ( factoryId );
        if ( fields == null )
        {
            fields = new HashSet<> ();
            this.ignoreFields.put ( factoryId, fields );
        }
        fields.addAll ( Arrays.asList ( fieldNames ) );
    }

    public void addData ( final String factoryId, final String configurationId, final Map<String, String> data )
    {
        Map<String, Map<String, String>> factoryData = this.data.get ( factoryId );
        if ( factoryData == null )
        {
            factoryData = new HashMap<> ();
            this.data.put ( factoryId, factoryData );
        }
        factoryData.put ( configurationId, data );
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
