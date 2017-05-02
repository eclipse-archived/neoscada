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
 * A representation of the model object '<em><b>Structure Attribute</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.protocol.ngp.model.Protocol.StructureAttribute#getStructure <em>Structure</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.protocol.ngp.model.Protocol.ProtocolPackage#getStructureAttribute()
 * @model
 * @generated
 */
public interface StructureAttribute extends Attribute
{
    /**
     * Returns the value of the '<em><b>Structure</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Structure</em>' reference isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Structure</em>' reference.
     * @see #setStructure(Structure)
     * @see org.eclipse.scada.protocol.ngp.model.Protocol.ProtocolPackage#getStructureAttribute_Structure()
     * @model required="true"
     * @generated
     */
    Structure getStructure ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.protocol.ngp.model.Protocol.StructureAttribute#getStructure <em>Structure</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Structure</em>' reference.
     * @see #getStructure()
     * @generated
     */
    void setStructure ( Structure value );

} // StructureAttribute
