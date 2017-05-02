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
package org.eclipse.scada.protocol.modbus.slave;

import org.eclipse.scada.utils.beans.AbstractPropertyChange;

public class ProtocolOptions extends AbstractPropertyChange
{
    public static final String PROP_MODE = "mode"; //$NON-NLS-1$

    public static final String PROP_READ_TIMEOUT = "readTimeout"; //$NON-NLS-1$

    public static final String PROP_INTER_FRAME_DELAY = "interFrameDelay"; //$NON-NLS-1$

    private Mode mode = Mode.TCP;

    private Integer readTimeout = 10_000;

    private long interFrameDelay = 100;

    public ProtocolOptions ()
    {
    }

    public ProtocolOptions ( final ProtocolOptions other )
    {
        this.mode = other.mode;
        this.readTimeout = other.readTimeout;
        this.interFrameDelay = other.interFrameDelay;
    }

    public void setMode ( final Mode mode )
    {
        firePropertyChange ( PROP_MODE, this.mode, this.mode = mode );
    }

    public Mode getMode ()
    {
        return this.mode;
    }

    public void setReadTimeout ( final Integer readTimeout )
    {
        firePropertyChange ( PROP_READ_TIMEOUT, this.readTimeout, this.readTimeout = readTimeout );
    }

    public Integer getReadTimeout ()
    {
        return this.readTimeout;
    }

    public void setInterFrameDelay ( final long interFrameDelay )
    {
        firePropertyChange ( PROP_INTER_FRAME_DELAY, this.interFrameDelay, this.interFrameDelay = interFrameDelay );
    }

    public long getInterFrameDelay ()
    {
        return this.interFrameDelay;
    }
}
