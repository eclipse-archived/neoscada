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
package org.eclipse.scada.protocol.iec60870.asdu.message;

import org.eclipse.scada.protocol.iec60870.asdu.ASDUHeader;
import org.eclipse.scada.protocol.iec60870.asdu.Dumpable;
import org.eclipse.scada.protocol.iec60870.asdu.Dumper;
import org.eclipse.scada.protocol.iec60870.asdu.DumperHelper;

public abstract class AbstractMessage implements Dumpable, Encodeable
{
    protected static final int MAX_INFORMATION_ENTRIES = 127;

    protected final ASDUHeader header;

    public AbstractMessage ( final ASDUHeader header )
    {
        this.header = header;
    }

    public ASDUHeader getHeader ()
    {
        return this.header;
    }

    @Override
    public void dump ( final Dumper dumper )
    {
        dumper.fields ( this );
    }

    @Override
    public String toString ()
    {
        return DumperHelper.dump ( this ).toString ();
    }

}