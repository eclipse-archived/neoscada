/*******************************************************************************
 * Copyright (c) 2013, 2014 Protos GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Protos GmbH - initial API and implementation
 *     IBH SYSTEMS GmbH - add profile handling, fix some issues, refactor
 *          PropertyEntry
 *******************************************************************************/
package org.eclipse.scada.configuration.modbus.lib;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.scada.configuration.generator.Profiles;
import org.eclipse.scada.configuration.modbus.ModbusExporter;
import org.eclipse.scada.configuration.modbus.ModbusExporterDevice;
import org.eclipse.scada.configuration.modbus.ModbusExporterItem;
import org.eclipse.scada.configuration.modbus.ModbusPackage;
import org.eclipse.scada.configuration.world.PropertyEntry;
import org.eclipse.scada.configuration.world.lib.oscar.OscarContext;
import org.eclipse.scada.configuration.world.lib.oscar.OscarProcessor;
import org.eclipse.scada.configuration.world.osgi.EquinoxApplication;
import org.eclipse.scada.configuration.world.osgi.profile.Profile;

public class ModbusExporterProcessor implements OscarProcessor
{
    private static final String BUNDLE_MODBUS_EXPORTER = "org.eclipse.scada.da.server.exporter.modbus"; //$NON-NLS-1$

    static final String DEVICE_FACTORY_ID = "org.eclipse.scada.da.server.exporter.modbus.device"; //$NON-NLS-1$

    @Override
    public void process ( final OscarContext ctx, final EquinoxApplication application, final IProgressMonitor monitor )
    {
        try
        {
            final Collection<Object> exporters = EcoreUtil.getObjectsByType ( application.getModules (), ModbusPackage.Literals.MODBUS_EXPORTER );
            for ( final Object exp : exporters )
            {
                assert exp instanceof ModbusExporter;
                processExporter ( ctx, application, (ModbusExporter)exp, monitor );
            }
        }
        finally
        {
            monitor.done ();
        }
    }

    private void processExporter ( final OscarContext ctx, final EquinoxApplication application, final ModbusExporter exporter, final IProgressMonitor monitor )
    {
        final Profile profile = Profiles.createOrGetCustomizationProfile ( application );
        Profiles.addStartBundle ( profile, BUNDLE_MODBUS_EXPORTER );
        profile.getInstallationUnits ().add ( BUNDLE_MODBUS_EXPORTER );

        for ( final ModbusExporterDevice device : exporter.getDevices () )
        {
            validateDevice ( device );

            processDevice ( ctx, application, device, monitor );
        }
    }

    /**
     * Validates a ModbusExporterDevice instance using the EMF core validator
     * API. The
     * contained ModbusExporterItems are also validated.
     * 
     * @param device
     *            the ModbusExporterDevice to validate
     * @throws IllegalStateException
     *             if validation errors are encountered
     */
    private void validateDevice ( final ModbusExporterDevice device )
    {
        // Also validates contained ModbusExporterItems
        final Diagnostic diag = Diagnostician.INSTANCE.validate ( device );
        if ( diag.getSeverity () == Diagnostic.ERROR )
        {
            String msg = "Invalid Modbus Exporter Device";
            for ( final Diagnostic child : diag.getChildren () )
            {
                if ( child.getSeverity () == Diagnostic.ERROR )
                {
                    msg += "\n" + child.getMessage (); //$NON-NLS-1$
                }
            }
            throw new IllegalStateException ( msg );
        }
    }

    private void processDevice ( final OscarContext ctx, final EquinoxApplication application, final ModbusExporterDevice device, final IProgressMonitor monitor )
    {
        final String id = Integer.toString ( device.getPort ().getPortNumber () ) + "." + Integer.toString ( device.getSlaveId () ); //$NON-NLS-1$
        final Map<String, String> data = new HashMap<String, String> ();
        data.put ( "port", Integer.toString ( device.getPort ().getPortNumber () ) ); //$NON-NLS-1$
        data.put ( "slaveId", Integer.toString ( device.getSlaveId () ) ); //$NON-NLS-1$
        data.put ( "dataOrder", "" + device.getDataOrder () );
        // Add device properties
        for ( final PropertyEntry property : device.getProperties () )
        {
            final String key = "hive." + property.getKey (); //$NON-NLS-1$
            data.put ( key, property.getValue () );
        }
        // Add item data
        for ( final ModbusExporterItem item : device.getItems () )
        {
            processItem ( data, item );
        }
        ctx.addData ( DEVICE_FACTORY_ID, id, data );
    }

    private void processItem ( final Map<String, String> data, final ModbusExporterItem item )
    {
        final String id = "item." + item.getSource ().getName (); //$NON-NLS-1$
        // Convert item to String value 
        String value = Integer.toString ( item.getOffset () ) + ":" + item.getType ().getName (); //$NON-NLS-1$
        // Optional scale attribute
        if ( item.getType ().getScale () != null )
        {
            value += ":" + item.getType ().getScale (); //$NON-NLS-1$
        }

        data.put ( id, value.toString () );
    }
}
