/*******************************************************************************
 * Copyright (c) 2009, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *******************************************************************************/
package org.eclipse.scada.da.master;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.scada.core.Variant;
import org.eclipse.scada.core.server.OperationParameters;

public class WriteRequest
{
    private final OperationParameters operationParameters;

    private final Variant value;

    private final Map<String, Variant> attributes;

    public WriteRequest ( final Variant value, final OperationParameters operationParameters )
    {
        this ( value, null, operationParameters );
    }

    public WriteRequest ( final Map<String, Variant> attributes, final OperationParameters operationParameters )
    {
        this ( null, attributes, operationParameters );
    }

    public WriteRequest ( final Variant value, final Map<String, Variant> attributes, final OperationParameters operationParameters )
    {
        this.value = value;
        this.operationParameters = operationParameters;

        if ( attributes != null )
        {
            this.attributes = new HashMap<String, Variant> ( attributes );
        }
        else
        {
            this.attributes = new HashMap<String, Variant> ();
        }
    }

    public Map<String, Variant> getAttributes ()
    {
        return Collections.unmodifiableMap ( this.attributes );
    }

    public OperationParameters getOperationParameters ()
    {
        return this.operationParameters;
    }

    public Variant getValue ()
    {
        return this.value;
    }

    /**
     * Check if the request is an empty request. A request
     * is empty if neither attributes nor the primary value
     * is requested to be written.
     * 
     * @return <code>true</code>if the request is empty, <code>false</code>
     *         otherwise
     */
    public boolean isEmpty ()
    {
        return this.value == null && ( this.attributes == null || this.attributes.isEmpty () );
    }
}
