/*******************************************************************************
 * Copyright (c) 2010, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     IBH SYSTEMS GmbH - refactor for generic memory devices
 *******************************************************************************/
package org.eclipse.scada.da.server.common.memory;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

import org.eclipse.scada.core.Variant;
import org.eclipse.scada.core.server.OperationParameters;
import org.eclipse.scada.da.core.WriteAttributeResults;
import org.eclipse.scada.da.core.WriteResult;
import org.eclipse.scada.utils.concurrent.InstantErrorFuture;
import org.eclipse.scada.utils.concurrent.NotifyFuture;
import org.eclipse.scada.da.server.common.chain.DataItemInputOutputChained;

public class MemoryDeviceDataitem extends DataItemInputOutputChained
{

    private final ScalarVariable variable;

    public MemoryDeviceDataitem ( final String itemId, final Executor executor, final ScalarVariable variable )
    {
        super ( itemId, executor );
        this.variable = variable;
    }

    @Override
    protected WriteAttributeResults handleUnhandledAttributes ( final WriteAttributeResults initialResults, final Map<String, Variant> attributes )
    {
        // check for null
        WriteAttributeResults writeAttributeResults = initialResults;
        if ( writeAttributeResults == null )
        {
            writeAttributeResults = new WriteAttributeResults ();
        }

        // gather the list of open requests
        final Map<String, Variant> requests = new HashMap<String, Variant> ( 0 );

        for ( final Map.Entry<String, Variant> entry : attributes.entrySet () )
        {
            if ( !writeAttributeResults.containsKey ( entry.getKey () ) )
            {
                requests.put ( entry.getKey (), entry.getValue () );
            }
        }

        writeAttributeResults.putAll ( this.variable.handleAttributes ( requests ) );

        // default for the rest
        return super.handleUnhandledAttributes ( writeAttributeResults, attributes );
    }

    @Override
    protected NotifyFuture<WriteResult> startWriteCalculatedValue ( final Variant value, final OperationParameters operationParameters )
    {
        try
        {
            return this.variable.handleWrite ( value );
        }
        catch ( final Exception e )
        {
            return new InstantErrorFuture<> ( e );
        }
    }

}
