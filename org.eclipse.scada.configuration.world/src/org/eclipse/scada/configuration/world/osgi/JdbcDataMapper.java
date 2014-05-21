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
import org.eclipse.scada.configuration.world.PropertyEntry;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Jdbc Data Mapper</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.JdbcDataMapper#getJdbcDriver <em>Jdbc Driver</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.JdbcDataMapper#getSql <em>Sql</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.JdbcDataMapper#getProperties <em>Properties</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getJdbcDataMapper()
 * @model
 * @generated
 */
public interface JdbcDataMapper extends DataMapper
{
    /**
     * Returns the value of the '<em><b>Jdbc Driver</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Jdbc Driver</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Jdbc Driver</em>' attribute.
     * @see #setJdbcDriver(String)
     * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getJdbcDataMapper_JdbcDriver()
     * @model unique="false" required="true"
     * @generated
     */
    String getJdbcDriver ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.world.osgi.JdbcDataMapper#getJdbcDriver <em>Jdbc Driver</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Jdbc Driver</em>' attribute.
     * @see #getJdbcDriver()
     * @generated
     */
    void setJdbcDriver ( String value );

    /**
     * Returns the value of the '<em><b>Sql</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Sql</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Sql</em>' attribute.
     * @see #setSql(String)
     * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getJdbcDataMapper_Sql()
     * @model unique="false" required="true"
     * @generated
     */
    String getSql ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.world.osgi.JdbcDataMapper#getSql <em>Sql</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Sql</em>' attribute.
     * @see #getSql()
     * @generated
     */
    void setSql ( String value );

    /**
     * Returns the value of the '<em><b>Properties</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.scada.configuration.world.PropertyEntry}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Properties</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Properties</em>' containment reference list.
     * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getJdbcDataMapper_Properties()
     * @model containment="true" resolveProxies="true"
     * @generated
     */
    EList<PropertyEntry> getProperties ();

} // JdbcDataMapper
