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
package org.eclipse.scada.core.common.iec60870;

import org.eclipse.scada.ca.ConfigurationDataHelper;
import org.eclipse.scada.protocol.iec60870.ASDUAddressType;
import org.eclipse.scada.protocol.iec60870.CauseOfTransmissionType;
import org.eclipse.scada.protocol.iec60870.InformationObjectAddressType;
import org.eclipse.scada.protocol.iec60870.ProtocolOptions;
import org.eclipse.scada.protocol.iec60870.ProtocolOptions.Builder;

public final class Configurations
{

    public static ProtocolOptions.Builder parseProtocolOptions ( final ConfigurationDataHelper cfg )
    {
        final ProtocolOptions.Builder optionsBuilder = new Builder ();

        optionsBuilder.setTimeout1 ( cfg.getInteger ( "t1", optionsBuilder.getTimeout1 () ) ); //$NON-NLS-1$
        optionsBuilder.setTimeout2 ( cfg.getInteger ( "t2", optionsBuilder.getTimeout2 () ) ); //$NON-NLS-1$
        optionsBuilder.setTimeout3 ( cfg.getInteger ( "t3", optionsBuilder.getTimeout3 () ) ); //$NON-NLS-1$
        optionsBuilder.setAdsuAddressType ( cfg.getEnum ( "asduAddressType", ASDUAddressType.class, ASDUAddressType.SIZE_2 ) ); //$NON-NLS-1$
        optionsBuilder.setCauseOfTransmissionType ( cfg.getEnum ( "causeOfTransmissionType", CauseOfTransmissionType.class, CauseOfTransmissionType.SIZE_2 ) ); //$NON-NLS-1$
        optionsBuilder.setInformationObjectAddressType ( cfg.getEnum ( "informationObjectAddressType", InformationObjectAddressType.class, InformationObjectAddressType.SIZE_3 ) ); //$NON-NLS-1$
        optionsBuilder.setAcknowledgeWindow ( (short)cfg.getInteger ( "w", optionsBuilder.getAcknowledgeWindow () ) ); //$NON-NLS-1$
        optionsBuilder.setMaxUnacknowledged ( (short)cfg.getInteger ( "k", optionsBuilder.getMaxUnacknowledged () ) ); //$NON-NLS-1$
        optionsBuilder.setTimeZone ( cfg.getTimeZone ( "timeZone", null ) ); //$NON-NLS-1$
        optionsBuilder.setIgnoreDaylightSavingTime ( cfg.getBoolean ( "ignoreDaylightSavingTime", false ) ); //$NON-NLS-1$

        return optionsBuilder;
    }

}
