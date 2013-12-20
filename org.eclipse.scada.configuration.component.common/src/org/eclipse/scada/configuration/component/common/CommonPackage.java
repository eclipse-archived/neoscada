/**
 * Copyright (c) 2013 IBH SYSTEMS GmbH.
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
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.scada.configuration.component.ComponentPackage;

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
     * The number of structural features of the '<em>Heartbeat Generator</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HEARTBEAT_GENERATOR_FEATURE_COUNT = ComponentPackage.MASTER_COMPONENT_FEATURE_COUNT + 2;

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
     * The number of structural features of the '<em>Timer Action</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TIMER_ACTION_FEATURE_COUNT = ComponentPackage.MASTER_COMPONENT_FEATURE_COUNT + 3;

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

    }

} //CommonPackage
