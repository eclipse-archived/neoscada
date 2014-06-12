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
package org.eclipse.scada.configuration.iec60870;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Item</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.iec60870.Item#getSource <em>Source</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.iec60870.Item#getAddress <em>Address</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.iec60870.Item#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.configuration.iec60870.IEC60870Package#getItem()
 * @model
 * @generated
 */
public interface Item extends EObject
{
    /**
     * Returns the value of the '<em><b>Source</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Source</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Source</em>' reference.
     * @see #setSource(org.eclipse.scada.configuration.world.osgi.Item)
     * @see org.eclipse.scada.configuration.iec60870.IEC60870Package#getItem_Source()
     * @model required="true"
     * @generated
     */
    org.eclipse.scada.configuration.world.osgi.Item getSource ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.iec60870.Item#getSource <em>Source</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Source</em>' reference.
     * @see #getSource()
     * @generated
     */
    void setSource ( org.eclipse.scada.configuration.world.osgi.Item value );

    /**
     * Returns the value of the '<em><b>Address</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Address</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Address</em>' attribute.
     * @see #setAddress(AddressInformation)
     * @see org.eclipse.scada.configuration.iec60870.IEC60870Package#getItem_Address()
     * @model dataType="org.eclipse.scada.configuration.iec60870.Address" required="true"
     * @generated
     */
    AddressInformation getAddress ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.iec60870.Item#getAddress <em>Address</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Address</em>' attribute.
     * @see #getAddress()
     * @generated
     */
    void setAddress ( AddressInformation value );

    /**
     * Returns the value of the '<em><b>Type</b></em>' attribute.
     * The literals are from the enumeration {@link org.eclipse.scada.configuration.iec60870.DataType}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Type</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Type</em>' attribute.
     * @see org.eclipse.scada.configuration.iec60870.DataType
     * @see #setType(DataType)
     * @see org.eclipse.scada.configuration.iec60870.IEC60870Package#getItem_Type()
     * @model required="true"
     * @generated
     */
    DataType getType ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.iec60870.Item#getType <em>Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Type</em>' attribute.
     * @see org.eclipse.scada.configuration.iec60870.DataType
     * @see #getType()
     * @generated
     */
    void setType ( DataType value );

} // Item
