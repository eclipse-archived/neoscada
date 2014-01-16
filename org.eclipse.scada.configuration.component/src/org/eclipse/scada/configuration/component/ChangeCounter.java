/**
 * Copyright (c) 2014 IBH SYSTEMS GmbH.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation and/or initial documentation
 * 
 */
package org.eclipse.scada.configuration.component;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Change Counter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.component.ChangeCounter#getBuffer <em>Buffer</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.configuration.component.ComponentPackage#getChangeCounter()
 * @model
 * @generated
 */
public interface ChangeCounter extends SingleValue
{
    /**
     * Returns the value of the '<em><b>Buffer</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Buffer</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Buffer</em>' reference.
     * @see #setBuffer(BufferedValue)
     * @see org.eclipse.scada.configuration.component.ComponentPackage#getChangeCounter_Buffer()
     * @model
     * @generated
     */
    BufferedValue getBuffer ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.component.ChangeCounter#getBuffer <em>Buffer</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Buffer</em>' reference.
     * @see #getBuffer()
     * @generated
     */
    void setBuffer ( BufferedValue value );

} // ChangeCounter
