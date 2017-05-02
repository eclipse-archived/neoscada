/*******************************************************************************
 * Copyright (c) 2011, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *******************************************************************************/
package org.eclipse.scada.da.server.arduino;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

import org.eclipse.scada.core.Variant;
import org.eclipse.scada.core.server.OperationParameters;
import org.eclipse.scada.da.core.DataItemInformation;
import org.eclipse.scada.da.core.WriteResult;
import org.eclipse.scada.protocol.arduino.ArduinoDevice;
import org.eclipse.scada.utils.concurrent.InstantErrorFuture;
import org.eclipse.scada.utils.concurrent.InstantFuture;
import org.eclipse.scada.utils.concurrent.NotifyFuture;
import org.eclipse.scada.da.server.common.AttributeMode;
import org.eclipse.scada.da.server.common.chain.DataItemInputOutputChained;

public class ArduinoDataItem extends DataItemInputOutputChained
{

    private final ArduinoDevice device;

    private final short itemIndex;

    public ArduinoDataItem ( final ArduinoDevice device, final short itemIndex, final DataItemInformation information, final Executor executor )
    {
        super ( information, executor );
        this.device = device;
        this.itemIndex = itemIndex;

        final Map<String, Variant> attributes = new HashMap<String, Variant> ( 1 );
        attributes.put ( "itemIndex", Variant.valueOf ( itemIndex ) );
        updateData ( null, attributes, AttributeMode.SET );
    }

    @Override
    protected NotifyFuture<WriteResult> startWriteCalculatedValue ( final Variant value, final OperationParameters operationParameters )
    {
        try
        {
            this.device.sendWrite ( this.itemIndex, value.as ( null ) );
        }
        catch ( final Exception e )
        {
            return new InstantErrorFuture<WriteResult> ( e );
        }
        return new InstantFuture<WriteResult> ( WriteResult.OK );
    }

}
