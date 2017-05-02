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

import org.eclipse.scada.configuration.item.CustomizationRequest;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Call</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.item.Call#getPipeline <em>Pipeline</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.configuration.item.ItemPackage#getCall()
 * @model
 * @generated
 */
public interface Call extends Step
{
    /**
     * Returns the value of the '<em><b>Pipeline</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Pipeline</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Pipeline</em>' reference.
     * @see #setPipeline(CustomizationPipeline)
     * @see org.eclipse.scada.configuration.item.ItemPackage#getCall_Pipeline()
     * @model
     * @generated
     */
    CustomizationPipeline getPipeline ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.item.Call#getPipeline <em>Pipeline</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Pipeline</em>' reference.
     * @see #getPipeline()
     * @generated
     */
    void setPipeline ( CustomizationPipeline value );

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model requestDataType="org.eclipse.scada.configuration.item.CustomizationRequest"
     *        annotation="http://www.eclipse.org/emf/2002/GenModel body='getPipeline ().customize ( request );'"
     * @generated
     */
    void execute ( CustomizationRequest request );

} // Call
