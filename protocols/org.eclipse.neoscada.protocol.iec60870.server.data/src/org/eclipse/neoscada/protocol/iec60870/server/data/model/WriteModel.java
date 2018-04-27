/*******************************************************************************
 * Copyright (c) 2016 Red Hat Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Red Hat Inc - initial API and implementation
 *******************************************************************************/
package org.eclipse.neoscada.protocol.iec60870.server.data.model;

import java.util.concurrent.CompletionStage;

import org.eclipse.neoscada.protocol.iec60870.asdu.ASDUHeader;
import org.eclipse.neoscada.protocol.iec60870.asdu.types.InformationObjectAddress;

public interface WriteModel
{
    public class Request<T>
    {
        private final ASDUHeader header;

        private final InformationObjectAddress address;

        private final T value;

        private final byte type;

        private final boolean execute;

        public Request ( final ASDUHeader header, final InformationObjectAddress address, final T value, final byte type, final boolean execute )
        {
            this.header = header;
            this.address = address;
            this.value = value;
            this.type = type;
            this.execute = execute;
        }

        public ASDUHeader getHeader ()
        {
            return header;
        }

        public InformationObjectAddress getAddress ()
        {
            return address;
        }

        public T getValue ()
        {
            return value;
        }

        public byte getType ()
        {
            return type;
        }

        public boolean isExecute ()
        {
            return execute;
        }

        @Override
        public String toString ()
        {
            return String.format ( "[Request - header: %s, address: %s, value: %s, type: %s, execute: %s]", header, address, value, type, execute );
        }
    }

    @FunctionalInterface
    public interface Action
    {
        public CompletionStage<Void> execute ();
    }

    public Action prepareWriteValue ( Request<?> request );

    public default Runnable dispose ()
    {
        return () -> {
        };
    }
}
