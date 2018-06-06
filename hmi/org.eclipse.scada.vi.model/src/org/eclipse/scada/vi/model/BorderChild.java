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
 * A representation of the model object '<em><b>Border Child</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.scada.vi.model.BorderChild#getAlignment <em>Alignment</em>}</li>
 * </ul>
 *
 * @see org.eclipse.scada.vi.model.VisualInterfacePackage#getBorderChild()
 * @model
 * @generated
 */
public interface BorderChild extends Child
{
    /**
     * Returns the value of the '<em><b>Alignment</b></em>' attribute.
     * The default value is <code>"CENTER"</code>.
     * The literals are from the enumeration {@link org.eclipse.scada.vi.model.Alignment}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Alignment</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Alignment</em>' attribute.
     * @see org.eclipse.scada.vi.model.Alignment
     * @see #setAlignment(Alignment)
     * @see org.eclipse.scada.vi.model.VisualInterfacePackage#getBorderChild_Alignment()
     * @model default="CENTER" required="true"
     * @generated
     */
    Alignment getAlignment ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.vi.model.BorderChild#getAlignment <em>Alignment</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Alignment</em>' attribute.
     * @see org.eclipse.scada.vi.model.Alignment
     * @see #getAlignment()
     * @generated
     */
    void setAlignment ( Alignment value );

} // BorderChild
