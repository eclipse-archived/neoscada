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
package org.eclipse.scada.configuration.world.osgi.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.scada.configuration.world.DatabaseSettings;
import org.eclipse.scada.configuration.world.osgi.AbstractEventStorageJdbc;
import org.eclipse.scada.configuration.world.osgi.OsgiPackage;
import org.eclipse.scada.configuration.world.osgi.ReplicationDataFormat;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '
 * <em><b>Abstract Event Storage Jdbc</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.AbstractEventStorageJdbcImpl#getSchema <em>Schema</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.AbstractEventStorageJdbcImpl#getInstanceName <em>Instance Name</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.AbstractEventStorageJdbcImpl#isEnableReplication <em>Enable Replication</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.AbstractEventStorageJdbcImpl#getArchiveDays <em>Archive Days</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.AbstractEventStorageJdbcImpl#getCleanupPeriodSeconds <em>Cleanup Period Seconds</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.AbstractEventStorageJdbcImpl#getDatabase <em>Database</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.AbstractEventStorageJdbcImpl#getReplicationDataFormat <em>Replication Data Format</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class AbstractEventStorageJdbcImpl extends MinimalEObjectImpl.Container implements AbstractEventStorageJdbc
{
    /**
     * The default value of the '{@link #getSchema() <em>Schema</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSchema()
     * @generated
     * @ordered
     */
    protected static final String SCHEMA_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getSchema() <em>Schema</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSchema()
     * @generated
     * @ordered
     */
    protected String schema = SCHEMA_EDEFAULT;

    /**
     * The default value of the '{@link #getInstanceName() <em>Instance Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getInstanceName()
     * @generated
     * @ordered
     */
    protected static final String INSTANCE_NAME_EDEFAULT = "default"; //$NON-NLS-1$

    /**
     * The cached value of the '{@link #getInstanceName() <em>Instance Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getInstanceName()
     * @generated
     * @ordered
     */
    protected String instanceName = INSTANCE_NAME_EDEFAULT;

    /**
     * The default value of the '{@link #isEnableReplication() <em>Enable Replication</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isEnableReplication()
     * @generated
     * @ordered
     */
    protected static final boolean ENABLE_REPLICATION_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isEnableReplication() <em>Enable Replication</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isEnableReplication()
     * @generated
     * @ordered
     */
    protected boolean enableReplication = ENABLE_REPLICATION_EDEFAULT;

    /**
     * The default value of the '{@link #getArchiveDays() <em>Archive Days</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getArchiveDays()
     * @generated
     * @ordered
     */
    protected static final Integer ARCHIVE_DAYS_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getArchiveDays() <em>Archive Days</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getArchiveDays()
     * @generated
     * @ordered
     */
    protected Integer archiveDays = ARCHIVE_DAYS_EDEFAULT;

    /**
     * The default value of the '{@link #getCleanupPeriodSeconds() <em>Cleanup Period Seconds</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getCleanupPeriodSeconds()
     * @generated
     * @ordered
     */
    protected static final Integer CLEANUP_PERIOD_SECONDS_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getCleanupPeriodSeconds() <em>Cleanup Period Seconds</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getCleanupPeriodSeconds()
     * @generated
     * @ordered
     */
    protected Integer cleanupPeriodSeconds = CLEANUP_PERIOD_SECONDS_EDEFAULT;

    /**
     * The cached value of the '{@link #getDatabase() <em>Database</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDatabase()
     * @generated
     * @ordered
     */
    protected DatabaseSettings database;

    /**
     * The default value of the '{@link #getReplicationDataFormat() <em>Replication Data Format</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getReplicationDataFormat()
     * @generated
     * @ordered
     */
    protected static final ReplicationDataFormat REPLICATION_DATA_FORMAT_EDEFAULT = ReplicationDataFormat.JSON;

    /**
     * The cached value of the '{@link #getReplicationDataFormat() <em>Replication Data Format</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getReplicationDataFormat()
     * @generated
     * @ordered
     */
    protected ReplicationDataFormat replicationDataFormat = REPLICATION_DATA_FORMAT_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected AbstractEventStorageJdbcImpl ()
    {
        super ();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass ()
    {
        return OsgiPackage.Literals.ABSTRACT_EVENT_STORAGE_JDBC;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String getSchema ()
    {
        return schema;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setSchema ( String newSchema )
    {
        String oldSchema = schema;
        schema = newSchema;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, OsgiPackage.ABSTRACT_EVENT_STORAGE_JDBC__SCHEMA, oldSchema, schema ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String getInstanceName ()
    {
        return instanceName;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setInstanceName ( String newInstanceName )
    {
        String oldInstanceName = instanceName;
        instanceName = newInstanceName;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, OsgiPackage.ABSTRACT_EVENT_STORAGE_JDBC__INSTANCE_NAME, oldInstanceName, instanceName ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean isEnableReplication ()
    {
        return enableReplication;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setEnableReplication ( boolean newEnableReplication )
    {
        boolean oldEnableReplication = enableReplication;
        enableReplication = newEnableReplication;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, OsgiPackage.ABSTRACT_EVENT_STORAGE_JDBC__ENABLE_REPLICATION, oldEnableReplication, enableReplication ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Integer getArchiveDays ()
    {
        return archiveDays;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setArchiveDays ( Integer newArchiveDays )
    {
        Integer oldArchiveDays = archiveDays;
        archiveDays = newArchiveDays;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, OsgiPackage.ABSTRACT_EVENT_STORAGE_JDBC__ARCHIVE_DAYS, oldArchiveDays, archiveDays ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Integer getCleanupPeriodSeconds ()
    {
        return cleanupPeriodSeconds;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setCleanupPeriodSeconds ( Integer newCleanupPeriodSeconds )
    {
        Integer oldCleanupPeriodSeconds = cleanupPeriodSeconds;
        cleanupPeriodSeconds = newCleanupPeriodSeconds;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, OsgiPackage.ABSTRACT_EVENT_STORAGE_JDBC__CLEANUP_PERIOD_SECONDS, oldCleanupPeriodSeconds, cleanupPeriodSeconds ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public DatabaseSettings getDatabase ()
    {
        if ( database != null && database.eIsProxy () )
        {
            InternalEObject oldDatabase = (InternalEObject)database;
            database = (DatabaseSettings)eResolveProxy ( oldDatabase );
            if ( database != oldDatabase )
            {
                if ( eNotificationRequired () )
                    eNotify ( new ENotificationImpl ( this, Notification.RESOLVE, OsgiPackage.ABSTRACT_EVENT_STORAGE_JDBC__DATABASE, oldDatabase, database ) );
            }
        }
        return database;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DatabaseSettings basicGetDatabase ()
    {
        return database;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setDatabase ( DatabaseSettings newDatabase )
    {
        DatabaseSettings oldDatabase = database;
        database = newDatabase;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, OsgiPackage.ABSTRACT_EVENT_STORAGE_JDBC__DATABASE, oldDatabase, database ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ReplicationDataFormat getReplicationDataFormat ()
    {
        return replicationDataFormat;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setReplicationDataFormat ( ReplicationDataFormat newReplicationDataFormat )
    {
        ReplicationDataFormat oldReplicationDataFormat = replicationDataFormat;
        replicationDataFormat = newReplicationDataFormat == null ? REPLICATION_DATA_FORMAT_EDEFAULT : newReplicationDataFormat;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, OsgiPackage.ABSTRACT_EVENT_STORAGE_JDBC__REPLICATION_DATA_FORMAT, oldReplicationDataFormat, replicationDataFormat ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet ( int featureID, boolean resolve, boolean coreType )
    {
        switch ( featureID )
        {
            case OsgiPackage.ABSTRACT_EVENT_STORAGE_JDBC__SCHEMA:
                return getSchema ();
            case OsgiPackage.ABSTRACT_EVENT_STORAGE_JDBC__INSTANCE_NAME:
                return getInstanceName ();
            case OsgiPackage.ABSTRACT_EVENT_STORAGE_JDBC__ENABLE_REPLICATION:
                return isEnableReplication ();
            case OsgiPackage.ABSTRACT_EVENT_STORAGE_JDBC__ARCHIVE_DAYS:
                return getArchiveDays ();
            case OsgiPackage.ABSTRACT_EVENT_STORAGE_JDBC__CLEANUP_PERIOD_SECONDS:
                return getCleanupPeriodSeconds ();
            case OsgiPackage.ABSTRACT_EVENT_STORAGE_JDBC__DATABASE:
                if ( resolve )
                    return getDatabase ();
                return basicGetDatabase ();
            case OsgiPackage.ABSTRACT_EVENT_STORAGE_JDBC__REPLICATION_DATA_FORMAT:
                return getReplicationDataFormat ();
        }
        return super.eGet ( featureID, resolve, coreType );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eSet ( int featureID, Object newValue )
    {
        switch ( featureID )
        {
            case OsgiPackage.ABSTRACT_EVENT_STORAGE_JDBC__SCHEMA:
                setSchema ( (String)newValue );
                return;
            case OsgiPackage.ABSTRACT_EVENT_STORAGE_JDBC__INSTANCE_NAME:
                setInstanceName ( (String)newValue );
                return;
            case OsgiPackage.ABSTRACT_EVENT_STORAGE_JDBC__ENABLE_REPLICATION:
                setEnableReplication ( (Boolean)newValue );
                return;
            case OsgiPackage.ABSTRACT_EVENT_STORAGE_JDBC__ARCHIVE_DAYS:
                setArchiveDays ( (Integer)newValue );
                return;
            case OsgiPackage.ABSTRACT_EVENT_STORAGE_JDBC__CLEANUP_PERIOD_SECONDS:
                setCleanupPeriodSeconds ( (Integer)newValue );
                return;
            case OsgiPackage.ABSTRACT_EVENT_STORAGE_JDBC__DATABASE:
                setDatabase ( (DatabaseSettings)newValue );
                return;
            case OsgiPackage.ABSTRACT_EVENT_STORAGE_JDBC__REPLICATION_DATA_FORMAT:
                setReplicationDataFormat ( (ReplicationDataFormat)newValue );
                return;
        }
        super.eSet ( featureID, newValue );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eUnset ( int featureID )
    {
        switch ( featureID )
        {
            case OsgiPackage.ABSTRACT_EVENT_STORAGE_JDBC__SCHEMA:
                setSchema ( SCHEMA_EDEFAULT );
                return;
            case OsgiPackage.ABSTRACT_EVENT_STORAGE_JDBC__INSTANCE_NAME:
                setInstanceName ( INSTANCE_NAME_EDEFAULT );
                return;
            case OsgiPackage.ABSTRACT_EVENT_STORAGE_JDBC__ENABLE_REPLICATION:
                setEnableReplication ( ENABLE_REPLICATION_EDEFAULT );
                return;
            case OsgiPackage.ABSTRACT_EVENT_STORAGE_JDBC__ARCHIVE_DAYS:
                setArchiveDays ( ARCHIVE_DAYS_EDEFAULT );
                return;
            case OsgiPackage.ABSTRACT_EVENT_STORAGE_JDBC__CLEANUP_PERIOD_SECONDS:
                setCleanupPeriodSeconds ( CLEANUP_PERIOD_SECONDS_EDEFAULT );
                return;
            case OsgiPackage.ABSTRACT_EVENT_STORAGE_JDBC__DATABASE:
                setDatabase ( (DatabaseSettings)null );
                return;
            case OsgiPackage.ABSTRACT_EVENT_STORAGE_JDBC__REPLICATION_DATA_FORMAT:
                setReplicationDataFormat ( REPLICATION_DATA_FORMAT_EDEFAULT );
                return;
        }
        super.eUnset ( featureID );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean eIsSet ( int featureID )
    {
        switch ( featureID )
        {
            case OsgiPackage.ABSTRACT_EVENT_STORAGE_JDBC__SCHEMA:
                return SCHEMA_EDEFAULT == null ? schema != null : !SCHEMA_EDEFAULT.equals ( schema );
            case OsgiPackage.ABSTRACT_EVENT_STORAGE_JDBC__INSTANCE_NAME:
                return INSTANCE_NAME_EDEFAULT == null ? instanceName != null : !INSTANCE_NAME_EDEFAULT.equals ( instanceName );
            case OsgiPackage.ABSTRACT_EVENT_STORAGE_JDBC__ENABLE_REPLICATION:
                return enableReplication != ENABLE_REPLICATION_EDEFAULT;
            case OsgiPackage.ABSTRACT_EVENT_STORAGE_JDBC__ARCHIVE_DAYS:
                return ARCHIVE_DAYS_EDEFAULT == null ? archiveDays != null : !ARCHIVE_DAYS_EDEFAULT.equals ( archiveDays );
            case OsgiPackage.ABSTRACT_EVENT_STORAGE_JDBC__CLEANUP_PERIOD_SECONDS:
                return CLEANUP_PERIOD_SECONDS_EDEFAULT == null ? cleanupPeriodSeconds != null : !CLEANUP_PERIOD_SECONDS_EDEFAULT.equals ( cleanupPeriodSeconds );
            case OsgiPackage.ABSTRACT_EVENT_STORAGE_JDBC__DATABASE:
                return database != null;
            case OsgiPackage.ABSTRACT_EVENT_STORAGE_JDBC__REPLICATION_DATA_FORMAT:
                return replicationDataFormat != REPLICATION_DATA_FORMAT_EDEFAULT;
        }
        return super.eIsSet ( featureID );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String toString ()
    {
        if ( eIsProxy () )
            return super.toString ();

        StringBuffer result = new StringBuffer ( super.toString () );
        result.append ( " (schema: " ); //$NON-NLS-1$
        result.append ( schema );
        result.append ( ", instanceName: " ); //$NON-NLS-1$
        result.append ( instanceName );
        result.append ( ", enableReplication: " ); //$NON-NLS-1$
        result.append ( enableReplication );
        result.append ( ", archiveDays: " ); //$NON-NLS-1$
        result.append ( archiveDays );
        result.append ( ", cleanupPeriodSeconds: " ); //$NON-NLS-1$
        result.append ( cleanupPeriodSeconds );
        result.append ( ", replicationDataFormat: " ); //$NON-NLS-1$
        result.append ( replicationDataFormat );
        result.append ( ')' );
        return result.toString ();
    }

} //AbstractEventStorageJdbcImpl
