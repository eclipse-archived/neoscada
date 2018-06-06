/**
 * Copyright (c) 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 */
package org.eclipse.scada.vi.model;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Rounded Rectangle</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.scada.vi.model.RoundedRectangle#getCorner <em>Corner</em>}</li>
 * </ul>
 *
 * @see org.eclipse.scada.vi.model.VisualInterfacePackage#getRoundedRectangle()
 * @model
 * @generated
 */
public interface RoundedRectangle extends Shape
{
    /**
     * Returns the value of the '<em><b>Corner</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Corner</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Corner</em>' containment reference.
     * @see #setCorner(Dimension)
     * @see org.eclipse.scada.vi.model.VisualInterfacePackage#getRoundedRectangle_Corner()
     * @model containment="true"
     * @generated
     */
    Dimension getCorner ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.vi.model.RoundedRectangle#getCorner <em>Corner</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Corner</em>' containment reference.
     * @see #getCorner()
     * @generated
     */
    void setCorner ( Dimension value );

} // RoundedRectangle
