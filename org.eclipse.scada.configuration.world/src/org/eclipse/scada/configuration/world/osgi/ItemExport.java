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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Item Export</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.ItemExport#getItem <em>Item</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.ItemExport#getExportName <em>Export Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getItemExport()
 * @model
 * @generated
 */
public interface ItemExport extends EObject {
	/**
	 * Returns the value of the '<em><b>Item</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Item</em>' reference isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Item</em>' reference.
	 * @see #setItem(Item)
	 * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getItemExport_Item()
	 * @model required="true"
	 * @generated
	 */
	Item getItem();

	/**
	 * Sets the value of the '{@link org.eclipse.scada.configuration.world.osgi.ItemExport#getItem <em>Item</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Item</em>' reference.
	 * @see #getItem()
	 * @generated
	 */
	void setItem(Item value);

	/**
	 * Returns the value of the '<em><b>Export Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Export Name</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Export Name</em>' attribute.
	 * @see #setExportName(String)
	 * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getItemExport_ExportName()
	 * @model
	 * @generated
	 */
	String getExportName();

	/**
	 * Sets the value of the '{@link org.eclipse.scada.configuration.world.osgi.ItemExport#getExportName <em>Export Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Export Name</em>' attribute.
	 * @see #getExportName()
	 * @generated
	 */
	void setExportName(String value);

} // ItemExport
