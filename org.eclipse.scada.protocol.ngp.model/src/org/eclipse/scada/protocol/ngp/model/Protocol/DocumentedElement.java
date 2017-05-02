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
/**
 */
package org.eclipse.scada.protocol.ngp.model.Protocol;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Documented Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.protocol.ngp.model.Protocol.DocumentedElement#getDescription <em>Description</em>}</li>
 *   <li>{@link org.eclipse.scada.protocol.ngp.model.Protocol.DocumentedElement#getShortDescription <em>Short Description</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.protocol.ngp.model.Protocol.ProtocolPackage#getDocumentedElement()
 * @model abstract="true"
 * @generated
 */
public interface DocumentedElement extends EObject
{
    /**
     * Returns the value of the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Description</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Description</em>' attribute.
     * @see #setDescription(String)
     * @see org.eclipse.scada.protocol.ngp.model.Protocol.ProtocolPackage#getDocumentedElement_Description()
     * @model
     * @generated
     */
    String getDescription ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.protocol.ngp.model.Protocol.DocumentedElement#getDescription <em>Description</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Description</em>' attribute.
     * @see #getDescription()
     * @generated
     */
    void setDescription ( String value );

    /**
     * Returns the value of the '<em><b>Short Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Short Description</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Short Description</em>' attribute.
     * @see #setShortDescription(String)
     * @see org.eclipse.scada.protocol.ngp.model.Protocol.ProtocolPackage#getDocumentedElement_ShortDescription()
     * @model
     * @generated
     */
    String getShortDescription ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.protocol.ngp.model.Protocol.DocumentedElement#getShortDescription <em>Short Description</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Short Description</em>' attribute.
     * @see #getShortDescription()
     * @generated
     */
    void setShortDescription ( String value );

} // DocumentedElement
