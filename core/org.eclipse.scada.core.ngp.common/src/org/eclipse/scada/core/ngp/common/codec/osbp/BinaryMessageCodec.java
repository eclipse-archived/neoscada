/*******************************************************************************
 * Copyright (c) 2011, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.core.ngp.common.codec.osbp;

import org.apache.mina.core.buffer.IoBuffer;

public interface BinaryMessageCodec
{
    public int getMessageCode ();

    public Class<?> getMessageClass ();

    public Object decodeMessage ( BinaryContext context, IoBuffer data ) throws Exception;

    public IoBuffer encodeMessage ( BinaryContext context, Object message ) throws Exception;
}
