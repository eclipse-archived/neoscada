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
 * A representation of the model object '<em><b>Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.recipe.Definition#getTask <em>Task</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.recipe.Definition#getImport <em>Import</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.recipe.Definition#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.recipe.Definition#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.recipe.Definition#getProperties <em>Properties</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.recipe.Definition#getProfiles <em>Profiles</em>}</li>
 * </ul>
 *
 * @see org.eclipse.scada.configuration.recipe.RecipePackage#getDefinition()
 * @model
 * @generated
 */
public interface Definition extends EObject
{
    /**
     * Returns the value of the '<em><b>Task</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.scada.configuration.recipe.Task}.
     * It is bidirectional and its opposite is '{@link org.eclipse.scada.configuration.recipe.Task#getDefinition <em>Definition</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Task</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Task</em>' containment reference list.
     * @see org.eclipse.scada.configuration.recipe.RecipePackage#getDefinition_Task()
     * @see org.eclipse.scada.configuration.recipe.Task#getDefinition
     * @model opposite="definition" containment="true" resolveProxies="true" ordered="false"
     * @generated
     */
    EList<Task> getTask ();

    /**
     * Returns the value of the '<em><b>Import</b></em>' reference list.
     * The list contents are of type {@link org.eclipse.scada.configuration.recipe.Definition}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Import</em>' reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Import</em>' reference list.
     * @see org.eclipse.scada.configuration.recipe.RecipePackage#getDefinition_Import()
     * @model
     * @generated
     */
    EList<Definition> getImport ();

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
     * @see org.eclipse.scada.configuration.recipe.RecipePackage#getDefinition_Name()
     * @model required="true"
     * @generated
     */
    String getName ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.recipe.Definition#getName <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
    void setName ( String value );

    /**
     * Returns the value of the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Id</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Id</em>' attribute.
     * @see #setId(String)
     * @see org.eclipse.scada.configuration.recipe.RecipePackage#getDefinition_Id()
     * @model id="true" required="true"
     * @generated
     */
    String getId ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.recipe.Definition#getId <em>Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Id</em>' attribute.
     * @see #getId()
     * @generated
     */
    void setId ( String value );

    /**
     * Returns the value of the '<em><b>Properties</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.scada.configuration.recipe.PropertyEntry}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Properties</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Properties</em>' containment reference list.
     * @see org.eclipse.scada.configuration.recipe.RecipePackage#getDefinition_Properties()
     * @model containment="true" resolveProxies="true"
     * @generated
     */
    EList<PropertyEntry> getProperties ();

    /**
     * Returns the value of the '<em><b>Profiles</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.scada.configuration.recipe.Profile}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Profiles</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Profiles</em>' containment reference list.
     * @see org.eclipse.scada.configuration.recipe.RecipePackage#getDefinition_Profiles()
     * @model containment="true" resolveProxies="true"
     * @generated
     */
    EList<Profile> getProfiles ();

} // Definition
