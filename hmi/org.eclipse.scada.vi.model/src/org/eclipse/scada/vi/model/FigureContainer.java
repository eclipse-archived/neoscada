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
 * A representation of the model object '<em><b>Figure Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.scada.vi.model.FigureContainer#getContent <em>Content</em>}</li>
 * </ul>
 *
 * @see org.eclipse.scada.vi.model.VisualInterfacePackage#getFigureContainer()
 * @model
 * @generated
 */
public interface FigureContainer extends Figure
{
    /**
     * Returns the value of the '<em><b>Content</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Content</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Content</em>' containment reference.
     * @see #setContent(Primitive)
     * @see org.eclipse.scada.vi.model.VisualInterfacePackage#getFigureContainer_Content()
     * @model containment="true"
     * @generated
     */
    Primitive getContent ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.vi.model.FigureContainer#getContent <em>Content</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Content</em>' containment reference.
     * @see #getContent()
     * @generated
     */
    void setContent ( Primitive value );

} // FigureContainer
