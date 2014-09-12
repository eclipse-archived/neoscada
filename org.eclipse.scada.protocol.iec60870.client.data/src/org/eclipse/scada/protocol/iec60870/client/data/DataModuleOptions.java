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
package org.eclipse.scada.protocol.iec60870.client.data;

import java.io.Serializable;

import org.eclipse.scada.utils.beans.AbstractPropertyChange;

public class DataModuleOptions
{
    private final boolean ignoreBackgroundScan;

    private final Byte causeSourceAddress;

    private DataModuleOptions ( final boolean ignoreBackgroundScan, final Byte causeSourceAddress )
    {
        this.ignoreBackgroundScan = ignoreBackgroundScan;
        this.causeSourceAddress = causeSourceAddress;
    }

    public boolean isIgnoreBackgroundScan ()
    {
        return this.ignoreBackgroundScan;
    }

    public Byte getCauseSourceAddress ()
    {
        return this.causeSourceAddress;
    }

    public static class Builder extends AbstractPropertyChange implements Serializable
    {
        private static final long serialVersionUID = 1L;

        public static final String PROP_IGNORE_BACKGROUND_SCAN = "ignoreBackgroundScan";

        public static final String PROP_CAUSE_SOURCE_ADDRESS = "causeSourceAddress";

        private boolean ignoreBackgroundScan;

        private Byte causeSourceAddress;

        public Builder ()
        {
        }

        public Builder ( final DataModuleOptions options )
        {
            this.causeSourceAddress = options.getCauseSourceAddress ();
            this.ignoreBackgroundScan = options.isIgnoreBackgroundScan ();
        }

        public void setCauseSourceAddress ( final Byte causeSourceAddress )
        {
            firePropertyChange ( PROP_CAUSE_SOURCE_ADDRESS, this.causeSourceAddress, this.causeSourceAddress = causeSourceAddress );
        }

        public Byte getCauseSourceAddress ()
        {
            return this.causeSourceAddress;
        }

        public void setIgnoreBackgroundScan ( final boolean ignoreBackgroundScan )
        {
            firePropertyChange ( PROP_IGNORE_BACKGROUND_SCAN, this.ignoreBackgroundScan, this.ignoreBackgroundScan = ignoreBackgroundScan );
        }

        public boolean isIgnoreBackgroundScan ()
        {
            return this.ignoreBackgroundScan;
        }

        public DataModuleOptions build ()
        {
            return new DataModuleOptions ( this.ignoreBackgroundScan, this.causeSourceAddress );
        }
    }
}
