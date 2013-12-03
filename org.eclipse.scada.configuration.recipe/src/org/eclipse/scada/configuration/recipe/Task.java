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
 * A representation of the model object '<em><b>Task</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.recipe.Task#getExecute <em>Execute</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.recipe.Task#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.recipe.Task#getDefinition <em>Definition</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.recipe.Task#getOrder <em>Order</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.configuration.recipe.RecipePackage#getTask()
 * @model
 * @generated
 */
public interface Task extends EObject
{
    /**
     * Returns the value of the '<em><b>Execute</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.scada.configuration.recipe.Execute}.
     * It is bidirectional and its opposite is '{@link org.eclipse.scada.configuration.recipe.Execute#getTask <em>Task</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Execute</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Execute</em>' containment reference list.
     * @see org.eclipse.scada.configuration.recipe.RecipePackage#getTask_Execute()
     * @see org.eclipse.scada.configuration.recipe.Execute#getTask
     * @model opposite="task" containment="true" resolveProxies="true" ordered="false"
     * @generated
     */
    EList<Execute> getExecute ();

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
     * @see org.eclipse.scada.configuration.recipe.RecipePackage#getTask_Name()
     * @model required="true"
     * @generated
     */
    String getName ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.recipe.Task#getName <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
    void setName ( String value );

    /**
     * Returns the value of the '<em><b>Definition</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link org.eclipse.scada.configuration.recipe.Definition#getTask <em>Task</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Definition</em>' container reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Definition</em>' container reference.
     * @see #setDefinition(Definition)
     * @see org.eclipse.scada.configuration.recipe.RecipePackage#getTask_Definition()
     * @see org.eclipse.scada.configuration.recipe.Definition#getTask
     * @model opposite="task" required="true" transient="false"
     * @generated
     */
    Definition getDefinition ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.recipe.Task#getDefinition <em>Definition</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Definition</em>' container reference.
     * @see #getDefinition()
     * @generated
     */
    void setDefinition ( Definition value );

    /**
     * Returns the value of the '<em><b>Order</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Order</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Order</em>' attribute.
     * @see #setOrder(int)
     * @see org.eclipse.scada.configuration.recipe.RecipePackage#getTask_Order()
     * @model required="true"
     * @generated
     */
    int getOrder ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.recipe.Task#getOrder <em>Order</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Order</em>' attribute.
     * @see #getOrder()
     * @generated
     */
    void setOrder ( int value );

} // Task
