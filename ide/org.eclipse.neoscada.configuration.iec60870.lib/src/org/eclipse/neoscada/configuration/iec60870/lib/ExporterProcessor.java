/*******************************************************************************
 * Copyright (c) 2014, 2016 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.neoscada.configuration.iec60870.lib;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.neoscada.configuration.iec60870.Device;
import org.eclipse.neoscada.configuration.iec60870.Exporter;
import org.eclipse.neoscada.configuration.iec60870.IEC60870Package;
import org.eclipse.neoscada.configuration.iec60870.Item;
import org.eclipse.scada.configuration.generator.Profiles;
import org.eclipse.scada.configuration.world.PropertyEntry;
import org.eclipse.scada.configuration.world.lib.oscar.OscarContext;
import org.eclipse.scada.configuration.world.lib.oscar.OscarProcessor;
import org.eclipse.scada.configuration.world.osgi.EquinoxApplication;
import org.eclipse.scada.configuration.world.osgi.profile.Profile;

public class ExporterProcessor implements OscarProcessor
{
    private static final String BUNDLE_IEC60870_EXPORTER = "org.eclipse.neoscada.da.server.exporter.iec60870"; //$NON-NLS-1$

    private static final String DEVICE_FACTORY_ID = "org.eclipse.neoscada.da.server.exporter.iec60870.device"; //$NON-NLS-1$

    @Override
    public void process ( final OscarContext ctx, final EquinoxApplication application, final IProgressMonitor monitor )
    {
        try
        {
            final Collection<Object> exporters = EcoreUtil.getObjectsByType ( application.getModules (), IEC60870Package.Literals.EXPORTER );
            for ( final Object exp : exporters )
            {
                assert exp instanceof Exporter;
                processExporter ( ctx, application, (Exporter)exp, monitor );
            }
        }
        finally
        {
            monitor.done ();
        }
    }

    private void processExporter ( final OscarContext ctx, final EquinoxApplication application, final Exporter exporter, final IProgressMonitor monitor )
    {
        final Profile profile = Profiles.createOrGetCustomizationProfile ( application );
        Profiles.addStartBundle ( profile, BUNDLE_IEC60870_EXPORTER );
        profile.getInstallationUnits ().add ( BUNDLE_IEC60870_EXPORTER );

        for ( final Device device : exporter.getDevices () )
        {
            validateDevice ( device, "IEC 60870 Exporter" );

            processDevice ( ctx, application, device, monitor );
        }
    }

    /**
     * Validates a object instance and its children using the EMF core validator
     * API.
     *
     * @param element
     *            the element to validate
     * @param label
     *            the type label of the element
     * @throws IllegalStateException
     *             if validation errors are encountered
     */
    protected static void validateDevice ( final EObject object, final String label )
    {
        final Diagnostic diag = Diagnostician.INSTANCE.validate ( object );
        if ( diag.getSeverity () == Diagnostic.ERROR )
        {
            final StringBuilder sb = new StringBuilder ( "Invalid " + label );
            for ( final Diagnostic child : diag.getChildren () )
            {
                if ( child.getSeverity () == Diagnostic.ERROR )
                {
                    sb.append ( System.lineSeparator () );
                    sb.append ( child.getMessage () );
                }
            }
            throw new IllegalStateException ( sb.toString () );
        }
    }

    private void processDevice ( final OscarContext ctx, final EquinoxApplication application, final Device device, final IProgressMonitor monitor )
    {
        final String id = device.getId ();

        final Map<String, String> data = new HashMap<String, String> ();
        data.put ( "port", Integer.toString ( device.getEndpoint ().getPortNumber () ) ); //$NON-NLS-1$

        if ( device.getSpontaneousBufferWindow () != null && device.getSpontaneousBufferWindow () > 0 )
        {
            data.put ( "spontaneousBufferWindow", device.getSpontaneousBufferWindow ().toString () ); //$NON-NLS-1$
        }
        if ( device.getCyclicPeriod () != null && device.getCyclicPeriod () > 0 )
        {
            data.put ( "cyclicPeriod", device.getCyclicPeriod ().toString () ); //$NON-NLS-1$
        }

        Configurations.encode ( data, null, device.getProtocolOptions () );
        Configurations.encode ( data, null, device.getDataModuleOptions () );

        // Add hive properties
        for ( final PropertyEntry property : device.getHiveProperties () )
        {
            final String key = "hive." + property.getKey (); //$NON-NLS-1$
            data.put ( key, property.getValue () );
        }

        // Add item data
        for ( final Item item : device.getItems () )
        {
            processItem ( data, item );
        }
        ctx.addData ( DEVICE_FACTORY_ID, id, data );
    }

    private void processItem ( final Map<String, String> data, final Item item )
    {
        final int[] addr = item.getAddress ().getAddress ();

        final String key = "entry." + String.format ( "%d-%d.%d-%d-%d", addr[0], addr[1], addr[2], addr[3], addr[4] );
        final String value = item.getType () + "#" + item.getSource ().getName ();

        data.put ( key, value );
    }
}
