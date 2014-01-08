/*******************************************************************************
 * Copyright (c) 2013 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.configuration.modbus.lib;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.validation.IValidationContext;
import org.eclipse.emf.validation.model.ConstraintStatus;
import org.eclipse.scada.configuration.infrastructure.AbstractFactoryDriver;
import org.eclipse.scada.configuration.infrastructure.Device;
import org.eclipse.scada.configuration.infrastructure.EquinoxDriver;
import org.eclipse.scada.configuration.infrastructure.Node;
import org.eclipse.scada.configuration.infrastructure.lib.AbstractEquinoxDriverFactory;
import org.eclipse.scada.configuration.infrastructure.lib.DeviceTypeValidator;
import org.eclipse.scada.configuration.infrastructure.lib.Worlds;
import org.eclipse.scada.configuration.memory.TypeSystem;
import org.eclipse.scada.configuration.memory.manager.MemoryManagerFactory;
import org.eclipse.scada.configuration.memory.manager.MemoryManagerModule;
import org.eclipse.scada.configuration.modbus.ModbusBlock;
import org.eclipse.scada.configuration.modbus.ModbusDevice;
import org.eclipse.scada.configuration.modbus.ModbusDriver;
import org.eclipse.scada.configuration.modbus.ModbusFactory;
import org.eclipse.scada.configuration.modbus.ModbusMaster;
import org.eclipse.scada.configuration.modbus.ModbusSlave;
import org.eclipse.scada.configuration.modbus.ProtocolType;
import org.eclipse.scada.configuration.world.Endpoint;

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

        final Endpoint ep = Worlds.createEndpoint ( device.getPort (), "Modbus Device Endpoint" );
        master.setEndpoint ( ep );
        master.setProtocolType ( device.getProtocolType () );
        master.setInterFrameDelay ( device.getInterFrameDelay () );

        // lookup node
        final org.eclipse.scada.configuration.world.Node node = nodes.get ( device.getNode () );
        if ( node == null )
        {
            throw new IllegalStateException ( String.format ( "Node %s was not found in target model", device.getNode () ) );
        }
        node.getEndpoints ().add ( ep );

        master.getSlaves ().addAll ( EcoreUtil.copyAll ( device.getSlaves () ) );
    }

    @Override
    protected void performValidation ( final IValidationContext ctx, final EquinoxDriver driver, final Collection<IStatus> result )
    {
        super.performValidation ( ctx, driver, result );

        final Set<TypeSystem> typeSystems = new HashSet<> ();

        for ( final Device device : driver.getDevices () )
        {
            if ( ! ( device instanceof ModbusDevice ) )
            {
                throw new IllegalStateException ( String.format ( "Device type %s is not supported", device.getClass () ) );
            }

            typeSystems.add ( ( (ModbusDevice)device ).getTypeSystem () );

            validateDevice ( ctx, driver, (ModbusDevice)device, result );
        }

        if ( typeSystems.size () > 1 )
        {
            result.add ( ConstraintStatus.createStatus ( ctx, driver, null, "All modbus devices of one driver instance must share the same type system ({})", typeSystems ) );
        }
    }

    private void validateDevice ( final IValidationContext ctx, final EquinoxDriver driver, final ModbusDevice device, final Collection<IStatus> result )
    {
        if ( device.getProtocolType () == ProtocolType.TCP && device.getInterFrameDelay () != null )
        {
            result.add ( ConstraintStatus.createStatus ( ctx, device, null, "InterFrameDelay must not be set for TCP devices." ) );
        }
        for ( final ModbusSlave slave : device.getSlaves () )
        {
            if ( slave.getUnitAddress () == 0x00 || slave.getUnitAddress () == 0xFF )
            {
                result.add ( ConstraintStatus.createStatus ( ctx, slave, null, "Unit address {} is invalid. Must be greater than 0x00 and less than 0xFF.", slave.getUnitAddress () ) );
            }
            for ( final ModbusBlock block : slave.getBlocks () )
            {
                if ( block.getCount () <= 0 )
                {
                    result.add ( ConstraintStatus.createStatus ( ctx, block, null, "Block size must be positive and greater than zero" ) );
                }
                if ( block.getPeriod () <= 0 )
                {
                    result.add ( ConstraintStatus.createStatus ( ctx, block, null, "Block polling period must be positive and greater than zero" ) );
                }
                if ( block.getTimeout () < 0 )
                {
                    result.add ( ConstraintStatus.createStatus ( ctx, block, null, "Block timeot must not be negative" ) );
                }
                if ( block.getStartAddress () < MIN_ADDRESS || block.getStartAddress () >= MAX_ADDRESS )
                {
                    result.add ( ConstraintStatus.createStatus ( ctx, block, null, "Block address must be between {} and {}", MIN_ADDRESS, MAX_ADDRESS ) );
                }
                if ( block.getStartAddress () + block.getCount () >= MAX_ADDRESS )
                {
                    result.add ( ConstraintStatus.createStatus ( ctx, block, null, "A start address of {} and block size of {} would read beyond the maximum.", block.getStartAddress (), block.getCount () ) );
                }
            }
        }
    }

}
