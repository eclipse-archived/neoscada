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
package org.eclipse.scada.configuration.globalization;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Item Name Filter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.globalization.ItemNameFilter#isInclude <em>Include</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.globalization.ItemNameFilter#getItemName <em>Item Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.configuration.globalization.GlobalizePackage#getItemNameFilter()
 * @model
 * @generated
 */
public interface ItemNameFilter extends Filter
{
    /**
     * Returns the value of the '<em><b>Include</b></em>' attribute.
     * The default value is <code>"true"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Include</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Include</em>' attribute.
     * @see #setInclude(boolean)
     * @see org.eclipse.scada.configuration.globalization.GlobalizePackage#getItemNameFilter_Include()
     * @model default="true" required="true"
     * @generated
     */
    boolean isInclude ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.globalization.ItemNameFilter#isInclude <em>Include</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Include</em>' attribute.
     * @see #isInclude()
     * @generated
     */
    void setInclude ( boolean value );

    /**
     * Returns the value of the '<em><b>Item Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Item Name</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Item Name</em>' attribute.
     * @see #setItemName(String)
     * @see org.eclipse.scada.configuration.globalization.GlobalizePackage#getItemNameFilter_ItemName()
     * @model required="true"
     * @generated
     */
    String getItemName ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.globalization.ItemNameFilter#getItemName <em>Item Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Item Name</em>' attribute.
     * @see #getItemName()
     * @generated
     */
    void setItemName ( String value );

} // ItemNameFilter
