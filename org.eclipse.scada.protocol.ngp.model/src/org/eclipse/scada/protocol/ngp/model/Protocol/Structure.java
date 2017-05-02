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
 * A representation of the model object '<em><b>Structure</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.protocol.ngp.model.Protocol.Structure#getProtocol <em>Protocol</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.protocol.ngp.model.Protocol.ProtocolPackage#getStructure()
 * @model
 * @generated
 */
public interface Structure extends AttributeStructure
{

    /**
     * Returns the value of the '<em><b>Protocol</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link org.eclipse.scada.protocol.ngp.model.Protocol.Protocol#getStructures <em>Structures</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Protocol</em>' container reference isn't
     * clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Protocol</em>' container reference.
     * @see #setProtocol(Protocol)
     * @see org.eclipse.scada.protocol.ngp.model.Protocol.ProtocolPackage#getStructure_Protocol()
     * @see org.eclipse.scada.protocol.ngp.model.Protocol.Protocol#getStructures
     * @model opposite="structures" required="true" transient="false"
     * @generated
     */
    Protocol getProtocol ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.protocol.ngp.model.Protocol.Structure#getProtocol <em>Protocol</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Protocol</em>' container reference.
     * @see #getProtocol()
     * @generated
     */
    void setProtocol ( Protocol value );
} // Structure
