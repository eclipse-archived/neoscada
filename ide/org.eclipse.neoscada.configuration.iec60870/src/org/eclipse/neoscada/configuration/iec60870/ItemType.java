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
package org.eclipse.neoscada.configuration.iec60870;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Item Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.neoscada.configuration.iec60870.ItemType#getItem <em>Item</em>}</li>
 *   <li>{@link org.eclipse.neoscada.configuration.iec60870.ItemType#getType <em>Type</em>}</li>
 * </ul>
 *
 * @see org.eclipse.neoscada.configuration.iec60870.IEC60870Package#getItemType()
 * @model
 * @generated
 */
public interface ItemType extends EObject
{
    /**
     * Returns the value of the '<em><b>Item</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Item</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Item</em>' attribute.
     * @see #setItem(String)
     * @see org.eclipse.neoscada.configuration.iec60870.IEC60870Package#getItemType_Item()
     * @model
     * @generated
     */
    String getItem ();

    /**
     * Sets the value of the '{@link org.eclipse.neoscada.configuration.iec60870.ItemType#getItem <em>Item</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Item</em>' attribute.
     * @see #getItem()
     * @generated
     */
    void setItem ( String value );

    /**
     * Returns the value of the '<em><b>Type</b></em>' attribute.
     * The literals are from the enumeration {@link org.eclipse.neoscada.configuration.iec60870.IECType}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Type</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Type</em>' attribute.
     * @see org.eclipse.neoscada.configuration.iec60870.IECType
     * @see #setType(IECType)
     * @see org.eclipse.neoscada.configuration.iec60870.IEC60870Package#getItemType_Type()
     * @model
     * @generated
     */
    IECType getType ();

    /**
     * Sets the value of the '{@link org.eclipse.neoscada.configuration.iec60870.ItemType#getType <em>Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Type</em>' attribute.
     * @see org.eclipse.neoscada.configuration.iec60870.IECType
     * @see #getType()
     * @generated
     */
    void setType ( IECType value );

} // ItemType
