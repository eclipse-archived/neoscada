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
package org.eclipse.scada.configuration.item;

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
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.scada.configuration.item.ItemFactory
 * @model kind="package"
 * @generated
 */
public interface ItemPackage extends EPackage
{
    /**
     * The package name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNAME = "item"; //$NON-NLS-1$

    /**
     * The package namespace URI.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_URI = "http://eclipse.org/SCADA/Configuration/Item"; //$NON-NLS-1$

    /**
     * The package namespace name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_PREFIX = "item"; //$NON-NLS-1$

    /**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    ItemPackage eINSTANCE = org.eclipse.scada.configuration.item.impl.ItemPackageImpl.init ();

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.item.CustomizationPipeline <em>Customization Pipeline</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.item.CustomizationPipeline
     * @see org.eclipse.scada.configuration.item.impl.ItemPackageImpl#getCustomizationPipeline()
     * @generated
     */
    int CUSTOMIZATION_PIPELINE = 0;

    /**
     * The number of structural features of the '<em>Customization Pipeline</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CUSTOMIZATION_PIPELINE_FEATURE_COUNT = 0;

    /**
     * The operation id for the '<em>Customize</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CUSTOMIZATION_PIPELINE___CUSTOMIZE__CUSTOMIZATIONREQUEST = 0;

    /**
     * The number of operations of the '<em>Customization Pipeline</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CUSTOMIZATION_PIPELINE_OPERATION_COUNT = 1;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.item.impl.ScriptCustomizationPipelineImpl <em>Script Customization Pipeline</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.item.impl.ScriptCustomizationPipelineImpl
     * @see org.eclipse.scada.configuration.item.impl.ItemPackageImpl#getScriptCustomizationPipeline()
     * @generated
     */
    int SCRIPT_CUSTOMIZATION_PIPELINE = 1;

    /**
     * The feature id for the '<em><b>Code</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCRIPT_CUSTOMIZATION_PIPELINE__CODE = CUSTOMIZATION_PIPELINE_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Script Customization Pipeline</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCRIPT_CUSTOMIZATION_PIPELINE_FEATURE_COUNT = CUSTOMIZATION_PIPELINE_FEATURE_COUNT + 1;

    /**
     * The operation id for the '<em>Customize</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCRIPT_CUSTOMIZATION_PIPELINE___CUSTOMIZE__CUSTOMIZATIONREQUEST = CUSTOMIZATION_PIPELINE___CUSTOMIZE__CUSTOMIZATIONREQUEST;

    /**
     * The operation id for the '<em>Get Script Engine</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCRIPT_CUSTOMIZATION_PIPELINE___GET_SCRIPT_ENGINE = CUSTOMIZATION_PIPELINE_OPERATION_COUNT + 0;

    /**
     * The number of operations of the '<em>Script Customization Pipeline</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCRIPT_CUSTOMIZATION_PIPELINE_OPERATION_COUNT = CUSTOMIZATION_PIPELINE_OPERATION_COUNT + 1;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.item.impl.CompositePipelineImpl <em>Composite Pipeline</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.item.impl.CompositePipelineImpl
     * @see org.eclipse.scada.configuration.item.impl.ItemPackageImpl#getCompositePipeline()
     * @generated
     */
    int COMPOSITE_PIPELINE = 2;

    /**
     * The feature id for the '<em><b>Steps</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COMPOSITE_PIPELINE__STEPS = CUSTOMIZATION_PIPELINE_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COMPOSITE_PIPELINE__ID = CUSTOMIZATION_PIPELINE_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Parent</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COMPOSITE_PIPELINE__PARENT = CUSTOMIZATION_PIPELINE_FEATURE_COUNT + 2;

    /**
     * The number of structural features of the '<em>Composite Pipeline</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COMPOSITE_PIPELINE_FEATURE_COUNT = CUSTOMIZATION_PIPELINE_FEATURE_COUNT + 3;

    /**
     * The operation id for the '<em>Customize</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COMPOSITE_PIPELINE___CUSTOMIZE__CUSTOMIZATIONREQUEST = CUSTOMIZATION_PIPELINE_OPERATION_COUNT + 0;

    /**
     * The number of operations of the '<em>Composite Pipeline</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COMPOSITE_PIPELINE_OPERATION_COUNT = CUSTOMIZATION_PIPELINE_OPERATION_COUNT + 1;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.item.impl.StepImpl <em>Step</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.item.impl.StepImpl
     * @see org.eclipse.scada.configuration.item.impl.ItemPackageImpl#getStep()
     * @generated
     */
    int STEP = 4;

    /**
     * The feature id for the '<em><b>Containing Pipeline</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int STEP__CONTAINING_PIPELINE = 0;

    /**
     * The number of structural features of the '<em>Step</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int STEP_FEATURE_COUNT = 1;

    /**
     * The operation id for the '<em>Execute</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int STEP___EXECUTE__CUSTOMIZATIONREQUEST = 0;

    /**
     * The number of operations of the '<em>Step</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int STEP_OPERATION_COUNT = 1;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.item.impl.CallImpl <em>Call</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.item.impl.CallImpl
     * @see org.eclipse.scada.configuration.item.impl.ItemPackageImpl#getCall()
     * @generated
     */
    int CALL = 3;

    /**
     * The feature id for the '<em><b>Containing Pipeline</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CALL__CONTAINING_PIPELINE = STEP__CONTAINING_PIPELINE;

    /**
     * The feature id for the '<em><b>Pipeline</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CALL__PIPELINE = STEP_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Call</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CALL_FEATURE_COUNT = STEP_FEATURE_COUNT + 1;

    /**
     * The operation id for the '<em>Execute</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CALL___EXECUTE__CUSTOMIZATIONREQUEST = STEP_OPERATION_COUNT + 0;

    /**
     * The number of operations of the '<em>Call</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CALL_OPERATION_COUNT = STEP_OPERATION_COUNT + 1;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.item.impl.CallSuperImpl <em>Call Super</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.item.impl.CallSuperImpl
     * @see org.eclipse.scada.configuration.item.impl.ItemPackageImpl#getCallSuper()
     * @generated
     */
    int CALL_SUPER = 5;

    /**
     * The feature id for the '<em><b>Containing Pipeline</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CALL_SUPER__CONTAINING_PIPELINE = STEP__CONTAINING_PIPELINE;

    /**
     * The number of structural features of the '<em>Call Super</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CALL_SUPER_FEATURE_COUNT = STEP_FEATURE_COUNT + 0;

    /**
     * The operation id for the '<em>Execute</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CALL_SUPER___EXECUTE__CUSTOMIZATIONREQUEST = STEP_OPERATION_COUNT + 0;

    /**
     * The number of operations of the '<em>Call Super</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CALL_SUPER_OPERATION_COUNT = STEP_OPERATION_COUNT + 1;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.item.Selector <em>Selector</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.item.Selector
     * @see org.eclipse.scada.configuration.item.impl.ItemPackageImpl#getSelector()
     * @generated
     */
    int SELECTOR = 6;

    /**
     * The number of structural features of the '<em>Selector</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SELECTOR_FEATURE_COUNT = 0;

    /**
     * The operation id for the '<em>Selected</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SELECTOR___SELECTED__CUSTOMIZATIONREQUEST = 0;

    /**
     * The number of operations of the '<em>Selector</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SELECTOR_OPERATION_COUNT = 1;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.item.impl.ScriptSelectorImpl <em>Script Selector</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.item.impl.ScriptSelectorImpl
     * @see org.eclipse.scada.configuration.item.impl.ItemPackageImpl#getScriptSelector()
     * @generated
     */
    int SCRIPT_SELECTOR = 7;

    /**
     * The feature id for the '<em><b>Code</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCRIPT_SELECTOR__CODE = SELECTOR_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Script Selector</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCRIPT_SELECTOR_FEATURE_COUNT = SELECTOR_FEATURE_COUNT + 1;

    /**
     * The operation id for the '<em>Selected</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCRIPT_SELECTOR___SELECTED__CUSTOMIZATIONREQUEST = SELECTOR___SELECTED__CUSTOMIZATIONREQUEST;

    /**
     * The operation id for the '<em>Get Script Engine</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCRIPT_SELECTOR___GET_SCRIPT_ENGINE = SELECTOR_OPERATION_COUNT + 0;

    /**
     * The number of operations of the '<em>Script Selector</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCRIPT_SELECTOR_OPERATION_COUNT = SELECTOR_OPERATION_COUNT + 1;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.item.impl.JavaScriptCustomizationPipelineImpl <em>Java Script Customization Pipeline</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.item.impl.JavaScriptCustomizationPipelineImpl
     * @see org.eclipse.scada.configuration.item.impl.ItemPackageImpl#getJavaScriptCustomizationPipeline()
     * @generated
     */
    int JAVA_SCRIPT_CUSTOMIZATION_PIPELINE = 8;

    /**
     * The feature id for the '<em><b>Code</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int JAVA_SCRIPT_CUSTOMIZATION_PIPELINE__CODE = SCRIPT_CUSTOMIZATION_PIPELINE__CODE;

    /**
     * The number of structural features of the '<em>Java Script Customization Pipeline</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int JAVA_SCRIPT_CUSTOMIZATION_PIPELINE_FEATURE_COUNT = SCRIPT_CUSTOMIZATION_PIPELINE_FEATURE_COUNT + 0;

    /**
     * The operation id for the '<em>Customize</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int JAVA_SCRIPT_CUSTOMIZATION_PIPELINE___CUSTOMIZE__CUSTOMIZATIONREQUEST = SCRIPT_CUSTOMIZATION_PIPELINE___CUSTOMIZE__CUSTOMIZATIONREQUEST;

    /**
     * The operation id for the '<em>Get Script Engine</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int JAVA_SCRIPT_CUSTOMIZATION_PIPELINE___GET_SCRIPT_ENGINE = SCRIPT_CUSTOMIZATION_PIPELINE_OPERATION_COUNT + 0;

    /**
     * The number of operations of the '<em>Java Script Customization Pipeline</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int JAVA_SCRIPT_CUSTOMIZATION_PIPELINE_OPERATION_COUNT = SCRIPT_CUSTOMIZATION_PIPELINE_OPERATION_COUNT + 1;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.item.impl.CustomScriptCustomizationPipelineImpl <em>Custom Script Customization Pipeline</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.item.impl.CustomScriptCustomizationPipelineImpl
     * @see org.eclipse.scada.configuration.item.impl.ItemPackageImpl#getCustomScriptCustomizationPipeline()
     * @generated
     */
    int CUSTOM_SCRIPT_CUSTOMIZATION_PIPELINE = 9;

    /**
     * The feature id for the '<em><b>Code</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CUSTOM_SCRIPT_CUSTOMIZATION_PIPELINE__CODE = SCRIPT_CUSTOMIZATION_PIPELINE__CODE;

    /**
     * The feature id for the '<em><b>Script Engine</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CUSTOM_SCRIPT_CUSTOMIZATION_PIPELINE__SCRIPT_ENGINE = SCRIPT_CUSTOMIZATION_PIPELINE_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Custom Script Customization Pipeline</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CUSTOM_SCRIPT_CUSTOMIZATION_PIPELINE_FEATURE_COUNT = SCRIPT_CUSTOMIZATION_PIPELINE_FEATURE_COUNT + 1;

    /**
     * The operation id for the '<em>Customize</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CUSTOM_SCRIPT_CUSTOMIZATION_PIPELINE___CUSTOMIZE__CUSTOMIZATIONREQUEST = SCRIPT_CUSTOMIZATION_PIPELINE___CUSTOMIZE__CUSTOMIZATIONREQUEST;

    /**
     * The operation id for the '<em>Get Script Engine</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CUSTOM_SCRIPT_CUSTOMIZATION_PIPELINE___GET_SCRIPT_ENGINE = SCRIPT_CUSTOMIZATION_PIPELINE___GET_SCRIPT_ENGINE;

    /**
     * The number of operations of the '<em>Custom Script Customization Pipeline</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CUSTOM_SCRIPT_CUSTOMIZATION_PIPELINE_OPERATION_COUNT = SCRIPT_CUSTOMIZATION_PIPELINE_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.item.impl.JavaScriptSelectorImpl <em>Java Script Selector</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.item.impl.JavaScriptSelectorImpl
     * @see org.eclipse.scada.configuration.item.impl.ItemPackageImpl#getJavaScriptSelector()
     * @generated
     */
    int JAVA_SCRIPT_SELECTOR = 10;

    /**
     * The feature id for the '<em><b>Code</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int JAVA_SCRIPT_SELECTOR__CODE = SCRIPT_SELECTOR__CODE;

    /**
     * The number of structural features of the '<em>Java Script Selector</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int JAVA_SCRIPT_SELECTOR_FEATURE_COUNT = SCRIPT_SELECTOR_FEATURE_COUNT + 0;

    /**
     * The operation id for the '<em>Selected</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int JAVA_SCRIPT_SELECTOR___SELECTED__CUSTOMIZATIONREQUEST = SCRIPT_SELECTOR___SELECTED__CUSTOMIZATIONREQUEST;

    /**
     * The operation id for the '<em>Get Script Engine</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int JAVA_SCRIPT_SELECTOR___GET_SCRIPT_ENGINE = SCRIPT_SELECTOR_OPERATION_COUNT + 0;

    /**
     * The number of operations of the '<em>Java Script Selector</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int JAVA_SCRIPT_SELECTOR_OPERATION_COUNT = SCRIPT_SELECTOR_OPERATION_COUNT + 1;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.item.impl.CustomScriptSelectorImpl <em>Custom Script Selector</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.item.impl.CustomScriptSelectorImpl
     * @see org.eclipse.scada.configuration.item.impl.ItemPackageImpl#getCustomScriptSelector()
     * @generated
     */
    int CUSTOM_SCRIPT_SELECTOR = 11;

    /**
     * The feature id for the '<em><b>Code</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CUSTOM_SCRIPT_SELECTOR__CODE = SCRIPT_SELECTOR__CODE;

    /**
     * The feature id for the '<em><b>Script Engine</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CUSTOM_SCRIPT_SELECTOR__SCRIPT_ENGINE = SCRIPT_SELECTOR_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Custom Script Selector</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CUSTOM_SCRIPT_SELECTOR_FEATURE_COUNT = SCRIPT_SELECTOR_FEATURE_COUNT + 1;

    /**
     * The operation id for the '<em>Selected</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CUSTOM_SCRIPT_SELECTOR___SELECTED__CUSTOMIZATIONREQUEST = SCRIPT_SELECTOR___SELECTED__CUSTOMIZATIONREQUEST;

    /**
     * The operation id for the '<em>Get Script Engine</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CUSTOM_SCRIPT_SELECTOR___GET_SCRIPT_ENGINE = SCRIPT_SELECTOR___GET_SCRIPT_ENGINE;

    /**
     * The number of operations of the '<em>Custom Script Selector</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CUSTOM_SCRIPT_SELECTOR_OPERATION_COUNT = SCRIPT_SELECTOR_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '<em>Customization Request</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.item.CustomizationRequest
     * @see org.eclipse.scada.configuration.item.impl.ItemPackageImpl#getCustomizationRequest()
     * @generated
     */
    int CUSTOMIZATION_REQUEST = 12;

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.item.CustomizationPipeline <em>Customization Pipeline</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Customization Pipeline</em>'.
     * @see org.eclipse.scada.configuration.item.CustomizationPipeline
     * @generated
     */
    EClass getCustomizationPipeline ();

    /**
     * Returns the meta object for the '{@link org.eclipse.scada.configuration.item.CustomizationPipeline#customize(org.eclipse.scada.configuration.item.CustomizationRequest) <em>Customize</em>}' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the '<em>Customize</em>' operation.
     * @see org.eclipse.scada.configuration.item.CustomizationPipeline#customize(org.eclipse.scada.configuration.item.CustomizationRequest)
     * @generated
     */
    EOperation getCustomizationPipeline__Customize__CustomizationRequest ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.item.ScriptCustomizationPipeline <em>Script Customization Pipeline</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Script Customization Pipeline</em>'.
     * @see org.eclipse.scada.configuration.item.ScriptCustomizationPipeline
     * @generated
     */
    EClass getScriptCustomizationPipeline ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.item.ScriptCustomizationPipeline#getCode <em>Code</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Code</em>'.
     * @see org.eclipse.scada.configuration.item.ScriptCustomizationPipeline#getCode()
     * @see #getScriptCustomizationPipeline()
     * @generated
     */
    EAttribute getScriptCustomizationPipeline_Code ();

    /**
     * Returns the meta object for the '{@link org.eclipse.scada.configuration.item.ScriptCustomizationPipeline#getScriptEngine() <em>Get Script Engine</em>}' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the '<em>Get Script Engine</em>' operation.
     * @see org.eclipse.scada.configuration.item.ScriptCustomizationPipeline#getScriptEngine()
     * @generated
     */
    EOperation getScriptCustomizationPipeline__GetScriptEngine ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.item.CompositePipeline <em>Composite Pipeline</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Composite Pipeline</em>'.
     * @see org.eclipse.scada.configuration.item.CompositePipeline
     * @generated
     */
    EClass getCompositePipeline ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.configuration.item.CompositePipeline#getSteps <em>Steps</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Steps</em>'.
     * @see org.eclipse.scada.configuration.item.CompositePipeline#getSteps()
     * @see #getCompositePipeline()
     * @generated
     */
    EReference getCompositePipeline_Steps ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.item.CompositePipeline#getId <em>Id</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Id</em>'.
     * @see org.eclipse.scada.configuration.item.CompositePipeline#getId()
     * @see #getCompositePipeline()
     * @generated
     */
    EAttribute getCompositePipeline_Id ();

    /**
     * Returns the meta object for the reference '{@link org.eclipse.scada.configuration.item.CompositePipeline#getParent <em>Parent</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Parent</em>'.
     * @see org.eclipse.scada.configuration.item.CompositePipeline#getParent()
     * @see #getCompositePipeline()
     * @generated
     */
    EReference getCompositePipeline_Parent ();

    /**
     * Returns the meta object for the '{@link org.eclipse.scada.configuration.item.CompositePipeline#customize(org.eclipse.scada.configuration.item.CustomizationRequest) <em>Customize</em>}' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the '<em>Customize</em>' operation.
     * @see org.eclipse.scada.configuration.item.CompositePipeline#customize(org.eclipse.scada.configuration.item.CustomizationRequest)
     * @generated
     */
    EOperation getCompositePipeline__Customize__CustomizationRequest ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.item.Call <em>Call</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Call</em>'.
     * @see org.eclipse.scada.configuration.item.Call
     * @generated
     */
    EClass getCall ();

    /**
     * Returns the meta object for the reference '{@link org.eclipse.scada.configuration.item.Call#getPipeline <em>Pipeline</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Pipeline</em>'.
     * @see org.eclipse.scada.configuration.item.Call#getPipeline()
     * @see #getCall()
     * @generated
     */
    EReference getCall_Pipeline ();

    /**
     * Returns the meta object for the '{@link org.eclipse.scada.configuration.item.Call#execute(org.eclipse.scada.configuration.item.CustomizationRequest) <em>Execute</em>}' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the '<em>Execute</em>' operation.
     * @see org.eclipse.scada.configuration.item.Call#execute(org.eclipse.scada.configuration.item.CustomizationRequest)
     * @generated
     */
    EOperation getCall__Execute__CustomizationRequest ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.item.Step <em>Step</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Step</em>'.
     * @see org.eclipse.scada.configuration.item.Step
     * @generated
     */
    EClass getStep ();

    /**
     * Returns the meta object for the container reference '{@link org.eclipse.scada.configuration.item.Step#getContainingPipeline <em>Containing Pipeline</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Containing Pipeline</em>'.
     * @see org.eclipse.scada.configuration.item.Step#getContainingPipeline()
     * @see #getStep()
     * @generated
     */
    EReference getStep_ContainingPipeline ();

    /**
     * Returns the meta object for the '{@link org.eclipse.scada.configuration.item.Step#execute(org.eclipse.scada.configuration.item.CustomizationRequest) <em>Execute</em>}' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the '<em>Execute</em>' operation.
     * @see org.eclipse.scada.configuration.item.Step#execute(org.eclipse.scada.configuration.item.CustomizationRequest)
     * @generated
     */
    EOperation getStep__Execute__CustomizationRequest ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.item.CallSuper <em>Call Super</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Call Super</em>'.
     * @see org.eclipse.scada.configuration.item.CallSuper
     * @generated
     */
    EClass getCallSuper ();

    /**
     * Returns the meta object for the '{@link org.eclipse.scada.configuration.item.CallSuper#execute(org.eclipse.scada.configuration.item.CustomizationRequest) <em>Execute</em>}' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the '<em>Execute</em>' operation.
     * @see org.eclipse.scada.configuration.item.CallSuper#execute(org.eclipse.scada.configuration.item.CustomizationRequest)
     * @generated
     */
    EOperation getCallSuper__Execute__CustomizationRequest ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.item.Selector <em>Selector</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Selector</em>'.
     * @see org.eclipse.scada.configuration.item.Selector
     * @generated
     */
    EClass getSelector ();

    /**
     * Returns the meta object for the '{@link org.eclipse.scada.configuration.item.Selector#selected(org.eclipse.scada.configuration.item.CustomizationRequest) <em>Selected</em>}' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the '<em>Selected</em>' operation.
     * @see org.eclipse.scada.configuration.item.Selector#selected(org.eclipse.scada.configuration.item.CustomizationRequest)
     * @generated
     */
    EOperation getSelector__Selected__CustomizationRequest ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.item.ScriptSelector <em>Script Selector</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Script Selector</em>'.
     * @see org.eclipse.scada.configuration.item.ScriptSelector
     * @generated
     */
    EClass getScriptSelector ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.item.ScriptSelector#getCode <em>Code</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Code</em>'.
     * @see org.eclipse.scada.configuration.item.ScriptSelector#getCode()
     * @see #getScriptSelector()
     * @generated
     */
    EAttribute getScriptSelector_Code ();

    /**
     * Returns the meta object for the '{@link org.eclipse.scada.configuration.item.ScriptSelector#getScriptEngine() <em>Get Script Engine</em>}' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the '<em>Get Script Engine</em>' operation.
     * @see org.eclipse.scada.configuration.item.ScriptSelector#getScriptEngine()
     * @generated
     */
    EOperation getScriptSelector__GetScriptEngine ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.item.JavaScriptCustomizationPipeline <em>Java Script Customization Pipeline</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Java Script Customization Pipeline</em>'.
     * @see org.eclipse.scada.configuration.item.JavaScriptCustomizationPipeline
     * @generated
     */
    EClass getJavaScriptCustomizationPipeline ();

    /**
     * Returns the meta object for the '{@link org.eclipse.scada.configuration.item.JavaScriptCustomizationPipeline#getScriptEngine() <em>Get Script Engine</em>}' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the '<em>Get Script Engine</em>' operation.
     * @see org.eclipse.scada.configuration.item.JavaScriptCustomizationPipeline#getScriptEngine()
     * @generated
     */
    EOperation getJavaScriptCustomizationPipeline__GetScriptEngine ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.item.CustomScriptCustomizationPipeline <em>Custom Script Customization Pipeline</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Custom Script Customization Pipeline</em>'.
     * @see org.eclipse.scada.configuration.item.CustomScriptCustomizationPipeline
     * @generated
     */
    EClass getCustomScriptCustomizationPipeline ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.item.CustomScriptCustomizationPipeline#getScriptEngine <em>Script Engine</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Script Engine</em>'.
     * @see org.eclipse.scada.configuration.item.CustomScriptCustomizationPipeline#getScriptEngine()
     * @see #getCustomScriptCustomizationPipeline()
     * @generated
     */
    EAttribute getCustomScriptCustomizationPipeline_ScriptEngine ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.item.JavaScriptSelector <em>Java Script Selector</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Java Script Selector</em>'.
     * @see org.eclipse.scada.configuration.item.JavaScriptSelector
     * @generated
     */
    EClass getJavaScriptSelector ();

    /**
     * Returns the meta object for the '{@link org.eclipse.scada.configuration.item.JavaScriptSelector#getScriptEngine() <em>Get Script Engine</em>}' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the '<em>Get Script Engine</em>' operation.
     * @see org.eclipse.scada.configuration.item.JavaScriptSelector#getScriptEngine()
     * @generated
     */
    EOperation getJavaScriptSelector__GetScriptEngine ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.item.CustomScriptSelector <em>Custom Script Selector</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Custom Script Selector</em>'.
     * @see org.eclipse.scada.configuration.item.CustomScriptSelector
     * @generated
     */
    EClass getCustomScriptSelector ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.item.CustomScriptSelector#getScriptEngine <em>Script Engine</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Script Engine</em>'.
     * @see org.eclipse.scada.configuration.item.CustomScriptSelector#getScriptEngine()
     * @see #getCustomScriptSelector()
     * @generated
     */
    EAttribute getCustomScriptSelector_ScriptEngine ();

    /**
     * Returns the meta object for data type '{@link org.eclipse.scada.configuration.item.CustomizationRequest <em>Customization Request</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for data type '<em>Customization Request</em>'.
     * @see org.eclipse.scada.configuration.item.CustomizationRequest
     * @model instanceClass="org.eclipse.scada.configuration.item.CustomizationRequest" serializeable="false"
     * @generated
     */
    EDataType getCustomizationRequest ();

    /**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
    ItemFactory getItemFactory ();

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
         * The meta object literal for the '{@link org.eclipse.scada.configuration.item.CustomizationPipeline <em>Customization Pipeline</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.item.CustomizationPipeline
         * @see org.eclipse.scada.configuration.item.impl.ItemPackageImpl#getCustomizationPipeline()
         * @generated
         */
        EClass CUSTOMIZATION_PIPELINE = eINSTANCE.getCustomizationPipeline ();

        /**
         * The meta object literal for the '<em><b>Customize</b></em>' operation.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EOperation CUSTOMIZATION_PIPELINE___CUSTOMIZE__CUSTOMIZATIONREQUEST = eINSTANCE.getCustomizationPipeline__Customize__CustomizationRequest ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.item.impl.ScriptCustomizationPipelineImpl <em>Script Customization Pipeline</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.item.impl.ScriptCustomizationPipelineImpl
         * @see org.eclipse.scada.configuration.item.impl.ItemPackageImpl#getScriptCustomizationPipeline()
         * @generated
         */
        EClass SCRIPT_CUSTOMIZATION_PIPELINE = eINSTANCE.getScriptCustomizationPipeline ();

        /**
         * The meta object literal for the '<em><b>Code</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SCRIPT_CUSTOMIZATION_PIPELINE__CODE = eINSTANCE.getScriptCustomizationPipeline_Code ();

        /**
         * The meta object literal for the '<em><b>Get Script Engine</b></em>' operation.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EOperation SCRIPT_CUSTOMIZATION_PIPELINE___GET_SCRIPT_ENGINE = eINSTANCE.getScriptCustomizationPipeline__GetScriptEngine ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.item.impl.CompositePipelineImpl <em>Composite Pipeline</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.item.impl.CompositePipelineImpl
         * @see org.eclipse.scada.configuration.item.impl.ItemPackageImpl#getCompositePipeline()
         * @generated
         */
        EClass COMPOSITE_PIPELINE = eINSTANCE.getCompositePipeline ();

        /**
         * The meta object literal for the '<em><b>Steps</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference COMPOSITE_PIPELINE__STEPS = eINSTANCE.getCompositePipeline_Steps ();

        /**
         * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute COMPOSITE_PIPELINE__ID = eINSTANCE.getCompositePipeline_Id ();

        /**
         * The meta object literal for the '<em><b>Parent</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference COMPOSITE_PIPELINE__PARENT = eINSTANCE.getCompositePipeline_Parent ();

        /**
         * The meta object literal for the '<em><b>Customize</b></em>' operation.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EOperation COMPOSITE_PIPELINE___CUSTOMIZE__CUSTOMIZATIONREQUEST = eINSTANCE.getCompositePipeline__Customize__CustomizationRequest ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.item.impl.CallImpl <em>Call</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.item.impl.CallImpl
         * @see org.eclipse.scada.configuration.item.impl.ItemPackageImpl#getCall()
         * @generated
         */
        EClass CALL = eINSTANCE.getCall ();

        /**
         * The meta object literal for the '<em><b>Pipeline</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference CALL__PIPELINE = eINSTANCE.getCall_Pipeline ();

        /**
         * The meta object literal for the '<em><b>Execute</b></em>' operation.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EOperation CALL___EXECUTE__CUSTOMIZATIONREQUEST = eINSTANCE.getCall__Execute__CustomizationRequest ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.item.impl.StepImpl <em>Step</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.item.impl.StepImpl
         * @see org.eclipse.scada.configuration.item.impl.ItemPackageImpl#getStep()
         * @generated
         */
        EClass STEP = eINSTANCE.getStep ();

        /**
         * The meta object literal for the '<em><b>Containing Pipeline</b></em>' container reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference STEP__CONTAINING_PIPELINE = eINSTANCE.getStep_ContainingPipeline ();

        /**
         * The meta object literal for the '<em><b>Execute</b></em>' operation.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EOperation STEP___EXECUTE__CUSTOMIZATIONREQUEST = eINSTANCE.getStep__Execute__CustomizationRequest ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.item.impl.CallSuperImpl <em>Call Super</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.item.impl.CallSuperImpl
         * @see org.eclipse.scada.configuration.item.impl.ItemPackageImpl#getCallSuper()
         * @generated
         */
        EClass CALL_SUPER = eINSTANCE.getCallSuper ();

        /**
         * The meta object literal for the '<em><b>Execute</b></em>' operation.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EOperation CALL_SUPER___EXECUTE__CUSTOMIZATIONREQUEST = eINSTANCE.getCallSuper__Execute__CustomizationRequest ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.item.Selector <em>Selector</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.item.Selector
         * @see org.eclipse.scada.configuration.item.impl.ItemPackageImpl#getSelector()
         * @generated
         */
        EClass SELECTOR = eINSTANCE.getSelector ();

        /**
         * The meta object literal for the '<em><b>Selected</b></em>' operation.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EOperation SELECTOR___SELECTED__CUSTOMIZATIONREQUEST = eINSTANCE.getSelector__Selected__CustomizationRequest ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.item.impl.ScriptSelectorImpl <em>Script Selector</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.item.impl.ScriptSelectorImpl
         * @see org.eclipse.scada.configuration.item.impl.ItemPackageImpl#getScriptSelector()
         * @generated
         */
        EClass SCRIPT_SELECTOR = eINSTANCE.getScriptSelector ();

        /**
         * The meta object literal for the '<em><b>Code</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SCRIPT_SELECTOR__CODE = eINSTANCE.getScriptSelector_Code ();

        /**
         * The meta object literal for the '<em><b>Get Script Engine</b></em>' operation.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EOperation SCRIPT_SELECTOR___GET_SCRIPT_ENGINE = eINSTANCE.getScriptSelector__GetScriptEngine ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.item.impl.JavaScriptCustomizationPipelineImpl <em>Java Script Customization Pipeline</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.item.impl.JavaScriptCustomizationPipelineImpl
         * @see org.eclipse.scada.configuration.item.impl.ItemPackageImpl#getJavaScriptCustomizationPipeline()
         * @generated
         */
        EClass JAVA_SCRIPT_CUSTOMIZATION_PIPELINE = eINSTANCE.getJavaScriptCustomizationPipeline ();

        /**
         * The meta object literal for the '<em><b>Get Script Engine</b></em>' operation.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EOperation JAVA_SCRIPT_CUSTOMIZATION_PIPELINE___GET_SCRIPT_ENGINE = eINSTANCE.getJavaScriptCustomizationPipeline__GetScriptEngine ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.item.impl.CustomScriptCustomizationPipelineImpl <em>Custom Script Customization Pipeline</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.item.impl.CustomScriptCustomizationPipelineImpl
         * @see org.eclipse.scada.configuration.item.impl.ItemPackageImpl#getCustomScriptCustomizationPipeline()
         * @generated
         */
        EClass CUSTOM_SCRIPT_CUSTOMIZATION_PIPELINE = eINSTANCE.getCustomScriptCustomizationPipeline ();

        /**
         * The meta object literal for the '<em><b>Script Engine</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute CUSTOM_SCRIPT_CUSTOMIZATION_PIPELINE__SCRIPT_ENGINE = eINSTANCE.getCustomScriptCustomizationPipeline_ScriptEngine ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.item.impl.JavaScriptSelectorImpl <em>Java Script Selector</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.item.impl.JavaScriptSelectorImpl
         * @see org.eclipse.scada.configuration.item.impl.ItemPackageImpl#getJavaScriptSelector()
         * @generated
         */
        EClass JAVA_SCRIPT_SELECTOR = eINSTANCE.getJavaScriptSelector ();

        /**
         * The meta object literal for the '<em><b>Get Script Engine</b></em>' operation.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EOperation JAVA_SCRIPT_SELECTOR___GET_SCRIPT_ENGINE = eINSTANCE.getJavaScriptSelector__GetScriptEngine ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.item.impl.CustomScriptSelectorImpl <em>Custom Script Selector</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.item.impl.CustomScriptSelectorImpl
         * @see org.eclipse.scada.configuration.item.impl.ItemPackageImpl#getCustomScriptSelector()
         * @generated
         */
        EClass CUSTOM_SCRIPT_SELECTOR = eINSTANCE.getCustomScriptSelector ();

        /**
         * The meta object literal for the '<em><b>Script Engine</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute CUSTOM_SCRIPT_SELECTOR__SCRIPT_ENGINE = eINSTANCE.getCustomScriptSelector_ScriptEngine ();

        /**
         * The meta object literal for the '<em>Customization Request</em>' data type.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.item.CustomizationRequest
         * @see org.eclipse.scada.configuration.item.impl.ItemPackageImpl#getCustomizationRequest()
         * @generated
         */
        EDataType CUSTOMIZATION_REQUEST = eINSTANCE.getCustomizationRequest ();

    }

} //ItemPackage
