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

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Item</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.Item#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.Item#getInformation <em>Information</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.Item#getItemFeatures <em>Item Features</em>}</li>
 * </ul>
 *
 * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getItem()
 * @model abstract="true"
 * @generated
 */
public interface Item extends EObject
{
    /**
     * Returns the value of the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Name</em>' attribute isn't clear, there really
     * should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Name</em>' attribute.
     * @see #setName(String)
     * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getItem_Name()
     * @model required="true"
     * @generated
     */
    String getName ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.world.osgi.Item#getName <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
    void setName ( String value );

    /**
     * Returns the value of the '<em><b>Information</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Information</em>' containment reference isn't
     * clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Information</em>' containment reference.
     * @see #setInformation(ItemInformation)
     * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getItem_Information()
     * @model containment="true" resolveProxies="true"
     * @generated
     */
    ItemInformation getInformation ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.world.osgi.Item#getInformation <em>Information</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Information</em>' containment reference.
     * @see #getInformation()
     * @generated
     */
    void setInformation ( ItemInformation value );

    /**
     * Returns the value of the '<em><b>Item Features</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.scada.configuration.world.osgi.ItemFeatureEntry}.
     * It is bidirectional and its opposite is '{@link org.eclipse.scada.configuration.world.osgi.ItemFeatureEntry#getItem <em>Item</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Item Features</em>' containment reference list
     * isn't clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Item Features</em>' containment reference list.
     * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getItem_ItemFeatures()
     * @see org.eclipse.scada.configuration.world.osgi.ItemFeatureEntry#getItem
     * @model opposite="item" containment="true" resolveProxies="true" keys="name"
     * @generated
     */
    EList<ItemFeatureEntry> getItemFeatures ();

} // Item
