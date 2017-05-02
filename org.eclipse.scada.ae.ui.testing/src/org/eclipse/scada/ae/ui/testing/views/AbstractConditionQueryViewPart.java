/*******************************************************************************
 * Copyright (c) 2009, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.ae.ui.testing.views;

import java.util.List;
import java.util.Set;

import org.eclipse.scada.ae.client.MonitorListener;
import org.eclipse.scada.ae.data.BrowserType;
import org.eclipse.scada.ae.data.MonitorStatusInformation;
import org.eclipse.scada.ae.ui.connection.data.BrowserEntryBean;
import org.eclipse.scada.core.data.SubscriptionState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractConditionQueryViewPart extends AbstractEntryViewPart
{
    private final static Logger logger = LoggerFactory.getLogger ( AbstractConditionQueryViewPart.class );

    protected final class ConditionListenerImpl implements MonitorListener
    {
        private boolean disposed = false;

        public synchronized void dispose ()
        {
            this.disposed = true;
        }

        @Override
        public synchronized void statusChanged ( final SubscriptionState state )
        {
            if ( !this.disposed )
            {
                handleStatusChanged ( state );
            }
        }

        @Override
        public synchronized void dataChanged ( final List<MonitorStatusInformation> addedOrUpdated, final Set<String> removed, final boolean full )
        {
            if ( !this.disposed )
            {
                handleDataChanged ( addedOrUpdated, removed, full );
            }
        }
    }

    private ConditionListenerImpl listener;

    @Override
    protected boolean isSupported ( final BrowserEntryBean query )
    {
        return query.getEntry ().getTypes ().contains ( BrowserType.MONITORS );
    }

    @Override
    protected void setEntry ( final BrowserEntryBean query )
    {
        logger.info ( "Setting entry: {}", query ); //$NON-NLS-1$

        this.entry = query;
        if ( this.listener != null )
        {
            this.listener.dispose ();
            this.listener = null;
        }
        this.entry.getConnection ().getConnection ().setMonitorListener ( this.entry.getEntry ().getId (), this.listener = new ConditionListenerImpl () );
    }

    protected abstract void handleDataChanged ( final List<MonitorStatusInformation> addedOrUpdated, final Set<String> removed, final boolean full );

    protected abstract void handleStatusChanged ( final SubscriptionState state );

    @Override
    protected void clear ()
    {
        if ( this.entry != null )
        {
            if ( this.listener != null )
            {
                this.listener.dispose ();
                this.listener = null;
            }
            this.entry.getConnection ().getConnection ().setMonitorListener ( this.entry.getEntry ().getId (), null );
            this.entry = null;
        }
    }
}
