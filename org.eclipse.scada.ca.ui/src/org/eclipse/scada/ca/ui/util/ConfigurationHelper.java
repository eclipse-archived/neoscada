/*******************************************************************************
 * Copyright (c) 2010, 2014 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     IBH SYSTEMS GmbH - improve error reporting
 *******************************************************************************/
package org.eclipse.scada.ca.ui.util;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.scada.ca.client.Connection;
import org.eclipse.scada.ca.data.ConfigurationInformation;
import org.eclipse.scada.ca.data.FactoryInformation;
import org.eclipse.scada.utils.concurrent.NotifyFuture;

public class ConfigurationHelper
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

    /**
     * Convert from the remote data format to local data format
     *
     * @param remoteData
     *            remote data
     * @param data
     *            local data target
     * @return the number of entries found
     */
    public static long convert ( final Collection<FactoryInformation> remoteData, final Map<String, Map<String, Map<String, String>>> data )
    {
        long count = 0;

        // convert to local data type structure
        for ( final FactoryInformation factory : remoteData )
        {
            final Map<String, Map<String, String>> factoryData = new HashMap<String, Map<String, String>> ();
            data.put ( factory.getId (), factoryData );

            if ( factory.getConfigurations () != null )
            {
                for ( final ConfigurationInformation configuration : factory.getConfigurations () )
                {
                    factoryData.put ( configuration.getId (), configuration.getData () );
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * Convert from the remote data format to local data format
     *
     * @param remoteData
     *            the remote data format
     * @return the local data format
     */
    public static Map<String, Map<String, Map<String, String>>> convert ( final Collection<FactoryInformation> remoteData )
    {
        final Map<String, Map<String, Map<String, String>>> data = new HashMap<String, Map<String, Map<String, String>>> ();
        convert ( remoteData, data );
        return data;
    }

}
