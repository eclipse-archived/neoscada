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
package org.eclipse.scada.configuration.setup.common;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.scada.configuration.world.setup.SetupPackage;

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
 * @see org.eclipse.scada.configuration.setup.common.CommonFactory
 * @model kind="package"
 * @generated
 */
public interface CommonPackage extends EPackage
{
    /**
     * The package name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNAME = "common"; //$NON-NLS-1$

    /**
     * The package namespace URI.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_URI = "http://eclipse.org/SCADA/Configuration/Setup/Common"; //$NON-NLS-1$

    /**
     * The package namespace name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_PREFIX = "setupCommon"; //$NON-NLS-1$

    /**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    CommonPackage eINSTANCE = org.eclipse.scada.configuration.setup.common.impl.CommonPackageImpl.init ();

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.setup.common.impl.PostgresSetupModuleImpl <em>Postgres Setup Module</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.setup.common.impl.PostgresSetupModuleImpl
     * @see org.eclipse.scada.configuration.setup.common.impl.CommonPackageImpl#getPostgresSetupModule()
     * @generated
     */
    int POSTGRES_SETUP_MODULE = 0;

    /**
     * The feature id for the '<em><b>Database</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int POSTGRES_SETUP_MODULE__DATABASE = SetupPackage.SETUP_MODULE_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Postgres User</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int POSTGRES_SETUP_MODULE__POSTGRES_USER = SetupPackage.SETUP_MODULE_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Host Based Access File</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int POSTGRES_SETUP_MODULE__HOST_BASED_ACCESS_FILE = SetupPackage.SETUP_MODULE_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Configuration File</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int POSTGRES_SETUP_MODULE__CONFIGURATION_FILE = SetupPackage.SETUP_MODULE_FEATURE_COUNT + 3;

    /**
     * The number of structural features of the '<em>Postgres Setup Module</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int POSTGRES_SETUP_MODULE_FEATURE_COUNT = SetupPackage.SETUP_MODULE_FEATURE_COUNT + 4;

    /**
     * The operation id for the '<em>Validate Operating System</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int POSTGRES_SETUP_MODULE___VALIDATE_OPERATING_SYSTEM__OPERATINGSYSTEMDESCRIPTOR_VALIDATIONCONTEXT = SetupPackage.SETUP_MODULE___VALIDATE_OPERATING_SYSTEM__OPERATINGSYSTEMDESCRIPTOR_VALIDATIONCONTEXT;

    /**
     * The number of operations of the '<em>Postgres Setup Module</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int POSTGRES_SETUP_MODULE_OPERATION_COUNT = SetupPackage.SETUP_MODULE_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.setup.common.impl.SerialToNetworkSetupModuleImpl <em>Serial To Network Setup Module</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.setup.common.impl.SerialToNetworkSetupModuleImpl
     * @see org.eclipse.scada.configuration.setup.common.impl.CommonPackageImpl#getSerialToNetworkSetupModule()
     * @generated
     */
    int SERIAL_TO_NETWORK_SETUP_MODULE = 1;

    /**
     * The feature id for the '<em><b>Mappings</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SERIAL_TO_NETWORK_SETUP_MODULE__MAPPINGS = SetupPackage.SETUP_MODULE_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Serial To Network Setup Module</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SERIAL_TO_NETWORK_SETUP_MODULE_FEATURE_COUNT = SetupPackage.SETUP_MODULE_FEATURE_COUNT + 1;

    /**
     * The operation id for the '<em>Validate Operating System</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SERIAL_TO_NETWORK_SETUP_MODULE___VALIDATE_OPERATING_SYSTEM__OPERATINGSYSTEMDESCRIPTOR_VALIDATIONCONTEXT = SetupPackage.SETUP_MODULE___VALIDATE_OPERATING_SYSTEM__OPERATINGSYSTEMDESCRIPTOR_VALIDATIONCONTEXT;

    /**
     * The number of operations of the '<em>Serial To Network Setup Module</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SERIAL_TO_NETWORK_SETUP_MODULE_OPERATION_COUNT = SetupPackage.SETUP_MODULE_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.setup.common.impl.SerialToNetworkMappingImpl <em>Serial To Network Mapping</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.setup.common.impl.SerialToNetworkMappingImpl
     * @see org.eclipse.scada.configuration.setup.common.impl.CommonPackageImpl#getSerialToNetworkMapping()
     * @generated
     */
    int SERIAL_TO_NETWORK_MAPPING = 2;

    /**
     * The feature id for the '<em><b>Device</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SERIAL_TO_NETWORK_MAPPING__DEVICE = 0;

    /**
     * The feature id for the '<em><b>Tcp Port</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SERIAL_TO_NETWORK_MAPPING__TCP_PORT = 1;

    /**
     * The feature id for the '<em><b>Timeout</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SERIAL_TO_NETWORK_MAPPING__TIMEOUT = 2;

    /**
     * The feature id for the '<em><b>Baud Rate</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SERIAL_TO_NETWORK_MAPPING__BAUD_RATE = 3;

    /**
     * The feature id for the '<em><b>Parity</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SERIAL_TO_NETWORK_MAPPING__PARITY = 4;

    /**
     * The feature id for the '<em><b>Xonxoff</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SERIAL_TO_NETWORK_MAPPING__XONXOFF = 5;

    /**
     * The feature id for the '<em><b>Rtscts</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SERIAL_TO_NETWORK_MAPPING__RTSCTS = 6;

    /**
     * The feature id for the '<em><b>Data Bits</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SERIAL_TO_NETWORK_MAPPING__DATA_BITS = 7;

    /**
     * The feature id for the '<em><b>Stop Bits</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SERIAL_TO_NETWORK_MAPPING__STOP_BITS = 8;

    /**
     * The feature id for the '<em><b>Modem Control</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SERIAL_TO_NETWORK_MAPPING__MODEM_CONTROL = 9;

    /**
     * The feature id for the '<em><b>Break</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SERIAL_TO_NETWORK_MAPPING__BREAK = 10;

    /**
     * The number of structural features of the '<em>Serial To Network Mapping</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SERIAL_TO_NETWORK_MAPPING_FEATURE_COUNT = 11;

    /**
     * The number of operations of the '<em>Serial To Network Mapping</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SERIAL_TO_NETWORK_MAPPING_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.setup.common.Parity <em>Parity</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.setup.common.Parity
     * @see org.eclipse.scada.configuration.setup.common.impl.CommonPackageImpl#getParity()
     * @generated
     */
    int PARITY = 3;

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.setup.common.PostgresSetupModule <em>Postgres Setup Module</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Postgres Setup Module</em>'.
     * @see org.eclipse.scada.configuration.setup.common.PostgresSetupModule
     * @generated
     */
    EClass getPostgresSetupModule ();

    /**
     * Returns the meta object for the reference '{@link org.eclipse.scada.configuration.setup.common.PostgresSetupModule#getDatabase <em>Database</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Database</em>'.
     * @see org.eclipse.scada.configuration.setup.common.PostgresSetupModule#getDatabase()
     * @see #getPostgresSetupModule()
     * @generated
     */
    EReference getPostgresSetupModule_Database ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.setup.common.PostgresSetupModule#getPostgresUser <em>Postgres User</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Postgres User</em>'.
     * @see org.eclipse.scada.configuration.setup.common.PostgresSetupModule#getPostgresUser()
     * @see #getPostgresSetupModule()
     * @generated
     */
    EAttribute getPostgresSetupModule_PostgresUser ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.setup.common.PostgresSetupModule#getHostBasedAccessFile <em>Host Based Access File</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Host Based Access File</em>'.
     * @see org.eclipse.scada.configuration.setup.common.PostgresSetupModule#getHostBasedAccessFile()
     * @see #getPostgresSetupModule()
     * @generated
     */
    EAttribute getPostgresSetupModule_HostBasedAccessFile ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.setup.common.PostgresSetupModule#getConfigurationFile <em>Configuration File</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Configuration File</em>'.
     * @see org.eclipse.scada.configuration.setup.common.PostgresSetupModule#getConfigurationFile()
     * @see #getPostgresSetupModule()
     * @generated
     */
    EAttribute getPostgresSetupModule_ConfigurationFile ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.setup.common.SerialToNetworkSetupModule <em>Serial To Network Setup Module</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Serial To Network Setup Module</em>'.
     * @see org.eclipse.scada.configuration.setup.common.SerialToNetworkSetupModule
     * @generated
     */
    EClass getSerialToNetworkSetupModule ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.configuration.setup.common.SerialToNetworkSetupModule#getMappings <em>Mappings</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Mappings</em>'.
     * @see org.eclipse.scada.configuration.setup.common.SerialToNetworkSetupModule#getMappings()
     * @see #getSerialToNetworkSetupModule()
     * @generated
     */
    EReference getSerialToNetworkSetupModule_Mappings ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.setup.common.SerialToNetworkMapping <em>Serial To Network Mapping</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Serial To Network Mapping</em>'.
     * @see org.eclipse.scada.configuration.setup.common.SerialToNetworkMapping
     * @generated
     */
    EClass getSerialToNetworkMapping ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.setup.common.SerialToNetworkMapping#getDevice <em>Device</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Device</em>'.
     * @see org.eclipse.scada.configuration.setup.common.SerialToNetworkMapping#getDevice()
     * @see #getSerialToNetworkMapping()
     * @generated
     */
    EAttribute getSerialToNetworkMapping_Device ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.setup.common.SerialToNetworkMapping#getTcpPort <em>Tcp Port</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Tcp Port</em>'.
     * @see org.eclipse.scada.configuration.setup.common.SerialToNetworkMapping#getTcpPort()
     * @see #getSerialToNetworkMapping()
     * @generated
     */
    EAttribute getSerialToNetworkMapping_TcpPort ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.setup.common.SerialToNetworkMapping#getTimeout <em>Timeout</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Timeout</em>'.
     * @see org.eclipse.scada.configuration.setup.common.SerialToNetworkMapping#getTimeout()
     * @see #getSerialToNetworkMapping()
     * @generated
     */
    EAttribute getSerialToNetworkMapping_Timeout ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.setup.common.SerialToNetworkMapping#getBaudRate <em>Baud Rate</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Baud Rate</em>'.
     * @see org.eclipse.scada.configuration.setup.common.SerialToNetworkMapping#getBaudRate()
     * @see #getSerialToNetworkMapping()
     * @generated
     */
    EAttribute getSerialToNetworkMapping_BaudRate ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.setup.common.SerialToNetworkMapping#getParity <em>Parity</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Parity</em>'.
     * @see org.eclipse.scada.configuration.setup.common.SerialToNetworkMapping#getParity()
     * @see #getSerialToNetworkMapping()
     * @generated
     */
    EAttribute getSerialToNetworkMapping_Parity ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.setup.common.SerialToNetworkMapping#isXonxoff <em>Xonxoff</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Xonxoff</em>'.
     * @see org.eclipse.scada.configuration.setup.common.SerialToNetworkMapping#isXonxoff()
     * @see #getSerialToNetworkMapping()
     * @generated
     */
    EAttribute getSerialToNetworkMapping_Xonxoff ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.setup.common.SerialToNetworkMapping#isRtscts <em>Rtscts</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Rtscts</em>'.
     * @see org.eclipse.scada.configuration.setup.common.SerialToNetworkMapping#isRtscts()
     * @see #getSerialToNetworkMapping()
     * @generated
     */
    EAttribute getSerialToNetworkMapping_Rtscts ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.setup.common.SerialToNetworkMapping#getDataBits <em>Data Bits</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Data Bits</em>'.
     * @see org.eclipse.scada.configuration.setup.common.SerialToNetworkMapping#getDataBits()
     * @see #getSerialToNetworkMapping()
     * @generated
     */
    EAttribute getSerialToNetworkMapping_DataBits ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.setup.common.SerialToNetworkMapping#getStopBits <em>Stop Bits</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Stop Bits</em>'.
     * @see org.eclipse.scada.configuration.setup.common.SerialToNetworkMapping#getStopBits()
     * @see #getSerialToNetworkMapping()
     * @generated
     */
    EAttribute getSerialToNetworkMapping_StopBits ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.setup.common.SerialToNetworkMapping#isModemControl <em>Modem Control</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Modem Control</em>'.
     * @see org.eclipse.scada.configuration.setup.common.SerialToNetworkMapping#isModemControl()
     * @see #getSerialToNetworkMapping()
     * @generated
     */
    EAttribute getSerialToNetworkMapping_ModemControl ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.setup.common.SerialToNetworkMapping#isBreak <em>Break</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Break</em>'.
     * @see org.eclipse.scada.configuration.setup.common.SerialToNetworkMapping#isBreak()
     * @see #getSerialToNetworkMapping()
     * @generated
     */
    EAttribute getSerialToNetworkMapping_Break ();

    /**
     * Returns the meta object for enum '{@link org.eclipse.scada.configuration.setup.common.Parity <em>Parity</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for enum '<em>Parity</em>'.
     * @see org.eclipse.scada.configuration.setup.common.Parity
     * @generated
     */
    EEnum getParity ();

    /**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
    CommonFactory getCommonFactory ();

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
         * The meta object literal for the '{@link org.eclipse.scada.configuration.setup.common.impl.PostgresSetupModuleImpl <em>Postgres Setup Module</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.setup.common.impl.PostgresSetupModuleImpl
         * @see org.eclipse.scada.configuration.setup.common.impl.CommonPackageImpl#getPostgresSetupModule()
         * @generated
         */
        EClass POSTGRES_SETUP_MODULE = eINSTANCE.getPostgresSetupModule ();

        /**
         * The meta object literal for the '<em><b>Database</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference POSTGRES_SETUP_MODULE__DATABASE = eINSTANCE.getPostgresSetupModule_Database ();

        /**
         * The meta object literal for the '<em><b>Postgres User</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute POSTGRES_SETUP_MODULE__POSTGRES_USER = eINSTANCE.getPostgresSetupModule_PostgresUser ();

        /**
         * The meta object literal for the '<em><b>Host Based Access File</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute POSTGRES_SETUP_MODULE__HOST_BASED_ACCESS_FILE = eINSTANCE.getPostgresSetupModule_HostBasedAccessFile ();

        /**
         * The meta object literal for the '<em><b>Configuration File</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute POSTGRES_SETUP_MODULE__CONFIGURATION_FILE = eINSTANCE.getPostgresSetupModule_ConfigurationFile ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.setup.common.impl.SerialToNetworkSetupModuleImpl <em>Serial To Network Setup Module</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.setup.common.impl.SerialToNetworkSetupModuleImpl
         * @see org.eclipse.scada.configuration.setup.common.impl.CommonPackageImpl#getSerialToNetworkSetupModule()
         * @generated
         */
        EClass SERIAL_TO_NETWORK_SETUP_MODULE = eINSTANCE.getSerialToNetworkSetupModule ();

        /**
         * The meta object literal for the '<em><b>Mappings</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference SERIAL_TO_NETWORK_SETUP_MODULE__MAPPINGS = eINSTANCE.getSerialToNetworkSetupModule_Mappings ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.setup.common.impl.SerialToNetworkMappingImpl <em>Serial To Network Mapping</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.setup.common.impl.SerialToNetworkMappingImpl
         * @see org.eclipse.scada.configuration.setup.common.impl.CommonPackageImpl#getSerialToNetworkMapping()
         * @generated
         */
        EClass SERIAL_TO_NETWORK_MAPPING = eINSTANCE.getSerialToNetworkMapping ();

        /**
         * The meta object literal for the '<em><b>Device</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SERIAL_TO_NETWORK_MAPPING__DEVICE = eINSTANCE.getSerialToNetworkMapping_Device ();

        /**
         * The meta object literal for the '<em><b>Tcp Port</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SERIAL_TO_NETWORK_MAPPING__TCP_PORT = eINSTANCE.getSerialToNetworkMapping_TcpPort ();

        /**
         * The meta object literal for the '<em><b>Timeout</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SERIAL_TO_NETWORK_MAPPING__TIMEOUT = eINSTANCE.getSerialToNetworkMapping_Timeout ();

        /**
         * The meta object literal for the '<em><b>Baud Rate</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SERIAL_TO_NETWORK_MAPPING__BAUD_RATE = eINSTANCE.getSerialToNetworkMapping_BaudRate ();

        /**
         * The meta object literal for the '<em><b>Parity</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SERIAL_TO_NETWORK_MAPPING__PARITY = eINSTANCE.getSerialToNetworkMapping_Parity ();

        /**
         * The meta object literal for the '<em><b>Xonxoff</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SERIAL_TO_NETWORK_MAPPING__XONXOFF = eINSTANCE.getSerialToNetworkMapping_Xonxoff ();

        /**
         * The meta object literal for the '<em><b>Rtscts</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SERIAL_TO_NETWORK_MAPPING__RTSCTS = eINSTANCE.getSerialToNetworkMapping_Rtscts ();

        /**
         * The meta object literal for the '<em><b>Data Bits</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SERIAL_TO_NETWORK_MAPPING__DATA_BITS = eINSTANCE.getSerialToNetworkMapping_DataBits ();

        /**
         * The meta object literal for the '<em><b>Stop Bits</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SERIAL_TO_NETWORK_MAPPING__STOP_BITS = eINSTANCE.getSerialToNetworkMapping_StopBits ();

        /**
         * The meta object literal for the '<em><b>Modem Control</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SERIAL_TO_NETWORK_MAPPING__MODEM_CONTROL = eINSTANCE.getSerialToNetworkMapping_ModemControl ();

        /**
         * The meta object literal for the '<em><b>Break</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SERIAL_TO_NETWORK_MAPPING__BREAK = eINSTANCE.getSerialToNetworkMapping_Break ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.setup.common.Parity <em>Parity</em>}' enum.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.setup.common.Parity
         * @see org.eclipse.scada.configuration.setup.common.impl.CommonPackageImpl#getParity()
         * @generated
         */
        EEnum PARITY = eINSTANCE.getParity ();

    }

} //CommonPackage
