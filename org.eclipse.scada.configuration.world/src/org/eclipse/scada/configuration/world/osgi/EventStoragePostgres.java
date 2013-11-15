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
 * A representation of the model object '<em><b>Event Storage Postgres</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.EventStoragePostgres#getBatchSize <em>Batch Size</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.EventStoragePostgres#getPostgresDriverBundles <em>Postgres Driver Bundles</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getEventStoragePostgres()
 * @model
 * @generated
 */
public interface EventStoragePostgres extends AbstractEventStorageJdbc
{

    /**
     * Returns the value of the '<em><b>Batch Size</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Batch Size</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Batch Size</em>' attribute.
     * @see #setBatchSize(Integer)
     * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getEventStoragePostgres_BatchSize()
     * @model
     * @generated
     */
    Integer getBatchSize ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.world.osgi.EventStoragePostgres#getBatchSize <em>Batch Size</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Batch Size</em>' attribute.
     * @see #getBatchSize()
     * @generated
     */
    void setBatchSize ( Integer value );

    /**
     * Returns the value of the '<em><b>Postgres Driver Bundles</b></em>' attribute list.
     * The list contents are of type {@link java.lang.String}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Postgres Driver Bundles</em>' attribute list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Postgres Driver Bundles</em>' attribute list.
     * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getEventStoragePostgres_PostgresDriverBundles()
     * @model
     * @generated
     */
    EList<String> getPostgresDriverBundles ();

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model kind="operation" required="true"
     *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return \"org.postgresql.Driver\";'"
     * @generated
     */
    String getJdbcDriverName ();

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model kind="operation"
     *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return getPostgresDriverBundles();'"
     * @generated
     */
    EList<String> getDriverBundles ();
} // EventStoragePostgres
