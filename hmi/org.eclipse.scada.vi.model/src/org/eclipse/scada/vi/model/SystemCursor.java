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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>System Cursor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.scada.vi.model.SystemCursor#getType <em>Type</em>}</li>
 * </ul>
 *
 * @see org.eclipse.scada.vi.model.VisualInterfacePackage#getSystemCursor()
 * @model
 * @generated
 */
public interface SystemCursor extends Cursor
{
    /**
     * Returns the value of the '<em><b>Type</b></em>' attribute.
     * The literals are from the enumeration {@link org.eclipse.scada.vi.model.SystemCursorType}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Type</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Type</em>' attribute.
     * @see org.eclipse.scada.vi.model.SystemCursorType
     * @see #setType(SystemCursorType)
     * @see org.eclipse.scada.vi.model.VisualInterfacePackage#getSystemCursor_Type()
     * @model required="true"
     * @generated
     */
    SystemCursorType getType ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.vi.model.SystemCursor#getType <em>Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Type</em>' attribute.
     * @see org.eclipse.scada.vi.model.SystemCursorType
     * @see #getType()
     * @generated
     */
    void setType ( SystemCursorType value );

} // SystemCursor
