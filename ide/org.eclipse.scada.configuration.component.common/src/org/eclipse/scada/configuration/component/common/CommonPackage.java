/**
 * Copyright (c) 2013, 2014 IBH SYSTEMS GmbH.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation and/or initial documentation
 * 
 */
package org.eclipse.scada.configuration.component.common;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.scada.configuration.component.ComponentPackage;

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
 * @see org.eclipse.scada.configuration.component.common.CommonFactory
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
    String eNS_URI = "http://eclipse.org/SCADA/Configuration/Component/Common"; //$NON-NLS-1$

    /**
     * The package namespace name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_PREFIX = "common"; //$NON-NLS-1$

    /**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    CommonPackage eINSTANCE = org.eclipse.scada.configuration.component.common.impl.CommonPackageImpl.init ();

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.component.common.impl.HeartbeatGeneratorImpl <em>Heartbeat Generator</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.component.common.impl.HeartbeatGeneratorImpl
     * @see org.eclipse.scada.configuration.component.common.impl.CommonPackageImpl#getHeartbeatGenerator()
     * @generated
     */
    int HEARTBEAT_GENERATOR = 0;

    /**
     * The feature id for the '<em><b>Short Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HEARTBEAT_GENERATOR__SHORT_DESCRIPTION = ComponentPackage.MASTER_COMPONENT__SHORT_DESCRIPTION;

    /**
     * The feature id for the '<em><b>Level</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HEARTBEAT_GENERATOR__LEVEL = ComponentPackage.MASTER_COMPONENT__LEVEL;

    /**
     * The feature id for the '<em><b>Customization Pipeline</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HEARTBEAT_GENERATOR__CUSTOMIZATION_PIPELINE = ComponentPackage.MASTER_COMPONENT__CUSTOMIZATION_PIPELINE;

    /**
     * The feature id for the '<em><b>Archive Selector</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HEARTBEAT_GENERATOR__ARCHIVE_SELECTOR = ComponentPackage.MASTER_COMPONENT__ARCHIVE_SELECTOR;

    /**
     * The feature id for the '<em><b>Properties</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HEARTBEAT_GENERATOR__PROPERTIES = ComponentPackage.MASTER_COMPONENT__PROPERTIES;

    /**
     * The feature id for the '<em><b>Master On</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HEARTBEAT_GENERATOR__MASTER_ON = ComponentPackage.MASTER_COMPONENT__MASTER_ON;

    /**
     * The feature id for the '<em><b>Period</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HEARTBEAT_GENERATOR__PERIOD = ComponentPackage.MASTER_COMPONENT_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Target Item</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HEARTBEAT_GENERATOR__TARGET_ITEM = ComponentPackage.MASTER_COMPONENT_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Active Input</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HEARTBEAT_GENERATOR__ACTIVE_INPUT = ComponentPackage.MASTER_COMPONENT_FEATURE_COUNT + 2;

    /**
     * The number of structural features of the '<em>Heartbeat Generator</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HEARTBEAT_GENERATOR_FEATURE_COUNT = ComponentPackage.MASTER_COMPONENT_FEATURE_COUNT + 3;

    /**
     * The operation id for the '<em>Get Master On</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HEARTBEAT_GENERATOR___GET_MASTER_ON = ComponentPackage.MASTER_COMPONENT___GET_MASTER_ON;

    /**
     * The number of operations of the '<em>Heartbeat Generator</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HEARTBEAT_GENERATOR_OPERATION_COUNT = ComponentPackage.MASTER_COMPONENT_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.component.common.impl.ToggleHeartbeatGeneratorImpl <em>Toggle Heartbeat Generator</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.component.common.impl.ToggleHeartbeatGeneratorImpl
     * @see org.eclipse.scada.configuration.component.common.impl.CommonPackageImpl#getToggleHeartbeatGenerator()
     * @generated
     */
    int TOGGLE_HEARTBEAT_GENERATOR = 1;

    /**
     * The feature id for the '<em><b>Short Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TOGGLE_HEARTBEAT_GENERATOR__SHORT_DESCRIPTION = HEARTBEAT_GENERATOR__SHORT_DESCRIPTION;

    /**
     * The feature id for the '<em><b>Level</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TOGGLE_HEARTBEAT_GENERATOR__LEVEL = HEARTBEAT_GENERATOR__LEVEL;

    /**
     * The feature id for the '<em><b>Customization Pipeline</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TOGGLE_HEARTBEAT_GENERATOR__CUSTOMIZATION_PIPELINE = HEARTBEAT_GENERATOR__CUSTOMIZATION_PIPELINE;

    /**
     * The feature id for the '<em><b>Archive Selector</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TOGGLE_HEARTBEAT_GENERATOR__ARCHIVE_SELECTOR = HEARTBEAT_GENERATOR__ARCHIVE_SELECTOR;

    /**
     * The feature id for the '<em><b>Properties</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TOGGLE_HEARTBEAT_GENERATOR__PROPERTIES = HEARTBEAT_GENERATOR__PROPERTIES;

    /**
     * The feature id for the '<em><b>Master On</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TOGGLE_HEARTBEAT_GENERATOR__MASTER_ON = HEARTBEAT_GENERATOR__MASTER_ON;

    /**
     * The feature id for the '<em><b>Period</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TOGGLE_HEARTBEAT_GENERATOR__PERIOD = HEARTBEAT_GENERATOR__PERIOD;

    /**
     * The feature id for the '<em><b>Target Item</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TOGGLE_HEARTBEAT_GENERATOR__TARGET_ITEM = HEARTBEAT_GENERATOR__TARGET_ITEM;

    /**
     * The feature id for the '<em><b>Active Input</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TOGGLE_HEARTBEAT_GENERATOR__ACTIVE_INPUT = HEARTBEAT_GENERATOR__ACTIVE_INPUT;

    /**
     * The number of structural features of the '<em>Toggle Heartbeat Generator</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TOGGLE_HEARTBEAT_GENERATOR_FEATURE_COUNT = HEARTBEAT_GENERATOR_FEATURE_COUNT + 0;

    /**
     * The operation id for the '<em>Get Master On</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TOGGLE_HEARTBEAT_GENERATOR___GET_MASTER_ON = HEARTBEAT_GENERATOR___GET_MASTER_ON;

    /**
     * The number of operations of the '<em>Toggle Heartbeat Generator</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TOGGLE_HEARTBEAT_GENERATOR_OPERATION_COUNT = HEARTBEAT_GENERATOR_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.component.common.impl.HeartbeatDetectorImpl <em>Heartbeat Detector</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.component.common.impl.HeartbeatDetectorImpl
     * @see org.eclipse.scada.configuration.component.common.impl.CommonPackageImpl#getHeartbeatDetector()
     * @generated
     */
    int HEARTBEAT_DETECTOR = 2;

    /**
     * The feature id for the '<em><b>Short Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HEARTBEAT_DETECTOR__SHORT_DESCRIPTION = ComponentPackage.MASTER_COMPONENT__SHORT_DESCRIPTION;

    /**
     * The feature id for the '<em><b>Level</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HEARTBEAT_DETECTOR__LEVEL = ComponentPackage.MASTER_COMPONENT__LEVEL;

    /**
     * The feature id for the '<em><b>Customization Pipeline</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HEARTBEAT_DETECTOR__CUSTOMIZATION_PIPELINE = ComponentPackage.MASTER_COMPONENT__CUSTOMIZATION_PIPELINE;

    /**
     * The feature id for the '<em><b>Archive Selector</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HEARTBEAT_DETECTOR__ARCHIVE_SELECTOR = ComponentPackage.MASTER_COMPONENT__ARCHIVE_SELECTOR;

    /**
     * The feature id for the '<em><b>Properties</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HEARTBEAT_DETECTOR__PROPERTIES = ComponentPackage.MASTER_COMPONENT__PROPERTIES;

    /**
     * The feature id for the '<em><b>Master On</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HEARTBEAT_DETECTOR__MASTER_ON = ComponentPackage.MASTER_COMPONENT__MASTER_ON;

    /**
     * The number of structural features of the '<em>Heartbeat Detector</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HEARTBEAT_DETECTOR_FEATURE_COUNT = ComponentPackage.MASTER_COMPONENT_FEATURE_COUNT + 0;

    /**
     * The operation id for the '<em>Get Master On</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HEARTBEAT_DETECTOR___GET_MASTER_ON = ComponentPackage.MASTER_COMPONENT___GET_MASTER_ON;

    /**
     * The number of operations of the '<em>Heartbeat Detector</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HEARTBEAT_DETECTOR_OPERATION_COUNT = ComponentPackage.MASTER_COMPONENT_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.component.common.impl.ChangeHeartbeatDetectorImpl <em>Change Heartbeat Detector</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.component.common.impl.ChangeHeartbeatDetectorImpl
     * @see org.eclipse.scada.configuration.component.common.impl.CommonPackageImpl#getChangeHeartbeatDetector()
     * @generated
     */
    int CHANGE_HEARTBEAT_DETECTOR = 3;

    /**
     * The feature id for the '<em><b>Short Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CHANGE_HEARTBEAT_DETECTOR__SHORT_DESCRIPTION = HEARTBEAT_DETECTOR__SHORT_DESCRIPTION;

    /**
     * The feature id for the '<em><b>Level</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CHANGE_HEARTBEAT_DETECTOR__LEVEL = HEARTBEAT_DETECTOR__LEVEL;

    /**
     * The feature id for the '<em><b>Customization Pipeline</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CHANGE_HEARTBEAT_DETECTOR__CUSTOMIZATION_PIPELINE = HEARTBEAT_DETECTOR__CUSTOMIZATION_PIPELINE;

    /**
     * The feature id for the '<em><b>Archive Selector</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CHANGE_HEARTBEAT_DETECTOR__ARCHIVE_SELECTOR = HEARTBEAT_DETECTOR__ARCHIVE_SELECTOR;

    /**
     * The feature id for the '<em><b>Properties</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CHANGE_HEARTBEAT_DETECTOR__PROPERTIES = HEARTBEAT_DETECTOR__PROPERTIES;

    /**
     * The feature id for the '<em><b>Master On</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CHANGE_HEARTBEAT_DETECTOR__MASTER_ON = HEARTBEAT_DETECTOR__MASTER_ON;

    /**
     * The feature id for the '<em><b>Timeout</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CHANGE_HEARTBEAT_DETECTOR__TIMEOUT = HEARTBEAT_DETECTOR_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Check Period</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CHANGE_HEARTBEAT_DETECTOR__CHECK_PERIOD = HEARTBEAT_DETECTOR_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Source Item</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CHANGE_HEARTBEAT_DETECTOR__SOURCE_ITEM = HEARTBEAT_DETECTOR_FEATURE_COUNT + 2;

    /**
     * The number of structural features of the '<em>Change Heartbeat Detector</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CHANGE_HEARTBEAT_DETECTOR_FEATURE_COUNT = HEARTBEAT_DETECTOR_FEATURE_COUNT + 3;

    /**
     * The operation id for the '<em>Get Master On</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CHANGE_HEARTBEAT_DETECTOR___GET_MASTER_ON = HEARTBEAT_DETECTOR___GET_MASTER_ON;

    /**
     * The number of operations of the '<em>Change Heartbeat Detector</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CHANGE_HEARTBEAT_DETECTOR_OPERATION_COUNT = HEARTBEAT_DETECTOR_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.component.common.impl.TimerActionImpl <em>Timer Action</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.component.common.impl.TimerActionImpl
     * @see org.eclipse.scada.configuration.component.common.impl.CommonPackageImpl#getTimerAction()
     * @generated
     */
    int TIMER_ACTION = 4;

    /**
     * The feature id for the '<em><b>Short Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TIMER_ACTION__SHORT_DESCRIPTION = ComponentPackage.MASTER_COMPONENT__SHORT_DESCRIPTION;

    /**
     * The feature id for the '<em><b>Level</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TIMER_ACTION__LEVEL = ComponentPackage.MASTER_COMPONENT__LEVEL;

    /**
     * The feature id for the '<em><b>Customization Pipeline</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TIMER_ACTION__CUSTOMIZATION_PIPELINE = ComponentPackage.MASTER_COMPONENT__CUSTOMIZATION_PIPELINE;

    /**
     * The feature id for the '<em><b>Archive Selector</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TIMER_ACTION__ARCHIVE_SELECTOR = ComponentPackage.MASTER_COMPONENT__ARCHIVE_SELECTOR;

    /**
     * The feature id for the '<em><b>Properties</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TIMER_ACTION__PROPERTIES = ComponentPackage.MASTER_COMPONENT__PROPERTIES;

    /**
     * The feature id for the '<em><b>Master On</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TIMER_ACTION__MASTER_ON = ComponentPackage.MASTER_COMPONENT__MASTER_ON;

    /**
     * The feature id for the '<em><b>Period</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TIMER_ACTION__PERIOD = ComponentPackage.MASTER_COMPONENT_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Target Item</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TIMER_ACTION__TARGET_ITEM = ComponentPackage.MASTER_COMPONENT_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TIMER_ACTION__VALUE = ComponentPackage.MASTER_COMPONENT_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TIMER_ACTION__NAME = ComponentPackage.MASTER_COMPONENT_FEATURE_COUNT + 3;

    /**
     * The number of structural features of the '<em>Timer Action</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TIMER_ACTION_FEATURE_COUNT = ComponentPackage.MASTER_COMPONENT_FEATURE_COUNT + 4;

    /**
     * The operation id for the '<em>Get Master On</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TIMER_ACTION___GET_MASTER_ON = ComponentPackage.MASTER_COMPONENT___GET_MASTER_ON;

    /**
     * The number of operations of the '<em>Timer Action</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TIMER_ACTION_OPERATION_COUNT = ComponentPackage.MASTER_COMPONENT_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.component.common.impl.CurrentTimeComponentImpl <em>Current Time Component</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.component.common.impl.CurrentTimeComponentImpl
     * @see org.eclipse.scada.configuration.component.common.impl.CommonPackageImpl#getCurrentTimeComponent()
     * @generated
     */
    int CURRENT_TIME_COMPONENT = 5;

    /**
     * The feature id for the '<em><b>Short Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CURRENT_TIME_COMPONENT__SHORT_DESCRIPTION = ComponentPackage.MASTER_COMPONENT__SHORT_DESCRIPTION;

    /**
     * The feature id for the '<em><b>Level</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CURRENT_TIME_COMPONENT__LEVEL = ComponentPackage.MASTER_COMPONENT__LEVEL;

    /**
     * The feature id for the '<em><b>Customization Pipeline</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CURRENT_TIME_COMPONENT__CUSTOMIZATION_PIPELINE = ComponentPackage.MASTER_COMPONENT__CUSTOMIZATION_PIPELINE;

    /**
     * The feature id for the '<em><b>Archive Selector</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CURRENT_TIME_COMPONENT__ARCHIVE_SELECTOR = ComponentPackage.MASTER_COMPONENT__ARCHIVE_SELECTOR;

    /**
     * The feature id for the '<em><b>Properties</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CURRENT_TIME_COMPONENT__PROPERTIES = ComponentPackage.MASTER_COMPONENT__PROPERTIES;

    /**
     * The feature id for the '<em><b>Master On</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CURRENT_TIME_COMPONENT__MASTER_ON = ComponentPackage.MASTER_COMPONENT__MASTER_ON;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CURRENT_TIME_COMPONENT__NAME = ComponentPackage.MASTER_COMPONENT_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Update Period</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CURRENT_TIME_COMPONENT__UPDATE_PERIOD = ComponentPackage.MASTER_COMPONENT_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Date Format</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CURRENT_TIME_COMPONENT__DATE_FORMAT = ComponentPackage.MASTER_COMPONENT_FEATURE_COUNT + 2;

    /**
     * The number of structural features of the '<em>Current Time Component</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CURRENT_TIME_COMPONENT_FEATURE_COUNT = ComponentPackage.MASTER_COMPONENT_FEATURE_COUNT + 3;

    /**
     * The operation id for the '<em>Get Master On</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CURRENT_TIME_COMPONENT___GET_MASTER_ON = ComponentPackage.MASTER_COMPONENT___GET_MASTER_ON;

    /**
     * The number of operations of the '<em>Current Time Component</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CURRENT_TIME_COMPONENT_OPERATION_COUNT = ComponentPackage.MASTER_COMPONENT_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.component.common.impl.ScaledValueImpl <em>Scaled Value</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.component.common.impl.ScaledValueImpl
     * @see org.eclipse.scada.configuration.component.common.impl.CommonPackageImpl#getScaledValue()
     * @generated
     */
    int SCALED_VALUE = 6;

    /**
     * The feature id for the '<em><b>Short Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCALED_VALUE__SHORT_DESCRIPTION = ComponentPackage.SINGLE_VALUE__SHORT_DESCRIPTION;

    /**
     * The feature id for the '<em><b>Level</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCALED_VALUE__LEVEL = ComponentPackage.SINGLE_VALUE__LEVEL;

    /**
     * The feature id for the '<em><b>Customization Pipeline</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCALED_VALUE__CUSTOMIZATION_PIPELINE = ComponentPackage.SINGLE_VALUE__CUSTOMIZATION_PIPELINE;

    /**
     * The feature id for the '<em><b>Archive Selector</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCALED_VALUE__ARCHIVE_SELECTOR = ComponentPackage.SINGLE_VALUE__ARCHIVE_SELECTOR;

    /**
     * The feature id for the '<em><b>Properties</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCALED_VALUE__PROPERTIES = ComponentPackage.SINGLE_VALUE__PROPERTIES;

    /**
     * The feature id for the '<em><b>Master On</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCALED_VALUE__MASTER_ON = ComponentPackage.SINGLE_VALUE__MASTER_ON;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCALED_VALUE__NAME = ComponentPackage.SINGLE_VALUE__NAME;

    /**
     * The feature id for the '<em><b>Data Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCALED_VALUE__DATA_TYPE = ComponentPackage.SINGLE_VALUE__DATA_TYPE;

    /**
     * The feature id for the '<em><b>Customization Tags</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCALED_VALUE__CUSTOMIZATION_TAGS = ComponentPackage.SINGLE_VALUE__CUSTOMIZATION_TAGS;

    /**
     * The feature id for the '<em><b>Source Item</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCALED_VALUE__SOURCE_ITEM = ComponentPackage.SINGLE_VALUE_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Input Minimum</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCALED_VALUE__INPUT_MINIMUM = ComponentPackage.SINGLE_VALUE_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Input Maximum</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCALED_VALUE__INPUT_MAXIMUM = ComponentPackage.SINGLE_VALUE_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Output Minimum</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCALED_VALUE__OUTPUT_MINIMUM = ComponentPackage.SINGLE_VALUE_FEATURE_COUNT + 3;

    /**
     * The feature id for the '<em><b>Output Maximum</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCALED_VALUE__OUTPUT_MAXIMUM = ComponentPackage.SINGLE_VALUE_FEATURE_COUNT + 4;

    /**
     * The feature id for the '<em><b>Validate Range</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCALED_VALUE__VALIDATE_RANGE = ComponentPackage.SINGLE_VALUE_FEATURE_COUNT + 5;

    /**
     * The number of structural features of the '<em>Scaled Value</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCALED_VALUE_FEATURE_COUNT = ComponentPackage.SINGLE_VALUE_FEATURE_COUNT + 6;

    /**
     * The operation id for the '<em>Get Master On</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCALED_VALUE___GET_MASTER_ON = ComponentPackage.SINGLE_VALUE___GET_MASTER_ON;

    /**
     * The operation id for the '<em>Is Readable</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCALED_VALUE___IS_READABLE = ComponentPackage.SINGLE_VALUE___IS_READABLE;

    /**
     * The operation id for the '<em>Is Writable</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCALED_VALUE___IS_WRITABLE = ComponentPackage.SINGLE_VALUE___IS_WRITABLE;

    /**
     * The number of operations of the '<em>Scaled Value</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCALED_VALUE_OPERATION_COUNT = ComponentPackage.SINGLE_VALUE_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '<em>Date Format</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.component.common.DateFormat
     * @see org.eclipse.scada.configuration.component.common.impl.CommonPackageImpl#getDateFormat()
     * @generated
     */
    int DATE_FORMAT = 7;

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.component.common.HeartbeatGenerator <em>Heartbeat Generator</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Heartbeat Generator</em>'.
     * @see org.eclipse.scada.configuration.component.common.HeartbeatGenerator
     * @generated
     */
    EClass getHeartbeatGenerator ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.component.common.HeartbeatGenerator#getPeriod <em>Period</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Period</em>'.
     * @see org.eclipse.scada.configuration.component.common.HeartbeatGenerator#getPeriod()
     * @see #getHeartbeatGenerator()
     * @generated
     */
    EAttribute getHeartbeatGenerator_Period ();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.scada.configuration.component.common.HeartbeatGenerator#getTargetItem <em>Target Item</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Target Item</em>'.
     * @see org.eclipse.scada.configuration.component.common.HeartbeatGenerator#getTargetItem()
     * @see #getHeartbeatGenerator()
     * @generated
     */
    EReference getHeartbeatGenerator_TargetItem ();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.scada.configuration.component.common.HeartbeatGenerator#getActiveInput <em>Active Input</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Active Input</em>'.
     * @see org.eclipse.scada.configuration.component.common.HeartbeatGenerator#getActiveInput()
     * @see #getHeartbeatGenerator()
     * @generated
     */
    EReference getHeartbeatGenerator_ActiveInput ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.component.common.ToggleHeartbeatGenerator <em>Toggle Heartbeat Generator</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Toggle Heartbeat Generator</em>'.
     * @see org.eclipse.scada.configuration.component.common.ToggleHeartbeatGenerator
     * @generated
     */
    EClass getToggleHeartbeatGenerator ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.component.common.HeartbeatDetector <em>Heartbeat Detector</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Heartbeat Detector</em>'.
     * @see org.eclipse.scada.configuration.component.common.HeartbeatDetector
     * @generated
     */
    EClass getHeartbeatDetector ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.component.common.ChangeHeartbeatDetector <em>Change Heartbeat Detector</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Change Heartbeat Detector</em>'.
     * @see org.eclipse.scada.configuration.component.common.ChangeHeartbeatDetector
     * @generated
     */
    EClass getChangeHeartbeatDetector ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.component.common.ChangeHeartbeatDetector#getTimeout <em>Timeout</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Timeout</em>'.
     * @see org.eclipse.scada.configuration.component.common.ChangeHeartbeatDetector#getTimeout()
     * @see #getChangeHeartbeatDetector()
     * @generated
     */
    EAttribute getChangeHeartbeatDetector_Timeout ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.component.common.ChangeHeartbeatDetector#getCheckPeriod <em>Check Period</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Check Period</em>'.
     * @see org.eclipse.scada.configuration.component.common.ChangeHeartbeatDetector#getCheckPeriod()
     * @see #getChangeHeartbeatDetector()
     * @generated
     */
    EAttribute getChangeHeartbeatDetector_CheckPeriod ();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.scada.configuration.component.common.ChangeHeartbeatDetector#getSourceItem <em>Source Item</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Source Item</em>'.
     * @see org.eclipse.scada.configuration.component.common.ChangeHeartbeatDetector#getSourceItem()
     * @see #getChangeHeartbeatDetector()
     * @generated
     */
    EReference getChangeHeartbeatDetector_SourceItem ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.component.common.TimerAction <em>Timer Action</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Timer Action</em>'.
     * @see org.eclipse.scada.configuration.component.common.TimerAction
     * @generated
     */
    EClass getTimerAction ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.component.common.TimerAction#getPeriod <em>Period</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Period</em>'.
     * @see org.eclipse.scada.configuration.component.common.TimerAction#getPeriod()
     * @see #getTimerAction()
     * @generated
     */
    EAttribute getTimerAction_Period ();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.scada.configuration.component.common.TimerAction#getTargetItem <em>Target Item</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Target Item</em>'.
     * @see org.eclipse.scada.configuration.component.common.TimerAction#getTargetItem()
     * @see #getTimerAction()
     * @generated
     */
    EReference getTimerAction_TargetItem ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.component.common.TimerAction#getValue <em>Value</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Value</em>'.
     * @see org.eclipse.scada.configuration.component.common.TimerAction#getValue()
     * @see #getTimerAction()
     * @generated
     */
    EAttribute getTimerAction_Value ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.component.common.TimerAction#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see org.eclipse.scada.configuration.component.common.TimerAction#getName()
     * @see #getTimerAction()
     * @generated
     */
    EAttribute getTimerAction_Name ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.component.common.CurrentTimeComponent <em>Current Time Component</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Current Time Component</em>'.
     * @see org.eclipse.scada.configuration.component.common.CurrentTimeComponent
     * @generated
     */
    EClass getCurrentTimeComponent ();

    /**
     * Returns the meta object for the attribute list '{@link org.eclipse.scada.configuration.component.common.CurrentTimeComponent#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute list '<em>Name</em>'.
     * @see org.eclipse.scada.configuration.component.common.CurrentTimeComponent#getName()
     * @see #getCurrentTimeComponent()
     * @generated
     */
    EAttribute getCurrentTimeComponent_Name ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.component.common.CurrentTimeComponent#getUpdatePeriod <em>Update Period</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Update Period</em>'.
     * @see org.eclipse.scada.configuration.component.common.CurrentTimeComponent#getUpdatePeriod()
     * @see #getCurrentTimeComponent()
     * @generated
     */
    EAttribute getCurrentTimeComponent_UpdatePeriod ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.component.common.CurrentTimeComponent#getDateFormat <em>Date Format</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Date Format</em>'.
     * @see org.eclipse.scada.configuration.component.common.CurrentTimeComponent#getDateFormat()
     * @see #getCurrentTimeComponent()
     * @generated
     */
    EAttribute getCurrentTimeComponent_DateFormat ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.component.common.ScaledValue <em>Scaled Value</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Scaled Value</em>'.
     * @see org.eclipse.scada.configuration.component.common.ScaledValue
     * @generated
     */
    EClass getScaledValue ();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.scada.configuration.component.common.ScaledValue#getSourceItem <em>Source Item</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Source Item</em>'.
     * @see org.eclipse.scada.configuration.component.common.ScaledValue#getSourceItem()
     * @see #getScaledValue()
     * @generated
     */
    EReference getScaledValue_SourceItem ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.component.common.ScaledValue#getInputMinimum <em>Input Minimum</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Input Minimum</em>'.
     * @see org.eclipse.scada.configuration.component.common.ScaledValue#getInputMinimum()
     * @see #getScaledValue()
     * @generated
     */
    EAttribute getScaledValue_InputMinimum ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.component.common.ScaledValue#getInputMaximum <em>Input Maximum</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Input Maximum</em>'.
     * @see org.eclipse.scada.configuration.component.common.ScaledValue#getInputMaximum()
     * @see #getScaledValue()
     * @generated
     */
    EAttribute getScaledValue_InputMaximum ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.component.common.ScaledValue#getOutputMinimum <em>Output Minimum</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Output Minimum</em>'.
     * @see org.eclipse.scada.configuration.component.common.ScaledValue#getOutputMinimum()
     * @see #getScaledValue()
     * @generated
     */
    EAttribute getScaledValue_OutputMinimum ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.component.common.ScaledValue#getOutputMaximum <em>Output Maximum</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Output Maximum</em>'.
     * @see org.eclipse.scada.configuration.component.common.ScaledValue#getOutputMaximum()
     * @see #getScaledValue()
     * @generated
     */
    EAttribute getScaledValue_OutputMaximum ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.component.common.ScaledValue#isValidateRange <em>Validate Range</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Validate Range</em>'.
     * @see org.eclipse.scada.configuration.component.common.ScaledValue#isValidateRange()
     * @see #getScaledValue()
     * @generated
     */
    EAttribute getScaledValue_ValidateRange ();

    /**
     * Returns the meta object for data type '{@link org.eclipse.scada.configuration.component.common.DateFormat <em>Date Format</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for data type '<em>Date Format</em>'.
     * @see org.eclipse.scada.configuration.component.common.DateFormat
     * @model instanceClass="org.eclipse.scada.configuration.component.common.DateFormat"
     * @generated
     */
    EDataType getDateFormat ();

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
         * The meta object literal for the '{@link org.eclipse.scada.configuration.component.common.impl.HeartbeatGeneratorImpl <em>Heartbeat Generator</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.component.common.impl.HeartbeatGeneratorImpl
         * @see org.eclipse.scada.configuration.component.common.impl.CommonPackageImpl#getHeartbeatGenerator()
         * @generated
         */
        EClass HEARTBEAT_GENERATOR = eINSTANCE.getHeartbeatGenerator ();

        /**
         * The meta object literal for the '<em><b>Period</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute HEARTBEAT_GENERATOR__PERIOD = eINSTANCE.getHeartbeatGenerator_Period ();

        /**
         * The meta object literal for the '<em><b>Target Item</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference HEARTBEAT_GENERATOR__TARGET_ITEM = eINSTANCE.getHeartbeatGenerator_TargetItem ();

        /**
         * The meta object literal for the '<em><b>Active Input</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference HEARTBEAT_GENERATOR__ACTIVE_INPUT = eINSTANCE.getHeartbeatGenerator_ActiveInput ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.component.common.impl.ToggleHeartbeatGeneratorImpl <em>Toggle Heartbeat Generator</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.component.common.impl.ToggleHeartbeatGeneratorImpl
         * @see org.eclipse.scada.configuration.component.common.impl.CommonPackageImpl#getToggleHeartbeatGenerator()
         * @generated
         */
        EClass TOGGLE_HEARTBEAT_GENERATOR = eINSTANCE.getToggleHeartbeatGenerator ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.component.common.impl.HeartbeatDetectorImpl <em>Heartbeat Detector</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.component.common.impl.HeartbeatDetectorImpl
         * @see org.eclipse.scada.configuration.component.common.impl.CommonPackageImpl#getHeartbeatDetector()
         * @generated
         */
        EClass HEARTBEAT_DETECTOR = eINSTANCE.getHeartbeatDetector ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.component.common.impl.ChangeHeartbeatDetectorImpl <em>Change Heartbeat Detector</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.component.common.impl.ChangeHeartbeatDetectorImpl
         * @see org.eclipse.scada.configuration.component.common.impl.CommonPackageImpl#getChangeHeartbeatDetector()
         * @generated
         */
        EClass CHANGE_HEARTBEAT_DETECTOR = eINSTANCE.getChangeHeartbeatDetector ();

        /**
         * The meta object literal for the '<em><b>Timeout</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute CHANGE_HEARTBEAT_DETECTOR__TIMEOUT = eINSTANCE.getChangeHeartbeatDetector_Timeout ();

        /**
         * The meta object literal for the '<em><b>Check Period</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute CHANGE_HEARTBEAT_DETECTOR__CHECK_PERIOD = eINSTANCE.getChangeHeartbeatDetector_CheckPeriod ();

        /**
         * The meta object literal for the '<em><b>Source Item</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference CHANGE_HEARTBEAT_DETECTOR__SOURCE_ITEM = eINSTANCE.getChangeHeartbeatDetector_SourceItem ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.component.common.impl.TimerActionImpl <em>Timer Action</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.component.common.impl.TimerActionImpl
         * @see org.eclipse.scada.configuration.component.common.impl.CommonPackageImpl#getTimerAction()
         * @generated
         */
        EClass TIMER_ACTION = eINSTANCE.getTimerAction ();

        /**
         * The meta object literal for the '<em><b>Period</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute TIMER_ACTION__PERIOD = eINSTANCE.getTimerAction_Period ();

        /**
         * The meta object literal for the '<em><b>Target Item</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference TIMER_ACTION__TARGET_ITEM = eINSTANCE.getTimerAction_TargetItem ();

        /**
         * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute TIMER_ACTION__VALUE = eINSTANCE.getTimerAction_Value ();

        /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute TIMER_ACTION__NAME = eINSTANCE.getTimerAction_Name ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.component.common.impl.CurrentTimeComponentImpl <em>Current Time Component</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.component.common.impl.CurrentTimeComponentImpl
         * @see org.eclipse.scada.configuration.component.common.impl.CommonPackageImpl#getCurrentTimeComponent()
         * @generated
         */
        EClass CURRENT_TIME_COMPONENT = eINSTANCE.getCurrentTimeComponent ();

        /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute CURRENT_TIME_COMPONENT__NAME = eINSTANCE.getCurrentTimeComponent_Name ();

        /**
         * The meta object literal for the '<em><b>Update Period</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute CURRENT_TIME_COMPONENT__UPDATE_PERIOD = eINSTANCE.getCurrentTimeComponent_UpdatePeriod ();

        /**
         * The meta object literal for the '<em><b>Date Format</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute CURRENT_TIME_COMPONENT__DATE_FORMAT = eINSTANCE.getCurrentTimeComponent_DateFormat ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.component.common.impl.ScaledValueImpl <em>Scaled Value</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.component.common.impl.ScaledValueImpl
         * @see org.eclipse.scada.configuration.component.common.impl.CommonPackageImpl#getScaledValue()
         * @generated
         */
        EClass SCALED_VALUE = eINSTANCE.getScaledValue ();

        /**
         * The meta object literal for the '<em><b>Source Item</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference SCALED_VALUE__SOURCE_ITEM = eINSTANCE.getScaledValue_SourceItem ();

        /**
         * The meta object literal for the '<em><b>Input Minimum</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SCALED_VALUE__INPUT_MINIMUM = eINSTANCE.getScaledValue_InputMinimum ();

        /**
         * The meta object literal for the '<em><b>Input Maximum</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SCALED_VALUE__INPUT_MAXIMUM = eINSTANCE.getScaledValue_InputMaximum ();

        /**
         * The meta object literal for the '<em><b>Output Minimum</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SCALED_VALUE__OUTPUT_MINIMUM = eINSTANCE.getScaledValue_OutputMinimum ();

        /**
         * The meta object literal for the '<em><b>Output Maximum</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SCALED_VALUE__OUTPUT_MAXIMUM = eINSTANCE.getScaledValue_OutputMaximum ();

        /**
         * The meta object literal for the '<em><b>Validate Range</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SCALED_VALUE__VALIDATE_RANGE = eINSTANCE.getScaledValue_ValidateRange ();

        /**
         * The meta object literal for the '<em>Date Format</em>' data type.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.component.common.DateFormat
         * @see org.eclipse.scada.configuration.component.common.impl.CommonPackageImpl#getDateFormat()
         * @generated
         */
        EDataType DATE_FORMAT = eINSTANCE.getDateFormat ();

    }

} //CommonPackage
