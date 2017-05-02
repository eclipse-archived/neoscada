/*******************************************************************************
 * Copyright (c) 2010, 2013 TH4 SYSTEMS GmbH and others.
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

import java.util.Collection;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

import org.eclipse.scada.core.Variant;
import org.eclipse.scada.core.server.OperationParameters;
import org.eclipse.scada.da.core.DataItemInformation;
import org.eclipse.scada.da.core.WriteResult;
import org.eclipse.scada.da.data.IODirection;
import org.eclipse.scada.da.server.common.DataItemInformationBase;
import org.eclipse.scada.utils.concurrent.NotifyFuture;

public abstract class DataItemInputOutputChained extends DataItemInputChained
{
    public DataItemInputOutputChained ( final DataItemInformation di, final Executor executor )
    {
        super ( di, executor );
    }

    public DataItemInputOutputChained ( final String id, final Executor executor )
    {
        this ( new DataItemInformationBase ( id, EnumSet.of ( IODirection.INPUT, IODirection.OUTPUT ) ), executor );
    }

    @Override
    public NotifyFuture<WriteResult> startWriteValue ( Variant value, final OperationParameters operationParameters )
    {
        synchronized ( this )
        {
            final Collection<ChainProcessEntry> chain = getChainCopy ();

            final Map<String, Variant> primaryAttributes = new HashMap<String, Variant> ( this.primaryAttributes );

            for ( final ChainProcessEntry entry : chain )
            {
                if ( entry.getWhen ().contains ( IODirection.OUTPUT ) )
                {
                    final Variant newValue = entry.getWhat ().process ( value, primaryAttributes );
                    if ( newValue != null )
                    {
                        value = newValue;
                    }
                }
            }
        }
        // FIXME: for the moment output chain item don't show up in the attribute list
        // secondaryAttributes.set ( primaryAttributes );

        return startWriteCalculatedValue ( value, operationParameters );
    }

    protected abstract NotifyFuture<WriteResult> startWriteCalculatedValue ( final Variant value, OperationParameters operationParameters );
}
