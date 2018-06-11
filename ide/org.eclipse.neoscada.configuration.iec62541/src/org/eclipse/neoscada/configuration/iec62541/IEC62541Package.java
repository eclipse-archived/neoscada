/**
 * Copyright (c) 2014 IBH SYSTEMS GmbH.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation and/or initial documentation
 * 
 */
package org.eclipse.neoscada.configuration.iec62541;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.scada.configuration.infrastructure.InfrastructurePackage;

import org.eclipse.scada.configuration.world.WorldPackage;

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
 * @see org.eclipse.neoscada.configuration.iec62541.IEC62541Factory
 * @model kind="package"
 * @generated
 */
public interface IEC62541Package extends EPackage
{
    /**
     * The package name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNAME = "iec62541"; //$NON-NLS-1$

    /**
     * The package namespace URI.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_URI = "http://eclipse.org/Configuration/IEC62541"; //$NON-NLS-1$

    /**
     * The package namespace name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_PREFIX = "iec62541"; //$NON-NLS-1$

    /**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    IEC62541Package eINSTANCE = org.eclipse.neoscada.configuration.iec62541.impl.IEC62541PackageImpl.init ();

    /**
     * The meta object id for the '{@link org.eclipse.neoscada.configuration.iec62541.impl.IEC62541DriverImpl <em>Driver</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.neoscada.configuration.iec62541.impl.IEC62541DriverImpl
     * @see org.eclipse.neoscada.configuration.iec62541.impl.IEC62541PackageImpl#getIEC62541Driver()
     * @generated
     */
    int IEC62541_DRIVER = 0;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IEC62541_DRIVER__NAME = InfrastructurePackage.ABSTRACT_EQUINOX_DRIVER__NAME;

    /**
     * The feature id for the '<em><b>Node</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IEC62541_DRIVER__NODE = InfrastructurePackage.ABSTRACT_EQUINOX_DRIVER__NODE;

    /**
     * The feature id for the '<em><b>Protocol Type Tag</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IEC62541_DRIVER__PROTOCOL_TYPE_TAG = InfrastructurePackage.ABSTRACT_EQUINOX_DRIVER__PROTOCOL_TYPE_TAG;

    /**
     * The feature id for the '<em><b>Instance Number</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IEC62541_DRIVER__INSTANCE_NUMBER = InfrastructurePackage.ABSTRACT_EQUINOX_DRIVER__INSTANCE_NUMBER;

    /**
     * The feature id for the '<em><b>User Service</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IEC62541_DRIVER__USER_SERVICE = InfrastructurePackage.ABSTRACT_EQUINOX_DRIVER__USER_SERVICE;

    /**
     * The feature id for the '<em><b>Security Configuration</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IEC62541_DRIVER__SECURITY_CONFIGURATION = InfrastructurePackage.ABSTRACT_EQUINOX_DRIVER__SECURITY_CONFIGURATION;

    /**
     * The feature id for the '<em><b>Modules</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IEC62541_DRIVER__MODULES = InfrastructurePackage.ABSTRACT_EQUINOX_DRIVER__MODULES;

    /**
     * The feature id for the '<em><b>Configuration</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IEC62541_DRIVER__CONFIGURATION = InfrastructurePackage.ABSTRACT_EQUINOX_DRIVER__CONFIGURATION;

    /**
     * The feature id for the '<em><b>Configurations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IEC62541_DRIVER__CONFIGURATIONS = InfrastructurePackage.ABSTRACT_EQUINOX_DRIVER__CONFIGURATIONS;

    /**
     * The feature id for the '<em><b>Access Credentials</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IEC62541_DRIVER__ACCESS_CREDENTIALS = InfrastructurePackage.ABSTRACT_EQUINOX_DRIVER__ACCESS_CREDENTIALS;

    /**
     * The feature id for the '<em><b>Devices</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IEC62541_DRIVER__DEVICES = InfrastructurePackage.ABSTRACT_EQUINOX_DRIVER_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Driver</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IEC62541_DRIVER_FEATURE_COUNT = InfrastructurePackage.ABSTRACT_EQUINOX_DRIVER_FEATURE_COUNT + 1;

    /**
     * The number of operations of the '<em>Driver</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IEC62541_DRIVER_OPERATION_COUNT = InfrastructurePackage.ABSTRACT_EQUINOX_DRIVER_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.neoscada.configuration.iec62541.impl.IEC62541DeviceImpl <em>Device</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.neoscada.configuration.iec62541.impl.IEC62541DeviceImpl
     * @see org.eclipse.neoscada.configuration.iec62541.impl.IEC62541PackageImpl#getIEC62541Device()
     * @generated
     */
    int IEC62541_DEVICE = 1;

    /**
     * The feature id for the '<em><b>Short Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IEC62541_DEVICE__SHORT_DESCRIPTION = InfrastructurePackage.DEVICE__SHORT_DESCRIPTION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IEC62541_DEVICE__NAME = InfrastructurePackage.DEVICE__NAME;

    /**
     * The feature id for the '<em><b>Node</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IEC62541_DEVICE__NODE = InfrastructurePackage.DEVICE__NODE;

    /**
     * The feature id for the '<em><b>Server Url</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IEC62541_DEVICE__SERVER_URL = InfrastructurePackage.DEVICE_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Device</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IEC62541_DEVICE_FEATURE_COUNT = InfrastructurePackage.DEVICE_FEATURE_COUNT + 1;

    /**
     * The number of operations of the '<em>Device</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IEC62541_DEVICE_OPERATION_COUNT = InfrastructurePackage.DEVICE_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.neoscada.configuration.iec62541.impl.DriverApplicationImpl <em>Driver Application</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.neoscada.configuration.iec62541.impl.DriverApplicationImpl
     * @see org.eclipse.neoscada.configuration.iec62541.impl.IEC62541PackageImpl#getDriverApplication()
     * @generated
     */
    int DRIVER_APPLICATION = 2;

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
     * The meta object id for the '{@link org.eclipse.neoscada.configuration.iec62541.impl.HiveDeviceImpl <em>Hive Device</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.neoscada.configuration.iec62541.impl.HiveDeviceImpl
     * @see org.eclipse.neoscada.configuration.iec62541.impl.IEC62541PackageImpl#getHiveDevice()
     * @generated
     */
    int HIVE_DEVICE = 3;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HIVE_DEVICE__ID = 0;

    /**
     * The feature id for the '<em><b>Server Url</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HIVE_DEVICE__SERVER_URL = 1;

    /**
     * The number of structural features of the '<em>Hive Device</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HIVE_DEVICE_FEATURE_COUNT = 2;

    /**
     * The number of operations of the '<em>Hive Device</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HIVE_DEVICE_OPERATION_COUNT = 0;

    /**
     * Returns the meta object for class '{@link org.eclipse.neoscada.configuration.iec62541.IEC62541Driver <em>Driver</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Driver</em>'.
     * @see org.eclipse.neoscada.configuration.iec62541.IEC62541Driver
     * @generated
     */
    EClass getIEC62541Driver ();

    /**
     * Returns the meta object for the reference list '{@link org.eclipse.neoscada.configuration.iec62541.IEC62541Driver#getDevices <em>Devices</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Devices</em>'.
     * @see org.eclipse.neoscada.configuration.iec62541.IEC62541Driver#getDevices()
     * @see #getIEC62541Driver()
     * @generated
     */
    EReference getIEC62541Driver_Devices ();

    /**
     * Returns the meta object for class '{@link org.eclipse.neoscada.configuration.iec62541.IEC62541Device <em>Device</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Device</em>'.
     * @see org.eclipse.neoscada.configuration.iec62541.IEC62541Device
     * @generated
     */
    EClass getIEC62541Device ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.neoscada.configuration.iec62541.IEC62541Device#getServerUrl <em>Server Url</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Server Url</em>'.
     * @see org.eclipse.neoscada.configuration.iec62541.IEC62541Device#getServerUrl()
     * @see #getIEC62541Device()
     * @generated
     */
    EAttribute getIEC62541Device_ServerUrl ();

    /**
     * Returns the meta object for class '{@link org.eclipse.neoscada.configuration.iec62541.DriverApplication <em>Driver Application</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Driver Application</em>'.
     * @see org.eclipse.neoscada.configuration.iec62541.DriverApplication
     * @generated
     */
    EClass getDriverApplication ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.neoscada.configuration.iec62541.DriverApplication#getDevices <em>Devices</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Devices</em>'.
     * @see org.eclipse.neoscada.configuration.iec62541.DriverApplication#getDevices()
     * @see #getDriverApplication()
     * @generated
     */
    EReference getDriverApplication_Devices ();

    /**
     * Returns the meta object for class '{@link org.eclipse.neoscada.configuration.iec62541.HiveDevice <em>Hive Device</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Hive Device</em>'.
     * @see org.eclipse.neoscada.configuration.iec62541.HiveDevice
     * @generated
     */
    EClass getHiveDevice ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.neoscada.configuration.iec62541.HiveDevice#getId <em>Id</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Id</em>'.
     * @see org.eclipse.neoscada.configuration.iec62541.HiveDevice#getId()
     * @see #getHiveDevice()
     * @generated
     */
    EAttribute getHiveDevice_Id ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.neoscada.configuration.iec62541.HiveDevice#getServerUrl <em>Server Url</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Server Url</em>'.
     * @see org.eclipse.neoscada.configuration.iec62541.HiveDevice#getServerUrl()
     * @see #getHiveDevice()
     * @generated
     */
    EAttribute getHiveDevice_ServerUrl ();

    /**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
    IEC62541Factory getIEC62541Factory ();

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
         * The meta object literal for the '{@link org.eclipse.neoscada.configuration.iec62541.impl.IEC62541DriverImpl <em>Driver</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.neoscada.configuration.iec62541.impl.IEC62541DriverImpl
         * @see org.eclipse.neoscada.configuration.iec62541.impl.IEC62541PackageImpl#getIEC62541Driver()
         * @generated
         */
        EClass IEC62541_DRIVER = eINSTANCE.getIEC62541Driver ();

        /**
         * The meta object literal for the '<em><b>Devices</b></em>' reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference IEC62541_DRIVER__DEVICES = eINSTANCE.getIEC62541Driver_Devices ();

        /**
         * The meta object literal for the '{@link org.eclipse.neoscada.configuration.iec62541.impl.IEC62541DeviceImpl <em>Device</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.neoscada.configuration.iec62541.impl.IEC62541DeviceImpl
         * @see org.eclipse.neoscada.configuration.iec62541.impl.IEC62541PackageImpl#getIEC62541Device()
         * @generated
         */
        EClass IEC62541_DEVICE = eINSTANCE.getIEC62541Device ();

        /**
         * The meta object literal for the '<em><b>Server Url</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute IEC62541_DEVICE__SERVER_URL = eINSTANCE.getIEC62541Device_ServerUrl ();

        /**
         * The meta object literal for the '{@link org.eclipse.neoscada.configuration.iec62541.impl.DriverApplicationImpl <em>Driver Application</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.neoscada.configuration.iec62541.impl.DriverApplicationImpl
         * @see org.eclipse.neoscada.configuration.iec62541.impl.IEC62541PackageImpl#getDriverApplication()
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
         * The meta object literal for the '{@link org.eclipse.neoscada.configuration.iec62541.impl.HiveDeviceImpl <em>Hive Device</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.neoscada.configuration.iec62541.impl.HiveDeviceImpl
         * @see org.eclipse.neoscada.configuration.iec62541.impl.IEC62541PackageImpl#getHiveDevice()
         * @generated
         */
        EClass HIVE_DEVICE = eINSTANCE.getHiveDevice ();

        /**
         * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute HIVE_DEVICE__ID = eINSTANCE.getHiveDevice_Id ();

        /**
         * The meta object literal for the '<em><b>Server Url</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute HIVE_DEVICE__SERVER_URL = eINSTANCE.getHiveDevice_ServerUrl ();

    }

} //IEC62541Package
