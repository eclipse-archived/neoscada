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
package org.eclipse.scada.configuration.driver.jdbc;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.scada.configuration.component.ComponentPackage;
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
 * @see org.eclipse.scada.configuration.driver.jdbc.JdbcFactory
 * @model kind="package"
 * @generated
 */
public interface JdbcPackage extends EPackage
{
    /**
     * The package name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNAME = "jdbc"; //$NON-NLS-1$

    /**
     * The package namespace URI.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_URI = "http://eclipse.org/SCADA/Configuration/Driver/JDBC"; //$NON-NLS-1$

    /**
     * The package namespace name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_PREFIX = "jdbc"; //$NON-NLS-1$

    /**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    JdbcPackage eINSTANCE = org.eclipse.scada.configuration.driver.jdbc.impl.JdbcPackageImpl.init ();

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.driver.jdbc.impl.JdbcDriverInstanceImpl <em>Driver Instance</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.driver.jdbc.impl.JdbcDriverInstanceImpl
     * @see org.eclipse.scada.configuration.driver.jdbc.impl.JdbcPackageImpl#getJdbcDriverInstance()
     * @generated
     */
    int JDBC_DRIVER_INSTANCE = 0;

    /**
     * The feature id for the '<em><b>Short Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int JDBC_DRIVER_INSTANCE__SHORT_DESCRIPTION = WorldPackage.COMMON_DRIVER__SHORT_DESCRIPTION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int JDBC_DRIVER_INSTANCE__NAME = WorldPackage.COMMON_DRIVER__NAME;

    /**
     * The feature id for the '<em><b>Password</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int JDBC_DRIVER_INSTANCE__PASSWORD = WorldPackage.COMMON_DRIVER__PASSWORD;

    /**
     * The feature id for the '<em><b>Endpoints</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int JDBC_DRIVER_INSTANCE__ENDPOINTS = WorldPackage.COMMON_DRIVER__ENDPOINTS;

    /**
     * The feature id for the '<em><b>Root</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int JDBC_DRIVER_INSTANCE__ROOT = WorldPackage.COMMON_DRIVER_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Driver Instance</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int JDBC_DRIVER_INSTANCE_FEATURE_COUNT = WorldPackage.COMMON_DRIVER_FEATURE_COUNT + 1;

    /**
     * The operation id for the '<em>Get Endpoints</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int JDBC_DRIVER_INSTANCE___GET_ENDPOINTS = WorldPackage.COMMON_DRIVER___GET_ENDPOINTS;

    /**
     * The number of operations of the '<em>Driver Instance</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int JDBC_DRIVER_INSTANCE_OPERATION_COUNT = WorldPackage.COMMON_DRIVER_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.driver.jdbc.impl.UpdateCommandImpl <em>Update Command</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.driver.jdbc.impl.UpdateCommandImpl
     * @see org.eclipse.scada.configuration.driver.jdbc.impl.JdbcPackageImpl#getUpdateCommand()
     * @generated
     */
    int UPDATE_COMMAND = 1;

    /**
     * The feature id for the '<em><b>Short Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int UPDATE_COMMAND__SHORT_DESCRIPTION = ComponentPackage.SINGLE_VALUE__SHORT_DESCRIPTION;

    /**
     * The feature id for the '<em><b>Level</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int UPDATE_COMMAND__LEVEL = ComponentPackage.SINGLE_VALUE__LEVEL;

    /**
     * The feature id for the '<em><b>Customization Pipeline</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int UPDATE_COMMAND__CUSTOMIZATION_PIPELINE = ComponentPackage.SINGLE_VALUE__CUSTOMIZATION_PIPELINE;

    /**
     * The feature id for the '<em><b>Archive Selector</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int UPDATE_COMMAND__ARCHIVE_SELECTOR = ComponentPackage.SINGLE_VALUE__ARCHIVE_SELECTOR;

    /**
     * The feature id for the '<em><b>Properties</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int UPDATE_COMMAND__PROPERTIES = ComponentPackage.SINGLE_VALUE__PROPERTIES;

    /**
     * The feature id for the '<em><b>Master On</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int UPDATE_COMMAND__MASTER_ON = ComponentPackage.SINGLE_VALUE__MASTER_ON;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int UPDATE_COMMAND__NAME = ComponentPackage.SINGLE_VALUE__NAME;

    /**
     * The feature id for the '<em><b>Data Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int UPDATE_COMMAND__DATA_TYPE = ComponentPackage.SINGLE_VALUE__DATA_TYPE;

    /**
     * The feature id for the '<em><b>Customization Tags</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int UPDATE_COMMAND__CUSTOMIZATION_TAGS = ComponentPackage.SINGLE_VALUE__CUSTOMIZATION_TAGS;

    /**
     * The feature id for the '<em><b>Sql</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int UPDATE_COMMAND__SQL = ComponentPackage.SINGLE_VALUE_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Database</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int UPDATE_COMMAND__DATABASE = ComponentPackage.SINGLE_VALUE_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Query Timeout</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int UPDATE_COMMAND__QUERY_TIMEOUT = ComponentPackage.SINGLE_VALUE_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Runs On</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int UPDATE_COMMAND__RUNS_ON = ComponentPackage.SINGLE_VALUE_FEATURE_COUNT + 3;

    /**
     * The feature id for the '<em><b>Mappings</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int UPDATE_COMMAND__MAPPINGS = ComponentPackage.SINGLE_VALUE_FEATURE_COUNT + 4;

    /**
     * The number of structural features of the '<em>Update Command</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int UPDATE_COMMAND_FEATURE_COUNT = ComponentPackage.SINGLE_VALUE_FEATURE_COUNT + 5;

    /**
     * The operation id for the '<em>Get Master On</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int UPDATE_COMMAND___GET_MASTER_ON = ComponentPackage.SINGLE_VALUE___GET_MASTER_ON;

    /**
     * The number of operations of the '<em>Update Command</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int UPDATE_COMMAND_OPERATION_COUNT = ComponentPackage.SINGLE_VALUE_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.driver.jdbc.impl.QueryComponentImpl <em>Query Component</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.driver.jdbc.impl.QueryComponentImpl
     * @see org.eclipse.scada.configuration.driver.jdbc.impl.JdbcPackageImpl#getQueryComponent()
     * @generated
     */
    int QUERY_COMPONENT = 2;

    /**
     * The feature id for the '<em><b>Short Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int QUERY_COMPONENT__SHORT_DESCRIPTION = ComponentPackage.MASTER_COMPONENT__SHORT_DESCRIPTION;

    /**
     * The feature id for the '<em><b>Level</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int QUERY_COMPONENT__LEVEL = ComponentPackage.MASTER_COMPONENT__LEVEL;

    /**
     * The feature id for the '<em><b>Customization Pipeline</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int QUERY_COMPONENT__CUSTOMIZATION_PIPELINE = ComponentPackage.MASTER_COMPONENT__CUSTOMIZATION_PIPELINE;

    /**
     * The feature id for the '<em><b>Archive Selector</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int QUERY_COMPONENT__ARCHIVE_SELECTOR = ComponentPackage.MASTER_COMPONENT__ARCHIVE_SELECTOR;

    /**
     * The feature id for the '<em><b>Properties</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int QUERY_COMPONENT__PROPERTIES = ComponentPackage.MASTER_COMPONENT__PROPERTIES;

    /**
     * The feature id for the '<em><b>Master On</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int QUERY_COMPONENT__MASTER_ON = ComponentPackage.MASTER_COMPONENT__MASTER_ON;

    /**
     * The feature id for the '<em><b>Sql</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int QUERY_COMPONENT__SQL = ComponentPackage.MASTER_COMPONENT_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Database</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int QUERY_COMPONENT__DATABASE = ComponentPackage.MASTER_COMPONENT_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Query Timeout</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int QUERY_COMPONENT__QUERY_TIMEOUT = ComponentPackage.MASTER_COMPONENT_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Runs On</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int QUERY_COMPONENT__RUNS_ON = ComponentPackage.MASTER_COMPONENT_FEATURE_COUNT + 3;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int QUERY_COMPONENT__NAME = ComponentPackage.MASTER_COMPONENT_FEATURE_COUNT + 4;

    /**
     * The feature id for the '<em><b>Mappings</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int QUERY_COMPONENT__MAPPINGS = ComponentPackage.MASTER_COMPONENT_FEATURE_COUNT + 5;

    /**
     * The feature id for the '<em><b>Period</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int QUERY_COMPONENT__PERIOD = ComponentPackage.MASTER_COMPONENT_FEATURE_COUNT + 6;

    /**
     * The feature id for the '<em><b>Default Customization Tags</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int QUERY_COMPONENT__DEFAULT_CUSTOMIZATION_TAGS = ComponentPackage.MASTER_COMPONENT_FEATURE_COUNT + 7;

    /**
     * The feature id for the '<em><b>Default Data Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int QUERY_COMPONENT__DEFAULT_DATA_TYPE = ComponentPackage.MASTER_COMPONENT_FEATURE_COUNT + 8;

    /**
     * The number of structural features of the '<em>Query Component</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int QUERY_COMPONENT_FEATURE_COUNT = ComponentPackage.MASTER_COMPONENT_FEATURE_COUNT + 9;

    /**
     * The operation id for the '<em>Get Master On</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int QUERY_COMPONENT___GET_MASTER_ON = ComponentPackage.MASTER_COMPONENT___GET_MASTER_ON;

    /**
     * The number of operations of the '<em>Query Component</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int QUERY_COMPONENT_OPERATION_COUNT = ComponentPackage.MASTER_COMPONENT_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.driver.jdbc.QueryBase <em>Query Base</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.driver.jdbc.QueryBase
     * @see org.eclipse.scada.configuration.driver.jdbc.impl.JdbcPackageImpl#getQueryBase()
     * @generated
     */
    int QUERY_BASE = 3;

    /**
     * The feature id for the '<em><b>Sql</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int QUERY_BASE__SQL = 0;

    /**
     * The feature id for the '<em><b>Database</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int QUERY_BASE__DATABASE = 1;

    /**
     * The feature id for the '<em><b>Query Timeout</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int QUERY_BASE__QUERY_TIMEOUT = 2;

    /**
     * The feature id for the '<em><b>Runs On</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int QUERY_BASE__RUNS_ON = 3;

    /**
     * The number of structural features of the '<em>Query Base</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int QUERY_BASE_FEATURE_COUNT = 4;

    /**
     * The number of operations of the '<em>Query Base</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int QUERY_BASE_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.driver.jdbc.impl.UpdateMappingImpl <em>Update Mapping</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.driver.jdbc.impl.UpdateMappingImpl
     * @see org.eclipse.scada.configuration.driver.jdbc.impl.JdbcPackageImpl#getUpdateMapping()
     * @generated
     */
    int UPDATE_MAPPING = 4;

    /**
     * The feature id for the '<em><b>Named Parameter</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int UPDATE_MAPPING__NAMED_PARAMETER = 0;

    /**
     * The number of structural features of the '<em>Update Mapping</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int UPDATE_MAPPING_FEATURE_COUNT = 1;

    /**
     * The number of operations of the '<em>Update Mapping</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int UPDATE_MAPPING_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.driver.jdbc.impl.ColumnMappingImpl <em>Column Mapping</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.driver.jdbc.impl.ColumnMappingImpl
     * @see org.eclipse.scada.configuration.driver.jdbc.impl.JdbcPackageImpl#getColumnMapping()
     * @generated
     */
    int COLUMN_MAPPING = 5;

    /**
     * The feature id for the '<em><b>Column Number</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLUMN_MAPPING__COLUMN_NUMBER = 0;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLUMN_MAPPING__NAME = 1;

    /**
     * The feature id for the '<em><b>Customization Tags</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLUMN_MAPPING__CUSTOMIZATION_TAGS = 2;

    /**
     * The feature id for the '<em><b>Data Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLUMN_MAPPING__DATA_TYPE = 3;

    /**
     * The number of structural features of the '<em>Column Mapping</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLUMN_MAPPING_FEATURE_COUNT = 4;

    /**
     * The number of operations of the '<em>Column Mapping</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLUMN_MAPPING_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.driver.jdbc.impl.JdbcDriverImpl <em>Driver</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.driver.jdbc.impl.JdbcDriverImpl
     * @see org.eclipse.scada.configuration.driver.jdbc.impl.JdbcPackageImpl#getJdbcDriver()
     * @generated
     */
    int JDBC_DRIVER = 6;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int JDBC_DRIVER__NAME = InfrastructurePackage.ABSTRACT_COMMON_DRIVER__NAME;

    /**
     * The feature id for the '<em><b>Node</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int JDBC_DRIVER__NODE = InfrastructurePackage.ABSTRACT_COMMON_DRIVER__NODE;

    /**
     * The feature id for the '<em><b>Port Number</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int JDBC_DRIVER__PORT_NUMBER = InfrastructurePackage.ABSTRACT_COMMON_DRIVER__PORT_NUMBER;

    /**
     * The number of structural features of the '<em>Driver</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int JDBC_DRIVER_FEATURE_COUNT = InfrastructurePackage.ABSTRACT_COMMON_DRIVER_FEATURE_COUNT + 0;

    /**
     * The number of operations of the '<em>Driver</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int JDBC_DRIVER_OPERATION_COUNT = InfrastructurePackage.ABSTRACT_COMMON_DRIVER_OPERATION_COUNT + 0;

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.driver.jdbc.JdbcDriverInstance <em>Driver Instance</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Driver Instance</em>'.
     * @see org.eclipse.scada.configuration.driver.jdbc.JdbcDriverInstance
     * @generated
     */
    EClass getJdbcDriverInstance ();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.scada.configuration.driver.jdbc.JdbcDriverInstance#getRoot <em>Root</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Root</em>'.
     * @see org.eclipse.scada.configuration.driver.jdbc.JdbcDriverInstance#getRoot()
     * @see #getJdbcDriverInstance()
     * @generated
     */
    EReference getJdbcDriverInstance_Root ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.driver.jdbc.UpdateCommand <em>Update Command</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Update Command</em>'.
     * @see org.eclipse.scada.configuration.driver.jdbc.UpdateCommand
     * @generated
     */
    EClass getUpdateCommand ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.configuration.driver.jdbc.UpdateCommand#getMappings <em>Mappings</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Mappings</em>'.
     * @see org.eclipse.scada.configuration.driver.jdbc.UpdateCommand#getMappings()
     * @see #getUpdateCommand()
     * @generated
     */
    EReference getUpdateCommand_Mappings ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.driver.jdbc.QueryComponent <em>Query Component</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Query Component</em>'.
     * @see org.eclipse.scada.configuration.driver.jdbc.QueryComponent
     * @generated
     */
    EClass getQueryComponent ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.driver.jdbc.QueryComponent#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see org.eclipse.scada.configuration.driver.jdbc.QueryComponent#getName()
     * @see #getQueryComponent()
     * @generated
     */
    EAttribute getQueryComponent_Name ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.configuration.driver.jdbc.QueryComponent#getMappings <em>Mappings</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Mappings</em>'.
     * @see org.eclipse.scada.configuration.driver.jdbc.QueryComponent#getMappings()
     * @see #getQueryComponent()
     * @generated
     */
    EReference getQueryComponent_Mappings ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.driver.jdbc.QueryComponent#getPeriod <em>Period</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Period</em>'.
     * @see org.eclipse.scada.configuration.driver.jdbc.QueryComponent#getPeriod()
     * @see #getQueryComponent()
     * @generated
     */
    EAttribute getQueryComponent_Period ();

    /**
     * Returns the meta object for the attribute list '{@link org.eclipse.scada.configuration.driver.jdbc.QueryComponent#getDefaultCustomizationTags <em>Default Customization Tags</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute list '<em>Default Customization Tags</em>'.
     * @see org.eclipse.scada.configuration.driver.jdbc.QueryComponent#getDefaultCustomizationTags()
     * @see #getQueryComponent()
     * @generated
     */
    EAttribute getQueryComponent_DefaultCustomizationTags ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.driver.jdbc.QueryComponent#getDefaultDataType <em>Default Data Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Default Data Type</em>'.
     * @see org.eclipse.scada.configuration.driver.jdbc.QueryComponent#getDefaultDataType()
     * @see #getQueryComponent()
     * @generated
     */
    EAttribute getQueryComponent_DefaultDataType ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.driver.jdbc.QueryBase <em>Query Base</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Query Base</em>'.
     * @see org.eclipse.scada.configuration.driver.jdbc.QueryBase
     * @generated
     */
    EClass getQueryBase ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.driver.jdbc.QueryBase#getSql <em>Sql</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Sql</em>'.
     * @see org.eclipse.scada.configuration.driver.jdbc.QueryBase#getSql()
     * @see #getQueryBase()
     * @generated
     */
    EAttribute getQueryBase_Sql ();

    /**
     * Returns the meta object for the reference '{@link org.eclipse.scada.configuration.driver.jdbc.QueryBase#getDatabase <em>Database</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Database</em>'.
     * @see org.eclipse.scada.configuration.driver.jdbc.QueryBase#getDatabase()
     * @see #getQueryBase()
     * @generated
     */
    EReference getQueryBase_Database ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.driver.jdbc.QueryBase#getQueryTimeout <em>Query Timeout</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Query Timeout</em>'.
     * @see org.eclipse.scada.configuration.driver.jdbc.QueryBase#getQueryTimeout()
     * @see #getQueryBase()
     * @generated
     */
    EAttribute getQueryBase_QueryTimeout ();

    /**
     * Returns the meta object for the reference '{@link org.eclipse.scada.configuration.driver.jdbc.QueryBase#getRunsOn <em>Runs On</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Runs On</em>'.
     * @see org.eclipse.scada.configuration.driver.jdbc.QueryBase#getRunsOn()
     * @see #getQueryBase()
     * @generated
     */
    EReference getQueryBase_RunsOn ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.driver.jdbc.UpdateMapping <em>Update Mapping</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Update Mapping</em>'.
     * @see org.eclipse.scada.configuration.driver.jdbc.UpdateMapping
     * @generated
     */
    EClass getUpdateMapping ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.driver.jdbc.UpdateMapping#getNamedParameter <em>Named Parameter</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Named Parameter</em>'.
     * @see org.eclipse.scada.configuration.driver.jdbc.UpdateMapping#getNamedParameter()
     * @see #getUpdateMapping()
     * @generated
     */
    EAttribute getUpdateMapping_NamedParameter ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.driver.jdbc.ColumnMapping <em>Column Mapping</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Column Mapping</em>'.
     * @see org.eclipse.scada.configuration.driver.jdbc.ColumnMapping
     * @generated
     */
    EClass getColumnMapping ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.driver.jdbc.ColumnMapping#getColumnNumber <em>Column Number</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Column Number</em>'.
     * @see org.eclipse.scada.configuration.driver.jdbc.ColumnMapping#getColumnNumber()
     * @see #getColumnMapping()
     * @generated
     */
    EAttribute getColumnMapping_ColumnNumber ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.driver.jdbc.ColumnMapping#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see org.eclipse.scada.configuration.driver.jdbc.ColumnMapping#getName()
     * @see #getColumnMapping()
     * @generated
     */
    EAttribute getColumnMapping_Name ();

    /**
     * Returns the meta object for the attribute list '{@link org.eclipse.scada.configuration.driver.jdbc.ColumnMapping#getCustomizationTags <em>Customization Tags</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute list '<em>Customization Tags</em>'.
     * @see org.eclipse.scada.configuration.driver.jdbc.ColumnMapping#getCustomizationTags()
     * @see #getColumnMapping()
     * @generated
     */
    EAttribute getColumnMapping_CustomizationTags ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.driver.jdbc.ColumnMapping#getDataType <em>Data Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Data Type</em>'.
     * @see org.eclipse.scada.configuration.driver.jdbc.ColumnMapping#getDataType()
     * @see #getColumnMapping()
     * @generated
     */
    EAttribute getColumnMapping_DataType ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.driver.jdbc.JdbcDriver <em>Driver</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Driver</em>'.
     * @see org.eclipse.scada.configuration.driver.jdbc.JdbcDriver
     * @generated
     */
    EClass getJdbcDriver ();

    /**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
    JdbcFactory getJdbcFactory ();

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
         * The meta object literal for the '{@link org.eclipse.scada.configuration.driver.jdbc.impl.JdbcDriverInstanceImpl <em>Driver Instance</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.driver.jdbc.impl.JdbcDriverInstanceImpl
         * @see org.eclipse.scada.configuration.driver.jdbc.impl.JdbcPackageImpl#getJdbcDriverInstance()
         * @generated
         */
        EClass JDBC_DRIVER_INSTANCE = eINSTANCE.getJdbcDriverInstance ();

        /**
         * The meta object literal for the '<em><b>Root</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference JDBC_DRIVER_INSTANCE__ROOT = eINSTANCE.getJdbcDriverInstance_Root ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.driver.jdbc.impl.UpdateCommandImpl <em>Update Command</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.driver.jdbc.impl.UpdateCommandImpl
         * @see org.eclipse.scada.configuration.driver.jdbc.impl.JdbcPackageImpl#getUpdateCommand()
         * @generated
         */
        EClass UPDATE_COMMAND = eINSTANCE.getUpdateCommand ();

        /**
         * The meta object literal for the '<em><b>Mappings</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference UPDATE_COMMAND__MAPPINGS = eINSTANCE.getUpdateCommand_Mappings ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.driver.jdbc.impl.QueryComponentImpl <em>Query Component</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.driver.jdbc.impl.QueryComponentImpl
         * @see org.eclipse.scada.configuration.driver.jdbc.impl.JdbcPackageImpl#getQueryComponent()
         * @generated
         */
        EClass QUERY_COMPONENT = eINSTANCE.getQueryComponent ();

        /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute QUERY_COMPONENT__NAME = eINSTANCE.getQueryComponent_Name ();

        /**
         * The meta object literal for the '<em><b>Mappings</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference QUERY_COMPONENT__MAPPINGS = eINSTANCE.getQueryComponent_Mappings ();

        /**
         * The meta object literal for the '<em><b>Period</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute QUERY_COMPONENT__PERIOD = eINSTANCE.getQueryComponent_Period ();

        /**
         * The meta object literal for the '<em><b>Default Customization Tags</b></em>' attribute list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute QUERY_COMPONENT__DEFAULT_CUSTOMIZATION_TAGS = eINSTANCE.getQueryComponent_DefaultCustomizationTags ();

        /**
         * The meta object literal for the '<em><b>Default Data Type</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute QUERY_COMPONENT__DEFAULT_DATA_TYPE = eINSTANCE.getQueryComponent_DefaultDataType ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.driver.jdbc.QueryBase <em>Query Base</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.driver.jdbc.QueryBase
         * @see org.eclipse.scada.configuration.driver.jdbc.impl.JdbcPackageImpl#getQueryBase()
         * @generated
         */
        EClass QUERY_BASE = eINSTANCE.getQueryBase ();

        /**
         * The meta object literal for the '<em><b>Sql</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute QUERY_BASE__SQL = eINSTANCE.getQueryBase_Sql ();

        /**
         * The meta object literal for the '<em><b>Database</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference QUERY_BASE__DATABASE = eINSTANCE.getQueryBase_Database ();

        /**
         * The meta object literal for the '<em><b>Query Timeout</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute QUERY_BASE__QUERY_TIMEOUT = eINSTANCE.getQueryBase_QueryTimeout ();

        /**
         * The meta object literal for the '<em><b>Runs On</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference QUERY_BASE__RUNS_ON = eINSTANCE.getQueryBase_RunsOn ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.driver.jdbc.impl.UpdateMappingImpl <em>Update Mapping</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.driver.jdbc.impl.UpdateMappingImpl
         * @see org.eclipse.scada.configuration.driver.jdbc.impl.JdbcPackageImpl#getUpdateMapping()
         * @generated
         */
        EClass UPDATE_MAPPING = eINSTANCE.getUpdateMapping ();

        /**
         * The meta object literal for the '<em><b>Named Parameter</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute UPDATE_MAPPING__NAMED_PARAMETER = eINSTANCE.getUpdateMapping_NamedParameter ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.driver.jdbc.impl.ColumnMappingImpl <em>Column Mapping</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.driver.jdbc.impl.ColumnMappingImpl
         * @see org.eclipse.scada.configuration.driver.jdbc.impl.JdbcPackageImpl#getColumnMapping()
         * @generated
         */
        EClass COLUMN_MAPPING = eINSTANCE.getColumnMapping ();

        /**
         * The meta object literal for the '<em><b>Column Number</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute COLUMN_MAPPING__COLUMN_NUMBER = eINSTANCE.getColumnMapping_ColumnNumber ();

        /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute COLUMN_MAPPING__NAME = eINSTANCE.getColumnMapping_Name ();

        /**
         * The meta object literal for the '<em><b>Customization Tags</b></em>' attribute list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute COLUMN_MAPPING__CUSTOMIZATION_TAGS = eINSTANCE.getColumnMapping_CustomizationTags ();

        /**
         * The meta object literal for the '<em><b>Data Type</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute COLUMN_MAPPING__DATA_TYPE = eINSTANCE.getColumnMapping_DataType ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.driver.jdbc.impl.JdbcDriverImpl <em>Driver</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.driver.jdbc.impl.JdbcDriverImpl
         * @see org.eclipse.scada.configuration.driver.jdbc.impl.JdbcPackageImpl#getJdbcDriver()
         * @generated
         */
        EClass JDBC_DRIVER = eINSTANCE.getJdbcDriver ();

    }

} //JdbcPackage
