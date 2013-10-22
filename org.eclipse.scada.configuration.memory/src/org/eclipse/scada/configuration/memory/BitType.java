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
package org.eclipse.scada.configuration.memory;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Bit Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.memory.BitType#getSubIndex <em>Sub Index</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.configuration.memory.MemoryPackage#getBitType()
 * @model
 * @generated
 */
public interface BitType extends BaseScalarType
{
    /**
     * Returns the value of the '<em><b>Sub Index</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Sub Index</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Sub Index</em>' attribute.
     * @see #setSubIndex(int)
     * @see org.eclipse.scada.configuration.memory.MemoryPackage#getBitType_SubIndex()
     * @model required="true"
     * @generated
     */
    int getSubIndex ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.memory.BitType#getSubIndex <em>Sub Index</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Sub Index</em>' attribute.
     * @see #getSubIndex()
     * @generated
     */
    void setSubIndex ( int value );

} // BitType
