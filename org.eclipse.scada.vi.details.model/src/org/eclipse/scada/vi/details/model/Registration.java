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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Registration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.vi.details.model.Registration#getKey <em>Key</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.details.model.Registration#getDescriptor <em>Descriptor</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.details.model.Registration#isAggregateState <em>Aggregate State</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.vi.details.model.DetailViewPackage#getRegistration()
 * @model
 * @generated
 */
public interface Registration extends EObject
{
    /**
     * Returns the value of the '<em><b>Key</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Key</em>' attribute isn't clear, there really
     * should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Key</em>' attribute.
     * @see #setKey(String)
     * @see org.eclipse.scada.vi.details.model.DetailViewPackage#getRegistration_Key()
     * @model required="true"
     * @generated
     */
    String getKey ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.vi.details.model.Registration#getKey <em>Key</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Key</em>' attribute.
     * @see #getKey()
     * @generated
     */
    void setKey ( String value );

    /**
     * Returns the value of the '<em><b>Descriptor</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Descriptor</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Descriptor</em>' attribute.
     * @see #setDescriptor(String)
     * @see org.eclipse.scada.vi.details.model.DetailViewPackage#getRegistration_Descriptor()
     * @model required="true"
     * @generated
     */
    String getDescriptor ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.vi.details.model.Registration#getDescriptor <em>Descriptor</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Descriptor</em>' attribute.
     * @see #getDescriptor()
     * @generated
     */
    void setDescriptor ( String value );

    /**
     * Returns the value of the '<em><b>Aggregate State</b></em>' attribute.
     * The default value is <code>"true"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Aggregate State</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Aggregate State</em>' attribute.
     * @see #setAggregateState(boolean)
     * @see org.eclipse.scada.vi.details.model.DetailViewPackage#getRegistration_AggregateState()
     * @model default="true"
     * @generated
     */
    boolean isAggregateState ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.vi.details.model.Registration#isAggregateState <em>Aggregate State</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Aggregate State</em>' attribute.
     * @see #isAggregateState()
     * @generated
     */
    void setAggregateState ( boolean value );

} // Registration
