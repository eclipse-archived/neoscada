/*******************************************************************************
 * Copyright (c) 2013, 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.configuration.modbus.lib;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.scada.configuration.infrastructure.AbstractFactoryDriver;
import org.eclipse.scada.configuration.infrastructure.Device;
import org.eclipse.scada.configuration.infrastructure.EquinoxDriver;
import org.eclipse.scada.configuration.infrastructure.Node;
import org.eclipse.scada.configuration.infrastructure.lib.AbstractEquinoxDriverFactory;
import org.eclipse.scada.configuration.infrastructure.lib.DeviceTypeValidator;
import org.eclipse.scada.configuration.lib.Endpoints;
import org.eclipse.scada.configuration.memory.TypeHelper;
import org.eclipse.scada.configuration.memory.TypeSystem;
import org.eclipse.scada.configuration.memory.manager.MemoryManagerFactory;
import org.eclipse.scada.configuration.memory.manager.MemoryManagerModule;
import org.eclipse.scada.configuration.modbus.ModbusBlock;
import org.eclipse.scada.configuration.modbus.ModbusDevice;
import org.eclipse.scada.configuration.modbus.ModbusDriver;
import org.eclipse.scada.configuration.modbus.ModbusFactory;
import org.eclipse.scada.configuration.modbus.ModbusMaster;
import org.eclipse.scada.configuration.modbus.ModbusPackage;
import org.eclipse.scada.configuration.modbus.ModbusSlave;
import org.eclipse.scada.configuration.modbus.ProtocolType;
import org.eclipse.scada.configuration.world.Endpoint;
import org.eclipse.scada.utils.ecore.validation.Severity;
import org.eclipse.scada.utils.ecore.validation.ValidationContext;

public class DriverFactoryImpl extends AbstractEquinoxDriverFactory<ModbusDriver>
{

    private static final int MIN_ADDRESS = 0;

    private static final int MAX_ADDRESS = 64 * 1024;

    public DriverFactoryImpl ()
    {
        addValidator ( new DeviceTypeValidator<EquinoxDriver> ( ModbusDevice.class ) );
    }

    @Override
    protected ModbusDriver createDriver ()
    {
        return ModbusFactory.eINSTANCE.createModbusDriver ();
    }

    @Override
    protected void configureDriver ( final AbstractFactoryDriver driver, final ModbusDriver result, final Map<Node, org.eclipse.scada.configuration.world.Node> nodes )
    {
        final MemoryManagerModule manager = MemoryManagerFactory.eINSTANCE.createMemoryManagerModule ();
        result.getModules ().add ( manager );

        for ( final Device device : driver.getDevices () )
        {
            if ( ! ( device instanceof ModbusDevice ) )
            {
                throw new IllegalStateException ( String.format ( "Device type %s is not supported", device.getClass () ) );
            }

            if ( manager.getTypeSystem () == null )
            {
                manager.setTypeSystem ( ( (ModbusDevice)device ).getTypeSystem () );
            }
            else if ( ( (ModbusDevice)device ).getTypeSystem () != null )
            {
                if ( manager.getTypeSystem ().getName ().equals ( ( (ModbusDevice)device ).getTypeSystem ().getName () ) )
                {
                    throw new IllegalStateException ( "All modbus devices must share the same type system" );
                }
            }

            createDevice ( driver, result, (ModbusDevice)device, nodes );
        }
    }

    protected void createDevice ( final AbstractFactoryDriver driver, final ModbusDriver result, final ModbusDevice device, final Map<Node, org.eclipse.scada.configuration.world.Node> nodes )
    {
        final ModbusMaster master = ModbusFactory.eINSTANCE.createModbusMaster ();

        master.setId ( device.getName () );
        result.getMasters ().add ( master );

        final Endpoint ep = Endpoints.registerEndpoint ( nodes.get ( device.getNode () ), device.getPort (), null, "Modbus Device Endpoint" );
        master.setEndpoint ( ep );
        master.setProtocolType ( device.getProtocolType () );
        master.setInterFrameDelay ( device.getInterFrameDelay () );

        master.getSlaves ().addAll ( EcoreUtil.copyAll ( device.getSlaves () ) );
    }

    @Override
    protected void performValidation ( final ValidationContext ctx, final EquinoxDriver driver )
    {
        super.performValidation ( ctx, driver );

        final Set<TypeSystem> typeSystems = new HashSet<> ();

        for ( final Device device : driver.getDevices () )
        {
            if ( ! ( device instanceof ModbusDevice ) )
            {
                throw new IllegalStateException ( String.format ( "Device type %s is not supported", device.getClass () ) );
            }

            typeSystems.add ( ( (ModbusDevice)device ).getTypeSystem () );

            validateDevice ( ctx, driver, (ModbusDevice)device );
        }

        if ( typeSystems.size () > 1 )
        {
            ctx.add ( ModbusPackage.Literals.MODBUS_DEVICE__TYPE_SYSTEM, "All modbus devices of one driver instance must share the same type system ({0})", typeSystems );
        }
    }

    private void validateDevice ( final ValidationContext ctx, final EquinoxDriver driver, final ModbusDevice device )
    {
        if ( device.getProtocolType () == ProtocolType.TCP && device.getInterFrameDelay () != null )
        {
            ctx.add ( Severity.ERROR, new Object[] { device, ModbusPackage.Literals.MODBUS_DEVICE__INTER_FRAME_DELAY }, "InterFrameDelay must not be set for TCP devices." );
        }
        for ( final ModbusSlave slave : device.getSlaves () )
        {
            if ( slave.getUnitAddress () == 0x00 || slave.getUnitAddress () == 0xFF )
            {
                ctx.add ( Severity.ERROR, new Object[] { slave, ModbusPackage.Literals.MODBUS_SLAVE__UNIT_ADDRESS }, "Unit address {0} is invalid. Must be greater than 0x00 and less than 0xFF.", slave.getUnitAddress () );
            }
            for ( final ModbusBlock block : slave.getBlocks () )
            {
                if ( block.getCount () <= 0 )
                {
                    ctx.add ( Severity.ERROR, new Object[] { block, ModbusPackage.Literals.MODBUS_BLOCK__COUNT }, "Block size must be positive and greater than zero" );
                }
                if ( block.getPeriod () <= 0 )
                {
                    ctx.add ( Severity.ERROR, new Object[] { block, ModbusPackage.Literals.MODBUS_BLOCK__PERIOD }, "Block polling period must be positive and greater than zero" );
                }
                if ( block.getTimeout () < 0 )
                {
                    ctx.add ( Severity.ERROR, new Object[] { block, ModbusPackage.Literals.MODBUS_BLOCK__TIMEOUT }, "Block timeout must not be negative" );
                }
                if ( block.getStartAddress () < MIN_ADDRESS || block.getStartAddress () >= MAX_ADDRESS )
                {
                    ctx.add ( Severity.ERROR, new Object[] { block, ModbusPackage.Literals.MODBUS_BLOCK__START_ADDRESS }, "Block address must be between {0} and {1}", MIN_ADDRESS, MAX_ADDRESS );
                }
                if ( block.getStartAddress () + block.getCount () >= MAX_ADDRESS )
                {
                    ctx.add ( Severity.ERROR, new Object[] { block }, "A start address of {0} and block size of {1} would read beyond the maximum.", block.getStartAddress (), block.getCount () );
                }
                final int typeLen = TypeHelper.calculateByteSize ( block.getType () );
                if ( block.getCount () * 2 < typeLen )
                {
                    ctx.add ( Severity.ERROR, new Object[] { block }, "The defined block type ({0} bytes) is bigger than the block request ({1} bytes / {2} registers).", typeLen, block.getCount () * 2, block.getCount () );
                }
                validateTypeSystem ( device.getTypeSystem (), block, device, ctx );
            }
        }
    }

    private void validateTypeSystem ( final TypeSystem typeSystem, final ModbusBlock block, final ModbusDevice device, final ValidationContext ctx )
    {
        if ( !TypeHelper.hasType ( typeSystem, block.getType () ) )
        {
            ctx.add ( Severity.ERROR, new Object[] { block, ModbusPackage.Literals.MODBUS_BLOCK__TYPE }, "Block type {0} is not define in the type system of the device {1}", block.getId (), device.getName () );
        }
    }
}
