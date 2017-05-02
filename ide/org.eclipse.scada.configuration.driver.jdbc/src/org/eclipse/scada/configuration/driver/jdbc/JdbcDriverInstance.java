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
package org.eclipse.scada.configuration.driver.jdbc;

import org.eclipse.scada.configuration.world.CommonDriver;

import org.eclipse.scada.da.server.jdbc.configuration.RootType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Driver Instance</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.driver.jdbc.JdbcDriverInstance#getRoot <em>Root</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.configuration.driver.jdbc.JdbcPackage#getJdbcDriverInstance()
 * @model
 * @generated
 */
public interface JdbcDriverInstance extends CommonDriver
{
    /**
     * Returns the value of the '<em><b>Root</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Root</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Root</em>' containment reference.
     * @see #setRoot(RootType)
     * @see org.eclipse.scada.configuration.driver.jdbc.JdbcPackage#getJdbcDriverInstance_Root()
     * @model containment="true" resolveProxies="true"
     * @generated
     */
    RootType getRoot ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.driver.jdbc.JdbcDriverInstance#getRoot <em>Root</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Root</em>' containment reference.
     * @see #getRoot()
     * @generated
     */
    void setRoot ( RootType value );

} // JdbcDriverInstance
