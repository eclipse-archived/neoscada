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
package org.eclipse.scada.configuration.component;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
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
 * @see org.eclipse.scada.configuration.component.ComponentFactory
 * @model kind="package"
 * @generated
 */
public interface ComponentPackage extends EPackage
{
    /**
     * The package name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNAME = "component"; //$NON-NLS-1$

    /**
     * The package namespace URI.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_URI = "http://eclipse.org/SCADA/Configuration/Component"; //$NON-NLS-1$

    /**
     * The package namespace name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_PREFIX = "component"; //$NON-NLS-1$

    /**
     * The package content type ID.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eCONTENT_TYPE = "org.eclipse.scada.configuration.component"; //$NON-NLS-1$

    /**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    ComponentPackage eINSTANCE = org.eclipse.scada.configuration.component.impl.ComponentPackageImpl.init ();

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.component.impl.ContainerImpl <em>Container</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.component.impl.ContainerImpl
     * @see org.eclipse.scada.configuration.component.impl.ComponentPackageImpl#getContainer()
     * @generated
     */
    int CONTAINER = 33;

    /**
     * The feature id for the '<em><b>Item Interceptors</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONTAINER__ITEM_INTERCEPTORS = 0;

    /**
     * The number of structural features of the '<em>Container</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONTAINER_FEATURE_COUNT = 1;

    /**
     * The number of operations of the '<em>Container</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONTAINER_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.component.impl.ComponentWorldImpl <em>World</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.component.impl.ComponentWorldImpl
     * @see org.eclipse.scada.configuration.component.impl.ComponentPackageImpl#getComponentWorld()
     * @generated
     */
    int COMPONENT_WORLD = 0;

    /**
     * The feature id for the '<em><b>Item Interceptors</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COMPONENT_WORLD__ITEM_INTERCEPTORS = CONTAINER__ITEM_INTERCEPTORS;

    /**
     * The feature id for the '<em><b>Levels</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COMPONENT_WORLD__LEVELS = CONTAINER_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Configurations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COMPONENT_WORLD__CONFIGURATIONS = CONTAINER_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Services</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COMPONENT_WORLD__SERVICES = CONTAINER_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Infrastructure</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COMPONENT_WORLD__INFRASTRUCTURE = CONTAINER_FEATURE_COUNT + 3;

    /**
     * The feature id for the '<em><b>Default Customization Pipeline</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COMPONENT_WORLD__DEFAULT_CUSTOMIZATION_PIPELINE = CONTAINER_FEATURE_COUNT + 4;

    /**
     * The feature id for the '<em><b>Default Archive Selector</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COMPONENT_WORLD__DEFAULT_ARCHIVE_SELECTOR = CONTAINER_FEATURE_COUNT + 5;

    /**
     * The number of structural features of the '<em>World</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COMPONENT_WORLD_FEATURE_COUNT = CONTAINER_FEATURE_COUNT + 6;

    /**
     * The number of operations of the '<em>World</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COMPONENT_WORLD_OPERATION_COUNT = CONTAINER_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.component.impl.LevelImpl <em>Level</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.component.impl.LevelImpl
     * @see org.eclipse.scada.configuration.component.impl.ComponentPackageImpl#getLevel()
     * @generated
     */
    int LEVEL = 1;

    /**
     * The feature id for the '<em><b>Item Interceptors</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LEVEL__ITEM_INTERCEPTORS = CONTAINER__ITEM_INTERCEPTORS;

    /**
     * The feature id for the '<em><b>Components</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LEVEL__COMPONENTS = CONTAINER_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Levels</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LEVEL__LEVELS = CONTAINER_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Parent</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LEVEL__PARENT = CONTAINER_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Customization Pipeline</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LEVEL__CUSTOMIZATION_PIPELINE = CONTAINER_FEATURE_COUNT + 3;

    /**
     * The feature id for the '<em><b>Archive Selector</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LEVEL__ARCHIVE_SELECTOR = CONTAINER_FEATURE_COUNT + 4;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LEVEL__NAME = CONTAINER_FEATURE_COUNT + 5;

    /**
     * The number of structural features of the '<em>Level</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LEVEL_FEATURE_COUNT = CONTAINER_FEATURE_COUNT + 6;

    /**
     * The number of operations of the '<em>Level</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LEVEL_OPERATION_COUNT = CONTAINER_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.component.impl.ComponentImpl <em>Component</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.component.impl.ComponentImpl
     * @see org.eclipse.scada.configuration.component.impl.ComponentPackageImpl#getComponent()
     * @generated
     */
    int COMPONENT = 2;

    /**
     * The feature id for the '<em><b>Level</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COMPONENT__LEVEL = 0;

    /**
     * The feature id for the '<em><b>Customization Pipeline</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COMPONENT__CUSTOMIZATION_PIPELINE = 1;

    /**
     * The feature id for the '<em><b>Archive Selector</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COMPONENT__ARCHIVE_SELECTOR = 2;

    /**
     * The number of structural features of the '<em>Component</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COMPONENT_FEATURE_COUNT = 3;

    /**
     * The number of operations of the '<em>Component</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COMPONENT_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.component.impl.DataComponentImpl <em>Data Component</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.component.impl.DataComponentImpl
     * @see org.eclipse.scada.configuration.component.impl.ComponentPackageImpl#getDataComponent()
     * @generated
     */
    int DATA_COMPONENT = 3;

    /**
     * The feature id for the '<em><b>Level</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATA_COMPONENT__LEVEL = COMPONENT__LEVEL;

    /**
     * The feature id for the '<em><b>Customization Pipeline</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATA_COMPONENT__CUSTOMIZATION_PIPELINE = COMPONENT__CUSTOMIZATION_PIPELINE;

    /**
     * The feature id for the '<em><b>Archive Selector</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATA_COMPONENT__ARCHIVE_SELECTOR = COMPONENT__ARCHIVE_SELECTOR;

    /**
     * The number of structural features of the '<em>Data Component</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATA_COMPONENT_FEATURE_COUNT = COMPONENT_FEATURE_COUNT + 0;

    /**
     * The operation id for the '<em>Get Master On</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATA_COMPONENT___GET_MASTER_ON = COMPONENT_OPERATION_COUNT + 0;

    /**
     * The number of operations of the '<em>Data Component</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATA_COMPONENT_OPERATION_COUNT = COMPONENT_OPERATION_COUNT + 1;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.component.impl.ConfigurationImpl <em>Configuration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.component.impl.ConfigurationImpl
     * @see org.eclipse.scada.configuration.component.impl.ComponentPackageImpl#getConfiguration()
     * @generated
     */
    int CONFIGURATION = 4;

    /**
     * The number of structural features of the '<em>Configuration</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONFIGURATION_FEATURE_COUNT = 0;

    /**
     * The number of operations of the '<em>Configuration</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONFIGURATION_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.component.impl.MasterComponentImpl <em>Master Component</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.component.impl.MasterComponentImpl
     * @see org.eclipse.scada.configuration.component.impl.ComponentPackageImpl#getMasterComponent()
     * @generated
     */
    int MASTER_COMPONENT = 37;

    /**
     * The feature id for the '<em><b>Level</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MASTER_COMPONENT__LEVEL = DATA_COMPONENT__LEVEL;

    /**
     * The feature id for the '<em><b>Customization Pipeline</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MASTER_COMPONENT__CUSTOMIZATION_PIPELINE = DATA_COMPONENT__CUSTOMIZATION_PIPELINE;

    /**
     * The feature id for the '<em><b>Archive Selector</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MASTER_COMPONENT__ARCHIVE_SELECTOR = DATA_COMPONENT__ARCHIVE_SELECTOR;

    /**
     * The feature id for the '<em><b>Master On</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MASTER_COMPONENT__MASTER_ON = DATA_COMPONENT_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Master Component</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MASTER_COMPONENT_FEATURE_COUNT = DATA_COMPONENT_FEATURE_COUNT + 1;

    /**
     * The operation id for the '<em>Get Master On</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MASTER_COMPONENT___GET_MASTER_ON = DATA_COMPONENT___GET_MASTER_ON;

    /**
     * The number of operations of the '<em>Master Component</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MASTER_COMPONENT_OPERATION_COUNT = DATA_COMPONENT_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.component.impl.SingleValueImpl <em>Single Value</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.component.impl.SingleValueImpl
     * @see org.eclipse.scada.configuration.component.impl.ComponentPackageImpl#getSingleValue()
     * @generated
     */
    int SINGLE_VALUE = 11;

    /**
     * The feature id for the '<em><b>Level</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SINGLE_VALUE__LEVEL = MASTER_COMPONENT__LEVEL;

    /**
     * The feature id for the '<em><b>Customization Pipeline</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SINGLE_VALUE__CUSTOMIZATION_PIPELINE = MASTER_COMPONENT__CUSTOMIZATION_PIPELINE;

    /**
     * The feature id for the '<em><b>Archive Selector</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SINGLE_VALUE__ARCHIVE_SELECTOR = MASTER_COMPONENT__ARCHIVE_SELECTOR;

    /**
     * The feature id for the '<em><b>Master On</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SINGLE_VALUE__MASTER_ON = MASTER_COMPONENT__MASTER_ON;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SINGLE_VALUE__NAME = MASTER_COMPONENT_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Data Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SINGLE_VALUE__DATA_TYPE = MASTER_COMPONENT_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Customization Tags</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SINGLE_VALUE__CUSTOMIZATION_TAGS = MASTER_COMPONENT_FEATURE_COUNT + 2;

    /**
     * The number of structural features of the '<em>Single Value</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SINGLE_VALUE_FEATURE_COUNT = MASTER_COMPONENT_FEATURE_COUNT + 3;

    /**
     * The operation id for the '<em>Get Master On</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SINGLE_VALUE___GET_MASTER_ON = MASTER_COMPONENT___GET_MASTER_ON;

    /**
     * The number of operations of the '<em>Single Value</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SINGLE_VALUE_OPERATION_COUNT = MASTER_COMPONENT_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.component.impl.ConstantValueImpl <em>Constant Value</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.component.impl.ConstantValueImpl
     * @see org.eclipse.scada.configuration.component.impl.ComponentPackageImpl#getConstantValue()
     * @generated
     */
    int CONSTANT_VALUE = 5;

    /**
     * The feature id for the '<em><b>Level</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONSTANT_VALUE__LEVEL = SINGLE_VALUE__LEVEL;

    /**
     * The feature id for the '<em><b>Customization Pipeline</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONSTANT_VALUE__CUSTOMIZATION_PIPELINE = SINGLE_VALUE__CUSTOMIZATION_PIPELINE;

    /**
     * The feature id for the '<em><b>Archive Selector</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONSTANT_VALUE__ARCHIVE_SELECTOR = SINGLE_VALUE__ARCHIVE_SELECTOR;

    /**
     * The feature id for the '<em><b>Master On</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONSTANT_VALUE__MASTER_ON = SINGLE_VALUE__MASTER_ON;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONSTANT_VALUE__NAME = SINGLE_VALUE__NAME;

    /**
     * The feature id for the '<em><b>Data Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONSTANT_VALUE__DATA_TYPE = SINGLE_VALUE__DATA_TYPE;

    /**
     * The feature id for the '<em><b>Customization Tags</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONSTANT_VALUE__CUSTOMIZATION_TAGS = SINGLE_VALUE__CUSTOMIZATION_TAGS;

    /**
     * The feature id for the '<em><b>Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONSTANT_VALUE__VALUE = SINGLE_VALUE_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Constant Value</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONSTANT_VALUE_FEATURE_COUNT = SINGLE_VALUE_FEATURE_COUNT + 1;

    /**
     * The operation id for the '<em>Get Master On</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONSTANT_VALUE___GET_MASTER_ON = SINGLE_VALUE___GET_MASTER_ON;

    /**
     * The number of operations of the '<em>Constant Value</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONSTANT_VALUE_OPERATION_COUNT = SINGLE_VALUE_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.component.impl.MarkerConfigurationImpl <em>Marker Configuration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.component.impl.MarkerConfigurationImpl
     * @see org.eclipse.scada.configuration.component.impl.ComponentPackageImpl#getMarkerConfiguration()
     * @generated
     */
    int MARKER_CONFIGURATION = 6;

    /**
     * The feature id for the '<em><b>Markers</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MARKER_CONFIGURATION__MARKERS = CONFIGURATION_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Marker Configuration</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MARKER_CONFIGURATION_FEATURE_COUNT = CONFIGURATION_FEATURE_COUNT + 1;

    /**
     * The number of operations of the '<em>Marker Configuration</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MARKER_CONFIGURATION_OPERATION_COUNT = CONFIGURATION_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.component.Service <em>Service</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.component.Service
     * @see org.eclipse.scada.configuration.component.impl.ComponentPackageImpl#getService()
     * @generated
     */
    int SERVICE = 7;

    /**
     * The number of structural features of the '<em>Service</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SERVICE_FEATURE_COUNT = 0;

    /**
     * The number of operations of the '<em>Service</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SERVICE_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.component.impl.PersistentValueImpl <em>Persistent Value</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.component.impl.PersistentValueImpl
     * @see org.eclipse.scada.configuration.component.impl.ComponentPackageImpl#getPersistentValue()
     * @generated
     */
    int PERSISTENT_VALUE = 8;

    /**
     * The feature id for the '<em><b>Level</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PERSISTENT_VALUE__LEVEL = SINGLE_VALUE__LEVEL;

    /**
     * The feature id for the '<em><b>Customization Pipeline</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PERSISTENT_VALUE__CUSTOMIZATION_PIPELINE = SINGLE_VALUE__CUSTOMIZATION_PIPELINE;

    /**
     * The feature id for the '<em><b>Archive Selector</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PERSISTENT_VALUE__ARCHIVE_SELECTOR = SINGLE_VALUE__ARCHIVE_SELECTOR;

    /**
     * The feature id for the '<em><b>Master On</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PERSISTENT_VALUE__MASTER_ON = SINGLE_VALUE__MASTER_ON;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PERSISTENT_VALUE__NAME = SINGLE_VALUE__NAME;

    /**
     * The feature id for the '<em><b>Data Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PERSISTENT_VALUE__DATA_TYPE = SINGLE_VALUE__DATA_TYPE;

    /**
     * The feature id for the '<em><b>Customization Tags</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PERSISTENT_VALUE__CUSTOMIZATION_TAGS = SINGLE_VALUE__CUSTOMIZATION_TAGS;

    /**
     * The number of structural features of the '<em>Persistent Value</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PERSISTENT_VALUE_FEATURE_COUNT = SINGLE_VALUE_FEATURE_COUNT + 0;

    /**
     * The operation id for the '<em>Get Master On</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PERSISTENT_VALUE___GET_MASTER_ON = SINGLE_VALUE___GET_MASTER_ON;

    /**
     * The number of operations of the '<em>Persistent Value</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PERSISTENT_VALUE_OPERATION_COUNT = SINGLE_VALUE_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.component.impl.DriverConnectionAnalyzerImpl <em>Driver Connection Analyzer</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.component.impl.DriverConnectionAnalyzerImpl
     * @see org.eclipse.scada.configuration.component.impl.ComponentPackageImpl#getDriverConnectionAnalyzer()
     * @generated
     */
    int DRIVER_CONNECTION_ANALYZER = 9;

    /**
     * The feature id for the '<em><b>Level</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DRIVER_CONNECTION_ANALYZER__LEVEL = MASTER_COMPONENT__LEVEL;

    /**
     * The feature id for the '<em><b>Customization Pipeline</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DRIVER_CONNECTION_ANALYZER__CUSTOMIZATION_PIPELINE = MASTER_COMPONENT__CUSTOMIZATION_PIPELINE;

    /**
     * The feature id for the '<em><b>Archive Selector</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DRIVER_CONNECTION_ANALYZER__ARCHIVE_SELECTOR = MASTER_COMPONENT__ARCHIVE_SELECTOR;

    /**
     * The feature id for the '<em><b>Master On</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DRIVER_CONNECTION_ANALYZER__MASTER_ON = MASTER_COMPONENT__MASTER_ON;

    /**
     * The feature id for the '<em><b>Driver</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DRIVER_CONNECTION_ANALYZER__DRIVER = MASTER_COMPONENT_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Driver Connection Analyzer</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DRIVER_CONNECTION_ANALYZER_FEATURE_COUNT = MASTER_COMPONENT_FEATURE_COUNT + 1;

    /**
     * The operation id for the '<em>Get Master On</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DRIVER_CONNECTION_ANALYZER___GET_MASTER_ON = MASTER_COMPONENT___GET_MASTER_ON;

    /**
     * The number of operations of the '<em>Driver Connection Analyzer</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DRIVER_CONNECTION_ANALYZER_OPERATION_COUNT = MASTER_COMPONENT_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.component.impl.MasterImportConnectionAnalyzerImpl <em>Master Import Connection Analyzer</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.component.impl.MasterImportConnectionAnalyzerImpl
     * @see org.eclipse.scada.configuration.component.impl.ComponentPackageImpl#getMasterImportConnectionAnalyzer()
     * @generated
     */
    int MASTER_IMPORT_CONNECTION_ANALYZER = 10;

    /**
     * The feature id for the '<em><b>Level</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MASTER_IMPORT_CONNECTION_ANALYZER__LEVEL = MASTER_COMPONENT__LEVEL;

    /**
     * The feature id for the '<em><b>Customization Pipeline</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MASTER_IMPORT_CONNECTION_ANALYZER__CUSTOMIZATION_PIPELINE = MASTER_COMPONENT__CUSTOMIZATION_PIPELINE;

    /**
     * The feature id for the '<em><b>Archive Selector</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MASTER_IMPORT_CONNECTION_ANALYZER__ARCHIVE_SELECTOR = MASTER_COMPONENT__ARCHIVE_SELECTOR;

    /**
     * The feature id for the '<em><b>Master On</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MASTER_IMPORT_CONNECTION_ANALYZER__MASTER_ON = MASTER_COMPONENT__MASTER_ON;

    /**
     * The feature id for the '<em><b>Connection</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MASTER_IMPORT_CONNECTION_ANALYZER__CONNECTION = MASTER_COMPONENT_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Master Import Connection Analyzer</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MASTER_IMPORT_CONNECTION_ANALYZER_FEATURE_COUNT = MASTER_COMPONENT_FEATURE_COUNT + 1;

    /**
     * The operation id for the '<em>Get Master On</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MASTER_IMPORT_CONNECTION_ANALYZER___GET_MASTER_ON = MASTER_COMPONENT___GET_MASTER_ON;

    /**
     * The number of operations of the '<em>Master Import Connection Analyzer</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MASTER_IMPORT_CONNECTION_ANALYZER_OPERATION_COUNT = MASTER_COMPONENT_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.component.impl.DataMapperAnalyzerImpl <em>Data Mapper Analyzer</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.component.impl.DataMapperAnalyzerImpl
     * @see org.eclipse.scada.configuration.component.impl.ComponentPackageImpl#getDataMapperAnalyzer()
     * @generated
     */
    int DATA_MAPPER_ANALYZER = 12;

    /**
     * The feature id for the '<em><b>Level</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATA_MAPPER_ANALYZER__LEVEL = MASTER_COMPONENT__LEVEL;

    /**
     * The feature id for the '<em><b>Customization Pipeline</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATA_MAPPER_ANALYZER__CUSTOMIZATION_PIPELINE = MASTER_COMPONENT__CUSTOMIZATION_PIPELINE;

    /**
     * The feature id for the '<em><b>Archive Selector</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATA_MAPPER_ANALYZER__ARCHIVE_SELECTOR = MASTER_COMPONENT__ARCHIVE_SELECTOR;

    /**
     * The feature id for the '<em><b>Master On</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATA_MAPPER_ANALYZER__MASTER_ON = MASTER_COMPONENT__MASTER_ON;

    /**
     * The feature id for the '<em><b>Data Mapper</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATA_MAPPER_ANALYZER__DATA_MAPPER = MASTER_COMPONENT_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Data Mapper Analyzer</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATA_MAPPER_ANALYZER_FEATURE_COUNT = MASTER_COMPONENT_FEATURE_COUNT + 1;

    /**
     * The operation id for the '<em>Get Master On</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATA_MAPPER_ANALYZER___GET_MASTER_ON = MASTER_COMPONENT___GET_MASTER_ON;

    /**
     * The number of operations of the '<em>Data Mapper Analyzer</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATA_MAPPER_ANALYZER_OPERATION_COUNT = MASTER_COMPONENT_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.component.impl.DataMapperServiceImpl <em>Data Mapper Service</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.component.impl.DataMapperServiceImpl
     * @see org.eclipse.scada.configuration.component.impl.ComponentPackageImpl#getDataMapperService()
     * @generated
     */
    int DATA_MAPPER_SERVICE = 13;

    /**
     * The feature id for the '<em><b>Data Mapper</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATA_MAPPER_SERVICE__DATA_MAPPER = SERVICE_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Master On</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATA_MAPPER_SERVICE__MASTER_ON = SERVICE_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Data Mapper Service</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATA_MAPPER_SERVICE_FEATURE_COUNT = SERVICE_FEATURE_COUNT + 2;

    /**
     * The number of operations of the '<em>Data Mapper Service</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATA_MAPPER_SERVICE_OPERATION_COUNT = SERVICE_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.component.impl.MappedSourceValueImpl <em>Mapped Source Value</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.component.impl.MappedSourceValueImpl
     * @see org.eclipse.scada.configuration.component.impl.ComponentPackageImpl#getMappedSourceValue()
     * @generated
     */
    int MAPPED_SOURCE_VALUE = 14;

    /**
     * The feature id for the '<em><b>Short Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MAPPED_SOURCE_VALUE__SHORT_DESCRIPTION = WorldPackage.DOCUMENTABLE__SHORT_DESCRIPTION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MAPPED_SOURCE_VALUE__NAME = WorldPackage.DOCUMENTABLE__NAME;

    /**
     * The feature id for the '<em><b>Level</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MAPPED_SOURCE_VALUE__LEVEL = WorldPackage.DOCUMENTABLE_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Customization Pipeline</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MAPPED_SOURCE_VALUE__CUSTOMIZATION_PIPELINE = WorldPackage.DOCUMENTABLE_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Archive Selector</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MAPPED_SOURCE_VALUE__ARCHIVE_SELECTOR = WorldPackage.DOCUMENTABLE_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Master On</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MAPPED_SOURCE_VALUE__MASTER_ON = WorldPackage.DOCUMENTABLE_FEATURE_COUNT + 3;

    /**
     * The feature id for the '<em><b>Mapper</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MAPPED_SOURCE_VALUE__MAPPER = WorldPackage.DOCUMENTABLE_FEATURE_COUNT + 4;

    /**
     * The feature id for the '<em><b>Input</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MAPPED_SOURCE_VALUE__INPUT = WorldPackage.DOCUMENTABLE_FEATURE_COUNT + 5;

    /**
     * The feature id for the '<em><b>Customization Tags</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MAPPED_SOURCE_VALUE__CUSTOMIZATION_TAGS = WorldPackage.DOCUMENTABLE_FEATURE_COUNT + 6;

    /**
     * The number of structural features of the '<em>Mapped Source Value</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MAPPED_SOURCE_VALUE_FEATURE_COUNT = WorldPackage.DOCUMENTABLE_FEATURE_COUNT + 7;

    /**
     * The operation id for the '<em>Get Master On</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MAPPED_SOURCE_VALUE___GET_MASTER_ON = WorldPackage.DOCUMENTABLE_OPERATION_COUNT + 0;

    /**
     * The number of operations of the '<em>Mapped Source Value</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MAPPED_SOURCE_VALUE_OPERATION_COUNT = WorldPackage.DOCUMENTABLE_OPERATION_COUNT + 1;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.component.impl.CalculationComponentImpl <em>Calculation Component</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.component.impl.CalculationComponentImpl
     * @see org.eclipse.scada.configuration.component.impl.ComponentPackageImpl#getCalculationComponent()
     * @generated
     */
    int CALCULATION_COMPONENT = 15;

    /**
     * The feature id for the '<em><b>Short Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CALCULATION_COMPONENT__SHORT_DESCRIPTION = WorldPackage.DOCUMENTABLE__SHORT_DESCRIPTION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CALCULATION_COMPONENT__NAME = WorldPackage.DOCUMENTABLE__NAME;

    /**
     * The feature id for the '<em><b>Level</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CALCULATION_COMPONENT__LEVEL = WorldPackage.DOCUMENTABLE_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Customization Pipeline</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CALCULATION_COMPONENT__CUSTOMIZATION_PIPELINE = WorldPackage.DOCUMENTABLE_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Archive Selector</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CALCULATION_COMPONENT__ARCHIVE_SELECTOR = WorldPackage.DOCUMENTABLE_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Master On</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CALCULATION_COMPONENT__MASTER_ON = WorldPackage.DOCUMENTABLE_FEATURE_COUNT + 3;

    /**
     * The feature id for the '<em><b>Implementation</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CALCULATION_COMPONENT__IMPLEMENTATION = WorldPackage.DOCUMENTABLE_FEATURE_COUNT + 4;

    /**
     * The feature id for the '<em><b>Outputs</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CALCULATION_COMPONENT__OUTPUTS = WorldPackage.DOCUMENTABLE_FEATURE_COUNT + 5;

    /**
     * The feature id for the '<em><b>Inputs</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CALCULATION_COMPONENT__INPUTS = WorldPackage.DOCUMENTABLE_FEATURE_COUNT + 6;

    /**
     * The number of structural features of the '<em>Calculation Component</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CALCULATION_COMPONENT_FEATURE_COUNT = WorldPackage.DOCUMENTABLE_FEATURE_COUNT + 7;

    /**
     * The operation id for the '<em>Get Master On</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CALCULATION_COMPONENT___GET_MASTER_ON = WorldPackage.DOCUMENTABLE_OPERATION_COUNT + 0;

    /**
     * The number of operations of the '<em>Calculation Component</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CALCULATION_COMPONENT_OPERATION_COUNT = WorldPackage.DOCUMENTABLE_OPERATION_COUNT + 1;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.component.impl.CalculationModuleImpl <em>Calculation Module</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.component.impl.CalculationModuleImpl
     * @see org.eclipse.scada.configuration.component.impl.ComponentPackageImpl#getCalculationModule()
     * @generated
     */
    int CALCULATION_MODULE = 16;

    /**
     * The feature id for the '<em><b>Known Inputs</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CALCULATION_MODULE__KNOWN_INPUTS = SERVICE_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Known Outputs</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CALCULATION_MODULE__KNOWN_OUTPUTS = SERVICE_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Calculation Module</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CALCULATION_MODULE_FEATURE_COUNT = SERVICE_FEATURE_COUNT + 2;

    /**
     * The number of operations of the '<em>Calculation Module</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CALCULATION_MODULE_OPERATION_COUNT = SERVICE_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.component.impl.InputSpecificationImpl <em>Input Specification</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.component.impl.InputSpecificationImpl
     * @see org.eclipse.scada.configuration.component.impl.ComponentPackageImpl#getInputSpecification()
     * @generated
     */
    int INPUT_SPECIFICATION = 17;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INPUT_SPECIFICATION__NAME = 0;

    /**
     * The number of structural features of the '<em>Input Specification</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INPUT_SPECIFICATION_FEATURE_COUNT = 1;

    /**
     * The number of operations of the '<em>Input Specification</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INPUT_SPECIFICATION_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.component.impl.OutputSpecificationImpl <em>Output Specification</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.component.impl.OutputSpecificationImpl
     * @see org.eclipse.scada.configuration.component.impl.ComponentPackageImpl#getOutputSpecification()
     * @generated
     */
    int OUTPUT_SPECIFICATION = 18;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OUTPUT_SPECIFICATION__NAME = 0;

    /**
     * The feature id for the '<em><b>Data Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OUTPUT_SPECIFICATION__DATA_TYPE = 1;

    /**
     * The number of structural features of the '<em>Output Specification</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OUTPUT_SPECIFICATION_FEATURE_COUNT = 2;

    /**
     * The number of operations of the '<em>Output Specification</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OUTPUT_SPECIFICATION_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.component.impl.OutputDefinitionImpl <em>Output Definition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.component.impl.OutputDefinitionImpl
     * @see org.eclipse.scada.configuration.component.impl.ComponentPackageImpl#getOutputDefinition()
     * @generated
     */
    int OUTPUT_DEFINITION = 19;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OUTPUT_DEFINITION__NAME = 0;

    /**
     * The feature id for the '<em><b>Local Tag</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OUTPUT_DEFINITION__LOCAL_TAG = 1;

    /**
     * The feature id for the '<em><b>Customization Tags</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OUTPUT_DEFINITION__CUSTOMIZATION_TAGS = 2;

    /**
     * The number of structural features of the '<em>Output Definition</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OUTPUT_DEFINITION_FEATURE_COUNT = 3;

    /**
     * The number of operations of the '<em>Output Definition</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OUTPUT_DEFINITION_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.component.impl.InputDefinitionImpl <em>Input Definition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.component.impl.InputDefinitionImpl
     * @see org.eclipse.scada.configuration.component.impl.ComponentPackageImpl#getInputDefinition()
     * @generated
     */
    int INPUT_DEFINITION = 21;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INPUT_DEFINITION__NAME = 0;

    /**
     * The number of structural features of the '<em>Input Definition</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INPUT_DEFINITION_FEATURE_COUNT = 1;

    /**
     * The operation id for the '<em>Create Reference</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INPUT_DEFINITION___CREATE_REFERENCE = 0;

    /**
     * The number of operations of the '<em>Input Definition</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INPUT_DEFINITION_OPERATION_COUNT = 1;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.component.impl.ItemReferenceInputDefinitionImpl <em>Item Reference Input Definition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.component.impl.ItemReferenceInputDefinitionImpl
     * @see org.eclipse.scada.configuration.component.impl.ComponentPackageImpl#getItemReferenceInputDefinition()
     * @generated
     */
    int ITEM_REFERENCE_INPUT_DEFINITION = 20;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ITEM_REFERENCE_INPUT_DEFINITION__NAME = INPUT_DEFINITION__NAME;

    /**
     * The feature id for the '<em><b>Item Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ITEM_REFERENCE_INPUT_DEFINITION__ITEM_ID = INPUT_DEFINITION_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Item Reference Input Definition</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ITEM_REFERENCE_INPUT_DEFINITION_FEATURE_COUNT = INPUT_DEFINITION_FEATURE_COUNT + 1;

    /**
     * The operation id for the '<em>Create Reference</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ITEM_REFERENCE_INPUT_DEFINITION___CREATE_REFERENCE = INPUT_DEFINITION_OPERATION_COUNT + 0;

    /**
     * The number of operations of the '<em>Item Reference Input Definition</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ITEM_REFERENCE_INPUT_DEFINITION_OPERATION_COUNT = INPUT_DEFINITION_OPERATION_COUNT + 1;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.component.impl.ComponentReferenceInputDefinitionImpl <em>Reference Input Definition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.component.impl.ComponentReferenceInputDefinitionImpl
     * @see org.eclipse.scada.configuration.component.impl.ComponentPackageImpl#getComponentReferenceInputDefinition()
     * @generated
     */
    int COMPONENT_REFERENCE_INPUT_DEFINITION = 22;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COMPONENT_REFERENCE_INPUT_DEFINITION__NAME = INPUT_DEFINITION__NAME;

    /**
     * The feature id for the '<em><b>Component</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COMPONENT_REFERENCE_INPUT_DEFINITION__COMPONENT = INPUT_DEFINITION_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Local Tag</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COMPONENT_REFERENCE_INPUT_DEFINITION__LOCAL_TAG = INPUT_DEFINITION_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Reference Input Definition</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COMPONENT_REFERENCE_INPUT_DEFINITION_FEATURE_COUNT = INPUT_DEFINITION_FEATURE_COUNT + 2;

    /**
     * The operation id for the '<em>Create Reference</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COMPONENT_REFERENCE_INPUT_DEFINITION___CREATE_REFERENCE = INPUT_DEFINITION_OPERATION_COUNT + 0;

    /**
     * The number of operations of the '<em>Reference Input Definition</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COMPONENT_REFERENCE_INPUT_DEFINITION_OPERATION_COUNT = INPUT_DEFINITION_OPERATION_COUNT + 1;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.component.impl.FormulaModuleImpl <em>Formula Module</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.component.impl.FormulaModuleImpl
     * @see org.eclipse.scada.configuration.component.impl.ComponentPackageImpl#getFormulaModule()
     * @generated
     */
    int FORMULA_MODULE = 23;

    /**
     * The feature id for the '<em><b>Short Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FORMULA_MODULE__SHORT_DESCRIPTION = WorldPackage.DOCUMENTABLE__SHORT_DESCRIPTION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FORMULA_MODULE__NAME = WorldPackage.DOCUMENTABLE__NAME;

    /**
     * The feature id for the '<em><b>Known Inputs</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FORMULA_MODULE__KNOWN_INPUTS = WorldPackage.DOCUMENTABLE_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Known Outputs</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FORMULA_MODULE__KNOWN_OUTPUTS = WorldPackage.DOCUMENTABLE_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Inputs</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FORMULA_MODULE__INPUTS = WorldPackage.DOCUMENTABLE_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Update</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FORMULA_MODULE__UPDATE = WorldPackage.DOCUMENTABLE_FEATURE_COUNT + 3;

    /**
     * The feature id for the '<em><b>Script Engine</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FORMULA_MODULE__SCRIPT_ENGINE = WorldPackage.DOCUMENTABLE_FEATURE_COUNT + 4;

    /**
     * The feature id for the '<em><b>Init</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FORMULA_MODULE__INIT = WorldPackage.DOCUMENTABLE_FEATURE_COUNT + 5;

    /**
     * The number of structural features of the '<em>Formula Module</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FORMULA_MODULE_FEATURE_COUNT = WorldPackage.DOCUMENTABLE_FEATURE_COUNT + 6;

    /**
     * The operation id for the '<em>Get Known Inputs</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FORMULA_MODULE___GET_KNOWN_INPUTS = WorldPackage.DOCUMENTABLE_OPERATION_COUNT + 0;

    /**
     * The operation id for the '<em>Custom ENotify</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FORMULA_MODULE___CUSTOM_ENOTIFY__NOTIFICATION = WorldPackage.DOCUMENTABLE_OPERATION_COUNT + 1;

    /**
     * The number of operations of the '<em>Formula Module</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FORMULA_MODULE_OPERATION_COUNT = WorldPackage.DOCUMENTABLE_OPERATION_COUNT + 2;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.component.impl.AverageModuleImpl <em>Average Module</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.component.impl.AverageModuleImpl
     * @see org.eclipse.scada.configuration.component.impl.ComponentPackageImpl#getAverageModule()
     * @generated
     */
    int AVERAGE_MODULE = 24;

    /**
     * The feature id for the '<em><b>Known Inputs</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int AVERAGE_MODULE__KNOWN_INPUTS = CALCULATION_MODULE__KNOWN_INPUTS;

    /**
     * The feature id for the '<em><b>Known Outputs</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int AVERAGE_MODULE__KNOWN_OUTPUTS = CALCULATION_MODULE__KNOWN_OUTPUTS;

    /**
     * The feature id for the '<em><b>Valid Sources Required</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int AVERAGE_MODULE__VALID_SOURCES_REQUIRED = CALCULATION_MODULE_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Average Module</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int AVERAGE_MODULE_FEATURE_COUNT = CALCULATION_MODULE_FEATURE_COUNT + 1;

    /**
     * The number of operations of the '<em>Average Module</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int AVERAGE_MODULE_OPERATION_COUNT = CALCULATION_MODULE_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.component.impl.DanglingItemReferenceImpl <em>Dangling Item Reference</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.component.impl.DanglingItemReferenceImpl
     * @see org.eclipse.scada.configuration.component.impl.ComponentPackageImpl#getDanglingItemReference()
     * @generated
     */
    int DANGLING_ITEM_REFERENCE = 25;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DANGLING_ITEM_REFERENCE__NAME = OsgiPackage.ITEM__NAME;

    /**
     * The feature id for the '<em><b>Information</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DANGLING_ITEM_REFERENCE__INFORMATION = OsgiPackage.ITEM__INFORMATION;

    /**
     * The feature id for the '<em><b>Item Features</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DANGLING_ITEM_REFERENCE__ITEM_FEATURES = OsgiPackage.ITEM__ITEM_FEATURES;

    /**
     * The number of structural features of the '<em>Dangling Item Reference</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DANGLING_ITEM_REFERENCE_FEATURE_COUNT = OsgiPackage.ITEM_FEATURE_COUNT + 0;

    /**
     * The number of operations of the '<em>Dangling Item Reference</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DANGLING_ITEM_REFERENCE_OPERATION_COUNT = OsgiPackage.ITEM_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.component.impl.ScriptModuleImpl <em>Script Module</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.component.impl.ScriptModuleImpl
     * @see org.eclipse.scada.configuration.component.impl.ComponentPackageImpl#getScriptModule()
     * @generated
     */
    int SCRIPT_MODULE = 26;

    /**
     * The feature id for the '<em><b>Short Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCRIPT_MODULE__SHORT_DESCRIPTION = WorldPackage.DOCUMENTABLE__SHORT_DESCRIPTION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCRIPT_MODULE__NAME = WorldPackage.DOCUMENTABLE__NAME;

    /**
     * The feature id for the '<em><b>Known Inputs</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCRIPT_MODULE__KNOWN_INPUTS = WorldPackage.DOCUMENTABLE_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Known Outputs</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCRIPT_MODULE__KNOWN_OUTPUTS = WorldPackage.DOCUMENTABLE_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Inputs</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCRIPT_MODULE__INPUTS = WorldPackage.DOCUMENTABLE_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Outputs</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCRIPT_MODULE__OUTPUTS = WorldPackage.DOCUMENTABLE_FEATURE_COUNT + 3;

    /**
     * The feature id for the '<em><b>Script Engine</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCRIPT_MODULE__SCRIPT_ENGINE = WorldPackage.DOCUMENTABLE_FEATURE_COUNT + 4;

    /**
     * The number of structural features of the '<em>Script Module</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCRIPT_MODULE_FEATURE_COUNT = WorldPackage.DOCUMENTABLE_FEATURE_COUNT + 5;

    /**
     * The operation id for the '<em>Get Known Inputs</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCRIPT_MODULE___GET_KNOWN_INPUTS = WorldPackage.DOCUMENTABLE_OPERATION_COUNT + 0;

    /**
     * The operation id for the '<em>Custom ENotify</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCRIPT_MODULE___CUSTOM_ENOTIFY__NOTIFICATION = WorldPackage.DOCUMENTABLE_OPERATION_COUNT + 1;

    /**
     * The operation id for the '<em>Get Known Outputs</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCRIPT_MODULE___GET_KNOWN_OUTPUTS = WorldPackage.DOCUMENTABLE_OPERATION_COUNT + 2;

    /**
     * The number of operations of the '<em>Script Module</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCRIPT_MODULE_OPERATION_COUNT = WorldPackage.DOCUMENTABLE_OPERATION_COUNT + 3;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.component.impl.ScriptImpl <em>Script</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.component.impl.ScriptImpl
     * @see org.eclipse.scada.configuration.component.impl.ComponentPackageImpl#getScript()
     * @generated
     */
    int SCRIPT = 27;

    /**
     * The feature id for the '<em><b>Code</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCRIPT__CODE = 0;

    /**
     * The number of structural features of the '<em>Script</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCRIPT_FEATURE_COUNT = 1;

    /**
     * The number of operations of the '<em>Script</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCRIPT_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.component.impl.AbsoluteDanglingReferenceImpl <em>Absolute Dangling Reference</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.component.impl.AbsoluteDanglingReferenceImpl
     * @see org.eclipse.scada.configuration.component.impl.ComponentPackageImpl#getAbsoluteDanglingReference()
     * @generated
     */
    int ABSOLUTE_DANGLING_REFERENCE = 28;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSOLUTE_DANGLING_REFERENCE__NAME = DANGLING_ITEM_REFERENCE__NAME;

    /**
     * The feature id for the '<em><b>Information</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSOLUTE_DANGLING_REFERENCE__INFORMATION = DANGLING_ITEM_REFERENCE__INFORMATION;

    /**
     * The feature id for the '<em><b>Item Features</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSOLUTE_DANGLING_REFERENCE__ITEM_FEATURES = DANGLING_ITEM_REFERENCE__ITEM_FEATURES;

    /**
     * The number of structural features of the '<em>Absolute Dangling Reference</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSOLUTE_DANGLING_REFERENCE_FEATURE_COUNT = DANGLING_ITEM_REFERENCE_FEATURE_COUNT + 0;

    /**
     * The number of operations of the '<em>Absolute Dangling Reference</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSOLUTE_DANGLING_REFERENCE_OPERATION_COUNT = DANGLING_ITEM_REFERENCE_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.component.impl.ComponentDanglingReferenceImpl <em>Dangling Reference</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.component.impl.ComponentDanglingReferenceImpl
     * @see org.eclipse.scada.configuration.component.impl.ComponentPackageImpl#getComponentDanglingReference()
     * @generated
     */
    int COMPONENT_DANGLING_REFERENCE = 29;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COMPONENT_DANGLING_REFERENCE__NAME = DANGLING_ITEM_REFERENCE__NAME;

    /**
     * The feature id for the '<em><b>Information</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COMPONENT_DANGLING_REFERENCE__INFORMATION = DANGLING_ITEM_REFERENCE__INFORMATION;

    /**
     * The feature id for the '<em><b>Item Features</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COMPONENT_DANGLING_REFERENCE__ITEM_FEATURES = DANGLING_ITEM_REFERENCE__ITEM_FEATURES;

    /**
     * The feature id for the '<em><b>Local Tag</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COMPONENT_DANGLING_REFERENCE__LOCAL_TAG = DANGLING_ITEM_REFERENCE_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Component</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COMPONENT_DANGLING_REFERENCE__COMPONENT = DANGLING_ITEM_REFERENCE_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Dangling Reference</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COMPONENT_DANGLING_REFERENCE_FEATURE_COUNT = DANGLING_ITEM_REFERENCE_FEATURE_COUNT + 2;

    /**
     * The number of operations of the '<em>Dangling Reference</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COMPONENT_DANGLING_REFERENCE_OPERATION_COUNT = DANGLING_ITEM_REFERENCE_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.component.impl.ExternalValueImpl <em>External Value</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.component.impl.ExternalValueImpl
     * @see org.eclipse.scada.configuration.component.impl.ComponentPackageImpl#getExternalValue()
     * @generated
     */
    int EXTERNAL_VALUE = 30;

    /**
     * The feature id for the '<em><b>Level</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXTERNAL_VALUE__LEVEL = SINGLE_VALUE__LEVEL;

    /**
     * The feature id for the '<em><b>Customization Pipeline</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXTERNAL_VALUE__CUSTOMIZATION_PIPELINE = SINGLE_VALUE__CUSTOMIZATION_PIPELINE;

    /**
     * The feature id for the '<em><b>Archive Selector</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXTERNAL_VALUE__ARCHIVE_SELECTOR = SINGLE_VALUE__ARCHIVE_SELECTOR;

    /**
     * The feature id for the '<em><b>Master On</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXTERNAL_VALUE__MASTER_ON = SINGLE_VALUE__MASTER_ON;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXTERNAL_VALUE__NAME = SINGLE_VALUE__NAME;

    /**
     * The feature id for the '<em><b>Data Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXTERNAL_VALUE__DATA_TYPE = SINGLE_VALUE__DATA_TYPE;

    /**
     * The feature id for the '<em><b>Customization Tags</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXTERNAL_VALUE__CUSTOMIZATION_TAGS = SINGLE_VALUE__CUSTOMIZATION_TAGS;

    /**
     * The feature id for the '<em><b>Connection</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXTERNAL_VALUE__CONNECTION = SINGLE_VALUE_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Source Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXTERNAL_VALUE__SOURCE_NAME = SINGLE_VALUE_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>External Value</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXTERNAL_VALUE_FEATURE_COUNT = SINGLE_VALUE_FEATURE_COUNT + 2;

    /**
     * The operation id for the '<em>Get Master On</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXTERNAL_VALUE___GET_MASTER_ON = SINGLE_VALUE___GET_MASTER_ON;

    /**
     * The number of operations of the '<em>External Value</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXTERNAL_VALUE_OPERATION_COUNT = SINGLE_VALUE_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.component.impl.SummariesConfigurationImpl <em>Summaries Configuration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.component.impl.SummariesConfigurationImpl
     * @see org.eclipse.scada.configuration.component.impl.ComponentPackageImpl#getSummariesConfiguration()
     * @generated
     */
    int SUMMARIES_CONFIGURATION = 31;

    /**
     * The feature id for the '<em><b>Item Threshold</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SUMMARIES_CONFIGURATION__ITEM_THRESHOLD = CONFIGURATION_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Summaries Configuration</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SUMMARIES_CONFIGURATION_FEATURE_COUNT = CONFIGURATION_FEATURE_COUNT + 1;

    /**
     * The number of operations of the '<em>Summaries Configuration</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SUMMARIES_CONFIGURATION_OPERATION_COUNT = CONFIGURATION_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.component.ItemInterceptor <em>Item Interceptor</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.component.ItemInterceptor
     * @see org.eclipse.scada.configuration.component.impl.ComponentPackageImpl#getItemInterceptor()
     * @generated
     */
    int ITEM_INTERCEPTOR = 32;

    /**
     * The feature id for the '<em><b>Master On</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ITEM_INTERCEPTOR__MASTER_ON = 0;

    /**
     * The number of structural features of the '<em>Item Interceptor</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ITEM_INTERCEPTOR_FEATURE_COUNT = 1;

    /**
     * The number of operations of the '<em>Item Interceptor</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ITEM_INTERCEPTOR_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.component.impl.RestInterceptorImpl <em>Rest Interceptor</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.component.impl.RestInterceptorImpl
     * @see org.eclipse.scada.configuration.component.impl.ComponentPackageImpl#getRestInterceptor()
     * @generated
     */
    int REST_INTERCEPTOR = 34;

    /**
     * The feature id for the '<em><b>Master On</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int REST_INTERCEPTOR__MASTER_ON = ITEM_INTERCEPTOR__MASTER_ON;

    /**
     * The feature id for the '<em><b>Selector</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int REST_INTERCEPTOR__SELECTOR = ITEM_INTERCEPTOR_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Definition</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int REST_INTERCEPTOR__DEFINITION = ITEM_INTERCEPTOR_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Rest Interceptor</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int REST_INTERCEPTOR_FEATURE_COUNT = ITEM_INTERCEPTOR_FEATURE_COUNT + 2;

    /**
     * The number of operations of the '<em>Rest Interceptor</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int REST_INTERCEPTOR_OPERATION_COUNT = ITEM_INTERCEPTOR_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.component.impl.GlobalizeComponentImpl <em>Globalize Component</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.component.impl.GlobalizeComponentImpl
     * @see org.eclipse.scada.configuration.component.impl.ComponentPackageImpl#getGlobalizeComponent()
     * @generated
     */
    int GLOBALIZE_COMPONENT = 35;

    /**
     * The feature id for the '<em><b>Short Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GLOBALIZE_COMPONENT__SHORT_DESCRIPTION = WorldPackage.DOCUMENTABLE__SHORT_DESCRIPTION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GLOBALIZE_COMPONENT__NAME = WorldPackage.DOCUMENTABLE__NAME;

    /**
     * The feature id for the '<em><b>Level</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GLOBALIZE_COMPONENT__LEVEL = WorldPackage.DOCUMENTABLE_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Customization Pipeline</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GLOBALIZE_COMPONENT__CUSTOMIZATION_PIPELINE = WorldPackage.DOCUMENTABLE_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Archive Selector</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GLOBALIZE_COMPONENT__ARCHIVE_SELECTOR = WorldPackage.DOCUMENTABLE_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Components</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GLOBALIZE_COMPONENT__COMPONENTS = WorldPackage.DOCUMENTABLE_FEATURE_COUNT + 3;

    /**
     * The feature id for the '<em><b>Source Master</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GLOBALIZE_COMPONENT__SOURCE_MASTER = WorldPackage.DOCUMENTABLE_FEATURE_COUNT + 4;

    /**
     * The number of structural features of the '<em>Globalize Component</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GLOBALIZE_COMPONENT_FEATURE_COUNT = WorldPackage.DOCUMENTABLE_FEATURE_COUNT + 5;

    /**
     * The operation id for the '<em>Get Master On</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GLOBALIZE_COMPONENT___GET_MASTER_ON = WorldPackage.DOCUMENTABLE_OPERATION_COUNT + 0;

    /**
     * The number of operations of the '<em>Globalize Component</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GLOBALIZE_COMPONENT_OPERATION_COUNT = WorldPackage.DOCUMENTABLE_OPERATION_COUNT + 1;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.component.impl.TransientValueImpl <em>Transient Value</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.component.impl.TransientValueImpl
     * @see org.eclipse.scada.configuration.component.impl.ComponentPackageImpl#getTransientValue()
     * @generated
     */
    int TRANSIENT_VALUE = 36;

    /**
     * The feature id for the '<em><b>Level</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TRANSIENT_VALUE__LEVEL = SINGLE_VALUE__LEVEL;

    /**
     * The feature id for the '<em><b>Customization Pipeline</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TRANSIENT_VALUE__CUSTOMIZATION_PIPELINE = SINGLE_VALUE__CUSTOMIZATION_PIPELINE;

    /**
     * The feature id for the '<em><b>Archive Selector</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TRANSIENT_VALUE__ARCHIVE_SELECTOR = SINGLE_VALUE__ARCHIVE_SELECTOR;

    /**
     * The feature id for the '<em><b>Master On</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TRANSIENT_VALUE__MASTER_ON = SINGLE_VALUE__MASTER_ON;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TRANSIENT_VALUE__NAME = SINGLE_VALUE__NAME;

    /**
     * The feature id for the '<em><b>Data Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TRANSIENT_VALUE__DATA_TYPE = SINGLE_VALUE__DATA_TYPE;

    /**
     * The feature id for the '<em><b>Customization Tags</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TRANSIENT_VALUE__CUSTOMIZATION_TAGS = SINGLE_VALUE__CUSTOMIZATION_TAGS;

    /**
     * The number of structural features of the '<em>Transient Value</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TRANSIENT_VALUE_FEATURE_COUNT = SINGLE_VALUE_FEATURE_COUNT + 0;

    /**
     * The operation id for the '<em>Get Master On</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TRANSIENT_VALUE___GET_MASTER_ON = SINGLE_VALUE___GET_MASTER_ON;

    /**
     * The number of operations of the '<em>Transient Value</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TRANSIENT_VALUE_OPERATION_COUNT = SINGLE_VALUE_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.component.impl.BufferedValueImpl <em>Buffered Value</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.component.impl.BufferedValueImpl
     * @see org.eclipse.scada.configuration.component.impl.ComponentPackageImpl#getBufferedValue()
     * @generated
     */
    int BUFFERED_VALUE = 38;

    /**
     * The feature id for the '<em><b>Level</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BUFFERED_VALUE__LEVEL = MASTER_COMPONENT__LEVEL;

    /**
     * The feature id for the '<em><b>Customization Pipeline</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BUFFERED_VALUE__CUSTOMIZATION_PIPELINE = MASTER_COMPONENT__CUSTOMIZATION_PIPELINE;

    /**
     * The feature id for the '<em><b>Archive Selector</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BUFFERED_VALUE__ARCHIVE_SELECTOR = MASTER_COMPONENT__ARCHIVE_SELECTOR;

    /**
     * The feature id for the '<em><b>Master On</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BUFFERED_VALUE__MASTER_ON = MASTER_COMPONENT__MASTER_ON;

    /**
     * The feature id for the '<em><b>Input</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BUFFERED_VALUE__INPUT = MASTER_COMPONENT_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Range</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BUFFERED_VALUE__RANGE = MASTER_COMPONENT_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Initial Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BUFFERED_VALUE__INITIAL_VALUE = MASTER_COMPONENT_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Persistence</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BUFFERED_VALUE__PERSISTENCE = MASTER_COMPONENT_FEATURE_COUNT + 3;

    /**
     * The feature id for the '<em><b>Trigger Only</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BUFFERED_VALUE__TRIGGER_ONLY = MASTER_COMPONENT_FEATURE_COUNT + 4;

    /**
     * The number of structural features of the '<em>Buffered Value</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BUFFERED_VALUE_FEATURE_COUNT = MASTER_COMPONENT_FEATURE_COUNT + 5;

    /**
     * The operation id for the '<em>Get Master On</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BUFFERED_VALUE___GET_MASTER_ON = MASTER_COMPONENT___GET_MASTER_ON;

    /**
     * The number of operations of the '<em>Buffered Value</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BUFFERED_VALUE_OPERATION_COUNT = MASTER_COMPONENT_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.component.impl.ChangeCounterImpl <em>Change Counter</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.component.impl.ChangeCounterImpl
     * @see org.eclipse.scada.configuration.component.impl.ComponentPackageImpl#getChangeCounter()
     * @generated
     */
    int CHANGE_COUNTER = 39;

    /**
     * The feature id for the '<em><b>Level</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CHANGE_COUNTER__LEVEL = SINGLE_VALUE__LEVEL;

    /**
     * The feature id for the '<em><b>Customization Pipeline</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CHANGE_COUNTER__CUSTOMIZATION_PIPELINE = SINGLE_VALUE__CUSTOMIZATION_PIPELINE;

    /**
     * The feature id for the '<em><b>Archive Selector</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CHANGE_COUNTER__ARCHIVE_SELECTOR = SINGLE_VALUE__ARCHIVE_SELECTOR;

    /**
     * The feature id for the '<em><b>Master On</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CHANGE_COUNTER__MASTER_ON = SINGLE_VALUE__MASTER_ON;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CHANGE_COUNTER__NAME = SINGLE_VALUE__NAME;

    /**
     * The feature id for the '<em><b>Data Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CHANGE_COUNTER__DATA_TYPE = SINGLE_VALUE__DATA_TYPE;

    /**
     * The feature id for the '<em><b>Customization Tags</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CHANGE_COUNTER__CUSTOMIZATION_TAGS = SINGLE_VALUE__CUSTOMIZATION_TAGS;

    /**
     * The feature id for the '<em><b>Buffer</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CHANGE_COUNTER__BUFFER = SINGLE_VALUE_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Change Counter</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CHANGE_COUNTER_FEATURE_COUNT = SINGLE_VALUE_FEATURE_COUNT + 1;

    /**
     * The operation id for the '<em>Get Master On</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CHANGE_COUNTER___GET_MASTER_ON = SINGLE_VALUE___GET_MASTER_ON;

    /**
     * The number of operations of the '<em>Change Counter</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CHANGE_COUNTER_OPERATION_COUNT = SINGLE_VALUE_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.component.Persistence <em>Persistence</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.component.Persistence
     * @see org.eclipse.scada.configuration.component.impl.ComponentPackageImpl#getPersistence()
     * @generated
     */
    int PERSISTENCE = 40;

    /**
     * The meta object id for the '<em>Notification</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.emf.common.notify.Notification
     * @see org.eclipse.scada.configuration.component.impl.ComponentPackageImpl#getNotification()
     * @generated
     */
    int NOTIFICATION = 41;

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.component.ComponentWorld <em>World</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>World</em>'.
     * @see org.eclipse.scada.configuration.component.ComponentWorld
     * @generated
     */
    EClass getComponentWorld ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.configuration.component.ComponentWorld#getLevels <em>Levels</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Levels</em>'.
     * @see org.eclipse.scada.configuration.component.ComponentWorld#getLevels()
     * @see #getComponentWorld()
     * @generated
     */
    EReference getComponentWorld_Levels ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.configuration.component.ComponentWorld#getConfigurations <em>Configurations</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Configurations</em>'.
     * @see org.eclipse.scada.configuration.component.ComponentWorld#getConfigurations()
     * @see #getComponentWorld()
     * @generated
     */
    EReference getComponentWorld_Configurations ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.configuration.component.ComponentWorld#getServices <em>Services</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Services</em>'.
     * @see org.eclipse.scada.configuration.component.ComponentWorld#getServices()
     * @see #getComponentWorld()
     * @generated
     */
    EReference getComponentWorld_Services ();

    /**
     * Returns the meta object for the reference '{@link org.eclipse.scada.configuration.component.ComponentWorld#getInfrastructure <em>Infrastructure</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Infrastructure</em>'.
     * @see org.eclipse.scada.configuration.component.ComponentWorld#getInfrastructure()
     * @see #getComponentWorld()
     * @generated
     */
    EReference getComponentWorld_Infrastructure ();

    /**
     * Returns the meta object for the reference '{@link org.eclipse.scada.configuration.component.ComponentWorld#getDefaultCustomizationPipeline <em>Default Customization Pipeline</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Default Customization Pipeline</em>'.
     * @see org.eclipse.scada.configuration.component.ComponentWorld#getDefaultCustomizationPipeline()
     * @see #getComponentWorld()
     * @generated
     */
    EReference getComponentWorld_DefaultCustomizationPipeline ();

    /**
     * Returns the meta object for the reference '{@link org.eclipse.scada.configuration.component.ComponentWorld#getDefaultArchiveSelector <em>Default Archive Selector</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Default Archive Selector</em>'.
     * @see org.eclipse.scada.configuration.component.ComponentWorld#getDefaultArchiveSelector()
     * @see #getComponentWorld()
     * @generated
     */
    EReference getComponentWorld_DefaultArchiveSelector ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.component.Level <em>Level</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Level</em>'.
     * @see org.eclipse.scada.configuration.component.Level
     * @generated
     */
    EClass getLevel ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.configuration.component.Level#getComponents <em>Components</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Components</em>'.
     * @see org.eclipse.scada.configuration.component.Level#getComponents()
     * @see #getLevel()
     * @generated
     */
    EReference getLevel_Components ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.component.Level#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see org.eclipse.scada.configuration.component.Level#getName()
     * @see #getLevel()
     * @generated
     */
    EAttribute getLevel_Name ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.configuration.component.Level#getLevels <em>Levels</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Levels</em>'.
     * @see org.eclipse.scada.configuration.component.Level#getLevels()
     * @see #getLevel()
     * @generated
     */
    EReference getLevel_Levels ();

    /**
     * Returns the meta object for the container reference '{@link org.eclipse.scada.configuration.component.Level#getParent <em>Parent</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Parent</em>'.
     * @see org.eclipse.scada.configuration.component.Level#getParent()
     * @see #getLevel()
     * @generated
     */
    EReference getLevel_Parent ();

    /**
     * Returns the meta object for the reference '{@link org.eclipse.scada.configuration.component.Level#getCustomizationPipeline <em>Customization Pipeline</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Customization Pipeline</em>'.
     * @see org.eclipse.scada.configuration.component.Level#getCustomizationPipeline()
     * @see #getLevel()
     * @generated
     */
    EReference getLevel_CustomizationPipeline ();

    /**
     * Returns the meta object for the reference '{@link org.eclipse.scada.configuration.component.Level#getArchiveSelector <em>Archive Selector</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Archive Selector</em>'.
     * @see org.eclipse.scada.configuration.component.Level#getArchiveSelector()
     * @see #getLevel()
     * @generated
     */
    EReference getLevel_ArchiveSelector ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.component.Component <em>Component</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Component</em>'.
     * @see org.eclipse.scada.configuration.component.Component
     * @generated
     */
    EClass getComponent ();

    /**
     * Returns the meta object for the container reference '{@link org.eclipse.scada.configuration.component.Component#getLevel <em>Level</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Level</em>'.
     * @see org.eclipse.scada.configuration.component.Component#getLevel()
     * @see #getComponent()
     * @generated
     */
    EReference getComponent_Level ();

    /**
     * Returns the meta object for the reference '{@link org.eclipse.scada.configuration.component.Component#getCustomizationPipeline <em>Customization Pipeline</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Customization Pipeline</em>'.
     * @see org.eclipse.scada.configuration.component.Component#getCustomizationPipeline()
     * @see #getComponent()
     * @generated
     */
    EReference getComponent_CustomizationPipeline ();

    /**
     * Returns the meta object for the reference '{@link org.eclipse.scada.configuration.component.Component#getArchiveSelector <em>Archive Selector</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Archive Selector</em>'.
     * @see org.eclipse.scada.configuration.component.Component#getArchiveSelector()
     * @see #getComponent()
     * @generated
     */
    EReference getComponent_ArchiveSelector ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.component.DataComponent <em>Data Component</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Data Component</em>'.
     * @see org.eclipse.scada.configuration.component.DataComponent
     * @generated
     */
    EClass getDataComponent ();

    /**
     * Returns the meta object for the '{@link org.eclipse.scada.configuration.component.DataComponent#getMasterOn() <em>Get Master On</em>}' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the '<em>Get Master On</em>' operation.
     * @see org.eclipse.scada.configuration.component.DataComponent#getMasterOn()
     * @generated
     */
    EOperation getDataComponent__GetMasterOn ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.component.Configuration <em>Configuration</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Configuration</em>'.
     * @see org.eclipse.scada.configuration.component.Configuration
     * @generated
     */
    EClass getConfiguration ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.component.ConstantValue <em>Constant Value</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Constant Value</em>'.
     * @see org.eclipse.scada.configuration.component.ConstantValue
     * @generated
     */
    EClass getConstantValue ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.component.ConstantValue#getValue <em>Value</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Value</em>'.
     * @see org.eclipse.scada.configuration.component.ConstantValue#getValue()
     * @see #getConstantValue()
     * @generated
     */
    EAttribute getConstantValue_Value ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.component.MarkerConfiguration <em>Marker Configuration</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Marker Configuration</em>'.
     * @see org.eclipse.scada.configuration.component.MarkerConfiguration
     * @generated
     */
    EClass getMarkerConfiguration ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.configuration.component.MarkerConfiguration#getMarkers <em>Markers</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Markers</em>'.
     * @see org.eclipse.scada.configuration.component.MarkerConfiguration#getMarkers()
     * @see #getMarkerConfiguration()
     * @generated
     */
    EReference getMarkerConfiguration_Markers ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.component.Service <em>Service</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Service</em>'.
     * @see org.eclipse.scada.configuration.component.Service
     * @generated
     */
    EClass getService ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.component.PersistentValue <em>Persistent Value</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Persistent Value</em>'.
     * @see org.eclipse.scada.configuration.component.PersistentValue
     * @generated
     */
    EClass getPersistentValue ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.component.DriverConnectionAnalyzer <em>Driver Connection Analyzer</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Driver Connection Analyzer</em>'.
     * @see org.eclipse.scada.configuration.component.DriverConnectionAnalyzer
     * @generated
     */
    EClass getDriverConnectionAnalyzer ();

    /**
     * Returns the meta object for the reference '{@link org.eclipse.scada.configuration.component.DriverConnectionAnalyzer#getDriver <em>Driver</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Driver</em>'.
     * @see org.eclipse.scada.configuration.component.DriverConnectionAnalyzer#getDriver()
     * @see #getDriverConnectionAnalyzer()
     * @generated
     */
    EReference getDriverConnectionAnalyzer_Driver ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.component.MasterImportConnectionAnalyzer <em>Master Import Connection Analyzer</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Master Import Connection Analyzer</em>'.
     * @see org.eclipse.scada.configuration.component.MasterImportConnectionAnalyzer
     * @generated
     */
    EClass getMasterImportConnectionAnalyzer ();

    /**
     * Returns the meta object for the reference '{@link org.eclipse.scada.configuration.component.MasterImportConnectionAnalyzer#getConnection <em>Connection</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Connection</em>'.
     * @see org.eclipse.scada.configuration.component.MasterImportConnectionAnalyzer#getConnection()
     * @see #getMasterImportConnectionAnalyzer()
     * @generated
     */
    EReference getMasterImportConnectionAnalyzer_Connection ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.component.SingleValue <em>Single Value</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Single Value</em>'.
     * @see org.eclipse.scada.configuration.component.SingleValue
     * @generated
     */
    EClass getSingleValue ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.component.SingleValue#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see org.eclipse.scada.configuration.component.SingleValue#getName()
     * @see #getSingleValue()
     * @generated
     */
    EAttribute getSingleValue_Name ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.component.SingleValue#getDataType <em>Data Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Data Type</em>'.
     * @see org.eclipse.scada.configuration.component.SingleValue#getDataType()
     * @see #getSingleValue()
     * @generated
     */
    EAttribute getSingleValue_DataType ();

    /**
     * Returns the meta object for the attribute list '{@link org.eclipse.scada.configuration.component.SingleValue#getCustomizationTags <em>Customization Tags</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute list '<em>Customization Tags</em>'.
     * @see org.eclipse.scada.configuration.component.SingleValue#getCustomizationTags()
     * @see #getSingleValue()
     * @generated
     */
    EAttribute getSingleValue_CustomizationTags ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.component.DataMapperAnalyzer <em>Data Mapper Analyzer</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Data Mapper Analyzer</em>'.
     * @see org.eclipse.scada.configuration.component.DataMapperAnalyzer
     * @generated
     */
    EClass getDataMapperAnalyzer ();

    /**
     * Returns the meta object for the reference '{@link org.eclipse.scada.configuration.component.DataMapperAnalyzer#getDataMapper <em>Data Mapper</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Data Mapper</em>'.
     * @see org.eclipse.scada.configuration.component.DataMapperAnalyzer#getDataMapper()
     * @see #getDataMapperAnalyzer()
     * @generated
     */
    EReference getDataMapperAnalyzer_DataMapper ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.component.DataMapperService <em>Data Mapper Service</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Data Mapper Service</em>'.
     * @see org.eclipse.scada.configuration.component.DataMapperService
     * @generated
     */
    EClass getDataMapperService ();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.scada.configuration.component.DataMapperService#getDataMapper <em>Data Mapper</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Data Mapper</em>'.
     * @see org.eclipse.scada.configuration.component.DataMapperService#getDataMapper()
     * @see #getDataMapperService()
     * @generated
     */
    EReference getDataMapperService_DataMapper ();

    /**
     * Returns the meta object for the reference list '{@link org.eclipse.scada.configuration.component.DataMapperService#getMasterOn <em>Master On</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Master On</em>'.
     * @see org.eclipse.scada.configuration.component.DataMapperService#getMasterOn()
     * @see #getDataMapperService()
     * @generated
     */
    EReference getDataMapperService_MasterOn ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.component.MappedSourceValue <em>Mapped Source Value</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Mapped Source Value</em>'.
     * @see org.eclipse.scada.configuration.component.MappedSourceValue
     * @generated
     */
    EClass getMappedSourceValue ();

    /**
     * Returns the meta object for the reference '{@link org.eclipse.scada.configuration.component.MappedSourceValue#getMapper <em>Mapper</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Mapper</em>'.
     * @see org.eclipse.scada.configuration.component.MappedSourceValue#getMapper()
     * @see #getMappedSourceValue()
     * @generated
     */
    EReference getMappedSourceValue_Mapper ();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.scada.configuration.component.MappedSourceValue#getInput <em>Input</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Input</em>'.
     * @see org.eclipse.scada.configuration.component.MappedSourceValue#getInput()
     * @see #getMappedSourceValue()
     * @generated
     */
    EReference getMappedSourceValue_Input ();

    /**
     * Returns the meta object for the attribute list '{@link org.eclipse.scada.configuration.component.MappedSourceValue#getCustomizationTags <em>Customization Tags</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute list '<em>Customization Tags</em>'.
     * @see org.eclipse.scada.configuration.component.MappedSourceValue#getCustomizationTags()
     * @see #getMappedSourceValue()
     * @generated
     */
    EAttribute getMappedSourceValue_CustomizationTags ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.component.CalculationComponent <em>Calculation Component</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Calculation Component</em>'.
     * @see org.eclipse.scada.configuration.component.CalculationComponent
     * @generated
     */
    EClass getCalculationComponent ();

    /**
     * Returns the meta object for the reference '{@link org.eclipse.scada.configuration.component.CalculationComponent#getImplementation <em>Implementation</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Implementation</em>'.
     * @see org.eclipse.scada.configuration.component.CalculationComponent#getImplementation()
     * @see #getCalculationComponent()
     * @generated
     */
    EReference getCalculationComponent_Implementation ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.configuration.component.CalculationComponent#getOutputs <em>Outputs</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Outputs</em>'.
     * @see org.eclipse.scada.configuration.component.CalculationComponent#getOutputs()
     * @see #getCalculationComponent()
     * @generated
     */
    EReference getCalculationComponent_Outputs ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.configuration.component.CalculationComponent#getInputs <em>Inputs</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Inputs</em>'.
     * @see org.eclipse.scada.configuration.component.CalculationComponent#getInputs()
     * @see #getCalculationComponent()
     * @generated
     */
    EReference getCalculationComponent_Inputs ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.component.CalculationModule <em>Calculation Module</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Calculation Module</em>'.
     * @see org.eclipse.scada.configuration.component.CalculationModule
     * @generated
     */
    EClass getCalculationModule ();

    /**
     * Returns the meta object for the reference list '{@link org.eclipse.scada.configuration.component.CalculationModule#getKnownInputs <em>Known Inputs</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Known Inputs</em>'.
     * @see org.eclipse.scada.configuration.component.CalculationModule#getKnownInputs()
     * @see #getCalculationModule()
     * @generated
     */
    EReference getCalculationModule_KnownInputs ();

    /**
     * Returns the meta object for the reference list '{@link org.eclipse.scada.configuration.component.CalculationModule#getKnownOutputs <em>Known Outputs</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Known Outputs</em>'.
     * @see org.eclipse.scada.configuration.component.CalculationModule#getKnownOutputs()
     * @see #getCalculationModule()
     * @generated
     */
    EReference getCalculationModule_KnownOutputs ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.component.InputSpecification <em>Input Specification</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Input Specification</em>'.
     * @see org.eclipse.scada.configuration.component.InputSpecification
     * @generated
     */
    EClass getInputSpecification ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.component.InputSpecification#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see org.eclipse.scada.configuration.component.InputSpecification#getName()
     * @see #getInputSpecification()
     * @generated
     */
    EAttribute getInputSpecification_Name ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.component.OutputSpecification <em>Output Specification</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Output Specification</em>'.
     * @see org.eclipse.scada.configuration.component.OutputSpecification
     * @generated
     */
    EClass getOutputSpecification ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.component.OutputSpecification#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see org.eclipse.scada.configuration.component.OutputSpecification#getName()
     * @see #getOutputSpecification()
     * @generated
     */
    EAttribute getOutputSpecification_Name ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.component.OutputSpecification#getDataType <em>Data Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Data Type</em>'.
     * @see org.eclipse.scada.configuration.component.OutputSpecification#getDataType()
     * @see #getOutputSpecification()
     * @generated
     */
    EAttribute getOutputSpecification_DataType ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.component.OutputDefinition <em>Output Definition</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Output Definition</em>'.
     * @see org.eclipse.scada.configuration.component.OutputDefinition
     * @generated
     */
    EClass getOutputDefinition ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.component.OutputDefinition#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see org.eclipse.scada.configuration.component.OutputDefinition#getName()
     * @see #getOutputDefinition()
     * @generated
     */
    EAttribute getOutputDefinition_Name ();

    /**
     * Returns the meta object for the attribute list '{@link org.eclipse.scada.configuration.component.OutputDefinition#getLocalTag <em>Local Tag</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute list '<em>Local Tag</em>'.
     * @see org.eclipse.scada.configuration.component.OutputDefinition#getLocalTag()
     * @see #getOutputDefinition()
     * @generated
     */
    EAttribute getOutputDefinition_LocalTag ();

    /**
     * Returns the meta object for the attribute list '{@link org.eclipse.scada.configuration.component.OutputDefinition#getCustomizationTags <em>Customization Tags</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute list '<em>Customization Tags</em>'.
     * @see org.eclipse.scada.configuration.component.OutputDefinition#getCustomizationTags()
     * @see #getOutputDefinition()
     * @generated
     */
    EAttribute getOutputDefinition_CustomizationTags ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.component.ItemReferenceInputDefinition <em>Item Reference Input Definition</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Item Reference Input Definition</em>'.
     * @see org.eclipse.scada.configuration.component.ItemReferenceInputDefinition
     * @generated
     */
    EClass getItemReferenceInputDefinition ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.component.ItemReferenceInputDefinition#getItemId <em>Item Id</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Item Id</em>'.
     * @see org.eclipse.scada.configuration.component.ItemReferenceInputDefinition#getItemId()
     * @see #getItemReferenceInputDefinition()
     * @generated
     */
    EAttribute getItemReferenceInputDefinition_ItemId ();

    /**
     * Returns the meta object for the '{@link org.eclipse.scada.configuration.component.ItemReferenceInputDefinition#createReference() <em>Create Reference</em>}' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the '<em>Create Reference</em>' operation.
     * @see org.eclipse.scada.configuration.component.ItemReferenceInputDefinition#createReference()
     * @generated
     */
    EOperation getItemReferenceInputDefinition__CreateReference ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.component.InputDefinition <em>Input Definition</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Input Definition</em>'.
     * @see org.eclipse.scada.configuration.component.InputDefinition
     * @generated
     */
    EClass getInputDefinition ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.component.InputDefinition#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see org.eclipse.scada.configuration.component.InputDefinition#getName()
     * @see #getInputDefinition()
     * @generated
     */
    EAttribute getInputDefinition_Name ();

    /**
     * Returns the meta object for the '{@link org.eclipse.scada.configuration.component.InputDefinition#createReference() <em>Create Reference</em>}' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the '<em>Create Reference</em>' operation.
     * @see org.eclipse.scada.configuration.component.InputDefinition#createReference()
     * @generated
     */
    EOperation getInputDefinition__CreateReference ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.component.ComponentReferenceInputDefinition <em>Reference Input Definition</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Reference Input Definition</em>'.
     * @see org.eclipse.scada.configuration.component.ComponentReferenceInputDefinition
     * @generated
     */
    EClass getComponentReferenceInputDefinition ();

    /**
     * Returns the meta object for the reference '{@link org.eclipse.scada.configuration.component.ComponentReferenceInputDefinition#getComponent <em>Component</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Component</em>'.
     * @see org.eclipse.scada.configuration.component.ComponentReferenceInputDefinition#getComponent()
     * @see #getComponentReferenceInputDefinition()
     * @generated
     */
    EReference getComponentReferenceInputDefinition_Component ();

    /**
     * Returns the meta object for the attribute list '{@link org.eclipse.scada.configuration.component.ComponentReferenceInputDefinition#getLocalTag <em>Local Tag</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute list '<em>Local Tag</em>'.
     * @see org.eclipse.scada.configuration.component.ComponentReferenceInputDefinition#getLocalTag()
     * @see #getComponentReferenceInputDefinition()
     * @generated
     */
    EAttribute getComponentReferenceInputDefinition_LocalTag ();

    /**
     * Returns the meta object for the '{@link org.eclipse.scada.configuration.component.ComponentReferenceInputDefinition#createReference() <em>Create Reference</em>}' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the '<em>Create Reference</em>' operation.
     * @see org.eclipse.scada.configuration.component.ComponentReferenceInputDefinition#createReference()
     * @generated
     */
    EOperation getComponentReferenceInputDefinition__CreateReference ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.component.FormulaModule <em>Formula Module</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Formula Module</em>'.
     * @see org.eclipse.scada.configuration.component.FormulaModule
     * @generated
     */
    EClass getFormulaModule ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.configuration.component.FormulaModule#getInputs <em>Inputs</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Inputs</em>'.
     * @see org.eclipse.scada.configuration.component.FormulaModule#getInputs()
     * @see #getFormulaModule()
     * @generated
     */
    EReference getFormulaModule_Inputs ();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.scada.configuration.component.FormulaModule#getUpdate <em>Update</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Update</em>'.
     * @see org.eclipse.scada.configuration.component.FormulaModule#getUpdate()
     * @see #getFormulaModule()
     * @generated
     */
    EReference getFormulaModule_Update ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.component.FormulaModule#getScriptEngine <em>Script Engine</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Script Engine</em>'.
     * @see org.eclipse.scada.configuration.component.FormulaModule#getScriptEngine()
     * @see #getFormulaModule()
     * @generated
     */
    EAttribute getFormulaModule_ScriptEngine ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.configuration.component.FormulaModule#getInit <em>Init</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Init</em>'.
     * @see org.eclipse.scada.configuration.component.FormulaModule#getInit()
     * @see #getFormulaModule()
     * @generated
     */
    EReference getFormulaModule_Init ();

    /**
     * Returns the meta object for the '{@link org.eclipse.scada.configuration.component.FormulaModule#getKnownInputs() <em>Get Known Inputs</em>}' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the '<em>Get Known Inputs</em>' operation.
     * @see org.eclipse.scada.configuration.component.FormulaModule#getKnownInputs()
     * @generated
     */
    EOperation getFormulaModule__GetKnownInputs ();

    /**
     * Returns the meta object for the '{@link org.eclipse.scada.configuration.component.FormulaModule#customENotify(org.eclipse.emf.common.notify.Notification) <em>Custom ENotify</em>}' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the '<em>Custom ENotify</em>' operation.
     * @see org.eclipse.scada.configuration.component.FormulaModule#customENotify(org.eclipse.emf.common.notify.Notification)
     * @generated
     */
    EOperation getFormulaModule__CustomENotify__Notification ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.component.AverageModule <em>Average Module</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Average Module</em>'.
     * @see org.eclipse.scada.configuration.component.AverageModule
     * @generated
     */
    EClass getAverageModule ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.component.AverageModule#getValidSourcesRequired <em>Valid Sources Required</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Valid Sources Required</em>'.
     * @see org.eclipse.scada.configuration.component.AverageModule#getValidSourcesRequired()
     * @see #getAverageModule()
     * @generated
     */
    EAttribute getAverageModule_ValidSourcesRequired ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.component.DanglingItemReference <em>Dangling Item Reference</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Dangling Item Reference</em>'.
     * @see org.eclipse.scada.configuration.component.DanglingItemReference
     * @generated
     */
    EClass getDanglingItemReference ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.component.ScriptModule <em>Script Module</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Script Module</em>'.
     * @see org.eclipse.scada.configuration.component.ScriptModule
     * @generated
     */
    EClass getScriptModule ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.configuration.component.ScriptModule#getInputs <em>Inputs</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Inputs</em>'.
     * @see org.eclipse.scada.configuration.component.ScriptModule#getInputs()
     * @see #getScriptModule()
     * @generated
     */
    EReference getScriptModule_Inputs ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.configuration.component.ScriptModule#getOutputs <em>Outputs</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Outputs</em>'.
     * @see org.eclipse.scada.configuration.component.ScriptModule#getOutputs()
     * @see #getScriptModule()
     * @generated
     */
    EReference getScriptModule_Outputs ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.component.ScriptModule#getScriptEngine <em>Script Engine</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Script Engine</em>'.
     * @see org.eclipse.scada.configuration.component.ScriptModule#getScriptEngine()
     * @see #getScriptModule()
     * @generated
     */
    EAttribute getScriptModule_ScriptEngine ();

    /**
     * Returns the meta object for the '{@link org.eclipse.scada.configuration.component.ScriptModule#getKnownInputs() <em>Get Known Inputs</em>}' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the '<em>Get Known Inputs</em>' operation.
     * @see org.eclipse.scada.configuration.component.ScriptModule#getKnownInputs()
     * @generated
     */
    EOperation getScriptModule__GetKnownInputs ();

    /**
     * Returns the meta object for the '{@link org.eclipse.scada.configuration.component.ScriptModule#customENotify(org.eclipse.emf.common.notify.Notification) <em>Custom ENotify</em>}' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the '<em>Custom ENotify</em>' operation.
     * @see org.eclipse.scada.configuration.component.ScriptModule#customENotify(org.eclipse.emf.common.notify.Notification)
     * @generated
     */
    EOperation getScriptModule__CustomENotify__Notification ();

    /**
     * Returns the meta object for the '{@link org.eclipse.scada.configuration.component.ScriptModule#getKnownOutputs() <em>Get Known Outputs</em>}' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the '<em>Get Known Outputs</em>' operation.
     * @see org.eclipse.scada.configuration.component.ScriptModule#getKnownOutputs()
     * @generated
     */
    EOperation getScriptModule__GetKnownOutputs ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.component.Script <em>Script</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Script</em>'.
     * @see org.eclipse.scada.configuration.component.Script
     * @generated
     */
    EClass getScript ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.component.Script#getCode <em>Code</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Code</em>'.
     * @see org.eclipse.scada.configuration.component.Script#getCode()
     * @see #getScript()
     * @generated
     */
    EAttribute getScript_Code ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.component.AbsoluteDanglingReference <em>Absolute Dangling Reference</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Absolute Dangling Reference</em>'.
     * @see org.eclipse.scada.configuration.component.AbsoluteDanglingReference
     * @generated
     */
    EClass getAbsoluteDanglingReference ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.component.ComponentDanglingReference <em>Dangling Reference</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Dangling Reference</em>'.
     * @see org.eclipse.scada.configuration.component.ComponentDanglingReference
     * @generated
     */
    EClass getComponentDanglingReference ();

    /**
     * Returns the meta object for the attribute list '{@link org.eclipse.scada.configuration.component.ComponentDanglingReference#getLocalTag <em>Local Tag</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute list '<em>Local Tag</em>'.
     * @see org.eclipse.scada.configuration.component.ComponentDanglingReference#getLocalTag()
     * @see #getComponentDanglingReference()
     * @generated
     */
    EAttribute getComponentDanglingReference_LocalTag ();

    /**
     * Returns the meta object for the reference '{@link org.eclipse.scada.configuration.component.ComponentDanglingReference#getComponent <em>Component</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Component</em>'.
     * @see org.eclipse.scada.configuration.component.ComponentDanglingReference#getComponent()
     * @see #getComponentDanglingReference()
     * @generated
     */
    EReference getComponentDanglingReference_Component ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.component.ExternalValue <em>External Value</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>External Value</em>'.
     * @see org.eclipse.scada.configuration.component.ExternalValue
     * @generated
     */
    EClass getExternalValue ();

    /**
     * Returns the meta object for the reference '{@link org.eclipse.scada.configuration.component.ExternalValue#getConnection <em>Connection</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Connection</em>'.
     * @see org.eclipse.scada.configuration.component.ExternalValue#getConnection()
     * @see #getExternalValue()
     * @generated
     */
    EReference getExternalValue_Connection ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.component.ExternalValue#getSourceName <em>Source Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Source Name</em>'.
     * @see org.eclipse.scada.configuration.component.ExternalValue#getSourceName()
     * @see #getExternalValue()
     * @generated
     */
    EAttribute getExternalValue_SourceName ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.component.SummariesConfiguration <em>Summaries Configuration</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Summaries Configuration</em>'.
     * @see org.eclipse.scada.configuration.component.SummariesConfiguration
     * @generated
     */
    EClass getSummariesConfiguration ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.component.SummariesConfiguration#getItemThreshold <em>Item Threshold</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Item Threshold</em>'.
     * @see org.eclipse.scada.configuration.component.SummariesConfiguration#getItemThreshold()
     * @see #getSummariesConfiguration()
     * @generated
     */
    EAttribute getSummariesConfiguration_ItemThreshold ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.component.ItemInterceptor <em>Item Interceptor</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Item Interceptor</em>'.
     * @see org.eclipse.scada.configuration.component.ItemInterceptor
     * @generated
     */
    EClass getItemInterceptor ();

    /**
     * Returns the meta object for the reference list '{@link org.eclipse.scada.configuration.component.ItemInterceptor#getMasterOn <em>Master On</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Master On</em>'.
     * @see org.eclipse.scada.configuration.component.ItemInterceptor#getMasterOn()
     * @see #getItemInterceptor()
     * @generated
     */
    EReference getItemInterceptor_MasterOn ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.component.Container <em>Container</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Container</em>'.
     * @see org.eclipse.scada.configuration.component.Container
     * @generated
     */
    EClass getContainer ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.configuration.component.Container#getItemInterceptors <em>Item Interceptors</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Item Interceptors</em>'.
     * @see org.eclipse.scada.configuration.component.Container#getItemInterceptors()
     * @see #getContainer()
     * @generated
     */
    EReference getContainer_ItemInterceptors ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.component.RestInterceptor <em>Rest Interceptor</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Rest Interceptor</em>'.
     * @see org.eclipse.scada.configuration.component.RestInterceptor
     * @generated
     */
    EClass getRestInterceptor ();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.scada.configuration.component.RestInterceptor#getSelector <em>Selector</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Selector</em>'.
     * @see org.eclipse.scada.configuration.component.RestInterceptor#getSelector()
     * @see #getRestInterceptor()
     * @generated
     */
    EReference getRestInterceptor_Selector ();

    /**
     * Returns the meta object for the reference '{@link org.eclipse.scada.configuration.component.RestInterceptor#getDefinition <em>Definition</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Definition</em>'.
     * @see org.eclipse.scada.configuration.component.RestInterceptor#getDefinition()
     * @see #getRestInterceptor()
     * @generated
     */
    EReference getRestInterceptor_Definition ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.component.GlobalizeComponent <em>Globalize Component</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Globalize Component</em>'.
     * @see org.eclipse.scada.configuration.component.GlobalizeComponent
     * @generated
     */
    EClass getGlobalizeComponent ();

    /**
     * Returns the meta object for the reference list '{@link org.eclipse.scada.configuration.component.GlobalizeComponent#getComponents <em>Components</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Components</em>'.
     * @see org.eclipse.scada.configuration.component.GlobalizeComponent#getComponents()
     * @see #getGlobalizeComponent()
     * @generated
     */
    EReference getGlobalizeComponent_Components ();

    /**
     * Returns the meta object for the reference '{@link org.eclipse.scada.configuration.component.GlobalizeComponent#getSourceMaster <em>Source Master</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Source Master</em>'.
     * @see org.eclipse.scada.configuration.component.GlobalizeComponent#getSourceMaster()
     * @see #getGlobalizeComponent()
     * @generated
     */
    EReference getGlobalizeComponent_SourceMaster ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.component.TransientValue <em>Transient Value</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Transient Value</em>'.
     * @see org.eclipse.scada.configuration.component.TransientValue
     * @generated
     */
    EClass getTransientValue ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.component.MasterComponent <em>Master Component</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Master Component</em>'.
     * @see org.eclipse.scada.configuration.component.MasterComponent
     * @generated
     */
    EClass getMasterComponent ();

    /**
     * Returns the meta object for the reference list '{@link org.eclipse.scada.configuration.component.MasterComponent#getMasterOn <em>Master On</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Master On</em>'.
     * @see org.eclipse.scada.configuration.component.MasterComponent#getMasterOn()
     * @see #getMasterComponent()
     * @generated
     */
    EReference getMasterComponent_MasterOn ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.component.BufferedValue <em>Buffered Value</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Buffered Value</em>'.
     * @see org.eclipse.scada.configuration.component.BufferedValue
     * @generated
     */
    EClass getBufferedValue ();

    /**
     * Returns the meta object for the reference '{@link org.eclipse.scada.configuration.component.BufferedValue#getInput <em>Input</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Input</em>'.
     * @see org.eclipse.scada.configuration.component.BufferedValue#getInput()
     * @see #getBufferedValue()
     * @generated
     */
    EReference getBufferedValue_Input ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.component.BufferedValue#getRange <em>Range</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Range</em>'.
     * @see org.eclipse.scada.configuration.component.BufferedValue#getRange()
     * @see #getBufferedValue()
     * @generated
     */
    EAttribute getBufferedValue_Range ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.component.BufferedValue#getInitialValue <em>Initial Value</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Initial Value</em>'.
     * @see org.eclipse.scada.configuration.component.BufferedValue#getInitialValue()
     * @see #getBufferedValue()
     * @generated
     */
    EAttribute getBufferedValue_InitialValue ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.component.BufferedValue#getPersistence <em>Persistence</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Persistence</em>'.
     * @see org.eclipse.scada.configuration.component.BufferedValue#getPersistence()
     * @see #getBufferedValue()
     * @generated
     */
    EAttribute getBufferedValue_Persistence ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.component.BufferedValue#isTriggerOnly <em>Trigger Only</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Trigger Only</em>'.
     * @see org.eclipse.scada.configuration.component.BufferedValue#isTriggerOnly()
     * @see #getBufferedValue()
     * @generated
     */
    EAttribute getBufferedValue_TriggerOnly ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.component.ChangeCounter <em>Change Counter</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Change Counter</em>'.
     * @see org.eclipse.scada.configuration.component.ChangeCounter
     * @generated
     */
    EClass getChangeCounter ();

    /**
     * Returns the meta object for the reference '{@link org.eclipse.scada.configuration.component.ChangeCounter#getBuffer <em>Buffer</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Buffer</em>'.
     * @see org.eclipse.scada.configuration.component.ChangeCounter#getBuffer()
     * @see #getChangeCounter()
     * @generated
     */
    EReference getChangeCounter_Buffer ();

    /**
     * Returns the meta object for enum '{@link org.eclipse.scada.configuration.component.Persistence <em>Persistence</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for enum '<em>Persistence</em>'.
     * @see org.eclipse.scada.configuration.component.Persistence
     * @generated
     */
    EEnum getPersistence ();

    /**
     * Returns the meta object for data type '{@link org.eclipse.emf.common.notify.Notification <em>Notification</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for data type '<em>Notification</em>'.
     * @see org.eclipse.emf.common.notify.Notification
     * @model instanceClass="org.eclipse.emf.common.notify.Notification" serializeable="false"
     * @generated
     */
    EDataType getNotification ();

    /**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
    ComponentFactory getComponentFactory ();

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
         * The meta object literal for the '{@link org.eclipse.scada.configuration.component.impl.ComponentWorldImpl <em>World</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.component.impl.ComponentWorldImpl
         * @see org.eclipse.scada.configuration.component.impl.ComponentPackageImpl#getComponentWorld()
         * @generated
         */
        EClass COMPONENT_WORLD = eINSTANCE.getComponentWorld ();

        /**
         * The meta object literal for the '<em><b>Levels</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference COMPONENT_WORLD__LEVELS = eINSTANCE.getComponentWorld_Levels ();

        /**
         * The meta object literal for the '<em><b>Configurations</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference COMPONENT_WORLD__CONFIGURATIONS = eINSTANCE.getComponentWorld_Configurations ();

        /**
         * The meta object literal for the '<em><b>Services</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference COMPONENT_WORLD__SERVICES = eINSTANCE.getComponentWorld_Services ();

        /**
         * The meta object literal for the '<em><b>Infrastructure</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference COMPONENT_WORLD__INFRASTRUCTURE = eINSTANCE.getComponentWorld_Infrastructure ();

        /**
         * The meta object literal for the '<em><b>Default Customization Pipeline</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference COMPONENT_WORLD__DEFAULT_CUSTOMIZATION_PIPELINE = eINSTANCE.getComponentWorld_DefaultCustomizationPipeline ();

        /**
         * The meta object literal for the '<em><b>Default Archive Selector</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference COMPONENT_WORLD__DEFAULT_ARCHIVE_SELECTOR = eINSTANCE.getComponentWorld_DefaultArchiveSelector ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.component.impl.LevelImpl <em>Level</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.component.impl.LevelImpl
         * @see org.eclipse.scada.configuration.component.impl.ComponentPackageImpl#getLevel()
         * @generated
         */
        EClass LEVEL = eINSTANCE.getLevel ();

        /**
         * The meta object literal for the '<em><b>Components</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference LEVEL__COMPONENTS = eINSTANCE.getLevel_Components ();

        /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute LEVEL__NAME = eINSTANCE.getLevel_Name ();

        /**
         * The meta object literal for the '<em><b>Levels</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference LEVEL__LEVELS = eINSTANCE.getLevel_Levels ();

        /**
         * The meta object literal for the '<em><b>Parent</b></em>' container reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference LEVEL__PARENT = eINSTANCE.getLevel_Parent ();

        /**
         * The meta object literal for the '<em><b>Customization Pipeline</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference LEVEL__CUSTOMIZATION_PIPELINE = eINSTANCE.getLevel_CustomizationPipeline ();

        /**
         * The meta object literal for the '<em><b>Archive Selector</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference LEVEL__ARCHIVE_SELECTOR = eINSTANCE.getLevel_ArchiveSelector ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.component.impl.ComponentImpl <em>Component</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.component.impl.ComponentImpl
         * @see org.eclipse.scada.configuration.component.impl.ComponentPackageImpl#getComponent()
         * @generated
         */
        EClass COMPONENT = eINSTANCE.getComponent ();

        /**
         * The meta object literal for the '<em><b>Level</b></em>' container reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference COMPONENT__LEVEL = eINSTANCE.getComponent_Level ();

        /**
         * The meta object literal for the '<em><b>Customization Pipeline</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference COMPONENT__CUSTOMIZATION_PIPELINE = eINSTANCE.getComponent_CustomizationPipeline ();

        /**
         * The meta object literal for the '<em><b>Archive Selector</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference COMPONENT__ARCHIVE_SELECTOR = eINSTANCE.getComponent_ArchiveSelector ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.component.impl.DataComponentImpl <em>Data Component</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.component.impl.DataComponentImpl
         * @see org.eclipse.scada.configuration.component.impl.ComponentPackageImpl#getDataComponent()
         * @generated
         */
        EClass DATA_COMPONENT = eINSTANCE.getDataComponent ();

        /**
         * The meta object literal for the '<em><b>Get Master On</b></em>' operation.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EOperation DATA_COMPONENT___GET_MASTER_ON = eINSTANCE.getDataComponent__GetMasterOn ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.component.impl.ConfigurationImpl <em>Configuration</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.component.impl.ConfigurationImpl
         * @see org.eclipse.scada.configuration.component.impl.ComponentPackageImpl#getConfiguration()
         * @generated
         */
        EClass CONFIGURATION = eINSTANCE.getConfiguration ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.component.impl.ConstantValueImpl <em>Constant Value</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.component.impl.ConstantValueImpl
         * @see org.eclipse.scada.configuration.component.impl.ComponentPackageImpl#getConstantValue()
         * @generated
         */
        EClass CONSTANT_VALUE = eINSTANCE.getConstantValue ();

        /**
         * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute CONSTANT_VALUE__VALUE = eINSTANCE.getConstantValue_Value ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.component.impl.MarkerConfigurationImpl <em>Marker Configuration</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.component.impl.MarkerConfigurationImpl
         * @see org.eclipse.scada.configuration.component.impl.ComponentPackageImpl#getMarkerConfiguration()
         * @generated
         */
        EClass MARKER_CONFIGURATION = eINSTANCE.getMarkerConfiguration ();

        /**
         * The meta object literal for the '<em><b>Markers</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference MARKER_CONFIGURATION__MARKERS = eINSTANCE.getMarkerConfiguration_Markers ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.component.Service <em>Service</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.component.Service
         * @see org.eclipse.scada.configuration.component.impl.ComponentPackageImpl#getService()
         * @generated
         */
        EClass SERVICE = eINSTANCE.getService ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.component.impl.PersistentValueImpl <em>Persistent Value</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.component.impl.PersistentValueImpl
         * @see org.eclipse.scada.configuration.component.impl.ComponentPackageImpl#getPersistentValue()
         * @generated
         */
        EClass PERSISTENT_VALUE = eINSTANCE.getPersistentValue ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.component.impl.DriverConnectionAnalyzerImpl <em>Driver Connection Analyzer</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.component.impl.DriverConnectionAnalyzerImpl
         * @see org.eclipse.scada.configuration.component.impl.ComponentPackageImpl#getDriverConnectionAnalyzer()
         * @generated
         */
        EClass DRIVER_CONNECTION_ANALYZER = eINSTANCE.getDriverConnectionAnalyzer ();

        /**
         * The meta object literal for the '<em><b>Driver</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference DRIVER_CONNECTION_ANALYZER__DRIVER = eINSTANCE.getDriverConnectionAnalyzer_Driver ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.component.impl.MasterImportConnectionAnalyzerImpl <em>Master Import Connection Analyzer</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.component.impl.MasterImportConnectionAnalyzerImpl
         * @see org.eclipse.scada.configuration.component.impl.ComponentPackageImpl#getMasterImportConnectionAnalyzer()
         * @generated
         */
        EClass MASTER_IMPORT_CONNECTION_ANALYZER = eINSTANCE.getMasterImportConnectionAnalyzer ();

        /**
         * The meta object literal for the '<em><b>Connection</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference MASTER_IMPORT_CONNECTION_ANALYZER__CONNECTION = eINSTANCE.getMasterImportConnectionAnalyzer_Connection ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.component.impl.SingleValueImpl <em>Single Value</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.component.impl.SingleValueImpl
         * @see org.eclipse.scada.configuration.component.impl.ComponentPackageImpl#getSingleValue()
         * @generated
         */
        EClass SINGLE_VALUE = eINSTANCE.getSingleValue ();

        /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SINGLE_VALUE__NAME = eINSTANCE.getSingleValue_Name ();

        /**
         * The meta object literal for the '<em><b>Data Type</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SINGLE_VALUE__DATA_TYPE = eINSTANCE.getSingleValue_DataType ();

        /**
         * The meta object literal for the '<em><b>Customization Tags</b></em>' attribute list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SINGLE_VALUE__CUSTOMIZATION_TAGS = eINSTANCE.getSingleValue_CustomizationTags ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.component.impl.DataMapperAnalyzerImpl <em>Data Mapper Analyzer</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.component.impl.DataMapperAnalyzerImpl
         * @see org.eclipse.scada.configuration.component.impl.ComponentPackageImpl#getDataMapperAnalyzer()
         * @generated
         */
        EClass DATA_MAPPER_ANALYZER = eINSTANCE.getDataMapperAnalyzer ();

        /**
         * The meta object literal for the '<em><b>Data Mapper</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference DATA_MAPPER_ANALYZER__DATA_MAPPER = eINSTANCE.getDataMapperAnalyzer_DataMapper ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.component.impl.DataMapperServiceImpl <em>Data Mapper Service</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.component.impl.DataMapperServiceImpl
         * @see org.eclipse.scada.configuration.component.impl.ComponentPackageImpl#getDataMapperService()
         * @generated
         */
        EClass DATA_MAPPER_SERVICE = eINSTANCE.getDataMapperService ();

        /**
         * The meta object literal for the '<em><b>Data Mapper</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference DATA_MAPPER_SERVICE__DATA_MAPPER = eINSTANCE.getDataMapperService_DataMapper ();

        /**
         * The meta object literal for the '<em><b>Master On</b></em>' reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference DATA_MAPPER_SERVICE__MASTER_ON = eINSTANCE.getDataMapperService_MasterOn ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.component.impl.MappedSourceValueImpl <em>Mapped Source Value</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.component.impl.MappedSourceValueImpl
         * @see org.eclipse.scada.configuration.component.impl.ComponentPackageImpl#getMappedSourceValue()
         * @generated
         */
        EClass MAPPED_SOURCE_VALUE = eINSTANCE.getMappedSourceValue ();

        /**
         * The meta object literal for the '<em><b>Mapper</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference MAPPED_SOURCE_VALUE__MAPPER = eINSTANCE.getMappedSourceValue_Mapper ();

        /**
         * The meta object literal for the '<em><b>Input</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference MAPPED_SOURCE_VALUE__INPUT = eINSTANCE.getMappedSourceValue_Input ();

        /**
         * The meta object literal for the '<em><b>Customization Tags</b></em>' attribute list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute MAPPED_SOURCE_VALUE__CUSTOMIZATION_TAGS = eINSTANCE.getMappedSourceValue_CustomizationTags ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.component.impl.CalculationComponentImpl <em>Calculation Component</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.component.impl.CalculationComponentImpl
         * @see org.eclipse.scada.configuration.component.impl.ComponentPackageImpl#getCalculationComponent()
         * @generated
         */
        EClass CALCULATION_COMPONENT = eINSTANCE.getCalculationComponent ();

        /**
         * The meta object literal for the '<em><b>Implementation</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference CALCULATION_COMPONENT__IMPLEMENTATION = eINSTANCE.getCalculationComponent_Implementation ();

        /**
         * The meta object literal for the '<em><b>Outputs</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference CALCULATION_COMPONENT__OUTPUTS = eINSTANCE.getCalculationComponent_Outputs ();

        /**
         * The meta object literal for the '<em><b>Inputs</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference CALCULATION_COMPONENT__INPUTS = eINSTANCE.getCalculationComponent_Inputs ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.component.impl.CalculationModuleImpl <em>Calculation Module</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.component.impl.CalculationModuleImpl
         * @see org.eclipse.scada.configuration.component.impl.ComponentPackageImpl#getCalculationModule()
         * @generated
         */
        EClass CALCULATION_MODULE = eINSTANCE.getCalculationModule ();

        /**
         * The meta object literal for the '<em><b>Known Inputs</b></em>' reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference CALCULATION_MODULE__KNOWN_INPUTS = eINSTANCE.getCalculationModule_KnownInputs ();

        /**
         * The meta object literal for the '<em><b>Known Outputs</b></em>' reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference CALCULATION_MODULE__KNOWN_OUTPUTS = eINSTANCE.getCalculationModule_KnownOutputs ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.component.impl.InputSpecificationImpl <em>Input Specification</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.component.impl.InputSpecificationImpl
         * @see org.eclipse.scada.configuration.component.impl.ComponentPackageImpl#getInputSpecification()
         * @generated
         */
        EClass INPUT_SPECIFICATION = eINSTANCE.getInputSpecification ();

        /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute INPUT_SPECIFICATION__NAME = eINSTANCE.getInputSpecification_Name ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.component.impl.OutputSpecificationImpl <em>Output Specification</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.component.impl.OutputSpecificationImpl
         * @see org.eclipse.scada.configuration.component.impl.ComponentPackageImpl#getOutputSpecification()
         * @generated
         */
        EClass OUTPUT_SPECIFICATION = eINSTANCE.getOutputSpecification ();

        /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute OUTPUT_SPECIFICATION__NAME = eINSTANCE.getOutputSpecification_Name ();

        /**
         * The meta object literal for the '<em><b>Data Type</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute OUTPUT_SPECIFICATION__DATA_TYPE = eINSTANCE.getOutputSpecification_DataType ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.component.impl.OutputDefinitionImpl <em>Output Definition</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.component.impl.OutputDefinitionImpl
         * @see org.eclipse.scada.configuration.component.impl.ComponentPackageImpl#getOutputDefinition()
         * @generated
         */
        EClass OUTPUT_DEFINITION = eINSTANCE.getOutputDefinition ();

        /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute OUTPUT_DEFINITION__NAME = eINSTANCE.getOutputDefinition_Name ();

        /**
         * The meta object literal for the '<em><b>Local Tag</b></em>' attribute list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute OUTPUT_DEFINITION__LOCAL_TAG = eINSTANCE.getOutputDefinition_LocalTag ();

        /**
         * The meta object literal for the '<em><b>Customization Tags</b></em>' attribute list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute OUTPUT_DEFINITION__CUSTOMIZATION_TAGS = eINSTANCE.getOutputDefinition_CustomizationTags ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.component.impl.ItemReferenceInputDefinitionImpl <em>Item Reference Input Definition</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.component.impl.ItemReferenceInputDefinitionImpl
         * @see org.eclipse.scada.configuration.component.impl.ComponentPackageImpl#getItemReferenceInputDefinition()
         * @generated
         */
        EClass ITEM_REFERENCE_INPUT_DEFINITION = eINSTANCE.getItemReferenceInputDefinition ();

        /**
         * The meta object literal for the '<em><b>Item Id</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute ITEM_REFERENCE_INPUT_DEFINITION__ITEM_ID = eINSTANCE.getItemReferenceInputDefinition_ItemId ();

        /**
         * The meta object literal for the '<em><b>Create Reference</b></em>' operation.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EOperation ITEM_REFERENCE_INPUT_DEFINITION___CREATE_REFERENCE = eINSTANCE.getItemReferenceInputDefinition__CreateReference ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.component.impl.InputDefinitionImpl <em>Input Definition</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.component.impl.InputDefinitionImpl
         * @see org.eclipse.scada.configuration.component.impl.ComponentPackageImpl#getInputDefinition()
         * @generated
         */
        EClass INPUT_DEFINITION = eINSTANCE.getInputDefinition ();

        /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute INPUT_DEFINITION__NAME = eINSTANCE.getInputDefinition_Name ();

        /**
         * The meta object literal for the '<em><b>Create Reference</b></em>' operation.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EOperation INPUT_DEFINITION___CREATE_REFERENCE = eINSTANCE.getInputDefinition__CreateReference ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.component.impl.ComponentReferenceInputDefinitionImpl <em>Reference Input Definition</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.component.impl.ComponentReferenceInputDefinitionImpl
         * @see org.eclipse.scada.configuration.component.impl.ComponentPackageImpl#getComponentReferenceInputDefinition()
         * @generated
         */
        EClass COMPONENT_REFERENCE_INPUT_DEFINITION = eINSTANCE.getComponentReferenceInputDefinition ();

        /**
         * The meta object literal for the '<em><b>Component</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference COMPONENT_REFERENCE_INPUT_DEFINITION__COMPONENT = eINSTANCE.getComponentReferenceInputDefinition_Component ();

        /**
         * The meta object literal for the '<em><b>Local Tag</b></em>' attribute list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute COMPONENT_REFERENCE_INPUT_DEFINITION__LOCAL_TAG = eINSTANCE.getComponentReferenceInputDefinition_LocalTag ();

        /**
         * The meta object literal for the '<em><b>Create Reference</b></em>' operation.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EOperation COMPONENT_REFERENCE_INPUT_DEFINITION___CREATE_REFERENCE = eINSTANCE.getComponentReferenceInputDefinition__CreateReference ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.component.impl.FormulaModuleImpl <em>Formula Module</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.component.impl.FormulaModuleImpl
         * @see org.eclipse.scada.configuration.component.impl.ComponentPackageImpl#getFormulaModule()
         * @generated
         */
        EClass FORMULA_MODULE = eINSTANCE.getFormulaModule ();

        /**
         * The meta object literal for the '<em><b>Inputs</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference FORMULA_MODULE__INPUTS = eINSTANCE.getFormulaModule_Inputs ();

        /**
         * The meta object literal for the '<em><b>Update</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference FORMULA_MODULE__UPDATE = eINSTANCE.getFormulaModule_Update ();

        /**
         * The meta object literal for the '<em><b>Script Engine</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute FORMULA_MODULE__SCRIPT_ENGINE = eINSTANCE.getFormulaModule_ScriptEngine ();

        /**
         * The meta object literal for the '<em><b>Init</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference FORMULA_MODULE__INIT = eINSTANCE.getFormulaModule_Init ();

        /**
         * The meta object literal for the '<em><b>Get Known Inputs</b></em>' operation.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EOperation FORMULA_MODULE___GET_KNOWN_INPUTS = eINSTANCE.getFormulaModule__GetKnownInputs ();

        /**
         * The meta object literal for the '<em><b>Custom ENotify</b></em>' operation.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EOperation FORMULA_MODULE___CUSTOM_ENOTIFY__NOTIFICATION = eINSTANCE.getFormulaModule__CustomENotify__Notification ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.component.impl.AverageModuleImpl <em>Average Module</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.component.impl.AverageModuleImpl
         * @see org.eclipse.scada.configuration.component.impl.ComponentPackageImpl#getAverageModule()
         * @generated
         */
        EClass AVERAGE_MODULE = eINSTANCE.getAverageModule ();

        /**
         * The meta object literal for the '<em><b>Valid Sources Required</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute AVERAGE_MODULE__VALID_SOURCES_REQUIRED = eINSTANCE.getAverageModule_ValidSourcesRequired ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.component.impl.DanglingItemReferenceImpl <em>Dangling Item Reference</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.component.impl.DanglingItemReferenceImpl
         * @see org.eclipse.scada.configuration.component.impl.ComponentPackageImpl#getDanglingItemReference()
         * @generated
         */
        EClass DANGLING_ITEM_REFERENCE = eINSTANCE.getDanglingItemReference ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.component.impl.ScriptModuleImpl <em>Script Module</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.component.impl.ScriptModuleImpl
         * @see org.eclipse.scada.configuration.component.impl.ComponentPackageImpl#getScriptModule()
         * @generated
         */
        EClass SCRIPT_MODULE = eINSTANCE.getScriptModule ();

        /**
         * The meta object literal for the '<em><b>Inputs</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference SCRIPT_MODULE__INPUTS = eINSTANCE.getScriptModule_Inputs ();

        /**
         * The meta object literal for the '<em><b>Outputs</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference SCRIPT_MODULE__OUTPUTS = eINSTANCE.getScriptModule_Outputs ();

        /**
         * The meta object literal for the '<em><b>Script Engine</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SCRIPT_MODULE__SCRIPT_ENGINE = eINSTANCE.getScriptModule_ScriptEngine ();

        /**
         * The meta object literal for the '<em><b>Get Known Inputs</b></em>' operation.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EOperation SCRIPT_MODULE___GET_KNOWN_INPUTS = eINSTANCE.getScriptModule__GetKnownInputs ();

        /**
         * The meta object literal for the '<em><b>Custom ENotify</b></em>' operation.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EOperation SCRIPT_MODULE___CUSTOM_ENOTIFY__NOTIFICATION = eINSTANCE.getScriptModule__CustomENotify__Notification ();

        /**
         * The meta object literal for the '<em><b>Get Known Outputs</b></em>' operation.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EOperation SCRIPT_MODULE___GET_KNOWN_OUTPUTS = eINSTANCE.getScriptModule__GetKnownOutputs ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.component.impl.ScriptImpl <em>Script</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.component.impl.ScriptImpl
         * @see org.eclipse.scada.configuration.component.impl.ComponentPackageImpl#getScript()
         * @generated
         */
        EClass SCRIPT = eINSTANCE.getScript ();

        /**
         * The meta object literal for the '<em><b>Code</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SCRIPT__CODE = eINSTANCE.getScript_Code ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.component.impl.AbsoluteDanglingReferenceImpl <em>Absolute Dangling Reference</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.component.impl.AbsoluteDanglingReferenceImpl
         * @see org.eclipse.scada.configuration.component.impl.ComponentPackageImpl#getAbsoluteDanglingReference()
         * @generated
         */
        EClass ABSOLUTE_DANGLING_REFERENCE = eINSTANCE.getAbsoluteDanglingReference ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.component.impl.ComponentDanglingReferenceImpl <em>Dangling Reference</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.component.impl.ComponentDanglingReferenceImpl
         * @see org.eclipse.scada.configuration.component.impl.ComponentPackageImpl#getComponentDanglingReference()
         * @generated
         */
        EClass COMPONENT_DANGLING_REFERENCE = eINSTANCE.getComponentDanglingReference ();

        /**
         * The meta object literal for the '<em><b>Local Tag</b></em>' attribute list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute COMPONENT_DANGLING_REFERENCE__LOCAL_TAG = eINSTANCE.getComponentDanglingReference_LocalTag ();

        /**
         * The meta object literal for the '<em><b>Component</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference COMPONENT_DANGLING_REFERENCE__COMPONENT = eINSTANCE.getComponentDanglingReference_Component ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.component.impl.ExternalValueImpl <em>External Value</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.component.impl.ExternalValueImpl
         * @see org.eclipse.scada.configuration.component.impl.ComponentPackageImpl#getExternalValue()
         * @generated
         */
        EClass EXTERNAL_VALUE = eINSTANCE.getExternalValue ();

        /**
         * The meta object literal for the '<em><b>Connection</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference EXTERNAL_VALUE__CONNECTION = eINSTANCE.getExternalValue_Connection ();

        /**
         * The meta object literal for the '<em><b>Source Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EXTERNAL_VALUE__SOURCE_NAME = eINSTANCE.getExternalValue_SourceName ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.component.impl.SummariesConfigurationImpl <em>Summaries Configuration</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.component.impl.SummariesConfigurationImpl
         * @see org.eclipse.scada.configuration.component.impl.ComponentPackageImpl#getSummariesConfiguration()
         * @generated
         */
        EClass SUMMARIES_CONFIGURATION = eINSTANCE.getSummariesConfiguration ();

        /**
         * The meta object literal for the '<em><b>Item Threshold</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SUMMARIES_CONFIGURATION__ITEM_THRESHOLD = eINSTANCE.getSummariesConfiguration_ItemThreshold ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.component.ItemInterceptor <em>Item Interceptor</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.component.ItemInterceptor
         * @see org.eclipse.scada.configuration.component.impl.ComponentPackageImpl#getItemInterceptor()
         * @generated
         */
        EClass ITEM_INTERCEPTOR = eINSTANCE.getItemInterceptor ();

        /**
         * The meta object literal for the '<em><b>Master On</b></em>' reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference ITEM_INTERCEPTOR__MASTER_ON = eINSTANCE.getItemInterceptor_MasterOn ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.component.impl.ContainerImpl <em>Container</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.component.impl.ContainerImpl
         * @see org.eclipse.scada.configuration.component.impl.ComponentPackageImpl#getContainer()
         * @generated
         */
        EClass CONTAINER = eINSTANCE.getContainer ();

        /**
         * The meta object literal for the '<em><b>Item Interceptors</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference CONTAINER__ITEM_INTERCEPTORS = eINSTANCE.getContainer_ItemInterceptors ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.component.impl.RestInterceptorImpl <em>Rest Interceptor</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.component.impl.RestInterceptorImpl
         * @see org.eclipse.scada.configuration.component.impl.ComponentPackageImpl#getRestInterceptor()
         * @generated
         */
        EClass REST_INTERCEPTOR = eINSTANCE.getRestInterceptor ();

        /**
         * The meta object literal for the '<em><b>Selector</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference REST_INTERCEPTOR__SELECTOR = eINSTANCE.getRestInterceptor_Selector ();

        /**
         * The meta object literal for the '<em><b>Definition</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference REST_INTERCEPTOR__DEFINITION = eINSTANCE.getRestInterceptor_Definition ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.component.impl.GlobalizeComponentImpl <em>Globalize Component</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.component.impl.GlobalizeComponentImpl
         * @see org.eclipse.scada.configuration.component.impl.ComponentPackageImpl#getGlobalizeComponent()
         * @generated
         */
        EClass GLOBALIZE_COMPONENT = eINSTANCE.getGlobalizeComponent ();

        /**
         * The meta object literal for the '<em><b>Components</b></em>' reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference GLOBALIZE_COMPONENT__COMPONENTS = eINSTANCE.getGlobalizeComponent_Components ();

        /**
         * The meta object literal for the '<em><b>Source Master</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference GLOBALIZE_COMPONENT__SOURCE_MASTER = eINSTANCE.getGlobalizeComponent_SourceMaster ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.component.impl.TransientValueImpl <em>Transient Value</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.component.impl.TransientValueImpl
         * @see org.eclipse.scada.configuration.component.impl.ComponentPackageImpl#getTransientValue()
         * @generated
         */
        EClass TRANSIENT_VALUE = eINSTANCE.getTransientValue ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.component.impl.MasterComponentImpl <em>Master Component</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.component.impl.MasterComponentImpl
         * @see org.eclipse.scada.configuration.component.impl.ComponentPackageImpl#getMasterComponent()
         * @generated
         */
        EClass MASTER_COMPONENT = eINSTANCE.getMasterComponent ();

        /**
         * The meta object literal for the '<em><b>Master On</b></em>' reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference MASTER_COMPONENT__MASTER_ON = eINSTANCE.getMasterComponent_MasterOn ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.component.impl.BufferedValueImpl <em>Buffered Value</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.component.impl.BufferedValueImpl
         * @see org.eclipse.scada.configuration.component.impl.ComponentPackageImpl#getBufferedValue()
         * @generated
         */
        EClass BUFFERED_VALUE = eINSTANCE.getBufferedValue ();

        /**
         * The meta object literal for the '<em><b>Input</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference BUFFERED_VALUE__INPUT = eINSTANCE.getBufferedValue_Input ();

        /**
         * The meta object literal for the '<em><b>Range</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute BUFFERED_VALUE__RANGE = eINSTANCE.getBufferedValue_Range ();

        /**
         * The meta object literal for the '<em><b>Initial Value</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute BUFFERED_VALUE__INITIAL_VALUE = eINSTANCE.getBufferedValue_InitialValue ();

        /**
         * The meta object literal for the '<em><b>Persistence</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute BUFFERED_VALUE__PERSISTENCE = eINSTANCE.getBufferedValue_Persistence ();

        /**
         * The meta object literal for the '<em><b>Trigger Only</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute BUFFERED_VALUE__TRIGGER_ONLY = eINSTANCE.getBufferedValue_TriggerOnly ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.component.impl.ChangeCounterImpl <em>Change Counter</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.component.impl.ChangeCounterImpl
         * @see org.eclipse.scada.configuration.component.impl.ComponentPackageImpl#getChangeCounter()
         * @generated
         */
        EClass CHANGE_COUNTER = eINSTANCE.getChangeCounter ();

        /**
         * The meta object literal for the '<em><b>Buffer</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference CHANGE_COUNTER__BUFFER = eINSTANCE.getChangeCounter_Buffer ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.component.Persistence <em>Persistence</em>}' enum.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.component.Persistence
         * @see org.eclipse.scada.configuration.component.impl.ComponentPackageImpl#getPersistence()
         * @generated
         */
        EEnum PERSISTENCE = eINSTANCE.getPersistence ();

        /**
         * The meta object literal for the '<em>Notification</em>' data type.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.emf.common.notify.Notification
         * @see org.eclipse.scada.configuration.component.impl.ComponentPackageImpl#getNotification()
         * @generated
         */
        EDataType NOTIFICATION = eINSTANCE.getNotification ();

    }

} //ComponentPackage
