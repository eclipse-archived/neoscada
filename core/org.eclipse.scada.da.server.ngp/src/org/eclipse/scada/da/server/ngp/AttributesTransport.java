/*******************************************************************************
 * Copyright (c) 2012, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *******************************************************************************/
package org.eclipse.scada.da.server.ngp;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.scada.core.Variant;

public class AttributesTransport
{
    private final Map<String, Variant> addedOrUpdated;

    private final Set<String> removed;

    public AttributesTransport ( final Map<String, Variant> attributes )
    {
        if ( attributes == null )
        {
            this.addedOrUpdated = Collections.emptyMap ();
            this.removed = Collections.emptySet ();
        }
        else
        {
            this.addedOrUpdated = new HashMap<String, Variant> ();
            this.removed = new HashSet<String> ();

            for ( final Map.Entry<String, Variant> entry : attributes.entrySet () )
            {
                if ( entry.getValue () == null )
                {
                    this.removed.add ( entry.getKey () );
                }
                else
                {
                    this.addedOrUpdated.put ( entry.getKey (), entry.getValue () );
                }
            }
        }
    }

    public Map<String, Variant> getAddedOrUpdated ()
    {
        return this.addedOrUpdated;
    }

    public Set<String> getRemoved ()
    {
        return this.removed;
    }
}