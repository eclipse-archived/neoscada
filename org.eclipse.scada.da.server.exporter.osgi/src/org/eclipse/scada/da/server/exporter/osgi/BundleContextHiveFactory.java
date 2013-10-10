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
package org.eclipse.scada.da.server.exporter.osgi;

import java.util.Collection;

import org.eclipse.scada.da.server.exporter.AbstractHiveFactory;
import org.eclipse.scada.da.server.exporter.ConfigurationException;
import org.eclipse.scada.da.server.exporter.HiveConfigurationType;
import org.eclipse.scada.da.server.exporter.HiveFactory;
import org.eclipse.scada.da.core.server.Hive;
import org.eclipse.scada.da.core.server.HiveCreator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BundleContextHiveFactory extends AbstractHiveFactory implements HiveFactory
{

    private final static Logger logger = LoggerFactory.getLogger ( BundleContextHiveFactory.class );

    private final BundleContext context;

    public BundleContextHiveFactory ( final BundleContext context )
    {
        this.context = context;
    }

    @Override
    public Hive createHive ( final String reference, final HiveConfigurationType configuration ) throws ConfigurationException
    {
        try
        {
            final Object configurationData = getConfigurationData ( configuration );

            final Collection<ServiceReference<HiveCreator>> refs = this.context.getServiceReferences ( HiveCreator.class, String.format ( "(%s=%s)", HiveCreator.SERVICE_REFERENCE_TYPE, reference ) );
            if ( refs.isEmpty () )
            {
                throw new ConfigurationException ( "Unable to create hive", new IllegalArgumentException ( String.format ( "Hive '%s' is unknown", reference ) ) );
            }

            final ServiceReference<HiveCreator> first = refs.iterator ().next ();
            final HiveCreator service = this.context.getService ( first );
            try
            {
                logger.debug ( "Delegating call to: {}", service );
                final Hive result = service.createHive ( reference, configurationData );
                if ( result == null )
                {
                    throw new IllegalArgumentException ( "Creator did not create hive" );
                }
                return result;
            }
            catch ( final Exception e )
            {
                throw new ConfigurationException ( "Failed to create hive", e );
            }
            finally
            {
                this.context.ungetService ( first );
            }
        }
        catch ( final InvalidSyntaxException e )
        {
            throw new ConfigurationException ( "Failed to locate services", e );
        }
    }

}
