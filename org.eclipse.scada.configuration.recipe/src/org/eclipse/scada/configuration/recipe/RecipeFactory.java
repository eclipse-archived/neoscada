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

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.scada.configuration.recipe.RecipePackage
 * @generated
 */
public interface RecipeFactory extends EFactory
{
    /**
     * The singleton instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    RecipeFactory eINSTANCE = org.eclipse.scada.configuration.recipe.impl.RecipeFactoryImpl.init ();

    /**
     * Returns a new object of class '<em>Definition</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Definition</em>'.
     * @generated
     */
    Definition createDefinition ();

    /**
     * Returns a new object of class '<em>Task</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Task</em>'.
     * @generated
     */
    Task createTask ();

    /**
     * Returns a new object of class '<em>Execute</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Execute</em>'.
     * @generated
     */
    Execute createExecute ();

    /**
     * Returns a new object of class '<em>Map Input</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Map Input</em>'.
     * @generated
     */
    MapInput createMapInput ();

    /**
     * Returns a new object of class '<em>String Input Value</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>String Input Value</em>'.
     * @generated
     */
    StringInputValue createStringInputValue ();

    /**
     * Returns a new object of class '<em>Capture Output</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Capture Output</em>'.
     * @generated
     */
    CaptureOutput createCaptureOutput ();

    /**
     * Returns a new object of class '<em>Input Reference</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Input Reference</em>'.
     * @generated
     */
    InputReference createInputReference ();

    /**
     * Returns the package supported by this factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the package supported by this factory.
     * @generated
     */
    RecipePackage getRecipePackage ();

} //RecipeFactory
