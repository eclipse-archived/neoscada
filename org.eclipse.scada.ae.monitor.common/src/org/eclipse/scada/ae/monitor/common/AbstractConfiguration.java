/*******************************************************************************
 * Copyright (c) 2012, 2013 TH4 SYSTEMS GmbH and others.
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

import org.eclipse.scada.ae.Event;
import org.eclipse.scada.ae.Event.EventBuilder;
import org.eclipse.scada.ae.utils.AbstractBaseConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AbstractConfiguration extends AbstractBaseConfiguration
{
    final static Logger logger = LoggerFactory.getLogger ( AbstractConfiguration.class );

    final AbstractStateMonitor monitor;

    public AbstractConfiguration ( final AbstractConfiguration currentConfiguration, final AbstractStateMonitor monitor )
    {
        super ( currentConfiguration );
        this.monitor = monitor;
    }

    @Override
    protected void sendEvent ( final Event event )
    {
        // configuration events should always we recorded, force them
        this.monitor.sendEvent ( event, true );
    }

    @Override
    protected void injectEventAttributes ( final EventBuilder builder )
    {
        this.monitor.injectEventAttributes ( builder );
    }

}