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
package org.eclipse.scada.configuration.modbus.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.scada.configuration.modbus.*;
import org.eclipse.scada.configuration.modbus.ModbusBlock;
import org.eclipse.scada.configuration.modbus.ModbusDevice;
import org.eclipse.scada.configuration.modbus.ModbusDriver;
import org.eclipse.scada.configuration.modbus.ModbusFactory;
import org.eclipse.scada.configuration.modbus.ModbusMaster;
import org.eclipse.scada.configuration.modbus.ModbusPackage;
import org.eclipse.scada.configuration.modbus.ModbusSlave;
import org.eclipse.scada.configuration.modbus.ProtocolType;
import org.eclipse.scada.da.server.osgi.modbus.RequestType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ModbusFactoryImpl extends EFactoryImpl implements ModbusFactory
{
    /**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static ModbusFactory init ()
    {
        try
        {
            ModbusFactory theModbusFactory = (ModbusFactory)EPackage.Registry.INSTANCE.getEFactory ( ModbusPackage.eNS_URI );
            if ( theModbusFactory != null )
            {
                return theModbusFactory;
            }
        }
        catch ( Exception exception )
        {
            EcorePlugin.INSTANCE.log ( exception );
        }
        return new ModbusFactoryImpl ();
    }

    /**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ModbusFactoryImpl ()
    {
        super ();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EObject create ( EClass eClass )
    {
        switch ( eClass.getClassifierID () )
        {
            case ModbusPackage.MODBUS_DEVICE:
                return createModbusDevice ();
            case ModbusPackage.MODBUS_DRIVER:
                return createModbusDriver ();
            case ModbusPackage.MODBUS_SLAVE:
                return createModbusSlave ();
            case ModbusPackage.MODBUS_MASTER:
                return createModbusMaster ();
            case ModbusPackage.MODBUS_BLOCK:
                return createModbusBlock ();
            case ModbusPackage.MODBUS_EXPORTER:
                return createModbusExporter ();
            case ModbusPackage.MODBUS_EXPORTER_DEVICE:
                return createModbusExporterDevice ();
            case ModbusPackage.MODBUS_EXPORTER_ITEM:
                return createModbusExporterItem ();
            case ModbusPackage.MODBUS_DOUBLE:
                return createModbusDouble ();
            case ModbusPackage.MODBUS_SINT16:
                return createModbusSInt16 ();
            case ModbusPackage.MODBUS_SINT32:
                return createModbusSInt32 ();
            case ModbusPackage.MODBUS_UINT16:
                return createModbusUInt16 ();
            case ModbusPackage.MODBUS_UINT32:
                return createModbusUInt32 ();
            default:
                throw new IllegalArgumentException ( "The class '" + eClass.getName () + "' is not a valid classifier" ); //$NON-NLS-1$ //$NON-NLS-2$
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object createFromString ( EDataType eDataType, String initialValue )
    {
        switch ( eDataType.getClassifierID () )
        {
            case ModbusPackage.PROTOCOL_TYPE:
                return createProtocolTypeFromString ( eDataType, initialValue );
            case ModbusPackage.REQUEST_TYPE:
                return createRequestTypeFromString ( eDataType, initialValue );
            default:
                throw new IllegalArgumentException ( "The datatype '" + eDataType.getName () + "' is not a valid classifier" ); //$NON-NLS-1$ //$NON-NLS-2$
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String convertToString ( EDataType eDataType, Object instanceValue )
    {
        switch ( eDataType.getClassifierID () )
        {
            case ModbusPackage.PROTOCOL_TYPE:
                return convertProtocolTypeToString ( eDataType, instanceValue );
            case ModbusPackage.REQUEST_TYPE:
                return convertRequestTypeToString ( eDataType, instanceValue );
            default:
                throw new IllegalArgumentException ( "The datatype '" + eDataType.getName () + "' is not a valid classifier" ); //$NON-NLS-1$ //$NON-NLS-2$
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ModbusDevice createModbusDevice ()
    {
        ModbusDeviceImpl modbusDevice = new ModbusDeviceImpl ();
        return modbusDevice;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ModbusDriver createModbusDriver ()
    {
        ModbusDriverImpl modbusDriver = new ModbusDriverImpl ();
        return modbusDriver;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ModbusSlave createModbusSlave ()
    {
        ModbusSlaveImpl modbusSlave = new ModbusSlaveImpl ();
        return modbusSlave;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ModbusMaster createModbusMaster ()
    {
        ModbusMasterImpl modbusMaster = new ModbusMasterImpl ();
        return modbusMaster;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ModbusBlock createModbusBlock ()
    {
        ModbusBlockImpl modbusBlock = new ModbusBlockImpl ();
        return modbusBlock;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ModbusExporter createModbusExporter ()
    {
        ModbusExporterImpl modbusExporter = new ModbusExporterImpl ();
        return modbusExporter;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ModbusExporterDevice createModbusExporterDevice ()
    {
        ModbusExporterDeviceImpl modbusExporterDevice = new ModbusExporterDeviceImpl ();
        return modbusExporterDevice;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ModbusExporterItem createModbusExporterItem ()
    {
        ModbusExporterItemImpl modbusExporterItem = new ModbusExporterItemImpl ();
        return modbusExporterItem;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ModbusDouble createModbusDouble ()
    {
        ModbusDoubleImpl modbusDouble = new ModbusDoubleImpl ();
        return modbusDouble;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ModbusSInt16 createModbusSInt16 ()
    {
        ModbusSInt16Impl modbusSInt16 = new ModbusSInt16Impl ();
        return modbusSInt16;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ModbusSInt32 createModbusSInt32 ()
    {
        ModbusSInt32Impl modbusSInt32 = new ModbusSInt32Impl ();
        return modbusSInt32;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ModbusUInt16 createModbusUInt16 ()
    {
        ModbusUInt16Impl modbusUInt16 = new ModbusUInt16Impl ();
        return modbusUInt16;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ModbusUInt32 createModbusUInt32 ()
    {
        ModbusUInt32Impl modbusUInt32 = new ModbusUInt32Impl ();
        return modbusUInt32;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ProtocolType createProtocolTypeFromString ( EDataType eDataType, String initialValue )
    {
        ProtocolType result = ProtocolType.get ( initialValue );
        if ( result == null )
            throw new IllegalArgumentException ( "The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName () + "'" ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        return result;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String convertProtocolTypeToString ( EDataType eDataType, Object instanceValue )
    {
        return instanceValue == null ? null : instanceValue.toString ();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public RequestType createRequestTypeFromString ( EDataType eDataType, String initialValue )
    {
        return (RequestType)super.createFromString ( eDataType, initialValue );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String convertRequestTypeToString ( EDataType eDataType, Object instanceValue )
    {
        return super.convertToString ( eDataType, instanceValue );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ModbusPackage getModbusPackage ()
    {
        return (ModbusPackage)getEPackage ();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
    @Deprecated
    public static ModbusPackage getPackage ()
    {
        return ModbusPackage.eINSTANCE;
    }

} //ModbusFactoryImpl
