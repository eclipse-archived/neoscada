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
package org.eclipse.scada.configuration.world.osgi;

import org.eclipse.scada.configuration.world.DatabaseSettings;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Event Injector</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.EventInjector#getDatabase <em>Database</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.EventInjector#getLoopDelay <em>Loop Delay</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.EventInjector#getInstanceName <em>Instance Name</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.EventInjector#getSchema <em>Schema</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.EventInjector#getReplicationSchema <em>Replication Schema</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.EventInjector#isDeleteFailed <em>Delete Failed</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getEventInjector()
 * @model abstract="true"
 * @generated
 */
public interface EventInjector extends IndependentConfiguration
{
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
     * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getEventInjector_Database()
     * @model required="true"
     * @generated
     */
    DatabaseSettings getDatabase ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.world.osgi.EventInjector#getDatabase <em>Database</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Database</em>' reference.
     * @see #getDatabase()
     * @generated
     */
    void setDatabase ( DatabaseSettings value );

    /**
     * Returns the value of the '<em><b>Loop Delay</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Loop Delay</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Loop Delay</em>' attribute.
     * @see #setLoopDelay(Integer)
     * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getEventInjector_LoopDelay()
     * @model
     * @generated
     */
    Integer getLoopDelay ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.world.osgi.EventInjector#getLoopDelay <em>Loop Delay</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Loop Delay</em>' attribute.
     * @see #getLoopDelay()
     * @generated
     */
    void setLoopDelay ( Integer value );

    /**
     * Returns the value of the '<em><b>Instance Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Instance Name</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Instance Name</em>' attribute.
     * @see #setInstanceName(String)
     * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getEventInjector_InstanceName()
     * @model
     * @generated
     */
    String getInstanceName ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.world.osgi.EventInjector#getInstanceName <em>Instance Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Instance Name</em>' attribute.
     * @see #getInstanceName()
     * @generated
     */
    void setInstanceName ( String value );

    /**
     * Returns the value of the '<em><b>Schema</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Schema</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Schema</em>' attribute.
     * @see #setSchema(String)
     * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getEventInjector_Schema()
     * @model
     * @generated
     */
    String getSchema ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.world.osgi.EventInjector#getSchema <em>Schema</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Schema</em>' attribute.
     * @see #getSchema()
     * @generated
     */
    void setSchema ( String value );

    /**
     * Returns the value of the '<em><b>Replication Schema</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Replication Schema</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Replication Schema</em>' attribute.
     * @see #setReplicationSchema(String)
     * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getEventInjector_ReplicationSchema()
     * @model
     * @generated
     */
    String getReplicationSchema ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.world.osgi.EventInjector#getReplicationSchema <em>Replication Schema</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Replication Schema</em>' attribute.
     * @see #getReplicationSchema()
     * @generated
     */
    void setReplicationSchema ( String value );

    /**
     * Returns the value of the '<em><b>Delete Failed</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Delete Failed</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Delete Failed</em>' attribute.
     * @see #setDeleteFailed(boolean)
     * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getEventInjector_DeleteFailed()
     * @model
     * @generated
     */
    boolean isDeleteFailed ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.world.osgi.EventInjector#isDeleteFailed <em>Delete Failed</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Delete Failed</em>' attribute.
     * @see #isDeleteFailed()
     * @generated
     */
    void setDeleteFailed ( boolean value );

} // EventInjector
