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
package org.eclipse.scada.configuration.modbus;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.scada.configuration.infrastructure.InfrastructurePackage;
import org.eclipse.scada.configuration.world.WorldPackage;
import org.eclipse.scada.configuration.world.osgi.OsgiPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.scada.configuration.modbus.ModbusFactory
 * @model kind="package"
 * @generated
 */
public interface ModbusPackage extends EPackage
{
    /**
     * The package name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNAME = "modbus"; //$NON-NLS-1$

    /**
     * The package namespace URI.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_URI = "http://eclipse.org/SCADA/Configuration/Modbus"; //$NON-NLS-1$

    /**
     * The package namespace name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_PREFIX = "modbus"; //$NON-NLS-1$

    /**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    ModbusPackage eINSTANCE = org.eclipse.scada.configuration.modbus.impl.ModbusPackageImpl.init ();

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.modbus.impl.ModbusDeviceImpl <em>Device</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.modbus.impl.ModbusDeviceImpl
     * @see org.eclipse.scada.configuration.modbus.impl.ModbusPackageImpl#getModbusDevice()
     * @generated
     */
    int MODBUS_DEVICE = 0;

    /**
     * The feature id for the '<em><b>Short Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MODBUS_DEVICE__SHORT_DESCRIPTION = InfrastructurePackage.DEVICE__SHORT_DESCRIPTION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MODBUS_DEVICE__NAME = InfrastructurePackage.DEVICE__NAME;

    /**
     * The feature id for the '<em><b>Node</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MODBUS_DEVICE__NODE = InfrastructurePackage.DEVICE__NODE;

    /**
     * The feature id for the '<em><b>Port</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MODBUS_DEVICE__PORT = InfrastructurePackage.DEVICE_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Protocol Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MODBUS_DEVICE__PROTOCOL_TYPE = InfrastructurePackage.DEVICE_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Inter Frame Delay</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MODBUS_DEVICE__INTER_FRAME_DELAY = InfrastructurePackage.DEVICE_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Slaves</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MODBUS_DEVICE__SLAVES = InfrastructurePackage.DEVICE_FEATURE_COUNT + 3;

    /**
     * The feature id for the '<em><b>Type System</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MODBUS_DEVICE__TYPE_SYSTEM = InfrastructurePackage.DEVICE_FEATURE_COUNT + 4;

    /**
     * The number of structural features of the '<em>Device</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MODBUS_DEVICE_FEATURE_COUNT = InfrastructurePackage.DEVICE_FEATURE_COUNT + 5;

    /**
     * The number of operations of the '<em>Device</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MODBUS_DEVICE_OPERATION_COUNT = InfrastructurePackage.DEVICE_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.modbus.impl.ModbusDriverImpl <em>Driver</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.modbus.impl.ModbusDriverImpl
     * @see org.eclipse.scada.configuration.modbus.impl.ModbusPackageImpl#getModbusDriver()
     * @generated
     */
    int MODBUS_DRIVER = 1;

    /**
     * The feature id for the '<em><b>Short Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MODBUS_DRIVER__SHORT_DESCRIPTION = WorldPackage.DRIVER__SHORT_DESCRIPTION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MODBUS_DRIVER__NAME = WorldPackage.DRIVER__NAME;

    /**
     * The feature id for the '<em><b>Connections</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MODBUS_DRIVER__CONNECTIONS = WorldPackage.DRIVER_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Exporter</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MODBUS_DRIVER__EXPORTER = WorldPackage.DRIVER_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Customization Profile</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MODBUS_DRIVER__CUSTOMIZATION_PROFILE = WorldPackage.DRIVER_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Security Configuration</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MODBUS_DRIVER__SECURITY_CONFIGURATION = WorldPackage.DRIVER_FEATURE_COUNT + 3;

    /**
     * The feature id for the '<em><b>Modules</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MODBUS_DRIVER__MODULES = WorldPackage.DRIVER_FEATURE_COUNT + 4;

    /**
     * The feature id for the '<em><b>Masters</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MODBUS_DRIVER__MASTERS = WorldPackage.DRIVER_FEATURE_COUNT + 5;

    /**
     * The number of structural features of the '<em>Driver</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MODBUS_DRIVER_FEATURE_COUNT = WorldPackage.DRIVER_FEATURE_COUNT + 6;

    /**
     * The operation id for the '<em>Get Endpoints</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MODBUS_DRIVER___GET_ENDPOINTS = WorldPackage.DRIVER___GET_ENDPOINTS;

    /**
     * The operation id for the '<em>Get Profile</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MODBUS_DRIVER___GET_PROFILE = WorldPackage.DRIVER_OPERATION_COUNT + 0;

    /**
     * The number of operations of the '<em>Driver</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MODBUS_DRIVER_OPERATION_COUNT = WorldPackage.DRIVER_OPERATION_COUNT + 1;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.modbus.impl.ModbusSlaveImpl <em>Slave</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.modbus.impl.ModbusSlaveImpl
     * @see org.eclipse.scada.configuration.modbus.impl.ModbusPackageImpl#getModbusSlave()
     * @generated
     */
    int MODBUS_SLAVE = 2;

    /**
     * The feature id for the '<em><b>Blocks</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MODBUS_SLAVE__BLOCKS = 0;

    /**
     * The feature id for the '<em><b>Unit Address</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MODBUS_SLAVE__UNIT_ADDRESS = 1;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MODBUS_SLAVE__ID = 2;

    /**
     * The number of structural features of the '<em>Slave</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MODBUS_SLAVE_FEATURE_COUNT = 3;

    /**
     * The number of operations of the '<em>Slave</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MODBUS_SLAVE_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.modbus.impl.ModbusMasterImpl <em>Master</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.modbus.impl.ModbusMasterImpl
     * @see org.eclipse.scada.configuration.modbus.impl.ModbusPackageImpl#getModbusMaster()
     * @generated
     */
    int MODBUS_MASTER = 3;

    /**
     * The feature id for the '<em><b>Slaves</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MODBUS_MASTER__SLAVES = 0;

    /**
     * The feature id for the '<em><b>Endpoint</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MODBUS_MASTER__ENDPOINT = 1;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MODBUS_MASTER__ID = 2;

    /**
     * The feature id for the '<em><b>Protocol Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MODBUS_MASTER__PROTOCOL_TYPE = 3;

    /**
     * The feature id for the '<em><b>Inter Frame Delay</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MODBUS_MASTER__INTER_FRAME_DELAY = 4;

    /**
     * The number of structural features of the '<em>Master</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MODBUS_MASTER_FEATURE_COUNT = 5;

    /**
     * The number of operations of the '<em>Master</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MODBUS_MASTER_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.modbus.impl.ModbusBlockImpl <em>Block</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.modbus.impl.ModbusBlockImpl
     * @see org.eclipse.scada.configuration.modbus.impl.ModbusPackageImpl#getModbusBlock()
     * @generated
     */
    int MODBUS_BLOCK = 4;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MODBUS_BLOCK__ID = 0;

    /**
     * The feature id for the '<em><b>Block Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MODBUS_BLOCK__BLOCK_TYPE = 1;

    /**
     * The feature id for the '<em><b>Start Address</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MODBUS_BLOCK__START_ADDRESS = 2;

    /**
     * The feature id for the '<em><b>Count</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MODBUS_BLOCK__COUNT = 3;

    /**
     * The feature id for the '<em><b>Period</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MODBUS_BLOCK__PERIOD = 4;

    /**
     * The feature id for the '<em><b>Timeout</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MODBUS_BLOCK__TIMEOUT = 5;

    /**
     * The feature id for the '<em><b>Type</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MODBUS_BLOCK__TYPE = 6;

    /**
     * The number of structural features of the '<em>Block</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MODBUS_BLOCK_FEATURE_COUNT = 7;

    /**
     * The number of operations of the '<em>Block</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MODBUS_BLOCK_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.modbus.impl.ModbusExporterImpl <em>Exporter</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.modbus.impl.ModbusExporterImpl
     * @see org.eclipse.scada.configuration.modbus.impl.ModbusPackageImpl#getModbusExporter()
     * @generated
     */
    int MODBUS_EXPORTER = 5;

    /**
     * The feature id for the '<em><b>Devices</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MODBUS_EXPORTER__DEVICES = OsgiPackage.APPLICATION_MODULE_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Exporter</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MODBUS_EXPORTER_FEATURE_COUNT = OsgiPackage.APPLICATION_MODULE_FEATURE_COUNT + 1;

    /**
     * The number of operations of the '<em>Exporter</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MODBUS_EXPORTER_OPERATION_COUNT = OsgiPackage.APPLICATION_MODULE_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.modbus.impl.ModbusExporterDeviceImpl <em>Exporter Device</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.modbus.impl.ModbusExporterDeviceImpl
     * @see org.eclipse.scada.configuration.modbus.impl.ModbusPackageImpl#getModbusExporterDevice()
     * @generated
     */
    int MODBUS_EXPORTER_DEVICE = 6;

    /**
     * The feature id for the '<em><b>Items</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MODBUS_EXPORTER_DEVICE__ITEMS = 0;

    /**
     * The feature id for the '<em><b>Port</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MODBUS_EXPORTER_DEVICE__PORT = 1;

    /**
     * The feature id for the '<em><b>Slave Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MODBUS_EXPORTER_DEVICE__SLAVE_ID = 2;

    /**
     * The feature id for the '<em><b>Properties</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MODBUS_EXPORTER_DEVICE__PROPERTIES = 3;

    /**
     * The number of structural features of the '<em>Exporter Device</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MODBUS_EXPORTER_DEVICE_FEATURE_COUNT = 4;

    /**
     * The number of operations of the '<em>Exporter Device</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MODBUS_EXPORTER_DEVICE_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.modbus.impl.ModbusExporterItemImpl <em>Exporter Item</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.modbus.impl.ModbusExporterItemImpl
     * @see org.eclipse.scada.configuration.modbus.impl.ModbusPackageImpl#getModbusExporterItem()
     * @generated
     */
    int MODBUS_EXPORTER_ITEM = 7;

    /**
     * The feature id for the '<em><b>Source</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MODBUS_EXPORTER_ITEM__SOURCE = 0;

    /**
     * The feature id for the '<em><b>Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MODBUS_EXPORTER_ITEM__OFFSET = 1;

    /**
     * The feature id for the '<em><b>Type</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MODBUS_EXPORTER_ITEM__TYPE = 2;

    /**
     * The number of structural features of the '<em>Exporter Item</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MODBUS_EXPORTER_ITEM_FEATURE_COUNT = 3;

    /**
     * The number of operations of the '<em>Exporter Item</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MODBUS_EXPORTER_ITEM_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.modbus.ModbusDataType <em>Data Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.modbus.ModbusDataType
     * @see org.eclipse.scada.configuration.modbus.impl.ModbusPackageImpl#getModbusDataType()
     * @generated
     */
    int MODBUS_DATA_TYPE = 8;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MODBUS_DATA_TYPE__NAME = 0;

    /**
     * The feature id for the '<em><b>Scale</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MODBUS_DATA_TYPE__SCALE = 1;

    /**
     * The number of structural features of the '<em>Data Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MODBUS_DATA_TYPE_FEATURE_COUNT = 2;

    /**
     * The number of operations of the '<em>Data Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MODBUS_DATA_TYPE_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.modbus.impl.ModbusDoubleImpl <em>Double</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.modbus.impl.ModbusDoubleImpl
     * @see org.eclipse.scada.configuration.modbus.impl.ModbusPackageImpl#getModbusDouble()
     * @generated
     */
    int MODBUS_DOUBLE = 9;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MODBUS_DOUBLE__NAME = MODBUS_DATA_TYPE__NAME;

    /**
     * The feature id for the '<em><b>Scale</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MODBUS_DOUBLE__SCALE = MODBUS_DATA_TYPE__SCALE;

    /**
     * The number of structural features of the '<em>Double</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MODBUS_DOUBLE_FEATURE_COUNT = MODBUS_DATA_TYPE_FEATURE_COUNT + 0;

    /**
     * The number of operations of the '<em>Double</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MODBUS_DOUBLE_OPERATION_COUNT = MODBUS_DATA_TYPE_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.modbus.impl.ModbusSInt16Impl <em>SInt16</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.modbus.impl.ModbusSInt16Impl
     * @see org.eclipse.scada.configuration.modbus.impl.ModbusPackageImpl#getModbusSInt16()
     * @generated
     */
    int MODBUS_SINT16 = 10;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MODBUS_SINT16__NAME = MODBUS_DATA_TYPE__NAME;

    /**
     * The feature id for the '<em><b>Scale</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MODBUS_SINT16__SCALE = MODBUS_DATA_TYPE__SCALE;

    /**
     * The number of structural features of the '<em>SInt16</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MODBUS_SINT16_FEATURE_COUNT = MODBUS_DATA_TYPE_FEATURE_COUNT + 0;

    /**
     * The number of operations of the '<em>SInt16</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MODBUS_SINT16_OPERATION_COUNT = MODBUS_DATA_TYPE_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.modbus.impl.ModbusSInt32Impl <em>SInt32</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.modbus.impl.ModbusSInt32Impl
     * @see org.eclipse.scada.configuration.modbus.impl.ModbusPackageImpl#getModbusSInt32()
     * @generated
     */
    int MODBUS_SINT32 = 11;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MODBUS_SINT32__NAME = MODBUS_DATA_TYPE__NAME;

    /**
     * The feature id for the '<em><b>Scale</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MODBUS_SINT32__SCALE = MODBUS_DATA_TYPE__SCALE;

    /**
     * The number of structural features of the '<em>SInt32</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MODBUS_SINT32_FEATURE_COUNT = MODBUS_DATA_TYPE_FEATURE_COUNT + 0;

    /**
     * The number of operations of the '<em>SInt32</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MODBUS_SINT32_OPERATION_COUNT = MODBUS_DATA_TYPE_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.modbus.impl.ModbusUInt16Impl <em>UInt16</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.modbus.impl.ModbusUInt16Impl
     * @see org.eclipse.scada.configuration.modbus.impl.ModbusPackageImpl#getModbusUInt16()
     * @generated
     */
    int MODBUS_UINT16 = 12;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MODBUS_UINT16__NAME = MODBUS_DATA_TYPE__NAME;

    /**
     * The feature id for the '<em><b>Scale</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MODBUS_UINT16__SCALE = MODBUS_DATA_TYPE__SCALE;

    /**
     * The number of structural features of the '<em>UInt16</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MODBUS_UINT16_FEATURE_COUNT = MODBUS_DATA_TYPE_FEATURE_COUNT + 0;

    /**
     * The number of operations of the '<em>UInt16</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MODBUS_UINT16_OPERATION_COUNT = MODBUS_DATA_TYPE_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.modbus.impl.ModbusUInt32Impl <em>UInt32</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.modbus.impl.ModbusUInt32Impl
     * @see org.eclipse.scada.configuration.modbus.impl.ModbusPackageImpl#getModbusUInt32()
     * @generated
     */
    int MODBUS_UINT32 = 13;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MODBUS_UINT32__NAME = MODBUS_DATA_TYPE__NAME;

    /**
     * The feature id for the '<em><b>Scale</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MODBUS_UINT32__SCALE = MODBUS_DATA_TYPE__SCALE;

    /**
     * The number of structural features of the '<em>UInt32</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MODBUS_UINT32_FEATURE_COUNT = MODBUS_DATA_TYPE_FEATURE_COUNT + 0;

    /**
     * The number of operations of the '<em>UInt32</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MODBUS_UINT32_OPERATION_COUNT = MODBUS_DATA_TYPE_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.modbus.ProtocolType <em>Protocol Type</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.modbus.ProtocolType
     * @see org.eclipse.scada.configuration.modbus.impl.ModbusPackageImpl#getProtocolType()
     * @generated
     */
    int PROTOCOL_TYPE = 14;

    /**
     * The meta object id for the '<em>Request Type</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.da.server.osgi.modbus.RequestType
     * @see org.eclipse.scada.configuration.modbus.impl.ModbusPackageImpl#getRequestType()
     * @generated
     */
    int REQUEST_TYPE = 15;

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.modbus.ModbusDevice <em>Device</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Device</em>'.
     * @see org.eclipse.scada.configuration.modbus.ModbusDevice
     * @generated
     */
    EClass getModbusDevice ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.configuration.modbus.ModbusDevice#getSlaves <em>Slaves</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Slaves</em>'.
     * @see org.eclipse.scada.configuration.modbus.ModbusDevice#getSlaves()
     * @see #getModbusDevice()
     * @generated
     */
    EReference getModbusDevice_Slaves ();

    /**
     * Returns the meta object for the reference '{@link org.eclipse.scada.configuration.modbus.ModbusDevice#getTypeSystem <em>Type System</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Type System</em>'.
     * @see org.eclipse.scada.configuration.modbus.ModbusDevice#getTypeSystem()
     * @see #getModbusDevice()
     * @generated
     */
    EReference getModbusDevice_TypeSystem ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.modbus.ModbusDevice#getPort <em>Port</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Port</em>'.
     * @see org.eclipse.scada.configuration.modbus.ModbusDevice#getPort()
     * @see #getModbusDevice()
     * @generated
     */
    EAttribute getModbusDevice_Port ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.modbus.ModbusDevice#getProtocolType <em>Protocol Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Protocol Type</em>'.
     * @see org.eclipse.scada.configuration.modbus.ModbusDevice#getProtocolType()
     * @see #getModbusDevice()
     * @generated
     */
    EAttribute getModbusDevice_ProtocolType ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.modbus.ModbusDevice#getInterFrameDelay <em>Inter Frame Delay</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Inter Frame Delay</em>'.
     * @see org.eclipse.scada.configuration.modbus.ModbusDevice#getInterFrameDelay()
     * @see #getModbusDevice()
     * @generated
     */
    EAttribute getModbusDevice_InterFrameDelay ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.modbus.ModbusDriver <em>Driver</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Driver</em>'.
     * @see org.eclipse.scada.configuration.modbus.ModbusDriver
     * @generated
     */
    EClass getModbusDriver ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.configuration.modbus.ModbusDriver#getMasters <em>Masters</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Masters</em>'.
     * @see org.eclipse.scada.configuration.modbus.ModbusDriver#getMasters()
     * @see #getModbusDriver()
     * @generated
     */
    EReference getModbusDriver_Masters ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.modbus.ModbusSlave <em>Slave</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Slave</em>'.
     * @see org.eclipse.scada.configuration.modbus.ModbusSlave
     * @generated
     */
    EClass getModbusSlave ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.configuration.modbus.ModbusSlave#getBlocks <em>Blocks</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Blocks</em>'.
     * @see org.eclipse.scada.configuration.modbus.ModbusSlave#getBlocks()
     * @see #getModbusSlave()
     * @generated
     */
    EReference getModbusSlave_Blocks ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.modbus.ModbusSlave#getUnitAddress <em>Unit Address</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Unit Address</em>'.
     * @see org.eclipse.scada.configuration.modbus.ModbusSlave#getUnitAddress()
     * @see #getModbusSlave()
     * @generated
     */
    EAttribute getModbusSlave_UnitAddress ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.modbus.ModbusSlave#getId <em>Id</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Id</em>'.
     * @see org.eclipse.scada.configuration.modbus.ModbusSlave#getId()
     * @see #getModbusSlave()
     * @generated
     */
    EAttribute getModbusSlave_Id ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.modbus.ModbusMaster <em>Master</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Master</em>'.
     * @see org.eclipse.scada.configuration.modbus.ModbusMaster
     * @generated
     */
    EClass getModbusMaster ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.configuration.modbus.ModbusMaster#getSlaves <em>Slaves</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Slaves</em>'.
     * @see org.eclipse.scada.configuration.modbus.ModbusMaster#getSlaves()
     * @see #getModbusMaster()
     * @generated
     */
    EReference getModbusMaster_Slaves ();

    /**
     * Returns the meta object for the reference '{@link org.eclipse.scada.configuration.modbus.ModbusMaster#getEndpoint <em>Endpoint</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Endpoint</em>'.
     * @see org.eclipse.scada.configuration.modbus.ModbusMaster#getEndpoint()
     * @see #getModbusMaster()
     * @generated
     */
    EReference getModbusMaster_Endpoint ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.modbus.ModbusMaster#getId <em>Id</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Id</em>'.
     * @see org.eclipse.scada.configuration.modbus.ModbusMaster#getId()
     * @see #getModbusMaster()
     * @generated
     */
    EAttribute getModbusMaster_Id ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.modbus.ModbusMaster#getProtocolType <em>Protocol Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Protocol Type</em>'.
     * @see org.eclipse.scada.configuration.modbus.ModbusMaster#getProtocolType()
     * @see #getModbusMaster()
     * @generated
     */
    EAttribute getModbusMaster_ProtocolType ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.modbus.ModbusMaster#getInterFrameDelay <em>Inter Frame Delay</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Inter Frame Delay</em>'.
     * @see org.eclipse.scada.configuration.modbus.ModbusMaster#getInterFrameDelay()
     * @see #getModbusMaster()
     * @generated
     */
    EAttribute getModbusMaster_InterFrameDelay ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.modbus.ModbusBlock <em>Block</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Block</em>'.
     * @see org.eclipse.scada.configuration.modbus.ModbusBlock
     * @generated
     */
    EClass getModbusBlock ();

    /**
     * Returns the meta object for the reference '{@link org.eclipse.scada.configuration.modbus.ModbusBlock#getType <em>Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Type</em>'.
     * @see org.eclipse.scada.configuration.modbus.ModbusBlock#getType()
     * @see #getModbusBlock()
     * @generated
     */
    EReference getModbusBlock_Type ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.modbus.ModbusExporter <em>Exporter</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Exporter</em>'.
     * @see org.eclipse.scada.configuration.modbus.ModbusExporter
     * @generated
     */
    EClass getModbusExporter ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.configuration.modbus.ModbusExporter#getDevices <em>Devices</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Devices</em>'.
     * @see org.eclipse.scada.configuration.modbus.ModbusExporter#getDevices()
     * @see #getModbusExporter()
     * @generated
     */
    EReference getModbusExporter_Devices ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.modbus.ModbusExporterDevice <em>Exporter Device</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Exporter Device</em>'.
     * @see org.eclipse.scada.configuration.modbus.ModbusExporterDevice
     * @generated
     */
    EClass getModbusExporterDevice ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.configuration.modbus.ModbusExporterDevice#getItems <em>Items</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Items</em>'.
     * @see org.eclipse.scada.configuration.modbus.ModbusExporterDevice#getItems()
     * @see #getModbusExporterDevice()
     * @generated
     */
    EReference getModbusExporterDevice_Items ();

    /**
     * Returns the meta object for the reference '{@link org.eclipse.scada.configuration.modbus.ModbusExporterDevice#getPort <em>Port</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Port</em>'.
     * @see org.eclipse.scada.configuration.modbus.ModbusExporterDevice#getPort()
     * @see #getModbusExporterDevice()
     * @generated
     */
    EReference getModbusExporterDevice_Port ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.modbus.ModbusExporterDevice#getSlaveId <em>Slave Id</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Slave Id</em>'.
     * @see org.eclipse.scada.configuration.modbus.ModbusExporterDevice#getSlaveId()
     * @see #getModbusExporterDevice()
     * @generated
     */
    EAttribute getModbusExporterDevice_SlaveId ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.configuration.modbus.ModbusExporterDevice#getProperties <em>Properties</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Properties</em>'.
     * @see org.eclipse.scada.configuration.modbus.ModbusExporterDevice#getProperties()
     * @see #getModbusExporterDevice()
     * @generated
     */
    EReference getModbusExporterDevice_Properties ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.modbus.ModbusExporterItem <em>Exporter Item</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Exporter Item</em>'.
     * @see org.eclipse.scada.configuration.modbus.ModbusExporterItem
     * @generated
     */
    EClass getModbusExporterItem ();

    /**
     * Returns the meta object for the reference '{@link org.eclipse.scada.configuration.modbus.ModbusExporterItem#getSource <em>Source</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Source</em>'.
     * @see org.eclipse.scada.configuration.modbus.ModbusExporterItem#getSource()
     * @see #getModbusExporterItem()
     * @generated
     */
    EReference getModbusExporterItem_Source ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.modbus.ModbusExporterItem#getOffset <em>Offset</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Offset</em>'.
     * @see org.eclipse.scada.configuration.modbus.ModbusExporterItem#getOffset()
     * @see #getModbusExporterItem()
     * @generated
     */
    EAttribute getModbusExporterItem_Offset ();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.scada.configuration.modbus.ModbusExporterItem#getType <em>Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Type</em>'.
     * @see org.eclipse.scada.configuration.modbus.ModbusExporterItem#getType()
     * @see #getModbusExporterItem()
     * @generated
     */
    EReference getModbusExporterItem_Type ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.modbus.ModbusDataType <em>Data Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Data Type</em>'.
     * @see org.eclipse.scada.configuration.modbus.ModbusDataType
     * @generated
     */
    EClass getModbusDataType ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.modbus.ModbusDataType#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see org.eclipse.scada.configuration.modbus.ModbusDataType#getName()
     * @see #getModbusDataType()
     * @generated
     */
    EAttribute getModbusDataType_Name ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.modbus.ModbusDataType#getScale <em>Scale</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Scale</em>'.
     * @see org.eclipse.scada.configuration.modbus.ModbusDataType#getScale()
     * @see #getModbusDataType()
     * @generated
     */
    EAttribute getModbusDataType_Scale ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.modbus.ModbusDouble <em>Double</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Double</em>'.
     * @see org.eclipse.scada.configuration.modbus.ModbusDouble
     * @generated
     */
    EClass getModbusDouble ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.modbus.ModbusSInt16 <em>SInt16</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>SInt16</em>'.
     * @see org.eclipse.scada.configuration.modbus.ModbusSInt16
     * @generated
     */
    EClass getModbusSInt16 ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.modbus.ModbusSInt32 <em>SInt32</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>SInt32</em>'.
     * @see org.eclipse.scada.configuration.modbus.ModbusSInt32
     * @generated
     */
    EClass getModbusSInt32 ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.modbus.ModbusUInt16 <em>UInt16</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>UInt16</em>'.
     * @see org.eclipse.scada.configuration.modbus.ModbusUInt16
     * @generated
     */
    EClass getModbusUInt16 ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.modbus.ModbusUInt32 <em>UInt32</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>UInt32</em>'.
     * @see org.eclipse.scada.configuration.modbus.ModbusUInt32
     * @generated
     */
    EClass getModbusUInt32 ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.modbus.ModbusBlock#getBlockType <em>Block Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Block Type</em>'.
     * @see org.eclipse.scada.configuration.modbus.ModbusBlock#getBlockType()
     * @see #getModbusBlock()
     * @generated
     */
    EAttribute getModbusBlock_BlockType ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.modbus.ModbusBlock#getStartAddress <em>Start Address</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Start Address</em>'.
     * @see org.eclipse.scada.configuration.modbus.ModbusBlock#getStartAddress()
     * @see #getModbusBlock()
     * @generated
     */
    EAttribute getModbusBlock_StartAddress ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.modbus.ModbusBlock#getCount <em>Count</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Count</em>'.
     * @see org.eclipse.scada.configuration.modbus.ModbusBlock#getCount()
     * @see #getModbusBlock()
     * @generated
     */
    EAttribute getModbusBlock_Count ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.modbus.ModbusBlock#getPeriod <em>Period</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Period</em>'.
     * @see org.eclipse.scada.configuration.modbus.ModbusBlock#getPeriod()
     * @see #getModbusBlock()
     * @generated
     */
    EAttribute getModbusBlock_Period ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.modbus.ModbusBlock#getTimeout <em>Timeout</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Timeout</em>'.
     * @see org.eclipse.scada.configuration.modbus.ModbusBlock#getTimeout()
     * @see #getModbusBlock()
     * @generated
     */
    EAttribute getModbusBlock_Timeout ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.modbus.ModbusBlock#getId <em>Id</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Id</em>'.
     * @see org.eclipse.scada.configuration.modbus.ModbusBlock#getId()
     * @see #getModbusBlock()
     * @generated
     */
    EAttribute getModbusBlock_Id ();

    /**
     * Returns the meta object for enum '{@link org.eclipse.scada.configuration.modbus.ProtocolType <em>Protocol Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for enum '<em>Protocol Type</em>'.
     * @see org.eclipse.scada.configuration.modbus.ProtocolType
     * @generated
     */
    EEnum getProtocolType ();

    /**
     * Returns the meta object for data type '{@link org.eclipse.scada.da.server.osgi.modbus.RequestType <em>Request Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for data type '<em>Request Type</em>'.
     * @see org.eclipse.scada.da.server.osgi.modbus.RequestType
     * @model instanceClass="org.eclipse.scada.da.server.osgi.modbus.RequestType"
     * @generated
     */
    EDataType getRequestType ();

    /**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
    ModbusFactory getModbusFactory ();

    /**
     * <!-- begin-user-doc -->
     * Defines literals for the meta objects that represent
     * <ul>
     *   <li>each class,</li>
     *   <li>each feature of each class,</li>
     *   <li>each operation of each class,</li>
     *   <li>each enum,</li>
     *   <li>and each data type</li>
     * </ul>
     * <!-- end-user-doc -->
     * @generated
     */
    interface Literals
    {
        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.modbus.impl.ModbusDeviceImpl <em>Device</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.modbus.impl.ModbusDeviceImpl
         * @see org.eclipse.scada.configuration.modbus.impl.ModbusPackageImpl#getModbusDevice()
         * @generated
         */
        EClass MODBUS_DEVICE = eINSTANCE.getModbusDevice ();

        /**
         * The meta object literal for the '<em><b>Slaves</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference MODBUS_DEVICE__SLAVES = eINSTANCE.getModbusDevice_Slaves ();

        /**
         * The meta object literal for the '<em><b>Type System</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference MODBUS_DEVICE__TYPE_SYSTEM = eINSTANCE.getModbusDevice_TypeSystem ();

        /**
         * The meta object literal for the '<em><b>Port</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute MODBUS_DEVICE__PORT = eINSTANCE.getModbusDevice_Port ();

        /**
         * The meta object literal for the '<em><b>Protocol Type</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute MODBUS_DEVICE__PROTOCOL_TYPE = eINSTANCE.getModbusDevice_ProtocolType ();

        /**
         * The meta object literal for the '<em><b>Inter Frame Delay</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute MODBUS_DEVICE__INTER_FRAME_DELAY = eINSTANCE.getModbusDevice_InterFrameDelay ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.modbus.impl.ModbusDriverImpl <em>Driver</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.modbus.impl.ModbusDriverImpl
         * @see org.eclipse.scada.configuration.modbus.impl.ModbusPackageImpl#getModbusDriver()
         * @generated
         */
        EClass MODBUS_DRIVER = eINSTANCE.getModbusDriver ();

        /**
         * The meta object literal for the '<em><b>Masters</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference MODBUS_DRIVER__MASTERS = eINSTANCE.getModbusDriver_Masters ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.modbus.impl.ModbusSlaveImpl <em>Slave</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.modbus.impl.ModbusSlaveImpl
         * @see org.eclipse.scada.configuration.modbus.impl.ModbusPackageImpl#getModbusSlave()
         * @generated
         */
        EClass MODBUS_SLAVE = eINSTANCE.getModbusSlave ();

        /**
         * The meta object literal for the '<em><b>Blocks</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference MODBUS_SLAVE__BLOCKS = eINSTANCE.getModbusSlave_Blocks ();

        /**
         * The meta object literal for the '<em><b>Unit Address</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute MODBUS_SLAVE__UNIT_ADDRESS = eINSTANCE.getModbusSlave_UnitAddress ();

        /**
         * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute MODBUS_SLAVE__ID = eINSTANCE.getModbusSlave_Id ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.modbus.impl.ModbusMasterImpl <em>Master</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.modbus.impl.ModbusMasterImpl
         * @see org.eclipse.scada.configuration.modbus.impl.ModbusPackageImpl#getModbusMaster()
         * @generated
         */
        EClass MODBUS_MASTER = eINSTANCE.getModbusMaster ();

        /**
         * The meta object literal for the '<em><b>Slaves</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference MODBUS_MASTER__SLAVES = eINSTANCE.getModbusMaster_Slaves ();

        /**
         * The meta object literal for the '<em><b>Endpoint</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference MODBUS_MASTER__ENDPOINT = eINSTANCE.getModbusMaster_Endpoint ();

        /**
         * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute MODBUS_MASTER__ID = eINSTANCE.getModbusMaster_Id ();

        /**
         * The meta object literal for the '<em><b>Protocol Type</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute MODBUS_MASTER__PROTOCOL_TYPE = eINSTANCE.getModbusMaster_ProtocolType ();

        /**
         * The meta object literal for the '<em><b>Inter Frame Delay</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute MODBUS_MASTER__INTER_FRAME_DELAY = eINSTANCE.getModbusMaster_InterFrameDelay ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.modbus.impl.ModbusBlockImpl <em>Block</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.modbus.impl.ModbusBlockImpl
         * @see org.eclipse.scada.configuration.modbus.impl.ModbusPackageImpl#getModbusBlock()
         * @generated
         */
        EClass MODBUS_BLOCK = eINSTANCE.getModbusBlock ();

        /**
         * The meta object literal for the '<em><b>Type</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference MODBUS_BLOCK__TYPE = eINSTANCE.getModbusBlock_Type ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.modbus.impl.ModbusExporterImpl <em>Exporter</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.modbus.impl.ModbusExporterImpl
         * @see org.eclipse.scada.configuration.modbus.impl.ModbusPackageImpl#getModbusExporter()
         * @generated
         */
        EClass MODBUS_EXPORTER = eINSTANCE.getModbusExporter ();

        /**
         * The meta object literal for the '<em><b>Devices</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference MODBUS_EXPORTER__DEVICES = eINSTANCE.getModbusExporter_Devices ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.modbus.impl.ModbusExporterDeviceImpl <em>Exporter Device</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.modbus.impl.ModbusExporterDeviceImpl
         * @see org.eclipse.scada.configuration.modbus.impl.ModbusPackageImpl#getModbusExporterDevice()
         * @generated
         */
        EClass MODBUS_EXPORTER_DEVICE = eINSTANCE.getModbusExporterDevice ();

        /**
         * The meta object literal for the '<em><b>Items</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference MODBUS_EXPORTER_DEVICE__ITEMS = eINSTANCE.getModbusExporterDevice_Items ();

        /**
         * The meta object literal for the '<em><b>Port</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference MODBUS_EXPORTER_DEVICE__PORT = eINSTANCE.getModbusExporterDevice_Port ();

        /**
         * The meta object literal for the '<em><b>Slave Id</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute MODBUS_EXPORTER_DEVICE__SLAVE_ID = eINSTANCE.getModbusExporterDevice_SlaveId ();

        /**
         * The meta object literal for the '<em><b>Properties</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference MODBUS_EXPORTER_DEVICE__PROPERTIES = eINSTANCE.getModbusExporterDevice_Properties ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.modbus.impl.ModbusExporterItemImpl <em>Exporter Item</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.modbus.impl.ModbusExporterItemImpl
         * @see org.eclipse.scada.configuration.modbus.impl.ModbusPackageImpl#getModbusExporterItem()
         * @generated
         */
        EClass MODBUS_EXPORTER_ITEM = eINSTANCE.getModbusExporterItem ();

        /**
         * The meta object literal for the '<em><b>Source</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference MODBUS_EXPORTER_ITEM__SOURCE = eINSTANCE.getModbusExporterItem_Source ();

        /**
         * The meta object literal for the '<em><b>Offset</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute MODBUS_EXPORTER_ITEM__OFFSET = eINSTANCE.getModbusExporterItem_Offset ();

        /**
         * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference MODBUS_EXPORTER_ITEM__TYPE = eINSTANCE.getModbusExporterItem_Type ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.modbus.ModbusDataType <em>Data Type</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.modbus.ModbusDataType
         * @see org.eclipse.scada.configuration.modbus.impl.ModbusPackageImpl#getModbusDataType()
         * @generated
         */
        EClass MODBUS_DATA_TYPE = eINSTANCE.getModbusDataType ();

        /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute MODBUS_DATA_TYPE__NAME = eINSTANCE.getModbusDataType_Name ();

        /**
         * The meta object literal for the '<em><b>Scale</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute MODBUS_DATA_TYPE__SCALE = eINSTANCE.getModbusDataType_Scale ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.modbus.impl.ModbusDoubleImpl <em>Double</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.modbus.impl.ModbusDoubleImpl
         * @see org.eclipse.scada.configuration.modbus.impl.ModbusPackageImpl#getModbusDouble()
         * @generated
         */
        EClass MODBUS_DOUBLE = eINSTANCE.getModbusDouble ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.modbus.impl.ModbusSInt16Impl <em>SInt16</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.modbus.impl.ModbusSInt16Impl
         * @see org.eclipse.scada.configuration.modbus.impl.ModbusPackageImpl#getModbusSInt16()
         * @generated
         */
        EClass MODBUS_SINT16 = eINSTANCE.getModbusSInt16 ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.modbus.impl.ModbusSInt32Impl <em>SInt32</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.modbus.impl.ModbusSInt32Impl
         * @see org.eclipse.scada.configuration.modbus.impl.ModbusPackageImpl#getModbusSInt32()
         * @generated
         */
        EClass MODBUS_SINT32 = eINSTANCE.getModbusSInt32 ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.modbus.impl.ModbusUInt16Impl <em>UInt16</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.modbus.impl.ModbusUInt16Impl
         * @see org.eclipse.scada.configuration.modbus.impl.ModbusPackageImpl#getModbusUInt16()
         * @generated
         */
        EClass MODBUS_UINT16 = eINSTANCE.getModbusUInt16 ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.modbus.impl.ModbusUInt32Impl <em>UInt32</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.modbus.impl.ModbusUInt32Impl
         * @see org.eclipse.scada.configuration.modbus.impl.ModbusPackageImpl#getModbusUInt32()
         * @generated
         */
        EClass MODBUS_UINT32 = eINSTANCE.getModbusUInt32 ();

        /**
         * The meta object literal for the '<em><b>Block Type</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute MODBUS_BLOCK__BLOCK_TYPE = eINSTANCE.getModbusBlock_BlockType ();

        /**
         * The meta object literal for the '<em><b>Start Address</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute MODBUS_BLOCK__START_ADDRESS = eINSTANCE.getModbusBlock_StartAddress ();

        /**
         * The meta object literal for the '<em><b>Count</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute MODBUS_BLOCK__COUNT = eINSTANCE.getModbusBlock_Count ();

        /**
         * The meta object literal for the '<em><b>Period</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute MODBUS_BLOCK__PERIOD = eINSTANCE.getModbusBlock_Period ();

        /**
         * The meta object literal for the '<em><b>Timeout</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute MODBUS_BLOCK__TIMEOUT = eINSTANCE.getModbusBlock_Timeout ();

        /**
         * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute MODBUS_BLOCK__ID = eINSTANCE.getModbusBlock_Id ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.modbus.ProtocolType <em>Protocol Type</em>}' enum.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.modbus.ProtocolType
         * @see org.eclipse.scada.configuration.modbus.impl.ModbusPackageImpl#getProtocolType()
         * @generated
         */
        EEnum PROTOCOL_TYPE = eINSTANCE.getProtocolType ();

        /**
         * The meta object literal for the '<em>Request Type</em>' data type.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.da.server.osgi.modbus.RequestType
         * @see org.eclipse.scada.configuration.modbus.impl.ModbusPackageImpl#getRequestType()
         * @generated
         */
        EDataType REQUEST_TYPE = eINSTANCE.getRequestType ();

    }

} //ModbusPackage
