/*******************************************************************************
 * Copyright (c) 2014, 2016 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *     Red Hat Inc - enhancements
 *******************************************************************************/
package org.eclipse.neoscada.protocol.iec60870.server.data;

import java.util.List;

import org.eclipse.neoscada.protocol.iec60870.asdu.types.ASDUAddress;
import org.eclipse.neoscada.protocol.iec60870.asdu.types.CauseOfTransmission;
import org.eclipse.neoscada.protocol.iec60870.asdu.types.InformationEntry;
import org.eclipse.neoscada.protocol.iec60870.asdu.types.InformationObjectAddress;
import org.eclipse.neoscada.protocol.iec60870.asdu.types.Value;

public interface DataListener
{
    public void dataChangeBoolean ( CauseOfTransmission cause, ASDUAddress asduAddress, InformationObjectAddress startAddress, List<Value<Boolean>> values );

    public void dataChangeBoolean ( CauseOfTransmission cause, ASDUAddress asduAddress, List<InformationEntry<Boolean>> values );

    public void dataChangeFloat ( CauseOfTransmission cause, ASDUAddress asduAddress, List<InformationEntry<Float>> values );

    public void dataChangeFloat ( CauseOfTransmission cause, ASDUAddress asduAddress, InformationObjectAddress startAddress, List<Value<Float>> values );

    public void dataChangeShort ( CauseOfTransmission cause, ASDUAddress asduAddress, List<InformationEntry<Short>> values );

    public void dataChangeShort ( CauseOfTransmission cause, ASDUAddress asduAddress, InformationObjectAddress startAddress, List<Value<Short>> values );
}
