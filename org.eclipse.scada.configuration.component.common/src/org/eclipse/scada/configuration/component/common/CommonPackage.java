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
    int HEARTBEAT_GENERATOR__LEVEL = ComponentPackage.DATA_COMPONENT__LEVEL;

    /**
     * The feature id for the '<em><b>Customization Pipeline</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HEARTBEAT_GENERATOR__CUSTOMIZATION_PIPELINE = ComponentPackage.DATA_COMPONENT__CUSTOMIZATION_PIPELINE;

    /**
     * The feature id for the '<em><b>Archive Selector</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HEARTBEAT_GENERATOR__ARCHIVE_SELECTOR = ComponentPackage.DATA_COMPONENT__ARCHIVE_SELECTOR;

    /**
     * The feature id for the '<em><b>Master On</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HEARTBEAT_GENERATOR__MASTER_ON = ComponentPackage.DATA_COMPONENT__MASTER_ON;

    /**
     * The feature id for the '<em><b>Period</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HEARTBEAT_GENERATOR__PERIOD = ComponentPackage.DATA_COMPONENT_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Target Item</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HEARTBEAT_GENERATOR__TARGET_ITEM = ComponentPackage.DATA_COMPONENT_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Heartbeat Generator</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HEARTBEAT_GENERATOR_FEATURE_COUNT = ComponentPackage.DATA_COMPONENT_FEATURE_COUNT + 2;

    /**
     * The number of operations of the '<em>Heartbeat Generator</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int HEARTBEAT_GENERATOR_OPERATION_COUNT = ComponentPackage.DATA_COMPONENT_OPERATION_COUNT + 0;

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
     * The number of operations of the '<em>Toggle Heartbeat Generator</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TOGGLE_HEARTBEAT_GENERATOR_OPERATION_COUNT = HEARTBEAT_GENERATOR_OPERATION_COUNT + 0;

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

    }

} //CommonPackage
