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

import org.eclipse.scada.configuration.generator.GeneratorContext.MasterContext;
import org.eclipse.scada.configuration.modbus.ModbusExporterInterceptor;
import org.eclipse.scada.configuration.modbus.ModbusFactory;
import org.eclipse.scada.configuration.world.osgi.Item;

public class ModbusProcessor
{
    /*
     * The following type builders are not static for easier access in Java Script 
     */
    public final TypeBuilder UNSIGNED_INT_32 = new TypeBuilder ( ModbusFactory.eINSTANCE.createModbusUInt32 () );

    public final TypeBuilder SIGNED_INT_32 = new TypeBuilder ( ModbusFactory.eINSTANCE.createModbusSInt32 () );

    public final TypeBuilder UNSIGNED_INT_16 = new TypeBuilder ( ModbusFactory.eINSTANCE.createModbusUInt16 () );

    public final TypeBuilder SIGNED_INT_16 = new TypeBuilder ( ModbusFactory.eINSTANCE.createModbusSInt16 () );

    public final TypeBuilder DOUBLE = new TypeBuilder ( ModbusFactory.eINSTANCE.createModbusDouble () );

    private final ModbusExporterInterceptorHandler modbusExporterInterceptorHandler;

    private final ModbusExporterInterceptor interceptor;

    private final MasterContext masterContext;

    private final Item item;

    public ModbusProcessor ( final ModbusExporterInterceptorHandler modbusExporterInterceptorHandler, final ModbusExporterInterceptor interceptor, final MasterContext masterContext, final Item item )
    {
        this.modbusExporterInterceptorHandler = modbusExporterInterceptorHandler;
        this.interceptor = interceptor;
        this.masterContext = masterContext;
        this.item = item;
    }

    public void doExport ( final int port, final int slaveId, final int offset, final TypeBuilder typeBuilder )
    {
        this.modbusExporterInterceptorHandler.handleExport ( this.interceptor, this.masterContext, this.item, port, slaveId, offset, typeBuilder.build () );
    }
}