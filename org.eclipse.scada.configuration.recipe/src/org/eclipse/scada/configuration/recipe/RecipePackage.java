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
package org.eclipse.scada.configuration.recipe;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
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
 * @see org.eclipse.scada.configuration.recipe.RecipeFactory
 * @model kind="package"
 * @generated
 */
public interface RecipePackage extends EPackage
{
    /**
     * The package name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNAME = "recipe"; //$NON-NLS-1$

    /**
     * The package namespace URI.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_URI = "http://eclipse.org/SCADA/Configuration/Recipe"; //$NON-NLS-1$

    /**
     * The package namespace name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_PREFIX = "recipe"; //$NON-NLS-1$

    /**
     * The package content type ID.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eCONTENT_TYPE = "org.eclipse.scada.configuration.recipe"; //$NON-NLS-1$

    /**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    RecipePackage eINSTANCE = org.eclipse.scada.configuration.recipe.impl.RecipePackageImpl.init ();

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.recipe.impl.DefinitionImpl <em>Definition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.recipe.impl.DefinitionImpl
     * @see org.eclipse.scada.configuration.recipe.impl.RecipePackageImpl#getDefinition()
     * @generated
     */
    int DEFINITION = 0;

    /**
     * The feature id for the '<em><b>Task</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DEFINITION__TASK = 0;

    /**
     * The feature id for the '<em><b>Import</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DEFINITION__IMPORT = 1;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DEFINITION__NAME = 2;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DEFINITION__ID = 3;

    /**
     * The number of structural features of the '<em>Definition</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DEFINITION_FEATURE_COUNT = 4;

    /**
     * The number of operations of the '<em>Definition</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DEFINITION_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.recipe.impl.TaskImpl <em>Task</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.recipe.impl.TaskImpl
     * @see org.eclipse.scada.configuration.recipe.impl.RecipePackageImpl#getTask()
     * @generated
     */
    int TASK = 1;

    /**
     * The feature id for the '<em><b>Execute</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TASK__EXECUTE = 0;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TASK__NAME = 1;

    /**
     * The feature id for the '<em><b>Definition</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TASK__DEFINITION = 2;

    /**
     * The feature id for the '<em><b>Order</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TASK__ORDER = 3;

    /**
     * The number of structural features of the '<em>Task</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TASK_FEATURE_COUNT = 4;

    /**
     * The number of operations of the '<em>Task</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TASK_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.recipe.impl.ExecuteImpl <em>Execute</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.recipe.impl.ExecuteImpl
     * @see org.eclipse.scada.configuration.recipe.impl.RecipePackageImpl#getExecute()
     * @generated
     */
    int EXECUTE = 2;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTE__NAME = 0;

    /**
     * The feature id for the '<em><b>Task</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTE__TASK = 1;

    /**
     * The feature id for the '<em><b>Map Input</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTE__MAP_INPUT = 2;

    /**
     * The feature id for the '<em><b>Input Value</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTE__INPUT_VALUE = 3;

    /**
     * The feature id for the '<em><b>Output</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTE__OUTPUT = 4;

    /**
     * The feature id for the '<em><b>Input Reference</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTE__INPUT_REFERENCE = 5;

    /**
     * The number of structural features of the '<em>Execute</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTE_FEATURE_COUNT = 6;

    /**
     * The number of operations of the '<em>Execute</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXECUTE_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.recipe.impl.MapInputImpl <em>Map Input</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.recipe.impl.MapInputImpl
     * @see org.eclipse.scada.configuration.recipe.impl.RecipePackageImpl#getMapInput()
     * @generated
     */
    int MAP_INPUT = 3;

    /**
     * The feature id for the '<em><b>Local Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MAP_INPUT__LOCAL_NAME = 0;

    /**
     * The feature id for the '<em><b>Context Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MAP_INPUT__CONTEXT_NAME = 1;

    /**
     * The number of structural features of the '<em>Map Input</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MAP_INPUT_FEATURE_COUNT = 2;

    /**
     * The number of operations of the '<em>Map Input</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MAP_INPUT_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.recipe.impl.InputValueImpl <em>Input Value</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.recipe.impl.InputValueImpl
     * @see org.eclipse.scada.configuration.recipe.impl.RecipePackageImpl#getInputValue()
     * @generated
     */
    int INPUT_VALUE = 4;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INPUT_VALUE__NAME = 0;

    /**
     * The number of structural features of the '<em>Input Value</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INPUT_VALUE_FEATURE_COUNT = 1;

    /**
     * The operation id for the '<em>Get Value</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INPUT_VALUE___GET_VALUE = 0;

    /**
     * The number of operations of the '<em>Input Value</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INPUT_VALUE_OPERATION_COUNT = 1;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.recipe.impl.StringInputValueImpl <em>String Input Value</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.recipe.impl.StringInputValueImpl
     * @see org.eclipse.scada.configuration.recipe.impl.RecipePackageImpl#getStringInputValue()
     * @generated
     */
    int STRING_INPUT_VALUE = 5;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int STRING_INPUT_VALUE__NAME = INPUT_VALUE__NAME;

    /**
     * The feature id for the '<em><b>Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int STRING_INPUT_VALUE__VALUE = INPUT_VALUE_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>String Input Value</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int STRING_INPUT_VALUE_FEATURE_COUNT = INPUT_VALUE_FEATURE_COUNT + 1;

    /**
     * The operation id for the '<em>Get Value</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int STRING_INPUT_VALUE___GET_VALUE = INPUT_VALUE___GET_VALUE;

    /**
     * The number of operations of the '<em>String Input Value</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int STRING_INPUT_VALUE_OPERATION_COUNT = INPUT_VALUE_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.recipe.impl.CaptureOutputImpl <em>Capture Output</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.recipe.impl.CaptureOutputImpl
     * @see org.eclipse.scada.configuration.recipe.impl.RecipePackageImpl#getCaptureOutput()
     * @generated
     */
    int CAPTURE_OUTPUT = 6;

    /**
     * The feature id for the '<em><b>Local Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CAPTURE_OUTPUT__LOCAL_NAME = 0;

    /**
     * The feature id for the '<em><b>Context Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CAPTURE_OUTPUT__CONTEXT_NAME = 1;

    /**
     * The number of structural features of the '<em>Capture Output</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CAPTURE_OUTPUT_FEATURE_COUNT = 2;

    /**
     * The number of operations of the '<em>Capture Output</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CAPTURE_OUTPUT_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.recipe.impl.InputReferenceImpl <em>Input Reference</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.recipe.impl.InputReferenceImpl
     * @see org.eclipse.scada.configuration.recipe.impl.RecipePackageImpl#getInputReference()
     * @generated
     */
    int INPUT_REFERENCE = 7;

    /**
     * The feature id for the '<em><b>Expression</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INPUT_REFERENCE__EXPRESSION = 0;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INPUT_REFERENCE__NAME = 1;

    /**
     * The number of structural features of the '<em>Input Reference</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INPUT_REFERENCE_FEATURE_COUNT = 2;

    /**
     * The number of operations of the '<em>Input Reference</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INPUT_REFERENCE_OPERATION_COUNT = 0;

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.recipe.Definition <em>Definition</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Definition</em>'.
     * @see org.eclipse.scada.configuration.recipe.Definition
     * @generated
     */
    EClass getDefinition ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.configuration.recipe.Definition#getTask <em>Task</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Task</em>'.
     * @see org.eclipse.scada.configuration.recipe.Definition#getTask()
     * @see #getDefinition()
     * @generated
     */
    EReference getDefinition_Task ();

    /**
     * Returns the meta object for the reference list '{@link org.eclipse.scada.configuration.recipe.Definition#getImport <em>Import</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Import</em>'.
     * @see org.eclipse.scada.configuration.recipe.Definition#getImport()
     * @see #getDefinition()
     * @generated
     */
    EReference getDefinition_Import ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.recipe.Definition#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see org.eclipse.scada.configuration.recipe.Definition#getName()
     * @see #getDefinition()
     * @generated
     */
    EAttribute getDefinition_Name ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.recipe.Definition#getId <em>Id</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Id</em>'.
     * @see org.eclipse.scada.configuration.recipe.Definition#getId()
     * @see #getDefinition()
     * @generated
     */
    EAttribute getDefinition_Id ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.recipe.Task <em>Task</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Task</em>'.
     * @see org.eclipse.scada.configuration.recipe.Task
     * @generated
     */
    EClass getTask ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.configuration.recipe.Task#getExecute <em>Execute</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Execute</em>'.
     * @see org.eclipse.scada.configuration.recipe.Task#getExecute()
     * @see #getTask()
     * @generated
     */
    EReference getTask_Execute ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.recipe.Task#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see org.eclipse.scada.configuration.recipe.Task#getName()
     * @see #getTask()
     * @generated
     */
    EAttribute getTask_Name ();

    /**
     * Returns the meta object for the container reference '{@link org.eclipse.scada.configuration.recipe.Task#getDefinition <em>Definition</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Definition</em>'.
     * @see org.eclipse.scada.configuration.recipe.Task#getDefinition()
     * @see #getTask()
     * @generated
     */
    EReference getTask_Definition ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.recipe.Task#getOrder <em>Order</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Order</em>'.
     * @see org.eclipse.scada.configuration.recipe.Task#getOrder()
     * @see #getTask()
     * @generated
     */
    EAttribute getTask_Order ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.recipe.Execute <em>Execute</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Execute</em>'.
     * @see org.eclipse.scada.configuration.recipe.Execute
     * @generated
     */
    EClass getExecute ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.recipe.Execute#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see org.eclipse.scada.configuration.recipe.Execute#getName()
     * @see #getExecute()
     * @generated
     */
    EAttribute getExecute_Name ();

    /**
     * Returns the meta object for the container reference '{@link org.eclipse.scada.configuration.recipe.Execute#getTask <em>Task</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Task</em>'.
     * @see org.eclipse.scada.configuration.recipe.Execute#getTask()
     * @see #getExecute()
     * @generated
     */
    EReference getExecute_Task ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.configuration.recipe.Execute#getMapInput <em>Map Input</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Map Input</em>'.
     * @see org.eclipse.scada.configuration.recipe.Execute#getMapInput()
     * @see #getExecute()
     * @generated
     */
    EReference getExecute_MapInput ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.configuration.recipe.Execute#getInputValue <em>Input Value</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Input Value</em>'.
     * @see org.eclipse.scada.configuration.recipe.Execute#getInputValue()
     * @see #getExecute()
     * @generated
     */
    EReference getExecute_InputValue ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.configuration.recipe.Execute#getOutput <em>Output</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Output</em>'.
     * @see org.eclipse.scada.configuration.recipe.Execute#getOutput()
     * @see #getExecute()
     * @generated
     */
    EReference getExecute_Output ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.configuration.recipe.Execute#getInputReference <em>Input Reference</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Input Reference</em>'.
     * @see org.eclipse.scada.configuration.recipe.Execute#getInputReference()
     * @see #getExecute()
     * @generated
     */
    EReference getExecute_InputReference ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.recipe.MapInput <em>Map Input</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Map Input</em>'.
     * @see org.eclipse.scada.configuration.recipe.MapInput
     * @generated
     */
    EClass getMapInput ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.recipe.MapInput#getLocalName <em>Local Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Local Name</em>'.
     * @see org.eclipse.scada.configuration.recipe.MapInput#getLocalName()
     * @see #getMapInput()
     * @generated
     */
    EAttribute getMapInput_LocalName ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.recipe.MapInput#getContextName <em>Context Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Context Name</em>'.
     * @see org.eclipse.scada.configuration.recipe.MapInput#getContextName()
     * @see #getMapInput()
     * @generated
     */
    EAttribute getMapInput_ContextName ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.recipe.InputValue <em>Input Value</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Input Value</em>'.
     * @see org.eclipse.scada.configuration.recipe.InputValue
     * @generated
     */
    EClass getInputValue ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.recipe.InputValue#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see org.eclipse.scada.configuration.recipe.InputValue#getName()
     * @see #getInputValue()
     * @generated
     */
    EAttribute getInputValue_Name ();

    /**
     * Returns the meta object for the '{@link org.eclipse.scada.configuration.recipe.InputValue#getValue() <em>Get Value</em>}' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the '<em>Get Value</em>' operation.
     * @see org.eclipse.scada.configuration.recipe.InputValue#getValue()
     * @generated
     */
    EOperation getInputValue__GetValue ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.recipe.StringInputValue <em>String Input Value</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>String Input Value</em>'.
     * @see org.eclipse.scada.configuration.recipe.StringInputValue
     * @generated
     */
    EClass getStringInputValue ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.recipe.StringInputValue#getValue <em>Value</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Value</em>'.
     * @see org.eclipse.scada.configuration.recipe.StringInputValue#getValue()
     * @see #getStringInputValue()
     * @generated
     */
    EAttribute getStringInputValue_Value ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.recipe.CaptureOutput <em>Capture Output</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Capture Output</em>'.
     * @see org.eclipse.scada.configuration.recipe.CaptureOutput
     * @generated
     */
    EClass getCaptureOutput ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.recipe.CaptureOutput#getLocalName <em>Local Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Local Name</em>'.
     * @see org.eclipse.scada.configuration.recipe.CaptureOutput#getLocalName()
     * @see #getCaptureOutput()
     * @generated
     */
    EAttribute getCaptureOutput_LocalName ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.recipe.CaptureOutput#getContextName <em>Context Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Context Name</em>'.
     * @see org.eclipse.scada.configuration.recipe.CaptureOutput#getContextName()
     * @see #getCaptureOutput()
     * @generated
     */
    EAttribute getCaptureOutput_ContextName ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.recipe.InputReference <em>Input Reference</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Input Reference</em>'.
     * @see org.eclipse.scada.configuration.recipe.InputReference
     * @generated
     */
    EClass getInputReference ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.recipe.InputReference#getExpression <em>Expression</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Expression</em>'.
     * @see org.eclipse.scada.configuration.recipe.InputReference#getExpression()
     * @see #getInputReference()
     * @generated
     */
    EAttribute getInputReference_Expression ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.recipe.InputReference#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see org.eclipse.scada.configuration.recipe.InputReference#getName()
     * @see #getInputReference()
     * @generated
     */
    EAttribute getInputReference_Name ();

    /**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
    RecipeFactory getRecipeFactory ();

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
         * The meta object literal for the '{@link org.eclipse.scada.configuration.recipe.impl.DefinitionImpl <em>Definition</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.recipe.impl.DefinitionImpl
         * @see org.eclipse.scada.configuration.recipe.impl.RecipePackageImpl#getDefinition()
         * @generated
         */
        EClass DEFINITION = eINSTANCE.getDefinition ();

        /**
         * The meta object literal for the '<em><b>Task</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference DEFINITION__TASK = eINSTANCE.getDefinition_Task ();

        /**
         * The meta object literal for the '<em><b>Import</b></em>' reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference DEFINITION__IMPORT = eINSTANCE.getDefinition_Import ();

        /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute DEFINITION__NAME = eINSTANCE.getDefinition_Name ();

        /**
         * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute DEFINITION__ID = eINSTANCE.getDefinition_Id ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.recipe.impl.TaskImpl <em>Task</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.recipe.impl.TaskImpl
         * @see org.eclipse.scada.configuration.recipe.impl.RecipePackageImpl#getTask()
         * @generated
         */
        EClass TASK = eINSTANCE.getTask ();

        /**
         * The meta object literal for the '<em><b>Execute</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference TASK__EXECUTE = eINSTANCE.getTask_Execute ();

        /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute TASK__NAME = eINSTANCE.getTask_Name ();

        /**
         * The meta object literal for the '<em><b>Definition</b></em>' container reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference TASK__DEFINITION = eINSTANCE.getTask_Definition ();

        /**
         * The meta object literal for the '<em><b>Order</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute TASK__ORDER = eINSTANCE.getTask_Order ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.recipe.impl.ExecuteImpl <em>Execute</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.recipe.impl.ExecuteImpl
         * @see org.eclipse.scada.configuration.recipe.impl.RecipePackageImpl#getExecute()
         * @generated
         */
        EClass EXECUTE = eINSTANCE.getExecute ();

        /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EXECUTE__NAME = eINSTANCE.getExecute_Name ();

        /**
         * The meta object literal for the '<em><b>Task</b></em>' container reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference EXECUTE__TASK = eINSTANCE.getExecute_Task ();

        /**
         * The meta object literal for the '<em><b>Map Input</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference EXECUTE__MAP_INPUT = eINSTANCE.getExecute_MapInput ();

        /**
         * The meta object literal for the '<em><b>Input Value</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference EXECUTE__INPUT_VALUE = eINSTANCE.getExecute_InputValue ();

        /**
         * The meta object literal for the '<em><b>Output</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference EXECUTE__OUTPUT = eINSTANCE.getExecute_Output ();

        /**
         * The meta object literal for the '<em><b>Input Reference</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference EXECUTE__INPUT_REFERENCE = eINSTANCE.getExecute_InputReference ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.recipe.impl.MapInputImpl <em>Map Input</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.recipe.impl.MapInputImpl
         * @see org.eclipse.scada.configuration.recipe.impl.RecipePackageImpl#getMapInput()
         * @generated
         */
        EClass MAP_INPUT = eINSTANCE.getMapInput ();

        /**
         * The meta object literal for the '<em><b>Local Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute MAP_INPUT__LOCAL_NAME = eINSTANCE.getMapInput_LocalName ();

        /**
         * The meta object literal for the '<em><b>Context Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute MAP_INPUT__CONTEXT_NAME = eINSTANCE.getMapInput_ContextName ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.recipe.impl.InputValueImpl <em>Input Value</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.recipe.impl.InputValueImpl
         * @see org.eclipse.scada.configuration.recipe.impl.RecipePackageImpl#getInputValue()
         * @generated
         */
        EClass INPUT_VALUE = eINSTANCE.getInputValue ();

        /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute INPUT_VALUE__NAME = eINSTANCE.getInputValue_Name ();

        /**
         * The meta object literal for the '<em><b>Get Value</b></em>' operation.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EOperation INPUT_VALUE___GET_VALUE = eINSTANCE.getInputValue__GetValue ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.recipe.impl.StringInputValueImpl <em>String Input Value</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.recipe.impl.StringInputValueImpl
         * @see org.eclipse.scada.configuration.recipe.impl.RecipePackageImpl#getStringInputValue()
         * @generated
         */
        EClass STRING_INPUT_VALUE = eINSTANCE.getStringInputValue ();

        /**
         * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute STRING_INPUT_VALUE__VALUE = eINSTANCE.getStringInputValue_Value ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.recipe.impl.CaptureOutputImpl <em>Capture Output</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.recipe.impl.CaptureOutputImpl
         * @see org.eclipse.scada.configuration.recipe.impl.RecipePackageImpl#getCaptureOutput()
         * @generated
         */
        EClass CAPTURE_OUTPUT = eINSTANCE.getCaptureOutput ();

        /**
         * The meta object literal for the '<em><b>Local Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute CAPTURE_OUTPUT__LOCAL_NAME = eINSTANCE.getCaptureOutput_LocalName ();

        /**
         * The meta object literal for the '<em><b>Context Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute CAPTURE_OUTPUT__CONTEXT_NAME = eINSTANCE.getCaptureOutput_ContextName ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.recipe.impl.InputReferenceImpl <em>Input Reference</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.recipe.impl.InputReferenceImpl
         * @see org.eclipse.scada.configuration.recipe.impl.RecipePackageImpl#getInputReference()
         * @generated
         */
        EClass INPUT_REFERENCE = eINSTANCE.getInputReference ();

        /**
         * The meta object literal for the '<em><b>Expression</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute INPUT_REFERENCE__EXPRESSION = eINSTANCE.getInputReference_Expression ();

        /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute INPUT_REFERENCE__NAME = eINSTANCE.getInputReference_Name ();

    }

} //RecipePackage
