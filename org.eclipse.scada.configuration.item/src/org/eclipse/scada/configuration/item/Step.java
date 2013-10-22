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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.scada.configuration.item.CustomizationRequest;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Step</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.item.Step#getContainingPipeline <em>Containing Pipeline</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.configuration.item.ItemPackage#getStep()
 * @model abstract="true"
 * @generated
 */
public interface Step extends EObject
{

    /**
     * Returns the value of the '<em><b>Containing Pipeline</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link org.eclipse.scada.configuration.item.CompositePipeline#getSteps <em>Steps</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Containing Pipeline</em>' container reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Containing Pipeline</em>' container reference.
     * @see #setContainingPipeline(CompositePipeline)
     * @see org.eclipse.scada.configuration.item.ItemPackage#getStep_ContainingPipeline()
     * @see org.eclipse.scada.configuration.item.CompositePipeline#getSteps
     * @model opposite="steps" transient="false"
     * @generated
     */
    CompositePipeline getContainingPipeline ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.item.Step#getContainingPipeline <em>Containing Pipeline</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Containing Pipeline</em>' container reference.
     * @see #getContainingPipeline()
     * @generated
     */
    void setContainingPipeline ( CompositePipeline value );

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model requestDataType="org.eclipse.scada.configuration.item.CustomizationRequest"
     * @generated
     */
    void execute ( CustomizationRequest request );
} // Step
