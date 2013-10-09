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
 * A representation of the model object '<em><b>Enum</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.scada.protocol.ngp.model.Protocol.Enum#getName <em>
 * Name</em>}</li>
 * <li>{@link org.eclipse.scada.protocol.ngp.model.Protocol.Enum#getLiterals
 * <em>Literals</em>}</li>
 * <li>{@link org.eclipse.scada.protocol.ngp.model.Protocol.Enum#getProtocol
 * <em>Protocol</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.scada.protocol.ngp.model.Protocol.ProtocolPackage#getEnum()
 * @model
 * @generated
 */
public interface Enum extends DocumentedElement
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
     * @see org.eclipse.scada.protocol.ngp.model.Protocol.ProtocolPackage#getEnum_Name()
     * @model id="true" required="true"
     * @generated
     */
    String getName ();

    /**
     * Sets the value of the '
     * {@link org.eclipse.scada.protocol.ngp.model.Protocol.Enum#getName
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
     * Returns the value of the '<em><b>Literals</b></em>' attribute list.
     * The list contents are of type {@link java.lang.String}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Literals</em>' attribute list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Literals</em>' attribute list.
     * @see org.eclipse.scada.protocol.ngp.model.Protocol.ProtocolPackage#getEnum_Literals()
     * @model
     * @generated
     */
    EList<String> getLiterals ();

    /**
     * Returns the value of the '<em><b>Protocol</b></em>' container reference.
     * It is bidirectional and its opposite is '
     * {@link org.eclipse.scada.protocol.ngp.model.Protocol.Protocol#getEnums
     * <em>Enums</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Protocol</em>' container reference isn't
     * clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Protocol</em>' container reference.
     * @see #setProtocol(Protocol)
     * @see org.eclipse.scada.protocol.ngp.model.Protocol.ProtocolPackage#getEnum_Protocol()
     * @see org.eclipse.scada.protocol.ngp.model.Protocol.Protocol#getEnums
     * @model opposite="enums" transient="false"
     * @generated
     */
    Protocol getProtocol ();

    /**
     * Sets the value of the '
     * {@link org.eclipse.scada.protocol.ngp.model.Protocol.Enum#getProtocol
     * <em>Protocol</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Protocol</em>' container reference.
     * @see #getProtocol()
     * @generated
     */
    void setProtocol ( Protocol value );

} // Enum
