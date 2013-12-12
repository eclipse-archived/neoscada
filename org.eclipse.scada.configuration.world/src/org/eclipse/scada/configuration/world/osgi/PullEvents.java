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
import org.eclipse.scada.configuration.world.Documentable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Pull Events</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.PullEvents#getJdbcDriverName <em>Jdbc Driver Name</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.PullEvents#getJdbcProperties <em>Jdbc Properties</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.PullEvents#getJobInterval <em>Job Interval</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.PullEvents#getCustomSelectSql <em>Custom Select Sql</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.PullEvents#getCustomDeleteSql <em>Custom Delete Sql</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getPullEvents()
 * @model
 * @generated
 */
public interface PullEvents extends Documentable {
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
	 * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getPullEvents_JdbcDriverName()
	 * @model required="true"
	 * @generated
	 */
	String getJdbcDriverName();

	/**
	 * Sets the value of the '{@link org.eclipse.scada.configuration.world.osgi.PullEvents#getJdbcDriverName <em>Jdbc Driver Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Jdbc Driver Name</em>' attribute.
	 * @see #getJdbcDriverName()
	 * @generated
	 */
	void setJdbcDriverName(String value);

	/**
	 * Returns the value of the '<em><b>Jdbc Properties</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.scada.configuration.world.osgi.PropertyEntry}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Jdbc Properties</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Jdbc Properties</em>' containment reference list.
	 * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getPullEvents_JdbcProperties()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<PropertyEntry> getJdbcProperties();

	/**
	 * Returns the value of the '<em><b>Job Interval</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Job Interval</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Job Interval</em>' attribute.
	 * @see #setJobInterval(Integer)
	 * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getPullEvents_JobInterval()
	 * @model
	 * @generated
	 */
	Integer getJobInterval();

	/**
	 * Sets the value of the '{@link org.eclipse.scada.configuration.world.osgi.PullEvents#getJobInterval <em>Job Interval</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Job Interval</em>' attribute.
	 * @see #getJobInterval()
	 * @generated
	 */
	void setJobInterval(Integer value);

	/**
	 * Returns the value of the '<em><b>Custom Select Sql</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Custom Select Sql</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Custom Select Sql</em>' attribute.
	 * @see #setCustomSelectSql(String)
	 * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getPullEvents_CustomSelectSql()
	 * @model
	 * @generated
	 */
	String getCustomSelectSql();

	/**
	 * Sets the value of the '{@link org.eclipse.scada.configuration.world.osgi.PullEvents#getCustomSelectSql <em>Custom Select Sql</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Custom Select Sql</em>' attribute.
	 * @see #getCustomSelectSql()
	 * @generated
	 */
	void setCustomSelectSql(String value);

	/**
	 * Returns the value of the '<em><b>Custom Delete Sql</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Custom Delete Sql</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Custom Delete Sql</em>' attribute.
	 * @see #setCustomDeleteSql(String)
	 * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getPullEvents_CustomDeleteSql()
	 * @model
	 * @generated
	 */
	String getCustomDeleteSql();

	/**
	 * Sets the value of the '{@link org.eclipse.scada.configuration.world.osgi.PullEvents#getCustomDeleteSql <em>Custom Delete Sql</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Custom Delete Sql</em>' attribute.
	 * @see #getCustomDeleteSql()
	 * @generated
	 */
	void setCustomDeleteSql(String value);

} // PullEvents
