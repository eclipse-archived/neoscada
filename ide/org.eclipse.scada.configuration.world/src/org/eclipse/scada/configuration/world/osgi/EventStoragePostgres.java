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
 * A representation of the model object '<em><b>Event Storage Postgres</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.EventStoragePostgres#getBatchSize <em>Batch Size</em>}</li>
 * </ul>
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
} // EventStoragePostgres
