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
 * A representation of the model object '<em><b>Weak Reference Data Source Item</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.WeakReferenceDataSourceItem#getDataSourceId <em>Data Source Id</em>}</li>
 * </ul>
 *
 * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getWeakReferenceDataSourceItem()
 * @model
 * @generated
 */
public interface WeakReferenceDataSourceItem extends Item
{
    /**
     * Returns the value of the '<em><b>Data Source Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Data Source Id</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Data Source Id</em>' attribute.
     * @see #setDataSourceId(String)
     * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getWeakReferenceDataSourceItem_DataSourceId()
     * @model required="true"
     * @generated
     */
    String getDataSourceId ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.world.osgi.WeakReferenceDataSourceItem#getDataSourceId <em>Data Source Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Data Source Id</em>' attribute.
     * @see #getDataSourceId()
     * @generated
     */
    void setDataSourceId ( String value );

} // WeakReferenceDataSourceItem
