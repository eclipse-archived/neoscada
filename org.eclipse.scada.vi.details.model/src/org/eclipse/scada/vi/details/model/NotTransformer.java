/*******************************************************************************
 * Copyright (c) 2012, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.vi.details.model;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Not Transformer</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.vi.details.model.NotTransformer#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.vi.details.model.DetailViewPackage#getNotTransformer()
 * @model
 * @generated
 */
public interface NotTransformer extends ValueSource
{
    /**
     * Returns the value of the '<em><b>Value</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Value</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Value</em>' containment reference.
     * @see #setValue(ValueSource)
     * @see org.eclipse.scada.vi.details.model.DetailViewPackage#getNotTransformer_Value()
     * @model containment="true" required="true"
     * @generated
     */
    ValueSource getValue ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.vi.details.model.NotTransformer#getValue <em>Value</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Value</em>' containment reference.
     * @see #getValue()
     * @generated
     */
    void setValue ( ValueSource value );

} // NotTransformer
