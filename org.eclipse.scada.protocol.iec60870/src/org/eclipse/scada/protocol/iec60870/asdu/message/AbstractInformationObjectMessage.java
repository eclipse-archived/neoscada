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
import org.eclipse.scada.protocol.iec60870.asdu.types.InformationObjectAddress;

public abstract class AbstractInformationObjectMessage extends AbstractMessage
{
    protected final InformationObjectAddress informationObjectAddress;

    public AbstractInformationObjectMessage ( final ASDUHeader header, final InformationObjectAddress informationObjectAddress )
    {
        super ( header );
        this.informationObjectAddress = informationObjectAddress;
    }

    public InformationObjectAddress getInformationObjectAddress ()
    {
        return this.informationObjectAddress;
    }
}
