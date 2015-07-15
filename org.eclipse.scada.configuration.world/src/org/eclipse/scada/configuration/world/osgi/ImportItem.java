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
 * A representation of the model object '<em><b>Import Item</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.ImportItem#getExport <em>Export</em>}</li>
 * </ul>
 *
 * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getImportItem()
 * @model
 * @generated
 */
public interface ImportItem extends Item
{
    /**
     * Returns the value of the '<em><b>Export</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Export</em>' reference list isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Export</em>' reference.
     * @see #setExport(ItemExport)
     * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getImportItem_Export()
     * @model required="true"
     * @generated
     */
    ItemExport getExport ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.world.osgi.ImportItem#getExport <em>Export</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Export</em>' reference.
     * @see #getExport()
     * @generated
     */
    void setExport ( ItemExport value );

} // ImportItem
