/*******************************************************************************
 * Copyright (c) 2013, 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.configuration.world.osgi;

import org.eclipse.scada.configuration.world.DatabaseSettings;
import org.eclipse.scada.configuration.world.NamedDocumentable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Pull Events</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.PullEvents#getJobInterval <em>Job Interval</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.PullEvents#getCustomSelectSql <em>Custom Select Sql</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.PullEvents#getCustomDeleteSql <em>Custom Delete Sql</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.PullEvents#getDatabase <em>Database</em>}</li>
 * </ul>
 *
 * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getPullEvents()
 * @model
 * @generated
 */
public interface PullEvents extends NamedDocumentable
{
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
    Integer getJobInterval ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.world.osgi.PullEvents#getJobInterval <em>Job Interval</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Job Interval</em>' attribute.
     * @see #getJobInterval()
     * @generated
     */
    void setJobInterval ( Integer value );

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
    String getCustomSelectSql ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.world.osgi.PullEvents#getCustomSelectSql <em>Custom Select Sql</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Custom Select Sql</em>' attribute.
     * @see #getCustomSelectSql()
     * @generated
     */
    void setCustomSelectSql ( String value );

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
    String getCustomDeleteSql ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.world.osgi.PullEvents#getCustomDeleteSql <em>Custom Delete Sql</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Custom Delete Sql</em>' attribute.
     * @see #getCustomDeleteSql()
     * @generated
     */
    void setCustomDeleteSql ( String value );

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
     * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getPullEvents_Database()
     * @model required="true"
     * @generated
     */
    DatabaseSettings getDatabase ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.world.osgi.PullEvents#getDatabase <em>Database</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Database</em>' reference.
     * @see #getDatabase()
     * @generated
     */
    void setDatabase ( DatabaseSettings value );

} // PullEvents
