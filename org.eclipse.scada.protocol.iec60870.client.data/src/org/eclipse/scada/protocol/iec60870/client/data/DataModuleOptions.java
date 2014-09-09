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

public class DataModuleOptions
{
    private final boolean ignoreBackgroundScan;

    private final boolean automaticDataStart;

    private DataModuleOptions ( final boolean ignoreBackgroundScan, final boolean automaticDataStart )
    {
        this.ignoreBackgroundScan = ignoreBackgroundScan;
        this.automaticDataStart = automaticDataStart;
    }

    public boolean isIgnoreBackgroundScan ()
    {
        return this.ignoreBackgroundScan;
    }

    public boolean isAutomaticDataStart ()
    {
        return this.automaticDataStart;
    }

    public static class Builder
    {
        private boolean ignoreBackgroundScan;

        private boolean automaticDataStart = true;

        public Builder ()
        {
        }

        public void setIgnoreBackgroundScan ( final boolean ignoreBackgroundScan )
        {
            this.ignoreBackgroundScan = ignoreBackgroundScan;
        }

        public boolean isIgnoreBackgroundScan ()
        {
            return this.ignoreBackgroundScan;
        }

        public void setAutomaticDataStart ( final boolean automaticDataStart )
        {
            this.automaticDataStart = automaticDataStart;
        }

        public boolean isAutomaticDataStart ()
        {
            return this.automaticDataStart;
        }

        public DataModuleOptions build ()
        {
            return new DataModuleOptions ( this.ignoreBackgroundScan, this.automaticDataStart );
        }
    }
}
