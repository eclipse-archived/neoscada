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
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BrowseAdded
{
    public static class Entry
    {
        public static enum Flags
        {
            INPUT,
            OUTPUT
        }

        private final short register;

        private final String name;

        private final String description;

        private final String unit;

        private final DataType dataType;

        private final Set<Flags> flags;

        public Entry ( final short register, final String name, final String description, final String unit, final DataType dataType, final Set<Flags> flags )
        {
            this.register = register;
            this.name = name;
            this.description = description;
            this.unit = unit;
            this.dataType = dataType;
            this.flags = Collections.unmodifiableSet ( new HashSet<Flags> ( flags ) );
        }

        public DataType getDataType ()
        {
            return this.dataType;
        }

        public String getDescription ()
        {
            return this.description;
        }

        public Set<Flags> getFlags ()
        {
            return this.flags;
        }

        public String getName ()
        {
            return this.name;
        }

        public short getRegister ()
        {
            return this.register;
        }

        public String getUnit ()
        {
            return this.unit;
        }
    }

    private final List<Entry> entries;

    public BrowseAdded ( final List<Entry> entries )
    {
        this.entries = Collections.unmodifiableList ( new ArrayList<Entry> ( entries ) );
    }

    public List<Entry> getEntries ()
    {
        return this.entries;
    }
}
