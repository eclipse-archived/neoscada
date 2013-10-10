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
package org.eclipse.scada.da.server.exporter;

import java.util.Iterator;
import java.util.ServiceLoader;

import org.eclipse.scada.da.server.exporter.HiveConfigurationType;
import org.eclipse.scada.da.core.server.Hive;
import org.eclipse.scada.da.core.server.HiveCreator;

/**
 * This hive factory creates hives by locating its {@link HiveCreator} first
 * using
 * the {@link ServiceLoader} facility
 * 
 * @author Jens Reimann
 */
public class ServiceLoaderHiveFactory extends AbstractHiveFactory
{

    @Override
    public Hive createHive ( final String reference, final HiveConfigurationType configuration ) throws Exception
    {
        final ServiceLoader<HiveCreator> serviceLoader = ServiceLoader.load ( HiveCreator.class );

        final Object configurationData = getConfigurationData ( configuration );

        final Iterator<HiveCreator> i = serviceLoader.iterator ();
        while ( i.hasNext () )
        {
            final HiveCreator creator = i.next ();
            final Hive hive = creator.createHive ( reference, configurationData );
            if ( hive != null )
            {
                return hive;
            }
        }

        return null;
    }

}
