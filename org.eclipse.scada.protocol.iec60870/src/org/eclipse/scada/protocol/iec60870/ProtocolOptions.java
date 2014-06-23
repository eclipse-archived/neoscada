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

import java.util.TimeZone;

import org.eclipse.scada.protocol.iec60870.apci.Supervisory;

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

    private short maxSequenceNumber = 32767;

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
    private String timeZoneId;

    /**
     * A flag indicating of the daylight saving time information should be
     * ignored
     */
    private boolean ignoreDaylightSavingTime;

    private ProtocolOptions ()
    {
    }

    private ProtocolOptions ( final ProtocolOptions other )
    {
        this.timeout1 = other.timeout1;
        this.timeout2 = other.timeout2;
        this.timeout3 = other.timeout3;
        this.adsuAddressType = other.adsuAddressType;
        this.informationObjectAddressType = other.informationObjectAddressType;
        this.causeOfTransmissionType = other.causeOfTransmissionType;
        this.acknowledgeWindow = other.acknowledgeWindow;
        this.maxUnacknowledged = other.maxUnacknowledged;
        this.maxSequenceNumber = other.maxSequenceNumber;
        this.timeZone = other.timeZone;
        this.timeZoneId = other.timeZoneId;
        this.ignoreDaylightSavingTime = other.ignoreDaylightSavingTime;
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

    public static class Builder
    {
        private final ProtocolOptions value;

        public Builder ()
        {
            this.value = new ProtocolOptions ();
        }

        public Builder ( final ProtocolOptions other )
        {
            this.value = new ProtocolOptions ( other );
        }

        public ProtocolOptions build ()
        {
            validate ();
            return new ProtocolOptions ( this.value );
        }

        public void validate ()
        {
            validate ( "maxUnacknowledged", this.value.maxUnacknowledged, 1, this.value.maxSequenceNumber - 1 );
            validate ( "acknowledgeWindow", this.value.acknowledgeWindow, 1, this.value.maxUnacknowledged - 1 );
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
            return this.value.timeout1;
        }

        public void setTimeout1 ( final int timeout1 )
        {
            this.value.timeout1 = timeout1;
        }

        public int getTimeout2 ()
        {
            return this.value.timeout2;
        }

        public void setTimeout2 ( final int timeout2 )
        {
            this.value.timeout2 = timeout2;
        }

        public int getTimeout3 ()
        {
            return this.value.timeout3;
        }

        public void setTimeout3 ( final int timeout3 )
        {
            this.value.timeout3 = timeout3;
        }

        public short getAcknowledgeWindow ()
        {
            return this.value.acknowledgeWindow;
        }

        public void setAcknowledgeWindow ( final short acknowledgeWindow )
        {
            this.value.acknowledgeWindow = acknowledgeWindow;
        }

        public short getMaxUnacknowledged ()
        {
            return this.value.maxUnacknowledged;
        }

        public void setMaxUnacknowledged ( final short maxUnacknowledged )
        {
            this.value.maxUnacknowledged = maxUnacknowledged;
        }

        public ASDUAddressType getAdsuAddressType ()
        {
            return this.value.adsuAddressType;
        }

        public void setAdsuAddressType ( final ASDUAddressType adsuAddressType )
        {
            this.value.adsuAddressType = adsuAddressType;
        }

        public InformationObjectAddressType getInformationObjectAddressType ()
        {
            return this.value.informationObjectAddressType;
        }

        public void setInformationObjectAddressType ( final InformationObjectAddressType informationObjectAddressType )
        {
            this.value.informationObjectAddressType = informationObjectAddressType;
        }

        public CauseOfTransmissionType getCauseOfTransmissionType ()
        {
            return this.value.causeOfTransmissionType;
        }

        public void setCauseOfTransmissionType ( final CauseOfTransmissionType causeOfTransmissionType )
        {
            this.value.causeOfTransmissionType = causeOfTransmissionType;
        }

        public TimeZone getTimeZone ()
        {
            return this.value.timeZone;
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
            if ( timeZone == null )
            {
                setTimeZone ( TimeZone.getTimeZone ( "UTC" ) );
            }
            else
            {
                this.value.timeZone = timeZone;
                this.value.timeZoneId = timeZone.getID ();
            }
        }

        public void setIgnoreDaylightSavingTime ( final boolean ignoreDaylightSavingTime )
        {
            this.value.ignoreDaylightSavingTime = ignoreDaylightSavingTime;
        }

        public boolean isIgnoreDaylightSavingTime ()
        {
            return this.value.ignoreDaylightSavingTime;
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