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
package org.eclipse.scada.da.server.exporter.iec60870;

import org.eclipse.scada.utils.beans.AbstractPropertyChange;

public class InformationBean extends AbstractPropertyChange
{
    public static final String PROP_CONFIGURED = "configured";

    public static final String PROP_HAS_SERVER = "hasServer";

    public static final String PROP_HAS_DATA_MODULE = "hasDataModule";

    public static final String PROP_ITEMS = "items";

    public static final String PROP_NUMBER_OF_SUBSCRIPTIONS = "numberOfSubscriptions";

    private boolean configured;

    private boolean hasServer;

    private boolean hasDataModule;

    private int items;

    private int numberOfSubscriptions;

    public boolean isConfigured ()
    {
        return this.configured;
    }

    public void setConfigured ( final boolean configured )
    {
        firePropertyChange ( PROP_CONFIGURED, this.configured, this.configured = configured );
    }

    public boolean isHasServer ()
    {
        return this.hasServer;
    }

    public void setHasServer ( final boolean hasServer )
    {
        firePropertyChange ( PROP_HAS_SERVER, this.hasServer, this.hasServer = hasServer );
    }

    public boolean isHasDataModule ()
    {
        return this.hasDataModule;
    }

    public void setHasDataModule ( final boolean hasDataModule )
    {
        firePropertyChange ( PROP_HAS_DATA_MODULE, this.hasDataModule, this.hasDataModule = hasDataModule );
    }

    public int getItems ()
    {
        return this.items;
    }

    public void setItems ( final int items )
    {
        firePropertyChange ( PROP_ITEMS, this.items, this.items = items );
    }

    public int getNumberOfSubscriptions ()
    {
        return this.numberOfSubscriptions;
    }

    public void setNumberOfSubscriptions ( final int numberOfSubscriptions )
    {
        firePropertyChange ( PROP_NUMBER_OF_SUBSCRIPTIONS, this.numberOfSubscriptions, this.numberOfSubscriptions = numberOfSubscriptions );
    }

}
