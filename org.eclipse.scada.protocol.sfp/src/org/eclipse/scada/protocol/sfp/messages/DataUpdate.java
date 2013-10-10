/*******************************************************************************
 * Copyright (c) 2013 Jens Reimann and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Jens Reimann - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.protocol.sfp.messages;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.scada.core.Variant;

public class DataUpdate
{

    public static enum State
    {
        ERROR,
        ALARM,
        WARNING,
        ERROR_ACK,
        ALARM_ACK,
        WARNING_ACK,
        MANUAL_OVERRIDE,
        BLOCKED
    }

    public static class Entry
    {
        private final int register;

        private final Variant value;

        private final long timestamp;

        private final Set<State> states;

        private final byte missedUpdates;

        public Entry ( final int register, final Variant value, final long timestamp, final Set<State> states, final byte missedUpdates )
        {
            this.register = register;
            this.value = value;
            this.timestamp = timestamp;
            this.states = Collections.unmodifiableSet ( new HashSet<State> ( states ) );
            this.missedUpdates = missedUpdates;
        }

        public int getRegister ()
        {
            return this.register;
        }

        public Set<State> getStates ()
        {
            return this.states;
        }

        public long getTimestamp ()
        {
            return this.timestamp;
        }

        public Variant getValue ()
        {
            return this.value;
        }

        public byte getMissedUpdates ()
        {
            return this.missedUpdates;
        }
    }

    private final Collection<Entry> entries;

    public DataUpdate ( final Collection<Entry> entries )
    {
        this.entries = Collections.unmodifiableList ( new ArrayList<Entry> ( entries ) );
    }

    public Collection<Entry> getEntries ()
    {
        return this.entries;
    }

}
