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

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.scada.core.Variant;
import org.eclipse.scada.core.server.OperationParameters;
import org.eclipse.scada.da.core.DataItemInformation;
import org.eclipse.scada.da.core.WriteAttributeResults;
import org.eclipse.scada.da.core.WriteResult;
import org.eclipse.scada.da.data.IODirection;
import org.eclipse.scada.da.server.common.AttributeMode;
import org.eclipse.scada.da.server.common.DataItemInformationBase;
import org.eclipse.scada.utils.concurrent.DirectExecutor;
import org.eclipse.scada.utils.concurrent.InstantFuture;
import org.eclipse.scada.utils.concurrent.NotifyFuture;

public class MemoryItemChained extends DataItemInputOutputChained
{
    public MemoryItemChained ( final DataItemInformation di )
    {
        super ( di, DirectExecutor.INSTANCE );
    }

    public MemoryItemChained ( final String id )
    {
        this ( new DataItemInformationBase ( id, EnumSet.of ( IODirection.INPUT, IODirection.OUTPUT ) ) );
    }

    @Override
    protected WriteAttributeResults handleUnhandledAttributes ( final WriteAttributeResults writeAttributeResults, final Map<String, Variant> attributes )
    {
        final Map<String, Variant> addAttributes = new HashMap<String, Variant> ();

        testFlag ( attributes, addAttributes, "test.error", "test.error" );
        testFlag ( attributes, addAttributes, "test.alarm", "test.alarm" );
        testFlag ( attributes, addAttributes, "test.warning", "warning" );
        testFlag ( attributes, addAttributes, "test.manual", "manual" );

        updateData ( null, addAttributes, AttributeMode.UPDATE );

        return super.handleUnhandledAttributes ( writeAttributeResults, attributes );
    }

    private void testFlag ( final Map<String, Variant> attributes, final Map<String, Variant> addAttributes, final String writeAttribute, final String readAttribute )
    {
        final Variant attributeRequest = attributes.remove ( writeAttribute );
        if ( attributeRequest != null )
        {
            addAttributes.put ( readAttribute, attributeRequest );
        }
    }

    @Override
    protected NotifyFuture<WriteResult> startWriteCalculatedValue ( final Variant value, final OperationParameters operationParameters )
    {
        updateData ( value, null, null );
        return new InstantFuture<WriteResult> ( WriteResult.OK );
    }
}
