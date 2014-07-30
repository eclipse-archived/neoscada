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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Event Storage Jdbc</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.AbstractEventStorageJdbc#getSchema <em>Schema</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.AbstractEventStorageJdbc#getInstanceName <em>Instance Name</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.AbstractEventStorageJdbc#isEnableReplication <em>Enable Replication</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.AbstractEventStorageJdbc#getArchiveDays <em>Archive Days</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.AbstractEventStorageJdbc#getCleanupPeriodSeconds <em>Cleanup Period Seconds</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.AbstractEventStorageJdbc#getDatabase <em>Database</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.AbstractEventStorageJdbc#getReplicationDataFormat <em>Replication Data Format</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getAbstractEventStorageJdbc()
 * @model abstract="true"
 * @generated
 */
public interface AbstractEventStorageJdbc extends EventStorage
{
    /**
     * Returns the value of the '<em><b>Schema</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * An optional database schema.
     * <!-- end-model-doc -->
     * @return the value of the '<em>Schema</em>' attribute.
     * @see #setSchema(String)
     * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getAbstractEventStorageJdbc_Schema()
     * @model
     * @generated
     */
    String getSchema ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.world.osgi.AbstractEventStorageJdbc#getSchema <em>Schema</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Schema</em>' attribute.
     * @see #getSchema()
     * @generated
     */
    void setSchema ( String value );

    /**
     * Returns the value of the '<em><b>Instance Name</b></em>' attribute.
     * The default value is <code>"default"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Instance Name</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Instance Name</em>' attribute.
     * @see #setInstanceName(String)
     * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getAbstractEventStorageJdbc_InstanceName()
     * @model default="default" required="true"
     * @generated
     */
    String getInstanceName ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.world.osgi.AbstractEventStorageJdbc#getInstanceName <em>Instance Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Instance Name</em>' attribute.
     * @see #getInstanceName()
     * @generated
     */
    void setInstanceName ( String value );

    /**
     * Returns the value of the '<em><b>Enable Replication</b></em>' attribute.
     * The default value is <code>"false"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Enable Replication</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Enable Replication</em>' attribute.
     * @see #setEnableReplication(boolean)
     * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getAbstractEventStorageJdbc_EnableReplication()
     * @model default="false" required="true"
     * @generated
     */
    boolean isEnableReplication ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.world.osgi.AbstractEventStorageJdbc#isEnableReplication <em>Enable Replication</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Enable Replication</em>' attribute.
     * @see #isEnableReplication()
     * @generated
     */
    void setEnableReplication ( boolean value );

    /**
     * Returns the value of the '<em><b>Archive Days</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Archive Days</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Archive Days</em>' attribute.
     * @see #setArchiveDays(Integer)
     * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getAbstractEventStorageJdbc_ArchiveDays()
     * @model
     * @generated
     */
    Integer getArchiveDays ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.world.osgi.AbstractEventStorageJdbc#getArchiveDays <em>Archive Days</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Archive Days</em>' attribute.
     * @see #getArchiveDays()
     * @generated
     */
    void setArchiveDays ( Integer value );

    /**
     * Returns the value of the '<em><b>Cleanup Period Seconds</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Cleanup Period Seconds</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Cleanup Period Seconds</em>' attribute.
     * @see #setCleanupPeriodSeconds(Integer)
     * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getAbstractEventStorageJdbc_CleanupPeriodSeconds()
     * @model
     * @generated
     */
    Integer getCleanupPeriodSeconds ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.world.osgi.AbstractEventStorageJdbc#getCleanupPeriodSeconds <em>Cleanup Period Seconds</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Cleanup Period Seconds</em>' attribute.
     * @see #getCleanupPeriodSeconds()
     * @generated
     */
    void setCleanupPeriodSeconds ( Integer value );

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
     * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getAbstractEventStorageJdbc_Database()
     * @model required="true"
     * @generated
     */
    DatabaseSettings getDatabase ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.world.osgi.AbstractEventStorageJdbc#getDatabase <em>Database</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Database</em>' reference.
     * @see #getDatabase()
     * @generated
     */
    void setDatabase ( DatabaseSettings value );

    /**
     * Returns the value of the '<em><b>Replication Data Format</b></em>' attribute.
     * The default value is <code>"JSON"</code>.
     * The literals are from the enumeration {@link org.eclipse.scada.configuration.world.osgi.ReplicationDataFormat}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Replication Data Format</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Replication Data Format</em>' attribute.
     * @see org.eclipse.scada.configuration.world.osgi.ReplicationDataFormat
     * @see #setReplicationDataFormat(ReplicationDataFormat)
     * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getAbstractEventStorageJdbc_ReplicationDataFormat()
     * @model default="JSON"
     * @generated
     */
    ReplicationDataFormat getReplicationDataFormat ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.world.osgi.AbstractEventStorageJdbc#getReplicationDataFormat <em>Replication Data Format</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Replication Data Format</em>' attribute.
     * @see org.eclipse.scada.configuration.world.osgi.ReplicationDataFormat
     * @see #getReplicationDataFormat()
     * @generated
     */
    void setReplicationDataFormat ( ReplicationDataFormat value );

} // AbstractEventStorageJdbc
