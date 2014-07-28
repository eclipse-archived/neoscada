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
package org.eclipse.scada.configuration.infrastructure;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.scada.configuration.world.WorldPackage;

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
 * @see org.eclipse.scada.configuration.infrastructure.InfrastructureFactory
 * @model kind="package"
 * @generated
 */
public interface InfrastructurePackage extends EPackage
{
    /**
     * The package name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNAME = "infrastructure"; //$NON-NLS-1$

    /**
     * The package namespace URI.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_URI = "http://eclipse.org/SCADA/Configuration/Infrastructure"; //$NON-NLS-1$

    /**
     * The package namespace name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_PREFIX = "infrastructure"; //$NON-NLS-1$

    /**
     * The package content type ID.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eCONTENT_TYPE = "org.eclipse.scada.configuration.infrastructure"; //$NON-NLS-1$

    /**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    InfrastructurePackage eINSTANCE = org.eclipse.scada.configuration.infrastructure.impl.InfrastructurePackageImpl.init ();

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.infrastructure.impl.WorldImpl <em>World</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.infrastructure.impl.WorldImpl
     * @see org.eclipse.scada.configuration.infrastructure.impl.InfrastructurePackageImpl#getWorld()
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
     * The feature id for the '<em><b>Default Security Configuration</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WORLD__DEFAULT_SECURITY_CONFIGURATION = 2;

    /**
     * The feature id for the '<em><b>Default Master Handler Priorities</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WORLD__DEFAULT_MASTER_HANDLER_PRIORITIES = 3;

    /**
     * The feature id for the '<em><b>Default Credentials</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WORLD__DEFAULT_CREDENTIALS = 4;

    /**
     * The feature id for the '<em><b>Default Master Customization Profile</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WORLD__DEFAULT_MASTER_CUSTOMIZATION_PROFILE = 5;

    /**
     * The feature id for the '<em><b>Default Value Archive Customization Profile</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WORLD__DEFAULT_VALUE_ARCHIVE_CUSTOMIZATION_PROFILE = 6;

    /**
     * The feature id for the '<em><b>Default Driver Password</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WORLD__DEFAULT_DRIVER_PASSWORD = 7;

    /**
     * The feature id for the '<em><b>Application Configurations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WORLD__APPLICATION_CONFIGURATIONS = 8;

    /**
     * The feature id for the '<em><b>Default Driver Access Credentials</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WORLD__DEFAULT_DRIVER_ACCESS_CREDENTIALS = 9;

    /**
     * The feature id for the '<em><b>Configurations</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WORLD__CONFIGURATIONS = 10;

    /**
     * The number of structural features of the '<em>World</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WORLD_FEATURE_COUNT = 11;

    /**
     * The number of operations of the '<em>World</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WORLD_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.infrastructure.impl.NodeImpl <em>Node</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.infrastructure.impl.NodeImpl
     * @see org.eclipse.scada.configuration.infrastructure.impl.InfrastructurePackageImpl#getNode()
     * @generated
     */
    int NODE = 1;

    /**
     * The feature id for the '<em><b>Short Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NODE__SHORT_DESCRIPTION = WorldPackage.NAMED_DOCUMENTABLE__SHORT_DESCRIPTION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NODE__NAME = WorldPackage.NAMED_DOCUMENTABLE__NAME;

    /**
     * The feature id for the '<em><b>Host Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NODE__HOST_NAME = WorldPackage.NAMED_DOCUMENTABLE_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Devices</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NODE__DEVICES = WorldPackage.NAMED_DOCUMENTABLE_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Node</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NODE_FEATURE_COUNT = WorldPackage.NAMED_DOCUMENTABLE_FEATURE_COUNT + 2;

    /**
     * The number of operations of the '<em>Node</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NODE_OPERATION_COUNT = WorldPackage.NAMED_DOCUMENTABLE_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.infrastructure.impl.EquinoxApplicationImpl <em>Equinox Application</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.infrastructure.impl.EquinoxApplicationImpl
     * @see org.eclipse.scada.configuration.infrastructure.impl.InfrastructurePackageImpl#getEquinoxApplication()
     * @generated
     */
    int EQUINOX_APPLICATION = 5;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EQUINOX_APPLICATION__NAME = 0;

    /**
     * The feature id for the '<em><b>Instance Number</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EQUINOX_APPLICATION__INSTANCE_NUMBER = 1;

    /**
     * The feature id for the '<em><b>Configurations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EQUINOX_APPLICATION__CONFIGURATIONS = 2;

    /**
     * The feature id for the '<em><b>Configuration</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EQUINOX_APPLICATION__CONFIGURATION = 3;

    /**
     * The feature id for the '<em><b>Local Credentials</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EQUINOX_APPLICATION__LOCAL_CREDENTIALS = 4;

    /**
     * The feature id for the '<em><b>Security Configuration</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EQUINOX_APPLICATION__SECURITY_CONFIGURATION = 5;

    /**
     * The number of structural features of the '<em>Equinox Application</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EQUINOX_APPLICATION_FEATURE_COUNT = 6;

    /**
     * The number of operations of the '<em>Equinox Application</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EQUINOX_APPLICATION_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.infrastructure.impl.MasterServerImpl <em>Master Server</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.infrastructure.impl.MasterServerImpl
     * @see org.eclipse.scada.configuration.infrastructure.impl.InfrastructurePackageImpl#getMasterServer()
     * @generated
     */
    int MASTER_SERVER = 2;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MASTER_SERVER__NAME = EQUINOX_APPLICATION__NAME;

    /**
     * The feature id for the '<em><b>Instance Number</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MASTER_SERVER__INSTANCE_NUMBER = EQUINOX_APPLICATION__INSTANCE_NUMBER;

    /**
     * The feature id for the '<em><b>Configurations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MASTER_SERVER__CONFIGURATIONS = EQUINOX_APPLICATION__CONFIGURATIONS;

    /**
     * The feature id for the '<em><b>Configuration</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MASTER_SERVER__CONFIGURATION = EQUINOX_APPLICATION__CONFIGURATION;

    /**
     * The feature id for the '<em><b>Local Credentials</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MASTER_SERVER__LOCAL_CREDENTIALS = EQUINOX_APPLICATION__LOCAL_CREDENTIALS;

    /**
     * The feature id for the '<em><b>Security Configuration</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MASTER_SERVER__SECURITY_CONFIGURATION = EQUINOX_APPLICATION__SECURITY_CONFIGURATION;

    /**
     * The feature id for the '<em><b>Authoratives</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MASTER_SERVER__AUTHORATIVES = EQUINOX_APPLICATION_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Import Master</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MASTER_SERVER__IMPORT_MASTER = EQUINOX_APPLICATION_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Driver</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MASTER_SERVER__DRIVER = EQUINOX_APPLICATION_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Archive To</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MASTER_SERVER__ARCHIVE_TO = EQUINOX_APPLICATION_FEATURE_COUNT + 3;

    /**
     * The number of structural features of the '<em>Master Server</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MASTER_SERVER_FEATURE_COUNT = EQUINOX_APPLICATION_FEATURE_COUNT + 4;

    /**
     * The number of operations of the '<em>Master Server</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MASTER_SERVER_OPERATION_COUNT = EQUINOX_APPLICATION_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.infrastructure.impl.MasterImportImpl <em>Master Import</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.infrastructure.impl.MasterImportImpl
     * @see org.eclipse.scada.configuration.infrastructure.impl.InfrastructurePackageImpl#getMasterImport()
     * @generated
     */
    int MASTER_IMPORT = 3;

    /**
     * The feature id for the '<em><b>Imported Master</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MASTER_IMPORT__IMPORTED_MASTER = 0;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MASTER_IMPORT__ID = 1;

    /**
     * The feature id for the '<em><b>Credentials</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MASTER_IMPORT__CREDENTIALS = 2;

    /**
     * The feature id for the '<em><b>Master</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MASTER_IMPORT__MASTER = 3;

    /**
     * The number of structural features of the '<em>Master Import</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MASTER_IMPORT_FEATURE_COUNT = 4;

    /**
     * The number of operations of the '<em>Master Import</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MASTER_IMPORT_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.infrastructure.impl.OptionsImpl <em>Options</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.infrastructure.impl.OptionsImpl
     * @see org.eclipse.scada.configuration.infrastructure.impl.InfrastructurePackageImpl#getOptions()
     * @generated
     */
    int OPTIONS = 4;

    /**
     * The feature id for the '<em><b>Base Da Ngp Port</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OPTIONS__BASE_DA_NGP_PORT = 0;

    /**
     * The feature id for the '<em><b>Base Ae Ngp Port</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OPTIONS__BASE_AE_NGP_PORT = 1;

    /**
     * The feature id for the '<em><b>Base Ca Ngp Port</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OPTIONS__BASE_CA_NGP_PORT = 2;

    /**
     * The feature id for the '<em><b>Base Hd Ngp Port</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OPTIONS__BASE_HD_NGP_PORT = 3;

    /**
     * The feature id for the '<em><b>Monitor Pools</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OPTIONS__MONITOR_POOLS = 4;

    /**
     * The feature id for the '<em><b>Event Pools</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OPTIONS__EVENT_POOLS = 5;

    /**
     * The feature id for the '<em><b>Default User Service</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OPTIONS__DEFAULT_USER_SERVICE = 6;

    /**
     * The number of structural features of the '<em>Options</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OPTIONS_FEATURE_COUNT = 7;

    /**
     * The number of operations of the '<em>Options</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OPTIONS_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.infrastructure.impl.DriverImpl <em>Driver</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.infrastructure.impl.DriverImpl
     * @see org.eclipse.scada.configuration.infrastructure.impl.InfrastructurePackageImpl#getDriver()
     * @generated
     */
    int DRIVER = 18;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DRIVER__NAME = 0;

    /**
     * The feature id for the '<em><b>Node</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DRIVER__NODE = 1;

    /**
     * The number of structural features of the '<em>Driver</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DRIVER_FEATURE_COUNT = 2;

    /**
     * The number of operations of the '<em>Driver</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DRIVER_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.infrastructure.impl.AbstractFactoryDriverImpl <em>Abstract Factory Driver</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.infrastructure.impl.AbstractFactoryDriverImpl
     * @see org.eclipse.scada.configuration.infrastructure.impl.InfrastructurePackageImpl#getAbstractFactoryDriver()
     * @generated
     */
    int ABSTRACT_FACTORY_DRIVER = 14;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_FACTORY_DRIVER__NAME = DRIVER__NAME;

    /**
     * The feature id for the '<em><b>Node</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_FACTORY_DRIVER__NODE = DRIVER__NODE;

    /**
     * The feature id for the '<em><b>Driver Type Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_FACTORY_DRIVER__DRIVER_TYPE_ID = DRIVER_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Devices</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_FACTORY_DRIVER__DEVICES = DRIVER_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Abstract Factory Driver</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_FACTORY_DRIVER_FEATURE_COUNT = DRIVER_FEATURE_COUNT + 2;

    /**
     * The number of operations of the '<em>Abstract Factory Driver</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_FACTORY_DRIVER_OPERATION_COUNT = DRIVER_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.infrastructure.impl.CommonDriverImpl <em>Common Driver</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.infrastructure.impl.CommonDriverImpl
     * @see org.eclipse.scada.configuration.infrastructure.impl.InfrastructurePackageImpl#getCommonDriver()
     * @generated
     */
    int COMMON_DRIVER = 6;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COMMON_DRIVER__NAME = ABSTRACT_FACTORY_DRIVER__NAME;

    /**
     * The feature id for the '<em><b>Node</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COMMON_DRIVER__NODE = ABSTRACT_FACTORY_DRIVER__NODE;

    /**
     * The feature id for the '<em><b>Driver Type Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COMMON_DRIVER__DRIVER_TYPE_ID = ABSTRACT_FACTORY_DRIVER__DRIVER_TYPE_ID;

    /**
     * The feature id for the '<em><b>Devices</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COMMON_DRIVER__DEVICES = ABSTRACT_FACTORY_DRIVER__DEVICES;

    /**
     * The feature id for the '<em><b>Password</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COMMON_DRIVER__PASSWORD = ABSTRACT_FACTORY_DRIVER_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Port Number</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COMMON_DRIVER__PORT_NUMBER = ABSTRACT_FACTORY_DRIVER_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Common Driver</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COMMON_DRIVER_FEATURE_COUNT = ABSTRACT_FACTORY_DRIVER_FEATURE_COUNT + 2;

    /**
     * The number of operations of the '<em>Common Driver</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COMMON_DRIVER_OPERATION_COUNT = ABSTRACT_FACTORY_DRIVER_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.infrastructure.impl.ExternalNodeImpl <em>External Node</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.infrastructure.impl.ExternalNodeImpl
     * @see org.eclipse.scada.configuration.infrastructure.impl.InfrastructurePackageImpl#getExternalNode()
     * @generated
     */
    int EXTERNAL_NODE = 7;

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
     * The feature id for the '<em><b>Devices</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXTERNAL_NODE__DEVICES = NODE__DEVICES;

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
     * The meta object id for the '{@link org.eclipse.scada.configuration.infrastructure.impl.SystemNodeImpl <em>System Node</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.infrastructure.impl.SystemNodeImpl
     * @see org.eclipse.scada.configuration.infrastructure.impl.InfrastructurePackageImpl#getSystemNode()
     * @generated
     */
    int SYSTEM_NODE = 8;

    /**
     * The feature id for the '<em><b>Short Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SYSTEM_NODE__SHORT_DESCRIPTION = NODE__SHORT_DESCRIPTION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SYSTEM_NODE__NAME = NODE__NAME;

    /**
     * The feature id for the '<em><b>Host Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SYSTEM_NODE__HOST_NAME = NODE__HOST_NAME;

    /**
     * The feature id for the '<em><b>Devices</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SYSTEM_NODE__DEVICES = NODE__DEVICES;

    /**
     * The feature id for the '<em><b>Deployment</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SYSTEM_NODE__DEPLOYMENT = NODE_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Drivers</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SYSTEM_NODE__DRIVERS = NODE_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Masters</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SYSTEM_NODE__MASTERS = NODE_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Value Archives</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SYSTEM_NODE__VALUE_ARCHIVES = NODE_FEATURE_COUNT + 3;

    /**
     * The feature id for the '<em><b>Applications</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SYSTEM_NODE__APPLICATIONS = NODE_FEATURE_COUNT + 4;

    /**
     * The feature id for the '<em><b>Services</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SYSTEM_NODE__SERVICES = NODE_FEATURE_COUNT + 5;

    /**
     * The feature id for the '<em><b>Value Slaves</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SYSTEM_NODE__VALUE_SLAVES = NODE_FEATURE_COUNT + 6;

    /**
     * The number of structural features of the '<em>System Node</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SYSTEM_NODE_FEATURE_COUNT = NODE_FEATURE_COUNT + 7;

    /**
     * The number of operations of the '<em>System Node</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SYSTEM_NODE_OPERATION_COUNT = NODE_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.infrastructure.UserService <em>User Service</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.infrastructure.UserService
     * @see org.eclipse.scada.configuration.infrastructure.impl.InfrastructurePackageImpl#getUserService()
     * @generated
     */
    int USER_SERVICE = 11;

    /**
     * The number of structural features of the '<em>User Service</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int USER_SERVICE_FEATURE_COUNT = 0;

    /**
     * The number of operations of the '<em>User Service</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int USER_SERVICE_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.infrastructure.impl.SystemPropertyUserServiceImpl <em>System Property User Service</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.infrastructure.impl.SystemPropertyUserServiceImpl
     * @see org.eclipse.scada.configuration.infrastructure.impl.InfrastructurePackageImpl#getSystemPropertyUserService()
     * @generated
     */
    int SYSTEM_PROPERTY_USER_SERVICE = 9;

    /**
     * The feature id for the '<em><b>Users</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SYSTEM_PROPERTY_USER_SERVICE__USERS = USER_SERVICE_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>System Property User Service</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SYSTEM_PROPERTY_USER_SERVICE_FEATURE_COUNT = USER_SERVICE_FEATURE_COUNT + 1;

    /**
     * The number of operations of the '<em>System Property User Service</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SYSTEM_PROPERTY_USER_SERVICE_OPERATION_COUNT = USER_SERVICE_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.infrastructure.impl.UserEntryImpl <em>User Entry</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.infrastructure.impl.UserEntryImpl
     * @see org.eclipse.scada.configuration.infrastructure.impl.InfrastructurePackageImpl#getUserEntry()
     * @generated
     */
    int USER_ENTRY = 10;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int USER_ENTRY__NAME = 0;

    /**
     * The feature id for the '<em><b>Password</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int USER_ENTRY__PASSWORD = 1;

    /**
     * The feature id for the '<em><b>Roles</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int USER_ENTRY__ROLES = 2;

    /**
     * The number of structural features of the '<em>User Entry</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int USER_ENTRY_FEATURE_COUNT = 3;

    /**
     * The number of operations of the '<em>User Entry</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int USER_ENTRY_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.infrastructure.impl.JdbcUserServiceImpl <em>Jdbc User Service</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.infrastructure.impl.JdbcUserServiceImpl
     * @see org.eclipse.scada.configuration.infrastructure.impl.InfrastructurePackageImpl#getJdbcUserService()
     * @generated
     */
    int JDBC_USER_SERVICE = 12;

    /**
     * The feature id for the '<em><b>Implementation</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int JDBC_USER_SERVICE__IMPLEMENTATION = USER_SERVICE_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Jdbc User Service</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int JDBC_USER_SERVICE_FEATURE_COUNT = USER_SERVICE_FEATURE_COUNT + 1;

    /**
     * The number of operations of the '<em>Jdbc User Service</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int JDBC_USER_SERVICE_OPERATION_COUNT = USER_SERVICE_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.infrastructure.impl.ValueArchiveServerImpl <em>Value Archive Server</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.infrastructure.impl.ValueArchiveServerImpl
     * @see org.eclipse.scada.configuration.infrastructure.impl.InfrastructurePackageImpl#getValueArchiveServer()
     * @generated
     */
    int VALUE_ARCHIVE_SERVER = 13;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VALUE_ARCHIVE_SERVER__NAME = EQUINOX_APPLICATION__NAME;

    /**
     * The feature id for the '<em><b>Instance Number</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VALUE_ARCHIVE_SERVER__INSTANCE_NUMBER = EQUINOX_APPLICATION__INSTANCE_NUMBER;

    /**
     * The feature id for the '<em><b>Configurations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VALUE_ARCHIVE_SERVER__CONFIGURATIONS = EQUINOX_APPLICATION__CONFIGURATIONS;

    /**
     * The feature id for the '<em><b>Configuration</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VALUE_ARCHIVE_SERVER__CONFIGURATION = EQUINOX_APPLICATION__CONFIGURATION;

    /**
     * The feature id for the '<em><b>Local Credentials</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VALUE_ARCHIVE_SERVER__LOCAL_CREDENTIALS = EQUINOX_APPLICATION__LOCAL_CREDENTIALS;

    /**
     * The feature id for the '<em><b>Security Configuration</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VALUE_ARCHIVE_SERVER__SECURITY_CONFIGURATION = EQUINOX_APPLICATION__SECURITY_CONFIGURATION;

    /**
     * The number of structural features of the '<em>Value Archive Server</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VALUE_ARCHIVE_SERVER_FEATURE_COUNT = EQUINOX_APPLICATION_FEATURE_COUNT + 0;

    /**
     * The number of operations of the '<em>Value Archive Server</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VALUE_ARCHIVE_SERVER_OPERATION_COUNT = EQUINOX_APPLICATION_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.infrastructure.Device <em>Device</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.infrastructure.Device
     * @see org.eclipse.scada.configuration.infrastructure.impl.InfrastructurePackageImpl#getDevice()
     * @generated
     */
    int DEVICE = 15;

    /**
     * The feature id for the '<em><b>Short Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DEVICE__SHORT_DESCRIPTION = WorldPackage.NAMED_DOCUMENTABLE__SHORT_DESCRIPTION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DEVICE__NAME = WorldPackage.NAMED_DOCUMENTABLE__NAME;

    /**
     * The feature id for the '<em><b>Node</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DEVICE__NODE = WorldPackage.NAMED_DOCUMENTABLE_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Device</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DEVICE_FEATURE_COUNT = WorldPackage.NAMED_DOCUMENTABLE_FEATURE_COUNT + 1;

    /**
     * The number of operations of the '<em>Device</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DEVICE_OPERATION_COUNT = WorldPackage.NAMED_DOCUMENTABLE_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.infrastructure.impl.EquinoxDriverImpl <em>Equinox Driver</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.infrastructure.impl.EquinoxDriverImpl
     * @see org.eclipse.scada.configuration.infrastructure.impl.InfrastructurePackageImpl#getEquinoxDriver()
     * @generated
     */
    int EQUINOX_DRIVER = 16;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EQUINOX_DRIVER__NAME = ABSTRACT_FACTORY_DRIVER__NAME;

    /**
     * The feature id for the '<em><b>Node</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EQUINOX_DRIVER__NODE = ABSTRACT_FACTORY_DRIVER__NODE;

    /**
     * The feature id for the '<em><b>Driver Type Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EQUINOX_DRIVER__DRIVER_TYPE_ID = ABSTRACT_FACTORY_DRIVER__DRIVER_TYPE_ID;

    /**
     * The feature id for the '<em><b>Devices</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EQUINOX_DRIVER__DEVICES = ABSTRACT_FACTORY_DRIVER__DEVICES;

    /**
     * The feature id for the '<em><b>Instance Number</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EQUINOX_DRIVER__INSTANCE_NUMBER = ABSTRACT_FACTORY_DRIVER_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>User Service</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EQUINOX_DRIVER__USER_SERVICE = ABSTRACT_FACTORY_DRIVER_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Security Configuration</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EQUINOX_DRIVER__SECURITY_CONFIGURATION = ABSTRACT_FACTORY_DRIVER_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Access Credentials</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EQUINOX_DRIVER__ACCESS_CREDENTIALS = ABSTRACT_FACTORY_DRIVER_FEATURE_COUNT + 3;

    /**
     * The number of structural features of the '<em>Equinox Driver</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EQUINOX_DRIVER_FEATURE_COUNT = ABSTRACT_FACTORY_DRIVER_FEATURE_COUNT + 4;

    /**
     * The number of operations of the '<em>Equinox Driver</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EQUINOX_DRIVER_OPERATION_COUNT = ABSTRACT_FACTORY_DRIVER_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.infrastructure.impl.ExternalDriverImpl <em>External Driver</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.infrastructure.impl.ExternalDriverImpl
     * @see org.eclipse.scada.configuration.infrastructure.impl.InfrastructurePackageImpl#getExternalDriver()
     * @generated
     */
    int EXTERNAL_DRIVER = 17;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXTERNAL_DRIVER__NAME = DRIVER__NAME;

    /**
     * The feature id for the '<em><b>Node</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXTERNAL_DRIVER__NODE = DRIVER__NODE;

    /**
     * The feature id for the '<em><b>Port Number</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXTERNAL_DRIVER__PORT_NUMBER = DRIVER_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Access Credentials</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXTERNAL_DRIVER__ACCESS_CREDENTIALS = DRIVER_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Binding</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXTERNAL_DRIVER__BINDING = DRIVER_FEATURE_COUNT + 2;

    /**
     * The number of structural features of the '<em>External Driver</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXTERNAL_DRIVER_FEATURE_COUNT = DRIVER_FEATURE_COUNT + 3;

    /**
     * The number of operations of the '<em>External Driver</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXTERNAL_DRIVER_OPERATION_COUNT = DRIVER_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.infrastructure.impl.ExternalDriverPlaceholderImpl <em>External Driver Placeholder</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.infrastructure.impl.ExternalDriverPlaceholderImpl
     * @see org.eclipse.scada.configuration.infrastructure.impl.InfrastructurePackageImpl#getExternalDriverPlaceholder()
     * @generated
     */
    int EXTERNAL_DRIVER_PLACEHOLDER = 19;

    /**
     * The feature id for the '<em><b>Short Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXTERNAL_DRIVER_PLACEHOLDER__SHORT_DESCRIPTION = WorldPackage.DRIVER__SHORT_DESCRIPTION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXTERNAL_DRIVER_PLACEHOLDER__NAME = WorldPackage.DRIVER__NAME;

    /**
     * The feature id for the '<em><b>Endpoints</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXTERNAL_DRIVER_PLACEHOLDER__ENDPOINTS = WorldPackage.DRIVER_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>External Driver Placeholder</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXTERNAL_DRIVER_PLACEHOLDER_FEATURE_COUNT = WorldPackage.DRIVER_FEATURE_COUNT + 1;

    /**
     * The operation id for the '<em>Get Endpoints</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXTERNAL_DRIVER_PLACEHOLDER___GET_ENDPOINTS = WorldPackage.DRIVER___GET_ENDPOINTS;

    /**
     * The number of operations of the '<em>External Driver Placeholder</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXTERNAL_DRIVER_PLACEHOLDER_OPERATION_COUNT = WorldPackage.DRIVER_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.infrastructure.impl.ApplicationConfigurationImpl <em>Application Configuration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.infrastructure.impl.ApplicationConfigurationImpl
     * @see org.eclipse.scada.configuration.infrastructure.impl.InfrastructurePackageImpl#getApplicationConfiguration()
     * @generated
     */
    int APPLICATION_CONFIGURATION = 20;

    /**
     * The feature id for the '<em><b>Short Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int APPLICATION_CONFIGURATION__SHORT_DESCRIPTION = WorldPackage.NAMED_DOCUMENTABLE__SHORT_DESCRIPTION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int APPLICATION_CONFIGURATION__NAME = WorldPackage.NAMED_DOCUMENTABLE__NAME;

    /**
     * The feature id for the '<em><b>Modules</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int APPLICATION_CONFIGURATION__MODULES = WorldPackage.NAMED_DOCUMENTABLE_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Configurations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int APPLICATION_CONFIGURATION__CONFIGURATIONS = WorldPackage.NAMED_DOCUMENTABLE_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Application Configuration</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int APPLICATION_CONFIGURATION_FEATURE_COUNT = WorldPackage.NAMED_DOCUMENTABLE_FEATURE_COUNT + 2;

    /**
     * The number of operations of the '<em>Application Configuration</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int APPLICATION_CONFIGURATION_OPERATION_COUNT = WorldPackage.NAMED_DOCUMENTABLE_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.infrastructure.impl.ConfigurationsImpl <em>Configurations</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.infrastructure.impl.ConfigurationsImpl
     * @see org.eclipse.scada.configuration.infrastructure.impl.InfrastructurePackageImpl#getConfigurations()
     * @generated
     */
    int CONFIGURATIONS = 21;

    /**
     * The feature id for the '<em><b>Configurations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONFIGURATIONS__CONFIGURATIONS = 0;

    /**
     * The feature id for the '<em><b>Settings</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONFIGURATIONS__SETTINGS = 1;

    /**
     * The number of structural features of the '<em>Configurations</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONFIGURATIONS_FEATURE_COUNT = 2;

    /**
     * The number of operations of the '<em>Configurations</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONFIGURATIONS_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.infrastructure.Module <em>Module</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.infrastructure.Module
     * @see org.eclipse.scada.configuration.infrastructure.impl.InfrastructurePackageImpl#getModule()
     * @generated
     */
    int MODULE = 22;

    /**
     * The number of structural features of the '<em>Module</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MODULE_FEATURE_COUNT = 0;

    /**
     * The number of operations of the '<em>Module</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MODULE_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.infrastructure.impl.HttpServiceModuleImpl <em>Http Service Module</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.infrastructure.impl.HttpServiceModuleImpl
     * @see org.eclipse.scada.configuration.infrastructure.impl.InfrastructurePackageImpl#getHttpServiceModule()
     * @generated
     */
    int HTTP_SERVICE_MODULE = 23;

    /**
     * The feature id for the '<em><b>Port</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HTTP_SERVICE_MODULE__PORT = MODULE_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Http Service Module</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HTTP_SERVICE_MODULE_FEATURE_COUNT = MODULE_FEATURE_COUNT + 1;

    /**
     * The number of operations of the '<em>Http Service Module</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HTTP_SERVICE_MODULE_OPERATION_COUNT = MODULE_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.infrastructure.impl.RestExporterModuleImpl <em>Rest Exporter Module</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.infrastructure.impl.RestExporterModuleImpl
     * @see org.eclipse.scada.configuration.infrastructure.impl.InfrastructurePackageImpl#getRestExporterModule()
     * @generated
     */
    int REST_EXPORTER_MODULE = 24;

    /**
     * The feature id for the '<em><b>Context Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int REST_EXPORTER_MODULE__CONTEXT_ID = MODULE_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Rest Exporter Module</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int REST_EXPORTER_MODULE_FEATURE_COUNT = MODULE_FEATURE_COUNT + 1;

    /**
     * The number of operations of the '<em>Rest Exporter Module</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int REST_EXPORTER_MODULE_OPERATION_COUNT = MODULE_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.infrastructure.impl.ValueArchiveSlaveImpl <em>Value Archive Slave</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.infrastructure.impl.ValueArchiveSlaveImpl
     * @see org.eclipse.scada.configuration.infrastructure.impl.InfrastructurePackageImpl#getValueArchiveSlave()
     * @generated
     */
    int VALUE_ARCHIVE_SLAVE = 25;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VALUE_ARCHIVE_SLAVE__NAME = EQUINOX_APPLICATION__NAME;

    /**
     * The feature id for the '<em><b>Instance Number</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VALUE_ARCHIVE_SLAVE__INSTANCE_NUMBER = EQUINOX_APPLICATION__INSTANCE_NUMBER;

    /**
     * The feature id for the '<em><b>Configurations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VALUE_ARCHIVE_SLAVE__CONFIGURATIONS = EQUINOX_APPLICATION__CONFIGURATIONS;

    /**
     * The feature id for the '<em><b>Configuration</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VALUE_ARCHIVE_SLAVE__CONFIGURATION = EQUINOX_APPLICATION__CONFIGURATION;

    /**
     * The feature id for the '<em><b>Local Credentials</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VALUE_ARCHIVE_SLAVE__LOCAL_CREDENTIALS = EQUINOX_APPLICATION__LOCAL_CREDENTIALS;

    /**
     * The feature id for the '<em><b>Security Configuration</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VALUE_ARCHIVE_SLAVE__SECURITY_CONFIGURATION = EQUINOX_APPLICATION__SECURITY_CONFIGURATION;

    /**
     * The feature id for the '<em><b>Storage Path</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VALUE_ARCHIVE_SLAVE__STORAGE_PATH = EQUINOX_APPLICATION_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Storage Layout</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VALUE_ARCHIVE_SLAVE__STORAGE_LAYOUT = EQUINOX_APPLICATION_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Value Archive Slave</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VALUE_ARCHIVE_SLAVE_FEATURE_COUNT = EQUINOX_APPLICATION_FEATURE_COUNT + 2;

    /**
     * The number of operations of the '<em>Value Archive Slave</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VALUE_ARCHIVE_SLAVE_OPERATION_COUNT = EQUINOX_APPLICATION_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.infrastructure.impl.WebAdminConsoleImpl <em>Web Admin Console</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.infrastructure.impl.WebAdminConsoleImpl
     * @see org.eclipse.scada.configuration.infrastructure.impl.InfrastructurePackageImpl#getWebAdminConsole()
     * @generated
     */
    int WEB_ADMIN_CONSOLE = 26;

    /**
     * The feature id for the '<em><b>Http Service</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WEB_ADMIN_CONSOLE__HTTP_SERVICE = MODULE_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Web Admin Console</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WEB_ADMIN_CONSOLE_FEATURE_COUNT = MODULE_FEATURE_COUNT + 1;

    /**
     * The number of operations of the '<em>Web Admin Console</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int WEB_ADMIN_CONSOLE_OPERATION_COUNT = MODULE_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.infrastructure.impl.OracleVMSettingsImpl <em>Oracle VM Settings</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.infrastructure.impl.OracleVMSettingsImpl
     * @see org.eclipse.scada.configuration.infrastructure.impl.InfrastructurePackageImpl#getOracleVMSettings()
     * @generated
     */
    int ORACLE_VM_SETTINGS = 27;

    /**
     * The feature id for the '<em><b>Initial Heap Size</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ORACLE_VM_SETTINGS__INITIAL_HEAP_SIZE = MODULE_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Maximum Heap Size</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ORACLE_VM_SETTINGS__MAXIMUM_HEAP_SIZE = MODULE_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Oracle VM Settings</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ORACLE_VM_SETTINGS_FEATURE_COUNT = MODULE_FEATURE_COUNT + 2;

    /**
     * The number of operations of the '<em>Oracle VM Settings</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ORACLE_VM_SETTINGS_OPERATION_COUNT = MODULE_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.infrastructure.impl.GenericVMSettingsImpl <em>Generic VM Settings</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.infrastructure.impl.GenericVMSettingsImpl
     * @see org.eclipse.scada.configuration.infrastructure.impl.InfrastructurePackageImpl#getGenericVMSettings()
     * @generated
     */
    int GENERIC_VM_SETTINGS = 28;

    /**
     * The feature id for the '<em><b>Arguments</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GENERIC_VM_SETTINGS__ARGUMENTS = MODULE_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Generic VM Settings</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GENERIC_VM_SETTINGS_FEATURE_COUNT = MODULE_FEATURE_COUNT + 1;

    /**
     * The number of operations of the '<em>Generic VM Settings</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GENERIC_VM_SETTINGS_OPERATION_COUNT = MODULE_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.infrastructure.impl.AbstractEquinoxDriverImpl <em>Abstract Equinox Driver</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.infrastructure.impl.AbstractEquinoxDriverImpl
     * @see org.eclipse.scada.configuration.infrastructure.impl.InfrastructurePackageImpl#getAbstractEquinoxDriver()
     * @generated
     */
    int ABSTRACT_EQUINOX_DRIVER = 29;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_EQUINOX_DRIVER__NAME = DRIVER__NAME;

    /**
     * The feature id for the '<em><b>Node</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_EQUINOX_DRIVER__NODE = DRIVER__NODE;

    /**
     * The feature id for the '<em><b>Instance Number</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_EQUINOX_DRIVER__INSTANCE_NUMBER = DRIVER_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>User Service</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_EQUINOX_DRIVER__USER_SERVICE = DRIVER_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Security Configuration</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_EQUINOX_DRIVER__SECURITY_CONFIGURATION = DRIVER_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Access Credentials</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_EQUINOX_DRIVER__ACCESS_CREDENTIALS = DRIVER_FEATURE_COUNT + 3;

    /**
     * The number of structural features of the '<em>Abstract Equinox Driver</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_EQUINOX_DRIVER_FEATURE_COUNT = DRIVER_FEATURE_COUNT + 4;

    /**
     * The number of operations of the '<em>Abstract Equinox Driver</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_EQUINOX_DRIVER_OPERATION_COUNT = DRIVER_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.infrastructure.EquinoxBase <em>Equinox Base</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.infrastructure.EquinoxBase
     * @see org.eclipse.scada.configuration.infrastructure.impl.InfrastructurePackageImpl#getEquinoxBase()
     * @generated
     */
    int EQUINOX_BASE = 30;

    /**
     * The feature id for the '<em><b>Instance Number</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EQUINOX_BASE__INSTANCE_NUMBER = 0;

    /**
     * The feature id for the '<em><b>User Service</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EQUINOX_BASE__USER_SERVICE = 1;

    /**
     * The feature id for the '<em><b>Security Configuration</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EQUINOX_BASE__SECURITY_CONFIGURATION = 2;

    /**
     * The number of structural features of the '<em>Equinox Base</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EQUINOX_BASE_FEATURE_COUNT = 3;

    /**
     * The number of operations of the '<em>Equinox Base</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EQUINOX_BASE_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.infrastructure.impl.AbstractCommonDriverImpl <em>Abstract Common Driver</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.infrastructure.impl.AbstractCommonDriverImpl
     * @see org.eclipse.scada.configuration.infrastructure.impl.InfrastructurePackageImpl#getAbstractCommonDriver()
     * @generated
     */
    int ABSTRACT_COMMON_DRIVER = 31;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_COMMON_DRIVER__NAME = DRIVER__NAME;

    /**
     * The feature id for the '<em><b>Node</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_COMMON_DRIVER__NODE = DRIVER__NODE;

    /**
     * The feature id for the '<em><b>Port Number</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_COMMON_DRIVER__PORT_NUMBER = DRIVER_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Password</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_COMMON_DRIVER__PASSWORD = DRIVER_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Abstract Common Driver</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_COMMON_DRIVER_FEATURE_COUNT = DRIVER_FEATURE_COUNT + 2;

    /**
     * The number of operations of the '<em>Abstract Common Driver</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_COMMON_DRIVER_OPERATION_COUNT = DRIVER_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.infrastructure.SlaveStorageLayout <em>Slave Storage Layout</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.infrastructure.SlaveStorageLayout
     * @see org.eclipse.scada.configuration.infrastructure.impl.InfrastructurePackageImpl#getSlaveStorageLayout()
     * @generated
     */
    int SLAVE_STORAGE_LAYOUT = 32;

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.infrastructure.World <em>World</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>World</em>'.
     * @see org.eclipse.scada.configuration.infrastructure.World
     * @generated
     */
    EClass getWorld ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.configuration.infrastructure.World#getNodes <em>Nodes</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Nodes</em>'.
     * @see org.eclipse.scada.configuration.infrastructure.World#getNodes()
     * @see #getWorld()
     * @generated
     */
    EReference getWorld_Nodes ();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.scada.configuration.infrastructure.World#getOptions <em>Options</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Options</em>'.
     * @see org.eclipse.scada.configuration.infrastructure.World#getOptions()
     * @see #getWorld()
     * @generated
     */
    EReference getWorld_Options ();

    /**
     * Returns the meta object for the reference '{@link org.eclipse.scada.configuration.infrastructure.World#getDefaultSecurityConfiguration <em>Default Security Configuration</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Default Security Configuration</em>'.
     * @see org.eclipse.scada.configuration.infrastructure.World#getDefaultSecurityConfiguration()
     * @see #getWorld()
     * @generated
     */
    EReference getWorld_DefaultSecurityConfiguration ();

    /**
     * Returns the meta object for the reference '{@link org.eclipse.scada.configuration.infrastructure.World#getDefaultMasterHandlerPriorities <em>Default Master Handler Priorities</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Default Master Handler Priorities</em>'.
     * @see org.eclipse.scada.configuration.infrastructure.World#getDefaultMasterHandlerPriorities()
     * @see #getWorld()
     * @generated
     */
    EReference getWorld_DefaultMasterHandlerPriorities ();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.scada.configuration.infrastructure.World#getDefaultCredentials <em>Default Credentials</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Default Credentials</em>'.
     * @see org.eclipse.scada.configuration.infrastructure.World#getDefaultCredentials()
     * @see #getWorld()
     * @generated
     */
    EReference getWorld_DefaultCredentials ();

    /**
     * Returns the meta object for the reference '{@link org.eclipse.scada.configuration.infrastructure.World#getDefaultMasterCustomizationProfile <em>Default Master Customization Profile</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Default Master Customization Profile</em>'.
     * @see org.eclipse.scada.configuration.infrastructure.World#getDefaultMasterCustomizationProfile()
     * @see #getWorld()
     * @generated
     */
    EReference getWorld_DefaultMasterCustomizationProfile ();

    /**
     * Returns the meta object for the reference '{@link org.eclipse.scada.configuration.infrastructure.World#getDefaultValueArchiveCustomizationProfile <em>Default Value Archive Customization Profile</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Default Value Archive Customization Profile</em>'.
     * @see org.eclipse.scada.configuration.infrastructure.World#getDefaultValueArchiveCustomizationProfile()
     * @see #getWorld()
     * @generated
     */
    EReference getWorld_DefaultValueArchiveCustomizationProfile ();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.scada.configuration.infrastructure.World#getDefaultDriverPassword <em>Default Driver Password</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Default Driver Password</em>'.
     * @see org.eclipse.scada.configuration.infrastructure.World#getDefaultDriverPassword()
     * @see #getWorld()
     * @generated
     */
    EReference getWorld_DefaultDriverPassword ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.configuration.infrastructure.World#getApplicationConfigurations <em>Application Configurations</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Application Configurations</em>'.
     * @see org.eclipse.scada.configuration.infrastructure.World#getApplicationConfigurations()
     * @see #getWorld()
     * @generated
     */
    EReference getWorld_ApplicationConfigurations ();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.scada.configuration.infrastructure.World#getDefaultDriverAccessCredentials <em>Default Driver Access Credentials</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Default Driver Access Credentials</em>'.
     * @see org.eclipse.scada.configuration.infrastructure.World#getDefaultDriverAccessCredentials()
     * @see #getWorld()
     * @generated
     */
    EReference getWorld_DefaultDriverAccessCredentials ();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.scada.configuration.infrastructure.World#getConfigurations <em>Configurations</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Configurations</em>'.
     * @see org.eclipse.scada.configuration.infrastructure.World#getConfigurations()
     * @see #getWorld()
     * @generated
     */
    EReference getWorld_Configurations ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.infrastructure.Node <em>Node</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Node</em>'.
     * @see org.eclipse.scada.configuration.infrastructure.Node
     * @generated
     */
    EClass getNode ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.infrastructure.Node#getHostName <em>Host Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Host Name</em>'.
     * @see org.eclipse.scada.configuration.infrastructure.Node#getHostName()
     * @see #getNode()
     * @generated
     */
    EAttribute getNode_HostName ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.configuration.infrastructure.Node#getDevices <em>Devices</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Devices</em>'.
     * @see org.eclipse.scada.configuration.infrastructure.Node#getDevices()
     * @see #getNode()
     * @generated
     */
    EReference getNode_Devices ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.infrastructure.MasterServer <em>Master Server</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Master Server</em>'.
     * @see org.eclipse.scada.configuration.infrastructure.MasterServer
     * @generated
     */
    EClass getMasterServer ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.configuration.infrastructure.MasterServer#getAuthoratives <em>Authoratives</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Authoratives</em>'.
     * @see org.eclipse.scada.configuration.infrastructure.MasterServer#getAuthoratives()
     * @see #getMasterServer()
     * @generated
     */
    EReference getMasterServer_Authoratives ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.configuration.infrastructure.MasterServer#getImportMaster <em>Import Master</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Import Master</em>'.
     * @see org.eclipse.scada.configuration.infrastructure.MasterServer#getImportMaster()
     * @see #getMasterServer()
     * @generated
     */
    EReference getMasterServer_ImportMaster ();

    /**
     * Returns the meta object for the reference list '{@link org.eclipse.scada.configuration.infrastructure.MasterServer#getDriver <em>Driver</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Driver</em>'.
     * @see org.eclipse.scada.configuration.infrastructure.MasterServer#getDriver()
     * @see #getMasterServer()
     * @generated
     */
    EReference getMasterServer_Driver ();

    /**
     * Returns the meta object for the reference '{@link org.eclipse.scada.configuration.infrastructure.MasterServer#getArchiveTo <em>Archive To</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Archive To</em>'.
     * @see org.eclipse.scada.configuration.infrastructure.MasterServer#getArchiveTo()
     * @see #getMasterServer()
     * @generated
     */
    EReference getMasterServer_ArchiveTo ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.infrastructure.MasterImport <em>Master Import</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Master Import</em>'.
     * @see org.eclipse.scada.configuration.infrastructure.MasterImport
     * @generated
     */
    EClass getMasterImport ();

    /**
     * Returns the meta object for the reference '{@link org.eclipse.scada.configuration.infrastructure.MasterImport#getImportedMaster <em>Imported Master</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Imported Master</em>'.
     * @see org.eclipse.scada.configuration.infrastructure.MasterImport#getImportedMaster()
     * @see #getMasterImport()
     * @generated
     */
    EReference getMasterImport_ImportedMaster ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.infrastructure.MasterImport#getId <em>Id</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Id</em>'.
     * @see org.eclipse.scada.configuration.infrastructure.MasterImport#getId()
     * @see #getMasterImport()
     * @generated
     */
    EAttribute getMasterImport_Id ();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.scada.configuration.infrastructure.MasterImport#getCredentials <em>Credentials</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Credentials</em>'.
     * @see org.eclipse.scada.configuration.infrastructure.MasterImport#getCredentials()
     * @see #getMasterImport()
     * @generated
     */
    EReference getMasterImport_Credentials ();

    /**
     * Returns the meta object for the container reference '{@link org.eclipse.scada.configuration.infrastructure.MasterImport#getMaster <em>Master</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Master</em>'.
     * @see org.eclipse.scada.configuration.infrastructure.MasterImport#getMaster()
     * @see #getMasterImport()
     * @generated
     */
    EReference getMasterImport_Master ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.infrastructure.Options <em>Options</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Options</em>'.
     * @see org.eclipse.scada.configuration.infrastructure.Options
     * @generated
     */
    EClass getOptions ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.infrastructure.Options#getBaseDaNgpPort <em>Base Da Ngp Port</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Base Da Ngp Port</em>'.
     * @see org.eclipse.scada.configuration.infrastructure.Options#getBaseDaNgpPort()
     * @see #getOptions()
     * @generated
     */
    EAttribute getOptions_BaseDaNgpPort ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.infrastructure.Options#getBaseAeNgpPort <em>Base Ae Ngp Port</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Base Ae Ngp Port</em>'.
     * @see org.eclipse.scada.configuration.infrastructure.Options#getBaseAeNgpPort()
     * @see #getOptions()
     * @generated
     */
    EAttribute getOptions_BaseAeNgpPort ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.infrastructure.Options#getBaseCaNgpPort <em>Base Ca Ngp Port</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Base Ca Ngp Port</em>'.
     * @see org.eclipse.scada.configuration.infrastructure.Options#getBaseCaNgpPort()
     * @see #getOptions()
     * @generated
     */
    EAttribute getOptions_BaseCaNgpPort ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.infrastructure.Options#getBaseHdNgpPort <em>Base Hd Ngp Port</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Base Hd Ngp Port</em>'.
     * @see org.eclipse.scada.configuration.infrastructure.Options#getBaseHdNgpPort()
     * @see #getOptions()
     * @generated
     */
    EAttribute getOptions_BaseHdNgpPort ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.configuration.infrastructure.Options#getMonitorPools <em>Monitor Pools</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Monitor Pools</em>'.
     * @see org.eclipse.scada.configuration.infrastructure.Options#getMonitorPools()
     * @see #getOptions()
     * @generated
     */
    EReference getOptions_MonitorPools ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.configuration.infrastructure.Options#getEventPools <em>Event Pools</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Event Pools</em>'.
     * @see org.eclipse.scada.configuration.infrastructure.Options#getEventPools()
     * @see #getOptions()
     * @generated
     */
    EReference getOptions_EventPools ();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.scada.configuration.infrastructure.Options#getDefaultUserService <em>Default User Service</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Default User Service</em>'.
     * @see org.eclipse.scada.configuration.infrastructure.Options#getDefaultUserService()
     * @see #getOptions()
     * @generated
     */
    EReference getOptions_DefaultUserService ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.infrastructure.EquinoxApplication <em>Equinox Application</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Equinox Application</em>'.
     * @see org.eclipse.scada.configuration.infrastructure.EquinoxApplication
     * @generated
     */
    EClass getEquinoxApplication ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.infrastructure.EquinoxApplication#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see org.eclipse.scada.configuration.infrastructure.EquinoxApplication#getName()
     * @see #getEquinoxApplication()
     * @generated
     */
    EAttribute getEquinoxApplication_Name ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.infrastructure.EquinoxApplication#getInstanceNumber <em>Instance Number</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Instance Number</em>'.
     * @see org.eclipse.scada.configuration.infrastructure.EquinoxApplication#getInstanceNumber()
     * @see #getEquinoxApplication()
     * @generated
     */
    EAttribute getEquinoxApplication_InstanceNumber ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.configuration.infrastructure.EquinoxApplication#getConfigurations <em>Configurations</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Configurations</em>'.
     * @see org.eclipse.scada.configuration.infrastructure.EquinoxApplication#getConfigurations()
     * @see #getEquinoxApplication()
     * @generated
     */
    EReference getEquinoxApplication_Configurations ();

    /**
     * Returns the meta object for the reference '{@link org.eclipse.scada.configuration.infrastructure.EquinoxApplication#getConfiguration <em>Configuration</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Configuration</em>'.
     * @see org.eclipse.scada.configuration.infrastructure.EquinoxApplication#getConfiguration()
     * @see #getEquinoxApplication()
     * @generated
     */
    EReference getEquinoxApplication_Configuration ();

    /**
     * Returns the meta object for the reference '{@link org.eclipse.scada.configuration.infrastructure.EquinoxApplication#getLocalCredentials <em>Local Credentials</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Local Credentials</em>'.
     * @see org.eclipse.scada.configuration.infrastructure.EquinoxApplication#getLocalCredentials()
     * @see #getEquinoxApplication()
     * @generated
     */
    EReference getEquinoxApplication_LocalCredentials ();

    /**
     * Returns the meta object for the reference '{@link org.eclipse.scada.configuration.infrastructure.EquinoxApplication#getSecurityConfiguration <em>Security Configuration</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Security Configuration</em>'.
     * @see org.eclipse.scada.configuration.infrastructure.EquinoxApplication#getSecurityConfiguration()
     * @see #getEquinoxApplication()
     * @generated
     */
    EReference getEquinoxApplication_SecurityConfiguration ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.infrastructure.CommonDriver <em>Common Driver</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Common Driver</em>'.
     * @see org.eclipse.scada.configuration.infrastructure.CommonDriver
     * @generated
     */
    EClass getCommonDriver ();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.scada.configuration.infrastructure.CommonDriver#getPassword <em>Password</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Password</em>'.
     * @see org.eclipse.scada.configuration.infrastructure.CommonDriver#getPassword()
     * @see #getCommonDriver()
     * @generated
     */
    EReference getCommonDriver_Password ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.infrastructure.CommonDriver#getPortNumber <em>Port Number</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Port Number</em>'.
     * @see org.eclipse.scada.configuration.infrastructure.CommonDriver#getPortNumber()
     * @see #getCommonDriver()
     * @generated
     */
    EAttribute getCommonDriver_PortNumber ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.infrastructure.ExternalNode <em>External Node</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>External Node</em>'.
     * @see org.eclipse.scada.configuration.infrastructure.ExternalNode
     * @generated
     */
    EClass getExternalNode ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.infrastructure.SystemNode <em>System Node</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>System Node</em>'.
     * @see org.eclipse.scada.configuration.infrastructure.SystemNode
     * @generated
     */
    EClass getSystemNode ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.configuration.infrastructure.SystemNode#getDeployment <em>Deployment</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Deployment</em>'.
     * @see org.eclipse.scada.configuration.infrastructure.SystemNode#getDeployment()
     * @see #getSystemNode()
     * @generated
     */
    EReference getSystemNode_Deployment ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.configuration.infrastructure.SystemNode#getDrivers <em>Drivers</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Drivers</em>'.
     * @see org.eclipse.scada.configuration.infrastructure.SystemNode#getDrivers()
     * @see #getSystemNode()
     * @generated
     */
    EReference getSystemNode_Drivers ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.configuration.infrastructure.SystemNode#getMasters <em>Masters</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Masters</em>'.
     * @see org.eclipse.scada.configuration.infrastructure.SystemNode#getMasters()
     * @see #getSystemNode()
     * @generated
     */
    EReference getSystemNode_Masters ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.configuration.infrastructure.SystemNode#getValueArchives <em>Value Archives</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Value Archives</em>'.
     * @see org.eclipse.scada.configuration.infrastructure.SystemNode#getValueArchives()
     * @see #getSystemNode()
     * @generated
     */
    EReference getSystemNode_ValueArchives ();

    /**
     * Returns the meta object for the attribute list '{@link org.eclipse.scada.configuration.infrastructure.SystemNode#getApplications <em>Applications</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute list '<em>Applications</em>'.
     * @see org.eclipse.scada.configuration.infrastructure.SystemNode#getApplications()
     * @see #getSystemNode()
     * @generated
     */
    EAttribute getSystemNode_Applications ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.configuration.infrastructure.SystemNode#getServices <em>Services</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Services</em>'.
     * @see org.eclipse.scada.configuration.infrastructure.SystemNode#getServices()
     * @see #getSystemNode()
     * @generated
     */
    EReference getSystemNode_Services ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.configuration.infrastructure.SystemNode#getValueSlaves <em>Value Slaves</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Value Slaves</em>'.
     * @see org.eclipse.scada.configuration.infrastructure.SystemNode#getValueSlaves()
     * @see #getSystemNode()
     * @generated
     */
    EReference getSystemNode_ValueSlaves ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.infrastructure.SystemPropertyUserService <em>System Property User Service</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>System Property User Service</em>'.
     * @see org.eclipse.scada.configuration.infrastructure.SystemPropertyUserService
     * @generated
     */
    EClass getSystemPropertyUserService ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.configuration.infrastructure.SystemPropertyUserService#getUsers <em>Users</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Users</em>'.
     * @see org.eclipse.scada.configuration.infrastructure.SystemPropertyUserService#getUsers()
     * @see #getSystemPropertyUserService()
     * @generated
     */
    EReference getSystemPropertyUserService_Users ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.infrastructure.UserEntry <em>User Entry</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>User Entry</em>'.
     * @see org.eclipse.scada.configuration.infrastructure.UserEntry
     * @generated
     */
    EClass getUserEntry ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.infrastructure.UserEntry#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see org.eclipse.scada.configuration.infrastructure.UserEntry#getName()
     * @see #getUserEntry()
     * @generated
     */
    EAttribute getUserEntry_Name ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.infrastructure.UserEntry#getPassword <em>Password</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Password</em>'.
     * @see org.eclipse.scada.configuration.infrastructure.UserEntry#getPassword()
     * @see #getUserEntry()
     * @generated
     */
    EAttribute getUserEntry_Password ();

    /**
     * Returns the meta object for the attribute list '{@link org.eclipse.scada.configuration.infrastructure.UserEntry#getRoles <em>Roles</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute list '<em>Roles</em>'.
     * @see org.eclipse.scada.configuration.infrastructure.UserEntry#getRoles()
     * @see #getUserEntry()
     * @generated
     */
    EAttribute getUserEntry_Roles ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.infrastructure.UserService <em>User Service</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>User Service</em>'.
     * @see org.eclipse.scada.configuration.infrastructure.UserService
     * @generated
     */
    EClass getUserService ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.infrastructure.JdbcUserService <em>Jdbc User Service</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Jdbc User Service</em>'.
     * @see org.eclipse.scada.configuration.infrastructure.JdbcUserService
     * @generated
     */
    EClass getJdbcUserService ();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.scada.configuration.infrastructure.JdbcUserService#getImplementation <em>Implementation</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Implementation</em>'.
     * @see org.eclipse.scada.configuration.infrastructure.JdbcUserService#getImplementation()
     * @see #getJdbcUserService()
     * @generated
     */
    EReference getJdbcUserService_Implementation ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.infrastructure.ValueArchiveServer <em>Value Archive Server</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Value Archive Server</em>'.
     * @see org.eclipse.scada.configuration.infrastructure.ValueArchiveServer
     * @generated
     */
    EClass getValueArchiveServer ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.infrastructure.AbstractFactoryDriver <em>Abstract Factory Driver</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Abstract Factory Driver</em>'.
     * @see org.eclipse.scada.configuration.infrastructure.AbstractFactoryDriver
     * @generated
     */
    EClass getAbstractFactoryDriver ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.infrastructure.AbstractFactoryDriver#getDriverTypeId <em>Driver Type Id</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Driver Type Id</em>'.
     * @see org.eclipse.scada.configuration.infrastructure.AbstractFactoryDriver#getDriverTypeId()
     * @see #getAbstractFactoryDriver()
     * @generated
     */
    EAttribute getAbstractFactoryDriver_DriverTypeId ();

    /**
     * Returns the meta object for the reference list '{@link org.eclipse.scada.configuration.infrastructure.AbstractFactoryDriver#getDevices <em>Devices</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Devices</em>'.
     * @see org.eclipse.scada.configuration.infrastructure.AbstractFactoryDriver#getDevices()
     * @see #getAbstractFactoryDriver()
     * @generated
     */
    EReference getAbstractFactoryDriver_Devices ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.infrastructure.Device <em>Device</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Device</em>'.
     * @see org.eclipse.scada.configuration.infrastructure.Device
     * @generated
     */
    EClass getDevice ();

    /**
     * Returns the meta object for the container reference '{@link org.eclipse.scada.configuration.infrastructure.Device#getNode <em>Node</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Node</em>'.
     * @see org.eclipse.scada.configuration.infrastructure.Device#getNode()
     * @see #getDevice()
     * @generated
     */
    EReference getDevice_Node ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.infrastructure.EquinoxDriver <em>Equinox Driver</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Equinox Driver</em>'.
     * @see org.eclipse.scada.configuration.infrastructure.EquinoxDriver
     * @generated
     */
    EClass getEquinoxDriver ();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.scada.configuration.infrastructure.EquinoxDriver#getAccessCredentials <em>Access Credentials</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Access Credentials</em>'.
     * @see org.eclipse.scada.configuration.infrastructure.EquinoxDriver#getAccessCredentials()
     * @see #getEquinoxDriver()
     * @generated
     */
    EReference getEquinoxDriver_AccessCredentials ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.infrastructure.ExternalDriver <em>External Driver</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>External Driver</em>'.
     * @see org.eclipse.scada.configuration.infrastructure.ExternalDriver
     * @generated
     */
    EClass getExternalDriver ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.infrastructure.ExternalDriver#getPortNumber <em>Port Number</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Port Number</em>'.
     * @see org.eclipse.scada.configuration.infrastructure.ExternalDriver#getPortNumber()
     * @see #getExternalDriver()
     * @generated
     */
    EAttribute getExternalDriver_PortNumber ();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.scada.configuration.infrastructure.ExternalDriver#getAccessCredentials <em>Access Credentials</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Access Credentials</em>'.
     * @see org.eclipse.scada.configuration.infrastructure.ExternalDriver#getAccessCredentials()
     * @see #getExternalDriver()
     * @generated
     */
    EReference getExternalDriver_AccessCredentials ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.infrastructure.ExternalDriver#isBinding <em>Binding</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Binding</em>'.
     * @see org.eclipse.scada.configuration.infrastructure.ExternalDriver#isBinding()
     * @see #getExternalDriver()
     * @generated
     */
    EAttribute getExternalDriver_Binding ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.infrastructure.Driver <em>Driver</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Driver</em>'.
     * @see org.eclipse.scada.configuration.infrastructure.Driver
     * @generated
     */
    EClass getDriver ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.infrastructure.Driver#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see org.eclipse.scada.configuration.infrastructure.Driver#getName()
     * @see #getDriver()
     * @generated
     */
    EAttribute getDriver_Name ();

    /**
     * Returns the meta object for the container reference '{@link org.eclipse.scada.configuration.infrastructure.Driver#getNode <em>Node</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Node</em>'.
     * @see org.eclipse.scada.configuration.infrastructure.Driver#getNode()
     * @see #getDriver()
     * @generated
     */
    EReference getDriver_Node ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.infrastructure.ExternalDriverPlaceholder <em>External Driver Placeholder</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>External Driver Placeholder</em>'.
     * @see org.eclipse.scada.configuration.infrastructure.ExternalDriverPlaceholder
     * @generated
     */
    EClass getExternalDriverPlaceholder ();

    /**
     * Returns the meta object for the reference list '{@link org.eclipse.scada.configuration.infrastructure.ExternalDriverPlaceholder#getEndpoints <em>Endpoints</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Endpoints</em>'.
     * @see org.eclipse.scada.configuration.infrastructure.ExternalDriverPlaceholder#getEndpoints()
     * @see #getExternalDriverPlaceholder()
     * @generated
     */
    EReference getExternalDriverPlaceholder_Endpoints ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.infrastructure.ApplicationConfiguration <em>Application Configuration</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Application Configuration</em>'.
     * @see org.eclipse.scada.configuration.infrastructure.ApplicationConfiguration
     * @generated
     */
    EClass getApplicationConfiguration ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.configuration.infrastructure.ApplicationConfiguration#getModules <em>Modules</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Modules</em>'.
     * @see org.eclipse.scada.configuration.infrastructure.ApplicationConfiguration#getModules()
     * @see #getApplicationConfiguration()
     * @generated
     */
    EReference getApplicationConfiguration_Modules ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.configuration.infrastructure.ApplicationConfiguration#getConfigurations <em>Configurations</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Configurations</em>'.
     * @see org.eclipse.scada.configuration.infrastructure.ApplicationConfiguration#getConfigurations()
     * @see #getApplicationConfiguration()
     * @generated
     */
    EReference getApplicationConfiguration_Configurations ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.infrastructure.Configurations <em>Configurations</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Configurations</em>'.
     * @see org.eclipse.scada.configuration.infrastructure.Configurations
     * @generated
     */
    EClass getConfigurations ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.configuration.infrastructure.Configurations#getConfigurations <em>Configurations</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Configurations</em>'.
     * @see org.eclipse.scada.configuration.infrastructure.Configurations#getConfigurations()
     * @see #getConfigurations()
     * @generated
     */
    EReference getConfigurations_Configurations ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.configuration.infrastructure.Configurations#getSettings <em>Settings</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Settings</em>'.
     * @see org.eclipse.scada.configuration.infrastructure.Configurations#getSettings()
     * @see #getConfigurations()
     * @generated
     */
    EReference getConfigurations_Settings ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.infrastructure.Module <em>Module</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Module</em>'.
     * @see org.eclipse.scada.configuration.infrastructure.Module
     * @generated
     */
    EClass getModule ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.infrastructure.HttpServiceModule <em>Http Service Module</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Http Service Module</em>'.
     * @see org.eclipse.scada.configuration.infrastructure.HttpServiceModule
     * @generated
     */
    EClass getHttpServiceModule ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.infrastructure.HttpServiceModule#getPort <em>Port</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Port</em>'.
     * @see org.eclipse.scada.configuration.infrastructure.HttpServiceModule#getPort()
     * @see #getHttpServiceModule()
     * @generated
     */
    EAttribute getHttpServiceModule_Port ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.infrastructure.RestExporterModule <em>Rest Exporter Module</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Rest Exporter Module</em>'.
     * @see org.eclipse.scada.configuration.infrastructure.RestExporterModule
     * @generated
     */
    EClass getRestExporterModule ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.infrastructure.RestExporterModule#getContextId <em>Context Id</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Context Id</em>'.
     * @see org.eclipse.scada.configuration.infrastructure.RestExporterModule#getContextId()
     * @see #getRestExporterModule()
     * @generated
     */
    EAttribute getRestExporterModule_ContextId ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.infrastructure.ValueArchiveSlave <em>Value Archive Slave</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Value Archive Slave</em>'.
     * @see org.eclipse.scada.configuration.infrastructure.ValueArchiveSlave
     * @generated
     */
    EClass getValueArchiveSlave ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.infrastructure.ValueArchiveSlave#getStoragePath <em>Storage Path</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Storage Path</em>'.
     * @see org.eclipse.scada.configuration.infrastructure.ValueArchiveSlave#getStoragePath()
     * @see #getValueArchiveSlave()
     * @generated
     */
    EAttribute getValueArchiveSlave_StoragePath ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.infrastructure.ValueArchiveSlave#getStorageLayout <em>Storage Layout</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Storage Layout</em>'.
     * @see org.eclipse.scada.configuration.infrastructure.ValueArchiveSlave#getStorageLayout()
     * @see #getValueArchiveSlave()
     * @generated
     */
    EAttribute getValueArchiveSlave_StorageLayout ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.infrastructure.WebAdminConsole <em>Web Admin Console</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Web Admin Console</em>'.
     * @see org.eclipse.scada.configuration.infrastructure.WebAdminConsole
     * @generated
     */
    EClass getWebAdminConsole ();

    /**
     * Returns the meta object for the reference '{@link org.eclipse.scada.configuration.infrastructure.WebAdminConsole#getHttpService <em>Http Service</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Http Service</em>'.
     * @see org.eclipse.scada.configuration.infrastructure.WebAdminConsole#getHttpService()
     * @see #getWebAdminConsole()
     * @generated
     */
    EReference getWebAdminConsole_HttpService ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.infrastructure.OracleVMSettings <em>Oracle VM Settings</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Oracle VM Settings</em>'.
     * @see org.eclipse.scada.configuration.infrastructure.OracleVMSettings
     * @generated
     */
    EClass getOracleVMSettings ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.infrastructure.OracleVMSettings#getInitialHeapSize <em>Initial Heap Size</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Initial Heap Size</em>'.
     * @see org.eclipse.scada.configuration.infrastructure.OracleVMSettings#getInitialHeapSize()
     * @see #getOracleVMSettings()
     * @generated
     */
    EAttribute getOracleVMSettings_InitialHeapSize ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.infrastructure.OracleVMSettings#getMaximumHeapSize <em>Maximum Heap Size</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Maximum Heap Size</em>'.
     * @see org.eclipse.scada.configuration.infrastructure.OracleVMSettings#getMaximumHeapSize()
     * @see #getOracleVMSettings()
     * @generated
     */
    EAttribute getOracleVMSettings_MaximumHeapSize ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.infrastructure.GenericVMSettings <em>Generic VM Settings</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Generic VM Settings</em>'.
     * @see org.eclipse.scada.configuration.infrastructure.GenericVMSettings
     * @generated
     */
    EClass getGenericVMSettings ();

    /**
     * Returns the meta object for the attribute list '{@link org.eclipse.scada.configuration.infrastructure.GenericVMSettings#getArguments <em>Arguments</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute list '<em>Arguments</em>'.
     * @see org.eclipse.scada.configuration.infrastructure.GenericVMSettings#getArguments()
     * @see #getGenericVMSettings()
     * @generated
     */
    EAttribute getGenericVMSettings_Arguments ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.infrastructure.AbstractEquinoxDriver <em>Abstract Equinox Driver</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Abstract Equinox Driver</em>'.
     * @see org.eclipse.scada.configuration.infrastructure.AbstractEquinoxDriver
     * @generated
     */
    EClass getAbstractEquinoxDriver ();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.scada.configuration.infrastructure.AbstractEquinoxDriver#getAccessCredentials <em>Access Credentials</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Access Credentials</em>'.
     * @see org.eclipse.scada.configuration.infrastructure.AbstractEquinoxDriver#getAccessCredentials()
     * @see #getAbstractEquinoxDriver()
     * @generated
     */
    EReference getAbstractEquinoxDriver_AccessCredentials ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.infrastructure.EquinoxBase <em>Equinox Base</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Equinox Base</em>'.
     * @see org.eclipse.scada.configuration.infrastructure.EquinoxBase
     * @generated
     */
    EClass getEquinoxBase ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.infrastructure.EquinoxBase#getInstanceNumber <em>Instance Number</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Instance Number</em>'.
     * @see org.eclipse.scada.configuration.infrastructure.EquinoxBase#getInstanceNumber()
     * @see #getEquinoxBase()
     * @generated
     */
    EAttribute getEquinoxBase_InstanceNumber ();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.scada.configuration.infrastructure.EquinoxBase#getUserService <em>User Service</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>User Service</em>'.
     * @see org.eclipse.scada.configuration.infrastructure.EquinoxBase#getUserService()
     * @see #getEquinoxBase()
     * @generated
     */
    EReference getEquinoxBase_UserService ();

    /**
     * Returns the meta object for the reference '{@link org.eclipse.scada.configuration.infrastructure.EquinoxBase#getSecurityConfiguration <em>Security Configuration</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Security Configuration</em>'.
     * @see org.eclipse.scada.configuration.infrastructure.EquinoxBase#getSecurityConfiguration()
     * @see #getEquinoxBase()
     * @generated
     */
    EReference getEquinoxBase_SecurityConfiguration ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.infrastructure.AbstractCommonDriver <em>Abstract Common Driver</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Abstract Common Driver</em>'.
     * @see org.eclipse.scada.configuration.infrastructure.AbstractCommonDriver
     * @generated
     */
    EClass getAbstractCommonDriver ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.infrastructure.AbstractCommonDriver#getPortNumber <em>Port Number</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Port Number</em>'.
     * @see org.eclipse.scada.configuration.infrastructure.AbstractCommonDriver#getPortNumber()
     * @see #getAbstractCommonDriver()
     * @generated
     */
    EAttribute getAbstractCommonDriver_PortNumber ();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.scada.configuration.infrastructure.AbstractCommonDriver#getPassword <em>Password</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Password</em>'.
     * @see org.eclipse.scada.configuration.infrastructure.AbstractCommonDriver#getPassword()
     * @see #getAbstractCommonDriver()
     * @generated
     */
    EReference getAbstractCommonDriver_Password ();

    /**
     * Returns the meta object for enum '{@link org.eclipse.scada.configuration.infrastructure.SlaveStorageLayout <em>Slave Storage Layout</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for enum '<em>Slave Storage Layout</em>'.
     * @see org.eclipse.scada.configuration.infrastructure.SlaveStorageLayout
     * @generated
     */
    EEnum getSlaveStorageLayout ();

    /**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
    InfrastructureFactory getInfrastructureFactory ();

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
         * The meta object literal for the '{@link org.eclipse.scada.configuration.infrastructure.impl.WorldImpl <em>World</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.infrastructure.impl.WorldImpl
         * @see org.eclipse.scada.configuration.infrastructure.impl.InfrastructurePackageImpl#getWorld()
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
         * The meta object literal for the '<em><b>Default Security Configuration</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference WORLD__DEFAULT_SECURITY_CONFIGURATION = eINSTANCE.getWorld_DefaultSecurityConfiguration ();

        /**
         * The meta object literal for the '<em><b>Default Master Handler Priorities</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference WORLD__DEFAULT_MASTER_HANDLER_PRIORITIES = eINSTANCE.getWorld_DefaultMasterHandlerPriorities ();

        /**
         * The meta object literal for the '<em><b>Default Credentials</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference WORLD__DEFAULT_CREDENTIALS = eINSTANCE.getWorld_DefaultCredentials ();

        /**
         * The meta object literal for the '<em><b>Default Master Customization Profile</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference WORLD__DEFAULT_MASTER_CUSTOMIZATION_PROFILE = eINSTANCE.getWorld_DefaultMasterCustomizationProfile ();

        /**
         * The meta object literal for the '<em><b>Default Value Archive Customization Profile</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference WORLD__DEFAULT_VALUE_ARCHIVE_CUSTOMIZATION_PROFILE = eINSTANCE.getWorld_DefaultValueArchiveCustomizationProfile ();

        /**
         * The meta object literal for the '<em><b>Default Driver Password</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference WORLD__DEFAULT_DRIVER_PASSWORD = eINSTANCE.getWorld_DefaultDriverPassword ();

        /**
         * The meta object literal for the '<em><b>Application Configurations</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference WORLD__APPLICATION_CONFIGURATIONS = eINSTANCE.getWorld_ApplicationConfigurations ();

        /**
         * The meta object literal for the '<em><b>Default Driver Access Credentials</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference WORLD__DEFAULT_DRIVER_ACCESS_CREDENTIALS = eINSTANCE.getWorld_DefaultDriverAccessCredentials ();

        /**
         * The meta object literal for the '<em><b>Configurations</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference WORLD__CONFIGURATIONS = eINSTANCE.getWorld_Configurations ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.infrastructure.impl.NodeImpl <em>Node</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.infrastructure.impl.NodeImpl
         * @see org.eclipse.scada.configuration.infrastructure.impl.InfrastructurePackageImpl#getNode()
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
         * The meta object literal for the '<em><b>Devices</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference NODE__DEVICES = eINSTANCE.getNode_Devices ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.infrastructure.impl.MasterServerImpl <em>Master Server</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.infrastructure.impl.MasterServerImpl
         * @see org.eclipse.scada.configuration.infrastructure.impl.InfrastructurePackageImpl#getMasterServer()
         * @generated
         */
        EClass MASTER_SERVER = eINSTANCE.getMasterServer ();

        /**
         * The meta object literal for the '<em><b>Authoratives</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference MASTER_SERVER__AUTHORATIVES = eINSTANCE.getMasterServer_Authoratives ();

        /**
         * The meta object literal for the '<em><b>Import Master</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference MASTER_SERVER__IMPORT_MASTER = eINSTANCE.getMasterServer_ImportMaster ();

        /**
         * The meta object literal for the '<em><b>Driver</b></em>' reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference MASTER_SERVER__DRIVER = eINSTANCE.getMasterServer_Driver ();

        /**
         * The meta object literal for the '<em><b>Archive To</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference MASTER_SERVER__ARCHIVE_TO = eINSTANCE.getMasterServer_ArchiveTo ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.infrastructure.impl.MasterImportImpl <em>Master Import</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.infrastructure.impl.MasterImportImpl
         * @see org.eclipse.scada.configuration.infrastructure.impl.InfrastructurePackageImpl#getMasterImport()
         * @generated
         */
        EClass MASTER_IMPORT = eINSTANCE.getMasterImport ();

        /**
         * The meta object literal for the '<em><b>Imported Master</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference MASTER_IMPORT__IMPORTED_MASTER = eINSTANCE.getMasterImport_ImportedMaster ();

        /**
         * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute MASTER_IMPORT__ID = eINSTANCE.getMasterImport_Id ();

        /**
         * The meta object literal for the '<em><b>Credentials</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference MASTER_IMPORT__CREDENTIALS = eINSTANCE.getMasterImport_Credentials ();

        /**
         * The meta object literal for the '<em><b>Master</b></em>' container reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference MASTER_IMPORT__MASTER = eINSTANCE.getMasterImport_Master ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.infrastructure.impl.OptionsImpl <em>Options</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.infrastructure.impl.OptionsImpl
         * @see org.eclipse.scada.configuration.infrastructure.impl.InfrastructurePackageImpl#getOptions()
         * @generated
         */
        EClass OPTIONS = eINSTANCE.getOptions ();

        /**
         * The meta object literal for the '<em><b>Base Da Ngp Port</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute OPTIONS__BASE_DA_NGP_PORT = eINSTANCE.getOptions_BaseDaNgpPort ();

        /**
         * The meta object literal for the '<em><b>Base Ae Ngp Port</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute OPTIONS__BASE_AE_NGP_PORT = eINSTANCE.getOptions_BaseAeNgpPort ();

        /**
         * The meta object literal for the '<em><b>Base Ca Ngp Port</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute OPTIONS__BASE_CA_NGP_PORT = eINSTANCE.getOptions_BaseCaNgpPort ();

        /**
         * The meta object literal for the '<em><b>Base Hd Ngp Port</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute OPTIONS__BASE_HD_NGP_PORT = eINSTANCE.getOptions_BaseHdNgpPort ();

        /**
         * The meta object literal for the '<em><b>Monitor Pools</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference OPTIONS__MONITOR_POOLS = eINSTANCE.getOptions_MonitorPools ();

        /**
         * The meta object literal for the '<em><b>Event Pools</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference OPTIONS__EVENT_POOLS = eINSTANCE.getOptions_EventPools ();

        /**
         * The meta object literal for the '<em><b>Default User Service</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference OPTIONS__DEFAULT_USER_SERVICE = eINSTANCE.getOptions_DefaultUserService ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.infrastructure.impl.EquinoxApplicationImpl <em>Equinox Application</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.infrastructure.impl.EquinoxApplicationImpl
         * @see org.eclipse.scada.configuration.infrastructure.impl.InfrastructurePackageImpl#getEquinoxApplication()
         * @generated
         */
        EClass EQUINOX_APPLICATION = eINSTANCE.getEquinoxApplication ();

        /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EQUINOX_APPLICATION__NAME = eINSTANCE.getEquinoxApplication_Name ();

        /**
         * The meta object literal for the '<em><b>Instance Number</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EQUINOX_APPLICATION__INSTANCE_NUMBER = eINSTANCE.getEquinoxApplication_InstanceNumber ();

        /**
         * The meta object literal for the '<em><b>Configurations</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference EQUINOX_APPLICATION__CONFIGURATIONS = eINSTANCE.getEquinoxApplication_Configurations ();

        /**
         * The meta object literal for the '<em><b>Configuration</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference EQUINOX_APPLICATION__CONFIGURATION = eINSTANCE.getEquinoxApplication_Configuration ();

        /**
         * The meta object literal for the '<em><b>Local Credentials</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference EQUINOX_APPLICATION__LOCAL_CREDENTIALS = eINSTANCE.getEquinoxApplication_LocalCredentials ();

        /**
         * The meta object literal for the '<em><b>Security Configuration</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference EQUINOX_APPLICATION__SECURITY_CONFIGURATION = eINSTANCE.getEquinoxApplication_SecurityConfiguration ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.infrastructure.impl.CommonDriverImpl <em>Common Driver</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.infrastructure.impl.CommonDriverImpl
         * @see org.eclipse.scada.configuration.infrastructure.impl.InfrastructurePackageImpl#getCommonDriver()
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
         * The meta object literal for the '<em><b>Port Number</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute COMMON_DRIVER__PORT_NUMBER = eINSTANCE.getCommonDriver_PortNumber ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.infrastructure.impl.ExternalNodeImpl <em>External Node</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.infrastructure.impl.ExternalNodeImpl
         * @see org.eclipse.scada.configuration.infrastructure.impl.InfrastructurePackageImpl#getExternalNode()
         * @generated
         */
        EClass EXTERNAL_NODE = eINSTANCE.getExternalNode ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.infrastructure.impl.SystemNodeImpl <em>System Node</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.infrastructure.impl.SystemNodeImpl
         * @see org.eclipse.scada.configuration.infrastructure.impl.InfrastructurePackageImpl#getSystemNode()
         * @generated
         */
        EClass SYSTEM_NODE = eINSTANCE.getSystemNode ();

        /**
         * The meta object literal for the '<em><b>Deployment</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference SYSTEM_NODE__DEPLOYMENT = eINSTANCE.getSystemNode_Deployment ();

        /**
         * The meta object literal for the '<em><b>Drivers</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference SYSTEM_NODE__DRIVERS = eINSTANCE.getSystemNode_Drivers ();

        /**
         * The meta object literal for the '<em><b>Masters</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference SYSTEM_NODE__MASTERS = eINSTANCE.getSystemNode_Masters ();

        /**
         * The meta object literal for the '<em><b>Value Archives</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference SYSTEM_NODE__VALUE_ARCHIVES = eINSTANCE.getSystemNode_ValueArchives ();

        /**
         * The meta object literal for the '<em><b>Applications</b></em>' attribute list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SYSTEM_NODE__APPLICATIONS = eINSTANCE.getSystemNode_Applications ();

        /**
         * The meta object literal for the '<em><b>Services</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference SYSTEM_NODE__SERVICES = eINSTANCE.getSystemNode_Services ();

        /**
         * The meta object literal for the '<em><b>Value Slaves</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference SYSTEM_NODE__VALUE_SLAVES = eINSTANCE.getSystemNode_ValueSlaves ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.infrastructure.impl.SystemPropertyUserServiceImpl <em>System Property User Service</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.infrastructure.impl.SystemPropertyUserServiceImpl
         * @see org.eclipse.scada.configuration.infrastructure.impl.InfrastructurePackageImpl#getSystemPropertyUserService()
         * @generated
         */
        EClass SYSTEM_PROPERTY_USER_SERVICE = eINSTANCE.getSystemPropertyUserService ();

        /**
         * The meta object literal for the '<em><b>Users</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference SYSTEM_PROPERTY_USER_SERVICE__USERS = eINSTANCE.getSystemPropertyUserService_Users ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.infrastructure.impl.UserEntryImpl <em>User Entry</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.infrastructure.impl.UserEntryImpl
         * @see org.eclipse.scada.configuration.infrastructure.impl.InfrastructurePackageImpl#getUserEntry()
         * @generated
         */
        EClass USER_ENTRY = eINSTANCE.getUserEntry ();

        /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute USER_ENTRY__NAME = eINSTANCE.getUserEntry_Name ();

        /**
         * The meta object literal for the '<em><b>Password</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute USER_ENTRY__PASSWORD = eINSTANCE.getUserEntry_Password ();

        /**
         * The meta object literal for the '<em><b>Roles</b></em>' attribute list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute USER_ENTRY__ROLES = eINSTANCE.getUserEntry_Roles ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.infrastructure.UserService <em>User Service</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.infrastructure.UserService
         * @see org.eclipse.scada.configuration.infrastructure.impl.InfrastructurePackageImpl#getUserService()
         * @generated
         */
        EClass USER_SERVICE = eINSTANCE.getUserService ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.infrastructure.impl.JdbcUserServiceImpl <em>Jdbc User Service</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.infrastructure.impl.JdbcUserServiceImpl
         * @see org.eclipse.scada.configuration.infrastructure.impl.InfrastructurePackageImpl#getJdbcUserService()
         * @generated
         */
        EClass JDBC_USER_SERVICE = eINSTANCE.getJdbcUserService ();

        /**
         * The meta object literal for the '<em><b>Implementation</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference JDBC_USER_SERVICE__IMPLEMENTATION = eINSTANCE.getJdbcUserService_Implementation ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.infrastructure.impl.ValueArchiveServerImpl <em>Value Archive Server</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.infrastructure.impl.ValueArchiveServerImpl
         * @see org.eclipse.scada.configuration.infrastructure.impl.InfrastructurePackageImpl#getValueArchiveServer()
         * @generated
         */
        EClass VALUE_ARCHIVE_SERVER = eINSTANCE.getValueArchiveServer ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.infrastructure.impl.AbstractFactoryDriverImpl <em>Abstract Factory Driver</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.infrastructure.impl.AbstractFactoryDriverImpl
         * @see org.eclipse.scada.configuration.infrastructure.impl.InfrastructurePackageImpl#getAbstractFactoryDriver()
         * @generated
         */
        EClass ABSTRACT_FACTORY_DRIVER = eINSTANCE.getAbstractFactoryDriver ();

        /**
         * The meta object literal for the '<em><b>Driver Type Id</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute ABSTRACT_FACTORY_DRIVER__DRIVER_TYPE_ID = eINSTANCE.getAbstractFactoryDriver_DriverTypeId ();

        /**
         * The meta object literal for the '<em><b>Devices</b></em>' reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference ABSTRACT_FACTORY_DRIVER__DEVICES = eINSTANCE.getAbstractFactoryDriver_Devices ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.infrastructure.Device <em>Device</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.infrastructure.Device
         * @see org.eclipse.scada.configuration.infrastructure.impl.InfrastructurePackageImpl#getDevice()
         * @generated
         */
        EClass DEVICE = eINSTANCE.getDevice ();

        /**
         * The meta object literal for the '<em><b>Node</b></em>' container reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference DEVICE__NODE = eINSTANCE.getDevice_Node ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.infrastructure.impl.EquinoxDriverImpl <em>Equinox Driver</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.infrastructure.impl.EquinoxDriverImpl
         * @see org.eclipse.scada.configuration.infrastructure.impl.InfrastructurePackageImpl#getEquinoxDriver()
         * @generated
         */
        EClass EQUINOX_DRIVER = eINSTANCE.getEquinoxDriver ();

        /**
         * The meta object literal for the '<em><b>Access Credentials</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference EQUINOX_DRIVER__ACCESS_CREDENTIALS = eINSTANCE.getEquinoxDriver_AccessCredentials ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.infrastructure.impl.ExternalDriverImpl <em>External Driver</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.infrastructure.impl.ExternalDriverImpl
         * @see org.eclipse.scada.configuration.infrastructure.impl.InfrastructurePackageImpl#getExternalDriver()
         * @generated
         */
        EClass EXTERNAL_DRIVER = eINSTANCE.getExternalDriver ();

        /**
         * The meta object literal for the '<em><b>Port Number</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EXTERNAL_DRIVER__PORT_NUMBER = eINSTANCE.getExternalDriver_PortNumber ();

        /**
         * The meta object literal for the '<em><b>Access Credentials</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference EXTERNAL_DRIVER__ACCESS_CREDENTIALS = eINSTANCE.getExternalDriver_AccessCredentials ();

        /**
         * The meta object literal for the '<em><b>Binding</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EXTERNAL_DRIVER__BINDING = eINSTANCE.getExternalDriver_Binding ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.infrastructure.impl.DriverImpl <em>Driver</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.infrastructure.impl.DriverImpl
         * @see org.eclipse.scada.configuration.infrastructure.impl.InfrastructurePackageImpl#getDriver()
         * @generated
         */
        EClass DRIVER = eINSTANCE.getDriver ();

        /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute DRIVER__NAME = eINSTANCE.getDriver_Name ();

        /**
         * The meta object literal for the '<em><b>Node</b></em>' container reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference DRIVER__NODE = eINSTANCE.getDriver_Node ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.infrastructure.impl.ExternalDriverPlaceholderImpl <em>External Driver Placeholder</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.infrastructure.impl.ExternalDriverPlaceholderImpl
         * @see org.eclipse.scada.configuration.infrastructure.impl.InfrastructurePackageImpl#getExternalDriverPlaceholder()
         * @generated
         */
        EClass EXTERNAL_DRIVER_PLACEHOLDER = eINSTANCE.getExternalDriverPlaceholder ();

        /**
         * The meta object literal for the '<em><b>Endpoints</b></em>' reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference EXTERNAL_DRIVER_PLACEHOLDER__ENDPOINTS = eINSTANCE.getExternalDriverPlaceholder_Endpoints ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.infrastructure.impl.ApplicationConfigurationImpl <em>Application Configuration</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.infrastructure.impl.ApplicationConfigurationImpl
         * @see org.eclipse.scada.configuration.infrastructure.impl.InfrastructurePackageImpl#getApplicationConfiguration()
         * @generated
         */
        EClass APPLICATION_CONFIGURATION = eINSTANCE.getApplicationConfiguration ();

        /**
         * The meta object literal for the '<em><b>Modules</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference APPLICATION_CONFIGURATION__MODULES = eINSTANCE.getApplicationConfiguration_Modules ();

        /**
         * The meta object literal for the '<em><b>Configurations</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference APPLICATION_CONFIGURATION__CONFIGURATIONS = eINSTANCE.getApplicationConfiguration_Configurations ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.infrastructure.impl.ConfigurationsImpl <em>Configurations</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.infrastructure.impl.ConfigurationsImpl
         * @see org.eclipse.scada.configuration.infrastructure.impl.InfrastructurePackageImpl#getConfigurations()
         * @generated
         */
        EClass CONFIGURATIONS = eINSTANCE.getConfigurations ();

        /**
         * The meta object literal for the '<em><b>Configurations</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference CONFIGURATIONS__CONFIGURATIONS = eINSTANCE.getConfigurations_Configurations ();

        /**
         * The meta object literal for the '<em><b>Settings</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference CONFIGURATIONS__SETTINGS = eINSTANCE.getConfigurations_Settings ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.infrastructure.Module <em>Module</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.infrastructure.Module
         * @see org.eclipse.scada.configuration.infrastructure.impl.InfrastructurePackageImpl#getModule()
         * @generated
         */
        EClass MODULE = eINSTANCE.getModule ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.infrastructure.impl.HttpServiceModuleImpl <em>Http Service Module</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.infrastructure.impl.HttpServiceModuleImpl
         * @see org.eclipse.scada.configuration.infrastructure.impl.InfrastructurePackageImpl#getHttpServiceModule()
         * @generated
         */
        EClass HTTP_SERVICE_MODULE = eINSTANCE.getHttpServiceModule ();

        /**
         * The meta object literal for the '<em><b>Port</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute HTTP_SERVICE_MODULE__PORT = eINSTANCE.getHttpServiceModule_Port ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.infrastructure.impl.RestExporterModuleImpl <em>Rest Exporter Module</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.infrastructure.impl.RestExporterModuleImpl
         * @see org.eclipse.scada.configuration.infrastructure.impl.InfrastructurePackageImpl#getRestExporterModule()
         * @generated
         */
        EClass REST_EXPORTER_MODULE = eINSTANCE.getRestExporterModule ();

        /**
         * The meta object literal for the '<em><b>Context Id</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute REST_EXPORTER_MODULE__CONTEXT_ID = eINSTANCE.getRestExporterModule_ContextId ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.infrastructure.impl.ValueArchiveSlaveImpl <em>Value Archive Slave</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.infrastructure.impl.ValueArchiveSlaveImpl
         * @see org.eclipse.scada.configuration.infrastructure.impl.InfrastructurePackageImpl#getValueArchiveSlave()
         * @generated
         */
        EClass VALUE_ARCHIVE_SLAVE = eINSTANCE.getValueArchiveSlave ();

        /**
         * The meta object literal for the '<em><b>Storage Path</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute VALUE_ARCHIVE_SLAVE__STORAGE_PATH = eINSTANCE.getValueArchiveSlave_StoragePath ();

        /**
         * The meta object literal for the '<em><b>Storage Layout</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute VALUE_ARCHIVE_SLAVE__STORAGE_LAYOUT = eINSTANCE.getValueArchiveSlave_StorageLayout ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.infrastructure.impl.WebAdminConsoleImpl <em>Web Admin Console</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.infrastructure.impl.WebAdminConsoleImpl
         * @see org.eclipse.scada.configuration.infrastructure.impl.InfrastructurePackageImpl#getWebAdminConsole()
         * @generated
         */
        EClass WEB_ADMIN_CONSOLE = eINSTANCE.getWebAdminConsole ();

        /**
         * The meta object literal for the '<em><b>Http Service</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference WEB_ADMIN_CONSOLE__HTTP_SERVICE = eINSTANCE.getWebAdminConsole_HttpService ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.infrastructure.impl.OracleVMSettingsImpl <em>Oracle VM Settings</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.infrastructure.impl.OracleVMSettingsImpl
         * @see org.eclipse.scada.configuration.infrastructure.impl.InfrastructurePackageImpl#getOracleVMSettings()
         * @generated
         */
        EClass ORACLE_VM_SETTINGS = eINSTANCE.getOracleVMSettings ();

        /**
         * The meta object literal for the '<em><b>Initial Heap Size</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute ORACLE_VM_SETTINGS__INITIAL_HEAP_SIZE = eINSTANCE.getOracleVMSettings_InitialHeapSize ();

        /**
         * The meta object literal for the '<em><b>Maximum Heap Size</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute ORACLE_VM_SETTINGS__MAXIMUM_HEAP_SIZE = eINSTANCE.getOracleVMSettings_MaximumHeapSize ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.infrastructure.impl.GenericVMSettingsImpl <em>Generic VM Settings</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.infrastructure.impl.GenericVMSettingsImpl
         * @see org.eclipse.scada.configuration.infrastructure.impl.InfrastructurePackageImpl#getGenericVMSettings()
         * @generated
         */
        EClass GENERIC_VM_SETTINGS = eINSTANCE.getGenericVMSettings ();

        /**
         * The meta object literal for the '<em><b>Arguments</b></em>' attribute list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute GENERIC_VM_SETTINGS__ARGUMENTS = eINSTANCE.getGenericVMSettings_Arguments ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.infrastructure.impl.AbstractEquinoxDriverImpl <em>Abstract Equinox Driver</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.infrastructure.impl.AbstractEquinoxDriverImpl
         * @see org.eclipse.scada.configuration.infrastructure.impl.InfrastructurePackageImpl#getAbstractEquinoxDriver()
         * @generated
         */
        EClass ABSTRACT_EQUINOX_DRIVER = eINSTANCE.getAbstractEquinoxDriver ();

        /**
         * The meta object literal for the '<em><b>Access Credentials</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference ABSTRACT_EQUINOX_DRIVER__ACCESS_CREDENTIALS = eINSTANCE.getAbstractEquinoxDriver_AccessCredentials ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.infrastructure.EquinoxBase <em>Equinox Base</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.infrastructure.EquinoxBase
         * @see org.eclipse.scada.configuration.infrastructure.impl.InfrastructurePackageImpl#getEquinoxBase()
         * @generated
         */
        EClass EQUINOX_BASE = eINSTANCE.getEquinoxBase ();

        /**
         * The meta object literal for the '<em><b>Instance Number</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EQUINOX_BASE__INSTANCE_NUMBER = eINSTANCE.getEquinoxBase_InstanceNumber ();

        /**
         * The meta object literal for the '<em><b>User Service</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference EQUINOX_BASE__USER_SERVICE = eINSTANCE.getEquinoxBase_UserService ();

        /**
         * The meta object literal for the '<em><b>Security Configuration</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference EQUINOX_BASE__SECURITY_CONFIGURATION = eINSTANCE.getEquinoxBase_SecurityConfiguration ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.infrastructure.impl.AbstractCommonDriverImpl <em>Abstract Common Driver</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.infrastructure.impl.AbstractCommonDriverImpl
         * @see org.eclipse.scada.configuration.infrastructure.impl.InfrastructurePackageImpl#getAbstractCommonDriver()
         * @generated
         */
        EClass ABSTRACT_COMMON_DRIVER = eINSTANCE.getAbstractCommonDriver ();

        /**
         * The meta object literal for the '<em><b>Port Number</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute ABSTRACT_COMMON_DRIVER__PORT_NUMBER = eINSTANCE.getAbstractCommonDriver_PortNumber ();

        /**
         * The meta object literal for the '<em><b>Password</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference ABSTRACT_COMMON_DRIVER__PASSWORD = eINSTANCE.getAbstractCommonDriver_Password ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.infrastructure.SlaveStorageLayout <em>Slave Storage Layout</em>}' enum.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.infrastructure.SlaveStorageLayout
         * @see org.eclipse.scada.configuration.infrastructure.impl.InfrastructurePackageImpl#getSlaveStorageLayout()
         * @generated
         */
        EEnum SLAVE_STORAGE_LAYOUT = eINSTANCE.getSlaveStorageLayout ();

    }

} //InfrastructurePackage
