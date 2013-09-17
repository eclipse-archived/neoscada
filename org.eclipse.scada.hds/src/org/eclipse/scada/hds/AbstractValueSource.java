/*******************************************************************************
 * Copyright (c) 2011 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.hds;

import java.util.Date;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractValueSource implements ValueSource
{
    private final static Logger logger = LoggerFactory.getLogger ( AbstractValueSource.class );

    private final Set<DataStoreListener> listeners = new CopyOnWriteArraySet<DataStoreListener> ();

    @Override
    public void addListener ( final DataStoreListener listener )
    {
        this.listeners.add ( listener );
    }

    @Override
    public void removeListener ( final DataStoreListener listener )
    {
        this.listeners.remove ( listener );
    }

    protected void notifyChange ( final Date start, final Date end )
    {
        logger.debug ( "Notify change - start: {}, end: {}", start, end );
        for ( final DataStoreListener listener : this.listeners )
        {
            try
            {
                listener.storeChanged ( start, end );
            }
            catch ( final Exception e )
            {
                logger.warn ( "Failed to handler listener", e );
            }
        }
    }
}
