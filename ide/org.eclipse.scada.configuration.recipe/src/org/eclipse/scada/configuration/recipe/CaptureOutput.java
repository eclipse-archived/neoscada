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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Capture Output</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.recipe.CaptureOutput#getLocalName <em>Local Name</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.recipe.CaptureOutput#getContextName <em>Context Name</em>}</li>
 * </ul>
 *
 * @see org.eclipse.scada.configuration.recipe.RecipePackage#getCaptureOutput()
 * @model
 * @generated
 */
public interface CaptureOutput extends EObject
{
    /**
     * Returns the value of the '<em><b>Local Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Local Name</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Local Name</em>' attribute.
     * @see #setLocalName(String)
     * @see org.eclipse.scada.configuration.recipe.RecipePackage#getCaptureOutput_LocalName()
     * @model required="true"
     * @generated
     */
    String getLocalName ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.recipe.CaptureOutput#getLocalName <em>Local Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Local Name</em>' attribute.
     * @see #getLocalName()
     * @generated
     */
    void setLocalName ( String value );

    /**
     * Returns the value of the '<em><b>Context Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Context Name</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Context Name</em>' attribute.
     * @see #setContextName(String)
     * @see org.eclipse.scada.configuration.recipe.RecipePackage#getCaptureOutput_ContextName()
     * @model
     * @generated
     */
    String getContextName ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.recipe.CaptureOutput#getContextName <em>Context Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Context Name</em>' attribute.
     * @see #getContextName()
     * @generated
     */
    void setContextName ( String value );

} // CaptureOutput
