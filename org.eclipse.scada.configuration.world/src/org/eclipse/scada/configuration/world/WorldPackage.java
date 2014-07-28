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
package org.eclipse.scada.configuration.world;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

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
 * @see org.eclipse.scada.configuration.world.WorldFactory
 * @model kind="package"
 * @generated
 */
public interface WorldPackage extends EPackage
{
    /**
     * The package name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNAME = "world"; //$NON-NLS-1$

    /**
     * The package namespace URI.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_URI = "http://eclipse.org/SCADA/Configuration/World"; //$NON-NLS-1$

    /**
     * The package namespace name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_PREFIX = "world"; //$NON-NLS-1$

    /**
     * The package content type ID.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eCONTENT_TYPE = "org.eclipse.scada.configuration.world"; //$NON-NLS-1$

    /**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    WorldPackage eINSTANCE = org.eclipse.scada.configuration.world.impl.WorldPackageImpl.init ();

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.world.impl.WorldImpl <em>World</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.world.impl.WorldImpl
     * @see org.eclipse.scada.configuration.world.impl.WorldPackageImpl#getWorld()
     * @generated
     */
    int WORLD = 0;

    /**
     * The feature id for the '<em><b>Nodes</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WORLD__NODES = 0;

    /**
     * The feature id for the '<em><b>Options</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WORLD__OPTIONS = 1;

    /**
     * The number of structural features of the '<em>World</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WORLD_FEATURE_COUNT = 2;

    /**
     * The number of operations of the '<em>World</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WORLD_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.world.Documentable <em>Documentable</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.world.Documentable
     * @see org.eclipse.scada.configuration.world.impl.WorldPackageImpl#getDocumentable()
     * @generated
     */
    int DOCUMENTABLE = 3;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.world.impl.NodeImpl <em>Node</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.world.impl.NodeImpl
     * @see org.eclipse.scada.configuration.world.impl.WorldPackageImpl#getNode()
     * @generated
     */
    int NODE = 1;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.world.impl.ApplicationNodeImpl <em>Application Node</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.world.impl.ApplicationNodeImpl
     * @see org.eclipse.scada.configuration.world.impl.WorldPackageImpl#getApplicationNode()
     * @generated
     */
    int APPLICATION_NODE = 2;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.world.Application <em>Application</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.world.Application
     * @see org.eclipse.scada.configuration.world.impl.WorldPackageImpl#getApplication()
     * @generated
     */
    int APPLICATION = 4;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.world.Driver <em>Driver</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.world.Driver
     * @see org.eclipse.scada.configuration.world.impl.WorldPackageImpl#getDriver()
     * @generated
     */
    int DRIVER = 5;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.world.impl.EndpointImpl <em>Endpoint</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.world.impl.EndpointImpl
     * @see org.eclipse.scada.configuration.world.impl.WorldPackageImpl#getEndpoint()
     * @generated
     */
    int ENDPOINT = 6;

    /**
     * The feature id for the '<em><b>Short Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DOCUMENTABLE__SHORT_DESCRIPTION = 0;

    /**
     * The number of structural features of the '<em>Documentable</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DOCUMENTABLE_FEATURE_COUNT = 1;

    /**
     * The number of operations of the '<em>Documentable</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DOCUMENTABLE_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.world.NamedDocumentable <em>Named Documentable</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.world.NamedDocumentable
     * @see org.eclipse.scada.configuration.world.impl.WorldPackageImpl#getNamedDocumentable()
     * @generated
     */
    int NAMED_DOCUMENTABLE = 17;

    /**
     * The feature id for the '<em><b>Short Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NAMED_DOCUMENTABLE__SHORT_DESCRIPTION = DOCUMENTABLE__SHORT_DESCRIPTION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NAMED_DOCUMENTABLE__NAME = DOCUMENTABLE_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Named Documentable</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NAMED_DOCUMENTABLE_FEATURE_COUNT = DOCUMENTABLE_FEATURE_COUNT + 1;

    /**
     * The number of operations of the '<em>Named Documentable</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NAMED_DOCUMENTABLE_OPERATION_COUNT = DOCUMENTABLE_OPERATION_COUNT + 0;

    /**
     * The feature id for the '<em><b>Short Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NODE__SHORT_DESCRIPTION = NAMED_DOCUMENTABLE__SHORT_DESCRIPTION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NODE__NAME = NAMED_DOCUMENTABLE__NAME;

    /**
     * The feature id for the '<em><b>Host Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NODE__HOST_NAME = NAMED_DOCUMENTABLE_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Endpoints</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NODE__ENDPOINTS = NAMED_DOCUMENTABLE_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Deployments</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NODE__DEPLOYMENTS = NAMED_DOCUMENTABLE_FEATURE_COUNT + 2;

    /**
     * The number of structural features of the '<em>Node</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NODE_FEATURE_COUNT = NAMED_DOCUMENTABLE_FEATURE_COUNT + 3;

    /**
     * The number of operations of the '<em>Node</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NODE_OPERATION_COUNT = NAMED_DOCUMENTABLE_OPERATION_COUNT + 0;

    /**
     * The feature id for the '<em><b>Short Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int APPLICATION_NODE__SHORT_DESCRIPTION = NODE__SHORT_DESCRIPTION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int APPLICATION_NODE__NAME = NODE__NAME;

    /**
     * The feature id for the '<em><b>Host Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int APPLICATION_NODE__HOST_NAME = NODE__HOST_NAME;

    /**
     * The feature id for the '<em><b>Endpoints</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int APPLICATION_NODE__ENDPOINTS = NODE__ENDPOINTS;

    /**
     * The feature id for the '<em><b>Deployments</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int APPLICATION_NODE__DEPLOYMENTS = NODE__DEPLOYMENTS;

    /**
     * The feature id for the '<em><b>Applications</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int APPLICATION_NODE__APPLICATIONS = NODE_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Services</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int APPLICATION_NODE__SERVICES = NODE_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Application Node</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int APPLICATION_NODE_FEATURE_COUNT = NODE_FEATURE_COUNT + 2;

    /**
     * The number of operations of the '<em>Application Node</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int APPLICATION_NODE_OPERATION_COUNT = NODE_OPERATION_COUNT + 0;

    /**
     * The feature id for the '<em><b>Short Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int APPLICATION__SHORT_DESCRIPTION = NAMED_DOCUMENTABLE__SHORT_DESCRIPTION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int APPLICATION__NAME = NAMED_DOCUMENTABLE__NAME;

    /**
     * The number of structural features of the '<em>Application</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int APPLICATION_FEATURE_COUNT = NAMED_DOCUMENTABLE_FEATURE_COUNT + 0;

    /**
     * The number of operations of the '<em>Application</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int APPLICATION_OPERATION_COUNT = NAMED_DOCUMENTABLE_OPERATION_COUNT + 0;

    /**
     * The feature id for the '<em><b>Short Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DRIVER__SHORT_DESCRIPTION = APPLICATION__SHORT_DESCRIPTION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DRIVER__NAME = APPLICATION__NAME;

    /**
     * The number of structural features of the '<em>Driver</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DRIVER_FEATURE_COUNT = APPLICATION_FEATURE_COUNT + 0;

    /**
     * The operation id for the '<em>Get Endpoints</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DRIVER___GET_ENDPOINTS = APPLICATION_OPERATION_COUNT + 0;

    /**
     * The number of operations of the '<em>Driver</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DRIVER_OPERATION_COUNT = APPLICATION_OPERATION_COUNT + 1;

    /**
     * The feature id for the '<em><b>Short Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ENDPOINT__SHORT_DESCRIPTION = NAMED_DOCUMENTABLE__SHORT_DESCRIPTION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ENDPOINT__NAME = NAMED_DOCUMENTABLE__NAME;

    /**
     * The feature id for the '<em><b>Node</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ENDPOINT__NODE = NAMED_DOCUMENTABLE_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Port Number</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ENDPOINT__PORT_NUMBER = NAMED_DOCUMENTABLE_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Bound Service</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ENDPOINT__BOUND_SERVICE = NAMED_DOCUMENTABLE_FEATURE_COUNT + 2;

    /**
     * The number of structural features of the '<em>Endpoint</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ENDPOINT_FEATURE_COUNT = NAMED_DOCUMENTABLE_FEATURE_COUNT + 3;

    /**
     * The number of operations of the '<em>Endpoint</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ENDPOINT_OPERATION_COUNT = NAMED_DOCUMENTABLE_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.world.impl.CommonDriverImpl <em>Common Driver</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.world.impl.CommonDriverImpl
     * @see org.eclipse.scada.configuration.world.impl.WorldPackageImpl#getCommonDriver()
     * @generated
     */
    int COMMON_DRIVER = 8;

    /**
     * The feature id for the '<em><b>Short Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COMMON_DRIVER__SHORT_DESCRIPTION = DRIVER__SHORT_DESCRIPTION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COMMON_DRIVER__NAME = DRIVER__NAME;

    /**
     * The feature id for the '<em><b>Password</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COMMON_DRIVER__PASSWORD = DRIVER_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Endpoints</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COMMON_DRIVER__ENDPOINTS = DRIVER_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Common Driver</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COMMON_DRIVER_FEATURE_COUNT = DRIVER_FEATURE_COUNT + 2;

    /**
     * The operation id for the '<em>Get Endpoints</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COMMON_DRIVER___GET_ENDPOINTS = DRIVER___GET_ENDPOINTS;

    /**
     * The number of operations of the '<em>Common Driver</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COMMON_DRIVER_OPERATION_COUNT = DRIVER_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.world.impl.ExecDriverImpl <em>Exec Driver</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.world.impl.ExecDriverImpl
     * @see org.eclipse.scada.configuration.world.impl.WorldPackageImpl#getExecDriver()
     * @generated
     */
    int EXEC_DRIVER = 7;

    /**
     * The feature id for the '<em><b>Short Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXEC_DRIVER__SHORT_DESCRIPTION = COMMON_DRIVER__SHORT_DESCRIPTION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXEC_DRIVER__NAME = COMMON_DRIVER__NAME;

    /**
     * The feature id for the '<em><b>Password</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXEC_DRIVER__PASSWORD = COMMON_DRIVER__PASSWORD;

    /**
     * The feature id for the '<em><b>Endpoints</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXEC_DRIVER__ENDPOINTS = COMMON_DRIVER__ENDPOINTS;

    /**
     * The feature id for the '<em><b>Root</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXEC_DRIVER__ROOT = COMMON_DRIVER_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Exec Driver</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXEC_DRIVER_FEATURE_COUNT = COMMON_DRIVER_FEATURE_COUNT + 1;

    /**
     * The operation id for the '<em>Get Endpoints</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXEC_DRIVER___GET_ENDPOINTS = COMMON_DRIVER___GET_ENDPOINTS;

    /**
     * The number of operations of the '<em>Exec Driver</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXEC_DRIVER_OPERATION_COUNT = COMMON_DRIVER_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.world.impl.HandlerPriorityRuleImpl <em>Handler Priority Rule</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.world.impl.HandlerPriorityRuleImpl
     * @see org.eclipse.scada.configuration.world.impl.WorldPackageImpl#getHandlerPriorityRule()
     * @generated
     */
    int HANDLER_PRIORITY_RULE = 9;

    /**
     * The feature id for the '<em><b>Order</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HANDLER_PRIORITY_RULE__ORDER = 0;

    /**
     * The feature id for the '<em><b>Factory Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HANDLER_PRIORITY_RULE__FACTORY_ID = 1;

    /**
     * The feature id for the '<em><b>Configuration Filter</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HANDLER_PRIORITY_RULE__CONFIGURATION_FILTER = 2;

    /**
     * The feature id for the '<em><b>Priority</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HANDLER_PRIORITY_RULE__PRIORITY = 3;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HANDLER_PRIORITY_RULE__DESCRIPTION = 4;

    /**
     * The number of structural features of the '<em>Handler Priority Rule</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HANDLER_PRIORITY_RULE_FEATURE_COUNT = 5;

    /**
     * The number of operations of the '<em>Handler Priority Rule</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HANDLER_PRIORITY_RULE_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.world.impl.MasterHandlerPrioritiesImpl <em>Master Handler Priorities</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.world.impl.MasterHandlerPrioritiesImpl
     * @see org.eclipse.scada.configuration.world.impl.WorldPackageImpl#getMasterHandlerPriorities()
     * @generated
     */
    int MASTER_HANDLER_PRIORITIES = 10;

    /**
     * The feature id for the '<em><b>Short Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MASTER_HANDLER_PRIORITIES__SHORT_DESCRIPTION = NAMED_DOCUMENTABLE__SHORT_DESCRIPTION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MASTER_HANDLER_PRIORITIES__NAME = NAMED_DOCUMENTABLE__NAME;

    /**
     * The feature id for the '<em><b>Rules</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MASTER_HANDLER_PRIORITIES__RULES = NAMED_DOCUMENTABLE_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Master Handler Priorities</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MASTER_HANDLER_PRIORITIES_FEATURE_COUNT = NAMED_DOCUMENTABLE_FEATURE_COUNT + 1;

    /**
     * The number of operations of the '<em>Master Handler Priorities</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MASTER_HANDLER_PRIORITIES_OPERATION_COUNT = NAMED_DOCUMENTABLE_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.world.impl.OptionsImpl <em>Options</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.world.impl.OptionsImpl
     * @see org.eclipse.scada.configuration.world.impl.WorldPackageImpl#getOptions()
     * @generated
     */
    int OPTIONS = 11;

    /**
     * The feature id for the '<em><b>Master Handler Priorities</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OPTIONS__MASTER_HANDLER_PRIORITIES = 0;

    /**
     * The number of structural features of the '<em>Options</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OPTIONS_FEATURE_COUNT = 1;

    /**
     * The number of operations of the '<em>Options</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OPTIONS_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.world.Credentials <em>Credentials</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.world.Credentials
     * @see org.eclipse.scada.configuration.world.impl.WorldPackageImpl#getCredentials()
     * @generated
     */
    int CREDENTIALS = 14;

    /**
     * The number of structural features of the '<em>Credentials</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CREDENTIALS_FEATURE_COUNT = 0;

    /**
     * The number of operations of the '<em>Credentials</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CREDENTIALS_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.world.impl.UsernamePasswordCredentialsImpl <em>Username Password Credentials</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.world.impl.UsernamePasswordCredentialsImpl
     * @see org.eclipse.scada.configuration.world.impl.WorldPackageImpl#getUsernamePasswordCredentials()
     * @generated
     */
    int USERNAME_PASSWORD_CREDENTIALS = 12;

    /**
     * The feature id for the '<em><b>Username</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int USERNAME_PASSWORD_CREDENTIALS__USERNAME = CREDENTIALS_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Password</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int USERNAME_PASSWORD_CREDENTIALS__PASSWORD = CREDENTIALS_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Username Password Credentials</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int USERNAME_PASSWORD_CREDENTIALS_FEATURE_COUNT = CREDENTIALS_FEATURE_COUNT + 2;

    /**
     * The number of operations of the '<em>Username Password Credentials</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int USERNAME_PASSWORD_CREDENTIALS_OPERATION_COUNT = CREDENTIALS_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.world.impl.PasswordCredentialsImpl <em>Password Credentials</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.world.impl.PasswordCredentialsImpl
     * @see org.eclipse.scada.configuration.world.impl.WorldPackageImpl#getPasswordCredentials()
     * @generated
     */
    int PASSWORD_CREDENTIALS = 13;

    /**
     * The feature id for the '<em><b>Password</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PASSWORD_CREDENTIALS__PASSWORD = CREDENTIALS_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Password Credentials</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PASSWORD_CREDENTIALS_FEATURE_COUNT = CREDENTIALS_FEATURE_COUNT + 1;

    /**
     * The number of operations of the '<em>Password Credentials</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PASSWORD_CREDENTIALS_OPERATION_COUNT = CREDENTIALS_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.world.impl.ExternalNodeImpl <em>External Node</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.world.impl.ExternalNodeImpl
     * @see org.eclipse.scada.configuration.world.impl.WorldPackageImpl#getExternalNode()
     * @generated
     */
    int EXTERNAL_NODE = 15;

    /**
     * The feature id for the '<em><b>Short Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXTERNAL_NODE__SHORT_DESCRIPTION = NODE__SHORT_DESCRIPTION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXTERNAL_NODE__NAME = NODE__NAME;

    /**
     * The feature id for the '<em><b>Host Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXTERNAL_NODE__HOST_NAME = NODE__HOST_NAME;

    /**
     * The feature id for the '<em><b>Endpoints</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXTERNAL_NODE__ENDPOINTS = NODE__ENDPOINTS;

    /**
     * The feature id for the '<em><b>Deployments</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXTERNAL_NODE__DEPLOYMENTS = NODE__DEPLOYMENTS;

    /**
     * The number of structural features of the '<em>External Node</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXTERNAL_NODE_FEATURE_COUNT = NODE_FEATURE_COUNT + 0;

    /**
     * The number of operations of the '<em>External Node</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXTERNAL_NODE_OPERATION_COUNT = NODE_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.world.Service <em>Service</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.world.Service
     * @see org.eclipse.scada.configuration.world.impl.WorldPackageImpl#getService()
     * @generated
     */
    int SERVICE = 16;

    /**
     * The feature id for the '<em><b>Short Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SERVICE__SHORT_DESCRIPTION = NAMED_DOCUMENTABLE__SHORT_DESCRIPTION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SERVICE__NAME = NAMED_DOCUMENTABLE__NAME;

    /**
     * The number of structural features of the '<em>Service</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SERVICE_FEATURE_COUNT = NAMED_DOCUMENTABLE_FEATURE_COUNT + 0;

    /**
     * The number of operations of the '<em>Service</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SERVICE_OPERATION_COUNT = NAMED_DOCUMENTABLE_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.world.impl.PropertyEntryImpl <em>Property Entry</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.world.impl.PropertyEntryImpl
     * @see org.eclipse.scada.configuration.world.impl.WorldPackageImpl#getPropertyEntry()
     * @generated
     */
    int PROPERTY_ENTRY = 18;

    /**
     * The feature id for the '<em><b>Key</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PROPERTY_ENTRY__KEY = 0;

    /**
     * The feature id for the '<em><b>Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PROPERTY_ENTRY__VALUE = 1;

    /**
     * The number of structural features of the '<em>Property Entry</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PROPERTY_ENTRY_FEATURE_COUNT = 2;

    /**
     * The number of operations of the '<em>Property Entry</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PROPERTY_ENTRY_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.world.ServiceBinding <em>Service Binding</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.world.ServiceBinding
     * @see org.eclipse.scada.configuration.world.impl.WorldPackageImpl#getServiceBinding()
     * @generated
     */
    int SERVICE_BINDING = 19;

    /**
     * The number of structural features of the '<em>Service Binding</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SERVICE_BINDING_FEATURE_COUNT = 0;

    /**
     * The operation id for the '<em>Get Service</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SERVICE_BINDING___GET_SERVICE = 0;

    /**
     * The number of operations of the '<em>Service Binding</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SERVICE_BINDING_OPERATION_COUNT = 1;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.world.impl.ContainedServiceBindingImpl <em>Contained Service Binding</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.world.impl.ContainedServiceBindingImpl
     * @see org.eclipse.scada.configuration.world.impl.WorldPackageImpl#getContainedServiceBinding()
     * @generated
     */
    int CONTAINED_SERVICE_BINDING = 20;

    /**
     * The feature id for the '<em><b>Service</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONTAINED_SERVICE_BINDING__SERVICE = SERVICE_BINDING_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Contained Service Binding</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONTAINED_SERVICE_BINDING_FEATURE_COUNT = SERVICE_BINDING_FEATURE_COUNT + 1;

    /**
     * The operation id for the '<em>Get Service</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONTAINED_SERVICE_BINDING___GET_SERVICE = SERVICE_BINDING___GET_SERVICE;

    /**
     * The number of operations of the '<em>Contained Service Binding</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONTAINED_SERVICE_BINDING_OPERATION_COUNT = SERVICE_BINDING_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.world.impl.ReferencedServiceBindingImpl <em>Referenced Service Binding</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.world.impl.ReferencedServiceBindingImpl
     * @see org.eclipse.scada.configuration.world.impl.WorldPackageImpl#getReferencedServiceBinding()
     * @generated
     */
    int REFERENCED_SERVICE_BINDING = 21;

    /**
     * The feature id for the '<em><b>Service</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int REFERENCED_SERVICE_BINDING__SERVICE = SERVICE_BINDING_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Referenced Service Binding</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int REFERENCED_SERVICE_BINDING_FEATURE_COUNT = SERVICE_BINDING_FEATURE_COUNT + 1;

    /**
     * The operation id for the '<em>Get Service</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int REFERENCED_SERVICE_BINDING___GET_SERVICE = SERVICE_BINDING___GET_SERVICE;

    /**
     * The number of operations of the '<em>Referenced Service Binding</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int REFERENCED_SERVICE_BINDING_OPERATION_COUNT = SERVICE_BINDING_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.world.Settings <em>Settings</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.world.Settings
     * @see org.eclipse.scada.configuration.world.impl.WorldPackageImpl#getSettings()
     * @generated
     */
    int SETTINGS = 22;

    /**
     * The number of structural features of the '<em>Settings</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SETTINGS_FEATURE_COUNT = 0;

    /**
     * The number of operations of the '<em>Settings</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SETTINGS_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.world.DatabaseSettings <em>Database Settings</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.world.DatabaseSettings
     * @see org.eclipse.scada.configuration.world.impl.WorldPackageImpl#getDatabaseSettings()
     * @generated
     */
    int DATABASE_SETTINGS = 23;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATABASE_SETTINGS__ID = SETTINGS_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Database Settings</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATABASE_SETTINGS_FEATURE_COUNT = SETTINGS_FEATURE_COUNT + 1;

    /**
     * The operation id for the '<em>Get Driver Name</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATABASE_SETTINGS___GET_DRIVER_NAME = SETTINGS_OPERATION_COUNT + 0;

    /**
     * The operation id for the '<em>Get Properties</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATABASE_SETTINGS___GET_PROPERTIES = SETTINGS_OPERATION_COUNT + 1;

    /**
     * The operation id for the '<em>Get Url</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATABASE_SETTINGS___GET_URL = SETTINGS_OPERATION_COUNT + 2;

    /**
     * The operation id for the '<em>Get Login Timeout</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATABASE_SETTINGS___GET_LOGIN_TIMEOUT = SETTINGS_OPERATION_COUNT + 3;

    /**
     * The operation id for the '<em>Get Bundles</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATABASE_SETTINGS___GET_BUNDLES = SETTINGS_OPERATION_COUNT + 4;

    /**
     * The number of operations of the '<em>Database Settings</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATABASE_SETTINGS_OPERATION_COUNT = SETTINGS_OPERATION_COUNT + 5;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.world.impl.GenericSettingsContainerImpl <em>Generic Settings Container</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.world.impl.GenericSettingsContainerImpl
     * @see org.eclipse.scada.configuration.world.impl.WorldPackageImpl#getGenericSettingsContainer()
     * @generated
     */
    int GENERIC_SETTINGS_CONTAINER = 24;

    /**
     * The feature id for the '<em><b>Settings</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GENERIC_SETTINGS_CONTAINER__SETTINGS = 0;

    /**
     * The number of structural features of the '<em>Generic Settings Container</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GENERIC_SETTINGS_CONTAINER_FEATURE_COUNT = 1;

    /**
     * The number of operations of the '<em>Generic Settings Container</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GENERIC_SETTINGS_CONTAINER_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.world.impl.AbstractGenericDatabaseSettingsImpl <em>Abstract Generic Database Settings</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.world.impl.AbstractGenericDatabaseSettingsImpl
     * @see org.eclipse.scada.configuration.world.impl.WorldPackageImpl#getAbstractGenericDatabaseSettings()
     * @generated
     */
    int ABSTRACT_GENERIC_DATABASE_SETTINGS = 26;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_GENERIC_DATABASE_SETTINGS__ID = DATABASE_SETTINGS__ID;

    /**
     * The feature id for the '<em><b>Username</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_GENERIC_DATABASE_SETTINGS__USERNAME = DATABASE_SETTINGS_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Password</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_GENERIC_DATABASE_SETTINGS__PASSWORD = DATABASE_SETTINGS_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Login Timeout</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_GENERIC_DATABASE_SETTINGS__LOGIN_TIMEOUT = DATABASE_SETTINGS_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Additional Properties</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_GENERIC_DATABASE_SETTINGS__ADDITIONAL_PROPERTIES = DATABASE_SETTINGS_FEATURE_COUNT + 3;

    /**
     * The feature id for the '<em><b>Database Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_GENERIC_DATABASE_SETTINGS__DATABASE_NAME = DATABASE_SETTINGS_FEATURE_COUNT + 4;

    /**
     * The feature id for the '<em><b>Server Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_GENERIC_DATABASE_SETTINGS__SERVER_NAME = DATABASE_SETTINGS_FEATURE_COUNT + 5;

    /**
     * The feature id for the '<em><b>Port Number</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_GENERIC_DATABASE_SETTINGS__PORT_NUMBER = DATABASE_SETTINGS_FEATURE_COUNT + 6;

    /**
     * The number of structural features of the '<em>Abstract Generic Database Settings</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_GENERIC_DATABASE_SETTINGS_FEATURE_COUNT = DATABASE_SETTINGS_FEATURE_COUNT + 7;

    /**
     * The operation id for the '<em>Get Driver Name</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_GENERIC_DATABASE_SETTINGS___GET_DRIVER_NAME = DATABASE_SETTINGS___GET_DRIVER_NAME;

    /**
     * The operation id for the '<em>Get Properties</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_GENERIC_DATABASE_SETTINGS___GET_PROPERTIES = DATABASE_SETTINGS___GET_PROPERTIES;

    /**
     * The operation id for the '<em>Get Url</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_GENERIC_DATABASE_SETTINGS___GET_URL = DATABASE_SETTINGS___GET_URL;

    /**
     * The operation id for the '<em>Get Login Timeout</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_GENERIC_DATABASE_SETTINGS___GET_LOGIN_TIMEOUT = DATABASE_SETTINGS___GET_LOGIN_TIMEOUT;

    /**
     * The operation id for the '<em>Get Bundles</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_GENERIC_DATABASE_SETTINGS___GET_BUNDLES = DATABASE_SETTINGS___GET_BUNDLES;

    /**
     * The number of operations of the '<em>Abstract Generic Database Settings</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_GENERIC_DATABASE_SETTINGS_OPERATION_COUNT = DATABASE_SETTINGS_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.world.impl.GenericDatabaseSettingsImpl <em>Generic Database Settings</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.world.impl.GenericDatabaseSettingsImpl
     * @see org.eclipse.scada.configuration.world.impl.WorldPackageImpl#getGenericDatabaseSettings()
     * @generated
     */
    int GENERIC_DATABASE_SETTINGS = 25;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GENERIC_DATABASE_SETTINGS__ID = ABSTRACT_GENERIC_DATABASE_SETTINGS__ID;

    /**
     * The feature id for the '<em><b>Username</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GENERIC_DATABASE_SETTINGS__USERNAME = ABSTRACT_GENERIC_DATABASE_SETTINGS__USERNAME;

    /**
     * The feature id for the '<em><b>Password</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GENERIC_DATABASE_SETTINGS__PASSWORD = ABSTRACT_GENERIC_DATABASE_SETTINGS__PASSWORD;

    /**
     * The feature id for the '<em><b>Login Timeout</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GENERIC_DATABASE_SETTINGS__LOGIN_TIMEOUT = ABSTRACT_GENERIC_DATABASE_SETTINGS__LOGIN_TIMEOUT;

    /**
     * The feature id for the '<em><b>Additional Properties</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GENERIC_DATABASE_SETTINGS__ADDITIONAL_PROPERTIES = ABSTRACT_GENERIC_DATABASE_SETTINGS__ADDITIONAL_PROPERTIES;

    /**
     * The feature id for the '<em><b>Database Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GENERIC_DATABASE_SETTINGS__DATABASE_NAME = ABSTRACT_GENERIC_DATABASE_SETTINGS__DATABASE_NAME;

    /**
     * The feature id for the '<em><b>Server Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GENERIC_DATABASE_SETTINGS__SERVER_NAME = ABSTRACT_GENERIC_DATABASE_SETTINGS__SERVER_NAME;

    /**
     * The feature id for the '<em><b>Port Number</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GENERIC_DATABASE_SETTINGS__PORT_NUMBER = ABSTRACT_GENERIC_DATABASE_SETTINGS__PORT_NUMBER;

    /**
     * The feature id for the '<em><b>Url</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GENERIC_DATABASE_SETTINGS__URL = ABSTRACT_GENERIC_DATABASE_SETTINGS_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Driver Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GENERIC_DATABASE_SETTINGS__DRIVER_NAME = ABSTRACT_GENERIC_DATABASE_SETTINGS_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Bundles</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GENERIC_DATABASE_SETTINGS__BUNDLES = ABSTRACT_GENERIC_DATABASE_SETTINGS_FEATURE_COUNT + 2;

    /**
     * The number of structural features of the '<em>Generic Database Settings</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GENERIC_DATABASE_SETTINGS_FEATURE_COUNT = ABSTRACT_GENERIC_DATABASE_SETTINGS_FEATURE_COUNT + 3;

    /**
     * The operation id for the '<em>Get Driver Name</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GENERIC_DATABASE_SETTINGS___GET_DRIVER_NAME = ABSTRACT_GENERIC_DATABASE_SETTINGS___GET_DRIVER_NAME;

    /**
     * The operation id for the '<em>Get Properties</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GENERIC_DATABASE_SETTINGS___GET_PROPERTIES = ABSTRACT_GENERIC_DATABASE_SETTINGS___GET_PROPERTIES;

    /**
     * The operation id for the '<em>Get Url</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GENERIC_DATABASE_SETTINGS___GET_URL = ABSTRACT_GENERIC_DATABASE_SETTINGS___GET_URL;

    /**
     * The operation id for the '<em>Get Login Timeout</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GENERIC_DATABASE_SETTINGS___GET_LOGIN_TIMEOUT = ABSTRACT_GENERIC_DATABASE_SETTINGS___GET_LOGIN_TIMEOUT;

    /**
     * The operation id for the '<em>Get Bundles</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GENERIC_DATABASE_SETTINGS___GET_BUNDLES = ABSTRACT_GENERIC_DATABASE_SETTINGS___GET_BUNDLES;

    /**
     * The number of operations of the '<em>Generic Database Settings</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GENERIC_DATABASE_SETTINGS_OPERATION_COUNT = ABSTRACT_GENERIC_DATABASE_SETTINGS_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.world.impl.PostgresDatabaseSettingsImpl <em>Postgres Database Settings</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.world.impl.PostgresDatabaseSettingsImpl
     * @see org.eclipse.scada.configuration.world.impl.WorldPackageImpl#getPostgresDatabaseSettings()
     * @generated
     */
    int POSTGRES_DATABASE_SETTINGS = 27;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int POSTGRES_DATABASE_SETTINGS__ID = ABSTRACT_GENERIC_DATABASE_SETTINGS__ID;

    /**
     * The feature id for the '<em><b>Username</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int POSTGRES_DATABASE_SETTINGS__USERNAME = ABSTRACT_GENERIC_DATABASE_SETTINGS__USERNAME;

    /**
     * The feature id for the '<em><b>Password</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int POSTGRES_DATABASE_SETTINGS__PASSWORD = ABSTRACT_GENERIC_DATABASE_SETTINGS__PASSWORD;

    /**
     * The feature id for the '<em><b>Login Timeout</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int POSTGRES_DATABASE_SETTINGS__LOGIN_TIMEOUT = ABSTRACT_GENERIC_DATABASE_SETTINGS__LOGIN_TIMEOUT;

    /**
     * The feature id for the '<em><b>Additional Properties</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int POSTGRES_DATABASE_SETTINGS__ADDITIONAL_PROPERTIES = ABSTRACT_GENERIC_DATABASE_SETTINGS__ADDITIONAL_PROPERTIES;

    /**
     * The feature id for the '<em><b>Database Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int POSTGRES_DATABASE_SETTINGS__DATABASE_NAME = ABSTRACT_GENERIC_DATABASE_SETTINGS__DATABASE_NAME;

    /**
     * The feature id for the '<em><b>Server Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int POSTGRES_DATABASE_SETTINGS__SERVER_NAME = ABSTRACT_GENERIC_DATABASE_SETTINGS__SERVER_NAME;

    /**
     * The feature id for the '<em><b>Port Number</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int POSTGRES_DATABASE_SETTINGS__PORT_NUMBER = ABSTRACT_GENERIC_DATABASE_SETTINGS__PORT_NUMBER;

    /**
     * The number of structural features of the '<em>Postgres Database Settings</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int POSTGRES_DATABASE_SETTINGS_FEATURE_COUNT = ABSTRACT_GENERIC_DATABASE_SETTINGS_FEATURE_COUNT + 0;

    /**
     * The operation id for the '<em>Get Driver Name</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int POSTGRES_DATABASE_SETTINGS___GET_DRIVER_NAME = ABSTRACT_GENERIC_DATABASE_SETTINGS___GET_DRIVER_NAME;

    /**
     * The operation id for the '<em>Get Properties</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int POSTGRES_DATABASE_SETTINGS___GET_PROPERTIES = ABSTRACT_GENERIC_DATABASE_SETTINGS___GET_PROPERTIES;

    /**
     * The operation id for the '<em>Get Url</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int POSTGRES_DATABASE_SETTINGS___GET_URL = ABSTRACT_GENERIC_DATABASE_SETTINGS___GET_URL;

    /**
     * The operation id for the '<em>Get Login Timeout</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int POSTGRES_DATABASE_SETTINGS___GET_LOGIN_TIMEOUT = ABSTRACT_GENERIC_DATABASE_SETTINGS___GET_LOGIN_TIMEOUT;

    /**
     * The operation id for the '<em>Get Bundles</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int POSTGRES_DATABASE_SETTINGS___GET_BUNDLES = ABSTRACT_GENERIC_DATABASE_SETTINGS___GET_BUNDLES;

    /**
     * The number of operations of the '<em>Postgres Database Settings</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int POSTGRES_DATABASE_SETTINGS_OPERATION_COUNT = ABSTRACT_GENERIC_DATABASE_SETTINGS_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '<em>Pattern</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see java.util.regex.Pattern
     * @see org.eclipse.scada.configuration.world.impl.WorldPackageImpl#getPattern()
     * @generated
     */
    int PATTERN = 28;

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.world.World <em>World</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>World</em>'.
     * @see org.eclipse.scada.configuration.world.World
     * @generated
     */
    EClass getWorld ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.configuration.world.World#getNodes <em>Nodes</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Nodes</em>'.
     * @see org.eclipse.scada.configuration.world.World#getNodes()
     * @see #getWorld()
     * @generated
     */
    EReference getWorld_Nodes ();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.scada.configuration.world.World#getOptions <em>Options</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Options</em>'.
     * @see org.eclipse.scada.configuration.world.World#getOptions()
     * @see #getWorld()
     * @generated
     */
    EReference getWorld_Options ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.world.Node <em>Node</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Node</em>'.
     * @see org.eclipse.scada.configuration.world.Node
     * @generated
     */
    EClass getNode ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.Node#getHostName <em>Host Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Host Name</em>'.
     * @see org.eclipse.scada.configuration.world.Node#getHostName()
     * @see #getNode()
     * @generated
     */
    EAttribute getNode_HostName ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.configuration.world.Node#getEndpoints <em>Endpoints</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Endpoints</em>'.
     * @see org.eclipse.scada.configuration.world.Node#getEndpoints()
     * @see #getNode()
     * @generated
     */
    EReference getNode_Endpoints ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.configuration.world.Node#getDeployments <em>Deployments</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Deployments</em>'.
     * @see org.eclipse.scada.configuration.world.Node#getDeployments()
     * @see #getNode()
     * @generated
     */
    EReference getNode_Deployments ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.world.ApplicationNode <em>Application Node</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Application Node</em>'.
     * @see org.eclipse.scada.configuration.world.ApplicationNode
     * @generated
     */
    EClass getApplicationNode ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.configuration.world.ApplicationNode#getApplications <em>Applications</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Applications</em>'.
     * @see org.eclipse.scada.configuration.world.ApplicationNode#getApplications()
     * @see #getApplicationNode()
     * @generated
     */
    EReference getApplicationNode_Applications ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.configuration.world.ApplicationNode#getServices <em>Services</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Services</em>'.
     * @see org.eclipse.scada.configuration.world.ApplicationNode#getServices()
     * @see #getApplicationNode()
     * @generated
     */
    EReference getApplicationNode_Services ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.world.Documentable <em>Documentable</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Documentable</em>'.
     * @see org.eclipse.scada.configuration.world.Documentable
     * @generated
     */
    EClass getDocumentable ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.Documentable#getShortDescription <em>Short Description</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Short Description</em>'.
     * @see org.eclipse.scada.configuration.world.Documentable#getShortDescription()
     * @see #getDocumentable()
     * @generated
     */
    EAttribute getDocumentable_ShortDescription ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.world.Application <em>Application</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Application</em>'.
     * @see org.eclipse.scada.configuration.world.Application
     * @generated
     */
    EClass getApplication ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.world.Driver <em>Driver</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Driver</em>'.
     * @see org.eclipse.scada.configuration.world.Driver
     * @generated
     */
    EClass getDriver ();

    /**
     * Returns the meta object for the '{@link org.eclipse.scada.configuration.world.Driver#getEndpoints() <em>Get Endpoints</em>}' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the '<em>Get Endpoints</em>' operation.
     * @see org.eclipse.scada.configuration.world.Driver#getEndpoints()
     * @generated
     */
    EOperation getDriver__GetEndpoints ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.world.Endpoint <em>Endpoint</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Endpoint</em>'.
     * @see org.eclipse.scada.configuration.world.Endpoint
     * @generated
     */
    EClass getEndpoint ();

    /**
     * Returns the meta object for the container reference '{@link org.eclipse.scada.configuration.world.Endpoint#getNode <em>Node</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Node</em>'.
     * @see org.eclipse.scada.configuration.world.Endpoint#getNode()
     * @see #getEndpoint()
     * @generated
     */
    EReference getEndpoint_Node ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.Endpoint#getPortNumber <em>Port Number</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Port Number</em>'.
     * @see org.eclipse.scada.configuration.world.Endpoint#getPortNumber()
     * @see #getEndpoint()
     * @generated
     */
    EAttribute getEndpoint_PortNumber ();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.scada.configuration.world.Endpoint#getBoundService <em>Bound Service</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Bound Service</em>'.
     * @see org.eclipse.scada.configuration.world.Endpoint#getBoundService()
     * @see #getEndpoint()
     * @generated
     */
    EReference getEndpoint_BoundService ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.world.ExecDriver <em>Exec Driver</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Exec Driver</em>'.
     * @see org.eclipse.scada.configuration.world.ExecDriver
     * @generated
     */
    EClass getExecDriver ();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.scada.configuration.world.ExecDriver#getRoot <em>Root</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Root</em>'.
     * @see org.eclipse.scada.configuration.world.ExecDriver#getRoot()
     * @see #getExecDriver()
     * @generated
     */
    EReference getExecDriver_Root ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.world.CommonDriver <em>Common Driver</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Common Driver</em>'.
     * @see org.eclipse.scada.configuration.world.CommonDriver
     * @generated
     */
    EClass getCommonDriver ();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.scada.configuration.world.CommonDriver#getPassword <em>Password</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Password</em>'.
     * @see org.eclipse.scada.configuration.world.CommonDriver#getPassword()
     * @see #getCommonDriver()
     * @generated
     */
    EReference getCommonDriver_Password ();

    /**
     * Returns the meta object for the reference list '{@link org.eclipse.scada.configuration.world.CommonDriver#getEndpoints <em>Endpoints</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Endpoints</em>'.
     * @see org.eclipse.scada.configuration.world.CommonDriver#getEndpoints()
     * @see #getCommonDriver()
     * @generated
     */
    EReference getCommonDriver_Endpoints ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.world.HandlerPriorityRule <em>Handler Priority Rule</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Handler Priority Rule</em>'.
     * @see org.eclipse.scada.configuration.world.HandlerPriorityRule
     * @generated
     */
    EClass getHandlerPriorityRule ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.HandlerPriorityRule#getOrder <em>Order</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Order</em>'.
     * @see org.eclipse.scada.configuration.world.HandlerPriorityRule#getOrder()
     * @see #getHandlerPriorityRule()
     * @generated
     */
    EAttribute getHandlerPriorityRule_Order ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.HandlerPriorityRule#getFactoryId <em>Factory Id</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Factory Id</em>'.
     * @see org.eclipse.scada.configuration.world.HandlerPriorityRule#getFactoryId()
     * @see #getHandlerPriorityRule()
     * @generated
     */
    EAttribute getHandlerPriorityRule_FactoryId ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.HandlerPriorityRule#getConfigurationFilter <em>Configuration Filter</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Configuration Filter</em>'.
     * @see org.eclipse.scada.configuration.world.HandlerPriorityRule#getConfigurationFilter()
     * @see #getHandlerPriorityRule()
     * @generated
     */
    EAttribute getHandlerPriorityRule_ConfigurationFilter ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.HandlerPriorityRule#getPriority <em>Priority</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Priority</em>'.
     * @see org.eclipse.scada.configuration.world.HandlerPriorityRule#getPriority()
     * @see #getHandlerPriorityRule()
     * @generated
     */
    EAttribute getHandlerPriorityRule_Priority ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.HandlerPriorityRule#getDescription <em>Description</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Description</em>'.
     * @see org.eclipse.scada.configuration.world.HandlerPriorityRule#getDescription()
     * @see #getHandlerPriorityRule()
     * @generated
     */
    EAttribute getHandlerPriorityRule_Description ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.world.MasterHandlerPriorities <em>Master Handler Priorities</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Master Handler Priorities</em>'.
     * @see org.eclipse.scada.configuration.world.MasterHandlerPriorities
     * @generated
     */
    EClass getMasterHandlerPriorities ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.configuration.world.MasterHandlerPriorities#getRules <em>Rules</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Rules</em>'.
     * @see org.eclipse.scada.configuration.world.MasterHandlerPriorities#getRules()
     * @see #getMasterHandlerPriorities()
     * @generated
     */
    EReference getMasterHandlerPriorities_Rules ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.world.Options <em>Options</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Options</em>'.
     * @see org.eclipse.scada.configuration.world.Options
     * @generated
     */
    EClass getOptions ();

    /**
     * Returns the meta object for the reference '{@link org.eclipse.scada.configuration.world.Options#getMasterHandlerPriorities <em>Master Handler Priorities</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Master Handler Priorities</em>'.
     * @see org.eclipse.scada.configuration.world.Options#getMasterHandlerPriorities()
     * @see #getOptions()
     * @generated
     */
    EReference getOptions_MasterHandlerPriorities ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.world.UsernamePasswordCredentials <em>Username Password Credentials</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Username Password Credentials</em>'.
     * @see org.eclipse.scada.configuration.world.UsernamePasswordCredentials
     * @generated
     */
    EClass getUsernamePasswordCredentials ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.UsernamePasswordCredentials#getUsername <em>Username</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Username</em>'.
     * @see org.eclipse.scada.configuration.world.UsernamePasswordCredentials#getUsername()
     * @see #getUsernamePasswordCredentials()
     * @generated
     */
    EAttribute getUsernamePasswordCredentials_Username ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.UsernamePasswordCredentials#getPassword <em>Password</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Password</em>'.
     * @see org.eclipse.scada.configuration.world.UsernamePasswordCredentials#getPassword()
     * @see #getUsernamePasswordCredentials()
     * @generated
     */
    EAttribute getUsernamePasswordCredentials_Password ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.world.PasswordCredentials <em>Password Credentials</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Password Credentials</em>'.
     * @see org.eclipse.scada.configuration.world.PasswordCredentials
     * @generated
     */
    EClass getPasswordCredentials ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.PasswordCredentials#getPassword <em>Password</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Password</em>'.
     * @see org.eclipse.scada.configuration.world.PasswordCredentials#getPassword()
     * @see #getPasswordCredentials()
     * @generated
     */
    EAttribute getPasswordCredentials_Password ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.world.Credentials <em>Credentials</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Credentials</em>'.
     * @see org.eclipse.scada.configuration.world.Credentials
     * @generated
     */
    EClass getCredentials ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.world.ExternalNode <em>External Node</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>External Node</em>'.
     * @see org.eclipse.scada.configuration.world.ExternalNode
     * @generated
     */
    EClass getExternalNode ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.world.Service <em>Service</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Service</em>'.
     * @see org.eclipse.scada.configuration.world.Service
     * @generated
     */
    EClass getService ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.world.NamedDocumentable <em>Named Documentable</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Named Documentable</em>'.
     * @see org.eclipse.scada.configuration.world.NamedDocumentable
     * @generated
     */
    EClass getNamedDocumentable ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.NamedDocumentable#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see org.eclipse.scada.configuration.world.NamedDocumentable#getName()
     * @see #getNamedDocumentable()
     * @generated
     */
    EAttribute getNamedDocumentable_Name ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.world.PropertyEntry <em>Property Entry</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Property Entry</em>'.
     * @see org.eclipse.scada.configuration.world.PropertyEntry
     * @generated
     */
    EClass getPropertyEntry ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.PropertyEntry#getKey <em>Key</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Key</em>'.
     * @see org.eclipse.scada.configuration.world.PropertyEntry#getKey()
     * @see #getPropertyEntry()
     * @generated
     */
    EAttribute getPropertyEntry_Key ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.PropertyEntry#getValue <em>Value</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Value</em>'.
     * @see org.eclipse.scada.configuration.world.PropertyEntry#getValue()
     * @see #getPropertyEntry()
     * @generated
     */
    EAttribute getPropertyEntry_Value ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.world.ServiceBinding <em>Service Binding</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Service Binding</em>'.
     * @see org.eclipse.scada.configuration.world.ServiceBinding
     * @generated
     */
    EClass getServiceBinding ();

    /**
     * Returns the meta object for the '{@link org.eclipse.scada.configuration.world.ServiceBinding#getService() <em>Get Service</em>}' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the '<em>Get Service</em>' operation.
     * @see org.eclipse.scada.configuration.world.ServiceBinding#getService()
     * @generated
     */
    EOperation getServiceBinding__GetService ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.world.ContainedServiceBinding <em>Contained Service Binding</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Contained Service Binding</em>'.
     * @see org.eclipse.scada.configuration.world.ContainedServiceBinding
     * @generated
     */
    EClass getContainedServiceBinding ();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.scada.configuration.world.ContainedServiceBinding#getService <em>Service</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Service</em>'.
     * @see org.eclipse.scada.configuration.world.ContainedServiceBinding#getService()
     * @see #getContainedServiceBinding()
     * @generated
     */
    EReference getContainedServiceBinding_Service ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.world.ReferencedServiceBinding <em>Referenced Service Binding</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Referenced Service Binding</em>'.
     * @see org.eclipse.scada.configuration.world.ReferencedServiceBinding
     * @generated
     */
    EClass getReferencedServiceBinding ();

    /**
     * Returns the meta object for the reference '{@link org.eclipse.scada.configuration.world.ReferencedServiceBinding#getService <em>Service</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Service</em>'.
     * @see org.eclipse.scada.configuration.world.ReferencedServiceBinding#getService()
     * @see #getReferencedServiceBinding()
     * @generated
     */
    EReference getReferencedServiceBinding_Service ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.world.Settings <em>Settings</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Settings</em>'.
     * @see org.eclipse.scada.configuration.world.Settings
     * @generated
     */
    EClass getSettings ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.world.DatabaseSettings <em>Database Settings</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Database Settings</em>'.
     * @see org.eclipse.scada.configuration.world.DatabaseSettings
     * @generated
     */
    EClass getDatabaseSettings ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.DatabaseSettings#getId <em>Id</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Id</em>'.
     * @see org.eclipse.scada.configuration.world.DatabaseSettings#getId()
     * @see #getDatabaseSettings()
     * @generated
     */
    EAttribute getDatabaseSettings_Id ();

    /**
     * Returns the meta object for the '{@link org.eclipse.scada.configuration.world.DatabaseSettings#getDriverName() <em>Get Driver Name</em>}' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the '<em>Get Driver Name</em>' operation.
     * @see org.eclipse.scada.configuration.world.DatabaseSettings#getDriverName()
     * @generated
     */
    EOperation getDatabaseSettings__GetDriverName ();

    /**
     * Returns the meta object for the '{@link org.eclipse.scada.configuration.world.DatabaseSettings#getProperties() <em>Get Properties</em>}' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the '<em>Get Properties</em>' operation.
     * @see org.eclipse.scada.configuration.world.DatabaseSettings#getProperties()
     * @generated
     */
    EOperation getDatabaseSettings__GetProperties ();

    /**
     * Returns the meta object for the '{@link org.eclipse.scada.configuration.world.DatabaseSettings#getUrl() <em>Get Url</em>}' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the '<em>Get Url</em>' operation.
     * @see org.eclipse.scada.configuration.world.DatabaseSettings#getUrl()
     * @generated
     */
    EOperation getDatabaseSettings__GetUrl ();

    /**
     * Returns the meta object for the '{@link org.eclipse.scada.configuration.world.DatabaseSettings#getLoginTimeout() <em>Get Login Timeout</em>}' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the '<em>Get Login Timeout</em>' operation.
     * @see org.eclipse.scada.configuration.world.DatabaseSettings#getLoginTimeout()
     * @generated
     */
    EOperation getDatabaseSettings__GetLoginTimeout ();

    /**
     * Returns the meta object for the '{@link org.eclipse.scada.configuration.world.DatabaseSettings#getBundles() <em>Get Bundles</em>}' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the '<em>Get Bundles</em>' operation.
     * @see org.eclipse.scada.configuration.world.DatabaseSettings#getBundles()
     * @generated
     */
    EOperation getDatabaseSettings__GetBundles ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.world.GenericSettingsContainer <em>Generic Settings Container</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Generic Settings Container</em>'.
     * @see org.eclipse.scada.configuration.world.GenericSettingsContainer
     * @generated
     */
    EClass getGenericSettingsContainer ();

    /**
     * Returns the meta object for the reference '{@link org.eclipse.scada.configuration.world.GenericSettingsContainer#getSettings <em>Settings</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Settings</em>'.
     * @see org.eclipse.scada.configuration.world.GenericSettingsContainer#getSettings()
     * @see #getGenericSettingsContainer()
     * @generated
     */
    EReference getGenericSettingsContainer_Settings ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.world.GenericDatabaseSettings <em>Generic Database Settings</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Generic Database Settings</em>'.
     * @see org.eclipse.scada.configuration.world.GenericDatabaseSettings
     * @generated
     */
    EClass getGenericDatabaseSettings ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.GenericDatabaseSettings#getUrl <em>Url</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Url</em>'.
     * @see org.eclipse.scada.configuration.world.GenericDatabaseSettings#getUrl()
     * @see #getGenericDatabaseSettings()
     * @generated
     */
    EAttribute getGenericDatabaseSettings_Url ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.GenericDatabaseSettings#getDriverName <em>Driver Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Driver Name</em>'.
     * @see org.eclipse.scada.configuration.world.GenericDatabaseSettings#getDriverName()
     * @see #getGenericDatabaseSettings()
     * @generated
     */
    EAttribute getGenericDatabaseSettings_DriverName ();

    /**
     * Returns the meta object for the attribute list '{@link org.eclipse.scada.configuration.world.GenericDatabaseSettings#getBundles <em>Bundles</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute list '<em>Bundles</em>'.
     * @see org.eclipse.scada.configuration.world.GenericDatabaseSettings#getBundles()
     * @see #getGenericDatabaseSettings()
     * @generated
     */
    EAttribute getGenericDatabaseSettings_Bundles ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.world.AbstractGenericDatabaseSettings <em>Abstract Generic Database Settings</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Abstract Generic Database Settings</em>'.
     * @see org.eclipse.scada.configuration.world.AbstractGenericDatabaseSettings
     * @generated
     */
    EClass getAbstractGenericDatabaseSettings ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.AbstractGenericDatabaseSettings#getUsername <em>Username</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Username</em>'.
     * @see org.eclipse.scada.configuration.world.AbstractGenericDatabaseSettings#getUsername()
     * @see #getAbstractGenericDatabaseSettings()
     * @generated
     */
    EAttribute getAbstractGenericDatabaseSettings_Username ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.AbstractGenericDatabaseSettings#getPassword <em>Password</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Password</em>'.
     * @see org.eclipse.scada.configuration.world.AbstractGenericDatabaseSettings#getPassword()
     * @see #getAbstractGenericDatabaseSettings()
     * @generated
     */
    EAttribute getAbstractGenericDatabaseSettings_Password ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.AbstractGenericDatabaseSettings#getLoginTimeout <em>Login Timeout</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Login Timeout</em>'.
     * @see org.eclipse.scada.configuration.world.AbstractGenericDatabaseSettings#getLoginTimeout()
     * @see #getAbstractGenericDatabaseSettings()
     * @generated
     */
    EAttribute getAbstractGenericDatabaseSettings_LoginTimeout ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.configuration.world.AbstractGenericDatabaseSettings#getAdditionalProperties <em>Additional Properties</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Additional Properties</em>'.
     * @see org.eclipse.scada.configuration.world.AbstractGenericDatabaseSettings#getAdditionalProperties()
     * @see #getAbstractGenericDatabaseSettings()
     * @generated
     */
    EReference getAbstractGenericDatabaseSettings_AdditionalProperties ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.AbstractGenericDatabaseSettings#getDatabaseName <em>Database Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Database Name</em>'.
     * @see org.eclipse.scada.configuration.world.AbstractGenericDatabaseSettings#getDatabaseName()
     * @see #getAbstractGenericDatabaseSettings()
     * @generated
     */
    EAttribute getAbstractGenericDatabaseSettings_DatabaseName ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.AbstractGenericDatabaseSettings#getServerName <em>Server Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Server Name</em>'.
     * @see org.eclipse.scada.configuration.world.AbstractGenericDatabaseSettings#getServerName()
     * @see #getAbstractGenericDatabaseSettings()
     * @generated
     */
    EAttribute getAbstractGenericDatabaseSettings_ServerName ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.AbstractGenericDatabaseSettings#getPortNumber <em>Port Number</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Port Number</em>'.
     * @see org.eclipse.scada.configuration.world.AbstractGenericDatabaseSettings#getPortNumber()
     * @see #getAbstractGenericDatabaseSettings()
     * @generated
     */
    EAttribute getAbstractGenericDatabaseSettings_PortNumber ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.world.PostgresDatabaseSettings <em>Postgres Database Settings</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Postgres Database Settings</em>'.
     * @see org.eclipse.scada.configuration.world.PostgresDatabaseSettings
     * @generated
     */
    EClass getPostgresDatabaseSettings ();

    /**
     * Returns the meta object for data type '{@link java.util.regex.Pattern <em>Pattern</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for data type '<em>Pattern</em>'.
     * @see java.util.regex.Pattern
     * @model instanceClass="java.util.regex.Pattern"
     * @generated
     */
    EDataType getPattern ();

    /**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
    WorldFactory getWorldFactory ();

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
         * The meta object literal for the '{@link org.eclipse.scada.configuration.world.impl.WorldImpl <em>World</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.world.impl.WorldImpl
         * @see org.eclipse.scada.configuration.world.impl.WorldPackageImpl#getWorld()
         * @generated
         */
        EClass WORLD = eINSTANCE.getWorld ();

        /**
         * The meta object literal for the '<em><b>Nodes</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference WORLD__NODES = eINSTANCE.getWorld_Nodes ();

        /**
         * The meta object literal for the '<em><b>Options</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference WORLD__OPTIONS = eINSTANCE.getWorld_Options ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.world.impl.NodeImpl <em>Node</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.world.impl.NodeImpl
         * @see org.eclipse.scada.configuration.world.impl.WorldPackageImpl#getNode()
         * @generated
         */
        EClass NODE = eINSTANCE.getNode ();

        /**
         * The meta object literal for the '<em><b>Host Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute NODE__HOST_NAME = eINSTANCE.getNode_HostName ();

        /**
         * The meta object literal for the '<em><b>Endpoints</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference NODE__ENDPOINTS = eINSTANCE.getNode_Endpoints ();

        /**
         * The meta object literal for the '<em><b>Deployments</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference NODE__DEPLOYMENTS = eINSTANCE.getNode_Deployments ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.world.impl.ApplicationNodeImpl <em>Application Node</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.world.impl.ApplicationNodeImpl
         * @see org.eclipse.scada.configuration.world.impl.WorldPackageImpl#getApplicationNode()
         * @generated
         */
        EClass APPLICATION_NODE = eINSTANCE.getApplicationNode ();

        /**
         * The meta object literal for the '<em><b>Applications</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference APPLICATION_NODE__APPLICATIONS = eINSTANCE.getApplicationNode_Applications ();

        /**
         * The meta object literal for the '<em><b>Services</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference APPLICATION_NODE__SERVICES = eINSTANCE.getApplicationNode_Services ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.world.Documentable <em>Documentable</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.world.Documentable
         * @see org.eclipse.scada.configuration.world.impl.WorldPackageImpl#getDocumentable()
         * @generated
         */
        EClass DOCUMENTABLE = eINSTANCE.getDocumentable ();

        /**
         * The meta object literal for the '<em><b>Short Description</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute DOCUMENTABLE__SHORT_DESCRIPTION = eINSTANCE.getDocumentable_ShortDescription ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.world.Application <em>Application</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.world.Application
         * @see org.eclipse.scada.configuration.world.impl.WorldPackageImpl#getApplication()
         * @generated
         */
        EClass APPLICATION = eINSTANCE.getApplication ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.world.Driver <em>Driver</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.world.Driver
         * @see org.eclipse.scada.configuration.world.impl.WorldPackageImpl#getDriver()
         * @generated
         */
        EClass DRIVER = eINSTANCE.getDriver ();

        /**
         * The meta object literal for the '<em><b>Get Endpoints</b></em>' operation.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EOperation DRIVER___GET_ENDPOINTS = eINSTANCE.getDriver__GetEndpoints ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.world.impl.EndpointImpl <em>Endpoint</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.world.impl.EndpointImpl
         * @see org.eclipse.scada.configuration.world.impl.WorldPackageImpl#getEndpoint()
         * @generated
         */
        EClass ENDPOINT = eINSTANCE.getEndpoint ();

        /**
         * The meta object literal for the '<em><b>Node</b></em>' container reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference ENDPOINT__NODE = eINSTANCE.getEndpoint_Node ();

        /**
         * The meta object literal for the '<em><b>Port Number</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute ENDPOINT__PORT_NUMBER = eINSTANCE.getEndpoint_PortNumber ();

        /**
         * The meta object literal for the '<em><b>Bound Service</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference ENDPOINT__BOUND_SERVICE = eINSTANCE.getEndpoint_BoundService ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.world.impl.ExecDriverImpl <em>Exec Driver</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.world.impl.ExecDriverImpl
         * @see org.eclipse.scada.configuration.world.impl.WorldPackageImpl#getExecDriver()
         * @generated
         */
        EClass EXEC_DRIVER = eINSTANCE.getExecDriver ();

        /**
         * The meta object literal for the '<em><b>Root</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference EXEC_DRIVER__ROOT = eINSTANCE.getExecDriver_Root ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.world.impl.CommonDriverImpl <em>Common Driver</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.world.impl.CommonDriverImpl
         * @see org.eclipse.scada.configuration.world.impl.WorldPackageImpl#getCommonDriver()
         * @generated
         */
        EClass COMMON_DRIVER = eINSTANCE.getCommonDriver ();

        /**
         * The meta object literal for the '<em><b>Password</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference COMMON_DRIVER__PASSWORD = eINSTANCE.getCommonDriver_Password ();

        /**
         * The meta object literal for the '<em><b>Endpoints</b></em>' reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference COMMON_DRIVER__ENDPOINTS = eINSTANCE.getCommonDriver_Endpoints ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.world.impl.HandlerPriorityRuleImpl <em>Handler Priority Rule</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.world.impl.HandlerPriorityRuleImpl
         * @see org.eclipse.scada.configuration.world.impl.WorldPackageImpl#getHandlerPriorityRule()
         * @generated
         */
        EClass HANDLER_PRIORITY_RULE = eINSTANCE.getHandlerPriorityRule ();

        /**
         * The meta object literal for the '<em><b>Order</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute HANDLER_PRIORITY_RULE__ORDER = eINSTANCE.getHandlerPriorityRule_Order ();

        /**
         * The meta object literal for the '<em><b>Factory Id</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute HANDLER_PRIORITY_RULE__FACTORY_ID = eINSTANCE.getHandlerPriorityRule_FactoryId ();

        /**
         * The meta object literal for the '<em><b>Configuration Filter</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute HANDLER_PRIORITY_RULE__CONFIGURATION_FILTER = eINSTANCE.getHandlerPriorityRule_ConfigurationFilter ();

        /**
         * The meta object literal for the '<em><b>Priority</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute HANDLER_PRIORITY_RULE__PRIORITY = eINSTANCE.getHandlerPriorityRule_Priority ();

        /**
         * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute HANDLER_PRIORITY_RULE__DESCRIPTION = eINSTANCE.getHandlerPriorityRule_Description ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.world.impl.MasterHandlerPrioritiesImpl <em>Master Handler Priorities</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.world.impl.MasterHandlerPrioritiesImpl
         * @see org.eclipse.scada.configuration.world.impl.WorldPackageImpl#getMasterHandlerPriorities()
         * @generated
         */
        EClass MASTER_HANDLER_PRIORITIES = eINSTANCE.getMasterHandlerPriorities ();

        /**
         * The meta object literal for the '<em><b>Rules</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference MASTER_HANDLER_PRIORITIES__RULES = eINSTANCE.getMasterHandlerPriorities_Rules ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.world.impl.OptionsImpl <em>Options</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.world.impl.OptionsImpl
         * @see org.eclipse.scada.configuration.world.impl.WorldPackageImpl#getOptions()
         * @generated
         */
        EClass OPTIONS = eINSTANCE.getOptions ();

        /**
         * The meta object literal for the '<em><b>Master Handler Priorities</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference OPTIONS__MASTER_HANDLER_PRIORITIES = eINSTANCE.getOptions_MasterHandlerPriorities ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.world.impl.UsernamePasswordCredentialsImpl <em>Username Password Credentials</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.world.impl.UsernamePasswordCredentialsImpl
         * @see org.eclipse.scada.configuration.world.impl.WorldPackageImpl#getUsernamePasswordCredentials()
         * @generated
         */
        EClass USERNAME_PASSWORD_CREDENTIALS = eINSTANCE.getUsernamePasswordCredentials ();

        /**
         * The meta object literal for the '<em><b>Username</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute USERNAME_PASSWORD_CREDENTIALS__USERNAME = eINSTANCE.getUsernamePasswordCredentials_Username ();

        /**
         * The meta object literal for the '<em><b>Password</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute USERNAME_PASSWORD_CREDENTIALS__PASSWORD = eINSTANCE.getUsernamePasswordCredentials_Password ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.world.impl.PasswordCredentialsImpl <em>Password Credentials</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.world.impl.PasswordCredentialsImpl
         * @see org.eclipse.scada.configuration.world.impl.WorldPackageImpl#getPasswordCredentials()
         * @generated
         */
        EClass PASSWORD_CREDENTIALS = eINSTANCE.getPasswordCredentials ();

        /**
         * The meta object literal for the '<em><b>Password</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute PASSWORD_CREDENTIALS__PASSWORD = eINSTANCE.getPasswordCredentials_Password ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.world.Credentials <em>Credentials</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.world.Credentials
         * @see org.eclipse.scada.configuration.world.impl.WorldPackageImpl#getCredentials()
         * @generated
         */
        EClass CREDENTIALS = eINSTANCE.getCredentials ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.world.impl.ExternalNodeImpl <em>External Node</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.world.impl.ExternalNodeImpl
         * @see org.eclipse.scada.configuration.world.impl.WorldPackageImpl#getExternalNode()
         * @generated
         */
        EClass EXTERNAL_NODE = eINSTANCE.getExternalNode ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.world.Service <em>Service</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.world.Service
         * @see org.eclipse.scada.configuration.world.impl.WorldPackageImpl#getService()
         * @generated
         */
        EClass SERVICE = eINSTANCE.getService ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.world.NamedDocumentable <em>Named Documentable</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.world.NamedDocumentable
         * @see org.eclipse.scada.configuration.world.impl.WorldPackageImpl#getNamedDocumentable()
         * @generated
         */
        EClass NAMED_DOCUMENTABLE = eINSTANCE.getNamedDocumentable ();

        /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute NAMED_DOCUMENTABLE__NAME = eINSTANCE.getNamedDocumentable_Name ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.world.impl.PropertyEntryImpl <em>Property Entry</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.world.impl.PropertyEntryImpl
         * @see org.eclipse.scada.configuration.world.impl.WorldPackageImpl#getPropertyEntry()
         * @generated
         */
        EClass PROPERTY_ENTRY = eINSTANCE.getPropertyEntry ();

        /**
         * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute PROPERTY_ENTRY__KEY = eINSTANCE.getPropertyEntry_Key ();

        /**
         * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute PROPERTY_ENTRY__VALUE = eINSTANCE.getPropertyEntry_Value ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.world.ServiceBinding <em>Service Binding</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.world.ServiceBinding
         * @see org.eclipse.scada.configuration.world.impl.WorldPackageImpl#getServiceBinding()
         * @generated
         */
        EClass SERVICE_BINDING = eINSTANCE.getServiceBinding ();

        /**
         * The meta object literal for the '<em><b>Get Service</b></em>' operation.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EOperation SERVICE_BINDING___GET_SERVICE = eINSTANCE.getServiceBinding__GetService ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.world.impl.ContainedServiceBindingImpl <em>Contained Service Binding</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.world.impl.ContainedServiceBindingImpl
         * @see org.eclipse.scada.configuration.world.impl.WorldPackageImpl#getContainedServiceBinding()
         * @generated
         */
        EClass CONTAINED_SERVICE_BINDING = eINSTANCE.getContainedServiceBinding ();

        /**
         * The meta object literal for the '<em><b>Service</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference CONTAINED_SERVICE_BINDING__SERVICE = eINSTANCE.getContainedServiceBinding_Service ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.world.impl.ReferencedServiceBindingImpl <em>Referenced Service Binding</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.world.impl.ReferencedServiceBindingImpl
         * @see org.eclipse.scada.configuration.world.impl.WorldPackageImpl#getReferencedServiceBinding()
         * @generated
         */
        EClass REFERENCED_SERVICE_BINDING = eINSTANCE.getReferencedServiceBinding ();

        /**
         * The meta object literal for the '<em><b>Service</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference REFERENCED_SERVICE_BINDING__SERVICE = eINSTANCE.getReferencedServiceBinding_Service ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.world.Settings <em>Settings</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.world.Settings
         * @see org.eclipse.scada.configuration.world.impl.WorldPackageImpl#getSettings()
         * @generated
         */
        EClass SETTINGS = eINSTANCE.getSettings ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.world.DatabaseSettings <em>Database Settings</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.world.DatabaseSettings
         * @see org.eclipse.scada.configuration.world.impl.WorldPackageImpl#getDatabaseSettings()
         * @generated
         */
        EClass DATABASE_SETTINGS = eINSTANCE.getDatabaseSettings ();

        /**
         * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute DATABASE_SETTINGS__ID = eINSTANCE.getDatabaseSettings_Id ();

        /**
         * The meta object literal for the '<em><b>Get Driver Name</b></em>' operation.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EOperation DATABASE_SETTINGS___GET_DRIVER_NAME = eINSTANCE.getDatabaseSettings__GetDriverName ();

        /**
         * The meta object literal for the '<em><b>Get Properties</b></em>' operation.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EOperation DATABASE_SETTINGS___GET_PROPERTIES = eINSTANCE.getDatabaseSettings__GetProperties ();

        /**
         * The meta object literal for the '<em><b>Get Url</b></em>' operation.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EOperation DATABASE_SETTINGS___GET_URL = eINSTANCE.getDatabaseSettings__GetUrl ();

        /**
         * The meta object literal for the '<em><b>Get Login Timeout</b></em>' operation.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EOperation DATABASE_SETTINGS___GET_LOGIN_TIMEOUT = eINSTANCE.getDatabaseSettings__GetLoginTimeout ();

        /**
         * The meta object literal for the '<em><b>Get Bundles</b></em>' operation.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EOperation DATABASE_SETTINGS___GET_BUNDLES = eINSTANCE.getDatabaseSettings__GetBundles ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.world.impl.GenericSettingsContainerImpl <em>Generic Settings Container</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.world.impl.GenericSettingsContainerImpl
         * @see org.eclipse.scada.configuration.world.impl.WorldPackageImpl#getGenericSettingsContainer()
         * @generated
         */
        EClass GENERIC_SETTINGS_CONTAINER = eINSTANCE.getGenericSettingsContainer ();

        /**
         * The meta object literal for the '<em><b>Settings</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference GENERIC_SETTINGS_CONTAINER__SETTINGS = eINSTANCE.getGenericSettingsContainer_Settings ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.world.impl.GenericDatabaseSettingsImpl <em>Generic Database Settings</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.world.impl.GenericDatabaseSettingsImpl
         * @see org.eclipse.scada.configuration.world.impl.WorldPackageImpl#getGenericDatabaseSettings()
         * @generated
         */
        EClass GENERIC_DATABASE_SETTINGS = eINSTANCE.getGenericDatabaseSettings ();

        /**
         * The meta object literal for the '<em><b>Url</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute GENERIC_DATABASE_SETTINGS__URL = eINSTANCE.getGenericDatabaseSettings_Url ();

        /**
         * The meta object literal for the '<em><b>Driver Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute GENERIC_DATABASE_SETTINGS__DRIVER_NAME = eINSTANCE.getGenericDatabaseSettings_DriverName ();

        /**
         * The meta object literal for the '<em><b>Bundles</b></em>' attribute list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute GENERIC_DATABASE_SETTINGS__BUNDLES = eINSTANCE.getGenericDatabaseSettings_Bundles ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.world.impl.AbstractGenericDatabaseSettingsImpl <em>Abstract Generic Database Settings</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.world.impl.AbstractGenericDatabaseSettingsImpl
         * @see org.eclipse.scada.configuration.world.impl.WorldPackageImpl#getAbstractGenericDatabaseSettings()
         * @generated
         */
        EClass ABSTRACT_GENERIC_DATABASE_SETTINGS = eINSTANCE.getAbstractGenericDatabaseSettings ();

        /**
         * The meta object literal for the '<em><b>Username</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute ABSTRACT_GENERIC_DATABASE_SETTINGS__USERNAME = eINSTANCE.getAbstractGenericDatabaseSettings_Username ();

        /**
         * The meta object literal for the '<em><b>Password</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute ABSTRACT_GENERIC_DATABASE_SETTINGS__PASSWORD = eINSTANCE.getAbstractGenericDatabaseSettings_Password ();

        /**
         * The meta object literal for the '<em><b>Login Timeout</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute ABSTRACT_GENERIC_DATABASE_SETTINGS__LOGIN_TIMEOUT = eINSTANCE.getAbstractGenericDatabaseSettings_LoginTimeout ();

        /**
         * The meta object literal for the '<em><b>Additional Properties</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference ABSTRACT_GENERIC_DATABASE_SETTINGS__ADDITIONAL_PROPERTIES = eINSTANCE.getAbstractGenericDatabaseSettings_AdditionalProperties ();

        /**
         * The meta object literal for the '<em><b>Database Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute ABSTRACT_GENERIC_DATABASE_SETTINGS__DATABASE_NAME = eINSTANCE.getAbstractGenericDatabaseSettings_DatabaseName ();

        /**
         * The meta object literal for the '<em><b>Server Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute ABSTRACT_GENERIC_DATABASE_SETTINGS__SERVER_NAME = eINSTANCE.getAbstractGenericDatabaseSettings_ServerName ();

        /**
         * The meta object literal for the '<em><b>Port Number</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute ABSTRACT_GENERIC_DATABASE_SETTINGS__PORT_NUMBER = eINSTANCE.getAbstractGenericDatabaseSettings_PortNumber ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.world.impl.PostgresDatabaseSettingsImpl <em>Postgres Database Settings</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.world.impl.PostgresDatabaseSettingsImpl
         * @see org.eclipse.scada.configuration.world.impl.WorldPackageImpl#getPostgresDatabaseSettings()
         * @generated
         */
        EClass POSTGRES_DATABASE_SETTINGS = eINSTANCE.getPostgresDatabaseSettings ();

        /**
         * The meta object literal for the '<em>Pattern</em>' data type.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see java.util.regex.Pattern
         * @see org.eclipse.scada.configuration.world.impl.WorldPackageImpl#getPattern()
         * @generated
         */
        EDataType PATTERN = eINSTANCE.getPattern ();

    }

} //ConfigurationPackage
