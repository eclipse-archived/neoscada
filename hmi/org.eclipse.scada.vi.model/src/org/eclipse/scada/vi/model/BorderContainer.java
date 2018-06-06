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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Border Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.scada.vi.model.BorderContainer#getChildren <em>Children</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.model.BorderContainer#getVerticalSpacing <em>Vertical Spacing</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.model.BorderContainer#getHorizontalSpacing <em>Horizontal Spacing</em>}</li>
 * </ul>
 *
 * @see org.eclipse.scada.vi.model.VisualInterfacePackage#getBorderContainer()
 * @model
 * @generated
 */
public interface BorderContainer extends Container
{
    /**
     * Returns the value of the '<em><b>Children</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.scada.vi.model.BorderChild}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Children</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Children</em>' containment reference list.
     * @see org.eclipse.scada.vi.model.VisualInterfacePackage#getBorderContainer_Children()
     * @model containment="true"
     * @generated
     */
    EList<BorderChild> getChildren ();

    /**
     * Returns the value of the '<em><b>Vertical Spacing</b></em>' attribute.
     * The default value is <code>"0"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Vertical Spacing</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Vertical Spacing</em>' attribute.
     * @see #setVerticalSpacing(int)
     * @see org.eclipse.scada.vi.model.VisualInterfacePackage#getBorderContainer_VerticalSpacing()
     * @model default="0" required="true"
     * @generated
     */
    int getVerticalSpacing ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.vi.model.BorderContainer#getVerticalSpacing <em>Vertical Spacing</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Vertical Spacing</em>' attribute.
     * @see #getVerticalSpacing()
     * @generated
     */
    void setVerticalSpacing ( int value );

    /**
     * Returns the value of the '<em><b>Horizontal Spacing</b></em>' attribute.
     * The default value is <code>"0"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Horizontal Spacing</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Horizontal Spacing</em>' attribute.
     * @see #setHorizontalSpacing(int)
     * @see org.eclipse.scada.vi.model.VisualInterfacePackage#getBorderContainer_HorizontalSpacing()
     * @model default="0" required="true"
     * @generated
     */
    int getHorizontalSpacing ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.vi.model.BorderContainer#getHorizontalSpacing <em>Horizontal Spacing</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Horizontal Spacing</em>' attribute.
     * @see #getHorizontalSpacing()
     * @generated
     */
    void setHorizontalSpacing ( int value );

} // BorderContainer
