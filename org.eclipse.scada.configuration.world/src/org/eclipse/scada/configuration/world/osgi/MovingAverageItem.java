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
package org.eclipse.scada.configuration.world.osgi;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Moving Average Item</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.MovingAverageItem#getSource <em>Source</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.MovingAverageItem#getType <em>Type</em>}</li>
 * </ul>
 *
 * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getMovingAverageItem()
 * @model
 * @generated
 */
public interface MovingAverageItem extends Item
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
     * @see #setSource(MovingAverage)
     * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getMovingAverageItem_Source()
     * @model required="true"
     * @generated
     */
    MovingAverage getSource ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.world.osgi.MovingAverageItem#getSource <em>Source</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Source</em>' reference.
     * @see #getSource()
     * @generated
     */
    void setSource ( MovingAverage value );

    /**
     * Returns the value of the '<em><b>Type</b></em>' attribute.
     * The literals are from the enumeration {@link org.eclipse.scada.configuration.world.osgi.MovingAverageReferenceType}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Type</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Type</em>' attribute.
     * @see org.eclipse.scada.configuration.world.osgi.MovingAverageReferenceType
     * @see #setType(MovingAverageReferenceType)
     * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getMovingAverageItem_Type()
     * @model required="true"
     * @generated
     */
    MovingAverageReferenceType getType ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.world.osgi.MovingAverageItem#getType <em>Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Type</em>' attribute.
     * @see org.eclipse.scada.configuration.world.osgi.MovingAverageReferenceType
     * @see #getType()
     * @generated
     */
    void setType ( MovingAverageReferenceType value );

} // MovingAverageItem
