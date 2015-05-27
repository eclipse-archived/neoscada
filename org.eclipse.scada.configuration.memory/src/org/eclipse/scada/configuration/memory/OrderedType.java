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
package org.eclipse.scada.configuration.memory;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ordered Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.memory.OrderedType#getOrder <em>Order</em>}</li>
 * </ul>
 *
 * @see org.eclipse.scada.configuration.memory.MemoryPackage#getOrderedType()
 * @model abstract="true"
 * @generated
 */
public interface OrderedType extends BaseScalarType
{
    /**
     * Returns the value of the '<em><b>Order</b></em>' attribute.
     * The default value is <code>"BIG_ENDIAN"</code>.
     * The literals are from the enumeration {@link org.eclipse.scada.configuration.memory.ByteOrder}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Order</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Order</em>' attribute.
     * @see org.eclipse.scada.configuration.memory.ByteOrder
     * @see #setOrder(ByteOrder)
     * @see org.eclipse.scada.configuration.memory.MemoryPackage#getOrderedType_Order()
     * @model default="BIG_ENDIAN" required="true"
     * @generated
     */
    ByteOrder getOrder ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.memory.OrderedType#getOrder <em>Order</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Order</em>' attribute.
     * @see org.eclipse.scada.configuration.memory.ByteOrder
     * @see #getOrder()
     * @generated
     */
    void setOrder ( ByteOrder value );

} // OrderedType
