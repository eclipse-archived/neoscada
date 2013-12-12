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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Event Storage Jdbc</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.EventStorageJdbc#getJdbcDriverName <em>Jdbc Driver Name</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.EventStorageJdbc#getDriverBundles <em>Driver Bundles</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.EventStorageJdbc#getMaxFieldLength <em>Max Field Length</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.EventStorageJdbc#getQueryFetchSize <em>Query Fetch Size</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getEventStorageJdbc()
 * @model
 * @generated
 */
public interface EventStorageJdbc extends AbstractEventStorageJdbc {

	/**
	 * Returns the value of the '<em><b>Jdbc Driver Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Jdbc Driver Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Jdbc Driver Name</em>' attribute.
	 * @see #setJdbcDriverName(String)
	 * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getEventStorageJdbc_JdbcDriverName()
	 * @model required="true"
	 * @generated
	 */
	String getJdbcDriverName();

	/**
	 * Sets the value of the '{@link org.eclipse.scada.configuration.world.osgi.EventStorageJdbc#getJdbcDriverName <em>Jdbc Driver Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Jdbc Driver Name</em>' attribute.
	 * @see #getJdbcDriverName()
	 * @generated
	 */
	void setJdbcDriverName(String value);

	/**
	 * Returns the value of the '<em><b>Driver Bundles</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Defines a list of OSGi bundles to start automatically.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Driver Bundles</em>' attribute list.
	 * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getEventStorageJdbc_DriverBundles()
	 * @model
	 * @generated
	 */
	EList<String> getDriverBundles();

	/**
	 * Returns the value of the '<em><b>Max Field Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max Field Length</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Field Length</em>' attribute.
	 * @see #setMaxFieldLength(Integer)
	 * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getEventStorageJdbc_MaxFieldLength()
	 * @model
	 * @generated
	 */
	Integer getMaxFieldLength();

	/**
	 * Sets the value of the '{@link org.eclipse.scada.configuration.world.osgi.EventStorageJdbc#getMaxFieldLength <em>Max Field Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Field Length</em>' attribute.
	 * @see #getMaxFieldLength()
	 * @generated
	 */
	void setMaxFieldLength(Integer value);

	/**
	 * Returns the value of the '<em><b>Query Fetch Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Query Fetch Size</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Query Fetch Size</em>' attribute.
	 * @see #setQueryFetchSize(Integer)
	 * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getEventStorageJdbc_QueryFetchSize()
	 * @model
	 * @generated
	 */
	Integer getQueryFetchSize();

	/**
	 * Sets the value of the '{@link org.eclipse.scada.configuration.world.osgi.EventStorageJdbc#getQueryFetchSize <em>Query Fetch Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Query Fetch Size</em>' attribute.
	 * @see #getQueryFetchSize()
	 * @generated
	 */
	void setQueryFetchSize(Integer value);
} // EventStorageJdbc
