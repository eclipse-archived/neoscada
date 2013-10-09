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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attribute Structure</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>
 * {@link org.eclipse.scada.protocol.ngp.model.Protocol.AttributeStructure#getName
 * <em>Name</em>}</li>
 * <li>
 * {@link org.eclipse.scada.protocol.ngp.model.Protocol.AttributeStructure#getAttributes
 * <em>Attributes</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.scada.protocol.ngp.model.Protocol.ProtocolPackage#getAttributeStructure()
 * @model abstract="true"
 * @generated
 */
public interface AttributeStructure extends DocumentedElement
{
    /**
     * Returns the value of the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Name</em>' attribute isn't clear, there really
     * should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Name</em>' attribute.
     * @see #setName(String)
     * @see org.eclipse.scada.protocol.ngp.model.Protocol.ProtocolPackage#getAttributeStructure_Name()
     * @model id="true" required="true"
     * @generated
     */
    String getName ();

    /**
     * Sets the value of the '
     * {@link org.eclipse.scada.protocol.ngp.model.Protocol.AttributeStructure#getName
     * <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
    void setName ( String value );

    /**
     * Returns the value of the '<em><b>Attributes</b></em>' containment
     * reference list.
     * The list contents are of type
     * {@link org.eclipse.scada.protocol.ngp.model.Protocol.Attribute}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Attributes</em>' containment reference list
     * isn't clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Attributes</em>' containment reference
     *         list.
     * @see org.eclipse.scada.protocol.ngp.model.Protocol.ProtocolPackage#getAttributeStructure_Attributes()
     * @model containment="true" resolveProxies="true"
     * @generated
     */
    EList<Attribute> getAttributes ();

} // AttributeStructure
