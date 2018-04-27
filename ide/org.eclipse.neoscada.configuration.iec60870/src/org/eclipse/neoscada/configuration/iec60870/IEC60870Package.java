/**
 * Copyright (c) 2014, 2016 IBH SYSTEMS GmbH.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation and/or initial documentation
 *
 */
package org.eclipse.neoscada.configuration.iec60870;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.scada.configuration.component.ComponentPackage;
import org.eclipse.scada.configuration.infrastructure.InfrastructurePackage;
import org.eclipse.scada.configuration.world.WorldPackage;
import org.eclipse.scada.configuration.world.osgi.OsgiPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each operation of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.neoscada.configuration.iec60870.IEC60870Factory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/OCL/Import component='/resource/org.eclipse.scada.configuration.component/model/component.ecore#/' ecore='http://www.eclipse.org/emf/2002/Ecore#/' script_0='/resource/org.eclipse.scada.configuration.script/model/script.ecore#/'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore invocationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL' settingDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL' validationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL'"
 * @generated
 */
public interface IEC60870Package extends EPackage
{
    /**
     * The package name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNAME = "iec60870"; //$NON-NLS-1$

    /**
     * The package namespace URI.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_URI = "http://openscada.org/Configuration/IEC60870"; //$NON-NLS-1$

    /**
     * The package namespace name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_PREFIX = "iec60870"; //$NON-NLS-1$

    /**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    IEC60870Package eINSTANCE = org.eclipse.neoscada.configuration.iec60870.impl.IEC60870PackageImpl.init ();

    /**
     * The meta object id for the '{@link org.eclipse.neoscada.configuration.iec60870.impl.ExporterImpl <em>Exporter</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.neoscada.configuration.iec60870.impl.ExporterImpl
     * @see org.eclipse.neoscada.configuration.iec60870.impl.IEC60870PackageImpl#getExporter()
     * @generated
     */
    int EXPORTER = 0;

    /**
     * The feature id for the '<em><b>Devices</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXPORTER__DEVICES = OsgiPackage.APPLICATION_MODULE_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Exporter</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXPORTER_FEATURE_COUNT = OsgiPackage.APPLICATION_MODULE_FEATURE_COUNT + 1;

    /**
     * The number of operations of the '<em>Exporter</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXPORTER_OPERATION_COUNT = OsgiPackage.APPLICATION_MODULE_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.neoscada.configuration.iec60870.impl.DeviceImpl <em>Device</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.neoscada.configuration.iec60870.impl.DeviceImpl
     * @see org.eclipse.neoscada.configuration.iec60870.impl.IEC60870PackageImpl#getDevice()
     * @generated
     */
    int DEVICE = 1;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DEVICE__ID = 0;

    /**
     * The feature id for the '<em><b>Items</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DEVICE__ITEMS = 1;

    /**
     * The feature id for the '<em><b>Endpoint</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DEVICE__ENDPOINT = 2;

    /**
     * The feature id for the '<em><b>Protocol Options</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DEVICE__PROTOCOL_OPTIONS = 3;

    /**
     * The feature id for the '<em><b>Data Module Options</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DEVICE__DATA_MODULE_OPTIONS = 4;

    /**
     * The feature id for the '<em><b>Hive Properties</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DEVICE__HIVE_PROPERTIES = 5;

    /**
     * The feature id for the '<em><b>Spontaneous Buffer Window</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DEVICE__SPONTANEOUS_BUFFER_WINDOW = 6;

    /**
     * The feature id for the '<em><b>Cyclic Period</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DEVICE__CYCLIC_PERIOD = 7;

    /**
     * The number of structural features of the '<em>Device</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DEVICE_FEATURE_COUNT = 8;

    /**
     * The number of operations of the '<em>Device</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DEVICE_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link org.eclipse.neoscada.configuration.iec60870.impl.ItemImpl <em>Item</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.neoscada.configuration.iec60870.impl.ItemImpl
     * @see org.eclipse.neoscada.configuration.iec60870.impl.IEC60870PackageImpl#getItem()
     * @generated
     */
    int ITEM = 2;

    /**
     * The feature id for the '<em><b>Source</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ITEM__SOURCE = 0;

    /**
     * The feature id for the '<em><b>Address</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ITEM__ADDRESS = 1;

    /**
     * The feature id for the '<em><b>Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ITEM__TYPE = 2;

    /**
     * The number of structural features of the '<em>Item</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ITEM_FEATURE_COUNT = 3;

    /**
     * The number of operations of the '<em>Item</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ITEM_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link org.eclipse.neoscada.configuration.iec60870.impl.ExporterItemInterceptorImpl <em>Exporter Item Interceptor</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.neoscada.configuration.iec60870.impl.ExporterItemInterceptorImpl
     * @see org.eclipse.neoscada.configuration.iec60870.impl.IEC60870PackageImpl#getExporterItemInterceptor()
     * @generated
     */
    int EXPORTER_ITEM_INTERCEPTOR = 3;

    /**
     * The feature id for the '<em><b>Master On</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXPORTER_ITEM_INTERCEPTOR__MASTER_ON = ComponentPackage.ITEM_INTERCEPTOR__MASTER_ON;

    /**
     * The feature id for the '<em><b>Properties</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXPORTER_ITEM_INTERCEPTOR__PROPERTIES = ComponentPackage.ITEM_INTERCEPTOR__PROPERTIES;

    /**
     * The feature id for the '<em><b>Script</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXPORTER_ITEM_INTERCEPTOR__SCRIPT = ComponentPackage.ITEM_INTERCEPTOR_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Protocol Options</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXPORTER_ITEM_INTERCEPTOR__PROTOCOL_OPTIONS = ComponentPackage.ITEM_INTERCEPTOR_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Data Module Options</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXPORTER_ITEM_INTERCEPTOR__DATA_MODULE_OPTIONS = ComponentPackage.ITEM_INTERCEPTOR_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Port</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXPORTER_ITEM_INTERCEPTOR__PORT = ComponentPackage.ITEM_INTERCEPTOR_FEATURE_COUNT + 3;

    /**
     * The feature id for the '<em><b>Hive Properties</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXPORTER_ITEM_INTERCEPTOR__HIVE_PROPERTIES = ComponentPackage.ITEM_INTERCEPTOR_FEATURE_COUNT + 4;

    /**
     * The feature id for the '<em><b>Spontaneous Buffer Window</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXPORTER_ITEM_INTERCEPTOR__SPONTANEOUS_BUFFER_WINDOW = ComponentPackage.ITEM_INTERCEPTOR_FEATURE_COUNT + 5;

    /**
     * The feature id for the '<em><b>Cyclic Period</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXPORTER_ITEM_INTERCEPTOR__CYCLIC_PERIOD = ComponentPackage.ITEM_INTERCEPTOR_FEATURE_COUNT + 6;

    /**
     * The number of structural features of the '<em>Exporter Item Interceptor</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXPORTER_ITEM_INTERCEPTOR_FEATURE_COUNT = ComponentPackage.ITEM_INTERCEPTOR_FEATURE_COUNT + 7;

    /**
     * The number of operations of the '<em>Exporter Item Interceptor</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXPORTER_ITEM_INTERCEPTOR_OPERATION_COUNT = ComponentPackage.ITEM_INTERCEPTOR_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.neoscada.configuration.iec60870.impl.ProtocolOptionsImpl <em>Protocol Options</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.neoscada.configuration.iec60870.impl.ProtocolOptionsImpl
     * @see org.eclipse.neoscada.configuration.iec60870.impl.IEC60870PackageImpl#getProtocolOptions()
     * @generated
     */
    int PROTOCOL_OPTIONS = 4;

    /**
     * The feature id for the '<em><b>Timeout1</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PROTOCOL_OPTIONS__TIMEOUT1 = 0;

    /**
     * The feature id for the '<em><b>Timeout2</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PROTOCOL_OPTIONS__TIMEOUT2 = 1;

    /**
     * The feature id for the '<em><b>Timeout3</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PROTOCOL_OPTIONS__TIMEOUT3 = 2;

    /**
     * The feature id for the '<em><b>Asdu Address Size</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PROTOCOL_OPTIONS__ASDU_ADDRESS_SIZE = 3;

    /**
     * The feature id for the '<em><b>Information Object Address Size</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PROTOCOL_OPTIONS__INFORMATION_OBJECT_ADDRESS_SIZE = 4;

    /**
     * The feature id for the '<em><b>Cause Of Transmission Size</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PROTOCOL_OPTIONS__CAUSE_OF_TRANSMISSION_SIZE = 5;

    /**
     * The feature id for the '<em><b>W</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PROTOCOL_OPTIONS__W = 6;

    /**
     * The feature id for the '<em><b>K</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PROTOCOL_OPTIONS__K = 7;

    /**
     * The feature id for the '<em><b>Target Time Zone</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PROTOCOL_OPTIONS__TARGET_TIME_ZONE = 8;

    /**
     * The feature id for the '<em><b>Ignore Daylight Saving Time</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PROTOCOL_OPTIONS__IGNORE_DAYLIGHT_SAVING_TIME = 9;

    /**
     * The number of structural features of the '<em>Protocol Options</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PROTOCOL_OPTIONS_FEATURE_COUNT = 10;

    /**
     * The number of operations of the '<em>Protocol Options</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PROTOCOL_OPTIONS_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link org.eclipse.neoscada.configuration.iec60870.impl.DataModuleOptionsImpl <em>Data Module Options</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.neoscada.configuration.iec60870.impl.DataModuleOptionsImpl
     * @see org.eclipse.neoscada.configuration.iec60870.impl.IEC60870PackageImpl#getDataModuleOptions()
     * @generated
     */
    int DATA_MODULE_OPTIONS = 5;

    /**
     * The feature id for the '<em><b>Background Scan Period</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATA_MODULE_OPTIONS__BACKGROUND_SCAN_PERIOD = 0;

    /**
     * The feature id for the '<em><b>Spontaneous Item Buffer</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATA_MODULE_OPTIONS__SPONTANEOUS_ITEM_BUFFER = 1;

    /**
     * The feature id for the '<em><b>Timestamps For Boolean</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATA_MODULE_OPTIONS__TIMESTAMPS_FOR_BOOLEAN = 2;

    /**
     * The feature id for the '<em><b>Timestamps For Float</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATA_MODULE_OPTIONS__TIMESTAMPS_FOR_FLOAT = 3;

    /**
     * The number of structural features of the '<em>Data Module Options</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATA_MODULE_OPTIONS_FEATURE_COUNT = 4;

    /**
     * The number of operations of the '<em>Data Module Options</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATA_MODULE_OPTIONS_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link org.eclipse.neoscada.configuration.iec60870.impl.ClientDeviceImpl <em>Client Device</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.neoscada.configuration.iec60870.impl.ClientDeviceImpl
     * @see org.eclipse.neoscada.configuration.iec60870.impl.IEC60870PackageImpl#getClientDevice()
     * @generated
     */
    int CLIENT_DEVICE = 6;

    /**
     * The feature id for the '<em><b>Endpoint</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CLIENT_DEVICE__ENDPOINT = 0;

    /**
     * The feature id for the '<em><b>Protocol Options</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CLIENT_DEVICE__PROTOCOL_OPTIONS = 1;

    /**
     * The feature id for the '<em><b>Data Module Options</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CLIENT_DEVICE__DATA_MODULE_OPTIONS = 2;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CLIENT_DEVICE__ID = 3;

    /**
     * The feature id for the '<em><b>Item Types</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CLIENT_DEVICE__ITEM_TYPES = 4;

    /**
     * The number of structural features of the '<em>Client Device</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CLIENT_DEVICE_FEATURE_COUNT = 5;

    /**
     * The number of operations of the '<em>Client Device</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CLIENT_DEVICE_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link org.eclipse.neoscada.configuration.iec60870.impl.DriverApplicationImpl <em>Driver Application</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.neoscada.configuration.iec60870.impl.DriverApplicationImpl
     * @see org.eclipse.neoscada.configuration.iec60870.impl.IEC60870PackageImpl#getDriverApplication()
     * @generated
     */
    int DRIVER_APPLICATION = 7;

    /**
     * The feature id for the '<em><b>Short Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DRIVER_APPLICATION__SHORT_DESCRIPTION = WorldPackage.DRIVER__SHORT_DESCRIPTION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DRIVER_APPLICATION__NAME = WorldPackage.DRIVER__NAME;

    /**
     * The feature id for the '<em><b>Connections</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DRIVER_APPLICATION__CONNECTIONS = WorldPackage.DRIVER_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Exporter</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DRIVER_APPLICATION__EXPORTER = WorldPackage.DRIVER_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Customization Profile</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DRIVER_APPLICATION__CUSTOMIZATION_PROFILE = WorldPackage.DRIVER_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Security Configuration</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DRIVER_APPLICATION__SECURITY_CONFIGURATION = WorldPackage.DRIVER_FEATURE_COUNT + 3;

    /**
     * The feature id for the '<em><b>Modules</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DRIVER_APPLICATION__MODULES = WorldPackage.DRIVER_FEATURE_COUNT + 4;

    /**
     * The feature id for the '<em><b>Devices</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DRIVER_APPLICATION__DEVICES = WorldPackage.DRIVER_FEATURE_COUNT + 5;

    /**
     * The number of structural features of the '<em>Driver Application</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DRIVER_APPLICATION_FEATURE_COUNT = WorldPackage.DRIVER_FEATURE_COUNT + 6;

    /**
     * The operation id for the '<em>Get Endpoints</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DRIVER_APPLICATION___GET_ENDPOINTS = WorldPackage.DRIVER___GET_ENDPOINTS;

    /**
     * The operation id for the '<em>Get Profile</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DRIVER_APPLICATION___GET_PROFILE = WorldPackage.DRIVER_OPERATION_COUNT + 0;

    /**
     * The number of operations of the '<em>Driver Application</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DRIVER_APPLICATION_OPERATION_COUNT = WorldPackage.DRIVER_OPERATION_COUNT + 1;

    /**
     * The meta object id for the '{@link org.eclipse.neoscada.configuration.iec60870.impl.ClientDataModuleOptionsImpl <em>Client Data Module Options</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.neoscada.configuration.iec60870.impl.ClientDataModuleOptionsImpl
     * @see org.eclipse.neoscada.configuration.iec60870.impl.IEC60870PackageImpl#getClientDataModuleOptions()
     * @generated
     */
    int CLIENT_DATA_MODULE_OPTIONS = 8;

    /**
     * The feature id for the '<em><b>Ignore Background Scan</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CLIENT_DATA_MODULE_OPTIONS__IGNORE_BACKGROUND_SCAN = 0;

    /**
     * The feature id for the '<em><b>Delay Start</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CLIENT_DATA_MODULE_OPTIONS__DELAY_START = 1;

    /**
     * The number of structural features of the '<em>Client Data Module Options</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CLIENT_DATA_MODULE_OPTIONS_FEATURE_COUNT = 2;

    /**
     * The number of operations of the '<em>Client Data Module Options</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CLIENT_DATA_MODULE_OPTIONS_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link org.eclipse.neoscada.configuration.iec60870.impl.IEC60870DriverImpl <em>Driver</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.neoscada.configuration.iec60870.impl.IEC60870DriverImpl
     * @see org.eclipse.neoscada.configuration.iec60870.impl.IEC60870PackageImpl#getIEC60870Driver()
     * @generated
     */
    int IEC60870_DRIVER = 9;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IEC60870_DRIVER__NAME = InfrastructurePackage.ABSTRACT_EQUINOX_DRIVER__NAME;

    /**
     * The feature id for the '<em><b>Node</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IEC60870_DRIVER__NODE = InfrastructurePackage.ABSTRACT_EQUINOX_DRIVER__NODE;

    /**
     * The feature id for the '<em><b>Protocol Type Tag</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IEC60870_DRIVER__PROTOCOL_TYPE_TAG = InfrastructurePackage.ABSTRACT_EQUINOX_DRIVER__PROTOCOL_TYPE_TAG;

    /**
     * The feature id for the '<em><b>Instance Number</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IEC60870_DRIVER__INSTANCE_NUMBER = InfrastructurePackage.ABSTRACT_EQUINOX_DRIVER__INSTANCE_NUMBER;

    /**
     * The feature id for the '<em><b>User Service</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IEC60870_DRIVER__USER_SERVICE = InfrastructurePackage.ABSTRACT_EQUINOX_DRIVER__USER_SERVICE;

    /**
     * The feature id for the '<em><b>Security Configuration</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IEC60870_DRIVER__SECURITY_CONFIGURATION = InfrastructurePackage.ABSTRACT_EQUINOX_DRIVER__SECURITY_CONFIGURATION;

    /**
     * The feature id for the '<em><b>Modules</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IEC60870_DRIVER__MODULES = InfrastructurePackage.ABSTRACT_EQUINOX_DRIVER__MODULES;

    /**
     * The feature id for the '<em><b>Configuration</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IEC60870_DRIVER__CONFIGURATION = InfrastructurePackage.ABSTRACT_EQUINOX_DRIVER__CONFIGURATION;

    /**
     * The feature id for the '<em><b>Configurations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IEC60870_DRIVER__CONFIGURATIONS = InfrastructurePackage.ABSTRACT_EQUINOX_DRIVER__CONFIGURATIONS;

    /**
     * The feature id for the '<em><b>Access Credentials</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IEC60870_DRIVER__ACCESS_CREDENTIALS = InfrastructurePackage.ABSTRACT_EQUINOX_DRIVER__ACCESS_CREDENTIALS;

    /**
     * The feature id for the '<em><b>Devices</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IEC60870_DRIVER__DEVICES = InfrastructurePackage.ABSTRACT_EQUINOX_DRIVER_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Driver</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IEC60870_DRIVER_FEATURE_COUNT = InfrastructurePackage.ABSTRACT_EQUINOX_DRIVER_FEATURE_COUNT + 1;

    /**
     * The number of operations of the '<em>Driver</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IEC60870_DRIVER_OPERATION_COUNT = InfrastructurePackage.ABSTRACT_EQUINOX_DRIVER_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.neoscada.configuration.iec60870.impl.IEC60870DeviceImpl <em>Device</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.neoscada.configuration.iec60870.impl.IEC60870DeviceImpl
     * @see org.eclipse.neoscada.configuration.iec60870.impl.IEC60870PackageImpl#getIEC60870Device()
     * @generated
     */
    int IEC60870_DEVICE = 10;

    /**
     * The feature id for the '<em><b>Short Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IEC60870_DEVICE__SHORT_DESCRIPTION = InfrastructurePackage.DEVICE__SHORT_DESCRIPTION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IEC60870_DEVICE__NAME = InfrastructurePackage.DEVICE__NAME;

    /**
     * The feature id for the '<em><b>Node</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IEC60870_DEVICE__NODE = InfrastructurePackage.DEVICE__NODE;

    /**
     * The feature id for the '<em><b>Data Module Options</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IEC60870_DEVICE__DATA_MODULE_OPTIONS = InfrastructurePackage.DEVICE_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Protocol Options</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IEC60870_DEVICE__PROTOCOL_OPTIONS = InfrastructurePackage.DEVICE_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Port</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IEC60870_DEVICE__PORT = InfrastructurePackage.DEVICE_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Item Types</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IEC60870_DEVICE__ITEM_TYPES = InfrastructurePackage.DEVICE_FEATURE_COUNT + 3;

    /**
     * The number of structural features of the '<em>Device</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IEC60870_DEVICE_FEATURE_COUNT = InfrastructurePackage.DEVICE_FEATURE_COUNT + 4;

    /**
     * The number of operations of the '<em>Device</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IEC60870_DEVICE_OPERATION_COUNT = InfrastructurePackage.DEVICE_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.neoscada.configuration.iec60870.impl.ItemTypeImpl <em>Item Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.neoscada.configuration.iec60870.impl.ItemTypeImpl
     * @see org.eclipse.neoscada.configuration.iec60870.impl.IEC60870PackageImpl#getItemType()
     * @generated
     */
    int ITEM_TYPE = 11;

    /**
     * The feature id for the '<em><b>Item</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ITEM_TYPE__ITEM = 0;

    /**
     * The feature id for the '<em><b>Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ITEM_TYPE__TYPE = 1;

    /**
     * The number of structural features of the '<em>Item Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ITEM_TYPE_FEATURE_COUNT = 2;

    /**
     * The number of operations of the '<em>Item Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ITEM_TYPE_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link org.eclipse.neoscada.configuration.iec60870.DataType <em>Data Type</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.neoscada.configuration.iec60870.DataType
     * @see org.eclipse.neoscada.configuration.iec60870.impl.IEC60870PackageImpl#getDataType()
     * @generated
     */
    int DATA_TYPE = 12;

    /**
     * The meta object id for the '{@link org.eclipse.neoscada.configuration.iec60870.IECType <em>IEC Type</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.neoscada.configuration.iec60870.IECType
     * @see org.eclipse.neoscada.configuration.iec60870.impl.IEC60870PackageImpl#getIECType()
     * @generated
     */
    int IEC_TYPE = 13;

    /**
     * The meta object id for the '<em>Address</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.neoscada.configuration.iec60870.AddressInformation
     * @see org.eclipse.neoscada.configuration.iec60870.impl.IEC60870PackageImpl#getAddress()
     * @generated
     */
    int ADDRESS = 14;

    /**
     * Returns the meta object for class '{@link org.eclipse.neoscada.configuration.iec60870.Exporter <em>Exporter</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Exporter</em>'.
     * @see org.eclipse.neoscada.configuration.iec60870.Exporter
     * @generated
     */
    EClass getExporter ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.neoscada.configuration.iec60870.Exporter#getDevices <em>Devices</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Devices</em>'.
     * @see org.eclipse.neoscada.configuration.iec60870.Exporter#getDevices()
     * @see #getExporter()
     * @generated
     */
    EReference getExporter_Devices ();

    /**
     * Returns the meta object for class '{@link org.eclipse.neoscada.configuration.iec60870.Device <em>Device</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Device</em>'.
     * @see org.eclipse.neoscada.configuration.iec60870.Device
     * @generated
     */
    EClass getDevice ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.neoscada.configuration.iec60870.Device#getId <em>Id</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Id</em>'.
     * @see org.eclipse.neoscada.configuration.iec60870.Device#getId()
     * @see #getDevice()
     * @generated
     */
    EAttribute getDevice_Id ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.neoscada.configuration.iec60870.Device#getItems <em>Items</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Items</em>'.
     * @see org.eclipse.neoscada.configuration.iec60870.Device#getItems()
     * @see #getDevice()
     * @generated
     */
    EReference getDevice_Items ();

    /**
     * Returns the meta object for the reference '{@link org.eclipse.neoscada.configuration.iec60870.Device#getEndpoint <em>Endpoint</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Endpoint</em>'.
     * @see org.eclipse.neoscada.configuration.iec60870.Device#getEndpoint()
     * @see #getDevice()
     * @generated
     */
    EReference getDevice_Endpoint ();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.neoscada.configuration.iec60870.Device#getProtocolOptions <em>Protocol Options</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Protocol Options</em>'.
     * @see org.eclipse.neoscada.configuration.iec60870.Device#getProtocolOptions()
     * @see #getDevice()
     * @generated
     */
    EReference getDevice_ProtocolOptions ();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.neoscada.configuration.iec60870.Device#getDataModuleOptions <em>Data Module Options</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Data Module Options</em>'.
     * @see org.eclipse.neoscada.configuration.iec60870.Device#getDataModuleOptions()
     * @see #getDevice()
     * @generated
     */
    EReference getDevice_DataModuleOptions ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.neoscada.configuration.iec60870.Device#getHiveProperties <em>Hive Properties</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Hive Properties</em>'.
     * @see org.eclipse.neoscada.configuration.iec60870.Device#getHiveProperties()
     * @see #getDevice()
     * @generated
     */
    EReference getDevice_HiveProperties ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.neoscada.configuration.iec60870.Device#getSpontaneousBufferWindow <em>Spontaneous Buffer Window</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Spontaneous Buffer Window</em>'.
     * @see org.eclipse.neoscada.configuration.iec60870.Device#getSpontaneousBufferWindow()
     * @see #getDevice()
     * @generated
     */
    EAttribute getDevice_SpontaneousBufferWindow ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.neoscada.configuration.iec60870.Device#getCyclicPeriod <em>Cyclic Period</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Cyclic Period</em>'.
     * @see org.eclipse.neoscada.configuration.iec60870.Device#getCyclicPeriod()
     * @see #getDevice()
     * @generated
     */
    EAttribute getDevice_CyclicPeriod ();

    /**
     * Returns the meta object for class '{@link org.eclipse.neoscada.configuration.iec60870.Item <em>Item</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Item</em>'.
     * @see org.eclipse.neoscada.configuration.iec60870.Item
     * @generated
     */
    EClass getItem ();

    /**
     * Returns the meta object for the reference '{@link org.eclipse.neoscada.configuration.iec60870.Item#getSource <em>Source</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Source</em>'.
     * @see org.eclipse.neoscada.configuration.iec60870.Item#getSource()
     * @see #getItem()
     * @generated
     */
    EReference getItem_Source ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.neoscada.configuration.iec60870.Item#getAddress <em>Address</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Address</em>'.
     * @see org.eclipse.neoscada.configuration.iec60870.Item#getAddress()
     * @see #getItem()
     * @generated
     */
    EAttribute getItem_Address ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.neoscada.configuration.iec60870.Item#getType <em>Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Type</em>'.
     * @see org.eclipse.neoscada.configuration.iec60870.Item#getType()
     * @see #getItem()
     * @generated
     */
    EAttribute getItem_Type ();

    /**
     * Returns the meta object for class '{@link org.eclipse.neoscada.configuration.iec60870.ExporterItemInterceptor <em>Exporter Item Interceptor</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Exporter Item Interceptor</em>'.
     * @see org.eclipse.neoscada.configuration.iec60870.ExporterItemInterceptor
     * @generated
     */
    EClass getExporterItemInterceptor ();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.neoscada.configuration.iec60870.ExporterItemInterceptor#getScript <em>Script</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Script</em>'.
     * @see org.eclipse.neoscada.configuration.iec60870.ExporterItemInterceptor#getScript()
     * @see #getExporterItemInterceptor()
     * @generated
     */
    EReference getExporterItemInterceptor_Script ();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.neoscada.configuration.iec60870.ExporterItemInterceptor#getProtocolOptions <em>Protocol Options</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Protocol Options</em>'.
     * @see org.eclipse.neoscada.configuration.iec60870.ExporterItemInterceptor#getProtocolOptions()
     * @see #getExporterItemInterceptor()
     * @generated
     */
    EReference getExporterItemInterceptor_ProtocolOptions ();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.neoscada.configuration.iec60870.ExporterItemInterceptor#getDataModuleOptions <em>Data Module Options</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Data Module Options</em>'.
     * @see org.eclipse.neoscada.configuration.iec60870.ExporterItemInterceptor#getDataModuleOptions()
     * @see #getExporterItemInterceptor()
     * @generated
     */
    EReference getExporterItemInterceptor_DataModuleOptions ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.neoscada.configuration.iec60870.ExporterItemInterceptor#getPort <em>Port</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Port</em>'.
     * @see org.eclipse.neoscada.configuration.iec60870.ExporterItemInterceptor#getPort()
     * @see #getExporterItemInterceptor()
     * @generated
     */
    EAttribute getExporterItemInterceptor_Port ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.neoscada.configuration.iec60870.ExporterItemInterceptor#getHiveProperties <em>Hive Properties</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Hive Properties</em>'.
     * @see org.eclipse.neoscada.configuration.iec60870.ExporterItemInterceptor#getHiveProperties()
     * @see #getExporterItemInterceptor()
     * @generated
     */
    EReference getExporterItemInterceptor_HiveProperties ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.neoscada.configuration.iec60870.ExporterItemInterceptor#getSpontaneousBufferWindow <em>Spontaneous Buffer Window</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Spontaneous Buffer Window</em>'.
     * @see org.eclipse.neoscada.configuration.iec60870.ExporterItemInterceptor#getSpontaneousBufferWindow()
     * @see #getExporterItemInterceptor()
     * @generated
     */
    EAttribute getExporterItemInterceptor_SpontaneousBufferWindow ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.neoscada.configuration.iec60870.ExporterItemInterceptor#getCyclicPeriod <em>Cyclic Period</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Cyclic Period</em>'.
     * @see org.eclipse.neoscada.configuration.iec60870.ExporterItemInterceptor#getCyclicPeriod()
     * @see #getExporterItemInterceptor()
     * @generated
     */
    EAttribute getExporterItemInterceptor_CyclicPeriod ();

    /**
     * Returns the meta object for class '{@link org.eclipse.neoscada.configuration.iec60870.ProtocolOptions <em>Protocol Options</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Protocol Options</em>'.
     * @see org.eclipse.neoscada.configuration.iec60870.ProtocolOptions
     * @generated
     */
    EClass getProtocolOptions ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.neoscada.configuration.iec60870.ProtocolOptions#getTimeout1 <em>Timeout1</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Timeout1</em>'.
     * @see org.eclipse.neoscada.configuration.iec60870.ProtocolOptions#getTimeout1()
     * @see #getProtocolOptions()
     * @generated
     */
    EAttribute getProtocolOptions_Timeout1 ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.neoscada.configuration.iec60870.ProtocolOptions#getTimeout2 <em>Timeout2</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Timeout2</em>'.
     * @see org.eclipse.neoscada.configuration.iec60870.ProtocolOptions#getTimeout2()
     * @see #getProtocolOptions()
     * @generated
     */
    EAttribute getProtocolOptions_Timeout2 ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.neoscada.configuration.iec60870.ProtocolOptions#getTimeout3 <em>Timeout3</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Timeout3</em>'.
     * @see org.eclipse.neoscada.configuration.iec60870.ProtocolOptions#getTimeout3()
     * @see #getProtocolOptions()
     * @generated
     */
    EAttribute getProtocolOptions_Timeout3 ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.neoscada.configuration.iec60870.ProtocolOptions#getAsduAddressSize <em>Asdu Address Size</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Asdu Address Size</em>'.
     * @see org.eclipse.neoscada.configuration.iec60870.ProtocolOptions#getAsduAddressSize()
     * @see #getProtocolOptions()
     * @generated
     */
    EAttribute getProtocolOptions_AsduAddressSize ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.neoscada.configuration.iec60870.ProtocolOptions#getInformationObjectAddressSize <em>Information Object Address Size</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Information Object Address Size</em>'.
     * @see org.eclipse.neoscada.configuration.iec60870.ProtocolOptions#getInformationObjectAddressSize()
     * @see #getProtocolOptions()
     * @generated
     */
    EAttribute getProtocolOptions_InformationObjectAddressSize ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.neoscada.configuration.iec60870.ProtocolOptions#getCauseOfTransmissionSize <em>Cause Of Transmission Size</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Cause Of Transmission Size</em>'.
     * @see org.eclipse.neoscada.configuration.iec60870.ProtocolOptions#getCauseOfTransmissionSize()
     * @see #getProtocolOptions()
     * @generated
     */
    EAttribute getProtocolOptions_CauseOfTransmissionSize ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.neoscada.configuration.iec60870.ProtocolOptions#getW <em>W</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>W</em>'.
     * @see org.eclipse.neoscada.configuration.iec60870.ProtocolOptions#getW()
     * @see #getProtocolOptions()
     * @generated
     */
    EAttribute getProtocolOptions_W ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.neoscada.configuration.iec60870.ProtocolOptions#getK <em>K</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>K</em>'.
     * @see org.eclipse.neoscada.configuration.iec60870.ProtocolOptions#getK()
     * @see #getProtocolOptions()
     * @generated
     */
    EAttribute getProtocolOptions_K ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.neoscada.configuration.iec60870.ProtocolOptions#getTargetTimeZone <em>Target Time Zone</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Target Time Zone</em>'.
     * @see org.eclipse.neoscada.configuration.iec60870.ProtocolOptions#getTargetTimeZone()
     * @see #getProtocolOptions()
     * @generated
     */
    EAttribute getProtocolOptions_TargetTimeZone ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.neoscada.configuration.iec60870.ProtocolOptions#isIgnoreDaylightSavingTime <em>Ignore Daylight Saving Time</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Ignore Daylight Saving Time</em>'.
     * @see org.eclipse.neoscada.configuration.iec60870.ProtocolOptions#isIgnoreDaylightSavingTime()
     * @see #getProtocolOptions()
     * @generated
     */
    EAttribute getProtocolOptions_IgnoreDaylightSavingTime ();

    /**
     * Returns the meta object for class '{@link org.eclipse.neoscada.configuration.iec60870.DataModuleOptions <em>Data Module Options</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Data Module Options</em>'.
     * @see org.eclipse.neoscada.configuration.iec60870.DataModuleOptions
     * @generated
     */
    EClass getDataModuleOptions ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.neoscada.configuration.iec60870.DataModuleOptions#getBackgroundScanPeriod <em>Background Scan Period</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Background Scan Period</em>'.
     * @see org.eclipse.neoscada.configuration.iec60870.DataModuleOptions#getBackgroundScanPeriod()
     * @see #getDataModuleOptions()
     * @generated
     */
    EAttribute getDataModuleOptions_BackgroundScanPeriod ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.neoscada.configuration.iec60870.DataModuleOptions#getSpontaneousItemBuffer <em>Spontaneous Item Buffer</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Spontaneous Item Buffer</em>'.
     * @see org.eclipse.neoscada.configuration.iec60870.DataModuleOptions#getSpontaneousItemBuffer()
     * @see #getDataModuleOptions()
     * @generated
     */
    EAttribute getDataModuleOptions_SpontaneousItemBuffer ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.neoscada.configuration.iec60870.DataModuleOptions#isTimestampsForBoolean <em>Timestamps For Boolean</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Timestamps For Boolean</em>'.
     * @see org.eclipse.neoscada.configuration.iec60870.DataModuleOptions#isTimestampsForBoolean()
     * @see #getDataModuleOptions()
     * @generated
     */
    EAttribute getDataModuleOptions_TimestampsForBoolean ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.neoscada.configuration.iec60870.DataModuleOptions#isTimestampsForFloat <em>Timestamps For Float</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Timestamps For Float</em>'.
     * @see org.eclipse.neoscada.configuration.iec60870.DataModuleOptions#isTimestampsForFloat()
     * @see #getDataModuleOptions()
     * @generated
     */
    EAttribute getDataModuleOptions_TimestampsForFloat ();

    /**
     * Returns the meta object for class '{@link org.eclipse.neoscada.configuration.iec60870.ClientDevice <em>Client Device</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Client Device</em>'.
     * @see org.eclipse.neoscada.configuration.iec60870.ClientDevice
     * @generated
     */
    EClass getClientDevice ();

    /**
     * Returns the meta object for the reference '{@link org.eclipse.neoscada.configuration.iec60870.ClientDevice#getEndpoint <em>Endpoint</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Endpoint</em>'.
     * @see org.eclipse.neoscada.configuration.iec60870.ClientDevice#getEndpoint()
     * @see #getClientDevice()
     * @generated
     */
    EReference getClientDevice_Endpoint ();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.neoscada.configuration.iec60870.ClientDevice#getProtocolOptions <em>Protocol Options</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Protocol Options</em>'.
     * @see org.eclipse.neoscada.configuration.iec60870.ClientDevice#getProtocolOptions()
     * @see #getClientDevice()
     * @generated
     */
    EReference getClientDevice_ProtocolOptions ();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.neoscada.configuration.iec60870.ClientDevice#getDataModuleOptions <em>Data Module Options</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Data Module Options</em>'.
     * @see org.eclipse.neoscada.configuration.iec60870.ClientDevice#getDataModuleOptions()
     * @see #getClientDevice()
     * @generated
     */
    EReference getClientDevice_DataModuleOptions ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.neoscada.configuration.iec60870.ClientDevice#getId <em>Id</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Id</em>'.
     * @see org.eclipse.neoscada.configuration.iec60870.ClientDevice#getId()
     * @see #getClientDevice()
     * @generated
     */
    EAttribute getClientDevice_Id ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.neoscada.configuration.iec60870.ClientDevice#getItemTypes <em>Item Types</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Item Types</em>'.
     * @see org.eclipse.neoscada.configuration.iec60870.ClientDevice#getItemTypes()
     * @see #getClientDevice()
     * @generated
     */
    EReference getClientDevice_ItemTypes ();

    /**
     * Returns the meta object for class '{@link org.eclipse.neoscada.configuration.iec60870.DriverApplication <em>Driver Application</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Driver Application</em>'.
     * @see org.eclipse.neoscada.configuration.iec60870.DriverApplication
     * @generated
     */
    EClass getDriverApplication ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.neoscada.configuration.iec60870.DriverApplication#getDevices <em>Devices</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Devices</em>'.
     * @see org.eclipse.neoscada.configuration.iec60870.DriverApplication#getDevices()
     * @see #getDriverApplication()
     * @generated
     */
    EReference getDriverApplication_Devices ();

    /**
     * Returns the meta object for class '{@link org.eclipse.neoscada.configuration.iec60870.ClientDataModuleOptions <em>Client Data Module Options</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Client Data Module Options</em>'.
     * @see org.eclipse.neoscada.configuration.iec60870.ClientDataModuleOptions
     * @generated
     */
    EClass getClientDataModuleOptions ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.neoscada.configuration.iec60870.ClientDataModuleOptions#isIgnoreBackgroundScan <em>Ignore Background Scan</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Ignore Background Scan</em>'.
     * @see org.eclipse.neoscada.configuration.iec60870.ClientDataModuleOptions#isIgnoreBackgroundScan()
     * @see #getClientDataModuleOptions()
     * @generated
     */
    EAttribute getClientDataModuleOptions_IgnoreBackgroundScan ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.neoscada.configuration.iec60870.ClientDataModuleOptions#isDelayStart <em>Delay Start</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Delay Start</em>'.
     * @see org.eclipse.neoscada.configuration.iec60870.ClientDataModuleOptions#isDelayStart()
     * @see #getClientDataModuleOptions()
     * @generated
     */
    EAttribute getClientDataModuleOptions_DelayStart ();

    /**
     * Returns the meta object for class '{@link org.eclipse.neoscada.configuration.iec60870.IEC60870Driver <em>Driver</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Driver</em>'.
     * @see org.eclipse.neoscada.configuration.iec60870.IEC60870Driver
     * @generated
     */
    EClass getIEC60870Driver ();

    /**
     * Returns the meta object for the reference list '{@link org.eclipse.neoscada.configuration.iec60870.IEC60870Driver#getDevices <em>Devices</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Devices</em>'.
     * @see org.eclipse.neoscada.configuration.iec60870.IEC60870Driver#getDevices()
     * @see #getIEC60870Driver()
     * @generated
     */
    EReference getIEC60870Driver_Devices ();

    /**
     * Returns the meta object for class '{@link org.eclipse.neoscada.configuration.iec60870.IEC60870Device <em>Device</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Device</em>'.
     * @see org.eclipse.neoscada.configuration.iec60870.IEC60870Device
     * @generated
     */
    EClass getIEC60870Device ();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.neoscada.configuration.iec60870.IEC60870Device#getDataModuleOptions <em>Data Module Options</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Data Module Options</em>'.
     * @see org.eclipse.neoscada.configuration.iec60870.IEC60870Device#getDataModuleOptions()
     * @see #getIEC60870Device()
     * @generated
     */
    EReference getIEC60870Device_DataModuleOptions ();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.neoscada.configuration.iec60870.IEC60870Device#getProtocolOptions <em>Protocol Options</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Protocol Options</em>'.
     * @see org.eclipse.neoscada.configuration.iec60870.IEC60870Device#getProtocolOptions()
     * @see #getIEC60870Device()
     * @generated
     */
    EReference getIEC60870Device_ProtocolOptions ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.neoscada.configuration.iec60870.IEC60870Device#getPort <em>Port</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Port</em>'.
     * @see org.eclipse.neoscada.configuration.iec60870.IEC60870Device#getPort()
     * @see #getIEC60870Device()
     * @generated
     */
    EAttribute getIEC60870Device_Port ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.neoscada.configuration.iec60870.IEC60870Device#getItemTypes <em>Item Types</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Item Types</em>'.
     * @see org.eclipse.neoscada.configuration.iec60870.IEC60870Device#getItemTypes()
     * @see #getIEC60870Device()
     * @generated
     */
    EReference getIEC60870Device_ItemTypes ();

    /**
     * Returns the meta object for class '{@link org.eclipse.neoscada.configuration.iec60870.ItemType <em>Item Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Item Type</em>'.
     * @see org.eclipse.neoscada.configuration.iec60870.ItemType
     * @generated
     */
    EClass getItemType ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.neoscada.configuration.iec60870.ItemType#getItem <em>Item</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Item</em>'.
     * @see org.eclipse.neoscada.configuration.iec60870.ItemType#getItem()
     * @see #getItemType()
     * @generated
     */
    EAttribute getItemType_Item ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.neoscada.configuration.iec60870.ItemType#getType <em>Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Type</em>'.
     * @see org.eclipse.neoscada.configuration.iec60870.ItemType#getType()
     * @see #getItemType()
     * @generated
     */
    EAttribute getItemType_Type ();

    /**
     * Returns the meta object for enum '{@link org.eclipse.neoscada.configuration.iec60870.DataType <em>Data Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for enum '<em>Data Type</em>'.
     * @see org.eclipse.neoscada.configuration.iec60870.DataType
     * @generated
     */
    EEnum getDataType ();

    /**
     * Returns the meta object for enum '{@link org.eclipse.neoscada.configuration.iec60870.IECType <em>IEC Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for enum '<em>IEC Type</em>'.
     * @see org.eclipse.neoscada.configuration.iec60870.IECType
     * @generated
     */
    EEnum getIECType ();

    /**
     * Returns the meta object for data type '{@link org.eclipse.neoscada.configuration.iec60870.AddressInformation <em>Address</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for data type '<em>Address</em>'.
     * @see org.eclipse.neoscada.configuration.iec60870.AddressInformation
     * @model instanceClass="org.eclipse.neoscada.configuration.iec60870.AddressInformation"
     * @generated
     */
    EDataType getAddress ();

    /**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
    IEC60870Factory getIEC60870Factory ();

    /**
     * <!-- begin-user-doc -->
     * Defines literals for the meta objects that represent
     * <ul>
     * <li>each class,</li>
     * <li>each feature of each class,</li>
     * <li>each operation of each class,</li>
     * <li>each enum,</li>
     * <li>and each data type</li>
     * </ul>
     * <!-- end-user-doc -->
     * @generated
     */
    interface Literals
    {
        /**
         * The meta object literal for the '{@link org.eclipse.neoscada.configuration.iec60870.impl.ExporterImpl <em>Exporter</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.neoscada.configuration.iec60870.impl.ExporterImpl
         * @see org.eclipse.neoscada.configuration.iec60870.impl.IEC60870PackageImpl#getExporter()
         * @generated
         */
        EClass EXPORTER = eINSTANCE.getExporter ();

        /**
         * The meta object literal for the '<em><b>Devices</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference EXPORTER__DEVICES = eINSTANCE.getExporter_Devices ();

        /**
         * The meta object literal for the '{@link org.eclipse.neoscada.configuration.iec60870.impl.DeviceImpl <em>Device</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.neoscada.configuration.iec60870.impl.DeviceImpl
         * @see org.eclipse.neoscada.configuration.iec60870.impl.IEC60870PackageImpl#getDevice()
         * @generated
         */
        EClass DEVICE = eINSTANCE.getDevice ();

        /**
         * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute DEVICE__ID = eINSTANCE.getDevice_Id ();

        /**
         * The meta object literal for the '<em><b>Items</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference DEVICE__ITEMS = eINSTANCE.getDevice_Items ();

        /**
         * The meta object literal for the '<em><b>Endpoint</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference DEVICE__ENDPOINT = eINSTANCE.getDevice_Endpoint ();

        /**
         * The meta object literal for the '<em><b>Protocol Options</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference DEVICE__PROTOCOL_OPTIONS = eINSTANCE.getDevice_ProtocolOptions ();

        /**
         * The meta object literal for the '<em><b>Data Module Options</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference DEVICE__DATA_MODULE_OPTIONS = eINSTANCE.getDevice_DataModuleOptions ();

        /**
         * The meta object literal for the '<em><b>Hive Properties</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference DEVICE__HIVE_PROPERTIES = eINSTANCE.getDevice_HiveProperties ();

        /**
         * The meta object literal for the '<em><b>Spontaneous Buffer Window</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute DEVICE__SPONTANEOUS_BUFFER_WINDOW = eINSTANCE.getDevice_SpontaneousBufferWindow ();

        /**
         * The meta object literal for the '<em><b>Cyclic Period</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute DEVICE__CYCLIC_PERIOD = eINSTANCE.getDevice_CyclicPeriod ();

        /**
         * The meta object literal for the '{@link org.eclipse.neoscada.configuration.iec60870.impl.ItemImpl <em>Item</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.neoscada.configuration.iec60870.impl.ItemImpl
         * @see org.eclipse.neoscada.configuration.iec60870.impl.IEC60870PackageImpl#getItem()
         * @generated
         */
        EClass ITEM = eINSTANCE.getItem ();

        /**
         * The meta object literal for the '<em><b>Source</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference ITEM__SOURCE = eINSTANCE.getItem_Source ();

        /**
         * The meta object literal for the '<em><b>Address</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute ITEM__ADDRESS = eINSTANCE.getItem_Address ();

        /**
         * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute ITEM__TYPE = eINSTANCE.getItem_Type ();

        /**
         * The meta object literal for the '{@link org.eclipse.neoscada.configuration.iec60870.impl.ExporterItemInterceptorImpl <em>Exporter Item Interceptor</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.neoscada.configuration.iec60870.impl.ExporterItemInterceptorImpl
         * @see org.eclipse.neoscada.configuration.iec60870.impl.IEC60870PackageImpl#getExporterItemInterceptor()
         * @generated
         */
        EClass EXPORTER_ITEM_INTERCEPTOR = eINSTANCE.getExporterItemInterceptor ();

        /**
         * The meta object literal for the '<em><b>Script</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference EXPORTER_ITEM_INTERCEPTOR__SCRIPT = eINSTANCE.getExporterItemInterceptor_Script ();

        /**
         * The meta object literal for the '<em><b>Protocol Options</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference EXPORTER_ITEM_INTERCEPTOR__PROTOCOL_OPTIONS = eINSTANCE.getExporterItemInterceptor_ProtocolOptions ();

        /**
         * The meta object literal for the '<em><b>Data Module Options</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference EXPORTER_ITEM_INTERCEPTOR__DATA_MODULE_OPTIONS = eINSTANCE.getExporterItemInterceptor_DataModuleOptions ();

        /**
         * The meta object literal for the '<em><b>Port</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EXPORTER_ITEM_INTERCEPTOR__PORT = eINSTANCE.getExporterItemInterceptor_Port ();

        /**
         * The meta object literal for the '<em><b>Hive Properties</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference EXPORTER_ITEM_INTERCEPTOR__HIVE_PROPERTIES = eINSTANCE.getExporterItemInterceptor_HiveProperties ();

        /**
         * The meta object literal for the '<em><b>Spontaneous Buffer Window</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EXPORTER_ITEM_INTERCEPTOR__SPONTANEOUS_BUFFER_WINDOW = eINSTANCE.getExporterItemInterceptor_SpontaneousBufferWindow ();

        /**
         * The meta object literal for the '<em><b>Cyclic Period</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EXPORTER_ITEM_INTERCEPTOR__CYCLIC_PERIOD = eINSTANCE.getExporterItemInterceptor_CyclicPeriod ();

        /**
         * The meta object literal for the '{@link org.eclipse.neoscada.configuration.iec60870.impl.ProtocolOptionsImpl <em>Protocol Options</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.neoscada.configuration.iec60870.impl.ProtocolOptionsImpl
         * @see org.eclipse.neoscada.configuration.iec60870.impl.IEC60870PackageImpl#getProtocolOptions()
         * @generated
         */
        EClass PROTOCOL_OPTIONS = eINSTANCE.getProtocolOptions ();

        /**
         * The meta object literal for the '<em><b>Timeout1</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute PROTOCOL_OPTIONS__TIMEOUT1 = eINSTANCE.getProtocolOptions_Timeout1 ();

        /**
         * The meta object literal for the '<em><b>Timeout2</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute PROTOCOL_OPTIONS__TIMEOUT2 = eINSTANCE.getProtocolOptions_Timeout2 ();

        /**
         * The meta object literal for the '<em><b>Timeout3</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute PROTOCOL_OPTIONS__TIMEOUT3 = eINSTANCE.getProtocolOptions_Timeout3 ();

        /**
         * The meta object literal for the '<em><b>Asdu Address Size</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute PROTOCOL_OPTIONS__ASDU_ADDRESS_SIZE = eINSTANCE.getProtocolOptions_AsduAddressSize ();

        /**
         * The meta object literal for the '<em><b>Information Object Address Size</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute PROTOCOL_OPTIONS__INFORMATION_OBJECT_ADDRESS_SIZE = eINSTANCE.getProtocolOptions_InformationObjectAddressSize ();

        /**
         * The meta object literal for the '<em><b>Cause Of Transmission Size</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute PROTOCOL_OPTIONS__CAUSE_OF_TRANSMISSION_SIZE = eINSTANCE.getProtocolOptions_CauseOfTransmissionSize ();

        /**
         * The meta object literal for the '<em><b>W</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute PROTOCOL_OPTIONS__W = eINSTANCE.getProtocolOptions_W ();

        /**
         * The meta object literal for the '<em><b>K</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute PROTOCOL_OPTIONS__K = eINSTANCE.getProtocolOptions_K ();

        /**
         * The meta object literal for the '<em><b>Target Time Zone</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute PROTOCOL_OPTIONS__TARGET_TIME_ZONE = eINSTANCE.getProtocolOptions_TargetTimeZone ();

        /**
         * The meta object literal for the '<em><b>Ignore Daylight Saving Time</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute PROTOCOL_OPTIONS__IGNORE_DAYLIGHT_SAVING_TIME = eINSTANCE.getProtocolOptions_IgnoreDaylightSavingTime ();

        /**
         * The meta object literal for the '{@link org.eclipse.neoscada.configuration.iec60870.impl.DataModuleOptionsImpl <em>Data Module Options</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.neoscada.configuration.iec60870.impl.DataModuleOptionsImpl
         * @see org.eclipse.neoscada.configuration.iec60870.impl.IEC60870PackageImpl#getDataModuleOptions()
         * @generated
         */
        EClass DATA_MODULE_OPTIONS = eINSTANCE.getDataModuleOptions ();

        /**
         * The meta object literal for the '<em><b>Background Scan Period</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute DATA_MODULE_OPTIONS__BACKGROUND_SCAN_PERIOD = eINSTANCE.getDataModuleOptions_BackgroundScanPeriod ();

        /**
         * The meta object literal for the '<em><b>Spontaneous Item Buffer</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute DATA_MODULE_OPTIONS__SPONTANEOUS_ITEM_BUFFER = eINSTANCE.getDataModuleOptions_SpontaneousItemBuffer ();

        /**
         * The meta object literal for the '<em><b>Timestamps For Boolean</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute DATA_MODULE_OPTIONS__TIMESTAMPS_FOR_BOOLEAN = eINSTANCE.getDataModuleOptions_TimestampsForBoolean ();

        /**
         * The meta object literal for the '<em><b>Timestamps For Float</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute DATA_MODULE_OPTIONS__TIMESTAMPS_FOR_FLOAT = eINSTANCE.getDataModuleOptions_TimestampsForFloat ();

        /**
         * The meta object literal for the '{@link org.eclipse.neoscada.configuration.iec60870.impl.ClientDeviceImpl <em>Client Device</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.neoscada.configuration.iec60870.impl.ClientDeviceImpl
         * @see org.eclipse.neoscada.configuration.iec60870.impl.IEC60870PackageImpl#getClientDevice()
         * @generated
         */
        EClass CLIENT_DEVICE = eINSTANCE.getClientDevice ();

        /**
         * The meta object literal for the '<em><b>Endpoint</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference CLIENT_DEVICE__ENDPOINT = eINSTANCE.getClientDevice_Endpoint ();

        /**
         * The meta object literal for the '<em><b>Protocol Options</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference CLIENT_DEVICE__PROTOCOL_OPTIONS = eINSTANCE.getClientDevice_ProtocolOptions ();

        /**
         * The meta object literal for the '<em><b>Data Module Options</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference CLIENT_DEVICE__DATA_MODULE_OPTIONS = eINSTANCE.getClientDevice_DataModuleOptions ();

        /**
         * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute CLIENT_DEVICE__ID = eINSTANCE.getClientDevice_Id ();

        /**
         * The meta object literal for the '<em><b>Item Types</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference CLIENT_DEVICE__ITEM_TYPES = eINSTANCE.getClientDevice_ItemTypes ();

        /**
         * The meta object literal for the '{@link org.eclipse.neoscada.configuration.iec60870.impl.DriverApplicationImpl <em>Driver Application</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.neoscada.configuration.iec60870.impl.DriverApplicationImpl
         * @see org.eclipse.neoscada.configuration.iec60870.impl.IEC60870PackageImpl#getDriverApplication()
         * @generated
         */
        EClass DRIVER_APPLICATION = eINSTANCE.getDriverApplication ();

        /**
         * The meta object literal for the '<em><b>Devices</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference DRIVER_APPLICATION__DEVICES = eINSTANCE.getDriverApplication_Devices ();

        /**
         * The meta object literal for the '{@link org.eclipse.neoscada.configuration.iec60870.impl.ClientDataModuleOptionsImpl <em>Client Data Module Options</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.neoscada.configuration.iec60870.impl.ClientDataModuleOptionsImpl
         * @see org.eclipse.neoscada.configuration.iec60870.impl.IEC60870PackageImpl#getClientDataModuleOptions()
         * @generated
         */
        EClass CLIENT_DATA_MODULE_OPTIONS = eINSTANCE.getClientDataModuleOptions ();

        /**
         * The meta object literal for the '<em><b>Ignore Background Scan</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute CLIENT_DATA_MODULE_OPTIONS__IGNORE_BACKGROUND_SCAN = eINSTANCE.getClientDataModuleOptions_IgnoreBackgroundScan ();

        /**
         * The meta object literal for the '<em><b>Delay Start</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute CLIENT_DATA_MODULE_OPTIONS__DELAY_START = eINSTANCE.getClientDataModuleOptions_DelayStart ();

        /**
         * The meta object literal for the '{@link org.eclipse.neoscada.configuration.iec60870.impl.IEC60870DriverImpl <em>Driver</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.neoscada.configuration.iec60870.impl.IEC60870DriverImpl
         * @see org.eclipse.neoscada.configuration.iec60870.impl.IEC60870PackageImpl#getIEC60870Driver()
         * @generated
         */
        EClass IEC60870_DRIVER = eINSTANCE.getIEC60870Driver ();

        /**
         * The meta object literal for the '<em><b>Devices</b></em>' reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference IEC60870_DRIVER__DEVICES = eINSTANCE.getIEC60870Driver_Devices ();

        /**
         * The meta object literal for the '{@link org.eclipse.neoscada.configuration.iec60870.impl.IEC60870DeviceImpl <em>Device</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.neoscada.configuration.iec60870.impl.IEC60870DeviceImpl
         * @see org.eclipse.neoscada.configuration.iec60870.impl.IEC60870PackageImpl#getIEC60870Device()
         * @generated
         */
        EClass IEC60870_DEVICE = eINSTANCE.getIEC60870Device ();

        /**
         * The meta object literal for the '<em><b>Data Module Options</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference IEC60870_DEVICE__DATA_MODULE_OPTIONS = eINSTANCE.getIEC60870Device_DataModuleOptions ();

        /**
         * The meta object literal for the '<em><b>Protocol Options</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference IEC60870_DEVICE__PROTOCOL_OPTIONS = eINSTANCE.getIEC60870Device_ProtocolOptions ();

        /**
         * The meta object literal for the '<em><b>Port</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute IEC60870_DEVICE__PORT = eINSTANCE.getIEC60870Device_Port ();

        /**
         * The meta object literal for the '<em><b>Item Types</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference IEC60870_DEVICE__ITEM_TYPES = eINSTANCE.getIEC60870Device_ItemTypes ();

        /**
         * The meta object literal for the '{@link org.eclipse.neoscada.configuration.iec60870.impl.ItemTypeImpl <em>Item Type</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.neoscada.configuration.iec60870.impl.ItemTypeImpl
         * @see org.eclipse.neoscada.configuration.iec60870.impl.IEC60870PackageImpl#getItemType()
         * @generated
         */
        EClass ITEM_TYPE = eINSTANCE.getItemType ();

        /**
         * The meta object literal for the '<em><b>Item</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute ITEM_TYPE__ITEM = eINSTANCE.getItemType_Item ();

        /**
         * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute ITEM_TYPE__TYPE = eINSTANCE.getItemType_Type ();

        /**
         * The meta object literal for the '{@link org.eclipse.neoscada.configuration.iec60870.DataType <em>Data Type</em>}' enum.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.neoscada.configuration.iec60870.DataType
         * @see org.eclipse.neoscada.configuration.iec60870.impl.IEC60870PackageImpl#getDataType()
         * @generated
         */
        EEnum DATA_TYPE = eINSTANCE.getDataType ();

        /**
         * The meta object literal for the '{@link org.eclipse.neoscada.configuration.iec60870.IECType <em>IEC Type</em>}' enum.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.neoscada.configuration.iec60870.IECType
         * @see org.eclipse.neoscada.configuration.iec60870.impl.IEC60870PackageImpl#getIECType()
         * @generated
         */
        EEnum IEC_TYPE = eINSTANCE.getIECType ();

        /**
         * The meta object literal for the '<em>Address</em>' data type.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.neoscada.configuration.iec60870.AddressInformation
         * @see org.eclipse.neoscada.configuration.iec60870.impl.IEC60870PackageImpl#getAddress()
         * @generated
         */
        EDataType ADDRESS = eINSTANCE.getAddress ();

    }

} //IEC60870Package
