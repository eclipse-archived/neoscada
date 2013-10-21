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
 * A representation of the model object '<em><b>Message</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.protocol.ngp.model.Protocol.Message#getCode <em>Code</em>}</li>
 *   <li>{@link org.eclipse.scada.protocol.ngp.model.Protocol.Message#getProtocol <em>Protocol</em>}</li>
 *   <li>{@link org.eclipse.scada.protocol.ngp.model.Protocol.Message#getInterfaces <em>Interfaces</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.protocol.ngp.model.Protocol.ProtocolPackage#getMessage()
 * @model
 * @generated
 */
public interface Message extends AttributeStructure
{
    /**
     * Returns the value of the '<em><b>Code</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Code</em>' attribute isn't clear, there really
     * should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Code</em>' attribute.
     * @see #setCode(int)
     * @see org.eclipse.scada.protocol.ngp.model.Protocol.ProtocolPackage#getMessage_Code()
     * @model required="true"
     * @generated
     */
    int getCode ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.protocol.ngp.model.Protocol.Message#getCode <em>Code</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Code</em>' attribute.
     * @see #getCode()
     * @generated
     */
    void setCode ( int value );

    /**
     * Returns the value of the '<em><b>Protocol</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link org.eclipse.scada.protocol.ngp.model.Protocol.Protocol#getMessages <em>Messages</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Protocol</em>' container reference isn't
     * clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Protocol</em>' container reference.
     * @see #setProtocol(Protocol)
     * @see org.eclipse.scada.protocol.ngp.model.Protocol.ProtocolPackage#getMessage_Protocol()
     * @see org.eclipse.scada.protocol.ngp.model.Protocol.Protocol#getMessages
     * @model opposite="messages" required="true" transient="false"
     * @generated
     */
    Protocol getProtocol ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.protocol.ngp.model.Protocol.Message#getProtocol <em>Protocol</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Protocol</em>' container reference.
     * @see #getProtocol()
     * @generated
     */
    void setProtocol ( Protocol value );

    /**
     * Returns the value of the '<em><b>Interfaces</b></em>' reference list.
     * The list contents are of type {@link org.eclipse.scada.protocol.ngp.model.Protocol.Interface}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Interfaces</em>' reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Interfaces</em>' reference list.
     * @see org.eclipse.scada.protocol.ngp.model.Protocol.ProtocolPackage#getMessage_Interfaces()
     * @model
     * @generated
     */
    EList<Interface> getInterfaces ();

} // Message
