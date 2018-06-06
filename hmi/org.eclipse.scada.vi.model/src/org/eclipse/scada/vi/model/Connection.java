/**
 * Copyright (c) 2011, 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 */
package org.eclipse.scada.vi.model;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Connection</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.scada.vi.model.Connection#getStart <em>Start</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.model.Connection#getEnd <em>End</em>}</li>
 * </ul>
 *
 * @see org.eclipse.scada.vi.model.VisualInterfacePackage#getConnection()
 * @model
 * @generated
 */
public interface Connection extends EObject
{
    /**
     * Returns the value of the '<em><b>Start</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Start</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Start</em>' reference.
     * @see #setStart(Primitive)
     * @see org.eclipse.scada.vi.model.VisualInterfacePackage#getConnection_Start()
     * @model required="true"
     * @generated
     */
    Primitive getStart ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.vi.model.Connection#getStart <em>Start</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Start</em>' reference.
     * @see #getStart()
     * @generated
     */
    void setStart ( Primitive value );

    /**
     * Returns the value of the '<em><b>End</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>End</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>End</em>' reference.
     * @see #setEnd(Primitive)
     * @see org.eclipse.scada.vi.model.VisualInterfacePackage#getConnection_End()
     * @model keys="name" required="true"
     * @generated
     */
    Primitive getEnd ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.vi.model.Connection#getEnd <em>End</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>End</em>' reference.
     * @see #getEnd()
     * @generated
     */
    void setEnd ( Primitive value );

} // Connection
