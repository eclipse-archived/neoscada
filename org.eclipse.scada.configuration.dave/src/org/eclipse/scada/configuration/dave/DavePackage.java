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
package org.eclipse.scada.configuration.dave;

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
 * @see org.eclipse.scada.configuration.dave.DaveFactory
 * @model kind="package"
 * @generated
 */
public interface DavePackage extends EPackage
{
    /**
     * The package name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNAME = "dave"; //$NON-NLS-1$

    /**
     * The package namespace URI.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_URI = "http://eclipse.org/SCADA/Configuration/Dave"; //$NON-NLS-1$

    /**
     * The package namespace name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_PREFIX = "dave"; //$NON-NLS-1$

    /**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    DavePackage eINSTANCE = org.eclipse.scada.configuration.dave.impl.DavePackageImpl.init ();

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.dave.impl.DaveDeviceImpl <em>Device</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.dave.impl.DaveDeviceImpl
     * @see org.eclipse.scada.configuration.dave.impl.DavePackageImpl#getDaveDevice()
     * @generated
     */
    int DAVE_DEVICE = 0;

    /**
     * The feature id for the '<em><b>Short Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DAVE_DEVICE__SHORT_DESCRIPTION = InfrastructurePackage.DEVICE__SHORT_DESCRIPTION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DAVE_DEVICE__NAME = InfrastructurePackage.DEVICE__NAME;

    /**
     * The feature id for the '<em><b>Node</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DAVE_DEVICE__NODE = InfrastructurePackage.DEVICE__NODE;

    /**
     * The feature id for the '<em><b>Port</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DAVE_DEVICE__PORT = InfrastructurePackage.DEVICE_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Rack</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DAVE_DEVICE__RACK = InfrastructurePackage.DEVICE_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Slot</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DAVE_DEVICE__SLOT = InfrastructurePackage.DEVICE_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Blocks</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DAVE_DEVICE__BLOCKS = InfrastructurePackage.DEVICE_FEATURE_COUNT + 3;

    /**
     * The feature id for the '<em><b>Type System</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DAVE_DEVICE__TYPE_SYSTEM = InfrastructurePackage.DEVICE_FEATURE_COUNT + 4;

    /**
     * The feature id for the '<em><b>Read Timeout</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DAVE_DEVICE__READ_TIMEOUT = InfrastructurePackage.DEVICE_FEATURE_COUNT + 5;

    /**
     * The number of structural features of the '<em>Device</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DAVE_DEVICE_FEATURE_COUNT = InfrastructurePackage.DEVICE_FEATURE_COUNT + 6;

    /**
     * The number of operations of the '<em>Device</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DAVE_DEVICE_OPERATION_COUNT = InfrastructurePackage.DEVICE_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.dave.impl.DaveDriverImpl <em>Driver</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.dave.impl.DaveDriverImpl
     * @see org.eclipse.scada.configuration.dave.impl.DavePackageImpl#getDaveDriver()
     * @generated
     */
    int DAVE_DRIVER = 1;

    /**
     * The feature id for the '<em><b>Short Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DAVE_DRIVER__SHORT_DESCRIPTION = WorldPackage.DRIVER__SHORT_DESCRIPTION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DAVE_DRIVER__NAME = WorldPackage.DRIVER__NAME;

    /**
     * The feature id for the '<em><b>Connections</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DAVE_DRIVER__CONNECTIONS = WorldPackage.DRIVER_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Exporter</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DAVE_DRIVER__EXPORTER = WorldPackage.DRIVER_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Customization Profile</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DAVE_DRIVER__CUSTOMIZATION_PROFILE = WorldPackage.DRIVER_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Security Configuration</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DAVE_DRIVER__SECURITY_CONFIGURATION = WorldPackage.DRIVER_FEATURE_COUNT + 3;

    /**
     * The feature id for the '<em><b>Modules</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DAVE_DRIVER__MODULES = WorldPackage.DRIVER_FEATURE_COUNT + 4;

    /**
     * The feature id for the '<em><b>Devices</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DAVE_DRIVER__DEVICES = WorldPackage.DRIVER_FEATURE_COUNT + 5;

    /**
     * The number of structural features of the '<em>Driver</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DAVE_DRIVER_FEATURE_COUNT = WorldPackage.DRIVER_FEATURE_COUNT + 6;

    /**
     * The operation id for the '<em>Get Endpoints</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DAVE_DRIVER___GET_ENDPOINTS = WorldPackage.DRIVER___GET_ENDPOINTS;

    /**
     * The operation id for the '<em>Get Profile</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DAVE_DRIVER___GET_PROFILE = WorldPackage.DRIVER_OPERATION_COUNT + 0;

    /**
     * The number of operations of the '<em>Driver</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DAVE_DRIVER_OPERATION_COUNT = WorldPackage.DRIVER_OPERATION_COUNT + 1;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.dave.impl.DaveCommunicationProcessorImpl <em>Communication Processor</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.dave.impl.DaveCommunicationProcessorImpl
     * @see org.eclipse.scada.configuration.dave.impl.DavePackageImpl#getDaveCommunicationProcessor()
     * @generated
     */
    int DAVE_COMMUNICATION_PROCESSOR = 2;

    /**
     * The feature id for the '<em><b>Endpoint</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DAVE_COMMUNICATION_PROCESSOR__ENDPOINT = 0;

    /**
     * The feature id for the '<em><b>Blocks</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DAVE_COMMUNICATION_PROCESSOR__BLOCKS = 1;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DAVE_COMMUNICATION_PROCESSOR__ID = 2;

    /**
     * The feature id for the '<em><b>Rack</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DAVE_COMMUNICATION_PROCESSOR__RACK = 3;

    /**
     * The feature id for the '<em><b>Slot</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DAVE_COMMUNICATION_PROCESSOR__SLOT = 4;

    /**
     * The feature id for the '<em><b>Read Timeout</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DAVE_COMMUNICATION_PROCESSOR__READ_TIMEOUT = 5;

    /**
     * The number of structural features of the '<em>Communication Processor</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DAVE_COMMUNICATION_PROCESSOR_FEATURE_COUNT = 6;

    /**
     * The number of operations of the '<em>Communication Processor</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DAVE_COMMUNICATION_PROCESSOR_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.dave.impl.DaveRequestBlockImpl <em>Request Block</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.dave.impl.DaveRequestBlockImpl
     * @see org.eclipse.scada.configuration.dave.impl.DavePackageImpl#getDaveRequestBlock()
     * @generated
     */
    int DAVE_REQUEST_BLOCK = 3;

    /**
     * The feature id for the '<em><b>Type</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DAVE_REQUEST_BLOCK__TYPE = 0;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DAVE_REQUEST_BLOCK__ID = 1;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DAVE_REQUEST_BLOCK__NAME = 2;

    /**
     * The feature id for the '<em><b>Area</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DAVE_REQUEST_BLOCK__AREA = 3;

    /**
     * The feature id for the '<em><b>Block</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DAVE_REQUEST_BLOCK__BLOCK = 4;

    /**
     * The feature id for the '<em><b>Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DAVE_REQUEST_BLOCK__OFFSET = 5;

    /**
     * The feature id for the '<em><b>Length</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DAVE_REQUEST_BLOCK__LENGTH = 6;

    /**
     * The feature id for the '<em><b>Period</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DAVE_REQUEST_BLOCK__PERIOD = 7;

    /**
     * The feature id for the '<em><b>Enable Statistics</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DAVE_REQUEST_BLOCK__ENABLE_STATISTICS = 8;

    /**
     * The feature id for the '<em><b>Device</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DAVE_REQUEST_BLOCK__DEVICE = 9;

    /**
     * The number of structural features of the '<em>Request Block</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DAVE_REQUEST_BLOCK_FEATURE_COUNT = 10;

    /**
     * The number of operations of the '<em>Request Block</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DAVE_REQUEST_BLOCK_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.dave.impl.DaveBlockDefinitionImpl <em>Block Definition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.dave.impl.DaveBlockDefinitionImpl
     * @see org.eclipse.scada.configuration.dave.impl.DavePackageImpl#getDaveBlockDefinition()
     * @generated
     */
    int DAVE_BLOCK_DEFINITION = 4;

    /**
     * The feature id for the '<em><b>Block</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DAVE_BLOCK_DEFINITION__BLOCK = 0;

    /**
     * The feature id for the '<em><b>Device</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DAVE_BLOCK_DEFINITION__DEVICE = 1;

    /**
     * The feature id for the '<em><b>Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DAVE_BLOCK_DEFINITION__OFFSET = 2;

    /**
     * The feature id for the '<em><b>Period</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DAVE_BLOCK_DEFINITION__PERIOD = 3;

    /**
     * The feature id for the '<em><b>Enable Statistics</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DAVE_BLOCK_DEFINITION__ENABLE_STATISTICS = 4;

    /**
     * The feature id for the '<em><b>Type</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DAVE_BLOCK_DEFINITION__TYPE = 5;

    /**
     * The feature id for the '<em><b>Area</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DAVE_BLOCK_DEFINITION__AREA = 6;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DAVE_BLOCK_DEFINITION__NAME = 7;

    /**
     * The number of structural features of the '<em>Block Definition</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DAVE_BLOCK_DEFINITION_FEATURE_COUNT = 8;

    /**
     * The number of operations of the '<em>Block Definition</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DAVE_BLOCK_DEFINITION_OPERATION_COUNT = 0;

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.dave.DaveDevice <em>Device</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Device</em>'.
     * @see org.eclipse.scada.configuration.dave.DaveDevice
     * @generated
     */
    EClass getDaveDevice ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.dave.DaveDevice#getPort <em>Port</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Port</em>'.
     * @see org.eclipse.scada.configuration.dave.DaveDevice#getPort()
     * @see #getDaveDevice()
     * @generated
     */
    EAttribute getDaveDevice_Port ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.dave.DaveDevice#getRack <em>Rack</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Rack</em>'.
     * @see org.eclipse.scada.configuration.dave.DaveDevice#getRack()
     * @see #getDaveDevice()
     * @generated
     */
    EAttribute getDaveDevice_Rack ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.dave.DaveDevice#getSlot <em>Slot</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Slot</em>'.
     * @see org.eclipse.scada.configuration.dave.DaveDevice#getSlot()
     * @see #getDaveDevice()
     * @generated
     */
    EAttribute getDaveDevice_Slot ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.configuration.dave.DaveDevice#getBlocks <em>Blocks</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Blocks</em>'.
     * @see org.eclipse.scada.configuration.dave.DaveDevice#getBlocks()
     * @see #getDaveDevice()
     * @generated
     */
    EReference getDaveDevice_Blocks ();

    /**
     * Returns the meta object for the reference '{@link org.eclipse.scada.configuration.dave.DaveDevice#getTypeSystem <em>Type System</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Type System</em>'.
     * @see org.eclipse.scada.configuration.dave.DaveDevice#getTypeSystem()
     * @see #getDaveDevice()
     * @generated
     */
    EReference getDaveDevice_TypeSystem ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.dave.DaveDevice#getReadTimeout <em>Read Timeout</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Read Timeout</em>'.
     * @see org.eclipse.scada.configuration.dave.DaveDevice#getReadTimeout()
     * @see #getDaveDevice()
     * @generated
     */
    EAttribute getDaveDevice_ReadTimeout ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.dave.DaveDriver <em>Driver</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Driver</em>'.
     * @see org.eclipse.scada.configuration.dave.DaveDriver
     * @generated
     */
    EClass getDaveDriver ();

    /**
     * Returns the meta object for the reference list '{@link org.eclipse.scada.configuration.dave.DaveDriver#getDevices <em>Devices</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Devices</em>'.
     * @see org.eclipse.scada.configuration.dave.DaveDriver#getDevices()
     * @see #getDaveDriver()
     * @generated
     */
    EReference getDaveDriver_Devices ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.dave.DaveCommunicationProcessor <em>Communication Processor</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Communication Processor</em>'.
     * @see org.eclipse.scada.configuration.dave.DaveCommunicationProcessor
     * @generated
     */
    EClass getDaveCommunicationProcessor ();

    /**
     * Returns the meta object for the reference '{@link org.eclipse.scada.configuration.dave.DaveCommunicationProcessor#getEndpoint <em>Endpoint</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Endpoint</em>'.
     * @see org.eclipse.scada.configuration.dave.DaveCommunicationProcessor#getEndpoint()
     * @see #getDaveCommunicationProcessor()
     * @generated
     */
    EReference getDaveCommunicationProcessor_Endpoint ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.configuration.dave.DaveCommunicationProcessor#getBlocks <em>Blocks</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Blocks</em>'.
     * @see org.eclipse.scada.configuration.dave.DaveCommunicationProcessor#getBlocks()
     * @see #getDaveCommunicationProcessor()
     * @generated
     */
    EReference getDaveCommunicationProcessor_Blocks ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.dave.DaveCommunicationProcessor#getId <em>Id</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Id</em>'.
     * @see org.eclipse.scada.configuration.dave.DaveCommunicationProcessor#getId()
     * @see #getDaveCommunicationProcessor()
     * @generated
     */
    EAttribute getDaveCommunicationProcessor_Id ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.dave.DaveCommunicationProcessor#getRack <em>Rack</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Rack</em>'.
     * @see org.eclipse.scada.configuration.dave.DaveCommunicationProcessor#getRack()
     * @see #getDaveCommunicationProcessor()
     * @generated
     */
    EAttribute getDaveCommunicationProcessor_Rack ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.dave.DaveCommunicationProcessor#getSlot <em>Slot</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Slot</em>'.
     * @see org.eclipse.scada.configuration.dave.DaveCommunicationProcessor#getSlot()
     * @see #getDaveCommunicationProcessor()
     * @generated
     */
    EAttribute getDaveCommunicationProcessor_Slot ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.dave.DaveCommunicationProcessor#getReadTimeout <em>Read Timeout</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Read Timeout</em>'.
     * @see org.eclipse.scada.configuration.dave.DaveCommunicationProcessor#getReadTimeout()
     * @see #getDaveCommunicationProcessor()
     * @generated
     */
    EAttribute getDaveCommunicationProcessor_ReadTimeout ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.dave.DaveRequestBlock <em>Request Block</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Request Block</em>'.
     * @see org.eclipse.scada.configuration.dave.DaveRequestBlock
     * @generated
     */
    EClass getDaveRequestBlock ();

    /**
     * Returns the meta object for the reference '{@link org.eclipse.scada.configuration.dave.DaveRequestBlock#getType <em>Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Type</em>'.
     * @see org.eclipse.scada.configuration.dave.DaveRequestBlock#getType()
     * @see #getDaveRequestBlock()
     * @generated
     */
    EReference getDaveRequestBlock_Type ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.dave.DaveRequestBlock#getId <em>Id</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Id</em>'.
     * @see org.eclipse.scada.configuration.dave.DaveRequestBlock#getId()
     * @see #getDaveRequestBlock()
     * @generated
     */
    EAttribute getDaveRequestBlock_Id ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.dave.DaveRequestBlock#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see org.eclipse.scada.configuration.dave.DaveRequestBlock#getName()
     * @see #getDaveRequestBlock()
     * @generated
     */
    EAttribute getDaveRequestBlock_Name ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.dave.DaveRequestBlock#getArea <em>Area</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Area</em>'.
     * @see org.eclipse.scada.configuration.dave.DaveRequestBlock#getArea()
     * @see #getDaveRequestBlock()
     * @generated
     */
    EAttribute getDaveRequestBlock_Area ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.dave.DaveRequestBlock#getBlock <em>Block</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Block</em>'.
     * @see org.eclipse.scada.configuration.dave.DaveRequestBlock#getBlock()
     * @see #getDaveRequestBlock()
     * @generated
     */
    EAttribute getDaveRequestBlock_Block ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.dave.DaveRequestBlock#getOffset <em>Offset</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Offset</em>'.
     * @see org.eclipse.scada.configuration.dave.DaveRequestBlock#getOffset()
     * @see #getDaveRequestBlock()
     * @generated
     */
    EAttribute getDaveRequestBlock_Offset ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.dave.DaveRequestBlock#getLength <em>Length</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Length</em>'.
     * @see org.eclipse.scada.configuration.dave.DaveRequestBlock#getLength()
     * @see #getDaveRequestBlock()
     * @generated
     */
    EAttribute getDaveRequestBlock_Length ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.dave.DaveRequestBlock#getPeriod <em>Period</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Period</em>'.
     * @see org.eclipse.scada.configuration.dave.DaveRequestBlock#getPeriod()
     * @see #getDaveRequestBlock()
     * @generated
     */
    EAttribute getDaveRequestBlock_Period ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.dave.DaveRequestBlock#isEnableStatistics <em>Enable Statistics</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Enable Statistics</em>'.
     * @see org.eclipse.scada.configuration.dave.DaveRequestBlock#isEnableStatistics()
     * @see #getDaveRequestBlock()
     * @generated
     */
    EAttribute getDaveRequestBlock_EnableStatistics ();

    /**
     * Returns the meta object for the container reference '{@link org.eclipse.scada.configuration.dave.DaveRequestBlock#getDevice <em>Device</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Device</em>'.
     * @see org.eclipse.scada.configuration.dave.DaveRequestBlock#getDevice()
     * @see #getDaveRequestBlock()
     * @generated
     */
    EReference getDaveRequestBlock_Device ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.dave.DaveBlockDefinition <em>Block Definition</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Block Definition</em>'.
     * @see org.eclipse.scada.configuration.dave.DaveBlockDefinition
     * @generated
     */
    EClass getDaveBlockDefinition ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.dave.DaveBlockDefinition#getBlock <em>Block</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Block</em>'.
     * @see org.eclipse.scada.configuration.dave.DaveBlockDefinition#getBlock()
     * @see #getDaveBlockDefinition()
     * @generated
     */
    EAttribute getDaveBlockDefinition_Block ();

    /**
     * Returns the meta object for the container reference '{@link org.eclipse.scada.configuration.dave.DaveBlockDefinition#getDevice <em>Device</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Device</em>'.
     * @see org.eclipse.scada.configuration.dave.DaveBlockDefinition#getDevice()
     * @see #getDaveBlockDefinition()
     * @generated
     */
    EReference getDaveBlockDefinition_Device ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.dave.DaveBlockDefinition#getOffset <em>Offset</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Offset</em>'.
     * @see org.eclipse.scada.configuration.dave.DaveBlockDefinition#getOffset()
     * @see #getDaveBlockDefinition()
     * @generated
     */
    EAttribute getDaveBlockDefinition_Offset ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.dave.DaveBlockDefinition#getPeriod <em>Period</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Period</em>'.
     * @see org.eclipse.scada.configuration.dave.DaveBlockDefinition#getPeriod()
     * @see #getDaveBlockDefinition()
     * @generated
     */
    EAttribute getDaveBlockDefinition_Period ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.dave.DaveBlockDefinition#isEnableStatistics <em>Enable Statistics</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Enable Statistics</em>'.
     * @see org.eclipse.scada.configuration.dave.DaveBlockDefinition#isEnableStatistics()
     * @see #getDaveBlockDefinition()
     * @generated
     */
    EAttribute getDaveBlockDefinition_EnableStatistics ();

    /**
     * Returns the meta object for the reference '{@link org.eclipse.scada.configuration.dave.DaveBlockDefinition#getType <em>Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Type</em>'.
     * @see org.eclipse.scada.configuration.dave.DaveBlockDefinition#getType()
     * @see #getDaveBlockDefinition()
     * @generated
     */
    EReference getDaveBlockDefinition_Type ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.dave.DaveBlockDefinition#getArea <em>Area</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Area</em>'.
     * @see org.eclipse.scada.configuration.dave.DaveBlockDefinition#getArea()
     * @see #getDaveBlockDefinition()
     * @generated
     */
    EAttribute getDaveBlockDefinition_Area ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.dave.DaveBlockDefinition#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see org.eclipse.scada.configuration.dave.DaveBlockDefinition#getName()
     * @see #getDaveBlockDefinition()
     * @generated
     */
    EAttribute getDaveBlockDefinition_Name ();

    /**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
    DaveFactory getDaveFactory ();

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
         * The meta object literal for the '{@link org.eclipse.scada.configuration.dave.impl.DaveDeviceImpl <em>Device</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.dave.impl.DaveDeviceImpl
         * @see org.eclipse.scada.configuration.dave.impl.DavePackageImpl#getDaveDevice()
         * @generated
         */
        EClass DAVE_DEVICE = eINSTANCE.getDaveDevice ();

        /**
         * The meta object literal for the '<em><b>Port</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute DAVE_DEVICE__PORT = eINSTANCE.getDaveDevice_Port ();

        /**
         * The meta object literal for the '<em><b>Rack</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute DAVE_DEVICE__RACK = eINSTANCE.getDaveDevice_Rack ();

        /**
         * The meta object literal for the '<em><b>Slot</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute DAVE_DEVICE__SLOT = eINSTANCE.getDaveDevice_Slot ();

        /**
         * The meta object literal for the '<em><b>Blocks</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference DAVE_DEVICE__BLOCKS = eINSTANCE.getDaveDevice_Blocks ();

        /**
         * The meta object literal for the '<em><b>Type System</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference DAVE_DEVICE__TYPE_SYSTEM = eINSTANCE.getDaveDevice_TypeSystem ();

        /**
         * The meta object literal for the '<em><b>Read Timeout</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute DAVE_DEVICE__READ_TIMEOUT = eINSTANCE.getDaveDevice_ReadTimeout ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.dave.impl.DaveDriverImpl <em>Driver</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.dave.impl.DaveDriverImpl
         * @see org.eclipse.scada.configuration.dave.impl.DavePackageImpl#getDaveDriver()
         * @generated
         */
        EClass DAVE_DRIVER = eINSTANCE.getDaveDriver ();

        /**
         * The meta object literal for the '<em><b>Devices</b></em>' reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference DAVE_DRIVER__DEVICES = eINSTANCE.getDaveDriver_Devices ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.dave.impl.DaveCommunicationProcessorImpl <em>Communication Processor</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.dave.impl.DaveCommunicationProcessorImpl
         * @see org.eclipse.scada.configuration.dave.impl.DavePackageImpl#getDaveCommunicationProcessor()
         * @generated
         */
        EClass DAVE_COMMUNICATION_PROCESSOR = eINSTANCE.getDaveCommunicationProcessor ();

        /**
         * The meta object literal for the '<em><b>Endpoint</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference DAVE_COMMUNICATION_PROCESSOR__ENDPOINT = eINSTANCE.getDaveCommunicationProcessor_Endpoint ();

        /**
         * The meta object literal for the '<em><b>Blocks</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference DAVE_COMMUNICATION_PROCESSOR__BLOCKS = eINSTANCE.getDaveCommunicationProcessor_Blocks ();

        /**
         * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute DAVE_COMMUNICATION_PROCESSOR__ID = eINSTANCE.getDaveCommunicationProcessor_Id ();

        /**
         * The meta object literal for the '<em><b>Rack</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute DAVE_COMMUNICATION_PROCESSOR__RACK = eINSTANCE.getDaveCommunicationProcessor_Rack ();

        /**
         * The meta object literal for the '<em><b>Slot</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute DAVE_COMMUNICATION_PROCESSOR__SLOT = eINSTANCE.getDaveCommunicationProcessor_Slot ();

        /**
         * The meta object literal for the '<em><b>Read Timeout</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute DAVE_COMMUNICATION_PROCESSOR__READ_TIMEOUT = eINSTANCE.getDaveCommunicationProcessor_ReadTimeout ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.dave.impl.DaveRequestBlockImpl <em>Request Block</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.dave.impl.DaveRequestBlockImpl
         * @see org.eclipse.scada.configuration.dave.impl.DavePackageImpl#getDaveRequestBlock()
         * @generated
         */
        EClass DAVE_REQUEST_BLOCK = eINSTANCE.getDaveRequestBlock ();

        /**
         * The meta object literal for the '<em><b>Type</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference DAVE_REQUEST_BLOCK__TYPE = eINSTANCE.getDaveRequestBlock_Type ();

        /**
         * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute DAVE_REQUEST_BLOCK__ID = eINSTANCE.getDaveRequestBlock_Id ();

        /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute DAVE_REQUEST_BLOCK__NAME = eINSTANCE.getDaveRequestBlock_Name ();

        /**
         * The meta object literal for the '<em><b>Area</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute DAVE_REQUEST_BLOCK__AREA = eINSTANCE.getDaveRequestBlock_Area ();

        /**
         * The meta object literal for the '<em><b>Block</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute DAVE_REQUEST_BLOCK__BLOCK = eINSTANCE.getDaveRequestBlock_Block ();

        /**
         * The meta object literal for the '<em><b>Offset</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute DAVE_REQUEST_BLOCK__OFFSET = eINSTANCE.getDaveRequestBlock_Offset ();

        /**
         * The meta object literal for the '<em><b>Length</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute DAVE_REQUEST_BLOCK__LENGTH = eINSTANCE.getDaveRequestBlock_Length ();

        /**
         * The meta object literal for the '<em><b>Period</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute DAVE_REQUEST_BLOCK__PERIOD = eINSTANCE.getDaveRequestBlock_Period ();

        /**
         * The meta object literal for the '<em><b>Enable Statistics</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute DAVE_REQUEST_BLOCK__ENABLE_STATISTICS = eINSTANCE.getDaveRequestBlock_EnableStatistics ();

        /**
         * The meta object literal for the '<em><b>Device</b></em>' container reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference DAVE_REQUEST_BLOCK__DEVICE = eINSTANCE.getDaveRequestBlock_Device ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.dave.impl.DaveBlockDefinitionImpl <em>Block Definition</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.dave.impl.DaveBlockDefinitionImpl
         * @see org.eclipse.scada.configuration.dave.impl.DavePackageImpl#getDaveBlockDefinition()
         * @generated
         */
        EClass DAVE_BLOCK_DEFINITION = eINSTANCE.getDaveBlockDefinition ();

        /**
         * The meta object literal for the '<em><b>Block</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute DAVE_BLOCK_DEFINITION__BLOCK = eINSTANCE.getDaveBlockDefinition_Block ();

        /**
         * The meta object literal for the '<em><b>Device</b></em>' container reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference DAVE_BLOCK_DEFINITION__DEVICE = eINSTANCE.getDaveBlockDefinition_Device ();

        /**
         * The meta object literal for the '<em><b>Offset</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute DAVE_BLOCK_DEFINITION__OFFSET = eINSTANCE.getDaveBlockDefinition_Offset ();

        /**
         * The meta object literal for the '<em><b>Period</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute DAVE_BLOCK_DEFINITION__PERIOD = eINSTANCE.getDaveBlockDefinition_Period ();

        /**
         * The meta object literal for the '<em><b>Enable Statistics</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute DAVE_BLOCK_DEFINITION__ENABLE_STATISTICS = eINSTANCE.getDaveBlockDefinition_EnableStatistics ();

        /**
         * The meta object literal for the '<em><b>Type</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference DAVE_BLOCK_DEFINITION__TYPE = eINSTANCE.getDaveBlockDefinition_Type ();

        /**
         * The meta object literal for the '<em><b>Area</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute DAVE_BLOCK_DEFINITION__AREA = eINSTANCE.getDaveBlockDefinition_Area ();

        /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute DAVE_BLOCK_DEFINITION__NAME = eINSTANCE.getDaveBlockDefinition_Name ();

    }

} //DavePackage
