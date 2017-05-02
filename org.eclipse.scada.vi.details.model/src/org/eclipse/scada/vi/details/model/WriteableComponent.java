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
 * A representation of the model object '<em><b>Writeable Component</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.vi.details.model.WriteableComponent#getCeil <em>Ceil</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.details.model.WriteableComponent#getFloor <em>Floor</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.vi.details.model.DetailViewPackage#getWriteableComponent()
 * @model abstract="true"
 * @generated
 */
public interface WriteableComponent extends ReadableComponent
{
    /**
     * Returns the value of the '<em><b>Ceil</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Ceil</em>' attribute isn't clear, there really
     * should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Ceil</em>' attribute.
     * @see #setCeil(Double)
     * @see org.eclipse.scada.vi.details.model.DetailViewPackage#getWriteableComponent_Ceil()
     * @model
     * @generated
     */
    Double getCeil ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.vi.details.model.WriteableComponent#getCeil <em>Ceil</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Ceil</em>' attribute.
     * @see #getCeil()
     * @generated
     */
    void setCeil ( Double value );

    /**
     * Returns the value of the '<em><b>Floor</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Floor</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Floor</em>' attribute.
     * @see #setFloor(double)
     * @see org.eclipse.scada.vi.details.model.DetailViewPackage#getWriteableComponent_Floor()
     * @model
     * @generated
     */
    double getFloor ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.vi.details.model.WriteableComponent#getFloor <em>Floor</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Floor</em>' attribute.
     * @see #getFloor()
     * @generated
     */
    void setFloor ( double value );

} // WriteableComponent
