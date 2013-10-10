/*******************************************************************************
 * Copyright (c) 2010, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *******************************************************************************/
package org.eclipse.scada.ae.monitor.common;

import org.eclipse.scada.ae.data.Severity;
import org.eclipse.scada.core.Variant;
import org.eclipse.scada.utils.lang.Immutable;

@Immutable
public class StateInformation
{
    private final State state;

    private final Severity severity;

    private final Long lastChangeTimestamp;

    private final Long lastValueTimestamp;

    private final Long lastFailTimestamp;

    private final Long lastAckRequiredTimestamp;

    private final Long lastAckTimestamp;

    private final String lastAckUser;

    private final Variant value;

    private final Variant lastFailValue;

    public StateInformation ( final State state, final Severity severity, final Long lastChangeTimestamp, final Variant value, final Long lastValueTimestamp, final Long lastFailTimestamp, final Long lastAckRequiredTimestamp, final Long lastAckTimestamp, final String lastAckUser, final Variant lastFailValue )
    {
        this.state = state;
        this.severity = severity;
        this.lastChangeTimestamp = lastChangeTimestamp;
        this.value = value;
        this.lastValueTimestamp = lastValueTimestamp;
        this.lastFailTimestamp = lastFailTimestamp;
        this.lastAckRequiredTimestamp = lastAckRequiredTimestamp;
        this.lastAckTimestamp = lastAckTimestamp;
        this.lastAckUser = lastAckUser;
        this.lastFailValue = lastFailValue;
    }

    @Override
    public String toString ()
    {
        return String.format ( "[%s: %s]", this.state, this.severity );
    }

    public State getState ()
    {
        return this.state;
    }

    public Severity getSeverity ()
    {
        return this.severity;
    }

    public Long getLastChangeTimestamp ()
    {
        return this.lastChangeTimestamp;
    }

    public Variant getValue ()
    {
        return this.value;
    }

    public Long getLastValueTimestamp ()
    {
        return this.lastValueTimestamp;
    }

    public Long getLastFailTimestamp ()
    {
        return this.lastFailTimestamp;
    }

    public Long getLastAckRequiredTimestamp ()
    {
        return this.lastAckRequiredTimestamp;
    }

    public Long getLastAckTimestamp ()
    {
        return this.lastAckTimestamp;
    }

    public String getLastAckUser ()
    {
        return this.lastAckUser;
    }

    public Variant getLastFailValue ()
    {
        return this.lastFailValue;
    }

    public static class Builder
    {
        private State state;

        private Severity severity;

        private Long lastChangeTimestamp;

        private Variant value;

        private Long lastValueTimestamp;

        private Long lastFailTimestamp;

        private Long lastAckRequiredTimestamp;

        private Long lastAckTimestamp;

        private String lastAckUser;

        private Variant lastFailValue;

        public Builder ( final StateInformation other )
        {
            this.state = other.state;
            this.severity = other.severity;
            this.lastChangeTimestamp = other.lastChangeTimestamp;
            this.value = other.value;
            this.lastValueTimestamp = other.lastValueTimestamp;
            this.lastFailTimestamp = other.lastFailTimestamp;
            this.lastAckRequiredTimestamp = other.lastAckRequiredTimestamp;
            this.lastAckTimestamp = other.lastAckTimestamp;
            this.lastAckUser = other.lastAckUser;
            this.lastFailValue = other.lastFailValue;
        }

        public StateInformation build ()
        {
            return new StateInformation ( this.state, this.severity, this.lastChangeTimestamp, this.value, this.lastValueTimestamp, this.lastFailTimestamp, this.lastAckRequiredTimestamp, this.lastAckTimestamp, this.lastAckUser, this.lastFailValue );
        }

        public Builder setLastAckRequiredTimestamp ( final Long lastAckRequiredTimestamp )
        {
            this.lastAckRequiredTimestamp = lastAckRequiredTimestamp;
            return this;
        }

        public Builder setLastFailTimestamp ( final Long lastFailTimestamp )
        {
            this.lastFailTimestamp = lastFailTimestamp;
            return this;
        }

        public Builder setLastValueTimestamp ( final Long lastValueTimestamp )
        {
            this.lastValueTimestamp = lastValueTimestamp;
            return this;
        }

        public Builder setSeverity ( final Severity severity )
        {
            this.severity = severity;
            return this;
        }

        public Builder setState ( final State state )
        {
            this.state = state;
            return this;
        }

        public Builder setLastAckTimestamp ( final Long lastAckTimestamp )
        {
            this.lastAckTimestamp = lastAckTimestamp;
            return this;
        }

        public Builder setLastChangeTimestamp ( final Long lastChangeTimestamp )
        {
            this.lastChangeTimestamp = lastChangeTimestamp;
            return this;
        }

        public Builder setLastAckUser ( final String lastAckUser )
        {
            this.lastAckUser = lastAckUser;
            return this;
        }

        public Builder setValue ( final Variant value )
        {
            this.value = value;
            return this;
        }

        public Builder setLastFailValue ( final Variant lastFailValue )
        {
            this.lastFailValue = lastFailValue;
            return this;
        }

    }

    @Override
    public int hashCode ()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ( this.lastAckRequiredTimestamp == null ? 0 : this.lastAckRequiredTimestamp.hashCode () );
        result = prime * result + ( this.lastAckTimestamp == null ? 0 : this.lastAckTimestamp.hashCode () );
        result = prime * result + ( this.lastAckUser == null ? 0 : this.lastAckUser.hashCode () );
        result = prime * result + ( this.lastChangeTimestamp == null ? 0 : this.lastChangeTimestamp.hashCode () );
        result = prime * result + ( this.lastFailTimestamp == null ? 0 : this.lastFailTimestamp.hashCode () );
        result = prime * result + ( this.lastValueTimestamp == null ? 0 : this.lastValueTimestamp.hashCode () );
        result = prime * result + ( this.severity == null ? 0 : this.severity.hashCode () );
        result = prime * result + ( this.state == null ? 0 : this.state.hashCode () );
        result = prime * result + ( this.value == null ? 0 : this.value.hashCode () );
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
        final StateInformation other = (StateInformation)obj;
        if ( this.lastAckRequiredTimestamp == null )
        {
            if ( other.lastAckRequiredTimestamp != null )
            {
                return false;
            }
        }
        else if ( !this.lastAckRequiredTimestamp.equals ( other.lastAckRequiredTimestamp ) )
        {
            return false;
        }
        if ( this.lastAckTimestamp == null )
        {
            if ( other.lastAckTimestamp != null )
            {
                return false;
            }
        }
        else if ( !this.lastAckTimestamp.equals ( other.lastAckTimestamp ) )
        {
            return false;
        }
        if ( this.lastAckUser == null )
        {
            if ( other.lastAckUser != null )
            {
                return false;
            }
        }
        else if ( !this.lastAckUser.equals ( other.lastAckUser ) )
        {
            return false;
        }
        if ( this.lastChangeTimestamp == null )
        {
            if ( other.lastChangeTimestamp != null )
            {
                return false;
            }
        }
        else if ( !this.lastChangeTimestamp.equals ( other.lastChangeTimestamp ) )
        {
            return false;
        }
        if ( this.lastFailTimestamp == null )
        {
            if ( other.lastFailTimestamp != null )
            {
                return false;
            }
        }
        else if ( !this.lastFailTimestamp.equals ( other.lastFailTimestamp ) )
        {
            return false;
        }
        if ( this.lastValueTimestamp == null )
        {
            if ( other.lastValueTimestamp != null )
            {
                return false;
            }
        }
        else if ( !this.lastValueTimestamp.equals ( other.lastValueTimestamp ) )
        {
            return false;
        }
        if ( this.severity != other.severity )
        {
            return false;
        }
        if ( this.state != other.state )
        {
            return false;
        }
        if ( this.value == null )
        {
            if ( other.value != null )
            {
                return false;
            }
        }
        else if ( !this.value.equals ( other.value ) )
        {
            return false;
        }
        return true;
    }

}