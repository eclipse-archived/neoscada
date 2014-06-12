/*******************************************************************************
 * Copyright (c) 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.protocol.iec60870.server.data;

import java.util.List;

import org.eclipse.scada.protocol.iec60870.asdu.types.ASDUAddress;
import org.eclipse.scada.protocol.iec60870.asdu.types.InformationObjectAddress;
import org.eclipse.scada.protocol.iec60870.asdu.types.Value;

import com.google.common.util.concurrent.ListenableFuture;

public class DefaultSubscription implements Subscription
{
    private final AbstractBaseDataModel dataModel;

    private final DataListener listener;

    public DefaultSubscription ( final AbstractBaseDataModel dataModel, final DataListener listener )
    {
        this.dataModel = dataModel;
        this.listener = listener;
    }

    @Override
    public ListenableFuture<Void> dispose ()
    {
        return this.dataModel.disposeSubscription ( this );
    }

    public void notifyChangeFloat ( final ASDUAddress asduAddress, final InformationObjectAddress startAddress, final List<Value<Float>> values )
    {
        this.listener.dataChangeFloat ( asduAddress, startAddress, values );
    }

    public void notifyChangeBoolean ( final ASDUAddress asduAddress, final InformationObjectAddress startAddress, final List<Value<Boolean>> values )
    {
        this.listener.dataChangeBoolean ( asduAddress, startAddress, values );
    }
}
