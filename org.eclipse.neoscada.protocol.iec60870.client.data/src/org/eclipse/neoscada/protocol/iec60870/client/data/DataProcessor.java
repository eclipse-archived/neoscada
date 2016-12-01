/*******************************************************************************
 * Copyright (c) 2014, 2016 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *     Red Hat Inc - refactoring
 *******************************************************************************/
package org.eclipse.neoscada.protocol.iec60870.client.data;

import java.util.concurrent.Executor;

import org.eclipse.neoscada.protocol.iec60870.asdu.types.ASDUAddress;
import org.eclipse.neoscada.protocol.iec60870.asdu.types.InformationObjectAddress;
import org.eclipse.neoscada.protocol.iec60870.asdu.types.QualifierOfInterrogation;
import org.eclipse.neoscada.protocol.iec60870.asdu.types.Value;

import io.netty.channel.ChannelHandlerContext;

public class DataProcessor extends AbstractDataProcessor
{
    private final DataListener listener;

    private final Executor executor;

    public DataProcessor ( final Executor executor, final DataListener listener )
    {
        this.executor = executor;
        this.listener = listener;
    }

    @Override
    public void activated ( final DataModuleContext dataModuleContext, final ChannelHandlerContext ctx )
    {
        dataModuleContext.requestStartData ();
        dataModuleContext.startInterrogation ( ASDUAddress.BROADCAST, QualifierOfInterrogation.GLOBAL );
    }

    @Override
    public void started ()
    {
        this.executor.execute ( new Runnable () {
            @Override
            public void run ()
            {
                DataProcessor.this.listener.started ();
            };
        } );
    }

    @Override
    public void disconnected ()
    {
        this.executor.execute ( new Runnable () {
            @Override
            public void run ()
            {
                DataProcessor.this.listener.disconnected ();
            };
        } );
    }

    @Override
    protected void fireEntry ( final ASDUAddress asduAddress, final InformationObjectAddress address, final Value<?> value )
    {
        this.executor.execute ( new Runnable () {

            @Override
            public void run ()
            {
                DataProcessor.this.listener.update ( asduAddress, address, value );
            }
        } );
    }

}
