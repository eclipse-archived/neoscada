/*******************************************************************************
 * Copyright (c) 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.configuration.modbus.lib.internal;

import java.util.Properties;

import javax.script.ScriptContext;
import javax.script.ScriptEngineManager;
import javax.script.SimpleScriptContext;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.scada.configuration.component.ItemInterceptor;
import org.eclipse.scada.configuration.component.generator.interceptor.AbstractItemInterceptorHandler;
import org.eclipse.scada.configuration.generator.GeneratorContext.MasterContext;
import org.eclipse.scada.configuration.lib.Endpoints;
import org.eclipse.scada.configuration.modbus.ModbusDataType;
import org.eclipse.scada.configuration.modbus.ModbusExporter;
import org.eclipse.scada.configuration.modbus.ModbusExporterDevice;
import org.eclipse.scada.configuration.modbus.ModbusExporterInterceptor;
import org.eclipse.scada.configuration.modbus.ModbusExporterItem;
import org.eclipse.scada.configuration.modbus.ModbusFactory;
import org.eclipse.scada.configuration.script.Script;
import org.eclipse.scada.configuration.world.osgi.ApplicationModule;
import org.eclipse.scada.configuration.world.osgi.Item;
import org.eclipse.scada.utils.script.ScriptExecutor;

public class ModbusExporterInterceptorHandler extends AbstractItemInterceptorHandler
{

    @Override
    protected boolean processInterceptItem ( final Item item, final ItemInterceptor interceptorElement, final MasterContext masterContext, final Properties properties )
    {
        final ModbusExporterInterceptor interceptor = (ModbusExporterInterceptor)interceptorElement;

        final Script script = interceptor.getScript ();

        final ScriptEngineManager manager = new ScriptEngineManager ();
        try
        {
            final ScriptExecutor executor = new ScriptExecutor ( manager, script.getLanguage (), script.getSource (), null );
            final ScriptContext context = new SimpleScriptContext ();
            final ModbusProcessor modbus = new ModbusProcessor ( this, interceptor, masterContext, item );
            context.setAttribute ( "MODBUS", modbus, ScriptContext.ENGINE_SCOPE );
            context.setAttribute ( "item", item, ScriptContext.ENGINE_SCOPE );
            context.setAttribute ( "properties", properties, ScriptContext.ENGINE_SCOPE );
            executor.execute ( context );
        }
        catch ( final Exception e )
        {
            throw new RuntimeException ( "Failed to process script", e );
        }
        return true;
    }

    public void handleExport ( final ModbusExporterInterceptor interceptor, final MasterContext masterContext, final Item item, final int port, final int slaveId, final int offset, final ModbusDataType type )
    {
        final ModbusExporter exporter = createOrFindExporter ( masterContext );
        if ( exporter == null )
        {
            throw new RuntimeException ( "Failed to find modbus exporter" );
        }

        final ModbusExporterDevice device = createOrFindDevice ( interceptor, masterContext, exporter, port, slaveId );

        final ModbusExporterItem exporterItem = ModbusFactory.eINSTANCE.createModbusExporterItem ();
        device.getItems ().add ( exporterItem );
        exporterItem.setOffset ( offset );
        exporterItem.setSource ( item );
        exporterItem.setType ( type );
    }

    /**
     * Find or create the modbus exporter device in the modbus exporter
     * 
     * @param interceptor
     * @param masterContext
     * @param exporter
     *            the modbus exporter
     * @param port
     *            the modbus port number to use
     * @param slaveId
     *            the modbus device slave id
     * @return the modbus exporter device, never returns <code>null</code>
     */
    private ModbusExporterDevice createOrFindDevice ( final ModbusExporterInterceptor interceptor, final MasterContext masterContext, final ModbusExporter exporter, final int port, final int slaveId )
    {
        for ( final ModbusExporterDevice device : exporter.getDevices () )
        {
            if ( device.getPort ().getPortNumber () == port )
            {
                if ( device.getSlaveId () != slaveId )
                {
                    throw new IllegalStateException ( String.format ( "At the moment each modbus exporter can only handle one slave id per port" ) );
                }

                return device;
            }
        }

        final ModbusExporterDevice device = ModbusFactory.eINSTANCE.createModbusExporterDevice ();
        device.setDataOrder ( interceptor.getSettings ().getDataOrder () );
        device.setSlaveId ( slaveId );
        device.getProperties ().addAll ( EcoreUtil.copyAll ( interceptor.getSettings ().getProperties () ) );

        device.setPort ( Endpoints.registerEndpoint ( masterContext.getImplementation (), (short)port, String.format ( "Modbus Exporter: %s", masterContext.getDefinition ().getName () ) ) );

        exporter.getDevices ().add ( device );
        return device;
    }

    /**
     * Find or create the modbus exporter module on the target master
     * 
     * @param masterContext
     *            the target master
     * @return the modbus exporter, never returns <code>null</code>
     */
    private ModbusExporter createOrFindExporter ( final MasterContext masterContext )
    {
        for ( final ApplicationModule module : masterContext.getImplementation ().getModules () )
        {
            if ( module instanceof ModbusExporter )
            {
                return (ModbusExporter)module;
            }
        }

        final ModbusExporter exporter = ModbusFactory.eINSTANCE.createModbusExporter ();
        masterContext.getImplementation ().getModules ().add ( exporter );

        return exporter;
    }
}
