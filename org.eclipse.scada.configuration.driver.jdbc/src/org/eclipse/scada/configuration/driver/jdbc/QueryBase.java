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

import org.eclipse.emf.ecore.EObject;

import org.eclipse.scada.configuration.infrastructure.DatabaseSettings;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Query Base</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.driver.jdbc.QueryBase#getSql <em>Sql</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.driver.jdbc.QueryBase#getDatabase <em>Database</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.driver.jdbc.QueryBase#getQueryTimeout <em>Query Timeout</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.driver.jdbc.QueryBase#getRunsOn <em>Runs On</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.configuration.driver.jdbc.JdbcPackage#getQueryBase()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface QueryBase extends EObject
{
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
     * @see org.eclipse.scada.configuration.driver.jdbc.JdbcPackage#getQueryBase_Sql()
     * @model required="true"
     * @generated
     */
    String getSql ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.driver.jdbc.QueryBase#getSql <em>Sql</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Sql</em>' attribute.
     * @see #getSql()
     * @generated
     */
    void setSql ( String value );

    /**
     * Returns the value of the '<em><b>Database</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Database</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Database</em>' reference.
     * @see #setDatabase(DatabaseSettings)
     * @see org.eclipse.scada.configuration.driver.jdbc.JdbcPackage#getQueryBase_Database()
     * @model required="true"
     * @generated
     */
    DatabaseSettings getDatabase ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.driver.jdbc.QueryBase#getDatabase <em>Database</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Database</em>' reference.
     * @see #getDatabase()
     * @generated
     */
    void setDatabase ( DatabaseSettings value );

    /**
     * Returns the value of the '<em><b>Query Timeout</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Query Timeout</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * The query timeout in seconds.
     * <!-- end-model-doc -->
     * @return the value of the '<em>Query Timeout</em>' attribute.
     * @see #setQueryTimeout(Integer)
     * @see org.eclipse.scada.configuration.driver.jdbc.JdbcPackage#getQueryBase_QueryTimeout()
     * @model
     * @generated
     */
    Integer getQueryTimeout ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.driver.jdbc.QueryBase#getQueryTimeout <em>Query Timeout</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Query Timeout</em>' attribute.
     * @see #getQueryTimeout()
     * @generated
     */
    void setQueryTimeout ( Integer value );

    /**
     * Returns the value of the '<em><b>Runs On</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Runs On</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Runs On</em>' reference.
     * @see #setRunsOn(JdbcDriver)
     * @see org.eclipse.scada.configuration.driver.jdbc.JdbcPackage#getQueryBase_RunsOn()
     * @model required="true"
     * @generated
     */
    JdbcDriver getRunsOn ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.driver.jdbc.QueryBase#getRunsOn <em>Runs On</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Runs On</em>' reference.
     * @see #getRunsOn()
     * @generated
     */
    void setRunsOn ( JdbcDriver value );

} // QueryBase
