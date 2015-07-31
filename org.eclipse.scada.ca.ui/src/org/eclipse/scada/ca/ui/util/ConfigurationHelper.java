/*******************************************************************************
 * Copyright (c) 2010, 2015 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     IBH SYSTEMS GmbH - improve error reporting, relocate diff helper
 *******************************************************************************/
package org.eclipse.scada.ca.ui.util;

import java.util.Collection;
import java.util.LinkedList;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.scada.ca.client.Connection;
import org.eclipse.scada.ca.data.FactoryInformation;
import org.eclipse.scada.utils.concurrent.NotifyFuture;

public class ConfigurationHelper extends org.eclipse.scada.ca.utils.ConfigurationHelper
{
    public static Collection<FactoryInformation> loadData ( final IProgressMonitor monitor, final Connection connection ) throws Exception
    {
        final Collection<FactoryInformation> result = new LinkedList<FactoryInformation> ();
        try
        {
            if ( connection == null )
            {
                throw new IllegalStateException ( Messages.ConfigurationHelper_NoConnection );
            }

            final NotifyFuture<FactoryInformation[]> future = connection.getFactories ();
            final FactoryInformation[] factories = future.get ();
            monitor.beginTask ( Messages.ConfigurationHelper_TaskName, factories.length );
            for ( final FactoryInformation factory : factories )
            {
                monitor.subTask ( String.format ( Messages.ConfigurationHelper_SubTaskNameFormat, factory.getId () ) );
                result.add ( connection.getFactoryWithData ( factory.getId () ).get () );
                monitor.worked ( 1 );
                if ( monitor.isCanceled () )
                {
                    return null;
                }
            }
        }
        finally
        {
            monitor.done ();
        }
        return result;
    }
}
