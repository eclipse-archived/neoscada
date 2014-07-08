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
package org.eclipse.scada.protocol.iec60870.client.data;

import io.netty.channel.ChannelHandlerContext;

import org.eclipse.scada.protocol.iec60870.asdu.message.SinglePointInformationTimeSingle;

public interface DataHandler
{
    public void connected ( ChannelHandlerContext ctx );

    public void disconnected ();

    public void process ( SinglePointInformationTimeSingle msg );
}
