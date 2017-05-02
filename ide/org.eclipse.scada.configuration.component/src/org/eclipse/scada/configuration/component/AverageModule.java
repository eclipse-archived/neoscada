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
package org.eclipse.scada.configuration.component;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Average Module</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.component.AverageModule#getValidSourcesRequired <em>Valid Sources Required</em>}</li>
 * </ul>
 *
 * @see org.eclipse.scada.configuration.component.ComponentPackage#getAverageModule()
 * @model
 * @generated
 */
public interface AverageModule extends CalculationModule
{

    /**
     * Returns the value of the '<em><b>Valid Sources Required</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Valid Sources Required</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Valid Sources Required</em>' attribute.
     * @see #setValidSourcesRequired(String)
     * @see org.eclipse.scada.configuration.component.ComponentPackage#getAverageModule_ValidSourcesRequired()
     * @model required="true"
     * @generated
     */
    String getValidSourcesRequired ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.component.AverageModule#getValidSourcesRequired <em>Valid Sources Required</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Valid Sources Required</em>' attribute.
     * @see #getValidSourcesRequired()
     * @generated
     */
    void setValidSourcesRequired ( String value );
} // AverageModule
