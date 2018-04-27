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
package org.eclipse.neoscada.configuration.iec60870.lib;

import java.util.Properties;

import javax.script.ScriptContext;
import javax.script.ScriptEngineManager;
import javax.script.SimpleScriptContext;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.neoscada.configuration.iec60870.AddressInformation;
import org.eclipse.neoscada.configuration.iec60870.DataType;
import org.eclipse.neoscada.configuration.iec60870.Device;
import org.eclipse.neoscada.configuration.iec60870.Exporter;
import org.eclipse.neoscada.configuration.iec60870.ExporterItemInterceptor;
import org.eclipse.neoscada.configuration.iec60870.IEC60870Factory;
import org.eclipse.scada.configuration.component.ItemInterceptor;
import org.eclipse.scada.configuration.component.generator.interceptor.AbstractItemInterceptorHandler;
import org.eclipse.scada.configuration.generator.GeneratorContext.MasterContext;
import org.eclipse.scada.configuration.lib.Endpoints;
import org.eclipse.scada.configuration.script.Script;
import org.eclipse.scada.configuration.world.Endpoint;
import org.eclipse.scada.configuration.world.osgi.ApplicationModule;
import org.eclipse.scada.configuration.world.osgi.Item;
import org.eclipse.scada.utils.script.ScriptExecutor;

public class ExporterInterceptorHandler extends AbstractItemInterceptorHandler
{

    @Override
    protected boolean processInterceptItem ( final Item item, final ItemInterceptor interceptorElement, final MasterContext masterContext, final Properties properties )
    {
        final ExporterItemInterceptor interceptor = (ExporterItemInterceptor)interceptorElement;

        final Script script = interceptor.getScript ();

        final ScriptEngineManager manager = new ScriptEngineManager ();
        try
        {
            final ScriptExecutor executor = new ScriptExecutor ( manager, script.getLanguage (), script.getSource (), null );
            final ScriptContext context = new SimpleScriptContext ();
            final IEC60870Processor modbus = new IEC60870Processor ( this, interceptor, masterContext, item );
            context.setAttribute ( "IEC60870", modbus, ScriptContext.ENGINE_SCOPE );
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

    public void processExport ( final ExporterItemInterceptor interceptor, final MasterContext masterContext, final Item item, final AddressInformation address, final DataType type )
    {
        final Exporter exporter = createOrGetExporterImpl ( masterContext );

        final Device device = createOrGetDevice ( exporter, interceptor, masterContext );
        final org.eclipse.neoscada.configuration.iec60870.Item exportItem = IEC60870Factory.eINSTANCE.createItem ();
        exportItem.setAddress ( address );
        exportItem.setSource ( item );
        exportItem.setType ( type );

        device.getItems ().add ( exportItem );
    }

    private Device createOrGetDevice ( final Exporter exporter, final ExporterItemInterceptor interceptor, final MasterContext masterContext )
    {
        final String id = String.format ( "iec.exporter.%s", interceptor.getPort () ); //$NON-NLS-1$

        for ( final Device device : exporter.getDevices () )
        {
            if ( device.getId ().equals ( id ) )
            {
                return device;
            }
        }

        final Device device = IEC60870Factory.eINSTANCE.createDevice ();

        device.setId ( id );

        final Endpoint ep = Endpoints.registerEndpoint ( masterContext.getImplementation (), interceptor.getPort (), Endpoints.reference ( device ), "IEC60870 exporter" );
        device.setEndpoint ( ep );

        device.setSpontaneousBufferWindow ( interceptor.getSpontaneousBufferWindow () );
        device.setCyclicPeriod ( interceptor.getCyclicPeriod () );

        device.setDataModuleOptions ( EcoreUtil.copy ( interceptor.getDataModuleOptions () ) );
        device.setProtocolOptions ( EcoreUtil.copy ( interceptor.getProtocolOptions () ) );
        device.getHiveProperties ().addAll ( EcoreUtil.copyAll ( interceptor.getHiveProperties () ) );

        exporter.getDevices ().add ( device );

        return device;
    }

    protected Exporter createOrGetExporterImpl ( final MasterContext masterContext )
    {
        for ( final ApplicationModule module : masterContext.getImplementation ().getModules () )
        {
            if ( module instanceof Exporter )
            {
                return (Exporter)module;
            }
        }

        final Exporter exporter = IEC60870Factory.eINSTANCE.createExporter ();
        masterContext.getImplementation ().getModules ().add ( exporter );
        return exporter;
    }
}
