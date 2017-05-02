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

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Execute</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.recipe.Execute#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.recipe.Execute#getTask <em>Task</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.recipe.Execute#getMapInput <em>Map Input</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.recipe.Execute#getInputValue <em>Input Value</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.recipe.Execute#getOutput <em>Output</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.recipe.Execute#getInputReference <em>Input Reference</em>}</li>
 * </ul>
 *
 * @see org.eclipse.scada.configuration.recipe.RecipePackage#getExecute()
 * @model
 * @generated
 */
public interface Execute extends EObject
{
    /**
     * Returns the value of the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Name</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Name</em>' attribute.
     * @see #setName(String)
     * @see org.eclipse.scada.configuration.recipe.RecipePackage#getExecute_Name()
     * @model required="true"
     * @generated
     */
    String getName ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.recipe.Execute#getName <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
    void setName ( String value );

    /**
     * Returns the value of the '<em><b>Task</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link org.eclipse.scada.configuration.recipe.Task#getExecute <em>Execute</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Task</em>' container reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Task</em>' container reference.
     * @see #setTask(Task)
     * @see org.eclipse.scada.configuration.recipe.RecipePackage#getExecute_Task()
     * @see org.eclipse.scada.configuration.recipe.Task#getExecute
     * @model opposite="execute" required="true" transient="false"
     * @generated
     */
    Task getTask ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.recipe.Execute#getTask <em>Task</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Task</em>' container reference.
     * @see #getTask()
     * @generated
     */
    void setTask ( Task value );

    /**
     * Returns the value of the '<em><b>Map Input</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.scada.configuration.recipe.MapInput}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Map Input</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Map Input</em>' containment reference list.
     * @see org.eclipse.scada.configuration.recipe.RecipePackage#getExecute_MapInput()
     * @model containment="true" resolveProxies="true"
     * @generated
     */
    EList<MapInput> getMapInput ();

    /**
     * Returns the value of the '<em><b>Input Value</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.scada.configuration.recipe.InputValue}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Input Value</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Input Value</em>' containment reference list.
     * @see org.eclipse.scada.configuration.recipe.RecipePackage#getExecute_InputValue()
     * @model containment="true" resolveProxies="true"
     * @generated
     */
    EList<InputValue> getInputValue ();

    /**
     * Returns the value of the '<em><b>Output</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.scada.configuration.recipe.CaptureOutput}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Output</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Output</em>' containment reference list.
     * @see org.eclipse.scada.configuration.recipe.RecipePackage#getExecute_Output()
     * @model containment="true" resolveProxies="true"
     * @generated
     */
    EList<CaptureOutput> getOutput ();

    /**
     * Returns the value of the '<em><b>Input Reference</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.scada.configuration.recipe.InputReference}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Input Reference</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Input Reference</em>' containment reference list.
     * @see org.eclipse.scada.configuration.recipe.RecipePackage#getExecute_InputReference()
     * @model containment="true" resolveProxies="true"
     * @generated
     */
    EList<InputReference> getInputReference ();

} // Execute
