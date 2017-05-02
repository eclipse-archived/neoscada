/*******************************************************************************
 * Copyright (c) 2010, 2011 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *******************************************************************************/
package org.eclipse.scada.da.server.common.chain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.scada.core.Variant;
import org.eclipse.scada.da.core.WriteAttributeResult;
import org.eclipse.scada.da.core.WriteAttributeResults;

public abstract class BaseChainItemCommon implements ChainItem
{

    private final Set<String> reservedAttributes = new HashSet<String> ();

    @Override
    public WriteAttributeResults setAttributes ( final Map<String, Variant> attributes )
    {
        final WriteAttributeResults writeAttributeResults = new WriteAttributeResults ();

        for ( final Map.Entry<String, Variant> entry : attributes.entrySet () )
        {
            if ( this.reservedAttributes.contains ( entry.getKey () ) )
            {
                writeAttributeResults.put ( entry.getKey (), new WriteAttributeResult ( new Exception ( "Attribute may not be set" ) ) );
            }
        }

        return writeAttributeResults;
    }

    public void setReservedAttributes ( final String... reservedAttributes )
    {
        this.reservedAttributes.addAll ( Arrays.asList ( reservedAttributes ) );
    }

}
