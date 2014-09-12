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
package org.eclipse.scada.protocol.iec60870;

import java.io.Serializable;
import java.util.TimeZone;

import org.eclipse.scada.protocol.iec60870.apci.Supervisory;
import org.eclipse.scada.utils.beans.AbstractPropertyChange;

public class ProtocolOptions
{
    /**
     * The connection timeout. <br/>
     * If no data was received for this amount of time, the connection will be
     * closed.
     */
    private int timeout1 = 15_000;

    /**
     * The acknowledge timeout. <br/>
     * If an inbound message was received, but no outbound message was sent
     * for this amount of time, a {@link Supervisory} message will be sent.
     */
    private int timeout2 = 10_000;

    /**
     * The "ping" timeout. <br/>
     * If no data was received for this amount of time, a TESTFR request will be
     * sent.
     */
    private int timeout3 = 20_000;

    private ASDUAddressType adsuAddressType = ASDUAddressType.SIZE_2;

    private InformationObjectAddressType informationObjectAddressType = InformationObjectAddressType.SIZE_3;

    private CauseOfTransmissionType causeOfTransmissionType = CauseOfTransmissionType.SIZE_2;

    private final short maxSequenceNumber = 32767;

    /**
     * aka parameter "k"
     */
    private short maxUnacknowledged = 15;

    /**
     * aka parameter "w"
     */
    private short acknowledgeWindow = 10;

    /**
     * The timezone to which the internal (UTC) timestamps will be converted
     * <p>
     * The default is UTC. The recommendation of IEC 60870-5 also is UTC.
     * </p>
     */
    private TimeZone timeZone = TimeZone.getTimeZone ( "UTC" );

    /**
     * An internal copy of the time zone ID <br/>
     * This is used to implement hashCode and equals
     */
    private final String timeZoneId;

    /**
     * A flag indicating of the daylight saving time information should be
     * ignored
     */
    private final boolean ignoreDaylightSavingTime;

    public ProtocolOptions ( final int timeout1, final int timeout2, final int timeout3, final ASDUAddressType adsuAddressType, final InformationObjectAddressType informationObjectAddressType, final CauseOfTransmissionType causeOfTransmissionType, final short maxUnacknowledged, final short acknowledgeWindow, final TimeZone timeZone, final boolean ignoreDaylightSavingTime )
    {
        super ();
        this.timeout1 = timeout1;
        this.timeout2 = timeout2;
        this.timeout3 = timeout3;
        this.adsuAddressType = adsuAddressType;
        this.informationObjectAddressType = informationObjectAddressType;
        this.causeOfTransmissionType = causeOfTransmissionType;
        this.maxUnacknowledged = maxUnacknowledged;
        this.acknowledgeWindow = acknowledgeWindow;
        this.timeZone = timeZone;
        this.timeZoneId = timeZone != null ? timeZone.getID () : null;
        this.ignoreDaylightSavingTime = ignoreDaylightSavingTime;
    }

    public int getTimeout1 ()
    {
        return this.timeout1;
    }

    public int getTimeout2 ()
    {
        return this.timeout2;
    }

    public int getTimeout3 ()
    {
        return this.timeout3;
    }

    public int getAcknowledgeWindow ()
    {
        return this.acknowledgeWindow;
    }

    public int getMaxUnacknowledged ()
    {
        return this.maxUnacknowledged;
    }

    public short getMaxSequenceNumber ()
    {
        return this.maxSequenceNumber;
    }

    public ASDUAddressType getAdsuAddressType ()
    {
        return this.adsuAddressType;
    }

    public InformationObjectAddressType getInformationObjectAddressType ()
    {
        return this.informationObjectAddressType;
    }

    public CauseOfTransmissionType getCauseOfTransmissionType ()
    {
        return this.causeOfTransmissionType;
    }

    public TimeZone getTimeZone ()
    {
        return this.timeZone;
    }

    public boolean isIgnoreDaylightSavingTime ()
    {
        return this.ignoreDaylightSavingTime;
    }

    public static class Builder extends AbstractPropertyChange implements Serializable
    {
        private static final long serialVersionUID = 1L;

        public static final String PROP_TIMEOUT1 = "timeout1";

        public static final String PROP_TIMEOUT2 = "timeout2";

        public static final String PROP_TIMEOUT3 = "timeout3";

        public static final String PROP_MAX_UNACKNOWLEDGED = "maxUnacknowledged";

        public static final String PROP_ACKNOWLEDGE_WINDOW = "acknowledgeWindow";

        public static final String PROP_ASDU_ADDRESS_TYPE = "adsuAddressType";

        public static final String PROP_INFORMATION_OBJECT_ADDRESS_TYPE = "informationObjectAddressType";

        public static final String PROP_CAUSE_OF_TRANSMISSION_TYPE = "causeOfTransmissionType";

        public static final String PROP_TIME_ZONE = "timeZone";

        public static final String PROP_IGNORE_DAYLIGHT_SAVING_TIME = "ignoreDaylightSavingTime";

        private int timeout1 = 15_000;

        private int timeout2 = 10_000;

        private int timeout3 = 20_000;

        private ASDUAddressType adsuAddressType = ASDUAddressType.SIZE_2;

        private InformationObjectAddressType informationObjectAddressType = InformationObjectAddressType.SIZE_3;

        private CauseOfTransmissionType causeOfTransmissionType = CauseOfTransmissionType.SIZE_2;

        private final short maxSequenceNumber = 32767;

        private short maxUnacknowledged = 15;

        private short acknowledgeWindow = 10;

        private TimeZone timeZone = TimeZone.getTimeZone ( "UTC" );

        /**
         * A flag indicating of the daylight saving time information should be
         * ignored
         */
        private boolean ignoreDaylightSavingTime;

        public Builder ()
        {
        }

        public Builder ( final ProtocolOptions other )
        {
            this.timeout1 = other.timeout1;
            this.timeout2 = other.timeout2;
            this.timeout3 = other.timeout3;
            this.adsuAddressType = other.adsuAddressType;
            this.informationObjectAddressType = other.informationObjectAddressType;
            this.causeOfTransmissionType = other.causeOfTransmissionType;
            this.acknowledgeWindow = other.acknowledgeWindow;
            this.maxUnacknowledged = other.maxUnacknowledged;
            this.timeZone = other.timeZone;
            this.ignoreDaylightSavingTime = other.ignoreDaylightSavingTime;
        }

        public ProtocolOptions build ()
        {
            validate ();
            return new ProtocolOptions ( this.timeout1, this.timeout2, this.timeout3, this.adsuAddressType, this.informationObjectAddressType, this.causeOfTransmissionType, this.maxUnacknowledged, this.acknowledgeWindow, this.timeZone, this.ignoreDaylightSavingTime );
        }

        public void validate ()
        {
            validate ( "maxUnacknowledged", this.maxUnacknowledged, 1, this.maxSequenceNumber - 1 );
            validate ( "acknowledgeWindow", this.acknowledgeWindow, 1, this.maxUnacknowledged - 1 );
        }

        private void validate ( final String parameter, final int value, final int start, final int end )
        {
            if ( value < start || value > end )
            {
                throw new IllegalStateException ( String.format ( "'%s' must be between %s (inclusive) and %s (inclusive), but is %s", parameter, start, end, value ) );
            }
        }

        public int getTimeout1 ()
        {
            return this.timeout1;
        }

        public void setTimeout1 ( final int timeout1 )
        {
            firePropertyChange ( PROP_TIMEOUT1, this.timeout1, this.timeout1 = timeout1 );
        }

        public int getTimeout2 ()
        {
            return this.timeout2;
        }

        public void setTimeout2 ( final int timeout2 )
        {
            firePropertyChange ( PROP_TIMEOUT2, this.timeout2, this.timeout2 = timeout2 );
        }

        public int getTimeout3 ()
        {
            return this.timeout3;
        }

        public void setTimeout3 ( final int timeout3 )
        {
            firePropertyChange ( PROP_TIMEOUT3, this.timeout3, this.timeout3 = timeout3 );
        }

        public short getAcknowledgeWindow ()
        {
            return this.acknowledgeWindow;
        }

        public void setAcknowledgeWindow ( final short acknowledgeWindow )
        {
            firePropertyChange ( PROP_ACKNOWLEDGE_WINDOW, this.acknowledgeWindow, this.acknowledgeWindow = acknowledgeWindow );
        }

        public short getMaxUnacknowledged ()
        {
            return this.maxUnacknowledged;
        }

        public void setMaxUnacknowledged ( final short maxUnacknowledged )
        {
            firePropertyChange ( PROP_MAX_UNACKNOWLEDGED, this.maxUnacknowledged, this.maxUnacknowledged = maxUnacknowledged );
        }

        public ASDUAddressType getAdsuAddressType ()
        {
            return this.adsuAddressType;
        }

        public void setAdsuAddressType ( final ASDUAddressType adsuAddressType )
        {
            firePropertyChange ( PROP_ASDU_ADDRESS_TYPE, this.adsuAddressType, this.adsuAddressType = adsuAddressType );
        }

        public InformationObjectAddressType getInformationObjectAddressType ()
        {
            return this.informationObjectAddressType;
        }

        public void setInformationObjectAddressType ( final InformationObjectAddressType informationObjectAddressType )
        {
            firePropertyChange ( PROP_INFORMATION_OBJECT_ADDRESS_TYPE, this.informationObjectAddressType, this.informationObjectAddressType = informationObjectAddressType );
        }

        public CauseOfTransmissionType getCauseOfTransmissionType ()
        {
            return this.causeOfTransmissionType;
        }

        public void setCauseOfTransmissionType ( final CauseOfTransmissionType causeOfTransmissionType )
        {
            firePropertyChange ( PROP_CAUSE_OF_TRANSMISSION_TYPE, this.causeOfTransmissionType, this.causeOfTransmissionType = causeOfTransmissionType );
        }

        public TimeZone getTimeZone ()
        {
            return this.timeZone;
        }

        /**
         * Set the target time zone <br/>
         * If the timezone is not set or set to <code>null</code> the timezone
         * will be <q>UTC</q>.
         *
         * @param timeZone
         *            the target time zone, may be <code>null</code/>
         */
        public void setTimeZone ( final TimeZone timeZone )
        {
            final TimeZone oldTimeZone = this.timeZone;

            if ( timeZone == null )
            {
                this.timeZone = TimeZone.getTimeZone ( "UTC" );
            }
            else
            {
                this.timeZone = timeZone;
            }

            firePropertyChange ( PROP_TIME_ZONE, oldTimeZone, this.timeZone );
        }

        public void setIgnoreDaylightSavingTime ( final boolean ignoreDaylightSavingTime )
        {
            this.ignoreDaylightSavingTime = ignoreDaylightSavingTime;
            firePropertyChange ( PROP_IGNORE_DAYLIGHT_SAVING_TIME, this.ignoreDaylightSavingTime, this.ignoreDaylightSavingTime = ignoreDaylightSavingTime );
        }

        public boolean isIgnoreDaylightSavingTime ()
        {
            return this.ignoreDaylightSavingTime;
        }
    }

    @Override
    public int hashCode ()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + this.acknowledgeWindow;
        result = prime * result + ( this.adsuAddressType == null ? 0 : this.adsuAddressType.hashCode () );
        result = prime * result + ( this.causeOfTransmissionType == null ? 0 : this.causeOfTransmissionType.hashCode () );
        result = prime * result + ( this.ignoreDaylightSavingTime ? 1231 : 1237 );
        result = prime * result + ( this.informationObjectAddressType == null ? 0 : this.informationObjectAddressType.hashCode () );
        result = prime * result + this.maxSequenceNumber;
        result = prime * result + this.maxUnacknowledged;
        result = prime * result + ( this.timeZoneId == null ? 0 : this.timeZoneId.hashCode () );
        result = prime * result + this.timeout1;
        result = prime * result + this.timeout2;
        result = prime * result + this.timeout3;
        return result;
    }

    @Override
    public boolean equals ( final Object obj )
    {
        if ( this == obj )
        {
            return true;
        }
        if ( obj == null )
        {
            return false;
        }
        if ( getClass () != obj.getClass () )
        {
            return false;
        }
        final ProtocolOptions other = (ProtocolOptions)obj;
        if ( this.acknowledgeWindow != other.acknowledgeWindow )
        {
            return false;
        }
        if ( this.adsuAddressType != other.adsuAddressType )
        {
            return false;
        }
        if ( this.causeOfTransmissionType != other.causeOfTransmissionType )
        {
            return false;
        }
        if ( this.ignoreDaylightSavingTime != other.ignoreDaylightSavingTime )
        {
            return false;
        }
        if ( this.informationObjectAddressType != other.informationObjectAddressType )
        {
            return false;
        }
        if ( this.maxSequenceNumber != other.maxSequenceNumber )
        {
            return false;
        }
        if ( this.maxUnacknowledged != other.maxUnacknowledged )
        {
            return false;
        }
        if ( this.timeZoneId == null )
        {
            if ( other.timeZoneId != null )
            {
                return false;
            }
        }
        else if ( !this.timeZoneId.equals ( other.timeZoneId ) )
        {
            return false;
        }
        if ( this.timeout1 != other.timeout1 )
        {
            return false;
        }
        if ( this.timeout2 != other.timeout2 )
        {
            return false;
        }
        if ( this.timeout3 != other.timeout3 )
        {
            return false;
        }
        return true;
    }

}