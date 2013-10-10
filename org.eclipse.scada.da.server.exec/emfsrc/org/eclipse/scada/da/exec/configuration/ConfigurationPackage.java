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
package org.eclipse.scada.da.exec.configuration;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
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
 * @see org.eclipse.scada.da.exec.configuration.ConfigurationFactory
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
    String eNS_URI = "http://openscada.org/DA/Exec/Configuration"; //$NON-NLS-1$

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
    ConfigurationPackage eINSTANCE = org.eclipse.scada.da.exec.configuration.impl.ConfigurationPackageImpl.init ();

    /**
     * The meta object id for the '{@link org.eclipse.scada.da.exec.configuration.impl.CommandTypeImpl <em>Command Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.da.exec.configuration.impl.CommandTypeImpl
     * @see org.eclipse.scada.da.exec.configuration.impl.ConfigurationPackageImpl#getCommandType()
     * @generated
     */
    int COMMAND_TYPE = 0;

    /**
     * The feature id for the '<em><b>Process</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COMMAND_TYPE__PROCESS = 0;

    /**
     * The feature id for the '<em><b>Extractor</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COMMAND_TYPE__EXTRACTOR = 1;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COMMAND_TYPE__ID = 2;

    /**
     * The number of structural features of the '<em>Command Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COMMAND_TYPE_FEATURE_COUNT = 3;

    /**
     * The number of operations of the '<em>Command Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COMMAND_TYPE_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.da.exec.configuration.impl.ContinuousCommandTypeImpl <em>Continuous Command Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.da.exec.configuration.impl.ContinuousCommandTypeImpl
     * @see org.eclipse.scada.da.exec.configuration.impl.ConfigurationPackageImpl#getContinuousCommandType()
     * @generated
     */
    int CONTINUOUS_COMMAND_TYPE = 1;

    /**
     * The feature id for the '<em><b>Process</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONTINUOUS_COMMAND_TYPE__PROCESS = COMMAND_TYPE__PROCESS;

    /**
     * The feature id for the '<em><b>Extractor</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONTINUOUS_COMMAND_TYPE__EXTRACTOR = COMMAND_TYPE__EXTRACTOR;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONTINUOUS_COMMAND_TYPE__ID = COMMAND_TYPE__ID;

    /**
     * The feature id for the '<em><b>Max Input Buffer</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONTINUOUS_COMMAND_TYPE__MAX_INPUT_BUFFER = COMMAND_TYPE_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Restart Delay</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONTINUOUS_COMMAND_TYPE__RESTART_DELAY = COMMAND_TYPE_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Continuous Command Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONTINUOUS_COMMAND_TYPE_FEATURE_COUNT = COMMAND_TYPE_FEATURE_COUNT + 2;

    /**
     * The number of operations of the '<em>Continuous Command Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONTINUOUS_COMMAND_TYPE_OPERATION_COUNT = COMMAND_TYPE_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.da.exec.configuration.impl.ExtractorTypeImpl <em>Extractor Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.da.exec.configuration.impl.ExtractorTypeImpl
     * @see org.eclipse.scada.da.exec.configuration.impl.ConfigurationPackageImpl#getExtractorType()
     * @generated
     */
    int EXTRACTOR_TYPE = 5;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXTRACTOR_TYPE__NAME = 0;

    /**
     * The number of structural features of the '<em>Extractor Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXTRACTOR_TYPE_FEATURE_COUNT = 1;

    /**
     * The number of operations of the '<em>Extractor Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXTRACTOR_TYPE_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.da.exec.configuration.impl.CustomExtractorTypeImpl <em>Custom Extractor Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.da.exec.configuration.impl.CustomExtractorTypeImpl
     * @see org.eclipse.scada.da.exec.configuration.impl.ConfigurationPackageImpl#getCustomExtractorType()
     * @generated
     */
    int CUSTOM_EXTRACTOR_TYPE = 2;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CUSTOM_EXTRACTOR_TYPE__NAME = EXTRACTOR_TYPE__NAME;

    /**
     * The feature id for the '<em><b>Any</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CUSTOM_EXTRACTOR_TYPE__ANY = EXTRACTOR_TYPE_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Class</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CUSTOM_EXTRACTOR_TYPE__CLASS = EXTRACTOR_TYPE_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Custom Extractor Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CUSTOM_EXTRACTOR_TYPE_FEATURE_COUNT = EXTRACTOR_TYPE_FEATURE_COUNT + 2;

    /**
     * The number of operations of the '<em>Custom Extractor Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CUSTOM_EXTRACTOR_TYPE_OPERATION_COUNT = EXTRACTOR_TYPE_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.da.exec.configuration.impl.DocumentRootImpl <em>Document Root</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.da.exec.configuration.impl.DocumentRootImpl
     * @see org.eclipse.scada.da.exec.configuration.impl.ConfigurationPackageImpl#getDocumentRoot()
     * @generated
     */
    int DOCUMENT_ROOT = 3;

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
     * The meta object id for the '{@link org.eclipse.scada.da.exec.configuration.impl.EnvEntryTypeImpl <em>Env Entry Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.da.exec.configuration.impl.EnvEntryTypeImpl
     * @see org.eclipse.scada.da.exec.configuration.impl.ConfigurationPackageImpl#getEnvEntryType()
     * @generated
     */
    int ENV_ENTRY_TYPE = 4;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ENV_ENTRY_TYPE__NAME = 0;

    /**
     * The feature id for the '<em><b>Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ENV_ENTRY_TYPE__VALUE = 1;

    /**
     * The number of structural features of the '<em>Env Entry Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ENV_ENTRY_TYPE_FEATURE_COUNT = 2;

    /**
     * The number of operations of the '<em>Env Entry Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ENV_ENTRY_TYPE_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.da.exec.configuration.impl.FieldExtractorTypeImpl <em>Field Extractor Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.da.exec.configuration.impl.FieldExtractorTypeImpl
     * @see org.eclipse.scada.da.exec.configuration.impl.ConfigurationPackageImpl#getFieldExtractorType()
     * @generated
     */
    int FIELD_EXTRACTOR_TYPE = 6;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FIELD_EXTRACTOR_TYPE__NAME = EXTRACTOR_TYPE__NAME;

    /**
     * The feature id for the '<em><b>Field</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FIELD_EXTRACTOR_TYPE__FIELD = EXTRACTOR_TYPE_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Field Extractor Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FIELD_EXTRACTOR_TYPE_FEATURE_COUNT = EXTRACTOR_TYPE_FEATURE_COUNT + 1;

    /**
     * The number of operations of the '<em>Field Extractor Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FIELD_EXTRACTOR_TYPE_OPERATION_COUNT = EXTRACTOR_TYPE_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.da.exec.configuration.impl.FieldTypeImpl <em>Field Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.da.exec.configuration.impl.FieldTypeImpl
     * @see org.eclipse.scada.da.exec.configuration.impl.ConfigurationPackageImpl#getFieldType()
     * @generated
     */
    int FIELD_TYPE = 7;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FIELD_TYPE__NAME = 0;

    /**
     * The feature id for the '<em><b>Variant Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FIELD_TYPE__VARIANT_TYPE = 1;

    /**
     * The number of structural features of the '<em>Field Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FIELD_TYPE_FEATURE_COUNT = 2;

    /**
     * The number of operations of the '<em>Field Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FIELD_TYPE_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.da.exec.configuration.impl.HiveProcessCommandTypeImpl <em>Hive Process Command Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.da.exec.configuration.impl.HiveProcessCommandTypeImpl
     * @see org.eclipse.scada.da.exec.configuration.impl.ConfigurationPackageImpl#getHiveProcessCommandType()
     * @generated
     */
    int HIVE_PROCESS_COMMAND_TYPE = 8;

    /**
     * The feature id for the '<em><b>Process</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HIVE_PROCESS_COMMAND_TYPE__PROCESS = CONTINUOUS_COMMAND_TYPE__PROCESS;

    /**
     * The feature id for the '<em><b>Extractor</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HIVE_PROCESS_COMMAND_TYPE__EXTRACTOR = CONTINUOUS_COMMAND_TYPE__EXTRACTOR;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HIVE_PROCESS_COMMAND_TYPE__ID = CONTINUOUS_COMMAND_TYPE__ID;

    /**
     * The feature id for the '<em><b>Max Input Buffer</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HIVE_PROCESS_COMMAND_TYPE__MAX_INPUT_BUFFER = CONTINUOUS_COMMAND_TYPE__MAX_INPUT_BUFFER;

    /**
     * The feature id for the '<em><b>Restart Delay</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HIVE_PROCESS_COMMAND_TYPE__RESTART_DELAY = CONTINUOUS_COMMAND_TYPE__RESTART_DELAY;

    /**
     * The number of structural features of the '<em>Hive Process Command Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HIVE_PROCESS_COMMAND_TYPE_FEATURE_COUNT = CONTINUOUS_COMMAND_TYPE_FEATURE_COUNT + 0;

    /**
     * The number of operations of the '<em>Hive Process Command Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HIVE_PROCESS_COMMAND_TYPE_OPERATION_COUNT = CONTINUOUS_COMMAND_TYPE_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.da.exec.configuration.impl.NagiosReturnCodeExtractorTypeImpl <em>Nagios Return Code Extractor Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.da.exec.configuration.impl.NagiosReturnCodeExtractorTypeImpl
     * @see org.eclipse.scada.da.exec.configuration.impl.ConfigurationPackageImpl#getNagiosReturnCodeExtractorType()
     * @generated
     */
    int NAGIOS_RETURN_CODE_EXTRACTOR_TYPE = 9;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NAGIOS_RETURN_CODE_EXTRACTOR_TYPE__NAME = EXTRACTOR_TYPE__NAME;

    /**
     * The number of structural features of the '<em>Nagios Return Code Extractor Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NAGIOS_RETURN_CODE_EXTRACTOR_TYPE_FEATURE_COUNT = EXTRACTOR_TYPE_FEATURE_COUNT + 0;

    /**
     * The number of operations of the '<em>Nagios Return Code Extractor Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NAGIOS_RETURN_CODE_EXTRACTOR_TYPE_OPERATION_COUNT = EXTRACTOR_TYPE_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.da.exec.configuration.impl.PlainStreamExtractorTypeImpl <em>Plain Stream Extractor Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.da.exec.configuration.impl.PlainStreamExtractorTypeImpl
     * @see org.eclipse.scada.da.exec.configuration.impl.ConfigurationPackageImpl#getPlainStreamExtractorType()
     * @generated
     */
    int PLAIN_STREAM_EXTRACTOR_TYPE = 10;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PLAIN_STREAM_EXTRACTOR_TYPE__NAME = EXTRACTOR_TYPE__NAME;

    /**
     * The number of structural features of the '<em>Plain Stream Extractor Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PLAIN_STREAM_EXTRACTOR_TYPE_FEATURE_COUNT = EXTRACTOR_TYPE_FEATURE_COUNT + 0;

    /**
     * The number of operations of the '<em>Plain Stream Extractor Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PLAIN_STREAM_EXTRACTOR_TYPE_OPERATION_COUNT = EXTRACTOR_TYPE_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.da.exec.configuration.impl.ProcessTypeImpl <em>Process Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.da.exec.configuration.impl.ProcessTypeImpl
     * @see org.eclipse.scada.da.exec.configuration.impl.ConfigurationPackageImpl#getProcessType()
     * @generated
     */
    int PROCESS_TYPE = 11;

    /**
     * The feature id for the '<em><b>Argument</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PROCESS_TYPE__ARGUMENT = 0;

    /**
     * The feature id for the '<em><b>Env</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PROCESS_TYPE__ENV = 1;

    /**
     * The feature id for the '<em><b>Exec</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PROCESS_TYPE__EXEC = 2;

    /**
     * The number of structural features of the '<em>Process Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PROCESS_TYPE_FEATURE_COUNT = 3;

    /**
     * The number of operations of the '<em>Process Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PROCESS_TYPE_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.da.exec.configuration.impl.QueueTypeImpl <em>Queue Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.da.exec.configuration.impl.QueueTypeImpl
     * @see org.eclipse.scada.da.exec.configuration.impl.ConfigurationPackageImpl#getQueueType()
     * @generated
     */
    int QUEUE_TYPE = 12;

    /**
     * The feature id for the '<em><b>Command</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int QUEUE_TYPE__COMMAND = 0;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int QUEUE_TYPE__NAME = 1;

    /**
     * The number of structural features of the '<em>Queue Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int QUEUE_TYPE_FEATURE_COUNT = 2;

    /**
     * The number of operations of the '<em>Queue Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int QUEUE_TYPE_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.da.exec.configuration.impl.RegExExtractorTypeImpl <em>Reg Ex Extractor Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.da.exec.configuration.impl.RegExExtractorTypeImpl
     * @see org.eclipse.scada.da.exec.configuration.impl.ConfigurationPackageImpl#getRegExExtractorType()
     * @generated
     */
    int REG_EX_EXTRACTOR_TYPE = 13;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int REG_EX_EXTRACTOR_TYPE__NAME = FIELD_EXTRACTOR_TYPE__NAME;

    /**
     * The feature id for the '<em><b>Field</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int REG_EX_EXTRACTOR_TYPE__FIELD = FIELD_EXTRACTOR_TYPE__FIELD;

    /**
     * The feature id for the '<em><b>Expression</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int REG_EX_EXTRACTOR_TYPE__EXPRESSION = FIELD_EXTRACTOR_TYPE_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Require Full Match</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int REG_EX_EXTRACTOR_TYPE__REQUIRE_FULL_MATCH = FIELD_EXTRACTOR_TYPE_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Reg Ex Extractor Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int REG_EX_EXTRACTOR_TYPE_FEATURE_COUNT = FIELD_EXTRACTOR_TYPE_FEATURE_COUNT + 2;

    /**
     * The number of operations of the '<em>Reg Ex Extractor Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int REG_EX_EXTRACTOR_TYPE_OPERATION_COUNT = FIELD_EXTRACTOR_TYPE_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.da.exec.configuration.impl.ReturnCodeExtractorTypeImpl <em>Return Code Extractor Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.da.exec.configuration.impl.ReturnCodeExtractorTypeImpl
     * @see org.eclipse.scada.da.exec.configuration.impl.ConfigurationPackageImpl#getReturnCodeExtractorType()
     * @generated
     */
    int RETURN_CODE_EXTRACTOR_TYPE = 14;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RETURN_CODE_EXTRACTOR_TYPE__NAME = EXTRACTOR_TYPE__NAME;

    /**
     * The number of structural features of the '<em>Return Code Extractor Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RETURN_CODE_EXTRACTOR_TYPE_FEATURE_COUNT = EXTRACTOR_TYPE_FEATURE_COUNT + 0;

    /**
     * The number of operations of the '<em>Return Code Extractor Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RETURN_CODE_EXTRACTOR_TYPE_OPERATION_COUNT = EXTRACTOR_TYPE_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.da.exec.configuration.impl.RootTypeImpl <em>Root Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.da.exec.configuration.impl.RootTypeImpl
     * @see org.eclipse.scada.da.exec.configuration.impl.ConfigurationPackageImpl#getRootType()
     * @generated
     */
    int ROOT_TYPE = 15;

    /**
     * The feature id for the '<em><b>Group</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ROOT_TYPE__GROUP = 0;

    /**
     * The feature id for the '<em><b>Queue</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ROOT_TYPE__QUEUE = 1;

    /**
     * The feature id for the '<em><b>Command</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ROOT_TYPE__COMMAND = 2;

    /**
     * The feature id for the '<em><b>Hive Process</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ROOT_TYPE__HIVE_PROCESS = 3;

    /**
     * The feature id for the '<em><b>Trigger</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ROOT_TYPE__TRIGGER = 4;

    /**
     * The feature id for the '<em><b>Additional Configuration Directory</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ROOT_TYPE__ADDITIONAL_CONFIGURATION_DIRECTORY = 5;

    /**
     * The number of structural features of the '<em>Root Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ROOT_TYPE_FEATURE_COUNT = 6;

    /**
     * The number of operations of the '<em>Root Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ROOT_TYPE_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.da.exec.configuration.impl.SimpleExtractorTypeImpl <em>Simple Extractor Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.da.exec.configuration.impl.SimpleExtractorTypeImpl
     * @see org.eclipse.scada.da.exec.configuration.impl.ConfigurationPackageImpl#getSimpleExtractorType()
     * @generated
     */
    int SIMPLE_EXTRACTOR_TYPE = 16;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SIMPLE_EXTRACTOR_TYPE__NAME = EXTRACTOR_TYPE__NAME;

    /**
     * The number of structural features of the '<em>Simple Extractor Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SIMPLE_EXTRACTOR_TYPE_FEATURE_COUNT = EXTRACTOR_TYPE_FEATURE_COUNT + 0;

    /**
     * The number of operations of the '<em>Simple Extractor Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SIMPLE_EXTRACTOR_TYPE_OPERATION_COUNT = EXTRACTOR_TYPE_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.da.exec.configuration.impl.SingleCommandTypeImpl <em>Single Command Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.da.exec.configuration.impl.SingleCommandTypeImpl
     * @see org.eclipse.scada.da.exec.configuration.impl.ConfigurationPackageImpl#getSingleCommandType()
     * @generated
     */
    int SINGLE_COMMAND_TYPE = 17;

    /**
     * The feature id for the '<em><b>Process</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SINGLE_COMMAND_TYPE__PROCESS = COMMAND_TYPE__PROCESS;

    /**
     * The feature id for the '<em><b>Extractor</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SINGLE_COMMAND_TYPE__EXTRACTOR = COMMAND_TYPE__EXTRACTOR;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SINGLE_COMMAND_TYPE__ID = COMMAND_TYPE__ID;

    /**
     * The feature id for the '<em><b>Period</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SINGLE_COMMAND_TYPE__PERIOD = COMMAND_TYPE_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Single Command Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SINGLE_COMMAND_TYPE_FEATURE_COUNT = COMMAND_TYPE_FEATURE_COUNT + 1;

    /**
     * The number of operations of the '<em>Single Command Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SINGLE_COMMAND_TYPE_OPERATION_COUNT = COMMAND_TYPE_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.da.exec.configuration.impl.SplitContinuousCommandTypeImpl <em>Split Continuous Command Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.da.exec.configuration.impl.SplitContinuousCommandTypeImpl
     * @see org.eclipse.scada.da.exec.configuration.impl.ConfigurationPackageImpl#getSplitContinuousCommandType()
     * @generated
     */
    int SPLIT_CONTINUOUS_COMMAND_TYPE = 18;

    /**
     * The feature id for the '<em><b>Process</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SPLIT_CONTINUOUS_COMMAND_TYPE__PROCESS = CONTINUOUS_COMMAND_TYPE__PROCESS;

    /**
     * The feature id for the '<em><b>Extractor</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SPLIT_CONTINUOUS_COMMAND_TYPE__EXTRACTOR = CONTINUOUS_COMMAND_TYPE__EXTRACTOR;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SPLIT_CONTINUOUS_COMMAND_TYPE__ID = CONTINUOUS_COMMAND_TYPE__ID;

    /**
     * The feature id for the '<em><b>Max Input Buffer</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SPLIT_CONTINUOUS_COMMAND_TYPE__MAX_INPUT_BUFFER = CONTINUOUS_COMMAND_TYPE__MAX_INPUT_BUFFER;

    /**
     * The feature id for the '<em><b>Restart Delay</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SPLIT_CONTINUOUS_COMMAND_TYPE__RESTART_DELAY = CONTINUOUS_COMMAND_TYPE__RESTART_DELAY;

    /**
     * The feature id for the '<em><b>Splitter</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SPLIT_CONTINUOUS_COMMAND_TYPE__SPLITTER = CONTINUOUS_COMMAND_TYPE_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Ignore Start Lines</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SPLIT_CONTINUOUS_COMMAND_TYPE__IGNORE_START_LINES = CONTINUOUS_COMMAND_TYPE_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Split Continuous Command Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SPLIT_CONTINUOUS_COMMAND_TYPE_FEATURE_COUNT = CONTINUOUS_COMMAND_TYPE_FEATURE_COUNT + 2;

    /**
     * The number of operations of the '<em>Split Continuous Command Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SPLIT_CONTINUOUS_COMMAND_TYPE_OPERATION_COUNT = CONTINUOUS_COMMAND_TYPE_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.da.exec.configuration.impl.SplitterExtractorTypeImpl <em>Splitter Extractor Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.da.exec.configuration.impl.SplitterExtractorTypeImpl
     * @see org.eclipse.scada.da.exec.configuration.impl.ConfigurationPackageImpl#getSplitterExtractorType()
     * @generated
     */
    int SPLITTER_EXTRACTOR_TYPE = 19;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SPLITTER_EXTRACTOR_TYPE__NAME = FIELD_EXTRACTOR_TYPE__NAME;

    /**
     * The feature id for the '<em><b>Field</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SPLITTER_EXTRACTOR_TYPE__FIELD = FIELD_EXTRACTOR_TYPE__FIELD;

    /**
     * The feature id for the '<em><b>Split Expression</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SPLITTER_EXTRACTOR_TYPE__SPLIT_EXPRESSION = FIELD_EXTRACTOR_TYPE_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Splitter Extractor Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SPLITTER_EXTRACTOR_TYPE_FEATURE_COUNT = FIELD_EXTRACTOR_TYPE_FEATURE_COUNT + 1;

    /**
     * The number of operations of the '<em>Splitter Extractor Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SPLITTER_EXTRACTOR_TYPE_OPERATION_COUNT = FIELD_EXTRACTOR_TYPE_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.da.exec.configuration.impl.SplitterTypeImpl <em>Splitter Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.da.exec.configuration.impl.SplitterTypeImpl
     * @see org.eclipse.scada.da.exec.configuration.impl.ConfigurationPackageImpl#getSplitterType()
     * @generated
     */
    int SPLITTER_TYPE = 20;

    /**
     * The feature id for the '<em><b>Parameter</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SPLITTER_TYPE__PARAMETER = 0;

    /**
     * The feature id for the '<em><b>Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SPLITTER_TYPE__TYPE = 1;

    /**
     * The number of structural features of the '<em>Splitter Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SPLITTER_TYPE_FEATURE_COUNT = 2;

    /**
     * The number of operations of the '<em>Splitter Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SPLITTER_TYPE_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.da.exec.configuration.impl.TriggerCommandTypeImpl <em>Trigger Command Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.da.exec.configuration.impl.TriggerCommandTypeImpl
     * @see org.eclipse.scada.da.exec.configuration.impl.ConfigurationPackageImpl#getTriggerCommandType()
     * @generated
     */
    int TRIGGER_COMMAND_TYPE = 21;

    /**
     * The feature id for the '<em><b>Process</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TRIGGER_COMMAND_TYPE__PROCESS = COMMAND_TYPE__PROCESS;

    /**
     * The feature id for the '<em><b>Extractor</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TRIGGER_COMMAND_TYPE__EXTRACTOR = COMMAND_TYPE__EXTRACTOR;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TRIGGER_COMMAND_TYPE__ID = COMMAND_TYPE__ID;

    /**
     * The feature id for the '<em><b>Argument Placeholder</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TRIGGER_COMMAND_TYPE__ARGUMENT_PLACEHOLDER = COMMAND_TYPE_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Fork</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TRIGGER_COMMAND_TYPE__FORK = COMMAND_TYPE_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Skip If Null</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TRIGGER_COMMAND_TYPE__SKIP_IF_NULL = COMMAND_TYPE_FEATURE_COUNT + 2;

    /**
     * The number of structural features of the '<em>Trigger Command Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TRIGGER_COMMAND_TYPE_FEATURE_COUNT = COMMAND_TYPE_FEATURE_COUNT + 3;

    /**
     * The number of operations of the '<em>Trigger Command Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TRIGGER_COMMAND_TYPE_OPERATION_COUNT = COMMAND_TYPE_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.da.exec.configuration.VariantTypeType <em>Variant Type Type</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.da.exec.configuration.VariantTypeType
     * @see org.eclipse.scada.da.exec.configuration.impl.ConfigurationPackageImpl#getVariantTypeType()
     * @generated
     */
    int VARIANT_TYPE_TYPE = 22;

    /**
     * The meta object id for the '<em>Class Type</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see java.lang.String
     * @see org.eclipse.scada.da.exec.configuration.impl.ConfigurationPackageImpl#getClassType()
     * @generated
     */
    int CLASS_TYPE = 23;

    /**
     * The meta object id for the '<em>Name Type</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see java.lang.String
     * @see org.eclipse.scada.da.exec.configuration.impl.ConfigurationPackageImpl#getNameType()
     * @generated
     */
    int NAME_TYPE = 24;

    /**
     * The meta object id for the '<em>Name Type1</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see java.lang.String
     * @see org.eclipse.scada.da.exec.configuration.impl.ConfigurationPackageImpl#getNameType1()
     * @generated
     */
    int NAME_TYPE1 = 25;

    /**
     * The meta object id for the '<em>Period Type</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.da.exec.configuration.impl.ConfigurationPackageImpl#getPeriodType()
     * @generated
     */
    int PERIOD_TYPE = 26;

    /**
     * The meta object id for the '<em>Period Type Object</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see java.lang.Integer
     * @see org.eclipse.scada.da.exec.configuration.impl.ConfigurationPackageImpl#getPeriodTypeObject()
     * @generated
     */
    int PERIOD_TYPE_OBJECT = 27;

    /**
     * The meta object id for the '<em>Restart Delay Type</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.da.exec.configuration.impl.ConfigurationPackageImpl#getRestartDelayType()
     * @generated
     */
    int RESTART_DELAY_TYPE = 28;

    /**
     * The meta object id for the '<em>Restart Delay Type Object</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see java.lang.Integer
     * @see org.eclipse.scada.da.exec.configuration.impl.ConfigurationPackageImpl#getRestartDelayTypeObject()
     * @generated
     */
    int RESTART_DELAY_TYPE_OBJECT = 29;

    /**
     * The meta object id for the '<em>Type Type</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see java.lang.String
     * @see org.eclipse.scada.da.exec.configuration.impl.ConfigurationPackageImpl#getTypeType()
     * @generated
     */
    int TYPE_TYPE = 30;

    /**
     * The meta object id for the '<em>Variant Type Type Object</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.da.exec.configuration.VariantTypeType
     * @see org.eclipse.scada.da.exec.configuration.impl.ConfigurationPackageImpl#getVariantTypeTypeObject()
     * @generated
     */
    int VARIANT_TYPE_TYPE_OBJECT = 31;

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.da.exec.configuration.CommandType <em>Command Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Command Type</em>'.
     * @see org.eclipse.scada.da.exec.configuration.CommandType
     * @generated
     */
    EClass getCommandType ();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.scada.da.exec.configuration.CommandType#getProcess <em>Process</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Process</em>'.
     * @see org.eclipse.scada.da.exec.configuration.CommandType#getProcess()
     * @see #getCommandType()
     * @generated
     */
    EReference getCommandType_Process ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.da.exec.configuration.CommandType#getExtractor <em>Extractor</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Extractor</em>'.
     * @see org.eclipse.scada.da.exec.configuration.CommandType#getExtractor()
     * @see #getCommandType()
     * @generated
     */
    EReference getCommandType_Extractor ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.da.exec.configuration.CommandType#getId <em>Id</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Id</em>'.
     * @see org.eclipse.scada.da.exec.configuration.CommandType#getId()
     * @see #getCommandType()
     * @generated
     */
    EAttribute getCommandType_Id ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.da.exec.configuration.ContinuousCommandType <em>Continuous Command Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Continuous Command Type</em>'.
     * @see org.eclipse.scada.da.exec.configuration.ContinuousCommandType
     * @generated
     */
    EClass getContinuousCommandType ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.da.exec.configuration.ContinuousCommandType#getMaxInputBuffer <em>Max Input Buffer</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Max Input Buffer</em>'.
     * @see org.eclipse.scada.da.exec.configuration.ContinuousCommandType#getMaxInputBuffer()
     * @see #getContinuousCommandType()
     * @generated
     */
    EAttribute getContinuousCommandType_MaxInputBuffer ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.da.exec.configuration.ContinuousCommandType#getRestartDelay <em>Restart Delay</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Restart Delay</em>'.
     * @see org.eclipse.scada.da.exec.configuration.ContinuousCommandType#getRestartDelay()
     * @see #getContinuousCommandType()
     * @generated
     */
    EAttribute getContinuousCommandType_RestartDelay ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.da.exec.configuration.CustomExtractorType <em>Custom Extractor Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Custom Extractor Type</em>'.
     * @see org.eclipse.scada.da.exec.configuration.CustomExtractorType
     * @generated
     */
    EClass getCustomExtractorType ();

    /**
     * Returns the meta object for the attribute list '{@link org.eclipse.scada.da.exec.configuration.CustomExtractorType#getAny <em>Any</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute list '<em>Any</em>'.
     * @see org.eclipse.scada.da.exec.configuration.CustomExtractorType#getAny()
     * @see #getCustomExtractorType()
     * @generated
     */
    EAttribute getCustomExtractorType_Any ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.da.exec.configuration.CustomExtractorType#getClass_ <em>Class</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Class</em>'.
     * @see org.eclipse.scada.da.exec.configuration.CustomExtractorType#getClass_()
     * @see #getCustomExtractorType()
     * @generated
     */
    EAttribute getCustomExtractorType_Class ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.da.exec.configuration.DocumentRoot <em>Document Root</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Document Root</em>'.
     * @see org.eclipse.scada.da.exec.configuration.DocumentRoot
     * @generated
     */
    EClass getDocumentRoot ();

    /**
     * Returns the meta object for the attribute list '{@link org.eclipse.scada.da.exec.configuration.DocumentRoot#getMixed <em>Mixed</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute list '<em>Mixed</em>'.
     * @see org.eclipse.scada.da.exec.configuration.DocumentRoot#getMixed()
     * @see #getDocumentRoot()
     * @generated
     */
    EAttribute getDocumentRoot_Mixed ();

    /**
     * Returns the meta object for the map '{@link org.eclipse.scada.da.exec.configuration.DocumentRoot#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the map '<em>XMLNS Prefix Map</em>'.
     * @see org.eclipse.scada.da.exec.configuration.DocumentRoot#getXMLNSPrefixMap()
     * @see #getDocumentRoot()
     * @generated
     */
    EReference getDocumentRoot_XMLNSPrefixMap ();

    /**
     * Returns the meta object for the map '{@link org.eclipse.scada.da.exec.configuration.DocumentRoot#getXSISchemaLocation <em>XSI Schema Location</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the map '<em>XSI Schema Location</em>'.
     * @see org.eclipse.scada.da.exec.configuration.DocumentRoot#getXSISchemaLocation()
     * @see #getDocumentRoot()
     * @generated
     */
    EReference getDocumentRoot_XSISchemaLocation ();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.scada.da.exec.configuration.DocumentRoot#getRoot <em>Root</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Root</em>'.
     * @see org.eclipse.scada.da.exec.configuration.DocumentRoot#getRoot()
     * @see #getDocumentRoot()
     * @generated
     */
    EReference getDocumentRoot_Root ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.da.exec.configuration.EnvEntryType <em>Env Entry Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Env Entry Type</em>'.
     * @see org.eclipse.scada.da.exec.configuration.EnvEntryType
     * @generated
     */
    EClass getEnvEntryType ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.da.exec.configuration.EnvEntryType#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see org.eclipse.scada.da.exec.configuration.EnvEntryType#getName()
     * @see #getEnvEntryType()
     * @generated
     */
    EAttribute getEnvEntryType_Name ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.da.exec.configuration.EnvEntryType#getValue <em>Value</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Value</em>'.
     * @see org.eclipse.scada.da.exec.configuration.EnvEntryType#getValue()
     * @see #getEnvEntryType()
     * @generated
     */
    EAttribute getEnvEntryType_Value ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.da.exec.configuration.ExtractorType <em>Extractor Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Extractor Type</em>'.
     * @see org.eclipse.scada.da.exec.configuration.ExtractorType
     * @generated
     */
    EClass getExtractorType ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.da.exec.configuration.ExtractorType#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see org.eclipse.scada.da.exec.configuration.ExtractorType#getName()
     * @see #getExtractorType()
     * @generated
     */
    EAttribute getExtractorType_Name ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.da.exec.configuration.FieldExtractorType <em>Field Extractor Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Field Extractor Type</em>'.
     * @see org.eclipse.scada.da.exec.configuration.FieldExtractorType
     * @generated
     */
    EClass getFieldExtractorType ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.da.exec.configuration.FieldExtractorType#getField <em>Field</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Field</em>'.
     * @see org.eclipse.scada.da.exec.configuration.FieldExtractorType#getField()
     * @see #getFieldExtractorType()
     * @generated
     */
    EReference getFieldExtractorType_Field ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.da.exec.configuration.FieldType <em>Field Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Field Type</em>'.
     * @see org.eclipse.scada.da.exec.configuration.FieldType
     * @generated
     */
    EClass getFieldType ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.da.exec.configuration.FieldType#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see org.eclipse.scada.da.exec.configuration.FieldType#getName()
     * @see #getFieldType()
     * @generated
     */
    EAttribute getFieldType_Name ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.da.exec.configuration.FieldType#getVariantType <em>Variant Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Variant Type</em>'.
     * @see org.eclipse.scada.da.exec.configuration.FieldType#getVariantType()
     * @see #getFieldType()
     * @generated
     */
    EAttribute getFieldType_VariantType ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.da.exec.configuration.HiveProcessCommandType <em>Hive Process Command Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Hive Process Command Type</em>'.
     * @see org.eclipse.scada.da.exec.configuration.HiveProcessCommandType
     * @generated
     */
    EClass getHiveProcessCommandType ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.da.exec.configuration.NagiosReturnCodeExtractorType <em>Nagios Return Code Extractor Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Nagios Return Code Extractor Type</em>'.
     * @see org.eclipse.scada.da.exec.configuration.NagiosReturnCodeExtractorType
     * @generated
     */
    EClass getNagiosReturnCodeExtractorType ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.da.exec.configuration.PlainStreamExtractorType <em>Plain Stream Extractor Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Plain Stream Extractor Type</em>'.
     * @see org.eclipse.scada.da.exec.configuration.PlainStreamExtractorType
     * @generated
     */
    EClass getPlainStreamExtractorType ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.da.exec.configuration.ProcessType <em>Process Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Process Type</em>'.
     * @see org.eclipse.scada.da.exec.configuration.ProcessType
     * @generated
     */
    EClass getProcessType ();

    /**
     * Returns the meta object for the attribute list '{@link org.eclipse.scada.da.exec.configuration.ProcessType#getArgument <em>Argument</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute list '<em>Argument</em>'.
     * @see org.eclipse.scada.da.exec.configuration.ProcessType#getArgument()
     * @see #getProcessType()
     * @generated
     */
    EAttribute getProcessType_Argument ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.da.exec.configuration.ProcessType#getEnv <em>Env</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Env</em>'.
     * @see org.eclipse.scada.da.exec.configuration.ProcessType#getEnv()
     * @see #getProcessType()
     * @generated
     */
    EReference getProcessType_Env ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.da.exec.configuration.ProcessType#getExec <em>Exec</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Exec</em>'.
     * @see org.eclipse.scada.da.exec.configuration.ProcessType#getExec()
     * @see #getProcessType()
     * @generated
     */
    EAttribute getProcessType_Exec ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.da.exec.configuration.QueueType <em>Queue Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Queue Type</em>'.
     * @see org.eclipse.scada.da.exec.configuration.QueueType
     * @generated
     */
    EClass getQueueType ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.da.exec.configuration.QueueType#getCommand <em>Command</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Command</em>'.
     * @see org.eclipse.scada.da.exec.configuration.QueueType#getCommand()
     * @see #getQueueType()
     * @generated
     */
    EReference getQueueType_Command ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.da.exec.configuration.QueueType#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see org.eclipse.scada.da.exec.configuration.QueueType#getName()
     * @see #getQueueType()
     * @generated
     */
    EAttribute getQueueType_Name ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.da.exec.configuration.RegExExtractorType <em>Reg Ex Extractor Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Reg Ex Extractor Type</em>'.
     * @see org.eclipse.scada.da.exec.configuration.RegExExtractorType
     * @generated
     */
    EClass getRegExExtractorType ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.da.exec.configuration.RegExExtractorType#getExpression <em>Expression</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Expression</em>'.
     * @see org.eclipse.scada.da.exec.configuration.RegExExtractorType#getExpression()
     * @see #getRegExExtractorType()
     * @generated
     */
    EAttribute getRegExExtractorType_Expression ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.da.exec.configuration.RegExExtractorType#isRequireFullMatch <em>Require Full Match</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Require Full Match</em>'.
     * @see org.eclipse.scada.da.exec.configuration.RegExExtractorType#isRequireFullMatch()
     * @see #getRegExExtractorType()
     * @generated
     */
    EAttribute getRegExExtractorType_RequireFullMatch ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.da.exec.configuration.ReturnCodeExtractorType <em>Return Code Extractor Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Return Code Extractor Type</em>'.
     * @see org.eclipse.scada.da.exec.configuration.ReturnCodeExtractorType
     * @generated
     */
    EClass getReturnCodeExtractorType ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.da.exec.configuration.RootType <em>Root Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Root Type</em>'.
     * @see org.eclipse.scada.da.exec.configuration.RootType
     * @generated
     */
    EClass getRootType ();

    /**
     * Returns the meta object for the attribute list '{@link org.eclipse.scada.da.exec.configuration.RootType#getGroup <em>Group</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute list '<em>Group</em>'.
     * @see org.eclipse.scada.da.exec.configuration.RootType#getGroup()
     * @see #getRootType()
     * @generated
     */
    EAttribute getRootType_Group ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.da.exec.configuration.RootType#getQueue <em>Queue</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Queue</em>'.
     * @see org.eclipse.scada.da.exec.configuration.RootType#getQueue()
     * @see #getRootType()
     * @generated
     */
    EReference getRootType_Queue ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.da.exec.configuration.RootType#getCommand <em>Command</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Command</em>'.
     * @see org.eclipse.scada.da.exec.configuration.RootType#getCommand()
     * @see #getRootType()
     * @generated
     */
    EReference getRootType_Command ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.da.exec.configuration.RootType#getHiveProcess <em>Hive Process</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Hive Process</em>'.
     * @see org.eclipse.scada.da.exec.configuration.RootType#getHiveProcess()
     * @see #getRootType()
     * @generated
     */
    EReference getRootType_HiveProcess ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.da.exec.configuration.RootType#getTrigger <em>Trigger</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Trigger</em>'.
     * @see org.eclipse.scada.da.exec.configuration.RootType#getTrigger()
     * @see #getRootType()
     * @generated
     */
    EReference getRootType_Trigger ();

    /**
     * Returns the meta object for the attribute list '{@link org.eclipse.scada.da.exec.configuration.RootType#getAdditionalConfigurationDirectory <em>Additional Configuration Directory</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute list '<em>Additional Configuration Directory</em>'.
     * @see org.eclipse.scada.da.exec.configuration.RootType#getAdditionalConfigurationDirectory()
     * @see #getRootType()
     * @generated
     */
    EAttribute getRootType_AdditionalConfigurationDirectory ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.da.exec.configuration.SimpleExtractorType <em>Simple Extractor Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Simple Extractor Type</em>'.
     * @see org.eclipse.scada.da.exec.configuration.SimpleExtractorType
     * @generated
     */
    EClass getSimpleExtractorType ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.da.exec.configuration.SingleCommandType <em>Single Command Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Single Command Type</em>'.
     * @see org.eclipse.scada.da.exec.configuration.SingleCommandType
     * @generated
     */
    EClass getSingleCommandType ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.da.exec.configuration.SingleCommandType#getPeriod <em>Period</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Period</em>'.
     * @see org.eclipse.scada.da.exec.configuration.SingleCommandType#getPeriod()
     * @see #getSingleCommandType()
     * @generated
     */
    EAttribute getSingleCommandType_Period ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.da.exec.configuration.SplitContinuousCommandType <em>Split Continuous Command Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Split Continuous Command Type</em>'.
     * @see org.eclipse.scada.da.exec.configuration.SplitContinuousCommandType
     * @generated
     */
    EClass getSplitContinuousCommandType ();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.scada.da.exec.configuration.SplitContinuousCommandType#getSplitter <em>Splitter</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Splitter</em>'.
     * @see org.eclipse.scada.da.exec.configuration.SplitContinuousCommandType#getSplitter()
     * @see #getSplitContinuousCommandType()
     * @generated
     */
    EReference getSplitContinuousCommandType_Splitter ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.da.exec.configuration.SplitContinuousCommandType#getIgnoreStartLines <em>Ignore Start Lines</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Ignore Start Lines</em>'.
     * @see org.eclipse.scada.da.exec.configuration.SplitContinuousCommandType#getIgnoreStartLines()
     * @see #getSplitContinuousCommandType()
     * @generated
     */
    EAttribute getSplitContinuousCommandType_IgnoreStartLines ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.da.exec.configuration.SplitterExtractorType <em>Splitter Extractor Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Splitter Extractor Type</em>'.
     * @see org.eclipse.scada.da.exec.configuration.SplitterExtractorType
     * @generated
     */
    EClass getSplitterExtractorType ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.da.exec.configuration.SplitterExtractorType#getSplitExpression <em>Split Expression</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Split Expression</em>'.
     * @see org.eclipse.scada.da.exec.configuration.SplitterExtractorType#getSplitExpression()
     * @see #getSplitterExtractorType()
     * @generated
     */
    EAttribute getSplitterExtractorType_SplitExpression ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.da.exec.configuration.SplitterType <em>Splitter Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Splitter Type</em>'.
     * @see org.eclipse.scada.da.exec.configuration.SplitterType
     * @generated
     */
    EClass getSplitterType ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.da.exec.configuration.SplitterType#getParameter <em>Parameter</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Parameter</em>'.
     * @see org.eclipse.scada.da.exec.configuration.SplitterType#getParameter()
     * @see #getSplitterType()
     * @generated
     */
    EAttribute getSplitterType_Parameter ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.da.exec.configuration.SplitterType#getType <em>Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Type</em>'.
     * @see org.eclipse.scada.da.exec.configuration.SplitterType#getType()
     * @see #getSplitterType()
     * @generated
     */
    EAttribute getSplitterType_Type ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.da.exec.configuration.TriggerCommandType <em>Trigger Command Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Trigger Command Type</em>'.
     * @see org.eclipse.scada.da.exec.configuration.TriggerCommandType
     * @generated
     */
    EClass getTriggerCommandType ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.da.exec.configuration.TriggerCommandType#getArgumentPlaceholder <em>Argument Placeholder</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Argument Placeholder</em>'.
     * @see org.eclipse.scada.da.exec.configuration.TriggerCommandType#getArgumentPlaceholder()
     * @see #getTriggerCommandType()
     * @generated
     */
    EAttribute getTriggerCommandType_ArgumentPlaceholder ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.da.exec.configuration.TriggerCommandType#isFork <em>Fork</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Fork</em>'.
     * @see org.eclipse.scada.da.exec.configuration.TriggerCommandType#isFork()
     * @see #getTriggerCommandType()
     * @generated
     */
    EAttribute getTriggerCommandType_Fork ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.da.exec.configuration.TriggerCommandType#isSkipIfNull <em>Skip If Null</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Skip If Null</em>'.
     * @see org.eclipse.scada.da.exec.configuration.TriggerCommandType#isSkipIfNull()
     * @see #getTriggerCommandType()
     * @generated
     */
    EAttribute getTriggerCommandType_SkipIfNull ();

    /**
     * Returns the meta object for enum '{@link org.eclipse.scada.da.exec.configuration.VariantTypeType <em>Variant Type Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for enum '<em>Variant Type Type</em>'.
     * @see org.eclipse.scada.da.exec.configuration.VariantTypeType
     * @generated
     */
    EEnum getVariantTypeType ();

    /**
     * Returns the meta object for data type '{@link java.lang.String <em>Class Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for data type '<em>Class Type</em>'.
     * @see java.lang.String
     * @model instanceClass="java.lang.String"
     *        extendedMetaData="name='class_._type' baseType='http://www.eclipse.org/emf/2003/XMLType#string' pattern='\\w+(\\.\\w+)*'"
     * @generated
     */
    EDataType getClassType ();

    /**
     * Returns the meta object for data type '{@link java.lang.String <em>Name Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for data type '<em>Name Type</em>'.
     * @see java.lang.String
     * @model instanceClass="java.lang.String"
     *        extendedMetaData="name='name_._type' baseType='http://www.eclipse.org/emf/2003/XMLType#string' whiteSpace='collapse'"
     * @generated
     */
    EDataType getNameType ();

    /**
     * Returns the meta object for data type '{@link java.lang.String <em>Name Type1</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for data type '<em>Name Type1</em>'.
     * @see java.lang.String
     * @model instanceClass="java.lang.String"
     *        extendedMetaData="name='name_._1_._type' baseType='http://www.eclipse.org/emf/2003/XMLType#string' whiteSpace='collapse' pattern='\\w+'"
     * @generated
     */
    EDataType getNameType1 ();

    /**
     * Returns the meta object for data type '<em>Period Type</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for data type '<em>Period Type</em>'.
     * @model instanceClass="int"
     *        extendedMetaData="name='period_._type' baseType='http://www.eclipse.org/emf/2003/XMLType#int' minExclusive='0'"
     * @generated
     */
    EDataType getPeriodType ();

    /**
     * Returns the meta object for data type '{@link java.lang.Integer <em>Period Type Object</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for data type '<em>Period Type Object</em>'.
     * @see java.lang.Integer
     * @model instanceClass="java.lang.Integer"
     *        extendedMetaData="name='period_._type:Object' baseType='period_._type'"
     * @generated
     */
    EDataType getPeriodTypeObject ();

    /**
     * Returns the meta object for data type '<em>Restart Delay Type</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for data type '<em>Restart Delay Type</em>'.
     * @model instanceClass="int"
     *        extendedMetaData="name='restartDelay_._type' baseType='http://www.eclipse.org/emf/2003/XMLType#int'"
     * @generated
     */
    EDataType getRestartDelayType ();

    /**
     * Returns the meta object for data type '{@link java.lang.Integer <em>Restart Delay Type Object</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for data type '<em>Restart Delay Type Object</em>'.
     * @see java.lang.Integer
     * @model instanceClass="java.lang.Integer"
     *        extendedMetaData="name='restartDelay_._type:Object' baseType='restartDelay_._type'"
     * @generated
     */
    EDataType getRestartDelayTypeObject ();

    /**
     * Returns the meta object for data type '{@link java.lang.String <em>Type Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for data type '<em>Type Type</em>'.
     * @see java.lang.String
     * @model instanceClass="java.lang.String"
     *        extendedMetaData="name='type_._type' baseType='http://www.eclipse.org/emf/2003/XMLType#string' pattern='(newline|regexpMatch|regexpSplit|split|class#.*)'"
     * @generated
     */
    EDataType getTypeType ();

    /**
     * Returns the meta object for data type '{@link org.eclipse.scada.da.exec.configuration.VariantTypeType <em>Variant Type Type Object</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for data type '<em>Variant Type Type Object</em>'.
     * @see org.eclipse.scada.da.exec.configuration.VariantTypeType
     * @model instanceClass="org.eclipse.scada.da.exec.configuration.VariantTypeType"
     *        extendedMetaData="name='variantType_._type:Object' baseType='variantType_._type'"
     * @generated
     */
    EDataType getVariantTypeTypeObject ();

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
         * The meta object literal for the '{@link org.eclipse.scada.da.exec.configuration.impl.CommandTypeImpl <em>Command Type</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.da.exec.configuration.impl.CommandTypeImpl
         * @see org.eclipse.scada.da.exec.configuration.impl.ConfigurationPackageImpl#getCommandType()
         * @generated
         */
        EClass COMMAND_TYPE = eINSTANCE.getCommandType ();

        /**
         * The meta object literal for the '<em><b>Process</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference COMMAND_TYPE__PROCESS = eINSTANCE.getCommandType_Process ();

        /**
         * The meta object literal for the '<em><b>Extractor</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference COMMAND_TYPE__EXTRACTOR = eINSTANCE.getCommandType_Extractor ();

        /**
         * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute COMMAND_TYPE__ID = eINSTANCE.getCommandType_Id ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.da.exec.configuration.impl.ContinuousCommandTypeImpl <em>Continuous Command Type</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.da.exec.configuration.impl.ContinuousCommandTypeImpl
         * @see org.eclipse.scada.da.exec.configuration.impl.ConfigurationPackageImpl#getContinuousCommandType()
         * @generated
         */
        EClass CONTINUOUS_COMMAND_TYPE = eINSTANCE.getContinuousCommandType ();

        /**
         * The meta object literal for the '<em><b>Max Input Buffer</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute CONTINUOUS_COMMAND_TYPE__MAX_INPUT_BUFFER = eINSTANCE.getContinuousCommandType_MaxInputBuffer ();

        /**
         * The meta object literal for the '<em><b>Restart Delay</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute CONTINUOUS_COMMAND_TYPE__RESTART_DELAY = eINSTANCE.getContinuousCommandType_RestartDelay ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.da.exec.configuration.impl.CustomExtractorTypeImpl <em>Custom Extractor Type</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.da.exec.configuration.impl.CustomExtractorTypeImpl
         * @see org.eclipse.scada.da.exec.configuration.impl.ConfigurationPackageImpl#getCustomExtractorType()
         * @generated
         */
        EClass CUSTOM_EXTRACTOR_TYPE = eINSTANCE.getCustomExtractorType ();

        /**
         * The meta object literal for the '<em><b>Any</b></em>' attribute list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute CUSTOM_EXTRACTOR_TYPE__ANY = eINSTANCE.getCustomExtractorType_Any ();

        /**
         * The meta object literal for the '<em><b>Class</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute CUSTOM_EXTRACTOR_TYPE__CLASS = eINSTANCE.getCustomExtractorType_Class ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.da.exec.configuration.impl.DocumentRootImpl <em>Document Root</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.da.exec.configuration.impl.DocumentRootImpl
         * @see org.eclipse.scada.da.exec.configuration.impl.ConfigurationPackageImpl#getDocumentRoot()
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
         * The meta object literal for the '{@link org.eclipse.scada.da.exec.configuration.impl.EnvEntryTypeImpl <em>Env Entry Type</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.da.exec.configuration.impl.EnvEntryTypeImpl
         * @see org.eclipse.scada.da.exec.configuration.impl.ConfigurationPackageImpl#getEnvEntryType()
         * @generated
         */
        EClass ENV_ENTRY_TYPE = eINSTANCE.getEnvEntryType ();

        /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute ENV_ENTRY_TYPE__NAME = eINSTANCE.getEnvEntryType_Name ();

        /**
         * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute ENV_ENTRY_TYPE__VALUE = eINSTANCE.getEnvEntryType_Value ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.da.exec.configuration.impl.ExtractorTypeImpl <em>Extractor Type</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.da.exec.configuration.impl.ExtractorTypeImpl
         * @see org.eclipse.scada.da.exec.configuration.impl.ConfigurationPackageImpl#getExtractorType()
         * @generated
         */
        EClass EXTRACTOR_TYPE = eINSTANCE.getExtractorType ();

        /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EXTRACTOR_TYPE__NAME = eINSTANCE.getExtractorType_Name ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.da.exec.configuration.impl.FieldExtractorTypeImpl <em>Field Extractor Type</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.da.exec.configuration.impl.FieldExtractorTypeImpl
         * @see org.eclipse.scada.da.exec.configuration.impl.ConfigurationPackageImpl#getFieldExtractorType()
         * @generated
         */
        EClass FIELD_EXTRACTOR_TYPE = eINSTANCE.getFieldExtractorType ();

        /**
         * The meta object literal for the '<em><b>Field</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference FIELD_EXTRACTOR_TYPE__FIELD = eINSTANCE.getFieldExtractorType_Field ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.da.exec.configuration.impl.FieldTypeImpl <em>Field Type</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.da.exec.configuration.impl.FieldTypeImpl
         * @see org.eclipse.scada.da.exec.configuration.impl.ConfigurationPackageImpl#getFieldType()
         * @generated
         */
        EClass FIELD_TYPE = eINSTANCE.getFieldType ();

        /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute FIELD_TYPE__NAME = eINSTANCE.getFieldType_Name ();

        /**
         * The meta object literal for the '<em><b>Variant Type</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute FIELD_TYPE__VARIANT_TYPE = eINSTANCE.getFieldType_VariantType ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.da.exec.configuration.impl.HiveProcessCommandTypeImpl <em>Hive Process Command Type</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.da.exec.configuration.impl.HiveProcessCommandTypeImpl
         * @see org.eclipse.scada.da.exec.configuration.impl.ConfigurationPackageImpl#getHiveProcessCommandType()
         * @generated
         */
        EClass HIVE_PROCESS_COMMAND_TYPE = eINSTANCE.getHiveProcessCommandType ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.da.exec.configuration.impl.NagiosReturnCodeExtractorTypeImpl <em>Nagios Return Code Extractor Type</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.da.exec.configuration.impl.NagiosReturnCodeExtractorTypeImpl
         * @see org.eclipse.scada.da.exec.configuration.impl.ConfigurationPackageImpl#getNagiosReturnCodeExtractorType()
         * @generated
         */
        EClass NAGIOS_RETURN_CODE_EXTRACTOR_TYPE = eINSTANCE.getNagiosReturnCodeExtractorType ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.da.exec.configuration.impl.PlainStreamExtractorTypeImpl <em>Plain Stream Extractor Type</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.da.exec.configuration.impl.PlainStreamExtractorTypeImpl
         * @see org.eclipse.scada.da.exec.configuration.impl.ConfigurationPackageImpl#getPlainStreamExtractorType()
         * @generated
         */
        EClass PLAIN_STREAM_EXTRACTOR_TYPE = eINSTANCE.getPlainStreamExtractorType ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.da.exec.configuration.impl.ProcessTypeImpl <em>Process Type</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.da.exec.configuration.impl.ProcessTypeImpl
         * @see org.eclipse.scada.da.exec.configuration.impl.ConfigurationPackageImpl#getProcessType()
         * @generated
         */
        EClass PROCESS_TYPE = eINSTANCE.getProcessType ();

        /**
         * The meta object literal for the '<em><b>Argument</b></em>' attribute list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute PROCESS_TYPE__ARGUMENT = eINSTANCE.getProcessType_Argument ();

        /**
         * The meta object literal for the '<em><b>Env</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference PROCESS_TYPE__ENV = eINSTANCE.getProcessType_Env ();

        /**
         * The meta object literal for the '<em><b>Exec</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute PROCESS_TYPE__EXEC = eINSTANCE.getProcessType_Exec ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.da.exec.configuration.impl.QueueTypeImpl <em>Queue Type</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.da.exec.configuration.impl.QueueTypeImpl
         * @see org.eclipse.scada.da.exec.configuration.impl.ConfigurationPackageImpl#getQueueType()
         * @generated
         */
        EClass QUEUE_TYPE = eINSTANCE.getQueueType ();

        /**
         * The meta object literal for the '<em><b>Command</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference QUEUE_TYPE__COMMAND = eINSTANCE.getQueueType_Command ();

        /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute QUEUE_TYPE__NAME = eINSTANCE.getQueueType_Name ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.da.exec.configuration.impl.RegExExtractorTypeImpl <em>Reg Ex Extractor Type</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.da.exec.configuration.impl.RegExExtractorTypeImpl
         * @see org.eclipse.scada.da.exec.configuration.impl.ConfigurationPackageImpl#getRegExExtractorType()
         * @generated
         */
        EClass REG_EX_EXTRACTOR_TYPE = eINSTANCE.getRegExExtractorType ();

        /**
         * The meta object literal for the '<em><b>Expression</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute REG_EX_EXTRACTOR_TYPE__EXPRESSION = eINSTANCE.getRegExExtractorType_Expression ();

        /**
         * The meta object literal for the '<em><b>Require Full Match</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute REG_EX_EXTRACTOR_TYPE__REQUIRE_FULL_MATCH = eINSTANCE.getRegExExtractorType_RequireFullMatch ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.da.exec.configuration.impl.ReturnCodeExtractorTypeImpl <em>Return Code Extractor Type</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.da.exec.configuration.impl.ReturnCodeExtractorTypeImpl
         * @see org.eclipse.scada.da.exec.configuration.impl.ConfigurationPackageImpl#getReturnCodeExtractorType()
         * @generated
         */
        EClass RETURN_CODE_EXTRACTOR_TYPE = eINSTANCE.getReturnCodeExtractorType ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.da.exec.configuration.impl.RootTypeImpl <em>Root Type</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.da.exec.configuration.impl.RootTypeImpl
         * @see org.eclipse.scada.da.exec.configuration.impl.ConfigurationPackageImpl#getRootType()
         * @generated
         */
        EClass ROOT_TYPE = eINSTANCE.getRootType ();

        /**
         * The meta object literal for the '<em><b>Group</b></em>' attribute list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute ROOT_TYPE__GROUP = eINSTANCE.getRootType_Group ();

        /**
         * The meta object literal for the '<em><b>Queue</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference ROOT_TYPE__QUEUE = eINSTANCE.getRootType_Queue ();

        /**
         * The meta object literal for the '<em><b>Command</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference ROOT_TYPE__COMMAND = eINSTANCE.getRootType_Command ();

        /**
         * The meta object literal for the '<em><b>Hive Process</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference ROOT_TYPE__HIVE_PROCESS = eINSTANCE.getRootType_HiveProcess ();

        /**
         * The meta object literal for the '<em><b>Trigger</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference ROOT_TYPE__TRIGGER = eINSTANCE.getRootType_Trigger ();

        /**
         * The meta object literal for the '<em><b>Additional Configuration Directory</b></em>' attribute list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute ROOT_TYPE__ADDITIONAL_CONFIGURATION_DIRECTORY = eINSTANCE.getRootType_AdditionalConfigurationDirectory ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.da.exec.configuration.impl.SimpleExtractorTypeImpl <em>Simple Extractor Type</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.da.exec.configuration.impl.SimpleExtractorTypeImpl
         * @see org.eclipse.scada.da.exec.configuration.impl.ConfigurationPackageImpl#getSimpleExtractorType()
         * @generated
         */
        EClass SIMPLE_EXTRACTOR_TYPE = eINSTANCE.getSimpleExtractorType ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.da.exec.configuration.impl.SingleCommandTypeImpl <em>Single Command Type</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.da.exec.configuration.impl.SingleCommandTypeImpl
         * @see org.eclipse.scada.da.exec.configuration.impl.ConfigurationPackageImpl#getSingleCommandType()
         * @generated
         */
        EClass SINGLE_COMMAND_TYPE = eINSTANCE.getSingleCommandType ();

        /**
         * The meta object literal for the '<em><b>Period</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SINGLE_COMMAND_TYPE__PERIOD = eINSTANCE.getSingleCommandType_Period ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.da.exec.configuration.impl.SplitContinuousCommandTypeImpl <em>Split Continuous Command Type</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.da.exec.configuration.impl.SplitContinuousCommandTypeImpl
         * @see org.eclipse.scada.da.exec.configuration.impl.ConfigurationPackageImpl#getSplitContinuousCommandType()
         * @generated
         */
        EClass SPLIT_CONTINUOUS_COMMAND_TYPE = eINSTANCE.getSplitContinuousCommandType ();

        /**
         * The meta object literal for the '<em><b>Splitter</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference SPLIT_CONTINUOUS_COMMAND_TYPE__SPLITTER = eINSTANCE.getSplitContinuousCommandType_Splitter ();

        /**
         * The meta object literal for the '<em><b>Ignore Start Lines</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SPLIT_CONTINUOUS_COMMAND_TYPE__IGNORE_START_LINES = eINSTANCE.getSplitContinuousCommandType_IgnoreStartLines ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.da.exec.configuration.impl.SplitterExtractorTypeImpl <em>Splitter Extractor Type</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.da.exec.configuration.impl.SplitterExtractorTypeImpl
         * @see org.eclipse.scada.da.exec.configuration.impl.ConfigurationPackageImpl#getSplitterExtractorType()
         * @generated
         */
        EClass SPLITTER_EXTRACTOR_TYPE = eINSTANCE.getSplitterExtractorType ();

        /**
         * The meta object literal for the '<em><b>Split Expression</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SPLITTER_EXTRACTOR_TYPE__SPLIT_EXPRESSION = eINSTANCE.getSplitterExtractorType_SplitExpression ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.da.exec.configuration.impl.SplitterTypeImpl <em>Splitter Type</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.da.exec.configuration.impl.SplitterTypeImpl
         * @see org.eclipse.scada.da.exec.configuration.impl.ConfigurationPackageImpl#getSplitterType()
         * @generated
         */
        EClass SPLITTER_TYPE = eINSTANCE.getSplitterType ();

        /**
         * The meta object literal for the '<em><b>Parameter</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SPLITTER_TYPE__PARAMETER = eINSTANCE.getSplitterType_Parameter ();

        /**
         * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SPLITTER_TYPE__TYPE = eINSTANCE.getSplitterType_Type ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.da.exec.configuration.impl.TriggerCommandTypeImpl <em>Trigger Command Type</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.da.exec.configuration.impl.TriggerCommandTypeImpl
         * @see org.eclipse.scada.da.exec.configuration.impl.ConfigurationPackageImpl#getTriggerCommandType()
         * @generated
         */
        EClass TRIGGER_COMMAND_TYPE = eINSTANCE.getTriggerCommandType ();

        /**
         * The meta object literal for the '<em><b>Argument Placeholder</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute TRIGGER_COMMAND_TYPE__ARGUMENT_PLACEHOLDER = eINSTANCE.getTriggerCommandType_ArgumentPlaceholder ();

        /**
         * The meta object literal for the '<em><b>Fork</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute TRIGGER_COMMAND_TYPE__FORK = eINSTANCE.getTriggerCommandType_Fork ();

        /**
         * The meta object literal for the '<em><b>Skip If Null</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute TRIGGER_COMMAND_TYPE__SKIP_IF_NULL = eINSTANCE.getTriggerCommandType_SkipIfNull ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.da.exec.configuration.VariantTypeType <em>Variant Type Type</em>}' enum.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.da.exec.configuration.VariantTypeType
         * @see org.eclipse.scada.da.exec.configuration.impl.ConfigurationPackageImpl#getVariantTypeType()
         * @generated
         */
        EEnum VARIANT_TYPE_TYPE = eINSTANCE.getVariantTypeType ();

        /**
         * The meta object literal for the '<em>Class Type</em>' data type.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see java.lang.String
         * @see org.eclipse.scada.da.exec.configuration.impl.ConfigurationPackageImpl#getClassType()
         * @generated
         */
        EDataType CLASS_TYPE = eINSTANCE.getClassType ();

        /**
         * The meta object literal for the '<em>Name Type</em>' data type.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see java.lang.String
         * @see org.eclipse.scada.da.exec.configuration.impl.ConfigurationPackageImpl#getNameType()
         * @generated
         */
        EDataType NAME_TYPE = eINSTANCE.getNameType ();

        /**
         * The meta object literal for the '<em>Name Type1</em>' data type.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see java.lang.String
         * @see org.eclipse.scada.da.exec.configuration.impl.ConfigurationPackageImpl#getNameType1()
         * @generated
         */
        EDataType NAME_TYPE1 = eINSTANCE.getNameType1 ();

        /**
         * The meta object literal for the '<em>Period Type</em>' data type.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.da.exec.configuration.impl.ConfigurationPackageImpl#getPeriodType()
         * @generated
         */
        EDataType PERIOD_TYPE = eINSTANCE.getPeriodType ();

        /**
         * The meta object literal for the '<em>Period Type Object</em>' data type.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see java.lang.Integer
         * @see org.eclipse.scada.da.exec.configuration.impl.ConfigurationPackageImpl#getPeriodTypeObject()
         * @generated
         */
        EDataType PERIOD_TYPE_OBJECT = eINSTANCE.getPeriodTypeObject ();

        /**
         * The meta object literal for the '<em>Restart Delay Type</em>' data type.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.da.exec.configuration.impl.ConfigurationPackageImpl#getRestartDelayType()
         * @generated
         */
        EDataType RESTART_DELAY_TYPE = eINSTANCE.getRestartDelayType ();

        /**
         * The meta object literal for the '<em>Restart Delay Type Object</em>' data type.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see java.lang.Integer
         * @see org.eclipse.scada.da.exec.configuration.impl.ConfigurationPackageImpl#getRestartDelayTypeObject()
         * @generated
         */
        EDataType RESTART_DELAY_TYPE_OBJECT = eINSTANCE.getRestartDelayTypeObject ();

        /**
         * The meta object literal for the '<em>Type Type</em>' data type.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see java.lang.String
         * @see org.eclipse.scada.da.exec.configuration.impl.ConfigurationPackageImpl#getTypeType()
         * @generated
         */
        EDataType TYPE_TYPE = eINSTANCE.getTypeType ();

        /**
         * The meta object literal for the '<em>Variant Type Type Object</em>' data type.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.da.exec.configuration.VariantTypeType
         * @see org.eclipse.scada.da.exec.configuration.impl.ConfigurationPackageImpl#getVariantTypeTypeObject()
         * @generated
         */
        EDataType VARIANT_TYPE_TYPE_OBJECT = eINSTANCE.getVariantTypeTypeObject ();

    }

} //ConfigurationPackage
