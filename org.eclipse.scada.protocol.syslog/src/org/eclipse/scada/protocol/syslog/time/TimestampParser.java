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
package org.eclipse.scada.protocol.syslog.time;

import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.CodecException;

import java.util.Calendar;

public interface TimestampParser
{
    /**
     * Parse a timestamp from the current reader index up to the end of the
     * timestamp
     *
     * @param data
     *            the remaining data
     * @return the timestamp, <code>null</code> if there was no timestamp
     * @throws CodecException
     *             if there was a parsing problem with the timestamp
     */
    Calendar parseTimestamp ( ByteBuf data );
}
