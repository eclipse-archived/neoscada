/*******************************************************************************
 * Copyright (c) 2013 Jens Reimann and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Jens Reimann - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.jdbc.configuration;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

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
 * @see org.eclipse.scada.da.jdbc.configuration.ConfigurationFactory
 * @model kind="package"
 * @generated
 */
public interface ConfigurationPackage extends EPackage
{

    /**
     * The package name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNAME = "configuration"; //$NON-NLS-1$

    /**
     * The package namespace URI.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_URI = "http://openscada.org/DA/JDBC/Configuration"; //$NON-NLS-1$

    /**
     * The package namespace name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_PREFIX = "configuration"; //$NON-NLS-1$

    /**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    ConfigurationPackage eINSTANCE = org.eclipse.scada.da.jdbc.configuration.impl.ConfigurationPackageImpl.init ();

    /**
     * The meta object id for the '{@link org.eclipse.scada.da.jdbc.configuration.impl.AbstractQueryTypeImpl <em>Abstract Query Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.da.jdbc.configuration.impl.AbstractQueryTypeImpl
     * @see org.eclipse.scada.da.jdbc.configuration.impl.ConfigurationPackageImpl#getAbstractQueryType()
     * @generated
     */
    int ABSTRACT_QUERY_TYPE = 0;

    /**
     * The feature id for the '<em><b>Sql</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_QUERY_TYPE__SQL = 0;

    /**
     * The feature id for the '<em><b>Column Mapping</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_QUERY_TYPE__COLUMN_MAPPING = 1;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_QUERY_TYPE__ID = 2;

    /**
     * The feature id for the '<em><b>Period</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_QUERY_TYPE__PERIOD = 3;

    /**
     * The feature id for the '<em><b>Sql1</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_QUERY_TYPE__SQL1 = 4;

    /**
     * The number of structural features of the '<em>Abstract Query Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_QUERY_TYPE_FEATURE_COUNT = 5;

    /**
     * The number of operations of the '<em>Abstract Query Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_QUERY_TYPE_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.da.jdbc.configuration.impl.ColumnMappingTypeImpl <em>Column Mapping Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.da.jdbc.configuration.impl.ColumnMappingTypeImpl
     * @see org.eclipse.scada.da.jdbc.configuration.impl.ConfigurationPackageImpl#getColumnMappingType()
     * @generated
     */
    int COLUMN_MAPPING_TYPE = 1;

    /**
     * The feature id for the '<em><b>Alias Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLUMN_MAPPING_TYPE__ALIAS_NAME = 0;

    /**
     * The feature id for the '<em><b>Column Number</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLUMN_MAPPING_TYPE__COLUMN_NUMBER = 1;

    /**
     * The number of structural features of the '<em>Column Mapping Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLUMN_MAPPING_TYPE_FEATURE_COUNT = 2;

    /**
     * The number of operations of the '<em>Column Mapping Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLUMN_MAPPING_TYPE_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.da.jdbc.configuration.impl.CommandsTypeImpl <em>Commands Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.da.jdbc.configuration.impl.CommandsTypeImpl
     * @see org.eclipse.scada.da.jdbc.configuration.impl.ConfigurationPackageImpl#getCommandsType()
     * @generated
     */
    int COMMANDS_TYPE = 2;

    /**
     * The feature id for the '<em><b>Sql</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COMMANDS_TYPE__SQL = 0;

    /**
     * The feature id for the '<em><b>Local Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COMMANDS_TYPE__LOCAL_NAME = 1;

    /**
     * The feature id for the '<em><b>Sql1</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COMMANDS_TYPE__SQL1 = 2;

    /**
     * The number of structural features of the '<em>Commands Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COMMANDS_TYPE_FEATURE_COUNT = 3;

    /**
     * The number of operations of the '<em>Commands Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COMMANDS_TYPE_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.da.jdbc.configuration.impl.ConnectionTypeImpl <em>Connection Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.da.jdbc.configuration.impl.ConnectionTypeImpl
     * @see org.eclipse.scada.da.jdbc.configuration.impl.ConfigurationPackageImpl#getConnectionType()
     * @generated
     */
    int CONNECTION_TYPE = 3;

    /**
     * The feature id for the '<em><b>Query</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONNECTION_TYPE__QUERY = 0;

    /**
     * The feature id for the '<em><b>Tabular Query</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONNECTION_TYPE__TABULAR_QUERY = 1;

    /**
     * The feature id for the '<em><b>Update</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONNECTION_TYPE__UPDATE = 2;

    /**
     * The feature id for the '<em><b>Connection Class</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONNECTION_TYPE__CONNECTION_CLASS = 3;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONNECTION_TYPE__ID = 4;

    /**
     * The feature id for the '<em><b>Password</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONNECTION_TYPE__PASSWORD = 5;

    /**
     * The feature id for the '<em><b>Timeout</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONNECTION_TYPE__TIMEOUT = 6;

    /**
     * The feature id for the '<em><b>Uri</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONNECTION_TYPE__URI = 7;

    /**
     * The feature id for the '<em><b>Username</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONNECTION_TYPE__USERNAME = 8;

    /**
     * The number of structural features of the '<em>Connection Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONNECTION_TYPE_FEATURE_COUNT = 9;

    /**
     * The number of operations of the '<em>Connection Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONNECTION_TYPE_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.da.jdbc.configuration.impl.DocumentRootImpl <em>Document Root</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.da.jdbc.configuration.impl.DocumentRootImpl
     * @see org.eclipse.scada.da.jdbc.configuration.impl.ConfigurationPackageImpl#getDocumentRoot()
     * @generated
     */
    int DOCUMENT_ROOT = 4;

    /**
     * The feature id for the '<em><b>Mixed</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DOCUMENT_ROOT__MIXED = 0;

    /**
     * The feature id for the '<em><b>XMLNS Prefix Map</b></em>' map.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DOCUMENT_ROOT__XMLNS_PREFIX_MAP = 1;

    /**
     * The feature id for the '<em><b>XSI Schema Location</b></em>' map.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DOCUMENT_ROOT__XSI_SCHEMA_LOCATION = 2;

    /**
     * The feature id for the '<em><b>Root</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DOCUMENT_ROOT__ROOT = 3;

    /**
     * The number of structural features of the '<em>Document Root</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DOCUMENT_ROOT_FEATURE_COUNT = 4;

    /**
     * The number of operations of the '<em>Document Root</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DOCUMENT_ROOT_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.da.jdbc.configuration.impl.QueryTypeImpl <em>Query Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.da.jdbc.configuration.impl.QueryTypeImpl
     * @see org.eclipse.scada.da.jdbc.configuration.impl.ConfigurationPackageImpl#getQueryType()
     * @generated
     */
    int QUERY_TYPE = 5;

    /**
     * The feature id for the '<em><b>Sql</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int QUERY_TYPE__SQL = ABSTRACT_QUERY_TYPE__SQL;

    /**
     * The feature id for the '<em><b>Column Mapping</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int QUERY_TYPE__COLUMN_MAPPING = ABSTRACT_QUERY_TYPE__COLUMN_MAPPING;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int QUERY_TYPE__ID = ABSTRACT_QUERY_TYPE__ID;

    /**
     * The feature id for the '<em><b>Period</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int QUERY_TYPE__PERIOD = ABSTRACT_QUERY_TYPE__PERIOD;

    /**
     * The feature id for the '<em><b>Sql1</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int QUERY_TYPE__SQL1 = ABSTRACT_QUERY_TYPE__SQL1;

    /**
     * The number of structural features of the '<em>Query Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int QUERY_TYPE_FEATURE_COUNT = ABSTRACT_QUERY_TYPE_FEATURE_COUNT + 0;

    /**
     * The number of operations of the '<em>Query Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int QUERY_TYPE_OPERATION_COUNT = ABSTRACT_QUERY_TYPE_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.da.jdbc.configuration.impl.RootTypeImpl <em>Root Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.da.jdbc.configuration.impl.RootTypeImpl
     * @see org.eclipse.scada.da.jdbc.configuration.impl.ConfigurationPackageImpl#getRootType()
     * @generated
     */
    int ROOT_TYPE = 6;

    /**
     * The feature id for the '<em><b>Connection</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ROOT_TYPE__CONNECTION = 0;

    /**
     * The number of structural features of the '<em>Root Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ROOT_TYPE_FEATURE_COUNT = 1;

    /**
     * The number of operations of the '<em>Root Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ROOT_TYPE_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.da.jdbc.configuration.impl.TabularQueryTypeImpl <em>Tabular Query Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.da.jdbc.configuration.impl.TabularQueryTypeImpl
     * @see org.eclipse.scada.da.jdbc.configuration.impl.ConfigurationPackageImpl#getTabularQueryType()
     * @generated
     */
    int TABULAR_QUERY_TYPE = 7;

    /**
     * The feature id for the '<em><b>Sql</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TABULAR_QUERY_TYPE__SQL = ABSTRACT_QUERY_TYPE__SQL;

    /**
     * The feature id for the '<em><b>Column Mapping</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TABULAR_QUERY_TYPE__COLUMN_MAPPING = ABSTRACT_QUERY_TYPE__COLUMN_MAPPING;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TABULAR_QUERY_TYPE__ID = ABSTRACT_QUERY_TYPE__ID;

    /**
     * The feature id for the '<em><b>Period</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TABULAR_QUERY_TYPE__PERIOD = ABSTRACT_QUERY_TYPE__PERIOD;

    /**
     * The feature id for the '<em><b>Sql1</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TABULAR_QUERY_TYPE__SQL1 = ABSTRACT_QUERY_TYPE__SQL1;

    /**
     * The feature id for the '<em><b>Update Columns</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TABULAR_QUERY_TYPE__UPDATE_COLUMNS = ABSTRACT_QUERY_TYPE_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Default Update Sql</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TABULAR_QUERY_TYPE__DEFAULT_UPDATE_SQL = ABSTRACT_QUERY_TYPE_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Commands</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TABULAR_QUERY_TYPE__COMMANDS = ABSTRACT_QUERY_TYPE_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Default Update Sql1</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TABULAR_QUERY_TYPE__DEFAULT_UPDATE_SQL1 = ABSTRACT_QUERY_TYPE_FEATURE_COUNT + 3;

    /**
     * The feature id for the '<em><b>Id Column</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TABULAR_QUERY_TYPE__ID_COLUMN = ABSTRACT_QUERY_TYPE_FEATURE_COUNT + 4;

    /**
     * The number of structural features of the '<em>Tabular Query Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TABULAR_QUERY_TYPE_FEATURE_COUNT = ABSTRACT_QUERY_TYPE_FEATURE_COUNT + 5;

    /**
     * The number of operations of the '<em>Tabular Query Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TABULAR_QUERY_TYPE_OPERATION_COUNT = ABSTRACT_QUERY_TYPE_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.da.jdbc.configuration.impl.UpdateColumnsTypeImpl <em>Update Columns Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.da.jdbc.configuration.impl.UpdateColumnsTypeImpl
     * @see org.eclipse.scada.da.jdbc.configuration.impl.ConfigurationPackageImpl#getUpdateColumnsType()
     * @generated
     */
    int UPDATE_COLUMNS_TYPE = 8;

    /**
     * The feature id for the '<em><b>Column Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int UPDATE_COLUMNS_TYPE__COLUMN_NAME = 0;

    /**
     * The feature id for the '<em><b>Custom Update Sql</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int UPDATE_COLUMNS_TYPE__CUSTOM_UPDATE_SQL = 1;

    /**
     * The number of structural features of the '<em>Update Columns Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int UPDATE_COLUMNS_TYPE_FEATURE_COUNT = 2;

    /**
     * The number of operations of the '<em>Update Columns Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int UPDATE_COLUMNS_TYPE_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.da.jdbc.configuration.impl.UpdateMappingTypeImpl <em>Update Mapping Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.da.jdbc.configuration.impl.UpdateMappingTypeImpl
     * @see org.eclipse.scada.da.jdbc.configuration.impl.ConfigurationPackageImpl#getUpdateMappingType()
     * @generated
     */
    int UPDATE_MAPPING_TYPE = 9;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int UPDATE_MAPPING_TYPE__NAME = 0;

    /**
     * The feature id for the '<em><b>Named Parameter</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int UPDATE_MAPPING_TYPE__NAMED_PARAMETER = 1;

    /**
     * The number of structural features of the '<em>Update Mapping Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int UPDATE_MAPPING_TYPE_FEATURE_COUNT = 2;

    /**
     * The number of operations of the '<em>Update Mapping Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int UPDATE_MAPPING_TYPE_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.da.jdbc.configuration.impl.UpdateTypeImpl <em>Update Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.da.jdbc.configuration.impl.UpdateTypeImpl
     * @see org.eclipse.scada.da.jdbc.configuration.impl.ConfigurationPackageImpl#getUpdateType()
     * @generated
     */
    int UPDATE_TYPE = 10;

    /**
     * The feature id for the '<em><b>Sql</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int UPDATE_TYPE__SQL = 0;

    /**
     * The feature id for the '<em><b>Mapping</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int UPDATE_TYPE__MAPPING = 1;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int UPDATE_TYPE__ID = 2;

    /**
     * The feature id for the '<em><b>Sql1</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int UPDATE_TYPE__SQL1 = 3;

    /**
     * The number of structural features of the '<em>Update Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int UPDATE_TYPE_FEATURE_COUNT = 4;

    /**
     * The number of operations of the '<em>Update Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int UPDATE_TYPE_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '<em>Alias Name Type</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see java.lang.String
     * @see org.eclipse.scada.da.jdbc.configuration.impl.ConfigurationPackageImpl#getAliasNameType()
     * @generated
     */
    int ALIAS_NAME_TYPE = 11;

    /**
     * The meta object id for the '<em>Column Number Type</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.da.jdbc.configuration.impl.ConfigurationPackageImpl#getColumnNumberType()
     * @generated
     */
    int COLUMN_NUMBER_TYPE = 12;

    /**
     * The meta object id for the '<em>Column Number Type Object</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see java.lang.Integer
     * @see org.eclipse.scada.da.jdbc.configuration.impl.ConfigurationPackageImpl#getColumnNumberTypeObject()
     * @generated
     */
    int COLUMN_NUMBER_TYPE_OBJECT = 13;

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.da.jdbc.configuration.AbstractQueryType <em>Abstract Query Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Abstract Query Type</em>'.
     * @see org.eclipse.scada.da.jdbc.configuration.AbstractQueryType
     * @generated
     */
    EClass getAbstractQueryType ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.da.jdbc.configuration.AbstractQueryType#getSql <em>Sql</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Sql</em>'.
     * @see org.eclipse.scada.da.jdbc.configuration.AbstractQueryType#getSql()
     * @see #getAbstractQueryType()
     * @generated
     */
    EAttribute getAbstractQueryType_Sql ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.da.jdbc.configuration.AbstractQueryType#getColumnMapping <em>Column Mapping</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Column Mapping</em>'.
     * @see org.eclipse.scada.da.jdbc.configuration.AbstractQueryType#getColumnMapping()
     * @see #getAbstractQueryType()
     * @generated
     */
    EReference getAbstractQueryType_ColumnMapping ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.da.jdbc.configuration.AbstractQueryType#getId <em>Id</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Id</em>'.
     * @see org.eclipse.scada.da.jdbc.configuration.AbstractQueryType#getId()
     * @see #getAbstractQueryType()
     * @generated
     */
    EAttribute getAbstractQueryType_Id ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.da.jdbc.configuration.AbstractQueryType#getPeriod <em>Period</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Period</em>'.
     * @see org.eclipse.scada.da.jdbc.configuration.AbstractQueryType#getPeriod()
     * @see #getAbstractQueryType()
     * @generated
     */
    EAttribute getAbstractQueryType_Period ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.da.jdbc.configuration.AbstractQueryType#getSql1 <em>Sql1</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Sql1</em>'.
     * @see org.eclipse.scada.da.jdbc.configuration.AbstractQueryType#getSql1()
     * @see #getAbstractQueryType()
     * @generated
     */
    EAttribute getAbstractQueryType_Sql1 ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.da.jdbc.configuration.ColumnMappingType <em>Column Mapping Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Column Mapping Type</em>'.
     * @see org.eclipse.scada.da.jdbc.configuration.ColumnMappingType
     * @generated
     */
    EClass getColumnMappingType ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.da.jdbc.configuration.ColumnMappingType#getAliasName <em>Alias Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Alias Name</em>'.
     * @see org.eclipse.scada.da.jdbc.configuration.ColumnMappingType#getAliasName()
     * @see #getColumnMappingType()
     * @generated
     */
    EAttribute getColumnMappingType_AliasName ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.da.jdbc.configuration.ColumnMappingType#getColumnNumber <em>Column Number</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Column Number</em>'.
     * @see org.eclipse.scada.da.jdbc.configuration.ColumnMappingType#getColumnNumber()
     * @see #getColumnMappingType()
     * @generated
     */
    EAttribute getColumnMappingType_ColumnNumber ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.da.jdbc.configuration.CommandsType <em>Commands Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Commands Type</em>'.
     * @see org.eclipse.scada.da.jdbc.configuration.CommandsType
     * @generated
     */
    EClass getCommandsType ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.da.jdbc.configuration.CommandsType#getSql <em>Sql</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Sql</em>'.
     * @see org.eclipse.scada.da.jdbc.configuration.CommandsType#getSql()
     * @see #getCommandsType()
     * @generated
     */
    EAttribute getCommandsType_Sql ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.da.jdbc.configuration.CommandsType#getLocalName <em>Local Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Local Name</em>'.
     * @see org.eclipse.scada.da.jdbc.configuration.CommandsType#getLocalName()
     * @see #getCommandsType()
     * @generated
     */
    EAttribute getCommandsType_LocalName ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.da.jdbc.configuration.CommandsType#getSql1 <em>Sql1</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Sql1</em>'.
     * @see org.eclipse.scada.da.jdbc.configuration.CommandsType#getSql1()
     * @see #getCommandsType()
     * @generated
     */
    EAttribute getCommandsType_Sql1 ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.da.jdbc.configuration.ConnectionType <em>Connection Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Connection Type</em>'.
     * @see org.eclipse.scada.da.jdbc.configuration.ConnectionType
     * @generated
     */
    EClass getConnectionType ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.da.jdbc.configuration.ConnectionType#getQuery <em>Query</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Query</em>'.
     * @see org.eclipse.scada.da.jdbc.configuration.ConnectionType#getQuery()
     * @see #getConnectionType()
     * @generated
     */
    EReference getConnectionType_Query ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.da.jdbc.configuration.ConnectionType#getTabularQuery <em>Tabular Query</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Tabular Query</em>'.
     * @see org.eclipse.scada.da.jdbc.configuration.ConnectionType#getTabularQuery()
     * @see #getConnectionType()
     * @generated
     */
    EReference getConnectionType_TabularQuery ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.da.jdbc.configuration.ConnectionType#getUpdate <em>Update</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Update</em>'.
     * @see org.eclipse.scada.da.jdbc.configuration.ConnectionType#getUpdate()
     * @see #getConnectionType()
     * @generated
     */
    EReference getConnectionType_Update ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.da.jdbc.configuration.ConnectionType#getConnectionClass <em>Connection Class</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Connection Class</em>'.
     * @see org.eclipse.scada.da.jdbc.configuration.ConnectionType#getConnectionClass()
     * @see #getConnectionType()
     * @generated
     */
    EAttribute getConnectionType_ConnectionClass ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.da.jdbc.configuration.ConnectionType#getId <em>Id</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Id</em>'.
     * @see org.eclipse.scada.da.jdbc.configuration.ConnectionType#getId()
     * @see #getConnectionType()
     * @generated
     */
    EAttribute getConnectionType_Id ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.da.jdbc.configuration.ConnectionType#getPassword <em>Password</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Password</em>'.
     * @see org.eclipse.scada.da.jdbc.configuration.ConnectionType#getPassword()
     * @see #getConnectionType()
     * @generated
     */
    EAttribute getConnectionType_Password ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.da.jdbc.configuration.ConnectionType#getTimeout <em>Timeout</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Timeout</em>'.
     * @see org.eclipse.scada.da.jdbc.configuration.ConnectionType#getTimeout()
     * @see #getConnectionType()
     * @generated
     */
    EAttribute getConnectionType_Timeout ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.da.jdbc.configuration.ConnectionType#getUri <em>Uri</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Uri</em>'.
     * @see org.eclipse.scada.da.jdbc.configuration.ConnectionType#getUri()
     * @see #getConnectionType()
     * @generated
     */
    EAttribute getConnectionType_Uri ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.da.jdbc.configuration.ConnectionType#getUsername <em>Username</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Username</em>'.
     * @see org.eclipse.scada.da.jdbc.configuration.ConnectionType#getUsername()
     * @see #getConnectionType()
     * @generated
     */
    EAttribute getConnectionType_Username ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.da.jdbc.configuration.DocumentRoot <em>Document Root</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Document Root</em>'.
     * @see org.eclipse.scada.da.jdbc.configuration.DocumentRoot
     * @generated
     */
    EClass getDocumentRoot ();

    /**
     * Returns the meta object for the attribute list '{@link org.eclipse.scada.da.jdbc.configuration.DocumentRoot#getMixed <em>Mixed</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute list '<em>Mixed</em>'.
     * @see org.eclipse.scada.da.jdbc.configuration.DocumentRoot#getMixed()
     * @see #getDocumentRoot()
     * @generated
     */
    EAttribute getDocumentRoot_Mixed ();

    /**
     * Returns the meta object for the map '{@link org.eclipse.scada.da.jdbc.configuration.DocumentRoot#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the map '<em>XMLNS Prefix Map</em>'.
     * @see org.eclipse.scada.da.jdbc.configuration.DocumentRoot#getXMLNSPrefixMap()
     * @see #getDocumentRoot()
     * @generated
     */
    EReference getDocumentRoot_XMLNSPrefixMap ();

    /**
     * Returns the meta object for the map '{@link org.eclipse.scada.da.jdbc.configuration.DocumentRoot#getXSISchemaLocation <em>XSI Schema Location</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the map '<em>XSI Schema Location</em>'.
     * @see org.eclipse.scada.da.jdbc.configuration.DocumentRoot#getXSISchemaLocation()
     * @see #getDocumentRoot()
     * @generated
     */
    EReference getDocumentRoot_XSISchemaLocation ();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.scada.da.jdbc.configuration.DocumentRoot#getRoot <em>Root</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Root</em>'.
     * @see org.eclipse.scada.da.jdbc.configuration.DocumentRoot#getRoot()
     * @see #getDocumentRoot()
     * @generated
     */
    EReference getDocumentRoot_Root ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.da.jdbc.configuration.QueryType <em>Query Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Query Type</em>'.
     * @see org.eclipse.scada.da.jdbc.configuration.QueryType
     * @generated
     */
    EClass getQueryType ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.da.jdbc.configuration.RootType <em>Root Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Root Type</em>'.
     * @see org.eclipse.scada.da.jdbc.configuration.RootType
     * @generated
     */
    EClass getRootType ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.da.jdbc.configuration.RootType#getConnection <em>Connection</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Connection</em>'.
     * @see org.eclipse.scada.da.jdbc.configuration.RootType#getConnection()
     * @see #getRootType()
     * @generated
     */
    EReference getRootType_Connection ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.da.jdbc.configuration.TabularQueryType <em>Tabular Query Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Tabular Query Type</em>'.
     * @see org.eclipse.scada.da.jdbc.configuration.TabularQueryType
     * @generated
     */
    EClass getTabularQueryType ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.da.jdbc.configuration.TabularQueryType#getUpdateColumns <em>Update Columns</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Update Columns</em>'.
     * @see org.eclipse.scada.da.jdbc.configuration.TabularQueryType#getUpdateColumns()
     * @see #getTabularQueryType()
     * @generated
     */
    EReference getTabularQueryType_UpdateColumns ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.da.jdbc.configuration.TabularQueryType#getDefaultUpdateSql <em>Default Update Sql</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Default Update Sql</em>'.
     * @see org.eclipse.scada.da.jdbc.configuration.TabularQueryType#getDefaultUpdateSql()
     * @see #getTabularQueryType()
     * @generated
     */
    EAttribute getTabularQueryType_DefaultUpdateSql ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.da.jdbc.configuration.TabularQueryType#getCommands <em>Commands</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Commands</em>'.
     * @see org.eclipse.scada.da.jdbc.configuration.TabularQueryType#getCommands()
     * @see #getTabularQueryType()
     * @generated
     */
    EReference getTabularQueryType_Commands ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.da.jdbc.configuration.TabularQueryType#getDefaultUpdateSql1 <em>Default Update Sql1</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Default Update Sql1</em>'.
     * @see org.eclipse.scada.da.jdbc.configuration.TabularQueryType#getDefaultUpdateSql1()
     * @see #getTabularQueryType()
     * @generated
     */
    EAttribute getTabularQueryType_DefaultUpdateSql1 ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.da.jdbc.configuration.TabularQueryType#getIdColumn <em>Id Column</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Id Column</em>'.
     * @see org.eclipse.scada.da.jdbc.configuration.TabularQueryType#getIdColumn()
     * @see #getTabularQueryType()
     * @generated
     */
    EAttribute getTabularQueryType_IdColumn ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.da.jdbc.configuration.UpdateColumnsType <em>Update Columns Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Update Columns Type</em>'.
     * @see org.eclipse.scada.da.jdbc.configuration.UpdateColumnsType
     * @generated
     */
    EClass getUpdateColumnsType ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.da.jdbc.configuration.UpdateColumnsType#getColumnName <em>Column Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Column Name</em>'.
     * @see org.eclipse.scada.da.jdbc.configuration.UpdateColumnsType#getColumnName()
     * @see #getUpdateColumnsType()
     * @generated
     */
    EAttribute getUpdateColumnsType_ColumnName ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.da.jdbc.configuration.UpdateColumnsType#getCustomUpdateSql <em>Custom Update Sql</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Custom Update Sql</em>'.
     * @see org.eclipse.scada.da.jdbc.configuration.UpdateColumnsType#getCustomUpdateSql()
     * @see #getUpdateColumnsType()
     * @generated
     */
    EAttribute getUpdateColumnsType_CustomUpdateSql ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.da.jdbc.configuration.UpdateMappingType <em>Update Mapping Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Update Mapping Type</em>'.
     * @see org.eclipse.scada.da.jdbc.configuration.UpdateMappingType
     * @generated
     */
    EClass getUpdateMappingType ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.da.jdbc.configuration.UpdateMappingType#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see org.eclipse.scada.da.jdbc.configuration.UpdateMappingType#getName()
     * @see #getUpdateMappingType()
     * @generated
     */
    EAttribute getUpdateMappingType_Name ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.da.jdbc.configuration.UpdateMappingType#getNamedParameter <em>Named Parameter</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Named Parameter</em>'.
     * @see org.eclipse.scada.da.jdbc.configuration.UpdateMappingType#getNamedParameter()
     * @see #getUpdateMappingType()
     * @generated
     */
    EAttribute getUpdateMappingType_NamedParameter ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.da.jdbc.configuration.UpdateType <em>Update Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Update Type</em>'.
     * @see org.eclipse.scada.da.jdbc.configuration.UpdateType
     * @generated
     */
    EClass getUpdateType ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.da.jdbc.configuration.UpdateType#getSql <em>Sql</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Sql</em>'.
     * @see org.eclipse.scada.da.jdbc.configuration.UpdateType#getSql()
     * @see #getUpdateType()
     * @generated
     */
    EAttribute getUpdateType_Sql ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.da.jdbc.configuration.UpdateType#getMapping <em>Mapping</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Mapping</em>'.
     * @see org.eclipse.scada.da.jdbc.configuration.UpdateType#getMapping()
     * @see #getUpdateType()
     * @generated
     */
    EReference getUpdateType_Mapping ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.da.jdbc.configuration.UpdateType#getId <em>Id</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Id</em>'.
     * @see org.eclipse.scada.da.jdbc.configuration.UpdateType#getId()
     * @see #getUpdateType()
     * @generated
     */
    EAttribute getUpdateType_Id ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.da.jdbc.configuration.UpdateType#getSql1 <em>Sql1</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Sql1</em>'.
     * @see org.eclipse.scada.da.jdbc.configuration.UpdateType#getSql1()
     * @see #getUpdateType()
     * @generated
     */
    EAttribute getUpdateType_Sql1 ();

    /**
     * Returns the meta object for data type '{@link java.lang.String <em>Alias Name Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for data type '<em>Alias Name Type</em>'.
     * @see java.lang.String
     * @model instanceClass="java.lang.String"
     *        extendedMetaData="name='aliasName_._type' baseType='http://www.eclipse.org/emf/2003/XMLType#string' minLength='1'"
     * @generated
     */
    EDataType getAliasNameType ();

    /**
     * Returns the meta object for data type '<em>Column Number Type</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for data type '<em>Column Number Type</em>'.
     * @model instanceClass="int"
     *        extendedMetaData="name='columnNumber_._type' baseType='http://www.eclipse.org/emf/2003/XMLType#int' minInclusive='1'"
     * @generated
     */
    EDataType getColumnNumberType ();

    /**
     * Returns the meta object for data type '{@link java.lang.Integer <em>Column Number Type Object</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for data type '<em>Column Number Type Object</em>'.
     * @see java.lang.Integer
     * @model instanceClass="java.lang.Integer"
     *        extendedMetaData="name='columnNumber_._type:Object' baseType='columnNumber_._type'"
     * @generated
     */
    EDataType getColumnNumberTypeObject ();

    /**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
    ConfigurationFactory getConfigurationFactory ();

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
         * The meta object literal for the '{@link org.eclipse.scada.da.jdbc.configuration.impl.AbstractQueryTypeImpl <em>Abstract Query Type</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.da.jdbc.configuration.impl.AbstractQueryTypeImpl
         * @see org.eclipse.scada.da.jdbc.configuration.impl.ConfigurationPackageImpl#getAbstractQueryType()
         * @generated
         */
        EClass ABSTRACT_QUERY_TYPE = eINSTANCE.getAbstractQueryType ();

        /**
         * The meta object literal for the '<em><b>Sql</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute ABSTRACT_QUERY_TYPE__SQL = eINSTANCE.getAbstractQueryType_Sql ();

        /**
         * The meta object literal for the '<em><b>Column Mapping</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference ABSTRACT_QUERY_TYPE__COLUMN_MAPPING = eINSTANCE.getAbstractQueryType_ColumnMapping ();

        /**
         * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute ABSTRACT_QUERY_TYPE__ID = eINSTANCE.getAbstractQueryType_Id ();

        /**
         * The meta object literal for the '<em><b>Period</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute ABSTRACT_QUERY_TYPE__PERIOD = eINSTANCE.getAbstractQueryType_Period ();

        /**
         * The meta object literal for the '<em><b>Sql1</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute ABSTRACT_QUERY_TYPE__SQL1 = eINSTANCE.getAbstractQueryType_Sql1 ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.da.jdbc.configuration.impl.ColumnMappingTypeImpl <em>Column Mapping Type</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.da.jdbc.configuration.impl.ColumnMappingTypeImpl
         * @see org.eclipse.scada.da.jdbc.configuration.impl.ConfigurationPackageImpl#getColumnMappingType()
         * @generated
         */
        EClass COLUMN_MAPPING_TYPE = eINSTANCE.getColumnMappingType ();

        /**
         * The meta object literal for the '<em><b>Alias Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute COLUMN_MAPPING_TYPE__ALIAS_NAME = eINSTANCE.getColumnMappingType_AliasName ();

        /**
         * The meta object literal for the '<em><b>Column Number</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute COLUMN_MAPPING_TYPE__COLUMN_NUMBER = eINSTANCE.getColumnMappingType_ColumnNumber ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.da.jdbc.configuration.impl.CommandsTypeImpl <em>Commands Type</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.da.jdbc.configuration.impl.CommandsTypeImpl
         * @see org.eclipse.scada.da.jdbc.configuration.impl.ConfigurationPackageImpl#getCommandsType()
         * @generated
         */
        EClass COMMANDS_TYPE = eINSTANCE.getCommandsType ();

        /**
         * The meta object literal for the '<em><b>Sql</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute COMMANDS_TYPE__SQL = eINSTANCE.getCommandsType_Sql ();

        /**
         * The meta object literal for the '<em><b>Local Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute COMMANDS_TYPE__LOCAL_NAME = eINSTANCE.getCommandsType_LocalName ();

        /**
         * The meta object literal for the '<em><b>Sql1</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute COMMANDS_TYPE__SQL1 = eINSTANCE.getCommandsType_Sql1 ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.da.jdbc.configuration.impl.ConnectionTypeImpl <em>Connection Type</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.da.jdbc.configuration.impl.ConnectionTypeImpl
         * @see org.eclipse.scada.da.jdbc.configuration.impl.ConfigurationPackageImpl#getConnectionType()
         * @generated
         */
        EClass CONNECTION_TYPE = eINSTANCE.getConnectionType ();

        /**
         * The meta object literal for the '<em><b>Query</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference CONNECTION_TYPE__QUERY = eINSTANCE.getConnectionType_Query ();

        /**
         * The meta object literal for the '<em><b>Tabular Query</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference CONNECTION_TYPE__TABULAR_QUERY = eINSTANCE.getConnectionType_TabularQuery ();

        /**
         * The meta object literal for the '<em><b>Update</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference CONNECTION_TYPE__UPDATE = eINSTANCE.getConnectionType_Update ();

        /**
         * The meta object literal for the '<em><b>Connection Class</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute CONNECTION_TYPE__CONNECTION_CLASS = eINSTANCE.getConnectionType_ConnectionClass ();

        /**
         * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute CONNECTION_TYPE__ID = eINSTANCE.getConnectionType_Id ();

        /**
         * The meta object literal for the '<em><b>Password</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute CONNECTION_TYPE__PASSWORD = eINSTANCE.getConnectionType_Password ();

        /**
         * The meta object literal for the '<em><b>Timeout</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute CONNECTION_TYPE__TIMEOUT = eINSTANCE.getConnectionType_Timeout ();

        /**
         * The meta object literal for the '<em><b>Uri</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute CONNECTION_TYPE__URI = eINSTANCE.getConnectionType_Uri ();

        /**
         * The meta object literal for the '<em><b>Username</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute CONNECTION_TYPE__USERNAME = eINSTANCE.getConnectionType_Username ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.da.jdbc.configuration.impl.DocumentRootImpl <em>Document Root</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.da.jdbc.configuration.impl.DocumentRootImpl
         * @see org.eclipse.scada.da.jdbc.configuration.impl.ConfigurationPackageImpl#getDocumentRoot()
         * @generated
         */
        EClass DOCUMENT_ROOT = eINSTANCE.getDocumentRoot ();

        /**
         * The meta object literal for the '<em><b>Mixed</b></em>' attribute list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute DOCUMENT_ROOT__MIXED = eINSTANCE.getDocumentRoot_Mixed ();

        /**
         * The meta object literal for the '<em><b>XMLNS Prefix Map</b></em>' map feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference DOCUMENT_ROOT__XMLNS_PREFIX_MAP = eINSTANCE.getDocumentRoot_XMLNSPrefixMap ();

        /**
         * The meta object literal for the '<em><b>XSI Schema Location</b></em>' map feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference DOCUMENT_ROOT__XSI_SCHEMA_LOCATION = eINSTANCE.getDocumentRoot_XSISchemaLocation ();

        /**
         * The meta object literal for the '<em><b>Root</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference DOCUMENT_ROOT__ROOT = eINSTANCE.getDocumentRoot_Root ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.da.jdbc.configuration.impl.QueryTypeImpl <em>Query Type</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.da.jdbc.configuration.impl.QueryTypeImpl
         * @see org.eclipse.scada.da.jdbc.configuration.impl.ConfigurationPackageImpl#getQueryType()
         * @generated
         */
        EClass QUERY_TYPE = eINSTANCE.getQueryType ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.da.jdbc.configuration.impl.RootTypeImpl <em>Root Type</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.da.jdbc.configuration.impl.RootTypeImpl
         * @see org.eclipse.scada.da.jdbc.configuration.impl.ConfigurationPackageImpl#getRootType()
         * @generated
         */
        EClass ROOT_TYPE = eINSTANCE.getRootType ();

        /**
         * The meta object literal for the '<em><b>Connection</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference ROOT_TYPE__CONNECTION = eINSTANCE.getRootType_Connection ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.da.jdbc.configuration.impl.TabularQueryTypeImpl <em>Tabular Query Type</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.da.jdbc.configuration.impl.TabularQueryTypeImpl
         * @see org.eclipse.scada.da.jdbc.configuration.impl.ConfigurationPackageImpl#getTabularQueryType()
         * @generated
         */
        EClass TABULAR_QUERY_TYPE = eINSTANCE.getTabularQueryType ();

        /**
         * The meta object literal for the '<em><b>Update Columns</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference TABULAR_QUERY_TYPE__UPDATE_COLUMNS = eINSTANCE.getTabularQueryType_UpdateColumns ();

        /**
         * The meta object literal for the '<em><b>Default Update Sql</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute TABULAR_QUERY_TYPE__DEFAULT_UPDATE_SQL = eINSTANCE.getTabularQueryType_DefaultUpdateSql ();

        /**
         * The meta object literal for the '<em><b>Commands</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference TABULAR_QUERY_TYPE__COMMANDS = eINSTANCE.getTabularQueryType_Commands ();

        /**
         * The meta object literal for the '<em><b>Default Update Sql1</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute TABULAR_QUERY_TYPE__DEFAULT_UPDATE_SQL1 = eINSTANCE.getTabularQueryType_DefaultUpdateSql1 ();

        /**
         * The meta object literal for the '<em><b>Id Column</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute TABULAR_QUERY_TYPE__ID_COLUMN = eINSTANCE.getTabularQueryType_IdColumn ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.da.jdbc.configuration.impl.UpdateColumnsTypeImpl <em>Update Columns Type</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.da.jdbc.configuration.impl.UpdateColumnsTypeImpl
         * @see org.eclipse.scada.da.jdbc.configuration.impl.ConfigurationPackageImpl#getUpdateColumnsType()
         * @generated
         */
        EClass UPDATE_COLUMNS_TYPE = eINSTANCE.getUpdateColumnsType ();

        /**
         * The meta object literal for the '<em><b>Column Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute UPDATE_COLUMNS_TYPE__COLUMN_NAME = eINSTANCE.getUpdateColumnsType_ColumnName ();

        /**
         * The meta object literal for the '<em><b>Custom Update Sql</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute UPDATE_COLUMNS_TYPE__CUSTOM_UPDATE_SQL = eINSTANCE.getUpdateColumnsType_CustomUpdateSql ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.da.jdbc.configuration.impl.UpdateMappingTypeImpl <em>Update Mapping Type</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.da.jdbc.configuration.impl.UpdateMappingTypeImpl
         * @see org.eclipse.scada.da.jdbc.configuration.impl.ConfigurationPackageImpl#getUpdateMappingType()
         * @generated
         */
        EClass UPDATE_MAPPING_TYPE = eINSTANCE.getUpdateMappingType ();

        /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute UPDATE_MAPPING_TYPE__NAME = eINSTANCE.getUpdateMappingType_Name ();

        /**
         * The meta object literal for the '<em><b>Named Parameter</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute UPDATE_MAPPING_TYPE__NAMED_PARAMETER = eINSTANCE.getUpdateMappingType_NamedParameter ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.da.jdbc.configuration.impl.UpdateTypeImpl <em>Update Type</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.da.jdbc.configuration.impl.UpdateTypeImpl
         * @see org.eclipse.scada.da.jdbc.configuration.impl.ConfigurationPackageImpl#getUpdateType()
         * @generated
         */
        EClass UPDATE_TYPE = eINSTANCE.getUpdateType ();

        /**
         * The meta object literal for the '<em><b>Sql</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute UPDATE_TYPE__SQL = eINSTANCE.getUpdateType_Sql ();

        /**
         * The meta object literal for the '<em><b>Mapping</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference UPDATE_TYPE__MAPPING = eINSTANCE.getUpdateType_Mapping ();

        /**
         * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute UPDATE_TYPE__ID = eINSTANCE.getUpdateType_Id ();

        /**
         * The meta object literal for the '<em><b>Sql1</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute UPDATE_TYPE__SQL1 = eINSTANCE.getUpdateType_Sql1 ();

        /**
         * The meta object literal for the '<em>Alias Name Type</em>' data type.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see java.lang.String
         * @see org.eclipse.scada.da.jdbc.configuration.impl.ConfigurationPackageImpl#getAliasNameType()
         * @generated
         */
        EDataType ALIAS_NAME_TYPE = eINSTANCE.getAliasNameType ();

        /**
         * The meta object literal for the '<em>Column Number Type</em>' data type.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.da.jdbc.configuration.impl.ConfigurationPackageImpl#getColumnNumberType()
         * @generated
         */
        EDataType COLUMN_NUMBER_TYPE = eINSTANCE.getColumnNumberType ();

        /**
         * The meta object literal for the '<em>Column Number Type Object</em>' data type.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see java.lang.Integer
         * @see org.eclipse.scada.da.jdbc.configuration.impl.ConfigurationPackageImpl#getColumnNumberTypeObject()
         * @generated
         */
        EDataType COLUMN_NUMBER_TYPE_OBJECT = eINSTANCE.getColumnNumberTypeObject ();

    }

} //ConfigurationPackage
