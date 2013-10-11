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
package org.eclipse.scada.ae.ui.views.handler;

import java.util.Iterator;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.scada.ae.data.MonitorStatus;
import org.eclipse.scada.ae.ui.views.views.MonitorSubscriptionAlarmsEventsView;
import org.eclipse.scada.sec.ui.DisplayCallbackHandler;
import org.eclipse.scada.ui.databinding.AbstractSelectionHandler;
import org.eclipse.scada.ui.databinding.AdapterHelper;
import org.eclipse.ui.IWorkbenchPart;

public class AcknowledgeHandler extends AbstractSelectionHandler implements IHandler
{

    @Override
    public Object execute ( final ExecutionEvent handlerEvent ) throws ExecutionException
    {
        final IWorkbenchPart part = getActivePage ().getActivePart ();
        if ( ! ( part instanceof MonitorSubscriptionAlarmsEventsView ) )
        {
            return null;
        }

        final MonitorSubscriptionAlarmsEventsView view = (MonitorSubscriptionAlarmsEventsView)part;

        final Iterator<?> i = getSelection ().iterator ();

        while ( i.hasNext () )
        {
            final AckInformation ackInformation = AdapterHelper.adapt ( i.next (), AckInformation.class );
            if ( ackInformation == null )
            {
                continue;
            }

            final MonitorStatus status = ackInformation.getMonitorStatus ();
            switch ( status )
            {
                case NOT_AKN:
                case NOT_OK_NOT_AKN:
                    view.acknowledgeMonitor ( ackInformation.getMonitorId (), ackInformation.getTimestamp (), new DisplayCallbackHandler ( getShell (), "Acknowledge", "Confirmation required" ) );
                    break;
                default:
                    break;
            }
        }

        return null;
    }
}
