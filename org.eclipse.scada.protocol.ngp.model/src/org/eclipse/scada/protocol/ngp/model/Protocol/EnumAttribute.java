/*******************************************************************************
 * Copyright (c) 2010, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - implement security callback system
 *******************************************************************************/
package org.eclipse.scada.protocol.ngp.model.Protocol;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Enum Attribute</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.protocol.ngp.model.Protocol.EnumAttribute#getEnumType <em>Enum Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.protocol.ngp.model.Protocol.ProtocolPackage#getEnumAttribute()
 * @model
 * @generated
 */
public interface EnumAttribute extends Attribute
{
    /**
     * Returns the value of the '<em><b>Enum Type</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Enum Type</em>' reference isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Enum Type</em>' reference.
     * @see #setEnumType(org.eclipse.scada.protocol.ngp.model.Protocol.Enum)
     * @see org.eclipse.scada.protocol.ngp.model.Protocol.ProtocolPackage#getEnumAttribute_EnumType()
     * @model required="true"
     * @generated
     */
    org.eclipse.scada.protocol.ngp.model.Protocol.Enum getEnumType ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.protocol.ngp.model.Protocol.EnumAttribute#getEnumType <em>Enum Type</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Enum Type</em>' reference.
     * @see #getEnumType()
     * @generated
     */
    void setEnumType ( org.eclipse.scada.protocol.ngp.model.Protocol.Enum value );

} // EnumAttribute
